package com.ss.android.lark.pb.usearch;

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

/* JADX INFO: loaded from: classes37.dex */
public final class MessageFilter extends Message<MessageFilter, Builder> {
    public static final ProtoAdapter<MessageFilter> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class AttachmentFilter extends Message<AttachmentFilter, Builder> {
        public static final ProtoAdapter<AttachmentFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<com.ss.android.lark.pb.entities.Message.MessageAttachmentType> minclude_attachment_types;

        public static final class Builder extends Message.Builder<AttachmentFilter, Builder> {
            public List<com.ss.android.lark.pb.entities.Message.MessageAttachmentType> minclude_attachment_types;

            @Override // com.squareup.wire.Message.Builder
            public AttachmentFilter build() {
                return new AttachmentFilter(this.minclude_attachment_types, super.buildUnknownFields());
            }

            public Builder() {
                this.minclude_attachment_types = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder include_attachment_types(List<com.ss.android.lark.pb.entities.Message.MessageAttachmentType> r100) {
                Internal.checkElementsNotNull(r100);
                this.minclude_attachment_types = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_AttachmentFilter extends ProtoAdapter<AttachmentFilter> {
            public ProtoAdapter_AttachmentFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, AttachmentFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AttachmentFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L7;
                r101.minclude_attachment_types.add(com.ss.android.lark.pb.entities.Message.MessageAttachmentType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(AttachmentFilter r100) {
                return com.ss.android.lark.pb.entities.Message.MessageAttachmentType.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.minclude_attachment_types) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AttachmentFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AttachmentFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AttachmentFilter r101) throws IOException {
                com.ss.android.lark.pb.entities.Message.MessageAttachmentType.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.minclude_attachment_types);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AttachmentFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AttachmentFilter();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.minclude_attachment_types = Internal.copyOf("minclude_attachment_types", this.minclude_attachment_types);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return AttachmentFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public AttachmentFilter(List<com.ss.android.lark.pb.entities.Message.MessageAttachmentType> r100) {
            this(r100, ByteString.EMPTY);
        }

        public AttachmentFilter(List<com.ss.android.lark.pb.entities.Message.MessageAttachmentType> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.minclude_attachment_types = Internal.immutableCopyOf("minclude_attachment_types", r100);
        }
    }

    public static final class Builder extends Message.Builder<MessageFilter, Builder> {
        @Override // com.squareup.wire.Message.Builder
        public MessageFilter build() {
            return new MessageFilter(super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }
    }

    public static final class ChatTypeFilter extends Message<ChatTypeFilter, Builder> {
        public static final ProtoAdapter<ChatTypeFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final ChatFilterType mchat_filter_type;

        public static final class Builder extends Message.Builder<ChatTypeFilter, Builder> {
            public ChatFilterType mchat_filter_type;

            @Override // com.squareup.wire.Message.Builder
            public ChatTypeFilter build() {
                return new ChatTypeFilter(this.mchat_filter_type, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder chat_filter_type(ChatFilterType r100) {
                this.mchat_filter_type = r100;
                return this;
            }
        }

        public static final enum ChatFilterType extends Enum<ChatFilterType> implements WireEnum {
            private static final /* synthetic */ ChatFilterType[] $VALUES = null;
            public static final ProtoAdapter<ChatFilterType> ADAPTER = null;
            public static final ChatFilterType DEFAULT = null;
            public static final ChatFilterType GROUP_CHAT = null;
            public static final ChatFilterType P2P_CHAT = null;
            private final int value;

            static {
                ChatFilterType r100 = new ChatFilterType("DEFAULT", 0, 0);
                DEFAULT = r100;
                ChatFilterType r101 = new ChatFilterType("GROUP_CHAT", 1, 1);
                GROUP_CHAT = r101;
                ChatFilterType r102 = new ChatFilterType("P2P_CHAT", 2, 2);
                P2P_CHAT = r102;
                $VALUES = new ChatFilterType[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(ChatFilterType.class);
            }

            public static ChatFilterType[] values() {
                return (ChatFilterType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static ChatFilterType fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return P2P_CHAT;
            L12:
                return GROUP_CHAT;
            L14:
                return DEFAULT;
            }

            public static ChatFilterType valueOf(String r100) {
                return (ChatFilterType) a.a(ChatFilterType.class, r100);
            }

            private ChatFilterType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_ChatTypeFilter extends ProtoAdapter<ChatTypeFilter> {
            public ProtoAdapter_ChatTypeFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, ChatTypeFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ChatTypeFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L7;
                r101.mchat_filter_type = ChatFilterType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ChatTypeFilter r100) {
                ChatFilterType r101 = r100.mchat_filter_type;
                if (r101 == null) goto L5;
                int r102 = ChatFilterType.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ChatTypeFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ChatTypeFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ChatTypeFilter r101) throws IOException {
                ChatFilterType r102 = r101.mchat_filter_type;
                if (r102 == null) goto L5;
                ChatFilterType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatTypeFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ChatTypeFilter();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mchat_filter_type = this.mchat_filter_type;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ChatTypeFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ChatTypeFilter(ChatFilterType r100) {
            this(r100, ByteString.EMPTY);
        }

        public ChatTypeFilter(ChatFilterType r100, ByteString r101) {
            super(ADAPTER, r101);
            this.mchat_filter_type = r100;
        }
    }

    public static final class FromUserFilter extends Message<FromUserFilter, Builder> {
        public static final ProtoAdapter<FromUserFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> muser_ids;

        public static final class Builder extends Message.Builder<FromUserFilter, Builder> {
            public List<String> muser_ids;

            @Override // com.squareup.wire.Message.Builder
            public FromUserFilter build() {
                return new FromUserFilter(this.muser_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.muser_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder user_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.muser_ids = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_FromUserFilter extends ProtoAdapter<FromUserFilter> {
            public ProtoAdapter_FromUserFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, FromUserFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public FromUserFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.muser_ids.add(ProtoAdapter.STRING.decode(r100));
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
            public int encodedSize2(FromUserFilter r100) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.muser_ids) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ FromUserFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(FromUserFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, FromUserFilter r101) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.muser_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FromUserFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_FromUserFilter();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.muser_ids = Internal.copyOf("muser_ids", this.muser_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return FromUserFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public FromUserFilter(List<String> r100) {
            this(r100, ByteString.EMPTY);
        }

        public FromUserFilter(List<String> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.muser_ids = Internal.immutableCopyOf("muser_ids", r100);
        }
    }

    public static final class InChatFilter extends Message<InChatFilter, Builder> {
        public static final ProtoAdapter<InChatFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> mgroup_chat_ids;
        public final List<String> mp2p_chatter_ids;

        public static final class Builder extends Message.Builder<InChatFilter, Builder> {
            public List<String> mgroup_chat_ids;
            public List<String> mp2p_chatter_ids;

            @Override // com.squareup.wire.Message.Builder
            public InChatFilter build() {
                return new InChatFilter(this.mgroup_chat_ids, this.mp2p_chatter_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.mgroup_chat_ids = Internal.newMutableList();
                this.mp2p_chatter_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder group_chat_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.mgroup_chat_ids = r100;
                return this;
            }

            public Builder p2p_chatter_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.mp2p_chatter_ids = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_InChatFilter extends ProtoAdapter<InChatFilter> {
            public ProtoAdapter_InChatFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, InChatFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public InChatFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mgroup_chat_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mp2p_chatter_ids.add(ProtoAdapter.STRING.decode(r100));
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
            public int encodedSize2(InChatFilter r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                return (r101.asRepeated().encodedSizeWithTag(1, r100.mgroup_chat_ids) + r101.asRepeated().encodedSizeWithTag(2, r100.mp2p_chatter_ids)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ InChatFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(InChatFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, InChatFilter r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.asRepeated().encodeWithTag(r100, 1, r101.mgroup_chat_ids);
                r102.asRepeated().encodeWithTag(r100, 2, r101.mp2p_chatter_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, InChatFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_InChatFilter();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mgroup_chat_ids = Internal.copyOf("mgroup_chat_ids", this.mgroup_chat_ids);
            r100.mp2p_chatter_ids = Internal.copyOf("mp2p_chatter_ids", this.mp2p_chatter_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return InChatFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public InChatFilter(List<String> r100, List<String> r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public InChatFilter(List<String> r100, List<String> r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mgroup_chat_ids = Internal.immutableCopyOf("mgroup_chat_ids", r100);
            this.mp2p_chatter_ids = Internal.immutableCopyOf("mp2p_chatter_ids", r101);
        }
    }

    public static final class MatchScopeFilter extends Message<MatchScopeFilter, Builder> {
        public static final ProtoAdapter<MatchScopeFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<ScopeType> mscope_types;

        public static final class Builder extends Message.Builder<MatchScopeFilter, Builder> {
            public List<ScopeType> mscope_types;

            @Override // com.squareup.wire.Message.Builder
            public MatchScopeFilter build() {
                return new MatchScopeFilter(this.mscope_types, super.buildUnknownFields());
            }

            public Builder() {
                this.mscope_types = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder scope_types(List<ScopeType> r100) {
                Internal.checkElementsNotNull(r100);
                this.mscope_types = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MatchScopeFilter extends ProtoAdapter<MatchScopeFilter> {
            public ProtoAdapter_MatchScopeFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, MatchScopeFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MatchScopeFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L7;
                r101.mscope_types.add(ScopeType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(MatchScopeFilter r100) {
                return ScopeType.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mscope_types) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MatchScopeFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MatchScopeFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MatchScopeFilter r101) throws IOException {
                ScopeType.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mscope_types);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MatchScopeFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum ScopeType extends Enum<ScopeType> implements WireEnum {
            private static final /* synthetic */ ScopeType[] $VALUES = null;
            public static final ProtoAdapter<ScopeType> ADAPTER = null;
            public static final ScopeType AT_ALL = null;
            public static final ScopeType AT_ME = null;
            public static final ScopeType BLOCK_BOT_MESSAGE = null;
            public static final ScopeType BLOCK_USER_MESSAGE = null;
            public static final ScopeType DEFAULT = null;
            private final int value;

            static {
                ScopeType r100 = new ScopeType("DEFAULT", 0, 0);
                DEFAULT = r100;
                ScopeType r101 = new ScopeType("AT_ME", 1, 1);
                AT_ME = r101;
                ScopeType r102 = new ScopeType("BLOCK_BOT_MESSAGE", 2, 2);
                BLOCK_BOT_MESSAGE = r102;
                ScopeType r103 = new ScopeType("BLOCK_USER_MESSAGE", 3, 3);
                BLOCK_USER_MESSAGE = r103;
                ScopeType r104 = new ScopeType("AT_ALL", 4, 4);
                AT_ALL = r104;
                $VALUES = new ScopeType[]{r100, r101, r102, r103, r104};
                ADAPTER = ProtoAdapter.newEnumAdapter(ScopeType.class);
            }

            public static ScopeType[] values() {
                return (ScopeType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static ScopeType fromValue(int r100) {
                if (r100 == 0) goto L22;
                if (r100 == 1) goto L20;
                if (r100 == 2) goto L18;
                if (r100 == 3) goto L16;
                if (r100 == 4) goto L14;
                return null;
            L14:
                return AT_ALL;
            L16:
                return BLOCK_USER_MESSAGE;
            L18:
                return BLOCK_BOT_MESSAGE;
            L20:
                return AT_ME;
            L22:
                return DEFAULT;
            }

            public static ScopeType valueOf(String r100) {
                return (ScopeType) a.a(ScopeType.class, r100);
            }

            private ScopeType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MatchScopeFilter();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mscope_types = Internal.copyOf("mscope_types", this.mscope_types);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MatchScopeFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public MatchScopeFilter(List<ScopeType> r100) {
            this(r100, ByteString.EMPTY);
        }

        public MatchScopeFilter(List<ScopeType> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.mscope_types = Internal.immutableCopyOf("mscope_types", r100);
        }
    }

    public static final class MessageTypeFilter extends Message<MessageTypeFilter, Builder> {
        public static final ProtoAdapter<MessageTypeFilter> ADAPTER = null;
        public static final Boolean DEFAULT_IS_URL = null;
        private static final long serialVersionUID = 0;
        public final Boolean mis_url;
        public final com.ss.android.lark.pb.entities.Message.Type mmessage_type;

        public static final class Builder extends Message.Builder<MessageTypeFilter, Builder> {
            public Boolean mis_url;
            public com.ss.android.lark.pb.entities.Message.Type mmessage_type;

            @Override // com.squareup.wire.Message.Builder
            public MessageTypeFilter build() {
                return new MessageTypeFilter(this.mmessage_type, this.mis_url, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder is_url(Boolean r100) {
                this.mis_url = r100;
                return this;
            }

            public Builder message_type(com.ss.android.lark.pb.entities.Message.Type r100) {
                this.mmessage_type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MessageTypeFilter extends ProtoAdapter<MessageTypeFilter> {
            public ProtoAdapter_MessageTypeFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, MessageTypeFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MessageTypeFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mis_url = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.mmessage_type = com.ss.android.lark.pb.entities.Message.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mis_url = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(MessageTypeFilter r100) {
                com.ss.android.lark.pb.entities.Message.Type r101 = r100.mmessage_type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = com.ss.android.lark.pb.entities.Message.Type.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.mis_url;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MessageTypeFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MessageTypeFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MessageTypeFilter r101) throws IOException {
                com.ss.android.lark.pb.entities.Message.Type r102 = r101.mmessage_type;
                if (r102 == null) goto L5;
                com.ss.android.lark.pb.entities.Message.Type.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.mis_url;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageTypeFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MessageTypeFilter();
            DEFAULT_IS_URL = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mmessage_type = this.mmessage_type;
            r100.mis_url = this.mis_url;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MessageTypeFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public MessageTypeFilter(com.ss.android.lark.pb.entities.Message.Type r100, Boolean r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public MessageTypeFilter(com.ss.android.lark.pb.entities.Message.Type r100, Boolean r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mmessage_type = r100;
            this.mis_url = r101;
        }
    }

    public static final class ProtoAdapter_MessageFilter extends ProtoAdapter<MessageFilter> {
        public ProtoAdapter_MessageFilter() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageFilter.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MessageFilter decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L6;
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L6:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MessageFilter r100) {
            return r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MessageFilter decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MessageFilter r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MessageFilter r101) throws IOException {
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageFilter r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class TimeFilter extends Message<TimeFilter, Builder> {
        public static final ProtoAdapter<TimeFilter> ADAPTER = null;
        public static final Long DEFAULT_CUSTOMIZED_END_TIME = null;
        public static final Long DEFAULT_CUSTOMIZED_START_TIME = null;
        private static final long serialVersionUID = 0;
        public final Long mcustomized_end_time;
        public final Long mcustomized_start_time;
        public final TimeFilterType mtime_range_type;

        public static final class Builder extends Message.Builder<TimeFilter, Builder> {
            public Long mcustomized_end_time;
            public Long mcustomized_start_time;
            public TimeFilterType mtime_range_type;

            @Override // com.squareup.wire.Message.Builder
            public TimeFilter build() {
                return new TimeFilter(this.mtime_range_type, this.mcustomized_start_time, this.mcustomized_end_time, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder customized_end_time(Long r100) {
                this.mcustomized_end_time = r100;
                return this;
            }

            public Builder customized_start_time(Long r100) {
                this.mcustomized_start_time = r100;
                return this;
            }

            public Builder time_range_type(TimeFilterType r100) {
                this.mtime_range_type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TimeFilter extends ProtoAdapter<TimeFilter> {
            public ProtoAdapter_TimeFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, TimeFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TimeFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mcustomized_start_time = 0L;
                r101.mcustomized_end_time = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.mtime_range_type = TimeFilterType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mcustomized_start_time = ProtoAdapter.INT64.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.mcustomized_end_time = ProtoAdapter.INT64.decode(r100);
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
            public int encodedSize2(TimeFilter r100) {
                TimeFilterType r101 = r100.mtime_range_type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = TimeFilterType.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.mcustomized_start_time;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Long r107 = r100.mcustomized_end_time;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ TimeFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TimeFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TimeFilter r101) throws IOException {
                TimeFilterType r102 = r101.mtime_range_type;
                if (r102 == null) goto L5;
                TimeFilterType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.mcustomized_start_time;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
            L8:
                Long r104 = r101.mcustomized_end_time;
                if (r104 == null) goto L11;
                ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TimeFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum TimeFilterType extends Enum<TimeFilterType> implements WireEnum {
            private static final /* synthetic */ TimeFilterType[] $VALUES = null;
            public static final ProtoAdapter<TimeFilterType> ADAPTER = null;
            public static final TimeFilterType CUSTOMIZED = null;
            public static final TimeFilterType DEFAULT = null;
            public static final TimeFilterType ONE_DAY = null;
            public static final TimeFilterType ONE_MONTH = null;
            public static final TimeFilterType ONE_WEEK = null;
            public static final TimeFilterType THREE_MONTH = null;
            private final int value;

            static {
                TimeFilterType r100 = new TimeFilterType("DEFAULT", 0, 0);
                DEFAULT = r100;
                TimeFilterType r101 = new TimeFilterType("ONE_DAY", 1, 1);
                ONE_DAY = r101;
                TimeFilterType r102 = new TimeFilterType("ONE_WEEK", 2, 2);
                ONE_WEEK = r102;
                TimeFilterType r103 = new TimeFilterType("ONE_MONTH", 3, 3);
                ONE_MONTH = r103;
                TimeFilterType r104 = new TimeFilterType("THREE_MONTH", 4, 4);
                THREE_MONTH = r104;
                TimeFilterType r105 = new TimeFilterType("CUSTOMIZED", 5, 5);
                CUSTOMIZED = r105;
                $VALUES = new TimeFilterType[]{r100, r101, r102, r103, r104, r105};
                ADAPTER = ProtoAdapter.newEnumAdapter(TimeFilterType.class);
            }

            public static TimeFilterType[] values() {
                return (TimeFilterType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static TimeFilterType fromValue(int r100) {
                if (r100 == 0) goto L26;
                if (r100 == 1) goto L24;
                if (r100 == 2) goto L22;
                if (r100 == 3) goto L20;
                if (r100 == 4) goto L18;
                if (r100 == 5) goto L16;
                return null;
            L16:
                return CUSTOMIZED;
            L18:
                return THREE_MONTH;
            L20:
                return ONE_MONTH;
            L22:
                return ONE_WEEK;
            L24:
                return ONE_DAY;
            L26:
                return DEFAULT;
            }

            public static TimeFilterType valueOf(String r100) {
                return (TimeFilterType) a.a(TimeFilterType.class, r100);
            }

            private TimeFilterType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TimeFilter();
            DEFAULT_CUSTOMIZED_START_TIME = 0L;
            DEFAULT_CUSTOMIZED_END_TIME = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mtime_range_type = this.mtime_range_type;
            r100.mcustomized_start_time = this.mcustomized_start_time;
            r100.mcustomized_end_time = this.mcustomized_end_time;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TimeFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public TimeFilter(TimeFilterType r100, Long r101, Long r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public TimeFilter(TimeFilterType r100, Long r101, Long r102, ByteString r103) {
            super(ADAPTER, r103);
            this.mtime_range_type = r100;
            this.mcustomized_start_time = r101;
            this.mcustomized_end_time = r102;
        }
    }

    public static final class WithUserFilter extends Message<WithUserFilter, Builder> {
        public static final ProtoAdapter<WithUserFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> muser_ids;

        public static final class Builder extends Message.Builder<WithUserFilter, Builder> {
            public List<String> muser_ids;

            @Override // com.squareup.wire.Message.Builder
            public WithUserFilter build() {
                return new WithUserFilter(this.muser_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.muser_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder user_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.muser_ids = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_WithUserFilter extends ProtoAdapter<WithUserFilter> {
            public ProtoAdapter_WithUserFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, WithUserFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public WithUserFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.muser_ids.add(ProtoAdapter.STRING.decode(r100));
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
            public int encodedSize2(WithUserFilter r100) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.muser_ids) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ WithUserFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(WithUserFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, WithUserFilter r101) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.muser_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WithUserFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_WithUserFilter();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.muser_ids = Internal.copyOf("muser_ids", this.muser_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return WithUserFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public WithUserFilter(List<String> r100) {
            this(r100, ByteString.EMPTY);
        }

        public WithUserFilter(List<String> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.muser_ids = Internal.immutableCopyOf("muser_ids", r100);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessageFilter();
    }

    public MessageFilter() {
        this(ByteString.EMPTY);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MessageFilter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MessageFilter(ByteString r100) {
        super(ADAPTER, r100);
    }
}
