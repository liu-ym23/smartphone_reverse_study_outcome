package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.w;
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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004)*+,B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010'\u001a\u00020\u0002H\u0016J\b\u0010(\u001a\u00020\u000eH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010%\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0010¨\u0006-"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/HongbaoCover;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/HongbaoCover$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/HongbaoCover$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "name", "", "getName", "()Ljava/lang/String;", "cover_type", "Lcom/lark/kmp/pb/basic/v1/HongbaoCover$CoverType;", "getCover_type", "()Lcom/lark/kmp/pb/basic/v1/HongbaoCover$CoverType;", "main_cover", "Lcom/lark/kmp/pb/basic/v1/ImageSetPassThrough;", "getMain_cover", "()Lcom/lark/kmp/pb/basic/v1/ImageSetPassThrough;", "message_cover", "getMessage_cover", "head_cover", "getHead_cover", "company_logo", "getCompany_logo", "select_cover", "getSelect_cover", "display_name", "Lcom/lark/kmp/pb/basic/v1/HongbaoCover$DisplayName;", "getDisplay_name", "()Lcom/lark/kmp/pb/basic/v1/HongbaoCover$DisplayName;", "company_name", "getCompany_name", "newBuilder", "toString", "Builder", "Companion", "CoverType", "DisplayName", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class HongbaoCover extends com.lark.wire.Message<HongbaoCover, a> {
    public static final ProtoAdapter<HongbaoCover> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final ImageSetPassThrough company_logo;
    private final String company_name;
    private final CoverType cover_type;
    private final DisplayName display_name;
    private final ImageSetPassThrough head_cover;
    private final Long id;
    private final ImageSetPassThrough main_cover;
    private final ImageSetPassThrough message_cover;
    private final String name;
    private final ImageSetPassThrough select_cover;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/HongbaoCover$CoverType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "TEMPLATE", "CUSTOMIZE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum CoverType extends Enum<CoverType> implements o0 {
        public static final ProtoAdapter<CoverType> ADAPTER = null;
        public static final CoverType CUSTOMIZE = null;
        public static final b Companion = null;
        public static final CoverType TEMPLATE = null;
        public static final CoverType UNKNOWN = null;
        public static final /* synthetic */ CoverType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<CoverType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                CoverType.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return CoverType.CUSTOMIZE;
            L15:
                return CoverType.TEMPLATE;
            L12:
                return CoverType.UNKNOWN;
            }

            public a(KClass<CoverType> r1, Syntax r2, CoverType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<CoverType> getEntries() {
            return b;
        }

        static {
            CoverType r0 = new CoverType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            CoverType r1 = new CoverType("TEMPLATE", 1, 1);
            TEMPLATE = r1;
            CoverType r3 = new CoverType("CUSTOMIZE", 2, 2);
            CUSTOMIZE = r3;
            CoverType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(CoverType.class), Syntax.PROTO_2, r0);
        }

        public static CoverType[] values() {
            return (CoverType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final CoverType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return CUSTOMIZE;
        L15:
            return TEMPLATE;
        L12:
            return UNKNOWN;
        }

        public static CoverType valueOf(String r1) {
            return (CoverType) r27.a.a(CoverType.class, r1);
        }

        public CoverType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/HongbaoCover$DisplayName;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/HongbaoCover$DisplayName$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/HongbaoCover$DisplayName$Builder;Lokio/ByteString;)V", "background_img", "Lcom/lark/kmp/pb/basic/v1/ImageSetPassThrough;", "getBackground_img", "()Lcom/lark/kmp/pb/basic/v1/ImageSetPassThrough;", "display_name", "", "getDisplay_name", "()Ljava/lang/String;", "bg_border_width", "", "getBg_border_width", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "bg_img_dot_9", "getBg_img_dot_9", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class DisplayName extends com.lark.wire.Message<DisplayName, a> {
        public static final ProtoAdapter<DisplayName> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final ImageSetPassThrough background_img;
        private final Integer bg_border_width;
        private final ImageSetPassThrough bg_img_dot_9;
        private final String display_name;

        public static final class a extends com.lark.wire.Message.a<DisplayName, a> {
            public ImageSetPassThrough d;
            public String e;
            public Integer f;
            public ImageSetPassThrough g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new DisplayName(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<DisplayName> {
            @Override // com.lark.wire.ProtoAdapter
            public final DisplayName c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L19;
                if (r4 != 1) goto L8;
                r1.d = ImageSetPassThrough.ADAPTER.c(r7);
                goto L3
            L8:
                if (r4 != 2) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L10:
                if (r4 != 3) goto L12;
                r1.f = (Integer) ProtoAdapter.h.c(r7);
                goto L3
            L12:
                if (r4 != 4) goto L13;
                r1.g = ImageSetPassThrough.ADAPTER.c(r7);
                goto L3
            L13:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L19:
                return new DisplayName(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(DisplayName r6) {
                DisplayName r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size();
                ProtoAdapter<ImageSetPassThrough> r1 = ImageSetPassThrough.ADAPTER;
                return (((r0 + r1.l(1, r7.getBackground_img())) + ProtoAdapter.q.l(2, r7.getDisplay_name())) + ProtoAdapter.h.l(3, r7.getBg_border_width())) + r1.l(4, r7.getBg_img_dot_9());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, DisplayName r6) {
                DisplayName r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                ProtoAdapter<ImageSetPassThrough> r0 = ImageSetPassThrough.ADAPTER;
                r0.i(r5, 1, r7.getBackground_img());
                ProtoAdapter.q.i(r5, 2, r7.getDisplay_name());
                ProtoAdapter.h.i(r5, 3, r7.getBg_border_width());
                r0.i(r5, 4, r7.getBg_img_dot_9());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, DisplayName r6) {
                DisplayName r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                ProtoAdapter<ImageSetPassThrough> r0 = ImageSetPassThrough.ADAPTER;
                r0.j(r5, 4, r7.getBg_img_dot_9());
                ProtoAdapter.h.j(r5, 3, r7.getBg_border_width());
                ProtoAdapter.q.j(r5, 2, r7.getDisplay_name());
                r0.j(r5, 1, r7.getBackground_img());
            }

            public b(FieldEncoding r7, KClass<DisplayName> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.HongbaoCover.DisplayName", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ DisplayName(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(DisplayName.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.background_img;
            r0.e = this.display_name;
            r0.f = this.bg_border_width;
            r0.g = this.bg_img_dot_9;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(DisplayName.class).getSimpleName() + '@' + hashCode();
        }

        public final ImageSetPassThrough getBackground_img() {
            return this.background_img;
        }

        public final Integer getBg_border_width() {
            return this.bg_border_width;
        }

        public final ImageSetPassThrough getBg_img_dot_9() {
            return this.bg_img_dot_9;
        }

        public final String getDisplay_name() {
            return this.display_name;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public DisplayName(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.background_img = r2.d;
            this.display_name = r2.e;
            this.bg_border_width = r2.f;
            this.bg_img_dot_9 = r2.g;
        }

        public /* synthetic */ DisplayName(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<HongbaoCover, a> {
        public Long d;
        public String e;
        public CoverType f;
        public ImageSetPassThrough g;
        public ImageSetPassThrough h;
        public ImageSetPassThrough i;
        public ImageSetPassThrough j;
        public ImageSetPassThrough k;
        public DisplayName l;
        public String m;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new HongbaoCover(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<HongbaoCover> {
        @Override // com.lark.wire.ProtoAdapter
        public final HongbaoCover c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L21;
            switch(r4) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L22;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L22:
            r1.f = CoverType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L7:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.m = r10.i();
            goto L3
        L8:
            r1.l = DisplayName.ADAPTER.c(r10);
            goto L3
        L9:
            r1.k = ImageSetPassThrough.ADAPTER.c(r10);
            goto L3
        L10:
            r1.j = ImageSetPassThrough.ADAPTER.c(r10);
            goto L3
        L11:
            r1.i = ImageSetPassThrough.ADAPTER.c(r10);
            goto L3
        L12:
            r1.h = ImageSetPassThrough.ADAPTER.c(r10);
            goto L3
        L13:
            r1.g = ImageSetPassThrough.ADAPTER.c(r10);
            goto L3
        L18:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.e = r10.i();
            goto L3
        L19:
            r1.d = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L6:
            r10.j(r4);
            Unit r6 = Unit.INSTANCE;
            goto L3
        L21:
            return new HongbaoCover(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(HongbaoCover r6) {
            HongbaoCover r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size() + ProtoAdapter.k.l(1, r7.getId());
            w r1 = ProtoAdapter.q;
            int r2 = (r0 + r1.l(2, r7.getName())) + CoverType.ADAPTER.l(3, r7.getCover_type());
            ProtoAdapter<ImageSetPassThrough> r3 = ImageSetPassThrough.ADAPTER;
            return ((((((r2 + r3.l(4, r7.getMain_cover())) + r3.l(5, r7.getMessage_cover())) + r3.l(6, r7.getHead_cover())) + r3.l(7, r7.getCompany_logo())) + r3.l(8, r7.getSelect_cover())) + DisplayName.ADAPTER.l(9, r7.getDisplay_name())) + r1.l(10, r7.getCompany_name());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, HongbaoCover r6) {
            HongbaoCover r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            ProtoAdapter.k.i(r5, 1, r7.getId());
            w r0 = ProtoAdapter.q;
            r0.i(r5, 2, r7.getName());
            CoverType.ADAPTER.i(r5, 3, r7.getCover_type());
            ProtoAdapter<ImageSetPassThrough> r1 = ImageSetPassThrough.ADAPTER;
            r1.i(r5, 4, r7.getMain_cover());
            r1.i(r5, 5, r7.getMessage_cover());
            r1.i(r5, 6, r7.getHead_cover());
            r1.i(r5, 7, r7.getCompany_logo());
            r1.i(r5, 8, r7.getSelect_cover());
            DisplayName.ADAPTER.i(r5, 9, r7.getDisplay_name());
            r0.i(r5, 10, r7.getCompany_name());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, HongbaoCover r6) {
            HongbaoCover r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            w r0 = ProtoAdapter.q;
            r0.j(r5, 10, r7.getCompany_name());
            DisplayName.ADAPTER.j(r5, 9, r7.getDisplay_name());
            ProtoAdapter<ImageSetPassThrough> r1 = ImageSetPassThrough.ADAPTER;
            r1.j(r5, 8, r7.getSelect_cover());
            r1.j(r5, 7, r7.getCompany_logo());
            r1.j(r5, 6, r7.getHead_cover());
            r1.j(r5, 5, r7.getMessage_cover());
            r1.j(r5, 4, r7.getMain_cover());
            CoverType.ADAPTER.j(r5, 3, r7.getCover_type());
            r0.j(r5, 2, r7.getName());
            ProtoAdapter.k.j(r5, 1, r7.getId());
        }

        public b(FieldEncoding r7, KClass<HongbaoCover> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.HongbaoCover", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ HongbaoCover(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(HongbaoCover.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.name;
        r0.f = this.cover_type;
        r0.g = this.main_cover;
        r0.h = this.message_cover;
        r0.i = this.head_cover;
        r0.j = this.company_logo;
        r0.k = this.select_cover;
        r0.l = this.display_name;
        r0.m = this.company_name;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(HongbaoCover.class).getSimpleName() + '@' + hashCode();
    }

    public final ImageSetPassThrough getCompany_logo() {
        return this.company_logo;
    }

    public final String getCompany_name() {
        return this.company_name;
    }

    public final CoverType getCover_type() {
        return this.cover_type;
    }

    public final DisplayName getDisplay_name() {
        return this.display_name;
    }

    public final ImageSetPassThrough getHead_cover() {
        return this.head_cover;
    }

    public final Long getId() {
        return this.id;
    }

    public final ImageSetPassThrough getMain_cover() {
        return this.main_cover;
    }

    public final ImageSetPassThrough getMessage_cover() {
        return this.message_cover;
    }

    public final String getName() {
        return this.name;
    }

    public final ImageSetPassThrough getSelect_cover() {
        return this.select_cover;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public HongbaoCover(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.id = r2.d;
        this.name = r2.e;
        this.cover_type = r2.f;
        this.main_cover = r2.g;
        this.message_cover = r2.h;
        this.head_cover = r2.i;
        this.company_logo = r2.j;
        this.select_cover = r2.k;
        this.display_name = r2.l;
        this.company_name = r2.m;
    }

    public /* synthetic */ HongbaoCover(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
