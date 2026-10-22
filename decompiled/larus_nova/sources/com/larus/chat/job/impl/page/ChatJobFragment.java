package com.larus.chat.job.impl.page;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.common.auth.AuthConstants;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.core.CoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.view.BottomMenuGridLayout;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.camera.api.params.CameraOutputContext;
import com.larus.chat.job.impl.databinding.LarusChatJobMainFragmentBinding;
import com.larus.common_ui.view.TouchInterceptingView;
import com.larus.im.bean.job.AIJob;
import com.larus.nova.R;
import com.larus.platform.api.d1;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.spi.IAIChatConversationService;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.texturerender.TextureRenderKeys;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b*\u0002\u001a\u001d\u0018\u0000 W2\u00020\u00012\u00020\u0002:\u0001WB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u00100\u001a\u00020.H\u0016J\u0010\u00101\u001a\u00020.2\u0006\u00102\u001a\u00020\u000eH\u0016J\b\u00103\u001a\u00020.H\u0016J\u0018\u00104\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u0010H\u0016J\b\u00107\u001a\u00020\u000eH\u0002J\u001a\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020\u00102\b\u0010:\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020@H\u0002J(\u0010A\u001a\u00020.2\b\u0010B\u001a\u0004\u0018\u00010@2\b\u0010C\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0010H\u0002JB\u0010F\u001a\u00020.2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00102\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010B\u001a\u0004\u0018\u00010@2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010J\u001a\u00020\u000eH\u0002J\u0010\u0010K\u001a\u00020.2\u0006\u0010B\u001a\u00020@H\u0002J\f\u0010L\u001a\u00020@*\u00020@H\u0002J\n\u0010M\u001a\u0004\u0018\u00010\u0010H\u0002J\u001c\u0010N\u001a\u00020,2\u0006\u0010I\u001a\u00020\u00102\n\b\u0002\u0010O\u001a\u0004\u0018\u00010PH\u0002J\u0016\u0010Q\u001a\u00020.*\u00020,2\b\u0010O\u001a\u0004\u0018\u00010PH\u0002J\b\u0010R\u001a\u00020\u0010H\u0002J\n\u0010S\u001a\u0004\u0018\u00010DH\u0002J\u0010\u0010T\u001a\u0004\u0018\u00010DH\u0082@¢\u0006\u0002\u0010UJ\b\u0010V\u001a\u00020.H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"¨\u0006X"}, d2 = {"Lcom/larus/chat/job/impl/page/ChatJobFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/platform/api/IPageInputFillAbility;", "<init>", "()V", "binding", "Lcom/larus/chat/job/impl/databinding/LarusChatJobMainFragmentBinding;", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "cameraAbility", "Lcom/larus/bmhome/camera/IChatCameraAbility;", "speakerAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "voiceInputTakeOverConfigured", "", "lastAutoRoutedVoiceInputKey", "", "inputStatusBeforeVoiceInput", "", "Ljava/lang/Integer;", "pageConfigs", "", "Lcom/larus/chat/job/impl/page/config/IChatJobPageConfig;", "pendingCronTemplateId", "currentInputContent", "inputTextChangedListener", "com/larus/chat/job/impl/page/ChatJobFragment$inputTextChangedListener$1", "Lcom/larus/chat/job/impl/page/ChatJobFragment$inputTextChangedListener$1;", "speakerStateListener", "com/larus/chat/job/impl/page/ChatJobFragment$speakerStateListener$1", "Lcom/larus/chat/job/impl/page/ChatJobFragment$speakerStateListener$1;", "listViewModel", "Lcom/larus/chat/job/impl/page/ChatJobListViewModel;", "getListViewModel", "()Lcom/larus/chat/job/impl/page/ChatJobListViewModel;", "listViewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onHiddenChanged", "hidden", "onDestroyView", "fillInput", "source", "contentId", "onActionSendClicked", "onVoiceInputSuccess", "text", "asrLogId", "onCameraSuccess", "outputContext", "Lcom/larus/camera/api/params/CameraOutputContext;", "onSendIntercepted", "params", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "routeWithResolvedBotIdAsync", "sendParams", "sourceConversation", "Lcom/larus/im/bean/conversation/Conversation;", "pendingCameraResultKey", "routeToSubConversation", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "botId", "shouldDowngrade", "resetInputAfterAcceptedSend", "withChatJobMessageExt", "resolveBotId", "buildRouteExtraParams", "chatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "appendSelectedProjectRouteParam", "trackingRunEnvironment", "createSourceConversation", "fetchMainConversation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyPageVisible", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatJobFragment extends Fragment implements d1 {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f325058q = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusChatJobMainFragmentBinding f325059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ICoreInputAbility f325060e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public zb8.e f325061f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.larus.bmhome.chat.component.bottom.core.speaker.l f325062g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f325063h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f325064i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f325065j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<cz8.j> f325066k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f325067l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f325068m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f325069n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final d f325070o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f325071p;

    public static final class a {
    }

    public static final class b implements ICoreInputAbility.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatJobFragment f325072a;

        public b(ChatJobFragment r100) {
            this.f325072a = r100;
        }

        @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility.e
        public final void h(String r100) {
            Intrinsics.checkNotNullParameter(r100, "content");
        }

        @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility.e
        public final void i(String r100) {
            Intrinsics.checkNotNullParameter(r100, "content");
            this.f325072a.f325068m = r100;
            FLogger r101 = FLogger.f375446a;
            StringBuilder r102 = new StringBuilder("input text changed, contentLength=");
            r102.append(r100.length());
            r102.append(", hasPendingTemplate=");
            if (this.f325072a.f325067l == null) goto L5;
            boolean r103 = true;
        L6:
            r102.append(r103);
            r102.append(", lastStatus=");
            ICoreInputAbility r104 = this.f325072a.f325060e;
            if (r104 == null) goto L9;
            Integer r105 = Integer.valueOf(r104.Rp());
        L10:
            r102.append(r105);
            r101.i("ChatJobFragment", r102.toString());
            return;
        L9:
            r105 = null;
            goto L10
        L5:
            r103 = false;
            goto L6
        }

        @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility.e
        public final void j(String r100) {
            Intrinsics.checkNotNullParameter(r100, "content");
        }
    }

    public /* synthetic */ class c implements zb8.f, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatJobFragment f325073a;

        public c(ChatJobFragment r100) {
            this.f325073a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof zb8.f) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return new FunctionReferenceImpl(1, this.f325073a, ChatJobFragment.class, "onCameraSuccess", "onCameraSuccess(Lcom/larus/camera/api/params/CameraOutputContext;)Z", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // zb8.f
        public final boolean a(CameraOutputContext r110) {
            Intrinsics.checkNotNullParameter(r110, "p0");
            ChatJobFragment r100 = this.f325073a;
            int r101 = ChatJobFragment.f325058q;
            r100.getClass();
            ConcurrentHashMap<String, com.larus.bmhome.chat.camera.command.t> r102 = com.larus.bmhome.chat.camera.command.k.f297601a;
            zb8.e r103 = r100.f325061f;
            if (r103 == null) goto L5;
            SuggestedAction r104 = r103.Pc();
        L6:
            String r105 = com.larus.bmhome.chat.camera.command.k.a(r110, r104);
            wc9.e r106 = r100.S90();
            String r107 = r100.T90();
            FLogger r108 = FLogger.f375446a;
            StringBuilder r109 = new StringBuilder("camera success intercepted, pendingResultKey=");
            r109.append(r105);
            r109.append(", botIdEmpty=");
            boolean r111 = false;
            if (r107 != null) goto L9;
        L12:
            boolean r112 = true;
        L13:
            r109.append(r112);
            r109.append(", sourceConversationId=");
            if (r106 == null) goto L16;
            String r113 = r106.f559198a;
        L17:
            r109.append(r113);
            r108.i("ChatJobFragment", r109.toString());
            Context r114 = r100.getContext();
            if (r114 != null) goto L20;
            r108.e("ChatJobFragment", "camera success route skipped, context is null");
            com.larus.bmhome.chat.camera.command.k.b(r105);
        L29:
            return true;
        L20:
            if (r107 != null) goto L22;
        L23:
            r111 = true;
        L24:
            if (r111 == true) goto L28;
            if (r106 == null) goto L28;
            r100.U90(r114, r107, r106, null, r105, com.larus.platform.exp.o.a());
        L28:
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100.getViewLifecycleOwner()), null, null, new ChatJobFragment$routeWithResolvedBotIdAsync$1(r106, r100, r105, null, null), 3, null);
            goto L29
        L22:
            if (StringsKt.isBlank(r107) == false) goto L24;
        L16:
            r113 = null;
            goto L17
        L9:
            if (StringsKt.isBlank(r107) == true) goto L12;
            r112 = false;
            goto L13
        L5:
            r104 = null;
            goto L6
        }
    }

    public static final class d implements com.larus.bmhome.chat.component.bottom.core.speaker.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatJobFragment f325074a;

        public d(ChatJobFragment r100) {
            this.f325074a = r100;
        }

        @Override // com.larus.bmhome.chat.component.bottom.core.speaker.h
        public final void a(com.larus.bmhome.chat.component.bottom.core.speaker.g r110) {
            Intrinsics.checkNotNullParameter(r110, "state");
            Map r100 = null;
            Integer r101 = null;
            r100 = null;
            if (Intrinsics.areEqual(r110, com.larus.bmhome.chat.component.bottom.core.speaker.g.c.f299421a) == false) goto L9;
            ChatJobFragment r111 = this.f325074a;
            r111.f325064i = null;
            ICoreInputAbility r102 = r111.f325060e;
            if (r102 == null) goto L7;
            r101 = Integer.valueOf(r102.Rp());
        L7:
            r111.f325065j = r101;
            return;
        L9:
            if (Intrinsics.areEqual(r110, com.larus.bmhome.chat.component.bottom.core.speaker.g.a.f299419a) == false) goto L11;
        L52:
            ChatJobFragment r112 = this.f325074a;
            r112.f325064i = null;
            r112.f325065j = null;
            return;
        L11:
            if (Intrinsics.areEqual(r110, com.larus.bmhome.chat.component.bottom.core.speaker.g.b.f299420a) == true) goto L52;
            if ((r110 instanceof com.larus.bmhome.chat.component.bottom.core.speaker.g.e) == false) goto L48;
            com.larus.bmhome.chat.component.bottom.core.speaker.g.e r113 = (com.larus.bmhome.chat.component.bottom.core.speaker.g.e) r110;
            if (r113.f299425c == false) goto L18;
            ChatJobFragment r114 = this.f325074a;
            r114.f325064i = null;
            r114.f325065j = null;
            return;
        L18:
            ChatJobFragment r103 = this.f325074a;
            String r104 = r113.f299423a;
            String r115 = r113.f299424b;
            int r105 = ChatJobFragment.f325058q;
            r103.getClass();
            String r106 = StringsKt.trim(r104).toString();
            boolean r107 = false;
            if (r106.length() != 0) goto L21;
            boolean r108 = true;
        L23:
            if (r108 == false) goto L25;
            FLogger.f375446a.i("ChatJobFragment", "voice input success but content is blank, skip route");
            return;
        L25:
            StringBuilder r109 = new StringBuilder();
            if (r115 != null) goto L28;
            String r116 = "";
        L29:
            r109.append(r116);
            r109.append('#');
            r109.append(r106);
            String r117 = r109.toString();
            if (Intrinsics.areEqual(r103.f325064i, r117) == false) goto L32;
            FLogger.f375446a.i("ChatJobFragment", "voice input success already routed, skip duplicate");
            return;
        L32:
            r103.f325064i = r117;
            r103.f325068m = r106;
            FLogger r118 = FLogger.f375446a;
            StringBuilder r119 = new StringBuilder("voice input success, auto route to sub conversation, contentLength=");
            r119.append(r106.length());
            r119.append(", hasAsrLogId=");
            if (r115 == null) goto L35;
            r107 = true;
        L35:
            r119.append(r107);
            r118.i("ChatJobFragment", r119.toString());
            ICoreInputAbility r120 = r103.f325060e;
            if (r120 != null) goto L39;
            r118.e("ChatJobFragment", "voice input route skipped, coreInputAbility is null");
            return;
        L39:
            if (r115 != null) goto L41;
        L46:
            ICoreInputAbility.b.c(r120, r106, true, null, "cron_job", r100, 4);
            return;
        L41:
            if ((!StringsKt.isBlank(r115)) == true) goto L44;
            r115 = null;
        L44:
            if (r115 == null) goto L46;
            r100 = MapsKt.mapOf(TuplesKt.to("asr_log_id", r115));
            goto L46
        L28:
            r116 = r115;
            goto L29
        L21:
            r108 = false;
            goto L23
        L48:
            if ((r110 instanceof com.larus.bmhome.chat.component.bottom.core.speaker.g.d) == false) goto L51;
            return;
        L51:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        FLogger.f375446a.i("ChatJobFragment", "onDestroyView, unregister input callbacks");
        s1a.a.g(this).l(Reflection.getOrCreateKotlinClass(d1.class));
        this.f325067l = null;
        this.f325068m = "";
        this.f325064i = null;
        this.f325065j = null;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r100 = this.f325062g;
        if (r100 == null) goto L5;
        r100.B9(this.f325070o);
    L5:
        this.f325062g = null;
        zb8.e r101 = this.f325061f;
        if (r101 == null) goto L8;
        r101.MI();
    L8:
        this.f325061f = null;
        ICoreInputAbility r102 = this.f325060e;
        if (r102 == null) goto L11;
        r102.Vs(this.f325069n);
    L11:
        ICoreInputAbility r103 = this.f325060e;
        if (r103 == null) goto L14;
        r103.iN(new f());
    L14:
        ICoreInputAbility r104 = this.f325060e;
        if (r104 == null) goto L18;
        r104.tr(new g());
    L18:
        if (this.f325063h == false) goto L25;
        ICoreInputAbility r105 = this.f325060e;
        if (r105 == null) goto L24;
        CoreInputAbility r106 = r105.JO();
        if (r106 == null) goto L24;
        r106.j9();
    L24:
        this.f325063h = false;
    L25:
        this.f325059d = null;
        this.f325060e = null;
        Iterator<T> r107 = this.f325066k.iterator();
    L27:
        if (r107.hasNext() == false) goto L29;
        ((cz8.j) r107.next()).onDestroyView();
        goto L27
    L29:
        super.onDestroyView();
    }

    public ChatJobFragment() {
        this.f325066k = CollectionsKt.listOf(new cz8.j[]{new cz8.e(), new cz8.c(), new cz8.d(), new cz8.i()});
        this.f325068m = "";
        this.f325069n = new b(this);
        this.f325070o = new d(this);
        this.f325071p = LazyKt.lazy(LazyThreadSafetyMode.NONE, new h(this));
    }

    public final wc9.e S90() {
        Bundle r100 = getArguments();
        Integer r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getString("chat_job_source_conversation_id");
    L6:
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        return null;
    L14:
        Bundle r104 = getArguments();
        if (r104 == null) goto L23;
        if (r104.containsKey("chat_job_source_input_left_action_style") == true) goto L20;
        r104 = null;
    L20:
        if (r104 == null) goto L23;
        r101 = Integer.valueOf(r104.getInt("chat_job_source_input_left_action_style"));
    L23:
        return new wc9.e(r102, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, r101, null, null, 0, 0, null, null, 0, -268435458, 63);
    L8:
        if (StringsKt.isBlank(r102) == true) goto L11;
        r103 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public final String T90() {
        Bundle r100 = getArguments();
        if (r100 == null) goto L10;
        String r101 = r100.getString("argBotId");
        if (r101 != null) goto L7;
        return null;
    L7:
        if ((!StringsKt.isBlank(r101)) == true) goto L9;
        return null;
    L9:
        return r101;
    L10:
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        ez8.a r100 = ez8.a.f474904a;
        Bundle r101 = getArguments();
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getString("argPreviousPage");
    L6:
        Bundle r104 = getArguments();
        if (r104 == null) goto L9;
        r102 = r104.getString("enter_method");
    L9:
        boolean r105 = !com.larus.bmhome.b0.b(this);
        r100.getClass();
        ez8.a.a(r103, r102, r105);
        View r106 = getView();
        if (r106 == null) goto L13;
        r106.post(new com.larus.chat.job.impl.page.a(this));
        return;
    L13:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.larus.platform.api.d1
    public final boolean Se(String r110) {
        Intrinsics.checkNotNullParameter("scheduled_job_template", "source");
        Intrinsics.checkNotNullParameter(r110, "contentId");
        if (Intrinsics.areEqual("scheduled_job_template", "scheduled_job_template") == true) goto L6;
        FLogger.f375446a.e("ChatJobFragment", "fillInput failed, unsupported source=scheduled_job_template");
        return false;
    L6:
        FLogger r100 = FLogger.f375446a;
        r100.i("ChatJobFragment", "fillInput invoked, rawTemplateIdLength=" + r110.length());
        String r111 = StringsKt.trim(r110).toString();
        if (r111.length() <= 0) goto L9;
        boolean r101 = true;
    L10:
        String r102 = null;
        if (r101 == true) goto L14;
        r111 = null;
    L14:
        if (r111 != null) goto L17;
        r100.e("ChatJobFragment", "fillInput failed, normalized template id is empty");
        return false;
    L17:
        ICoreInputAbility r103 = this.f325060e;
        if (r103 != null) goto L21;
        r100.e("ChatJobFragment", "fillInput failed, coreInputAbility is null");
        return false;
    L21:
        ez8.a r104 = ez8.a.f474904a;
        List<i> r105 = ((ChatJobListViewModel) this.f325071p.getValue()).getUiState().getValue().f325402a;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r111, GXTemplateKey.GAIAX_TEMPLATE_ID);
        Intrinsics.checkNotNullParameter(r105, "items");
        String r106 = StringsKt.trim(r111).toString();
        if (r106.length() <= 0) goto L24;
        boolean r107 = true;
    L25:
        if (r107 == false) goto L27;
        r102 = r106;
    L27:
        if (r102 == null) goto L33;
        Pair r108 = ez8.a.b(r105, r102);
        if (r108 != null) goto L32;
        r100.w("ChatJobTracker", "recommend click skipped, templateIdLength=" + r102.length() + " not found");
        goto L33
    L32:
        ez8.a.f("recommend_cron_job_click", ez8.a.d((AIJob) r108.component1(), r102, ((Number) r108.component2()).intValue()));
    L33:
        String r109 = ((ChatJobListViewModel) this.f325071p.getValue()).resolveRecommendPrompt(r111);
        if (r109 != null) goto L37;
        r100.e("ChatJobFragment", "fillInput failed, prompt not found for templateId=".concat(r111));
        return false;
    L37:
        r100.i("ChatJobFragment", "fillInput resolved, templateId=" + r111 + ", promptLength=" + r109.length() + ", lastStatusBeforeSetText=" + r103.Rp());
        r103.mv("ChatJobFragment#fillInput", true);
        this.f325067l = r111;
        this.f325068m = r109;
        ICoreInputAbility.b.d(r103, r109, false, false, Integer.valueOf(r109.length()), Integer.valueOf(r109.length()), false, 32);
        r103.g2(3, true);
        r100.i("ChatJobFragment", "fillInput finished, lastStatusAfterSwitch=" + r103.Rp());
        return true;
    L24:
        r107 = false;
        goto L25
    L9:
        r101 = false;
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    public final void onHiddenChanged(boolean r100) {
        super.onHiddenChanged(r100);
        zb8.e r101 = this.f325061f;
        if (r101 == null) goto L5;
        r101.kL(!r100);
    L5:
        if (r100 == true) goto L17;
        ez8.a r102 = ez8.a.f474904a;
        Bundle r103 = getArguments();
        String r104 = null;
        if (r103 == null) goto L9;
        String r105 = r103.getString("argPreviousPage");
    L10:
        Bundle r106 = getArguments();
        if (r106 == null) goto L13;
        r104 = r106.getString("enter_method");
    L13:
        boolean r107 = !com.larus.bmhome.b0.b(this);
        r102.getClass();
        ez8.a.a(r105, r104, r107);
        View r108 = getView();
        if (r108 == null) goto L18;
        r108.post(new com.larus.chat.job.impl.page.a(this));
        return;
    L18:
        return;
    L9:
        r105 = null;
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Iterator<T> r102 = this.f325066k.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((cz8.j) r102.next()).a(this, r100);
        goto L4
    L6:
        ChatJobListViewModel r103 = (ChatJobListViewModel) this.f325071p.getValue();
        this.f325060e = (ICoreInputAbility) s1a.a.g(this).getAbility(ICoreInputAbility.class);
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("onViewCreated, coreInputAbilityFound=");
        boolean r106 = false;
        if (this.f325060e == null) goto L9;
        boolean r107 = true;
    L10:
        r105.append(r107);
        r105.append(", botIdEmpty=");
        Bundle r108 = getArguments();
        String r109 = null;
        if (r108 == null) goto L13;
        String r110 = r108.getString("argBotId");
    L14:
        if (r110 != null) goto L16;
    L19:
        boolean r111 = true;
    L20:
        r105.append(r111);
        r105.append(", sourceConversationIdEmpty=");
        Bundle r112 = getArguments();
        if (r112 == null) goto L23;
        String r113 = r112.getString("chat_job_source_conversation_id");
    L24:
        if (r113 != null) goto L26;
    L27:
        r106 = true;
    L28:
        r105.append(r106);
        r105.append(", enterMethod=");
        Bundle r114 = getArguments();
        if (r114 == null) goto L31;
        r109 = r114.getString("enter_method");
    L31:
        r105.append(r109);
        r104.i("ChatJobFragment", r105.toString());
        ICoreInputAbility r115 = this.f325060e;
        if (r115 == null) goto L34;
        r115.QG(this.f325069n);
        r115.JO().z9(true);
        r115.JO().R8();
        this.f325063h = true;
        r115.iN(new com.larus.chat.job.impl.page.b(this));
        r115.tr(new com.larus.chat.job.impl.page.c(this));
    L35:
        zb8.e r116 = (zb8.e) s1a.a.g(this).getAbility(zb8.e.class);
        this.f325061f = r116;
        if (r116 == null) goto L38;
        r116.mQ(new c(this), new com.larus.chat.job.impl.page.d(), new e());
    L39:
        zb8.e r117 = this.f325061f;
        if (r117 == null) goto L42;
        r117.kL(!isHidden());
    L42:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r118 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) s1a.a.g(this).getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        this.f325062g = r118;
        if (r118 == null) goto L45;
        r118.e8(this.f325070o);
    L46:
        s1a.a.g(this).k(this, Reflection.getOrCreateKotlinClass(d1.class));
        return;
    L45:
        r104.e("ChatJobFragment", "IChatBottomSpeakerAbility not found");
        goto L46
    L38:
        r104.e("ChatJobFragment", "IChatCameraAbility not found");
        goto L39
    L34:
        r104.e("ChatJobFragment", "ICoreInputAbility not found");
        goto L35
    L26:
        if (StringsKt.isBlank(r113) == false) goto L28;
    L23:
        r113 = null;
        goto L24
    L16:
        if (StringsKt.isBlank(r110) == true) goto L19;
        r111 = false;
        goto L20
    L13:
        r110 = null;
        goto L14
    L9:
        r107 = false;
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r100 = r110.inflate(R.layout.larus_chat_job_main_fragment, r111, false);
        int r101 = R.id.bottom_floating_button_container;
        if (((ViewStub) ViewBindings.findChildViewById(r100, R.id.bottom_floating_button_container)) == null) goto L76;
        r101 = R.id.bottom_layout;
        FrameLayout r102 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.bottom_layout);
        if (r102 == null) goto L76;
        r101 = R.id.bottom_menu;
        if (((BottomMenuGridLayout) ViewBindings.findChildViewById(r100, R.id.bottom_menu)) == null) goto L76;
        r101 = R.id.cancel_modify_area;
        View r103 = ViewBindings.findChildViewById(r100, R.id.cancel_modify_area);
        if (r103 == null) goto L76;
        r101 = R.id.case_layout;
        if (((ViewStub) ViewBindings.findChildViewById(r100, R.id.case_layout)) == null) goto L76;
        ChatConstraintLayout r104 = (ChatConstraintLayout) r100;
        if (((TextView) ViewBindings.findChildViewById(r100, R.id.continue_talk_btn)) != null) goto L15;
        r101 = R.id.continue_talk_btn;
        goto L76
    L15:
        if (((ViewStub) ViewBindings.findChildViewById(r100, R.id.continuous_talk_container)) == null) goto L73;
        FrameLayout r105 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.input);
        if (r105 != null) goto L19;
        r101 = R.id.input;
        goto L76
    L19:
        if (((ViewStub) ViewBindings.findChildViewById(r100, R.id.input_delegate)) != null) goto L21;
        r101 = R.id.input_delegate;
        goto L76
    L21:
        if (((TouchInterceptingView) ViewBindings.findChildViewById(r100, R.id.input_intercept_view)) != null) goto L23;
        r101 = R.id.input_intercept_view;
        goto L76
    L23:
        if (((TouchInterceptingView) ViewBindings.findChildViewById(r100, R.id.intercept_use_interact_view)) == null) goto L69;
        FrameLayout r106 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.larus_chat_job_main_content_placeholder);
        if (r106 == null) goto L68;
        FrameLayout r113 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.larus_chat_job_main_title_container);
        if (r113 != null) goto L29;
        r101 = R.id.larus_chat_job_main_title_container;
        goto L76
    L29:
        if (((ConstraintLayout) ViewBindings.findChildViewById(r100, R.id.latest_photo_shortcut_container)) != null) goto L31;
        r101 = R.id.latest_photo_shortcut_container;
        goto L76
    L31:
        if (((ViewStub) ViewBindings.findChildViewById(r100, R.id.playback_layout)) != null) goto L33;
        r101 = R.id.playback_layout;
        goto L76
    L33:
        if (((Space) ViewBindings.findChildViewById(r100, R.id.space_shortcut_x_pos)) != null) goto L35;
        r101 = R.id.space_shortcut_x_pos;
        goto L76
    L35:
        if (((Space) ViewBindings.findChildViewById(r100, R.id.space_shortcut_y_pos)) != null) goto L37;
        r101 = R.id.space_shortcut_y_pos;
        goto L76
    L37:
        if (((ViewStub) ViewBindings.findChildViewById(r100, R.id.speaker)) == null) goto L62;
        View r114 = ViewBindings.findChildViewById(r100, R.id.splitter);
        if (r114 != null) goto L41;
        r101 = R.id.splitter;
        goto L76
    L41:
        if (((ViewStub) ViewBindings.findChildViewById(r100, R.id.stub_latest_photo_shortcut)) != null) goto L43;
        r101 = R.id.stub_latest_photo_shortcut;
        goto L76
    L43:
        if (((TouchInterceptingView) ViewBindings.findChildViewById(r100, R.id.top_button_intercept_view)) != null) goto L45;
        r101 = R.id.top_button_intercept_view;
        goto L76
    L45:
        if (((TouchInterceptingView) ViewBindings.findChildViewById(r100, R.id.touch_intercepting_view)) == null) goto L58;
        this.f325059d = new LarusChatJobMainFragmentBinding(r104, r102, r103, r105, r106, r113, r114);
        if (r104 == null) goto L51;
        ViewStub r107 = (ViewStub) r104.findViewById(R.id.input_delegate);
        if (r107 == null) goto L51;
        InputViewCreatorDelegate.f298409b.a(r107, Integer.valueOf(R.id.input_delegate));
    L51:
        LarusChatJobMainFragmentBinding r108 = this.f325059d;
        if (r108 == null) goto L57;
        ChatConstraintLayout r109 = r108.f325049a;
        if (r109 == null) goto L57;
        return r109;
    L57:
        return r110.inflate(R.layout.larus_chat_job_main_fragment, r111, false);
    L58:
        r101 = R.id.touch_intercepting_view;
        goto L76
    L62:
        r101 = R.id.speaker;
        goto L76
    L68:
        r101 = R.id.larus_chat_job_main_content_placeholder;
        goto L76
    L69:
        r101 = R.id.intercept_use_interact_view;
        goto L76
    L73:
        r101 = R.id.continuous_talk_container;
    L76:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public final void U90(Context r110, String r111, wc9.e r112, ICoreInputAbility.OnSendParams r210, String r211, boolean r212) {
        FLogger r113 = FLogger.f375446a;
        StringBuilder r100 = new StringBuilder("gotoSubConversation start, botId=");
        r100.append(r111);
        r100.append(", sourceConversationId=");
        if (r112 == null) goto L5;
        String r101 = r112.f559198a;
    L6:
        r100.append(r101);
        r100.append(", autoSendContentLength=");
        if (r210 == null) goto L11;
        String r102 = r210.getContent();
        if (r102 == null) goto L11;
        int r103 = r102.length();
    L12:
        r100.append(r103);
        r100.append(", hasPendingCameraResult=");
        if (r211 == null) goto L15;
        boolean r104 = true;
    L16:
        r100.append(r104);
        r113.i("ChatJobFragment", r100.toString());
        String r105 = "cloud";
        if (r210 == null) goto L47;
        String r106 = this.f325067l;
        if (r106 == null) goto L47;
        ez8.a r107 = ez8.a.f474904a;
        List<i> r108 = ((ChatJobListViewModel) this.f325071p.getValue()).getUiState().getValue().f325402a;
        bz8.k r109 = (bz8.k) s1a.a.g(this).getAbility(bz8.k.class);
        if (r109 == null) goto L25;
        String r114 = r109.kX();
        if (r114 == null) goto L25;
    L26:
        r107.getClass();
        Intrinsics.checkNotNullParameter(r106, GXTemplateKey.GAIAX_TEMPLATE_ID);
        Intrinsics.checkNotNullParameter(r108, "items");
        Intrinsics.checkNotNullParameter(r114, "runEnvironment");
        String r115 = StringsKt.trim(r106).toString();
        if (r115.length() <= 0) goto L29;
        boolean r116 = true;
    L30:
        if (r116 == true) goto L33;
        r115 = null;
    L33:
        if (r115 == null) goto L47;
        Pair r117 = ez8.a.b(r108, r115);
        if (r117 == null) goto L38;
        AIJob r118 = (AIJob) r117.getFirst();
    L39:
        JSONObject r119 = new JSONObject().put("create_way", ThumbGlideUrl.SOURCE_TEMPLATE).put("scene", "moa").put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r115).put("run_env", r114);
        if (r118 == null) goto L44;
        String r120 = ez8.a.e(r118);
        if (r120 == null) goto L44;
        r119.put(TextureRenderKeys.KEY_IS_TEXTURE_REPEAT_TYPE, r120);
    L44:
        Intrinsics.checkNotNull(r119);
        ez8.a.f("create_cron_job", r119);
        if (r118 != null) goto L47;
        r113.w("ChatJobTracker", "create submit missing recommendation metadata, templateIdLength=" + r115.length());
        goto L47
    L38:
        r118 = null;
        goto L39
    L29:
        r116 = false;
    L25:
        r114 = "cloud";
    L47:
        if (r210 == null) goto L49;
        ChatPageContext r121 = r210.chatPageContext;
    L50:
        bz8.k r122 = (bz8.k) s1a.a.g(this).getAbility(bz8.k.class);
        if (r122 == null) goto L55;
        String r123 = r122.kX();
        if (r123 == null) goto L55;
        r105 = r123;
    L55:
        ReplyOption r124 = gz8.i.c((com.larus.bmhome.instruction.g) s1a.a.g(this).getAbility(com.larus.bmhome.instruction.g.class));
        Bundle r125 = getArguments();
        if (r125 == null) goto L58;
        Bundle r126 = new Bundle(r125);
    L59:
        r126.putString("argBotId", r111);
        r126.remove("pending_reply_mode");
        if (r124 == null) goto L62;
        r126.putSerializable("pending_reply_mode", r124);
    L62:
        r126.putParcelable("actionbar_instruction_send_message_track_ext_map", new ICoreInputAbility.SendMessageTrackExtMap(MapsKt.mapOf(TuplesKt.to("run_env", r105))));
        bz8.k r127 = (bz8.k) s1a.a.g(this).getAbility(bz8.k.class);
        if (r127 == null) goto L65;
        r127.mH(r126);
    L65:
        if (r121 != null) goto L68;
        r121 = (ChatPageContext) s1a.a.g(this).a(ChatPageContext.class);
    L68:
        if (r121 == null) goto L85;
        Map<String, String> r128 = r121.getReqExt();
        if (r128 == null) goto L85;
        if (r128.containsKey("select_project_id") == false) goto L85;
        String r129 = r128.get("select_project_id");
        if (r129 != null) goto L78;
    L81:
        boolean r130 = true;
    L82:
        if (r130 == false) goto L84;
        r126.remove(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID);
        goto L85
    L84:
        r126.putString(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, r129);
        goto L85
    L78:
        if (r129.length() == 0) goto L81;
        r130 = false;
    L85:
        if (r211 == null) goto L87;
        r126.putString("KEY_CAMERA_RESULT_PENDING_SESSION_ID", r211);
    L87:
        StringBuilder r131 = new StringBuilder("gotoSubConversation params prepared, hasProjectId=");
        String r132 = r126.getString(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID);
        if (r132 != null) goto L90;
    L93:
        boolean r133 = true;
    L94:
        r131.append(!r133);
        r113.i("ChatJobFragment", r131.toString());
        IAIChatConversationService.Companion r134 = IAIChatConversationService.f365892a;
        if (r212 == true) goto L110;
        if (r210 == null) goto L105;
        String r135 = r210.getEnterMethod();
        if (r135 == null) goto L105;
        if ((!StringsKt.isBlank(r135)) == true) goto L104;
        r135 = null;
    L104:
        if (r135 == null) goto L105;
    L111:
        if (r210 == null) goto L114;
        String r136 = r210.getPreviousPage();
        if (r136 == null) goto L114;
    L120:
        if (r212 == true) goto L131;
        String r137 = r126.getString(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID);
        if (r137 != null) goto L124;
    L127:
        boolean r138 = true;
    L128:
        if (r138 == false) goto L131;
        boolean r139 = false;
    L132:
        r134.b(r110, r111, r112, r135, r136, r139, r126, r210, false);
        r113.i("ChatJobFragment", "gotoSubConversation invoked");
        if (r210 == null) goto L156;
        ICoreInputAbility r140 = this.f325060e;
        if (r140 != null) goto L138;
        r113.e("ChatJobFragment", "reset input skipped after accepted send, coreInputAbility is null");
        this.f325067l = null;
        this.f325068m = "";
        return;
    L138:
        if (r210.clearInputContent == true) goto L140;
        r113.i("ChatJobFragment", "reset input skipped after accepted send, clearInputContent=false");
        this.f325067l = null;
        return;
    L140:
        int r141 = r140.Rp();
        if (r210.getTextFromAudio() == false) goto L145;
        Integer r142 = this.f325065j;
        if (r142 == null) goto L145;
        int r143 = r142.intValue();
    L146:
        int r144 = 2;
        if (r143 == 2) goto L150;
        r144 = 1;
    L150:
        StringBuilder r145 = new StringBuilder("reset input after accepted send, contentLength=");
        r145.append(this.f325068m.length());
        r145.append(", hasPendingTemplate=");
        if (this.f325067l == null) goto L153;
        boolean r146 = true;
    L154:
        r145.append(r146);
        r145.append(", lastStatusBeforeReset=");
        r145.append(r141);
        r145.append(", inputStatusBeforeVoiceInput=");
        r145.append(this.f325065j);
        r145.append(", statusAfterReset=");
        r145.append(r144);
        r113.i("ChatJobFragment", r145.toString());
        this.f325067l = null;
        this.f325068m = "";
        this.f325065j = null;
        r140.mv("ChatJobFragment#acceptedSend", true);
        r140.g2(r144, true);
        r113.i("ChatJobFragment", "reset input after accepted send finished, lastStatusAfterReset=" + r140.Rp());
        return;
    L153:
        r146 = false;
    L145:
        r143 = r141;
        goto L146
    L156:
        return;
    L124:
        if (r137.length() == 0) goto L127;
        r138 = false;
    L131:
        r139 = true;
    L114:
        Bundle r147 = getArguments();
        if (r147 == null) goto L117;
        r136 = r147.getString("argPreviousPage");
    L118:
        if (r136 != null) goto L120;
        r136 = "chat_job";
        goto L120
    L117:
        r136 = null;
    L105:
        Bundle r148 = getArguments();
        if (r148 == null) goto L108;
        r135 = r148.getString("enter_method");
    L109:
        if (r135 != null) goto L111;
    L108:
        r135 = null;
    L110:
        r135 = "cron_job";
        goto L111
    L90:
        if (r132.length() == 0) goto L93;
        r133 = false;
        goto L94
    L58:
        r126 = new Bundle();
        goto L59
    L49:
        r121 = null;
        goto L50
    L15:
        r104 = false;
    L11:
        r103 = 0;
        goto L12
    L5:
        r101 = null;
        goto L6
    }
}
