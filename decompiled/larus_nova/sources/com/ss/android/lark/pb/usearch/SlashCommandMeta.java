package com.ss.android.lark.pb.usearch;

import com.bytedance.android.livesdkapi.depend.model.LocalSubStickerItem;
import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class SlashCommandMeta extends Message<SlashCommandMeta, Builder> {
    public static final ProtoAdapter<SlashCommandMeta> ADAPTER = null;
    public static final String DEFAULT_APP_LINK = "";
    public static final String DEFAULT_DATA_SOURCE_ID = "";
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_EXTRA = "";
    public static final String DEFAULT_IMAGE_URL = "";
    public static final Long DEFAULT_RENDER_TIME_STAMP = null;
    public static final FieldOptions FIELD_OPTIONS_MDATA_SOURCE_ID = null;
    private static final long serialVersionUID = 0;
    public final String mapp_link;
    public final String mdata_source_id;
    public final String mdescription;
    public final String mextra;
    public final String mimage_url;
    public final Long mrender_time_stamp;
    public final SearchQABizType msearch_qa_biz_type;
    public final SlashCommandType mslash_command_type;
    public final List<SlashCommandTag> mtag;

    public static final class Builder extends Message.Builder<SlashCommandMeta, Builder> {
        public String mapp_link;
        public String mdata_source_id;
        public String mdescription;
        public String mextra;
        public String mimage_url;
        public Long mrender_time_stamp;
        public SearchQABizType msearch_qa_biz_type;
        public SlashCommandType mslash_command_type;
        public List<SlashCommandTag> mtag;

        @Override // com.squareup.wire.Message.Builder
        public SlashCommandMeta build() {
            SlashCommandType r100 = this.mslash_command_type;
            if (r100 == null) goto L7;
            return new SlashCommandMeta(this.mslash_command_type, this.mapp_link, this.mtag, this.mextra, this.mimage_url, this.mdescription, this.mdata_source_id, this.msearch_qa_biz_type, this.mrender_time_stamp, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mslash_command_type"});
        }

        public Builder() {
            this.mtag = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_link(String r100) {
            this.mapp_link = r100;
            return this;
        }

        public Builder data_source_id(String r100) {
            this.mdata_source_id = r100;
            return this;
        }

        public Builder description(String r100) {
            this.mdescription = r100;
            return this;
        }

        public Builder extra(String r100) {
            this.mextra = r100;
            return this;
        }

        public Builder image_url(String r100) {
            this.mimage_url = r100;
            return this;
        }

        public Builder render_time_stamp(Long r100) {
            this.mrender_time_stamp = r100;
            return this;
        }

        public Builder search_qa_biz_type(SearchQABizType r100) {
            this.msearch_qa_biz_type = r100;
            return this;
        }

        public Builder slash_command_type(SlashCommandType r100) {
            this.mslash_command_type = r100;
            return this;
        }

        public Builder tag(List<SlashCommandTag> r100) {
            Internal.checkElementsNotNull(r100);
            this.mtag = r100;
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
            r101.mapp_link = "";
            r101.mextra = "";
            r101.mimage_url = "";
            r101.mdescription = "";
            r101.mdata_source_id = "";
            r101.mrender_time_stamp = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L22;
            switch(r103) {
                case 1: goto L24;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L26;
                case 9: goto L7;
                default: goto L6;
            };
        L24:
            r101.mslash_command_type = SlashCommandType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L26:
            r101.msearch_qa_biz_type = SearchQABizType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mrender_time_stamp = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            r101.mdata_source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.mdescription = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.mimage_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.mextra = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.mtag.add(SlashCommandTag.ADAPTER.decode(r100));
            goto L3
        L17:
            r101.mapp_link = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L22:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SlashCommandMeta r100) {
            int r101 = SlashCommandType.ADAPTER.encodedSizeWithTag(1, r100.mslash_command_type);
            String r102 = r100.mapp_link;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L6:
            int r105 = (r101 + r104) + SlashCommandTag.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.mtag);
            String r106 = r100.mextra;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.STRING.encodedSizeWithTag(4, r106);
        L10:
            int r108 = r105 + r107;
            String r109 = r100.mimage_url;
            if (r109 == null) goto L13;
            int r110 = ProtoAdapter.STRING.encodedSizeWithTag(5, r109);
        L14:
            int r111 = r108 + r110;
            String r112 = r100.mdescription;
            if (r112 == null) goto L17;
            int r113 = ProtoAdapter.STRING.encodedSizeWithTag(6, r112);
        L18:
            int r114 = r111 + r113;
            String r115 = r100.mdata_source_id;
            if (r115 == null) goto L21;
            int r116 = ProtoAdapter.STRING.encodedSizeWithTag(7, r115);
        L22:
            int r117 = r114 + r116;
            SearchQABizType r118 = r100.msearch_qa_biz_type;
            if (r118 == null) goto L25;
            int r119 = SearchQABizType.ADAPTER.encodedSizeWithTag(8, r118);
        L26:
            int r120 = r117 + r119;
            Long r121 = r100.mrender_time_stamp;
            if (r121 == null) goto L30;
            r103 = ProtoAdapter.INT64.encodedSizeWithTag(9, r121);
        L30:
            return (r120 + r103) + r100.unknownFields().size();
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
            SlashCommandType.ADAPTER.encodeWithTag(r100, 1, r101.mslash_command_type);
            String r102 = r101.mapp_link;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            SlashCommandTag.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.mtag);
            String r103 = r101.mextra;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r103);
        L8:
            String r104 = r101.mimage_url;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r104);
        L11:
            String r105 = r101.mdescription;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r105);
        L14:
            String r106 = r101.mdata_source_id;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r106);
        L17:
            SearchQABizType r107 = r101.msearch_qa_biz_type;
            if (r107 == null) goto L20;
            SearchQABizType.ADAPTER.encodeWithTag(r100, 8, r107);
        L20:
            Long r108 = r101.mrender_time_stamp;
            if (r108 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r100, 9, r108);
        L23:
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
        public final String mtext;
        public final Integer mtype;

        public static final class Builder extends Message.Builder<SlashCommandTag, Builder> {
            public String mtext;
            public Integer mtype;

            @Override // com.squareup.wire.Message.Builder
            public SlashCommandTag build() {
                Integer r100 = this.mtype;
                if (r100 == null) goto L9;
                if (this.mtext == null) goto L9;
                return new SlashCommandTag(this.mtype, this.mtext, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, GearStrategyConsts.EV_MEDIA_TYPE, this.mtext, "mtext"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder text(String r100) {
                this.mtext = r100;
                return this;
            }

            public Builder type(Integer r100) {
                this.mtype = r100;
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
                r101.mtype = 0;
                r101.mtext = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mtype = ProtoAdapter.INT32.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mtext = ProtoAdapter.STRING.decode(r100);
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
                return (ProtoAdapter.INT32.encodedSizeWithTag(1, r100.mtype) + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.mtext)) + r100.unknownFields().size();
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
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r101.mtype);
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.mtext);
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
            r100.mtype = this.mtype;
            r100.mtext = this.mtext;
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
            this.mtype = r100;
            this.mtext = r101;
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
        FieldOptions.Builder r100 = new FieldOptions.Builder();
        Boolean r101 = Boolean.TRUE;
        FIELD_OPTIONS_MDATA_SOURCE_ID = r100.security_field(r101).security_search_data_source_id(r101).build();
        DEFAULT_RENDER_TIME_STAMP = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mslash_command_type = this.mslash_command_type;
        r100.mapp_link = this.mapp_link;
        r100.mtag = Internal.copyOf("mtag", this.mtag);
        r100.mextra = this.mextra;
        r100.mimage_url = this.mimage_url;
        r100.mdescription = this.mdescription;
        r100.mdata_source_id = this.mdata_source_id;
        r100.msearch_qa_biz_type = this.msearch_qa_biz_type;
        r100.mrender_time_stamp = this.mrender_time_stamp;
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

    public SlashCommandMeta(SlashCommandType r110, String r111, List<SlashCommandTag> r112, String r113, String r114, String r115, String r116, SearchQABizType r117, Long r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public SlashCommandMeta(SlashCommandType r100, String r101, List<SlashCommandTag> r102, String r103, String r104, String r105, String r106, SearchQABizType r107, Long r110, ByteString r111) {
        super(ADAPTER, r111);
        this.mslash_command_type = r100;
        this.mapp_link = r101;
        this.mtag = Internal.immutableCopyOf("mtag", r102);
        this.mextra = r103;
        this.mimage_url = r104;
        this.mdescription = r105;
        this.mdata_source_id = r106;
        this.msearch_qa_biz_type = r107;
        this.mrender_time_stamp = r110;
    }
}
