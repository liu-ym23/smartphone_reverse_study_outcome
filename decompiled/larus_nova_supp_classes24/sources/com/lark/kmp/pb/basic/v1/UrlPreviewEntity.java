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
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 X2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u000bWXYZ[\\]^_`aB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010U\u001a\u00020\u0002H\u0016J\b\u0010V\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000fR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0015\u0010$\u001a\u0004\u0018\u00010%¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0015\u0010)\u001a\u0004\u0018\u00010*¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0013\u0010.\u001a\u0004\u0018\u00010/¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u00102\u001a\u0004\u0018\u000103¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u00106\u001a\u0004\u0018\u000107¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0015\u0010:\u001a\u0004\u0018\u00010%¢\u0006\n\n\u0002\u0010(\u001a\u0004\b:\u0010'R\u0013\u0010;\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u000fR\u0013\u0010=\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u000fR\u0013\u0010?\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u000fR\u0013\u0010A\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u000fR\u0013\u0010C\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u000fR\u0013\u0010E\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u000fR\u0013\u0010G\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u000fR\u0013\u0010I\u001a\u0004\u0018\u00010J¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0013\u0010M\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\u000fR\u0015\u0010O\u001a\u0004\u0018\u00010%¢\u0006\n\n\u0002\u0010(\u001a\u0004\bP\u0010'R\u0013\u0010Q\u001a\u0004\u0018\u00010R¢\u0006\b\n\u0000\u001a\u0004\bS\u0010T¨\u0006b"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$Builder;Lokio/ByteString;)V", "app_info", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$AppInfo;", "getApp_info", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$AppInfo;", "source_id", "", "getSource_id", "()Ljava/lang/String;", "preview_id", "getPreview_id", "url", "Lcom/lark/kmp/pb/basic/v1/URL;", "getUrl", "()Lcom/lark/kmp/pb/basic/v1/URL;", "server_icon_key", "getServer_icon_key", "server_title", "getServer_title", "server_tag", "getServer_tag", "ud_icon", "Lcom/lark/kmp/pb/basic/v1/UDIcon;", "getUd_icon", "()Lcom/lark/kmp/pb/basic/v1/UDIcon;", "server_icon_image", "Lcom/lark/kmp/pb/basic/v1/ImageSetPassThrough;", "getServer_icon_image", "()Lcom/lark/kmp/pb/basic/v1/ImageSetPassThrough;", "use_color_icon", "", "getUse_color_icon", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "version", "", "getVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "preview_body", "Lcom/lark/kmp/pb/basic/v1/URLPreviewBody;", "getPreview_body", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewBody;", "render_router_entity", "Lcom/lark/kmp/pb/basic/v1/RenderRouterEntity;", "getRender_router_entity", "()Lcom/lark/kmp/pb/basic/v1/RenderRouterEntity;", "unified_header", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$UnifiedHeader;", "getUnified_header", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$UnifiedHeader;", "is_sdk_preview", "sdk_icon_url", "getSdk_icon_url", "sdk_title", "getSdk_title", "sdk_description", "getSdk_description", "sdk_favicon_url", "getSdk_favicon_url", "sdk_domain", "getSdk_domain", "sdk_iframe_url", "getSdk_iframe_url", "sdk_site_name", "getSdk_site_name", "sdk_site_type", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$VideoProperty$Site;", "getSdk_site_type", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$VideoProperty$Site;", "sdk_video_id", "getSdk_video_id", "need_reload", "getNeed_reload", "ext_info", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$ExtInfo;", "getExt_info", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$ExtInfo;", "newBuilder", "toString", "Builder", "Companion", "ColorIcon", "UnifiedHeader", "AppInfo", "LastUpdateInfo", "TranslateInfo", "SingleCardMode", "DocInfo", "ComponentRootDisplayVariant", "ExtInfo", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UrlPreviewEntity extends com.lark.wire.Message<UrlPreviewEntity, a> {
    public static final ProtoAdapter<UrlPreviewEntity> ADAPTER = null;
    public static final c Companion = null;
    public static final boolean DEFAULT_IS_SDK_PREVIEW = false;
    public static final boolean DEFAULT_NEED_RELOAD = false;
    public static final URLPreviewComponent.VideoProperty.Site DEFAULT_SDK_SITE_TYPE = null;
    public static final boolean DEFAULT_USE_COLOR_ICON = false;
    private static final long serialVersionUID = 0;
    private final AppInfo app_info;
    private final ExtInfo ext_info;
    private final Boolean is_sdk_preview;
    private final Boolean need_reload;
    private final URLPreviewBody preview_body;
    private final String preview_id;
    private final RenderRouterEntity render_router_entity;
    private final String sdk_description;
    private final String sdk_domain;
    private final String sdk_favicon_url;
    private final String sdk_icon_url;
    private final String sdk_iframe_url;
    private final String sdk_site_name;
    private final URLPreviewComponent.VideoProperty.Site sdk_site_type;
    private final String sdk_title;
    private final String sdk_video_id;
    private final ImageSetPassThrough server_icon_image;
    private final String server_icon_key;
    private final String server_tag;
    private final String server_title;
    private final String source_id;
    private final UDIcon ud_icon;
    private final UnifiedHeader unified_header;
    private final URL url;
    private final Boolean use_color_icon;
    private final Integer version;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$AppInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$AppInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$AppInfo$Builder;Lokio/ByteString;)V", "app_id", "", "getApp_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "scene_type", "getScene_type", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class AppInfo extends com.lark.wire.Message<AppInfo, a> {
        public static final ProtoAdapter<AppInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Long app_id;
        private final Long scene_type;

        public static final class a extends com.lark.wire.Message.a<AppInfo, a> {
            public Long d;
            public Long e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new AppInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<AppInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final AppInfo c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L13;
                if (r3 != 1) goto L8;
                r0.d = (Long) ProtoAdapter.k.c(r6);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.e = (Long) ProtoAdapter.k.c(r6);
                goto L3
            L9:
                r6.j(r3);
                Unit r4 = Unit.INSTANCE;
                goto L3
            L13:
                return new AppInfo(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(AppInfo r5) {
                AppInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                t r1 = ProtoAdapter.k;
                return (r0 + r1.l(1, r6.getApp_id())) + r1.l(2, r6.getScene_type());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, AppInfo r5) {
                AppInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                t r0 = ProtoAdapter.k;
                r0.i(r4, 1, r6.getApp_id());
                r0.i(r4, 2, r6.getScene_type());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, AppInfo r5) {
                AppInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                t r0 = ProtoAdapter.k;
                r0.j(r4, 2, r6.getScene_type());
                r0.j(r4, 1, r6.getApp_id());
            }

            public b(FieldEncoding r7, KClass<AppInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.UrlPreviewEntity.AppInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ AppInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AppInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.app_id;
            r0.e = this.scene_type;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(AppInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final Long getApp_id() {
            return this.app_id;
        }

        public final Long getScene_type() {
            return this.scene_type;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public AppInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.app_id = r2.d;
            this.scene_type = r2.e;
        }

        public /* synthetic */ AppInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$ColorIcon;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$ColorIcon$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$ColorIcon$Builder;Lokio/ByteString;)V", "icon", "Lcom/lark/kmp/pb/basic/v1/ImageSet;", "getIcon", "()Lcom/lark/kmp/pb/basic/v1/ImageSet;", "favicon_url", "", "getFavicon_url", "()Ljava/lang/String;", "icon_color", "Lcom/lark/kmp/pb/basic/v1/ThemeColor;", "getIcon_color", "()Lcom/lark/kmp/pb/basic/v1/ThemeColor;", "ud_icon", "Lcom/lark/kmp/pb/basic/v1/UDIcon;", "getUd_icon", "()Lcom/lark/kmp/pb/basic/v1/UDIcon;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ColorIcon extends com.lark.wire.Message<ColorIcon, a> {
        public static final ProtoAdapter<ColorIcon> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String favicon_url;
        private final ImageSet icon;
        private final ThemeColor icon_color;
        private final UDIcon ud_icon;

        public static final class a extends com.lark.wire.Message.a<ColorIcon, a> {
            public ImageSet d;
            public String e;
            public ThemeColor f;
            public UDIcon g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ColorIcon(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ColorIcon> {
            @Override // com.lark.wire.ProtoAdapter
            public final ColorIcon c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L19;
                if (r4 != 1) goto L8;
                r1.d = ImageSet.ADAPTER.c(r7);
                goto L3
            L8:
                if (r4 != 2) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L10:
                if (r4 != 3) goto L12;
                r1.f = ThemeColor.ADAPTER.c(r7);
                goto L3
            L12:
                if (r4 != 4) goto L13;
                r1.g = UDIcon.ADAPTER.c(r7);
                goto L3
            L13:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L19:
                return new ColorIcon(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ColorIcon r5) {
                ColorIcon r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (((r6.unknownFields().size() + ImageSet.ADAPTER.l(1, r6.getIcon())) + ProtoAdapter.q.l(2, r6.getFavicon_url())) + ThemeColor.ADAPTER.l(3, r6.getIcon_color())) + UDIcon.ADAPTER.l(4, r6.getUd_icon());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, ColorIcon r5) {
                ColorIcon r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ImageSet.ADAPTER.i(r4, 1, r6.getIcon());
                ProtoAdapter.q.i(r4, 2, r6.getFavicon_url());
                ThemeColor.ADAPTER.i(r4, 3, r6.getIcon_color());
                UDIcon.ADAPTER.i(r4, 4, r6.getUd_icon());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, ColorIcon r5) {
                ColorIcon r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                UDIcon.ADAPTER.j(r4, 4, r6.getUd_icon());
                ThemeColor.ADAPTER.j(r4, 3, r6.getIcon_color());
                ProtoAdapter.q.j(r4, 2, r6.getFavicon_url());
                ImageSet.ADAPTER.j(r4, 1, r6.getIcon());
            }

            public b(FieldEncoding r7, KClass<ColorIcon> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.UrlPreviewEntity.ColorIcon", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ColorIcon(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ColorIcon.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.icon;
            r0.e = this.favicon_url;
            r0.f = this.icon_color;
            r0.g = this.ud_icon;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ColorIcon.class).getSimpleName() + '@' + hashCode();
        }

        public final String getFavicon_url() {
            return this.favicon_url;
        }

        public final ImageSet getIcon() {
            return this.icon;
        }

        public final ThemeColor getIcon_color() {
            return this.icon_color;
        }

        public final UDIcon getUd_icon() {
            return this.ud_icon;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ColorIcon(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.icon = r2.d;
            this.favicon_url = r2.e;
            this.icon_color = r2.f;
            this.ud_icon = r2.g;
        }

        public /* synthetic */ ColorIcon(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$ComponentRootDisplayVariant;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$ComponentRootDisplayVariant$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$ComponentRootDisplayVariant$Builder;Lokio/ByteString;)V", "default_root_id", "", "getDefault_root_id", "()Ljava/lang/String;", "compact_root_id", "getCompact_root_id", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ComponentRootDisplayVariant extends com.lark.wire.Message<ComponentRootDisplayVariant, a> {
        public static final ProtoAdapter<ComponentRootDisplayVariant> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String compact_root_id;
        private final String default_root_id;

        public static final class a extends com.lark.wire.Message.a<ComponentRootDisplayVariant, a> {
            public String d;
            public String e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ComponentRootDisplayVariant(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ComponentRootDisplayVariant> {
            @Override // com.lark.wire.ProtoAdapter
            public final ComponentRootDisplayVariant c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L13;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.i();
                goto L3
            L8:
                if (r4 != 2) goto L9;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L9:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L13:
                return new ComponentRootDisplayVariant(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ComponentRootDisplayVariant r5) {
                ComponentRootDisplayVariant r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return (r0 + r1.l(1, r6.getDefault_root_id())) + r1.l(2, r6.getCompact_root_id());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, ComponentRootDisplayVariant r5) {
                ComponentRootDisplayVariant r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getDefault_root_id());
                r0.i(r4, 2, r6.getCompact_root_id());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, ComponentRootDisplayVariant r5) {
                ComponentRootDisplayVariant r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 2, r6.getCompact_root_id());
                r0.j(r4, 1, r6.getDefault_root_id());
            }

            public b(FieldEncoding r7, KClass<ComponentRootDisplayVariant> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.UrlPreviewEntity.ComponentRootDisplayVariant", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ComponentRootDisplayVariant(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ComponentRootDisplayVariant.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.default_root_id;
            r0.e = this.compact_root_id;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ComponentRootDisplayVariant.class).getSimpleName() + '@' + hashCode();
        }

        public final String getCompact_root_id() {
            return this.compact_root_id;
        }

        public final String getDefault_root_id() {
            return this.default_root_id;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ComponentRootDisplayVariant(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.default_root_id = r2.d;
            this.compact_root_id = r2.e;
        }

        public /* synthetic */ ComponentRootDisplayVariant(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$DocInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$DocInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$DocInfo$Builder;Lokio/ByteString;)V", "file_token", "", "getFile_token", "()Ljava/lang/String;", "mount_point", "getMount_point", "file_name", "getFile_name", "file_type", "", "getFile_type", "()Ljava/lang/Long;", "Ljava/lang/Long;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class DocInfo extends com.lark.wire.Message<DocInfo, a> {
        public static final ProtoAdapter<DocInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String file_name;
        private final String file_token;
        private final Long file_type;
        private final String mount_point;

        public static final class a extends com.lark.wire.Message.a<DocInfo, a> {
            public String d;
            public String e;
            public String f;
            public Long g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new DocInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<DocInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final DocInfo c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L19;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.i();
                goto L3
            L8:
                if (r4 != 2) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L10:
                if (r4 != 3) goto L12;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.f = r7.i();
                goto L3
            L12:
                if (r4 != 4) goto L13;
                r1.g = (Long) ProtoAdapter.k.c(r7);
                goto L3
            L13:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L19:
                return new DocInfo(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(DocInfo r5) {
                DocInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return (((r0 + r1.l(1, r6.getFile_token())) + r1.l(2, r6.getMount_point())) + r1.l(3, r6.getFile_name())) + ProtoAdapter.k.l(4, r6.getFile_type());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, DocInfo r5) {
                DocInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getFile_token());
                r0.i(r4, 2, r6.getMount_point());
                r0.i(r4, 3, r6.getFile_name());
                ProtoAdapter.k.i(r4, 4, r6.getFile_type());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, DocInfo r5) {
                DocInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.k.j(r4, 4, r6.getFile_type());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 3, r6.getFile_name());
                r0.j(r4, 2, r6.getMount_point());
                r0.j(r4, 1, r6.getFile_token());
            }

            public b(FieldEncoding r7, KClass<DocInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.UrlPreviewEntity.DocInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ DocInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(DocInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.file_token;
            r0.e = this.mount_point;
            r0.f = this.file_name;
            r0.g = this.file_type;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(DocInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final String getFile_name() {
            return this.file_name;
        }

        public final String getFile_token() {
            return this.file_token;
        }

        public final Long getFile_type() {
            return this.file_type;
        }

        public final String getMount_point() {
            return this.mount_point;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public DocInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.file_token = r2.d;
            this.mount_point = r2.e;
            this.file_name = r2.f;
            this.file_type = r2.g;
        }

        public /* synthetic */ DocInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$ExtInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$ExtInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$ExtInfo$Builder;Lokio/ByteString;)V", "last_update_info", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$LastUpdateInfo;", "getLast_update_info", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$LastUpdateInfo;", "translate_info", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$TranslateInfo;", "getTranslate_info", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$TranslateInfo;", "single_card_mode", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$SingleCardMode;", "getSingle_card_mode", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$SingleCardMode;", "doc_info", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$DocInfo;", "getDoc_info", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$DocInfo;", "component_root_display_variant", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$ComponentRootDisplayVariant;", "getComponent_root_display_variant", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$ComponentRootDisplayVariant;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ExtInfo extends com.lark.wire.Message<ExtInfo, a> {
        public static final ProtoAdapter<ExtInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final ComponentRootDisplayVariant component_root_display_variant;
        private final DocInfo doc_info;
        private final LastUpdateInfo last_update_info;
        private final SingleCardMode single_card_mode;
        private final TranslateInfo translate_info;

        public static final class a extends com.lark.wire.Message.a<ExtInfo, a> {
            public LastUpdateInfo d;
            public TranslateInfo e;
            public SingleCardMode f;
            public DocInfo g;
            public ComponentRootDisplayVariant h;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ExtInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ExtInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final ExtInfo c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L25;
                if (r3 != 1) goto L8;
                r0.d = LastUpdateInfo.ADAPTER.c(r9);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.e = TranslateInfo.ADAPTER.c(r9);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.f = SingleCardMode.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
            L20:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L12:
                if (r3 != 4) goto L14;
                r0.g = DocInfo.ADAPTER.c(r9);
                goto L3
            L14:
                if (r3 != 5) goto L15;
                r0.h = ComponentRootDisplayVariant.ADAPTER.c(r9);
                goto L3
            L15:
                r9.j(r3);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L25:
                return new ExtInfo(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ExtInfo r5) {
                ExtInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return ((((r6.unknownFields().size() + LastUpdateInfo.ADAPTER.l(1, r6.getLast_update_info())) + TranslateInfo.ADAPTER.l(2, r6.getTranslate_info())) + SingleCardMode.ADAPTER.l(3, r6.getSingle_card_mode())) + DocInfo.ADAPTER.l(4, r6.getDoc_info())) + ComponentRootDisplayVariant.ADAPTER.l(5, r6.getComponent_root_display_variant());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, ExtInfo r5) {
                ExtInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                LastUpdateInfo.ADAPTER.i(r4, 1, r6.getLast_update_info());
                TranslateInfo.ADAPTER.i(r4, 2, r6.getTranslate_info());
                SingleCardMode.ADAPTER.i(r4, 3, r6.getSingle_card_mode());
                DocInfo.ADAPTER.i(r4, 4, r6.getDoc_info());
                ComponentRootDisplayVariant.ADAPTER.i(r4, 5, r6.getComponent_root_display_variant());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, ExtInfo r5) {
                ExtInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ComponentRootDisplayVariant.ADAPTER.j(r4, 5, r6.getComponent_root_display_variant());
                DocInfo.ADAPTER.j(r4, 4, r6.getDoc_info());
                SingleCardMode.ADAPTER.j(r4, 3, r6.getSingle_card_mode());
                TranslateInfo.ADAPTER.j(r4, 2, r6.getTranslate_info());
                LastUpdateInfo.ADAPTER.j(r4, 1, r6.getLast_update_info());
            }

            public b(FieldEncoding r7, KClass<ExtInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.UrlPreviewEntity.ExtInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ExtInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ExtInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.last_update_info;
            r0.e = this.translate_info;
            r0.f = this.single_card_mode;
            r0.g = this.doc_info;
            r0.h = this.component_root_display_variant;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ExtInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final ComponentRootDisplayVariant getComponent_root_display_variant() {
            return this.component_root_display_variant;
        }

        public final DocInfo getDoc_info() {
            return this.doc_info;
        }

        public final LastUpdateInfo getLast_update_info() {
            return this.last_update_info;
        }

        public final SingleCardMode getSingle_card_mode() {
            return this.single_card_mode;
        }

        public final TranslateInfo getTranslate_info() {
            return this.translate_info;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ExtInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.last_update_info = r2.d;
            this.translate_info = r2.e;
            this.single_card_mode = r2.f;
            this.doc_info = r2.g;
            this.component_root_display_variant = r2.h;
        }

        public /* synthetic */ ExtInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$LastUpdateInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$LastUpdateInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$LastUpdateInfo$Builder;Lokio/ByteString;)V", "text_color", "Lcom/lark/kmp/pb/basic/v1/ThemeColor;", "getText_color", "()Lcom/lark/kmp/pb/basic/v1/ThemeColor;", "last_update_timestamp", "", "getLast_update_timestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "visible", "", "getVisible", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class LastUpdateInfo extends com.lark.wire.Message<LastUpdateInfo, a> {
        public static final ProtoAdapter<LastUpdateInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Long last_update_timestamp;
        private final ThemeColor text_color;
        private final Boolean visible;

        public static final class a extends com.lark.wire.Message.a<LastUpdateInfo, a> {
            public ThemeColor d;
            public Long e;
            public Boolean f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new LastUpdateInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<LastUpdateInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final LastUpdateInfo c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L16;
                if (r3 != 2) goto L8;
                r0.d = ThemeColor.ADAPTER.c(r6);
                goto L3
            L8:
                if (r3 != 3) goto L10;
                r0.e = (Long) ProtoAdapter.k.c(r6);
                goto L3
            L10:
                if (r3 != 4) goto L11;
                r0.f = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L11:
                r6.j(r3);
                Unit r4 = Unit.INSTANCE;
                goto L3
            L16:
                return new LastUpdateInfo(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(LastUpdateInfo r5) {
                LastUpdateInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return ((r6.unknownFields().size() + ThemeColor.ADAPTER.l(2, r6.getText_color())) + ProtoAdapter.k.l(3, r6.getLast_update_timestamp())) + ProtoAdapter.g.l(4, r6.getVisible());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, LastUpdateInfo r5) {
                LastUpdateInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ThemeColor.ADAPTER.i(r4, 2, r6.getText_color());
                ProtoAdapter.k.i(r4, 3, r6.getLast_update_timestamp());
                ProtoAdapter.g.i(r4, 4, r6.getVisible());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, LastUpdateInfo r5) {
                LastUpdateInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.g.j(r4, 4, r6.getVisible());
                ProtoAdapter.k.j(r4, 3, r6.getLast_update_timestamp());
                ThemeColor.ADAPTER.j(r4, 2, r6.getText_color());
            }

            public b(FieldEncoding r7, KClass<LastUpdateInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.UrlPreviewEntity.LastUpdateInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ LastUpdateInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(LastUpdateInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.text_color;
            r0.e = this.last_update_timestamp;
            r0.f = this.visible;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(LastUpdateInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final Long getLast_update_timestamp() {
            return this.last_update_timestamp;
        }

        public final ThemeColor getText_color() {
            return this.text_color;
        }

        public final Boolean getVisible() {
            return this.visible;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public LastUpdateInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.text_color = r2.d;
            this.last_update_timestamp = r2.e;
            this.visible = r2.f;
        }

        public /* synthetic */ LastUpdateInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$SingleCardMode;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "AUTO", "INLINE_NOT_DISPLAY", "INLINE_DISPLAY", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum SingleCardMode extends Enum<SingleCardMode> implements o0 {
        public static final ProtoAdapter<SingleCardMode> ADAPTER = null;
        public static final SingleCardMode AUTO = null;
        public static final b Companion = null;
        public static final SingleCardMode INLINE_DISPLAY = null;
        public static final SingleCardMode INLINE_NOT_DISPLAY = null;
        public static final /* synthetic */ SingleCardMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<SingleCardMode> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                SingleCardMode.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return SingleCardMode.INLINE_DISPLAY;
            L15:
                return SingleCardMode.INLINE_NOT_DISPLAY;
            L12:
                return SingleCardMode.AUTO;
            }

            public a(KClass<SingleCardMode> r1, Syntax r2, SingleCardMode r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<SingleCardMode> getEntries() {
            return b;
        }

        static {
            SingleCardMode r0 = new SingleCardMode("AUTO", 0, 0);
            AUTO = r0;
            SingleCardMode r1 = new SingleCardMode("INLINE_NOT_DISPLAY", 1, 1);
            INLINE_NOT_DISPLAY = r1;
            SingleCardMode r3 = new SingleCardMode("INLINE_DISPLAY", 2, 2);
            INLINE_DISPLAY = r3;
            SingleCardMode[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(SingleCardMode.class), Syntax.PROTO_2, r0);
        }

        public static SingleCardMode[] values() {
            return (SingleCardMode[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final SingleCardMode fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return INLINE_DISPLAY;
        L15:
            return INLINE_NOT_DISPLAY;
        L12:
            return AUTO;
        }

        public static SingleCardMode valueOf(String r1) {
            return (SingleCardMode) r27.a.a(SingleCardMode.class, r1);
        }

        public SingleCardMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$TranslateInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$TranslateInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$TranslateInfo$Builder;Lokio/ByteString;)V", "inline_replacement_element_id", "", "getInline_replacement_element_id", "()Ljava/lang/String;", "inline_replacement_engine_property_path", "getInline_replacement_engine_property_path", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class TranslateInfo extends com.lark.wire.Message<TranslateInfo, a> {
        public static final ProtoAdapter<TranslateInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String inline_replacement_element_id;
        private final String inline_replacement_engine_property_path;

        public static final class a extends com.lark.wire.Message.a<TranslateInfo, a> {
            public String d;
            public String e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new TranslateInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<TranslateInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final TranslateInfo c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L13;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.i();
                goto L3
            L8:
                if (r4 != 2) goto L9;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L9:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L13:
                return new TranslateInfo(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TranslateInfo r5) {
                TranslateInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return (r0 + r1.l(1, r6.getInline_replacement_element_id())) + r1.l(2, r6.getInline_replacement_engine_property_path());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, TranslateInfo r5) {
                TranslateInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getInline_replacement_element_id());
                r0.i(r4, 2, r6.getInline_replacement_engine_property_path());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, TranslateInfo r5) {
                TranslateInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 2, r6.getInline_replacement_engine_property_path());
                r0.j(r4, 1, r6.getInline_replacement_element_id());
            }

            public b(FieldEncoding r7, KClass<TranslateInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.UrlPreviewEntity.TranslateInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ TranslateInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TranslateInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.inline_replacement_element_id;
            r0.e = this.inline_replacement_engine_property_path;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(TranslateInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final String getInline_replacement_element_id() {
            return this.inline_replacement_element_id;
        }

        public final String getInline_replacement_engine_property_path() {
            return this.inline_replacement_engine_property_path;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public TranslateInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.inline_replacement_element_id = r2.d;
            this.inline_replacement_engine_property_path = r2.e;
        }

        public /* synthetic */ TranslateInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$UnifiedHeader;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$UnifiedHeader$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$UnifiedHeader$Builder;Lokio/ByteString;)V", "icon", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$ColorIcon;", "getIcon", "()Lcom/lark/kmp/pb/basic/v1/UrlPreviewEntity$ColorIcon;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class UnifiedHeader extends com.lark.wire.Message<UnifiedHeader, a> {
        public static final ProtoAdapter<UnifiedHeader> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final ColorIcon icon;

        public static final class a extends com.lark.wire.Message.a<UnifiedHeader, a> {
            public ColorIcon d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new UnifiedHeader(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<UnifiedHeader> {
            @Override // com.lark.wire.ProtoAdapter
            public final UnifiedHeader c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L10;
                if (r3 == 1) goto L7;
                r6.j(r3);
                goto L3
            L7:
                r0.d = ColorIcon.ADAPTER.c(r6);
                goto L3
            L10:
                return new UnifiedHeader(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(UnifiedHeader r4) {
                UnifiedHeader r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ColorIcon.ADAPTER.l(1, r5.getIcon());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, UnifiedHeader r5) {
                UnifiedHeader r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ColorIcon.ADAPTER.i(r4, 1, r6.getIcon());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, UnifiedHeader r4) {
                UnifiedHeader r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ColorIcon.ADAPTER.j(r3, 1, r5.getIcon());
            }

            public b(FieldEncoding r7, KClass<UnifiedHeader> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.UrlPreviewEntity.UnifiedHeader", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ UnifiedHeader(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(UnifiedHeader.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.icon;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(UnifiedHeader.class).getSimpleName() + '@' + hashCode();
        }

        public final ColorIcon getIcon() {
            return this.icon;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public UnifiedHeader(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.icon = r2.d;
        }

        public /* synthetic */ UnifiedHeader(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<UrlPreviewEntity, a> {
        public String A;
        public Boolean B;
        public ExtInfo C;
        public AppInfo d;
        public String e;
        public String f;
        public URL g;
        public String h;
        public String i;
        public String j;
        public UDIcon k;
        public ImageSetPassThrough l;
        public Boolean m;
        public Integer n;
        public URLPreviewBody o;
        public RenderRouterEntity p;
        public UnifiedHeader q;
        public Boolean r;
        public String s;
        public String t;
        public String u;
        public String v;
        public String w;
        public String x;
        public String y;
        public URLPreviewComponent.VideoProperty.Site z;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new UrlPreviewEntity(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<UrlPreviewEntity> {
        @Override // com.lark.wire.ProtoAdapter
        public final UrlPreviewEntity c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L37;
            switch(r4) {
                case 1: goto L35;
                case 2: goto L34;
                case 3: goto L33;
                case 4: goto L32;
                case 5: goto L31;
                case 6: goto L30;
                case 7: goto L29;
                case 8: goto L28;
                case 9: goto L27;
                case 10: goto L26;
                case 11: goto L25;
                case 12: goto L24;
                case 13: goto L23;
                case 14: goto L22;
                case 15: goto L21;
                case 16: goto L20;
                case 17: goto L19;
                case 18: goto L38;
                case 19: goto L14;
                case 20: goto L13;
                case 21: goto L12;
                case 22: goto L11;
                case 23: goto L10;
                case 24: goto L9;
                case 25: goto L8;
                case 26: goto L7;
                default: goto L6;
            };
        L38:
            r1.z = URLPreviewComponent.VideoProperty.Site.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L7:
            r1.C = ExtInfo.ADAPTER.c(r10);
            goto L3
        L8:
            r1.m = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L9:
            r1.p = RenderRouterEntity.ADAPTER.c(r10);
            goto L3
        L10:
            r1.q = UnifiedHeader.ADAPTER.c(r10);
            goto L3
        L11:
            r1.d = AppInfo.ADAPTER.c(r10);
            goto L3
        L12:
            r1.B = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L13:
            r1.r = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L14:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.A = r10.i();
            goto L3
        L19:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.y = r10.i();
            goto L3
        L20:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.x = r10.i();
            goto L3
        L21:
            r1.l = ImageSetPassThrough.ADAPTER.c(r10);
            goto L3
        L22:
            r1.k = UDIcon.ADAPTER.c(r10);
            goto L3
        L23:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.w = r10.i();
            goto L3
        L24:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.v = r10.i();
            goto L3
        L25:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.u = r10.i();
            goto L3
        L26:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.t = r10.i();
            goto L3
        L27:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.s = r10.i();
            goto L3
        L28:
            r1.o = URLPreviewBody.ADAPTER.c(r10);
            goto L3
        L29:
            r1.n = (Integer) ProtoAdapter.h.c(r10);
            goto L3
        L30:
            r1.g = URL.ADAPTER.c(r10);
            goto L3
        L31:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.j = r10.i();
            goto L3
        L32:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.i = r10.i();
            goto L3
        L33:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.h = r10.i();
            goto L3
        L34:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            String r6 = r10.i();
            Intrinsics.checkNotNullParameter(r6, "preview_id");
            r1.f = r6;
            goto L3
        L35:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            String r7 = r10.i();
            Intrinsics.checkNotNullParameter(r7, "source_id");
            r1.e = r7;
            goto L3
        L6:
            r10.j(r4);
            Unit r8 = Unit.INSTANCE;
            goto L3
        L37:
            return new UrlPreviewEntity(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(UrlPreviewEntity r7) {
            UrlPreviewEntity r8 = r7;
            Intrinsics.checkNotNullParameter(r8, "value");
            int r0 = r8.unknownFields().size() + AppInfo.ADAPTER.l(22, r8.getApp_info());
            w r1 = ProtoAdapter.q;
            int r2 = (((((((r0 + r1.l(1, r8.getSource_id())) + r1.l(2, r8.getPreview_id())) + URL.ADAPTER.l(6, r8.getUrl())) + r1.l(3, r8.getServer_icon_key())) + r1.l(4, r8.getServer_title())) + r1.l(5, r8.getServer_tag())) + UDIcon.ADAPTER.l(14, r8.getUd_icon())) + ImageSetPassThrough.ADAPTER.l(15, r8.getServer_icon_image());
            l r3 = ProtoAdapter.g;
            return ((((((((((((((((r2 + r3.l(25, r8.getUse_color_icon())) + ProtoAdapter.h.l(7, r8.getVersion())) + URLPreviewBody.ADAPTER.l(8, r8.getPreview_body())) + RenderRouterEntity.ADAPTER.l(24, r8.getRender_router_entity())) + UnifiedHeader.ADAPTER.l(23, r8.getUnified_header())) + r3.l(20, r8.is_sdk_preview())) + r1.l(9, r8.getSdk_icon_url())) + r1.l(10, r8.getSdk_title())) + r1.l(11, r8.getSdk_description())) + r1.l(12, r8.getSdk_favicon_url())) + r1.l(13, r8.getSdk_domain())) + r1.l(16, r8.getSdk_iframe_url())) + r1.l(17, r8.getSdk_site_name())) + URLPreviewComponent.VideoProperty.Site.ADAPTER.l(18, r8.getSdk_site_type())) + r1.l(19, r8.getSdk_video_id())) + r3.l(21, r8.getNeed_reload())) + ExtInfo.ADAPTER.l(26, r8.getExt_info());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r6, UrlPreviewEntity r7) {
            UrlPreviewEntity r8 = r7;
            Intrinsics.checkNotNullParameter(r6, "writer");
            Intrinsics.checkNotNullParameter(r8, "value");
            AppInfo.ADAPTER.i(r6, 22, r8.getApp_info());
            w r0 = ProtoAdapter.q;
            r0.i(r6, 1, r8.getSource_id());
            r0.i(r6, 2, r8.getPreview_id());
            URL.ADAPTER.i(r6, 6, r8.getUrl());
            r0.i(r6, 3, r8.getServer_icon_key());
            r0.i(r6, 4, r8.getServer_title());
            r0.i(r6, 5, r8.getServer_tag());
            UDIcon.ADAPTER.i(r6, 14, r8.getUd_icon());
            ImageSetPassThrough.ADAPTER.i(r6, 15, r8.getServer_icon_image());
            l r1 = ProtoAdapter.g;
            r1.i(r6, 25, r8.getUse_color_icon());
            ProtoAdapter.h.i(r6, 7, r8.getVersion());
            URLPreviewBody.ADAPTER.i(r6, 8, r8.getPreview_body());
            RenderRouterEntity.ADAPTER.i(r6, 24, r8.getRender_router_entity());
            UnifiedHeader.ADAPTER.i(r6, 23, r8.getUnified_header());
            r1.i(r6, 20, r8.is_sdk_preview());
            r0.i(r6, 9, r8.getSdk_icon_url());
            r0.i(r6, 10, r8.getSdk_title());
            r0.i(r6, 11, r8.getSdk_description());
            r0.i(r6, 12, r8.getSdk_favicon_url());
            r0.i(r6, 13, r8.getSdk_domain());
            r0.i(r6, 16, r8.getSdk_iframe_url());
            r0.i(r6, 17, r8.getSdk_site_name());
            URLPreviewComponent.VideoProperty.Site.ADAPTER.i(r6, 18, r8.getSdk_site_type());
            r0.i(r6, 19, r8.getSdk_video_id());
            r1.i(r6, 21, r8.getNeed_reload());
            ExtInfo.ADAPTER.i(r6, 26, r8.getExt_info());
            r6.a(r8.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r6, UrlPreviewEntity r7) {
            UrlPreviewEntity r8 = r7;
            Intrinsics.checkNotNullParameter(r6, "writer");
            Intrinsics.checkNotNullParameter(r8, "value");
            r6.d(r8.unknownFields());
            ExtInfo.ADAPTER.j(r6, 26, r8.getExt_info());
            l r0 = ProtoAdapter.g;
            r0.j(r6, 21, r8.getNeed_reload());
            w r1 = ProtoAdapter.q;
            r1.j(r6, 19, r8.getSdk_video_id());
            URLPreviewComponent.VideoProperty.Site.ADAPTER.j(r6, 18, r8.getSdk_site_type());
            r1.j(r6, 17, r8.getSdk_site_name());
            r1.j(r6, 16, r8.getSdk_iframe_url());
            r1.j(r6, 13, r8.getSdk_domain());
            r1.j(r6, 12, r8.getSdk_favicon_url());
            r1.j(r6, 11, r8.getSdk_description());
            r1.j(r6, 10, r8.getSdk_title());
            r1.j(r6, 9, r8.getSdk_icon_url());
            r0.j(r6, 20, r8.is_sdk_preview());
            UnifiedHeader.ADAPTER.j(r6, 23, r8.getUnified_header());
            RenderRouterEntity.ADAPTER.j(r6, 24, r8.getRender_router_entity());
            URLPreviewBody.ADAPTER.j(r6, 8, r8.getPreview_body());
            ProtoAdapter.h.j(r6, 7, r8.getVersion());
            r0.j(r6, 25, r8.getUse_color_icon());
            ImageSetPassThrough.ADAPTER.j(r6, 15, r8.getServer_icon_image());
            UDIcon.ADAPTER.j(r6, 14, r8.getUd_icon());
            r1.j(r6, 5, r8.getServer_tag());
            r1.j(r6, 4, r8.getServer_title());
            r1.j(r6, 3, r8.getServer_icon_key());
            URL.ADAPTER.j(r6, 6, r8.getUrl());
            r1.j(r6, 2, r8.getPreview_id());
            r1.j(r6, 1, r8.getSource_id());
            AppInfo.ADAPTER.j(r6, 22, r8.getApp_info());
        }

        public b(FieldEncoding r7, KClass<UrlPreviewEntity> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.UrlPreviewEntity", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ UrlPreviewEntity(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        DEFAULT_SDK_SITE_TYPE = URLPreviewComponent.VideoProperty.Site.UNKNOWN;
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(UrlPreviewEntity.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.app_info;
        r0.e = this.source_id;
        r0.f = this.preview_id;
        r0.g = this.url;
        r0.h = this.server_icon_key;
        r0.i = this.server_title;
        r0.j = this.server_tag;
        r0.k = this.ud_icon;
        r0.l = this.server_icon_image;
        r0.m = this.use_color_icon;
        r0.n = this.version;
        r0.o = this.preview_body;
        r0.p = this.render_router_entity;
        r0.q = this.unified_header;
        r0.r = this.is_sdk_preview;
        r0.s = this.sdk_icon_url;
        r0.t = this.sdk_title;
        r0.u = this.sdk_description;
        r0.v = this.sdk_favicon_url;
        r0.w = this.sdk_domain;
        r0.x = this.sdk_iframe_url;
        r0.y = this.sdk_site_name;
        r0.z = this.sdk_site_type;
        r0.A = this.sdk_video_id;
        r0.B = this.need_reload;
        r0.C = this.ext_info;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(UrlPreviewEntity.class).getSimpleName() + '@' + hashCode();
    }

    public final AppInfo getApp_info() {
        return this.app_info;
    }

    public final ExtInfo getExt_info() {
        return this.ext_info;
    }

    public final Boolean getNeed_reload() {
        return this.need_reload;
    }

    public final URLPreviewBody getPreview_body() {
        return this.preview_body;
    }

    public final String getPreview_id() {
        return this.preview_id;
    }

    public final RenderRouterEntity getRender_router_entity() {
        return this.render_router_entity;
    }

    public final String getSdk_description() {
        return this.sdk_description;
    }

    public final String getSdk_domain() {
        return this.sdk_domain;
    }

    public final String getSdk_favicon_url() {
        return this.sdk_favicon_url;
    }

    public final String getSdk_icon_url() {
        return this.sdk_icon_url;
    }

    public final String getSdk_iframe_url() {
        return this.sdk_iframe_url;
    }

    public final String getSdk_site_name() {
        return this.sdk_site_name;
    }

    public final URLPreviewComponent.VideoProperty.Site getSdk_site_type() {
        return this.sdk_site_type;
    }

    public final String getSdk_title() {
        return this.sdk_title;
    }

    public final String getSdk_video_id() {
        return this.sdk_video_id;
    }

    public final ImageSetPassThrough getServer_icon_image() {
        return this.server_icon_image;
    }

    public final String getServer_icon_key() {
        return this.server_icon_key;
    }

    public final String getServer_tag() {
        return this.server_tag;
    }

    public final String getServer_title() {
        return this.server_title;
    }

    public final String getSource_id() {
        return this.source_id;
    }

    public final UDIcon getUd_icon() {
        return this.ud_icon;
    }

    public final UnifiedHeader getUnified_header() {
        return this.unified_header;
    }

    public final URL getUrl() {
        return this.url;
    }

    public final Boolean getUse_color_icon() {
        return this.use_color_icon;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public final Boolean is_sdk_preview() {
        return this.is_sdk_preview;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public UrlPreviewEntity(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.app_info = r2.d;
        String r4 = r2.e;
        Intrinsics.checkNotNull(r4);
        this.source_id = r4;
        String r5 = r2.f;
        Intrinsics.checkNotNull(r5);
        this.preview_id = r5;
        this.url = r2.g;
        this.server_icon_key = r2.h;
        this.server_title = r2.i;
        this.server_tag = r2.j;
        this.ud_icon = r2.k;
        this.server_icon_image = r2.l;
        this.use_color_icon = r2.m;
        this.version = r2.n;
        this.preview_body = r2.o;
        this.render_router_entity = r2.p;
        this.unified_header = r2.q;
        this.is_sdk_preview = r2.r;
        this.sdk_icon_url = r2.s;
        this.sdk_title = r2.t;
        this.sdk_description = r2.u;
        this.sdk_favicon_url = r2.v;
        this.sdk_domain = r2.w;
        this.sdk_iframe_url = r2.x;
        this.sdk_site_name = r2.y;
        this.sdk_site_type = r2.z;
        this.sdk_video_id = r2.A;
        this.need_reload = r2.B;
        this.ext_info = r2.C;
    }

    public /* synthetic */ UrlPreviewEntity(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
