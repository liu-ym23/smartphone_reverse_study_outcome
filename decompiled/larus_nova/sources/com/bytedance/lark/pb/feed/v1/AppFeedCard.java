package com.bytedance.lark.pb.feed.v1;

import com.bytedance.lark.pb.basic.v1.FeedButtonData;
import com.bytedance.lark.pb.basic.v1.Image;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class AppFeedCard extends Message<AppFeedCard, Builder> {
    public static final ProtoAdapter<AppFeedCard> ADAPTER = null;
    public static final Long DEFAULT_APP_ID = null;
    public static final String DEFAULT_BIZ_ID = "";
    public static final ByteString DEFAULT_EXTRA_DATA = null;
    public static final String DEFAULT_EXTRA_DATA_JSON = "";
    public static final Long DEFAULT_ID = null;
    public static final AppFeedCardType DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final Long app_id;
    public final AvatarData avatar_data;
    public final BadgeData badge_data;
    public final ExtraData biz_extra_data;
    public final String biz_id;
    public final FeedButtonData button_data;
    public final DisplayTimeData display_time_data;
    public final ByteString extra_data;
    public final String extra_data_json;
    public final FeedDefaultData feed_default_data;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final Long f253619id;
    public final LinkData link_data;
    public final PreviewData preview_data;
    public final SettingData setting_data;
    public final StatusData status_data;
    public final StatusLabelData status_label_data;
    public final TitleData title_data;
    public final AppFeedCardType type;

    public static final class AvatarData extends Message<AvatarData, Builder> {
        public static final ProtoAdapter<AvatarData> ADAPTER = null;
        public static final Long DEFAULT_VERSION = null;
        private static final long serialVersionUID = 0;
        public final Image avatar;
        public final Long version;

        public static final class Builder extends Message.Builder<AvatarData, Builder> {
            public Image avatar;
            public Long version;

            @Override // com.squareup.wire.Message.Builder
            public AvatarData build() {
                return new AvatarData(this.avatar, this.version, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder avatar(Image r100) {
                this.avatar = r100;
                return this;
            }

            public Builder version(Long r100) {
                this.version = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_AvatarData extends ProtoAdapter<AvatarData> {
            public ProtoAdapter_AvatarData() {
                super(FieldEncoding.LENGTH_DELIMITED, AvatarData.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AvatarData decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.version = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.avatar = Image.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 10) goto L9;
                r101.version = ProtoAdapter.INT64.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(AvatarData r100) {
                Image r101 = r100.avatar;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Image.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.version;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT64.encodedSizeWithTag(10, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AvatarData decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AvatarData r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AvatarData r101) throws IOException {
                Image r102 = r101.avatar;
                if (r102 == null) goto L5;
                Image.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.version;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 10, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AvatarData r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AvatarData();
            DEFAULT_VERSION = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.avatar = this.avatar;
            r100.version = this.version;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return AvatarData.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public AvatarData(Image r100, Long r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public AvatarData(Image r100, Long r101, ByteString r102) {
            super(ADAPTER, r102);
            this.avatar = r100;
            this.version = r101;
        }
    }

    public static final class BadgeData extends Message<BadgeData, Builder> {
        public static final ProtoAdapter<BadgeData> ADAPTER = null;
        public static final Long DEFAULT_BADGE = null;
        public static final Long DEFAULT_VERSION = null;
        private static final long serialVersionUID = 0;
        public final Long badge;
        public final Long version;

        public static final class Builder extends Message.Builder<BadgeData, Builder> {
            public Long badge;
            public Long version;

            @Override // com.squareup.wire.Message.Builder
            public BadgeData build() {
                return new BadgeData(this.badge, this.version, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder badge(Long r100) {
                this.badge = r100;
                return this;
            }

            public Builder version(Long r100) {
                this.version = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_BadgeData extends ProtoAdapter<BadgeData> {
            public ProtoAdapter_BadgeData() {
                super(FieldEncoding.LENGTH_DELIMITED, BadgeData.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public BadgeData decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.badge = 0L;
                r101.version = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.badge = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 10) goto L9;
                r101.version = ProtoAdapter.INT64.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(BadgeData r100) {
                Long r101 = r100.badge;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.version;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT64.encodedSizeWithTag(10, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ BadgeData decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(BadgeData r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, BadgeData r101) throws IOException {
                Long r102 = r101.badge;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.version;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 10, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BadgeData r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_BadgeData();
            DEFAULT_BADGE = 0L;
            DEFAULT_VERSION = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.badge = this.badge;
            r100.version = this.version;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return BadgeData.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public BadgeData(Long r100, Long r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public BadgeData(Long r100, Long r101, ByteString r102) {
            super(ADAPTER, r102);
            this.badge = r100;
            this.version = r101;
        }
    }

    public static final class Builder extends Message.Builder<AppFeedCard, Builder> {
        public Long app_id;
        public AvatarData avatar_data;
        public BadgeData badge_data;
        public ExtraData biz_extra_data;
        public String biz_id;
        public FeedButtonData button_data;
        public DisplayTimeData display_time_data;
        public ByteString extra_data;
        public String extra_data_json;
        public FeedDefaultData feed_default_data;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public Long f253620id;
        public LinkData link_data;
        public PreviewData preview_data;
        public SettingData setting_data;
        public StatusData status_data;
        public StatusLabelData status_label_data;
        public TitleData title_data;
        public AppFeedCardType type;

        @Override // com.squareup.wire.Message.Builder
        public AppFeedCard build() {
            return new AppFeedCard(this.f253620id, this.type, this.biz_id, this.app_id, this.title_data, this.avatar_data, this.preview_data, this.badge_data, this.display_time_data, this.status_label_data, this.button_data, this.setting_data, this.status_data, this.extra_data, this.extra_data_json, this.biz_extra_data, this.link_data, this.feed_default_data, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_id(Long r100) {
            this.app_id = r100;
            return this;
        }

        public Builder avatar_data(AvatarData r100) {
            this.avatar_data = r100;
            return this;
        }

        public Builder badge_data(BadgeData r100) {
            this.badge_data = r100;
            return this;
        }

        public Builder biz_extra_data(ExtraData r100) {
            this.biz_extra_data = r100;
            return this;
        }

        public Builder biz_id(String r100) {
            this.biz_id = r100;
            return this;
        }

        public Builder button_data(FeedButtonData r100) {
            this.button_data = r100;
            return this;
        }

        public Builder display_time_data(DisplayTimeData r100) {
            this.display_time_data = r100;
            return this;
        }

        public Builder extra_data(ByteString r100) {
            this.extra_data = r100;
            return this;
        }

        public Builder extra_data_json(String r100) {
            this.extra_data_json = r100;
            return this;
        }

        public Builder feed_default_data(FeedDefaultData r100) {
            this.feed_default_data = r100;
            return this;
        }

        public Builder id(Long r100) {
            this.f253620id = r100;
            return this;
        }

        public Builder link_data(LinkData r100) {
            this.link_data = r100;
            return this;
        }

        public Builder preview_data(PreviewData r100) {
            this.preview_data = r100;
            return this;
        }

        public Builder setting_data(SettingData r100) {
            this.setting_data = r100;
            return this;
        }

        public Builder status_data(StatusData r100) {
            this.status_data = r100;
            return this;
        }

        public Builder status_label_data(StatusLabelData r100) {
            this.status_label_data = r100;
            return this;
        }

        public Builder title_data(TitleData r100) {
            this.title_data = r100;
            return this;
        }

        public Builder type(AppFeedCardType r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class DisplayTimeData extends Message<DisplayTimeData, Builder> {
        public static final ProtoAdapter<DisplayTimeData> ADAPTER = null;
        public static final Long DEFAULT_DISPLAY_TIME_MS = null;
        public static final Long DEFAULT_VERSION = null;
        private static final long serialVersionUID = 0;
        public final Long display_time_ms;
        public final Long version;

        public static final class Builder extends Message.Builder<DisplayTimeData, Builder> {
            public Long display_time_ms;
            public Long version;

            @Override // com.squareup.wire.Message.Builder
            public DisplayTimeData build() {
                return new DisplayTimeData(this.display_time_ms, this.version, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder display_time_ms(Long r100) {
                this.display_time_ms = r100;
                return this;
            }

            public Builder version(Long r100) {
                this.version = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DisplayTimeData extends ProtoAdapter<DisplayTimeData> {
            public ProtoAdapter_DisplayTimeData() {
                super(FieldEncoding.LENGTH_DELIMITED, DisplayTimeData.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DisplayTimeData decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.display_time_ms = 0L;
                r101.version = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.display_time_ms = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 10) goto L9;
                r101.version = ProtoAdapter.INT64.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DisplayTimeData r100) {
                Long r101 = r100.display_time_ms;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.version;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT64.encodedSizeWithTag(10, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DisplayTimeData decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DisplayTimeData r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DisplayTimeData r101) throws IOException {
                Long r102 = r101.display_time_ms;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.version;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 10, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DisplayTimeData r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DisplayTimeData();
            DEFAULT_DISPLAY_TIME_MS = 0L;
            DEFAULT_VERSION = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.display_time_ms = this.display_time_ms;
            r100.version = this.version;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DisplayTimeData.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DisplayTimeData(Long r100, Long r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public DisplayTimeData(Long r100, Long r101, ByteString r102) {
            super(ADAPTER, r102);
            this.display_time_ms = r100;
            this.version = r101;
        }
    }

    public static final class ExtraData extends Message<ExtraData, Builder> {
        public static final ProtoAdapter<ExtraData> ADAPTER = null;
        public static final ByteString DEFAULT_EXTRA_DATA = null;
        public static final String DEFAULT_EXTRA_DATA_JSON = "";
        private static final long serialVersionUID = 0;
        public final BizFields biz_fields;
        public final ByteString extra_data;
        public final String extra_data_json;

        public static final class BizFields extends Message<BizFields, Builder> {
            public static final ProtoAdapter<BizFields> ADAPTER = null;
            public static final String DEFAULT_CONTACT_NAME = "";
            public static final Long DEFAULT_MAIL_ACCOUNT_ID = null;
            private static final long serialVersionUID = 0;
            public final String contact_name;
            public final Long mail_account_id;

            public static final class Builder extends Message.Builder<BizFields, Builder> {
                public String contact_name;
                public Long mail_account_id;

                @Override // com.squareup.wire.Message.Builder
                public BizFields build() {
                    return new BizFields(this.mail_account_id, this.contact_name, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder contact_name(String r100) {
                    this.contact_name = r100;
                    return this;
                }

                public Builder mail_account_id(Long r100) {
                    this.mail_account_id = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_BizFields extends ProtoAdapter<BizFields> {
                public ProtoAdapter_BizFields() {
                    super(FieldEncoding.LENGTH_DELIMITED, BizFields.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public BizFields decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.mail_account_id = 0L;
                    r101.contact_name = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L12;
                    if (r103 != 1) goto L8;
                    r101.mail_account_id = ProtoAdapter.INT64.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L9;
                    r101.contact_name = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L9:
                    FieldEncoding r104 = r100.peekFieldEncoding();
                    r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                    goto L3
                L12:
                    r100.endMessage(r102);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(BizFields r100) {
                    Long r101 = r100.mail_account_id;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
                L6:
                    String r104 = r100.contact_name;
                    if (r104 == null) goto L10;
                    r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
                L10:
                    return (r103 + r102) + r100.unknownFields().size();
                L5:
                    r103 = 0;
                    goto L6
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ BizFields decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(BizFields r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, BizFields r101) throws IOException {
                    Long r102 = r101.mail_account_id;
                    if (r102 == null) goto L5;
                    ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
                L5:
                    String r103 = r101.contact_name;
                    if (r103 == null) goto L8;
                    ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
                L8:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BizFields r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_BizFields();
                DEFAULT_MAIL_ACCOUNT_ID = 0L;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.mail_account_id = this.mail_account_id;
                r100.contact_name = this.contact_name;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return BizFields.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public BizFields(Long r100, String r101) {
                this(r100, r101, ByteString.EMPTY);
            }

            public BizFields(Long r100, String r101, ByteString r102) {
                super(ADAPTER, r102);
                this.mail_account_id = r100;
                this.contact_name = r101;
            }
        }

        public static final class Builder extends Message.Builder<ExtraData, Builder> {
            public BizFields biz_fields;
            public ByteString extra_data;
            public String extra_data_json;

            @Override // com.squareup.wire.Message.Builder
            public ExtraData build() {
                return new ExtraData(this.extra_data, this.extra_data_json, this.biz_fields, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder biz_fields(BizFields r100) {
                this.biz_fields = r100;
                return this;
            }

            public Builder extra_data(ByteString r100) {
                this.extra_data = r100;
                return this;
            }

            public Builder extra_data_json(String r100) {
                this.extra_data_json = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ExtraData extends ProtoAdapter<ExtraData> {
            public ProtoAdapter_ExtraData() {
                super(FieldEncoding.LENGTH_DELIMITED, ExtraData.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ExtraData decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.extra_data = ByteString.EMPTY;
                r101.extra_data_json = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.extra_data = ProtoAdapter.BYTES.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.extra_data_json = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.biz_fields = BizFields.ADAPTER.decode(r100);
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ExtraData r100) {
                ByteString r101 = r100.extra_data;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BYTES.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.extra_data_json;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                BizFields r107 = r100.biz_fields;
                if (r107 == null) goto L14;
                r102 = BizFields.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                return (r106 + r102) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ExtraData decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ExtraData r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ExtraData r101) throws IOException {
                ByteString r102 = r101.extra_data;
                if (r102 == null) goto L5;
                ProtoAdapter.BYTES.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.extra_data_json;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                BizFields r104 = r101.biz_fields;
                if (r104 == null) goto L11;
                BizFields.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ExtraData r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ExtraData();
            DEFAULT_EXTRA_DATA = ByteString.EMPTY;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.extra_data = this.extra_data;
            r100.extra_data_json = this.extra_data_json;
            r100.biz_fields = this.biz_fields;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ExtraData.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ExtraData(ByteString r100, String r101, BizFields r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public ExtraData(ByteString r100, String r101, BizFields r102, ByteString r103) {
            super(ADAPTER, r103);
            this.extra_data = r100;
            this.extra_data_json = r101;
            this.biz_fields = r102;
        }
    }

    public static final class FeedDefaultData extends Message<FeedDefaultData, Builder> {
        public static final ProtoAdapter<FeedDefaultData> ADAPTER = null;
        public static final Boolean DEFAULT_IS_SHORTCUT = null;
        public static final Long DEFAULT_RANK_TIME = null;
        public static final Long DEFAULT_VERSION = null;
        private static final long serialVersionUID = 0;
        public final Boolean is_shortcut;
        public final Long rank_time;
        public final Long version;

        public static final class Builder extends Message.Builder<FeedDefaultData, Builder> {
            public Boolean is_shortcut;
            public Long rank_time;
            public Long version;

            @Override // com.squareup.wire.Message.Builder
            public FeedDefaultData build() {
                return new FeedDefaultData(this.rank_time, this.is_shortcut, this.version, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder is_shortcut(Boolean r100) {
                this.is_shortcut = r100;
                return this;
            }

            public Builder rank_time(Long r100) {
                this.rank_time = r100;
                return this;
            }

            public Builder version(Long r100) {
                this.version = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_FeedDefaultData extends ProtoAdapter<FeedDefaultData> {
            public ProtoAdapter_FeedDefaultData() {
                super(FieldEncoding.LENGTH_DELIMITED, FeedDefaultData.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public FeedDefaultData decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.rank_time = 0L;
                r101.is_shortcut = Boolean.FALSE;
                r101.version = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.rank_time = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.is_shortcut = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                if (r103 != 10) goto L11;
                r101.version = ProtoAdapter.INT64.decode(r100);
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(FeedDefaultData r100) {
                Long r101 = r100.rank_time;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.is_shortcut;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Long r107 = r100.version;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.INT64.encodedSizeWithTag(10, r107);
            L14:
                return (r106 + r102) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ FeedDefaultData decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(FeedDefaultData r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, FeedDefaultData r101) throws IOException {
                Long r102 = r101.rank_time;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.is_shortcut;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                Long r104 = r101.version;
                if (r104 == null) goto L11;
                ProtoAdapter.INT64.encodeWithTag(r100, 10, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FeedDefaultData r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_FeedDefaultData();
            DEFAULT_RANK_TIME = 0L;
            DEFAULT_IS_SHORTCUT = Boolean.FALSE;
            DEFAULT_VERSION = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.rank_time = this.rank_time;
            r100.is_shortcut = this.is_shortcut;
            r100.version = this.version;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return FeedDefaultData.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public FeedDefaultData(Long r100, Boolean r101, Long r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public FeedDefaultData(Long r100, Boolean r101, Long r102, ByteString r103) {
            super(ADAPTER, r103);
            this.rank_time = r100;
            this.is_shortcut = r101;
            this.version = r102;
        }
    }

    public static final class LinkData extends Message<LinkData, Builder> {
        public static final ProtoAdapter<LinkData> ADAPTER = null;
        public static final String DEFAULT_LINK = "";
        public static final Long DEFAULT_VERSION = null;
        private static final long serialVersionUID = 0;
        public final String link;
        public final Long version;

        public static final class Builder extends Message.Builder<LinkData, Builder> {
            public String link;
            public Long version;

            @Override // com.squareup.wire.Message.Builder
            public LinkData build() {
                return new LinkData(this.link, this.version, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder link(String r100) {
                this.link = r100;
                return this;
            }

            public Builder version(Long r100) {
                this.version = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_LinkData extends ProtoAdapter<LinkData> {
            public ProtoAdapter_LinkData() {
                super(FieldEncoding.LENGTH_DELIMITED, LinkData.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LinkData decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.link = "";
                r101.version = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.link = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 10) goto L9;
                r101.version = ProtoAdapter.INT64.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(LinkData r100) {
                String r101 = r100.link;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.version;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT64.encodedSizeWithTag(10, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ LinkData decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(LinkData r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, LinkData r101) throws IOException {
                String r102 = r101.link;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.version;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 10, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LinkData r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_LinkData();
            DEFAULT_VERSION = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.link = this.link;
            r100.version = this.version;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return LinkData.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public LinkData(String r100, Long r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public LinkData(String r100, Long r101, ByteString r102) {
            super(ADAPTER, r102);
            this.link = r100;
            this.version = r101;
        }
    }

    public static final class PreviewData extends Message<PreviewData, Builder> {
        public static final ProtoAdapter<PreviewData> ADAPTER = null;
        public static final String DEFAULT_PREVIEW = "";
        public static final PreviewStatus DEFAULT_STATUS = null;
        public static final Long DEFAULT_VERSION = null;
        private static final long serialVersionUID = 0;
        public final String preview;
        public final PreviewStatus status;
        public final Long version;

        public static final class Builder extends Message.Builder<PreviewData, Builder> {
            public String preview;
            public PreviewStatus status;
            public Long version;

            @Override // com.squareup.wire.Message.Builder
            public PreviewData build() {
                return new PreviewData(this.preview, this.status, this.version, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder preview(String r100) {
                this.preview = r100;
                return this;
            }

            public Builder status(PreviewStatus r100) {
                this.status = r100;
                return this;
            }

            public Builder version(Long r100) {
                this.version = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_PreviewData extends ProtoAdapter<PreviewData> {
            public ProtoAdapter_PreviewData() {
                super(FieldEncoding.LENGTH_DELIMITED, PreviewData.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PreviewData decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.preview = "";
                r101.status = PreviewStatus.PREVIEW_NORMAL;
                r101.version = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.preview = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.status = PreviewStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r103 != 10) goto L11;
                r101.version = ProtoAdapter.INT64.decode(r100);
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(PreviewData r100) {
                String r101 = r100.preview;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                PreviewStatus r104 = r100.status;
                if (r104 == null) goto L9;
                int r105 = PreviewStatus.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Long r107 = r100.version;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.INT64.encodedSizeWithTag(10, r107);
            L14:
                return (r106 + r102) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ PreviewData decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(PreviewData r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, PreviewData r101) throws IOException {
                String r102 = r101.preview;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                PreviewStatus r103 = r101.status;
                if (r103 == null) goto L8;
                PreviewStatus.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                Long r104 = r101.version;
                if (r104 == null) goto L11;
                ProtoAdapter.INT64.encodeWithTag(r100, 10, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PreviewData r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_PreviewData();
            DEFAULT_STATUS = PreviewStatus.PREVIEW_NORMAL;
            DEFAULT_VERSION = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.preview = this.preview;
            r100.status = this.status;
            r100.version = this.version;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return PreviewData.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public PreviewData(String r100, PreviewStatus r101, Long r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public PreviewData(String r100, PreviewStatus r101, Long r102, ByteString r103) {
            super(ADAPTER, r103);
            this.preview = r100;
            this.status = r101;
            this.version = r102;
        }
    }

    public static final enum PreviewStatus extends Enum<PreviewStatus> implements WireEnum {
        private static final /* synthetic */ PreviewStatus[] $VALUES = null;
        public static final ProtoAdapter<PreviewStatus> ADAPTER = null;
        public static final PreviewStatus EDITING = null;
        public static final PreviewStatus ERROR = null;
        public static final PreviewStatus PREVIEW_NORMAL = null;
        private final int value;

        static {
            PreviewStatus r100 = new PreviewStatus("PREVIEW_NORMAL", 0, 0);
            PREVIEW_NORMAL = r100;
            PreviewStatus r101 = new PreviewStatus("EDITING", 1, 1);
            EDITING = r101;
            PreviewStatus r102 = new PreviewStatus("ERROR", 2, 2);
            ERROR = r102;
            $VALUES = new PreviewStatus[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(PreviewStatus.class);
        }

        public static PreviewStatus[] values() {
            return (PreviewStatus[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static PreviewStatus fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return ERROR;
        L12:
            return EDITING;
        L14:
            return PREVIEW_NORMAL;
        }

        public static PreviewStatus valueOf(String r100) {
            return (PreviewStatus) a.a(PreviewStatus.class, r100);
        }

        private PreviewStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_AppFeedCard extends ProtoAdapter<AppFeedCard> {
        public ProtoAdapter_AppFeedCard() {
            super(FieldEncoding.LENGTH_DELIMITED, AppFeedCard.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AppFeedCard decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253620id = 0L;
            r101.type = AppFeedCardType.UNKNOWN_APP_FEED_CARD_TYPE;
            r101.biz_id = "";
            r101.app_id = 0L;
            r101.extra_data = ByteString.EMPTY;
            r101.extra_data_json = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L39;
            if (r103 != 1) goto L8;
            r101.f253620id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.type = AppFeedCardType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L36
        L36:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.biz_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.app_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            if (r103 != 100) goto L15;
            r101.feed_default_data = FeedDefaultData.ADAPTER.decode(r100);
            goto L3
        L15:
            switch(r103) {
                case 11: goto L30;
                case 12: goto L29;
                case 13: goto L28;
                case 14: goto L27;
                case 15: goto L26;
                case 16: goto L25;
                case 17: goto L24;
                default: goto L16;
            };
        L24:
            r101.button_data = FeedButtonData.ADAPTER.decode(r100);
            goto L3
        L25:
            r101.status_label_data = StatusLabelData.ADAPTER.decode(r100);
            goto L3
        L26:
            r101.display_time_data = DisplayTimeData.ADAPTER.decode(r100);
            goto L3
        L27:
            r101.badge_data = BadgeData.ADAPTER.decode(r100);
            goto L3
        L28:
            r101.preview_data = PreviewData.ADAPTER.decode(r100);
            goto L3
        L29:
            r101.avatar_data = AvatarData.ADAPTER.decode(r100);
            goto L3
        L30:
            r101.title_data = TitleData.ADAPTER.decode(r100);
            goto L3
        L16:
            switch(r103) {
                case 21: goto L23;
                case 22: goto L22;
                case 23: goto L21;
                case 24: goto L20;
                case 25: goto L19;
                case 26: goto L18;
                default: goto L17;
            };
        L18:
            r101.link_data = LinkData.ADAPTER.decode(r100);
            goto L3
        L19:
            r101.biz_extra_data = ExtraData.ADAPTER.decode(r100);
            goto L3
        L20:
            r101.extra_data_json = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.extra_data = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L22:
            r101.status_data = StatusData.ADAPTER.decode(r100);
            goto L3
        L23:
            r101.setting_data = SettingData.ADAPTER.decode(r100);
            goto L3
        L17:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L39:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AppFeedCard r100) {
            Long r101 = r100.f253619id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            AppFeedCardType r104 = r100.type;
            if (r104 == null) goto L9;
            int r105 = AppFeedCardType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.biz_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.app_id;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            TitleData r113 = r100.title_data;
            if (r113 == null) goto L21;
            int r114 = TitleData.ADAPTER.encodedSizeWithTag(11, r113);
        L22:
            int r115 = r112 + r114;
            AvatarData r116 = r100.avatar_data;
            if (r116 == null) goto L25;
            int r117 = AvatarData.ADAPTER.encodedSizeWithTag(12, r116);
        L26:
            int r118 = r115 + r117;
            PreviewData r119 = r100.preview_data;
            if (r119 == null) goto L29;
            int r120 = PreviewData.ADAPTER.encodedSizeWithTag(13, r119);
        L30:
            int r121 = r118 + r120;
            BadgeData r122 = r100.badge_data;
            if (r122 == null) goto L33;
            int r123 = BadgeData.ADAPTER.encodedSizeWithTag(14, r122);
        L34:
            int r124 = r121 + r123;
            DisplayTimeData r125 = r100.display_time_data;
            if (r125 == null) goto L37;
            int r126 = DisplayTimeData.ADAPTER.encodedSizeWithTag(15, r125);
        L38:
            int r127 = r124 + r126;
            StatusLabelData r128 = r100.status_label_data;
            if (r128 == null) goto L41;
            int r129 = StatusLabelData.ADAPTER.encodedSizeWithTag(16, r128);
        L42:
            int r130 = r127 + r129;
            FeedButtonData r131 = r100.button_data;
            if (r131 == null) goto L45;
            int r132 = FeedButtonData.ADAPTER.encodedSizeWithTag(17, r131);
        L46:
            int r133 = r130 + r132;
            SettingData r134 = r100.setting_data;
            if (r134 == null) goto L49;
            int r135 = SettingData.ADAPTER.encodedSizeWithTag(21, r134);
        L50:
            int r136 = r133 + r135;
            StatusData r137 = r100.status_data;
            if (r137 == null) goto L53;
            int r138 = StatusData.ADAPTER.encodedSizeWithTag(22, r137);
        L54:
            int r139 = r136 + r138;
            ByteString r140 = r100.extra_data;
            if (r140 == null) goto L57;
            int r141 = ProtoAdapter.BYTES.encodedSizeWithTag(23, r140);
        L58:
            int r142 = r139 + r141;
            String r143 = r100.extra_data_json;
            if (r143 == null) goto L61;
            int r144 = ProtoAdapter.STRING.encodedSizeWithTag(24, r143);
        L62:
            int r145 = r142 + r144;
            ExtraData r146 = r100.biz_extra_data;
            if (r146 == null) goto L65;
            int r147 = ExtraData.ADAPTER.encodedSizeWithTag(25, r146);
        L66:
            int r148 = r145 + r147;
            LinkData r149 = r100.link_data;
            if (r149 == null) goto L69;
            int r150 = LinkData.ADAPTER.encodedSizeWithTag(26, r149);
        L70:
            int r151 = r148 + r150;
            FeedDefaultData r152 = r100.feed_default_data;
            if (r152 == null) goto L74;
            r102 = FeedDefaultData.ADAPTER.encodedSizeWithTag(100, r152);
        L74:
            return (r151 + r102) + r100.unknownFields().size();
        L69:
            r150 = 0;
            goto L70
        L65:
            r147 = 0;
            goto L66
        L61:
            r144 = 0;
            goto L62
        L57:
            r141 = 0;
            goto L58
        L53:
            r138 = 0;
            goto L54
        L49:
            r135 = 0;
            goto L50
        L45:
            r132 = 0;
            goto L46
        L41:
            r129 = 0;
            goto L42
        L37:
            r126 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AppFeedCard decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AppFeedCard r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AppFeedCard r101) throws IOException {
            Long r102 = r101.f253619id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            AppFeedCardType r103 = r101.type;
            if (r103 == null) goto L8;
            AppFeedCardType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.biz_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.app_id;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            TitleData r106 = r101.title_data;
            if (r106 == null) goto L17;
            TitleData.ADAPTER.encodeWithTag(r100, 11, r106);
        L17:
            AvatarData r107 = r101.avatar_data;
            if (r107 == null) goto L20;
            AvatarData.ADAPTER.encodeWithTag(r100, 12, r107);
        L20:
            PreviewData r108 = r101.preview_data;
            if (r108 == null) goto L23;
            PreviewData.ADAPTER.encodeWithTag(r100, 13, r108);
        L23:
            BadgeData r109 = r101.badge_data;
            if (r109 == null) goto L26;
            BadgeData.ADAPTER.encodeWithTag(r100, 14, r109);
        L26:
            DisplayTimeData r110 = r101.display_time_data;
            if (r110 == null) goto L29;
            DisplayTimeData.ADAPTER.encodeWithTag(r100, 15, r110);
        L29:
            StatusLabelData r111 = r101.status_label_data;
            if (r111 == null) goto L32;
            StatusLabelData.ADAPTER.encodeWithTag(r100, 16, r111);
        L32:
            FeedButtonData r112 = r101.button_data;
            if (r112 == null) goto L35;
            FeedButtonData.ADAPTER.encodeWithTag(r100, 17, r112);
        L35:
            SettingData r113 = r101.setting_data;
            if (r113 == null) goto L38;
            SettingData.ADAPTER.encodeWithTag(r100, 21, r113);
        L38:
            StatusData r114 = r101.status_data;
            if (r114 == null) goto L41;
            StatusData.ADAPTER.encodeWithTag(r100, 22, r114);
        L41:
            ByteString r115 = r101.extra_data;
            if (r115 == null) goto L44;
            ProtoAdapter.BYTES.encodeWithTag(r100, 23, r115);
        L44:
            String r116 = r101.extra_data_json;
            if (r116 == null) goto L47;
            ProtoAdapter.STRING.encodeWithTag(r100, 24, r116);
        L47:
            ExtraData r117 = r101.biz_extra_data;
            if (r117 == null) goto L50;
            ExtraData.ADAPTER.encodeWithTag(r100, 25, r117);
        L50:
            LinkData r118 = r101.link_data;
            if (r118 == null) goto L53;
            LinkData.ADAPTER.encodeWithTag(r100, 26, r118);
        L53:
            FeedDefaultData r119 = r101.feed_default_data;
            if (r119 == null) goto L56;
            FeedDefaultData.ADAPTER.encodeWithTag(r100, 100, r119);
        L56:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AppFeedCard r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class SettingData extends Message<SettingData, Builder> {
        public static final ProtoAdapter<SettingData> ADAPTER = null;
        public static final Boolean DEFAULT_MUTE = null;
        public static final Long DEFAULT_VERSION = null;
        private static final long serialVersionUID = 0;
        public final Boolean mute;
        public final Long version;

        public static final class Builder extends Message.Builder<SettingData, Builder> {
            public Boolean mute;
            public Long version;

            @Override // com.squareup.wire.Message.Builder
            public SettingData build() {
                return new SettingData(this.mute, this.version, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder mute(Boolean r100) {
                this.mute = r100;
                return this;
            }

            public Builder version(Long r100) {
                this.version = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SettingData extends ProtoAdapter<SettingData> {
            public ProtoAdapter_SettingData() {
                super(FieldEncoding.LENGTH_DELIMITED, SettingData.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SettingData decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mute = Boolean.FALSE;
                r101.version = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mute = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r103 != 10) goto L9;
                r101.version = ProtoAdapter.INT64.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(SettingData r100) {
                Boolean r101 = r100.mute;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.version;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT64.encodedSizeWithTag(10, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SettingData decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SettingData r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SettingData r101) throws IOException {
                Boolean r102 = r101.mute;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.version;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 10, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SettingData r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SettingData();
            DEFAULT_MUTE = Boolean.FALSE;
            DEFAULT_VERSION = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mute = this.mute;
            r100.version = this.version;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SettingData.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SettingData(Boolean r100, Long r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public SettingData(Boolean r100, Long r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mute = r100;
            this.version = r101;
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status DELETED = null;
        public static final Status NORMAL = null;
        public static final Status UNKNOWN = null;
        private final int value;

        static {
            Status r100 = new Status("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Status r101 = new Status(EffectConstants.NORMAL, 1, 1);
            NORMAL = r101;
            Status r102 = new Status("DELETED", 2, 2);
            DELETED = r102;
            $VALUES = new Status[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Status fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return DELETED;
        L12:
            return NORMAL;
        L14:
            return UNKNOWN;
        }

        public static Status valueOf(String r100) {
            return (Status) a.a(Status.class, r100);
        }

        private Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class StatusData extends Message<StatusData, Builder> {
        public static final ProtoAdapter<StatusData> ADAPTER = null;
        public static final Status DEFAULT_STATUS = null;
        public static final Long DEFAULT_VERSION = null;
        private static final long serialVersionUID = 0;
        public final Status status;
        public final Long version;

        public static final class Builder extends Message.Builder<StatusData, Builder> {
            public Status status;
            public Long version;

            @Override // com.squareup.wire.Message.Builder
            public StatusData build() {
                return new StatusData(this.status, this.version, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder status(Status r100) {
                this.status = r100;
                return this;
            }

            public Builder version(Long r100) {
                this.version = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_StatusData extends ProtoAdapter<StatusData> {
            public ProtoAdapter_StatusData() {
                super(FieldEncoding.LENGTH_DELIMITED, StatusData.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public StatusData decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.status = Status.UNKNOWN;
                r101.version = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.status = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 10) goto L9;
                r101.version = ProtoAdapter.INT64.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(StatusData r100) {
                Status r101 = r100.status;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Status.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.version;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT64.encodedSizeWithTag(10, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ StatusData decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(StatusData r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, StatusData r101) throws IOException {
                Status r102 = r101.status;
                if (r102 == null) goto L5;
                Status.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.version;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 10, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, StatusData r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_StatusData();
            DEFAULT_STATUS = Status.UNKNOWN;
            DEFAULT_VERSION = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.status = this.status;
            r100.version = this.version;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return StatusData.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public StatusData(Status r100, Long r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public StatusData(Status r100, Long r101, ByteString r102) {
            super(ADAPTER, r102);
            this.status = r100;
            this.version = r101;
        }
    }

    public static final class StatusLabelData extends Message<StatusLabelData, Builder> {
        public static final ProtoAdapter<StatusLabelData> ADAPTER = null;
        public static final Long DEFAULT_VERSION = null;
        private static final long serialVersionUID = 0;
        public final FeedStatusLabel label;
        public final Long version;

        public static final class Builder extends Message.Builder<StatusLabelData, Builder> {
            public FeedStatusLabel label;
            public Long version;

            @Override // com.squareup.wire.Message.Builder
            public StatusLabelData build() {
                return new StatusLabelData(this.label, this.version, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder label(FeedStatusLabel r100) {
                this.label = r100;
                return this;
            }

            public Builder version(Long r100) {
                this.version = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_StatusLabelData extends ProtoAdapter<StatusLabelData> {
            public ProtoAdapter_StatusLabelData() {
                super(FieldEncoding.LENGTH_DELIMITED, StatusLabelData.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public StatusLabelData decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.version = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.label = FeedStatusLabel.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 10) goto L9;
                r101.version = ProtoAdapter.INT64.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(StatusLabelData r100) {
                FeedStatusLabel r101 = r100.label;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = FeedStatusLabel.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.version;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT64.encodedSizeWithTag(10, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ StatusLabelData decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(StatusLabelData r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, StatusLabelData r101) throws IOException {
                FeedStatusLabel r102 = r101.label;
                if (r102 == null) goto L5;
                FeedStatusLabel.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.version;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 10, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, StatusLabelData r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_StatusLabelData();
            DEFAULT_VERSION = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.label = this.label;
            r100.version = this.version;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return StatusLabelData.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public StatusLabelData(FeedStatusLabel r100, Long r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public StatusLabelData(FeedStatusLabel r100, Long r101, ByteString r102) {
            super(ADAPTER, r102);
            this.label = r100;
            this.version = r101;
        }
    }

    public static final class TitleData extends Message<TitleData, Builder> {
        public static final ProtoAdapter<TitleData> ADAPTER = null;
        public static final String DEFAULT_TITLE = "";
        public static final Long DEFAULT_VERSION = null;
        private static final long serialVersionUID = 0;
        public final String title;
        public final Long version;

        public static final class Builder extends Message.Builder<TitleData, Builder> {
            public String title;
            public Long version;

            @Override // com.squareup.wire.Message.Builder
            public TitleData build() {
                return new TitleData(this.title, this.version, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder title(String r100) {
                this.title = r100;
                return this;
            }

            public Builder version(Long r100) {
                this.version = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TitleData extends ProtoAdapter<TitleData> {
            public ProtoAdapter_TitleData() {
                super(FieldEncoding.LENGTH_DELIMITED, TitleData.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TitleData decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.title = "";
                r101.version = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.title = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 10) goto L9;
                r101.version = ProtoAdapter.INT64.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TitleData r100) {
                String r101 = r100.title;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.version;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT64.encodedSizeWithTag(10, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TitleData decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TitleData r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TitleData r101) throws IOException {
                String r102 = r101.title;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.version;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 10, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TitleData r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TitleData();
            DEFAULT_VERSION = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.title = this.title;
            r100.version = this.version;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TitleData.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public TitleData(String r100, Long r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public TitleData(String r100, Long r101, ByteString r102) {
            super(ADAPTER, r102);
            this.title = r100;
            this.version = r101;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AppFeedCard();
        DEFAULT_ID = 0L;
        DEFAULT_TYPE = AppFeedCardType.UNKNOWN_APP_FEED_CARD_TYPE;
        DEFAULT_APP_ID = 0L;
        DEFAULT_EXTRA_DATA = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253620id = this.f253619id;
        r100.type = this.type;
        r100.biz_id = this.biz_id;
        r100.app_id = this.app_id;
        r100.title_data = this.title_data;
        r100.avatar_data = this.avatar_data;
        r100.preview_data = this.preview_data;
        r100.badge_data = this.badge_data;
        r100.display_time_data = this.display_time_data;
        r100.status_label_data = this.status_label_data;
        r100.button_data = this.button_data;
        r100.setting_data = this.setting_data;
        r100.status_data = this.status_data;
        r100.extra_data = this.extra_data;
        r100.extra_data_json = this.extra_data_json;
        r100.biz_extra_data = this.biz_extra_data;
        r100.link_data = this.link_data;
        r100.feed_default_data = this.feed_default_data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AppFeedCard.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AppFeedCard(Long r210, AppFeedCardType r211, String r212, Long r213, TitleData r214, AvatarData r215, PreviewData r216, BadgeData r217, DisplayTimeData r218, StatusLabelData r310, FeedButtonData r311, SettingData r312, StatusData r313, ByteString r314, String r315, ExtraData r316, LinkData r317, FeedDefaultData r318) {
        this(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r318, ByteString.EMPTY);
    }

    public AppFeedCard(Long r100, AppFeedCardType r101, String r102, Long r103, TitleData r104, AvatarData r105, PreviewData r110, BadgeData r111, DisplayTimeData r112, StatusLabelData r113, FeedButtonData r114, SettingData r115, StatusData r116, ByteString r117, String r118, ExtraData r119, LinkData r210, FeedDefaultData r211, ByteString r212) {
        super(ADAPTER, r212);
        this.f253619id = r100;
        this.type = r101;
        this.biz_id = r102;
        this.app_id = r103;
        this.title_data = r104;
        this.avatar_data = r105;
        this.preview_data = r110;
        this.badge_data = r111;
        this.display_time_data = r112;
        this.status_label_data = r113;
        this.button_data = r114;
        this.setting_data = r115;
        this.status_data = r116;
        this.extra_data = r117;
        this.extra_data_json = r118;
        this.biz_extra_data = r119;
        this.link_data = r210;
        this.feed_default_data = r211;
    }
}
