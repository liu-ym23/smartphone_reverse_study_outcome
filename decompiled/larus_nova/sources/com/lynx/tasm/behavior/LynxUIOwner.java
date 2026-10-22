package com.lynx.tasm.behavior;

import android.animation.AnimatorSet;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.mapbuffer.MapBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableCompactArrayBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxEnvKey;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.NativeFacade;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityHelper;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.list.container.UIListContainer;
import com.lynx.tasm.behavior.ui.swiper.XSwiperUI;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.behavior.utils.LynxUIMethodsExecutor;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes32.dex */
public class LynxUIOwner {
    private static final int LEGACY_STICKY_INFO_COUNT = 4;
    private static final String LYNXSDK_ASYNC_CREATE_CONFIG = "lynxsdk_async_create_config";
    private static final String LYNXSDK_ASYNC_CREATE_SUCCESS_EVENT = "lynxsdk_async_create_success_event";
    private static final String LYNXSDK_COMPONENT_STATISTIC_EVENT = "lynxsdk_component_statistic";
    private static final String TAG = "LynxUIOwner";
    private static final Comparator<LynxBaseUI> translationZComparator = null;
    private UIBody.UIBodyView.a mAttachLynxPageUICallback;
    private final com.lynx.tasm.behavior.c mBehaviorRegistry;
    private final HashSet<LynxBaseUI> mCachedBoundingClientRectUI;
    private final HashMap<String, Integer> mComponentIdToUiIdHolder;
    private final Set<String> mComponentSet;
    private LynxContext mContext;
    private final ConcurrentLinkedQueue<FutureTask<Runnable>> mCreateNodeAsyncTasks;
    private HashMap<String, Boolean> mCreateNodeConfigHasReportedMark;
    private boolean mEnableReportCreateAsync;
    private final List<j> mForegroundListeners;
    private q7a.b mGestureArenaManager;
    private boolean mHasTouchPseudo;
    private boolean mIsContextFree;
    private boolean mIsFirstLayout;
    private boolean mIsRootLayoutAnimationRunning;
    private WeakReference<NativeFacade> mNativeFacade;
    private l mPaintingContext;
    private int mRootSign;
    private Boolean mSettingsEnableNewImage;
    private final HashMap<Integer, LynxBaseUI> mTextChildUIHolder;
    private com.lynx.tasm.behavior.shadow.text.d mTextMeasurer;
    private final HashSet<LynxBaseUI> mTranslateZParentHolder;
    private UIBody mUIBody;
    private final HashMap<Integer, LynxBaseUI> mUIHolder;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FutureTask f381887a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f381887a.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(FutureTask r100) {
            this.f381887a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f381888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LynxBaseUI[] f381889b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UIShadowProxy f381890c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ x0 f381891d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f381892e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ LynxUIOwner f381893f;

        public final void a() {
            if (TraceEvent.isTracingStarted() == false) goto L5;
            String r100 = "UIOwner.AfterCreateAsyncViewRunnable." + this.f381888a;
            TraceEvent.beginSection(r100);
        L6:
            LynxBaseUI[] r101 = this.f381889b;
            r101[0] = LynxUIOwner.access$000(this.f381893f, r101[0], this.f381890c, this.f381891d);
            this.f381893f.reportStatistic(this.f381888a);
            LynxUIOwner.access$100(this.f381893f, this.f381892e, this.f381888a, this.f381891d);
            LynxUIOwner.access$200(this.f381893f).put(Integer.valueOf(this.f381892e), this.f381889b[0]);
            if (TraceEvent.isTracingStarted() == false) goto L10;
            TraceEvent.endSection(r100);
            return;
        L10:
            return;
        L5:
            r100 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(LynxUIOwner r100, String r101, LynxBaseUI[] r102, UIShadowProxy r103, x0 r104, int r105) {
            this.f381893f = r100;
            this.f381888a = r101;
            this.f381889b = r102;
            this.f381890c = r103;
            this.f381891d = r104;
            this.f381892e = r105;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Exception f381894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LynxUIOwner f381895b;

        @Override // java.lang.Runnable
        public final void run() {
            LynxUIOwner.access$300(this.f381895b).handleException(this.f381894a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(LynxUIOwner r100, Exception r101) {
            this.f381895b = r100;
            this.f381894a = r101;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f381896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f381897b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ReadableMap f381898c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ReadableMapBuffer f381899d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ReadableArray f381900e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f381901f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f381902g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ ReadableArray f381903h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ LynxUIOwner f381904i;

        @Override // java.lang.Runnable
        public final void run() {
            this.f381904i.createView(this.f381896a, this.f381897b, this.f381898c, this.f381899d, this.f381900e, this.f381901f, this.f381902g, this.f381903h);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(LynxUIOwner r100, int r101, String r102, ReadableMap r103, ReadableMapBuffer r104, ReadableArray r105, boolean r106, int r107, ReadableArray r108) {
            this.f381904i = r100;
            this.f381896a = r101;
            this.f381897b = r102;
            this.f381898c = r103;
            this.f381899d = r104;
            this.f381900e = r105;
            this.f381901f = r106;
            this.f381902g = r107;
            this.f381903h = r108;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f381905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LynxBaseUI[] f381906b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UIShadowProxy f381907c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ x0 f381908d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f381909e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ LynxUIOwner f381910f;

        public final void a() {
            if (TraceEvent.isTracingStarted() == false) goto L5;
            String r100 = "UIOwner.AfterCreateViewAsync." + this.f381905a;
            LynxUIOwner.access$400(this.f381910f, r100);
        L6:
            LynxBaseUI[] r101 = this.f381906b;
            r101[0] = LynxUIOwner.access$000(this.f381910f, r101[0], this.f381907c, this.f381908d);
            this.f381910f.reportStatistic(this.f381905a);
            LynxUIOwner.access$100(this.f381910f, this.f381909e, this.f381905a, this.f381908d);
            LynxUIOwner.access$200(this.f381910f).put(Integer.valueOf(this.f381909e), this.f381906b[0]);
            if (TraceEvent.isTracingStarted() == false) goto L10;
            TraceEvent.endSection(r100);
            return;
        L10:
            return;
        L5:
            r100 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(LynxUIOwner r100, String r101, LynxBaseUI[] r102, UIShadowProxy r103, x0 r104, int r105) {
            this.f381910f = r100;
            this.f381905a = r101;
            this.f381906b = r102;
            this.f381907c = r103;
            this.f381908d = r104;
            this.f381909e = r105;
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Exception f381911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LynxUIOwner f381912b;

        @Override // java.lang.Runnable
        public final void run() {
            LynxUIOwner.access$300(this.f381912b).handleException(this.f381911a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public f(LynxUIOwner r100, Exception r101) {
            this.f381912b = r100;
            this.f381911a = r101;
        }
    }

    public static class g implements Comparator<LynxBaseUI> {
        public g() {
        }

        @Override // java.util.Comparator
        public final int compare(LynxBaseUI r100, LynxBaseUI r101) {
            LynxBaseUI r102 = r100;
            LynxBaseUI r103 = r101;
            if (r102.getTranslationZ() <= r103.getTranslationZ()) goto L6;
            return 1;
        L6:
            if (r102.getTranslationZ() != r103.getTranslationZ()) goto L8;
            return 0;
        L8:
            return -1;
        }
    }

    public static final class h extends com.lynx.tasm.behavior.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.lynx.tasm.behavior.a f381913a;

        @Override // com.lynx.tasm.behavior.a
        public final com.lynx.tasm.a createClassWarmer() {
            return this.f381913a.createClassWarmer();
        }

        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            return this.f381913a.createShadowNode();
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxFlattenUI createFlattenUI(LynxContext r100) {
            return this.f381913a.createFlattenUI(r100);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxFlattenUI createFlattenUIFiber(LynxContext r100) {
            return this.f381913a.createFlattenUIFiber(r100);
        }

        @Override // com.lynx.tasm.behavior.a
        public final x6a.e createPlatformRendererHost(LynxContext r100) {
            return this.f381913a.createPlatformRendererHost(r100);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUI(LynxContext r100) {
            return this.f381913a.createUI(r100);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIFiber(LynxContext r100) {
            return this.f381913a.createUIFiber(r100);
        }

        public h(String r100, com.lynx.tasm.behavior.a r101) {
            super(r100, r101.supportUIFlatten(), r101.supportCreateAsync(), r101.needProcessDirection(), r101.supportFragmentLayerRenderer());
            this.f381913a = r101;
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxFlattenUI createFlattenUIWithParams(LynxContext r100, Object r101) {
            return this.f381913a.createFlattenUIWithParams(r100, r101);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIWithParams(LynxContext r100, Object r101) {
            return this.f381913a.createUIWithParams(r100, r101);
        }
    }

    public static /* synthetic */ Map a(String r100) {
        return lambda$componentStatistic$1(r100);
    }

    public static /* synthetic */ Runnable b(LynxUIOwner r100, String r101, int r102, int r103, boolean r104, x0 r105, Map r106, Map r107) {
        return r100.lambda$createViewAsync$0(r101, r102, r103, r104, r105, r106, r107);
    }

    public static /* synthetic */ Map c(String r100, String r101, boolean r102) {
        return lambda$reportCreateViewConfig$3(r100, r101, r102);
    }

    public static /* synthetic */ Map d(String r100, String r101, boolean r102, int r103) {
        return lambda$reportCreateAsyncSuccessEvent$2(r100, r101, r102, r103);
    }

    private int getSignFromOperationId(long r100) {
        return (int) (r100 >>> 32);
    }

    public void pauseRootLayoutAnimation() {
        this.mIsRootLayoutAnimationRunning = false;
    }

    public void reset() {
        this.mIsFirstLayout = true;
        this.mRootSign = -1;
        HashMap<Integer, LynxBaseUI> r100 = this.mUIHolder;
        if (r100 == null) goto L9;
        Iterator<LynxBaseUI> r101 = r100.values().iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        r101.next().destroy();
        goto L6
    L8:
        this.mUIHolder.clear();
        this.mTranslateZParentHolder.clear();
    L9:
        UIBody r102 = this.mUIBody;
        if (r102 == null) goto L12;
        r102.removeAll();
    L12:
        HashMap<String, Integer> r103 = this.mComponentIdToUiIdHolder;
        if (r103 == null) goto L15;
        r103.clear();
    L15:
        WeakReference<NativeFacade> r104 = this.mNativeFacade;
        if (r104 == null) goto L18;
        NativeFacade r105 = r104.get();
    L19:
        if (r105 == null) goto L25;
        NativeFacade.c r106 = r105.f381742a;
        if (r106 == null) goto L26;
        r106.q();
        return;
    L26:
        return;
    L25:
        return;
    L18:
        r105 = null;
        goto L19
    }

    public void resumeRootLayoutAnimation() {
        this.mIsRootLayoutAnimationRunning = true;
    }

    public void setFirstLayout() {
        this.mIsFirstLayout = false;
    }

    static {
        translationZComparator = new g();
    }

    private void didPerformLayout() {
        if (this.mCachedBoundingClientRectUI.isEmpty() == false) goto L5;
        return;
    L5:
        HashSet r100 = new HashSet(this.mCachedBoundingClientRectUI);
        this.mCachedBoundingClientRectUI.clear();
        Iterator r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((LynxBaseUI) r101.next()).uiOwnerDidPerformLayout();
        goto L7
    L9:
        didPerformLayout();
    }

    private void handleTranslateZUI() {
        if (this.mContext.getEnableFlattenTranslateZ() == true) goto L5;
        return;
    L5:
        Iterator<LynxBaseUI> r100 = this.mTranslateZParentHolder.iterator();
    L7:
        if (r100.hasNext() == false) goto L13;
        LynxBaseUI r101 = r100.next();
        if (r101.flattenChildrenCount() <= 0) goto L7;
        if (r101.getNeedSortChildren() == false) goto L7;
        sortTranslateZChildren(r101);
        r101.setNeedSortChildren(false);
        goto L7
    }

    public void destroy() {
        TraceEvent.beginSection("UIOwner.destroy");
        Iterator<Map.Entry<Integer, LynxBaseUI>> r100 = this.mUIHolder.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Map.Entry<Integer, LynxBaseUI> r101 = r100.next();
        if ((r101.getValue() instanceof LynxBaseUI) == false) goto L4;
        LynxBaseUI r102 = r101.getValue();
        if (r102 == null) goto L4;
        r102.destroy();
        goto L4
    L11:
        LynxContext r103 = this.mContext;
        if (r103 == null) goto L14;
        r103.destory();
    L14:
        q7a.b r104 = this.mGestureArenaManager;
        if (r104 == null) goto L40;
        Map<Integer, WeakReference<p7a.a>> r105 = r104.f531989a;
        if (r105 == null) goto L19;
        ((HashMap) r105).clear();
    L19:
        LinkedList<p7a.a> r106 = r104.f531990b;
        if (r106 == null) goto L22;
        r106.clear();
    L22:
        LinkedList<p7a.a> r107 = r104.f531991c;
        if (r107 == null) goto L25;
        r107.clear();
    L25:
        s7a.b r108 = r104.f531993e;
        if (r108 == null) goto L28;
        ((HashMap) r108.f540937a).clear();
    L28:
        t7a.d r109 = r104.f531996h;
        if (r109 == null) goto L40;
        VelocityTracker r110 = r109.f544925f;
        if (r110 != null) goto L42;
    L37:
        r109.f544921b = null;
        HashSet<p7a.a> r111 = r109.f544926g;
        if (r111 == null) goto L40;
        r111.clear();
        goto L40
    L42:
        r110.recycle();     // Catch: IllegalStateException -> L34
    L36:
        r109.f544925f = null;
    L34:
        e = move-exception;
        LLog.e("GestureHandlerTrigger", e.toString());
    L40:
        this.mCreateNodeAsyncTasks.clear();
        TraceEvent.endSection("UIOwner.destroy");
    }

    public Set<String> getComponentSet() {
        return new HashSet();
    }

    public boolean getEnableCreateViewAsync() {
        return this.mContext.getEnableCreateViewAsync();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r12v0 ??, still in use, count: 1, list:
          (r12v0 ?? I:java.lang.Object) from 0x0047: INVOKE (r0v1 ?? I:java.util.HashMap), (r9v0 ?? I:java.lang.Object), (r12v0 ?? I:java.lang.Object) VIRTUAL call: java.util.HashMap.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)] (LINE:71)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    public java.util.HashMap<java.lang.String, a8a.a> getMemoryUsage() {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v0 ??
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:341)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            r13 = this;
            java.util.HashMap<java.lang.Integer, com.lynx.tasm.behavior.ui.LynxBaseUI> r0 = r13.mUIHolder
            if (r0 != 0) goto L6
            r0 = 0
            return r0
        L6:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.HashMap<java.lang.Integer, com.lynx.tasm.behavior.ui.LynxBaseUI> r1 = r13.mUIHolder
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L15:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L74
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r2 = r2.getValue()
            com.lynx.tasm.behavior.ui.LynxBaseUI r2 = (com.lynx.tasm.behavior.ui.LynxBaseUI) r2
            if (r2 == 0) goto L6c
            java.lang.String r9 = r2.getTagName()
            if (r9 != 0) goto L30
            goto L15
        L30:
            long r10 = r2.getMemoryUsageBytes()
            java.lang.Object r3 = r0.get(r9)
            a8a.a r3 = (a8a.a) r3
            if (r3 != 0) goto L4a
            a8a.a r12 = new a8a.a
            r5 = 0
            r7 = 0
            r8 = 0
            r3 = r12
            r4 = r9
            r3.<init>(r4, r5, r7, r8)
            r0.put(r9, r12)
        L4a:
            int r4 = r3.f2206c
            int r4 = r4 + 1
            r3.f2206c = r4
            long r4 = r3.f2205b
            long r4 = r4 + r10
            r3.f2205b = r4
            java.util.Map r2 = r2.getMemoryUsageDetail()
            if (r2 == 0) goto L15
            java.util.Map<java.lang.String, java.lang.String> r4 = r3.f2207d
            if (r4 != 0) goto L66
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            r3.f2207d = r4
        L66:
            java.util.Map<java.lang.String, java.lang.String> r3 = r3.f2207d
            r3.putAll(r2)
            goto L15
        L6c:
            java.lang.String r2 = "LynxUIOwner"
            java.lang.String r3 = "getMemoryUsage failed, the ui is null or not LynxBaseUI"
            com.lynx.tasm.base.LLog.e(r2, r3)
            goto L15
        L74:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lynx.tasm.behavior.LynxUIOwner.getMemoryUsage():java.util.HashMap");
    }

    public int getRootHeight() {
        return this.mUIBody.getHeight();
    }

    public int getRootWidth() {
        return this.mUIBody.getWidth();
    }

    public void onEnterBackground() {
        List<j> r100 = this.mForegroundListeners;
        if (r100 != null) goto L5;
        return;
    L5:
        Iterator<j> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        r101.next().B();
        goto L7
    }

    public void onEnterForeground() {
        List<j> r100 = this.mForegroundListeners;
        if (r100 != null) goto L5;
        return;
    L5:
        Iterator<j> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        r101.next().p();
        goto L7
    }

    public void performLayout() {
        this.mUIBody.layoutChildren();
        if (this.mUIBody.getLynxContext().getEventEmitter() == null) goto L5;
        this.mUIBody.getLynxContext().getEventEmitter().sendLayoutEvent();
    L5:
        didPerformLayout();
    }

    public void performMeasure() {
        this.mUIBody.measureChildren();
    }

    public void setEnableSyncXElementRegistry() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("x-viewpager-ng", "viewpager");
        r100.put("x-viewpager-item-ng", LynxViewpagerItem.X_ELEMENT_TAG);
        r100.put("x-webview", "webview");
        r100.put("x-overlay-ng", "overlay");
        r100.put("x-refresh-view", "refresh");
        r100.put("x-refresh-header", "refresh-header");
        r100.put("x-blur-view", "blur-view");
        r100.put("x-foldview-ng", "scroll-coordinator");
        r100.put("x-foldview-header-ng", "scroll-coordinator-header");
        r100.put("x-foldview-slot-ng", "scroll-coordinator-slot");
        r100.put("x-foldview-slot-drag-ng", "scroll-coordinator-slot-drag");
        r100.put("x-foldview-toolbar-ng", "scroll-coordinator-toolbar");
        r100.put("x-input-ng", "input");
        r100.put("x-textarea-ng", "textarea");
        Iterator r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Map.Entry r102 = (Map.Entry) r101.next();
        com.lynx.tasm.behavior.a r103 = this.mBehaviorRegistry.c((String) r102.getKey());     // Catch: RuntimeException -> L8
        this.mBehaviorRegistry.a(new h((String) r102.getValue(), r103));     // Catch: RuntimeException -> L8
        goto L4
    }

    public z7a.k getMeaningfulPaintingAreas() {
        UIBody r100 = getRootUI();
        if (r100 != null) goto L5;
        return null;
    L5:
        List<com.lynx.tasm.behavior.ui.e> r101 = r100.getMeaningfulPaintingAreas();
        if (r101 != null) goto L8;
        return null;
    L8:
        if (r101.size() > 0) goto L11;
        return null;
    L11:
        return new z7a.k(r100.getWidth(), r100.getHeight(), r101);
    }

    public void rebuildViewTree() {
        if (TraceEvent.isTracingStarted() == false) goto L5;
        String r100 = "UIOwner.rebuildViewTree";
        TraceEvent.beginSection("UIOwner.rebuildViewTree");
    L6:
        this.mUIBody.rebuildViewTree();
        if (TraceEvent.isTracingStarted() == false) goto L10;
        TraceEvent.endSection(r100);
        return;
    L10:
        return;
    L5:
        r100 = null;
        goto L6
    }

    public LynxContext getContext() {
        return this.mContext;
    }

    public q7a.b getGestureArenaManager() {
        return this.mGestureArenaManager;
    }

    public boolean getHasTouchPseudo() {
        return this.mHasTouchPseudo;
    }

    public l getPaintingContext() {
        return this.mPaintingContext;
    }

    public int getRootSign() {
        return this.mRootSign;
    }

    public UIBody getRootUI() {
        return this.mUIBody;
    }

    public boolean isContextFree() {
        return this.mIsContextFree;
    }

    public static /* synthetic */ HashMap access$200(LynxUIOwner r100) {
        return r100.mUIHolder;
    }

    public static /* synthetic */ LynxContext access$300(LynxUIOwner r100) {
        return r100.mContext;
    }

    private void addShadowProxy(LynxBaseUI r100) {
        LynxBaseUI r101 = r100.getParentBaseUI();
        if (r101 == null) goto L5;
        int r102 = r101.getIndex(r100);
        remove(r101.getSign(), r100.getSign());
    L6:
        this.mContext.removeUIFromExposedMap(r100);
        UIShadowProxy r103 = new UIShadowProxy(this.mContext, r100);
        this.mUIHolder.put(Integer.valueOf(r100.getSign()), r103);
        if (r101 == null) goto L10;
        insert(r101.getSign(), r103.getSign(), r102);
        return;
    L10:
        return;
    L5:
        r102 = 0;
        goto L6
    }

    private void checkTranslateZ(LynxBaseUI r100) {
        if (r100.getParentBaseUI() == null) goto L6;
        checkTranslateZ(r100.getSign(), r100.getParentBaseUI().getSign());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LynxBaseUI createViewInterval(com.lynx.tasm.behavior.ui.j r100) {
        if (this.mRootSign < 0) goto L5;
    L32:
        LynxBaseUI r101 = createUI(r100.f382565d, r100.f382564c, r100);
    L33:
        if (r101 != null) goto L35;
        return r101;
    L35:
        r101.setEvents(r100.f382566e);
        r101.setSign(r100.f382562a, r100.f382565d);
        r101.setNodeIndex(r100.f382563b);
        r101.setGestureDetectors(r100.f382567f);
        return r101;
    L5:
        if (r100.f382565d.equals("page") == false) goto L32;
        r101 = this.mUIBody;
        this.mRootSign = r100.f382562a;
        if (r101 == null) goto L33;
        UIBody.UIBodyView.a r102 = this.mAttachLynxPageUICallback;
        if (r102 == null) goto L33;
        WeakReference r103 = new WeakReference(r101);
        c7a.c r104 = (c7a.c) r102;
        r104.getClass();
        if ((r103.get() instanceof UIBody) == false) goto L33;
        UIBody r105 = (UIBody) r103.get();
        if (r105.getLynxContext() == null) goto L33;
        r105.getLynxContext().EnsureEventDispatcher();
        LynxBaseUI r106 = r104.f22669a.get();
        if (r106 == null) goto L33;
        if (r106.getChildrenLynxPageUI() != null) goto L22;
        r106.setChildrenLynxPageUI(new HashMap());
    L22:
        r106.getChildrenLynxPageUI().put(String.valueOf(System.identityHashCode(r106)), r105);
        if (r106.getLynxContext() == null) goto L30;
        if (r106.getLynxContext().getLynxUIOwner() == null) goto L30;
        if (r106.getLynxContext().getLynxUIOwner().getRootUI() == null) goto L30;
        r105.setParentLynxPageUI(r106.getLynxContext().getLynxUIOwner().getRootUI());
    L30:
        if (r105.getView() == 0) goto L33;
        ((UIBody.UIBodyView) r105.getView()).setIsChildLynxPageUI(true);
        goto L33
    }

    private void destroyChildrenRecursively(LynxBaseUI r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.getChildren().size()) goto L6;
        LynxBaseUI r102 = r100.getChildAt(r101);
        r102.destroy();
        this.mUIHolder.remove(Integer.valueOf(r102.getSign()));
        this.mTranslateZParentHolder.remove(r102);
        this.mContext.removeUIFromExposedMap(r102);
        destroyChildrenRecursively(r102);
        r101 = r101 + 1;
        goto L4
    }

    private boolean hasShadowOrOutline(x0 r100) {
        if (r100.i(GXTemplateKey.STYLE_BOX_SHADOW) == false) goto L5;
    L12:
        return true;
    L5:
        if (r100.i("outline-color") == true) goto L12;
        if (r100.i("outline-style") == true) goto L12;
        if (r100.i("outline-width") == true) goto L12;
        return false;
    }

    private void insertChildIntoDrawListRecursive(LynxBaseUI r100) {
        Iterator<LynxBaseUI> r101 = r100.getChildren().iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L9;
        LynxBaseUI r103 = r101.next();
        int r104 = r102 + 1;
        insertIntoDrawList(r100, r103, r102);
        if (r103.isFlatten() == false) goto L8;
        insertChildIntoDrawListRecursive(r103);
    L8:
        r102 = r104;
        goto L4
    }

    private static /* synthetic */ Map lambda$componentStatistic$1(String r100) {
        HashMap r101 = new HashMap();
        r101.put("component_name", r100);
        return r101;
    }

    private float[] normalizeStickyInfo(float[] r100) {
        if (r100 != null) goto L4;
    L13:
        return r100;
    L4:
        if (r100.length <= 4) goto L13;
        LynxContext r101 = this.mContext;
        if (r101 != null) goto L9;
    L11:
        float[] r102 = new float[4];
        System.arraycopy(r100, 0, r102, 0, 4);
        return r102;
    L9:
        if (r101.getEnableNewSticky() == false) goto L11;
        return r100;
    }

    private void onNodeRemovedRecursively(LynxBaseUI r100) {
        boolean r101 = r100 instanceof UIShadowProxy;
        if (r101 == false) goto L5;
        LynxBaseUI r102 = ((UIShadowProxy) r100).f382373a;
    L6:
        r102.onNodeRemoved();
        if (r101 == true) goto L12;
        Iterator<LynxBaseUI> r103 = r100.getChildren().iterator();
    L10:
        if (r103.hasNext() == false) goto L14;
        onNodeRemovedRecursively(r103.next());
        goto L10
    L14:
        return;
    L12:
        return;
    L5:
        r102 = r100;
        goto L6
    }

    private void removeFromDrawList(LynxBaseUI r100) {
        UIGroup r101 = (UIGroup) r100.getDrawParent();
        LynxBaseUI r102 = r100.getParentBaseUI();
        if (r101 == null) goto L43;
        if (r102 != null) goto L7;
        return;
    L7:
        if (r100.isFlatten() == true) goto L20;
        LynxBaseUI r103 = r100.getPreviousDrawUI();
        LynxBaseUI r104 = r100.getNextDrawUI();
        if (r103 == null) goto L13;
        r103.setNextDrawUI(r104);
        if (r104 == null) goto L17;
        r104.setPreviousDrawUI(r103);
    L17:
        if (r102.isFlatten() == false) goto L19;
        r101.removeView(r100);
    L19:
        r100.setNextDrawUI(null);
        r100.setPreviousDrawUI(null);
        r100.setDrawParent(null);
        return;
    L13:
        r101.setDrawHead(r104);
        if (r104 == null) goto L17;
        r104.setPreviousDrawUI(null);
        goto L17
    L20:
        LynxBaseUI r105 = r100;
    L22:
        if (r105.isFlatten() == false) goto L26;
        if (r105.getChildren().isEmpty() == true) goto L26;
        r105 = r105.getChildAt(r105.getChildren().size() - 1);
    L26:
        LynxBaseUI r106 = r100.getPreviousDrawUI();
        if (r106 == null) goto L31;
        r106.setNextDrawUI(r105.getNextDrawUI());
        if (r105.getNextDrawUI() == null) goto L34;
        r105.getNextDrawUI().setPreviousDrawUI(r106);
    L34:
        r100.setPreviousDrawUI(null);
        LynxBaseUI r107 = r100.getNextDrawUI();
    L36:
        if (r107 == r105.getNextDrawUI()) goto L38;
        r107.getPreviousDrawUI().setNextDrawUI(null);
        r107.setPreviousDrawUI(null);
        r101.removeView(r107);
        r107.setDrawParent(null);
        r107 = r107.getNextDrawUI();
        goto L36
    L38:
        r105.setNextDrawUI(null);
        r100.setDrawParent(null);
        r102.invalidate();
        return;
    L31:
        r101.setDrawHead(r105.getNextDrawUI());
        if (r105.getNextDrawUI() == null) goto L34;
        r105.getNextDrawUI().setPreviousDrawUI(null);
        goto L34
    }

    private void resetUIDrawingLayoutInfo(LynxBaseUI r100) {
        r100.setBound(null);
        r100.setLeft(r100.getOriginLeft());
        r100.setTop(r100.getOriginTop());
    }

    private void sortTranslateZChildren(LynxBaseUI r100) {
        Iterator<LynxBaseUI> r101 = r100.getChildren().iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        removeFromDrawList(r101.next());
        goto L4
    L12:
        Collections.sort(r100.getChildren(), translationZComparator);     // Catch: Exception -> L8
    L10:
        insertChildIntoDrawListRecursive(r100);
        return;
    L8:
        e = move-exception;
        LLog.i(TAG, "Something went wrong during sort children by translation Z " + e.getStackTrace());
        goto L10
    }

    private void traceBeginWithInstanceId(String r100) {
        if (this.mContext == null) goto L5;
        HashMap r101 = new HashMap();
        r101.put("instance_id", String.valueOf(this.mContext.getInstanceId()));
        TraceEvent.beginSection(r100, r101);
        return;
    L5:
        TraceEvent.beginSection(r100);
    }

    public float[] align(int r100) {
        return this.mTextMeasurer.a(r100);
    }

    public void attachLynxContext(LynxContext r100) {
        if (r100 == null) goto L5;
        this.mContext = r100;
        return;
    }

    public void attachNativeFacade(NativeFacade r100) {
        this.mNativeFacade = new WeakReference(r100);
    }

    public void attachUIBodyView(UIBody.UIBodyView r100) {
        this.mUIBody.attachUIBodyView(r100, this.mContext);
        if (isContextFree() == true) goto L5;
        return;
    L5:
        if (this.mCreateNodeAsyncTasks.isEmpty() == true) goto L15;
        FutureTask<Runnable> r101 = this.mCreateNodeAsyncTasks.poll();
        if (r101 == null) goto L5;
        LynxThreadPool.g(new a(r101));
        goto L5
    }

    public boolean behaviorNeedProcessDirection(String r100) {
        if (r100.equals("page") == false) goto L7;
        return false;
    L7:
        return this.mBehaviorRegistry.c(r100).needProcessDirection();
    }

    public boolean behaviorSupportCreateAsync(String r100) {
        if (r100.equals("page") == false) goto L7;
        return false;
    L7:
        return this.mBehaviorRegistry.c(r100).supportCreateAsync();
    }

    public void componentStatistic(final String r100) {
        LynxContext r101 = this.mContext;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.enableEventReporter() == true) goto L8;
        return;
    L8:
        if (this.mComponentSet.contains(r100) == true) goto L16;
        this.mComponentSet.add(r100);
        LynxContext r102 = this.mContext;
        if (r102 != null) goto L12;
        int r103 = -1;
    L13:
        LynxEventReporter.onEvent(LYNXSDK_COMPONENT_STATISTIC_EVENT, r103, new h0(r100));
        return;
    L12:
        r103 = r102.getInstanceId();
        goto L13
    }

    public LynxBaseUI findLynxUIByA11yId(String r100) {
        if (r100.isEmpty() == false) goto L5;
        return null;
    L5:
        Iterator<Integer> r101 = this.mUIHolder.keySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L13;
        Integer r102 = r101.next();
        LynxBaseUI r103 = this.mUIHolder.get(r102);
        if (r103 == null) goto L7;
        if (r100.equals(r103.getAccessibilityId()) == false) goto L7;
        return r103;
    L13:
        return null;
    }

    public LynxBaseUI findLynxUIByComponentId(String r100) {
        if (r100.isEmpty() == true) goto L19;
        if ("-1".equals(r100) == true) goto L19;
        if (this.mComponentIdToUiIdHolder.containsKey(r100) == false) goto L20;
        int r101 = this.mComponentIdToUiIdHolder.get(r100).intValue();
    L13:
        if (r101 != (-1)) goto L17;
        return getRootUI();
    L17:
        return getNode(r101);
    L20:
        r101 = CastIntegerProtector.parseInt(r100);     // Catch: NumberFormatException -> L12
    L12:
        r101 = -1;
    L19:
        return getRootUI();
    }

    public LynxBaseUI findLynxUIByIdSelector(String r100) {
        Iterator<LynxBaseUI> r101 = this.mUIHolder.values().iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        LynxBaseUI r102 = r101.next();
        if (r102 == null) goto L4;
        if (r100.equals(r102.getIdSelector()) == false) goto L4;
        return r102;
    L10:
        return null;
    }

    public LynxBaseUI findLynxUIByIndex(int r100) {
        return this.mUIHolder.get(Integer.valueOf(r100));
    }

    public LynxBaseUI findLynxUIByName(String r100) {
        Iterator<LynxBaseUI> r101 = this.mUIHolder.values().iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        LynxBaseUI r102 = r101.next();
        if (r102 == null) goto L4;
        if (r100.equals(r102.getName()) == false) goto L4;
        return r102;
    L10:
        return null;
    }

    public LynxBaseUI findLynxUIBySign(int r100) {
        if ((this.mUIHolder.get(Integer.valueOf(r100)) instanceof UIShadowProxy) == false) goto L7;
        return ((UIShadowProxy) this.mUIHolder.get(Integer.valueOf(r100))).f382373a;
    L7:
        return this.mUIHolder.get(Integer.valueOf(r100));
    }

    public LynxBaseUI getNode(int r100) {
        HashMap<Integer, LynxBaseUI> r101 = this.mUIHolder;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.get(Integer.valueOf(r100));
    }

    public int getTagInfo(String r100) {
        ShadowNode r101 = this.mBehaviorRegistry.c(r100).createShadowNode();
        if (r101 != null) goto L6;
        return 1;
    L6:
        if (r101.p() == false) goto L8;
        return 6;
    L8:
        return 4;
    L11:
        return 0;
    }

    public void initGestureArenaManager(LynxContext r100) {
        if (this.mGestureArenaManager != null) goto L5;
        this.mGestureArenaManager = new q7a.b();
    L5:
        q7a.b r101 = this.mGestureArenaManager;
        r101.f531994f = true;
        if (r101.d() == false) goto L10;
        r101.f531993e = new s7a.b(r101);
        r101.f531989a = new HashMap();
        r101.f531990b = new LinkedList();
        r101.f531991c = new LinkedList();
        r101.f531996h = new t7a.d(r100, r101.f531993e);
        return;
    }

    public void onNodeReady(int r100) {
        LynxBaseUI r101 = this.mUIHolder.get(Integer.valueOf(r100));
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r101 instanceof UIShadowProxy) == false) goto L7;
        r101 = ((UIShadowProxy) r101).f382373a;
    L7:
        r101.onNodeReady();
    }

    public void onNodeReload(int r100) {
        LynxBaseUI r101 = this.mUIHolder.get(Integer.valueOf(r100));
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r101 instanceof UIShadowProxy) == false) goto L7;
        r101 = ((UIShadowProxy) r101).f382373a;
    L7:
        r101.onNodeReload();
    }

    public void onNodeRemoved(int r100) {
        LynxBaseUI r101 = this.mUIHolder.get(Integer.valueOf(r100));
        if (r101 == null) goto L6;
        onNodeRemovedRecursively(r101);
        return;
    }

    public void onTasmFinish(long r100) {
        List<r0> r101 = this.mContext.getPatchFinishListeners();
        if (r101 == null) goto L9;
        Iterator<r0> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L9;
        r102.next().onPatchFinish();
    L9:
        if (this.mUIBody.getBodyView() != null) goto L11;
        return;
    L11:
        if (this.mUIBody.getBodyView().HasPendingRequestLayout() == false) goto L16;
        LLog.i(TAG, "onTasmFinish do force RequestLayout after UpdateData in PreLoad Mode!");
        this.mUIBody.getBodyView().requestLayout();
        return;
    }

    public void registerBoundingClientRectUI(LynxBaseUI r100) {
        this.mCachedBoundingClientRectUI.add(r100);
    }

    public void registerForegroundListener(j r100) {
        List<j> r101 = this.mForegroundListeners;
        if (r101 == null) goto L6;
        r101.add(r100);
        return;
    }

    public void reportStatistic(String r100) {
        if (Build.VERSION.SDK_INT >= 24) goto L6;
        return;
    L6:
        if (LynxEnv.inst().enableComponentStatisticReport() == false) goto L9;
        componentStatistic(r100);
        return;
    }

    public void setAttachLynxPageUICallback(UIBody.UIBodyView.a r100) {
        this.mAttachLynxPageUICallback = r100;
    }

    public void setContextFree(boolean r100) {
        this.mIsContextFree = r100;
    }

    public void setHasTouchPseudo(boolean r100) {
        this.mHasTouchPseudo = r100;
    }

    public void setPaintingContext(l r100) {
        this.mPaintingContext = r100;
    }

    public void setRootSign(int r100) {
        this.mRootSign = r100;
    }

    public Object takeTextLayout(int r100) {
        com.lynx.tasm.behavior.shadow.text.d r101 = this.mTextMeasurer;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.f382279b.get(r100);
    }

    public void unregisterForegroundListener(j r100) {
        List<j> r101 = this.mForegroundListeners;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    public void validate(int r100) {
        LynxBaseUI r101 = getNode(r100);
        if (r101 != null) goto L6;
        LLog.e(TAG, "try to validate a not-existing node");
        return;
    L6:
        r101.renderIfNeeded();
    }

    public static /* synthetic */ void access$400(LynxUIOwner r100, String r101) {
        r100.traceBeginWithInstanceId(r101);
    }

    private void checkShadowOrOutline(x0 r100, LynxBaseUI r101) {
        if (hasShadowOrOutline(r100) == true) goto L6;
        return;
    L6:
        if (r100.a(GXTemplateKey.STYLE_BOX_SHADOW) != null) goto L11;
        if (r100.f("outline-style", -1) != (-1)) goto L11;
        return;
    L11:
        if ((r101 instanceof UIShadowProxy) == false) goto L13;
        return;
    L13:
        if ((r101.getParent() instanceof UIShadowProxy) == true) goto L18;
        addShadowProxy(r101);
        return;
    }

    private void checkTranslateZ(int r100, int r101) {
        if (this.mContext.getEnableFlattenTranslateZ() == true) goto L5;
        return;
    L5:
        LynxBaseUI r102 = this.mUIHolder.get(Integer.valueOf(r100));
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.getTranslationZ() == r102.getLastTranslateZ()) goto L17;
        LynxBaseUI r103 = this.mUIHolder.get(Integer.valueOf(r101));
        if (r103 != null) goto L13;
    L15:
        LynxBaseUI r104 = this.mUIHolder.get(Integer.valueOf(r101));
        this.mTranslateZParentHolder.add(r104);
        r104.setNeedSortChildren(true);
        r102.setLastTranslateZ(r102.getTranslationZ());
        return;
    L13:
        if (r103.isFlatten() == false) goto L15;
        newUpdateFlatten(r101, false);
        goto L15
    }

    private LynxBaseUI consumeInitialProps(LynxBaseUI r100, x0 r101) {
        return afterConsumeInitialProps(r100, consumeInitialPropsInterval(r100, r101), r101);
    }

    private UIShadowProxy consumeInitialPropsInterval(LynxBaseUI r100, x0 r101) {
        UIShadowProxy r102 = null;
        if (r101 != null) goto L5;
    L8:
        return r102;
    L5:
        if (hasShadowOrOutline(r101) == false) goto L7;
        r102 = new UIShadowProxy(this.mContext, r100);
    L7:
        r100.updatePropertiesInterval(r101);
        goto L8
    }

    private LynxBaseUI findLynxUIByIdWithGroup(String r100, UIGroup r101) {
        int r102 = 0;
    L4:
        if (r102 >= r101.getChildCount()) goto L18;
        LynxBaseUI r103 = r101.getChildAt(r102);
        if (r103.getIdSelector() == null) goto L11;
        if (r103.getIdSelector().equals(r100) == false) goto L11;
        return r103;
    L11:
        if (r103.getTagName().equals("component") == true) goto L17;
        if ((r103 instanceof UIGroup) == false) goto L17;
        LynxBaseUI r104 = findLynxUIByIdWithGroup(r100, (UIGroup) r103);
        if (r104 == null) goto L17;
        return r104;
    L17:
        r102 = r102 + 1;
        goto L4
    L18:
        return null;
    }

    private void insertA11yMutationEvent(int r100, LynxBaseUI r101) {
        com.lynx.tasm.behavior.ui.accessibility.d r102 = this.mUIBody.getLynxAccessibilityWrapper();
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.f382465k != null) goto L7;
        return;
    L7:
        if (r102.m() == false) goto L12;
        r102.f382465k.a(r100, r101, "");
        return;
    }

    private void newRemove(int r100, int r101) {
        if (this.mUIHolder.size() <= 0) goto L25;
        LynxBaseUI r102 = this.mUIHolder.get(Integer.valueOf(r101));
        if (r102 == null) goto L24;
        if (r100 != (-1)) goto L9;
        LynxBaseUI r103 = r102.getParentBaseUI();
    L10:
        if (r103 == null) goto L22;
        if (TraceEvent.isTracingStarted() == false) goto L14;
        String r104 = "UIOwner.remove." + r103.getTagName() + "." + r102.getTagName();
        TraceEvent.beginSection(r104);
    L15:
        removeFromDrawList(r102);
        r103.removeChild(r102);
        resetUIDrawingLayoutInfo(r102);
        if (r102.isFlatten() == false) goto L18;
        r103.flattenChildrenCountDecrement();
    L18:
        r102.removeChildrenExposureUI();
        insertA11yMutationEvent(1, r102);
        if (TraceEvent.isTracingStarted() == false) goto L26;
        TraceEvent.endSection(r104);
        return;
    L26:
        return;
    L14:
        r104 = null;
        goto L15
    L22:
        throw new RuntimeException("Trying to remove unknown ui signature: " + r101);
    L9:
        r103 = this.mUIHolder.get(Integer.valueOf(r100));
        goto L10
    L24:
        throw new RuntimeException("Trying to remove unknown ui signature: " + r101);
    }

    private void newUpdateFlatten(int r100, boolean r110) {
        LynxBaseUI r101 = this.mUIHolder.get(Integer.valueOf(r100));
        if (r101 != null) goto L5;
        return;
    L5:
        LynxBaseUI r102 = r101.getParentBaseUI();
        x0 r103 = new x0(r101.getProps());
        ArrayList r104 = new ArrayList(r101.getChildren());
        if (TraceEvent.isTracingStarted() == false) goto L8;
        String r105 = "UIOwner.updateFlatten." + r101.getTagName();
        TraceEvent.beginSection(r105);
    L9:
        int r106 = 0;
        if (r102 == null) goto L12;
        int r107 = r102.getIndex(r101);
        removeFromDrawList(r101);
        r102.removeChild(r101);
    L14:
        if (r101.isFlatten() == true) goto L19;
        Iterator r108 = r104.iterator();
    L17:
        if (r108.hasNext() == false) goto L19;
        removeFromDrawList((LynxBaseUI) r108.next());
    L19:
        int r109 = r101.getChildren().size() - 1;
    L20:
        if (r109 < 0) goto L22;
        r101.removeChild(r101.getChildAt(r109));
        r109 = r109 - 1;
        goto L20
    L22:
        LynxBaseUI r111 = createUI(r101.getTagName(), r110);
        r101.applyUIPaintStylesToTarget(r111);
        r111.setSign(r101.getSign(), r101.getTagName());
        consumeInitialProps(r111, r103);
        this.mUIHolder.put(Integer.valueOf(r101.getSign()), r111);
        if (this.mTranslateZParentHolder.contains(r101) == false) goto L25;
        this.mTranslateZParentHolder.remove(r101);
        this.mTranslateZParentHolder.add(r111);
    L25:
        if (r102 == null) goto L27;
        r102.insertChild(r111, r107);
        insertIntoDrawList(r102, r111, r107);
    L27:
        Iterator r112 = r104.iterator();
    L29:
        if (r112.hasNext() == false) goto L31;
        LynxBaseUI r113 = (LynxBaseUI) r112.next();
        resetUIDrawingLayoutInfo(r113);
        r111.insertChild(r113, r106);
        r106 = r106 + 1;
        goto L29
    L31:
        insertChildIntoDrawListRecursive(r111);
        r111.updateLayoutInfo(r101);
        r111.copyPropFromOldUiInUpdateFlatten(r101);
        r111.measure();
        ((LynxUI) r111).handleLayout();
        if ((r111 instanceof UIGroup) == false) goto L34;
        ((UIGroup) r111).layoutChildren();
    L34:
        r111.invalidate();
        r101.destroy();
        if (TraceEvent.isTracingStarted() == false) goto L41;
        TraceEvent.endSection(r105);
        return;
    L41:
        return;
    L12:
        r107 = 0;
        goto L14
    L8:
        r105 = null;
        goto L9
    }

    public LynxBaseUI createUI(String r100, boolean r101) {
        return createUI(r100, r101, null);
    }

    public void destroy(int r100, int r101) {
        TraceEvent.beginSection("UIOwner.destroy.item");
        if (this.mUIHolder.size() <= 0) goto L19;
        LynxBaseUI r102 = this.mUIHolder.get(Integer.valueOf(r101));
        if (r102 != null) goto L8;
        TraceEvent.endSection("UIOwner.destroy.item");
        return;
    L8:
        this.mTranslateZParentHolder.remove(r102);
        removeFromDrawList(r102);
        this.mUIHolder.remove(Integer.valueOf(r101));
        this.mContext.removeUIFromExposedMap(r102);
        r102.destroy();
        insertA11yMutationEvent(2, r102);
        if (this.mContext.getEnableFiberArch() == true) goto L12;
        destroyChildrenRecursively(r102);
    L12:
        if (r100 != (-1)) goto L14;
        LynxBaseUI r103 = r102.getParentBaseUI();
    L15:
        if (r103 != null) goto L18;
        TraceEvent.endSection("UIOwner.destroy.item");
        return;
    L18:
        r103.removeChild(r102);
        goto L19
    L14:
        r103 = this.mUIHolder.get(Integer.valueOf(r100));
    L19:
        TraceEvent.endSection("UIOwner.destroy.item");
    }

    public void dispatchLayoutBefore(int r100, ReadableCompactArrayBuffer r101) {
        this.mTextMeasurer.c(r100, r101);
    }

    public LynxBaseUI findLynxUIById(String r100, LynxBaseUI r101) {
        if (r101 == null) goto L9;
        if (r101.getIdSelector() == null) goto L9;
        if (r101.getIdSelector().equals(r100) == false) goto L9;
        return r101;
    L9:
        if ((r101 instanceof UIGroup) == true) goto L11;
        return null;
    L11:
        UIGroup r102 = (UIGroup) r101;
        int r103 = 0;
    L13:
        if (r103 >= r102.getChildCount()) goto L27;
        LynxBaseUI r104 = r102.getChildAt(r103);
        if (r104.getIdSelector() == null) goto L20;
        if (r104.getIdSelector().equals(r100) == false) goto L20;
        return r104;
    L20:
        if (r104.getTagName().equals("component") == true) goto L26;
        if ((r104 instanceof UIGroup) == false) goto L26;
        LynxBaseUI r105 = findLynxUIById(r100, r104);
        if (r105 == null) goto L26;
        return r105;
    L26:
        r103 = r103 + 1;
        goto L13
    L27:
        return null;
    }

    public LynxBaseUI findLynxUIByIdSelector(String r100, LynxBaseUI r101) {
        if (r101 == null) goto L9;
        if (r101.getIdSelector() == null) goto L9;
        if (r101.getIdSelector().equals(r100) == false) goto L9;
        return r101;
    L9:
        if (r101 != null) goto L11;
        return null;
    L11:
        Iterator<LynxBaseUI> r102 = r101.getChildren().iterator();
    L13:
        if (r102.hasNext() == false) goto L24;
        LynxBaseUI r103 = r102.next();
        if (r103.getIdSelector() == null) goto L20;
        if (r103.getIdSelector().equals(r100) == false) goto L20;
        return r103;
    L20:
        if ((r103 instanceof UIComponent) == true) goto L13;
        LynxBaseUI r104 = findLynxUIByIdSelector(r100, r103);
        if (r104 == null) goto L13;
        return r104;
    L24:
        return null;
    }

    public LynxBaseUI findLynxUIByIdSelectorSearchUp(String r100, LynxBaseUI r101) {
        if (r101 != null) goto L6;
        LLog.e(TAG, "findLynxUIByIdSelectorSearchUp failed, the ui is null for " + r100 + ".");
        return null;
    L6:
        if (r101.getIdSelector() == null) goto L11;
        if (r101.getIdSelector().equals(r100) == false) goto L11;
        return r101;
    L11:
        return findLynxUIByIdSelectorSearchUp(r100, r101.getParentBaseUI());
    }

    public LynxBaseUI findLynxUIByRefId(String r100, LynxBaseUI r101) {
        if (r101 == null) goto L9;
        if (r101.getRefIdSelector() == null) goto L9;
        if (r101.getRefIdSelector().equals(r100) == false) goto L9;
        return r101;
    L9:
        if (r101 != null) goto L11;
        return null;
    L11:
        Iterator<LynxBaseUI> r102 = r101.getChildren().iterator();
    L13:
        if (r102.hasNext() == false) goto L24;
        LynxBaseUI r103 = r102.next();
        if (r103.getRefIdSelector() == null) goto L20;
        if (r103.getRefIdSelector().equals(r100) == false) goto L20;
        return r103;
    L20:
        if (r103.getTagName().equals("component") == true) goto L13;
        LynxBaseUI r104 = findLynxUIByRefId(r100, r103);
        if (r104 == null) goto L13;
        return r104;
    L24:
        return null;
    }

    public void listCellAppear(int r100, String r101) {
        LynxBaseUI r102 = this.mUIHolder.get(Integer.valueOf(r100));
        if (r102 != null) goto L5;
        return;
    L5:
        if ((r102.getParentBaseUI() instanceof UIListContainer) == false) goto L9;
        r102.onListCellAppear(r101, r102.getParentBaseUI());
        return;
    }

    public void onLayoutFinish(int r100, long r101) {
        handleTranslateZUI();
        if (this.mUIBody.getLynxAccessibilityWrapper() == null) goto L46;
        com.lynx.tasm.behavior.ui.accessibility.d r102 = this.mUIBody.getLynxAccessibilityWrapper();
        if (r102.f382465k == null) goto L23;
        if (r102.m() == false) goto L23;
        if (r102.h() == null) goto L23;
        if (r102.h().getLynxContext() == null) goto L23;
        com.lynx.tasm.behavior.ui.accessibility.a r103 = r102.f382465k;
        LynxContext r104 = r102.h().getLynxContext();
        if (r104 != null) goto L15;
        r103.getClass();
        goto L23
    L15:
        if (r103.f382446a.isEmpty() == true) goto L23;
        JavaOnlyArray r105 = new JavaOnlyArray();
        Iterator<JavaOnlyMap> r106 = r103.f382446a.iterator();
    L18:
        if (r106.hasNext() == false) goto L20;
        r105.add(r106.next());
        goto L18
    L20:
        JavaOnlyArray r107 = new JavaOnlyArray();
        r107.add(r105);
        r104.sendGlobalEvent("a11y-mutations", r107);
        r103.f382446a.clear();
    L23:
        if (r102.f() == false) goto L46;
        LynxAccessibilityHelper r108 = r102.f382468n;
        if (r108.f382429d.isEmpty() == true) goto L36;
        Iterator<WeakReference<LynxBaseUI>> r109 = r108.f382429d.iterator();
    L28:
        if (r109.hasNext() == false) goto L34;
        WeakReference<LynxBaseUI> r110 = r109.next();
        if (r110 == null) goto L28;
        if (r110.get() == null) goto L28;
        r108.b(r110.get());
        goto L28
    L34:
        r108.f382429d.clear();
    L36:
        if (r108.f382428c.isEmpty() == true) goto L46;
        Iterator<WeakReference<LynxBaseUI>> r111 = r108.f382428c.iterator();
    L39:
        if (r111.hasNext() == false) goto L45;
        WeakReference<LynxBaseUI> r112 = r111.next();
        if (r112 == null) goto L39;
        if (r112.get() == null) goto L39;
        r108.b(r112.get());
        goto L39
    L45:
        r108.f382428c.clear();
    L46:
        UIBody.UIBodyView r113 = this.mUIBody.getBodyView();
        if (r113 == null) goto L54;
        int r114 = this.mUIBody.getWidth();
        int r115 = this.mUIBody.getHeight();
        if (r114 == r113.getIntrinsicWidth()) goto L51;
    L52:
        r113.setIntrinsicContentSize(r114, r115);
        goto L54
    L51:
        if (r115 != r113.getIntrinsicHeight()) goto L52;
    L54:
        if (r101 != 0) goto L56;
        return;
    L56:
        LynxBaseUI r116 = this.mUIHolder.get(Integer.valueOf(getSignFromOperationId(r101)));
        if (r116 != null) goto L59;
        return;
    L59:
        if (TraceEvent.isTracingStarted() == false) goto L61;
        String r117 = "UIOwner.layoutFinish." + r116.getTagName();
        TraceEvent.beginSection(r117);
    L62:
        r116.onLayoutFinish(r101, this.mUIHolder.get(Integer.valueOf(r100)));
        if (TraceEvent.isTracingStarted() == false) goto L82;
        TraceEvent.endSection(r117);
        return;
    L82:
        return;
    L61:
        r117 = null;
        goto L62
    }

    public void remove(int r100, int r101) {
        newRemove(r100, r101);
    }

    public void reuseListNode(int r100, String r101) {
        LynxBaseUI r102 = this.mUIHolder.get(Integer.valueOf(r100));
        if (r102 != null) goto L5;
        return;
    L5:
        if ((r102.getParentBaseUI() instanceof UIList) == false) goto L7;
    L8:
        r102.onListCellPrepareForReuse(r101, r102.getParentBaseUI());
        return;
    L7:
        if ((r102.getParentBaseUI() instanceof UIListContainer) == true) goto L8;
    }

    public void setFrameAppBundle(int r100, TemplateBundle r101) {
        updateViewExtraData(r100, r101);
    }

    public void setNode(int r100, LynxBaseUI r101) {
        HashMap<Integer, LynxBaseUI> r102 = this.mUIHolder;
        if (r102 == null) goto L6;
        r102.put(Integer.valueOf(r100), r101);
        return;
    }

    public void updateFlatten(int r100, boolean r101) {
        newUpdateFlatten(r100, r101);
    }

    public void updateViewExtraData(int r100, Object r101) {
        UIThreadUtils.assertOnUiThread();
        LynxBaseUI r102 = this.mUIHolder.get(Integer.valueOf(r100));
        if (r102 != null) goto L5;
        return;
    L5:
        if (TraceEvent.isTracingStarted() == false) goto L7;
        String r103 = "UIOwner.updateViewExtraData." + r102.getTagName();
        TraceEvent.beginSection(r103);
    L8:
        r102.updateExtraData(r101);
        if (TraceEvent.isTracingStarted() == false) goto L13;
        TraceEvent.endSection(r103);
        return;
    L13:
        return;
    L7:
        r103 = null;
        goto L8
    }

    public LynxUIOwner(LynxContext r100, com.lynx.tasm.behavior.c r101, UIBody.UIBodyView r102) {
        this.mIsContextFree = false;
        this.mSettingsEnableNewImage = null;
        this.mCreateNodeAsyncTasks = new ConcurrentLinkedQueue();
        TraceEvent.beginSection("LynxUIOwner initialized");
        this.mContext = r100;
        this.mBehaviorRegistry = r101;
        if (Build.VERSION.SDK_INT < 24) goto L5;
        this.mComponentSet = ConcurrentHashMap.newKeySet();
    L6:
        this.mTranslateZParentHolder = new HashSet();
        this.mForegroundListeners = new ArrayList();
        this.mUIHolder = new HashMap();
        this.mTextChildUIHolder = new HashMap();
        this.mComponentIdToUiIdHolder = new HashMap();
        this.mRootSign = -1;
        UIBody r103 = new UIBody(this.mContext, r102);
        this.mUIBody = r103;
        this.mContext.setUIBody(r103);
        this.mIsFirstLayout = true;
        this.mIsRootLayoutAnimationRunning = true;
        this.mCachedBoundingClientRectUI = new HashSet();
        this.mEnableReportCreateAsync = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.ENABLE_REPORT_CREATE_ASYNC_TAG, false);
        this.mCreateNodeConfigHasReportedMark = new HashMap();
        if (r100.isLayoutInElementModeOn() == false) goto L9;
        this.mTextMeasurer = new com.lynx.tasm.behavior.shadow.text.d(r100);
    L9:
        attachUIBodyView(r102);
        TraceEvent.endSection("LynxUIOwner initialized");
        return;
    L5:
        this.mComponentSet = new HashSet();
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LynxBaseUI afterConsumeInitialProps(LynxBaseUI r100, UIShadowProxy r101, x0 r102) {
        if ((r100 instanceof r0) == false) goto L6;
        this.mContext.registerPatchFinishListener((r0) r100);
    L6:
        if ((r100 instanceof j) == false) goto L8;
        registerForegroundListener((j) r100);
    L8:
        if (r102 == null) goto L32;
        r100.afterPropsUpdated(r102);
        boolean r103 = true;
        if (r102.i("transition") == true) goto L18;
        MapBuffer r104 = r102.f383220b;
        if (r104 == null) goto L14;
        boolean r105 = r104.contains(109);
    L15:
        if (r105 == true) goto L18;
        boolean r106 = false;
    L19:
        if (r106 == false) goto L22;
        r100.initTransitionAnimator(r102.f383219a);
    L22:
        if (r102.i(GXTemplateKey.GAIAX_ANIMATION) == true) goto L30;
        MapBuffer r107 = r102.f383220b;
        if (r107 == null) goto L26;
        boolean r108 = r107.contains(64);
    L27:
        if (r108 == true) goto L30;
        r103 = false;
        goto L30
    L26:
        r108 = false;
    L30:
        if (r103 == false) goto L32;
        r100.setAnimation(r102.a(GXTemplateKey.GAIAX_ANIMATION));
        goto L32
    L14:
        r105 = false;
    L18:
        r106 = true;
    L32:
        if (r101 != null) goto L34;
        return r100;
    L34:
        return r101;
    }

    private LynxBaseUI createSwiperIfNeeded(String r100, LynxBaseUI r101, Object r102) {
        if ("swiper".equals(r100) == true) goto L9;
        if ("x-swiper".equals(r100) == true) goto L9;
        return r101;
    L9:
        return new XSwiperUI(this.mContext, r102);
    }

    private LynxBaseUI createUI(String r100, boolean r101, Object r102) {
        LynxBaseUI r103 = null;
        if (this.mContext.isUseNewSwiper() == false) goto L5;
        r103 = createSwiperIfNeeded(r100, null, r102);
    L5:
        if (r103 != null) goto L23;
        com.lynx.tasm.behavior.a r104 = this.mBehaviorRegistry.c(r100);
        com.lynx.tasm.behavior.ui.accessibility.d r105 = this.mContext.getLynxAccessibilityWrapper();
        if (r105 != null) goto L9;
    L16:
        if (r101 == true) goto L18;
    L20:
        if (r103 == null) goto L22;
        return r103;
    L22:
        return r104.createUIWithParams(this.mContext, r102);
    L18:
        if (r104.supportUIFlatten() == false) goto L20;
        r103 = r104.createFlattenUIWithParams(this.mContext, r102);
        goto L20
    L9:
        if (r105.f() == true) goto L11;
    L13:
        boolean r106 = false;
    L14:
        if (r106 == false) goto L16;
        r101 = false;
        goto L16
    L11:
        if (r105.k() == false) goto L13;
        r106 = true;
        goto L14
    L23:
        return r103;
    }

    private void insertIntoDrawList(LynxBaseUI r100, LynxBaseUI r101, int r102) {
        r101.setNextDrawUI(null);
        if (r100.isFlatten() == false) goto L5;
        LynxBaseUI r103 = r100.getDrawParent();
    L6:
        if (r103 != null) goto L8;
        return;
    L8:
        if (r102 != 0) goto L14;
        LynxUI r104 = (LynxUI) r103;
        if (r100.isFlatten() == true) goto L13;
        r100 = null;
    L13:
        r104.insertDrawList(r100, r101);
    L22:
        if (r101.isFlatten() == true) goto L29;
        UIGroup r105 = (UIGroup) r103;
        if (r105.isInsertViewCalled() == false) goto L30;
        r105.insertView((LynxUI) r101);
        return;
    L30:
        return;
    L29:
        return;
    L14:
        LynxBaseUI r106 = r100.getChildAt(r102 - 1);
    L16:
        if (r106.isFlatten() == false) goto L20;
        if (r106.getChildren().isEmpty() == true) goto L20;
        r106 = r106.getChildAt(r106.getChildren().size() - 1);
    L20:
        ((LynxUI) r103).insertDrawList(r106, r101);
        goto L22
    L5:
        r103 = r100;
        goto L6
    }

    private static /* synthetic */ Map lambda$reportCreateViewConfig$3(String r100, String r101, boolean r102) {
        HashMap r103 = new HashMap();
        r103.put("tag_name", r100);
        r103.put("class_name", r101);
        r103.put("enable_async", Boolean.valueOf(r102));
        return r103;
    }

    private void newInsert(int r100, int r101, int r102) {
        if (this.mUIHolder.size() > 0) goto L5;
        return;
    L5:
        if (this.mUIHolder.get(Integer.valueOf(r100)) == null) goto L26;
        LynxBaseUI r103 = this.mUIHolder.get(Integer.valueOf(r101));
        if (r103 == null) goto L24;
        checkTranslateZ(r101, r100);
        LynxBaseUI r104 = this.mUIHolder.get(Integer.valueOf(r100));
        if (r104.canHaveFlattenChild() == true) goto L14;
        if (r103.isFlatten() == false) goto L14;
        newUpdateFlatten(r101, false);
        r103 = this.mUIHolder.get(Integer.valueOf(r101));
    L14:
        if (r102 != (-1)) goto L16;
        r102 = r104.getChildren().size();
    L16:
        r104.insertChild(r103, r102);
        insertIntoDrawList(r104, r103, r102);
        if (r103.isFlatten() == false) goto L20;
        r104.flattenChildrenCountIncrement();
    L20:
        if (r103.isFlatten() == false) goto L22;
        insertChildIntoDrawListRecursive(r103);
        r103.requestLayout();
        r103.invalidate();
    L22:
        insertA11yMutationEvent(0, r103);
        return;
    L24:
        throw new RuntimeException("Insertion (new) failed due to unknown child signature: " + r101);
    L26:
        throw new RuntimeException("Insertion (new) failed due to unknown parent signature: " + r100);
    }

    private void updateComponentIdToUiIdMapIfNeeded(int r100, String r101, x0 r102) {
        if (r101.equals("component") == true) goto L5;
        return;
    L5:
        if (r102.i("ComponentID") == false) goto L12;
        String r103 = r102.h("ComponentID");
        if (r103 != null) goto L9;
        r103 = "-1";
    L9:
        this.mComponentIdToUiIdHolder.put(r103, Integer.valueOf(r100));
        return;
    }

    public void cleanupCreatedView(int r100, String r101, ReadableMap r102) {
        if (getNode(r100) != null) goto L5;
        return;
    L5:
        destroy(-1, r100);
    }

    public void consumeGesture(int r100, int r101, ReadableMap r102) {
        LynxBaseUI r103 = getNode(r100);
        if (r103 != null) goto L6;
        LLog.e(TAG, "Attempted to set gesture detector state for a non-existing node");
        return;
    L6:
        r103.consumeGesture(r101, r102);
    }

    public void dump(StringBuilder r100, LynxBaseUI r101, int r102) {
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100.append(" ");
        r103 = r103 + 1;
        goto L3
    L5:
        r100.append("id: ");
        r100.append(r101.getSign());
        r100.append(", tag: ");
        r100.append(r101.getTagName());
        r100.append(", rect: [");
        r100.append(r101.getLeft());
        r100.append(", ");
        r100.append(r101.getTop());
        r100.append(", ");
        r100.append(r101.getWidth());
        r100.append(", ");
        r100.append(r101.getHeight());
        r100.append("]");
        if (r101.getLynxBackground() == null) goto L8;
        r100.append(", bg: 0x");
        r100.append(Integer.toHexString(r101.getLynxBackground().f383140e));
    L8:
        r100.append("\n");
    }

    public void dumpDrawList(StringBuilder r100, UIGroup r101, int r102) {
        dump(r100, r101, r102);
        LynxBaseUI r103 = r101.getDrawHead();
    L3:
        if (r103 == null) goto L5;
        dump(r100, r103, r102);
        r103 = r103.getNextDrawUI();
        goto L3
    }

    public void dumpTree(StringBuilder r100, LynxBaseUI r101, int r102) {
        dump(r100, r101, r102);
        int r103 = 0;
    L4:
        if (r103 >= r101.getChildren().size()) goto L6;
        dumpTree(r100, (LynxBaseUI) ListProtector.get(r101.getChildren(), r103), r102 + 1);
        r103 = r103 + 1;
        goto L4
    }

    public void insert(int r100, int r101, int r102) {
        newInsert(r100, r101, r102);
    }

    public void listCellDisappear(int r100, Boolean r101, String r102) {
        LynxBaseUI r103 = this.mUIHolder.get(Integer.valueOf(r100));
        if (r103 != null) goto L5;
        return;
    L5:
        if ((r103.getParentBaseUI() instanceof UIListContainer) == false) goto L9;
        r103.onListCellDisAppear(r102, r103.getParentBaseUI(), r101.booleanValue());
        return;
    }

    public void reportCreateViewConfig(int r100, final String r101, final boolean r102) {
        LynxContext r103 = this.mContext;
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103.enableEventReporter() == true) goto L8;
        return;
    L8:
        if (TextUtils.equals(r101, "page") == false) goto L11;
        return;
    L11:
        if (this.mEnableReportCreateAsync == true) goto L13;
        return;
    L13:
        if (this.mCreateNodeConfigHasReportedMark.containsKey(r101) == true) goto L22;
        this.mCreateNodeConfigHasReportedMark.put(r101, Boolean.valueOf(r102));
        LynxBaseUI r104 = getNode(r100);
        if (r104 == null) goto L17;
        final String r105 = r104.getClass().getSimpleName();
    L18:
        LynxEventReporter.onEvent(LYNXSDK_ASYNC_CREATE_CONFIG, getContext().getInstanceId(), new j0(r101, r105, r102));
        return;
    L17:
        r105 = null;
        goto L18
    }

    public void setGestureDetectorState(int r100, int r101, int r102) {
        LynxBaseUI r103 = getNode(r100);
        if (r103 != null) goto L6;
        LLog.e(TAG, "Attempted to set gesture detector state for a non-existing node");
        return;
    L6:
        r103.setGestureDetectorState(r101, r102);
    }

    public static /* synthetic */ LynxBaseUI access$000(LynxUIOwner r100, LynxBaseUI r101, UIShadowProxy r102, x0 r103) {
        return r100.afterConsumeInitialProps(r101, r102, r103);
    }

    public static /* synthetic */ void access$100(LynxUIOwner r100, int r101, String r102, x0 r103) {
        r100.updateComponentIdToUiIdMapIfNeeded(r101, r102, r103);
    }

    private static /* synthetic */ Map lambda$reportCreateAsyncSuccessEvent$2(String r100, String r101, boolean r102, int r103) {
        HashMap r104 = new HashMap();
        r104.put("tag_name", r100);
        r104.put("class_name", r101);
        r104.put("success", Boolean.valueOf(r102));
        r104.put("status", Integer.valueOf(r103));
        return r104;
    }

    public void invokeUIMethodForSelectorQuery(int r100, String r101, ReadableMap r102, Callback r103) {
        LynxBaseUI r104 = getNode(r100);
        if (r104 != null) goto L5;
        if (r103 == null) goto L16;
        r103.invoke(new Object[]{6, "node does not have a LynxUI"});
        return;
    L16:
        return;
    L5:
        if (TraceEvent.isTracingStarted() == false) goto L7;
        String r105 = "UIOwner.invokeUIMethodForSelectorQuery." + r104.getTagName() + "." + r101;
        TraceEvent.beginSection(r105);
    L8:
        LynxUIMethodsExecutor.b(r104, r101, r102, r103);
        if (TraceEvent.isTracingStarted() == false) goto L14;
        TraceEvent.endSection(r105);
        return;
    L14:
        return;
    L7:
        r105 = null;
        goto L8
    }

    public void reportCreateAsyncSuccessEvent(int r100, final String r101, final boolean r102, final int r103) {
        LynxContext r104 = this.mContext;
        if (r104 != null) goto L5;
        return;
    L5:
        if (r104.enableEventReporter() == true) goto L8;
        return;
    L8:
        if (this.mEnableReportCreateAsync == false) goto L16;
        LynxBaseUI r105 = getNode(r100);
        if (r105 == null) goto L12;
        final String r106 = r105.getClass().getSimpleName();
    L13:
        LynxEventReporter.onEvent(LYNXSDK_ASYNC_CREATE_SUCCESS_EVENT, getContext().getInstanceId(), new i0(r101, r106, r102, r103));
        return;
    L12:
        r106 = null;
        goto L13
    }

    public void invokeUIMethod(String r100, ReadableArray r110, String r111, ReadableMap r112, Callback r113) {
        LynxBaseUI r101 = findLynxUIByComponentId(r100);
        String r102 = "component not found, nodes: " + r110.toString() + ", method: " + r111;
        if (r101 == null) goto L33;
        int r103 = 0;
    L6:
        if (r103 >= r110.size()) goto L33;
        String r104 = r110.getString(r103);
        if (r112 != null) goto L10;
    L16:
        boolean r105 = false;
    L18:
        if (r104.startsWith("#") == true) goto L23;
        if (r105 == true) goto L23;
        if (r113 == null) goto L43;
        r113.invoke(new Object[]{5, r104.concat(" not support, only support id selector currently")});
        return;
    L43:
        return;
    L23:
        String r106 = r104.substring(1);
        if (r105 == false) goto L26;
        r101 = findLynxUIByRefId(r104, r101);
    L27:
        if (r101 == null) goto L28;
        if (r101.getIdSelector() == null) goto L32;
        r101.getIdSelector().equals(r106);
    L32:
        r103 = r103 + 1;
        goto L6
    L28:
        r102 = "not found ".concat(r104);
        goto L33
    L26:
        r101 = findLynxUIByIdSelector(r106, r101);
        goto L27
    L10:
        if (r112.size() <= 0) goto L16;
        if (r112.hasKey("_isCallByRefId") == false) goto L16;
        if (r112.getBoolean("_isCallByRefId") == false) goto L16;
        r105 = true;
    L33:
        if (r101 == null) goto L35;
        LynxUIMethodsExecutor.b(r101, r111, r112, r113);
        return;
    L35:
        if (r113 == null) goto L45;
        r113.invoke(new Object[]{2, r102});
        return;
    }

    public void updateProperties(int r100, boolean r101, x0 r102, Map<String, EventsListener> r103, Map<Integer, s7a.a> r104) {
        UIThreadUtils.assertOnUiThread();
        LynxBaseUI r105 = this.mUIHolder.get(Integer.valueOf(r100));
        if (r105 != null) goto L5;
        return;
    L5:
        updateComponentIdToUiIdMapIfNeeded(r100, r105.getTagName(), r102);
        if (TraceEvent.isTracingStarted() == false) goto L8;
        String r106 = "UIOwner.updateProps." + r105.getTagName();
        TraceEvent.beginSection(r106);
    L9:
        if (r103 == null) goto L11;
        r105.setEvents(r103);
    L11:
        if (r104 == null) goto L13;
        r105.setGestureDetectors(r104);
    L13:
        boolean r107 = true;
        if (r101 == false) goto L16;
    L18:
        boolean r108 = false;
    L19:
        if (r108 == false) goto L21;
        updateFlatten(r100, false);
        r105 = this.mUIHolder.get(Integer.valueOf(r100));
    L21:
        if (r102 != null) goto L23;
    L54:
        r105.updateProperties(r102);
        checkTranslateZ(r105);
        if (TraceEvent.isTracingStarted() == false) goto L58;
        TraceEvent.endSection(r106);
        return;
    L58:
        return;
    L23:
        if (r102.j() == true) goto L54;
        if (r102.i("transition") == true) goto L33;
        MapBuffer r109 = r102.f383220b;
        if (r109 == null) goto L29;
        boolean r110 = r109.contains(109);
    L30:
        if (r110 == true) goto L33;
        boolean r111 = false;
    L34:
        if (r111 == false) goto L40;
        if ((r105 instanceof UIShadowProxy) == false) goto L38;
        ((UIShadowProxy) r105).f382373a.initTransitionAnimator(r102.f383219a);
        goto L40
    L38:
        r105.initTransitionAnimator(r102.f383219a);
    L40:
        if (r102.i(GXTemplateKey.GAIAX_ANIMATION) == true) goto L48;
        MapBuffer r112 = r102.f383220b;
        if (r112 == null) goto L44;
        boolean r113 = r112.contains(64);
    L45:
        if (r113 == true) goto L48;
        r107 = false;
        goto L48
    L44:
        r113 = false;
    L48:
        if (r107 == true) goto L50;
    L53:
        checkShadowOrOutline(r102, r105);
        goto L54
    L50:
        if ((r105 instanceof UIShadowProxy) == false) goto L52;
        ((UIShadowProxy) r105).f382373a.setAnimation(r102.a(GXTemplateKey.GAIAX_ANIMATION));
        goto L53
    L52:
        r105.setAnimation(r102.a(GXTemplateKey.GAIAX_ANIMATION));
        goto L53
    L29:
        r110 = false;
    L33:
        r111 = true;
        goto L34
    L16:
        if (r105.isFlatten() == false) goto L18;
        r108 = true;
        goto L19
    L8:
        r106 = null;
        goto L9
    }

    public float[] measureText(int r100, float r101, int r110, float r111, int r112, float[] r113) {
        return this.mTextMeasurer.e(r100, r101, r110, r111, r112, r113);
    }

    private /* synthetic */ Runnable lambda$createViewAsync$0(String r110, int r111, int r112, boolean r113, x0 r114, Map r115, Map r116) throws Exception {
    L12:
        th = move-exception;
        String r100 = "createViewAsync failed, tagName:" + r110 + ", error:" + th;
        LLog.e(TAG, r100);
        Exception r101 = new Exception(r100);
        r101.setStackTrace(th.getStackTrace());
        UIThreadUtils.runOnUiThread(new f(this, r101));
        return null;
    L4:
        if (TraceEvent.isTracingStarted() == false) goto L6;
        String r102 = "UIOwner.createViewAsync." + r110;     // Catch: Throwable -> L12
        traceBeginWithInstanceId(r102);     // Catch: Throwable -> L12
    L7:
        LynxBaseUI r103 = createViewInterval(new com.lynx.tasm.behavior.ui.j(r111, r112, r113, r110, r115, r116));     // Catch: Throwable -> L12
        LynxBaseUI[] r104 = {r103};     // Catch: Throwable -> L12
        UIShadowProxy r105 = consumeInitialPropsInterval(r103, r114);     // Catch: Throwable -> L12
        if (TraceEvent.isTracingStarted() == false) goto L10;
        TraceEvent.endSection(r102);     // Catch: Throwable -> L12
    L10:
        return new e(this, r110, r104, r105, r114, r111);
    L6:
        r102 = null;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [com.lynx.tasm.behavior.g0, java.util.concurrent.Callable] */
    public Future<Runnable> createViewAsync(final int r110, final String r111, final x0 r112, final Map<String, EventsListener> r113, final boolean r114, final int r115, final Map<Integer, s7a.a> r116) {
        ?? r100 = new g0(this, r111, r110, r115, r114, r112, r113, r116);
        if (isContextFree() == false) goto L7;
        FutureTask<Runnable> r101 = new FutureTask(r100);
        this.mCreateNodeAsyncTasks.add(r101);
        return r101;
    L7:
        return LynxThreadPool.f(r100);
    }

    public synchronized void createViewInternal(int r110, String r111, x0 r112, Map<String, EventsListener> r210, boolean r211, int r212, Map<Integer, s7a.a> r213) {
        monitor-enter(this);
        LynxBaseUI r113 = null;
        if (TraceEvent.isTracingStarted() == false) goto L7;
        String r100 = "UIOwner.createView." + r111;     // Catch: Throwable -> L34
        TraceEvent.beginSection(r100);     // Catch: Throwable -> L34
        String r114 = r100;
    L8:
        UIThreadUtils.assertOnUiThread();     // Catch: Throwable -> L34
        r113 = createViewInterval(new com.lynx.tasm.behavior.ui.j(r110, r212, r211, r111, r210, r213));     // Catch: Throwable -> L18
        LynxBaseUI r101 = consumeInitialProps(r113, r112);     // Catch: Throwable -> L16
        if (r101 == null) goto L14;
        reportStatistic(r111);     // Catch: Throwable -> L34
        updateComponentIdToUiIdMapIfNeeded(r110, r111, r112);     // Catch: Throwable -> L34
        this.mUIHolder.put(Integer.valueOf(r110), r101);     // Catch: Throwable -> L34
    L25:
        if (TraceEvent.isTracingStarted() == false) goto L27;
        TraceEvent.endSection(r114);     // Catch: Throwable -> L34
    L27:
        monitor-exit(this);
        return;
    L14:
        LLog.e(TAG, "createUI got null ui for tag:" + r111);     // Catch: Throwable -> L34
    L16:
        th = th;
    L38:
        RuntimeException r102 = new RuntimeException("createUI catch error while createUI for tag: " + r111 + ", " + th.getMessage(), th);     // Catch: Throwable -> L29
        r102.setStackTrace(th.getStackTrace());     // Catch: Throwable -> L29
        this.mUIBody.getLynxContext().handleException(r102);     // Catch: Throwable -> L29
        if (r113 == null) goto L23;
        reportStatistic(r111);     // Catch: Throwable -> L34
        updateComponentIdToUiIdMapIfNeeded(r110, r111, r112);     // Catch: Throwable -> L34
        this.mUIHolder.put(Integer.valueOf(r110), r113);     // Catch: Throwable -> L34
        goto L25
    L23:
        LLog.e(TAG, "createUI got null ui for tag:" + r111);     // Catch: Throwable -> L34
        goto L25
    L29:
        th = move-exception;
        if (r113 == null) goto L32;
        reportStatistic(r111);     // Catch: Throwable -> L34
        updateComponentIdToUiIdMapIfNeeded(r110, r111, r112);     // Catch: Throwable -> L34
        this.mUIHolder.put(Integer.valueOf(r110), r113);     // Catch: Throwable -> L34
    L33:
        throw th;     // Catch: Throwable -> L34
    L32:
        LLog.e(TAG, "createUI got null ui for tag:" + r111);     // Catch: Throwable -> L34
    L18:
        th = th;
        goto L38
    L7:
        r114 = null;
    L34:
        th = move-exception;
        throw th;
    }

    public void createView(int r110, String r111, ReadableMap r112, ReadableMapBuffer r113, ReadableArray r114, boolean r115, int r116, ReadableArray r117) {
        if (r112 == null) goto L5;
        x0 r100 = new x0(r112, r113);
    L6:
        createViewInternal(r110, r111, r100, EventsListener.convertEventListeners(r114), r115, r116, s7a.a.a(r117));
        return;
    L5:
        r100 = null;
        goto L6
    }

    public Runnable createViewAsyncRunnable(int r110, String r111, ReadableMap r210, ReadableMapBuffer r211, ReadableArray r212, boolean r213, int r214, ReadableArray r215) {
        reportCreateViewConfig(r110, r111, true);
        if (r210 == null) goto L5;
        x0 r112 = new x0(r210, r211);
    L6:
        com.lynx.tasm.behavior.ui.j r100 = new com.lynx.tasm.behavior.ui.j(r110, r214, r213, r111, EventsListener.convertEventListeners(r212), s7a.a.a(r215));
    L20:
        th = th;
        boolean r113 = false;
    L22:
        String r101 = "createViewAsync failed, tagName:" + r111 + ", error:" + th;
        LLog.e(TAG, r101);
        Exception r102 = new Exception(r101);
        r102.setStackTrace(th.getStackTrace());
        UIThreadUtils.runOnUiThread(new c(this, r102));
        d r103 = new d(this, r110, r111, r210, r211, r212, r213, r214, r215);
        reportCreateAsyncSuccessEvent(r110, r111, r113, 3);
        return r103;
    L8:
        if (TraceEvent.isTracingStarted() == false) goto L10;
        String r104 = "UIOwner.createAsyncViewRunnable." + r111;     // Catch: Throwable -> L20
        TraceEvent.beginSection(r104);     // Catch: Throwable -> L20
        String r114 = r104;
    L11:
        LynxBaseUI r105 = createViewInterval(r100);     // Catch: Throwable -> L20
        LynxBaseUI[] r106 = {r105};     // Catch: Throwable -> L20
        UIShadowProxy r107 = consumeInitialPropsInterval(r105, r112);     // Catch: Throwable -> L20
        if (TraceEvent.isTracingStarted() == false) goto L14;
        TraceEvent.endSection(r114);     // Catch: Throwable -> L20
    L14:
        reportCreateAsyncSuccessEvent(r110, r111, true, 2);     // Catch: Throwable -> L20
        x0 r108 = r112;
        r113 = false;
        return new b(this, r111, r106, r107, r108, r110);
    L18:
        th = th;
        goto L22
    L10:
        r114 = null;
        goto L11
    L5:
        r112 = null;
        goto L6
    }

    public void updateLayout(int r410, int r411, int r412, int r413, int r414, int r510, int r511, int r512, int r513, int r514, int r515, int r516, int r517, int r518, int r519, int r610, int r611, Rect r612, float[] r613, float r614, int r615) {
        LynxUIOwner r100 = this;
        LynxBaseUI r110 = r100.mUIHolder.get(Integer.valueOf(r410));
        if (r110 != null) goto L6;
        LynxError r101 = new LynxError(60301, "Can't find ui tag");
        r101.addCustomInfo("node_index", Integer.toString(r615));
        r100.mContext.handleLynxError(r101);
        return;
    L6:
        boolean r111 = r110 instanceof UIShadowProxy;
        if (r111 == false) goto L9;
        LynxBaseUI r102 = ((UIShadowProxy) r110).f382373a;
    L10:
        r102.updateLayoutSize(r413, r414);
        if (r110.getLayoutAnimator() == null) goto L14;
        r110.getLayoutAnimator().i(r411, r412, r413, r414, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612);
    L14:
        u6a.a r112 = r110.getTransitionAnimator();
        Animation r113 = null;
        if (TraceEvent.isTracingStarted() == false) goto L17;
        String r103 = "UIOwner.updateLayout." + r110.getTagName();
        TraceEvent.beginSection(r103);
        String r210 = r103;
    L18:
        if (r112 == null) goto L155;
        if (r112.f548952j.size() != 0) goto L22;
    L34:
        boolean r104 = false;
    L35:
        if (r104 == false) goto L155;
        if (r100.mIsFirstLayout == true) goto L155;
        if (r110.isFirstAnimatedReady() == true) goto L155;
        if (r111 == false) goto L42;
        LynxBaseUI r105 = r110;
        LynxUI r106 = (LynxUI) ((UIShadowProxy) r105).f382373a;
    L44:
        if ((r106 instanceof LynxUI) == false) goto L153;
        LynxBaseUI r107 = r112.f548949g;
        if (r107 == null) goto L49;
        LynxBaseUI r114 = r107;
    L51:
        if (r114.getOriginLeft() == r15) goto L53;
        boolean r115 = true;
    L55:
        if (r114.getOriginTop() == r412) goto L57;
        boolean r116 = true;
    L59:
        if (r114.getWidth() == r413) goto L61;
        boolean r117 = true;
    L63:
        if (r114.getHeight() == r414) goto L65;
        boolean r211 = true;
    L67:
        if ((r114.getOriginLeft() + r114.getWidth()) != (r411 + r413)) goto L69;
        boolean r415 = true;
    L71:
        if ((r114.getOriginTop() + r114.getHeight()) != (r412 + r414)) goto L73;
        boolean r416 = true;
    L74:
        r114.onBeforeAnimation(r411, r412, r413, r414, r510, r511, r512, r513);
        if (r112.c(256) == false) goto L77;
    L80:
        boolean r108 = true;
    L82:
        if (r112.c(512) == false) goto L84;
    L87:
        boolean r109 = true;
    L88:
        boolean r118 = r112.c(16);
        boolean r119 = r112.c(32);
        if (r108 == false) goto L91;
        if (r115 == false) goto L91;
    L93:
        int r212 = r114.getOriginLeft();
    L95:
        if (r109 == false) goto L97;
        if (r116 == false) goto L97;
    L99:
        int r213 = r114.getOriginTop();
    L101:
        if (r117 == false) goto L104;
        if (r118 == false) goto L104;
        int r214 = r114.getWidth();
    L105:
        if (r211 == false) goto L108;
        if (r119 == false) goto L108;
        int r215 = r114.getHeight();
    L109:
        r112.f(256);
        r112.f(1024);
        r112.f(512);
        r112.f(2048);
        r112.f(32);
        r112.f(16);
        r114.updateLayout(r212, r213, r214, r215, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612);
        HashMap r120 = new HashMap();
        int r121 = 0;
    L111:
        if (r121 >= r112.f548952j.size()) goto L150;
        s6a.a r122 = r112.f548952j.valueAt(r121);
        int r123 = r122.f540863d;
        if ((r123 & 3888) == 0) goto L148;
        if (r123 == 16) goto L138;
        if (r123 == 32) goto L127;
        if (r123 == 256) goto L125;
        if (r123 == 512) goto L123;
        if (r123 == 1024) goto L125;
        if (r123 != 2048) goto L148;
    L123:
        if (r116 == false) goto L148;
        r120.put(Integer.valueOf(r122.f540863d), r112.d(r122.f540863d, r114, r114.getOriginTop(), r412, r122, true));
    L125:
        if (r115 == false) goto L148;
        r120.put(Integer.valueOf(r122.f540863d), r112.d(r122.f540863d, r114, r114.getOriginLeft(), r411, r122, true));
        goto L148
    L127:
        if (r211 == false) goto L148;
        AnimatorSet r124 = new AnimatorSet();
        ArrayList r125 = new ArrayList();
        r125.add(r112.d(32, r114, r114.getHeight(), r414, r122, true));
        if (r116 == false) goto L133;
        if (r416 == false) goto L133;
        if (r109 == true) goto L133;
        boolean r126 = true;
    L134:
        if (r126 == false) goto L136;
        r125.add(r112.d(512, r114, r114.getOriginTop(), r412, r122, false));
    L136:
        r124.playTogether(r125);
        r120.put(32, r124);
    L133:
        r126 = false;
        goto L134
    L138:
        if (r117 == false) goto L148;
        AnimatorSet r127 = new AnimatorSet();
        ArrayList r128 = new ArrayList();
        r128.add(r112.d(16, r114, r114.getWidth(), r413, r122, true));
        if (r115 == false) goto L144;
        if (r415 == false) goto L144;
        if (r108 == true) goto L144;
        boolean r129 = true;
    L145:
        if (r129 == false) goto L147;
        r128.add(r112.d(256, r114, r114.getOriginLeft(), r411, r122, false));
    L147:
        r127.playTogether(r128);
        r120.put(16, r127);
    L144:
        r129 = false;
    L148:
        r121 = r121 + 1;
        goto L111
    L150:
        if (r120.isEmpty() == true) goto L152;
        r112.f548951i.putAll(r120);
    L152:
        r112.f548943a = r411;
        r112.f548944b = r412;
        r112.f548945c = r413;
        r112.f548946d = r414;
    L108:
        r215 = r414;
    L104:
        r214 = r413;
    L97:
        if (r119 == false) goto L100;
        if (r416 == true) goto L99;
    L100:
        r213 = r412;
    L91:
        if (r118 == false) goto L94;
        if (r415 == true) goto L93;
    L94:
        r212 = r411;
        goto L95
    L84:
        if (r112.c(2048) == true) goto L87;
        r109 = false;
        goto L88
    L77:
        if (r112.c(1024) == true) goto L80;
        r108 = false;
        goto L82
    L73:
        r416 = false;
        goto L74
    L69:
        r415 = false;
        goto L71
    L65:
        r211 = false;
        goto L67
    L61:
        r117 = false;
        goto L63
    L57:
        r116 = false;
        goto L59
    L53:
        r115 = false;
        goto L55
    L49:
        r114 = r106;
    L153:
        r100.mUIBody.invalidate();
        LynxBaseUI r616 = r105;
    L237:
        LynxBaseUI r130 = r616;
        r130.updateSticky(r100.normalizeStickyInfo(r613));
        r130.updateMaxHeight(r614);
        r100.insertA11yMutationEvent(3, r130);
        if (TraceEvent.isTracingStarted() == false) goto L246;
        TraceEvent.endSection(r210);
        return;
    L246:
        return;
    L42:
        r105 = r110;
        r106 = (LynxUI) r105;
        goto L44
    L22:
        if (r112.c(256) == false) goto L24;
    L33:
        r104 = true;
        goto L35
    L24:
        if (r112.c(1024) == true) goto L33;
        if (r112.c(512) == true) goto L33;
        if (r112.c(2048) == true) goto L33;
        if (r112.c(16) == true) goto L33;
        if (r112.c(32) == false) goto L34;
    L155:
        if (r110.enableLayoutAnimation() == true) goto L157;
    L235:
        r616 = r110;
        r616.updateLayout(r411, r412, r413, r414, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612);
        goto L237
    L157:
        if (r100.mIsFirstLayout == true) goto L235;
        int r131 = r100.mRootSign;
        if (r410 != r131) goto L163;
        if (r410 != r131) goto L235;
        if (r100.mIsRootLayoutAnimationRunning == false) goto L235;
    L163:
        t6a.c r132 = r110.getLayoutAnimator();
        if (r111 == 0) goto L166;
        LynxBaseUI r133 = r110;
        LynxUI r134 = (LynxUI) ((UIShadowProxy) r133).f382373a;
    L167:
        LynxUI r135 = r134;
        r132.getClass();
        View r216 = r135.getView();
        r132.f544703a = new WeakReference(r135);
        r616 = r133;
        r132.i(r411, r412, r413, r414, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612);
        if (r132.f544726x != (-1.0f)) goto L171;
        if (r216 == null) goto L171;
        r132.f544726x = r216.getAlpha();
    L171:
        int r136 = r135.getSign();
        t6a.f r137 = r132.f544725w.get(r136);
        if (r137 == null) goto L181;
        if (r216 != null) goto L175;
    L178:
        r132.f544725w.remove(r136);
        goto L181
    L175:
        if (r216.getAnimation() == null) goto L178;
        r137.a(r411, r412, r413, r414);
    L177:
        r100 = this;
        r100.mUIBody.invalidate();
    L181:
        if (r135.getWidth() == 0) goto L183;
    L185:
        t6a.a r138 = r132.f544723u;
    L186:
        t6a.e r139 = r132.f544724v;
        if (r139 != null) goto L189;
    L199:
        t6a.e r140 = r132.f544724v;
        if (r140 != null) goto L202;
    L203:
        if (r413 != 0) goto L206;
        if (r414 != 0) goto L206;
        r135.updateLayout(r411, r412, r413, r414, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612);
    L206:
        if (r138 == null) goto L209;
        r113 = r138.a(r135, r411, r412, r413, r414, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r132.f544726x);
    L209:
        Animation r141 = r113;
        if ((r141 instanceof TranslateAnimation) == true) goto L212;
    L214:
        View r142 = r216;
        if (r141 != null) goto L224;
        float r143 = r132.f544726x;
        if (r143 == (-1.0f)) goto L219;
        r142.setAlpha(r143);
    L219:
        WeakReference<LynxUI> r144 = r132.f544703a;
        if (r144 == null) goto L222;
        r144.clear();
    L222:
        r11.updateLayout(r411, r412, r413, r414, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612);
        goto L177
    L224:
        if (r11.getWidth() == 0) goto L226;
    L228:
        r141.setAnimationListener(new t6a.c.a(r132, "layout-animation-update"));
        r132.b(r142, "layout-animation-update");
    L230:
        if ((r141 instanceof t6a.f) == false) goto L232;
        r11.requestLayout();
    L233:
        r11.onBeforeAnimation(r411, r412, r413, r414, r510, r511, r512, r513);
        r142.startAnimation(r141);
        goto L177
    L232:
        r11.updateLayout(r411, r412, r413, r414, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612);
        goto L233
    L226:
        if (r11.getHeight() != 0) goto L228;
        r141.setAnimationListener(new t6a.c.a(r132, "layout-animation-create"));
        r132.b(r142, "layout-animation-create");
        goto L230
    L212:
        if ((r11.getParent() instanceof UIShadowProxy) == false) goto L214;
        r216 = ((LynxUI) r135.getParent()).getView();
        goto L214
    L202:
        if (r140.c() == true) goto L206;
    L189:
        if (r139.c() == false) goto L199;
        if (r413 != 0) goto L199;
        if (r414 != 0) goto L199;
        View r145 = r135.getView();
        if (r145 == null) goto L177;
        r132.f544703a = new WeakReference(r135);
        Animation r146 = r132.f544724v.a(r135, r145.getLeft(), r145.getTop(), r145.getWidth(), r145.getHeight(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, new Rect(), r132.f544726x);
        if (r146 != null) goto L198;
        r135.updateLayout(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, new Rect());
        goto L177
    L198:
        r146.setAnimationListener(new t6a.c.a(r132, "layout-animation-delete"));
        r132.b(r145, "layout-animation-delete");
        r145.startAnimation(r146);
        goto L177
    L183:
        if (r135.getHeight() != 0) goto L185;
        r138 = r132.f544722t;
        goto L186
    L166:
        r133 = r110;
        r134 = (LynxUI) r133;
        goto L167
    L17:
        r210 = null;
        goto L18
    L9:
        r102 = r110;
        goto L10
    }

    public void updateLayout(int r100, int r101, int r102, int r103, int r104, int r105, int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r118, int r119, int r210, Rect r211, float[] r212, float r213, int r214, boolean r215) {
        LynxBaseUI r106 = this.mUIHolder.get(Integer.valueOf(r100));
        if (r106 == null) goto L5;
        r106.setDisplayNone(r215);
    L5:
        updateLayout(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214);
    }
}
