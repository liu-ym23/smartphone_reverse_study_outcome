package com.bytedance.lark.pb.search.v2;

import com.bytedance.android.livesdkapi.depend.model.LocalSubStickerItem;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class SlashCommandMeta extends Message<SlashCommandMeta, Builder> {
    public static final ProtoAdapter<SlashCommandMeta> ADAPTER = null;
    public static final String DEFAULT_APP_LINK = "";
    public static final SearchQABizType DEFAULT_BIZ_TYPE = null;
    public static final String DEFAULT_DATA_SOURCE_ID = "";
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_EXTRA = "";
    public static final Long DEFAULT_ID = null;
    public static final String DEFAULT_IMAGE_URL = "";
    public static final Boolean DEFAULT_IS_URL = null;
    public static final Long DEFAULT_RENDER_TIME_STAMP = null;
    public static final SlashCommandType DEFAULT_SLASH_COMMAND_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String app_link;
    public final SearchQABizType biz_type;
    public final String data_source_id;
    public final String description;
    public final String extra;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final Long f253739id;
    public final String image_url;
    public final Boolean is_url;
    public final Long render_time_stamp;
    public final SlashCommandType slash_command_type;
    public final List<SlashCommandTag> tag;

    public static final class Builder extends Message.Builder<SlashCommandMeta, Builder> {
        public String app_link;
        public SearchQABizType biz_type;
        public String data_source_id;
        public String description;
        public String extra;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public Long f253740id;
        public String image_url;
        public Boolean is_url;
        public Long render_time_stamp;
        public SlashCommandType slash_command_type;
        public List<SlashCommandTag> tag;

        @Override // com.squareup.wire.Message.Builder
        public SlashCommandMeta build() {
            SlashCommandType r100 = this.slash_command_type;
            if (r100 == null) goto L7;
            return new SlashCommandMeta(this.slash_command_type, this.app_link, this.tag, this.extra, this.image_url, this.description, this.data_source_id, this.biz_type, this.render_time_stamp, this.f253740id, this.is_url, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "slash_command_type"});
        }

        public Builder() {
            this.tag = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_link(String r100) {
            this.app_link = r100;
            return this;
        }

        public Builder biz_type(SearchQABizType r100) {
            this.biz_type = r100;
            return this;
        }

        public Builder data_source_id(String r100) {
            this.data_source_id = r100;
            return this;
        }

        public Builder description(String r100) {
            this.description = r100;
            return this;
        }

        public Builder extra(String r100) {
            this.extra = r100;
            return this;
        }

        public Builder id(Long r100) {
            this.f253740id = r100;
            return this;
        }

        public Builder image_url(String r100) {
            this.image_url = r100;
            return this;
        }

        public Builder is_url(Boolean r100) {
            this.is_url = r100;
            return this;
        }

        public Builder render_time_stamp(Long r100) {
            this.render_time_stamp = r100;
            return this;
        }

        public Builder slash_command_type(SlashCommandType r100) {
            this.slash_command_type = r100;
            return this;
        }

        public Builder tag(List<SlashCommandTag> r100) {
            Internal.checkElementsNotNull(r100);
            this.tag = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SlashCommandMeta extends ProtoAdapter<SlashCommandMeta> {
        public ProtoAdapter_SlashCommandMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, SlashCommandMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SlashCommandMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.slash_command_type = SlashCommandType.ENTITY;
            r101.app_link = "";
            r101.extra = "";
            r101.image_url = "";
            r101.description = "";
            r101.data_source_id = "";
            r101.biz_type = SearchQABizType.Unknown;
            r101.render_time_stamp = 0L;
            r101.f253740id = 0L;
            r101.is_url = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L28;
            if (r103 != 100) goto L8;
            r101.f253740id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 101) goto L9;
            r101.is_url = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            switch(r103) {
                case 1: goto L30;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L32;
                case 9: goto L11;
                default: goto L10;
            };
        L30:
            r101.slash_command_type = SlashCommandType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
        L24:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L32:
            r101.biz_type = SearchQABizType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.render_time_stamp = ProtoAdapter.INT64.decode(r100);
            goto L3
        L16:
            r101.data_source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.description = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.image_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.extra = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.tag.add(SlashCommandTag.ADAPTER.decode(r100));
            goto L3
        L21:
            r101.app_link = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L28:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SlashCommandMeta r100) {
            int r101 = SlashCommandType.ADAPTER.encodedSizeWithTag(1, r100.slash_command_type);
            String r102 = r100.app_link;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L6:
            int r105 = (r101 + r104) + SlashCommandTag.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.tag);
            String r106 = r100.extra;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.STRING.encodedSizeWithTag(4, r106);
        L10:
            int r108 = r105 + r107;
            String r109 = r100.image_url;
            if (r109 == null) goto L13;
            int r110 = ProtoAdapter.STRING.encodedSizeWithTag(5, r109);
        L14:
            int r111 = r108 + r110;
            String r112 = r100.description;
            if (r112 == null) goto L17;
            int r113 = ProtoAdapter.STRING.encodedSizeWithTag(6, r112);
        L18:
            int r114 = r111 + r113;
            String r115 = r100.data_source_id;
            if (r115 == null) goto L21;
            int r116 = ProtoAdapter.STRING.encodedSizeWithTag(7, r115);
        L22:
            int r117 = r114 + r116;
            SearchQABizType r118 = r100.biz_type;
            if (r118 == null) goto L25;
            int r119 = SearchQABizType.ADAPTER.encodedSizeWithTag(8, r118);
        L26:
            int r120 = r117 + r119;
            Long r121 = r100.render_time_stamp;
            if (r121 == null) goto L29;
            int r122 = ProtoAdapter.INT64.encodedSizeWithTag(9, r121);
        L30:
            int r123 = r120 + r122;
            Long r124 = r100.f253739id;
            if (r124 == null) goto L33;
            int r125 = ProtoAdapter.INT64.encodedSizeWithTag(100, r124);
        L34:
            int r126 = r123 + r125;
            Boolean r127 = r100.is_url;
            if (r127 == null) goto L38;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(101, r127);
        L38:
            return (r126 + r103) + r100.unknownFields().size();
        L33:
            r125 = 0;
            goto L34
        L29:
            r122 = 0;
            goto L30
        L25:
            r119 = 0;
            goto L26
        L21:
            r116 = 0;
            goto L22
        L17:
            r113 = 0;
            goto L18
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SlashCommandMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SlashCommandMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SlashCommandMeta r101) throws IOException {
            SlashCommandType.ADAPTER.encodeWithTag(r100, 1, r101.slash_command_type);
            String r102 = r101.app_link;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            SlashCommandTag.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.tag);
            String r103 = r101.extra;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r103);
        L8:
            String r104 = r101.image_url;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r104);
        L11:
            String r105 = r101.description;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r105);
        L14:
            String r106 = r101.data_source_id;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r106);
        L17:
            SearchQABizType r107 = r101.biz_type;
            if (r107 == null) goto L20;
            SearchQABizType.ADAPTER.encodeWithTag(r100, 8, r107);
        L20:
            Long r108 = r101.render_time_stamp;
            if (r108 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r100, 9, r108);
        L23:
            Long r109 = r101.f253739id;
            if (r109 == null) goto L26;
            ProtoAdapter.INT64.encodeWithTag(r100, 100, r109);
        L26:
            Boolean r110 = r101.is_url;
            if (r110 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 101, r110);
        L29:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SlashCommandMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class SlashCommandTag extends Message<SlashCommandTag, Builder> {
        public static final ProtoAdapter<SlashCommandTag> ADAPTER = null;
        public static final String DEFAULT_TEXT = "";
        public static final Integer DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final String text;
        public final Integer type;

        public static final class Builder extends Message.Builder<SlashCommandTag, Builder> {
            public String text;
            public Integer type;

            @Override // com.squareup.wire.Message.Builder
            public SlashCommandTag build() {
                Integer r100 = this.type;
                if (r100 == null) goto L9;
                if (this.text == null) goto L9;
                return new SlashCommandTag(this.type, this.text, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "type", this.text, "text"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder text(String r100) {
                this.text = r100;
                return this;
            }

            public Builder type(Integer r100) {
                this.type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SlashCommandTag extends ProtoAdapter<SlashCommandTag> {
            public ProtoAdapter_SlashCommandTag() {
                super(FieldEncoding.LENGTH_DELIMITED, SlashCommandTag.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SlashCommandTag decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = 0;
                r101.text = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.type = ProtoAdapter.INT32.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.text = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(SlashCommandTag r100) {
                return (ProtoAdapter.INT32.encodedSizeWithTag(1, r100.type) + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.text)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SlashCommandTag decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SlashCommandTag r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SlashCommandTag r101) throws IOException {
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r101.type);
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.text);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SlashCommandTag r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SlashCommandTag();
            DEFAULT_TYPE = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.text = this.text;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SlashCommandTag.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SlashCommandTag(Integer r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public SlashCommandTag(Integer r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.type = r100;
            this.text = r101;
        }
    }

    public static final enum SlashCommandType extends Enum<SlashCommandType> implements WireEnum {
        private static final /* synthetic */ SlashCommandType[] $VALUES = null;
        public static final ProtoAdapter<SlashCommandType> ADAPTER = null;
        public static final SlashCommandType ENTITY = null;
        public static final SlashCommandType FILTER = null;
        private final int value;

        static {
            SlashCommandType r100 = new SlashCommandType("ENTITY", 0, 0);
            ENTITY = r100;
            SlashCommandType r101 = new SlashCommandType(LocalSubStickerItem.BEAUTY_TYPE_FILTER, 1, 1);
            FILTER = r101;
            $VALUES = new SlashCommandType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(SlashCommandType.class);
        }

        public static SlashCommandType[] values() {
            return (SlashCommandType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SlashCommandType fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return FILTER;
        L10:
            return ENTITY;
        }

        public static SlashCommandType valueOf(String r100) {
            return (SlashCommandType) a.a(SlashCommandType.class, r100);
        }

        private SlashCommandType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SlashCommandMeta();
        DEFAULT_SLASH_COMMAND_TYPE = SlashCommandType.ENTITY;
        DEFAULT_BIZ_TYPE = SearchQABizType.Unknown;
        DEFAULT_RENDER_TIME_STAMP = 0L;
        DEFAULT_ID = 0L;
        DEFAULT_IS_URL = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.slash_command_type = this.slash_command_type;
        r100.app_link = this.app_link;
        r100.tag = Internal.copyOf("tag", this.tag);
        r100.extra = this.extra;
        r100.image_url = this.image_url;
        r100.description = this.description;
        r100.data_source_id = this.data_source_id;
        r100.biz_type = this.biz_type;
        r100.render_time_stamp = this.render_time_stamp;
        r100.f253740id = this.f253739id;
        r100.is_url = this.is_url;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SlashCommandMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SlashCommandMeta(SlashCommandType r110, String r111, List<SlashCommandTag> r112, String r113, String r114, String r115, String r210, SearchQABizType r211, Long r212, Long r213, Boolean r214) {
        this(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, ByteString.EMPTY);
    }

    public SlashCommandMeta(SlashCommandType r100, String r101, List<SlashCommandTag> r102, String r103, String r104, String r105, String r106, SearchQABizType r107, Long r110, Long r111, Boolean r112, ByteString r113) {
        super(ADAPTER, r113);
        this.slash_command_type = r100;
        this.app_link = r101;
        this.tag = Internal.immutableCopyOf("tag", r102);
        this.extra = r103;
        this.image_url = r104;
        this.description = r105;
        this.data_source_id = r106;
        this.biz_type = r107;
        this.render_time_stamp = r110;
        this.f253739id = r111;
        this.is_url = r112;
    }
}
