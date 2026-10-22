package com.larus.im.internal.network.chunk.cache;

import ae9.e;
import be9.d;
import com.larus.im.internal.core.message.concat.MessageConcatHelper;
import com.larus.im.internal.core.message.converter.MessageBodyConverterKt;
import com.larus.im.internal.database.delegate.MessageDaoSource;
import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.database.utils.j;
import com.larus.im.internal.database.utils.k;
import com.larus.im.internal.database.utils.o;
import com.larus.im.internal.protocol.bean.DownlinkBody;
import com.larus.im.internal.protocol.bean.DownlinkMessage;
import com.larus.im.internal.protocol.bean.IMCMD;
import com.larus.im.internal.protocol.bean.MessageBody;
import com.larus.im.internal.protocol.bean.MixedTokens;
import com.larus.im.internal.protocol.bean.SendMessageAckDownlinkBody;
import com.larus.im.internal.protocol.bean.SendMessageListAckDownlinkBody;
import com.larus.im.internal.protocol.bean.UplinkMessageChannel;
import com.larus.im.internal.stream.PendingHandler;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class SseHeaderCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SseHeaderCache f349082a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final vt7.a<a, b> f349083b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f349084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f349085b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f349086c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f349084a, r101.f349084a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f349085b, r101.f349085b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f349086c, r101.f349086c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f349084a.hashCode() * 31) + this.f349085b.hashCode()) * 31;
            String r101 = this.f349086c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "CachedKey(questionID=" + this.f349084a + ", conversationID=" + this.f349085b + ", token=" + this.f349086c + ')';
        }

        public a(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "questionID");
            Intrinsics.checkNotNullParameter(r101, "conversationID");
            this.f349084a = r100;
            this.f349085b = r101;
            this.f349086c = r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vt7.a<String, MessageEntity> f349087a;

        public b() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f349087a, ((b) r100).f349087a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f349087a.hashCode();
        }

        public final String toString() {
            return "CachedValue(replies=" + this.f349087a + ')';
        }

        public b(vt7.a<String, MessageEntity> r100) {
            Intrinsics.checkNotNullParameter(r100, "replies");
            this.f349087a = r100;
        }

        public /* synthetic */ b(int r100) {
            this(new vt7.a());
        }
    }

    public SseHeaderCache() {
    }

    static {
        f349082a = new SseHeaderCache();
        f349083b = new vt7.a();
    }

    public static List e(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        int r102 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("SseHeaderCache", "Find reply by token failed, because of token is Null or Blank.");
        return CollectionsKt.emptyList();
    L12:
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator<Map.Entry<a, b>> r104 = f349083b.entrySet().iterator();
    L14:
        if (r104.hasNext() == false) goto L19;
        Map.Entry<a, b> r105 = r104.next();
        a r106 = r105.getKey();
        b r107 = r105.getValue();
        if (Intrinsics.areEqual(r106.f349086c, r100) == false) goto L14;
        r103.putAll(r107.f349087a);
    L19:
        if (r103.isEmpty() == false) goto L23;
        int r108 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("SseHeaderCache", "Find reply by token success, but find result is empty.");
        return CollectionsKt.emptyList();
    L23:
        return CollectionsKt.toList(r103.values());
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L9
    }

    public static a f(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        int r102 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("SseHeaderCache", "Find cached key by token failed, because of token is Null or Blank.");
        return null;
    L12:
        Iterator<Map.Entry<a, b>> r103 = f349083b.entrySet().iterator();
    L14:
        if (r103.hasNext() == false) goto L18;
        a r104 = r103.next().getKey();
        if (Intrinsics.areEqual(r104.f349086c, r100) == false) goto L14;
        return r104;
    L18:
        int r105 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("SseHeaderCache", "Find cached key by token finish, but target cached key is not found.");
        return null;
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L9
    }

    public static void h(DownlinkMessage r100) {
        Intrinsics.checkNotNullParameter(r100, "downlink");
        int r101 = r100.cmd;
        if (r101 != IMCMD.SEND_MESSAGE.value) goto L10;
        DownlinkBody r102 = r100.downlinkBody;
        if (r102 == null) goto L8;
        SendMessageAckDownlinkBody r103 = r102.sendMessageAckDownlinkBody;
        if (r103 == null) goto L50;
    L20:
        String r104 = r103.conversationId;
        String r105 = r103.messageId;
        MixedTokens r106 = r103.tokenMixed;
        if (r106 == null) goto L23;
        String r107 = r106.sseToken;
    L24:
        boolean r108 = true;
        int r109 = 0;
        if (r104 != null) goto L27;
    L30:
        boolean r110 = true;
    L31:
        if (r110 == true) goto L55;
        if (r105 != null) goto L34;
    L37:
        boolean r111 = true;
    L38:
        if (r111 == false) goto L40;
        return;
    L40:
        if (Intrinsics.areEqual(r105, "0") == true) goto L57;
        if (r107 != null) goto L43;
    L46:
        if (r108 == true) goto L59;
        int r112 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("SseHeaderCache", "Cache ack, question_id(" + r105 + "), conversation_id(" + r104 + "), token(" + r107 + ')');
        f349083b.put(new a(r105, r104, r107), new b(r109));
        return;
    L59:
        return;
    L43:
        if (StringsKt.isBlank(r107) == true) goto L46;
        r108 = false;
        goto L46
    L57:
        return;
    L34:
        if (StringsKt.isBlank(r105) == true) goto L37;
        r111 = false;
        goto L38
    L55:
        return;
    L27:
        if (StringsKt.isBlank(r104) == true) goto L30;
        r110 = false;
        goto L31
    L23:
        r107 = null;
        goto L24
    L50:
        return;
    L8:
        return;
    L10:
        if (r101 != IMCMD.SEND_MESSAGE_LIST.value) goto L51;
        DownlinkBody r113 = r100.downlinkBody;
        if (r113 == null) goto L52;
        SendMessageListAckDownlinkBody r114 = r113.sendMessageListAckDownlinkBody;
        if (r114 == null) goto L53;
        List<SendMessageAckDownlinkBody> r115 = r114.ackMessageList;
        if (r115 == null) goto L54;
        r103 = (SendMessageAckDownlinkBody) CollectionsKt.lastOrNull(r115);
        if (r103 != null) goto L20;
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    }

    public static void d(a r100, List r101) {
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L3:
        boolean r104 = true;
        if (r103.hasNext() == false) goto L8;
        Object r105 = r103.next();
        if ((true ^ k.j((MessageEntity) r105)) == false) goto L3;
        r102.add(r105);
        goto L3
    L8:
        LinkedHashMap r106 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r102, 10)), 16));
        Iterator r107 = r102.iterator();
    L10:
        if (r107.hasNext() == false) goto L15;
        Object r108 = r107.next();
        String r109 = ((MessageEntity) r108).getMessageId();
        if (r109 != null) goto L14;
        r109 = "";
    L14:
        r106.put(r109, r108);
        goto L10
    L15:
        LinkedHashMap r110 = new LinkedHashMap();
        Iterator r111 = r106.entrySet().iterator();
    L17:
        if (r111.hasNext() == false) goto L21;
        Map.Entry r112 = (Map.Entry) r111.next();
        if ((!StringsKt.isBlank((CharSequence) r112.getKey())) == false) goto L17;
        r110.put(r112.getKey(), r112.getValue());
        goto L17
    L21:
        String r113 = r100.f349086c;
        String r114 = null;
        if (r113 != null) goto L24;
    L28:
        vt7.b<com.larus.im.internal.network.chunk.cache.a.C4363a> r115 = com.larus.im.internal.network.chunk.cache.a.f349088a;
        r113 = com.larus.im.internal.network.chunk.cache.a.c(r100.f349084a, UplinkMessageChannel.SSE);
        if (r113 != null) goto L31;
    L33:
        if (r114 == null) goto L39;
        if (StringsKt.isBlank(r114) == true) goto L39;
        r104 = false;
    L39:
        if (r104 == false) goto L42;
        int r116 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("SseHeaderCache", "Cache failed, because of token is Null or Blank.");
        return;
    L42:
        vt7.a<a, b> r117 = f349083b;
        b r118 = r117.get(r100);
        if (r118 != null) goto L45;
        int r119 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("SseHeaderCache", "Cache new message, question_id(" + r100.f349084a + "), conversation_id(" + r100.f349085b + "), token(" + r114 + ')');
        StringBuilder r120 = new StringBuilder("New cached message id: ");
        r120.append(r110.keySet());
        com.larus.im.internal.utils.b.c("SseHeaderCache", r120.toString());
        r117.put(r100, new b(new vt7.a(r110)));
        return;
    L45:
        Set r121 = SetsKt.minus(r110.keySet(), r118.f349087a.keySet());
        int r122 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("SseHeaderCache", "New cached message id: " + r121);
        Iterator r123 = r121.iterator();
    L47:
        if (r123.hasNext() == false) goto L71;
        String r124 = (String) r123.next();
        vt7.a<String, MessageEntity> r125 = r118.f349087a;
        MessageEntity r126 = (MessageEntity) r110.get(r124);
        if (r126 == null) goto L47;
        r125.put(r124, r126);
        goto L47
    L71:
        return;
    L31:
        if ((!StringsKt.isBlank(r113)) == false) goto L33;
    L32:
        r114 = r113;
        goto L33
    L24:
        if ((!StringsKt.isBlank(r113)) == true) goto L27;
        r113 = null;
    L27:
        if (r113 != null) goto L32;
        goto L28
    }

    public final Object c(MessageBody r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof SseHeaderCache$cache$2) == false) goto L7;
        SseHeaderCache$cache$2 r100 = (SseHeaderCache$cache$2) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        MessageEntity r113 = (MessageEntity) r100.L$3;
        String r104 = (String) r100.L$2;
        String r105 = (String) r100.L$1;
        String r106 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L65:
        MessageEntity r114 = (MessageEntity) r112;
        if (r114 != null) goto L68;
    L74:
        d(new a(r106, r105, r104), CollectionsKt.listOf(r113));
        return Unit.INSTANCE;
    L68:
        if (r114.getStatus() != 24) goto L74;
        if (CollectionsKt.listOf(new Integer[]{Boxing.boxInt(1), Boxing.boxInt(800)}).contains(Boxing.boxInt(k.e(r114))) == false) goto L74;
        if (CollectionsKt.listOf(new Integer[]{Boxing.boxInt(1), Boxing.boxInt(800)}).contains(Boxing.boxInt(k.e(r113))) == false) goto L74;
        vt7.b<nf9.a> r107 = MessageConcatHelper.f347786b;
        r113 = MessageConcatHelper.a.a(r114, r113);
        goto L74
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r115 = (String) r100.L$2;
        r105 = (String) r100.L$1;
        String r108 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L61:
        MessageEntity r116 = (MessageEntity) r112;
        d r109 = e.a();
        String r117 = r116.getLocalMessageId();
        String r118 = r116.getMessageId();
        r100.L$0 = r108;
        r100.L$1 = r105;
        r100.L$2 = r115;
        r100.L$3 = r116;
        r100.label = 2;
        Object r119 = ((MessageDaoSource) r109).n(r117, r118, r100);
        if (r119 != r102) goto L64;
        return r102;
    L64:
        r104 = r115;
        r113 = r116;
        r112 = r119;
        r106 = r108;
        goto L65
    L16:
        ResultKt.throwOnFailure(r112);
        if (j.i(r110) == true) goto L19;
    L78:
        int r120 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("SseHeaderCache", "message status = " + r110.contentStatus + ", message is Stream = " + j.i(r110));
        return Unit.INSTANCE;
    L19:
        if (Intrinsics.areEqual(r110.senderId, com.larus.im.internal.delegate.b.f348193b.getUserId()) == true) goto L78;
        String r121 = r110.botReplyMessageId;
        String r122 = r110.conversationId;
        MixedTokens r123 = r110.token;
        if (r123 == null) goto L24;
        String r124 = r123.sseToken;
    L25:
        String r125 = r110.messageId;
        if (r121 != null) goto L28;
    L31:
        boolean r126 = true;
    L32:
        if (r126 == false) goto L34;
    L76:
        int r127 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("SseHeaderCache", "Don't cache because of invalid failed, question_id(" + r121 + "), conversation_id(" + r122 + "), message_id(" + r125 + "), token(" + r124 + ").");
        return Unit.INSTANCE;
    L34:
        if (Intrinsics.areEqual(r121, "0") == true) goto L76;
        if (r122 != null) goto L37;
    L40:
        boolean r128 = true;
    L41:
        if (r128 == true) goto L76;
        if (r125 != null) goto L44;
    L47:
        boolean r129 = true;
    L48:
        if (r129 == true) goto L76;
        if (r124 != null) goto L51;
    L54:
        boolean r130 = true;
    L55:
        if (r130 == true) goto L76;
        int r131 = j.c(r110);
        r100.L$0 = r121;
        r100.L$1 = r122;
        r100.L$2 = r124;
        r100.label = 1;
        Object r132 = MessageBodyConverterKt.c(r110, r131, null, r100);
        if (r132 != r102) goto L60;
        return r102;
    L60:
        r105 = r122;
        r108 = r121;
        r112 = r132;
        r115 = r124;
        goto L61
    L51:
        if (StringsKt.isBlank(r124) == true) goto L54;
        r130 = false;
        goto L55
    L44:
        if (StringsKt.isBlank(r125) == true) goto L47;
        r129 = false;
        goto L48
    L37:
        if (StringsKt.isBlank(r122) == true) goto L40;
        r128 = false;
        goto L41
    L28:
        if (StringsKt.isBlank(r121) == true) goto L31;
        r126 = false;
        goto L32
    L24:
        r124 = null;
    L7:
        r100 = new SseHeaderCache$cache$2(this, r111);
        goto L8
    }

    public final Object g(a r610, Continuation<? super Unit> r611) {
        a r100 = r610;
        if ((r611 instanceof SseHeaderCache$retrieveReply$1) == false) goto L7;
        SseHeaderCache$retrieveReply$1 r101 = (SseHeaderCache$retrieveReply$1) r611;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        List r106 = (List) r101.L$1;
        a r107 = (a) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L34:
        Iterable r108 = (Iterable) r103;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator r110 = r108.iterator();
    L36:
        if (r110.hasNext() == false) goto L46;
        MessageEntity r111 = (MessageEntity) r110.next();
        String r112 = r111.getMessageId();
        String r113 = r111.getConversationId();
        if (r113 == null) goto L40;
        String r310 = StringsKt.substringBefore(r113, PendingHandler.f350087d, r113);
    L41:
        String r114 = r111.getLocalMessageId();
        String r115 = PendingHandler.f350087d;
        String r116 = StringsKt.substringBefore(r114, r115, r111.getLocalMessageId());
        if (r112 == null) goto L44;
        String r117 = StringsKt.substringBefore(r112, r115, r112);
    L45:
        r109.add(MessageEntity.copy$default(r111, r116, r117, null, null, null, 0, 0, 0, false, 0, 0, null, null, null, 0, false, null, null, null, null, null, null, r310, null, null, 0, null, false, null, 0, null, 0, null, null, null, null, null, null, null, null, null, null, 0, 0, -4194308, UnixStat.PERM_MASK, null));
        goto L36
    L44:
        r117 = null;
        goto L45
    L40:
        r310 = null;
        goto L41
    L46:
        d(r107, CollectionsKt.plus(r106, r109));
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r118 = (String) r101.L$2;
        String r119 = (String) r101.L$1;
        a r120 = (a) r101.L$0;
        ResultKt.throwOnFailure(r103);
        String r121 = r118;
        r100 = r120;
        Object r122 = r103;
    L30:
        List r123 = (List) r122;
        d r124 = e.a();
        String r125 = r121 + PendingHandler.f350087d;
        r101.L$0 = r100;
        r101.L$1 = r123;
        r101.L$2 = null;
        r101.label = 2;
        r103 = ((MessageDaoSource) r124).i(r125, r119, r101);
        if (r103 != r104) goto L33;
        return r104;
    L33:
        r107 = r100;
        r106 = r123;
        goto L34
    L16:
        ResultKt.throwOnFailure(r103);
        r119 = r100.f349084a;
        r121 = r100.f349085b;
        if (StringsKt.isBlank(r119) == true) goto L49;
        if (Intrinsics.areEqual(r119, "0") == true) goto L49;
        if (StringsKt.isBlank(r121) == true) goto L49;
        if (f349083b.containsKey(r100) == true) goto L26;
        d r126 = e.a();
        r101.L$0 = r100;
        r101.L$1 = r119;
        r101.L$2 = r121;
        r101.label = 1;
        r122 = ((MessageDaoSource) r126).i(r121, r119, r101);
        if (r122 != r104) goto L30;
        return r104;
    L26:
        return Unit.INSTANCE;
    L49:
        return Unit.INSTANCE;
    L7:
        r101 = new SseHeaderCache$retrieveReply$1(this, r611);
        goto L8
    }

    public final Object a(String r100, String r110, Continuation<? super MessageEntity> r111) {
        if ((r111 instanceof SseHeaderCache$acquireHeader$1) == false) goto L7;
        SseHeaderCache$acquireHeader$1 r101 = (SseHeaderCache$acquireHeader$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        boolean r105 = false;
        MessageEntity r106 = null;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        a r107 = (a) r101.L$2;
        r110 = (String) r101.L$1;
        String r108 = (String) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L46:
        b r109 = f349083b.get(r107);
        if (r109 == null) goto L51;
        vt7.a<String, MessageEntity> r113 = r109.f349087a;
        if (r113 == null) goto L51;
        r106 = r113.get(r108);
    L51:
        int r114 = com.larus.im.internal.network.chunk.a.f349081a;
        StringBuilder r115 = new StringBuilder("memory cache not found message_id(");
        r115.append(r108);
        r115.append("), token(");
        r115.append(r110);
        r115.append("), try acquire from db, success(");
        if (r106 == null) goto L54;
        r105 = true;
    L54:
        r115.append(r105);
        r115.append(')');
        com.larus.im.internal.utils.b.a("SseHeaderCache", r115.toString());
        return r106;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        if (r100 != null) goto L17;
    L20:
        boolean r116 = true;
    L21:
        if (r116 == true) goto L56;
        if (r110 != null) goto L24;
    L27:
        boolean r117 = true;
    L28:
        if (r117 == true) goto L56;
        a r118 = f(r110);
        if (r118 != null) goto L34;
        int r119 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.a("SseHeaderCache", "Acquire reply first package failed, because of cached key not found.");
        return null;
    L34:
        b r120 = f349083b.get(r118);
        if (r120 == null) goto L39;
        vt7.a<String, MessageEntity> r121 = r120.f349087a;
        if (r121 == null) goto L39;
        MessageEntity r122 = r121.get(r100);
    L40:
        if (r120 == null) goto L42;
        if (r122 == null) goto L42;
        return r122;
    L42:
        r101.L$0 = r100;
        r101.L$1 = r110;
        r101.L$2 = r118;
        r101.label = 1;
        if (g(r118, r101) != r103) goto L45;
        return r103;
    L45:
        r108 = r100;
        r107 = r118;
    L39:
        r122 = null;
        goto L40
    L24:
        if (StringsKt.isBlank(r110) == true) goto L27;
        r117 = false;
    L56:
        return null;
    L17:
        if (StringsKt.isBlank(r100) == true) goto L20;
        r116 = false;
    L7:
        r101 = new SseHeaderCache$acquireHeader$1(this, r111);
        goto L8
    }

    public final Object b(MessageEntity r110, String r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof SseHeaderCache$cache$1) == false) goto L7;
        SseHeaderCache$cache$1 r100 = (SseHeaderCache$cache$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        MessageEntity r114 = (MessageEntity) r100.L$4;
        String r115 = (String) r100.L$3;
        String r104 = (String) r100.L$2;
        String r105 = (String) r100.L$1;
        MessageEntity r106 = (MessageEntity) r100.L$0;
        ResultKt.throwOnFailure(r113);
        MessageEntity r116 = r114;
        r110 = r106;
        Object r107 = r113;
        String r117 = r115;
    L69:
        MessageEntity r108 = (MessageEntity) r107;
        if (r108 != null) goto L72;
    L82:
        d(new a(r105, r104, r117), CollectionsKt.listOf(r116));
        return Unit.INSTANCE;
    L72:
        if (r108.getStatus() != 24) goto L82;
        if (k.e(r108) == 1) goto L78;
        if (k.e(r108) != 800) goto L82;
    L78:
        if (k.e(r110) != 1) goto L80;
    L81:
        vt7.b<nf9.a> r118 = MessageConcatHelper.f347786b;
        r116 = MessageConcatHelper.a.a(r108, r110);
        goto L82
    L80:
        if (k.e(r110) != 800) goto L82;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        if (k.i(r110) == false) goto L87;
        if (o.a(r110) == true) goto L87;
        r105 = r110.getReplyId();
        String r119 = r110.getConversationId();
        String r109 = r110.getMessageId();
        boolean r120 = false;
        if (r105 != null) goto L22;
    L25:
        boolean r121 = true;
    L27:
        if (r121 == false) goto L29;
    L84:
        int r122 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("SseHeaderCache", "Don't cache because of invalid failed, question_id(" + r105 + "), conversation_id(" + r119 + "), message_id(" + r109 + ").");
        return Unit.INSTANCE;
    L29:
        if (Intrinsics.areEqual(r105, "0") == true) goto L84;
        if (r119 != null) goto L32;
    L35:
        boolean r123 = true;
    L36:
        if (r123 == true) goto L84;
        if (r109 != null) goto L39;
    L42:
        boolean r124 = true;
    L43:
        if (r124 == true) goto L84;
        if (r111 != null) goto L48;
    L52:
        vt7.b<com.larus.im.internal.network.chunk.cache.a.C4363a> r125 = com.larus.im.internal.network.chunk.cache.a.f349088a;
        r111 = com.larus.im.internal.network.chunk.cache.a.c(r109, UplinkMessageChannel.SSE);
        if (r111 != null) goto L55;
    L57:
        r111 = null;
    L58:
        if (r111 != null) goto L60;
    L61:
        r120 = true;
    L62:
        if (r120 == false) goto L65;
        int r126 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("SseHeaderCache", "Don't cache because of token is Null or Blank.");
        return Unit.INSTANCE;
    L65:
        d r127 = e.a();
        String r128 = r110.getLocalMessageId();
        String r129 = r110.getMessageId();
        r100.L$0 = r110;
        r100.L$1 = r105;
        r100.L$2 = r119;
        r100.L$3 = r111;
        r100.L$4 = r110;
        r100.label = 1;
        r107 = ((MessageDaoSource) r127).n(r128, r129, r100);
        if (r107 != r102) goto L68;
        return r102;
    L68:
        r104 = r119;
        r117 = r111;
        r116 = r110;
        goto L69
    L60:
        if (StringsKt.isBlank(r111) == false) goto L62;
    L55:
        if ((!StringsKt.isBlank(r111)) == false) goto L57;
    L48:
        if ((!StringsKt.isBlank(r111)) == true) goto L51;
        r111 = null;
    L51:
        if (r111 != null) goto L58;
    L39:
        if (StringsKt.isBlank(r109) == true) goto L42;
        r124 = false;
        goto L43
    L32:
        if (StringsKt.isBlank(r119) == true) goto L35;
        r123 = false;
        goto L36
    L22:
        if (StringsKt.isBlank(r105) == true) goto L25;
        r121 = false;
    L87:
        return Unit.INSTANCE;
    L7:
        r100 = new SseHeaderCache$cache$1(this, r112);
        goto L8
    }
}
