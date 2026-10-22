package com.larus.office.plugins.inputv2.component.slides;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.im.bean.message.Message;
import com.larus.im.j;
import com.larus.office.OfficeInputParam;
import com.larus.office.plugins.inputv2.coordinator.document.c;
import com.larus.office.plugins.inputv2.coordinator.runtime.integration.m;
import com.larus.ui.arch.component.external.api.Component;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import dw8.t;
import ic8.n;
import java.util.Map;
import jo9.l;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import po9.b;
import ro9.d;
import ro9.e;
import ro9.g;
import va8.t0;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\b\u0005\b\u0000\u0018\u0000 I2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001IB;\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010!\u001a\u00020\u000fH\u0016J\b\u0010\"\u001a\u00020\u000fH\u0016J\u0010\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%H\u0016J\u0018\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020,H\u0016J\u0018\u0010-\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%2\u0006\u0010.\u001a\u00020\u000eH\u0002J\u001c\u0010/\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u000e2\n\b\u0002\u00100\u001a\u0004\u0018\u00010%H\u0002J\u0010\u00101\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u00102\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u000eH\u0002J\u0010\u00105\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u000eH\u0002J\u000e\u00106\u001a\u00020\u000e*\u0004\u0018\u00010\u000eH\u0002J\u0010\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u000209H\u0002J\u0012\u0010:\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010<\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\b\u0010=\u001a\u00020\u000fH\u0016J\u0017\u0010>\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0002\u0010?J\b\u0010@\u001a\u00020\u000fH\u0016J\u001c\u0010A\u001a\u00020\u000f2\b\u0010B\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010C\u001a\u00020\u000f2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0E2\b\u0010F\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010G\u001a\u00020\u000f2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0EH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/larus/office/plugins/inputv2/component/slides/SlidesChatComponentV2;", "Lcom/larus/ui/arch/component/external/api/Component;", "Lcom/larus/office/plugins/input/ability/ISlidesChatCoreAbility;", "Lcom/larus/office/plugins/inputv2/message/OfficeSlidesMessageProvider;", "Lcom/larus/business/floatchat/api/OnMessageChangedObserver;", "adapter", "Lcom/larus/office/plugins/inputv2/adapter/OfficeChatInputAdapter;", "paramsProvider", "Lkotlin/Function0;", "Lcom/larus/office/OfficeInputParam;", "answerStateCoordinator", "Lcom/larus/office/plugins/inputv2/coordinator/document/OfficeAnswerStateCoordinator;", "onExpandRequired", "Lkotlin/Function1;", "", "", "<init>", "(Lcom/larus/office/plugins/inputv2/adapter/OfficeChatInputAdapter;Lkotlin/jvm/functions/Function0;Lcom/larus/office/plugins/inputv2/coordinator/document/OfficeAnswerStateCoordinator;Lkotlin/jvm/functions/Function1;)V", "artifactVersionId", "referenceData", "structureVersion", "", "Ljava/lang/Integer;", "queryId", "localQueryId", "currentAnswerMessageId", "hasSentMessage", "", "localConversationWhenSend", "hasExpanded", "isRefSelect", "stateListener", "Lcom/larus/business/floatchat/api/IAIChatAbilityHostStateListener;", "onAttach", LiveCommonConstants.REASON_ON_DEDTROY, "onSendMessage", "message", "Lcom/larus/im/bean/message/Message;", "onSendMessageResult", "onUpdateMessage", "onReceiveMessageEnd", "onReceiveRefreshCmd", "queryMsgId", WsConstants.KEY_PAYLOAD, "Lcom/larus/bmhome/ability/ViewBusinessPayload;", "isCurrentAnswerMessage", "source", "restoreCurrentAnswerTrackingIfNeeded", "triggerMessage", "shouldCaptureLocalConversationAnswer", "rememberAnswer", "completeAnswer", "reason", "expandOnce", "safeLogId", "handleAbilityState", "state", "Lcom/larus/business/floatchat/api/AIChatAbilityHostState;", "setReferenceData", "data", "refSelectStateChange", "clearReferenceData", "setStructureVersion", "(Ljava/lang/Integer;)V", "clearQueryId", "refreshArtifactInfo", "artifactMetaId", "putMessageExt", "ext", "", "actionBarKey", "setSlidesMessageExt", "map", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SlidesChatComponentV2 extends Component implements l, g, t {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.larus.office.plugins.inputv2.adapter.g f362756l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<OfficeInputParam> f362757m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f362758n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function1<String, Unit> f362759o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f362760p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f362761q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Integer f362762r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f362763s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f362764t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f362765u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f362766v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f362767w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f362768x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f362769y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final po9.a f362770z;

    public static final class a {
    }

    static {
    }

    @Override // dw8.t
    public final void ba(String r100, t0 r101) {
        Intrinsics.checkNotNullParameter(r100, "queryMsgId");
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
    }

    @Override // jo9.f
    /* JADX INFO: renamed from: if */
    public final void mo8561if() {
    }

    @Override // dw8.t
    public final void t() {
    }

    @Override // dw8.t
    public final void y() {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        this.f362756l.t(this);
        this.f362756l.n(this.f362770z);
        ro9.a<d> r100 = e.f538798a;
        Intrinsics.checkNotNullParameter(this, ShortVideoSegments.KEY_PROP_PROVIDER);
        e.f538801d.c(this);
    }

    @Override // com.larus.ui.arch.component.external.api.Component, com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        this.f362756l.l(this);
        this.f362756l.a(this.f362770z);
        ro9.a<d> r100 = e.f538798a;
        Intrinsics.checkNotNullParameter(this, ShortVideoSegments.KEY_PROP_PROVIDER);
        e.f538801d.a(this);
    }

    @Override // dw8.t
    public final void F1(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f362763s = r100.getMessageId();
        this.f362764t = r100.getLocalMessageId();
        this.f362765u = null;
        boolean r101 = true;
        this.f362766v = true;
        String r102 = r100.getConversationId();
        if (r102 == null) goto L7;
        Lazy r103 = n.f489237a;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        if (j.f(r102) != true) goto L7;
    L8:
        this.f362767w = r101;
        this.f362768x = false;
        this.f362758n.c();
        return;
    L7:
        r101 = false;
        goto L8
    }

    public final void F2(String r100) {
        boolean r101 = this.f362758n.f362780f;
        if (this.f362766v == true) goto L5;
    L11:
        if (r101 == false) goto L13;
        this.f362768x = true;
    L13:
        this.f362766v = false;
        this.f362767w = false;
        this.f362758n.a();
        return;
    L5:
        if (this.f362768x == true) goto L11;
        if (r101 == true) goto L11;
        String r102 = r100.concat("#without_ai_edit");
        if (this.f362768x == true) goto L13;
        this.f362768x = true;
        this.f362759o.invoke(r102);
        goto L13
    }

    @Override // ro9.g
    public final void O0(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        OfficeInputParam r101 = this.f362757m.invoke();
        if (r101 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r101.getType(), "slides") == true) goto L8;
        r101 = null;
    L8:
        OfficeInputParam r102 = r101;
        if (r102 == null) goto L23;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        int r104 = b.f530141a;     // Catch: Throwable -> L13
        b.a(r100, r102, this.f362760p, this.f362762r, this.f362761q, this.f362769y);     // Catch: Throwable -> L13
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L22;
        FLogger.f375446a.e("OfficeSlidesChatV2", "构建 Slides 消息扩展失败", r106);
        return;
    L22:
        return;
    L13:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    @Override // jo9.f
    public final void P(boolean r100) {
        this.f362769y = true;
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

    @Override // jo9.f
    public final void TX(Integer r100) {
        this.f362762r = r100;
    }

    @Override // jo9.f
    public final void a6(String r100) {
        this.f362761q = r100;
        this.f362769y = false;
    }

    @Override // dw8.t
    public final void oa(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        String r101 = r100.getLocalMessageId();
        String r102 = r100.getMessageId();
        boolean r103 = false;
        if (o0.d(this.f362764t) == true) goto L5;
    L7:
        boolean r104 = false;
    L8:
        FLogger.f375446a.i("OfficeSlidesChatV2", "关联发送结果, matchedLocalQuery=" + r104 + ", remoteQueryId=" + P2(r102) + ", resultLocalQueryId=" + P2(r101) + ", currentLocalQueryId=" + P2(this.f362764t));
        if (r104 == false) goto L18;
        if (r102 != null) goto L12;
    L13:
        r103 = true;
    L14:
        if (r103 == true) goto L19;
        this.f362763s = r102;
        return;
    L19:
        return;
    L12:
        if (r102.length() != 0) goto L14;
    L18:
        return;
    L5:
        if (Intrinsics.areEqual(r101, this.f362764t) == false) goto L7;
        r104 = true;
        goto L8
    }

    @Override // dw8.t
    public final void p(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        OfficeInputParam r101 = this.f362757m.invoke();
        if (r101 == null) goto L5;
        String r102 = r101.getType();
    L7:
        if (Intrinsics.areEqual(r102, "slides") == true) goto L9;
        return;
    L9:
        if (com.larus.bmhome.chat.bean.d.G0(r100) == false) goto L11;
        return;
    L11:
        if (L2(r100, "message_update") == false) goto L20;
        this.f362765u = r100.getMessageId();
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
        OfficeInputParam r101 = this.f362757m.invoke();
        if (r101 == null) goto L5;
        String r102 = r101.getType();
    L7:
        if (Intrinsics.areEqual(r102, "slides") == true) goto L9;
        return;
    L9:
        if (com.larus.bmhome.chat.bean.d.G0(r100) == false) goto L11;
        return;
    L11:
        if (L2(r100, "stream_end") == false) goto L16;
        this.f362765u = r100.getMessageId();
        F2("stream_end");
        return;
    L16:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // jo9.f
    public final void D8(String r100, String r101) {
        if (r101 == null) goto L5;
        this.f362760p = r101;
        return;
    }

    public final boolean L2(Message r100, String r101) {
        N2(r101, r100);
        String r102 = r100.getReplyId();
        boolean r103 = false;
        if (o0.d(this.f362763s) == false) goto L8;
        if (Intrinsics.areEqual(r102, this.f362763s) == false) goto L8;
        String r104 = "query_id";
    L36:
        if (r104 == null) goto L38;
        r103 = true;
    L38:
        if (r103 == true) goto L40;
        FLogger.f375446a.w("OfficeSlidesChatV2", "当前回答未匹配, source=" + r101 + ", msgId=" + P2(r100.getMessageId()) + ", replyId=" + P2(r102) + ", conversationId=" + P2(r100.getConversationId()) + ", queryId=" + P2(this.f362763s) + ", localQueryId=" + P2(this.f362764t) + ", answerMsgId=" + P2(this.f362765u) + ", hasSent=" + this.f362766v + ", localConversation=" + this.f362767w);
    L40:
        return r103;
    L8:
        if (o0.d(this.f362764t) == false) goto L13;
        if (Intrinsics.areEqual(r102, this.f362764t) == false) goto L13;
        r104 = "local_query_id";
    L13:
        if (o0.d(this.f362765u) == true) goto L15;
    L17:
        String r105 = this.f362765u;
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
        if (this.f362766v == false) goto L32;
        if (this.f362767w == false) goto L32;
        if (o0.d(r100.getReplyId()) == false) goto L32;
        r107 = true;
        goto L33
    L20:
        if (r105.length() == 0) goto L23;
        r106 = false;
        goto L24
    L15:
        if (Intrinsics.areEqual(r100.getMessageId(), this.f362765u) == false) goto L17;
        r104 = "answer_message_id";
        goto L36
    }

    public final void N2(String r100, Message r101) {
        if (this.f362766v == false) goto L5;
        return;
    L5:
        if (o0.d(this.f362763s) == false) goto L7;
        return;
    L7:
        if (o0.d(this.f362764t) == true) goto L22;
        int r102 = lo9.b.f510157a;
        lo9.b.a r103 = lo9.b.c(this.f362756l, r101);
        if (r103 != null) goto L12;
        return;
    L12:
        Message r104 = r103.f510158a;
        Message r105 = r103.f510159b;
        this.f362763s = r105.getMessageId();
        this.f362764t = r105.getLocalMessageId();
        this.f362765u = r104.getMessageId();
        boolean r106 = true;
        this.f362766v = true;
        String r107 = r105.getConversationId();
        if (r107 == null) goto L17;
        Lazy r108 = n.f489237a;
        Intrinsics.checkNotNullParameter(r107, "<this>");
        if (j.f(r107) != true) goto L17;
    L18:
        this.f362767w = r106;
        FLogger.f375446a.i("OfficeSlidesChatV2", "补建当前回答追踪, source=" + r100 + ", queryId=" + P2(r105.getMessageId()) + ", localQueryId=" + P2(r105.getLocalMessageId()) + ", answerMsgId=" + P2(r104.getMessageId()) + ", replyId=" + P2(r104.getReplyId()));
        return;
    L17:
        r106 = false;
        goto L18
    }

    public SlidesChatComponentV2(com.larus.office.plugins.inputv2.adapter.g r100, Function0 r101, c r102, m r103) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        Intrinsics.checkNotNullParameter(r101, "paramsProvider");
        Intrinsics.checkNotNullParameter(r102, "answerStateCoordinator");
        Intrinsics.checkNotNullParameter(r103, "onExpandRequired");
        this.f362756l = r100;
        this.f362757m = r101;
        this.f362758n = r102;
        this.f362759o = r103;
        OfficeInputParam r104 = (OfficeInputParam) r101.invoke();
        if (r104 == null) goto L5;
        String r105 = r104.getArtifactVersionId();
    L6:
        this.f362760p = r105;
        this.f362770z = new po9.a(this);
        return;
    L5:
        r105 = null;
        goto L6
    }
}
