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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardActionPacket;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardActionPacket$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardActionPacket$Builder;Lokio/ByteString;)V", "cid", "", "getCid", "()Ljava/lang/String;", "parameters", "Lcom/lark/kmp/pb/basic/v1/CardAction$Parameters;", "getParameters", "()Lcom/lark/kmp/pb/basic/v1/CardAction$Parameters;", "payload", "getPayload", "()Lokio/ByteString;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardActionPacket extends com.lark.wire.Message<CardActionPacket, a> {
    public static final ProtoAdapter<CardActionPacket> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String cid;
    private final CardAction.Parameters parameters;
    private final ByteString payload;

    public static final class a extends com.lark.wire.Message.a<CardActionPacket, a> {
        public String d;
        public CardAction.Parameters e;
        public ByteString f;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new CardActionPacket(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<CardActionPacket> {
        @Override // com.lark.wire.ProtoAdapter
        public final CardActionPacket c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L16;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.d = r7.i();
            goto L3
        L8:
            if (r4 != 2) goto L10;
            r1.e = CardAction.Parameters.ADAPTER.c(r7);
            goto L3
        L10:
            if (r4 != 3) goto L11;
            ProtoAdapter.p.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.f = r7.f();
            goto L3
        L11:
            r7.j(r4);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L16:
            return new CardActionPacket(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(CardActionPacket r5) {
            CardActionPacket r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return ((r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getCid())) + CardAction.Parameters.ADAPTER.l(2, r6.getParameters())) + ProtoAdapter.p.l(3, r6.getPayload());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, CardActionPacket r5) {
            CardActionPacket r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.i(r4, 1, r6.getCid());
            CardAction.Parameters.ADAPTER.i(r4, 2, r6.getParameters());
            ProtoAdapter.p.i(r4, 3, r6.getPayload());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, CardActionPacket r5) {
            CardActionPacket r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.p.j(r4, 3, r6.getPayload());
            CardAction.Parameters.ADAPTER.j(r4, 2, r6.getParameters());
            ProtoAdapter.q.j(r4, 1, r6.getCid());
        }

        public b(FieldEncoding r7, KClass<CardActionPacket> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.CardActionPacket", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ CardActionPacket(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CardActionPacket.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.cid;
        r0.e = this.parameters;
        r0.f = this.payload;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(CardActionPacket.class).getSimpleName() + '@' + hashCode();
    }

    public final String getCid() {
        return this.cid;
    }

    public final CardAction.Parameters getParameters() {
        return this.parameters;
    }

    public final ByteString getPayload() {
        return this.payload;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public CardActionPacket(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.cid = r2.d;
        this.parameters = r2.e;
        this.payload = r2.f;
    }

    public /* synthetic */ CardActionPacket(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
