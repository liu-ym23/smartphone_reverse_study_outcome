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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MailContext;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/MailContext$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/MailContext$Builder;Lokio/ByteString;)V", "container_id", "", "getContainer_id", "()Ljava/lang/String;", "account_id", "", "getAccount_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "extra", "getExtra", "()Lokio/ByteString;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MailContext extends com.lark.wire.Message<MailContext, a> {
    public static final ProtoAdapter<MailContext> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Long account_id;
    private final String container_id;
    private final ByteString extra;

    public static final class a extends com.lark.wire.Message.a<MailContext, a> {
        public String d;
        public Long e;
        public ByteString f;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new MailContext(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<MailContext> {
        @Override // com.lark.wire.ProtoAdapter
        public final MailContext c(g0 r7) {
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
            r1.e = (Long) ProtoAdapter.k.c(r7);
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
            return new MailContext(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(MailContext r5) {
            MailContext r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return ((r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getContainer_id())) + ProtoAdapter.k.l(2, r6.getAccount_id())) + ProtoAdapter.p.l(3, r6.getExtra());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, MailContext r5) {
            MailContext r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.i(r4, 1, r6.getContainer_id());
            ProtoAdapter.k.i(r4, 2, r6.getAccount_id());
            ProtoAdapter.p.i(r4, 3, r6.getExtra());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, MailContext r5) {
            MailContext r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.p.j(r4, 3, r6.getExtra());
            ProtoAdapter.k.j(r4, 2, r6.getAccount_id());
            ProtoAdapter.q.j(r4, 1, r6.getContainer_id());
        }

        public b(FieldEncoding r7, KClass<MailContext> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.MailContext", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ MailContext(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MailContext.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.container_id;
        r0.e = this.account_id;
        r0.f = this.extra;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(MailContext.class).getSimpleName() + '@' + hashCode();
    }

    public final Long getAccount_id() {
        return this.account_id;
    }

    public final String getContainer_id() {
        return this.container_id;
    }

    public final ByteString getExtra() {
        return this.extra;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public MailContext(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.container_id = r2.d;
        this.account_id = r2.e;
        this.extra = r2.f;
    }

    public /* synthetic */ MailContext(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
