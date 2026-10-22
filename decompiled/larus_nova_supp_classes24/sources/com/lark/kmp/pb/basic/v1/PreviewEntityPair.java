package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR(\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/PreviewEntityPair;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/PreviewEntityPair$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/PreviewEntityPair$Builder;Lokio/ByteString;)V", "preview_entity", "", "", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity;", "getPreview_entity", "()Ljava/util/Map;", "templates", "Lcom/lark/kmp/pb/basic/v1/URLPreviewTemplate;", "getTemplates$annotations", "()V", "getTemplates", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class PreviewEntityPair extends com.lark.wire.Message<PreviewEntityPair, a> {
    public static final ProtoAdapter<PreviewEntityPair> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final Map<String, UrlPreviewEntity> preview_entity;
    private final Map<String, URLPreviewTemplate> templates;

    public static final class a extends com.lark.wire.Message.a<PreviewEntityPair, a> {
        public Map<String, UrlPreviewEntity> d;
        public Map<String, URLPreviewTemplate> e;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new PreviewEntityPair(this, c(), null);
        }

        public a() {
            this.d = MapsKt.emptyMap();
            this.e = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ PreviewEntityPair(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Deprecated(message = "templates is deprecated")
    public static /* synthetic */ void getTemplates$annotations() {
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(PreviewEntityPair.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new PreviewEntityPair$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.preview_entity;
        r0.e = this.templates;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(PreviewEntityPair.class).getSimpleName() + '@' + hashCode();
    }

    public final Map<String, UrlPreviewEntity> getPreview_entity() {
        return this.preview_entity;
    }

    public final Map<String, URLPreviewTemplate> getTemplates() {
        return this.templates;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public PreviewEntityPair(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.preview_entity = com.lark.wire.internal.a.d("preview_entity", r2.d);
        this.templates = com.lark.wire.internal.a.d("templates", r2.e);
    }

    public /* synthetic */ PreviewEntityPair(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
