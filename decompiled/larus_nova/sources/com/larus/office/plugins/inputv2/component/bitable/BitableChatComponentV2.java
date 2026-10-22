package com.larus.office.plugins.inputv2.component.bitable;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.im.bean.message.Message;
import com.larus.im.j;
import com.larus.office.OfficeInputParam;
import com.larus.office.plugins.inputv2.adapter.g;
import com.larus.office.plugins.inputv2.coordinator.document.c;
import com.larus.ui.arch.component.external.api.Component;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import dw8.r;
import dw8.t;
import ic8.n;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ro9.d;
import ro9.e;
import va8.t0;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\b\u0000\u0018\u0000 82\u00020\u00012\u00020\u00022\u00020\u0003:\u00018BK\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020'H\u0016J\u0018\u0010(\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010)\u001a\u00020\u000fH\u0002J\u001c\u0010*\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u000f2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010 H\u0002J\u0010\u0010,\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010-\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u000fH\u0002J\u0010\u00100\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u000fH\u0002J\u000e\u00101\u001a\u00020\u000f*\u0004\u0018\u00010\u000fH\u0002J\u0010\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u000204H\u0002J\u001c\u00105\u001a\u00020\u00102\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f07H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/larus/office/plugins/inputv2/component/bitable/BitableChatComponentV2;", "Lcom/larus/ui/arch/component/external/api/Component;", "Lcom/larus/office/plugins/inputv2/message/OfficeBitableMessageProvider;", "Lcom/larus/business/floatchat/api/OnMessageChangedObserver;", "adapter", "Lcom/larus/office/plugins/inputv2/adapter/OfficeChatInputAdapter;", "paramsProvider", "Lkotlin/Function0;", "Lcom/larus/office/OfficeInputParam;", "contextProvider", "Lcom/bytedance/ee/bear/bitable/context/BitableContext;", "answerStateCoordinator", "Lcom/larus/office/plugins/inputv2/coordinator/document/OfficeAnswerStateCoordinator;", "onExpandRequired", "Lkotlin/Function1;", "", "", "<init>", "(Lcom/larus/office/plugins/inputv2/adapter/OfficeChatInputAdapter;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/larus/office/plugins/inputv2/coordinator/document/OfficeAnswerStateCoordinator;Lkotlin/jvm/functions/Function1;)V", "queryId", "localQueryId", "currentAnswerMessageId", "hasSentMessage", "", "localConversationWhenSend", "hasExpanded", "stateListener", "Lcom/larus/business/floatchat/api/IAIChatAbilityHostStateListener;", "onAttach", LiveCommonConstants.REASON_ON_DEDTROY, "onSendMessage", "message", "Lcom/larus/im/bean/message/Message;", "onSendMessageResult", "onUpdateMessage", "onReceiveMessageEnd", "onReceiveRefreshCmd", "queryMsgId", WsConstants.KEY_PAYLOAD, "Lcom/larus/bmhome/ability/ViewBusinessPayload;", "isCurrentAnswerMessage", "source", "restoreCurrentAnswerTrackingIfNeeded", "triggerMessage", "shouldCaptureLocalConversationAnswer", "rememberCurrentAnswerMessage", "completeAnswer", "reason", "expandOnce", "safeLogId", "handleAbilityState", "state", "Lcom/larus/business/floatchat/api/AIChatAbilityHostState;", "setBitableMessageExt", "map", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableChatComponentV2 extends Component implements ro9.b, t {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f362704x = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final g f362705l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<OfficeInputParam> f362706m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function0<tr4.a> f362707n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f362708o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function1<String, Unit> f362709p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f362710q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f362711r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f362712s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f362713t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f362714u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f362715v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final b f362716w;

    public static final class a {
    }

    public /* synthetic */ class b implements r, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableChatComponentV2 f362717a;

        public b(BitableChatComponentV2 r100) {
            this.f362717a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof r) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return new FunctionReferenceImpl(1, this.f362717a, BitableChatComponentV2.class, "handleAbilityState", "handleAbilityState(Lcom/larus/business/floatchat/api/AIChatAbilityHostState;)V", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // dw8.r
        public final void a(dw8.a r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            BitableChatComponentV2 r101 = this.f362717a;
            int r102 = BitableChatComponentV2.f362704x;
            r101.getClass();
            if (r100.f470327b == false) goto L6;
            r101.N2("ability_ready", null);
            return;
        }
    }

    static {
    }

    @Override // dw8.t
    public final void ba(String r100, t0 r101) {
        Intrinsics.checkNotNullParameter(r100, "queryMsgId");
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
    }

    @Override // dw8.t
    public final void t() {
    }

    @Override // dw8.t
    public final void y() {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        this.f362705l.t(this);
        this.f362705l.n(this.f362716w);
        ro9.a<d> r100 = e.f538798a;
        Intrinsics.checkNotNullParameter(this, ShortVideoSegments.KEY_PROP_PROVIDER);
        e.f538802e.c(this);
    }

    @Override // com.larus.ui.arch.component.external.api.Component, com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        this.f362705l.l(this);
        this.f362705l.a(this.f362716w);
        ro9.a<d> r100 = e.f538798a;
        Intrinsics.checkNotNullParameter(this, ShortVideoSegments.KEY_PROP_PROVIDER);
        e.f538802e.a(this);
    }

    @Override // dw8.t
    public final void F1(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f362710q = r100.getMessageId();
        this.f362711r = r100.getLocalMessageId();
        this.f362712s = null;
        boolean r101 = true;
        this.f362713t = true;
        String r102 = r100.getConversationId();
        if (r102 == null) goto L7;
        Lazy r103 = n.f489237a;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        if (j.f(r102) != true) goto L7;
    L8:
        this.f362714u = r101;
        this.f362715v = false;
        this.f362708o.c();
        return;
    L7:
        r101 = false;
        goto L8
    }

    public final void F2(String r100) {
        boolean r101 = this.f362708o.f362780f;
        if (this.f362713t == true) goto L5;
    L11:
        if (r101 == false) goto L13;
        this.f362715v = true;
    L13:
        this.f362713t = false;
        this.f362714u = false;
        this.f362708o.a();
        return;
    L5:
        if (this.f362715v == true) goto L11;
        if (r101 == true) goto L11;
        String r102 = r100.concat("#without_ai_edit");
        if (this.f362715v == true) goto L13;
        this.f362715v = true;
        this.f362709p.invoke(r102);
        goto L13
    }

    public final String P2(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L14;
        if (r100 != null) goto L11;
        return "null";
    L11:
        return "empty";
    L14:
        return "len=" + r100.length() + ",hash=" + r100.hashCode();
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    @Override // ro9.b
    public final void l2(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        OfficeInputParam r101 = this.f362706m.invoke();
        if (r101 == null) goto L5;
        String r102 = r101.getType();
    L7:
        if (Intrinsics.areEqual(r102, "base") == true) goto L17;
        return;
    L17:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        int r104 = mo9.a.f514618a;     // Catch: Throwable -> L11
        mo9.a.a(r100, this.f362707n.invoke());     // Catch: Throwable -> L11
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L19;
        FLogger.f375446a.e("OfficeBitableChatV2", "构建 Bitable 消息扩展失败", r106);
        return;
    L19:
        return;
    L11:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L5:
        r102 = null;
        goto L7
    }

    @Override // dw8.t
    public final void oa(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        String r101 = r100.getLocalMessageId();
        String r102 = r100.getMessageId();
        boolean r103 = false;
        if (o0.d(this.f362711r) == true) goto L5;
    L7:
        boolean r104 = false;
    L8:
        FLogger.f375446a.i("OfficeBitableChatV2", "关联发送结果, matchedLocalQuery=" + r104 + ", remoteQueryId=" + P2(r102) + ", resultLocalQueryId=" + P2(r101) + ", currentLocalQueryId=" + P2(this.f362711r));
        if (r104 == false) goto L18;
        if (r102 != null) goto L12;
    L13:
        r103 = true;
    L14:
        if (r103 == true) goto L19;
        this.f362710q = r102;
        return;
    L19:
        return;
    L12:
        if (r102.length() != 0) goto L14;
    L18:
        return;
    L5:
        if (Intrinsics.areEqual(r101, this.f362711r) == false) goto L7;
        r104 = true;
        goto L8
    }

    @Override // dw8.t
    public final void p(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        OfficeInputParam r101 = this.f362706m.invoke();
        if (r101 == null) goto L5;
        String r102 = r101.getType();
    L7:
        if (Intrinsics.areEqual(r102, "base") == true) goto L9;
        return;
    L9:
        if (com.larus.bmhome.chat.bean.d.G0(r100) == false) goto L11;
        return;
    L11:
        if (L2(r100, "message_update") == false) goto L20;
        this.f362712s = r100.getMessageId();
        if (com.larus.bmhome.chat.bean.d.j0(r100) == false) goto L19;
        F2("message_finished");
        return;
    L19:
        return;
    L20:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // dw8.t
    public final void za(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        OfficeInputParam r101 = this.f362706m.invoke();
        if (r101 == null) goto L5;
        String r102 = r101.getType();
    L7:
        if (Intrinsics.areEqual(r102, "base") == true) goto L9;
        return;
    L9:
        if (com.larus.bmhome.chat.bean.d.G0(r100) == false) goto L11;
        return;
    L11:
        if (L2(r100, "stream_end") == false) goto L16;
        this.f362712s = r100.getMessageId();
        F2("stream_end");
        return;
    L16:
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final boolean L2(Message r100, String r101) {
        N2(r101, r100);
        String r102 = r100.getReplyId();
        boolean r103 = false;
        if (o0.d(this.f362710q) == false) goto L8;
        if (Intrinsics.areEqual(r102, this.f362710q) == false) goto L8;
        String r104 = "query_id";
    L36:
        if (r104 == null) goto L38;
        r103 = true;
    L38:
        if (r103 == true) goto L40;
        FLogger.f375446a.w("OfficeBitableChatV2", "当前回答未匹配, source=" + r101 + ", msgId=" + P2(r100.getMessageId()) + ", replyId=" + P2(r102) + ", conversationId=" + P2(r100.getConversationId()) + ", queryId=" + P2(this.f362710q) + ", localQueryId=" + P2(this.f362711r) + ", answerMsgId=" + P2(this.f362712s) + ", hasSent=" + this.f362713t + ", localConversation=" + this.f362714u);
    L40:
        return r103;
    L8:
        if (o0.d(this.f362711r) == false) goto L13;
        if (Intrinsics.areEqual(r102, this.f362711r) == false) goto L13;
        r104 = "local_query_id";
    L13:
        if (o0.d(this.f362712s) == true) goto L15;
    L17:
        String r105 = this.f362712s;
        if (r105 != null) goto L20;
    L23:
        boolean r106 = true;
    L24:
        if (r106 == true) goto L26;
    L32:
        boolean r107 = false;
    L33:
        if (r107 == false) goto L35;
        r104 = "local_conversation_fallback";
        goto L36
    L35:
        r104 = null;
        goto L36
    L26:
        if (this.f362713t == false) goto L32;
        if (this.f362714u == false) goto L32;
        if (o0.d(r100.getReplyId()) == false) goto L32;
        r107 = true;
        goto L33
    L20:
        if (r105.length() == 0) goto L23;
        r106 = false;
        goto L24
    L15:
        if (Intrinsics.areEqual(r100.getMessageId(), this.f362712s) == false) goto L17;
        r104 = "answer_message_id";
        goto L36
    }

    public final void N2(String r100, Message r101) {
        if (this.f362713t == false) goto L5;
        return;
    L5:
        if (o0.d(this.f362710q) == false) goto L7;
        return;
    L7:
        if (o0.d(this.f362711r) == true) goto L22;
        int r102 = lo9.b.f510157a;
        lo9.b.a r103 = lo9.b.c(this.f362705l, r101);
        if (r103 != null) goto L12;
        return;
    L12:
        Message r104 = r103.f510158a;
        Message r105 = r103.f510159b;
        this.f362710q = r105.getMessageId();
        this.f362711r = r105.getLocalMessageId();
        this.f362712s = r104.getMessageId();
        boolean r106 = true;
        this.f362713t = true;
        String r107 = r105.getConversationId();
        if (r107 == null) goto L17;
        Lazy r108 = n.f489237a;
        Intrinsics.checkNotNullParameter(r107, "<this>");
        if (j.f(r107) != true) goto L17;
    L18:
        this.f362714u = r106;
        FLogger.f375446a.i("OfficeBitableChatV2", "补建当前回答追踪, source=" + r100 + ", queryId=" + P2(r105.getMessageId()) + ", localQueryId=" + P2(r105.getLocalMessageId()) + ", answerMsgId=" + P2(r104.getMessageId()) + ", replyId=" + P2(r104.getReplyId()));
        return;
    L17:
        r106 = false;
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BitableChatComponentV2(g r100, Function0<OfficeInputParam> r101, Function0<tr4.a> r102, c r103, Function1<? super String, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        Intrinsics.checkNotNullParameter(r101, "paramsProvider");
        Intrinsics.checkNotNullParameter(r102, "contextProvider");
        Intrinsics.checkNotNullParameter(r103, "answerStateCoordinator");
        Intrinsics.checkNotNullParameter(r104, "onExpandRequired");
        this.f362705l = r100;
        this.f362706m = r101;
        this.f362707n = r102;
        this.f362708o = r103;
        this.f362709p = r104;
        this.f362716w = new b(this);
    }
}
