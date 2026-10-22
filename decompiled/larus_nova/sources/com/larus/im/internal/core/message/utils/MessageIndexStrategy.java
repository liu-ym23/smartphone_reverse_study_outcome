package com.larus.im.internal.core.message.utils;

import com.larus.im.internal.database.delegate.MessageDaoSource;
import com.larus.im.internal.database.utils.OmniDatabaseExtKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class MessageIndexStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MessageIndexStrategy f347844a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/im/internal/core/message/utils/MessageIndexStrategy$ResortMessageIndexFrom;", "", "<init>", "(Ljava/lang/String;I)V", "FROM_SEND_MSG", "FROM_BATCH_SEND_MSG", "FROM_FRONTIER", "FROM_RECENT_CHAIN", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ResortMessageIndexFrom extends Enum<ResortMessageIndexFrom> {
        public static final ResortMessageIndexFrom FROM_BATCH_SEND_MSG = null;
        public static final ResortMessageIndexFrom FROM_FRONTIER = null;
        public static final ResortMessageIndexFrom FROM_RECENT_CHAIN = null;
        public static final ResortMessageIndexFrom FROM_SEND_MSG = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ResortMessageIndexFrom[] f347845a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f347846b = null;

        public static EnumEntries<ResortMessageIndexFrom> getEntries() {
            return f347846b;
        }

        static {
            ResortMessageIndexFrom r100 = new ResortMessageIndexFrom("FROM_SEND_MSG", 0);
            FROM_SEND_MSG = r100;
            ResortMessageIndexFrom r101 = new ResortMessageIndexFrom("FROM_BATCH_SEND_MSG", 1);
            FROM_BATCH_SEND_MSG = r101;
            ResortMessageIndexFrom r102 = new ResortMessageIndexFrom("FROM_FRONTIER", 2);
            FROM_FRONTIER = r102;
            ResortMessageIndexFrom r103 = new ResortMessageIndexFrom("FROM_RECENT_CHAIN", 3);
            FROM_RECENT_CHAIN = r103;
            ResortMessageIndexFrom[] r104 = {r100, r101, r102, r103};
            f347845a = r104;
            f347846b = EnumEntriesKt.enumEntries(r104);
        }

        public static ResortMessageIndexFrom[] values() {
            return (ResortMessageIndexFrom[]) f347845a.clone();
        }

        public static ResortMessageIndexFrom valueOf(String r100) {
            return (ResortMessageIndexFrom) r27.a.a(ResortMessageIndexFrom.class, r100);
        }

        public ResortMessageIndexFrom(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        f347844a = new MessageIndexStrategy();
    }

    public MessageIndexStrategy() {
    }

    public static long a(long r100, boolean r101) {
        long r102 = r100 * 1000;
        if (r101 == false) goto L5;
        r102 = r102 + 1;
    L5:
        com.larus.im.internal.delegate.a.f348188b.i("MessageIndexStrategy", "calReceiveMessageLocalIndex: ret  = " + r102);
        if (r102 >= 0) goto L9;
        return -1;
    L9:
        return r102;
    }

    public final Object b(String r100, Continuation<? super Long> r110) {
        if ((r110 instanceof MessageIndexStrategy$calSendMessageLocalIndex$1) == false) goto L7;
        MessageIndexStrategy$calSendMessageLocalIndex$1 r101 = (MessageIndexStrategy$calSendMessageLocalIndex$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        boolean r105 = true;
        long r106 = -1;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L21:
        long r107 = ((Number) r111).longValue();
        if (r107 <= (-1)) goto L25;
        r105 = false;
    L25:
        if (r105 == true) goto L28;
        r106 = r107 + 1;
    L28:
        com.larus.im.internal.delegate.a.f348188b.i("MessageIndexStrategy", "calSendMessageLocalIndex: ret = " + r106);
        return Boxing.boxLong(r106);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        com.larus.im.internal.delegate.a.f348188b.i("MessageIndexStrategy", "calSendMessageLocalIndex: cvsId = " + r100);
        if (r100 == null) goto L17;
        be9.d r112 = ae9.e.a();
        r101.label = 1;
        r111 = ((MessageDaoSource) r112).s(r100, r101);
        if (r111 != r103) goto L21;
        return r103;
    L17:
        return Boxing.boxLong(-1);
    L7:
        r101 = new MessageIndexStrategy$calSendMessageLocalIndex$1(this, r110);
        goto L8
    }

    public static Object c(String r110, long r111, Long r112, ResortMessageIndexFrom r113, List r114, Continuation r115) {
        com.larus.im.internal.delegate.a.f348188b.i("MessageIndexStrategy", "from = " + r113 + ", resortMessageIndex: cvsId = " + r110 + ", oldLocalIndex = " + r111 + ", newServerIndex = " + r112);
        if (StringsKt.isBlank(r110) == true) goto L16;
        if (r111 == 0) goto L16;
        if (r112 == null) goto L16;
        if (r112.longValue() <= 0) goto L16;
        Object r100 = OmniDatabaseExtKt.e(new MessageIndexStrategy$resortMessageIndex$2(r114, r110, r111, r113, a(r112.longValue(), false), null), r115);
        if (r100 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        return r100;
    L14:
        return Unit.INSTANCE;
    L16:
        return Unit.INSTANCE;
    }
}
