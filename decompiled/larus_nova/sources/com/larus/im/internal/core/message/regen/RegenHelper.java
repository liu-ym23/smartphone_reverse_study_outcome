package com.larus.im.internal.core.message.regen;

import ae9.e;
import be9.d;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.RegenStatus;
import com.larus.im.internal.core.message.converter.MessageBodyConverterKt;
import com.larus.im.internal.database.delegate.MessageDaoSource;
import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.database.utils.j;
import com.larus.im.internal.database.utils.k;
import com.larus.im.internal.protocol.bean.MessageBody;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class RegenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RegenHelper f347820a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f347821b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f347822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f347823b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f347824c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f347825d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f347826e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f347827f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f347822a, r101.f347822a) == true) goto L12;
            return false;
        L12:
            if (this.f347823b == r101.f347823b) goto L15;
            return false;
        L15:
            if (this.f347824c == r101.f347824c) goto L18;
            return false;
        L18:
            if (this.f347825d == r101.f347825d) goto L21;
            return false;
        L21:
            if (this.f347826e == r101.f347826e) goto L24;
            return false;
        L24:
            if (this.f347827f == r101.f347827f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f347822a.hashCode() * 31) + this.f347823b) * 31) + this.f347824c) * 31;
            if (this.f347825d == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = (r100 + r101) * 31;
            long r103 = this.f347826e;
            int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
            long r105 = this.f347827f;
            return r104 + ((int) (r105 ^ (r105 >>> 32)));
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "Calculated(messageId=" + this.f347822a + ", indexOfGroup=" + this.f347823b + ", status=" + this.f347824c + ", visible=" + this.f347825d + ", baselineIndex=" + this.f347826e + ", additionalIndex=" + this.f347827f + ')';
        }

        public a(String r100, int r101, @RegenStatus int r102, boolean r103, long r104, long r105) {
            Intrinsics.checkNotNullParameter(r100, "messageId");
            this.f347822a = r100;
            this.f347823b = r101;
            this.f347824c = r102;
            this.f347825d = r103;
            this.f347826e = r104;
            this.f347827f = r105;
        }
    }

    public RegenHelper() {
    }

    static {
        f347820a = new RegenHelper();
        f347821b = LazyKt.lazy(new b());
    }

    public static void c(String r100, String r101) {
        com.larus.im.internal.delegate.a.f348188b.i("RegenHelper", "<" + r100 + "> " + r101);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x020f -> B:83:0x0214). Please report as a decompilation issue!!! */
    public final Object b(List<MessageBody> r110, Map<String, a> r210, Continuation<? super List<MessageEntity>> r211) {
        if ((r211 instanceof RegenHelper$batchApply$1) == false) goto L7;
        RegenHelper$batchApply$1 r100 = (RegenHelper$batchApply$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
        RegenHelper r102 = this;
    L8:
        Object r103 = r100.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r100.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        MessageEntity r106 = (MessageEntity) r100.L$5;
        MessageBody r107 = (MessageBody) r100.L$4;
        Iterator<MessageBody> r111 = (Iterator) r100.L$3;
        List r112 = (List) r100.L$2;
        List r113 = (List) r100.L$1;
        Map<String, a> r114 = (Map) r100.L$0;
        ResultKt.throwOnFailure(r103);
        Object r108 = r103;
        RegenHelper r109 = r102;
    L83:
        MessageEntity r115 = (MessageEntity) r108;
        if (j.i(r107) == false) goto L92;
        if (r106 != null) goto L87;
    L89:
        boolean r116 = false;
    L90:
        if (r116 == false) goto L92;
        boolean r117 = true;
    L93:
        if (r117 == false) goto L95;
        c("batchApply", "skip cause server is streaming but local is finished " + r107.messageId);
    L96:
        RegenHelper r118 = r109;
    L61:
        if (r111.hasNext() == false) goto L97;
        r107 = r111.next();
        Iterator r119 = r112.iterator();
    L64:
        if (r119.hasNext() == false) goto L75;
        Object r120 = r119.next();
        MessageEntity r121 = (MessageEntity) r120;
        if (Intrinsics.areEqual(r121.getMessageId(), r107.messageId) == false) goto L68;
    L71:
        boolean r122 = true;
    L72:
        if (r122 == false) goto L64;
    L76:
        MessageEntity r123 = (MessageEntity) r120;
        String r124 = r107.messageId;
        if (r124 != null) goto L79;
        r124 = "";
    L79:
        a r125 = r114.get(r124);
        r100.L$0 = r114;
        r100.L$1 = r113;
        r100.L$2 = r112;
        r100.L$3 = r111;
        r100.L$4 = r107;
        r100.L$5 = r123;
        r100.label = 2;
        r108 = r118.a(r107, r125, r123, r100);
        if (r108 != r104) goto L82;
        return r104;
    L82:
        r109 = r118;
        r106 = r123;
        goto L83
    L68:
        if (Intrinsics.areEqual(r121.getLocalMessageId(), r107.localMessageId) == true) goto L71;
        r122 = false;
        goto L72
    L75:
        r120 = null;
        goto L76
    L97:
        StringBuilder r126 = new StringBuilder("all local_message_id(");
        List r127 = r113;
        ArrayList r128 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r127, 10));
        Iterator r129 = r127.iterator();
    L99:
        if (r129.hasNext() == false) goto L101;
        r128.add(((MessageEntity) r129.next()).getLocalMessageId());
        goto L99
    L101:
        r126.append(r128);
        r126.append(") all local_index(");
        ArrayList r130 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r127, 10));
        Iterator r131 = r127.iterator();
    L103:
        if (r131.hasNext() == false) goto L105;
        r130.add(Boxing.boxLong(((MessageEntity) r131.next()).getLocalIndex()));
        goto L103
    L105:
        r126.append(r130);
        r126.append(')');
        c("batchApply", r126.toString());
        return r113;
    L95:
        Boxing.boxBoolean(r113.add(r115));
        goto L96
    L87:
        if (r106.getStatus() != 21) goto L89;
        r116 = true;
    L92:
        r117 = false;
        goto L93
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        List r132 = (List) r100.L$3;
        List r133 = (List) r100.L$2;
        Map<String, a> r134 = (Map) r100.L$1;
        List<MessageBody> r135 = (List) r100.L$0;
        ResultKt.throwOnFailure(r103);
    L52:
        HashSet r136 = new HashSet();
        ArrayList r137 = new ArrayList();
        Iterator r138 = ((Iterable) r103).iterator();
    L54:
        if (r138.hasNext() == false) goto L59;
        Object r139 = r138.next();
        if (r136.add(((MessageEntity) r139).getLocalMessageId()) == false) goto L54;
        r137.add(r139);
        goto L54
    L59:
        r132.addAll(r137);
        Iterator<MessageBody> r140 = r135.iterator();
        r112 = r132;
        r118 = r102;
        r113 = r133;
        r114 = r134;
        r111 = r140;
        goto L61
    L16:
        ResultKt.throwOnFailure(r103);
        StringBuilder r141 = new StringBuilder("bodies(");
        List<MessageBody> r142 = r110;
        ArrayList r143 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r142, 10));
        Iterator<T> r144 = r142.iterator();
    L18:
        if (r144.hasNext() == false) goto L20;
        r143.add(((MessageBody) r144.next()).messageId);
        goto L18
    L20:
        r141.append(r143);
        r141.append(") applyFor(");
        r141.append(r210.keySet());
        r141.append(')');
        c("batchApply", r141.toString());
        if (r110.isEmpty() == true) goto L23;
        r133 = new ArrayList();
        ArrayList r145 = new ArrayList();
        List<MessageBody> r146 = r110;
        ArrayList r147 = new ArrayList();
        Iterator<T> r148 = r146.iterator();
    L26:
        if (r148.hasNext() == false) goto L30;
        String r149 = ((MessageBody) r148.next()).messageId;
        if (r149 == null) goto L26;
        r147.add(r149);
        goto L26
    L30:
        ArrayList r150 = new ArrayList();
        Iterator r151 = r147.iterator();
    L32:
        if (r151.hasNext() == false) goto L36;
        Object r152 = r151.next();
        if ((!StringsKt.isBlank((String) r152)) == false) goto L32;
        r150.add(r152);
        goto L32
    L36:
        ArrayList r153 = new ArrayList();
        Iterator<T> r154 = r146.iterator();
    L38:
        if (r154.hasNext() == false) goto L42;
        String r155 = ((MessageBody) r154.next()).localMessageId;
        if (r155 == null) goto L38;
        r153.add(r155);
        goto L38
    L42:
        ArrayList r156 = new ArrayList();
        Iterator r157 = r153.iterator();
    L44:
        if (r157.hasNext() == false) goto L48;
        Object r158 = r157.next();
        if ((!StringsKt.isBlank((String) r158)) == false) goto L44;
        r156.add(r158);
        goto L44
    L48:
        d r159 = e.a();
        r100.L$0 = r110;
        r100.L$1 = r210;
        r100.L$2 = r133;
        r100.L$3 = r145;
        r100.label = 1;
        Object r160 = ((MessageDaoSource) r159).L(r150, r156, r100);
        if (r160 != r104) goto L51;
        return r104;
    L51:
        r135 = r110;
        r132 = r145;
        r103 = r160;
        r134 = r210;
        goto L52
    L23:
        return CollectionsKt.emptyList();
    L7:
        r102 = this;
        r100 = new RegenHelper$batchApply$1(r102, r211);
        goto L8
    }

    public final Object a(MessageBody r610, a r611, MessageEntity r612, Continuation<? super MessageEntity> r613) {
        if ((r613 instanceof RegenHelper$apply$1) == false) goto L7;
        RegenHelper$apply$1 r100 = (RegenHelper$apply$1) r613;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = false;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        a r106 = (a) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L25:
        MessageEntity r110 = (MessageEntity) r102;
        String r107 = r110.getMessageId();
        Integer[] r108 = k.f348166a;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        if (r110.getMessageStatus() != MessageStatus.MessageStatus_REGENATED.value) goto L28;
    L31:
        boolean r109 = true;
    L32:
        if (r109 == false) goto L44;
        if (r107 != null) goto L35;
    L36:
        r105 = true;
    L37:
        if (r105 == true) goto L44;
        if (r106 == null) goto L44;
        if (Intrinsics.areEqual(r107, r106.f347822a) == false) goto L44;
        return MessageEntity.copy$default(r110, null, null, null, null, null, 0, 0, 0, false, 0, 0, null, null, Boxing.boxInt(r106.f347823b), r106.f347824c, r106.f347825d, null, null, null, null, null, null, null, null, null, r106.f347826e + r106.f347827f, null, false, null, 0, null, 0, null, null, null, null, null, null, null, null, null, null, 0, 0, -33611777, UnixStat.PERM_MASK, null);
    L35:
        if (StringsKt.isBlank(r107) == false) goto L37;
    L44:
        return r110;
    L28:
        if (r110.getMessageStatus() == MessageStatus.MessageStatus_REGEN_ROOT.value) goto L31;
        r109 = false;
        goto L32
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        StringBuilder r111 = new StringBuilder("message_id(");
        r111.append(r610.messageId);
        r111.append("), is_regen(");
        IntRange r112 = j.f348165a;
        Intrinsics.checkNotNullParameter(r610, "<this>");
        int r113 = r610.status;
        if (r113 != MessageStatus.MessageStatus_REGENATED.value) goto L17;
    L20:
        boolean r114 = true;
    L21:
        r111.append(r114);
        r111.append("), applyFor(");
        r111.append(r611);
        r111.append(')');
        c(e1.REPLY_ACTION_APPLY, r111.toString());
        int r115 = j.c(r610);
        r100.L$0 = r611;
        r100.label = 1;
        r102 = MessageBodyConverterKt.c(r610, r115, r612, r100);
        if (r102 != r103) goto L24;
        return r103;
    L24:
        r106 = r611;
        goto L25
    L17:
        if (r113 == MessageStatus.MessageStatus_REGEN_ROOT.value) goto L20;
        r114 = false;
    L7:
        r100 = new RegenHelper$apply$1(this, r613);
        goto L8
    }
}
