package com.larus.bmhome.chat.detail.code;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.chat.detail.AbstractCommonDetailFragment;
import com.larus.bmhome.chat.detail.code.artifact.request.CodeNodeContent;
import com.larus.bmhome.chat.detail.code.view.PreviewSwitchButton;
import com.larus.bmhome.chat.font.FontLevel;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.bmhome.web.AiChatHostWebService;
import com.larus.bmhome.web.IAiChatHostWebService;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.mainbot.impl.databinding.LarusFragmentCodeBlockDetailBinding;
import com.larus.mainbot.impl.databinding.LarusPageDeepResearchErrorBinding;
import com.larus.mainbot.impl.databinding.LarusPageDeepResearchLoadingBinding;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u0090\u00012\u00020\u00012\u00020\u0002:\u0002\u0090\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u00106\u001a\u000207H\u0002J\b\u0010@\u001a\u000207H\u0002J\b\u0010A\u001a\u000207H\u0002J\n\u0010L\u001a\u0004\u0018\u00010MH\u0016J\b\u0010N\u001a\u00020OH\u0016J\b\u0010P\u001a\u00020OH\u0016J\n\u0010Q\u001a\u0004\u0018\u00010\u0018H\u0014J\f\u0010T\u001a\u00020'*\u00020'H\u0002J\b\u0010U\u001a\u000207H\u0002J\u0012\u0010V\u001a\u0002072\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\b\u0010Y\u001a\u000207H\u0002J&\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010M2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\u001a\u0010_\u001a\u0002072\u0006\u0010`\u001a\u00020[2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\b\u0010a\u001a\u000207H\u0002J\u0010\u0010b\u001a\u0002072\u0006\u0010c\u001a\u00020dH\u0002J\u001a\u0010e\u001a\u0002072\b\u0010f\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u001a\u0010g\u001a\u00020\u00182\b\u0010f\u001a\u0004\u0018\u00010\u00182\u0006\u0010h\u001a\u00020\u0012H\u0002J\b\u0010i\u001a\u000207H\u0016J\u0006\u0010j\u001a\u00020\u0018J\b\u0010k\u001a\u000207H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010l\u001a\u00020\u0012H\u0016J\b\u0010m\u001a\u000207H\u0002J\u0012\u0010n\u001a\u0002072\b\b\u0002\u0010\u001f\u001a\u00020\u0012H\u0002J\b\u0010o\u001a\u000207H\u0002J\b\u0010p\u001a\u000207H\u0002J\u0010\u0010q\u001a\u0002072\u0006\u0010r\u001a\u00020'H\u0002J0\u0010s\u001a\u0002072\b\b\u0002\u0010t\u001a\u00020\u00122\b\b\u0002\u0010u\u001a\u00020\u00122\b\b\u0002\u0010v\u001a\u00020\u00122\b\b\u0002\u0010w\u001a\u00020\u0012H\u0002J\u0010\u0010x\u001a\u0002072\u0006\u0010y\u001a\u00020'H\u0002J\b\u0010z\u001a\u000207H\u0002J$\u0010{\u001a\u0004\u0018\u00010|2\u0006\u0010}\u001a\u00020~2\u0007\u0010\u007f\u001a\u00030\u0080\u00012\u0007\u0010\u0081\u0001\u001a\u00020'H\u0002J\t\u0010\u0082\u0001\u001a\u00020\u0012H\u0016J\t\u0010\u0083\u0001\u001a\u000207H\u0003J\t\u0010\u0084\u0001\u001a\u000207H\u0002J\u001b\u0010\u0085\u0001\u001a\u0002072\u0007\u0010\u0086\u0001\u001a\u00020\u00182\u0007\u0010\u0087\u0001\u001a\u00020\u0012H\u0002J\t\u0010\u0088\u0001\u001a\u000207H\u0002J\t\u0010\u0089\u0001\u001a\u000207H\u0002J\t\u0010\u008a\u0001\u001a\u00020\u0012H\u0016J\t\u0010\u008b\u0001\u001a\u00020\u0018H\u0016J\u000b\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0010H\u0016J\t\u0010\u008d\u0001\u001a\u00020\u0018H\u0016J\u000b\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0018H\u0016J\t\u0010\u008f\u0001\u001a\u000207H\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0014\u001a\u0004\u0018\u00010\u0018@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0004\n\u0002\u0010%R\u0012\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0004\n\u0002\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010.\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u000e\u001a\u0004\b3\u00104R\u001d\u00108\u001a\u0004\u0018\u0001098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u000e\u001a\u0004\b:\u0010;R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010B\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\u000e\u001a\u0004\bD\u0010ER\u001b\u0010G\u001a\u00020H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\u000e\u001a\u0004\bI\u0010JR\u0010\u0010R\u001a\u0004\u0018\u00010SX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0091\u0001"}, d2 = {"Lcom/larus/bmhome/chat/detail/code/CodeBlockDetailFragment;", "Lcom/larus/bmhome/chat/detail/AbstractCommonDetailFragment;", "Lcom/larus/bmhome/chat/detail/code/ICodeBlockDetailFragmentAbility;", "dependency", "Lcom/larus/bmhome/chat/detail/code/ICodeBlockParamProvider;", "<init>", "(Lcom/larus/bmhome/chat/detail/code/ICodeBlockParamProvider;)V", "getDependency", "()Lcom/larus/bmhome/chat/detail/code/ICodeBlockParamProvider;", "viewModel", "Lcom/larus/bmhome/chat/detail/code/CodeBlockDetailViewModel;", "getViewModel", "()Lcom/larus/bmhome/chat/detail/code/CodeBlockDetailViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/mainbot/impl/databinding/LarusFragmentCodeBlockDetailBinding;", "enableScroll", "", "isCodeRefreshing", "value", "isCodeFinished", "setCodeFinished", "(Z)V", "", "threadId", "setThreadId", "(Ljava/lang/String;)V", "showPreviewButton", "isGeneralAgent", "generalAgentChatId", "isInPreview", "waitToPreview", "codeRenderScene", "Lcom/larus/bmhome/chat/detail/code/CodeRenderScene;", "codeArtifactId", "", "Ljava/lang/Long;", "codeArtifactVersion", "", "Ljava/lang/Integer;", "deepResearchId", "deepResearchResourceId", "isUserTouch", "eventExtra", "", "", "singleCodeRefreshThreadExecutor", "Ljava/util/concurrent/ExecutorService;", "singleCodeRefreshThreadDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "getSingleCodeRefreshThreadDispatcher", "()Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "singleCodeRefreshThreadDispatcher$delegate", "shutdownSingleCodeRefreshThreadExecutor", "", "codeBlockDetailPreviewAbility", "Lcom/larus/bmhome/chat/detail/code/preview/ICodeBlockDetailPreviewAbility;", "getCodeBlockDetailPreviewAbility", "()Lcom/larus/bmhome/chat/detail/code/preview/ICodeBlockDetailPreviewAbility;", "codeBlockDetailPreviewAbility$delegate", "codeLoadingCoverAnimator", "Landroid/animation/ValueAnimator;", "isInLoadingDotAnim", "startLoadingDotAnim", "stopLoadingDotAnim", "deepResearchCodeHelper", "Lcom/larus/bmhome/chat/detail/code/DeepResearchFetchCodeHelper;", "getDeepResearchCodeHelper", "()Lcom/larus/bmhome/chat/detail/code/DeepResearchFetchCodeHelper;", "deepResearchCodeHelper$delegate", "codeArtifactRenderHelper", "Lcom/larus/bmhome/chat/detail/code/artifact/request/CodeArtifactRenderHelper;", "getCodeArtifactRenderHelper", "()Lcom/larus/bmhome/chat/detail/code/artifact/request/CodeArtifactRenderHelper;", "codeArtifactRenderHelper$delegate", "getMarkDownTextViewContainer", "Landroid/view/ViewGroup;", "getMarkdownTextSize", "", "getLineSpacingMult", "getCopyContentType", "codeLoadingDot", "Landroidx/appcompat/widget/AppCompatImageView;", "adjustDotBottom", "createCodeLoadingViews", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "attachPreviewComponent", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "onViewCreated", "view", "fetchCodeArtifactCode", "processCodeArtifactRender", "codeNodeContent", "Lcom/larus/bmhome/chat/detail/code/artifact/request/CodeNodeContent;", "refreshCodeWithCodeCheck", "realText", "processStreamingCodeUpdate", "isBlockFinished", LiveCommonConstants.REASON_ON_DEDTROY, "getMsgId", "initTitleBar", "isInPreviewTab", "refreshButtonState", "changeTab", "refreshChangeLineStatus", "initViewModel", "setCodeLoadingPlaceholderMarginTop", "marginTop", "refreshMarkDownTextView", "useAsync", "scrollToBottomIfNeeded", "isCodeToBeFinished", "useGradientCover", "startCodeLoadingCoverAnim", "oldHeight", "scrollCodeTabToBottom", "getNewMarkdownContent", "Lcom/larus/business/markdown/api/model/MarkdownContent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "markDownTextView", "Lcom/larus/bmhome/view/textview/impl/CustomMarkdownTextView;", "maxContentWidth", "enableScrollDefault", "initListener", "fetchDeepResearchCode", "refreshCode", "code", "isFinished", "onCodeCompleted", "onCodeFail", "autoLogEnterPage", "getCurrentPageName", "getBinding", "getCode", "getLanguage", "onCodePreviewReady", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CodeBlockDetailFragment extends AbstractCommonDetailFragment implements l0 {

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final /* synthetic */ int f302708k0 = 0;
    public final m0 A;
    public final Lazy B;
    public LarusFragmentCodeBlockDetailBinding C;
    public boolean D;
    public volatile boolean E;
    public boolean F;
    public boolean G;
    public String H;
    public String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f302709J;
    public boolean K;
    public CodeRenderScene L;
    public Long M;
    public Integer N;
    public String O;
    public String P;
    public boolean Q;
    public Map<String, ? extends Object> R;
    public ExecutorService S;
    public final Lazy T;
    public final Lazy U;
    public ValueAnimator V;
    public boolean W;
    public final Lazy X;
    public final Lazy Y;
    public AppCompatImageView Z;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f302710a = null;

        static {
            int[] r100 = new int[CodeRenderScene.values().length];
            r100[CodeRenderScene.DeepSearch.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[CodeRenderScene.CodeArtifact.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f302710a = r100;
        }
    }

    public static final class c implements n0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CodeBlockDetailFragment f302711a;

        @Override // com.larus.bmhome.chat.detail.code.n0
        public final void b() {
        }

        @Override // com.larus.bmhome.chat.detail.code.n0
        public final void a() {
            CodeBlockDetailFragment r100 = this.f302711a;
            int r101 = CodeBlockDetailFragment.f302708k0;
            m0 r102 = r100.A;
            if (r102 == null) goto L5;
            r102.g(true);
        L5:
            r100.F = true;
            AppCompatImageView r103 = this.f302711a.Z;
            if (r103 == null) goto L8;
            r103.setVisibility(8);
        L8:
            this.f302711a.va0();
            this.f302711a.na0();
        }

        @Override // com.larus.bmhome.chat.detail.code.n0
        public final void d() {
            CodeBlockDetailFragment r100 = this.f302711a;
            int r101 = CodeBlockDetailFragment.f302708k0;
            r100.qc();
        }

        public c(CodeBlockDetailFragment r100) {
            this.f302711a = r100;
        }

        @Override // com.larus.bmhome.chat.detail.code.n0
        public final void c(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "code");
            CodeBlockDetailFragment r102 = this.f302711a;
            int r103 = CodeBlockDetailFragment.f302708k0;
            r102.qa0(r100, r101);
        }
    }

    public static final class d implements com.larus.bmhome.chat.detail.code.artifact.request.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CodeBlockDetailFragment f302712a;

        public final void b() {
            LarusFragmentCodeBlockDetailBinding r100 = this.f302712a.C;
            if (r100 == null) goto L7;
            View r101 = r100.f358607d;
            if (r101 == null) goto L7;
            e1.x(r101);
        L7:
            LarusFragmentCodeBlockDetailBinding r102 = this.f302712a.C;
            if (r102 == null) goto L14;
            LarusPageDeepResearchLoadingBinding r103 = r102.f358617n;
            if (r103 == null) goto L14;
            LinearLayout r104 = r103.f358812a;
            if (r104 == null) goto L14;
            e1.x(r104);
        L14:
            LarusFragmentCodeBlockDetailBinding r105 = this.f302712a.C;
            if (r105 == null) goto L22;
            LarusPageDeepResearchErrorBinding r106 = r105.f358616m;
            if (r106 == null) goto L23;
            ConstraintLayout r107 = r106.f358811a;
            if (r107 == null) goto L24;
            e1.o(r107);
            return;
        L24:
            return;
        L23:
            return;
        }

        @Override // com.larus.bmhome.chat.detail.code.artifact.request.b
        public final void onError() {
            LarusFragmentCodeBlockDetailBinding r100 = this.f302712a.C;
            if (r100 == null) goto L9;
            LarusPageDeepResearchLoadingBinding r101 = r100.f358617n;
            if (r101 == null) goto L9;
            LinearLayout r102 = r101.f358812a;
            if (r102 == null) goto L9;
            e1.o(r102);
        L9:
            LarusFragmentCodeBlockDetailBinding r103 = this.f302712a.C;
            if (r103 == null) goto L17;
            LarusPageDeepResearchErrorBinding r104 = r103.f358616m;
            if (r104 == null) goto L18;
            ConstraintLayout r105 = r104.f358811a;
            if (r105 == null) goto L19;
            e1.x(r105);
            return;
        L19:
            return;
        L18:
            return;
        }

        public d(CodeBlockDetailFragment r100) {
            this.f302712a = r100;
        }

        @Override // com.larus.bmhome.chat.detail.code.artifact.request.b
        public final void a(CodeNodeContent r100) {
            Intrinsics.checkNotNullParameter(r100, "codeNodeContent");
            LarusFragmentCodeBlockDetailBinding r101 = this.f302712a.C;
            if (r101 == null) goto L9;
            LarusPageDeepResearchLoadingBinding r102 = r101.f358617n;
            if (r102 == null) goto L9;
            LinearLayout r103 = r102.f358812a;
            if (r103 == null) goto L9;
            e1.o(r103);
        L9:
            LarusFragmentCodeBlockDetailBinding r104 = this.f302712a.C;
            if (r104 == null) goto L16;
            LarusPageDeepResearchErrorBinding r105 = r104.f358616m;
            if (r105 == null) goto L16;
            ConstraintLayout r106 = r105.f358811a;
            if (r106 == null) goto L16;
            e1.o(r106);
        L16:
            LarusFragmentCodeBlockDetailBinding r107 = this.f302712a.C;
            if (r107 == null) goto L21;
            View r108 = r107.f358607d;
            if (r108 == null) goto L21;
            e1.o(r108);
        L21:
            CodeBlockDetailFragment r109 = this.f302712a;
            r109.getClass();
            String r110 = r100.getContent();
            if (r110 != null) goto L24;
            r110 = "";
        L24:
            r109.qa0(r110, true);
            if (Intrinsics.areEqual(r100.getLanguage(), "html") == false) goto L28;
            r109.G = true;
            r109.ma0();
            r109.qc();
            return;
        }
    }

    public static final class e implements PreviewSwitchButton.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CodeBlockDetailFragment f302713a;

        public e(CodeBlockDetailFragment r100) {
            this.f302713a = r100;
        }

        @Override // com.larus.bmhome.chat.detail.code.view.PreviewSwitchButton.a
        public final void a(boolean r100) {
            CodeBlockDetailFragment r101 = this.f302713a;
            r101.f302709J = r100;
            r101.ia0(r100);
        }
    }

    public static final class f implements IIMCallback<Message> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CodeBlockDetailFragment f302714a;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return true;
        }

        public f(CodeBlockDetailFragment r100) {
            this.f302714a = r100;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(Message r100) {
            Message r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            com.larus.bmhome.chat.detail.i r102 = this.f302714a.f302677e;
            if (r102 == null) goto L5;
            r102.j(r101);
        L5:
            final CodeBlockDetailFragment r103 = this.f302714a;
            t0.c(new d0(r103));
        }
    }

    public static final class g implements IIMCallback<Message> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatImageView f302715a;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return true;
        }

        public g(AppCompatImageView r100) {
            this.f302715a = r100;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f302715a.setEnabled(false);
            this.f302715a.setAlpha(0.5f);
        }

        @Override // com.larus.im.callback.IIMCallback
        public final /* bridge */ /* synthetic */ void onSuccess(Message r100) {
        }
    }

    public static final class h implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f302716a;

        public h(i r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f302716a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f302716a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f302716a.invoke(r100);
        }
    }

    static {
    }

    public CodeBlockDetailFragment() {
        this(null);
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public final boolean S90() {
        return true;
    }

    @Override // com.larus.bmhome.chat.detail.AbstractCommonDetailFragment
    public final String ca0() {
        return "code";
    }

    @Override // com.larus.bmhome.chat.detail.AbstractCommonDetailFragment
    public final float da0() {
        return 1.1f;
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "code_full_screen_page";
    }

    @Override // com.larus.bmhome.chat.detail.AbstractCommonDetailFragment
    public final ViewGroup fa0() {
        LarusFragmentCodeBlockDetailBinding r100 = this.C;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f358613j;
    }

    public final void ka0() {
        LarusFragmentCodeBlockDetailBinding r100 = this.C;
        if (r100 == null) goto L9;
        LarusPageDeepResearchErrorBinding r101 = r100.f358616m;
        if (r101 == null) goto L9;
        ConstraintLayout r102 = r101.f358811a;
        if (r102 == null) goto L9;
        e1.d(r102, new q(this));
    L9:
        com.larus.bmhome.chat.detail.code.artifact.request.a r103 = (com.larus.bmhome.chat.detail.code.artifact.request.a) this.Y.getValue();
        LifecycleCoroutineScope r104 = LifecycleOwnerKt.getLifecycleScope(this);
        Long r105 = this.M;
        if (r105 == null) goto L12;
        long r106 = r105.longValue();
    L13:
        r103.b(r104, r106, this.N, new d(this));
        return;
    L12:
        r106 = 0;
        goto L13
    }

    @Override // com.larus.bmhome.chat.detail.code.l0
    public final void ky() {
        if (this.K == false) goto L6;
        ia0(true);
        return;
    }

    public final void na0() {
        if (this.G == false) goto L7;
        com.larus.bmhome.chat.detail.code.preview.j r100 = (com.larus.bmhome.chat.detail.code.preview.j) this.U.getValue();
        if (r100 == null) goto L7;
        r100.Rj();
    L7:
        Context r101 = getContext();
        if (r101 == null) goto L11;
        String r102 = r101.getString(R.string.larus_deepResearch_previewScreen_status_error);
        if (r102 == null) goto L11;
    L13:
        if (this.f302709J == true) goto L16;
        t19.s r103 = t19.s.f544207a;
        Context r104 = getContext();
        r103.getClass();
        t19.s.c(r104, r102);
        return;
    L16:
        return;
    L11:
        r102 = "";
        goto L13
    }

    public final void oa0() {
        boolean r100 = false;
        if (this.F == true) goto L5;
    L10:
        boolean r101 = true;
    L11:
        LarusFragmentCodeBlockDetailBinding r102 = this.C;
        float r103 = 1.0f;
        if (r102 == null) goto L19;
        AppCompatImageView r104 = r102.f358608e;
        if (r104 == null) goto L19;
        if (r101 == false) goto L17;
        float r105 = 0.5f;
    L18:
        r104.setAlpha(r105);
        r104.setEnabled(!r101);
        goto L19
    L17:
        r105 = 1.0f;
    L19:
        int r106 = b.f302710a[this.L.ordinal()];
        if (r106 == 1) goto L44;
        if (r106 != 2) goto L24;
    L49:
        r100 = true;
    L50:
        FLogger r107 = FLogger.f375446a;
        StringBuilder r108 = new StringBuilder("isShareButtonDisabled = ");
        r108.append(r100);
        r108.append(" codeRenderScene = ");
        r108.append(this.L);
        r108.append(" message?.messageStatusLocal = ");
        m0 r109 = this.A;
        if (r109 == null) goto L53;
        Integer r110 = r109.k();
    L54:
        r108.append(r110);
        r107.d("CodeBlockDetailFragment", r108.toString());
        LarusFragmentCodeBlockDetailBinding r111 = this.C;
        if (r111 == null) goto L62;
        AppCompatImageView r112 = r111.f358625v;
        if (r112 == null) goto L63;
        if (r100 == false) goto L60;
        r103 = 0.5f;
    L60:
        r112.setAlpha(r103);
        r112.setEnabled(!r100);
        com.larus.im.d.e().m(this.f302679g, new g(r112));
        return;
    L63:
        return;
    L62:
        return;
    L53:
        r110 = null;
        goto L54
    L24:
        if (this.F == false) goto L49;
        if (this.f302709J == true) goto L38;
        m0 r113 = this.A;
        if (r113 == null) goto L30;
        boolean r114 = Intrinsics.areEqual(r113.isStreaming(), Boolean.TRUE);
    L31:
        if (r114 == false) goto L38;
        m0 r115 = this.A;
        if (r115 == null) goto L35;
        boolean r116 = Intrinsics.areEqual(r115.isFinished(), Boolean.FALSE);
    L36:
        if (r116 == true) goto L49;
    L35:
        r116 = false;
        goto L36
    L30:
        r114 = false;
    L38:
        if (this.f302679g.length() != 0) goto L40;
        boolean r117 = true;
    L41:
        if (r117 == false) goto L50;
    L40:
        r117 = false;
        goto L41
    L44:
        if (this.F == false) goto L49;
        if (this.f302709J == true) goto L50;
        if (this.E == false) goto L50;
    L5:
        if (this.f302709J == true) goto L10;
        if (this.E == true) goto L10;
        r101 = false;
        goto L11
    }

    public final void qc() {
        m0 r100 = this.A;
        if (r100 == null) goto L5;
        r100.g(true);
    L5:
        this.F = true;
        oa0();
        if (this.G == true) goto L8;
        return;
    L8:
        com.larus.bmhome.chat.detail.code.preview.j r101 = (com.larus.bmhome.chat.detail.code.preview.j) this.U.getValue();
        if (r101 == null) goto L12;
        r101.qc();
    L12:
        if (this.f302709J == true) goto L15;
        this.K = true;
        return;
    }

    public final void ua0() {
        if (this.W == false) goto L5;
        return;
    L5:
        AlphaAnimation r100 = new AlphaAnimation(1.0f, 0.0f);
        r100.setDuration(400);
        r100.setRepeatMode(2);
        r100.setRepeatCount(-1);
        AppCompatImageView r101 = this.Z;
        if (r101 == null) goto L8;
        r101.startAnimation(r100);
    L8:
        this.W = true;
    }

    public final void va0() {
        AppCompatImageView r100 = this.Z;
        if (r100 == null) goto L5;
        r100.clearAnimation();
    L5:
        this.W = false;
    }

    @Override // com.larus.bmhome.chat.detail.AbstractCommonDetailFragment
    public final float ga0() {
        return we8.a.a(i5.m(), false);
    }

    public final void ja0() {
        Context r100 = requireContext();
        LarusFragmentCodeBlockDetailBinding r101 = this.C;
        if (r101 == null) goto L5;
        FrameLayout r102 = r101.f358613j;
    L6:
        AppCompatImageView r103 = new AppCompatImageView(r100);
        r103.setId(R.id.code_loading_dot);
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(r103.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_8, null, R.dimen.larus_dp_8)), r103.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_8, null, R.dimen.larus_dp_8)));
        r104.setMarginStart(r103.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_42, null, R.dimen.larus_dp_42)));
        int r105 = i5.J();
        if (this.f302688p == true) goto L10;
        Lazy r106 = we8.e.f559400a;
        r105 = r105 + c7.b(Integer.valueOf((we8.e.f559403d - FontLevel.STANDARD.getValue()) * 3));
    L10:
        r104.bottomMargin = r105;
        r104.gravity = 8388691;
        r103.setLayoutParams(r104);
        r103.setVisibility(0);
        r103.setImageDrawable(ContextCompat.getDrawable(r100, v19.c.b(R.attr.larus_ic_loading_dot, r100, R.drawable.larus_ic_loading_dot)));
        this.Z = r103;
        if (r102 == null) goto L14;
        Intrinsics.checkNotNull(r103);
        r102.addView(r103);
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void ma0() {
        oa0();
        pa0();
        LarusFragmentCodeBlockDetailBinding r100 = this.C;
        if (r100 == null) goto L14;
        TextView r101 = r100.f358610g;
        Bundle r102 = getArguments();
        if (r102 == null) goto L9;
        String r103 = r102.getString("key_code_block_title");
        if (r103 == null) goto L9;
    L10:
        r101.setText(r103);
        if (this.G == false) goto L15;
        PreviewSwitchButton r104 = r100.f358622s;
        r104.setVisibility(0);
        r104.setState(this.f302709J);
        ia0(this.f302709J);
        r104.setOnStateChangeListener(new e(this));
        return;
    L15:
        return;
    L9:
        r103 = this.f302681i;
        goto L10
    }

    @Override // com.larus.bmhome.chat.detail.AbstractCommonDetailFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        AppCompatImageView r100 = this.Z;
        if (r100 == null) goto L5;
        r100.clearAnimation();
    L5:
        ValueAnimator r101 = this.V;
        if (r101 == null) goto L9;
        r101.cancel();
    L9:
        if (this.L != CodeRenderScene.DeepSearch) goto L14;
        h0 r102 = (h0) this.X.getValue();
        com.larus.im.internal.research.d.a r103 = r102.f302746d;
        if (r103 == null) goto L13;
        r103.a();
    L13:
        ((Handler) r102.f302747e.getValue()).removeCallbacksAndMessages(null);
        r102.f302745c = null;
    L14:
        ExecutorService r104 = this.S;
        if (r104 == null) goto L17;
        r104.shutdownNow();
    L17:
        this.S = null;
        m0 r105 = this.A;
        if (r105 == null) goto L21;
        r105.onDestroy();
        return;
    }

    public final void pa0() {
        Context r100 = getContext();
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.D == false) goto L16;
        LarusFragmentCodeBlockDetailBinding r101 = this.C;
        if (r101 == null) goto L11;
        AppCompatImageView r102 = r101.f358608e;
        if (r102 == null) goto L11;
        r102.setBackground(null);
    L11:
        LarusFragmentCodeBlockDetailBinding r103 = this.C;
        if (r103 == null) goto L28;
        AppCompatImageView r104 = r103.f358608e;
        if (r104 == null) goto L29;
        r104.setBackground(ContextCompat.getDrawable(r100, v19.c.b(R.attr.larus_ic_full_screen_change_line_enable_button, r100, R.drawable.larus_ic_full_screen_change_line_enable_button)));
        return;
    L29:
        return;
    L28:
        return;
    L16:
        LarusFragmentCodeBlockDetailBinding r105 = this.C;
        if (r105 == null) goto L21;
        AppCompatImageView r106 = r105.f358608e;
        if (r106 == null) goto L21;
        r106.setBackground(null);
    L21:
        LarusFragmentCodeBlockDetailBinding r107 = this.C;
        if (r107 == null) goto L31;
        AppCompatImageView r108 = r107.f358608e;
        if (r108 == null) goto L32;
        r108.setBackground(ContextCompat.getDrawable(r100, v19.c.b(R.attr.larus_ic_full_screen_change_line_disable_button, r100, R.drawable.larus_ic_full_screen_change_line_disable_button)));
        return;
    L32:
        return;
    }

    @Override // com.larus.bmhome.chat.detail.code.l0
    public final boolean Vo() {
        return this.f302709J;
    }

    @Override // com.larus.bmhome.chat.detail.AbstractCommonDetailFragment
    public final boolean Z90() {
        return this.D;
    }

    @Override // com.larus.bmhome.chat.detail.code.l0
    public final LarusFragmentCodeBlockDetailBinding d0() {
        return this.C;
    }

    @Override // com.larus.bmhome.chat.detail.code.l0
    public final String getCode() {
        return this.f302682j;
    }

    @Override // com.larus.bmhome.chat.detail.code.l0
    public final String getLanguage() {
        return this.f302681i;
    }

    @Override // com.larus.bmhome.chat.detail.code.l0
    public final boolean jW() {
        return this.F;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.larus.bmhome.chat.detail.code.g] */
    /* JADX WARN: Type inference failed for: r0v15, types: [com.larus.bmhome.chat.detail.code.b0] */
    /* JADX WARN: Type inference failed for: r0v16, types: [com.larus.bmhome.chat.detail.code.a0] */
    /* JADX WARN: Type inference failed for: r0v17, types: [com.larus.bmhome.chat.detail.code.z] */
    public CodeBlockDetailFragment(m0 r100) {
        super(r100);
        this.A = r100;
        this.B = LazyKt.lazy(new u(this));
        this.D = z2.f365865a.getMarkdownOptimizeConfig().f486596i;
        this.L = CodeRenderScene.Default;
        this.T = LazyKt.lazy(new v(this));
        this.U = LazyKt.lazy(new w(this));
        this.X = LazyKt.lazy(new x(this));
        this.Y = LazyKt.lazy(new y());
        if (r100 == 0) goto L5;
        r100.f(new z(this));
    L5:
        if (r100 == 0) goto L7;
        r100.h(new a0(this));
    L7:
        if (r100 == 0) goto L9;
        r100.b(new b0(this));
    L9:
        if (r100 == 0) goto L12;
        r100.l(new com.larus.bmhome.chat.detail.code.g(this));
        return;
    }

    public static void ha0(DialogFragment r100) {
        r100.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void ia0(boolean r100) {
        if (this.f302709J == r100) goto L10;
        this.f302709J = r100;
        LarusFragmentCodeBlockDetailBinding r101 = this.C;
        if (r101 == null) goto L10;
        PreviewSwitchButton r102 = r101.f358622s;
        if (r102 == null) goto L10;
        r102.setState(r100);
    L10:
        if (r100 == false) goto L24;
        this.K = false;
        com.larus.bmhome.chat.detail.code.preview.j r103 = (com.larus.bmhome.chat.detail.code.preview.j) this.U.getValue();
        if (r103 == null) goto L14;
        r103.B30(0);
    L14:
        LarusFragmentCodeBlockDetailBinding r104 = this.C;
        if (r104 == null) goto L19;
        NestedScrollView r105 = r104.f358612i;
        if (r105 == null) goto L19;
        r105.setVisibility(8);
    L19:
        LarusFragmentCodeBlockDetailBinding r106 = this.C;
        if (r106 == null) goto L37;
        TextView r107 = r106.f358605b;
        if (r107 == null) goto L37;
        r107.setVisibility(8);
    L37:
        oa0();
        return;
    L24:
        com.larus.bmhome.chat.detail.code.preview.j r108 = (com.larus.bmhome.chat.detail.code.preview.j) this.U.getValue();
        if (r108 == null) goto L27;
        r108.B30(8);
    L27:
        LarusFragmentCodeBlockDetailBinding r109 = this.C;
        if (r109 == null) goto L32;
        NestedScrollView r110 = r109.f358612i;
        if (r110 == null) goto L32;
        r110.setVisibility(0);
    L32:
        LarusFragmentCodeBlockDetailBinding r111 = this.C;
        if (r111 == null) goto L37;
        TextView r112 = r111.f358605b;
        if (r112 == null) goto L37;
        r112.setVisibility(0);
        goto L37
    }

    @Override // com.larus.bmhome.chat.detail.AbstractCommonDetailFragment, com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        boolean r102 = true;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L10;
        this.D = true;
    L10:
        s1a.a.a(this, this, l0.class);
        Bundle r104 = getArguments();
        if (r104 != null) goto L13;
    L15:
        boolean r105 = false;
    L16:
        if (r105 == false) goto L18;
        this.L = CodeRenderScene.DeepSearch;
    L26:
        Bundle r106 = getArguments();
        if (r106 == null) goto L30;
        String r107 = r106.getString("is_general_agent");
        if (r107 == null) goto L30;
    L31:
        this.H = r107;
        Bundle r108 = getArguments();
        Map<String, ? extends Object> r109 = null;
        if (r108 == null) goto L34;
        String r110 = r108.getString("chat_id");
    L35:
        this.I = r110;
        Bundle r111 = getArguments();
        if (r111 != null) goto L38;
    L42:
        boolean r112 = false;
    L43:
        this.G = r112;
        CodeRenderScene r113 = this.L;
        CodeRenderScene r114 = CodeRenderScene.CodeArtifact;
        if (r113 != r114) goto L47;
        this.G = false;
    L47:
        if (this.G == true) goto L49;
        if (r113 == r114) goto L49;
    L50:
        Bundle r115 = getArguments();
        if (r115 != null) goto L53;
    L57:
        boolean r116 = false;
    L58:
        this.f302709J = r116;
        CodeRenderScene r117 = this.L;
        if (r117 == CodeRenderScene.DeepSearch) goto L69;
        if (r117 == r114) goto L69;
        Bundle r118 = getArguments();
        if (r118 == null) goto L65;
        r102 = r118.getBoolean("key_is_code_finished", true);
    L65:
        m0 r119 = this.A;
        if (r119 == null) goto L68;
        r119.g(r102);
    L68:
        this.F = r102;
    L73:
        Bundle r120 = getArguments();
        if (r120 == null) goto L76;
        Integer r121 = Integer.valueOf(r120.getInt("key_artifact_code_version"));
    L77:
        this.N = r121;
        Bundle r122 = getArguments();
        if (r122 == null) goto L80;
        Long r123 = Long.valueOf(r122.getLong("key_artifact_code_code_id"));
    L81:
        this.M = r123;
        Bundle r124 = getArguments();
        if (r124 == null) goto L84;
        String r125 = r124.getString("key_thread_id");
    L85:
        m0 r126 = this.A;
        if (r126 == null) goto L88;
        r126.i(r125);
    L88:
        Bundle r127 = getArguments();
        if (r127 == null) goto L91;
        String r128 = r127.getString("key_deep_research_id");
    L92:
        this.O = r128;
        Bundle r129 = getArguments();
        if (r129 == null) goto L95;
        String r130 = r129.getString("key_deep_research_resource_id");
    L96:
        this.P = r130;
        Bundle r131 = getArguments();
        if (r131 == null) goto L99;
        Serializable r132 = r131.getSerializable("key_event_extra");
    L101:
        if ((r132 instanceof Map) == false) goto L103;
        r109 = (Map) r132;
    L103:
        this.R = r109;
        return;
    L99:
        r132 = null;
        goto L101
    L95:
        r130 = null;
        goto L96
    L91:
        r128 = null;
        goto L92
    L84:
        r125 = null;
        goto L85
    L80:
        r123 = null;
        goto L81
    L76:
        r121 = null;
    L69:
        m0 r133 = this.A;
        if (r133 == null) goto L72;
        r133.g(false);
    L72:
        this.F = false;
        goto L73
    L53:
        if (r115.getBoolean("key_is_to_preview") == false) goto L57;
        if (this.G == false) goto L57;
        r116 = true;
    L49:
        k1a.b.a(this, new com.larus.bmhome.chat.detail.code.h(this));
        goto L50
    L38:
        if (r111.getBoolean("key_can_code_be_previewed") == false) goto L42;
        AiChatHostWebService.f317594a.getClass();
        if (((IAiChatHostWebService) AiChatHostWebService.f317595b.getValue()) == null) goto L42;
        r112 = true;
        goto L43
    L34:
        r110 = null;
    L30:
        r107 = "0";
        goto L31
    L18:
        Bundle r134 = getArguments();
        if (r134 != null) goto L21;
    L23:
        boolean r135 = false;
    L24:
        if (r135 == false) goto L26;
        this.L = CodeRenderScene.CodeArtifact;
        goto L26
    L21:
        if (r134.getBoolean("key_is_from_code_artifact") != true) goto L23;
        r135 = true;
        goto L24
    L13:
        if (r104.getBoolean("key_is_from_deep_research") != true) goto L15;
        r105 = true;
        goto L16
    L5:
        if (r101.getBoolean("key_code_block_default_no_wrap") != true) goto L7;
        r103 = true;
        goto L8
    }

    public final void ta0(int r100) {
        LarusFragmentCodeBlockDetailBinding r101 = this.C;
        if (r101 == null) goto L14;
        TextView r102 = r101.f358611h;
        if (r102 == null) goto L15;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
    L10:
        if (r104 == null) goto L12;
        r104.topMargin = r100;
        r102.setLayoutParams(r104);
    L12:
        r102.setVisibility(0);
        return;
    L9:
        r104 = null;
        goto L10
    L15:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.chat.detail.code.i] */
    @Override // com.larus.bmhome.chat.detail.AbstractCommonDetailFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        ma0();
        ((CodeBlockDetailViewModel) this.B.getValue()).getShareDetailData().observe(getViewLifecycleOwner(), new h(new i(this)));
        LarusFragmentCodeBlockDetailBinding r102 = this.C;
        if (r102 == null) goto L9;
        e1.d(r102.f358606c, new j(this));
        e1.d(r102.f358608e, new k(this));
        e1.d(r102.f358625v, new l(this));
        LarusFragmentCodeBlockDetailBinding r103 = this.C;
        if (r103 == null) goto L9;
        NestedScrollView r104 = r103.f358612i;
        if (r104 == null) goto L9;
        r104.setOnTouchListener(new m(this));
    L9:
        CodeRenderScene r105 = this.L;
        int r106 = b.f302710a[r105.ordinal()];
        boolean r107 = false;
        if (r106 == 1) goto L25;
        if (r106 != 2) goto L14;
        ka0();
    L43:
        com.larus.im.d.e().m(this.f302679g, new f(this));
        return;
    L14:
        if (this.F == true) goto L43;
        if (this.f302679g.length() <= 0) goto L18;
        r107 = true;
    L18:
        if (r107 == false) goto L43;
        m0 r108 = this.A;
        if (r108 == null) goto L22;
        r108.m();
    L22:
        ja0();
        ua0();
        goto L43
    L25:
        if (this.L != CodeRenderScene.DeepSearch) goto L42;
        String r109 = this.P;
        if (r109 != null) goto L30;
    L33:
        boolean r110 = true;
    L34:
        if (r110 == true) goto L42;
        h0 r111 = (h0) this.X.getValue();
        if (r111.f302743a.length() != 0) goto L39;
        r107 = true;
    L39:
        if (r107 == true) goto L42;
        r111.f302744b = SystemClock.elapsedRealtime();
        com.larus.im.e r112 = com.larus.im.c.f347126a;
        com.larus.im.internal.research.a.f349800a.a(r111.f302743a, new k0(r111));
        goto L42
    L30:
        if (StringsKt.isBlank(r109) == true) goto L33;
        r110 = false;
    L42:
        ja0();
        ua0();
        goto L43
    }

    public final void qa0(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f302682j = r100;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f302690r = r100;
        String r102 = ba0(this.f302681i, r100, !r101);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f302683k = r102;
        sa0(true, true, r101, true);
    }

    public final void ra0(String r110, boolean r111) {
        boolean r112 = true;
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L30
        if (r110 != null) goto L6;
    L9:
        boolean r101 = true;
    L10:
        if (r101 == true) goto L34;
        String r102 = this.f302682j;     // Catch: Throwable -> L30
        int r113 = StringsKt.lastIndexOf$default(r110, StringsKt.trim(r102.substring(0, RangesKt.coerceAtMost(50, r102.length()))).toString(), 0, false, 6, null);     // Catch: Throwable -> L30
        if (r113 != (-1)) goto L21;
        m0 r103 = this.A;     // Catch: Throwable -> L30
        if (r103 == null) goto L17;
        r103.g(true);     // Catch: Throwable -> L30
    L17:
        this.F = true;     // Catch: Throwable -> L30
        AppCompatImageView r104 = this.Z;     // Catch: Throwable -> L30
        if (r104 == null) goto L20;
        r104.setVisibility(8);     // Catch: Throwable -> L30
    L20:
        va0();     // Catch: Throwable -> L30
        na0();     // Catch: Throwable -> L30
        goto L34
    L21:
        int r105 = StringsKt.indexOf$default(r110, "```", r113, false, 4, null);     // Catch: Throwable -> L30
        if (r105 != (-1)) goto L25;
        r105 = r110.length();     // Catch: Throwable -> L30
    L25:
        if (r105 != r110.length()) goto L27;
        if (r111 == true) goto L27;
    L28:
        FLogger.f375446a.d("CodeBlockDetailFragment", "endIndex = " + r105 + " currentMarkdownCode = " + StringsKt.trim(r110.substring(r113, r105)).toString());     // Catch: Throwable -> L30
        String r106 = StringsKt.trim(r110.substring(r113, r105)).toString();     // Catch: Throwable -> L30
    L36:
        if (r106.length() == 0) goto L39;
        r112 = false;
    L39:
        if (r112 == false) goto L41;
        return;
    L41:
        qa0(r106, this.F);
        return;
    L27:
        qc();     // Catch: Throwable -> L30
    L34:
        r106 = "";
        goto L36
    L6:
        if (r110.length() == 0) goto L9;
        r101 = false;
    L30:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Throwable r108 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r108 == null) goto L34;
        FLogger.f375446a.e("CodeBlockDetailFragment", r108.toString());
        goto L34
    }

    public final lw8.l la0(Context r310, CustomMarkdownTextView r311, int r312) {
        gw8.c.f483071a.getClass();
        gw8.c r100 = gw8.c.a.b();
        if (r100 == null) goto L5;
        int r101 = 0;
        return gw8.c.b.a(r100, r311.getContext(), r312, this.f302683k, true, new lw8.d(r101, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, aa0(r310, this.D), null, null, null, null, null, null, null, -2097153, 31), null, r311.getText(), 160);
    L5:
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r210, ViewGroup r211, Bundle r310) {
        Intrinsics.checkNotNullParameter(r210, "inflater");
        View r100 = r210.inflate(R.layout.larus_fragment_code_block_detail, r211, false);
        int r101 = R.id.ai_content_disclaimer;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r100, R.id.ai_content_disclaimer);
        if (r102 == null) goto L70;
        r101 = R.id.back_icon;
        AppCompatImageView r103 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.back_icon);
        if (r103 == null) goto L70;
        r101 = R.id.background_page;
        View r104 = ViewBindings.findChildViewById(r100, R.id.background_page);
        if (r104 == null) goto L70;
        r101 = R.id.change_line_button;
        AppCompatImageView r105 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.change_line_button);
        if (r105 == null) goto L70;
        ConstraintLayout r106 = (ConstraintLayout) r100;
        TextView r110 = (TextView) ViewBindings.findChildViewById(r100, R.id.code_info);
        if (r110 == null) goto L68;
        TextView r111 = (TextView) ViewBindings.findChildViewById(r100, R.id.code_loading_placeholder);
        if (r111 == null) goto L67;
        NestedScrollView r112 = (NestedScrollView) ViewBindings.findChildViewById(r100, R.id.code_tab);
        if (r112 == null) goto L66;
        FrameLayout r113 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.content_container);
        if (r113 == null) goto L65;
        FrameLayout r114 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.content_container_root);
        if (r114 == null) goto L64;
        LinearLayout r115 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.markdownCodeRenderFailedLayout);
        if (r115 == null) goto L63;
        View r107 = ViewBindings.findChildViewById(r100, R.id.page_error);
        if (r107 == null) goto L62;
        LarusPageDeepResearchErrorBinding r116 = LarusPageDeepResearchErrorBinding.a(r107);
        View r108 = ViewBindings.findChildViewById(r100, R.id.page_loading);
        if (r108 == null) goto L61;
        LarusPageDeepResearchLoadingBinding r117 = LarusPageDeepResearchLoadingBinding.a(r108);
        ConstraintLayout r118 = (ConstraintLayout) ViewBindings.findChildViewById(r100, R.id.preview_loading_container);
        if (r118 == null) goto L60;
        ProgressBar r212 = (ProgressBar) ViewBindings.findChildViewById(r100, R.id.preview_loading_progress_bar);
        if (r212 == null) goto L59;
        TextView r213 = (TextView) ViewBindings.findChildViewById(r100, R.id.preview_loading_text);
        if (r213 != null) goto L33;
        r101 = R.id.preview_loading_text;
        goto L70
    L33:
        if (((LinearLayout) ViewBindings.findChildViewById(r100, R.id.preview_loading_text_container)) == null) goto L57;
        FrameLayout r214 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.preview_lynx_view_container);
        if (r214 == null) goto L56;
        PreviewSwitchButton r215 = (PreviewSwitchButton) ViewBindings.findChildViewById(r100, R.id.preview_switch_button);
        if (r215 == null) goto L55;
        FrameLayout r216 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.preview_tab);
        if (r216 == null) goto L54;
        FrameLayout r217 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.preview_web_view_container);
        if (r217 == null) goto L53;
        AppCompatImageView r218 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.share_button);
        if (r218 != null) goto L45;
        r101 = R.id.share_button;
        goto L70
    L45:
        if (((ConstraintLayout) ViewBindings.findChildViewById(r100, R.id.title_bar_container)) == null) goto L51;
        this.C = new LarusFragmentCodeBlockDetailBinding(r106, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118, r212, r213, r214, r215, r216, r217, r218);
        if (r106 == null) goto L49;
        r106.setTag(R.id.lib_track_tag_parent_track_node, this);
        return r106;
    L49:
        return null;
    L51:
        r101 = R.id.title_bar_container;
        goto L70
    L53:
        r101 = R.id.preview_web_view_container;
        goto L70
    L54:
        r101 = R.id.preview_tab;
        goto L70
    L55:
        r101 = R.id.preview_switch_button;
        goto L70
    L56:
        r101 = R.id.preview_lynx_view_container;
        goto L70
    L57:
        r101 = R.id.preview_loading_text_container;
        goto L70
    L59:
        r101 = R.id.preview_loading_progress_bar;
        goto L70
    L60:
        r101 = R.id.preview_loading_container;
        goto L70
    L61:
        r101 = R.id.page_loading;
        goto L70
    L62:
        r101 = R.id.page_error;
        goto L70
    L63:
        r101 = R.id.markdownCodeRenderFailedLayout;
        goto L70
    L64:
        r101 = R.id.content_container_root;
        goto L70
    L65:
        r101 = R.id.content_container;
        goto L70
    L66:
        r101 = R.id.code_tab;
        goto L70
    L67:
        r101 = R.id.code_loading_placeholder;
        goto L70
    L68:
        r101 = R.id.code_info;
    L70:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public final void sa0(boolean r110, boolean r210, boolean r211, boolean r212) {
        boolean r100 = true;
        this.E = true;
        oa0();
        Ref.LongRef r101 = new Ref.LongRef();
        r101.element = SystemClock.elapsedRealtime();
        Context r102 = getContext();
        if (r102 == null) goto L43;
        CustomMarkdownTextView r103 = this.f302678f;
        if (r103 == null) goto L46;
        int r104 = (r103.getMarkdownWidth() - r103.getPaddingStart()) - r103.getPaddingEnd();
        if (r110 == false) goto L11;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new CodeBlockDetailFragment$refreshMarkDownTextView$1$1(r211, this, r101, r110, r210, r103, r212, r102, r104, null), 3, null);
        return;
    L11:
        lw8.l r105 = la0(r102, r103, r104);
        FLogger r106 = FLogger.f375446a;
        r106.d("CodeBlockDetailFragment", "getNewMarkdownContent cost[" + (SystemClock.elapsedRealtime() - r101.element) + "], useAsync[" + r110 + ']');
        if (r210 == true) goto L14;
    L16:
        r100 = false;
    L17:
        int r111 = r103.getMeasuredHeight();
        if (r212 == false) goto L20;
        ta0(r111);
    L20:
        r101.element = SystemClock.elapsedRealtime();
        r103.C(r105, null, null, null);
        r106.d("CodeBlockDetailFragment", "setMarkdown cost[" + (SystemClock.elapsedRealtime() - r101.element) + "], useAsync[" + r110 + ']');
        if (r100 == false) goto L28;
        LarusFragmentCodeBlockDetailBinding r107 = this.C;
        if (r107 == null) goto L28;
        NestedScrollView r108 = r107.f358612i;
        if (r108 == null) goto L28;
        r108.post(new n(r108));
    L28:
        if (r212 == false) goto L33;
        CustomMarkdownTextView r109 = this.f302678f;
        if (r109 == null) goto L33;
        r109.post(new com.larus.bmhome.chat.detail.code.f(r109, this, r111));
    L33:
        this.E = false;
        oa0();
        if (r211 == false) goto L38;
        va0();
        AppCompatImageView r112 = this.Z;
        if (r112 == null) goto L44;
        r112.setVisibility(8);
        return;
    L44:
        return;
    L38:
        AppCompatImageView r113 = this.Z;
        if (r113 == null) goto L41;
        r113.setVisibility(0);
    L41:
        ua0();
        return;
    L14:
        if (this.Q == true) goto L16;
    L46:
        return;
    }
}
