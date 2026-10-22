package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.b0;
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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ImageBaseAttribute;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/ImageBaseAttribute$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/ImageBaseAttribute$Builder;Lokio/ByteString;)V", "width", "", "getWidth", "()I", "height", "getHeight", "exif_orientation", "getExif_orientation", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ImageBaseAttribute extends com.lark.wire.Message<ImageBaseAttribute, a> {
    public static final ProtoAdapter<ImageBaseAttribute> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Integer exif_orientation;
    private final int height;
    private final int width;

    public static final class a extends com.lark.wire.Message.a<ImageBaseAttribute, a> {
        public Integer d;
        public Integer e;
        public Integer f;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new ImageBaseAttribute(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<ImageBaseAttribute> {
        @Override // com.lark.wire.ProtoAdapter
        public final ImageBaseAttribute c(g0 r6) {
            Intrinsics.checkNotNullParameter(r6, "reader");
            a r0 = new a();
            long r1 = r6.c();
        L3:
            int r3 = r6.e();
            if (r3 == (-1)) goto L16;
            if (r3 != 1) goto L8;
            r0.d = Integer.valueOf(((Number) ProtoAdapter.i.c(r6)).intValue());
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.e = Integer.valueOf(((Number) ProtoAdapter.i.c(r6)).intValue());
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.f = (Integer) ProtoAdapter.i.c(r6);
            goto L3
        L11:
            r6.j(r3);
            Unit r4 = Unit.INSTANCE;
            goto L3
        L16:
            return new ImageBaseAttribute(r0, r6.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(ImageBaseAttribute r5) {
            ImageBaseAttribute r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            b0 r1 = ProtoAdapter.i;
            return ((r0 + r1.l(1, Integer.valueOf(r6.getWidth()))) + r1.l(2, Integer.valueOf(r6.getHeight()))) + r1.l(3, r6.getExif_orientation());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, ImageBaseAttribute r5) {
            ImageBaseAttribute r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            b0 r0 = ProtoAdapter.i;
            r0.i(r4, 1, Integer.valueOf(r6.getWidth()));
            r0.i(r4, 2, Integer.valueOf(r6.getHeight()));
            r0.i(r4, 3, r6.getExif_orientation());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, ImageBaseAttribute r5) {
            ImageBaseAttribute r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            b0 r0 = ProtoAdapter.i;
            r0.j(r4, 3, r6.getExif_orientation());
            r0.j(r4, 2, Integer.valueOf(r6.getHeight()));
            r0.j(r4, 1, Integer.valueOf(r6.getWidth()));
        }

        public b(FieldEncoding r7, KClass<ImageBaseAttribute> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.ImageBaseAttribute", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ ImageBaseAttribute(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ImageBaseAttribute.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = Integer.valueOf(this.width);
        r0.e = Integer.valueOf(this.height);
        r0.f = this.exif_orientation;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(ImageBaseAttribute.class).getSimpleName() + '@' + hashCode();
    }

    public final Integer getExif_orientation() {
        return this.exif_orientation;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public ImageBaseAttribute(a r2, ByteString r3) {
        super(ADAPTER, r3);
        Integer r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.width = r4.intValue();
        Integer r5 = r2.e;
        Intrinsics.checkNotNull(r5);
        this.height = r5.intValue();
        this.exif_orientation = r2.f;
    }

    public /* synthetic */ ImageBaseAttribute(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
