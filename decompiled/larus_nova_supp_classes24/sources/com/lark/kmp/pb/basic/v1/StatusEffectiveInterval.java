package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.t;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u000f\u0010\u0011R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/StatusEffectiveInterval;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/StatusEffectiveInterval$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/StatusEffectiveInterval$Builder;Lokio/ByteString;)V", "start_time", "", "getStart_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "end_time", "getEnd_time", "is_show_end_time", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_open_without_end_time", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class StatusEffectiveInterval extends com.lark.wire.Message<StatusEffectiveInterval, a> {
    public static final ProtoAdapter<StatusEffectiveInterval> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Long end_time;
    private final Boolean is_open_without_end_time;
    private final Boolean is_show_end_time;
    private final Long start_time;

    public static final class a extends com.lark.wire.Message.a<StatusEffectiveInterval, a> {
        public Long d;
        public Long e;
        public Boolean f;
        public Boolean g;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new StatusEffectiveInterval(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<StatusEffectiveInterval> {
        @Override // com.lark.wire.ProtoAdapter
        public final StatusEffectiveInterval c(g0 r6) {
            Intrinsics.checkNotNullParameter(r6, "reader");
            a r0 = new a();
            long r1 = r6.c();
        L3:
            int r3 = r6.e();
            if (r3 == (-1)) goto L19;
            if (r3 != 1) goto L8;
            r0.d = (Long) ProtoAdapter.k.c(r6);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.e = (Long) ProtoAdapter.k.c(r6);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.f = (Boolean) ProtoAdapter.g.c(r6);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.g = (Boolean) ProtoAdapter.g.c(r6);
            goto L3
        L13:
            r6.j(r3);
            Unit r4 = Unit.INSTANCE;
            goto L3
        L19:
            return new StatusEffectiveInterval(r0, r6.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(StatusEffectiveInterval r5) {
            StatusEffectiveInterval r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            t r1 = ProtoAdapter.k;
            int r2 = (r0 + r1.l(1, r6.getStart_time())) + r1.l(2, r6.getEnd_time());
            l r3 = ProtoAdapter.g;
            return (r2 + r3.l(3, r6.is_show_end_time())) + r3.l(4, r6.is_open_without_end_time());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, StatusEffectiveInterval r5) {
            StatusEffectiveInterval r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            t r0 = ProtoAdapter.k;
            r0.i(r4, 1, r6.getStart_time());
            r0.i(r4, 2, r6.getEnd_time());
            l r1 = ProtoAdapter.g;
            r1.i(r4, 3, r6.is_show_end_time());
            r1.i(r4, 4, r6.is_open_without_end_time());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, StatusEffectiveInterval r5) {
            StatusEffectiveInterval r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            l r0 = ProtoAdapter.g;
            r0.j(r4, 4, r6.is_open_without_end_time());
            r0.j(r4, 3, r6.is_show_end_time());
            t r1 = ProtoAdapter.k;
            r1.j(r4, 2, r6.getEnd_time());
            r1.j(r4, 1, r6.getStart_time());
        }

        public b(FieldEncoding r7, KClass<StatusEffectiveInterval> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.StatusEffectiveInterval", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ StatusEffectiveInterval(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(StatusEffectiveInterval.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.start_time;
        r0.e = this.end_time;
        r0.f = this.is_show_end_time;
        r0.g = this.is_open_without_end_time;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(StatusEffectiveInterval.class).getSimpleName() + '@' + hashCode();
    }

    public final Long getEnd_time() {
        return this.end_time;
    }

    public final Long getStart_time() {
        return this.start_time;
    }

    public final Boolean is_open_without_end_time() {
        return this.is_open_without_end_time;
    }

    public final Boolean is_show_end_time() {
        return this.is_show_end_time;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public StatusEffectiveInterval(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.start_time = r2.d;
        this.end_time = r2.e;
        this.is_show_end_time = r2.f;
        this.is_open_without_end_time = r2.g;
    }

    public /* synthetic */ StatusEffectiveInterval(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
