package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/EditMessageContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/EditMessageContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/EditMessageContent$Builder;Lokio/ByteString;)V", "rich_text", "Lcom/lark/kmp/pb/basic/v1/RichText;", "getRich_text", "()Lcom/lark/kmp/pb/basic/v1/RichText;", "title", "", "getTitle", "()Ljava/lang/String;", "lingo_option", "Lcom/lark/kmp/pb/basic/v1/LingoOption;", "getLingo_option", "()Lcom/lark/kmp/pb/basic/v1/LingoOption;", "url_preview_hang_point_map", "", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewHangPoint;", "getUrl_preview_hang_point_map", "()Ljava/util/Map;", "attachment_update", "Lcom/lark/kmp/pb/basic/v1/EditMessageAttachmentUpdate;", "getAttachment_update", "()Lcom/lark/kmp/pb/basic/v1/EditMessageAttachmentUpdate;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class EditMessageContent extends com.lark.wire.Message<EditMessageContent, a> {
    public static final ProtoAdapter<EditMessageContent> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final EditMessageAttachmentUpdate attachment_update;
    private final LingoOption lingo_option;
    private final RichText rich_text;
    private final String title;
    private final Map<String, UrlPreviewHangPoint> url_preview_hang_point_map;

    public static final class a extends com.lark.wire.Message.a<EditMessageContent, a> {
        public RichText d;
        public String e;
        public LingoOption f;
        public Map<String, UrlPreviewHangPoint> g;
        public EditMessageAttachmentUpdate h;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new EditMessageContent(this, c(), null);
        }

        public a() {
            this.g = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ EditMessageContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(EditMessageContent.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new EditMessageContent$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.rich_text;
        r0.e = this.title;
        r0.f = this.lingo_option;
        r0.g = this.url_preview_hang_point_map;
        r0.h = this.attachment_update;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(EditMessageContent.class).getSimpleName() + '@' + hashCode();
    }

    public final EditMessageAttachmentUpdate getAttachment_update() {
        return this.attachment_update;
    }

    public final LingoOption getLingo_option() {
        return this.lingo_option;
    }

    public final RichText getRich_text() {
        return this.rich_text;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Map<String, UrlPreviewHangPoint> getUrl_preview_hang_point_map() {
        return this.url_preview_hang_point_map;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public EditMessageContent(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.rich_text = r2.d;
        this.title = r2.e;
        this.lingo_option = r2.f;
        this.url_preview_hang_point_map = com.lark.wire.internal.a.d("url_preview_hang_point_map", r2.g);
        this.attachment_update = r2.h;
    }

    public /* synthetic */ EditMessageContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
