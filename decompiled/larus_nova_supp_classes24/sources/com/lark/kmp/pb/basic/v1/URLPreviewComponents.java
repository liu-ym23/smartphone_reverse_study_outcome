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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\fR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponents;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponents$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponents$Builder;Lokio/ByteString;)V", "root_ids", "", "", "getRoot_ids", "()Ljava/util/List;", "elements", "", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent;", "getElements", "()Ljava/util/Map;", "image_ids", "getImage_ids", "at_ids", "getAt_ids", "button_ids", "getButton_ids", "richtext_ids", "getRichtext_ids", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class URLPreviewComponents extends com.lark.wire.Message<URLPreviewComponents, a> {
    public static final ProtoAdapter<URLPreviewComponents> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final List<String> at_ids;
    private final List<String> button_ids;
    private final Map<String, URLPreviewComponent> elements;
    private final List<String> image_ids;
    private final List<String> richtext_ids;
    private final List<String> root_ids;

    public static final class a extends com.lark.wire.Message.a<URLPreviewComponents, a> {
        public List<String> d;
        public Map<String, URLPreviewComponent> e;
        public List<String> f;
        public List<String> g;
        public List<String> h;
        public List<String> i;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new URLPreviewComponents(this, c(), null);
        }

        public a() {
            this.d = CollectionsKt.emptyList();
            this.e = MapsKt.emptyMap();
            this.f = CollectionsKt.emptyList();
            this.g = CollectionsKt.emptyList();
            this.h = CollectionsKt.emptyList();
            this.i = CollectionsKt.emptyList();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ URLPreviewComponents(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(URLPreviewComponents.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new URLPreviewComponents$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.root_ids;
        r0.e = this.elements;
        r0.f = this.image_ids;
        r0.g = this.at_ids;
        r0.h = this.button_ids;
        r0.i = this.richtext_ids;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(URLPreviewComponents.class).getSimpleName() + '@' + hashCode();
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

    public final List<String> getImage_ids() {
        return this.image_ids;
    }

    public final List<String> getRichtext_ids() {
        return this.richtext_ids;
    }

    public final List<String> getRoot_ids() {
        return this.root_ids;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public URLPreviewComponents(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.root_ids = com.lark.wire.internal.a.c("root_ids", r2.d);
        this.elements = com.lark.wire.internal.a.d("elements", r2.e);
        this.image_ids = com.lark.wire.internal.a.c("image_ids", r2.f);
        this.at_ids = com.lark.wire.internal.a.c("at_ids", r2.g);
        this.button_ids = com.lark.wire.internal.a.c("button_ids", r2.h);
        this.richtext_ids = com.lark.wire.internal.a.c("richtext_ids", r2.i);
    }

    public /* synthetic */ URLPreviewComponents(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
