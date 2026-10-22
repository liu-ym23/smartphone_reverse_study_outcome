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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003%&'B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010#\u001a\u00020\u0002H\u0016J\b\u0010$\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001a\u0010\u001cR\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!¨\u0006("}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ImageSetV2;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/ImageSetV2$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/ImageSetV2$Builder;Lokio/ByteString;)V", "image_key", "", "getImage_key", "()Ljava/lang/String;", "fs_unit", "getFs_unit", "crypto", "Lcom/lark/kmp/pb/basic/v1/SerCrypto;", "getCrypto", "()Lcom/lark/kmp/pb/basic/v1/SerCrypto;", "images", "", "Lcom/lark/kmp/pb/basic/v1/ImageSetV2$ImageAttribute;", "getImages", "()Ljava/util/List;", "inline_preview", "getInline_preview", "()Lokio/ByteString;", "is_destroyed", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "scene_id", "", "getScene_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "newBuilder", "toString", "Builder", "Companion", "ImageAttribute", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ImageSetV2 extends com.lark.wire.Message<ImageSetV2, a> {
    public static final ProtoAdapter<ImageSetV2> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final SerCrypto crypto;
    private final String fs_unit;
    private final String image_key;
    private final List<ImageAttribute> images;
    private final ByteString inline_preview;
    private final Boolean is_destroyed;
    private final Long scene_id;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ImageSetV2$ImageAttribute;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/ImageSetV2$ImageAttribute$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/ImageSetV2$ImageAttribute$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/ImageCropType;", "getType", "()Lcom/lark/kmp/pb/basic/v1/ImageCropType;", "attribute", "Lcom/lark/kmp/pb/basic/v1/ImageBaseAttribute;", "getAttribute", "()Lcom/lark/kmp/pb/basic/v1/ImageBaseAttribute;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ImageAttribute extends com.lark.wire.Message<ImageAttribute, a> {
        public static final ProtoAdapter<ImageAttribute> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final ImageBaseAttribute attribute;
        private final ImageCropType type;

        public static final class a extends com.lark.wire.Message.a<ImageAttribute, a> {
            public ImageCropType d;
            public ImageBaseAttribute e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ImageAttribute(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ImageAttribute> {
            @Override // com.lark.wire.ProtoAdapter
            public final ImageAttribute c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L16;
                if (r3 != 1) goto L8;
                ImageCropType r4 = ImageCropType.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
                Intrinsics.checkNotNullParameter(r4, "type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
                r0.d = r4;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.e = ImageBaseAttribute.ADAPTER.c(r9);
                goto L3
            L9:
                r9.j(r3);
                goto L3
            L16:
                return new ImageAttribute(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ImageAttribute r5) {
                ImageAttribute r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + ImageCropType.ADAPTER.l(1, r6.getType())) + ImageBaseAttribute.ADAPTER.l(2, r6.getAttribute());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, ImageAttribute r5) {
                ImageAttribute r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ImageCropType.ADAPTER.i(r4, 1, r6.getType());
                ImageBaseAttribute.ADAPTER.i(r4, 2, r6.getAttribute());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, ImageAttribute r5) {
                ImageAttribute r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ImageBaseAttribute.ADAPTER.j(r4, 2, r6.getAttribute());
                ImageCropType.ADAPTER.j(r4, 1, r6.getType());
            }

            public b(FieldEncoding r7, KClass<ImageAttribute> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.ImageSetV2.ImageAttribute", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ImageAttribute(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ImageAttribute.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.type;
            r0.e = this.attribute;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ImageAttribute.class).getSimpleName() + '@' + hashCode();
        }

        public final ImageBaseAttribute getAttribute() {
            return this.attribute;
        }

        public final ImageCropType getType() {
            return this.type;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ImageAttribute(a r2, ByteString r3) {
            super(ADAPTER, r3);
            ImageCropType r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.type = r4;
            ImageBaseAttribute r5 = r2.e;
            Intrinsics.checkNotNull(r5);
            this.attribute = r5;
        }

        public /* synthetic */ ImageAttribute(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<ImageSetV2, a> {
        public String d;
        public String e;
        public SerCrypto f;
        public List<ImageAttribute> g;
        public ByteString h;
        public Boolean i;
        public Long j;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new ImageSetV2(this, c(), null);
        }

        public a() {
            this.g = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<ImageSetV2> {
        @Override // com.lark.wire.ProtoAdapter
        public final ImageSetV2 c(g0 r8) {
            Intrinsics.checkNotNullParameter(r8, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r8.c();
        L3:
            int r5 = r8.e();
            if (r5 == (-1)) goto L14;
            switch(r5) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r1.j = (Long) ProtoAdapter.k.c(r8);
            goto L3
        L8:
            r1.i = (Boolean) ProtoAdapter.g.c(r8);
            goto L3
        L9:
            ProtoAdapter.p.getClass();
            Intrinsics.checkNotNullParameter(r8, "reader");
            r1.h = r8.f();
            goto L3
        L10:
            r2.add(ImageAttribute.ADAPTER.c(r8));
            goto L3
        L11:
            r1.f = SerCrypto.ADAPTER.c(r8);
            goto L3
        L12:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r8, "reader");
            r1.e = r8.i();
            goto L3
        L13:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r8, "reader");
            r1.d = r8.i();
            goto L3
        L6:
            r8.j(r5);
            Unit r6 = Unit.INSTANCE;
            goto L3
        L14:
            ByteString r9 = r8.d(r3);
            Intrinsics.checkNotNullParameter(r2, "images");
            com.lark.wire.internal.a.a(r2);
            r1.g = r2;
            return new ImageSetV2(r1, r9, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(ImageSetV2 r5) {
            ImageSetV2 r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return ((((((r0 + r1.l(1, r6.getImage_key())) + r1.l(2, r6.getFs_unit())) + SerCrypto.ADAPTER.l(3, r6.getCrypto())) + ImageAttribute.ADAPTER.a().l(4, r6.getImages())) + ProtoAdapter.p.l(5, r6.getInline_preview())) + ProtoAdapter.g.l(6, r6.is_destroyed())) + ProtoAdapter.k.l(7, r6.getScene_id());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, ImageSetV2 r5) {
            ImageSetV2 r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r4, 1, r6.getImage_key());
            r0.i(r4, 2, r6.getFs_unit());
            SerCrypto.ADAPTER.i(r4, 3, r6.getCrypto());
            ImageAttribute.ADAPTER.a().i(r4, 4, r6.getImages());
            ProtoAdapter.p.i(r4, 5, r6.getInline_preview());
            ProtoAdapter.g.i(r4, 6, r6.is_destroyed());
            ProtoAdapter.k.i(r4, 7, r6.getScene_id());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, ImageSetV2 r5) {
            ImageSetV2 r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.k.j(r4, 7, r6.getScene_id());
            ProtoAdapter.g.j(r4, 6, r6.is_destroyed());
            ProtoAdapter.p.j(r4, 5, r6.getInline_preview());
            ImageAttribute.ADAPTER.a().j(r4, 4, r6.getImages());
            SerCrypto.ADAPTER.j(r4, 3, r6.getCrypto());
            w r0 = ProtoAdapter.q;
            r0.j(r4, 2, r6.getFs_unit());
            r0.j(r4, 1, r6.getImage_key());
        }

        public b(FieldEncoding r7, KClass<ImageSetV2> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.ImageSetV2", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ ImageSetV2(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ImageSetV2.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.image_key;
        r0.e = this.fs_unit;
        r0.f = this.crypto;
        r0.g = this.images;
        r0.h = this.inline_preview;
        r0.i = this.is_destroyed;
        r0.j = this.scene_id;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(ImageSetV2.class).getSimpleName() + '@' + hashCode();
    }

    public final SerCrypto getCrypto() {
        return this.crypto;
    }

    public final String getFs_unit() {
        return this.fs_unit;
    }

    public final String getImage_key() {
        return this.image_key;
    }

    public final List<ImageAttribute> getImages() {
        return this.images;
    }

    public final ByteString getInline_preview() {
        return this.inline_preview;
    }

    public final Long getScene_id() {
        return this.scene_id;
    }

    public final Boolean is_destroyed() {
        return this.is_destroyed;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public ImageSetV2(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.image_key = r2.d;
        this.fs_unit = r2.e;
        this.crypto = r2.f;
        this.images = com.lark.wire.internal.a.c("images", r2.g);
        this.inline_preview = r2.h;
        this.is_destroyed = r2.i;
        this.scene_id = r2.j;
    }

    public /* synthetic */ ImageSetV2(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
