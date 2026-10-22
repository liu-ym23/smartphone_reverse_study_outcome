package com.bytedance.lark.pb.im.v1;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
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
public final class ChatChatterTagInfo extends Message<ChatChatterTagInfo, Builder> {
    public static final ProtoAdapter<ChatChatterTagInfo> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<TagInfo> tags;

    public static final class Builder extends Message.Builder<ChatChatterTagInfo, Builder> {
        public List<TagInfo> tags;

        @Override // com.squareup.wire.Message.Builder
        public ChatChatterTagInfo build() {
            return new ChatChatterTagInfo(this.tags, super.buildUnknownFields());
        }

        public Builder() {
            this.tags = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder tags(List<TagInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.tags = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatChatterTagInfo extends ProtoAdapter<ChatChatterTagInfo> {
        public ProtoAdapter_ChatChatterTagInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatChatterTagInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatChatterTagInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.tags.add(TagInfo.ADAPTER.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ChatChatterTagInfo r100) {
            return TagInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.tags) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ChatChatterTagInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatChatterTagInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatChatterTagInfo r101) throws IOException {
            TagInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.tags);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatChatterTagInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class TagInfo extends Message<TagInfo, Builder> {
        public static final ProtoAdapter<TagInfo> ADAPTER = null;
        public static final String DEFAULT_DESCRIPTION = "";
        public static final TagType DEFAULT_TAG_TYPE = null;
        private static final long serialVersionUID = 0;
        public final String description;
        public final TagType tag_type;

        public static final class Builder extends Message.Builder<TagInfo, Builder> {
            public String description;
            public TagType tag_type;

            @Override // com.squareup.wire.Message.Builder
            public TagInfo build() {
                return new TagInfo(this.tag_type, this.description, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder description(String r100) {
                this.description = r100;
                return this;
            }

            public Builder tag_type(TagType r100) {
                this.tag_type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TagInfo extends ProtoAdapter<TagInfo> {
            public ProtoAdapter_TagInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, TagInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TagInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.tag_type = TagType.UNKNOWN;
                r101.description = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.tag_type = TagType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.description = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(TagInfo r100) {
                TagType r101 = r100.tag_type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = TagType.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.description;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TagInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TagInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TagInfo r101) throws IOException {
                TagType r102 = r101.tag_type;
                if (r102 == null) goto L5;
                TagType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.description;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TagInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum TagType extends Enum<TagType> implements WireEnum {
            private static final /* synthetic */ TagType[] $VALUES = null;
            public static final ProtoAdapter<TagType> ADAPTER = null;
            public static final TagType CLASS_TEACHER = null;
            public static final TagType DISCIPLINE_TEACHER = null;
            public static final TagType UNKNOWN = null;
            private final int value;

            static {
                TagType r100 = new TagType("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                TagType r101 = new TagType("CLASS_TEACHER", 1, 1);
                CLASS_TEACHER = r101;
                TagType r102 = new TagType("DISCIPLINE_TEACHER", 2, 2);
                DISCIPLINE_TEACHER = r102;
                $VALUES = new TagType[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(TagType.class);
            }

            public static TagType[] values() {
                return (TagType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static TagType fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return DISCIPLINE_TEACHER;
            L12:
                return CLASS_TEACHER;
            L14:
                return UNKNOWN;
            }

            public static TagType valueOf(String r100) {
                return (TagType) a.a(TagType.class, r100);
            }

            private TagType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TagInfo();
            DEFAULT_TAG_TYPE = TagType.UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.tag_type = this.tag_type;
            r100.description = this.description;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TagInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public TagInfo(TagType r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public TagInfo(TagType r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.tag_type = r100;
            this.description = r101;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatChatterTagInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.tags = Internal.copyOf(PromotionProductPrivilegesStruct.TAGS, this.tags);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatChatterTagInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatChatterTagInfo(List<TagInfo> r100) {
        this(r100, ByteString.EMPTY);
    }

    public ChatChatterTagInfo(List<TagInfo> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.tags = Internal.immutableCopyOf(PromotionProductPrivilegesStruct.TAGS, r100);
    }
}
