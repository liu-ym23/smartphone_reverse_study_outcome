package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002 !B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichContent$Builder;Lokio/ByteString;)V", "rich_text", "Lcom/lark/kmp/pb/basic/v1/RichText;", "getRich_text", "()Lcom/lark/kmp/pb/basic/v1/RichText;", "doc_entity", "Lcom/lark/kmp/pb/basic/v1/DocEntity;", "getDoc_entity", "()Lcom/lark/kmp/pb/basic/v1/DocEntity;", "url_preview_hang_points", "", "", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewHangPoint;", "getUrl_preview_hang_points", "()Ljava/util/Map;", "url_preview_entities", "Lcom/lark/kmp/pb/basic/v1/PreviewEntityPair;", "getUrl_preview_entities", "()Lcom/lark/kmp/pb/basic/v1/PreviewEntityPair;", "fake_preview_ids", "", "getFake_preview_ids", "()Ljava/util/List;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class RichContent extends com.lark.wire.Message<RichContent, a> {
    public static final ProtoAdapter<RichContent> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final DocEntity doc_entity;
    private final List<String> fake_preview_ids;
    private final RichText rich_text;
    private final PreviewEntityPair url_preview_entities;
    private final Map<String, UrlPreviewHangPoint> url_preview_hang_points;

    public static final class a extends com.lark.wire.Message.a<RichContent, a> {
        public RichText d;
        public DocEntity e;
        public Map<String, UrlPreviewHangPoint> f;
        public PreviewEntityPair g;
        public List<String> h;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new RichContent(this, c(), null);
        }

        public a() {
            this.f = MapsKt.emptyMap();
            this.h = CollectionsKt.emptyList();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ RichContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(RichContent.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new RichContent$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.rich_text;
        r0.e = this.doc_entity;
        r0.f = this.url_preview_hang_points;
        r0.g = this.url_preview_entities;
        r0.h = this.fake_preview_ids;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(RichContent.class).getSimpleName() + '@' + hashCode();
    }

    public final DocEntity getDoc_entity() {
        return this.doc_entity;
    }

    public final List<String> getFake_preview_ids() {
        return this.fake_preview_ids;
    }

    public final RichText getRich_text() {
        return this.rich_text;
    }

    public final PreviewEntityPair getUrl_preview_entities() {
        return this.url_preview_entities;
    }

    public final Map<String, UrlPreviewHangPoint> getUrl_preview_hang_points() {
        return this.url_preview_hang_points;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public RichContent(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.rich_text = r2.d;
        this.doc_entity = r2.e;
        this.url_preview_hang_points = com.lark.wire.internal.a.d("url_preview_hang_points", r2.f);
        this.url_preview_entities = r2.g;
        this.fake_preview_ids = com.lark.wire.internal.a.c("fake_preview_ids", r2.h);
    }

    public /* synthetic */ RichContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
