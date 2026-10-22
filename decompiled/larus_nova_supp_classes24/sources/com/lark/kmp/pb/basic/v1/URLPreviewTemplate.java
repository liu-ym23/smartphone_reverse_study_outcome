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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002$%B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\"\u001a\u00020\u0002H\u0016J\b\u0010#\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 ¨\u0006&"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewTemplate;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewTemplate$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewTemplate$Builder;Lokio/ByteString;)V", "template_id", "", "getTemplate_id", "()Ljava/lang/String;", "root_component_id", "getRoot_component_id", "elements", "", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent;", "getElements", "()Ljava/util/Map;", "image_ids", "", "getImage_ids", "()Ljava/util/List;", "at_ids", "getAt_ids", "button_ids", "getButton_ids", "richtext_ids", "getRichtext_ids", "expires", "", "getExpires", "()Ljava/lang/Long;", "Ljava/lang/Long;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class URLPreviewTemplate extends com.lark.wire.Message<URLPreviewTemplate, a> {
    public static final ProtoAdapter<URLPreviewTemplate> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final List<String> at_ids;
    private final List<String> button_ids;
    private final Map<String, URLPreviewComponent> elements;
    private final Long expires;
    private final List<String> image_ids;
    private final List<String> richtext_ids;
    private final String root_component_id;
    private final String template_id;

    public static final class a extends com.lark.wire.Message.a<URLPreviewTemplate, a> {
        public String d;
        public String e;
        public Map<String, URLPreviewComponent> f;
        public List<String> g;
        public List<String> h;
        public List<String> i;
        public List<String> j;
        public Long k;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new URLPreviewTemplate(this, c(), null);
        }

        public a() {
            this.f = MapsKt.emptyMap();
            this.g = CollectionsKt.emptyList();
            this.h = CollectionsKt.emptyList();
            this.i = CollectionsKt.emptyList();
            this.j = CollectionsKt.emptyList();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ URLPreviewTemplate(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(URLPreviewTemplate.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new URLPreviewTemplate$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.template_id;
        r0.e = this.root_component_id;
        r0.f = this.elements;
        r0.g = this.image_ids;
        r0.h = this.at_ids;
        r0.i = this.button_ids;
        r0.j = this.richtext_ids;
        r0.k = this.expires;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(URLPreviewTemplate.class).getSimpleName() + '@' + hashCode();
    }

    public final List<String> getAt_ids() {
        return this.at_ids;
    }

    public final List<String> getButton_ids() {
        return this.button_ids;
    }

    public final Map<String, URLPreviewComponent> getElements() {
        return this.elements;
    }

    public final Long getExpires() {
        return this.expires;
    }

    public final List<String> getImage_ids() {
        return this.image_ids;
    }

    public final List<String> getRichtext_ids() {
        return this.richtext_ids;
    }

    public final String getRoot_component_id() {
        return this.root_component_id;
    }

    public final String getTemplate_id() {
        return this.template_id;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public URLPreviewTemplate(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.template_id = r2.d;
        this.root_component_id = r2.e;
        this.elements = com.lark.wire.internal.a.d("elements", r2.f);
        this.image_ids = com.lark.wire.internal.a.c("image_ids", r2.g);
        this.at_ids = com.lark.wire.internal.a.c("at_ids", r2.h);
        this.button_ids = com.lark.wire.internal.a.c("button_ids", r2.i);
        this.richtext_ids = com.lark.wire.internal.a.c("richtext_ids", r2.j);
        this.expires = r2.k;
    }

    public /* synthetic */ URLPreviewTemplate(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
