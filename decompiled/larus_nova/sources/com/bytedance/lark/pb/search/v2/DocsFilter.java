package com.bytedance.lark.pb.search.v2;

import com.bytedance.lark.pb.basic.v1.Doc;
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
public final class DocsFilter extends Message<DocsFilter, Builder> {
    public static final ProtoAdapter<DocsFilter> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<DocsFilter, Builder> {
        @Override // com.squareup.wire.Message.Builder
        public DocsFilter build() {
            return new DocsFilter(super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }
    }

    public static final class ContainerTypeFilter extends Message<ContainerTypeFilter, Builder> {
        public static final ProtoAdapter<ContainerTypeFilter> ADAPTER = null;
        public static final ContainerType DEFAULT_CONTAINER_TYPE = null;
        private static final long serialVersionUID = 0;
        public final ContainerType container_type;

        public static final class Builder extends Message.Builder<ContainerTypeFilter, Builder> {
            public ContainerType container_type;

            @Override // com.squareup.wire.Message.Builder
            public ContainerTypeFilter build() {
                return new ContainerTypeFilter(this.container_type, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder container_type(ContainerType r100) {
                this.container_type = r100;
                return this;
            }
        }

        public static final enum ContainerType extends Enum<ContainerType> implements WireEnum {
            private static final /* synthetic */ ContainerType[] $VALUES = null;
            public static final ProtoAdapter<ContainerType> ADAPTER = null;
            public static final ContainerType DEFAULT = null;
            public static final ContainerType DOCS = null;
            public static final ContainerType WIKI = null;
            private final int value;

            static {
                ContainerType r100 = new ContainerType("DEFAULT", 0, 0);
                DEFAULT = r100;
                ContainerType r101 = new ContainerType("DOCS", 1, 1);
                DOCS = r101;
                ContainerType r102 = new ContainerType("WIKI", 2, 2);
                WIKI = r102;
                $VALUES = new ContainerType[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(ContainerType.class);
            }

            public static ContainerType[] values() {
                return (ContainerType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static ContainerType fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return WIKI;
            L12:
                return DOCS;
            L14:
                return DEFAULT;
            }

            public static ContainerType valueOf(String r100) {
                return (ContainerType) a.a(ContainerType.class, r100);
            }

            private ContainerType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_ContainerTypeFilter extends ProtoAdapter<ContainerTypeFilter> {
            public ProtoAdapter_ContainerTypeFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, ContainerTypeFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ContainerTypeFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.container_type = ContainerType.DEFAULT;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L7;
                r101.container_type = ContainerType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
            public int encodedSize2(ContainerTypeFilter r100) {
                ContainerType r101 = r100.container_type;
                if (r101 == null) goto L5;
                int r102 = ContainerType.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ContainerTypeFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ContainerTypeFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ContainerTypeFilter r101) throws IOException {
                ContainerType r102 = r101.container_type;
                if (r102 == null) goto L5;
                ContainerType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ContainerTypeFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ContainerTypeFilter();
            DEFAULT_CONTAINER_TYPE = ContainerType.DEFAULT;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.container_type = this.container_type;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ContainerTypeFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ContainerTypeFilter(ContainerType r100) {
            this(r100, ByteString.EMPTY);
        }

        public ContainerTypeFilter(ContainerType r100, ByteString r101) {
            super(ADAPTER, r101);
            this.container_type = r100;
        }
    }

    public static final class EnableExtendedSearch extends Message<EnableExtendedSearch, Builder> {
        public static final ProtoAdapter<EnableExtendedSearch> ADAPTER = null;
        public static final Boolean DEFAULT_ENABLE_EXTENDED_SEARCH = null;
        private static final long serialVersionUID = 0;
        public final Boolean enable_extended_search;

        public static final class Builder extends Message.Builder<EnableExtendedSearch, Builder> {
            public Boolean enable_extended_search;

            @Override // com.squareup.wire.Message.Builder
            public EnableExtendedSearch build() {
                Boolean r100 = this.enable_extended_search;
                if (r100 == null) goto L7;
                return new EnableExtendedSearch(this.enable_extended_search, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "enable_extended_search"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder enable_extended_search(Boolean r100) {
                this.enable_extended_search = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_EnableExtendedSearch extends ProtoAdapter<EnableExtendedSearch> {
            public ProtoAdapter_EnableExtendedSearch() {
                super(FieldEncoding.LENGTH_DELIMITED, EnableExtendedSearch.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public EnableExtendedSearch decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.enable_extended_search = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.enable_extended_search = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(EnableExtendedSearch r100) {
                return ProtoAdapter.BOOL.encodedSizeWithTag(1, r100.enable_extended_search) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ EnableExtendedSearch decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(EnableExtendedSearch r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, EnableExtendedSearch r101) throws IOException {
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r101.enable_extended_search);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EnableExtendedSearch r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_EnableExtendedSearch();
            DEFAULT_ENABLE_EXTENDED_SEARCH = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.enable_extended_search = this.enable_extended_search;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return EnableExtendedSearch.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public EnableExtendedSearch(Boolean r100) {
            this(r100, ByteString.EMPTY);
        }

        public EnableExtendedSearch(Boolean r100, ByteString r101) {
            super(ADAPTER, r101);
            this.enable_extended_search = r100;
        }
    }

    public static final class FromUserFilter extends Message<FromUserFilter, Builder> {
        public static final ProtoAdapter<FromUserFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> user_ids;

        public static final class Builder extends Message.Builder<FromUserFilter, Builder> {
            public List<String> user_ids;

            @Override // com.squareup.wire.Message.Builder
            public FromUserFilter build() {
                return new FromUserFilter(this.user_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.user_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder user_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.user_ids = r100;
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
                r101.user_ids.add(ProtoAdapter.STRING.decode(r100));
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
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.user_ids) + r100.unknownFields().size();
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
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.user_ids);
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
            r100.user_ids = Internal.copyOf("user_ids", this.user_ids);
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
            this.user_ids = Internal.immutableCopyOf("user_ids", r100);
        }
    }

    public static final class InChatFilter extends Message<InChatFilter, Builder> {
        public static final ProtoAdapter<InChatFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> group_chat_ids;
        public final List<String> p2p_chatter_ids;

        public static final class Builder extends Message.Builder<InChatFilter, Builder> {
            public List<String> group_chat_ids;
            public List<String> p2p_chatter_ids;

            @Override // com.squareup.wire.Message.Builder
            public InChatFilter build() {
                return new InChatFilter(this.group_chat_ids, this.p2p_chatter_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.group_chat_ids = Internal.newMutableList();
                this.p2p_chatter_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder group_chat_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.group_chat_ids = r100;
                return this;
            }

            public Builder p2p_chatter_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.p2p_chatter_ids = r100;
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
                r101.group_chat_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.p2p_chatter_ids.add(ProtoAdapter.STRING.decode(r100));
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
                return (r101.asRepeated().encodedSizeWithTag(1, r100.group_chat_ids) + r101.asRepeated().encodedSizeWithTag(2, r100.p2p_chatter_ids)) + r100.unknownFields().size();
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
                r102.asRepeated().encodeWithTag(r100, 1, r101.group_chat_ids);
                r102.asRepeated().encodeWithTag(r100, 2, r101.p2p_chatter_ids);
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
            r100.group_chat_ids = Internal.copyOf("group_chat_ids", this.group_chat_ids);
            r100.p2p_chatter_ids = Internal.copyOf("p2p_chatter_ids", this.p2p_chatter_ids);
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
            this.group_chat_ids = Internal.immutableCopyOf("group_chat_ids", r100);
            this.p2p_chatter_ids = Internal.immutableCopyOf("p2p_chatter_ids", r101);
        }
    }

    public static final class InFolderFilter extends Message<InFolderFilter, Builder> {
        public static final ProtoAdapter<InFolderFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> folder_tokens;

        public static final class Builder extends Message.Builder<InFolderFilter, Builder> {
            public List<String> folder_tokens;

            @Override // com.squareup.wire.Message.Builder
            public InFolderFilter build() {
                return new InFolderFilter(this.folder_tokens, super.buildUnknownFields());
            }

            public Builder() {
                this.folder_tokens = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder folder_tokens(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.folder_tokens = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_InFolderFilter extends ProtoAdapter<InFolderFilter> {
            public ProtoAdapter_InFolderFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, InFolderFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public InFolderFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.folder_tokens.add(ProtoAdapter.STRING.decode(r100));
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
            public int encodedSize2(InFolderFilter r100) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.folder_tokens) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ InFolderFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(InFolderFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, InFolderFilter r101) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.folder_tokens);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, InFolderFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_InFolderFilter();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.folder_tokens = Internal.copyOf("folder_tokens", this.folder_tokens);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return InFolderFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public InFolderFilter(List<String> r100) {
            this(r100, ByteString.EMPTY);
        }

        public InFolderFilter(List<String> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.folder_tokens = Internal.immutableCopyOf("folder_tokens", r100);
        }
    }

    public static final class InWikiSpaceFilter extends Message<InWikiSpaceFilter, Builder> {
        public static final ProtoAdapter<InWikiSpaceFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> space_ids;

        public static final class Builder extends Message.Builder<InWikiSpaceFilter, Builder> {
            public List<String> space_ids;

            @Override // com.squareup.wire.Message.Builder
            public InWikiSpaceFilter build() {
                return new InWikiSpaceFilter(this.space_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.space_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder space_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.space_ids = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_InWikiSpaceFilter extends ProtoAdapter<InWikiSpaceFilter> {
            public ProtoAdapter_InWikiSpaceFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, InWikiSpaceFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public InWikiSpaceFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.space_ids.add(ProtoAdapter.STRING.decode(r100));
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
            public int encodedSize2(InWikiSpaceFilter r100) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.space_ids) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ InWikiSpaceFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(InWikiSpaceFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, InWikiSpaceFilter r101) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.space_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, InWikiSpaceFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_InWikiSpaceFilter();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.space_ids = Internal.copyOf("space_ids", this.space_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return InWikiSpaceFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public InWikiSpaceFilter(List<String> r100) {
            this(r100, ByteString.EMPTY);
        }

        public InWikiSpaceFilter(List<String> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.space_ids = Internal.immutableCopyOf("space_ids", r100);
        }
    }

    public static final class MatchTypeFilter extends Message<MatchTypeFilter, Builder> {
        public static final ProtoAdapter<MatchTypeFilter> ADAPTER = null;
        public static final MatchType DEFAULT_MATCH_TYPE = null;
        private static final long serialVersionUID = 0;
        public final MatchType match_type;

        public static final class Builder extends Message.Builder<MatchTypeFilter, Builder> {
            public MatchType match_type;

            @Override // com.squareup.wire.Message.Builder
            public MatchTypeFilter build() {
                return new MatchTypeFilter(this.match_type, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder match_type(MatchType r100) {
                this.match_type = r100;
                return this;
            }
        }

        public static final enum MatchType extends Enum<MatchType> implements WireEnum {
            private static final /* synthetic */ MatchType[] $VALUES = null;
            public static final ProtoAdapter<MatchType> ADAPTER = null;
            public static final MatchType DEFAULT = null;
            public static final MatchType ONLY_COMMENT = null;
            public static final MatchType ONLY_TITLE = null;
            public static final MatchType TRANSLATE_EN_TO_CN = null;
            private final int value;

            static {
                MatchType r100 = new MatchType("DEFAULT", 0, 0);
                DEFAULT = r100;
                MatchType r101 = new MatchType("ONLY_TITLE", 1, 1);
                ONLY_TITLE = r101;
                MatchType r102 = new MatchType("ONLY_COMMENT", 2, 2);
                ONLY_COMMENT = r102;
                MatchType r103 = new MatchType("TRANSLATE_EN_TO_CN", 3, 3);
                TRANSLATE_EN_TO_CN = r103;
                $VALUES = new MatchType[]{r100, r101, r102, r103};
                ADAPTER = ProtoAdapter.newEnumAdapter(MatchType.class);
            }

            public static MatchType[] values() {
                return (MatchType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static MatchType fromValue(int r100) {
                if (r100 == 0) goto L18;
                if (r100 == 1) goto L16;
                if (r100 == 2) goto L14;
                if (r100 == 3) goto L12;
                return null;
            L12:
                return TRANSLATE_EN_TO_CN;
            L14:
                return ONLY_COMMENT;
            L16:
                return ONLY_TITLE;
            L18:
                return DEFAULT;
            }

            public static MatchType valueOf(String r100) {
                return (MatchType) a.a(MatchType.class, r100);
            }

            private MatchType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_MatchTypeFilter extends ProtoAdapter<MatchTypeFilter> {
            public ProtoAdapter_MatchTypeFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, MatchTypeFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MatchTypeFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.match_type = MatchType.DEFAULT;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L7;
                r101.match_type = MatchType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
            public int encodedSize2(MatchTypeFilter r100) {
                MatchType r101 = r100.match_type;
                if (r101 == null) goto L5;
                int r102 = MatchType.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MatchTypeFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MatchTypeFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MatchTypeFilter r101) throws IOException {
                MatchType r102 = r101.match_type;
                if (r102 == null) goto L5;
                MatchType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MatchTypeFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MatchTypeFilter();
            DEFAULT_MATCH_TYPE = MatchType.DEFAULT;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.match_type = this.match_type;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MatchTypeFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public MatchTypeFilter(MatchType r100) {
            this(r100, ByteString.EMPTY);
        }

        public MatchTypeFilter(MatchType r100, ByteString r101) {
            super(ADAPTER, r101);
            this.match_type = r100;
        }
    }

    public static final class ObjectTypeFilter extends Message<ObjectTypeFilter, Builder> {
        public static final ProtoAdapter<ObjectTypeFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<Doc.Type> object_types;

        public static final class Builder extends Message.Builder<ObjectTypeFilter, Builder> {
            public List<Doc.Type> object_types;

            @Override // com.squareup.wire.Message.Builder
            public ObjectTypeFilter build() {
                return new ObjectTypeFilter(this.object_types, super.buildUnknownFields());
            }

            public Builder() {
                this.object_types = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder object_types(List<Doc.Type> r100) {
                Internal.checkElementsNotNull(r100);
                this.object_types = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ObjectTypeFilter extends ProtoAdapter<ObjectTypeFilter> {
            public ProtoAdapter_ObjectTypeFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, ObjectTypeFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ObjectTypeFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L7;
                r101.object_types.add(Doc.Type.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
            public int encodedSize2(ObjectTypeFilter r100) {
                return Doc.Type.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.object_types) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ObjectTypeFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ObjectTypeFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ObjectTypeFilter r101) throws IOException {
                Doc.Type.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.object_types);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ObjectTypeFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ObjectTypeFilter();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.object_types = Internal.copyOf("object_types", this.object_types);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ObjectTypeFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ObjectTypeFilter(List<Doc.Type> r100) {
            this(r100, ByteString.EMPTY);
        }

        public ObjectTypeFilter(List<Doc.Type> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.object_types = Internal.immutableCopyOf("object_types", r100);
        }
    }

    public static final class OpenTimeRangeFilter extends Message<OpenTimeRangeFilter, Builder> {
        public static final ProtoAdapter<OpenTimeRangeFilter> ADAPTER = null;
        public static final Long DEFAULT_CUSTOMIZED_END_TIME = null;
        public static final Long DEFAULT_CUSTOMIZED_START_TIME = null;
        public static final TimeRangeType DEFAULT_TIME_RANGE_TYPE = null;
        private static final long serialVersionUID = 0;
        public final Long customized_end_time;
        public final Long customized_start_time;
        public final TimeRangeType time_range_type;

        public static final class Builder extends Message.Builder<OpenTimeRangeFilter, Builder> {
            public Long customized_end_time;
            public Long customized_start_time;
            public TimeRangeType time_range_type;

            @Override // com.squareup.wire.Message.Builder
            public OpenTimeRangeFilter build() {
                return new OpenTimeRangeFilter(this.time_range_type, this.customized_start_time, this.customized_end_time, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder customized_end_time(Long r100) {
                this.customized_end_time = r100;
                return this;
            }

            public Builder customized_start_time(Long r100) {
                this.customized_start_time = r100;
                return this;
            }

            public Builder time_range_type(TimeRangeType r100) {
                this.time_range_type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_OpenTimeRangeFilter extends ProtoAdapter<OpenTimeRangeFilter> {
            public ProtoAdapter_OpenTimeRangeFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, OpenTimeRangeFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public OpenTimeRangeFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.time_range_type = TimeRangeType.DEFAULT;
                r101.customized_start_time = 0L;
                r101.customized_end_time = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.time_range_type = TimeRangeType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.customized_start_time = ProtoAdapter.INT64.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.customized_end_time = ProtoAdapter.INT64.decode(r100);
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
            public int encodedSize2(OpenTimeRangeFilter r100) {
                TimeRangeType r101 = r100.time_range_type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = TimeRangeType.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.customized_start_time;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Long r107 = r100.customized_end_time;
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
            public /* bridge */ /* synthetic */ OpenTimeRangeFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(OpenTimeRangeFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, OpenTimeRangeFilter r101) throws IOException {
                TimeRangeType r102 = r101.time_range_type;
                if (r102 == null) goto L5;
                TimeRangeType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.customized_start_time;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
            L8:
                Long r104 = r101.customized_end_time;
                if (r104 == null) goto L11;
                ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OpenTimeRangeFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum TimeRangeType extends Enum<TimeRangeType> implements WireEnum {
            private static final /* synthetic */ TimeRangeType[] $VALUES = null;
            public static final ProtoAdapter<TimeRangeType> ADAPTER = null;
            public static final TimeRangeType CUSTOMIZED = null;
            public static final TimeRangeType DEFAULT = null;
            public static final TimeRangeType LAST_ONE_DAY = null;
            public static final TimeRangeType LAST_ONE_MONTH = null;
            public static final TimeRangeType LAST_ONE_WEEK = null;
            public static final TimeRangeType LAST_THREE_MONTH = null;
            private final int value;

            static {
                TimeRangeType r100 = new TimeRangeType("DEFAULT", 0, 0);
                DEFAULT = r100;
                TimeRangeType r101 = new TimeRangeType("LAST_ONE_DAY", 1, 1);
                LAST_ONE_DAY = r101;
                TimeRangeType r102 = new TimeRangeType("LAST_ONE_WEEK", 2, 2);
                LAST_ONE_WEEK = r102;
                TimeRangeType r103 = new TimeRangeType("LAST_ONE_MONTH", 3, 3);
                LAST_ONE_MONTH = r103;
                TimeRangeType r104 = new TimeRangeType("LAST_THREE_MONTH", 4, 4);
                LAST_THREE_MONTH = r104;
                TimeRangeType r105 = new TimeRangeType("CUSTOMIZED", 5, 5);
                CUSTOMIZED = r105;
                $VALUES = new TimeRangeType[]{r100, r101, r102, r103, r104, r105};
                ADAPTER = ProtoAdapter.newEnumAdapter(TimeRangeType.class);
            }

            public static TimeRangeType[] values() {
                return (TimeRangeType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static TimeRangeType fromValue(int r100) {
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
                return LAST_THREE_MONTH;
            L20:
                return LAST_ONE_MONTH;
            L22:
                return LAST_ONE_WEEK;
            L24:
                return LAST_ONE_DAY;
            L26:
                return DEFAULT;
            }

            public static TimeRangeType valueOf(String r100) {
                return (TimeRangeType) a.a(TimeRangeType.class, r100);
            }

            private TimeRangeType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OpenTimeRangeFilter();
            DEFAULT_TIME_RANGE_TYPE = TimeRangeType.DEFAULT;
            DEFAULT_CUSTOMIZED_START_TIME = 0L;
            DEFAULT_CUSTOMIZED_END_TIME = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.time_range_type = this.time_range_type;
            r100.customized_start_time = this.customized_start_time;
            r100.customized_end_time = this.customized_end_time;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return OpenTimeRangeFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public OpenTimeRangeFilter(TimeRangeType r100, Long r101, Long r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public OpenTimeRangeFilter(TimeRangeType r100, Long r101, Long r102, ByteString r103) {
            super(ADAPTER, r103);
            this.time_range_type = r100;
            this.customized_start_time = r101;
            this.customized_end_time = r102;
        }
    }

    public static final class OwnerFilter extends Message<OwnerFilter, Builder> {
        public static final ProtoAdapter<OwnerFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> user_ids;

        public static final class Builder extends Message.Builder<OwnerFilter, Builder> {
            public List<String> user_ids;

            @Override // com.squareup.wire.Message.Builder
            public OwnerFilter build() {
                return new OwnerFilter(this.user_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.user_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder user_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.user_ids = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_OwnerFilter extends ProtoAdapter<OwnerFilter> {
            public ProtoAdapter_OwnerFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, OwnerFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public OwnerFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.user_ids.add(ProtoAdapter.STRING.decode(r100));
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
            public int encodedSize2(OwnerFilter r100) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.user_ids) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ OwnerFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(OwnerFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, OwnerFilter r101) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.user_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OwnerFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OwnerFilter();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.user_ids = Internal.copyOf("user_ids", this.user_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return OwnerFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public OwnerFilter(List<String> r100) {
            this(r100, ByteString.EMPTY);
        }

        public OwnerFilter(List<String> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.user_ids = Internal.immutableCopyOf("user_ids", r100);
        }
    }

    public static final class ProtoAdapter_DocsFilter extends ProtoAdapter<DocsFilter> {
        public ProtoAdapter_DocsFilter() {
            super(FieldEncoding.LENGTH_DELIMITED, DocsFilter.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DocsFilter decode(ProtoReader r100) throws IOException {
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
        public int encodedSize2(DocsFilter r100) {
            return r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DocsFilter decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DocsFilter r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DocsFilter r101) throws IOException {
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DocsFilter r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class SharerFilter extends Message<SharerFilter, Builder> {
        public static final ProtoAdapter<SharerFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> user_ids;

        public static final class Builder extends Message.Builder<SharerFilter, Builder> {
            public List<String> user_ids;

            @Override // com.squareup.wire.Message.Builder
            public SharerFilter build() {
                return new SharerFilter(this.user_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.user_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder user_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.user_ids = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SharerFilter extends ProtoAdapter<SharerFilter> {
            public ProtoAdapter_SharerFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, SharerFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SharerFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.user_ids.add(ProtoAdapter.STRING.decode(r100));
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
            public int encodedSize2(SharerFilter r100) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.user_ids) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SharerFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SharerFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SharerFilter r101) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.user_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SharerFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SharerFilter();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.user_ids = Internal.copyOf("user_ids", this.user_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SharerFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SharerFilter(List<String> r100) {
            this(r100, ByteString.EMPTY);
        }

        public SharerFilter(List<String> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.user_ids = Internal.immutableCopyOf("user_ids", r100);
        }
    }

    public static final class Sorter extends Message<Sorter, Builder> {
        public static final ProtoAdapter<Sorter> ADAPTER = null;
        public static final SortByField DEFAULT_SORT_BY_FIELD = null;
        private static final long serialVersionUID = 0;
        public final SortByField sort_by_field;

        public static final class Builder extends Message.Builder<Sorter, Builder> {
            public SortByField sort_by_field;

            @Override // com.squareup.wire.Message.Builder
            public Sorter build() {
                return new Sorter(this.sort_by_field, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder sort_by_field(SortByField r100) {
                this.sort_by_field = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Sorter extends ProtoAdapter<Sorter> {
            public ProtoAdapter_Sorter() {
                super(FieldEncoding.LENGTH_DELIMITED, Sorter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Sorter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.sort_by_field = SortByField.DEFAULT;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L7;
                r101.sort_by_field = SortByField.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
            public int encodedSize2(Sorter r100) {
                SortByField r101 = r100.sort_by_field;
                if (r101 == null) goto L5;
                int r102 = SortByField.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Sorter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Sorter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Sorter r101) throws IOException {
                SortByField r102 = r101.sort_by_field;
                if (r102 == null) goto L5;
                SortByField.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Sorter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum SortByField extends Enum<SortByField> implements WireEnum {
            private static final /* synthetic */ SortByField[] $VALUES = null;
            public static final ProtoAdapter<SortByField> ADAPTER = null;
            public static final SortByField CREATE_TIME = null;
            public static final SortByField DEFAULT = null;
            public static final SortByField EDIT_TIME = null;
            public static final SortByField OPEN_TIME = null;
            private final int value;

            static {
                SortByField r100 = new SortByField("DEFAULT", 0, 0);
                DEFAULT = r100;
                SortByField r101 = new SortByField("OPEN_TIME", 1, 1);
                OPEN_TIME = r101;
                SortByField r102 = new SortByField("EDIT_TIME", 2, 2);
                EDIT_TIME = r102;
                SortByField r103 = new SortByField("CREATE_TIME", 3, 3);
                CREATE_TIME = r103;
                $VALUES = new SortByField[]{r100, r101, r102, r103};
                ADAPTER = ProtoAdapter.newEnumAdapter(SortByField.class);
            }

            public static SortByField[] values() {
                return (SortByField[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static SortByField fromValue(int r100) {
                if (r100 == 0) goto L18;
                if (r100 == 1) goto L16;
                if (r100 == 2) goto L14;
                if (r100 == 3) goto L12;
                return null;
            L12:
                return CREATE_TIME;
            L14:
                return EDIT_TIME;
            L16:
                return OPEN_TIME;
            L18:
                return DEFAULT;
            }

            public static SortByField valueOf(String r100) {
                return (SortByField) a.a(SortByField.class, r100);
            }

            private SortByField(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Sorter();
            DEFAULT_SORT_BY_FIELD = SortByField.DEFAULT;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.sort_by_field = this.sort_by_field;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Sorter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Sorter(SortByField r100) {
            this(r100, ByteString.EMPTY);
        }

        public Sorter(SortByField r100, ByteString r101) {
            super(ADAPTER, r101);
            this.sort_by_field = r100;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DocsFilter();
    }

    public DocsFilter() {
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
        return DocsFilter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DocsFilter(ByteString r100) {
        super(ADAPTER, r100);
    }
}
