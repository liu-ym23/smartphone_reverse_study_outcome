package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.s;
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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 +2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002*+B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010(\u001a\u00020\u0002H\u0016J\b\u0010)\u001a\u00020\rH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0012\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001c\u0010\u001eR\u0015\u0010 \u001a\u0004\u0018\u00010\u001d¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b!\u0010\u001eR\u0013\u0010\"\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0013\u0010$\u001a\u0004\u0018\u00010%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/PreviewUrlContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/PreviewUrlContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/PreviewUrlContent$Builder;Lokio/ByteString;)V", "sequence_id", "", "getSequence_id", "()I", "url", "", "getUrl", "()Ljava/lang/String;", "offset", "getOffset", "count", "getCount", "title", "getTitle", "summary", "getSummary", "icon", "Lcom/lark/kmp/pb/basic/v1/ImageSet;", "getIcon", "()Lcom/lark/kmp/pb/basic/v1/ImageSet;", "is_hidden", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "has_preview", "getHas_preview", "cover_image", "getCover_image", "video_info", "Lcom/lark/kmp/pb/basic/v1/PreviewVideo;", "getVideo_info", "()Lcom/lark/kmp/pb/basic/v1/PreviewVideo;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class PreviewUrlContent extends com.lark.wire.Message<PreviewUrlContent, a> {
    public static final ProtoAdapter<PreviewUrlContent> ADAPTER = null;
    public static final c Companion = null;
    public static final boolean DEFAULT_HAS_PREVIEW = true;
    private static final long serialVersionUID = 0;
    private final int count;
    private final ImageSet cover_image;
    private final Boolean has_preview;
    private final ImageSet icon;
    private final Boolean is_hidden;
    private final int offset;
    private final int sequence_id;
    private final String summary;
    private final String title;
    private final String url;
    private final PreviewVideo video_info;

    public static final class a extends com.lark.wire.Message.a<PreviewUrlContent, a> {
        public Integer d;
        public String e;
        public Integer f;
        public Integer g;
        public String h;
        public String i;
        public ImageSet j;
        public Boolean k;
        public Boolean l;
        public ImageSet m;
        public PreviewVideo n;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new PreviewUrlContent(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<PreviewUrlContent> {
        @Override // com.lark.wire.ProtoAdapter
        public final PreviewUrlContent c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L19;
            switch(r4) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
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
        L7:
            r1.n = PreviewVideo.ADAPTER.c(r7);
            goto L3
        L8:
            r1.m = ImageSet.ADAPTER.c(r7);
            goto L3
        L9:
            r1.l = (Boolean) ProtoAdapter.g.c(r7);
            goto L3
        L10:
            r1.k = (Boolean) ProtoAdapter.g.c(r7);
            goto L3
        L11:
            r1.j = ImageSet.ADAPTER.c(r7);
            goto L3
        L12:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.i = r7.i();
            goto L3
        L13:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.h = r7.i();
            goto L3
        L14:
            r1.g = Integer.valueOf(((Number) ProtoAdapter.h.c(r7)).intValue());
            goto L3
        L15:
            r1.f = Integer.valueOf(((Number) ProtoAdapter.h.c(r7)).intValue());
            goto L3
        L16:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            String r5 = r7.i();
            Intrinsics.checkNotNullParameter(r5, "url");
            r1.e = r5;
            goto L3
        L17:
            r1.d = Integer.valueOf(((Number) ProtoAdapter.h.c(r7)).intValue());
            goto L3
        L6:
            r7.j(r4);
            Unit r6 = Unit.INSTANCE;
            goto L3
        L19:
            return new PreviewUrlContent(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(PreviewUrlContent r6) {
            PreviewUrlContent r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            s r1 = ProtoAdapter.h;
            int r2 = r0 + r1.l(1, Integer.valueOf(r7.getSequence_id()));
            w r3 = ProtoAdapter.q;
            int r4 = ((((r2 + r3.l(2, r7.getUrl())) + r1.l(3, Integer.valueOf(r7.getOffset()))) + r1.l(4, Integer.valueOf(r7.getCount()))) + r3.l(5, r7.getTitle())) + r3.l(6, r7.getSummary());
            ProtoAdapter<ImageSet> r5 = ImageSet.ADAPTER;
            int r8 = r4 + r5.l(7, r7.getIcon());
            l r9 = ProtoAdapter.g;
            return (((r8 + r9.l(8, r7.is_hidden())) + r9.l(9, r7.getHas_preview())) + r5.l(10, r7.getCover_image())) + PreviewVideo.ADAPTER.l(11, r7.getVideo_info());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, PreviewUrlContent r6) {
            PreviewUrlContent r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            s r0 = ProtoAdapter.h;
            r0.i(r5, 1, Integer.valueOf(r7.getSequence_id()));
            w r1 = ProtoAdapter.q;
            r1.i(r5, 2, r7.getUrl());
            r0.i(r5, 3, Integer.valueOf(r7.getOffset()));
            r0.i(r5, 4, Integer.valueOf(r7.getCount()));
            r1.i(r5, 5, r7.getTitle());
            r1.i(r5, 6, r7.getSummary());
            ProtoAdapter<ImageSet> r2 = ImageSet.ADAPTER;
            r2.i(r5, 7, r7.getIcon());
            l r3 = ProtoAdapter.g;
            r3.i(r5, 8, r7.is_hidden());
            r3.i(r5, 9, r7.getHas_preview());
            r2.i(r5, 10, r7.getCover_image());
            PreviewVideo.ADAPTER.i(r5, 11, r7.getVideo_info());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, PreviewUrlContent r6) {
            PreviewUrlContent r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            PreviewVideo.ADAPTER.j(r5, 11, r7.getVideo_info());
            ProtoAdapter<ImageSet> r0 = ImageSet.ADAPTER;
            r0.j(r5, 10, r7.getCover_image());
            l r1 = ProtoAdapter.g;
            r1.j(r5, 9, r7.getHas_preview());
            r1.j(r5, 8, r7.is_hidden());
            r0.j(r5, 7, r7.getIcon());
            w r2 = ProtoAdapter.q;
            r2.j(r5, 6, r7.getSummary());
            r2.j(r5, 5, r7.getTitle());
            s r3 = ProtoAdapter.h;
            r3.j(r5, 4, Integer.valueOf(r7.getCount()));
            r3.j(r5, 3, Integer.valueOf(r7.getOffset()));
            r2.j(r5, 2, r7.getUrl());
            r3.j(r5, 1, Integer.valueOf(r7.getSequence_id()));
        }

        public b(FieldEncoding r7, KClass<PreviewUrlContent> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.PreviewUrlContent", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ PreviewUrlContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PreviewUrlContent.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = Integer.valueOf(this.sequence_id);
        r0.e = this.url;
        r0.f = Integer.valueOf(this.offset);
        r0.g = Integer.valueOf(this.count);
        r0.h = this.title;
        r0.i = this.summary;
        r0.j = this.icon;
        r0.k = this.is_hidden;
        r0.l = this.has_preview;
        r0.m = this.cover_image;
        r0.n = this.video_info;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(PreviewUrlContent.class).getSimpleName() + '@' + hashCode();
    }

    public final int getCount() {
        return this.count;
    }

    public final ImageSet getCover_image() {
        return this.cover_image;
    }

    public final Boolean getHas_preview() {
        return this.has_preview;
    }

    public final ImageSet getIcon() {
        return this.icon;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final int getSequence_id() {
        return this.sequence_id;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final PreviewVideo getVideo_info() {
        return this.video_info;
    }

    public final Boolean is_hidden() {
        return this.is_hidden;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public PreviewUrlContent(a r2, ByteString r3) {
        super(ADAPTER, r3);
        Integer r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.sequence_id = r4.intValue();
        String r5 = r2.e;
        Intrinsics.checkNotNull(r5);
        this.url = r5;
        Integer r6 = r2.f;
        Intrinsics.checkNotNull(r6);
        this.offset = r6.intValue();
        Integer r7 = r2.g;
        Intrinsics.checkNotNull(r7);
        this.count = r7.intValue();
        this.title = r2.h;
        this.summary = r2.i;
        this.icon = r2.j;
        this.is_hidden = r2.k;
        this.has_preview = r2.l;
        this.cover_image = r2.m;
        this.video_info = r2.n;
    }

    public /* synthetic */ PreviewUrlContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
