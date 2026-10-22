package com.bytedance.lark.pb.search.v2;

import com.bytedance.lark.pb.search.v1.FilterInTab;
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
public final class UniversalSelectors extends Message<UniversalSelectors, Builder> {
    public static final ProtoAdapter<UniversalSelectors> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class BotSelector extends Message<BotSelector, Builder> {
        public static final ProtoAdapter<BotSelector> ADAPTER = null;
        public static final String DEFAULT_IS_IN_CHAT_ID = "";
        private static final long serialVersionUID = 0;
        public final String is_in_chat_id;

        public static final class Builder extends Message.Builder<BotSelector, Builder> {
            public String is_in_chat_id;

            @Override // com.squareup.wire.Message.Builder
            public BotSelector build() {
                return new BotSelector(this.is_in_chat_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder is_in_chat_id(String r100) {
                this.is_in_chat_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_BotSelector extends ProtoAdapter<BotSelector> {
            public ProtoAdapter_BotSelector() {
                super(FieldEncoding.LENGTH_DELIMITED, BotSelector.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public BotSelector decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.is_in_chat_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.is_in_chat_id = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(BotSelector r100) {
                String r101 = r100.is_in_chat_id;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ BotSelector decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(BotSelector r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, BotSelector r101) throws IOException {
                String r102 = r101.is_in_chat_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BotSelector r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_BotSelector();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.is_in_chat_id = this.is_in_chat_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return BotSelector.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public BotSelector(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public BotSelector(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.is_in_chat_id = r100;
        }
    }

    public static final class Builder extends Message.Builder<UniversalSelectors, Builder> {
        @Override // com.squareup.wire.Message.Builder
        public UniversalSelectors build() {
            return new UniversalSelectors(super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }
    }

    public static final class CryptoP2PChatSelector extends Message<CryptoP2PChatSelector, Builder> {
        public static final ProtoAdapter<CryptoP2PChatSelector> ADAPTER = null;
        public static final Boolean DEFAULT_RELATION_TAG = null;
        private static final long serialVersionUID = 0;
        public final Boolean relation_tag;

        public static final class Builder extends Message.Builder<CryptoP2PChatSelector, Builder> {
            public Boolean relation_tag;

            @Override // com.squareup.wire.Message.Builder
            public CryptoP2PChatSelector build() {
                return new CryptoP2PChatSelector(this.relation_tag, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder relation_tag(Boolean r100) {
                this.relation_tag = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CryptoP2PChatSelector extends ProtoAdapter<CryptoP2PChatSelector> {
            public ProtoAdapter_CryptoP2PChatSelector() {
                super(FieldEncoding.LENGTH_DELIMITED, CryptoP2PChatSelector.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CryptoP2PChatSelector decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.relation_tag = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.relation_tag = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(CryptoP2PChatSelector r100) {
                Boolean r101 = r100.relation_tag;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CryptoP2PChatSelector decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CryptoP2PChatSelector r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CryptoP2PChatSelector r101) throws IOException {
                Boolean r102 = r101.relation_tag;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CryptoP2PChatSelector r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CryptoP2PChatSelector();
            DEFAULT_RELATION_TAG = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.relation_tag = this.relation_tag;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CryptoP2PChatSelector.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public CryptoP2PChatSelector(Boolean r100) {
            this(r100, ByteString.EMPTY);
        }

        public CryptoP2PChatSelector(Boolean r100, ByteString r101) {
            super(ADAPTER, r101);
            this.relation_tag = r100;
        }
    }

    public static final class CustomizationSelector extends Message<CustomizationSelector, Builder> {
        public static final ProtoAdapter<CustomizationSelector> ADAPTER = null;
        public static final RenderType DEFAULT_RENDER_TYPE = null;
        private static final long serialVersionUID = 0;
        public final RenderType render_type;

        public static final class Builder extends Message.Builder<CustomizationSelector, Builder> {
            public RenderType render_type;

            @Override // com.squareup.wire.Message.Builder
            public CustomizationSelector build() {
                return new CustomizationSelector(this.render_type, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder render_type(RenderType r100) {
                this.render_type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CustomizationSelector extends ProtoAdapter<CustomizationSelector> {
            public ProtoAdapter_CustomizationSelector() {
                super(FieldEncoding.LENGTH_DELIMITED, CustomizationSelector.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CustomizationSelector decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.render_type = RenderType.AS_CARD;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L7;
                r101.render_type = RenderType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
            public int encodedSize2(CustomizationSelector r100) {
                RenderType r101 = r100.render_type;
                if (r101 == null) goto L5;
                int r102 = RenderType.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CustomizationSelector decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CustomizationSelector r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CustomizationSelector r101) throws IOException {
                RenderType r102 = r101.render_type;
                if (r102 == null) goto L5;
                RenderType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomizationSelector r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CustomizationSelector();
            DEFAULT_RENDER_TYPE = RenderType.AS_CARD;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.render_type = this.render_type;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CustomizationSelector.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public CustomizationSelector(RenderType r100) {
            this(r100, ByteString.EMPTY);
        }

        public CustomizationSelector(RenderType r100, ByteString r101) {
            super(ADAPTER, r101);
            this.render_type = r100;
        }
    }

    public static final class DocSelector extends Message<DocSelector, Builder> {
        public static final ProtoAdapter<DocSelector> ADAPTER = null;
        public static final Boolean DEFAULT_NEED_COLD_HOT_MODE = null;
        public static final Boolean DEFAULT_RELATION_TAG = null;
        private static final long serialVersionUID = 0;
        public final Boolean need_cold_hot_mode;
        public final Boolean relation_tag;

        public static final class Builder extends Message.Builder<DocSelector, Builder> {
            public Boolean need_cold_hot_mode;
            public Boolean relation_tag;

            @Override // com.squareup.wire.Message.Builder
            public DocSelector build() {
                return new DocSelector(this.relation_tag, this.need_cold_hot_mode, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder need_cold_hot_mode(Boolean r100) {
                this.need_cold_hot_mode = r100;
                return this;
            }

            public Builder relation_tag(Boolean r100) {
                this.relation_tag = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DocSelector extends ProtoAdapter<DocSelector> {
            public ProtoAdapter_DocSelector() {
                super(FieldEncoding.LENGTH_DELIMITED, DocSelector.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DocSelector decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.FALSE;
                r101.relation_tag = r102;
                r101.need_cold_hot_mode = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L12;
                if (r104 != 1) goto L8;
                r101.relation_tag = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L9;
                r101.need_cold_hot_mode = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L9:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DocSelector r100) {
                Boolean r101 = r100.relation_tag;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.need_cold_hot_mode;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DocSelector decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DocSelector r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DocSelector r101) throws IOException {
                Boolean r102 = r101.relation_tag;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.need_cold_hot_mode;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DocSelector r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DocSelector();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_RELATION_TAG = r100;
            DEFAULT_NEED_COLD_HOT_MODE = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.relation_tag = this.relation_tag;
            r100.need_cold_hot_mode = this.need_cold_hot_mode;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DocSelector.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DocSelector(Boolean r100, Boolean r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public DocSelector(Boolean r100, Boolean r101, ByteString r102) {
            super(ADAPTER, r102);
            this.relation_tag = r100;
            this.need_cold_hot_mode = r101;
        }
    }

    public static final class GroupChatSelector extends Message<GroupChatSelector, Builder> {
        public static final ProtoAdapter<GroupChatSelector> ADAPTER = null;
        public static final String DEFAULT_IS_IN_TEAM_ID = "";
        public static final Boolean DEFAULT_RELATION_TAG = null;
        public static final Boolean DEFAULT_SHOW_ENTERPRISE_EMAIL = null;
        private static final long serialVersionUID = 0;
        public final String is_in_team_id;
        public final Boolean relation_tag;
        public final Boolean show_enterprise_email;

        public static final class Builder extends Message.Builder<GroupChatSelector, Builder> {
            public String is_in_team_id;
            public Boolean relation_tag;
            public Boolean show_enterprise_email;

            @Override // com.squareup.wire.Message.Builder
            public GroupChatSelector build() {
                return new GroupChatSelector(this.is_in_team_id, this.relation_tag, this.show_enterprise_email, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder is_in_team_id(String r100) {
                this.is_in_team_id = r100;
                return this;
            }

            public Builder relation_tag(Boolean r100) {
                this.relation_tag = r100;
                return this;
            }

            public Builder show_enterprise_email(Boolean r100) {
                this.show_enterprise_email = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_GroupChatSelector extends ProtoAdapter<GroupChatSelector> {
            public ProtoAdapter_GroupChatSelector() {
                super(FieldEncoding.LENGTH_DELIMITED, GroupChatSelector.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GroupChatSelector decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.is_in_team_id = "";
                Boolean r102 = Boolean.FALSE;
                r101.relation_tag = r102;
                r101.show_enterprise_email = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L15;
                if (r104 != 1) goto L8;
                r101.is_in_team_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L10;
                r101.relation_tag = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                if (r104 != 3) goto L11;
                r101.show_enterprise_email = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L11:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(GroupChatSelector r100) {
                String r101 = r100.is_in_team_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.relation_tag;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.show_enterprise_email;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ GroupChatSelector decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(GroupChatSelector r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, GroupChatSelector r101) throws IOException {
                String r102 = r101.is_in_team_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.relation_tag;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.show_enterprise_email;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GroupChatSelector r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_GroupChatSelector();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_RELATION_TAG = r100;
            DEFAULT_SHOW_ENTERPRISE_EMAIL = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.is_in_team_id = this.is_in_team_id;
            r100.relation_tag = this.relation_tag;
            r100.show_enterprise_email = this.show_enterprise_email;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return GroupChatSelector.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public GroupChatSelector(String r100, Boolean r101, Boolean r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public GroupChatSelector(String r100, Boolean r101, Boolean r102, ByteString r103) {
            super(ADAPTER, r103);
            this.is_in_team_id = r100;
            this.relation_tag = r101;
            this.show_enterprise_email = r102;
        }
    }

    public static final class MessageFileSelector extends Message<MessageFileSelector, Builder> {
        public static final ProtoAdapter<MessageFileSelector> ADAPTER = null;
        public static final Boolean DEFAULT_ACCESS_AUTH = null;
        public static final Boolean DEFAULT_NEED_COLD_HOT_MODE = null;
        private static final long serialVersionUID = 0;
        public final Boolean access_auth;
        public final Boolean need_cold_hot_mode;

        public static final class Builder extends Message.Builder<MessageFileSelector, Builder> {
            public Boolean access_auth;
            public Boolean need_cold_hot_mode;

            @Override // com.squareup.wire.Message.Builder
            public MessageFileSelector build() {
                return new MessageFileSelector(this.access_auth, this.need_cold_hot_mode, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder access_auth(Boolean r100) {
                this.access_auth = r100;
                return this;
            }

            public Builder need_cold_hot_mode(Boolean r100) {
                this.need_cold_hot_mode = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MessageFileSelector extends ProtoAdapter<MessageFileSelector> {
            public ProtoAdapter_MessageFileSelector() {
                super(FieldEncoding.LENGTH_DELIMITED, MessageFileSelector.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MessageFileSelector decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.FALSE;
                r101.access_auth = r102;
                r101.need_cold_hot_mode = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L12;
                if (r104 != 1) goto L8;
                r101.access_auth = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L9;
                r101.need_cold_hot_mode = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L9:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(MessageFileSelector r100) {
                Boolean r101 = r100.access_auth;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.need_cold_hot_mode;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MessageFileSelector decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MessageFileSelector r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MessageFileSelector r101) throws IOException {
                Boolean r102 = r101.access_auth;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.need_cold_hot_mode;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageFileSelector r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MessageFileSelector();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_ACCESS_AUTH = r100;
            DEFAULT_NEED_COLD_HOT_MODE = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.access_auth = this.access_auth;
            r100.need_cold_hot_mode = this.need_cold_hot_mode;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MessageFileSelector.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public MessageFileSelector(Boolean r100, Boolean r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public MessageFileSelector(Boolean r100, Boolean r101, ByteString r102) {
            super(ADAPTER, r102);
            this.access_auth = r100;
            this.need_cold_hot_mode = r101;
        }
    }

    public static final class MessageSelector extends Message<MessageSelector, Builder> {
        public static final ProtoAdapter<MessageSelector> ADAPTER = null;
        public static final Boolean DEFAULT_ACCESS_AUTH = null;
        public static final Boolean DEFAULT_IS_AGGREGATED = null;
        public static final Long DEFAULT_LAST_CREATE_TIME = null;
        public static final String DEFAULT_LAST_ID = "";
        public static final Boolean DEFAULT_NEED_COLD_HOT_MODE = null;
        private static final long serialVersionUID = 0;
        public final Boolean access_auth;
        public final Boolean is_aggregated;
        public final Long last_create_time;
        public final String last_id;
        public final Boolean need_cold_hot_mode;

        public static final class Builder extends Message.Builder<MessageSelector, Builder> {
            public Boolean access_auth;
            public Boolean is_aggregated;
            public Long last_create_time;
            public String last_id;
            public Boolean need_cold_hot_mode;

            @Override // com.squareup.wire.Message.Builder
            public MessageSelector build() {
                return new MessageSelector(this.is_aggregated, this.last_create_time, this.last_id, this.access_auth, this.need_cold_hot_mode, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder access_auth(Boolean r100) {
                this.access_auth = r100;
                return this;
            }

            public Builder is_aggregated(Boolean r100) {
                this.is_aggregated = r100;
                return this;
            }

            public Builder last_create_time(Long r100) {
                this.last_create_time = r100;
                return this;
            }

            public Builder last_id(String r100) {
                this.last_id = r100;
                return this;
            }

            public Builder need_cold_hot_mode(Boolean r100) {
                this.need_cold_hot_mode = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MessageSelector extends ProtoAdapter<MessageSelector> {
            public ProtoAdapter_MessageSelector() {
                super(FieldEncoding.LENGTH_DELIMITED, MessageSelector.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MessageSelector decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.FALSE;
                r101.is_aggregated = r102;
                r101.last_create_time = 0L;
                r101.last_id = "";
                r101.access_auth = r102;
                r101.need_cold_hot_mode = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L21;
                if (r104 != 1) goto L8;
                r101.is_aggregated = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L10;
                r101.last_create_time = ProtoAdapter.INT64.decode(r100);
                goto L3
            L10:
                if (r104 != 3) goto L12;
                r101.last_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r104 != 4) goto L14;
                r101.access_auth = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L14:
                if (r104 != 5) goto L15;
                r101.need_cold_hot_mode = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L15:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(MessageSelector r100) {
                Boolean r101 = r100.is_aggregated;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.last_create_time;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.last_id;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Boolean r110 = r100.access_auth;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                Boolean r113 = r100.need_cold_hot_mode;
                if (r113 == null) goto L22;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
            L22:
                return (r112 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ MessageSelector decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MessageSelector r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MessageSelector r101) throws IOException {
                Boolean r102 = r101.is_aggregated;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.last_create_time;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.last_id;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                Boolean r105 = r101.access_auth;
                if (r105 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
            L14:
                Boolean r106 = r101.need_cold_hot_mode;
                if (r106 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
            L17:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageSelector r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MessageSelector();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_IS_AGGREGATED = r100;
            DEFAULT_LAST_CREATE_TIME = 0L;
            DEFAULT_ACCESS_AUTH = r100;
            DEFAULT_NEED_COLD_HOT_MODE = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.is_aggregated = this.is_aggregated;
            r100.last_create_time = this.last_create_time;
            r100.last_id = this.last_id;
            r100.access_auth = this.access_auth;
            r100.need_cold_hot_mode = this.need_cold_hot_mode;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MessageSelector.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public MessageSelector(Boolean r100, Long r101, String r110, Boolean r111, Boolean r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public MessageSelector(Boolean r100, Long r101, String r102, Boolean r103, Boolean r104, ByteString r105) {
            super(ADAPTER, r105);
            this.is_aggregated = r100;
            this.last_create_time = r101;
            this.last_id = r102;
            this.access_auth = r103;
            this.need_cold_hot_mode = r104;
        }
    }

    public static final class ProtoAdapter_UniversalSelectors extends ProtoAdapter<UniversalSelectors> {
        public ProtoAdapter_UniversalSelectors() {
            super(FieldEncoding.LENGTH_DELIMITED, UniversalSelectors.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UniversalSelectors decode(ProtoReader r100) throws IOException {
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
        public int encodedSize2(UniversalSelectors r100) {
            return r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UniversalSelectors decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UniversalSelectors r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UniversalSelectors r101) throws IOException {
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UniversalSelectors r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class QaCardSelector extends Message<QaCardSelector, Builder> {
        public static final ProtoAdapter<QaCardSelector> ADAPTER = null;
        public static final RenderType DEFAULT_RENDER_TYPE = null;
        public static final String DEFAULT_TEMPLATE = "";
        private static final long serialVersionUID = 0;
        public final RenderType render_type;
        public final String template;

        public static final class Builder extends Message.Builder<QaCardSelector, Builder> {
            public RenderType render_type;
            public String template;

            @Override // com.squareup.wire.Message.Builder
            public QaCardSelector build() {
                return new QaCardSelector(this.template, this.render_type, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder render_type(RenderType r100) {
                this.render_type = r100;
                return this;
            }

            public Builder template(String r100) {
                this.template = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_QaCardSelector extends ProtoAdapter<QaCardSelector> {
            public ProtoAdapter_QaCardSelector() {
                super(FieldEncoding.LENGTH_DELIMITED, QaCardSelector.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public QaCardSelector decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.template = "";
                r101.render_type = RenderType.AS_CARD;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.template = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.render_type = RenderType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
            public int encodedSize2(QaCardSelector r100) {
                String r101 = r100.template;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                RenderType r104 = r100.render_type;
                if (r104 == null) goto L10;
                r102 = RenderType.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ QaCardSelector decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(QaCardSelector r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, QaCardSelector r101) throws IOException {
                String r102 = r101.template;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                RenderType r103 = r101.render_type;
                if (r103 == null) goto L8;
                RenderType.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, QaCardSelector r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_QaCardSelector();
            DEFAULT_RENDER_TYPE = RenderType.AS_CARD;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.template = this.template;
            r100.render_type = this.render_type;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return QaCardSelector.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public QaCardSelector(String r100, RenderType r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public QaCardSelector(String r100, RenderType r101, ByteString r102) {
            super(ADAPTER, r102);
            this.template = r100;
            this.render_type = r101;
        }
    }

    public static final class RecommendFilterSelector extends Message<RecommendFilterSelector, Builder> {
        public static final ProtoAdapter<RecommendFilterSelector> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<FilterInTab> filter_in_tabs;
        public final List<FilterInfos> recommend_filter_infos;

        public static final class Builder extends Message.Builder<RecommendFilterSelector, Builder> {
            public List<FilterInTab> filter_in_tabs;
            public List<FilterInfos> recommend_filter_infos;

            @Override // com.squareup.wire.Message.Builder
            public RecommendFilterSelector build() {
                return new RecommendFilterSelector(this.filter_in_tabs, this.recommend_filter_infos, super.buildUnknownFields());
            }

            public Builder() {
                this.filter_in_tabs = Internal.newMutableList();
                this.recommend_filter_infos = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder filter_in_tabs(List<FilterInTab> r100) {
                Internal.checkElementsNotNull(r100);
                this.filter_in_tabs = r100;
                return this;
            }

            public Builder recommend_filter_infos(List<FilterInfos> r100) {
                Internal.checkElementsNotNull(r100);
                this.recommend_filter_infos = r100;
                return this;
            }
        }

        public static final class FilterInfos extends Message<FilterInfos, Builder> {
            public static final ProtoAdapter<FilterInfos> ADAPTER = null;
            public static final FilterInTab DEFAULT_FILTER_IN_TAB = null;
            public static final RecommendFilterStrategy DEFAULT_RECOMMEND_FILTER_STRATEGY = null;
            private static final long serialVersionUID = 0;
            public final FilterInTab filter_in_tab;
            public final RecommendFilterStrategy recommend_filter_strategy;

            public static final class Builder extends Message.Builder<FilterInfos, Builder> {
                public FilterInTab filter_in_tab;
                public RecommendFilterStrategy recommend_filter_strategy;

                @Override // com.squareup.wire.Message.Builder
                public FilterInfos build() {
                    return new FilterInfos(this.filter_in_tab, this.recommend_filter_strategy, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder filter_in_tab(FilterInTab r100) {
                    this.filter_in_tab = r100;
                    return this;
                }

                public Builder recommend_filter_strategy(RecommendFilterStrategy r100) {
                    this.recommend_filter_strategy = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_FilterInfos extends ProtoAdapter<FilterInfos> {
                public ProtoAdapter_FilterInfos() {
                    super(FieldEncoding.LENGTH_DELIMITED, FilterInfos.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public FilterInfos decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.filter_in_tab = FilterInTab.SMART_USER;
                    r101.recommend_filter_strategy = RecommendFilterStrategy.UnknownStrategy;
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L18;
                    if (r103 != 1) goto L8;
                    r101.filter_in_tab = FilterInTab.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
                L16:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L8:
                    if (r103 != 2) goto L9;
                    r101.recommend_filter_strategy = RecommendFilterStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
                L12:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L9:
                    FieldEncoding r104 = r100.peekFieldEncoding();
                    r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                    goto L3
                L18:
                    r100.endMessage(r102);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(FilterInfos r100) {
                    FilterInTab r101 = r100.filter_in_tab;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = FilterInTab.ADAPTER.encodedSizeWithTag(1, r101);
                L6:
                    RecommendFilterStrategy r104 = r100.recommend_filter_strategy;
                    if (r104 == null) goto L10;
                    r102 = RecommendFilterStrategy.ADAPTER.encodedSizeWithTag(2, r104);
                L10:
                    return (r103 + r102) + r100.unknownFields().size();
                L5:
                    r103 = 0;
                    goto L6
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ FilterInfos decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(FilterInfos r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, FilterInfos r101) throws IOException {
                    FilterInTab r102 = r101.filter_in_tab;
                    if (r102 == null) goto L5;
                    FilterInTab.ADAPTER.encodeWithTag(r100, 1, r102);
                L5:
                    RecommendFilterStrategy r103 = r101.recommend_filter_strategy;
                    if (r103 == null) goto L8;
                    RecommendFilterStrategy.ADAPTER.encodeWithTag(r100, 2, r103);
                L8:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FilterInfos r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_FilterInfos();
                DEFAULT_FILTER_IN_TAB = FilterInTab.SMART_USER;
                DEFAULT_RECOMMEND_FILTER_STRATEGY = RecommendFilterStrategy.UnknownStrategy;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.filter_in_tab = this.filter_in_tab;
                r100.recommend_filter_strategy = this.recommend_filter_strategy;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return FilterInfos.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public FilterInfos(FilterInTab r100, RecommendFilterStrategy r101) {
                this(r100, r101, ByteString.EMPTY);
            }

            public FilterInfos(FilterInTab r100, RecommendFilterStrategy r101, ByteString r102) {
                super(ADAPTER, r102);
                this.filter_in_tab = r100;
                this.recommend_filter_strategy = r101;
            }
        }

        public static final class ProtoAdapter_RecommendFilterSelector extends ProtoAdapter<RecommendFilterSelector> {
            public ProtoAdapter_RecommendFilterSelector() {
                super(FieldEncoding.LENGTH_DELIMITED, RecommendFilterSelector.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public RecommendFilterSelector decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.filter_in_tabs.add(FilterInTab.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.recommend_filter_infos.add(FilterInfos.ADAPTER.decode(r100));
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
            public int encodedSize2(RecommendFilterSelector r100) {
                return (FilterInTab.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.filter_in_tabs) + FilterInfos.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.recommend_filter_infos)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ RecommendFilterSelector decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(RecommendFilterSelector r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, RecommendFilterSelector r101) throws IOException {
                FilterInTab.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.filter_in_tabs);
                FilterInfos.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.recommend_filter_infos);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RecommendFilterSelector r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_RecommendFilterSelector();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.filter_in_tabs = Internal.copyOf("filter_in_tabs", this.filter_in_tabs);
            r100.recommend_filter_infos = Internal.copyOf("recommend_filter_infos", this.recommend_filter_infos);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return RecommendFilterSelector.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public RecommendFilterSelector(List<FilterInTab> r100, List<FilterInfos> r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public RecommendFilterSelector(List<FilterInTab> r100, List<FilterInfos> r101, ByteString r102) {
            super(ADAPTER, r102);
            this.filter_in_tabs = Internal.immutableCopyOf("filter_in_tabs", r100);
            this.recommend_filter_infos = Internal.immutableCopyOf("recommend_filter_infos", r101);
        }
    }

    public static final enum RenderType extends Enum<RenderType> implements WireEnum {
        private static final /* synthetic */ RenderType[] $VALUES = null;
        public static final ProtoAdapter<RenderType> ADAPTER = null;
        public static final RenderType AS_CARD = null;
        public static final RenderType BLOCK = null;
        public static final RenderType JSON_RAW = null;
        private final int value;

        static {
            RenderType r100 = new RenderType("AS_CARD", 0, 1);
            AS_CARD = r100;
            RenderType r101 = new RenderType("BLOCK", 1, 2);
            BLOCK = r101;
            RenderType r102 = new RenderType("JSON_RAW", 2, 3);
            JSON_RAW = r102;
            $VALUES = new RenderType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(RenderType.class);
        }

        public static RenderType[] values() {
            return (RenderType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static RenderType fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return JSON_RAW;
        L13:
            return BLOCK;
        L15:
            return AS_CARD;
        }

        public static RenderType valueOf(String r100) {
            return (RenderType) a.a(RenderType.class, r100);
        }

        private RenderType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ServiceCardSelector extends Message<ServiceCardSelector, Builder> {
        public static final ProtoAdapter<ServiceCardSelector> ADAPTER = null;
        public static final RenderType DEFAULT_RENDER_TYPE = null;
        public static final String DEFAULT_TEMPLATE = "";
        private static final long serialVersionUID = 0;
        public final RenderType render_type;
        public final String template;

        public static final class Builder extends Message.Builder<ServiceCardSelector, Builder> {
            public RenderType render_type;
            public String template;

            @Override // com.squareup.wire.Message.Builder
            public ServiceCardSelector build() {
                return new ServiceCardSelector(this.template, this.render_type, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder render_type(RenderType r100) {
                this.render_type = r100;
                return this;
            }

            public Builder template(String r100) {
                this.template = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ServiceCardSelector extends ProtoAdapter<ServiceCardSelector> {
            public ProtoAdapter_ServiceCardSelector() {
                super(FieldEncoding.LENGTH_DELIMITED, ServiceCardSelector.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ServiceCardSelector decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.template = "";
                r101.render_type = RenderType.AS_CARD;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.template = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.render_type = RenderType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
            public int encodedSize2(ServiceCardSelector r100) {
                String r101 = r100.template;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                RenderType r104 = r100.render_type;
                if (r104 == null) goto L10;
                r102 = RenderType.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ServiceCardSelector decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ServiceCardSelector r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ServiceCardSelector r101) throws IOException {
                String r102 = r101.template;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                RenderType r103 = r101.render_type;
                if (r103 == null) goto L8;
                RenderType.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ServiceCardSelector r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ServiceCardSelector();
            DEFAULT_RENDER_TYPE = RenderType.AS_CARD;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.template = this.template;
            r100.render_type = this.render_type;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ServiceCardSelector.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ServiceCardSelector(String r100, RenderType r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public ServiceCardSelector(String r100, RenderType r101, ByteString r102) {
            super(ADAPTER, r102);
            this.template = r100;
            this.render_type = r101;
        }
    }

    public static final class ShieldP2PChatSelector extends Message<ShieldP2PChatSelector, Builder> {
        public static final ProtoAdapter<ShieldP2PChatSelector> ADAPTER = null;
        public static final Boolean DEFAULT_RELATION_TAG = null;
        private static final long serialVersionUID = 0;
        public final Boolean relation_tag;

        public static final class Builder extends Message.Builder<ShieldP2PChatSelector, Builder> {
            public Boolean relation_tag;

            @Override // com.squareup.wire.Message.Builder
            public ShieldP2PChatSelector build() {
                return new ShieldP2PChatSelector(this.relation_tag, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder relation_tag(Boolean r100) {
                this.relation_tag = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ShieldP2PChatSelector extends ProtoAdapter<ShieldP2PChatSelector> {
            public ProtoAdapter_ShieldP2PChatSelector() {
                super(FieldEncoding.LENGTH_DELIMITED, ShieldP2PChatSelector.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ShieldP2PChatSelector decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.relation_tag = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.relation_tag = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(ShieldP2PChatSelector r100) {
                Boolean r101 = r100.relation_tag;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ShieldP2PChatSelector decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ShieldP2PChatSelector r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ShieldP2PChatSelector r101) throws IOException {
                Boolean r102 = r101.relation_tag;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ShieldP2PChatSelector r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ShieldP2PChatSelector();
            DEFAULT_RELATION_TAG = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.relation_tag = this.relation_tag;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ShieldP2PChatSelector.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ShieldP2PChatSelector(Boolean r100) {
            this(r100, ByteString.EMPTY);
        }

        public ShieldP2PChatSelector(Boolean r100, ByteString r101) {
            super(ADAPTER, r101);
            this.relation_tag = r100;
        }
    }

    public static final class URLSelector extends Message<URLSelector, Builder> {
        public static final ProtoAdapter<URLSelector> ADAPTER = null;
        public static final Boolean DEFAULT_NEED_COLD_HOT_MODE = null;
        private static final long serialVersionUID = 0;
        public final Boolean need_cold_hot_mode;

        public static final class Builder extends Message.Builder<URLSelector, Builder> {
            public Boolean need_cold_hot_mode;

            @Override // com.squareup.wire.Message.Builder
            public URLSelector build() {
                return new URLSelector(this.need_cold_hot_mode, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder need_cold_hot_mode(Boolean r100) {
                this.need_cold_hot_mode = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_URLSelector extends ProtoAdapter<URLSelector> {
            public ProtoAdapter_URLSelector() {
                super(FieldEncoding.LENGTH_DELIMITED, URLSelector.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public URLSelector decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.need_cold_hot_mode = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.need_cold_hot_mode = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(URLSelector r100) {
                Boolean r101 = r100.need_cold_hot_mode;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ URLSelector decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(URLSelector r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, URLSelector r101) throws IOException {
                Boolean r102 = r101.need_cold_hot_mode;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, URLSelector r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_URLSelector();
            DEFAULT_NEED_COLD_HOT_MODE = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.need_cold_hot_mode = this.need_cold_hot_mode;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return URLSelector.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public URLSelector(Boolean r100) {
            this(r100, ByteString.EMPTY);
        }

        public URLSelector(Boolean r100, ByteString r101) {
            super(ADAPTER, r101);
            this.need_cold_hot_mode = r100;
        }
    }

    public static final class UserSelector extends Message<UserSelector, Builder> {
        public static final ProtoAdapter<UserSelector> ADAPTER = null;
        public static final String DEFAULT_IS_DIRECTLY_IN_TEAM_ID = "";
        public static final Boolean DEFAULT_IS_FUZZY_USER = null;
        public static final String DEFAULT_IS_IN_CHAT_ID = "";
        public static final Boolean DEFAULT_RELATION_TAG = null;
        private static final long serialVersionUID = 0;
        public final String is_directly_in_team_id;
        public final Boolean is_fuzzy_user;
        public final String is_in_chat_id;
        public final Boolean relation_tag;

        public static final class Builder extends Message.Builder<UserSelector, Builder> {
            public String is_directly_in_team_id;
            public Boolean is_fuzzy_user;
            public String is_in_chat_id;
            public Boolean relation_tag;

            @Override // com.squareup.wire.Message.Builder
            public UserSelector build() {
                return new UserSelector(this.is_in_chat_id, this.is_fuzzy_user, this.is_directly_in_team_id, this.relation_tag, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder is_directly_in_team_id(String r100) {
                this.is_directly_in_team_id = r100;
                return this;
            }

            public Builder is_fuzzy_user(Boolean r100) {
                this.is_fuzzy_user = r100;
                return this;
            }

            public Builder is_in_chat_id(String r100) {
                this.is_in_chat_id = r100;
                return this;
            }

            public Builder relation_tag(Boolean r100) {
                this.relation_tag = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_UserSelector extends ProtoAdapter<UserSelector> {
            public ProtoAdapter_UserSelector() {
                super(FieldEncoding.LENGTH_DELIMITED, UserSelector.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UserSelector decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.is_in_chat_id = "";
                Boolean r102 = Boolean.FALSE;
                r101.is_fuzzy_user = r102;
                r101.is_directly_in_team_id = "";
                r101.relation_tag = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L18;
                if (r104 != 2) goto L8;
                r101.is_in_chat_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r104 != 3) goto L10;
                r101.is_fuzzy_user = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                if (r104 != 4) goto L12;
                r101.is_directly_in_team_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r104 != 5) goto L13;
                r101.relation_tag = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L13:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(UserSelector r100) {
                String r101 = r100.is_in_chat_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(2, r101);
            L6:
                Boolean r104 = r100.is_fuzzy_user;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.is_directly_in_team_id;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(4, r107);
            L14:
                int r109 = r106 + r108;
                Boolean r110 = r100.relation_tag;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r110);
            L18:
                return (r109 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ UserSelector decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(UserSelector r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, UserSelector r101) throws IOException {
                String r102 = r101.is_in_chat_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
            L5:
                Boolean r103 = r101.is_fuzzy_user;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
            L8:
                String r104 = r101.is_directly_in_team_id;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
            L11:
                Boolean r105 = r101.relation_tag;
                if (r105 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r100, 5, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserSelector r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UserSelector();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_IS_FUZZY_USER = r100;
            DEFAULT_RELATION_TAG = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.is_in_chat_id = this.is_in_chat_id;
            r100.is_fuzzy_user = this.is_fuzzy_user;
            r100.is_directly_in_team_id = this.is_directly_in_team_id;
            r100.relation_tag = this.relation_tag;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return UserSelector.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public UserSelector(String r100, Boolean r101, String r102, Boolean r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public UserSelector(String r100, Boolean r101, String r102, Boolean r103, ByteString r104) {
            super(ADAPTER, r104);
            this.is_in_chat_id = r100;
            this.is_fuzzy_user = r101;
            this.is_directly_in_team_id = r102;
            this.relation_tag = r103;
        }
    }

    public static final class WikiSelector extends Message<WikiSelector, Builder> {
        public static final ProtoAdapter<WikiSelector> ADAPTER = null;
        public static final Boolean DEFAULT_NEED_COLD_HOT_MODE = null;
        public static final Boolean DEFAULT_NEED_OWNER = null;
        public static final Boolean DEFAULT_RELATION_TAG = null;
        private static final long serialVersionUID = 0;
        public final Boolean need_cold_hot_mode;
        public final Boolean need_owner;
        public final Boolean relation_tag;

        public static final class Builder extends Message.Builder<WikiSelector, Builder> {
            public Boolean need_cold_hot_mode;
            public Boolean need_owner;
            public Boolean relation_tag;

            @Override // com.squareup.wire.Message.Builder
            public WikiSelector build() {
                return new WikiSelector(this.need_owner, this.relation_tag, this.need_cold_hot_mode, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder need_cold_hot_mode(Boolean r100) {
                this.need_cold_hot_mode = r100;
                return this;
            }

            public Builder need_owner(Boolean r100) {
                this.need_owner = r100;
                return this;
            }

            public Builder relation_tag(Boolean r100) {
                this.relation_tag = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_WikiSelector extends ProtoAdapter<WikiSelector> {
            public ProtoAdapter_WikiSelector() {
                super(FieldEncoding.LENGTH_DELIMITED, WikiSelector.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public WikiSelector decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.FALSE;
                r101.need_owner = r102;
                r101.relation_tag = r102;
                r101.need_cold_hot_mode = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L15;
                if (r104 != 1) goto L8;
                r101.need_owner = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L10;
                r101.relation_tag = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                if (r104 != 3) goto L11;
                r101.need_cold_hot_mode = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L11:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(WikiSelector r100) {
                Boolean r101 = r100.need_owner;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.relation_tag;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.need_cold_hot_mode;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ WikiSelector decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(WikiSelector r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, WikiSelector r101) throws IOException {
                Boolean r102 = r101.need_owner;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.relation_tag;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.need_cold_hot_mode;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WikiSelector r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_WikiSelector();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_NEED_OWNER = r100;
            DEFAULT_RELATION_TAG = r100;
            DEFAULT_NEED_COLD_HOT_MODE = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.need_owner = this.need_owner;
            r100.relation_tag = this.relation_tag;
            r100.need_cold_hot_mode = this.need_cold_hot_mode;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return WikiSelector.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public WikiSelector(Boolean r100, Boolean r101, Boolean r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public WikiSelector(Boolean r100, Boolean r101, Boolean r102, ByteString r103) {
            super(ADAPTER, r103);
            this.need_owner = r100;
            this.relation_tag = r101;
            this.need_cold_hot_mode = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UniversalSelectors();
    }

    public UniversalSelectors() {
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
        return UniversalSelectors.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UniversalSelectors(ByteString r100) {
        super(ADAPTER, r100);
    }
}
