package com.bytedance.ee.bear.document.ai.knowledgeai;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.drive.biz.versions.model.VersionPayLoadData;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.inline.ai.api.knowledgeai.CCMKnowledgePageConfig;
import com.ss.android.lark.inline.ai.api.knowledgeai.IAiScopeItemI18nText;
import com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIScopeItemInfo;
import com.ss.android.lark.inline.ai.api.knowledgeai.KnowledgeAIControlInfoBean;
import com.ss.android.lark.inline.ai.api.knowledgeai.KnowledgeAIPageMode;
import com.ss.android.lark.utils.x;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020%H\u0002J\u000e\u0010)\u001a\u00020%H\u0082@¢\u0006\u0002\u0010*J\u000e\u0010+\u001a\u00020%H\u0082@¢\u0006\u0002\u0010*J\u001c\u0010,\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020%H\u0002J\b\u00100\u001a\u00020%H\u0002J\u001e\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u0001042\b\b\u0001\u00105\u001a\u00020\u001eH\u0002J\n\u00106\u001a\u0004\u0018\u00010\u0015H\u0002J \u00107\u001a\u00020%2\u0016\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u0003090\u0017H\u0016J\b\u0010:\u001a\u00020#H\u0002J\u0006\u0010;\u001a\u00020%J\b\u0010<\u001a\u00020=H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\t\u0018\u00010\u0018¢\u0006\u0002\b\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/knowledgeai/KnowledgeAIPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "knowledgeAIViewModel", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/CCMKnowledgePageFlow;", "getKnowledgeAIViewModel", "()Lcom/ss/android/lark/inline/ai/api/knowledgeai/CCMKnowledgePageFlow;", "knowledgeAIViewModel$delegate", "Lkotlin/Lazy;", "ccmKnowledgeAISdk", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/CCMKnowledgeAISdk;", "getCcmKnowledgeAISdk", "()Lcom/ss/android/lark/inline/ai/api/knowledgeai/CCMKnowledgeAISdk;", "ccmKnowledgeAISdk$delegate", "knowledgeAINetRepository", "Lcom/bytedance/ee/bear/document/ai/knowledgeai/KnowledgeAINetRepository;", "getKnowledgeAINetRepository", "()Lcom/bytedance/ee/bear/document/ai/knowledgeai/KnowledgeAINetRepository;", "knowledgeAINetRepository$delegate", "aiFragment", "Lcom/bytedance/ee/bear/document/ai/knowledgeai/DocKnowledgeAIFragment;", "trackParams", "", "", "objToken", "Lorg/jspecify/annotations/Nullable;", "getObjToken", "()Ljava/lang/String;", "objType", "", "getObjType", "()I", "isVisibleFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "collectFlow", "fetchControlInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchScopeInfo", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "showMainAIPanel", "hideMainAIPanel", "findTargetIdOnFragment", "Landroidx/fragment/app/FragmentManager;", "fragment", "Landroidx/fragment/app/Fragment;", "id", "createFragment", "getBridgeHandlers", "handlersHolder", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "isAiFeatureGatingEnable", "destroy", "pageConfig", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/CCMKnowledgePageConfig;", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KnowledgeAIPlugin extends DocumentPlugin {
    public static final a Companion = null;
    public static final String KEY_AI_ENABLE = "ccm.ai.doc.mobile.knowledge_ai_enable";
    public static final String KEY_MEETING_ENABLE = "ccm.ai.meeting_ask_block_expand";
    public static final String SP_KEY_RECENT_AI_TOPIC = "sp_key_recent_ai_topic";
    public static final String TAG = "KnowledgeAIPlugin";
    public static final long TOPIC_EXPIRED_TIME_MS = 1800000;
    private DocKnowledgeAIFragment aiFragment;
    private final Lazy ccmKnowledgeAISdk$delegate;
    private final z0<Boolean> isVisibleFlow;
    private final Lazy knowledgeAINetRepository$delegate;
    private final Lazy knowledgeAIViewModel$delegate;
    private final Map<String, String> trackParams;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.knowledgeai.KnowledgeAIPlugin$collectFlow$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.document.ai.knowledgeai.KnowledgeAIPlugin$collectFlow$1", f = "KnowledgeAIPlugin.kt", i = {}, l = {VersionPayLoadData.OPERATION_DELETE}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ KnowledgeAIPlugin this$0;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.knowledgeai.KnowledgeAIPlugin$collectFlow$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ KnowledgeAIPlugin a;
            public final /* synthetic */ BaseUnspecifiedOrientationPlugin<?> b;

            public a(KnowledgeAIPlugin r2, BaseUnspecifiedOrientationPlugin r3) {
                b r0 = b.a;
                this.a = r2;
                this.b = r3;
            }

            public final Object emit(Object r1, Continuation r2) {
                if (((KnowledgeAIPageMode) r1) == KnowledgeAIPageMode.HIDE) goto L7;
                KnowledgeAIPlugin.access$showMainAIPanel(this.a);
                BaseUnspecifiedOrientationPlugin<?> r3 = this.b;
                if (r3 == null) goto L11;
                r3.onOrientationSupportPanelShowing(b.a);
            L11:
                return Unit.INSTANCE;
            L7:
                KnowledgeAIPlugin.access$hideMainAIPanel(this.a);
                BaseUnspecifiedOrientationPlugin<?> r4 = this.b;
                if (r4 == null) goto L11;
                r4.onOrientationSupportPanelDismiss(b.a);
                goto L11
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.knowledgeai.KnowledgeAIPlugin$collectFlow$1$b */
        public static final class b implements p {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            @Override // com.bytedance.ee.bear.document.orientation.p
            public final boolean shouldDisableLandscape() {
                return true;
            }
        }

        public AnonymousClass1(KnowledgeAIPlugin r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
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
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            BaseUnspecifiedOrientationPlugin r7 = (BaseUnspecifiedOrientationPlugin) KnowledgeAIPlugin.access$findPlugin(this.this$0, BaseUnspecifiedOrientationPlugin.class);
            b r2 = b.a;
            StateFlowImpl r3 = KnowledgeAIPlugin.access$getKnowledgeAIViewModel(this.this$0).g();
            a r4 = new a(this.this$0, r7);
            this.label = 1;
            if (r3.collect(r4, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.knowledgeai.KnowledgeAIPlugin$fetchControlInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.document.ai.knowledgeai.KnowledgeAIPlugin", f = "KnowledgeAIPlugin.kt", i = {}, l = {116}, m = "fetchControlInfo", n = {}, s = {})
    public static final class C03381 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ KnowledgeAIPlugin this$0;

        public C03381(KnowledgeAIPlugin r1, Continuation<? super C03381> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= ShareItemModel.SRC_TINT_UNDEFINED;
            return KnowledgeAIPlugin.access$fetchControlInfo(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.knowledgeai.KnowledgeAIPlugin$fetchScopeInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.document.ai.knowledgeai.KnowledgeAIPlugin", f = "KnowledgeAIPlugin.kt", i = {}, l = {139}, m = "fetchScopeInfo", n = {}, s = {})
    public static final class C03391 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ KnowledgeAIPlugin this$0;

        public C03391(KnowledgeAIPlugin r1, Continuation<? super C03391> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= ShareItemModel.SRC_TINT_UNDEFINED;
            return KnowledgeAIPlugin.access$fetchScopeInfo(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.knowledgeai.KnowledgeAIPlugin$onAttachToHost$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.document.ai.knowledgeai.KnowledgeAIPlugin$onAttachToHost$1", f = "KnowledgeAIPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ KnowledgeAIPlugin this$0;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.knowledgeai.KnowledgeAIPlugin$onAttachToHost$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.bytedance.ee.bear.document.ai.knowledgeai.KnowledgeAIPlugin$onAttachToHost$1$1", f = "KnowledgeAIPlugin.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ KnowledgeAIPlugin this$0;

            public C00531(KnowledgeAIPlugin r1, Continuation<? super C00531> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00531(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r4);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                KnowledgeAIPlugin r5 = this.this$0;
                this.label = 1;
                if (KnowledgeAIPlugin.access$fetchControlInfo(r5, this) != r0) goto L12;
                return r0;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.knowledgeai.KnowledgeAIPlugin$onAttachToHost$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.bytedance.ee.bear.document.ai.knowledgeai.KnowledgeAIPlugin$onAttachToHost$1$2", f = "KnowledgeAIPlugin.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ KnowledgeAIPlugin this$0;

            public AnonymousClass2(KnowledgeAIPlugin r1, Continuation<? super AnonymousClass2> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass2(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r4);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                KnowledgeAIPlugin r5 = this.this$0;
                this.label = 1;
                if (KnowledgeAIPlugin.access$fetchScopeInfo(r5, this) != r0) goto L12;
                return r0;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.knowledgeai.KnowledgeAIPlugin$onAttachToHost$1$3, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.bytedance.ee.bear.document.ai.knowledgeai.KnowledgeAIPlugin$onAttachToHost$1$3", f = "KnowledgeAIPlugin.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ KnowledgeAIPlugin this$0;

            /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.knowledgeai.KnowledgeAIPlugin$onAttachToHost$1$3$a */
            public static final class a<T> implements FlowCollector {
                public final /* synthetic */ KnowledgeAIPlugin a;

                public a(KnowledgeAIPlugin r1) {
                    this.a = r1;
                }

                public final Object emit(Object r1, Continuation r2) {
                    boolean r3 = ((Boolean) r1).booleanValue();
                    KnowledgeAIPlugin.access$isVisibleFlow$p(this.a).setValue(Boxing.boxBoolean(r3));
                    return Unit.INSTANCE;
                }
            }

            public AnonymousClass3(KnowledgeAIPlugin r1, Continuation<? super AnonymousClass3> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass3(this.this$0, r3);
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
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r5);
            L19:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                MutableSharedFlow r6 = KnowledgeAIPlugin.access$getKnowledgeAIViewModel(this.this$0).d();
                a r2 = new a(this.this$0);
                this.label = 1;
                Object r7 = r6.collect(new KnowledgeAIPlugin$onAttachToHost$1$3$invokeSuspend$$inlined$filter$1$2(new KnowledgeAIPlugin$onAttachToHost$1$3$invokeSuspend$$inlined$map$1$2(r2)), this);
                if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
                r7 = Unit.INSTANCE;
            L13:
                if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
                r7 = Unit.INSTANCE;
            L16:
                if (r7 != r0) goto L19;
                return r0;
            }
        }

        public C03401(KnowledgeAIPlugin r1, Continuation<? super C03401> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C03401 r0 = new C03401(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r8);
            CoroutineScope r9 = (CoroutineScope) this.L$0;
            BuildersKt.launch$default(r9, null, null, new C00531(this.this$0, null), 3, null);
            BuildersKt.launch$default(r9, null, null, new AnonymousClass2(this.this$0, null), 3, null);
            BuildersKt.launch$default(r9, null, null, new AnonymousClass3(this.this$0, null), 3, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
    }

    public final void destroy() {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final DocKnowledgeAIFragment createFragment() {
        DocKnowledgeAIFragment r0 = instantiateFragment(DocKnowledgeAIFragment.class);
        this.aiFragment = r0;
        r0.d = getCcmKnowledgeAISdk();
        return r0;
    }

    private final com.ss.android.lark.inline.ai.api.knowledgeai.c getCcmKnowledgeAISdk() {
        return (com.ss.android.lark.inline.ai.api.knowledgeai.c) this.ccmKnowledgeAISdk$delegate.getValue();
    }

    private final n getKnowledgeAINetRepository() {
        return (n) this.knowledgeAINetRepository$delegate.getValue();
    }

    private final com.ss.android.lark.inline.ai.api.knowledgeai.d getKnowledgeAIViewModel() {
        return (com.ss.android.lark.inline.ai.api.knowledgeai.d) this.knowledgeAIViewModel$delegate.getValue();
    }

    private final void hideMainAIPanel() {
        DocKnowledgeAIFragment r0 = this.aiFragment;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isAdded() == false) goto L7;
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_ai_knowledgeai_KnowledgeAIPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r0);
    L7:
        this.aiFragment = null;
    }

    private final boolean isAiFeatureGatingEnable() {
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        if (r0.g(KEY_AI_ENABLE) == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        tt5.a.h(TAG, "isAiFeatureGatingEnable: " + r1);
        return r1;
    L5:
        if (r0.g(KEY_MEETING_ENABLE) == false) goto L7;
        r1 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.bytedance.ee.bear.browser.plugin.PluginHost] */
    private final CCMKnowledgePageConfig pageConfig() {
        CCMKnowledgePageConfig.Builder r0 = new CCMKnowledgePageConfig.Builder();
        DocumentPluginHost r1 = (DocumentPluginHost) getHost();
        if (r1 == null) goto L5;
        final DocViewModel r2 = r1.a();
    L6:
        r0.a = new com.ss.android.lark.inline.ai.api.knowledgeai.b(getHost(), new d(((by4.d) ((DocumentPluginHost) getHost()).getUserComponent().a(by4.d.class)).b("document")), new c(), new e(), new KnowledgeAIPlugin$pageConfig$1$1(this));
        Function0<String> r3 = new KnowledgeAIPlugin$pageConfig$1$2(r2);
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.b = r3;
        String r4 = (String) r3.invoke();
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        new com.ss.android.lark.inline.ai.api.knowledgeai.g("sp_key_recent_ai_topic_".concat(r4));
        Function0<Map<String, String>> r5 = new KnowledgeAIPlugin$pageConfig$1$3(this);
        r0.c = r5;
        com.ss.android.lark.inline.ai.api.knowledgeai.b r6 = r0.a;
        if (r6 == null) goto L14;
        return new CCMKnowledgePageConfig(r6, r0.b, r5);
    L14:
        throw new IllegalArgumentException("abilityDependencies is null");
    L5:
        r2 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showMainAIPanel() {
        DocKnowledgeAIFragment r0 = this.aiFragment;
        if (r0 != null) goto L5;
        r0 = createFragment();
    L5:
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isAdded() == true) goto L18;
        FragmentManager r1 = findTargetIdOnFragment(((DocumentPluginHost) getHost()).getHostFragment(), 2131382749);
        if (r1 != null) goto L11;
    L15:
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_ai_knowledgeai_KnowledgeAIPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r0, getFragmentManager(), DocKnowledgeAIFragment.class.getName());
        return;
    L11:
        if (ForsetiHelper.s(((DocumentPluginHost) getHost()).getHostFragment()) == false) goto L15;
        if (DowngradeSettingUtil.a("downgradeCCMAiPanelOnActivityContent") == true) goto L15;
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_ai_knowledgeai_KnowledgeAIPlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r1.beginTransaction(), 2131382749, r0).commitAllowingStateLoss();
        return;
    }

    public KnowledgeAIPlugin() {
        this.knowledgeAIViewModel$delegate = LazyKt.lazy(new KnowledgeAIPlugin$knowledgeAIViewModel$2(this));
        this.ccmKnowledgeAISdk$delegate = LazyKt.lazy(new KnowledgeAIPlugin$ccmKnowledgeAISdk$2(this));
        this.knowledgeAINetRepository$delegate = LazyKt.lazy(new KnowledgeAIPlugin$knowledgeAINetRepository$2(this));
        this.trackParams = new LinkedHashMap();
        this.isVisibleFlow = j1.a(Boolean.FALSE);
    }

    private final void collectFlow() {
        LifecycleOwnerKt.getLifecycleScope(getLifecycleOwner()).launchWhenStarted(new AnonymousClass1(this, null));
    }

    private final String getObjToken() {
        return (String) getDocViewModel().liveDocObjToken().getValue();
    }

    private final int getObjType() {
        return getDocViewModel().getDocumentTypeValue();
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_document_ai_knowledgeai_KnowledgeAIPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(DocKnowledgeAIFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static final /* synthetic */ com.ss.android.lark.inline.ai.api.knowledgeai.c access$getCcmKnowledgeAISdk(KnowledgeAIPlugin r0) {
        return r0.getCcmKnowledgeAISdk();
    }

    public static final /* synthetic */ com.ss.android.lark.inline.ai.api.knowledgeai.d access$getKnowledgeAIViewModel(KnowledgeAIPlugin r0) {
        return r0.getKnowledgeAIViewModel();
    }

    public static final /* synthetic */ Map access$getTrackParams$p(KnowledgeAIPlugin r0) {
        return r0.trackParams;
    }

    public static final /* synthetic */ void access$hideMainAIPanel(KnowledgeAIPlugin r0) {
        r0.hideMainAIPanel();
    }

    public static final /* synthetic */ z0 access$isVisibleFlow$p(KnowledgeAIPlugin r0) {
        return r0.isVisibleFlow;
    }

    public static final /* synthetic */ CCMKnowledgePageConfig access$pageConfig(KnowledgeAIPlugin r0) {
        return r0.pageConfig();
    }

    public static final /* synthetic */ void access$showMainAIPanel(KnowledgeAIPlugin r0) {
        r0.showMainAIPanel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object fetchControlInfo(Continuation<? super Unit> r16) {
        if ((r16 instanceof C03381) == false) goto L7;
        C03381 r0 = (C03381) r16;
        int r1 = r0.label;
        if ((r1 & ShareItemModel.SRC_TINT_UNDEFINED) == 0) goto L7;
        r0.label = r1 - ShareItemModel.SRC_TINT_UNDEFINED;
    L8:
        Object r17 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r17);
    L35:
        KnowledgeAIControlInfoResponse r18 = (KnowledgeAIControlInfoResponse) r17;
        tt5.a.h(TAG, "fetchControlInfo: " + r18);
        if (r18 == null) goto L38;
        boolean r5 = Intrinsics.areEqual(r18.getAskUseable(), Boxing.boxBoolean(true));
    L39:
        if (r5 == true) goto L41;
    L43:
        r4 = false;
    L44:
        getKnowledgeAIViewModel().e(new com.ss.android.lark.inline.ai.api.knowledgeai.e.a(new KnowledgeAIControlInfoBean(r4)));
        return Unit.INSTANCE;
    L41:
        if (r18.isEnable() == false) goto L43;
    L38:
        r5 = false;
        goto L39
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r17);
        com.bytedance.ee.bear.lark.dependency.b r19 = (com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.b.class, null, null, 6);
        n r6 = getKnowledgeAINetRepository();
        KnowledgeAIControlInfoRequest r13 = new KnowledgeAIControlInfoRequest(r19.getUserId(), r19.getTenantId(), Boxing.boxInt(1), getObjToken(), Boxing.boxInt(getObjType()), Boxing.boxBoolean(true), Boxing.boxBoolean(true));
        r0.label = 1;
        r6.getClass();
        kotlinx.coroutines.j r110 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);
        r110.C();
        NetService.f r7 = new NetService.f("/space/api/inline_ai/inline_mode/control_info");
        Object r8 = JSON.toJSON(r13);
        if ((r8 instanceof JSONObject) == false) goto L17;
        JSONObject r9 = (JSONObject) r8;
    L18:
        if (r9 == null) goto L29;
        Map r10 = r9.getInnerMap();
        if (r10 == null) goto L29;
        Map r11 = new LinkedHashMap(MapsKt.mapCapacity(r10.size()));
        Iterator r12 = r10.entrySet().iterator();
    L23:
        if (r12.hasNext() == false) goto L30;
        Map.Entry r14 = (Map.Entry) r12.next();
        Object r20 = r14.getKey();
        Object r21 = r14.getValue();
        if (r21 == null) goto L27;
        String r22 = r21.toString();
    L28:
        r11.put(r20, r22);
        goto L23
    L27:
        r22 = null;
    L30:
        r7.d(r11);
        r7.c = 2;
        final Disposable r23 = r6.a.Vc(j.a).a(r7).map(k.a).subscribe(new f(r110), new g(r110));
        r110.i(new KnowledgeAINetRepository$awaitFetchControlInfo$2$1(r23));
        r17 = r110.B();
        if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L33;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L33:
        if (r17 != r2) goto L35;
        return r2;
    L29:
        r11 = MapsKt.emptyMap();
        goto L30
    L17:
        r9 = null;
    L7:
        r0 = new C03381(this, r16);
        goto L8
    }

    private final Object fetchScopeInfo(Continuation<? super Unit> r9) {
        if ((r9 instanceof C03391) == false) goto L7;
        C03391 r0 = (C03391) r9;
        int r1 = r0.label;
        if ((r1 & ShareItemModel.SRC_TINT_UNDEFINED) == 0) goto L7;
        r0.label = r1 - ShareItemModel.SRC_TINT_UNDEFINED;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r10);
    L19:
        com.ss.android.lark.inline.ai.api.knowledgeai.f r11 = (com.ss.android.lark.inline.ai.api.knowledgeai.f) r10;
        StringBuilder r4 = new StringBuilder("fetchScopeInfo: isVcMeetingNote=");
        r4.append(r11.a);
        r4.append(", docNames=");
        List r5 = r11.b;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r7 = r5.iterator();
    L21:
        if (r7.hasNext() == false) goto L27;
        IAiScopeItemI18nText r8 = ((IKnowledgeAIScopeItemInfo) r7.next()).getText();
        if (r8 == null) goto L25;
        String r12 = r8.getDefaultText();
    L26:
        r6.add(r12);
        goto L21
    L25:
        r12 = null;
        goto L26
    L27:
        r4.append(r6);
        tt5.a.h(TAG, r4.toString());
        this.trackParams.put("ccm_is_meeting_notes", String.valueOf(r11.a));
        getKnowledgeAIViewModel().e(new com.ss.android.lark.inline.ai.api.knowledgeai.e.d(r11));
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        n r13 = getKnowledgeAINetRepository();
        Integer r14 = Boxing.boxInt(getObjType());
        String r16 = getObjToken();
        r0.label = 1;
        r13.getClass();
        kotlinx.coroutines.j r17 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);
        r17.C();
        NetService.f r18 = new NetService.f("/space/api/inline_ai/check_vc_meeting_doc_index?obj_type=" + r14 + "&obj_token=" + r16);
        r18.c = 2;
        final Disposable r19 = r13.a.Vc(l.a).a(r18).map(m.a).subscribe(new h(r17), new i(r17));
        r17.i(new KnowledgeAINetRepository$awaitFetchScopeInfo$2$1(r19));
        r10 = r17.B();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L17:
        if (r10 != r2) goto L19;
        return r2;
    L7:
        r0 = new C03391(this, r9);
        goto L8
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r4) {
        Intrinsics.checkNotNullParameter(r4, "handlersHolder");
        if (isAiFeatureGatingEnable() == true) goto L5;
        return;
    L5:
        r4.put("biz.knowledgeAI.status", new BridgeAIStatusHandler(getKnowledgeAIViewModel(), this.isVisibleFlow));
        r4.put("biz.knowledgeAI.recommend", new com.bytedance.ee.bear.document.ai.knowledgeai.a(getKnowledgeAIViewModel()));
        r4.put("biz.knowledgeAI.show", new b(getKnowledgeAIViewModel()));
        r4.put("biz.knowledgeAI.message", new BridgeKnowledgeAIMessageHandler(getKnowledgeAIViewModel()));
    }

    public void onAttachToHost(DocumentPluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super.onAttachToHost(r3);
        tt5.a.h(TAG, "onAttachToHost: objType=" + getObjType());
        if (isAiFeatureGatingEnable() == true) goto L5;
        return;
    L5:
        this.trackParams.put("ccm_product_type", "doc");
        this.trackParams.put("ccm_file_type", getDocViewModel().getDocumentType());
        Map<String, String> r4 = this.trackParams;
        int r0 = x.a;
        String r1 = getObjToken();
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        String r5 = "";
    L15:
        r4.put("ccm_file_id", r5);
        com.ss.android.lark.inline.ai.api.knowledgeai.d r6 = getKnowledgeAIViewModel();
        getObjToken();
        r6.setup();
        collectFlow();
        LifecycleOwnerKt.getLifecycleScope(getLifecycleOwner()).launchWhenStarted(new C03401(this, null));
        return;
    L14:
        String r7 = "08a441".concat(new String(w28.a.a(x28.a.a(r1 + "42b91e"))));
        Intrinsics.checkNotNullParameter(r7, "s");
        r5 = new String(w28.a.a(x28.a.b(r7)));
        goto L15
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L12
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public static final /* synthetic */ Object access$fetchControlInfo(KnowledgeAIPlugin r0, Continuation r1) {
        return r0.fetchControlInfo(r1);
    }

    public static final /* synthetic */ Object access$fetchScopeInfo(KnowledgeAIPlugin r0, Continuation r1) {
        return r0.fetchScopeInfo(r1);
    }

    public static final /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$findPlugin(KnowledgeAIPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    private final FragmentManager findTargetIdOnFragment(Fragment r3, int r4) {
        View r0 = null;
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.isAdded() == false) goto L14;
        View r1 = r3.getView();
        if (r1 == null) goto L10;
        r0 = r1.findViewById(r4);
    L10:
        if (r0 == null) goto L14;
        return r3.getChildFragmentManager();
    L14:
        return findTargetIdOnFragment(r3.getParentFragment(), r4);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_document_ai_knowledgeai_KnowledgeAIPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(DocKnowledgeAIFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        DocKnowledgeAIFragment r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_bytedance_ee_bear_document_ai_knowledgeai_KnowledgeAIPlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r2, int r3, Fragment r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, r3) == false) goto L6;
        return r2;
    L6:
        return r2.add(r3, r4);
    }
}
