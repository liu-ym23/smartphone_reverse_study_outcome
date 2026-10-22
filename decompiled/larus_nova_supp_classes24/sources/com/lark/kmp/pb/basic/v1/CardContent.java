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
import com.larksuite.component.card.protocol.context.action.CardActionService;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 _2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\r^_`abcdefghijB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\\\u001a\u00020\u0002H\u0016J\b\u0010]\u001a\u00020\u0012H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0015\u0010#\u001a\u0004\u0018\u00010$¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0013\u0010(\u001a\u0004\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0015\u0010,\u001a\u0004\u0018\u00010$¢\u0006\n\n\u0002\u0010'\u001a\u0004\b-\u0010&R\u0015\u0010.\u001a\u0004\u0018\u00010$¢\u0006\n\n\u0002\u0010'\u001a\u0004\b/\u0010&R\u0013\u00100\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u00103\u001a\u0004\u0018\u000104¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u00107\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b8\u00102R\u0013\u00109\u001a\u0004\u0018\u00010:¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010=\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b>\u00102R\u0013\u0010?\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b@\u00102R\u0015\u0010A\u001a\u0004\u0018\u00010$¢\u0006\n\n\u0002\u0010'\u001a\u0004\bB\u0010&R\u0013\u0010C\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\bD\u00102R\u0013\u0010E\u001a\u0004\u0018\u00010F¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020K0J¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0013\u0010N\u001a\u0004\u0018\u00010O¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0013\u0010R\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\bS\u00102R\u0013\u0010T\u001a\u0004\u0018\u00010U¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0013\u0010X\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\bY\u00102R\u0013\u0010Z\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b[\u00102¨\u0006k"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardContent$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/CardContent$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/CardContent$Type;", "richtext", "Lcom/lark/kmp/pb/basic/v1/RichText;", "getRichtext", "()Lcom/lark/kmp/pb/basic/v1/RichText;", "actions", "", "", "Lcom/lark/kmp/pb/basic/v1/CardAction;", "getActions", "()Ljava/util/Map;", "extra", "Lcom/lark/kmp/pb/basic/v1/CardContent$ExtraType;", "getExtra", "()Lcom/lark/kmp/pb/basic/v1/CardContent$ExtraType;", "card_version", "", "getCard_version", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "card_header", "Lcom/lark/kmp/pb/basic/v1/CardContent$CardHeader;", "getCard_header", "()Lcom/lark/kmp/pb/basic/v1/CardContent$CardHeader;", "wide_screen_mode", "", "getWide_screen_mode", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "extra_info", "Lcom/lark/kmp/pb/basic/v1/CardContent$ExtraInfo;", "getExtra_info", "()Lcom/lark/kmp/pb/basic/v1/CardContent$ExtraInfo;", "enable_forward", "getEnable_forward", "compact_width", "getCompact_width", "json_body", "getJson_body", "()Ljava/lang/String;", "json_attachment", "Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment;", "getJson_attachment", "()Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment;", "width_mode", "getWidth_mode", "app_info", "Lcom/lark/kmp/pb/basic/v1/CardAppInfo;", "getApp_info", "()Lcom/lark/kmp/pb/basic/v1/CardAppInfo;", CardActionService.CARD_ID, "getCard_id", "version", "getVersion", "streaming_mode", "getStreaming_mode", "json_card_header_theme", "getJson_card_header_theme", "streaming_config", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$StreamingConfig;", "getStreaming_config", "()Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$StreamingConfig;", "json_card_urls", "", "Lcom/lark/kmp/pb/basic/v1/CardContent$Url;", "getJson_card_urls", "()Ljava/util/List;", "patch_info", "Lcom/lark/kmp/pb/basic/v1/CardContent$PatchInfo;", "getPatch_info", "()Lcom/lark/kmp/pb/basic/v1/CardContent$PatchInfo;", "universal_host_card_id", "getUniversal_host_card_id", "universal_card_entity", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity;", "getUniversal_card_entity", "()Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity;", "biz_id", "getBiz_id", "action_url", "getAction_url", "newBuilder", "toString", "Builder", "Companion", "Type", "ExtraType", "CardHeader", "ExtraInfo", "GadgetConfig", "CustomConfig", "MeegoConfig", "JsonAttachment", "PatchInfo", "DataSource", "Url", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardContent extends com.lark.wire.Message<CardContent, a> {
    public static final ProtoAdapter<CardContent> ADAPTER = null;
    public static final b Companion = null;
    public static final boolean DEFAULT_WIDE_SCREEN_MODE = false;
    private static final long serialVersionUID = 0;
    private final String action_url;
    private final Map<String, CardAction> actions;
    private final CardAppInfo app_info;
    private final String biz_id;
    private final CardHeader card_header;
    private final String card_id;
    private final Integer card_version;
    private final Boolean compact_width;
    private final Boolean enable_forward;
    private final ExtraType extra;
    private final ExtraInfo extra_info;
    private final JsonAttachment json_attachment;
    private final String json_body;
    private final String json_card_header_theme;
    private final List<Url> json_card_urls;
    private final PatchInfo patch_info;
    private final RichText richtext;
    private final UniversalCardEntity.StreamingConfig streaming_config;
    private final Boolean streaming_mode;
    private final Type type;
    private final UniversalCardEntity universal_card_entity;
    private final String universal_host_card_id;
    private final String version;
    private final Boolean wide_screen_mode;
    private final String width_mode;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\"#B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000bR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000b¨\u0006$"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardContent$CardHeader;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardContent$CardHeader$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardContent$CardHeader$Builder;Lokio/ByteString;)V", "title", "", "getTitle", "()Ljava/lang/String;", "title_i18n_key", "getTitle_i18n_key", "style", "", "getStyle", "()Ljava/util/Map;", "theme", "getTheme", "icon", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ImageProperty;", "getIcon", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$ImageProperty;", "subtitle", "getSubtitle", "subtitle_i18n_key", "getSubtitle_i18n_key", "main_title", "getMain_title", "main_title_i18n_key", "getMain_title_i18n_key", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CardHeader extends com.lark.wire.Message<CardHeader, a> {
        public static final ProtoAdapter<CardHeader> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final RichTextElement.ImageProperty icon;
        private final String main_title;
        private final String main_title_i18n_key;
        private final Map<String, String> style;
        private final String subtitle;
        private final String subtitle_i18n_key;
        private final String theme;
        private final String title;
        private final String title_i18n_key;

        public static final class a extends com.lark.wire.Message.a<CardHeader, a> {
            public String d;
            public String e;
            public Map<String, String> f;
            public String g;
            public RichTextElement.ImageProperty h;
            public String i;
            public String j;
            public String k;
            public String l;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new CardHeader(this, c(), null);
            }

            public a() {
                this.f = MapsKt.emptyMap();
            }
        }

        public static final class b {
            public b() {
            }
        }

        public /* synthetic */ CardHeader(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new b();
            final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
            final KClass r1 = Reflection.getOrCreateKotlinClass(CardHeader.class);
            final Syntax r2 = Syntax.PROTO_2;
            ADAPTER = new CardContent$CardHeader$Companion$ADAPTER$1(r0, r1, r2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.title;
            r0.e = this.title_i18n_key;
            r0.f = this.style;
            r0.g = this.theme;
            r0.h = this.icon;
            r0.i = this.subtitle;
            r0.j = this.subtitle_i18n_key;
            r0.k = this.main_title;
            r0.l = this.main_title_i18n_key;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(CardHeader.class).getSimpleName() + '@' + hashCode();
        }

        public final RichTextElement.ImageProperty getIcon() {
            return this.icon;
        }

        public final String getMain_title() {
            return this.main_title;
        }

        public final String getMain_title_i18n_key() {
            return this.main_title_i18n_key;
        }

        public final Map<String, String> getStyle() {
            return this.style;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final String getSubtitle_i18n_key() {
            return this.subtitle_i18n_key;
        }

        public final String getTheme() {
            return this.theme;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getTitle_i18n_key() {
            return this.title_i18n_key;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public CardHeader(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.title = r2.d;
            this.title_i18n_key = r2.e;
            this.style = com.lark.wire.internal.a.d("style", r2.f);
            this.theme = r2.g;
            this.icon = r2.h;
            this.subtitle = r2.i;
            this.subtitle_i18n_key = r2.j;
            this.main_title = r2.k;
            this.main_title_i18n_key = r2.l;
        }

        public /* synthetic */ CardHeader(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardContent$CustomConfig;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardContent$CustomConfig$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardContent$CustomConfig$Builder;Lokio/ByteString;)V", "analytics_data", "", "getAnalytics_data", "()Ljava/lang/String;", "use_custom_translation", "", "getUse_custom_translation", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "enable_translate", "getEnable_translate", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CustomConfig extends com.lark.wire.Message<CustomConfig, a> {
        public static final ProtoAdapter<CustomConfig> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String analytics_data;
        private final Boolean enable_translate;
        private final Boolean use_custom_translation;

        public static final class a extends com.lark.wire.Message.a<CustomConfig, a> {
            public String d;
            public Boolean e;
            public Boolean f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new CustomConfig(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<CustomConfig> {
            @Override // com.lark.wire.ProtoAdapter
            public final CustomConfig c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L16;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.i();
                goto L3
            L8:
                if (r4 != 2) goto L10;
                r1.e = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L10:
                if (r4 != 3) goto L11;
                r1.f = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L11:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L16:
                return new CustomConfig(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(CustomConfig r5) {
                CustomConfig r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getAnalytics_data());
                l r1 = ProtoAdapter.g;
                return (r0 + r1.l(2, r6.getUse_custom_translation())) + r1.l(3, r6.getEnable_translate());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, CustomConfig r5) {
                CustomConfig r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.i(r4, 1, r6.getAnalytics_data());
                l r0 = ProtoAdapter.g;
                r0.i(r4, 2, r6.getUse_custom_translation());
                r0.i(r4, 3, r6.getEnable_translate());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, CustomConfig r5) {
                CustomConfig r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                l r0 = ProtoAdapter.g;
                r0.j(r4, 3, r6.getEnable_translate());
                r0.j(r4, 2, r6.getUse_custom_translation());
                ProtoAdapter.q.j(r4, 1, r6.getAnalytics_data());
            }

            public b(FieldEncoding r7, KClass<CustomConfig> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.CardContent.CustomConfig", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ CustomConfig(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CustomConfig.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.analytics_data;
            r0.e = this.use_custom_translation;
            r0.f = this.enable_translate;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(CustomConfig.class).getSimpleName() + '@' + hashCode();
        }

        public final String getAnalytics_data() {
            return this.analytics_data;
        }

        public final Boolean getEnable_translate() {
            return this.enable_translate;
        }

        public final Boolean getUse_custom_translation() {
            return this.use_custom_translation;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public CustomConfig(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.analytics_data = r2.d;
            this.use_custom_translation = r2.e;
            this.enable_translate = r2.f;
        }

        public /* synthetic */ CustomConfig(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardContent$DataSource;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "IM", "CARD", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum DataSource extends Enum<DataSource> implements o0 {
        public static final ProtoAdapter<DataSource> ADAPTER = null;
        public static final DataSource CARD = null;
        public static final b Companion = null;
        public static final DataSource IM = null;
        public static final /* synthetic */ DataSource[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<DataSource> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                DataSource.Companion.getClass();
                if (r2 == 1) goto L9;
                if (r2 == 2) goto L11;
                return null;
            L11:
                return DataSource.CARD;
            L9:
                return DataSource.IM;
            }

            public a(KClass<DataSource> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<DataSource> getEntries() {
            return b;
        }

        static {
            DataSource r0 = new DataSource("IM", 0, 1);
            IM = r0;
            DataSource r1 = new DataSource("CARD", 1, 2);
            CARD = r1;
            DataSource[] r4 = {r0, r1};
            a = r4;
            b = EnumEntriesKt.enumEntries(r4);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(DataSource.class), Syntax.PROTO_2);
        }

        public static DataSource[] values() {
            return (DataSource[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final DataSource fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L9;
            if (r1 == 2) goto L11;
            return null;
        L11:
            return CARD;
        L9:
            return IM;
        }

        public static DataSource valueOf(String r1) {
            return (DataSource) r27.a.a(DataSource.class, r1);
        }

        public DataSource(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardContent$ExtraInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardContent$ExtraInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardContent$ExtraInfo$Builder;Lokio/ByteString;)V", "gadget_config", "Lcom/lark/kmp/pb/basic/v1/CardContent$GadgetConfig;", "getGadget_config", "()Lcom/lark/kmp/pb/basic/v1/CardContent$GadgetConfig;", "custom_config", "Lcom/lark/kmp/pb/basic/v1/CardContent$CustomConfig;", "getCustom_config", "()Lcom/lark/kmp/pb/basic/v1/CardContent$CustomConfig;", "meego_config", "Lcom/lark/kmp/pb/basic/v1/CardContent$MeegoConfig;", "getMeego_config", "()Lcom/lark/kmp/pb/basic/v1/CardContent$MeegoConfig;", "custom_parameter", "", "getCustom_parameter", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ExtraInfo extends com.lark.wire.Message<ExtraInfo, a> {
        public static final ProtoAdapter<ExtraInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final CustomConfig custom_config;
        private final String custom_parameter;
        private final GadgetConfig gadget_config;
        private final MeegoConfig meego_config;

        public static final class a extends com.lark.wire.Message.a<ExtraInfo, a> {
            public GadgetConfig d;
            public CustomConfig e;
            public MeegoConfig f;
            public String g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ExtraInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ExtraInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final ExtraInfo c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L19;
                if (r4 != 1) goto L8;
                r1.d = GadgetConfig.ADAPTER.c(r7);
                goto L3
            L8:
                if (r4 != 2) goto L10;
                r1.e = CustomConfig.ADAPTER.c(r7);
                goto L3
            L10:
                if (r4 != 3) goto L12;
                r1.f = MeegoConfig.ADAPTER.c(r7);
                goto L3
            L12:
                if (r4 != 4) goto L13;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.g = r7.i();
                goto L3
            L13:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L19:
                return new ExtraInfo(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ExtraInfo r5) {
                ExtraInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (((r6.unknownFields().size() + GadgetConfig.ADAPTER.l(1, r6.getGadget_config())) + CustomConfig.ADAPTER.l(2, r6.getCustom_config())) + MeegoConfig.ADAPTER.l(3, r6.getMeego_config())) + ProtoAdapter.q.l(4, r6.getCustom_parameter());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, ExtraInfo r5) {
                ExtraInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                GadgetConfig.ADAPTER.i(r4, 1, r6.getGadget_config());
                CustomConfig.ADAPTER.i(r4, 2, r6.getCustom_config());
                MeegoConfig.ADAPTER.i(r4, 3, r6.getMeego_config());
                ProtoAdapter.q.i(r4, 4, r6.getCustom_parameter());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, ExtraInfo r5) {
                ExtraInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.q.j(r4, 4, r6.getCustom_parameter());
                MeegoConfig.ADAPTER.j(r4, 3, r6.getMeego_config());
                CustomConfig.ADAPTER.j(r4, 2, r6.getCustom_config());
                GadgetConfig.ADAPTER.j(r4, 1, r6.getGadget_config());
            }

            public b(FieldEncoding r7, KClass<ExtraInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.CardContent.ExtraInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ExtraInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ExtraInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.gadget_config;
            r0.e = this.custom_config;
            r0.f = this.meego_config;
            r0.g = this.custom_parameter;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ExtraInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final CustomConfig getCustom_config() {
            return this.custom_config;
        }

        public final String getCustom_parameter() {
            return this.custom_parameter;
        }

        public final GadgetConfig getGadget_config() {
            return this.gadget_config;
        }

        public final MeegoConfig getMeego_config() {
            return this.meego_config;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ExtraInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.gadget_config = r2.d;
            this.custom_config = r2.e;
            this.meego_config = r2.f;
            this.custom_parameter = r2.g;
        }

        public /* synthetic */ ExtraInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardContent$ExtraType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "SENDER_CANNOT_CLICK", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum ExtraType extends Enum<ExtraType> implements o0 {
        public static final ProtoAdapter<ExtraType> ADAPTER = null;
        public static final b Companion = null;
        public static final ExtraType SENDER_CANNOT_CLICK = null;
        public static final ExtraType UNKNOWN = null;
        public static final /* synthetic */ ExtraType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<ExtraType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                ExtraType.Companion.getClass();
                if (r2 == 0) goto L9;
                if (r2 == 1) goto L11;
                return null;
            L11:
                return ExtraType.SENDER_CANNOT_CLICK;
            L9:
                return ExtraType.UNKNOWN;
            }

            public a(KClass<ExtraType> r1, Syntax r2, ExtraType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<ExtraType> getEntries() {
            return b;
        }

        static {
            ExtraType r0 = new ExtraType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ExtraType r1 = new ExtraType("SENDER_CANNOT_CLICK", 1, 1);
            SENDER_CANNOT_CLICK = r1;
            ExtraType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(ExtraType.class), Syntax.PROTO_2, r0);
        }

        public static ExtraType[] values() {
            return (ExtraType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final ExtraType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L9;
            if (r1 == 1) goto L11;
            return null;
        L11:
            return SENDER_CANNOT_CLICK;
        L9:
            return UNKNOWN;
        }

        public static ExtraType valueOf(String r1) {
            return (ExtraType) r27.a.a(ExtraType.class, r1);
        }

        public ExtraType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\b\u0010\nR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardContent$GadgetConfig;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardContent$GadgetConfig$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardContent$GadgetConfig$Builder;Lokio/ByteString;)V", "is_preload", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "cli_ids", "", "", "getCli_ids", "()Ljava/util/List;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class GadgetConfig extends com.lark.wire.Message<GadgetConfig, a> {
        public static final ProtoAdapter<GadgetConfig> ADAPTER = null;
        public static final c Companion = null;
        public static final boolean DEFAULT_IS_PRELOAD = false;
        private static final long serialVersionUID = 0;
        private final List<String> cli_ids;
        private final Boolean is_preload;

        public static final class a extends com.lark.wire.Message.a<GadgetConfig, a> {
            public Boolean d;
            public List<String> e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new GadgetConfig(this, c(), null);
            }

            public a() {
                this.e = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<GadgetConfig> {
            @Override // com.lark.wire.ProtoAdapter
            public final GadgetConfig c(g0 r8) {
                Intrinsics.checkNotNullParameter(r8, "reader");
                a r1 = new a();
                ArrayList r2 = new ArrayList();
                long r3 = r8.c();
            L3:
                int r5 = r8.e();
                if (r5 == (-1)) goto L12;
                if (r5 != 1) goto L8;
                r1.d = (Boolean) ProtoAdapter.g.c(r8);
                goto L3
            L8:
                if (r5 != 2) goto L9;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r2.add(r8.i());
                goto L3
            L9:
                r8.j(r5);
                goto L3
            L12:
                ByteString r9 = r8.d(r3);
                Intrinsics.checkNotNullParameter(r2, "cli_ids");
                com.lark.wire.internal.a.a(r2);
                r1.e = r2;
                return new GadgetConfig(r1, r9, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(GadgetConfig r5) {
                GadgetConfig r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + ProtoAdapter.g.l(1, r6.is_preload())) + ProtoAdapter.q.a().l(2, r6.getCli_ids());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, GadgetConfig r5) {
                GadgetConfig r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.g.i(r4, 1, r6.is_preload());
                ProtoAdapter.q.a().i(r4, 2, r6.getCli_ids());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, GadgetConfig r5) {
                GadgetConfig r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.q.a().j(r4, 2, r6.getCli_ids());
                ProtoAdapter.g.j(r4, 1, r6.is_preload());
            }

            public b(FieldEncoding r7, KClass<GadgetConfig> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.CardContent.GadgetConfig", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ GadgetConfig(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(GadgetConfig.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.is_preload;
            r0.e = this.cli_ids;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(GadgetConfig.class).getSimpleName() + '@' + hashCode();
        }

        public final List<String> getCli_ids() {
            return this.cli_ids;
        }

        public final Boolean is_preload() {
            return this.is_preload;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public GadgetConfig(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.is_preload = r2.d;
            this.cli_ids = com.lark.wire.internal.a.c("cli_ids", r2.e);
        }

        public /* synthetic */ GadgetConfig(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 -2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0007,-./012B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010*\u001a\u00020\u0002H\u0016J\b\u0010+\u001a\u00020\nH\u0016R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00120\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0018\u0010\u001aR\u001d\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\rR\u001d\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001f0\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010\rR\u001d\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\"0\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\rR\u0013\u0010$\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001d\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020(0\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\r¨\u00063"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$Builder;Lokio/ByteString;)V", "images", "", "", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ImageProperty;", "getImages", "()Ljava/util/Map;", "at_users", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$AtProperty;", "getAt_users", "option_users", "Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$OptionUser;", "getOption_users", "summary", "Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent;", "getSummary", "()Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent;", "is_forward", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component_status_by_name", "getComponent_status_by_name", "persons", "Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$PersonInfo;", "getPersons", "audios", "Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$AudioInfo;", "getAudios", "card_simple_summary", "getCard_simple_summary", "()Ljava/lang/String;", "videos", "Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$VideoInfo;", "getVideos", "newBuilder", "toString", "Builder", "Companion", "OptionUser", "PersonInfo", com.larksuite.component.card.protocol.data.media.AudioInfo.TAG, "SummaryContent", com.larksuite.component.card.protocol.data.media.VideoInfo.TAG, "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class JsonAttachment extends com.lark.wire.Message<JsonAttachment, a> {
        public static final ProtoAdapter<JsonAttachment> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final Map<String, RichTextElement.AtProperty> at_users;
        private final Map<String, AudioInfo> audios;
        private final String card_simple_summary;
        private final Map<String, String> component_status_by_name;
        private final Map<String, RichTextElement.ImageProperty> images;
        private final Boolean is_forward;
        private final Map<String, OptionUser> option_users;
        private final Map<String, PersonInfo> persons;
        private final SummaryContent summary;
        private final Map<String, VideoInfo> videos;

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$AudioInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$AudioInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$AudioInfo$Builder;Lokio/ByteString;)V", "key", "", "getKey", "()Ljava/lang/String;", "duration", "", "getDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "size", "", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "visit_info", "Lcom/lark/kmp/pb/basic/v1/CardVisitInfo;", "getVisit_info", "()Lcom/lark/kmp/pb/basic/v1/CardVisitInfo;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class AudioInfo extends com.lark.wire.Message<AudioInfo, a> {
            public static final ProtoAdapter<AudioInfo> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final Integer duration;
            private final String key;
            private final Long size;
            private final CardVisitInfo visit_info;

            public static final class a extends com.lark.wire.Message.a<AudioInfo, a> {
                public String d;
                public Integer e;
                public Long f;
                public CardVisitInfo g;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new AudioInfo(this, c(), null);
                }

                public a() {
                }
            }

            public static final class b extends ProtoAdapter<AudioInfo> {
                @Override // com.lark.wire.ProtoAdapter
                public final AudioInfo c(g0 r7) {
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
                    r1.e = (Integer) ProtoAdapter.h.c(r7);
                    goto L3
                L10:
                    if (r4 != 3) goto L12;
                    r1.f = (Long) ProtoAdapter.k.c(r7);
                    goto L3
                L12:
                    if (r4 != 4) goto L13;
                    r1.g = CardVisitInfo.ADAPTER.c(r7);
                    goto L3
                L13:
                    r7.j(r4);
                    Unit r5 = Unit.INSTANCE;
                    goto L3
                L19:
                    return new AudioInfo(r1, r7.d(r2), null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(AudioInfo r5) {
                    AudioInfo r6 = r5;
                    Intrinsics.checkNotNullParameter(r6, "value");
                    return (((r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getKey())) + ProtoAdapter.h.l(2, r6.getDuration())) + ProtoAdapter.k.l(3, r6.getSize())) + CardVisitInfo.ADAPTER.l(4, r6.getVisit_info());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r4, AudioInfo r5) {
                    AudioInfo r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    ProtoAdapter.q.i(r4, 1, r6.getKey());
                    ProtoAdapter.h.i(r4, 2, r6.getDuration());
                    ProtoAdapter.k.i(r4, 3, r6.getSize());
                    CardVisitInfo.ADAPTER.i(r4, 4, r6.getVisit_info());
                    r4.a(r6.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r4, AudioInfo r5) {
                    AudioInfo r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    r4.d(r6.unknownFields());
                    CardVisitInfo.ADAPTER.j(r4, 4, r6.getVisit_info());
                    ProtoAdapter.k.j(r4, 3, r6.getSize());
                    ProtoAdapter.h.j(r4, 2, r6.getDuration());
                    ProtoAdapter.q.j(r4, 1, r6.getKey());
                }

                public b(FieldEncoding r7, KClass<AudioInfo> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.CardContent.JsonAttachment.AudioInfo", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ AudioInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AudioInfo.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.key;
                r0.e = this.duration;
                r0.f = this.size;
                r0.g = this.visit_info;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(AudioInfo.class).getSimpleName() + '@' + hashCode();
            }

            public final Integer getDuration() {
                return this.duration;
            }

            public final String getKey() {
                return this.key;
            }

            public final Long getSize() {
                return this.size;
            }

            public final CardVisitInfo getVisit_info() {
                return this.visit_info;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public AudioInfo(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.key = r2.d;
                this.duration = r2.e;
                this.size = r2.f;
                this.visit_info = r2.g;
            }

            public /* synthetic */ AudioInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$OptionUser;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$OptionUser$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$OptionUser$Builder;Lokio/ByteString;)V", "user_id", "", "getUser_id", "()Ljava/lang/String;", "content", "getContent", "avatar_key", "getAvatar_key", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class OptionUser extends com.lark.wire.Message<OptionUser, a> {
            public static final ProtoAdapter<OptionUser> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final String avatar_key;
            private final String content;
            private final String user_id;

            public static final class a extends com.lark.wire.Message.a<OptionUser, a> {
                public String d;
                public String e;
                public String f;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new OptionUser(this, c(), null);
                }

                public a() {
                }
            }

            public static final class b extends ProtoAdapter<OptionUser> {
                @Override // com.lark.wire.ProtoAdapter
                public final OptionUser c(g0 r7) {
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    a r1 = new a();
                    long r2 = r7.c();
                L3:
                    int r4 = r7.e();
                    if (r4 == (-1)) goto L16;
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
                    if (r4 != 3) goto L11;
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    r1.f = r7.i();
                    goto L3
                L11:
                    r7.j(r4);
                    Unit r5 = Unit.INSTANCE;
                    goto L3
                L16:
                    return new OptionUser(r1, r7.d(r2), null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(OptionUser r5) {
                    OptionUser r6 = r5;
                    Intrinsics.checkNotNullParameter(r6, "value");
                    int r0 = r6.unknownFields().size();
                    w r1 = ProtoAdapter.q;
                    return ((r0 + r1.l(1, r6.getUser_id())) + r1.l(2, r6.getContent())) + r1.l(3, r6.getAvatar_key());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r4, OptionUser r5) {
                    OptionUser r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    w r0 = ProtoAdapter.q;
                    r0.i(r4, 1, r6.getUser_id());
                    r0.i(r4, 2, r6.getContent());
                    r0.i(r4, 3, r6.getAvatar_key());
                    r4.a(r6.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r4, OptionUser r5) {
                    OptionUser r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    r4.d(r6.unknownFields());
                    w r0 = ProtoAdapter.q;
                    r0.j(r4, 3, r6.getAvatar_key());
                    r0.j(r4, 2, r6.getContent());
                    r0.j(r4, 1, r6.getUser_id());
                }

                public b(FieldEncoding r7, KClass<OptionUser> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.CardContent.JsonAttachment.OptionUser", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ OptionUser(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(OptionUser.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.user_id;
                r0.e = this.content;
                r0.f = this.avatar_key;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(OptionUser.class).getSimpleName() + '@' + hashCode();
            }

            public final String getAvatar_key() {
                return this.avatar_key;
            }

            public final String getContent() {
                return this.content;
            }

            public final String getUser_id() {
                return this.user_id;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public OptionUser(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.user_id = r2.d;
                this.content = r2.e;
                this.avatar_key = r2.f;
            }

            public /* synthetic */ OptionUser(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0016\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$PersonInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$PersonInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$PersonInfo$Builder;Lokio/ByteString;)V", "person_id", "", "getPerson_id", "()Ljava/lang/String;", "type", "Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$PersonInfo$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$PersonInfo$Type;", "content", "getContent", "avatar_key", "getAvatar_key", "newBuilder", "toString", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class PersonInfo extends com.lark.wire.Message<PersonInfo, a> {
            public static final ProtoAdapter<PersonInfo> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final String avatar_key;
            private final String content;
            private final String person_id;
            private final Type type;

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$PersonInfo$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "USER", "CHAT", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
            public static final enum Type extends Enum<Type> implements o0 {
                public static final ProtoAdapter<Type> ADAPTER = null;
                public static final Type CHAT = null;
                public static final b Companion = null;
                public static final Type UNKNOWN = null;
                public static final Type USER = null;
                public static final /* synthetic */ Type[] a = null;
                public static final /* synthetic */ EnumEntries b = null;
                private final int value;

                public static final class a extends d<Type> {
                    @Override // com.lark.wire.d
                    public final o0 n(int r2) {
                        Type.Companion.getClass();
                        if (r2 == 0) goto L12;
                        if (r2 == 1) goto L15;
                        if (r2 == 2) goto L14;
                        return null;
                    L14:
                        return Type.CHAT;
                    L15:
                        return Type.USER;
                    L12:
                        return Type.UNKNOWN;
                    }

                    public a(KClass<Type> r1, Syntax r2, Type r3) {
                        super(r1, r2, r3);
                    }
                }

                public static final class b {
                    public b() {
                    }
                }

                public static EnumEntries<Type> getEntries() {
                    return b;
                }

                static {
                    Type r0 = new Type("UNKNOWN", 0, 0);
                    UNKNOWN = r0;
                    Type r1 = new Type("USER", 1, 1);
                    USER = r1;
                    Type r3 = new Type("CHAT", 2, 2);
                    CHAT = r3;
                    Type[] r5 = {r0, r1, r3};
                    a = r5;
                    b = EnumEntriesKt.enumEntries(r5);
                    Companion = new b();
                    ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2, r0);
                }

                public static Type[] values() {
                    return (Type[]) a.clone();
                }

                @Override // com.lark.wire.o0
                public int getValue() {
                    return this.value;
                }

                @JvmStatic
                public static final Type fromValue(int r1) {
                    Companion.getClass();
                    if (r1 == 0) goto L12;
                    if (r1 == 1) goto L15;
                    if (r1 == 2) goto L14;
                    return null;
                L14:
                    return CHAT;
                L15:
                    return USER;
                L12:
                    return UNKNOWN;
                }

                public static Type valueOf(String r1) {
                    return (Type) r27.a.a(Type.class, r1);
                }

                public Type(String r1, int r2, int r3) {
                    super(r1, r2);
                    this.value = r3;
                }
            }

            public static final class a extends com.lark.wire.Message.a<PersonInfo, a> {
                public String d;
                public Type e;
                public String f;
                public String g;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new PersonInfo(this, c(), null);
                }

                public a() {
                }
            }

            public static final class b extends ProtoAdapter<PersonInfo> {
                @Override // com.lark.wire.ProtoAdapter
                public final PersonInfo c(g0 r10) {
                    Intrinsics.checkNotNullParameter(r10, "reader");
                    a r1 = new a();
                    long r2 = r10.c();
                L3:
                    int r4 = r10.e();
                    if (r4 == (-1)) goto L22;
                    if (r4 != 1) goto L8;
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r10, "reader");
                    String r5 = r10.i();
                    Intrinsics.checkNotNullParameter(r5, "person_id");
                    r1.d = r5;
                    goto L3
                L8:
                    if (r4 != 2) goto L10;
                    Type r6 = Type.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
                    Intrinsics.checkNotNullParameter(r6, "type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
                    r1.e = r6;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
                L18:
                    e = move-exception;
                    r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                    Unit r7 = Unit.INSTANCE;
                    goto L3
                L10:
                    if (r4 != 3) goto L12;
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r10, "reader");
                    r1.f = r10.i();
                    goto L3
                L12:
                    if (r4 != 4) goto L13;
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r10, "reader");
                    r1.g = r10.i();
                    goto L3
                L13:
                    r10.j(r4);
                    Unit r8 = Unit.INSTANCE;
                    goto L3
                L22:
                    return new PersonInfo(r1, r10.d(r2), null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(PersonInfo r6) {
                    PersonInfo r7 = r6;
                    Intrinsics.checkNotNullParameter(r7, "value");
                    int r0 = r7.unknownFields().size();
                    w r1 = ProtoAdapter.q;
                    return (((r0 + r1.l(1, r7.getPerson_id())) + Type.ADAPTER.l(2, r7.getType())) + r1.l(3, r7.getContent())) + r1.l(4, r7.getAvatar_key());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r5, PersonInfo r6) {
                    PersonInfo r7 = r6;
                    Intrinsics.checkNotNullParameter(r5, "writer");
                    Intrinsics.checkNotNullParameter(r7, "value");
                    w r0 = ProtoAdapter.q;
                    r0.i(r5, 1, r7.getPerson_id());
                    Type.ADAPTER.i(r5, 2, r7.getType());
                    r0.i(r5, 3, r7.getContent());
                    r0.i(r5, 4, r7.getAvatar_key());
                    r5.a(r7.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r5, PersonInfo r6) {
                    PersonInfo r7 = r6;
                    Intrinsics.checkNotNullParameter(r5, "writer");
                    Intrinsics.checkNotNullParameter(r7, "value");
                    r5.d(r7.unknownFields());
                    w r0 = ProtoAdapter.q;
                    r0.j(r5, 4, r7.getAvatar_key());
                    r0.j(r5, 3, r7.getContent());
                    Type.ADAPTER.j(r5, 2, r7.getType());
                    r0.j(r5, 1, r7.getPerson_id());
                }

                public b(FieldEncoding r7, KClass<PersonInfo> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.CardContent.JsonAttachment.PersonInfo", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ PersonInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PersonInfo.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.person_id;
                r0.e = this.type;
                r0.f = this.content;
                r0.g = this.avatar_key;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(PersonInfo.class).getSimpleName() + '@' + hashCode();
            }

            public final String getAvatar_key() {
                return this.avatar_key;
            }

            public final String getContent() {
                return this.content;
            }

            public final String getPerson_id() {
                return this.person_id;
            }

            public final Type getType() {
                return this.type;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public PersonInfo(a r2, ByteString r3) {
                super(ADAPTER, r3);
                String r4 = r2.d;
                Intrinsics.checkNotNull(r4);
                this.person_id = r4;
                Type r5 = r2.e;
                Intrinsics.checkNotNull(r5);
                this.type = r5;
                this.content = r2.f;
                this.avatar_key = r2.g;
            }

            public /* synthetic */ PersonInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0010\u0011\u0012B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent$Builder;Lokio/ByteString;)V", "items", "", "Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent$Item;", "getItems", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "Item", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class SummaryContent extends com.lark.wire.Message<SummaryContent, a> {
            public static final ProtoAdapter<SummaryContent> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final List<Item> items;

            @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0006\"#$%&'B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006("}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent$Item;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent$Item$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent$Item$Builder;Lokio/ByteString;)V", "text", "", "getText", "()Ljava/lang/String;", "image", "Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent$Item$Image;", "getImage", "()Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent$Item$Image;", "at_user", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$AtProperty;", "getAt_user", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$AtProperty;", "emotion", "Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent$Item$Emotion;", "getEmotion", "()Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent$Item$Emotion;", "person_list", "Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent$Item$PersonList;", "getPerson_list", "()Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent$Item$PersonList;", "i18n_content", "Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent$Item$I18NContent;", "getI18n_content", "()Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent$Item$I18NContent;", "newBuilder", "toString", "Builder", "Companion", "Image", "Emotion", "PersonList", "I18NContent", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
            public static final class Item extends com.lark.wire.Message<Item, a> {
                public static final ProtoAdapter<Item> ADAPTER = null;
                public static final c Companion = null;
                private static final long serialVersionUID = 0;
                private final RichTextElement.AtProperty at_user;
                private final Emotion emotion;
                private final I18NContent i18n_content;
                private final Image image;
                private final PersonList person_list;
                private final String text;

                @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent$Item$Emotion;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent$Item$Emotion$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent$Item$Emotion$Builder;Lokio/ByteString;)V", "key", "", "getKey", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
                public static final class Emotion extends com.lark.wire.Message<Emotion, a> {
                    public static final ProtoAdapter<Emotion> ADAPTER = null;
                    public static final c Companion = null;
                    private static final long serialVersionUID = 0;
                    private final String key;

                    public static final class a extends com.lark.wire.Message.a<Emotion, a> {
                        public String d;

                        @Override // com.lark.wire.Message.a
                        public final com.lark.wire.Message b() {
                            return new Emotion(this, c(), null);
                        }

                        public a() {
                        }
                    }

                    public static final class b extends ProtoAdapter<Emotion> {
                        @Override // com.lark.wire.ProtoAdapter
                        public final Emotion c(g0 r7) {
                            Intrinsics.checkNotNullParameter(r7, "reader");
                            a r1 = new a();
                            long r2 = r7.c();
                        L3:
                            int r4 = r7.e();
                            if (r4 == (-1)) goto L10;
                            if (r4 == 1) goto L7;
                            r7.j(r4);
                            goto L3
                        L7:
                            ProtoAdapter.q.getClass();
                            Intrinsics.checkNotNullParameter(r7, "reader");
                            String r5 = r7.i();
                            Intrinsics.checkNotNullParameter(r5, "key");
                            r1.d = r5;
                            goto L3
                        L10:
                            return new Emotion(r1, r7.d(r2), null);
                        }

                        @Override // com.lark.wire.ProtoAdapter
                        public final int k(Emotion r4) {
                            Emotion r5 = r4;
                            Intrinsics.checkNotNullParameter(r5, "value");
                            return r5.unknownFields().size() + ProtoAdapter.q.l(1, r5.getKey());
                        }

                        @Override // com.lark.wire.ProtoAdapter
                        public final void f(j0 r4, Emotion r5) {
                            Emotion r6 = r5;
                            Intrinsics.checkNotNullParameter(r4, "writer");
                            Intrinsics.checkNotNullParameter(r6, "value");
                            ProtoAdapter.q.i(r4, 1, r6.getKey());
                            r4.a(r6.unknownFields());
                        }

                        @Override // com.lark.wire.ProtoAdapter
                        public final void g(n0 r3, Emotion r4) {
                            Emotion r5 = r4;
                            Intrinsics.checkNotNullParameter(r3, "writer");
                            Intrinsics.checkNotNullParameter(r5, "value");
                            r3.d(r5.unknownFields());
                            ProtoAdapter.q.j(r3, 1, r5.getKey());
                        }

                        public b(FieldEncoding r7, KClass<Emotion> r8, Syntax r9) {
                            super(r7, r8, "type.googleapis.com/basic.v1.CardContent.JsonAttachment.SummaryContent.Item.Emotion", r9, null);
                        }
                    }

                    public static final class c {
                        public c() {
                        }
                    }

                    public /* synthetic */ Emotion(a r1, ByteString r2, DefaultConstructorMarker r3) {
                        this(r1, r2);
                    }

                    static {
                        Companion = new c();
                        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Emotion.class), Syntax.PROTO_2);
                    }

                    @Override // com.lark.wire.Message
                    public a newBuilder() {
                        a r0 = new a();
                        r0.d = this.key;
                        r0.a(unknownFields());
                        return r0;
                    }

                    @Override // com.lark.wire.Message
                    public String toString() {
                        return Reflection.getOrCreateKotlinClass(Emotion.class).getSimpleName() + '@' + hashCode();
                    }

                    public final String getKey() {
                        return this.key;
                    }

                    @Override // com.lark.wire.Message
                    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                        return newBuilder();
                    }

                    public Emotion(a r2, ByteString r3) {
                        super(ADAPTER, r3);
                        String r4 = r2.d;
                        Intrinsics.checkNotNull(r4);
                        this.key = r4;
                    }

                    public /* synthetic */ Emotion(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                        if ((r3 & 2) == 0) goto L5;
                        r2 = ByteString.EMPTY;
                    L5:
                        this(r1, r2);
                    }
                }

                @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent$Item$I18NContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent$Item$I18NContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent$Item$I18NContent$Builder;Lokio/ByteString;)V", "key", "", "getKey", "()Ljava/lang/String;", "defaultValue", "getDefaultValue", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
                public static final class I18NContent extends com.lark.wire.Message<I18NContent, a> {
                    public static final ProtoAdapter<I18NContent> ADAPTER = null;
                    public static final c Companion = null;
                    private static final long serialVersionUID = 0;
                    private final String defaultValue;
                    private final String key;

                    public static final class a extends com.lark.wire.Message.a<I18NContent, a> {
                        public String d;
                        public String e;

                        @Override // com.lark.wire.Message.a
                        public final com.lark.wire.Message b() {
                            return new I18NContent(this, c(), null);
                        }

                        public a() {
                        }
                    }

                    public static final class b extends ProtoAdapter<I18NContent> {
                        @Override // com.lark.wire.ProtoAdapter
                        public final I18NContent c(g0 r7) {
                            Intrinsics.checkNotNullParameter(r7, "reader");
                            a r1 = new a();
                            long r2 = r7.c();
                        L3:
                            int r4 = r7.e();
                            if (r4 == (-1)) goto L13;
                            if (r4 != 1) goto L8;
                            ProtoAdapter.q.getClass();
                            Intrinsics.checkNotNullParameter(r7, "reader");
                            String r5 = r7.i();
                            Intrinsics.checkNotNullParameter(r5, "key");
                            r1.d = r5;
                            goto L3
                        L8:
                            if (r4 != 2) goto L9;
                            ProtoAdapter.q.getClass();
                            Intrinsics.checkNotNullParameter(r7, "reader");
                            r1.e = r7.i();
                            goto L3
                        L9:
                            r7.j(r4);
                            Unit r6 = Unit.INSTANCE;
                            goto L3
                        L13:
                            return new I18NContent(r1, r7.d(r2), null);
                        }

                        @Override // com.lark.wire.ProtoAdapter
                        public final int k(I18NContent r5) {
                            I18NContent r6 = r5;
                            Intrinsics.checkNotNullParameter(r6, "value");
                            int r0 = r6.unknownFields().size();
                            w r1 = ProtoAdapter.q;
                            return (r0 + r1.l(1, r6.getKey())) + r1.l(2, r6.getDefaultValue());
                        }

                        @Override // com.lark.wire.ProtoAdapter
                        public final void f(j0 r4, I18NContent r5) {
                            I18NContent r6 = r5;
                            Intrinsics.checkNotNullParameter(r4, "writer");
                            Intrinsics.checkNotNullParameter(r6, "value");
                            w r0 = ProtoAdapter.q;
                            r0.i(r4, 1, r6.getKey());
                            r0.i(r4, 2, r6.getDefaultValue());
                            r4.a(r6.unknownFields());
                        }

                        @Override // com.lark.wire.ProtoAdapter
                        public final void g(n0 r4, I18NContent r5) {
                            I18NContent r6 = r5;
                            Intrinsics.checkNotNullParameter(r4, "writer");
                            Intrinsics.checkNotNullParameter(r6, "value");
                            r4.d(r6.unknownFields());
                            w r0 = ProtoAdapter.q;
                            r0.j(r4, 2, r6.getDefaultValue());
                            r0.j(r4, 1, r6.getKey());
                        }

                        public b(FieldEncoding r7, KClass<I18NContent> r8, Syntax r9) {
                            super(r7, r8, "type.googleapis.com/basic.v1.CardContent.JsonAttachment.SummaryContent.Item.I18NContent", r9, null);
                        }
                    }

                    public static final class c {
                        public c() {
                        }
                    }

                    public /* synthetic */ I18NContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
                        this(r1, r2);
                    }

                    static {
                        Companion = new c();
                        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(I18NContent.class), Syntax.PROTO_2);
                    }

                    @Override // com.lark.wire.Message
                    public a newBuilder() {
                        a r0 = new a();
                        r0.d = this.key;
                        r0.e = this.defaultValue;
                        r0.a(unknownFields());
                        return r0;
                    }

                    @Override // com.lark.wire.Message
                    public String toString() {
                        return Reflection.getOrCreateKotlinClass(I18NContent.class).getSimpleName() + '@' + hashCode();
                    }

                    public final String getDefaultValue() {
                        return this.defaultValue;
                    }

                    public final String getKey() {
                        return this.key;
                    }

                    @Override // com.lark.wire.Message
                    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                        return newBuilder();
                    }

                    public I18NContent(a r2, ByteString r3) {
                        super(ADAPTER, r3);
                        String r4 = r2.d;
                        Intrinsics.checkNotNull(r4);
                        this.key = r4;
                        this.defaultValue = r2.e;
                    }

                    public /* synthetic */ I18NContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                        if ((r3 & 2) == 0) goto L5;
                        r2 = ByteString.EMPTY;
                    L5:
                        this(r1, r2);
                    }
                }

                @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent$Item$Image;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent$Item$Image$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent$Item$Image$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
                public static final class Image extends com.lark.wire.Message<Image, a> {
                    public static final ProtoAdapter<Image> ADAPTER = null;
                    public static final c Companion = null;
                    private static final long serialVersionUID = 0;

                    public static final class a extends com.lark.wire.Message.a<Image, a> {
                        @Override // com.lark.wire.Message.a
                        public final com.lark.wire.Message b() {
                            return new Image(this, c(), null);
                        }

                        public a() {
                        }
                    }

                    public static final class b extends ProtoAdapter<Image> {
                        @Override // com.lark.wire.ProtoAdapter
                        public final Image c(g0 r6) {
                            Intrinsics.checkNotNullParameter(r6, "reader");
                            a r0 = new a();
                            long r1 = r6.c();
                        L3:
                            int r3 = r6.e();
                            if (r3 == (-1)) goto L7;
                            r6.j(r3);
                            goto L3
                        L7:
                            return new Image(r0, r6.d(r1), null);
                        }

                        @Override // com.lark.wire.ProtoAdapter
                        public final int k(Image r2) {
                            Image r3 = r2;
                            Intrinsics.checkNotNullParameter(r3, "value");
                            return r3.unknownFields().size();
                        }

                        @Override // com.lark.wire.ProtoAdapter
                        public final void f(j0 r2, Image r3) {
                            Image r4 = r3;
                            Intrinsics.checkNotNullParameter(r2, "writer");
                            Intrinsics.checkNotNullParameter(r4, "value");
                            r2.a(r4.unknownFields());
                        }

                        @Override // com.lark.wire.ProtoAdapter
                        public final void g(n0 r2, Image r3) {
                            Image r4 = r3;
                            Intrinsics.checkNotNullParameter(r2, "writer");
                            Intrinsics.checkNotNullParameter(r4, "value");
                            r2.d(r4.unknownFields());
                        }

                        public b(FieldEncoding r7, KClass<Image> r8, Syntax r9) {
                            super(r7, r8, "type.googleapis.com/basic.v1.CardContent.JsonAttachment.SummaryContent.Item.Image", r9, null);
                        }
                    }

                    public static final class c {
                        public c() {
                        }
                    }

                    public /* synthetic */ Image(a r1, ByteString r2, DefaultConstructorMarker r3) {
                        this(r2);
                    }

                    static {
                        Companion = new c();
                        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Image.class), Syntax.PROTO_2);
                    }

                    @Override // com.lark.wire.Message
                    public a newBuilder() {
                        a r0 = new a();
                        r0.a(unknownFields());
                        return r0;
                    }

                    @Override // com.lark.wire.Message
                    public String toString() {
                        return Reflection.getOrCreateKotlinClass(Image.class).getSimpleName() + '@' + hashCode();
                    }

                    @Override // com.lark.wire.Message
                    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                        return newBuilder();
                    }

                    public Image(ByteString r2) {
                        super(ADAPTER, r2);
                    }

                    public /* synthetic */ Image(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                        if ((r3 & 2) == 0) goto L5;
                        r2 = ByteString.EMPTY;
                    L5:
                        this(r2);
                    }
                }

                @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent$Item$PersonList;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent$Item$PersonList$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$SummaryContent$Item$PersonList$Builder;Lokio/ByteString;)V", "persons", "", "Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$PersonInfo;", "getPersons", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
                public static final class PersonList extends com.lark.wire.Message<PersonList, a> {
                    public static final ProtoAdapter<PersonList> ADAPTER = null;
                    public static final c Companion = null;
                    private static final long serialVersionUID = 0;
                    private final List<PersonInfo> persons;

                    public static final class a extends com.lark.wire.Message.a<PersonList, a> {
                        public List<PersonInfo> d;

                        @Override // com.lark.wire.Message.a
                        public final com.lark.wire.Message b() {
                            return new PersonList(this, c(), null);
                        }

                        public a() {
                            this.d = CollectionsKt.emptyList();
                        }
                    }

                    public static final class b extends ProtoAdapter<PersonList> {
                        @Override // com.lark.wire.ProtoAdapter
                        public final PersonList c(g0 r7) {
                            Intrinsics.checkNotNullParameter(r7, "reader");
                            a r0 = new a();
                            ArrayList r1 = new ArrayList();
                            long r2 = r7.c();
                        L3:
                            int r4 = r7.e();
                            if (r4 == (-1)) goto L9;
                            if (r4 == 1) goto L7;
                            r7.j(r4);
                            goto L3
                        L7:
                            r1.add(PersonInfo.ADAPTER.c(r7));
                            goto L3
                        L9:
                            ByteString r8 = r7.d(r2);
                            Intrinsics.checkNotNullParameter(r1, "persons");
                            com.lark.wire.internal.a.a(r1);
                            r0.d = r1;
                            return new PersonList(r0, r8, null);
                        }

                        @Override // com.lark.wire.ProtoAdapter
                        public final int k(PersonList r4) {
                            PersonList r5 = r4;
                            Intrinsics.checkNotNullParameter(r5, "value");
                            return r5.unknownFields().size() + PersonInfo.ADAPTER.a().l(1, r5.getPersons());
                        }

                        @Override // com.lark.wire.ProtoAdapter
                        public final void f(j0 r4, PersonList r5) {
                            PersonList r6 = r5;
                            Intrinsics.checkNotNullParameter(r4, "writer");
                            Intrinsics.checkNotNullParameter(r6, "value");
                            PersonInfo.ADAPTER.a().i(r4, 1, r6.getPersons());
                            r4.a(r6.unknownFields());
                        }

                        @Override // com.lark.wire.ProtoAdapter
                        public final void g(n0 r3, PersonList r4) {
                            PersonList r5 = r4;
                            Intrinsics.checkNotNullParameter(r3, "writer");
                            Intrinsics.checkNotNullParameter(r5, "value");
                            r3.d(r5.unknownFields());
                            PersonInfo.ADAPTER.a().j(r3, 1, r5.getPersons());
                        }

                        public b(FieldEncoding r7, KClass<PersonList> r8, Syntax r9) {
                            super(r7, r8, "type.googleapis.com/basic.v1.CardContent.JsonAttachment.SummaryContent.Item.PersonList", r9, null);
                        }
                    }

                    public static final class c {
                        public c() {
                        }
                    }

                    public /* synthetic */ PersonList(a r1, ByteString r2, DefaultConstructorMarker r3) {
                        this(r1, r2);
                    }

                    static {
                        Companion = new c();
                        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PersonList.class), Syntax.PROTO_2);
                    }

                    @Override // com.lark.wire.Message
                    public a newBuilder() {
                        a r0 = new a();
                        r0.d = this.persons;
                        r0.a(unknownFields());
                        return r0;
                    }

                    @Override // com.lark.wire.Message
                    public String toString() {
                        return Reflection.getOrCreateKotlinClass(PersonList.class).getSimpleName() + '@' + hashCode();
                    }

                    public final List<PersonInfo> getPersons() {
                        return this.persons;
                    }

                    @Override // com.lark.wire.Message
                    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                        return newBuilder();
                    }

                    public PersonList(a r2, ByteString r3) {
                        super(ADAPTER, r3);
                        this.persons = com.lark.wire.internal.a.c("persons", r2.d);
                    }

                    public /* synthetic */ PersonList(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                        if ((r3 & 2) == 0) goto L5;
                        r2 = ByteString.EMPTY;
                    L5:
                        this(r1, r2);
                    }
                }

                public static final class a extends com.lark.wire.Message.a<Item, a> {
                    public String d;
                    public Image e;
                    public RichTextElement.AtProperty f;
                    public Emotion g;
                    public PersonList h;
                    public I18NContent i;

                    @Override // com.lark.wire.Message.a
                    public final com.lark.wire.Message b() {
                        return new Item(this, c(), null);
                    }

                    public a() {
                    }
                }

                public static final class b extends ProtoAdapter<Item> {
                    @Override // com.lark.wire.ProtoAdapter
                    public final Item c(g0 r8) {
                        Intrinsics.checkNotNullParameter(r8, "reader");
                        a r1 = new a();
                        long r2 = r8.c();
                    L3:
                        int r4 = r8.e();
                        DefaultConstructorMarker r6 = null;
                        if (r4 == (-1)) goto L14;
                        switch(r4) {
                            case 1: goto L12;
                            case 2: goto L11;
                            case 3: goto L10;
                            case 4: goto L9;
                            case 5: goto L8;
                            case 6: goto L7;
                            default: goto L6;
                        };
                    L7:
                        r1.i = I18NContent.ADAPTER.c(r8);
                        r1.d = null;
                        r1.e = null;
                        r1.f = null;
                        r1.g = null;
                        r1.h = null;
                        goto L3
                    L8:
                        r1.h = PersonList.ADAPTER.c(r8);
                        r1.d = null;
                        r1.e = null;
                        r1.f = null;
                        r1.g = null;
                        r1.i = null;
                        goto L3
                    L9:
                        r1.g = Emotion.ADAPTER.c(r8);
                        r1.d = null;
                        r1.e = null;
                        r1.f = null;
                        r1.h = null;
                        r1.i = null;
                        goto L3
                    L10:
                        r1.f = RichTextElement.AtProperty.ADAPTER.c(r8);
                        r1.d = null;
                        r1.e = null;
                        r1.g = null;
                        r1.h = null;
                        r1.i = null;
                        goto L3
                    L11:
                        r1.e = Image.ADAPTER.c(r8);
                        r1.d = null;
                        r1.f = null;
                        r1.g = null;
                        r1.h = null;
                        r1.i = null;
                        goto L3
                    L12:
                        ProtoAdapter.q.getClass();
                        Intrinsics.checkNotNullParameter(r8, "reader");
                        r1.d = r8.i();
                        r1.e = null;
                        r1.f = null;
                        r1.g = null;
                        r1.h = null;
                        r1.i = null;
                        goto L3
                    L6:
                        r8.j(r4);
                        Unit r5 = Unit.INSTANCE;
                        goto L3
                    L14:
                        return new Item(r1, r8.d(r2), r6);
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final int k(Item r5) {
                        Item r6 = r5;
                        Intrinsics.checkNotNullParameter(r6, "value");
                        return (((((r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getText())) + Image.ADAPTER.l(2, r6.getImage())) + RichTextElement.AtProperty.ADAPTER.l(3, r6.getAt_user())) + Emotion.ADAPTER.l(4, r6.getEmotion())) + PersonList.ADAPTER.l(5, r6.getPerson_list())) + I18NContent.ADAPTER.l(6, r6.getI18n_content());
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final void f(j0 r4, Item r5) {
                        Item r6 = r5;
                        Intrinsics.checkNotNullParameter(r4, "writer");
                        Intrinsics.checkNotNullParameter(r6, "value");
                        ProtoAdapter.q.i(r4, 1, r6.getText());
                        Image.ADAPTER.i(r4, 2, r6.getImage());
                        RichTextElement.AtProperty.ADAPTER.i(r4, 3, r6.getAt_user());
                        Emotion.ADAPTER.i(r4, 4, r6.getEmotion());
                        PersonList.ADAPTER.i(r4, 5, r6.getPerson_list());
                        I18NContent.ADAPTER.i(r4, 6, r6.getI18n_content());
                        r4.a(r6.unknownFields());
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final void g(n0 r4, Item r5) {
                        Item r6 = r5;
                        Intrinsics.checkNotNullParameter(r4, "writer");
                        Intrinsics.checkNotNullParameter(r6, "value");
                        r4.d(r6.unknownFields());
                        I18NContent.ADAPTER.j(r4, 6, r6.getI18n_content());
                        PersonList.ADAPTER.j(r4, 5, r6.getPerson_list());
                        Emotion.ADAPTER.j(r4, 4, r6.getEmotion());
                        RichTextElement.AtProperty.ADAPTER.j(r4, 3, r6.getAt_user());
                        Image.ADAPTER.j(r4, 2, r6.getImage());
                        ProtoAdapter.q.j(r4, 1, r6.getText());
                    }

                    public b(FieldEncoding r7, KClass<Item> r8, Syntax r9) {
                        super(r7, r8, "type.googleapis.com/basic.v1.CardContent.JsonAttachment.SummaryContent.Item", r9, null);
                    }
                }

                public static final class c {
                    public c() {
                    }
                }

                public /* synthetic */ Item(a r1, ByteString r2, DefaultConstructorMarker r3) {
                    this(r1, r2);
                }

                static {
                    Companion = new c();
                    ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Item.class), Syntax.PROTO_2);
                }

                @Override // com.lark.wire.Message
                public a newBuilder() {
                    a r0 = new a();
                    r0.d = this.text;
                    r0.e = this.image;
                    r0.f = this.at_user;
                    r0.g = this.emotion;
                    r0.h = this.person_list;
                    r0.i = this.i18n_content;
                    r0.a(unknownFields());
                    return r0;
                }

                @Override // com.lark.wire.Message
                public String toString() {
                    return Reflection.getOrCreateKotlinClass(Item.class).getSimpleName() + '@' + hashCode();
                }

                public final RichTextElement.AtProperty getAt_user() {
                    return this.at_user;
                }

                public final Emotion getEmotion() {
                    return this.emotion;
                }

                public final I18NContent getI18n_content() {
                    return this.i18n_content;
                }

                public final Image getImage() {
                    return this.image;
                }

                public final PersonList getPerson_list() {
                    return this.person_list;
                }

                public final String getText() {
                    return this.text;
                }

                @Override // com.lark.wire.Message
                public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                    return newBuilder();
                }

                public Item(a r7, ByteString r8) {
                    super(ADAPTER, r8);
                    String r9 = r7.d;
                    this.text = r9;
                    Image r0 = r7.e;
                    this.image = r0;
                    RichTextElement.AtProperty r1 = r7.f;
                    this.at_user = r1;
                    Emotion r2 = r7.g;
                    this.emotion = r2;
                    PersonList r3 = r7.h;
                    this.person_list = r3;
                    I18NContent r10 = r7.i;
                    this.i18n_content = r10;
                    boolean r5 = false;
                    if (com.lark.wire.internal.a.b(r9, r0, r1, r2, new Object[]{r3, r10}) > 1) goto L5;
                    r5 = true;
                L5:
                    if (r5 == false) goto L8;
                    return;
                L8:
                    throw new IllegalArgumentException("At most one of text, image, at_user, emotion, person_list, i18n_content may be non-null".toString());
                }

                public /* synthetic */ Item(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                    if ((r3 & 2) == 0) goto L5;
                    r2 = ByteString.EMPTY;
                L5:
                    this(r1, r2);
                }
            }

            public static final class a extends com.lark.wire.Message.a<SummaryContent, a> {
                public List<Item> d;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new SummaryContent(this, c(), null);
                }

                public a() {
                    this.d = CollectionsKt.emptyList();
                }
            }

            public static final class b extends ProtoAdapter<SummaryContent> {
                @Override // com.lark.wire.ProtoAdapter
                public final SummaryContent c(g0 r7) {
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    a r0 = new a();
                    ArrayList r1 = new ArrayList();
                    long r2 = r7.c();
                L3:
                    int r4 = r7.e();
                    if (r4 == (-1)) goto L9;
                    if (r4 == 1) goto L7;
                    r7.j(r4);
                    goto L3
                L7:
                    r1.add(Item.ADAPTER.c(r7));
                    goto L3
                L9:
                    ByteString r8 = r7.d(r2);
                    Intrinsics.checkNotNullParameter(r1, "items");
                    com.lark.wire.internal.a.a(r1);
                    r0.d = r1;
                    return new SummaryContent(r0, r8, null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(SummaryContent r4) {
                    SummaryContent r5 = r4;
                    Intrinsics.checkNotNullParameter(r5, "value");
                    return r5.unknownFields().size() + Item.ADAPTER.a().l(1, r5.getItems());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r4, SummaryContent r5) {
                    SummaryContent r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    Item.ADAPTER.a().i(r4, 1, r6.getItems());
                    r4.a(r6.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r3, SummaryContent r4) {
                    SummaryContent r5 = r4;
                    Intrinsics.checkNotNullParameter(r3, "writer");
                    Intrinsics.checkNotNullParameter(r5, "value");
                    r3.d(r5.unknownFields());
                    Item.ADAPTER.a().j(r3, 1, r5.getItems());
                }

                public b(FieldEncoding r7, KClass<SummaryContent> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.CardContent.JsonAttachment.SummaryContent", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ SummaryContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(SummaryContent.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.items;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(SummaryContent.class).getSimpleName() + '@' + hashCode();
            }

            public final List<Item> getItems() {
                return this.items;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public SummaryContent(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.items = com.lark.wire.internal.a.c("items", r2.d);
            }

            public /* synthetic */ SummaryContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\"#B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$VideoInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$VideoInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardContent$JsonAttachment$VideoInfo$Builder;Lokio/ByteString;)V", "key", "", "getKey", "()Ljava/lang/String;", "duration", "", "getDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "size", "", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "url", "getUrl", "mime", "getMime", "fs_unit", "getFs_unit", "visit_info", "Lcom/lark/kmp/pb/basic/v1/CardVisitInfo;", "getVisit_info", "()Lcom/lark/kmp/pb/basic/v1/CardVisitInfo;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class VideoInfo extends com.lark.wire.Message<VideoInfo, a> {
            public static final ProtoAdapter<VideoInfo> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final Integer duration;
            private final String fs_unit;
            private final String key;
            private final String mime;
            private final Long size;
            private final String url;
            private final CardVisitInfo visit_info;

            public static final class a extends com.lark.wire.Message.a<VideoInfo, a> {
                public String d;
                public Integer e;
                public Long f;
                public String g;
                public String h;
                public String i;
                public CardVisitInfo j;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new VideoInfo(this, c(), null);
                }

                public a() {
                }
            }

            public static final class b extends ProtoAdapter<VideoInfo> {
                @Override // com.lark.wire.ProtoAdapter
                public final VideoInfo c(g0 r7) {
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    a r1 = new a();
                    long r2 = r7.c();
                L3:
                    int r4 = r7.e();
                    if (r4 == (-1)) goto L15;
                    switch(r4) {
                        case 1: goto L13;
                        case 2: goto L12;
                        case 3: goto L11;
                        case 4: goto L10;
                        case 5: goto L9;
                        case 6: goto L8;
                        case 7: goto L7;
                        default: goto L6;
                    };
                L7:
                    r1.j = CardVisitInfo.ADAPTER.c(r7);
                    goto L3
                L8:
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    r1.i = r7.i();
                    goto L3
                L9:
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    r1.h = r7.i();
                    goto L3
                L10:
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    r1.g = r7.i();
                    goto L3
                L11:
                    r1.f = (Long) ProtoAdapter.k.c(r7);
                    goto L3
                L12:
                    r1.e = (Integer) ProtoAdapter.h.c(r7);
                    goto L3
                L13:
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    r1.d = r7.i();
                    goto L3
                L6:
                    r7.j(r4);
                    Unit r5 = Unit.INSTANCE;
                    goto L3
                L15:
                    return new VideoInfo(r1, r7.d(r2), null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(VideoInfo r6) {
                    VideoInfo r7 = r6;
                    Intrinsics.checkNotNullParameter(r7, "value");
                    int r0 = r7.unknownFields().size();
                    w r1 = ProtoAdapter.q;
                    return ((((((r0 + r1.l(1, r7.getKey())) + ProtoAdapter.h.l(2, r7.getDuration())) + ProtoAdapter.k.l(3, r7.getSize())) + r1.l(4, r7.getUrl())) + r1.l(5, r7.getMime())) + r1.l(6, r7.getFs_unit())) + CardVisitInfo.ADAPTER.l(7, r7.getVisit_info());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r5, VideoInfo r6) {
                    VideoInfo r7 = r6;
                    Intrinsics.checkNotNullParameter(r5, "writer");
                    Intrinsics.checkNotNullParameter(r7, "value");
                    w r0 = ProtoAdapter.q;
                    r0.i(r5, 1, r7.getKey());
                    ProtoAdapter.h.i(r5, 2, r7.getDuration());
                    ProtoAdapter.k.i(r5, 3, r7.getSize());
                    r0.i(r5, 4, r7.getUrl());
                    r0.i(r5, 5, r7.getMime());
                    r0.i(r5, 6, r7.getFs_unit());
                    CardVisitInfo.ADAPTER.i(r5, 7, r7.getVisit_info());
                    r5.a(r7.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r5, VideoInfo r6) {
                    VideoInfo r7 = r6;
                    Intrinsics.checkNotNullParameter(r5, "writer");
                    Intrinsics.checkNotNullParameter(r7, "value");
                    r5.d(r7.unknownFields());
                    CardVisitInfo.ADAPTER.j(r5, 7, r7.getVisit_info());
                    w r0 = ProtoAdapter.q;
                    r0.j(r5, 6, r7.getFs_unit());
                    r0.j(r5, 5, r7.getMime());
                    r0.j(r5, 4, r7.getUrl());
                    ProtoAdapter.k.j(r5, 3, r7.getSize());
                    ProtoAdapter.h.j(r5, 2, r7.getDuration());
                    r0.j(r5, 1, r7.getKey());
                }

                public b(FieldEncoding r7, KClass<VideoInfo> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.CardContent.JsonAttachment.VideoInfo", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ VideoInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(VideoInfo.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.key;
                r0.e = this.duration;
                r0.f = this.size;
                r0.g = this.url;
                r0.h = this.mime;
                r0.i = this.fs_unit;
                r0.j = this.visit_info;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(VideoInfo.class).getSimpleName() + '@' + hashCode();
            }

            public final Integer getDuration() {
                return this.duration;
            }

            public final String getFs_unit() {
                return this.fs_unit;
            }

            public final String getKey() {
                return this.key;
            }

            public final String getMime() {
                return this.mime;
            }

            public final Long getSize() {
                return this.size;
            }

            public final String getUrl() {
                return this.url;
            }

            public final CardVisitInfo getVisit_info() {
                return this.visit_info;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public VideoInfo(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.key = r2.d;
                this.duration = r2.e;
                this.size = r2.f;
                this.url = r2.g;
                this.mime = r2.h;
                this.fs_unit = r2.i;
                this.visit_info = r2.j;
            }

            public /* synthetic */ VideoInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        public static final class a extends com.lark.wire.Message.a<JsonAttachment, a> {
            public Map<String, RichTextElement.ImageProperty> d;
            public Map<String, RichTextElement.AtProperty> e;
            public Map<String, OptionUser> f;
            public SummaryContent g;
            public Boolean h;
            public Map<String, String> i;
            public Map<String, PersonInfo> j;
            public Map<String, AudioInfo> k;
            public String l;
            public Map<String, VideoInfo> m;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new JsonAttachment(this, c(), null);
            }

            public a() {
                this.d = MapsKt.emptyMap();
                this.e = MapsKt.emptyMap();
                this.f = MapsKt.emptyMap();
                this.i = MapsKt.emptyMap();
                this.j = MapsKt.emptyMap();
                this.k = MapsKt.emptyMap();
                this.m = MapsKt.emptyMap();
            }
        }

        public static final class b {
            public b() {
            }
        }

        public /* synthetic */ JsonAttachment(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new b();
            final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
            final KClass r1 = Reflection.getOrCreateKotlinClass(JsonAttachment.class);
            final Syntax r2 = Syntax.PROTO_2;
            ADAPTER = new CardContent$JsonAttachment$Companion$ADAPTER$1(r0, r1, r2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.images;
            r0.e = this.at_users;
            r0.f = this.option_users;
            r0.g = this.summary;
            r0.h = this.is_forward;
            r0.i = this.component_status_by_name;
            r0.j = this.persons;
            r0.k = this.audios;
            r0.l = this.card_simple_summary;
            r0.m = this.videos;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(JsonAttachment.class).getSimpleName() + '@' + hashCode();
        }

        public final Map<String, RichTextElement.AtProperty> getAt_users() {
            return this.at_users;
        }

        public final Map<String, AudioInfo> getAudios() {
            return this.audios;
        }

        public final String getCard_simple_summary() {
            return this.card_simple_summary;
        }

        public final Map<String, String> getComponent_status_by_name() {
            return this.component_status_by_name;
        }

        public final Map<String, RichTextElement.ImageProperty> getImages() {
            return this.images;
        }

        public final Map<String, OptionUser> getOption_users() {
            return this.option_users;
        }

        public final Map<String, PersonInfo> getPersons() {
            return this.persons;
        }

        public final SummaryContent getSummary() {
            return this.summary;
        }

        public final Map<String, VideoInfo> getVideos() {
            return this.videos;
        }

        public final Boolean is_forward() {
            return this.is_forward;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public JsonAttachment(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.images = com.lark.wire.internal.a.d("images", r2.d);
            this.at_users = com.lark.wire.internal.a.d("at_users", r2.e);
            this.option_users = com.lark.wire.internal.a.d("option_users", r2.f);
            this.summary = r2.g;
            this.is_forward = r2.h;
            this.component_status_by_name = com.lark.wire.internal.a.d("component_status_by_name", r2.i);
            this.persons = com.lark.wire.internal.a.d("persons", r2.j);
            this.audios = com.lark.wire.internal.a.d("audios", r2.k);
            this.card_simple_summary = r2.l;
            this.videos = com.lark.wire.internal.a.d("videos", r2.m);
        }

        public /* synthetic */ JsonAttachment(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\b\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardContent$MeegoConfig;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardContent$MeegoConfig$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardContent$MeegoConfig$Builder;Lokio/ByteString;)V", "is_preload", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class MeegoConfig extends com.lark.wire.Message<MeegoConfig, a> {
        public static final ProtoAdapter<MeegoConfig> ADAPTER = null;
        public static final c Companion = null;
        public static final boolean DEFAULT_IS_PRELOAD = false;
        private static final long serialVersionUID = 0;
        private final Boolean is_preload;

        public static final class a extends com.lark.wire.Message.a<MeegoConfig, a> {
            public Boolean d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new MeegoConfig(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<MeegoConfig> {
            @Override // com.lark.wire.ProtoAdapter
            public final MeegoConfig c(g0 r6) {
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
                r0.d = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L10:
                return new MeegoConfig(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(MeegoConfig r4) {
                MeegoConfig r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ProtoAdapter.g.l(1, r5.is_preload());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, MeegoConfig r5) {
                MeegoConfig r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.g.i(r4, 1, r6.is_preload());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, MeegoConfig r4) {
                MeegoConfig r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ProtoAdapter.g.j(r3, 1, r5.is_preload());
            }

            public b(FieldEncoding r7, KClass<MeegoConfig> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.CardContent.MeegoConfig", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ MeegoConfig(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MeegoConfig.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.is_preload;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(MeegoConfig.class).getSimpleName() + '@' + hashCode();
        }

        public final Boolean is_preload() {
            return this.is_preload;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public MeegoConfig(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.is_preload = r2.d;
        }

        public /* synthetic */ MeegoConfig(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardContent$PatchInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardContent$PatchInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardContent$PatchInfo$Builder;Lokio/ByteString;)V", "target_version", "", "getTarget_version", "()J", "patch_version", "getPatch_version", "data_source", "Lcom/lark/kmp/pb/basic/v1/CardContent$DataSource;", "getData_source", "()Lcom/lark/kmp/pb/basic/v1/CardContent$DataSource;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class PatchInfo extends com.lark.wire.Message<PatchInfo, a> {
        public static final ProtoAdapter<PatchInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final DataSource data_source;
        private final long patch_version;
        private final long target_version;

        public static final class a extends com.lark.wire.Message.a<PatchInfo, a> {
            public Long d;
            public Long e;
            public DataSource f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new PatchInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<PatchInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final PatchInfo c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L19;
                if (r3 != 1) goto L8;
                r0.d = Long.valueOf(((Number) ProtoAdapter.k.c(r9)).longValue());
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.e = Long.valueOf(((Number) ProtoAdapter.k.c(r9)).longValue());
                goto L3
            L10:
                if (r3 != 3) goto L11;
                DataSource r4 = DataSource.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
                Intrinsics.checkNotNullParameter(r4, "data_source");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
                r0.f = r4;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L11:
                r9.j(r3);
                goto L3
            L19:
                return new PatchInfo(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(PatchInfo r5) {
                PatchInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                t r1 = ProtoAdapter.k;
                return ((r0 + r1.l(1, Long.valueOf(r6.getTarget_version()))) + r1.l(2, Long.valueOf(r6.getPatch_version()))) + DataSource.ADAPTER.l(3, r6.getData_source());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, PatchInfo r5) {
                PatchInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                t r0 = ProtoAdapter.k;
                r0.i(r4, 1, Long.valueOf(r6.getTarget_version()));
                r0.i(r4, 2, Long.valueOf(r6.getPatch_version()));
                DataSource.ADAPTER.i(r4, 3, r6.getData_source());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, PatchInfo r5) {
                PatchInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                DataSource.ADAPTER.j(r4, 3, r6.getData_source());
                t r0 = ProtoAdapter.k;
                r0.j(r4, 2, Long.valueOf(r6.getPatch_version()));
                r0.j(r4, 1, Long.valueOf(r6.getTarget_version()));
            }

            public b(FieldEncoding r7, KClass<PatchInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.CardContent.PatchInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ PatchInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PatchInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = Long.valueOf(this.target_version);
            r0.e = Long.valueOf(this.patch_version);
            r0.f = this.data_source;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(PatchInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final DataSource getData_source() {
            return this.data_source;
        }

        public final long getPatch_version() {
            return this.patch_version;
        }

        public final long getTarget_version() {
            return this.target_version;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public PatchInfo(a r3, ByteString r4) {
            super(ADAPTER, r4);
            Long r5 = r3.d;
            Intrinsics.checkNotNull(r5);
            this.target_version = r5.longValue();
            Long r6 = r3.e;
            Intrinsics.checkNotNull(r6);
            this.patch_version = r6.longValue();
            DataSource r7 = r3.f;
            Intrinsics.checkNotNull(r7);
            this.data_source = r7;
        }

        public /* synthetic */ PatchInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardContent$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_TYPE", "VOTE", "TEXT", "VCHAT", "OPEN_CARD", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final b Companion = null;
        public static final Type OPEN_CARD = null;
        public static final Type TEXT = null;
        public static final Type UNKNOWN_TYPE = null;
        public static final Type VCHAT = null;
        public static final Type VOTE = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Type.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Type> r1, Syntax r2, Type r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Type a(int r1) {
                if (r1 == 0) goto L17;
                if (r1 == 1) goto L22;
                if (r1 == 2) goto L21;
                if (r1 == 3) goto L20;
                if (r1 == 4) goto L19;
                return null;
            L19:
                return Type.OPEN_CARD;
            L20:
                return Type.VCHAT;
            L21:
                return Type.TEXT;
            L22:
                return Type.VOTE;
            L17:
                return Type.UNKNOWN_TYPE;
            }
        }

        @JvmStatic
        public static final Type fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r0;
            Type r1 = new Type("VOTE", 1, 1);
            VOTE = r1;
            Type r3 = new Type("TEXT", 2, 2);
            TEXT = r3;
            Type r5 = new Type("VCHAT", 3, 3);
            VCHAT = r5;
            Type r7 = new Type("OPEN_CARD", 4, 4);
            OPEN_CARD = r7;
            Type[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2, r0);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardContent$Url;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardContent$Url$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardContent$Url$Builder;Lokio/ByteString;)V", "url", "", "getUrl", "()Ljava/lang/String;", "ios_url", "getIos_url", "android_url", "getAndroid_url", "pc_url", "getPc_url", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Url extends com.lark.wire.Message<Url, a> {
        public static final ProtoAdapter<Url> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String android_url;
        private final String ios_url;
        private final String pc_url;
        private final String url;

        public static final class a extends com.lark.wire.Message.a<Url, a> {
            public String d;
            public String e;
            public String f;
            public String g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Url(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Url> {
            @Override // com.lark.wire.ProtoAdapter
            public final Url c(g0 r7) {
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
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.g = r7.i();
                goto L3
            L13:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L19:
                return new Url(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Url r5) {
                Url r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return (((r0 + r1.l(1, r6.getUrl())) + r1.l(2, r6.getIos_url())) + r1.l(3, r6.getAndroid_url())) + r1.l(4, r6.getPc_url());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Url r5) {
                Url r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getUrl());
                r0.i(r4, 2, r6.getIos_url());
                r0.i(r4, 3, r6.getAndroid_url());
                r0.i(r4, 4, r6.getPc_url());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, Url r5) {
                Url r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 4, r6.getPc_url());
                r0.j(r4, 3, r6.getAndroid_url());
                r0.j(r4, 2, r6.getIos_url());
                r0.j(r4, 1, r6.getUrl());
            }

            public b(FieldEncoding r7, KClass<Url> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.CardContent.Url", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Url(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Url.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.url;
            r0.e = this.ios_url;
            r0.f = this.android_url;
            r0.g = this.pc_url;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Url.class).getSimpleName() + '@' + hashCode();
        }

        public final String getAndroid_url() {
            return this.android_url;
        }

        public final String getIos_url() {
            return this.ios_url;
        }

        public final String getPc_url() {
            return this.pc_url;
        }

        public final String getUrl() {
            return this.url;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Url(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.url = r2.d;
            this.ios_url = r2.e;
            this.android_url = r2.f;
            this.pc_url = r2.g;
        }

        public /* synthetic */ Url(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<CardContent, a> {
        public String A;
        public String B;
        public Type d;
        public RichText e;
        public Map<String, CardAction> f;
        public ExtraType g;
        public Integer h;
        public CardHeader i;
        public Boolean j;
        public ExtraInfo k;
        public Boolean l;
        public Boolean m;
        public String n;
        public JsonAttachment o;
        public String p;
        public CardAppInfo q;
        public String r;
        public String s;
        public Boolean t;
        public String u;
        public UniversalCardEntity.StreamingConfig v;
        public List<Url> w;
        public PatchInfo x;
        public String y;
        public UniversalCardEntity z;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new CardContent(this, c(), null);
        }

        public a() {
            this.f = MapsKt.emptyMap();
            this.w = CollectionsKt.emptyList();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ CardContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(CardContent.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new CardContent$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.type;
        r0.e = this.richtext;
        r0.f = this.actions;
        r0.g = this.extra;
        r0.h = this.card_version;
        r0.i = this.card_header;
        r0.j = this.wide_screen_mode;
        r0.k = this.extra_info;
        r0.l = this.enable_forward;
        r0.m = this.compact_width;
        r0.n = this.json_body;
        r0.o = this.json_attachment;
        r0.p = this.width_mode;
        r0.q = this.app_info;
        r0.r = this.card_id;
        r0.s = this.version;
        r0.t = this.streaming_mode;
        r0.u = this.json_card_header_theme;
        r0.v = this.streaming_config;
        r0.w = this.json_card_urls;
        r0.x = this.patch_info;
        r0.y = this.universal_host_card_id;
        r0.z = this.universal_card_entity;
        r0.A = this.biz_id;
        r0.B = this.action_url;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(CardContent.class).getSimpleName() + '@' + hashCode();
    }

    public final String getAction_url() {
        return this.action_url;
    }

    public final Map<String, CardAction> getActions() {
        return this.actions;
    }

    public final CardAppInfo getApp_info() {
        return this.app_info;
    }

    public final String getBiz_id() {
        return this.biz_id;
    }

    public final CardHeader getCard_header() {
        return this.card_header;
    }

    public final String getCard_id() {
        return this.card_id;
    }

    public final Integer getCard_version() {
        return this.card_version;
    }

    public final Boolean getCompact_width() {
        return this.compact_width;
    }

    public final Boolean getEnable_forward() {
        return this.enable_forward;
    }

    public final ExtraType getExtra() {
        return this.extra;
    }

    public final ExtraInfo getExtra_info() {
        return this.extra_info;
    }

    public final JsonAttachment getJson_attachment() {
        return this.json_attachment;
    }

    public final String getJson_body() {
        return this.json_body;
    }

    public final String getJson_card_header_theme() {
        return this.json_card_header_theme;
    }

    public final List<Url> getJson_card_urls() {
        return this.json_card_urls;
    }

    public final PatchInfo getPatch_info() {
        return this.patch_info;
    }

    public final RichText getRichtext() {
        return this.richtext;
    }

    public final UniversalCardEntity.StreamingConfig getStreaming_config() {
        return this.streaming_config;
    }

    public final Boolean getStreaming_mode() {
        return this.streaming_mode;
    }

    public final Type getType() {
        return this.type;
    }

    public final UniversalCardEntity getUniversal_card_entity() {
        return this.universal_card_entity;
    }

    public final String getUniversal_host_card_id() {
        return this.universal_host_card_id;
    }

    public final String getVersion() {
        return this.version;
    }

    public final Boolean getWide_screen_mode() {
        return this.wide_screen_mode;
    }

    public final String getWidth_mode() {
        return this.width_mode;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public CardContent(a r2, ByteString r3) {
        super(ADAPTER, r3);
        Type r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.type = r4;
        RichText r5 = r2.e;
        Intrinsics.checkNotNull(r5);
        this.richtext = r5;
        this.actions = com.lark.wire.internal.a.d("actions", r2.f);
        this.extra = r2.g;
        this.card_version = r2.h;
        this.card_header = r2.i;
        this.wide_screen_mode = r2.j;
        this.extra_info = r2.k;
        this.enable_forward = r2.l;
        this.compact_width = r2.m;
        this.json_body = r2.n;
        this.json_attachment = r2.o;
        this.width_mode = r2.p;
        this.app_info = r2.q;
        this.card_id = r2.r;
        this.version = r2.s;
        this.streaming_mode = r2.t;
        this.json_card_header_theme = r2.u;
        this.streaming_config = r2.v;
        this.json_card_urls = com.lark.wire.internal.a.c("json_card_urls", r2.w);
        this.patch_info = r2.x;
        this.universal_host_card_id = r2.y;
        this.universal_card_entity = r2.z;
        this.biz_id = r2.A;
        this.action_url = r2.B;
    }

    public /* synthetic */ CardContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
