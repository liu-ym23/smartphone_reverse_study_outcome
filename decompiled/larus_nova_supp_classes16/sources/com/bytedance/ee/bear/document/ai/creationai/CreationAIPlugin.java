package com.bytedance.ee.bear.document.ai.creationai;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.toast.ToastModel;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.contract.z;
import com.bytedance.ee.bear.doc.follow.impl.BaseFollowImpl;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.follow.FollowPlugin;
import com.bytedance.ee.bear.document.menu.TitleMenuPlugin;
import com.bytedance.ee.bear.document.oops.OopsPluginV2;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.edit.component.toolbar2.DocToolbarV2Compat;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.inline.ai.api.ScenarioType;
import com.ss.android.lark.inline.ai.api.creationai.CreationAIPanel;
import com.ss.android.lark.inline.ai.api.creationai.FeedbackJSParams;
import com.ss.android.lark.inline.ai.api.creationai.FeedbackResult;
import com.ss.android.lark.inline.ai.api.creationai.MenuItem;
import com.ss.android.lark.inline.ai.api.creationai.SubPanelInfo;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 A2\u00020\u00012\u00020\u00022\u00020\u0003:\tABCDEFGHIB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0014\u0010\u0016\u001a\u00020\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0014H\u0002J\n\u0010\u001f\u001a\u00020 *\u00020 J \u0010!\u001a\u00020\u00142\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030$0#H\u0016J\u0012\u0010%\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010(\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0006\u0010)\u001a\u00020\u000eJ\"\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020 2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u00103\u001a\u0002022\u0006\u00104\u001a\u000201H\u0002J\u0012\u00105\u001a\u0004\u0018\u0001022\u0006\u00104\u001a\u000201H\u0002J\b\u00107\u001a\u00020\u000eH\u0016J\u0010\u00109\u001a\u00020\u00142\u0006\u0010:\u001a\u00020\u000eH\u0002J\u0010\u0010;\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\u000eH\u0002J\b\u0010?\u001a\u00020@H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/creationai/CreationAIPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "Lcom/bytedance/ee/bear/document/orientation/OrientationSupportPanel;", "Lcom/bytedance/ee/bear/facade/common/ActivityResultHandler;", "<init>", "()V", "creationAISdk", "Lcom/ss/android/lark/inline/ai/api/creationai/ICreationAISdk;", "backPressDispatcher", "Lcom/bytedance/ee/bear/facade/common/BackPressDispatcher;", "mEditorCallback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "mCallback", "mKeyboardShow", "", "keyboardHeightProvider", "Lcom/ss/android/lark/edit/keyboard/provider/KeyboardHeightProvider;", "editPanel", "Lcom/bytedance/ee/bear/document/ai/inlineai/InlineAIEditPanel;", "destroy", "", "hideToolbar", "ensureSdk", "creationAIPanel", "Lcom/ss/android/lark/inline/ai/api/creationai/CreationAIPanel;", "popoverView", "Landroid/view/View;", "showPopOver", "text", "", "hidePopOver", "dp", "", "getBridgeHandlers", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "onDetachFromHost", "enableAiEditAt", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "currentScene", "keyboardObserverMap", "Lcom/ss/android/lark/inline/ai/api/ui/IKeyboardHeightProvider$IKeyboardHeightChangeListener;", "Lcom/ss/android/lark/edit/keyboard/KeyboardHeightObserver;", "getOrCreateKeyboardObserver", "onKeyboardHeightChangeListener", "removeAndGetKeyboardObserver", "disableLandscape", "shouldDisableLandscape", "hasnotifyOrientation", "handleOrientation", "isShow", "notifyOrientationSupportPanelState", "isShowing", "backPress", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "getScenario", "Lcom/ss/android/lark/inline/ai/api/ScenarioType;", "Companion", "CreationAIPopoverHandler", "CreationAIModelSettingHandler", "CreationAIHistoryHandler", "CreationAIShowHandler", "MessageFromPreviewComponentHandler", "CreationAIMessageHandler", "CreationAIFeedbackHandler", "SendMessageToPreviewComponentHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationAIPlugin extends DocumentPluginV2 implements com.bytedance.ee.bear.document.orientation.p, sa5.a {
    public static final a Companion = null;
    private static final String MENTION_ALL_ENABLE = "ccm.knowledge.inline_ai_mention_all_enable";
    private static final String TAG = "CreationAIPlugin";
    private final sa5.d backPress;
    private sa5.b backPressDispatcher;
    private vlb.c creationAISdk;
    private String currentScene;
    private boolean disableLandscape;
    private com.bytedance.ee.bear.document.ai.inlineai.a editPanel;
    private boolean hasnotifyOrientation;
    private pcb.a keyboardHeightProvider;
    private final Map<wlb.d.a, ocb.a> keyboardObserverMap;
    private tb5.m mCallback;
    private tb5.m mEditorCallback;
    private boolean mKeyboardShow;
    private View popoverView;

    public static final class a {
        public a() {
        }
    }

    public final class b implements tb5.i<FeedbackJSParams> {
        public final /* synthetic */ CreationAIPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(CreationAIPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            FeedbackJSParams r5 = (FeedbackJSParams) r3;
            tt5.a.h(CreationAIPlugin.TAG, "Creation AI CreationAIFeedbackHandler, data = " + r5);
            if (r5 == null) goto L6;
            CreationAIPlugin.ensureSdk$default(this.a, null, 1, null).c(r5);
            return;
        }
    }

    public final class c implements tb5.i<SubPanelInfo> {
        public final /* synthetic */ CreationAIPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(CreationAIPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            SubPanelInfo r5 = (SubPanelInfo) r3;
            tt5.a.h(CreationAIPlugin.TAG, "CreationAIHistoryHandler show, data = " + du5.b.k(String.valueOf(r5)));
            if (r5 != null) goto L6;
            return;
        L6:
            if (r5.getShow() == false) goto L8;
            CreationAIPlugin.ensureSdk$default(this.a, null, 1, null).d(r5);
            return;
        L8:
            vlb.c r6 = CreationAIPlugin.access$getCreationAISdk$p(this.a);
            if (r6 == null) goto L13;
            r6.g();
            return;
        }
    }

    public final class d implements tb5.i<String> {
        public final /* synthetic */ CreationAIPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(CreationAIPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            String r4 = (String) r2;
            tt5.a.h(CreationAIPlugin.TAG, "Creation AI set callback, callback = " + r3);
            CreationAIPlugin.access$setMCallback$p(this.a, r3);
        }
    }

    public final class e implements tb5.i<SubPanelInfo> {
        public final /* synthetic */ CreationAIPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public e(CreationAIPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            SubPanelInfo r5 = (SubPanelInfo) r3;
            tt5.a.h(CreationAIPlugin.TAG, "CreationAIModelSettingHandler show, data = " + du5.b.k(String.valueOf(r5)));
            if (r5 != null) goto L6;
            return;
        L6:
            if (r5.getShow() == false) goto L8;
            CreationAIPlugin.ensureSdk$default(this.a, null, 1, null).b(r5);
            return;
        L8:
            vlb.c r6 = CreationAIPlugin.access$getCreationAISdk$p(this.a);
            if (r6 == null) goto L13;
            r6.e();
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.creationai.CreationAIPlugin$ensureSdk$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.document.ai.creationai.CreationAIPlugin$ensureSdk$5", f = "CreationAIPlugin.kt", i = {}, l = {358}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<vlb.c> $sdk;
        int label;
        final /* synthetic */ CreationAIPlugin this$0;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.creationai.CreationAIPlugin$ensureSdk$5$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ CreationAIPlugin a;

            public a(CreationAIPlugin r1) {
                this.a = r1;
            }

            public final Object emit(Object r2, Continuation r3) {
                if (((Boolean) r2).booleanValue() == true) goto L6;
                ((com.bytedance.ee.bear.document.toolbar2.b) org.koin.java.a.c(com.bytedance.ee.bear.document.toolbar2.b.class, null, null, 6)).a(this.a.getHost());
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass5(Ref.ObjectRef<vlb.c> r1, CreationAIPlugin r2, Continuation<? super AnonymousClass5> r3) {
            this.$sdk = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass5(this.$sdk, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            i1 r6 = ((vlb.c) this.$sdk.element).isShowing();
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public final class f implements tb5.i<PopoverData> {
        public final /* synthetic */ CreationAIPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public f(CreationAIPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            PopoverData r5 = (PopoverData) r3;
            tt5.a.h(CreationAIPlugin.TAG, "CreationAIPopoverHandler show, data = " + r5);
            if (r5 == null) goto L17;
        L10:
            e = move-exception;
            tt5.a.d(CreationAIPlugin.TAG, "handle, e = " + e);
            return;
        L6:
            if (r5.getShow() == false) goto L8;
            CreationAIPlugin.access$showPopOver(this.a, r5.getText());     // Catch: Exception -> L10
        L13:
            return;
        L8:
            CreationAIPlugin.access$hidePopOver(this.a);     // Catch: Exception -> L10
            goto L13
        }
    }

    public final class g implements tb5.i<CreationAIPanel> {
        public final /* synthetic */ CreationAIPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public g(CreationAIPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            CreationAIPanel r4 = (CreationAIPanel) r2;
            tt5.a.h(CreationAIPlugin.TAG, "Creation AI show, data = " + du5.b.k(String.valueOf(r4)));
            if (r4 == null) goto L29;
            CreationAIPlugin.access$handleOrientation(this.a, r4.getShow());
            CreationAIPlugin.access$setDisableLandscape$p(this.a, r4.getDisableLandscape());
            if (r4.getShow() == true) goto L8;
            vlb.c r5 = CreationAIPlugin.access$getCreationAISdk$p(this.a);
            if (r5 == null) goto L18;
            r5.a();
        L18:
            com.bytedance.ee.bear.document.ai.inlineai.a r6 = CreationAIPlugin.access$getEditPanel$p(this.a);
            if (r6 == null) goto L27;
            MutableLiveData<Boolean> r7 = r6.b;
            if (r7 == null) goto L28;
            r7.setValue(Boolean.FALSE);
            return;
        L28:
            return;
        L27:
            return;
        L8:
            if (Intrinsics.areEqual(r4.getScene(), CreationAIPlugin.access$getCurrentScene$p(this.a)) == true) goto L10;
            CreationAIPlugin.access$setCurrentScene$p(this.a, r4.getScene());
            CreationAIPlugin.access$setCreationAISdk$p(this.a, null);
        L10:
            CreationAIPlugin.access$ensureSdk(this.a, r4).h(r4);
            com.bytedance.ee.bear.document.ai.inlineai.a r8 = CreationAIPlugin.access$getEditPanel$p(this.a);
            if (r8 == null) goto L24;
            MutableLiveData<Boolean> r9 = r8.b;
            if (r9 == null) goto L25;
            r9.setValue(Boolean.TRUE);
            return;
        L25:
            return;
        L24:
            return;
        }
    }

    public final class h implements tb5.i<String> {
        public final /* synthetic */ CreationAIPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public h(CreationAIPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            String r4 = (String) r2;
            tt5.a.h(CreationAIPlugin.TAG, "Creation AI onMessageFromPreviewComponent set callback, callback = " + r3);
            CreationAIPlugin.access$setMEditorCallback$p(this.a, r3);
        }
    }

    public final class i implements tb5.i<Object> {
        public final /* synthetic */ CreationAIPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public i(CreationAIPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            tt5.a.h(CreationAIPlugin.TAG, "Creation AI SendMessageToPreviewComponentHandler, data");
            if (r3 == null) goto L8;
            vlb.c r5 = CreationAIPlugin.ensureSdk$default(this.a, null, 1, null);
            if (r5 == null) goto L9;
            r5.f(r3);
            return;
        L9:
            return;
        }
    }

    public static final class j implements sa5.d {
        public final /* synthetic */ CreationAIPlugin a;

        public j(CreationAIPlugin r1) {
            this.a = r1;
        }

        @Override // sa5.d
        public final boolean onBackPressed() {
            vlb.c r0 = CreationAIPlugin.access$getCreationAISdk$p(this.a);
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.onBackPressed();
        }
    }

    public static final class k implements wlb.d {
        public final /* synthetic */ CreationAIPlugin a;

        public final int c() {
            pcb.a r0 = CreationAIPlugin.access$getKeyboardHeightProvider$p(this.a);
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getVisibleKeyboardHeight();
        }

        public final boolean isKeyboardShowing() {
            pcb.a r0 = CreationAIPlugin.access$getKeyboardHeightProvider$p(this.a);
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.isKeyboardShowing();
        }

        public k(CreationAIPlugin r1) {
            this.a = r1;
        }

        public final void a(wlb.d.a r2) {
            Intrinsics.checkNotNullParameter(r2, "onKeyboardHeightChangeListener");
            ocb.a r3 = CreationAIPlugin.access$removeAndGetKeyboardObserver(this.a, r2);
            if (r3 == null) goto L8;
            pcb.a r0 = CreationAIPlugin.access$getKeyboardHeightProvider$p(this.a);
            if (r0 == null) goto L9;
            r0.b(r3);
            return;
        L9:
            return;
        }

        public final void b(wlb.d.a r3) {
            Intrinsics.checkNotNullParameter(r3, "onKeyboardHeightChangeListener");
            pcb.a r0 = CreationAIPlugin.access$getKeyboardHeightProvider$p(this.a);
            if (r0 == null) goto L6;
            r0.d(CreationAIPlugin.access$getOrCreateKeyboardObserver(this.a, r3));
            return;
        }
    }

    public static final class l implements vlb.d {
        public final /* synthetic */ CreationAIPlugin a;

        public final int a() {
            if (ForsetiHelper.s(this.a.getHost().getHostFragment()) == false) goto L11;
            Fragment r0 = this.a.getHost().getHostFragment();
            if (r0 == null) goto L13;
            Fragment r1 = r0.getParentFragment();
            if (r1 == null) goto L13;
            return WindowInsetsUtils.b(r1).a();
        L13:
            return this.a.getHost().getActivity().getWindow().getStatusBarColor();
        L11:
            return this.a.getHost().getActivity().getWindow().getStatusBarColor();
        }

        public l(CreationAIPlugin r1) {
            this.a = r1;
        }

        public final void b(int r4) {
            FragmentActivity r0 = this.a.getHost().getActivity();
            PluginHost r1 = this.a.getHost();
            if (r1 == null) goto L7;
            Fragment r2 = r1.getHostFragment();
            if (r2 == null) goto L7;
            Fragment r3 = r2.getParentFragment();
        L8:
            bp5.c.e(r0, ForsetiHelper.g(r3), r4, false);
            return;
        L7:
            r3 = null;
            goto L8
        }
    }

    public static final class m implements vlb.b {
        public final /* synthetic */ CreationAIPlugin a;

        public final void c() {
            Intrinsics.checkNotNullParameter("outSideClick", "closeType");
            tt5.a.h(CreationAIPlugin.TAG, "onCloseConfirm, closeType = outSideClick ");
            tb5.m r0 = CreationAIPlugin.access$getMCallback$p(this.a);
            if (r0 == null) goto L6;
            CallbackData.a r2 = CallbackData.Companion;
            boolean r3 = CreationAIPlugin.access$getMKeyboardShow$p(this.a);
            r2.getClass();
            Intrinsics.checkNotNullParameter("outSideClick", "type");
            r0.a(new CallbackData("outSideClick", null, r3 ? 1 : 0));
            return;
        }

        public final void d() {
            Intrinsics.checkNotNullParameter("", "closeType");
            tt5.a.h(CreationAIPlugin.TAG, "onClosePanel, closeType = ");
            CreationAIPlugin.access$notifyOrientationSupportPanelState(this.a, false);
            com.bytedance.ee.bear.document.ai.inlineai.a r0 = CreationAIPlugin.access$getEditPanel$p(this.a);
            if (r0 == null) goto L7;
            MutableLiveData<Boolean> r1 = r0.b;
            if (r1 == null) goto L7;
            r1.setValue(Boolean.FALSE);
        L7:
            tb5.m r2 = CreationAIPlugin.access$getMCallback$p(this.a);
            if (r2 == null) goto L11;
            CallbackData.a r3 = CallbackData.Companion;
            boolean r4 = CreationAIPlugin.access$getMKeyboardShow$p(this.a);
            r3.getClass();
            r2.a(new CallbackData("closePanel", null, r4 ? 1 : 0));
            return;
        }

        public final void e() {
            tt5.a.h(CreationAIPlugin.TAG, "onClickStop");
            tb5.m r0 = CreationAIPlugin.access$getMCallback$p(this.a);
            if (r0 == null) goto L6;
            CallbackData.a r1 = CallbackData.Companion;
            boolean r2 = CreationAIPlugin.access$getMKeyboardShow$p(this.a);
            r1.getClass();
            r0.a(new CallbackData("stopBtnClick", null, r2 ? 1 : 0));
            return;
        }

        public final String g() {
            DocViewModel r0 = CreationAIPlugin.access$getDocViewModel(this.a);
            if (r0 == null) goto L6;
            String r1 = r0.getDocEncryptId();
            if (r1 == null) goto L6;
            return r1;
        L6:
            return "";
        }

        public final void j() {
            CreationAIPlugin.access$hideToolbar(this.a);
        }

        public final void l() {
            tt5.a.h(CreationAIPlugin.TAG, "onDebugInfo ");
            tb5.m r0 = CreationAIPlugin.access$getMCallback$p(this.a);
            if (r0 == null) goto L6;
            CallbackData.a r1 = CallbackData.Companion;
            boolean r2 = CreationAIPlugin.access$getMKeyboardShow$p(this.a);
            r1.getClass();
            r0.a(new CallbackData("debugInfo", null, r2 ? 1 : 0));
            return;
        }

        public m(CreationAIPlugin r1) {
            this.a = r1;
        }

        public final void a(int r6) {
            tt5.a.h(CreationAIPlugin.TAG, "onHeightChange, height = " + r6);
            tb5.m r0 = CreationAIPlugin.access$getMCallback$p(this.a);
            if (r0 == null) goto L5;
            CallbackData.a r1 = CallbackData.Companion;
            boolean r2 = CreationAIPlugin.access$getMKeyboardShow$p(this.a);
            r1.getClass();
            r0.a(new CallbackData("changeHeight", Integer.valueOf(r6), r2 ? 1 : 0));
        L5:
            pcb.a r3 = CreationAIPlugin.access$getKeyboardHeightProvider$p(this.a);
            if (r3 == null) goto L8;
            int r4 = r3.getVisibleKeyboardHeight();
        L9:
            com.bytedance.ee.bear.document.ai.inlineai.a r5 = CreationAIPlugin.access$getEditPanel$p(this.a);
            if (r5 == null) goto L13;
            r5.a = r6 - r4;
            return;
        L13:
            return;
        L8:
            r4 = 0;
            goto L9
        }

        public final void b(boolean r5) {
            tt5.a.h(CreationAIPlugin.TAG, "onKeyboardChange, show = " + r5);
            CreationAIPlugin.access$setMKeyboardShow$p(this.a, r5);
            tb5.m r6 = CreationAIPlugin.access$getMCallback$p(this.a);
            if (r6 == null) goto L6;
            CallbackData.a r0 = CallbackData.Companion;
            boolean r1 = CreationAIPlugin.access$getMKeyboardShow$p(this.a);
            r0.getClass();
            r6.a(new CallbackData("changeKeyboard", null, r1 ? 1 : 0));
            return;
        }

        public final void f(String r5) {
            Intrinsics.checkNotNullParameter(r5, "url");
            tt5.a.h(CreationAIPlugin.TAG, "onLinkClicked, url = " + du5.b.f(r5));
            tb5.m r1 = CreationAIPlugin.access$getMCallback$p(this.a);
            if (r1 == null) goto L6;
            CallbackData.a r2 = CallbackData.Companion;
            boolean r3 = CreationAIPlugin.access$getMKeyboardShow$p(this.a);
            r2.getClass();
            Intrinsics.checkNotNullParameter(r5, "url");
            HashMap r4 = new HashMap();
            r4.put("url", r5);
            r1.a(new CallbackData("openLink", r4, r3 ? 1 : 0));
            return;
        }

        public final void h(Object r5) {
            Intrinsics.checkNotNullParameter(r5, "text");
            StringBuilder r1 = new StringBuilder("onClickSend, String text length = ");
            String r6 = (String) r5;
            r1.append(r6.length());
            tt5.a.h(CreationAIPlugin.TAG, r1.toString());
            tb5.m r2 = CreationAIPlugin.access$getMCallback$p(this.a);
            if (r2 == null) goto L6;
            CallbackData.a r3 = CallbackData.Companion;
            boolean r4 = CreationAIPlugin.access$getMKeyboardShow$p(this.a);
            r3.getClass();
            Intrinsics.checkNotNullParameter(r6, "text");
            r2.a(new CallbackData("send", r6, r4 ? 1 : 0));
            return;
        }

        public final void i(Object r4) {
            if ((r4 instanceof JSONObject) == false) goto L5;
            JSONObject r5 = (JSONObject) r4;
        L6:
            if (r5 == null) goto L11;
            CreationAIPlugin r0 = this.a;
            tt5.a.h(CreationAIPlugin.TAG, "onSendMessageToDocs, data = " + r5.size());
            tb5.m r1 = CreationAIPlugin.access$getMEditorCallback$p(r0);
            if (r1 == null) goto L12;
            r1.b(r5);
            return;
        L12:
            return;
        L11:
            return;
        L5:
            r5 = null;
            goto L6
        }

        public final void k(FeedbackResult r5) {
            Intrinsics.checkNotNullParameter(r5, "feedbackResult");
            tt5.a.h(CreationAIPlugin.TAG, "onSubmitFeedback, feedbackResult = " + r5);
            tb5.m r1 = CreationAIPlugin.access$getMCallback$p(this.a);
            if (r1 == null) goto L6;
            CallbackData.a r2 = CallbackData.Companion;
            boolean r3 = CreationAIPlugin.access$getMKeyboardShow$p(this.a);
            r2.getClass();
            Intrinsics.checkNotNullParameter(r5, "feedbackResult");
            r1.a(new CallbackData("submitFeedback", r5, r3 ? 1 : 0));
            return;
        }

        public final void m(MenuItem r5) {
            Intrinsics.checkNotNullParameter(r5, "menuItem");
            tt5.a.h(CreationAIPlugin.TAG, "onClickOperation, menuItem = " + r5.getId());
            tb5.m r1 = CreationAIPlugin.access$getMCallback$p(this.a);
            if (r1 == null) goto L6;
            CallbackData.a r2 = CallbackData.Companion;
            boolean r3 = CreationAIPlugin.access$getMKeyboardShow$p(this.a);
            r2.getClass();
            Intrinsics.checkNotNullParameter(r5, "menuItem");
            r1.a(new CallbackData("operate", r5.getId(), r3 ? 1 : 0));
            return;
        }

        public final void n(MenuItem r5) {
            Intrinsics.checkNotNullParameter(r5, "menuItem");
            tt5.a.h(CreationAIPlugin.TAG, "onClickModelSetting, menuItem = " + r5.getId());
            tb5.m r1 = CreationAIPlugin.access$getMCallback$p(this.a);
            if (r1 == null) goto L6;
            CallbackData.a r2 = CallbackData.Companion;
            boolean r3 = CreationAIPlugin.access$getMKeyboardShow$p(this.a);
            r2.getClass();
            Intrinsics.checkNotNullParameter(r5, "menuItem");
            r1.a(new CallbackData("modelSetting", r5, r3 ? 1 : 0));
            return;
        }

        public final void o(MenuItem r5) {
            Intrinsics.checkNotNullParameter(r5, "menuItem");
            tt5.a.h(CreationAIPlugin.TAG, "onClickHistory, menuItem = " + r5.getId());
            tb5.m r1 = CreationAIPlugin.access$getMCallback$p(this.a);
            if (r1 == null) goto L6;
            CallbackData.a r2 = CallbackData.Companion;
            boolean r3 = CreationAIPlugin.access$getMKeyboardShow$p(this.a);
            r2.getClass();
            Intrinsics.checkNotNullParameter(r5, "menuItem");
            r1.a(new CallbackData("history", r5, r3 ? 1 : 0));
            return;
        }

        public final void onInputTextChange(String r5) {
            Intrinsics.checkNotNullParameter(r5, "text");
            tt5.a.h(CreationAIPlugin.TAG, "onInputTextChange, text length = " + r5.length());
            tb5.m r0 = CreationAIPlugin.access$getMCallback$p(this.a);
            if (r0 == null) goto L6;
            CallbackData.a r1 = CallbackData.Companion;
            boolean r2 = CreationAIPlugin.access$getMKeyboardShow$p(this.a);
            r1.getClass();
            Intrinsics.checkNotNullParameter(r5, "input");
            r0.a(new CallbackData("changeInput", r5, r2 ? 1 : 0));
            return;
        }

        public final void p(MenuItem r5) {
            Intrinsics.checkNotNullParameter(r5, "menuItem");
            tb5.m r1 = CreationAIPlugin.access$getMCallback$p(this.a);
            if (r1 == null) goto L6;
            CallbackData.a r2 = CallbackData.Companion;
            boolean r3 = CreationAIPlugin.access$getMKeyboardShow$p(this.a);
            r2.getClass();
            Intrinsics.checkNotNullParameter(r5, "menuItem");
            r1.a(new CallbackData("recommend", r5, r3 ? 1 : 0));
            return;
        }

        public final void q(String r5) {
            Intrinsics.checkNotNullParameter(r5, "closeType");
            tt5.a.h(CreationAIPlugin.TAG, "onCloseSubPanel, closeType = ".concat(r5));
            tb5.m r0 = CreationAIPlugin.access$getMCallback$p(this.a);
            if (r0 == null) goto L6;
            CallbackData.a r1 = CallbackData.Companion;
            boolean r2 = CreationAIPlugin.access$getMKeyboardShow$p(this.a);
            r1.getClass();
            Intrinsics.checkNotNullParameter(r5, "type");
            r0.a(new CallbackData(r5, null, r2 ? 1 : 0));
            return;
        }
    }

    public static final class n implements ocb.a {
        public final /* synthetic */ wlb.d.a a;

        public n(wlb.d.a r1) {
            this.a = r1;
        }

        public final void onKeyboardHeightChanged(pcb.a r1, int r2, int r3) {
            this.a.a(r2);
        }
    }

    public static final class o<T> implements Observer {
        public final /* synthetic */ CreationAIPlugin a;

        public o(CreationAIPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            if (((Boolean) r1).booleanValue() == false) goto L6;
            this.a.destroy();
            return;
        }
    }

    public static final class p implements sy4.d {
        public final /* synthetic */ CreationAIPlugin a;

        public p(CreationAIPlugin r1) {
            this.a = r1;
        }

        @Override // sy4.d
        public final void a(sy4.b r2) {
            if ((r2 instanceof sy4.e) == true) goto L5;
            return;
        L5:
            if (((sy4.e) r2).b == false) goto L11;
            vlb.c r3 = CreationAIPlugin.access$getCreationAISdk$p(this.a);
            if (r3 == null) goto L12;
            r3.a();
            return;
        L12:
            return;
        }
    }

    public static final class q implements Runnable {
        public final /* synthetic */ CreationAIPlugin a;
        public final /* synthetic */ BaseTitlePlugin<?> b;

        public q(CreationAIPlugin r1, BaseTitlePlugin<?> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CreationAIPlugin.access$hidePopOver(this.a);     // Catch: Throwable -> L6
            BaseTitlePlugin<?> r0 = this.b;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.removeNotifyTitleBarHideRunnable();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class r implements Runnable {
        public final /* synthetic */ CreationAIPlugin a;
        public final /* synthetic */ BaseTitlePlugin<?> b;

        public r(CreationAIPlugin r1, BaseTitlePlugin<?> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            tt5.a.h(CreationAIPlugin.TAG, "onTitleBarHide");     // Catch: Throwable -> L4
            CreationAIPlugin.access$hidePopOver(this.a);     // Catch: Throwable -> L4
            this.b.removeNotifyTitleBarHideRunnable();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void hidePopOver() {
        View r0 = this.popoverView;
        if (r0 == null) goto L12;
        ViewParent r1 = r0.getParent();
        if ((r1 instanceof ViewGroup) == false) goto L7;
        ViewGroup r2 = (ViewGroup) r1;
    L8:
        if (r2 == null) goto L10;
        r2.removeView(r0);
    L10:
        this.popoverView = null;
        return;
    L7:
        r2 = null;
        goto L8
    }

    private final void hideToolbar() {
        tt5.a.h(TAG, "force hide tool bar--->");
        DocToolbarV2Compat.of(getActivity()).hideAllToolbar();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.e(TAG, "hideToolbar: ", e, false);
    }

    public final void destroy() {
        tt5.a.h(TAG, "destroy=======");
        hidePopOver();
        vlb.c r0 = this.creationAISdk;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        vlb.c r1 = this.creationAISdk;
        if (r1 == null) goto L8;
        r1.destroy();
    L8:
        this.creationAISdk = null;
        this.mEditorCallback = null;
        this.mCallback = null;
    }

    public CreationAIPlugin() {
        this.keyboardObserverMap = new LinkedHashMap();
        this.disableLandscape = true;
        this.backPress = new j(this);
    }

    private final ScenarioType getScenario() {
        String r0 = getDocumentMetadata().getBearUrl().a;
        if (r0 == null) goto L23;
        switch(r0.hashCode()) {
            case -102775833: goto L19;
            case 99640: goto L15;
            case 3088960: goto L12;
            case 109403487: goto L8;
            default: goto L23;
        };
    L8:
        if (r0.equals("sheet") == false) goto L23;
        return ScenarioType.Sheet;
    L12:
        if (r0.equals("docx") == false) goto L23;
    L25:
        return ScenarioType.Doc;
    L15:
        if (r0.equals("doc") == true) goto L25;
    L19:
        if (r0.equals("bitable") == false) goto L23;
        return ScenarioType.Base;
    L23:
        return ScenarioType.UNKNOWN;
    }

    public final boolean enableAiEditAt() {
        DocViewModel r0 = getDocViewModel();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L18;
        DocViewModel r2 = getDocViewModel();
        if (r2 != null) goto L12;
    L14:
        boolean r3 = false;
    L15:
        if (r3 == true) goto L18;
        return false;
    L12:
        if (r2.isDocumentType(sbb.e.o) != true) goto L14;
        r3 = true;
    L18:
        return true;
    L5:
        if (r0.isDocumentType(sbb.e.g) != true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.document.orientation.p
    public boolean shouldDisableLandscape() {
        return this.disableLandscape;
    }

    public static View INVOKEVIRTUAL_com_bytedance_ee_bear_document_ai_creationai_CreationAIPlugin_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static final /* synthetic */ vlb.c access$getCreationAISdk$p(CreationAIPlugin r0) {
        return r0.creationAISdk;
    }

    public static final /* synthetic */ String access$getCurrentScene$p(CreationAIPlugin r0) {
        return r0.currentScene;
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(CreationAIPlugin r0) {
        return r0.getDocViewModel();
    }

    public static final /* synthetic */ com.bytedance.ee.bear.document.ai.inlineai.a access$getEditPanel$p(CreationAIPlugin r0) {
        return r0.editPanel;
    }

    public static final /* synthetic */ pcb.a access$getKeyboardHeightProvider$p(CreationAIPlugin r0) {
        return r0.keyboardHeightProvider;
    }

    public static final /* synthetic */ tb5.m access$getMCallback$p(CreationAIPlugin r0) {
        return r0.mCallback;
    }

    public static final /* synthetic */ tb5.m access$getMEditorCallback$p(CreationAIPlugin r0) {
        return r0.mEditorCallback;
    }

    public static final /* synthetic */ boolean access$getMKeyboardShow$p(CreationAIPlugin r0) {
        return r0.mKeyboardShow;
    }

    public static final /* synthetic */ void access$hidePopOver(CreationAIPlugin r0) {
        r0.hidePopOver();
    }

    public static final /* synthetic */ void access$hideToolbar(CreationAIPlugin r0) {
        r0.hideToolbar();
    }

    private final vlb.c ensureSdk(CreationAIPanel r14) {
        Ref.ObjectRef r16 = new Ref.ObjectRef();
        vlb.c r0 = this.creationAISdk;
        r16.element = r0;
        if (r0 != null) goto L36;
        DocViewModel r1 = getDocViewModel();
        if (r1 == null) goto L8;
        DocsOpenSource r2 = r1.getOpenSource();
    L10:
        if (r2 != DocsOpenSource.vc) goto L12;
        boolean r3 = true;
    L13:
        PluginHost r4 = getHost();
        if (r4 == null) goto L16;
        Fragment r5 = r4.getHostFragment();
    L17:
        boolean r6 = ForsetiHelper.s(r5);
        boolean r7 = Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE);
        if (r3 == true) goto L23;
        if (r6 == false) goto L22;
        ViewGroup r8 = getUIContainer().c(this);
    L25:
        ViewGroup r9 = r8;
    L26:
        tt5.a.h(TAG, "ensureSdk, isInForseti = " + r6 + ", isAtVc = " + r3 + ", isOfficeSdk = " + r7);
        slb.b r10 = (slb.b) ClaymoreServiceLoader.loadFirst(slb.b.class);
        FragmentActivity r11 = getActivity();
        ScenarioType r12 = getScenario();
        Intrinsics.checkNotNullParameter(r11, "activity");
        Intrinsics.checkNotNullParameter(r12, "scenario");
        if (r6 == false) goto L31;
        PluginHost r13 = getHost();
        if (r13 == null) goto L31;
        r13.getHostFragment();
    L31:
        ((z) org.koin.java.a.c(z.class, null, null, 6)).isDebugEnabled(getContext());
        k r17 = new k(this);
        Intrinsics.checkNotNullParameter(r17, "keyboardHeightProvider");
        if (r7 == false) goto L34;
        l r18 = null;
    L35:
        r0 = r10.createCreationAISdk(new vlb.a(r11, r9, r17, -1, r12, r18, true), new m(this));
        this.creationAISdk = r0;
        goto L36
    L34:
        r18 = new l(this);
        goto L35
    L22:
        if (r7 == true) goto L23;
        r8 = getUIContainer().c(this);
    L23:
        r9 = null;
        goto L26
    L16:
        r5 = null;
        goto L17
    L12:
        r3 = false;
        goto L13
    L8:
        r2 = null;
    L36:
        r16.element = r0;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getLifecycleOwner()), null, null, new AnonymousClass5(r16, this, null), 3, null);
        return (vlb.c) r16.element;
    }

    private final ocb.a getOrCreateKeyboardObserver(wlb.d.a r3) {
        Map<wlb.d.a, ocb.a> r0 = this.keyboardObserverMap;
        ocb.a r1 = r0.get(r3);
        if (r1 != null) goto L6;
        r1 = new n(r3);
        r0.put(r3, r1);
    L6:
        return r1;
    }

    private final void handleOrientation(boolean r4) {
        if (r4 == true) goto L4;
        this.hasnotifyOrientation = false;
        notifyOrientationSupportPanelState(false);
        sa5.b r5 = this.backPressDispatcher;
        if (r5 == null) goto L21;
        r5.d(this.backPress);
        return;
    L21:
        return;
    L4:
        if (this.hasnotifyOrientation == true) goto L15;
        notifyOrientationSupportPanelState(true);
        if (this.backPressDispatcher != null) goto L12;
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g r6 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g.a;
        FragmentActivity r1 = getActivity();
        PluginHost r2 = getHost();
        if (r2 == null) goto L10;
        Fragment r3 = r2.getHostFragment();
    L11:
        r6.getClass();
        this.backPressDispatcher = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g.a(r1, r3);
        goto L12
    L10:
        r3 = null;
    L12:
        sa5.b r7 = this.backPressDispatcher;
        if (r7 == null) goto L15;
        r7.e(this.backPress);
    L15:
        this.hasnotifyOrientation = true;
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

    private final ocb.a removeAndGetKeyboardObserver(wlb.d.a r2) {
        return this.keyboardObserverMap.remove(r2);
    }

    private final void showPopOver(String r10) {
        tt5.a.h(TAG, "showPopOver()");
        if (isUIContainerDetached() == false) goto L6;
        tt5.a.h(TAG, "showPopOver, isPopOverShowing = true, or isUIContainerDetached = " + isUIContainerDetached());
        return;
    L6:
        BaseTitlePlugin r0 = (BaseTitlePlugin) findPlugin(BaseTitlePlugin.class);
        if (r0 == null) goto L9;
        r0.setTitleBarVisible();
    L9:
        int[] r4 = null;
        View r2 = LayoutInflater.from(getActivity()).inflate(2131559969, null);
        this.popoverView = r2;
        if (r2 == null) goto L14;
        TextView r3 = (TextView) r2.findViewById(2131391129);
        if (r3 == null) goto L14;
        r3.setText(r10);
    L14:
        View r11 = this.popoverView;
        if (r11 == null) goto L17;
        ViewGroup r12 = (ViewGroup) r11.findViewById(2131368229);
    L18:
        DocViewModel r5 = getDocViewModel();
        if (r5 == null) goto L21;
        DocsOpenSource r6 = r5.getOpenSource();
    L22:
        int r7 = 0;
        if (r6 != DocsOpenSource.vc) goto L25;
        boolean r8 = true;
    L26:
        if (r8 == false) goto L28;
        View r9 = INVOKEVIRTUAL_com_bytedance_ee_bear_document_ai_creationai_CreationAIPlugin_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getActivity().getWindow());
    L29:
        TitleMenuPlugin r13 = (TitleMenuPlugin) findPlugin(TitleMenuPlugin.class);
        if (r13 == null) goto L32;
        int r14 = r13.getAIIconPadding();
    L33:
        int r16 = dp(r14) - dp(3);
        if (r13 == null) goto L36;
        int r17 = r13.getAIIconIndex();
    L37:
        if (r17 <= 0) goto L43;
        if (r0 == null) goto L40;
        int r18 = r0.getAiRightIconPosition(r17);
    L41:
        if (r18 <= 0) goto L43;
        r16 = r18 - dp(28);
        goto L43
    L40:
        r18 = 0;
    L43:
        if (r0 == null) goto L45;
        r4 = r0.getTitleBarHeightLocation();
    L45:
        if (r12 == null) goto L57;
        ViewGroup.LayoutParams r19 = r12.getLayoutParams();
        if (r19 == null) goto L57;
        if ((r19 instanceof ViewGroup.MarginLayoutParams) == false) goto L57;
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) r19;
        r110.setMarginEnd(r16);
        if (r4 == null) goto L53;
        r7 = r4[1];
    L53:
        int[] r20 = new int[2];
        r9.getLocationOnScreen(r20);
        if (r7 <= 0) goto L57;
        r110.topMargin = ((r7 - r20[1]) + dp(50)) - dp(10);
    L57:
        if ((r9 instanceof ViewGroup) == false) goto L61;
        ViewGroup r21 = (ViewGroup) r9;
        r21.addView(this.popoverView);
        r21.postDelayed(new q(this, r0), ToastModel.DEFAULT_DURATION);
        if (r0 == null) goto L63;
        r0.setNotifyTitleBarHideRunnable(new r(this, r0));
        return;
    L63:
        return;
    L61:
        tt5.a.d(TAG, "attachPopOver, containerView is not ViewGroup");
        return;
    L36:
        r17 = 0;
        goto L37
    L32:
        r14 = 27;
        goto L33
    L28:
        r9 = getUIContainer().c(this);
        goto L29
    L25:
        r8 = false;
        goto L26
    L21:
        r6 = null;
        goto L22
    L17:
        r12 = null;
        goto L18
    }

    public final int dp(int r1) {
        return y9c.d.a(r1);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put("biz.creationAI.show", new g(this));
        r3.put("biz.creationAI.message", new d(this));
        r3.put("biz.creationAI.feedback", new b(this));
        r3.put("biz.creationAI.sendMessageToPreviewComponent", new i(this));
        r3.put("biz.creationAI.onMessageFromPreviewComponent", new h(this));
        r3.put("biz.creationAI.modelSetting", new e(this));
        r3.put("biz.creationAI.history", new c(this));
        r3.put("biz.creationAI.popover", new f(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r3) {
        super.onAttachToHost(r3);
        this.keyboardHeightProvider = pcb.a.a.b(getActivity());
        OopsPluginV2 r4 = (OopsPluginV2) findPlugin(OopsPluginV2.class);
        if (r4 == null) goto L7;
        MutableLiveData<Boolean> r5 = r4.getIsClickRefresh();
        if (r5 == null) goto L7;
        r5.observe(getLifecycleOwner(), new o(this));
    L7:
        FollowPlugin r6 = (FollowPlugin) findPlugin(FollowPlugin.class);
        if (r6 == null) goto L12;
        BaseFollowImpl r7 = r6.getDocumentFollow();
        if (r7 == null) goto L12;
        r7.registerDocFollowStateObserver(new p(this));
    L12:
        com.bytedance.ee.bear.document.ai.inlineai.a r8 = new com.bytedance.ee.bear.document.ai.inlineai.a();
        this.editPanel = r8;
        ((EditPanelsManager) new ViewModelProvider(getActivity()).get(EditPanelsManager.class)).registerEditPanel(getLifecycleOwner(), r8);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r1) {
        super.onDetachFromHost(r1);
        destroy();
    }

    public static final /* synthetic */ vlb.c access$ensureSdk(CreationAIPlugin r0, CreationAIPanel r1) {
        return r0.ensureSdk(r1);
    }

    public static final /* synthetic */ ocb.a access$getOrCreateKeyboardObserver(CreationAIPlugin r0, wlb.d.a r1) {
        return r0.getOrCreateKeyboardObserver(r1);
    }

    public static final /* synthetic */ void access$handleOrientation(CreationAIPlugin r0, boolean r1) {
        r0.handleOrientation(r1);
    }

    public static final /* synthetic */ void access$notifyOrientationSupportPanelState(CreationAIPlugin r0, boolean r1) {
        r0.notifyOrientationSupportPanelState(r1);
    }

    public static final /* synthetic */ ocb.a access$removeAndGetKeyboardObserver(CreationAIPlugin r0, wlb.d.a r1) {
        return r0.removeAndGetKeyboardObserver(r1);
    }

    public static final /* synthetic */ void access$setCreationAISdk$p(CreationAIPlugin r0, vlb.c r1) {
        r0.creationAISdk = r1;
    }

    public static final /* synthetic */ void access$setCurrentScene$p(CreationAIPlugin r0, String r1) {
        r0.currentScene = r1;
    }

    public static final /* synthetic */ void access$setDisableLandscape$p(CreationAIPlugin r0, boolean r1) {
        r0.disableLandscape = r1;
    }

    public static final /* synthetic */ void access$setMCallback$p(CreationAIPlugin r0, tb5.m r1) {
        r0.mCallback = r1;
    }

    public static final /* synthetic */ void access$setMEditorCallback$p(CreationAIPlugin r0, tb5.m r1) {
        r0.mEditorCallback = r1;
    }

    public static final /* synthetic */ void access$setMKeyboardShow$p(CreationAIPlugin r0, boolean r1) {
        r0.mKeyboardShow = r1;
    }

    public static final /* synthetic */ void access$showPopOver(CreationAIPlugin r0, String r1) {
        r0.showPopOver(r1);
    }

    @Override // sa5.a
    public void onActivityResult(int r2, int r3, Intent r4) {
        vlb.c r0 = this.creationAISdk;
        if (r0 == null) goto L6;
        r0.onActivityResult(r2, r3, r4);
        return;
    }

    public static /* synthetic */ vlb.c ensureSdk$default(CreationAIPlugin r0, CreationAIPanel r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.ensureSdk(r1);
    }
}
