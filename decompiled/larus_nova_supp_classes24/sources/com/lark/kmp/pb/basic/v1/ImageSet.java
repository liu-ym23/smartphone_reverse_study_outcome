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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 -2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002,-B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010*\u001a\u00020\u0002H\u0016J\b\u0010+\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000fR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000fR\u0015\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\n\n\u0002\u0010$\u001a\u0004\b!\u0010#R\u0015\u0010%\u001a\u0004\u0018\u00010&¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(¨\u0006."}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ImageSet;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/ImageSet$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/ImageSet$Builder;Lokio/ByteString;)V", "key", "", "getKey", "()Ljava/lang/String;", "origin", "Lcom/lark/kmp/pb/basic/v1/Image;", "getOrigin", "()Lcom/lark/kmp/pb/basic/v1/Image;", "thumbnail", "getThumbnail", "middle", "getMiddle", "thumbnail_webp", "getThumbnail_webp", "middle_webp", "getMiddle_webp", "middle_mp4", "getMiddle_mp4", "cover", "getCover", "inline_preview", "getInline_preview", "()Lokio/ByteString;", "intact", "getIntact", "is_destroyed", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "scene_id", "", "getScene_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ImageSet extends com.lark.wire.Message<ImageSet, a> {
    public static final ProtoAdapter<ImageSet> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Image cover;
    private final ByteString inline_preview;
    private final Image intact;
    private final Boolean is_destroyed;
    private final String key;
    private final Image middle;
    private final Image middle_mp4;
    private final Image middle_webp;
    private final Image origin;
    private final Long scene_id;
    private final Image thumbnail;
    private final Image thumbnail_webp;

    public static final class a extends com.lark.wire.Message.a<ImageSet, a> {
        public String d;
        public Image e;
        public Image f;
        public Image g;
        public Image h;
        public Image i;
        public Image j;
        public Image k;
        public ByteString l;
        public Image m;
        public Boolean n;
        public Long o;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new ImageSet(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<ImageSet> {
        @Override // com.lark.wire.ProtoAdapter
        public final ImageSet c(g0 r7) {
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
            r1.o = (Long) ProtoAdapter.k.c(r7);
            goto L3
        L8:
            r1.n = (Boolean) ProtoAdapter.g.c(r7);
            goto L3
        L9:
            r1.m = Image.ADAPTER.c(r7);
            goto L3
        L10:
            ProtoAdapter.p.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.l = r7.f();
            goto L3
        L11:
            r1.k = Image.ADAPTER.c(r7);
            goto L3
        L12:
            r1.j = Image.ADAPTER.c(r7);
            goto L3
        L13:
            r1.i = Image.ADAPTER.c(r7);
            goto L3
        L14:
            r1.h = Image.ADAPTER.c(r7);
            goto L3
        L15:
            r1.g = Image.ADAPTER.c(r7);
            goto L3
        L16:
            r1.f = Image.ADAPTER.c(r7);
            goto L3
        L17:
            r1.e = Image.ADAPTER.c(r7);
            goto L3
        L18:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.d = r7.i();
            goto L3
        L6:
            r7.j(r4);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L20:
            return new ImageSet(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(ImageSet r6) {
            ImageSet r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size() + ProtoAdapter.q.l(1, r7.getKey());
            ProtoAdapter<Image> r1 = Image.ADAPTER;
            return ((((((((((r0 + r1.l(2, r7.getOrigin())) + r1.l(3, r7.getThumbnail())) + r1.l(4, r7.getMiddle())) + r1.l(5, r7.getThumbnail_webp())) + r1.l(6, r7.getMiddle_webp())) + r1.l(7, r7.getMiddle_mp4())) + r1.l(8, r7.getCover())) + ProtoAdapter.p.l(9, r7.getInline_preview())) + r1.l(10, r7.getIntact())) + ProtoAdapter.g.l(11, r7.is_destroyed())) + ProtoAdapter.k.l(12, r7.getScene_id());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, ImageSet r6) {
            ImageSet r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            ProtoAdapter.q.i(r5, 1, r7.getKey());
            ProtoAdapter<Image> r0 = Image.ADAPTER;
            r0.i(r5, 2, r7.getOrigin());
            r0.i(r5, 3, r7.getThumbnail());
            r0.i(r5, 4, r7.getMiddle());
            r0.i(r5, 5, r7.getThumbnail_webp());
            r0.i(r5, 6, r7.getMiddle_webp());
            r0.i(r5, 7, r7.getMiddle_mp4());
            r0.i(r5, 8, r7.getCover());
            ProtoAdapter.p.i(r5, 9, r7.getInline_preview());
            r0.i(r5, 10, r7.getIntact());
            ProtoAdapter.g.i(r5, 11, r7.is_destroyed());
            ProtoAdapter.k.i(r5, 12, r7.getScene_id());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, ImageSet r6) {
            ImageSet r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            ProtoAdapter.k.j(r5, 12, r7.getScene_id());
            ProtoAdapter.g.j(r5, 11, r7.is_destroyed());
            ProtoAdapter<Image> r0 = Image.ADAPTER;
            r0.j(r5, 10, r7.getIntact());
            ProtoAdapter.p.j(r5, 9, r7.getInline_preview());
            r0.j(r5, 8, r7.getCover());
            r0.j(r5, 7, r7.getMiddle_mp4());
            r0.j(r5, 6, r7.getMiddle_webp());
            r0.j(r5, 5, r7.getThumbnail_webp());
            r0.j(r5, 4, r7.getMiddle());
            r0.j(r5, 3, r7.getThumbnail());
            r0.j(r5, 2, r7.getOrigin());
            ProtoAdapter.q.j(r5, 1, r7.getKey());
        }

        public b(FieldEncoding r7, KClass<ImageSet> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.ImageSet", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ ImageSet(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ImageSet.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.key;
        r0.e = this.origin;
        r0.f = this.thumbnail;
        r0.g = this.middle;
        r0.h = this.thumbnail_webp;
        r0.i = this.middle_webp;
        r0.j = this.middle_mp4;
        r0.k = this.cover;
        r0.l = this.inline_preview;
        r0.m = this.intact;
        r0.n = this.is_destroyed;
        r0.o = this.scene_id;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(ImageSet.class).getSimpleName() + '@' + hashCode();
    }

    public final Image getCover() {
        return this.cover;
    }

    public final ByteString getInline_preview() {
        return this.inline_preview;
    }

    public final Image getIntact() {
        return this.intact;
    }

    public final String getKey() {
        return this.key;
    }

    public final Image getMiddle() {
        return this.middle;
    }

    public final Image getMiddle_mp4() {
        return this.middle_mp4;
    }

    public final Image getMiddle_webp() {
        return this.middle_webp;
    }

    public final Image getOrigin() {
        return this.origin;
    }

    public final Long getScene_id() {
        return this.scene_id;
    }

    public final Image getThumbnail() {
        return this.thumbnail;
    }

    public final Image getThumbnail_webp() {
        return this.thumbnail_webp;
    }

    public final Boolean is_destroyed() {
        return this.is_destroyed;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public ImageSet(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.key = r2.d;
        this.origin = r2.e;
        this.thumbnail = r2.f;
        this.middle = r2.g;
        this.thumbnail_webp = r2.h;
        this.middle_webp = r2.i;
        this.middle_mp4 = r2.j;
        this.cover = r2.k;
        this.inline_preview = r2.l;
        this.intact = r2.m;
        this.is_destroyed = r2.n;
        this.scene_id = r2.o;
    }

    public /* synthetic */ ImageSet(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
