package com.bytedance.lark.pb.search.slash.v1;

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
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_EXTRA = "";
    public static final SlashCommandType DEFAULT_SLASH_COMMAND_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String app_link;
    public final String description;
    public final String extra;
    public final SlashCommandType slash_command_type;
    public final List<SlashCommandTag> tag;

    public static final class Builder extends Message.Builder<SlashCommandMeta, Builder> {
        public String app_link;
        public String description;
        public String extra;
        public SlashCommandType slash_command_type;
        public List<SlashCommandTag> tag;

        @Override // com.squareup.wire.Message.Builder
        public SlashCommandMeta build() {
            SlashCommandType r100 = this.slash_command_type;
            if (r100 == null) goto L7;
            return new SlashCommandMeta(this.slash_command_type, this.app_link, this.description, this.tag, this.extra, super.buildUnknownFields());
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

        public Builder description(String r100) {
            this.description = r100;
            return this;
        }

        public Builder extra(String r100) {
            this.extra = r100;
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
            r101.description = "";
            r101.extra = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.slash_command_type = SlashCommandType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.app_link = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.description = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.tag.add(SlashCommandTag.ADAPTER.decode(r100));
            goto L3
        L14:
            if (r103 != 6) goto L15;
            r101.extra = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
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
            int r105 = r101 + r104;
            String r106 = r100.description;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.STRING.encodedSizeWithTag(3, r106);
        L10:
            int r108 = (r105 + r107) + SlashCommandTag.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.tag);
            String r109 = r100.extra;
            if (r109 == null) goto L14;
            r103 = ProtoAdapter.STRING.encodedSizeWithTag(6, r109);
        L14:
            return (r108 + r103) + r100.unknownFields().size();
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
            String r103 = r101.description;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
        L8:
            SlashCommandTag.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.tag);
            String r104 = r101.extra;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r104);
        L11:
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
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.slash_command_type = this.slash_command_type;
        r100.app_link = this.app_link;
        r100.description = this.description;
        r100.tag = Internal.copyOf("tag", this.tag);
        r100.extra = this.extra;
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

    public SlashCommandMeta(SlashCommandType r100, String r101, String r110, List<SlashCommandTag> r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public SlashCommandMeta(SlashCommandType r100, String r101, String r102, List<SlashCommandTag> r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.slash_command_type = r100;
        this.app_link = r101;
        this.description = r102;
        this.tag = Internal.immutableCopyOf("tag", r103);
        this.extra = r104;
    }
}
