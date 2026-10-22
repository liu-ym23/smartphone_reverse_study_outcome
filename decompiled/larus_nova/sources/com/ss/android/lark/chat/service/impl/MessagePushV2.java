package com.ss.android.lark.chat.service.impl;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.MessageFoldDetail;
import com.bytedance.lark.pb.basic.v1.QuasiMessage;
import com.bytedance.lark.pb.basic.v1.Thread;
import com.bytedance.lark.pb.im.v1.AIRoundInfo;
import com.bytedance.lark.pb.im.v1.PushMessageReactions;
import com.bytedance.lark.pb.im.v1.PushMessageReadStates;
import com.bytedance.lark.pb.im.v1.PushMessageResponse;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.SmartReplyEntryInfo;
import com.ss.android.lark.chat.entity.reaction.Reaction;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.ModelParserMessage;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class MessagePushV2 implements m6b.u {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final AtomicLong f416374l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Executor f416375m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f416376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f416377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<com.ss.android.lark.biz.im.api.k0> f416378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList<g0> f416379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, List<com.ss.android.lark.biz.im.api.f1>> f416380e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f416381f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f416382g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f416383h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f416384i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f416385j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy<Boolean> f416386k;

    public static final class a {
    }

    public static final class b implements Function1<Throwable, Unit> {
        public b() {
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable r100) {
            Throwable r101 = r100;
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            Log.e("MessagePush", r101);
            return Unit.INSTANCE;
        }
    }

    public static final class c implements Function1<PushMessageResponse, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessagePushV2 f416387a;

        public c(MessagePushV2 r100) {
            this.f416387a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PushMessageResponse r100) {
            PushMessageResponse r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "response");
            HashMap r102 = new HashMap();     // Catch: Throwable -> L17
            List<AIRoundInfo> r103 = r101.ai_last_round_infos;     // Catch: Throwable -> L17
            if (r103 != null) goto L6;
        L9:
            boolean r104 = true;
        L10:
            if (r104 == true) goto L20;
            Iterator<AIRoundInfo> r105 = r101.ai_last_round_infos.iterator();     // Catch: Throwable -> L17
        L13:
            if (r105.hasNext() == false) goto L15;
            AIRoundInfo r106 = r105.next();     // Catch: Throwable -> L17
            r102.put(Long.valueOf(r106.round_last_position.intValue()), r106);     // Catch: Throwable -> L17
            goto L13
        L15:
            CoreThreadPool.getDefault().getUIExecutor().execute(new g1(r101, this.f416387a));     // Catch: Throwable -> L17
        L20:
            return Unit.INSTANCE;
        L6:
            if (r103.isEmpty() == true) goto L9;
            r104 = false;
        L17:
            th = move-exception;
            Log.e("MessagePush", th, true);
            goto L20
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessagePushV2 f416388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MessageInfo f416389b;

        public d(MessagePushV2 r100, MessageInfo r101) {
            this.f416388a = r100;
            this.f416389b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<g0> r100 = this.f416388a.f416379d.iterator();     // Catch: Throwable -> L7
        L4:
            if (r100.hasNext() == false) goto L16;
            r100.next().c(this.f416389b);     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    static {
        f416374l = new AtomicLong(0);
        f416375m = PThreadExecutorsUtils.newSingleThreadExecutor(new com.larksuite.framework.thread.n("thread-pool-message-push"));
    }

    @Override // m6b.u
    public final void dispose() {
        Log.i("MessagePush", "dispose id:" + this.f416382g + ",uid:" + this.f416376a);
        this.f416381f.dispose();
    }

    @Override // m6b.u
    public final void I(MessageInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "preMessageInfo");
        f416375m.execute(new d(this, r100));
    }

    @Override // m6b.u
    public final void K3(g0 r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f416379d.addIfAbsent(r100) == false) goto L8;
        Log.i("MessagePush", "addPushPreMessageListener success:" + this.f416386k.getValue().booleanValue() + ",id:" + this.f416382g);
        return;
    L8:
        Log.i("MessagePush", "addPushPreMessageListener duplicated,id:" + this.f416382g);
    }

    @Override // m6b.u
    public final void O3(com.ss.android.lark.biz.im.api.k0 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Log.i("MessagePush", "removePushMessageListener success:" + this.f416378c.remove(r100) + ",id:" + this.f416382g);
    }

    @Override // m6b.u
    public final void gc(com.ss.android.lark.biz.im.api.k0 r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f416378c.addIfAbsent(r100) == false) goto L8;
        Log.i("MessagePush", "addPushMessageListener success:" + this.f416386k.getValue().booleanValue() + ",id:" + this.f416382g);
        return;
    L8:
        Log.i("MessagePush", "addPushMessageListener duplicated,id:" + this.f416382g);
    }

    @Override // m6b.u
    public final void kd(g0 r100) {
        Log.i("MessagePush", "removePushPreMessageListener success:" + this.f416379d.remove(r100) + ",id:" + this.f416382g);
    }

    @Inject
    public MessagePushV2(String r100, com.bytedance.lark.rustclient.api.l r101) {
        Intrinsics.checkNotNullParameter(r100, "currentUserId");
        Intrinsics.checkNotNullParameter(r101, "userClient");
        this.f416376a = r100;
        this.f416377b = r101;
        this.f416378c = new CopyOnWriteArrayList();
        this.f416379d = new CopyOnWriteArrayList();
        this.f416380e = new ConcurrentHashMap();
        this.f416381f = new CompositeDisposable();
        long r102 = f416374l.getAndIncrement();
        this.f416382g = r102;
        this.f416383h = new b();
        LazyThreadSafetyMode r103 = LazyThreadSafetyMode.SYNCHRONIZED;
        this.f416384i = LazyKt.lazy(r103, new MessagePushV2$roundInfoDisposable$2(this));
        this.f416385j = new c(this);
        this.f416386k = LazyKt.lazy(r103, new MessagePushV2$observePushMessageResult$1(this));
        Log.i("MessagePush", "init uid:" + r100 + ",id:" + r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(final MessagePushV2 r210, PushMessageResponse r211) {
        r210.getClass();
        Function5<MessageInfo, Chat, ThreadTopic, List<? extends MessageInfo>, List<? extends MessageInfo>, Unit> r100 = new MessagePushV2$handlePushMessage$1(r210);
        Function1 r101 = new MessagePushV2$handlePushMessage$2(r210);
        Intrinsics.checkNotNullParameter(r211, "pushMessageResponse");
        Entity r102 = r211.entity;
        String r103 = "MessagePush";
        if (r102 != null) goto L5;
        Log.i("MessagePush", "handlePushMessage entity == null");
        return;
    L5:
        List<PushMessageResponse.MessageItem> r104 = r211.message_items;
        Map<String, Message> r110 = ModelParserMessage.h(r102);
        int r111 = 1;
        com.ss.android.lark.chat.entity.chatter.a r112 = com.ss.android.lark.parser.internal.b.d(r102, true);
        Map r113 = null;
        Map<String, Chat> r114 = com.ss.android.lark.parser.internal.h.d(r102.chats, null, r102.mail_setting);
        Map<String, Thread> r105 = r102.threads;
        LinkedHashMap r115 = new LinkedHashMap();
        if (r105 == null) goto L13;
        Iterator<String> r106 = r105.keySet().iterator();
    L9:
        if (r106.hasNext() == false) goto L13;
        String r107 = r106.next();
        ThreadTopic r108 = com.ss.android.lark.parser.internal.b0.a(r105.get(r107));
        if (r108 == null) goto L9;
        r115.put(r107, r108);
    L13:
        HashMap r109 = new HashMap();
        Iterator<PushMessageResponse.MessageItem> r116 = r104.iterator();
    L15:
        if (r116.hasNext() == false) goto L182;
        PushMessageResponse.MessageItem r117 = r116.next();
        String r118 = r117.item_id;
        PushMessageResponse.MessageItem.ItemType r119 = r117.item_type;
        if (r119 != null) goto L19;
        int r120 = -1;
    L21:
        if (r120 != r111) goto L23;
    L54:
        HashMap r121 = r109;
        Intrinsics.checkNotNull(r102);
        Intrinsics.checkNotNull(r112);
        Intrinsics.checkNotNull(r118);
        if (r117.item_type != PushMessageResponse.MessageItem.ItemType.EPHEMERAL_MESSAGE) goto L57;
        boolean r122 = true;
    L58:
        Intrinsics.checkNotNullParameter(r102, "entity");
        Intrinsics.checkNotNullParameter(r110, "allMessagesMap");
        Intrinsics.checkNotNullParameter(r112, "chatChatters");
        Intrinsics.checkNotNullParameter(r121, "messageInfoMap");
        Intrinsics.checkNotNullParameter(r118, "itemId");
        LinkedHashMap r123 = (LinkedHashMap) r110;
        Message r124 = (Message) r123.get(r118);
        if (r122 == false) goto L61;
        com.bytedance.lark.pb.basic.v1.Message r125 = r102.ephemeral_messages.get(r118);
    L62:
        if (r124 == null) goto L134;
        if (r125 == null) goto L134;
        r124.setEphemeral(r122);
        Log.i("MessagePushV2", "push message:" + r124);
        ChatChatter r126 = r112.b(r124.getChatId(), r124.getFromId());
        String r127 = r124.getId();
        String r128 = r124.getChatId();
        MessageInfo r129 = (MessageInfo) r121.get(r127);
        if (r129 != null) goto L68;
        MessageInfo r130 = new MessageInfo(r124, r126);
    L69:
        r130.setPin(com.ss.android.lark.parser.internal.a.h(r125.pin, r128, r112));
        boolean r131 = Intrinsics.areEqual(r124.getFoldId(), r124.getId());
        Long r132 = StringsKt.toLongOrNull(r124.getFoldId());
        if (r131 == false) goto L82;
        if (r132 == null) goto L82;
        Function5<MessageInfo, Chat, ThreadTopic, List<? extends MessageInfo>, List<? extends MessageInfo>, Unit> r133 = r100;
        Log.i("MessagePushV2", "push message is a fold root, msg id " + r124.getId() + " , fold id is " + r132);
        MessageFoldDetail r134 = r102.message_fold_details.get(r132);
        if (r134 != null) goto L75;
        Log.w("MessagePushV2", "push fold root message, but not push fold");
    L80:
        if (r130.getMessageFoldDetail() != null) goto L83;
        r130.setMessageFoldDetail(new com.ss.android.lark.chat.entity.message.MessageFoldDetail.Builder().foldId(r124.getFoldId()).build());
    L83:
        ArrayList r135 = new ArrayList();
        Iterator<com.bytedance.lark.pb.basic.v1.Message.Reaction> r136 = r125.reactions.iterator();
    L85:
        if (r136.hasNext() == false) goto L94;
        Reaction r137 = com.ss.android.lark.parser.internal.x.a(r136.next());
        List<String> r138 = r137.getChatterIds();
        Iterator<com.bytedance.lark.pb.basic.v1.Message.Reaction> r212 = r136;
        HashMap r139 = new HashMap();
        Iterator<String> r140 = r138.iterator();
    L88:
        if (r140.hasNext() == false) goto L93;
        r140 = r140;
        String r141 = r140.next();
        r110 = r110;
        ChatChatter r142 = r112.b(r128, r141);
        if (r142 != null) goto L91;
        Log.w("MessagePushV2", "reactionChatter is null, chatid: " + r128 + "  reactionChatterId: " + r141);
        r115 = r115;
        goto L88
    L91:
        r139.put(r142.getId(), r142);
        goto L88
    L93:
        r135.add(new ReactionInfo(r137, r139));
        r136 = r212;
        r110 = r110;
        goto L85
    L94:
        Map<String, Message> r213 = r110;
        LinkedHashMap r214 = r115;
        r130.setReactionInfoList(r135);
        com.ss.android.lark.parser.internal.a.m(r125, r130, r112);
        String r143 = r124.getRecallerId();
        if (TextUtils.isEmpty(r143) == true) goto L97;
        r130.setRecallUser(r112.b(r128, r143));
    L97:
        r130.setTranslateInfo(com.ss.android.lark.parser.internal.d0.e(r124, r102, true));
        com.ss.android.lark.parser.internal.a.j(r124, r112);
        r130.setOriginalSender(com.ss.android.lark.parser.internal.a.g(r124, r112));
        com.ss.android.lark.parser.internal.a.i(r124, r112);
        com.ss.android.lark.parser.internal.b0.b(r124, r102, r130);
        Map r144 = null;
        com.ss.android.lark.parser.internal.a.c(r124, r102, r130, r112, null);
        com.ss.android.lark.parser.internal.a.a(r124, r102, r130);
        com.bytedance.lark.pb.basic.v1.Message.AIReplyEntryInfo r145 = r125.ai_reply_entry_info;
        if (r145 == null) goto L101;
        r130.setSmartReplyEntryInfo(new SmartReplyEntryInfo(r145.has_pre_generation.booleanValue(), r145.ai_reply_id, null));
    L101:
        String r146 = r124.getRootId();
        if (TextUtils.isEmpty(r146) == true) goto L110;
        MessageInfo r147 = (MessageInfo) r121.get(r146);
        Message r148 = (Message) r123.get(r146);
        if (r147 != null) goto L109;
        if (r148 == null) goto L109;
        ChatChatter r149 = r112.b(r128, r148.getFromId());
        if (r149 == null) goto L109;
        r147 = new MessageInfo(r148, r149);
        r121.put(r146, r147);
    L109:
        r130.setRootMessageInfo(r147);
    L110:
        String r150 = r124.getParentId();
        if (TextUtils.isEmpty(r150) == true) goto L119;
        MessageInfo r151 = (MessageInfo) r121.get(r150);
        Message r152 = (Message) r123.get(r150);
        if (r151 != null) goto L118;
        if (r152 == null) goto L118;
        ChatChatter r153 = r112.b(r128, r152.getFromId());
        if (r153 == null) goto L118;
        r151 = new MessageInfo(r152, r153);
        r121.put(r150, r151);
    L118:
        r130.setParentMessageInfo(r151);
    L119:
        String r154 = String.valueOf(r124.getSyncToChatThreadRootId());
        if (TextUtils.isEmpty(r154) == true) goto L133;
        MessageInfo r155 = (MessageInfo) r121.get(r154);
        Message r156 = (Message) r123.get(r154);
        if (r124.getSyncToChatThreadRootId() == 0) goto L127;
        if (r156 != null) goto L127;
        Map<String, Message> r157 = ImSdkService.f().ie(CollectionsKt.listOf(r154));
        if (r157 == null) goto L127;
        r156 = r157.get(r154);
    L127:
        if (r155 != null) goto L132;
        if (r156 == null) goto L132;
        ChatChatter r158 = r112.b(r128, r156.getFromId());
        if (r158 == null) goto L132;
        r155 = new MessageInfo(r156, r158);
        r121.put(r154, r155);
    L132:
        r130.setThreadParentMessageInfo(r155);
    L133:
        r121.put(r127, r130);
        MessageInfo r159 = r130;
    L135:
        if (r159 == 0) goto L155;
        String r160 = r159.getMessage().getThreadId();
        if (TextUtils.isEmpty(r160) == false) goto L139;
        ThreadTopic r161 = r144;
        LinkedHashMap r162 = r214;
    L140:
        ArrayList r163 = new ArrayList();
        if (r161 != 0) goto L143;
    L154:
        Map<String, Message> r164 = r213;
        List<MessageInfo> r165 = com.ss.android.lark.chat.api.service.impl.q1.a(r102, r161, r112, r164);
        r133.invoke(r159, ((HashMap) r114).get(r159.getMessage().getChatId()), r161, r163, r165);
    L156:
        r113 = r144;
        r115 = r162;
        r110 = r164;
        r109 = r121;
        r103 = r103;
        r101 = r101;
        r100 = r133;
        r114 = r114;
        r111 = 1;
        goto L15
    L143:
        if (CollectionUtils.isNotEmpty(r161.getLastReplyIds()) == false) goto L154;
        Iterator<String> r166 = r161.getLastReplyIds().iterator();
    L146:
        if (r166.hasNext() == false) goto L154;
        String r167 = r166.next();
        Message r168 = (Message) r123.get(r167);
        if (r168 == null) goto L149;
        ChatChatter r169 = r112.b(r168.getChatId(), r168.getFromId());
        if (r169 == null) goto L152;
        MessageInfo r170 = new MessageInfo(r168, r169);
        r170.setTranslateInfo(com.ss.android.lark.parser.internal.d0.e(r168, r102, true));
        r163.add(r170);
        goto L146
    L152:
        Log.e("MessagePushV2", "message sender is null, replyId=" + r167);
        goto L146
    L149:
        Log.e("MessagePushV2", "message is null, replyId=" + r167);
        goto L146
    L139:
        r162 = r214;
        r161 = (ThreadTopic) r162.get(r160);
        goto L140
    L155:
        r164 = r213;
        r162 = r214;
        goto L156
    L75:
        Pair<Message, com.bytedance.lark.pb.basic.v1.Message> r171 = ModelParserMessage.g(r102, r124.getFoldId());
        if (r171 == null) goto L78;
        Message r172 = r171.getFirst();
        com.ss.android.lark.chat.entity.message.MessageFoldDetail r173 = com.ss.android.lark.parser.internal.a.d(r134, r172, r112, r102.chats.get(r124.getChatId()));
        Log.i("MessagePushV2", "try to get fold from push entity is " + r173);
        r130.setMessage(r172);
        r130.setMessageFoldDetail(r173);
        goto L80
    L78:
        Log.w("MessagePushV2", "parseMessageFromFold get empty result");
    L82:
        r133 = r100;
        r114 = r114;
        goto L83
    L68:
        r130 = r129;
    L134:
        r133 = r100;
        r213 = r110;
        r144 = r113;
        r114 = r114;
        r214 = r115;
        Log.e("MessagePushV2", "Failed to find message or pbMessage, item id is: " + r118);
        r159 = r144;
        goto L135
    L61:
        r125 = r102.messages.get(r118);
        goto L62
    L57:
        r122 = false;
        goto L58
    L23:
        if (r120 == 2) goto L54;
        if (r120 != 3) goto L27;
        r121 = r109;
        Intrinsics.checkNotNull(r102);
        Intrinsics.checkNotNull(r112);
        Intrinsics.checkNotNull(r118);
        QuasiMessage r174 = r102.quasi_messages.get(r118);
        if (r174 != null) goto L49;
        Log.e("MessagePushV2", "Fail to find pbMessage, item id is: " + r118);
        Object r175 = r113;
    L50:
        if (r175 == null) goto L52;
        Log.i(r103, "handlePushPreMessage, message:" + r175);
        r101.invoke(r175);
    L52:
        r133 = r100;
        r101 = r101;
        r103 = r103;
        r164 = r110;
        r144 = r113;
        r114 = r114;
        r162 = r115;
        goto L156
    L49:
        Message r176 = ModelParserMessage.d(r102, r174);
        Log.i("MessagePushV2", "push premessage: " + r176);
        r175 = ModelParserMessage.k(r176, r102, r112, r113);
        goto L50
    L27:
        if (r120 != 4) goto L29;
        Log.i(r103, "handlePushFoldMessage, push fold id is : " + r117.item_id);
        Pair<Message, com.bytedance.lark.pb.basic.v1.Message> r177 = ModelParserMessage.g(r102, r117.item_id);
        if (r177 != null) goto L35;
        Log.w(r103, "handlePushFoldMessage, pushFold: try to getFold message by id, but get null");
    L41:
        r121 = r109;
        goto L52
    L35:
        com.bytedance.lark.pb.basic.v1.Message r178 = r177.getSecond();
        ChatChatter r179 = r112.b(r178.chat_id, r178.from_id);
        if (r179 != null) goto L38;
        Log.w(r103, "handlePushFoldMessage, pushFold: no chatter");
        goto L41
    L38:
        MessageInfo r180 = new MessageInfo(r177.getFirst(), r179);
        Long r181 = StringsKt.toLongOrNull(r180.getMessage().getFoldId());
        if (r181 != null) goto L42;
        Log.w(r103, "handlePushFoldMessage, pushFold: fold is is empty");
        goto L41
    L42:
        com.ss.android.lark.chat.entity.message.MessageFoldDetail r182 = com.ss.android.lark.parser.internal.a.d(r102.message_fold_details.get(r181), r180.getMessage(), r112, r102.chats.get(r180.getMessage().getChatId()));
        if (r182 != null) goto L45;
        r182 = new com.ss.android.lark.chat.entity.message.MessageFoldDetail.Builder().foldId(r180.getMessage().getFoldId()).build();
    L45:
        r180.setMessageFoldDetail(r182);
        Log.i("MessagePushV2", "pushMessage: push fold");
        Function5 r183 = r100;
        r121 = r109;
        r183.invoke(r180, ((HashMap) r114).get(r180.getMessage().getChatId()), null, CollectionsKt.emptyList(), CollectionsKt.emptyList());
        goto L52
    L29:
        if (r120 == 5) goto L31;
        Log.w("MessagePushV2", "pushMessage, message type is unknown, item id is: " + r118);
        goto L41
    L31:
        Log.w("MessagePushV2", "pushMessage, message type is unknown, item id is: " + r118);
        goto L41
    L19:
        r120 = m6b.w.f512310a[r119.ordinal()];
        goto L21
    }

    public static final void b(MessagePushV2 r110, PushMessageReactions r111) {
        r110.getClass();
        if (r111.msg_id2reactions != null) goto L5;
        Log.i("MessagePushV2", "handleReactionPushMessage, reactions or msg_id2reactions is null");
        return;
    L5:
        StringBuilder r100 = new StringBuilder("handleReactionPushMessage: ");
        StringBuilder r101 = new StringBuilder();
        r101.append(", chat_id=");
        r101.append(r111.chat_id);
        Map<String, PushMessageReactions.Reactions> r102 = r111.msg_id2reactions;
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == true) goto L14;
        r101.append(", msg_id2reactions=");
        Map<String, PushMessageReactions.Reactions> r104 = r111.msg_id2reactions;
        Intrinsics.checkNotNullParameter(r104, "<this>");
        r101.append(CollectionsKt.joinToString$default(r104.entrySet(), ", ", "{", com.alipay.sdk.m.u.i.f25855d, 0, null, ToStringHelper$asString$1.INSTANCE, 24, null));
    L14:
        StringBuilder r105 = r101.replace(0, 2, "PushMessageReactions{");
        r105.append('}');
        r100.append(r105.toString());
        Log.i("MessagePushV2", r100.toString());
        CoreThreadPool.getDefault().getUIExecutor().execute(new e1(r110, r111));
        return;
    L8:
        if (r102.isEmpty() == true) goto L11;
        r103 = false;
        goto L12
    }

    public static final void c(MessagePushV2 r100, PushMessageReadStates r101) {
        r100.getClass();
        Log.i("MessagePush", "handlePushReadStates chatId:" + r101.chat_id);
        CoreThreadPool.getDefault().getUIExecutor().execute(new f1(r100, r101));
    }

    @Override // m6b.u
    public final void Hd(String r100, Long r101, com.ss.android.lark.biz.im.api.f1 r102) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        if (r102 != null) goto L5;
        return;
    L5:
        if (r101 != null) goto L7;
    L9:
        List r103 = (List) ((ConcurrentHashMap) this.f416380e).get(r100);
        Log.i("MessagePush", "removePushAIRoundInfoListener, use key: " + r100);
        if (r103 == null) goto L13;
        r103.remove(r102);
        return;
    L13:
        return;
    L7:
        if (r101.longValue() == 0) goto L9;
        r100 = r100 + '_' + r101;
        goto L9
    }

    @Override // m6b.u
    public final void pb(String r100, Long r101, com.ss.android.lark.biz.im.api.f1 r102) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        if (r102 != null) goto L5;
        return;
    L5:
        if (r101 != null) goto L7;
    L9:
        List r103 = (List) ((ConcurrentHashMap) this.f416380e).get(r100);
        if (r103 != null) goto L12;
        r103 = new CopyOnWriteArrayList();
        ((ConcurrentHashMap) this.f416380e).put(r100, r103);
    L12:
        Log.i("MessagePush", "addPushAIRoundInfoListener, use key: " + r100);
        r103.add(r102);
        Disposable r104 = (Disposable) this.f416384i.getValue();
        Log.i("MessagePush", "add listener to roundInfoDisposable");
        return;
    L7:
        if (r101.longValue() == 0) goto L9;
        r100 = r100 + '_' + r101;
        goto L9
    }
}
