package com.obric.assistant;

import com.bytedance.keva.Keva;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.state.api.v2.core.IObricMsgInfoSaveService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/ObricMsgInfoSaveServiceImpl;", "Lcom/obric/assistant/state/api/v2/core/IObricMsgInfoSaveService;", "<init>", "()V", "keva", "Lcom/bytedance/keva/Keva;", "lastSendMessageCreateTime", "", "lastReceiveMessageCreateTime", "lastReceiveMessageId", "", "saveInformationOnSendOrRegenMessage", "", "saveInformationOnReceiveMessage", "saveMsgInfoOnRegen", "msg", "Lcom/larus/im/bean/message/Message;", "saveMsgInfoOnSend", "saveMsgRespondedTimeForOtherContentType", "saveMsgRespondedTime", "isCurrentReplyMessage", "", "isDismissMsg", "savePendingSendMessage", "clearPendingSendMessage", "getPendingSendMessageCreateTime", "isReplyForPendingSendMessage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMsgInfoSaveServiceImpl implements IObricMsgInfoSaveService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Keva f385162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f385163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f385164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f385165d;

    public static final class a {
    }

    static {
    }

    public final long e() {
        Long r100 = Long.valueOf(this.f385162a.getLong("last_send_message_create_time", this.f385163b));
        if (r100.longValue() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        r100 = null;
    L9:
        if (r100 == null) goto L12;
        return r100.longValue();
    L12:
        return this.f385163b;
    L5:
        r101 = false;
        goto L6
    }

    public final void f() {
        FLogger.f375446a.i("ObricMsgInfoSaveServiceImpl", "saveInformationOnReceiveMessage");
        this.f385162a.storeLong("response_end_time", System.currentTimeMillis());
        this.f385162a.storeBoolean("is_shown_in_response", false);
        this.f385162a.storeString("last_send_message_id", "");
        this.f385162a.storeString("last_send_message_conversation_id", "");
    }

    public final void g() {
        FLogger.f375446a.i("ObricMsgInfoSaveServiceImpl", "saveInformationOnSendOrRegenMessage");
        this.f385162a.storeBoolean("is_shown_in_response", true);
        this.f385162a.storeBoolean("is_shown_after_responded", false);
        this.f385162a.storeLong("last_message_send_time_ms", System.currentTimeMillis());
        this.f385162a.storeLong("last_message_send_time_s", System.currentTimeMillis() / ((long) 1000));
        this.f385162a.storeLong("last_send_message_create_time", this.f385163b);
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L6;
        this.f385162a.storeLong("last_message_send_time_in_device_locked", System.currentTimeMillis());
        return;
    }

    public ObricMsgInfoSaveServiceImpl() {
        this.f385162a = xg9.b.a();
        this.f385165d = "";
    }

    @Override // com.obric.assistant.state.api.v2.core.IObricMsgInfoSaveService
    public final void a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (com.larus.utils.o0.d(com.larus.bmhome.chat.bean.d.o(r100)) == false) goto L6;
        FLogger.f375446a.i("ObricMsgInfoSaveServiceImpl", "message onRegen and is not empty, store LAST_MESSAGE_SEND_TIME");
        this.f385163b = r100.getCreateTime();
        h(r100);
        g();
        return;
    }

    @Override // com.obric.assistant.state.api.v2.core.IObricMsgInfoSaveService
    public final void b(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        long r101 = e();
        if (r100.getContentType() == 800) goto L5;
        return;
    L5:
        if (r100.getCreateTime() > r101) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r100.getMessageId(), this.f385165d) == true) goto L12;
        FLogger.f375446a.i("ObricMsgInfoSaveServiceImpl", "onMessageReceiveEnd contentType is other, store RESPONSE_END_TIME");
        this.f385165d = String.valueOf(r100.getMessageId());
        f();
        return;
    }

    @Override // com.obric.assistant.state.api.v2.core.IObricMsgInfoSaveService
    public final void c(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (com.larus.utils.o0.d(com.larus.bmhome.chat.bean.d.o(r100)) == false) goto L6;
        FLogger.f375446a.i("ObricMsgInfoSaveServiceImpl", "message onSend and is not empty, store LAST_MESSAGE_SEND_TIME");
        this.f385163b = r100.getCreateTime();
        h(r100);
        g();
        return;
    }

    public final void h(Message r100) {
        Keva r101 = this.f385162a;
        String r102 = r100.getMessageId();
        String r103 = "";
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.storeString("last_send_message_id", r102);
        Keva r104 = this.f385162a;
        String r105 = r100.getConversationId();
        if (r105 == null) goto L9;
        r103 = r105;
    L9:
        r104.storeString("last_send_message_conversation_id", r103);
    }

    @Override // com.obric.assistant.state.api.v2.core.IObricMsgInfoSaveService
    public final void d(boolean r110, Message r111) {
        Intrinsics.checkNotNullParameter(r111, "msg");
        boolean r100 = false;
        if (com.larus.bmhome.chat.bean.d.k0(r111) == false) goto L5;
    L12:
        boolean r101 = true;
    L14:
        if (r101 == false) goto L18;
        FLogger.f375446a.i("ObricMsgInfoSaveServiceImpl", "saveMsgRespondedTime isDismissMsg:true");
        return;
    L18:
        if (r111.getContentType() == 66) goto L20;
    L22:
        boolean r102 = false;
    L23:
        String r103 = "";
        String r104 = this.f385162a.getString("last_send_message_id", "");
        if (r104 != null) goto L27;
        r104 = "";
    L27:
        if (r104.length() != 0) goto L29;
        boolean r105 = true;
    L30:
        if (r105 == true) goto L52;
        String r106 = this.f385162a.getString("last_send_message_conversation_id", "");
        if (r106 != null) goto L36;
        r106 = "";
    L36:
        if (r106.length() <= 0) goto L38;
        boolean r107 = true;
    L39:
        if (r107 == false) goto L48;
        String r108 = r111.getConversationId();
        if (r108 == null) goto L45;
        r103 = r108;
    L45:
        if (Intrinsics.areEqual(r106, r103) == false) goto L52;
    L48:
        if (Intrinsics.areEqual(r111.getReplyId(), r104) == false) goto L52;
        if (r111.getCreateTime() <= e()) goto L52;
        boolean r109 = true;
    L54:
        if (r110 == true) goto L67;
        if (r109 == true) goto L67;
        if (Intrinsics.areEqual(r111.getReplyId(), "0") == true) goto L59;
    L60:
        Map<String, String> r112 = r111.getExt();
        if (r112 == null) goto L63;
        String r113 = r112.get("msg_scene");
    L65:
        if (Intrinsics.areEqual(r113, "edu_homework_correction") == true) goto L67;
    L69:
        if (r102 == true) goto L71;
        if (r100 == true) goto L71;
        return;
    L71:
        FLogger.f375446a.i("ObricMsgInfoSaveServiceImpl", "CurrentReplyMessage is true real ending, store RESPONSE_END_TIME, isMultiContentSubReceiving:" + r102 + ", isValidReply:" + r100 + ", isReplyForPendingSendMessage:" + r109);
        if (r111.getCreateTime() <= this.f385164c) goto L74;
        this.f385164c = r111.getCreateTime();
        this.f385165d = String.valueOf(r111.getMessageId());
    L74:
        f();
        if (r102 == false) goto L79;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ObricMsgInfoSaveServiceImpl$saveMsgRespondedTime$1(this, null), 3, null);
        return;
    L79:
        return;
    L63:
        r113 = null;
        goto L65
    L59:
        if (r111.getCreateTime() <= e()) goto L60;
    L67:
        if (Intrinsics.areEqual(r111.getMessageId(), this.f385165d) == true) goto L69;
        r100 = true;
        goto L69
    L38:
        r107 = false;
    L52:
        r109 = false;
        goto L54
    L29:
        r105 = false;
        goto L30
    L20:
        if (com.larus.im.bean.message.a.z0(r111) == false) goto L22;
        r102 = true;
        goto L23
    L5:
        if (com.larus.bmhome.chat.bean.d.W0(r111) == true) goto L12;
        if (com.larus.bmhome.chat.bean.d.O0(r111) == true) goto L12;
        if (com.larus.bmhome.chat.bean.d.X(r111) == true) goto L12;
        r101 = false;
        goto L14
    }
}
