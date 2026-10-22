package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\b\u0010\nR\u0015\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RSVPCardChangeInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RSVPCardChangeInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RSVPCardChangeInfo$Builder;Lokio/ByteString;)V", "is_rrule_change", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_time_change", "is_location_change", "is_resource_change", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class RSVPCardChangeInfo extends com.lark.wire.Message<RSVPCardChangeInfo, a> {
    public static final ProtoAdapter<RSVPCardChangeInfo> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Boolean is_location_change;
    private final Boolean is_resource_change;
    private final Boolean is_rrule_change;
    private final Boolean is_time_change;

    public static final class a extends com.lark.wire.Message.a<RSVPCardChangeInfo, a> {
        public Boolean d;
        public Boolean e;
        public Boolean f;
        public Boolean g;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new RSVPCardChangeInfo(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<RSVPCardChangeInfo> {
        @Override // com.lark.wire.ProtoAdapter
        public final RSVPCardChangeInfo c(g0 r6) {
            Intrinsics.checkNotNullParameter(r6, "reader");
            a r0 = new a();
            long r1 = r6.c();
        L3:
            int r3 = r6.e();
            if (r3 == (-1)) goto L19;
            if (r3 != 1) goto L8;
            r0.d = (Boolean) ProtoAdapter.g.c(r6);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.e = (Boolean) ProtoAdapter.g.c(r6);
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
            return new RSVPCardChangeInfo(r0, r6.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(RSVPCardChangeInfo r5) {
            RSVPCardChangeInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            l r1 = ProtoAdapter.g;
            return (((r0 + r1.l(1, r6.is_rrule_change())) + r1.l(2, r6.is_time_change())) + r1.l(3, r6.is_location_change())) + r1.l(4, r6.is_resource_change());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, RSVPCardChangeInfo r5) {
            RSVPCardChangeInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            l r0 = ProtoAdapter.g;
            r0.i(r4, 1, r6.is_rrule_change());
            r0.i(r4, 2, r6.is_time_change());
            r0.i(r4, 3, r6.is_location_change());
            r0.i(r4, 4, r6.is_resource_change());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, RSVPCardChangeInfo r5) {
            RSVPCardChangeInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            l r0 = ProtoAdapter.g;
            r0.j(r4, 4, r6.is_resource_change());
            r0.j(r4, 3, r6.is_location_change());
            r0.j(r4, 2, r6.is_time_change());
            r0.j(r4, 1, r6.is_rrule_change());
        }

        public b(FieldEncoding r7, KClass<RSVPCardChangeInfo> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.RSVPCardChangeInfo", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ RSVPCardChangeInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(RSVPCardChangeInfo.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.is_rrule_change;
        r0.e = this.is_time_change;
        r0.f = this.is_location_change;
        r0.g = this.is_resource_change;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(RSVPCardChangeInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final Boolean is_location_change() {
        return this.is_location_change;
    }

    public final Boolean is_resource_change() {
        return this.is_resource_change;
    }

    public final Boolean is_rrule_change() {
        return this.is_rrule_change;
    }

    public final Boolean is_time_change() {
        return this.is_time_change;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public RSVPCardChangeInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.is_rrule_change = r2.d;
        this.is_time_change = r2.e;
        this.is_location_change = r2.f;
        this.is_resource_change = r2.g;
    }

    public /* synthetic */ RSVPCardChangeInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
