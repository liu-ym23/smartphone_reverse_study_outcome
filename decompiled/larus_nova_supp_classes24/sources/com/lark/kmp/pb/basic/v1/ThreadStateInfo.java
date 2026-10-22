package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ThreadStateInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/ThreadStateInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/ThreadStateInfo$Builder;Lokio/ByteString;)V", "state", "Lcom/lark/kmp/pb/basic/v1/ThreadState;", "getState", "()Lcom/lark/kmp/pb/basic/v1/ThreadState;", "operator_id", "", "getOperator_id", "()Ljava/lang/String;", "update_time_ms", "", "getUpdate_time_ms", "()Ljava/lang/Long;", "Ljava/lang/Long;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ThreadStateInfo extends com.lark.wire.Message<ThreadStateInfo, a> {
    public static final ProtoAdapter<ThreadStateInfo> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String operator_id;
    private final ThreadState state;
    private final Long update_time_ms;

    public static final class a extends com.lark.wire.Message.a<ThreadStateInfo, a> {
        public ThreadState d;
        public String e;
        public Long f;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new ThreadStateInfo(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<ThreadStateInfo> {
        @Override // com.lark.wire.ProtoAdapter
        public final ThreadStateInfo c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L19;
            if (r4 != 1) goto L8;
            r1.d = ThreadState.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
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
            if (r4 != 3) goto L11;
            r1.f = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L11:
            r10.j(r4);
            goto L3
        L19:
            return new ThreadStateInfo(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(ThreadStateInfo r5) {
            ThreadStateInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return ((r6.unknownFields().size() + ThreadState.ADAPTER.l(1, r6.getState())) + ProtoAdapter.q.l(2, r6.getOperator_id())) + ProtoAdapter.k.l(3, r6.getUpdate_time_ms());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, ThreadStateInfo r5) {
            ThreadStateInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ThreadState.ADAPTER.i(r4, 1, r6.getState());
            ProtoAdapter.q.i(r4, 2, r6.getOperator_id());
            ProtoAdapter.k.i(r4, 3, r6.getUpdate_time_ms());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, ThreadStateInfo r5) {
            ThreadStateInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.k.j(r4, 3, r6.getUpdate_time_ms());
            ProtoAdapter.q.j(r4, 2, r6.getOperator_id());
            ThreadState.ADAPTER.j(r4, 1, r6.getState());
        }

        public b(FieldEncoding r7, KClass<ThreadStateInfo> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.ThreadStateInfo", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ ThreadStateInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ThreadStateInfo.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.state;
        r0.e = this.operator_id;
        r0.f = this.update_time_ms;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(ThreadStateInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final String getOperator_id() {
        return this.operator_id;
    }

    public final ThreadState getState() {
        return this.state;
    }

    public final Long getUpdate_time_ms() {
        return this.update_time_ms;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public ThreadStateInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.state = r2.d;
        this.operator_id = r2.e;
        this.update_time_ms = r2.f;
    }

    public /* synthetic */ ThreadStateInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
