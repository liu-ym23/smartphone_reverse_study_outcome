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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u0000 /2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002./B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010,\u001a\u00020\u0002H\u0016J\b\u0010-\u001a\u00020\nH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\fR\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\fR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\fR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\fR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\fR\u0015\u0010&\u001a\u0004\u0018\u00010\u001c¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b'\u0010\u001eR\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\fR\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\f¨\u00060"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichText;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichText$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichText$Builder;Lokio/ByteString;)V", "element_ids", "", "", "getElement_ids", "()Ljava/util/List;", "inner_text", "getInner_text", "()Ljava/lang/String;", "elements", "", "Lcom/lark/kmp/pb/basic/v1/RichTextElement;", "getElements", "()Ljava/util/Map;", "image_ids", "getImage_ids", "at_ids", "getAt_ids", "anchor_ids", "getAnchor_ids", "version", "", "getVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "media_ids", "getMedia_ids", "docs_ids", "getDocs_ids", "mention_ids", "getMention_ids", "rich_text_version", "getRich_text_version", "at_user_group_ids", "getAt_user_group_ids", "markdown_ids", "getMarkdown_ids", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class RichText extends com.lark.wire.Message<RichText, a> {
    public static final ProtoAdapter<RichText> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final List<String> anchor_ids;
    private final List<String> at_ids;
    private final List<String> at_user_group_ids;
    private final List<String> docs_ids;
    private final List<String> element_ids;
    private final Map<String, RichTextElement> elements;
    private final List<String> image_ids;
    private final String inner_text;
    private final List<String> markdown_ids;
    private final List<String> media_ids;
    private final List<String> mention_ids;
    private final Integer rich_text_version;
    private final Integer version;

    public static final class a extends com.lark.wire.Message.a<RichText, a> {
        public List<String> d;
        public String e;
        public Map<String, RichTextElement> f;
        public List<String> g;
        public List<String> h;
        public List<String> i;
        public Integer j;
        public List<String> k;
        public List<String> l;
        public List<String> m;
        public Integer n;
        public List<String> o;
        public List<String> p;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new RichText(this, c(), null);
        }

        public a() {
            this.d = CollectionsKt.emptyList();
            this.f = MapsKt.emptyMap();
            this.g = CollectionsKt.emptyList();
            this.h = CollectionsKt.emptyList();
            this.i = CollectionsKt.emptyList();
            this.k = CollectionsKt.emptyList();
            this.l = CollectionsKt.emptyList();
            this.m = CollectionsKt.emptyList();
            this.o = CollectionsKt.emptyList();
            this.p = CollectionsKt.emptyList();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ RichText(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(RichText.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new RichText$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.element_ids;
        r0.e = this.inner_text;
        r0.f = this.elements;
        r0.g = this.image_ids;
        r0.h = this.at_ids;
        r0.i = this.anchor_ids;
        r0.j = this.version;
        r0.k = this.media_ids;
        r0.l = this.docs_ids;
        r0.m = this.mention_ids;
        r0.n = this.rich_text_version;
        r0.o = this.at_user_group_ids;
        r0.p = this.markdown_ids;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(RichText.class).getSimpleName() + '@' + hashCode();
    }

    public final List<String> getAnchor_ids() {
        return this.anchor_ids;
    }

    public final List<String> getAt_ids() {
        return this.at_ids;
    }

    public final List<String> getAt_user_group_ids() {
        return this.at_user_group_ids;
    }

    public final List<String> getDocs_ids() {
        return this.docs_ids;
    }

    public final List<String> getElement_ids() {
        return this.element_ids;
    }

    public final Map<String, RichTextElement> getElements() {
        return this.elements;
    }

    public final List<String> getImage_ids() {
        return this.image_ids;
    }

    public final String getInner_text() {
        return this.inner_text;
    }

    public final List<String> getMarkdown_ids() {
        return this.markdown_ids;
    }

    public final List<String> getMedia_ids() {
        return this.media_ids;
    }

    public final List<String> getMention_ids() {
        return this.mention_ids;
    }

    public final Integer getRich_text_version() {
        return this.rich_text_version;
    }

    public final Integer getVersion() {
        return this.version;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public RichText(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.element_ids = com.lark.wire.internal.a.c("element_ids", r2.d);
        String r4 = r2.e;
        Intrinsics.checkNotNull(r4);
        this.inner_text = r4;
        this.elements = com.lark.wire.internal.a.d("elements", r2.f);
        this.image_ids = com.lark.wire.internal.a.c("image_ids", r2.g);
        this.at_ids = com.lark.wire.internal.a.c("at_ids", r2.h);
        this.anchor_ids = com.lark.wire.internal.a.c("anchor_ids", r2.i);
        this.version = r2.j;
        this.media_ids = com.lark.wire.internal.a.c("media_ids", r2.k);
        this.docs_ids = com.lark.wire.internal.a.c("docs_ids", r2.l);
        this.mention_ids = com.lark.wire.internal.a.c("mention_ids", r2.m);
        this.rich_text_version = r2.n;
        this.at_user_group_ids = com.lark.wire.internal.a.c("at_user_group_ids", r2.o);
        this.markdown_ids = com.lark.wire.internal.a.c("markdown_ids", r2.p);
    }

    public /* synthetic */ RichText(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
