package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001d\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002$%B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\"\u001a\u00020\u0002H\u0016J\b\u0010#\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000bR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000bR\u0013\u0010 \u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u000b¨\u0006&"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Tenant;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Tenant$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Tenant$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "name", "getName", "contact_name", "getContact_name", "contact_mobile", "getContact_mobile", "contact_email", "getContact_email", "address", "getAddress", "domain", "getDomain", "post_code", "getPost_code", "remark", "getRemark", "telephone", "getTelephone", "icon_url", "getIcon_url", "unit_league", "getUnit_league", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class Tenant extends com.lark.wire.Message<Tenant, a> {
    public static final ProtoAdapter<Tenant> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String address;
    private final String contact_email;
    private final String contact_mobile;
    private final String contact_name;
    private final String domain;
    private final String icon_url;
    private final String id;
    private final String name;
    private final String post_code;
    private final String remark;
    private final String telephone;
    private final String unit_league;

    public static final class a extends com.lark.wire.Message.a<Tenant, a> {
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;
        public String n;
        public String o;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new Tenant(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<Tenant> {
        @Override // com.lark.wire.ProtoAdapter
        public final Tenant c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L20;
            switch(r4) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                case 9: goto L10;
                case 10: goto L9;
                case 11: goto L8;
                case 12: goto L7;
                default: goto L6;
            };
        L7:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.o = r7.i();
            goto L3
        L8:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.n = r7.i();
            goto L3
        L9:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.m = r7.i();
            goto L3
        L10:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.l = r7.i();
            goto L3
        L11:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.k = r7.i();
            goto L3
        L12:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.j = r7.i();
            goto L3
        L13:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.i = r7.i();
            goto L3
        L14:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.h = r7.i();
            goto L3
        L15:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.g = r7.i();
            goto L3
        L16:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.f = r7.i();
            goto L3
        L17:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            String r5 = r7.i();
            Intrinsics.checkNotNullParameter(r5, "name");
            r1.e = r5;
            goto L3
        L18:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            String r6 = r7.i();
            Intrinsics.checkNotNullParameter(r6, "id");
            r1.d = r6;
            goto L3
        L6:
            r7.j(r4);
            Unit r8 = Unit.INSTANCE;
            goto L3
        L20:
            return new Tenant(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(Tenant r5) {
            Tenant r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return (((((((((((r0 + r1.l(1, r6.getId())) + r1.l(2, r6.getName())) + r1.l(3, r6.getContact_name())) + r1.l(4, r6.getContact_mobile())) + r1.l(5, r6.getContact_email())) + r1.l(6, r6.getAddress())) + r1.l(7, r6.getDomain())) + r1.l(8, r6.getPost_code())) + r1.l(9, r6.getRemark())) + r1.l(10, r6.getTelephone())) + r1.l(11, r6.getIcon_url())) + r1.l(12, r6.getUnit_league());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, Tenant r5) {
            Tenant r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r4, 1, r6.getId());
            r0.i(r4, 2, r6.getName());
            r0.i(r4, 3, r6.getContact_name());
            r0.i(r4, 4, r6.getContact_mobile());
            r0.i(r4, 5, r6.getContact_email());
            r0.i(r4, 6, r6.getAddress());
            r0.i(r4, 7, r6.getDomain());
            r0.i(r4, 8, r6.getPost_code());
            r0.i(r4, 9, r6.getRemark());
            r0.i(r4, 10, r6.getTelephone());
            r0.i(r4, 11, r6.getIcon_url());
            r0.i(r4, 12, r6.getUnit_league());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, Tenant r5) {
            Tenant r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            w r0 = ProtoAdapter.q;
            r0.j(r4, 12, r6.getUnit_league());
            r0.j(r4, 11, r6.getIcon_url());
            r0.j(r4, 10, r6.getTelephone());
            r0.j(r4, 9, r6.getRemark());
            r0.j(r4, 8, r6.getPost_code());
            r0.j(r4, 7, r6.getDomain());
            r0.j(r4, 6, r6.getAddress());
            r0.j(r4, 5, r6.getContact_email());
            r0.j(r4, 4, r6.getContact_mobile());
            r0.j(r4, 3, r6.getContact_name());
            r0.j(r4, 2, r6.getName());
            r0.j(r4, 1, r6.getId());
        }

        public b(FieldEncoding r7, KClass<Tenant> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.Tenant", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ Tenant(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Tenant.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.name;
        r0.f = this.contact_name;
        r0.g = this.contact_mobile;
        r0.h = this.contact_email;
        r0.i = this.address;
        r0.j = this.domain;
        r0.k = this.post_code;
        r0.l = this.remark;
        r0.m = this.telephone;
        r0.n = this.icon_url;
        r0.o = this.unit_league;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(Tenant.class).getSimpleName() + '@' + hashCode();
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getContact_email() {
        return this.contact_email;
    }

    public final String getContact_mobile() {
        return this.contact_mobile;
    }

    public final String getContact_name() {
        return this.contact_name;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getIcon_url() {
        return this.icon_url;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPost_code() {
        return this.post_code;
    }

    public final String getRemark() {
        return this.remark;
    }

    public final String getTelephone() {
        return this.telephone;
    }

    public final String getUnit_league() {
        return this.unit_league;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public Tenant(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.id = r4;
        String r5 = r2.e;
        Intrinsics.checkNotNull(r5);
        this.name = r5;
        this.contact_name = r2.f;
        this.contact_mobile = r2.g;
        this.contact_email = r2.h;
        this.address = r2.i;
        this.domain = r2.j;
        this.post_code = r2.k;
        this.remark = r2.l;
        this.telephone = r2.m;
        this.icon_url = r2.n;
        this.unit_league = r2.o;
    }

    public /* synthetic */ Tenant(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
