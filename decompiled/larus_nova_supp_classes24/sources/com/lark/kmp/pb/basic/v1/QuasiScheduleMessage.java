package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0017\u0018\u0019B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/QuasiScheduleMessage;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/QuasiScheduleMessage$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/QuasiScheduleMessage$Builder;Lokio/ByteString;)V", "cid", "", "getCid", "()Ljava/lang/String;", "status", "Lcom/lark/kmp/pb/basic/v1/QuasiScheduleMessage$QuasiScheduleMessageStatus;", "getStatus", "()Lcom/lark/kmp/pb/basic/v1/QuasiScheduleMessage$QuasiScheduleMessageStatus;", "schedule_time", "", "getSchedule_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "newBuilder", "toString", "Builder", "Companion", "QuasiScheduleMessageStatus", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class QuasiScheduleMessage extends com.lark.wire.Message<QuasiScheduleMessage, a> {
    public static final ProtoAdapter<QuasiScheduleMessage> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String cid;
    private final Long schedule_time;
    private final QuasiScheduleMessageStatus status;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/QuasiScheduleMessage$QuasiScheduleMessageStatus;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DELETE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum QuasiScheduleMessageStatus extends Enum<QuasiScheduleMessageStatus> implements o0 {
        public static final ProtoAdapter<QuasiScheduleMessageStatus> ADAPTER = null;
        public static final b Companion = null;
        public static final QuasiScheduleMessageStatus DELETE = null;
        public static final QuasiScheduleMessageStatus UNKNOWN = null;
        public static final /* synthetic */ QuasiScheduleMessageStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<QuasiScheduleMessageStatus> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                QuasiScheduleMessageStatus.Companion.getClass();
                if (r2 == 0) goto L9;
                if (r2 == 3) goto L11;
                return null;
            L11:
                return QuasiScheduleMessageStatus.DELETE;
            L9:
                return QuasiScheduleMessageStatus.UNKNOWN;
            }

            public a(KClass<QuasiScheduleMessageStatus> r1, Syntax r2, QuasiScheduleMessageStatus r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<QuasiScheduleMessageStatus> getEntries() {
            return b;
        }

        static {
            QuasiScheduleMessageStatus r0 = new QuasiScheduleMessageStatus("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            QuasiScheduleMessageStatus r1 = new QuasiScheduleMessageStatus("DELETE", 1, 3);
            DELETE = r1;
            QuasiScheduleMessageStatus[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(QuasiScheduleMessageStatus.class), Syntax.PROTO_2, r0);
        }

        public static QuasiScheduleMessageStatus[] values() {
            return (QuasiScheduleMessageStatus[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final QuasiScheduleMessageStatus fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L9;
            if (r1 == 3) goto L11;
            return null;
        L11:
            return DELETE;
        L9:
            return UNKNOWN;
        }

        public static QuasiScheduleMessageStatus valueOf(String r1) {
            return (QuasiScheduleMessageStatus) r27.a.a(QuasiScheduleMessageStatus.class, r1);
        }

        public QuasiScheduleMessageStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<QuasiScheduleMessage, a> {
        public String d;
        public QuasiScheduleMessageStatus e;
        public Long f;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new QuasiScheduleMessage(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<QuasiScheduleMessage> {
        @Override // com.lark.wire.ProtoAdapter
        public final QuasiScheduleMessage c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L19;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.d = r10.i();
            goto L3
        L8:
            if (r4 != 2) goto L10;
            r1.e = QuasiScheduleMessageStatus.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L10:
            if (r4 != 3) goto L11;
            r1.f = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L11:
            r10.j(r4);
            goto L3
        L19:
            return new QuasiScheduleMessage(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(QuasiScheduleMessage r5) {
            QuasiScheduleMessage r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return ((r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getCid())) + QuasiScheduleMessageStatus.ADAPTER.l(2, r6.getStatus())) + ProtoAdapter.k.l(3, r6.getSchedule_time());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, QuasiScheduleMessage r5) {
            QuasiScheduleMessage r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.i(r4, 1, r6.getCid());
            QuasiScheduleMessageStatus.ADAPTER.i(r4, 2, r6.getStatus());
            ProtoAdapter.k.i(r4, 3, r6.getSchedule_time());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, QuasiScheduleMessage r5) {
            QuasiScheduleMessage r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.k.j(r4, 3, r6.getSchedule_time());
            QuasiScheduleMessageStatus.ADAPTER.j(r4, 2, r6.getStatus());
            ProtoAdapter.q.j(r4, 1, r6.getCid());
        }

        public b(FieldEncoding r7, KClass<QuasiScheduleMessage> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.QuasiScheduleMessage", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ QuasiScheduleMessage(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(QuasiScheduleMessage.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.cid;
        r0.e = this.status;
        r0.f = this.schedule_time;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(QuasiScheduleMessage.class).getSimpleName() + '@' + hashCode();
    }

    public final String getCid() {
        return this.cid;
    }

    public final Long getSchedule_time() {
        return this.schedule_time;
    }

    public final QuasiScheduleMessageStatus getStatus() {
        return this.status;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public QuasiScheduleMessage(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.cid = r2.d;
        this.status = r2.e;
        this.schedule_time = r2.f;
    }

    public /* synthetic */ QuasiScheduleMessage(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
