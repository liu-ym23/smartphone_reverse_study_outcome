package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewPropertyData;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewPropertyData$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewPropertyData$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Type;", "preview_property_data", "", "", "Lcom/lark/kmp/pb/basic/v1/PreviewData;", "getPreview_property_data", "()Ljava/util/Map;", "rich_text", "Lcom/lark/kmp/pb/basic/v1/RichText;", "getRich_text", "()Lcom/lark/kmp/pb/basic/v1/RichText;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class URLPreviewPropertyData extends com.lark.wire.Message<URLPreviewPropertyData, a> {
    public static final ProtoAdapter<URLPreviewPropertyData> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final Map<Integer, PreviewData> preview_property_data;
    private final RichText rich_text;
    private final URLPreviewComponent.Type type;

    public static final class a extends com.lark.wire.Message.a<URLPreviewPropertyData, a> {
        public URLPreviewComponent.Type d;
        public Map<Integer, PreviewData> e;
        public RichText f;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new URLPreviewPropertyData(this, c(), null);
        }

        public a() {
            this.e = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ URLPreviewPropertyData(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(URLPreviewPropertyData.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new URLPreviewPropertyData$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.type;
        r0.e = this.preview_property_data;
        r0.f = this.rich_text;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(URLPreviewPropertyData.class).getSimpleName() + '@' + hashCode();
    }

    public final Map<Integer, PreviewData> getPreview_property_data() {
        return this.preview_property_data;
    }

    public final RichText getRich_text() {
        return this.rich_text;
    }

    public final URLPreviewComponent.Type getType() {
        return this.type;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public URLPreviewPropertyData(a r2, ByteString r3) {
        super(ADAPTER, r3);
        URLPreviewComponent.Type r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.type = r4;
        this.preview_property_data = com.lark.wire.internal.a.d("preview_property_data", r2.e);
        this.rich_text = r2.f;
    }

    public /* synthetic */ URLPreviewPropertyData(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
