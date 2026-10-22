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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TranslatedImage;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/TranslatedImage$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/TranslatedImage$Builder;Lokio/ByteString;)V", "translated_image_set", "Lcom/lark/kmp/pb/basic/v1/ImageSet;", "getTranslated_image_set", "()Lcom/lark/kmp/pb/basic/v1/ImageSet;", "is_translated", "", "()Z", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TranslatedImage extends com.lark.wire.Message<TranslatedImage, a> {
    public static final ProtoAdapter<TranslatedImage> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final boolean is_translated;
    private final ImageSet translated_image_set;

    public static final class a extends com.lark.wire.Message.a<TranslatedImage, a> {
        public ImageSet d;
        public Boolean e;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new TranslatedImage(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<TranslatedImage> {
        @Override // com.lark.wire.ProtoAdapter
        public final TranslatedImage c(g0 r6) {
            Intrinsics.checkNotNullParameter(r6, "reader");
            a r0 = new a();
            long r1 = r6.c();
        L3:
            int r3 = r6.e();
            if (r3 == (-1)) goto L13;
            if (r3 != 1) goto L8;
            r0.d = ImageSet.ADAPTER.c(r6);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.e = Boolean.valueOf(((Boolean) ProtoAdapter.g.c(r6)).booleanValue());
            goto L3
        L9:
            r6.j(r3);
            Unit r4 = Unit.INSTANCE;
            goto L3
        L13:
            return new TranslatedImage(r0, r6.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(TranslatedImage r5) {
            TranslatedImage r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (r6.unknownFields().size() + ImageSet.ADAPTER.l(1, r6.getTranslated_image_set())) + ProtoAdapter.g.l(2, Boolean.valueOf(r6.is_translated()));
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, TranslatedImage r5) {
            TranslatedImage r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ImageSet.ADAPTER.i(r4, 1, r6.getTranslated_image_set());
            ProtoAdapter.g.i(r4, 2, Boolean.valueOf(r6.is_translated()));
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, TranslatedImage r5) {
            TranslatedImage r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.g.j(r4, 2, Boolean.valueOf(r6.is_translated()));
            ImageSet.ADAPTER.j(r4, 1, r6.getTranslated_image_set());
        }

        public b(FieldEncoding r7, KClass<TranslatedImage> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.TranslatedImage", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ TranslatedImage(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TranslatedImage.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.translated_image_set;
        r0.e = Boolean.valueOf(this.is_translated);
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(TranslatedImage.class).getSimpleName() + '@' + hashCode();
    }

    public final ImageSet getTranslated_image_set() {
        return this.translated_image_set;
    }

    public final boolean is_translated() {
        return this.is_translated;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public TranslatedImage(a r2, ByteString r3) {
        super(ADAPTER, r3);
        ImageSet r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.translated_image_set = r4;
        Boolean r5 = r2.e;
        Intrinsics.checkNotNull(r5);
        this.is_translated = r5.booleanValue();
    }

    public /* synthetic */ TranslatedImage(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
