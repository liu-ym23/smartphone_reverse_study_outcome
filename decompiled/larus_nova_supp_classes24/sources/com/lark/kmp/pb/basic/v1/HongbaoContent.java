package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 /2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003./0B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010,\u001a\u00020\u0002H\u0016J\b\u0010-\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0019\u0010\u0015R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010 \u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b!\u0010\u0015R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0015\u0010'\u001a\u0004\u0018\u00010(¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*¨\u00061"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/HongbaoContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/HongbaoContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/HongbaoContent$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "subject", "getSubject", "type", "Lcom/lark/kmp/pb/basic/v1/HongbaoContent$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/HongbaoContent$Type;", "clicked", "", "getClicked", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_expired", "grabbed", "getGrabbed", "grabbed_finish", "getGrabbed_finish", "cover", "Lcom/lark/kmp/pb/basic/v1/HongbaoCover;", "getCover", "()Lcom/lark/kmp/pb/basic/v1/HongbaoCover;", "can_grab", "getCan_grab", "preview_user_ids", "", "", "getPreview_user_ids", "()Ljava/util/List;", "total_num", "", "getTotal_num", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "newBuilder", "toString", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class HongbaoContent extends com.lark.wire.Message<HongbaoContent, a> {
    public static final ProtoAdapter<HongbaoContent> ADAPTER = null;
    public static final c Companion = null;
    public static final boolean DEFAULT_CAN_GRAB = true;
    public static final boolean DEFAULT_CLICKED = false;
    public static final boolean DEFAULT_GRABBED = false;
    public static final boolean DEFAULT_GRABBED_FINISH = false;
    public static final boolean DEFAULT_IS_EXPIRED = false;
    private static final long serialVersionUID = 0;
    private final Boolean can_grab;
    private final Boolean clicked;
    private final HongbaoCover cover;
    private final Boolean grabbed;
    private final Boolean grabbed_finish;
    private final String id;
    private final Boolean is_expired;
    private final List<Long> preview_user_ids;
    private final String subject;
    private final Integer total_num;
    private final Type type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00112\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/HongbaoContent$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "P2P", "GROUP_FIX", "GROUP_RANDOM", "COMMERCIAL", "EXCLUSIVE", "B2C_FIX", "B2C_RANDOM", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type B2C_FIX = null;
        public static final Type B2C_RANDOM = null;
        public static final Type COMMERCIAL = null;
        public static final b Companion = null;
        public static final Type EXCLUSIVE = null;
        public static final Type GROUP_FIX = null;
        public static final Type GROUP_RANDOM = null;
        public static final Type P2P = null;
        public static final Type UNKNOWN = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Type.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Type> r1, Syntax r2, Type r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Type a(int r0) {
                switch(r0) {
                    case 0: goto L12;
                    case 1: goto L20;
                    case 2: goto L19;
                    case 3: goto L18;
                    case 4: goto L17;
                    case 5: goto L16;
                    case 6: goto L15;
                    case 7: goto L14;
                    default: goto L3;
                };
            L3:
                return null;
            L14:
                return Type.B2C_RANDOM;
            L15:
                return Type.B2C_FIX;
            L16:
                return Type.EXCLUSIVE;
            L17:
                return Type.COMMERCIAL;
            L18:
                return Type.GROUP_RANDOM;
            L19:
                return Type.GROUP_FIX;
            L20:
                return Type.P2P;
            L12:
                return Type.UNKNOWN;
            }
        }

        @JvmStatic
        public static final Type fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("P2P", 1, 1);
            P2P = r1;
            Type r3 = new Type("GROUP_FIX", 2, 2);
            GROUP_FIX = r3;
            Type r5 = new Type("GROUP_RANDOM", 3, 3);
            GROUP_RANDOM = r5;
            Type r7 = new Type("COMMERCIAL", 4, 4);
            COMMERCIAL = r7;
            Type r9 = new Type("EXCLUSIVE", 5, 5);
            EXCLUSIVE = r9;
            Type r11 = new Type("B2C_FIX", 6, 6);
            B2C_FIX = r11;
            Type r13 = new Type("B2C_RANDOM", 7, 7);
            B2C_RANDOM = r13;
            Type[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
            a = r15;
            b = EnumEntriesKt.enumEntries(r15);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2, r0);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<HongbaoContent, a> {
        public String d;
        public String e;
        public Type f;
        public Boolean g;
        public Boolean h;
        public Boolean i;
        public Boolean j;
        public HongbaoCover k;
        public Boolean l;
        public List<Long> m;
        public Integer n;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new HongbaoContent(this, c(), null);
        }

        public a() {
            this.m = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<HongbaoContent> {
        @Override // com.lark.wire.ProtoAdapter
        public final HongbaoContent c(g0 r11) {
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
                case 3: goto L23;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L23:
            Type r6 = Type.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            Intrinsics.checkNotNullParameter(r6, "type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            r1.f = r6;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L7:
            r1.n = (Integer) ProtoAdapter.h.c(r11);
            goto L3
        L8:
            r2.add(ProtoAdapter.k.c(r11));
            goto L3
        L9:
            r1.l = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L10:
            r1.k = HongbaoCover.ADAPTER.c(r11);
            goto L3
        L11:
            r1.j = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L12:
            r1.i = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L13:
            r1.h = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L14:
            r1.g = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L19:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            String r8 = r11.i();
            Intrinsics.checkNotNullParameter(r8, "subject");
            r1.e = r8;
            goto L3
        L20:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            String r9 = r11.i();
            Intrinsics.checkNotNullParameter(r9, "id");
            r1.d = r9;
            goto L3
        L6:
            r11.j(r5);
            Unit r10 = Unit.INSTANCE;
            goto L3
        L21:
            ByteString r12 = r11.d(r3);
            Intrinsics.checkNotNullParameter(r2, "preview_user_ids");
            com.lark.wire.internal.a.a(r2);
            r1.m = r2;
            return new HongbaoContent(r1, r12, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(HongbaoContent r6) {
            HongbaoContent r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = ((r0 + r1.l(1, r7.getId())) + r1.l(2, r7.getSubject())) + Type.ADAPTER.l(3, r7.getType());
            l r3 = ProtoAdapter.g;
            return (((((((r2 + r3.l(4, r7.getClicked())) + r3.l(5, r7.is_expired())) + r3.l(6, r7.getGrabbed())) + r3.l(7, r7.getGrabbed_finish())) + HongbaoCover.ADAPTER.l(8, r7.getCover())) + r3.l(9, r7.getCan_grab())) + ProtoAdapter.k.a().l(10, r7.getPreview_user_ids())) + ProtoAdapter.h.l(11, r7.getTotal_num());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, HongbaoContent r6) {
            HongbaoContent r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getId());
            r0.i(r5, 2, r7.getSubject());
            Type.ADAPTER.i(r5, 3, r7.getType());
            l r1 = ProtoAdapter.g;
            r1.i(r5, 4, r7.getClicked());
            r1.i(r5, 5, r7.is_expired());
            r1.i(r5, 6, r7.getGrabbed());
            r1.i(r5, 7, r7.getGrabbed_finish());
            HongbaoCover.ADAPTER.i(r5, 8, r7.getCover());
            r1.i(r5, 9, r7.getCan_grab());
            ProtoAdapter.k.a().i(r5, 10, r7.getPreview_user_ids());
            ProtoAdapter.h.i(r5, 11, r7.getTotal_num());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, HongbaoContent r6) {
            HongbaoContent r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            ProtoAdapter.h.j(r5, 11, r7.getTotal_num());
            ProtoAdapter.k.a().j(r5, 10, r7.getPreview_user_ids());
            l r0 = ProtoAdapter.g;
            r0.j(r5, 9, r7.getCan_grab());
            HongbaoCover.ADAPTER.j(r5, 8, r7.getCover());
            r0.j(r5, 7, r7.getGrabbed_finish());
            r0.j(r5, 6, r7.getGrabbed());
            r0.j(r5, 5, r7.is_expired());
            r0.j(r5, 4, r7.getClicked());
            Type.ADAPTER.j(r5, 3, r7.getType());
            w r1 = ProtoAdapter.q;
            r1.j(r5, 2, r7.getSubject());
            r1.j(r5, 1, r7.getId());
        }

        public b(FieldEncoding r7, KClass<HongbaoContent> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.HongbaoContent", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ HongbaoContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(HongbaoContent.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.subject;
        r0.f = this.type;
        r0.g = this.clicked;
        r0.h = this.is_expired;
        r0.i = this.grabbed;
        r0.j = this.grabbed_finish;
        r0.k = this.cover;
        r0.l = this.can_grab;
        r0.m = this.preview_user_ids;
        r0.n = this.total_num;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(HongbaoContent.class).getSimpleName() + '@' + hashCode();
    }

    public final Boolean getCan_grab() {
        return this.can_grab;
    }

    public final Boolean getClicked() {
        return this.clicked;
    }

    public final HongbaoCover getCover() {
        return this.cover;
    }

    public final Boolean getGrabbed() {
        return this.grabbed;
    }

    public final Boolean getGrabbed_finish() {
        return this.grabbed_finish;
    }

    public final String getId() {
        return this.id;
    }

    public final List<Long> getPreview_user_ids() {
        return this.preview_user_ids;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final Integer getTotal_num() {
        return this.total_num;
    }

    public final Type getType() {
        return this.type;
    }

    public final Boolean is_expired() {
        return this.is_expired;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public HongbaoContent(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.id = r4;
        String r5 = r2.e;
        Intrinsics.checkNotNull(r5);
        this.subject = r5;
        Type r6 = r2.f;
        Intrinsics.checkNotNull(r6);
        this.type = r6;
        this.clicked = r2.g;
        this.is_expired = r2.h;
        this.grabbed = r2.i;
        this.grabbed_finish = r2.j;
        this.cover = r2.k;
        this.can_grab = r2.l;
        this.preview_user_ids = com.lark.wire.internal.a.c("preview_user_ids", r2.m);
        this.total_num = r2.n;
    }

    public /* synthetic */ HongbaoContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
