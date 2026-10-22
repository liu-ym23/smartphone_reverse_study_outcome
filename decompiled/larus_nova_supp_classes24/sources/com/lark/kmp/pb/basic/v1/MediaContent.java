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
import com.lark.wire.t;
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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 62\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003567B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u00103\u001a\u00020\u0002H\u0016J\b\u00104\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000bR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0013\u0010\"\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u000bR\u0013\u0010$\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u000bR\u0013\u0010&\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u000bR\u0015\u0010(\u001a\u0004\u0018\u00010)¢\u0006\n\n\u0002\u0010+\u001a\u0004\b(\u0010*R\u0013\u0010,\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u000bR\u0013\u0010.\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u000bR\u0015\u00100\u001a\u0004\u0018\u00010)¢\u0006\n\n\u0002\u0010+\u001a\u0004\b0\u0010*R\u0015\u00101\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b2\u0010\u0011¨\u00068"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MediaContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/MediaContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/MediaContent$Builder;Lokio/ByteString;)V", "key", "", "getKey", "()Ljava/lang/String;", "name", "getName", "size", "", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "mime", "getMime", "source", "Lcom/lark/kmp/pb/basic/v1/MediaContent$Source;", "getSource", "()Lcom/lark/kmp/pb/basic/v1/MediaContent$Source;", "image", "Lcom/lark/kmp/pb/basic/v1/ImageSet;", "getImage", "()Lcom/lark/kmp/pb/basic/v1/ImageSet;", "duration", "", "getDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "url", "getUrl", "compress_path", "getCompress_path", "origin_path", "getOrigin_path", "is_original", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "first_screen_image_upload_id", "getFirst_screen_image_upload_id", "media_upload_id", "getMedia_upload_id", "is_destroyed", "scene_id", "getScene_id", "newBuilder", "toString", "Builder", "Companion", "Source", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MediaContent extends com.lark.wire.Message<MediaContent, a> {
    public static final ProtoAdapter<MediaContent> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String compress_path;
    private final Integer duration;
    private final String first_screen_image_upload_id;
    private final ImageSet image;
    private final Boolean is_destroyed;
    private final Boolean is_original;
    private final String key;
    private final String media_upload_id;
    private final String mime;
    private final String name;
    private final String origin_path;
    private final Long scene_id;
    private final Long size;
    private final Source source;
    private final String url;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MediaContent$Source;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "LARK", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Source extends Enum<Source> implements o0 {
        public static final ProtoAdapter<Source> ADAPTER = null;
        public static final b Companion = null;
        public static final Source LARK = null;
        public static final Source UNKNOWN = null;
        public static final /* synthetic */ Source[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Source> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Source.Companion.getClass();
                if (r2 == 0) goto L9;
                if (r2 == 1) goto L11;
                return null;
            L11:
                return Source.LARK;
            L9:
                return Source.UNKNOWN;
            }

            public a(KClass<Source> r1, Syntax r2, Source r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Source> getEntries() {
            return b;
        }

        static {
            Source r0 = new Source("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Source r1 = new Source("LARK", 1, 1);
            LARK = r1;
            Source[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Source.class), Syntax.PROTO_2, r0);
        }

        public static Source[] values() {
            return (Source[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Source fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L9;
            if (r1 == 1) goto L11;
            return null;
        L11:
            return LARK;
        L9:
            return UNKNOWN;
        }

        public static Source valueOf(String r1) {
            return (Source) r27.a.a(Source.class, r1);
        }

        public Source(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<MediaContent, a> {
        public String d;
        public String e;
        public Long f;
        public String g;
        public Source h;
        public ImageSet i;
        public Integer j;
        public String k;
        public String l;
        public String m;
        public Boolean n;
        public String o;
        public String p;
        public Boolean q;
        public Long r;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new MediaContent(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<MediaContent> {
        @Override // com.lark.wire.ProtoAdapter
        public final MediaContent c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L26;
            switch(r4) {
                case 1: goto L24;
                case 2: goto L23;
                case 3: goto L22;
                case 4: goto L21;
                case 5: goto L27;
                case 6: goto L16;
                case 7: goto L15;
                case 8: goto L14;
                case 9: goto L13;
                case 10: goto L12;
                case 11: goto L11;
                case 12: goto L10;
                case 13: goto L9;
                case 14: goto L8;
                case 15: goto L7;
                default: goto L6;
            };
        L27:
            r1.h = Source.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L7:
            r1.r = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L8:
            r1.q = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L9:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.p = r10.i();
            goto L3
        L10:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.o = r10.i();
            goto L3
        L11:
            r1.n = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L12:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.m = r10.i();
            goto L3
        L13:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.l = r10.i();
            goto L3
        L14:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.k = r10.i();
            goto L3
        L15:
            r1.j = (Integer) ProtoAdapter.h.c(r10);
            goto L3
        L16:
            r1.i = ImageSet.ADAPTER.c(r10);
            goto L3
        L21:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.g = r10.i();
            goto L3
        L22:
            r1.f = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L23:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.e = r10.i();
            goto L3
        L24:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.d = r10.i();
            goto L3
        L6:
            r10.j(r4);
            Unit r6 = Unit.INSTANCE;
            goto L3
        L26:
            return new MediaContent(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(MediaContent r7) {
            MediaContent r8 = r7;
            Intrinsics.checkNotNullParameter(r8, "value");
            int r0 = r8.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = (r0 + r1.l(1, r8.getKey())) + r1.l(2, r8.getName());
            t r3 = ProtoAdapter.k;
            int r4 = (((((((r2 + r3.l(3, r8.getSize())) + r1.l(4, r8.getMime())) + Source.ADAPTER.l(5, r8.getSource())) + ImageSet.ADAPTER.l(6, r8.getImage())) + ProtoAdapter.h.l(7, r8.getDuration())) + r1.l(8, r8.getUrl())) + r1.l(9, r8.getCompress_path())) + r1.l(10, r8.getOrigin_path());
            l r5 = ProtoAdapter.g;
            return ((((r4 + r5.l(11, r8.is_original())) + r1.l(12, r8.getFirst_screen_image_upload_id())) + r1.l(13, r8.getMedia_upload_id())) + r5.l(14, r8.is_destroyed())) + r3.l(15, r8.getScene_id());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r6, MediaContent r7) {
            MediaContent r8 = r7;
            Intrinsics.checkNotNullParameter(r6, "writer");
            Intrinsics.checkNotNullParameter(r8, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r6, 1, r8.getKey());
            r0.i(r6, 2, r8.getName());
            t r1 = ProtoAdapter.k;
            r1.i(r6, 3, r8.getSize());
            r0.i(r6, 4, r8.getMime());
            Source.ADAPTER.i(r6, 5, r8.getSource());
            ImageSet.ADAPTER.i(r6, 6, r8.getImage());
            ProtoAdapter.h.i(r6, 7, r8.getDuration());
            r0.i(r6, 8, r8.getUrl());
            r0.i(r6, 9, r8.getCompress_path());
            r0.i(r6, 10, r8.getOrigin_path());
            l r2 = ProtoAdapter.g;
            r2.i(r6, 11, r8.is_original());
            r0.i(r6, 12, r8.getFirst_screen_image_upload_id());
            r0.i(r6, 13, r8.getMedia_upload_id());
            r2.i(r6, 14, r8.is_destroyed());
            r1.i(r6, 15, r8.getScene_id());
            r6.a(r8.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r6, MediaContent r7) {
            MediaContent r8 = r7;
            Intrinsics.checkNotNullParameter(r6, "writer");
            Intrinsics.checkNotNullParameter(r8, "value");
            r6.d(r8.unknownFields());
            t r0 = ProtoAdapter.k;
            r0.j(r6, 15, r8.getScene_id());
            l r1 = ProtoAdapter.g;
            r1.j(r6, 14, r8.is_destroyed());
            w r2 = ProtoAdapter.q;
            r2.j(r6, 13, r8.getMedia_upload_id());
            r2.j(r6, 12, r8.getFirst_screen_image_upload_id());
            r1.j(r6, 11, r8.is_original());
            r2.j(r6, 10, r8.getOrigin_path());
            r2.j(r6, 9, r8.getCompress_path());
            r2.j(r6, 8, r8.getUrl());
            ProtoAdapter.h.j(r6, 7, r8.getDuration());
            ImageSet.ADAPTER.j(r6, 6, r8.getImage());
            Source.ADAPTER.j(r6, 5, r8.getSource());
            r2.j(r6, 4, r8.getMime());
            r0.j(r6, 3, r8.getSize());
            r2.j(r6, 2, r8.getName());
            r2.j(r6, 1, r8.getKey());
        }

        public b(FieldEncoding r7, KClass<MediaContent> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.MediaContent", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ MediaContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MediaContent.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.key;
        r0.e = this.name;
        r0.f = this.size;
        r0.g = this.mime;
        r0.h = this.source;
        r0.i = this.image;
        r0.j = this.duration;
        r0.k = this.url;
        r0.l = this.compress_path;
        r0.m = this.origin_path;
        r0.n = this.is_original;
        r0.o = this.first_screen_image_upload_id;
        r0.p = this.media_upload_id;
        r0.q = this.is_destroyed;
        r0.r = this.scene_id;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(MediaContent.class).getSimpleName() + '@' + hashCode();
    }

    public final String getCompress_path() {
        return this.compress_path;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final String getFirst_screen_image_upload_id() {
        return this.first_screen_image_upload_id;
    }

    public final ImageSet getImage() {
        return this.image;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getMedia_upload_id() {
        return this.media_upload_id;
    }

    public final String getMime() {
        return this.mime;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOrigin_path() {
        return this.origin_path;
    }

    public final Long getScene_id() {
        return this.scene_id;
    }

    public final Long getSize() {
        return this.size;
    }

    public final Source getSource() {
        return this.source;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Boolean is_destroyed() {
        return this.is_destroyed;
    }

    public final Boolean is_original() {
        return this.is_original;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public MediaContent(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.key = r2.d;
        this.name = r2.e;
        this.size = r2.f;
        this.mime = r2.g;
        this.source = r2.h;
        this.image = r2.i;
        this.duration = r2.j;
        this.url = r2.k;
        this.compress_path = r2.l;
        this.origin_path = r2.m;
        this.is_original = r2.n;
        this.first_screen_image_upload_id = r2.o;
        this.media_upload_id = r2.p;
        this.is_destroyed = r2.q;
        this.scene_id = r2.r;
    }

    public /* synthetic */ MediaContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
