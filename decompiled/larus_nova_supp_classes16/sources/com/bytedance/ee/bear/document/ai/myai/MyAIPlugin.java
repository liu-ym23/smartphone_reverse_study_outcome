package com.bytedance.ee.bear.document.ai.myai;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.BasePermissionChangePlugin;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.PermissionPlugin;
import com.bytedance.ee.bear.document.oops.OopsPluginV2;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.drive.biz.versions.model.VersionPayLoadData;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.lark.dependency.e0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0005;<=>?B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010&\u001a\u00020'J \u0010(\u001a\u00020'2\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020+\u0012\b\u0012\u0006\u0012\u0002\b\u00030,0*H\u0016J\u0012\u0010/\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0012\u00102\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u00020'J\u0006\u00106\u001a\u00020'J\b\u00107\u001a\u000204H\u0016J\b\u00108\u001a\u00020'H\u0002J\u0010\u00109\u001a\u00020'2\u0006\u0010:\u001a\u000204H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/myai/MyAIPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "Lcom/bytedance/ee/bear/document/orientation/OrientationSupportPanel;", "<init>", "()V", "aiDependency", "Lcom/bytedance/ee/bear/lark/dependency/IQuickLaunchBarAIDependency;", "getAiDependency", "()Lcom/bytedance/ee/bear/lark/dependency/IQuickLaunchBarAIDependency;", "aiDependency$delegate", "Lkotlin/Lazy;", "mCallback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "getMCallback", "()Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "setMCallback", "(Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;)V", "myAIPageControl", "Lcom/ss/android/lark/myai/export/MyAIPageControl;", "getMyAIPageControl", "()Lcom/ss/android/lark/myai/export/MyAIPageControl;", "setMyAIPageControl", "(Lcom/ss/android/lark/myai/export/MyAIPageControl;)V", "mDocContext", "Lcom/bytedance/ee/bear/document/ai/myai/DocContext;", "getMDocContext", "()Lcom/bytedance/ee/bear/document/ai/myai/DocContext;", "setMDocContext", "(Lcom/bytedance/ee/bear/document/ai/myai/DocContext;)V", "mChatmodeIDRequestDebounce", "Lcom/bytedance/ee/bear/document/ai/myai/DebounceClick;", "getMChatmodeIDRequestDebounce", "()Lcom/bytedance/ee/bear/document/ai/myai/DebounceClick;", "setMChatmodeIDRequestDebounce", "(Lcom/bytedance/ee/bear/document/ai/myai/DebounceClick;)V", "mAICLickDebounce", "getMAICLickDebounce", "setMAICLickDebounce", "destroy", "", "getBridgeHandlers", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "mPermissionChangeCallback", "Lcom/bytedance/ee/bear/document/BasePermissionChangePlugin$PermissionChangeCallback;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "onDetachFromHost", "isVisible", "", "clickItem", "addMyAIIcon", "shouldDisableLandscape", "handleOrientation", "notifyOrientationSupportPanelState", "isShowing", "Companion", "MyAIMessageHandler", "MyAIShowHandler", "MyAIDocContextHandler", "MyAIOpenMyAIChatHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyAIPlugin extends DocumentPluginV2 implements p {
    private static final String BIZ_MYAI_DOCCONTEXT = "biz.myAI.doccontext";
    private static final String BIZ_MYAI_MESSAGE = "biz.myAI.message";
    private static final String BIZ_MYAI_OPENMYAICHAT = "biz.myAI.openMyAIChat";
    private static final String BIZ_MYAI_SHOW = "biz.myAI.show";
    public static final a Companion = null;
    private static final String TAG = "MyAIPlugin";
    private final Lazy aiDependency$delegate;
    private com.bytedance.ee.bear.document.ai.myai.a mAICLickDebounce;
    private m mCallback;
    private com.bytedance.ee.bear.document.ai.myai.a mChatmodeIDRequestDebounce;
    private DocContext mDocContext;
    private final BasePermissionChangePlugin.b mPermissionChangeCallback;
    private com.ss.android.lark.myai.export.d myAIPageControl;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<DocContext> {
        public final /* synthetic */ MyAIPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(MyAIPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            DocContext r4 = (DocContext) r2;
            tt5.a.h(MyAIPlugin.TAG, "MyAIDocContextHandler, DocContext data = " + r4);
            this.a.setMDocContext(r4);
        }
    }

    public final class c implements i<String> {
        public final /* synthetic */ MyAIPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(MyAIPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            String r4 = (String) r2;
            tt5.a.h(MyAIPlugin.TAG, "MyAIMessageHandler set callback, callback = " + r3);
            this.a.setMCallback(r3);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.myai.MyAIPlugin$clickItem$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        final /* synthetic */ MyAIPlugin this$0;

        public AnonymousClass1(MyAIPlugin r1) {
            this.this$0 = r1;
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m199invoke() {
            tt5.a.h(MyAIPlugin.TAG, "tryOnBoarding success");
            m r0 = this.this$0.getMCallback();
            if (r0 == null) goto L6;
            int r1 = com.bytedance.ee.bear.document.ai.myai.b.a;
            MyAIMessage r2 = new MyAIMessage();
            ActionButton r3 = new ActionButton();
            r3.setKey("open");
            r2.setKey(r3);
            r0.a(r2);
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m199invoke();
            return Unit.INSTANCE;
        }
    }

    public final class d implements i<String> {
        public final /* synthetic */ MyAIPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(MyAIPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, final m r3) {
            String r4 = (String) r2;
            tt5.a.h(MyAIPlugin.TAG, "MyAIOpenMyAIChatHandler...");
            e0 r5 = MyAIPlugin.access$getAiDependency(this.a);
            MyAIPlugin.access$getContext(this.a);
            new MyAIPlugin$MyAIOpenMyAIChatHandler$handle$1(r3);
            r5.h();
        }
    }

    public final class e implements i<MyAIChatModeParams> {
        public final /* synthetic */ MyAIPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public e(MyAIPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r10, m r11) {
            final MyAIChatModeParams r12 = (MyAIChatModeParams) r10;
            tt5.a.h(MyAIPlugin.TAG, "MyAIShowHandler, JSMyAIChatModeParams data = " + r12);
            Boolean r1 = null;
            if (this.a.getMAICLickDebounce().a() == true) goto L56;
            com.ss.android.lark.myai.export.d r13 = this.a.getMyAIPageControl();
            if (r13 == null) goto L11;
            i1 r14 = r13.isShowing();
            if (r14 == null) goto L11;
            boolean r2 = true;
            if (((Boolean) r14.getValue()).booleanValue() != true) goto L11;
        L12:
            if (r2 == true) goto L56;
            if (r12 == null) goto L66;
            ChatModeBase r16 = r12.getBase();
            if (r16 == null) goto L67;
            String r17 = r16.getChatId();
            if (r17 == null) goto L72;
            ChatModeBase r3 = r12.getBase();
            if (r3 == null) goto L68;
            Long r4 = r3.getAiChatModeId();
            if (r4 == null) goto L69;
            r4.longValue();
            ChatModeBase r5 = r12.getBase();
            if (r5 == null) goto L70;
            ArrayList<ActionButton> r6 = r5.getActions();
            if (r6 == null) goto L73;
            ChatModeData r7 = r12.getData();
            if (r7 == null) goto L34;
            DocContext r8 = r7.getDocContext();
            if (r8 == null) goto L34;
            this.a.setMDocContext(r8);
        L34:
            ArrayList r9 = new ArrayList();
            Iterator<ActionButton> r18 = r6.iterator();
        L36:
            if (r18.hasNext() == false) goto L44;
            ActionButton r19 = r18.next();
            String r20 = r19.getKey();
            if (r20 == null) goto L44;
            String r21 = r19.getTitle();
            if (r21 == null) goto L44;
            final MyAIPlugin r22 = this.a;
            r9.add(new com.ss.android.lark.myai.export.a(r20, r21, new MyAIPlugin$MyAIShowHandler$handle$actionButton$1(r22)));
        L44:
            Bundle r23 = new Bundle();
            ChatModeData r24 = r12.getData();
            String r26 = "";
            if (r24 == null) goto L48;
            String r27 = r24.getUrl();
            if (r27 == null) goto L48;
        L49:
            r23.putString("url", r27);
            ChatmodeConfig r28 = (ChatmodeConfig) com.bytedance.ee.bear.appsetting.c.a.a.c(ChatmodeConfig.KEY, ChatmodeConfig.class, new ChatmodeConfig());
            tt5.a.h(MyAIPlugin.TAG, "MyAIShowHandler, JSMyAIChatModeParams chatmodeConfig = " + r28);
            Intrinsics.checkNotNullParameter(r17, "chatId");
            new Bundle();
            CollectionsKt.emptyList();
            new ArrayList();
            ArrayList r110 = new ArrayList();
            Intrinsics.checkNotNullParameter(r9, "value");
            Intrinsics.checkNotNullParameter(r23, "value");
            ChatModeData r29 = r12.getData();
            if (r29 == null) goto L55;
            String r30 = r29.getUrl();
            if (r30 == null) goto L55;
            r26 = r30;
        L55:
            Intrinsics.checkNotNullParameter(new osb.i(r26), "info");
            final MyAIPlugin r31 = this.a;
            Intrinsics.checkNotNullParameter(new MyAIPlugin$MyAIShowHandler$handle$params$1(r12, r31), "provider");
            Intrinsics.checkNotNullParameter("doc", "value");
            Intrinsics.checkNotNullParameter(r28.getToolIds(), "value");
            Intrinsics.checkNotNullParameter(new com.bytedance.ee.bear.document.ai.myai.c(), "callback");
            CollectionsKt.toList(r9);
            CollectionsKt.toList(r110);
            MyAIPlugin r111 = this.a;
            e0 r112 = MyAIPlugin.access$getAiDependency(r111);
            MyAIPlugin.access$getContext(this.a);
            r112.b();
            r111.setMyAIPageControl(null);
            MyAIPlugin.access$handleOrientation(this.a);
            return;
        L48:
            r27 = "";
            goto L49
        L73:
            return;
        L70:
            return;
        L69:
            return;
        L68:
            return;
        L72:
            return;
        L67:
            return;
        L66:
            return;
        L11:
            r2 = false;
        L56:
            StringBuilder r113 = new StringBuilder("mAICLickDebounce return or isShowing: ");
            com.ss.android.lark.myai.export.d r114 = this.a.getMyAIPageControl();
            if (r114 == null) goto L61;
            i1 r115 = r114.isShowing();
            if (r115 == null) goto L61;
            r1 = (Boolean) r115.getValue();
        L61:
            r113.append(r1);
            tt5.a.h(MyAIPlugin.TAG, r113.toString());
        }
    }

    public static final class f implements BasePermissionChangePlugin.b {
        public final /* synthetic */ MyAIPlugin a;

        public f(MyAIPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.BasePermissionChangePlugin.b
        public final void a() {
            tt5.a.h(MyAIPlugin.TAG, "PermissionChangeCallback======  myAIPageControl: " + this.a.getMyAIPageControl());
            com.ss.android.lark.myai.export.d r0 = this.a.getMyAIPageControl();
            if (r0 == null) goto L6;
            r0.a();
            return;
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ MyAIPlugin a;

        public g(MyAIPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            if (((Boolean) r1).booleanValue() == false) goto L6;
            this.a.destroy();
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.myai.MyAIPlugin$handleOrientation$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.document.ai.myai.MyAIPlugin$handleOrientation$1", f = "MyAIPlugin.kt", i = {}, l = {396}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.BooleanRef $isFirstCall;
        int label;
        final /* synthetic */ MyAIPlugin this$0;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.myai.MyAIPlugin$handleOrientation$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ Ref.BooleanRef a;
            public final /* synthetic */ MyAIPlugin b;

            public a(Ref.BooleanRef r1, MyAIPlugin r2) {
                this.a = r1;
                this.b = r2;
            }

            public final Object emit(Object r2, Continuation r3) {
                boolean r4 = ((Boolean) r2).booleanValue();
                tt5.a.h(MyAIPlugin.TAG, "embeddedChatShowState.collect it = " + r4);
                Ref.BooleanRef r5 = this.a;
                if (r5.element == false) goto L5;
                r5.element = false;
            L7:
                return Unit.INSTANCE;
            L5:
                MyAIPlugin.access$notifyOrientationSupportPanelState(this.b, r4);
                goto L7
            }
        }

        public C03411(MyAIPlugin r1, Ref.BooleanRef r2, Continuation<? super C03411> r3) {
            this.this$0 = r1;
            this.$isFirstCall = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03411(this.this$0, this.$isFirstCall, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L16:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            com.ss.android.lark.myai.export.d r7 = this.this$0.getMyAIPageControl();
            if (r7 == null) goto L18;
            i1 r8 = r7.isShowing();
            if (r8 == null) goto L18;
            a r2 = new a(this.$isFirstCall, this.this$0);
            this.label = 1;
            if (r8.collect(r2, this) != r0) goto L16;
            return r0;
        L18:
            return Unit.INSTANCE;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final e0 getAiDependency() {
        return (e0) this.aiDependency$delegate.getValue();
    }

    private final void handleOrientation() {
        Ref.BooleanRef r0 = new Ref.BooleanRef();
        r0.element = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getActivity()), null, null, new C03411(this, r0, null), 3, null);
    }

    public final void clickItem() {
        if (this.mChatmodeIDRequestDebounce.a() == false) goto L6;
        tt5.a.h(TAG, "mChatmodeIDRequestDebounce return");
        return;
    L6:
        getAiDependency().g();
        m r0 = this.mCallback;
        if (r0 == null) goto L9;
        int r1 = com.bytedance.ee.bear.document.ai.myai.b.a;
        MyAIMessage r2 = new MyAIMessage();
        ActionButton r3 = new ActionButton();
        r3.setKey("open");
        r2.setKey(r3);
        r0.a(r2);
    L9:
        PermissionPlugin r4 = (PermissionPlugin) findPlugin(PermissionPlugin.class);
        if (r4 == null) goto L13;
        r4.registerPermissionChangeCallback(this.mPermissionChangeCallback);
        return;
    }

    public final void destroy() {
        tt5.a.h(TAG, "destroy=======  myAIPageControl: " + this.myAIPageControl);
        com.ss.android.lark.myai.export.d r0 = this.myAIPageControl;
        if (r0 == null) goto L6;
        r0.closePage();
        return;
    }

    public MyAIPlugin() {
        this.aiDependency$delegate = LazyKt.lazy(MyAIPlugin$aiDependency$2.INSTANCE);
        this.mChatmodeIDRequestDebounce = new com.bytedance.ee.bear.document.ai.myai.a();
        this.mAICLickDebounce = new com.bytedance.ee.bear.document.ai.myai.a();
        this.mPermissionChangeCallback = new f(this);
    }

    public final void addMyAIIcon() {
        if (isVisible() == true) goto L5;
        return;
    L5:
        if (((dn4.a) getHost().getUserComponent().a(dn4.a.class)).a().isCurrentEnable("ccm.mobile.move_myaibtn_to_moremenu") == true) goto L11;
        int r4 = getResources().getDimensionPixelSize(2131169532);
        int r0 = getResources().getDimensionPixelSize(2131169533);
        new LinearLayout.LayoutParams(-2, -2);
        e0 r1 = getAiDependency();
        if (r1 == null) goto L12;
        getContext();
        r1.e(new com.bytedance.ee.bear.lark.dependency.a(r4, r4, Integer.valueOf(r0), true, null, null, VersionPayLoadData.STATE_DELETE), new MyAIPlugin$addMyAIIcon$aiItemView$1(this));
        return;
    L12:
        return;
    }

    public final boolean isVisible() {
        DocViewModel r0 = getDocViewModel();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        return false;
    L10:
        DocViewModel r3 = getDocViewModel();
        if (r3 == null) goto L13;
        DocsOpenSource r4 = r3.getOpenSource();
    L15:
        if (r4 != DocsOpenSource.vc) goto L17;
        return false;
    L17:
        DocViewModel r5 = getDocViewModel();
        if (r5 != null) goto L20;
    L22:
        boolean r6 = false;
    L23:
        if (r6 == false) goto L25;
        return false;
    L25:
        DocViewModel r7 = getDocViewModel();
        if (r7 != null) goto L28;
    L30:
        r1 = false;
    L31:
        if (r1 == false) goto L34;
        return false;
    L34:
        if (((dn4.a) getHost().getUserComponent().a(dn4.a.class)).a().isCurrentEnable("ccm.docs.ai.chatmode.mobile.disable") == false) goto L36;
        return false;
    L36:
        e0 r8 = getAiDependency();
        if (r8 == null) goto L39;
        r8.k();
    L39:
        tt5.a.h(TAG, "isVisible isAIEnable = false");
        return false;
    L28:
        if (r7.isAnnounceDoc() != true) goto L30;
    L20:
        if (r5.isEditionDoc() != true) goto L22;
        r6 = true;
        goto L23
    L13:
        r4 = null;
        goto L15
    L5:
        if (r0.getDocumentTypeValue() != 22) goto L7;
        r2 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.document.orientation.p
    public boolean shouldDisableLandscape() {
        return !ku5.c.k(getContext());
    }

    public final com.bytedance.ee.bear.document.ai.myai.a getMAICLickDebounce() {
        return this.mAICLickDebounce;
    }

    public final m getMCallback() {
        return this.mCallback;
    }

    public final com.bytedance.ee.bear.document.ai.myai.a getMChatmodeIDRequestDebounce() {
        return this.mChatmodeIDRequestDebounce;
    }

    public final DocContext getMDocContext() {
        return this.mDocContext;
    }

    public final com.ss.android.lark.myai.export.d getMyAIPageControl() {
        return this.myAIPageControl;
    }

    public static final /* synthetic */ e0 access$getAiDependency(MyAIPlugin r0) {
        return r0.getAiDependency();
    }

    public static final /* synthetic */ Context access$getContext(MyAIPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ void access$handleOrientation(MyAIPlugin r0) {
        r0.handleOrientation();
    }

    private final void notifyOrientationSupportPanelState(boolean r2) {
        BaseUnspecifiedOrientationPlugin r0 = (BaseUnspecifiedOrientationPlugin) findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (r0 != null) goto L6;
        tt5.a.k(TAG, "can not find BaseUnspecifiedOrientationPlugin");
        return;
    L6:
        if (r2 == false) goto L8;
        r0.onOrientationSupportPanelShowing(this);
        return;
    L8:
        r0.onOrientationSupportPanelDismiss(this);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put(BIZ_MYAI_MESSAGE, new c(this));
        r3.put(BIZ_MYAI_SHOW, new e(this));
        r3.put(BIZ_MYAI_DOCCONTEXT, new b(this));
        r3.put(BIZ_MYAI_OPENMYAICHAT, new d(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r3) {
        super.onAttachToHost(r3);
        OopsPluginV2 r4 = (OopsPluginV2) findPlugin(OopsPluginV2.class);
        if (r4 == null) goto L8;
        MutableLiveData<Boolean> r5 = r4.getIsClickRefresh();
        if (r5 == null) goto L9;
        r5.observe(getLifecycleOwner(), new g(this));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r2) {
        super.onDetachFromHost(r2);
        PermissionPlugin r3 = (PermissionPlugin) findPlugin(PermissionPlugin.class);
        if (r3 == null) goto L5;
        r3.unRegisterPermissionChangeCallback(this.mPermissionChangeCallback);
    L5:
        destroy();
    }

    public final void setMAICLickDebounce(com.bytedance.ee.bear.document.ai.myai.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mAICLickDebounce = r2;
    }

    public final void setMCallback(m r1) {
        this.mCallback = r1;
    }

    public final void setMChatmodeIDRequestDebounce(com.bytedance.ee.bear.document.ai.myai.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mChatmodeIDRequestDebounce = r2;
    }

    public final void setMDocContext(DocContext r1) {
        this.mDocContext = r1;
    }

    public final void setMyAIPageControl(com.ss.android.lark.myai.export.d r1) {
        this.myAIPageControl = r1;
    }

    public static final /* synthetic */ void access$notifyOrientationSupportPanelState(MyAIPlugin r0, boolean r1) {
        r0.notifyOrientationSupportPanelState(r1);
    }
}
