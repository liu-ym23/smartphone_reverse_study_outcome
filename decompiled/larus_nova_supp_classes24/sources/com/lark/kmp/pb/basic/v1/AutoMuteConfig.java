package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\b\u0010\nR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/AutoMuteConfig;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/AutoMuteConfig$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/AutoMuteConfig$Builder;Lokio/ByteString;)V", "is_mute", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "position", "", "getPosition", "()Ljava/lang/Long;", "Ljava/lang/Long;", "badge_count", "getBadge_count", "mute_way", "Lcom/lark/kmp/pb/basic/v1/MuteWay;", "getMute_way", "()Lcom/lark/kmp/pb/basic/v1/MuteWay;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AutoMuteConfig extends com.lark.wire.Message<AutoMuteConfig, a> {
    public static final ProtoAdapter<AutoMuteConfig> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Long badge_count;
    private final Boolean is_mute;
    private final MuteWay mute_way;
    private final Long position;

    public static final class a extends com.lark.wire.Message.a<AutoMuteConfig, a> {
        public Boolean d;
        public Long e;
        public Long f;
        public MuteWay g;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new AutoMuteConfig(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<AutoMuteConfig> {
        @Override // com.lark.wire.ProtoAdapter
        public final AutoMuteConfig c(g0 r9) {
            Intrinsics.checkNotNullParameter(r9, "reader");
            a r0 = new a();
            long r1 = r9.c();
        L3:
            int r3 = r9.e();
            if (r3 == (-1)) goto L22;
            if (r3 != 1) goto L8;
            r0.d = (Boolean) ProtoAdapter.g.c(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.e = (Long) ProtoAdapter.k.c(r9);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.f = (Long) ProtoAdapter.k.c(r9);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.g = MuteWay.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r4 = Unit.INSTANCE;
            goto L3
        L13:
            r9.j(r3);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L22:
            return new AutoMuteConfig(r0, r9.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(AutoMuteConfig r5) {
            AutoMuteConfig r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size() + ProtoAdapter.g.l(1, r6.is_mute());
            t r1 = ProtoAdapter.k;
            return ((r0 + r1.l(2, r6.getPosition())) + r1.l(3, r6.getBadge_count())) + MuteWay.ADAPTER.l(4, r6.getMute_way());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, AutoMuteConfig r5) {
            AutoMuteConfig r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.g.i(r4, 1, r6.is_mute());
            t r0 = ProtoAdapter.k;
            r0.i(r4, 2, r6.getPosition());
            r0.i(r4, 3, r6.getBadge_count());
            MuteWay.ADAPTER.i(r4, 4, r6.getMute_way());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, AutoMuteConfig r5) {
            AutoMuteConfig r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            MuteWay.ADAPTER.j(r4, 4, r6.getMute_way());
            t r0 = ProtoAdapter.k;
            r0.j(r4, 3, r6.getBadge_count());
            r0.j(r4, 2, r6.getPosition());
            ProtoAdapter.g.j(r4, 1, r6.is_mute());
        }

        public b(FieldEncoding r7, KClass<AutoMuteConfig> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.AutoMuteConfig", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ AutoMuteConfig(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AutoMuteConfig.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.is_mute;
        r0.e = this.position;
        r0.f = this.badge_count;
        r0.g = this.mute_way;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(AutoMuteConfig.class).getSimpleName() + '@' + hashCode();
    }

    public final Long getBadge_count() {
        return this.badge_count;
    }

    public final MuteWay getMute_way() {
        return this.mute_way;
    }

    public final Long getPosition() {
        return this.position;
    }

    public final Boolean is_mute() {
        return this.is_mute;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public AutoMuteConfig(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.is_mute = r2.d;
        this.position = r2.e;
        this.badge_count = r2.f;
        this.mute_way = r2.g;
    }

    public /* synthetic */ AutoMuteConfig(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
