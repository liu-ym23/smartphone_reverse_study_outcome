package com.larus.im.internal.core.message.receiver;

import android.os.SystemClock;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.larus.im.constant.CompensateScene;
import com.larus.im.constant.PullSingleChainScene;
import com.larus.im.internal.TokenHolder;
import com.larus.im.internal.core.IMHandler;
import com.larus.im.internal.core.conversation.ConversationHandler;
import com.larus.im.internal.core.conversation.ConversationLocalManager;
import com.larus.im.internal.core.message.utils.MsgTimeoutTask;
import com.larus.im.internal.core.message.utils.f;
import com.larus.im.internal.core.message.utils.j;
import com.larus.im.internal.database.delegate.ConversationDaoSource;
import com.larus.im.internal.database.delegate.MessageDaoSource;
import com.larus.im.internal.database.entity.ConversationEntity;
import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.database.utils.OmniDatabaseExtKt;
import com.larus.im.internal.database.utils.e;
import com.larus.im.internal.delegate.d1;
import com.larus.im.internal.h;
import com.larus.im.internal.network.d;
import com.larus.im.internal.network.impl.MessageNetworkImpl;
import com.larus.im.internal.protocol.bean.DownlinkBody;
import com.larus.im.internal.protocol.bean.FetchType;
import com.larus.im.internal.protocol.bean.IMCMD;
import com.larus.im.internal.protocol.bean.MessageBody;
import com.larus.im.internal.protocol.bean.MixedTokens;
import com.larus.im.internal.protocol.bean.NewMessageNotify;
import com.larus.im.internal.protocol.bean.PullSingleChainDownlinkBody;
import com.larus.im.internal.protocol.bean.PullSingleChainUplinkBody;
import com.larus.im.internal.tracking.FlowImTracingProxy;
import com.larus.im.internal.tracking.ReceiveMessageFrom;
import com.larus.im.internal.tracking.k;
import com.larus.im.internal.tracking.q;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import ouc.e0;

