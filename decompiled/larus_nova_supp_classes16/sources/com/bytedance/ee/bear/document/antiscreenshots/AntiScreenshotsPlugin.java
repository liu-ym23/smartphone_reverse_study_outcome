package com.bytedance.ee.bear.document.antiscreenshots;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.AntiScreenshotsViewModel;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.documentinfo.BlockInfo;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.lark.dependency.g;
import com.bytedance.ee.bear.lark.dependency.i0;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleonv2.container.webcontainer.util.ContainerType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0002'*\u0018\u0000 @2\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J2\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u0007H\u0002J\b\u0010.\u001a\u00020\u0017H\u0002J\u0010\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u0007H\u0002J\u0012\u00101\u001a\u00020\u00072\b\b\u0002\u00102\u001a\u00020\u0007H\u0002J\u0012\u00103\u001a\u00020\u00172\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u001c\u00106\u001a\u00020\u00172\b\u00104\u001a\u0004\u0018\u0001052\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u001c\u00109\u001a\u00020\u00172\b\u00104\u001a\u0004\u0018\u0001052\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0012\u0010:\u001a\u00020\u00172\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u0010;\u001a\u00020\u0007H\u0002J\b\u0010<\u001a\u00020\u0017H\u0002J\b\u0010=\u001a\u00020\u0017H\u0002J\u0012\u0010>\u001a\u00020\u00172\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0012\u0010?\u001a\u00020\u00172\b\u00104\u001a\u0004\u0018\u000105H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(R\u0010\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0004\n\u0002\u0010+¨\u0006A"}, d2 = {"Lcom/bytedance/ee/bear/document/antiscreenshots/AntiScreenshotsPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "<init>", "()V", "TAG", "", "canCopy", "", "isShown", "loadSuccess", "contentContainer", "Landroid/view/ViewGroup;", "enableScreenshotsLivaData", "Landroidx/lifecycle/MutableLiveData;", "", "windowFocused", "viewTreeObserverRef", "Ljava/lang/ref/WeakReference;", "Landroid/view/ViewTreeObserver;", "windowFocusListener", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "permissionChangeObserver", "Lkotlin/Function1;", "", "isOfflineStart", "documentInfoDtaObserver", "Lcom/bytedance/ee/bear/document/documentinfo/DocumentInfo;", "offlineInfoDtaObserver", "onPermissionChange", "documentInfo", "permissionCheck", "token", "type", "Lcom/ss/android/lark/docs/icon/util/DocumentType;", "tenantId", "ownerUserId", "userPerm", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocUserPermission;", "onGlobalLayoutListener", "com/bytedance/ee/bear/document/antiscreenshots/AntiScreenshotsPlugin$onGlobalLayoutListener$1", "Lcom/bytedance/ee/bear/document/antiscreenshots/AntiScreenshotsPlugin$onGlobalLayoutListener$1;", "loadingCallback", "com/bytedance/ee/bear/document/antiscreenshots/AntiScreenshotsPlugin$loadingCallback$1", "Lcom/bytedance/ee/bear/document/antiscreenshots/AntiScreenshotsPlugin$loadingCallback$1;", "updateLoadSuccess", "success", "updateScreenshotsEnable", "setScreenshotsEnable", "enable", "checkWindowFocus", "log", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "onDetachFromHost", "getCurrentActivityEnable", "recordStateWhenAttach", "restoreStateWhenDetach", "onStart", "onStop", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AntiScreenshotsPlugin extends DocumentPluginV2 {
    public static final a Companion = null;
    private static final String FG_KEY_ON_PAUSE_NO_ANTI_SCREENSHOTS = "ccm.mobile.on_pause_no_anti_screenshots";
    private static final int FLAG_STATE_NONE = -1;
    private static final int FLAG_STATE_ORIGINAL = 0;
    private static final String SCS_FLAG_STATE = "SCS_FLAG_STATE";
    private static final Map<Integer, Integer> attachedPluginCountMap = null;
    private static final Map<Integer, Integer> originScsFlagStateMap = null;
    private final String TAG;
    private boolean canCopy;
    private ViewGroup contentContainer;
    private final Function1<DocumentInfo, Unit> documentInfoDtaObserver;
    private MutableLiveData<Integer> enableScreenshotsLivaData;
    private boolean isShown;
    private boolean loadSuccess;
    private final b loadingCallback;
    private final Function1<DocumentInfo, Unit> offlineInfoDtaObserver;
    private final d onGlobalLayoutListener;
    private final Function1<Boolean, Unit> permissionChangeObserver;
    private WeakReference<ViewTreeObserver> viewTreeObserverRef;
    private ViewTreeObserver.OnWindowFocusChangeListener windowFocusListener;
    private boolean windowFocused;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements x2.b {
        public final /* synthetic */ AntiScreenshotsPlugin a;

        @Override // com.bytedance.ee.bear.document.x2.b
        public final /* synthetic */ void onLoadCancel() {
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final /* synthetic */ void onSSRLoadSuccess() {
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadStart() {
            tt5.a.h(AntiScreenshotsPlugin.access$getTAG$p(this.a), "onLoadStart()...");
            AntiScreenshotsPlugin.access$updateLoadSuccess(this.a, false);
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadSuccess() {
            tt5.a.h(AntiScreenshotsPlugin.access$getTAG$p(this.a), "onLoadSuccess()...");
            AntiScreenshotsPlugin.access$updateLoadSuccess(this.a, true);
        }

        public b(AntiScreenshotsPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadFail(int r1, Throwable r2) {
            tt5.a.h(AntiScreenshotsPlugin.access$getTAG$p(this.a), "onLoadFail()...");
            AntiScreenshotsPlugin.access$updateLoadSuccess(this.a, false);
        }
    }

    public static final class c implements ViewTreeObserver.OnWindowFocusChangeListener {
        public final /* synthetic */ AntiScreenshotsPlugin a;
        public final /* synthetic */ t b;

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public final void onWindowFocusChanged(boolean r2) {
            if (r2 == false) goto L12;
            tt5.a.h(AntiScreenshotsPlugin.access$getTAG$p(this.a), "onWindowFocusChanged true");
            AntiScreenshotsPlugin.access$setWindowFocused$p(this.a, true);
            t r3 = this.b;
            if (r3 == null) goto L10;
            View r4 = r3.getContentView();
            if (r4 == null) goto L10;
            ViewTreeObserver r5 = r4.getViewTreeObserver();
            if (r5 == null) goto L10;
            r5.removeOnWindowFocusChangeListener(AntiScreenshotsPlugin.access$getWindowFocusListener$p(this.a));
        L10:
            AntiScreenshotsPlugin.access$setWindowFocusListener$p(this.a, null);
            AntiScreenshotsPlugin.access$updateScreenshotsEnable(this.a);
            return;
        }

        public c(AntiScreenshotsPlugin r1, t r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ AntiScreenshotsPlugin a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (AntiScreenshotsPlugin.access$getContentContainer$p(this.a) != null) goto L6;
            tt5.a.k(AntiScreenshotsPlugin.access$getTAG$p(this.a), "onGlobalLayoutListener()... contentContainer is null!");
            return;
        L6:
            ViewGroup r0 = AntiScreenshotsPlugin.access$getContentContainer$p(this.a);
            Intrinsics.checkNotNull(r0);
            boolean r1 = r0.isShown();
            if (r1 == AntiScreenshotsPlugin.access$isShown$p(this.a)) goto L10;
            AntiScreenshotsPlugin.access$setShown$p(this.a, r1);
            tt5.a.h(AntiScreenshotsPlugin.access$getTAG$p(this.a), "isShown changed " + AntiScreenshotsPlugin.access$isShown$p(this.a));
            AntiScreenshotsPlugin.access$updateScreenshotsEnable(this.a);
            return;
        }

        public d(AntiScreenshotsPlugin r1) {
            this.a = r1;
        }
    }

    public static final class e implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public e(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    static {
        Companion = new a();
        attachedPluginCountMap = new LinkedHashMap();
        originScsFlagStateMap = new LinkedHashMap();
    }

    private final boolean isOfflineStart() {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.f() == true) goto L5;
    L7:
        return false;
    L5:
        if (j.a.a.getNetworkState().a() == true) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateScreenshotsEnable() {
        boolean r0 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).getSwitchStatusFromCurrentApp();
        String r2 = this.TAG;
        StringBuilder r3 = new StringBuilder("updateScreenshotsEnable()... canCopy = ");
        r3.append(this.canCopy);
        r3.append(", isShown = ");
        r3.append(this.isShown);
        r3.append(", loadSuccess = ");
        r3.append(this.loadSuccess);
        r3.append(", checkWindowFocus() = ");
        boolean r4 = 0;
        r4 = 0;
        r3.append(checkWindowFocus$default(this, false, 1, null));
        r3.append(", windowFocused = ");
        r3.append(this.windowFocused);
        r3.append(", globalProtectionOn = ");
        r3.append(r0);
        tt5.a.h(r2, r3.toString());
        if (r0 == false) goto L9;
        setScreenshotsEnable(false);
        MutableLiveData<Integer> r1 = this.enableScreenshotsLivaData;
        if (r1 == null) goto L23;
        r1.postValue(2);
        return;
    L23:
        return;
    L9:
        if (this.canCopy == false) goto L11;
    L18:
        r4 = 1;
    L19:
        setScreenshotsEnable(r4);
        MutableLiveData<Integer> r5 = this.enableScreenshotsLivaData;
        if (r5 == null) goto L24;
        r5.postValue(Integer.valueOf(!r4));
        return;
    L24:
        return;
    L11:
        if (this.isShown == false) goto L18;
        if (this.loadSuccess == false) goto L18;
        if (checkWindowFocus$default(this, false, 1, null) == false) goto L19;
        if (this.windowFocused == true) goto L19;
        goto L18
    }

    public AntiScreenshotsPlugin() {
        this.TAG = "AntiScreenshotsPlugin@" + Integer.toHexString(hashCode());
        this.permissionChangeObserver = new AntiScreenshotsPlugin$permissionChangeObserver$1(this);
        this.documentInfoDtaObserver = new AntiScreenshotsPlugin$documentInfoDtaObserver$1(this);
        this.offlineInfoDtaObserver = new AntiScreenshotsPlugin$offlineInfoDtaObserver$1(this);
        this.onGlobalLayoutListener = new d(this);
        this.loadingCallback = new b(this);
    }

    private final boolean getCurrentActivityEnable() {
        if ((getActivity().getWindow().getAttributes().flags & 8192) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final void recordStateWhenAttach() {
        int r0 = getActivity().hashCode();
        Map<Integer, Integer> r1 = attachedPluginCountMap;
        Integer r2 = Integer.valueOf(r0);
        Integer r3 = r1.get(Integer.valueOf(r0));
        if (r3 == null) goto L5;
        int r4 = r3.intValue();
    L6:
        r1.put(r2, Integer.valueOf(r4 + 1));
        Map<Integer, Integer> r5 = originScsFlagStateMap;
        if (r5.get(Integer.valueOf(r0)) != null) goto L15;
        Integer r6 = Integer.valueOf(r0);
        Intent r7 = getActivity().getIntent();
        int r8 = -1;
        if (r7 == null) goto L11;
        r8 = r7.getIntExtra(SCS_FLAG_STATE, -1);
    L11:
        r5.put(r6, Integer.valueOf(r8));
        if (getActivity().getIntent() != null) goto L14;
        getActivity().setIntent(new Intent());
    L14:
        getActivity().getIntent().putExtra(SCS_FLAG_STATE, 0);
    L15:
        tt5.a.h(this.TAG, "recordStateWhenAttach()... attachedPluginCount = " + r1.get(Integer.valueOf(r0)) + ", originScsFlagState = " + r5.get(Integer.valueOf(r0)));
        return;
    L5:
        r4 = 0;
        goto L6
    }

    private final void restoreStateWhenDetach() {
        int r0 = getActivity().hashCode();
        if (getActivity().isFinishing() == false) goto L5;
    L25:
        tt5.a.h(this.TAG, "activity is finishing or destroyed, no need to restore");
        attachedPluginCountMap.remove(Integer.valueOf(r0));
        originScsFlagStateMap.remove(Integer.valueOf(r0));
        return;
    L5:
        if (getActivity().isDestroyed() == true) goto L25;
        Map<Integer, Integer> r1 = attachedPluginCountMap;
        Integer r2 = Integer.valueOf(r0);
        Integer r3 = r1.get(Integer.valueOf(r0));
        int r4 = 0;
        if (r3 == null) goto L10;
        int r5 = r3.intValue();
    L11:
        r1.put(r2, Integer.valueOf(r5 - 1));
        boolean r6 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).getSwitchStatusFromCurrentApp();
        String r7 = this.TAG;
        StringBuilder r8 = new StringBuilder("restoreStateWhenDetach()... attachedPluginCount = ");
        r8.append(r1.get(Integer.valueOf(r0)));
        r8.append(", originScsFlagState = ");
        Map<Integer, Integer> r9 = originScsFlagStateMap;
        r8.append(r9.get(Integer.valueOf(r0)));
        r8.append(", switchStatusFromCurrentApp = ");
        r8.append(r6);
        tt5.a.h(r7, r8.toString());
        Integer r10 = r1.get(Integer.valueOf(r0));
        if (r10 == null) goto L14;
        r4 = r10.intValue();
    L14:
        if (r4 > 0) goto L27;
        setScreenshotsEnable(!r6);
        Integer r11 = r9.get(Integer.valueOf(r0));
        if (r11 == null) goto L18;
        int r12 = r11.intValue();
    L20:
        if (r12 != (-1)) goto L22;
        getActivity().getIntent().removeExtra(SCS_FLAG_STATE);
    L23:
        r1.remove(Integer.valueOf(r0));
        r9.remove(Integer.valueOf(r0));
        return;
    L22:
        Intrinsics.checkNotNull(getActivity().getIntent().putExtra(SCS_FLAG_STATE, r12));
        goto L23
    L18:
        r12 = -1;
        goto L20
    L27:
        return;
    L10:
        r5 = 0;
        goto L11
    }

    public static boolean INVOKEVIRTUAL_com_bytedance_ee_bear_document_antiscreenshots_AntiScreenshotsPlugin_com_larus_home_impl_utils_DecorViewLancet_hasWindowFocus(FragmentActivity r3) {
        boolean r4 = r3.hasWindowFocus();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "hasWindowFocus");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "hasWindowFocus");
    L7:
        return r4;
    }

    public static final /* synthetic */ ViewGroup access$getContentContainer$p(AntiScreenshotsPlugin r0) {
        return r0.contentContainer;
    }

    public static final /* synthetic */ String access$getTAG$p(AntiScreenshotsPlugin r0) {
        return r0.TAG;
    }

    public static final /* synthetic */ ViewTreeObserver.OnWindowFocusChangeListener access$getWindowFocusListener$p(AntiScreenshotsPlugin r0) {
        return r0.windowFocusListener;
    }

    public static final /* synthetic */ boolean access$isOfflineStart(AntiScreenshotsPlugin r0) {
        return r0.isOfflineStart();
    }

    public static final /* synthetic */ boolean access$isShown$p(AntiScreenshotsPlugin r0) {
        return r0.isShown;
    }

    public static final /* synthetic */ void access$updateScreenshotsEnable(AntiScreenshotsPlugin r0) {
        r0.updateScreenshotsEnable();
    }

    private final boolean checkWindowFocus(boolean r5) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 31) goto L5;
        boolean r1 = true;
    L6:
        if (r5 == false) goto L8;
        tt5.a.h(this.TAG, "checkWindowFocus()... sdk = " + r0 + ", res = " + r1);
    L8:
        return r1;
    L5:
        r1 = false;
        goto L6
    }

    private final void onPermissionChange(DocumentInfo r12) {
        tt5.a.h(this.TAG, "onPermissionChange");
        boolean r0 = this.canCopy;
        boolean r3 = true;
        boolean r4 = false;
        if (com.bytedance.ee.bear.middleground.permission.b.g() == false) goto L36;
        Iterator<T> r1 = r12.getBlockInfos().keySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L35;
        String r6 = (String) r1.next();
        BlockInfo r2 = r12.getBlockInfo(r6);
        if (r2 == null) goto L10;
        Integer r7 = r2.getType();
    L11:
        if (r2 == null) goto L13;
        String r8 = r2.getCreatorTenantId();
    L14:
        if (r2 == null) goto L16;
        String r9 = r2.getOwnerUserId();
    L17:
        DocViewModel r5 = getDocViewModel();
        if (r5 == null) goto L24;
        ConcurrentHashMap<String, Boolean> r10 = r5.getDeleteCacheMap();
        if (r10 == null) goto L24;
        Boolean r11 = r10.get(r6);
        if (r11 == null) goto L24;
        boolean r13 = r11.booleanValue();
    L25:
        if (r13 == true) goto L26;
        if (r7 == null) goto L34;
        if (r8 == null) goto L34;
        boolean r14 = permissionCheck(r6, sbb.e.d(r7.intValue()), r8, r9, r12.getDocPermissionByToken(r6));
        tt5.a.h(this.TAG, "docscreenshot start changed. docCanCopy = " + r14 + ", " + r13 + r12.hashCode());
        if (r14 == false) goto L33;
        r0 = r14;
        goto L6
    L33:
        r4 = r14;
    L51:
        if (r4 == this.canCopy) goto L63;
        this.canCopy = r4;
        updateScreenshotsEnable();
        return;
    L63:
        return;
    L34:
        tt5.a.d(this.TAG, "block info error " + r7 + "  " + r8);
        goto L51
    L26:
        tt5.a.h(this.TAG, "documentInfo changed. docCanCopy isDeleted " + r13);
        r0 = true;
    L24:
        r13 = false;
        goto L25
    L16:
        r9 = null;
        goto L17
    L13:
        r8 = null;
        goto L14
    L10:
        r7 = null;
        goto L11
    L35:
        r4 = r0;
        goto L51
    L36:
        DocViewModel r16 = getDocViewModel();
        if (r16 == null) goto L43;
        ConcurrentHashMap<String, Boolean> r17 = r16.getDeleteCacheMap();
        if (r17 == null) goto L43;
        Boolean r18 = r17.get(r12.getObjToken());
        if (r18 == null) goto L43;
        boolean r19 = r18.booleanValue();
    L45:
        if (permissionCheck(r12.getObjToken(), sbb.e.d(r12.getType()), r12.getCreatorTenantId(), r12.getOwnerUid(), r12.getDocPermission().a) == true) goto L49;
        if (r19 == true) goto L49;
        r3 = false;
    L49:
        tt5.a.h(this.TAG, "documentInfo changed. docCanCopy = " + r3 + ", " + r19);
        r4 = r3;
    L43:
        r19 = false;
        goto L45
    }

    private final void setScreenshotsEnable(boolean r5) {
        boolean r0 = getCurrentActivityEnable();
        tt5.a.h(this.TAG, "setScreenshotsEnable()... enable = " + r5 + ", currentActivityEnable = " + r0);
        if (r0 != r5) goto L6;
        return;
    L6:
        if (r5 == false) goto L8;
        getHost().getActivity().getWindow().clearFlags(8192);
        return;
    L8:
        getHost().getActivity().getWindow().addFlags(8192);
    }

    private final void updateLoadSuccess(boolean r2) {
        if (r2 == this.loadSuccess) goto L6;
        this.loadSuccess = r2;
        updateScreenshotsEnable();
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r5) {
        super.onAttachToHost(r5);
        tt5.a.h(this.TAG, "onAttachToHost()...");
        recordStateWhenAttach();
        this.enableScreenshotsLivaData = ((AntiScreenshotsViewModel) new ViewModelProvider(getActivity()).get(AntiScreenshotsViewModel.class)).getEnableScreenshotsLivaData();
        ((w05.b) getHostAbility(w05.b.class)).getDocumentInfoProvider().g().observe(getLifecycleOwner(), new e(this.documentInfoDtaObserver));
        ((w05.b) getHostAbility(w05.b.class)).getDocumentInfoProvider().h().observe(getLifecycleOwner(), new e(this.offlineInfoDtaObserver));
        if ((r5 instanceof DocumentPluginHost) == false) goto L5;
        DocumentPluginHost r6 = (DocumentPluginHost) r5;
    L6:
        if (r6 == null) goto L12;
        DocViewModel r7 = r6.a();
        if (r7 == null) goto L12;
        MutableLiveData<Boolean> r8 = r7.getPermissionUpdate();
        if (r8 == null) goto L12;
        r8.observe(getLifecycleOwner(), new e(this.permissionChangeObserver));
    L12:
        getEditorAbility().getDocumentLoader().S3(this.loadingCallback);
        updateScreenshotsEnable();
        DocumentInfo r9 = (DocumentInfo) ((w05.b) getHostAbility(w05.b.class)).getDocumentInfoProvider().g().getValue();
        if (r9 == null) goto L16;
        onPermissionChange(r9);
        return;
    L16:
        return;
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r4) {
        super.onDetachFromHost(r4);
        tt5.a.h(this.TAG, "onDetachFromHost()...");
        ((w05.b) getHostAbility(w05.b.class)).getDocumentInfoProvider().g().removeObserver(new e(this.documentInfoDtaObserver));
        ((w05.b) getHostAbility(w05.b.class)).getDocumentInfoProvider().h().removeObserver(new e(this.offlineInfoDtaObserver));
        if ((r4 instanceof DocumentPluginHost) == false) goto L5;
        DocumentPluginHost r5 = (DocumentPluginHost) r4;
    L6:
        if (r5 == null) goto L12;
        DocViewModel r6 = r5.a();
        if (r6 == null) goto L12;
        MutableLiveData<Boolean> r7 = r6.getPermissionUpdate();
        if (r7 == null) goto L12;
        r7.removeObserver(new e(this.permissionChangeObserver));
    L12:
        getEditorAbility().getDocumentLoader().S(this.loadingCallback);
        restoreStateWhenDetach();
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onStart(PluginHost r2) {
        tt5.a.h(this.TAG, "onStart()...");
        updateScreenshotsEnable();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onStop(PluginHost r7) {
        super.onStop(r7);
        Fragment r1 = null;
        boolean r0 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).getSwitchStatusFromCurrentApp();
        boolean r2 = com.bytedance.ee.bear.appsetting.c.a.a.g(FG_KEY_ON_PAUSE_NO_ANTI_SCREENSHOTS);
        tt5.a.h(this.TAG, "onPause() called with: host = " + r7 + " globalProtectionOn:" + r0 + " fgOn:" + r2);
        if (getActivity() == null) goto L5;
        ((g) LarkContext.spiByDwarf(g.class)).D0();
    L5:
        if (r2 == false) goto L10;
        if (r7 == null) goto L8;
        r1 = r7.getHostFragment();
    L8:
        ForsetiHelper.s(r1);
        return;
    }

    public static final /* synthetic */ void access$onPermissionChange(AntiScreenshotsPlugin r0, DocumentInfo r1) {
        r0.onPermissionChange(r1);
    }

    public static final /* synthetic */ void access$setShown$p(AntiScreenshotsPlugin r0, boolean r1) {
        r0.isShown = r1;
    }

    public static final /* synthetic */ void access$setWindowFocusListener$p(AntiScreenshotsPlugin r0, ViewTreeObserver.OnWindowFocusChangeListener r1) {
        r0.windowFocusListener = r1;
    }

    public static final /* synthetic */ void access$setWindowFocused$p(AntiScreenshotsPlugin r0, boolean r1) {
        r0.windowFocused = r1;
    }

    public static final /* synthetic */ void access$updateLoadSuccess(AntiScreenshotsPlugin r0, boolean r1) {
        r0.updateLoadSuccess(r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r4, t r5) {
        super.onAttachToUIContainer(r4, r5);
        if (checkWindowFocus(true) == false) goto L20;
        boolean r1 = false;
        if (r4 == null) goto L11;
        FragmentActivity r2 = r4.getActivity();
        if (r2 == null) goto L11;
        if (INVOKEVIRTUAL_com_bytedance_ee_bear_document_antiscreenshots_AntiScreenshotsPlugin_com_larus_home_impl_utils_DecorViewLancet_hasWindowFocus(r2) != true) goto L11;
        r1 = true;
    L11:
        if (r1 == false) goto L13;
        tt5.a.h(this.TAG, "activity window focus is already true");
        this.windowFocused = true;
        updateScreenshotsEnable();
        goto L20
    L13:
        this.windowFocusListener = new c(this, r5);
        if (r5 == null) goto L20;
        View r6 = r5.getContentView();
        if (r6 == null) goto L20;
        ViewTreeObserver r7 = r6.getViewTreeObserver();
        if (r7 == null) goto L20;
        r7.addOnWindowFocusChangeListener(this.windowFocusListener);
    L20:
        ViewGroup r8 = null;
        if (r4 == null) goto L23;
        ViewGroup r9 = r4.getContainer(ContainerType.Web.getValue());
    L25:
        if ((r9 instanceof ViewGroup) == false) goto L27;
        r8 = r9;
    L27:
        this.contentContainer = r8;
        if (r8 != null) goto L31;
        tt5.a.d(this.TAG, "webContainer is null!");
        return;
    L31:
        Intrinsics.checkNotNull(r8);
        r8.getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
        ViewGroup r10 = this.contentContainer;
        Intrinsics.checkNotNull(r10);
        this.viewTreeObserverRef = new WeakReference(r10.getViewTreeObserver());
        return;
    L23:
        r9 = null;
        goto L25
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r4, t r5) {
        ViewGroup r6 = this.contentContainer;
        if (r6 == null) goto L7;
        ViewTreeObserver r7 = r6.getViewTreeObserver();
        if (r7 == null) goto L7;
        r7.removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
    L7:
        WeakReference<ViewTreeObserver> r8 = this.viewTreeObserverRef;
        if (r8 == null) goto L14;
        ViewTreeObserver r9 = r8.get();
        if (r9 == null) goto L14;
        if (r9.isAlive() == false) goto L14;
        r9.removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
    L14:
        this.contentContainer = null;
        this.viewTreeObserverRef = null;
        tt5.a.h(this.TAG, "onDetachFromUIContainer: windowFocusListener:" + this.windowFocusListener);
        if (this.windowFocusListener == null) goto L24;
        if (r5 == null) goto L22;
        View r10 = r5.getContentView();
        if (r10 == null) goto L22;
        ViewTreeObserver r11 = r10.getViewTreeObserver();
        if (r11 == null) goto L22;
        r11.removeOnWindowFocusChangeListener(this.windowFocusListener);
    L22:
        this.windowFocusListener = null;
        return;
    }

    public static /* synthetic */ boolean checkWindowFocus$default(AntiScreenshotsPlugin r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.checkWindowFocus(r1);
    }

    private final boolean permissionCheck(String r8, sbb.e r9, String r10, String r11, IDocUserPermission r12) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L6;
        int r0 = f35.b.a;
        return f35.b.d(r8, r9, r10, BizDomain.FileBizDomainCCM, r12, r11).getAllow();
    L6:
        boolean r13 = r12.canCopy();
        boolean r14 = ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g("CCM_CONTENT_COPY", FileBizDomain.FileBizDomainCCM, r9.b, r8).a;
        boolean r16 = TextUtils.isEmpty(((com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.d.class, null, null, 6)).a(r8, r9.b, "CCM_CONTENT_COPY", "", r10));
        tt5.a.h(this.TAG, "documentInfo changed. docCanCopy = " + r13 + ", adminCanCopy = " + r14 + ", old canCopy = " + this.canCopy + ", dlpCanCopy=" + r16);
        if (r13 == false) goto L11;
        if (r14 == false) goto L11;
        if (r16 == false) goto L11;
        return true;
    L11:
        return false;
    }
}
