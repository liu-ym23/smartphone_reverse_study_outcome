package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.t;
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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0019\u001a\u001bB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/WorkStatus;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/WorkStatus$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/WorkStatus$Builder;Lokio/ByteString;)V", "status", "Lcom/lark/kmp/pb/basic/v1/WorkStatus$Status;", "getStatus", "()Lcom/lark/kmp/pb/basic/v1/WorkStatus$Status;", "description", "", "getDescription", "()Ljava/lang/String;", "start_time", "", "getStart_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "end_time", "getEnd_time", "newBuilder", "toString", "Builder", "Companion", "Status", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class WorkStatus extends com.lark.wire.Message<WorkStatus, a> {
    public static final ProtoAdapter<WorkStatus> ADAPTER = null;
    public static final c Companion = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final long DEFAULT_END_TIME = 0;
    public static final long DEFAULT_START_TIME = 0;
    public static final Status DEFAULT_STATUS = null;
    private static final long serialVersionUID = 0;
    private final String description;
    private final Long end_time;
    private final Long start_time;
    private final Status status;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/WorkStatus$Status;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ON_LEAVE", "ON_MEETING", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Status extends Enum<Status> implements o0 {
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final b Companion = null;
        public static final Status ON_LEAVE = null;
        public static final Status ON_MEETING = null;
        public static final Status UNKNOWN = null;
        public static final /* synthetic */ Status[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Status> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Status.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return Status.ON_MEETING;
            L15:
                return Status.ON_LEAVE;
            L12:
                return Status.UNKNOWN;
            }

            public a(KClass<Status> r1, Syntax r2, Status r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Status> getEntries() {
            return b;
        }

        static {
            Status r0 = new Status("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Status r1 = new Status("ON_LEAVE", 1, 1);
            ON_LEAVE = r1;
            Status r3 = new Status("ON_MEETING", 2, 2);
            ON_MEETING = r3;
            Status[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Status.class), Syntax.PROTO_2, r0);
        }

        public static Status[] values() {
            return (Status[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Status fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return ON_MEETING;
        L15:
            return ON_LEAVE;
        L12:
            return UNKNOWN;
        }

        public static Status valueOf(String r1) {
            return (Status) r27.a.a(Status.class, r1);
        }

        public Status(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<WorkStatus, a> {
        public Status d;
        public String e;
        public Long f;
        public Long g;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new WorkStatus(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<WorkStatus> {
        @Override // com.lark.wire.ProtoAdapter
        public final WorkStatus c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L22;
            if (r4 != 1) goto L8;
            r1.d = Status.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L8:
            if (r4 != 2) goto L10;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.e = r10.i();
            goto L3
        L10:
            if (r4 != 3) goto L12;
            r1.f = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L12:
            if (r4 != 4) goto L13;
            r1.g = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L13:
            r10.j(r4);
            Unit r6 = Unit.INSTANCE;
            goto L3
        L22:
            return new WorkStatus(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(WorkStatus r5) {
            WorkStatus r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = (r6.unknownFields().size() + Status.ADAPTER.l(1, r6.getStatus())) + ProtoAdapter.q.l(2, r6.getDescription());
            t r1 = ProtoAdapter.k;
            return (r0 + r1.l(3, r6.getStart_time())) + r1.l(4, r6.getEnd_time());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, WorkStatus r5) {
            WorkStatus r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            Status.ADAPTER.i(r4, 1, r6.getStatus());
            ProtoAdapter.q.i(r4, 2, r6.getDescription());
            t r0 = ProtoAdapter.k;
            r0.i(r4, 3, r6.getStart_time());
            r0.i(r4, 4, r6.getEnd_time());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, WorkStatus r5) {
            WorkStatus r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            t r0 = ProtoAdapter.k;
            r0.j(r4, 4, r6.getEnd_time());
            r0.j(r4, 3, r6.getStart_time());
            ProtoAdapter.q.j(r4, 2, r6.getDescription());
            Status.ADAPTER.j(r4, 1, r6.getStatus());
        }

        public b(FieldEncoding r7, KClass<WorkStatus> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.WorkStatus", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ WorkStatus(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        DEFAULT_STATUS = Status.UNKNOWN;
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(WorkStatus.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.status;
        r0.e = this.description;
        r0.f = this.start_time;
        r0.g = this.end_time;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(WorkStatus.class).getSimpleName() + '@' + hashCode();
    }

    public final String getDescription() {
        return this.description;
    }

    public final Long getEnd_time() {
        return this.end_time;
    }

    public final Long getStart_time() {
        return this.start_time;
    }

    public final Status getStatus() {
        return this.status;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public WorkStatus(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.status = r2.d;
        this.description = r2.e;
        this.start_time = r2.f;
        this.end_time = r2.g;
    }

    public /* synthetic */ WorkStatus(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