/* JADX INFO: loaded from: classes4.dex */
public final class MessageReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MessageReceiver f347815a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f347816b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MessageNetworkImpl f347817c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final vt7.a f347818d = null;

    public MessageReceiver() {
    }

    static {
        f347815a = new MessageReceiver();
        f347816b = (CoroutineScope) com.larus.im.internal.core.cmd.util.c.f347539c.getValue();
        d.f349172a.getClass();
        f347817c = MessageNetworkImpl.f349200b;
        f347818d = new vt7.a();
    }

    public static void c(final h r100) {
        Intrinsics.checkNotNullParameter(r100, "mechanism");
        MessageNetworkImpl r101 = f347817c;
        Integer r102 = Integer.valueOf(IMCMD.NEW_MSG_NOTIFY.value);
        Function2 r103 = new b(r100);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r103, "listener");
        MessageNetworkImpl.f349202d.add(TuplesKt.to(r102, r103));
    }

    public static void d(DownlinkBody r100) {
        Intrinsics.checkNotNullParameter(r100, ContainerPosition.BODY);
        long r101 = SystemClock.elapsedRealtime();
        NewMessageNotify r102 = r100.newMessageNotify;
        if (r102 == null) goto L7;
        MessageBody r103 = r102.message;
        if (r103 == null) goto L7;
        String r104 = r103.conversationId;
    L8:
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        String r105 = r104;
        if (r105.length() != 0) goto L13;
        boolean r106 = true;
    L14:
        if (r106 == false) goto L16;
        return;
    L16:
        e.e(new MessageReceiver$reportFirstPackage$1(r105, r100, r102, r101, null));
        return;
    L13:
        r106 = false;
    L7:
        r104 = null;
        goto L8
    }

    public static void a(DownlinkBody r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, ContainerPosition.BODY);
        Intrinsics.checkNotNullParameter(r101, "fetchRecentConv");
        NewMessageNotify r102 = r100.newMessageNotify;
        if (r102 == null) goto L11;
        ConversationLocalManager r103 = ConversationLocalManager.INSTANCE;
        long r104 = r103.getConversationVersion();
        com.larus.im.internal.delegate.a.f348188b.i("MessageReceiver", "localVersion = " + r104 + "  preReadVersion = " + r102.preReadConvVersion + " readConvVersion = " + r102.readConvVersion);
        if (r102.preReadConvVersion <= r104) goto L7;
        r101.invoke(CompensateScene.FRONTIER_NEW_MSG);
        return;
    L7:
        long r105 = r102.readConvVersion;
        if (r105 <= r104) goto L13;
        r103.saveConversationVersion(r105);
        return;
    L13:
        return;
    }

    public static Object f(String r100, ContinuationImpl r101) {
        if (r100 == null) goto L11;
        Integer r102 = (Integer) f347818d.remove(r100);
        if (r102 == null) goto L9;
        int r103 = r102.intValue();
        Object r104 = ConversationHandler.INSTANCE.updateConversationBadgeCount(r100, r103, r101);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        return r104;
    L9:
        return Unit.INSTANCE;
    L11:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1, types: [T, com.larus.im.internal.database.entity.MessageEntity] */
    public final Object b(MessageBody r610, DownlinkBody r710, Function3<? super TokenHolder, ? super MessageEntity, ? super Continuation<? super Unit>, ? extends Object> r711, Function4<? super String, ? super Long, ? super PullSingleChainDownlinkBody, ? super Continuation<? super Unit>, ? extends Object> r712, Continuation<? super Unit> r713) {
        if ((r713 instanceof MessageReceiver$handleMessageBody$1) == false) goto L7;
        MessageReceiver$handleMessageBody$1 r100 = (MessageReceiver$handleMessageBody$1) r713;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 == 3) goto L16;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Ref.ObjectRef r105 = (Ref.ObjectRef) r100.L$1;
        MessageBody r106 = (MessageBody) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L206:
        MessageBody r107 = r106;
        Ref.ObjectRef r108 = r105;
    L212:
        Map<String, MsgTimeoutTask> r109 = j.f347872a;
        j.a(f347816b, (MessageEntity) r108.element, r107.ext);
    L227:
        return Unit.INSTANCE;
    L17:
        r108 = (Ref.ObjectRef) r100.L$4;
        NewMessageNotify r110 = (NewMessageNotify) r100.L$3;
        Function4<? super String, ? super Long, ? super PullSingleChainDownlinkBody, ? super Continuation<? super Unit>, ? extends Object> r111 = (Function4) r100.L$2;
        Function3<? super TokenHolder, ? super MessageEntity, ? super Continuation<? super Unit>, ? extends Object> r112 = (Function3) r100.L$1;
        MessageBody r113 = (MessageBody) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r107 = r113;
        Function3<? super TokenHolder, ? super MessageEntity, ? super Continuation<? super Unit>, ? extends Object> r114 = r112;
    L43:
        int r115 = com.larus.im.internal.tracking.c.f350315a;
        if (r110 == null) goto L48;
        MessageBody r116 = r110.message;
        if (r116 == null) goto L48;
        String r117 = r116.botReplyMessageId;
    L49:
        String r118 = "";
        if (r117 != null) goto L52;
        r117 = "";
    L52:
        if (r110 == null) goto L56;
        MessageBody r119 = r110.message;
        if (r119 == null) goto L56;
        String r120 = r119.messageId;
    L57:
        if (r120 != null) goto L59;
        r120 = "";
    L59:
        if (r110 == null) goto L63;
        MessageBody r121 = r110.message;
        if (r121 == null) goto L63;
        boolean r122 = com.larus.im.internal.database.utils.j.h(r121);
    L65:
        if (r117.length() != 0) goto L67;
        boolean r123 = true;
    L68:
        if (r123 == false) goto L70;
    L143:
        r103 = r103;
        r118 = "";
        r114 = r114;
    L144:
        if (r110 == null) goto L146;
        MessageBody r124 = r110.message;
    L147:
        Object r125 = f.f347865a;
        if (r124 == null) goto L150;
        String r126 = r124.botReplyMessageId;
    L151:
        if (r126 != null) goto L153;
        String r127 = r118;
    L154:
        if (r124 == null) goto L158;
        Map<String, String> r128 = r124.ext;
        if (r128 == null) goto L158;
        String r129 = com.larus.im.internal.database.utils.j.b(r128);
    L160:
        if (f.a(r127, r129) == false) goto L213;
        if (r110 == null) goto L163;
        Integer r130 = Boxing.boxInt(r110.fetchType);
    L164:
        int r131 = FetchType.CLIENT_PULL.value;
        if (r130 != null) goto L168;
    L173:
        int r132 = FetchType.CHUNK_STREAM.value;
        if (r130 != null) goto L177;
    L181:
        Function3<? super TokenHolder, ? super MessageEntity, ? super Continuation<? super Unit>, ? extends Object> r133 = r114;
        int r134 = FetchType.FRONTIER_PUSH.value;
        if (r130 != null) goto L185;
    L207:
        com.larus.im.internal.delegate.a r135 = com.larus.im.internal.delegate.a.f348188b;
        StringBuilder r136 = new StringBuilder("can't handle fetch type ,current type is ");
        if (r110 == null) goto L210;
        Integer r137 = Boxing.boxInt(r110.fetchType);
    L211:
        r136.append(r137);
        r135.i("MessageReceiver", r136.toString());
        goto L212
    L210:
        r137 = null;
        goto L211
    L185:
        if (r130.intValue() != r134) goto L207;
        MixedTokens r138 = r107.token;
        if (r138 == null) goto L189;
        String r139 = r138.sseToken;
    L190:
        MessageEntity r140 = (MessageEntity) r108.element;
        r100.L$0 = r107;
        r100.L$1 = r108;
        r100.L$2 = null;
        r100.L$3 = null;
        r100.L$4 = null;
        r100.label = 3;
        if (r139 != null) goto L193;
    L196:
        boolean r141 = true;
    L197:
        if (r141 == true) goto L202;
        Object r142 = OmniDatabaseExtKt.e(new MessageReceiver$launchChunkV2ByQuestion$2(r107, r139, r133, r140, null), r100);
        if (r142 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L203;
        r142 = Unit.INSTANCE;
    L203:
        if (r142 != r103) goto L205;
        return r103;
    L205:
        r106 = r107;
        r105 = r108;
        goto L206
    L202:
        r142 = Unit.INSTANCE;
        goto L203
    L193:
        if (StringsKt.isBlank(r139) == true) goto L196;
        r141 = false;
        goto L197
    L189:
        r139 = null;
        goto L190
    L177:
        if (r130.intValue() != r132) goto L181;
        TokenHolder r143 = new TokenHolder(r107.fetchToken, r107.token);
        Object r144 = r108.element;
        r100.L$0 = r107;
        r100.L$1 = r108;
        r100.L$2 = null;
        r100.L$3 = null;
        r100.L$4 = null;
        r100.label = 2;
        if (r114.invoke(r143, r144, r100) != r103) goto L205;
        return r103;
    L168:
        if (r130.intValue() != r131) goto L173;
        if (r110 == null) goto L171;
        MessageBody r145 = r110.message;
    L172:
        e.c(new MessageReceiver$handleClientPull$1(r145, r111, r110, null));
        goto L212
    L171:
        r145 = null;
        goto L172
    L163:
        r130 = null;
        goto L164
    L213:
        com.larus.im.internal.delegate.a r146 = com.larus.im.internal.delegate.a.f348188b;
        StringBuilder r147 = new StringBuilder("can't receive msg, because msg has been interrupt, msg id = ");
        if (r110 == null) goto L218;
        MessageBody r148 = r110.message;
        if (r148 == null) goto L218;
        String r149 = r148.messageId;
    L219:
        r147.append(r149);
        r147.append(" , reply for = ");
        if (r110 == null) goto L224;
        MessageBody r150 = r110.message;
        if (r150 == null) goto L224;
        String r151 = r150.botReplyMessageId;
    L225:
        r147.append(r151);
        r146.i("MessageReceiver", r147.toString());
    L224:
        r151 = null;
    L218:
        r149 = null;
    L158:
        r129 = null;
        goto L160
    L153:
        r127 = r126;
        goto L154
    L150:
        r126 = null;
        goto L151
    L146:
        r124 = null;
        goto L147
    L70:
        if (r120.length() != 0) goto L72;
        boolean r152 = true;
    L73:
        if (r152 == true) goto L143;
        if (r122 == true) goto L143;
        Object r153 = k.f350321a;
        Intrinsics.checkNotNullParameter(r117, "replyMsgId");
        q r154 = k.d(r117);
        long r155 = 0;
        if (r154 == null) goto L79;
        long r156 = r154.f350462j - r154.f350461i;
    L81:
        if (r156 <= 0) goto L143;
        e0 r157 = new e0();
        com.larus.im.internal.tracking.c.e(r157, ce9.a.a());
        if (r110 == null) goto L88;
        MessageBody r158 = r110.message;
        if (r158 == null) goto L88;
        String r159 = r158.senderId;
    L89:
        ouc.j.c(r157, "bot_id", r159);
        String r160 = r117;
        ouc.j.c(r157, "send_message_id", r160);
        ouc.j.c(r157, "receive_message_id", r120);
        if (r110 == null) goto L96;
        MessageBody r161 = r110.message;
        if (r161 == null) goto L96;
        Map<String, String> r162 = r161.ext;
        if (r162 == null) goto L96;
        String r163 = r162.get("is_deep_thinking");
    L97:
        String r164 = "1";
        if (Intrinsics.areEqual(r163, "1") == true) goto L101;
        r164 = null;
    L101:
        if (r164 != null) goto L103;
        r164 = "0";
    L103:
        ouc.j.c(r157, "is_deep_thinking", r164);
        Intrinsics.checkNotNullParameter(r160, "replyMsgId");
        q r165 = k.d(r160);
        if (r165 == null) goto L106;
        long r166 = r165.f350460h - r165.f350461i;
    L107:
        ouc.j.b(r157, "send_message_notify_duration", Long.valueOf(r166));
        Intrinsics.checkNotNullParameter(r160, "replyMsgId");
        q r167 = k.d(r160);
        if (r167 == null) goto L110;
        long r168 = r167.f350463k - r167.f350459g;
    L111:
        ouc.j.b(r157, "send_message_network_duration", Long.valueOf(r168));
        Intrinsics.checkNotNullParameter(r160, "replyMsgId");
        q r169 = k.d(r160);
        if (r169 == null) goto L114;
        long r170 = r169.f350464l - r169.f350463k;
    L115:
        ouc.j.b(r157, "send_message_ack_notify_duration", Long.valueOf(r170));
        Intrinsics.checkNotNullParameter(r160, "replyMsgId");
        q r171 = k.d(r160);
        if (r171 == null) goto L118;
        long r172 = r171.f350462j - r171.f350461i;
    L119:
        ouc.j.b(r157, "send_message_total_duration", Long.valueOf(r172));
        Intrinsics.checkNotNullParameter(r160, "replyMsgId");
        q r173 = k.d(r160);
        if (r173 == null) goto L122;
        long r174 = r173.f350470r - r173.f350463k;
    L123:
        ouc.j.b(r157, "first_package_network_duration", Long.valueOf(r174));
        Intrinsics.checkNotNullParameter(r160, "replyMsgId");
        q r175 = k.d(r160);
        if (r175 == null) goto L126;
        long r176 = r175.f350471s - r175.f350470r;
    L127:
        ouc.j.b(r157, "first_package_notify_duration", Long.valueOf(r176));
        Intrinsics.checkNotNullParameter(r160, "replyMsgId");
        q r177 = k.d(r160);
        if (r177 == null) goto L130;
        long r178 = r177.f350473u - r177.f350472t;
    L131:
        ouc.j.b(r157, "first_package_sync_db_duration", Long.valueOf(r178));
        Intrinsics.checkNotNullParameter(r160, "replyMsgId");
        q r179 = k.d(r160);
        if (r179 == null) goto L134;
        long r180 = r179.f350471s - r179.f350473u;
    L135:
        ouc.j.b(r157, "first_package_typewriter_duration", Long.valueOf(r180));
        Intrinsics.checkNotNullParameter(r160, "replyMsgId");
        q r181 = k.d(r160);
        if (r181 == null) goto L138;
        long r182 = r181.f350474v;
    L139:
        ouc.j.b(r157, "first_package_pending_duration", Long.valueOf(r182));
        Intrinsics.checkNotNullParameter(r160, "replyMsgId");
        q r183 = k.d(r160);
        if (r183 == null) goto L142;
        r155 = r183.f350471s - r183.f350463k;
    L142:
        ouc.j.b(r157, "first_package_total_duration", Long.valueOf(r155));
        d1.f348206b.a("flow_imsdk_message_chain_duration", r157.a());
        goto L144
    L138:
        r182 = 0;
        goto L139
    L134:
        r180 = 0;
        goto L135
    L130:
        r178 = 0;
        goto L131
    L126:
        r176 = 0;
        goto L127
    L122:
        r174 = 0;
        goto L123
    L118:
        r172 = 0;
        goto L119
    L114:
        r170 = 0;
        goto L115
    L110:
        r168 = 0;
        goto L111
    L106:
        r166 = 0;
    L96:
        r163 = null;
    L88:
        r159 = null;
        goto L89
    L79:
        r156 = 0;
        goto L81
    L72:
        r152 = false;
        goto L73
    L67:
        r123 = false;
    L63:
        r122 = true;
    L56:
        r120 = null;
    L48:
        r117 = null;
        goto L49
    L18:
        ResultKt.throwOnFailure(r102);
        NewMessageNotify r184 = r710.newMessageNotify;
        if (r184 == null) goto L21;
        Integer r185 = Boxing.boxInt(r184.fetchType);
    L22:
        int r186 = FetchType.CLIENT_PULL.value;
        if (r185 != null) goto L26;
    L28:
        int r187 = FetchType.CHUNK_STREAM.value;
        if (r185 != null) goto L32;
    L34:
        if (r184 == null) goto L38;
        MessageBody r188 = r184.message;
        if (r188 == null) goto L38;
        int r189 = com.larus.im.internal.database.utils.j.c(r188);
    L39:
        r108 = new Ref.ObjectRef();
        r108.element = new MessageEntity("", null, null, null, null, 0, 0, 0, false, 0, 0, null, null, null, 0, false, null, null, null, null, null, null, null, null, null, 0, null, false, null, 0, null, 0, null, null, null, null, null, null, null, null, null, null, 0, 0, -2, UnixStat.PERM_MASK, null);
        MessageReceiver$handleMessageBody$2 r190 = new MessageReceiver$handleMessageBody$2(r610, r108, r189, r185, r184, null);
        r100.L$0 = r610;
        r100.L$1 = r711;
        r100.L$2 = r712;
        r100.L$3 = r184;
        r100.L$4 = r108;
        r100.label = 1;
        if (OmniDatabaseExtKt.e(r190, r100) != r103) goto L42;
        return r103;
    L42:
        r114 = r711;
        r111 = r712;
        r110 = r184;
        r107 = r610;
    L38:
        r189 = 21;
        goto L39
    L32:
        if (r185.intValue() != r187) goto L34;
    L33:
        r189 = 20;
        goto L39
    L26:
        if (r185.intValue() != r186) goto L28;
    L21:
        r185 = null;
    L7:
        r100 = new MessageReceiver$handleMessageBody$1(this, r713);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object e(String r210, String r211, String r212, Function1<? super String, Unit> r213, Continuation<? super Unit> r310) {
        String r100 = r212;
        if ((r310 instanceof MessageReceiver$tryPullLatestMsg$1) == false) goto L7;
        MessageReceiver$tryPullLatestMsg$1 r101 = (MessageReceiver$tryPullLatestMsg$1) r310;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        MessageReceiver$tryPullLatestMsg$1 r103 = r101;
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L22;
        if (r106 == 1) goto L21;
        if (r106 == 2) goto L20;
        if (r106 == 3) goto L19;
        if (r106 == 4) goto L18;
        if (r106 != 5) goto L17;
        List<MessageBody> r107 = (List) r103.L$2;
        Function1<? super String, Unit> r108 = (Function1) r103.L$1;
        String r109 = (String) r103.L$0;
        ResultKt.throwOnFailure(r104);
        MessageBody r110 = null;
    L53:
        if (r107 == null) goto L62;
        Iterator<T> r111 = r107.iterator();
    L56:
        if (r111.hasNext() == false) goto L60;
        Object r112 = r111.next();
        if (Intrinsics.areEqual(((MessageBody) r112).botReplyMessageId, r109) == false) goto L56;
    L61:
        MessageBody r113 = (MessageBody) r112;
    L63:
        if (r113 == null) goto L65;
        r108.invoke(r109);
    L65:
        if (r107 == null) goto L80;
        Iterator<T> r114 = r107.iterator();
    L68:
        if (r114.hasNext() == false) goto L72;
        Object r115 = r114.next();
        if (Intrinsics.areEqual(((MessageBody) r115).botReplyMessageId, r109) == false) goto L68;
        Object r116 = r115;
    L73:
        MessageBody r117 = (MessageBody) r116;
        if (r117 == null) goto L80;
        FlowImTracingProxy r118 = FlowImTracingProxy.f350219a;
        String r119 = r117.messageId;
        if (r119 != null) goto L78;
        r119 = "";
    L78:
        r118.t(r119, Boxing.boxInt(3), new NewMessageNotify(r117, 0, 0, 0, 0, null, 0, 126, null), ReceiveMessageFrom.FIRST_PACKAGE_TIME_OUT, Boxing.boxLong(SystemClock.elapsedRealtime()));
        goto L80
    L72:
        r116 = r110;
    L80:
        return Unit.INSTANCE;
    L60:
        r112 = r110;
        goto L61
    L62:
        r113 = r110;
        goto L63
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        com.larus.im.internal.network.e r120 = (com.larus.im.internal.network.e) r103.L$3;
        Function1<? super String, Unit> r121 = (Function1) r103.L$2;
        String r122 = (String) r103.L$1;
        String r123 = (String) r103.L$0;
        ResultKt.throwOnFailure(r104);
    L48:
        com.larus.im.internal.network.e r124 = r120;
        Function1<? super String, Unit> r125 = r121;
    L49:
        String r126 = r122;
        String r127 = r123;
        PullSingleChainDownlinkBody r128 = (PullSingleChainDownlinkBody) ((com.larus.im.internal.network.e.f) r124).f349185a;
        List<MessageBody> r129 = r128.messages;
        IMHandler r130 = IMHandler.f347513a;
        Map<String, MessageBody> r131 = r128.regenMessages;
        r110 = null;
        MessageReceiver$tryPullLatestMsg$2 r132 = new MessageReceiver$tryPullLatestMsg$2(null);
        r103.L$0 = r126;
        r103.L$1 = r125;
        r103.L$2 = r129;
        r103.L$3 = null;
        r103.label = 5;
        if (r130.c(r127, r129, r131, r132, r103) != r105) goto L52;
        return r105;
    L52:
        r108 = r125;
        r109 = r126;
        r107 = r129;
        goto L53
    L19:
        r125 = (Function1) r103.L$3;
        String r133 = (String) r103.L$2;
        r122 = (String) r103.L$1;
        String r134 = (String) r103.L$0;
        ResultKt.throwOnFailure(r104);
        String r135 = r133;
        r123 = r134;
    L40:
        r124 = (com.larus.im.internal.network.e) r104;
        if ((r124 instanceof com.larus.im.internal.network.e.f) == false) goto L80;
        long r136 = RangesKt.coerceAtLeast(((PullSingleChainDownlinkBody) ((com.larus.im.internal.network.e.f) r124).f349185a).msgCursor, 0);
        if (com.flow.kmp.common.util.f.a(r135) == false) goto L49;
        be9.b r137 = ae9.b.a();
        r103.L$0 = r123;
        r103.L$1 = r122;
        r103.L$2 = r125;
        r103.L$3 = r124;
        r103.label = 4;
        if (((ConversationDaoSource) r137).n(r135, r136, r103) != r105) goto L47;
        return r105;
    L47:
        r121 = r125;
        r120 = r124;
        goto L48
    L20:
        long r138 = r103.J$0;
        r125 = (Function1) r103.L$3;
        String r139 = (String) r103.L$2;
        String r140 = (String) r103.L$1;
        String r141 = (String) r103.L$0;
        ResultKt.throwOnFailure(r104);
        r135 = r139;
        long r142 = r138;
    L30:
        ConversationEntity r143 = (ConversationEntity) r104;
        if (r143 == null) goto L35;
        Integer r144 = r143.getConversationType();
        if (r144 == null) goto L35;
        int r145 = r144.intValue();
    L36:
        String r146 = r135;
        PullSingleChainUplinkBody r147 = new PullSingleChainUplinkBody(r146, r145, 2, r142, 5, null, 32, null);
        MessageNetworkImpl r148 = f347817c;
        PullSingleChainScene r149 = PullSingleChainScene.FRONTIER_TIMEOUT;
        r103.L$0 = r141;
        r103.L$1 = r140;
        r103.L$2 = r135;
        r103.L$3 = r125;
        r103.label = 3;
        r104 = r148.d(r149, r147, false, r103);
        if (r104 != r105) goto L39;
        return r105;
    L39:
        r122 = r140;
        r123 = r141;
    L35:
        r145 = 0;
        goto L36
    L21:
        Function1<? super String, Unit> r150 = (Function1) r103.L$3;
        String r151 = (String) r103.L$2;
        String r152 = (String) r103.L$1;
        String r153 = (String) r103.L$0;
        ResultKt.throwOnFailure(r104);
        Function1<? super String, Unit> r154 = r150;
        r100 = r151;
    L26:
        long r155 = ((Number) r104).longValue();
        be9.b r156 = ae9.b.a();
        r103.L$0 = r153;
        r103.L$1 = r152;
        r103.L$2 = r100;
        r103.L$3 = r154;
        r103.J$0 = r155;
        r103.label = 2;
        r104 = be9.b.C0295b.a(r156, r100, 0, r103, 6);
        if (r104 != r105) goto L29;
        return r105;
    L29:
        r142 = r155;
        r140 = r152;
        r141 = r153;
        r135 = r100;
        r125 = r154;
        goto L30
    L22:
        ResultKt.throwOnFailure(r104);
        be9.d r157 = ae9.e.a();
        r103.L$0 = r210;
        r103.L$1 = r211;
        r103.L$2 = r100;
        r154 = r213;
        r103.L$3 = r154;
        r103.label = 1;
        r104 = ((MessageDaoSource) r157).B(r100, r103);
        if (r104 != r105) goto L25;
        return r105;
    L25:
        r152 = r211;
        r153 = r210;
    L7:
        r101 = new MessageReceiver$tryPullLatestMsg$1(this, r310);
        goto L8
    }
}
