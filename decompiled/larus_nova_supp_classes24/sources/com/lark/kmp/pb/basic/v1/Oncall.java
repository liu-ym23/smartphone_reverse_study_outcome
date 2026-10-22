package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 +2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002*+B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010(\u001a\u00020\u0002H\u0016J\b\u0010)\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010!\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000bR\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Oncall;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Oncall$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Oncall$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "name", "getName", "description", "getDescription", "avatar", "Lcom/lark/kmp/pb/basic/v1/ImageSet;", "getAvatar$annotations", "()V", "getAvatar", "()Lcom/lark/kmp/pb/basic/v1/ImageSet;", "chat_id", "getChat_id", "avatar_key", "getAvatar_key", "phone_number", "getPhone_number", "report_location", "", "getReport_location", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "avatar_path", "getAvatar_path", "tags", "", "Lcom/lark/kmp/pb/basic/v1/Tag;", "getTags", "()Ljava/util/List;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class Oncall extends com.lark.wire.Message<Oncall, a> {
    public static final ProtoAdapter<Oncall> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final ImageSet avatar;
    private final String avatar_key;
    private final String avatar_path;
    private final String chat_id;
    private final String description;
    private final String id;
    private final String name;
    private final String phone_number;
    private final Boolean report_location;
    private final List<Tag> tags;

    public static final class a extends com.lark.wire.Message.a<Oncall, a> {
        public String d;
        public String e;
        public String f;
        public ImageSet g;
        public String h;
        public String i;
        public String j;
        public Boolean k;
        public String l;
        public List<? extends Tag> m;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new Oncall(this, c(), null);
        }

        public a() {
            this.m = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<Oncall> {
        @Override // com.lark.wire.ProtoAdapter
        public final Oncall c(g0 r11) {
            Intrinsics.checkNotNullParameter(r11, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r11.c();
        L3:
            int r5 = r11.e();
            if (r5 == (-1)) goto L21;
            switch(r5) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L23;
                default: goto L6;
            };
        L23:
            Tag.ADAPTER.m(r11, r2);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L11:
            Unit r6 = Unit.INSTANCE;
        L9:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L11
        L12:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.l = r11.i();
            goto L3
        L13:
            r1.k = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L14:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.j = r11.i();
            goto L3
        L15:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.i = r11.i();
            goto L3
        L16:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.h = r11.i();
            goto L3
        L17:
            r1.g = ImageSet.ADAPTER.c(r11);
            goto L3
        L18:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.f = r11.i();
            goto L3
        L19:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            String r7 = r11.i();
            Intrinsics.checkNotNullParameter(r7, "name");
            r1.e = r7;
            goto L3
        L20:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            String r8 = r11.i();
            Intrinsics.checkNotNullParameter(r8, "id");
            r1.d = r8;
            goto L3
        L6:
            r11.j(r5);
            Unit r9 = Unit.INSTANCE;
            goto L3
        L21:
            ByteString r12 = r11.d(r3);
            Intrinsics.checkNotNullParameter(r2, "tags");
            com.lark.wire.internal.a.a(r2);
            r1.m = r2;
            return new Oncall(r1, r12, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(Oncall r6) {
            Oncall r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return (((((((((r0 + r1.l(1, r7.getId())) + r1.l(2, r7.getName())) + r1.l(3, r7.getDescription())) + ImageSet.ADAPTER.l(4, r7.getAvatar())) + r1.l(5, r7.getChat_id())) + r1.l(6, r7.getAvatar_key())) + r1.l(7, r7.getPhone_number())) + ProtoAdapter.g.l(8, r7.getReport_location())) + r1.l(9, r7.getAvatar_path())) + Tag.ADAPTER.a().l(10, r7.getTags());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, Oncall r6) {
            Oncall r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getId());
            r0.i(r5, 2, r7.getName());
            r0.i(r5, 3, r7.getDescription());
            ImageSet.ADAPTER.i(r5, 4, r7.getAvatar());
            r0.i(r5, 5, r7.getChat_id());
            r0.i(r5, 6, r7.getAvatar_key());
            r0.i(r5, 7, r7.getPhone_number());
            ProtoAdapter.g.i(r5, 8, r7.getReport_location());
            r0.i(r5, 9, r7.getAvatar_path());
            Tag.ADAPTER.a().i(r5, 10, r7.getTags());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, Oncall r6) {
            Oncall r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            Tag.ADAPTER.a().j(r5, 10, r7.getTags());
            w r0 = ProtoAdapter.q;
            r0.j(r5, 9, r7.getAvatar_path());
            ProtoAdapter.g.j(r5, 8, r7.getReport_location());
            r0.j(r5, 7, r7.getPhone_number());
            r0.j(r5, 6, r7.getAvatar_key());
            r0.j(r5, 5, r7.getChat_id());
            ImageSet.ADAPTER.j(r5, 4, r7.getAvatar());
            r0.j(r5, 3, r7.getDescription());
            r0.j(r5, 2, r7.getName());
            r0.j(r5, 1, r7.getId());
        }

        public b(FieldEncoding r7, KClass<Oncall> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.Oncall", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ Oncall(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Deprecated(message = "avatar is deprecated")
    public static /* synthetic */ void getAvatar$annotations() {
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Oncall.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.name;
        r0.f = this.description;
        r0.g = this.avatar;
        r0.h = this.chat_id;
        r0.i = this.avatar_key;
        r0.j = this.phone_number;
        r0.k = this.report_location;
        r0.l = this.avatar_path;
        r0.m = this.tags;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(Oncall.class).getSimpleName() + '@' + hashCode();
    }

    public final ImageSet getAvatar() {
        return this.avatar;
    }

    public final String getAvatar_key() {
        return this.avatar_key;
    }

    public final String getAvatar_path() {
        return this.avatar_path;
    }

    public final String getChat_id() {
        return this.chat_id;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPhone_number() {
        return this.phone_number;
    }

    public final Boolean getReport_location() {
        return this.report_location;
    }

    public final List<Tag> getTags() {
        return this.tags;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public Oncall(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.id = r4;
        String r5 = r2.e;
        Intrinsics.checkNotNull(r5);
        this.name = r5;
        this.description = r2.f;
        this.avatar = r2.g;
        this.chat_id = r2.h;
        this.avatar_key = r2.i;
        this.phone_number = r2.j;
        this.report_location = r2.k;
        this.avatar_path = r2.l;
        this.tags = com.lark.wire.internal.a.c("tags", r2.m);
    }

    public /* synthetic */ Oncall(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
