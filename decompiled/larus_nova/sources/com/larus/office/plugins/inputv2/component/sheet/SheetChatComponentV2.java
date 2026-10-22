package com.larus.office.plugins.inputv2.component.sheet;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.im.bean.message.Message;
import com.larus.office.OfficeInputParam;
import com.larus.office.plugins.inputv2.adapter.g;
import com.larus.office.plugins.inputv2.coordinator.document.c;
import com.larus.office.plugins.inputv2.coordinator.runtime.integration.k;
import com.larus.ui.arch.component.external.api.Component;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import dw8.t;
import ic8.n;
import java.util.Map;
import jo9.i;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import oo9.b;
import ro9.d;
import ro9.e;
import ro9.f;
import va8.t0;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0004\b\u0000\u0018\u0000 E2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001EBO\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010 \u001a\u00020\u000fH\u0016J\b\u0010!\u001a\u00020\u000fH\u0016J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u0010,\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$2\u0006\u0010-\u001a\u00020\u000eH\u0002J\u001c\u0010.\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u000e2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010$H\u0002J\u0010\u00100\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u00101\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u000eH\u0002J\u0010\u00104\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u000eH\u0002J\u000e\u00105\u001a\u00020\u001a*\u0004\u0018\u00010\u000eH\u0002J\u000e\u00106\u001a\u00020\u000e*\u0004\u0018\u00010\u000eH\u0002J\u0010\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u000209H\u0002J\u0012\u0010:\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010<\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010=\u001a\u00020\u000fH\u0016J\b\u0010>\u001a\u00020\u000fH\u0016J\u001c\u0010?\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010@\u001a\u00020\u000f2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0B2\b\u0010C\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010D\u001a\u00020\u000f2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0BH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/larus/office/plugins/inputv2/component/sheet/SheetChatComponentV2;", "Lcom/larus/ui/arch/component/external/api/Component;", "Lcom/larus/office/plugins/input/ability/ISheetChatCoreAbility;", "Lcom/larus/office/plugins/inputv2/message/OfficeSheetMessageProvider;", "Lcom/larus/business/floatchat/api/OnMessageChangedObserver;", "adapter", "Lcom/larus/office/plugins/inputv2/adapter/OfficeChatInputAdapter;", "paramsProvider", "Lkotlin/Function0;", "Lcom/larus/office/OfficeInputParam;", "answerStateCoordinator", "Lcom/larus/office/plugins/inputv2/coordinator/document/OfficeAnswerStateCoordinator;", "onExpandRequired", "Lkotlin/Function1;", "", "", "onSelectionSent", "<init>", "(Lcom/larus/office/plugins/inputv2/adapter/OfficeChatInputAdapter;Lkotlin/jvm/functions/Function0;Lcom/larus/office/plugins/inputv2/coordinator/document/OfficeAnswerStateCoordinator;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "artifactVersionId", "artifactMetaId", "referenceData", "queryId", "localQueryId", "currentAnswerMessageId", "hasSentMessageInCurrentPage", "", "localConversationWhenSend", "isRefSelect", "hasExpandedForCurrentAnswer", "stateListener", "Lcom/larus/business/floatchat/api/IAIChatAbilityHostStateListener;", "onAttach", LiveCommonConstants.REASON_ON_DEDTROY, "onSendMessage", "message", "Lcom/larus/im/bean/message/Message;", "onSendMessageResult", "onUpdateMessage", "onReceiveMessageEnd", "onReceiveRefreshCmd", "queryMsgId", WsConstants.KEY_PAYLOAD, "Lcom/larus/bmhome/ability/ViewBusinessPayload;", "isCurrentAnswerMessage", "source", "restoreCurrentAnswerTrackingIfNeeded", "triggerMessage", "shouldCaptureLocalConversationAnswer", "rememberCurrentAnswerMessage", "completeCurrentAnswer", "reason", "expandOnce", "isSheetLocalConversationId", "safeLogId", "handleAbilityState", "state", "Lcom/larus/business/floatchat/api/AIChatAbilityHostState;", "setReferenceData", "data", "refSelectStateChange", "clearReferenceData", "clearQueryId", "refreshArtifactInfo", "putMessageExt", "ext", "", "actionBarKey", "setSheetMessageExt", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SheetChatComponentV2 extends Component implements i, f, t {
    public static final /* synthetic */ int B = 0;
    public final oo9.a A;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final g f362741l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<OfficeInputParam> f362742m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f362743n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function1<String, Unit> f362744o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function1<String, Unit> f362745p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f362746q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f362747r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f362748s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f362749t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f362750u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f362751v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f362752w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f362753x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f362754y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f362755z;

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
        this.f362754y = false;
    }

    @Override // dw8.t
    public final void t() {
    }

    @Override // dw8.t
    public final void y() {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        this.f362741l.t(this);
        this.f362741l.n(this.A);
        ro9.a<d> r100 = e.f538798a;
        Intrinsics.checkNotNullParameter(this, ShortVideoSegments.KEY_PROP_PROVIDER);
        e.f538800c.c(this);
    }

    @Override // com.larus.ui.arch.component.external.api.Component, com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        this.f362741l.l(this);
        this.f362741l.a(this.A);
        ro9.a<d> r100 = e.f538798a;
        Intrinsics.checkNotNullParameter(this, ShortVideoSegments.KEY_PROP_PROVIDER);
        e.f538800c.a(this);
    }

    @Override // dw8.t
    public final void F1(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f362749t = r100.getMessageId();
        this.f362750u = r100.getLocalMessageId();
        this.f362751v = null;
        this.f362752w = true;
        this.f362753x = N2(r100.getConversationId());
        this.f362755z = false;
        this.f362743n.c();
    }

    public final void F2(String r100) {
        boolean r101 = this.f362743n.f362780f;
        if (this.f362752w == true) goto L5;
    L11:
        if (r101 == false) goto L13;
        this.f362755z = true;
    L13:
        this.f362752w = false;
        this.f362753x = false;
        this.f362743n.a();
        return;
    L5:
        if (this.f362755z == true) goto L11;
        if (r101 == true) goto L11;
        String r102 = r100.concat("#without_ai_edit");
        if (this.f362755z == true) goto L13;
        this.f362755z = true;
        this.f362744o.invoke(r102);
        goto L13
    }

    public final boolean N2(String r100) {
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L18;
        if (r100 != null) goto L11;
    L13:
        boolean r102 = false;
    L14:
        if (r102 == true) goto L19;
        return false;
    L19:
        return true;
    L11:
        if (StringsKt.contains$default(r100, "-sheets-detail", false, 2, null) != true) goto L13;
        r102 = true;
        goto L14
    L18:
        return true;
    L5:
        if (n.s(r100) != true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // jo9.f
    public final void P(boolean r100) {
        this.f362754y = true;
    }

    public final void P2(Message r100) {
        if (Intrinsics.areEqual(this.f362751v, r100.getMessageId()) == true) goto L6;
        this.f362751v = r100.getMessageId();
        FLogger.f375446a.i("OfficeSheetChatV2", "记录当前回答, msgId=" + r100.getMessageId() + ", replyId=" + r100.getReplyId());
        return;
    }

    public final String X2(String r100) {
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
    public final void a6(String r100) {
        this.f362748s = r100;
    }

    @Override // dw8.t
    public final void oa(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        String r101 = r100.getLocalMessageId();
        String r102 = r100.getMessageId();
        boolean r103 = false;
        if (o0.d(this.f362750u) == true) goto L5;
    L7:
        boolean r104 = false;
    L8:
        FLogger.f375446a.i("OfficeSheetChatV2", "关联发送结果, matchedLocalQuery=" + r104 + ", remoteQueryId=" + X2(r102) + ", resultLocalQueryId=" + X2(r101) + ", currentLocalQueryId=" + X2(this.f362750u));
        if (r104 == false) goto L18;
        if (r102 != null) goto L12;
    L13:
        r103 = true;
    L14:
        if (r103 == true) goto L19;
        this.f362749t = r102;
        return;
    L19:
        return;
    L12:
        if (r102.length() != 0) goto L14;
    L18:
        return;
    L5:
        if (Intrinsics.areEqual(r101, this.f362750u) == false) goto L7;
        r104 = true;
        goto L8
    }

    @Override // dw8.t
    public final void p(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        OfficeInputParam r101 = this.f362742m.invoke();
        if (r101 == null) goto L5;
        String r102 = r101.getType();
    L7:
        if (Intrinsics.areEqual(r102, DocumentType.SHEET_NAME) == true) goto L9;
        return;
    L9:
        if (com.larus.bmhome.chat.bean.d.G0(r100) == false) goto L12;
        return;
    L12:
        if (L2(r100, "message_update") == true) goto L14;
        return;
    L14:
        P2(r100);
        if (com.larus.bmhome.chat.bean.d.j0(r100) == false) goto L19;
        F2("message_finished");
        return;
    L19:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // ro9.f
    public final void p0(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "ext");
        OfficeInputParam r101 = this.f362742m.invoke();
        if (r101 == null) goto L5;
        String r102 = r101.getType();
    L7:
        if (Intrinsics.areEqual(r102, DocumentType.SHEET_NAME) == true) goto L18;
        return;
    L18:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        int r104 = b.f524659a;     // Catch: Throwable -> L11
        b.a(r100, r101, this.f362747r, this.f362746q, this.f362748s, this.f362754y);     // Catch: Throwable -> L11
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L16;
        FLogger.f375446a.e("OfficeSheetChatV2", "构建 Sheet 消息扩展失败", r106);
    L16:
        this.f362754y = false;
        this.f362745p.invoke("sheet_send");
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
    public final void za(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        OfficeInputParam r101 = this.f362742m.invoke();
        if (r101 == null) goto L5;
        String r102 = r101.getType();
    L7:
        if (Intrinsics.areEqual(r102, DocumentType.SHEET_NAME) == true) goto L9;
        return;
    L9:
        if (com.larus.bmhome.chat.bean.d.G0(r100) == false) goto L11;
        return;
    L11:
        if (L2(r100, "stream_end") == false) goto L17;
        P2(r100);
        F2("stream_end");
        return;
    L17:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // jo9.f
    public final void D8(String r100, String r101) {
        if (r100 == null) goto L4;
        this.f362747r = r100;
    L4:
        if (r101 == null) goto L7;
        this.f362746q = r101;
        return;
    }

    public final boolean L2(Message r100, String r101) {
        U2(r101, r100);
        String r102 = r100.getReplyId();
        boolean r103 = false;
        if (o0.d(this.f362749t) == false) goto L8;
        if (Intrinsics.areEqual(r102, this.f362749t) == false) goto L8;
        String r104 = "query_id";
    L36:
        if (r104 == null) goto L38;
        r103 = true;
    L38:
        if (r103 == true) goto L40;
        FLogger.f375446a.w("OfficeSheetChatV2", "当前回答未匹配, source=" + r101 + ", msgId=" + X2(r100.getMessageId()) + ", replyId=" + X2(r102) + ", conversationId=" + X2(r100.getConversationId()) + ", queryId=" + X2(this.f362749t) + ", localQueryId=" + X2(this.f362750u) + ", answerMsgId=" + X2(this.f362751v) + ", hasSent=" + this.f362752w + ", localConversation=" + this.f362753x);
    L40:
        return r103;
    L8:
        if (o0.d(this.f362750u) == false) goto L13;
        if (Intrinsics.areEqual(r102, this.f362750u) == false) goto L13;
        r104 = "local_query_id";
    L13:
        if (o0.d(this.f362751v) == true) goto L15;
    L17:
        String r105 = this.f362751v;
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
        if (this.f362752w == false) goto L32;
        if (this.f362753x == false) goto L32;
        if (o0.d(r100.getReplyId()) == false) goto L32;
        r107 = true;
        goto L33
    L20:
        if (r105.length() == 0) goto L23;
        r106 = false;
        goto L24
    L15:
        if (Intrinsics.areEqual(r100.getMessageId(), this.f362751v) == false) goto L17;
        r104 = "answer_message_id";
        goto L36
    }

    public final void U2(String r100, Message r101) {
        if (this.f362752w == false) goto L5;
        return;
    L5:
        if (o0.d(this.f362749t) == false) goto L7;
        return;
    L7:
        if (o0.d(this.f362750u) == true) goto L16;
        int r102 = lo9.b.f510157a;
        lo9.b.a r103 = lo9.b.c(this.f362741l, r101);
        if (r103 != null) goto L12;
        return;
    L12:
        Message r104 = r103.f510158a;
        Message r105 = r103.f510159b;
        this.f362749t = r105.getMessageId();
        this.f362750u = r105.getLocalMessageId();
        this.f362751v = r104.getMessageId();
        this.f362752w = true;
        this.f362753x = N2(r105.getConversationId());
        FLogger.f375446a.i("OfficeSheetChatV2", "补建当前回答追踪, source=" + r100 + ", queryId=" + X2(r105.getMessageId()) + ", localQueryId=" + X2(r105.getLocalMessageId()) + ", answerMsgId=" + X2(r104.getMessageId()) + ", replyId=" + X2(r104.getReplyId()));
        return;
    }

    public SheetChatComponentV2(g r100, Function0 r101, c r102, k r103, Function1 r104) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        Intrinsics.checkNotNullParameter(r101, "paramsProvider");
        Intrinsics.checkNotNullParameter(r102, "answerStateCoordinator");
        Intrinsics.checkNotNullParameter(r103, "onExpandRequired");
        Intrinsics.checkNotNullParameter(r104, "onSelectionSent");
        this.f362741l = r100;
        this.f362742m = r101;
        this.f362743n = r102;
        this.f362744o = r103;
        this.f362745p = r104;
        OfficeInputParam r105 = (OfficeInputParam) r101.invoke();
        String r106 = null;
        if (r105 == null) goto L5;
        String r107 = r105.getArtifactVersionId();
    L6:
        this.f362746q = r107;
        OfficeInputParam r108 = (OfficeInputParam) r101.invoke();
        if (r108 == null) goto L9;
        r106 = r108.getArtifactMetaId();
    L9:
        if (r106 != null) goto L11;
        r106 = "";
    L11:
        this.f362747r = r106;
        this.A = new oo9.a(this);
        return;
    L5:
        r107 = null;
        goto L6
    }
}
