package com.bytedance.lark.pb.basic.v1;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class UniversalCardEntity extends com.squareup.wire.Message<UniversalCardEntity, Builder> {
    public static final ProtoAdapter<UniversalCardEntity> ADAPTER = null;
    public static final ActionDataSource DEFAULT_ACTION_DATA_SOURCE = null;
    public static final String DEFAULT_ACTION_URL = "";
    public static final Long DEFAULT_APP_ID = null;
    public static final Long DEFAULT_BOT_ID = null;
    public static final String DEFAULT_CARD_ID = "";
    public static final DataSource DEFAULT_DATA_SOURCE = null;
    public static final DataType DEFAULT_DATA_TYPE = null;
    public static final String DEFAULT_SOURCE_ID = "";
    public static final Integer DEFAULT_SOURCE_TYPE = null;
    public static final Boolean DEFAULT_STREAMING_MODE = null;
    public static final String DEFAULT_VERSION = "";
    private static final long serialVersionUID = 0;
    public final ActionDataSource action_data_source;
    public final ActionStatus action_status;
    public final String action_url;
    public final Long app_id;
    public final CardAppInfo app_info;
    public final Long bot_id;
    public final CardHeader card_header;
    public final String card_id;
    public final Map<String, ResourceCleanScene> clean_resource_key_scene;
    public final Content content;
    public final DataSource data_source;
    public final DataType data_type;
    public final List<Url> json_card_urls;
    public final Map<Integer, String> local_extra;
    public final PatchInfo patch_info;
    public final String source_id;
    public final Integer source_type;
    public final StreamingConfig streaming_config;
    public final Boolean streaming_mode;
    public final String version;

    public static final class Action extends com.squareup.wire.Message<Action, Builder> {
        public static final ProtoAdapter<Action> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Map<String, String> extra;
        public final MessageExtra message_extra;

        public static final class Builder extends com.squareup.wire.Message.Builder<Action, Builder> {
            public Map<String, String> extra;
            public MessageExtra message_extra;

            @Override // com.squareup.wire.Message.Builder
            public Action build() {
                return new Action(this.extra, this.message_extra, super.buildUnknownFields());
            }

            public Builder() {
                this.extra = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder extra(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.extra = r100;
                return this;
            }

            public Builder message_extra(MessageExtra r100) {
                this.message_extra = r100;
                return this;
            }
        }

        public static final class MessageExtra extends com.squareup.wire.Message<MessageExtra, Builder> {
            public static final ProtoAdapter<MessageExtra> ADAPTER = null;
            public static final String DEFAULT_URL = "";
            private static final long serialVersionUID = 0;
            public final Map<String, String> params;
            public final String url;

            public static final class Builder extends com.squareup.wire.Message.Builder<MessageExtra, Builder> {
                public Map<String, String> params;
                public String url;

                @Override // com.squareup.wire.Message.Builder
                public MessageExtra build() {
                    return new MessageExtra(this.url, this.params, super.buildUnknownFields());
                }

                public Builder() {
                    this.params = Internal.newMutableMap();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder params(Map<String, String> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.params = r100;
                    return this;
                }

                public Builder url(String r100) {
                    this.url = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_MessageExtra extends ProtoAdapter<MessageExtra> {
                private final ProtoAdapter<Map<String, String>> params;

                public ProtoAdapter_MessageExtra() {
                    super(FieldEncoding.LENGTH_DELIMITED, MessageExtra.class);
                    ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                    this.params = ProtoAdapter.newMapAdapter(r100, r100);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public MessageExtra decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.url = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L12;
                    if (r103 != 1) goto L8;
                    r101.url = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L9;
                    r101.params.putAll(this.params.decode(r100));
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
                public int encodedSize2(MessageExtra r100) {
                    String r101 = r100.url;
                    if (r101 == null) goto L5;
                    int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
                L7:
                    return (r102 + this.params.encodedSizeWithTag(2, r100.params)) + r100.unknownFields().size();
                L5:
                    r102 = 0;
                    goto L7
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ MessageExtra decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(MessageExtra r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, MessageExtra r101) throws IOException {
                    String r102 = r101.url;
                    if (r102 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
                L5:
                    this.params.encodeWithTag(r100, 2, r101.params);
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageExtra r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_MessageExtra();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.url = this.url;
                r100.params = Internal.copyOf("params", this.params);
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return MessageExtra.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public MessageExtra(String r100, Map<String, String> r101) {
                this(r100, r101, ByteString.EMPTY);
            }

            public MessageExtra(String r100, Map<String, String> r101, ByteString r102) {
                super(ADAPTER, r102);
                this.url = r100;
                this.params = Internal.immutableCopyOf("params", r101);
            }
        }

        public static final class ProtoAdapter_Action extends ProtoAdapter<Action> {
            private final ProtoAdapter<Map<String, String>> extra;

            public ProtoAdapter_Action() {
                super(FieldEncoding.LENGTH_DELIMITED, Action.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.extra = ProtoAdapter.newMapAdapter(r100, r100);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Action decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 250) goto L8;
                r101.extra.putAll(this.extra.decode(r100));
                goto L3
            L8:
                if (r103 != 251) goto L9;
                r101.message_extra = MessageExtra.ADAPTER.decode(r100);
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
            public int encodedSize2(Action r100) {
                int r101 = this.extra.encodedSizeWithTag(250, r100.extra);
                MessageExtra r102 = r100.message_extra;
                if (r102 == null) goto L5;
                int r103 = MessageExtra.ADAPTER.encodedSizeWithTag(251, r102);
            L7:
                return (r101 + r103) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Action decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Action r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Action r101) throws IOException {
                this.extra.encodeWithTag(r100, 250, r101.extra);
                MessageExtra r102 = r101.message_extra;
                if (r102 == null) goto L5;
                MessageExtra.ADAPTER.encodeWithTag(r100, 251, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Action r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Action();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.extra = Internal.copyOf("extra", this.extra);
            r100.message_extra = this.message_extra;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Action.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Action(Map<String, String> r100, MessageExtra r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public Action(Map<String, String> r100, MessageExtra r101, ByteString r102) {
            super(ADAPTER, r102);
            this.extra = Internal.immutableCopyOf("extra", r100);
            this.message_extra = r101;
        }
    }

    public static final enum ActionDataSource extends Enum<ActionDataSource> implements WireEnum {
        private static final /* synthetic */ ActionDataSource[] $VALUES = null;
        public static final ProtoAdapter<ActionDataSource> ADAPTER = null;
        public static final ActionDataSource ENTITY_CARD = null;
        public static final ActionDataSource IM_CONTENT = null;
        public static final ActionDataSource STREAMING_CARD = null;
        private final int value;

        static {
            ActionDataSource r100 = new ActionDataSource("IM_CONTENT", 0, 1);
            IM_CONTENT = r100;
            ActionDataSource r101 = new ActionDataSource("STREAMING_CARD", 1, 2);
            STREAMING_CARD = r101;
            ActionDataSource r102 = new ActionDataSource("ENTITY_CARD", 2, 3);
            ENTITY_CARD = r102;
            $VALUES = new ActionDataSource[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(ActionDataSource.class);
        }

        public static ActionDataSource[] values() {
            return (ActionDataSource[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ActionDataSource fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return ENTITY_CARD;
        L13:
            return STREAMING_CARD;
        L15:
            return IM_CONTENT;
        }

        public static ActionDataSource valueOf(String r100) {
            return (ActionDataSource) a.a(ActionDataSource.class, r100);
        }

        private ActionDataSource(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ActionStatus extends com.squareup.wire.Message<ActionStatus, Builder> {
        public static final ProtoAdapter<ActionStatus> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Map<String, String> component_status_by_action_id;
        public final Map<String, String> component_status_by_name;

        public static final class Builder extends com.squareup.wire.Message.Builder<ActionStatus, Builder> {
            public Map<String, String> component_status_by_action_id;
            public Map<String, String> component_status_by_name;

            @Override // com.squareup.wire.Message.Builder
            public ActionStatus build() {
                return new ActionStatus(this.component_status_by_name, this.component_status_by_action_id, super.buildUnknownFields());
            }

            public Builder() {
                this.component_status_by_name = Internal.newMutableMap();
                this.component_status_by_action_id = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder component_status_by_action_id(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.component_status_by_action_id = r100;
                return this;
            }

            public Builder component_status_by_name(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.component_status_by_name = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ActionStatus extends ProtoAdapter<ActionStatus> {
            private final ProtoAdapter<Map<String, String>> component_status_by_action_id;
            private final ProtoAdapter<Map<String, String>> component_status_by_name;

            public ProtoAdapter_ActionStatus() {
                super(FieldEncoding.LENGTH_DELIMITED, ActionStatus.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.component_status_by_name = ProtoAdapter.newMapAdapter(r100, r100);
                this.component_status_by_action_id = ProtoAdapter.newMapAdapter(r100, r100);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ActionStatus decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.component_status_by_name.putAll(this.component_status_by_name.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.component_status_by_action_id.putAll(this.component_status_by_action_id.decode(r100));
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
            public int encodedSize2(ActionStatus r100) {
                return (this.component_status_by_name.encodedSizeWithTag(1, r100.component_status_by_name) + this.component_status_by_action_id.encodedSizeWithTag(2, r100.component_status_by_action_id)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ActionStatus decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ActionStatus r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ActionStatus r101) throws IOException {
                this.component_status_by_name.encodeWithTag(r100, 1, r101.component_status_by_name);
                this.component_status_by_action_id.encodeWithTag(r100, 2, r101.component_status_by_action_id);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ActionStatus r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ActionStatus();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.component_status_by_name = Internal.copyOf("component_status_by_name", this.component_status_by_name);
            r100.component_status_by_action_id = Internal.copyOf("component_status_by_action_id", this.component_status_by_action_id);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ActionStatus.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ActionStatus(Map<String, String> r100, Map<String, String> r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public ActionStatus(Map<String, String> r100, Map<String, String> r101, ByteString r102) {
            super(ADAPTER, r102);
            this.component_status_by_name = Internal.immutableCopyOf("component_status_by_name", r100);
            this.component_status_by_action_id = Internal.immutableCopyOf("component_status_by_action_id", r101);
        }
    }

    public static final class Attachment extends com.squareup.wire.Message<Attachment, Builder> {
        public static final ProtoAdapter<Attachment> ADAPTER = null;
        public static final String DEFAULT_CARD_SIMPLE_SUMMARY = "";
        public static final Boolean DEFAULT_IGNORE_AT_REMIND = null;
        private static final long serialVersionUID = 0;
        public final Map<String, RichTextElement.AtProperty> at_users;
        public final Map<String, AudioInfo> audios;
        public final String card_simple_summary;
        public final Map<String, Character> characters;
        public final Boolean ignore_at_remind;
        public final Map<String, RichTextElement.ImageProperty> images;
        public final List<String> preview_image_key_list;
        public final SummaryContent summary;
        public final Map<String, VideoInfo> videos;

        public static final class Builder extends com.squareup.wire.Message.Builder<Attachment, Builder> {
            public Map<String, RichTextElement.AtProperty> at_users;
            public Map<String, AudioInfo> audios;
            public String card_simple_summary;
            public Map<String, Character> characters;
            public Boolean ignore_at_remind;
            public Map<String, RichTextElement.ImageProperty> images;
            public List<String> preview_image_key_list;
            public SummaryContent summary;
            public Map<String, VideoInfo> videos;

            @Override // com.squareup.wire.Message.Builder
            public Attachment build() {
                return new Attachment(this.summary, this.images, this.at_users, this.characters, this.ignore_at_remind, this.preview_image_key_list, this.audios, this.card_simple_summary, this.videos, super.buildUnknownFields());
            }

            public Builder() {
                this.images = Internal.newMutableMap();
                this.at_users = Internal.newMutableMap();
                this.characters = Internal.newMutableMap();
                this.preview_image_key_list = Internal.newMutableList();
                this.audios = Internal.newMutableMap();
                this.videos = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder at_users(Map<String, RichTextElement.AtProperty> r100) {
                Internal.checkElementsNotNull(r100);
                this.at_users = r100;
                return this;
            }

            public Builder audios(Map<String, AudioInfo> r100) {
                Internal.checkElementsNotNull(r100);
                this.audios = r100;
                return this;
            }

            public Builder card_simple_summary(String r100) {
                this.card_simple_summary = r100;
                return this;
            }

            public Builder characters(Map<String, Character> r100) {
                Internal.checkElementsNotNull(r100);
                this.characters = r100;
                return this;
            }

            public Builder ignore_at_remind(Boolean r100) {
                this.ignore_at_remind = r100;
                return this;
            }

            public Builder images(Map<String, RichTextElement.ImageProperty> r100) {
                Internal.checkElementsNotNull(r100);
                this.images = r100;
                return this;
            }

            public Builder preview_image_key_list(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.preview_image_key_list = r100;
                return this;
            }

            public Builder summary(SummaryContent r100) {
                this.summary = r100;
                return this;
            }

            public Builder videos(Map<String, VideoInfo> r100) {
                Internal.checkElementsNotNull(r100);
                this.videos = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Attachment extends ProtoAdapter<Attachment> {
            private final ProtoAdapter<Map<String, RichTextElement.AtProperty>> at_users;
            private final ProtoAdapter<Map<String, AudioInfo>> audios;
            private final ProtoAdapter<Map<String, Character>> characters;
            private final ProtoAdapter<Map<String, RichTextElement.ImageProperty>> images;
            private final ProtoAdapter<Map<String, VideoInfo>> videos;

            public ProtoAdapter_Attachment() {
                super(FieldEncoding.LENGTH_DELIMITED, Attachment.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.images = ProtoAdapter.newMapAdapter(r100, RichTextElement.ImageProperty.ADAPTER);
                this.at_users = ProtoAdapter.newMapAdapter(r100, RichTextElement.AtProperty.ADAPTER);
                this.characters = ProtoAdapter.newMapAdapter(r100, Character.ADAPTER);
                this.audios = ProtoAdapter.newMapAdapter(r100, AudioInfo.ADAPTER);
                this.videos = ProtoAdapter.newMapAdapter(r100, VideoInfo.ADAPTER);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Attachment decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.ignore_at_remind = Boolean.FALSE;
                r101.card_simple_summary = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L16;
                switch(r103) {
                    case 1: goto L15;
                    case 2: goto L14;
                    case 3: goto L13;
                    case 4: goto L12;
                    case 5: goto L11;
                    case 6: goto L10;
                    case 7: goto L9;
                    case 8: goto L8;
                    case 9: goto L7;
                    default: goto L6;
                };
            L7:
                r101.videos.putAll(this.videos.decode(r100));
                goto L3
            L8:
                r101.card_simple_summary = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                r101.audios.putAll(this.audios.decode(r100));
                goto L3
            L10:
                r101.preview_image_key_list.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L11:
                r101.ignore_at_remind = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                r101.characters.putAll(this.characters.decode(r100));
                goto L3
            L13:
                r101.at_users.putAll(this.at_users.decode(r100));
                goto L3
            L14:
                r101.images.putAll(this.images.decode(r100));
                goto L3
            L15:
                r101.summary = SummaryContent.ADAPTER.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L16:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Attachment r100) {
                SummaryContent r101 = r100.summary;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = SummaryContent.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                int r104 = ((r103 + this.images.encodedSizeWithTag(2, r100.images)) + this.at_users.encodedSizeWithTag(3, r100.at_users)) + this.characters.encodedSizeWithTag(4, r100.characters);
                Boolean r105 = r100.ignore_at_remind;
                if (r105 == null) goto L9;
                int r106 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r105);
            L10:
                int r107 = r104 + r106;
                ProtoAdapter<String> r108 = ProtoAdapter.STRING;
                int r109 = (r107 + r108.asRepeated().encodedSizeWithTag(6, r100.preview_image_key_list)) + this.audios.encodedSizeWithTag(7, r100.audios);
                String r110 = r100.card_simple_summary;
                if (r110 == null) goto L14;
                r102 = r108.encodedSizeWithTag(8, r110);
            L14:
                return ((r109 + r102) + this.videos.encodedSizeWithTag(9, r100.videos)) + r100.unknownFields().size();
            L9:
                r106 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Attachment decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Attachment r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Attachment r101) throws IOException {
                SummaryContent r102 = r101.summary;
                if (r102 == null) goto L5;
                SummaryContent.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                this.images.encodeWithTag(r100, 2, r101.images);
                this.at_users.encodeWithTag(r100, 3, r101.at_users);
                this.characters.encodeWithTag(r100, 4, r101.characters);
                Boolean r103 = r101.ignore_at_remind;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 5, r103);
            L8:
                ProtoAdapter<String> r104 = ProtoAdapter.STRING;
                r104.asRepeated().encodeWithTag(r100, 6, r101.preview_image_key_list);
                this.audios.encodeWithTag(r100, 7, r101.audios);
                String r105 = r101.card_simple_summary;
                if (r105 == null) goto L11;
                r104.encodeWithTag(r100, 8, r105);
            L11:
                this.videos.encodeWithTag(r100, 9, r101.videos);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Attachment r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Attachment();
            DEFAULT_IGNORE_AT_REMIND = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.summary = this.summary;
            r100.images = Internal.copyOf("images", this.images);
            r100.at_users = Internal.copyOf("at_users", this.at_users);
            r100.characters = Internal.copyOf("characters", this.characters);
            r100.ignore_at_remind = this.ignore_at_remind;
            r100.preview_image_key_list = Internal.copyOf("preview_image_key_list", this.preview_image_key_list);
            r100.audios = Internal.copyOf("audios", this.audios);
            r100.card_simple_summary = this.card_simple_summary;
            r100.videos = Internal.copyOf("videos", this.videos);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Attachment.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Attachment(SummaryContent r110, Map<String, RichTextElement.ImageProperty> r111, Map<String, RichTextElement.AtProperty> r112, Map<String, Character> r113, Boolean r114, List<String> r115, Map<String, AudioInfo> r116, String r117, Map<String, VideoInfo> r210) {
            this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
        }

        public Attachment(SummaryContent r100, Map<String, RichTextElement.ImageProperty> r101, Map<String, RichTextElement.AtProperty> r102, Map<String, Character> r103, Boolean r104, List<String> r105, Map<String, AudioInfo> r106, String r107, Map<String, VideoInfo> r110, ByteString r111) {
            super(ADAPTER, r111);
            this.summary = r100;
            this.images = Internal.immutableCopyOf("images", r101);
            this.at_users = Internal.immutableCopyOf("at_users", r102);
            this.characters = Internal.immutableCopyOf("characters", r103);
            this.ignore_at_remind = r104;
            this.preview_image_key_list = Internal.immutableCopyOf("preview_image_key_list", r105);
            this.audios = Internal.immutableCopyOf("audios", r106);
            this.card_simple_summary = r107;
            this.videos = Internal.immutableCopyOf("videos", r110);
        }
    }

    public static final class AudioInfo extends com.squareup.wire.Message<AudioInfo, Builder> {
        public static final ProtoAdapter<AudioInfo> ADAPTER = null;
        public static final Integer DEFAULT_DURATION = null;
        public static final String DEFAULT_KEY = "";
        public static final Long DEFAULT_SIZE = null;
        private static final long serialVersionUID = 0;
        public final Integer duration;
        public final String key;
        public final Long size;
        public final CardVisitInfo visit_info;

        public static final class Builder extends com.squareup.wire.Message.Builder<AudioInfo, Builder> {
            public Integer duration;
            public String key;
            public Long size;
            public CardVisitInfo visit_info;

            @Override // com.squareup.wire.Message.Builder
            public AudioInfo build() {
                return new AudioInfo(this.key, this.duration, this.size, this.visit_info, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder duration(Integer r100) {
                this.duration = r100;
                return this;
            }

            public Builder key(String r100) {
                this.key = r100;
                return this;
            }

            public Builder size(Long r100) {
                this.size = r100;
                return this;
            }

            public Builder visit_info(CardVisitInfo r100) {
                this.visit_info = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_AudioInfo extends ProtoAdapter<AudioInfo> {
            public ProtoAdapter_AudioInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, AudioInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AudioInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.key = "";
                r101.duration = 0;
                r101.size = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.duration = ProtoAdapter.INT32.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.size = ProtoAdapter.INT64.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.visit_info = CardVisitInfo.ADAPTER.decode(r100);
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(AudioInfo r100) {
                String r101 = r100.key;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.duration;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Long r107 = r100.size;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                CardVisitInfo r110 = r100.visit_info;
                if (r110 == null) goto L18;
                r102 = CardVisitInfo.ADAPTER.encodedSizeWithTag(4, r110);
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
            public /* bridge */ /* synthetic */ AudioInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AudioInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AudioInfo r101) throws IOException {
                String r102 = r101.key;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.duration;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                Long r104 = r101.size;
                if (r104 == null) goto L11;
                ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
            L11:
                CardVisitInfo r105 = r101.visit_info;
                if (r105 == null) goto L14;
                CardVisitInfo.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AudioInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AudioInfo();
            DEFAULT_DURATION = 0;
            DEFAULT_SIZE = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.key = this.key;
            r100.duration = this.duration;
            r100.size = this.size;
            r100.visit_info = this.visit_info;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return AudioInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public AudioInfo(String r100, Integer r101, Long r102, CardVisitInfo r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public AudioInfo(String r100, Integer r101, Long r102, CardVisitInfo r103, ByteString r104) {
            super(ADAPTER, r104);
            this.key = r100;
            this.duration = r101;
            this.size = r102;
            this.visit_info = r103;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<UniversalCardEntity, Builder> {
        public ActionDataSource action_data_source;
        public ActionStatus action_status;
        public String action_url;
        public Long app_id;
        public CardAppInfo app_info;
        public Long bot_id;
        public CardHeader card_header;
        public String card_id;
        public Map<String, ResourceCleanScene> clean_resource_key_scene;
        public Content content;
        public DataSource data_source;
        public DataType data_type;
        public List<Url> json_card_urls;
        public Map<Integer, String> local_extra;
        public PatchInfo patch_info;
        public String source_id;
        public Integer source_type;
        public StreamingConfig streaming_config;
        public Boolean streaming_mode;
        public String version;

        @Override // com.squareup.wire.Message.Builder
        public UniversalCardEntity build() {
            String r100 = this.card_id;
            if (r100 == null) goto L11;
            if (this.version == null) goto L11;
            if (this.content == null) goto L11;
            return new UniversalCardEntity(this.card_id, this.version, this.content, this.source_id, this.source_type, this.action_status, this.action_url, this.local_extra, this.app_info, this.streaming_mode, this.data_source, this.streaming_config, this.data_type, this.patch_info, this.clean_resource_key_scene, this.app_id, this.bot_id, this.json_card_urls, this.card_header, this.action_data_source, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "card_id", this.version, "version", this.content, "content"});
        }

        public Builder() {
            this.local_extra = Internal.newMutableMap();
            this.clean_resource_key_scene = Internal.newMutableMap();
            this.json_card_urls = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder action_data_source(ActionDataSource r100) {
            this.action_data_source = r100;
            return this;
        }

        public Builder action_status(ActionStatus r100) {
            this.action_status = r100;
            return this;
        }

        public Builder action_url(String r100) {
            this.action_url = r100;
            return this;
        }

        public Builder app_id(Long r100) {
            this.app_id = r100;
            return this;
        }

        public Builder app_info(CardAppInfo r100) {
            this.app_info = r100;
            return this;
        }

        public Builder bot_id(Long r100) {
            this.bot_id = r100;
            return this;
        }

        public Builder card_header(CardHeader r100) {
            this.card_header = r100;
            return this;
        }

        public Builder card_id(String r100) {
            this.card_id = r100;
            return this;
        }

        public Builder clean_resource_key_scene(Map<String, ResourceCleanScene> r100) {
            Internal.checkElementsNotNull(r100);
            this.clean_resource_key_scene = r100;
            return this;
        }

        public Builder content(Content r100) {
            this.content = r100;
            return this;
        }

        public Builder data_source(DataSource r100) {
            this.data_source = r100;
            return this;
        }

        public Builder data_type(DataType r100) {
            this.data_type = r100;
            return this;
        }

        public Builder json_card_urls(List<Url> r100) {
            Internal.checkElementsNotNull(r100);
            this.json_card_urls = r100;
            return this;
        }

        public Builder local_extra(Map<Integer, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.local_extra = r100;
            return this;
        }

        public Builder patch_info(PatchInfo r100) {
            this.patch_info = r100;
            return this;
        }

        public Builder source_id(String r100) {
            this.source_id = r100;
            return this;
        }

        public Builder source_type(Integer r100) {
            this.source_type = r100;
            return this;
        }

        public Builder streaming_config(StreamingConfig r100) {
            this.streaming_config = r100;
            return this;
        }

        public Builder streaming_mode(Boolean r100) {
            this.streaming_mode = r100;
            return this;
        }

        public Builder version(String r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class CardHeader extends com.squareup.wire.Message<CardHeader, Builder> {
        public static final ProtoAdapter<CardHeader> ADAPTER = null;
        public static final String DEFAULT_MAIN_TITLE = "";
        public static final String DEFAULT_SUBTITLE = "";
        public static final String DEFAULT_THEME = "";
        public static final String DEFAULT_TITLE = "";
        private static final long serialVersionUID = 0;
        public final String main_title;
        public final String subtitle;
        public final String theme;
        public final String title;

        public static final class Builder extends com.squareup.wire.Message.Builder<CardHeader, Builder> {
            public String main_title;
            public String subtitle;
            public String theme;
            public String title;

            @Override // com.squareup.wire.Message.Builder
            public CardHeader build() {
                return new CardHeader(this.title, this.main_title, this.subtitle, this.theme, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder main_title(String r100) {
                this.main_title = r100;
                return this;
            }

            public Builder subtitle(String r100) {
                this.subtitle = r100;
                return this;
            }

            public Builder theme(String r100) {
                this.theme = r100;
                return this;
            }

            public Builder title(String r100) {
                this.title = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CardHeader extends ProtoAdapter<CardHeader> {
            public ProtoAdapter_CardHeader() {
                super(FieldEncoding.LENGTH_DELIMITED, CardHeader.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CardHeader decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.title = "";
                r101.main_title = "";
                r101.subtitle = "";
                r101.theme = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.title = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.main_title = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.subtitle = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.theme = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(CardHeader r100) {
                String r101 = r100.title;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.main_title;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.subtitle;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.theme;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
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
            public /* bridge */ /* synthetic */ CardHeader decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CardHeader r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CardHeader r101) throws IOException {
                String r102 = r101.title;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.main_title;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.subtitle;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.theme;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CardHeader r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CardHeader();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.title = this.title;
            r100.main_title = this.main_title;
            r100.subtitle = this.subtitle;
            r100.theme = this.theme;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CardHeader.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public CardHeader(String r100, String r101, String r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public CardHeader(String r100, String r101, String r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.title = r100;
            this.main_title = r101;
            this.subtitle = r102;
            this.theme = r103;
        }
    }

    public static final class Character extends com.squareup.wire.Message<Character, Builder> {
        public static final ProtoAdapter<Character> ADAPTER = null;
        public static final String DEFAULT_AVATAR_KEY = "";
        public static final String DEFAULT_CONTENT = "";
        public static final String DEFAULT_ID = "";
        public static final CharacterType DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final String avatar_key;
        public final String content;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public final String f253587id;
        public final CharacterType type;

        public static final class Builder extends com.squareup.wire.Message.Builder<Character, Builder> {
            public String avatar_key;
            public String content;

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            public String f253588id;
            public CharacterType type;

            @Override // com.squareup.wire.Message.Builder
            public Character build() {
                CharacterType r100 = this.type;
                if (r100 == null) goto L9;
                if (this.f253588id == null) goto L9;
                return new Character(this.type, this.f253588id, this.content, this.avatar_key, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "type", this.f253588id, "id"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder avatar_key(String r100) {
                this.avatar_key = r100;
                return this;
            }

            public Builder content(String r100) {
                this.content = r100;
                return this;
            }

            public Builder id(String r100) {
                this.f253588id = r100;
                return this;
            }

            public Builder type(CharacterType r100) {
                this.type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Character extends ProtoAdapter<Character> {
            public ProtoAdapter_Character() {
                super(FieldEncoding.LENGTH_DELIMITED, Character.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Character decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = CharacterType.CHARACTER_UNKNOWN;
                r101.f253588id = "";
                r101.content = "";
                r101.avatar_key = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.type = CharacterType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.f253588id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.content = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.avatar_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Character r100) {
                int r101 = CharacterType.ADAPTER.encodedSizeWithTag(1, r100.type);
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                int r103 = r101 + r102.encodedSizeWithTag(2, r100.f253587id);
                String r104 = r100.content;
                int r105 = 0;
                if (r104 == null) goto L5;
                int r106 = r102.encodedSizeWithTag(3, r104);
            L6:
                int r107 = r103 + r106;
                String r108 = r100.avatar_key;
                if (r108 == null) goto L10;
                r105 = r102.encodedSizeWithTag(4, r108);
            L10:
                return (r107 + r105) + r100.unknownFields().size();
            L5:
                r106 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Character decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Character r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Character r101) throws IOException {
                CharacterType.ADAPTER.encodeWithTag(r100, 1, r101.type);
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 2, r101.f253587id);
                String r103 = r101.content;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 3, r103);
            L5:
                String r104 = r101.avatar_key;
                if (r104 == null) goto L8;
                r102.encodeWithTag(r100, 4, r104);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Character r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Character();
            DEFAULT_TYPE = CharacterType.CHARACTER_UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.f253588id = this.f253587id;
            r100.content = this.content;
            r100.avatar_key = this.avatar_key;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Character.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Character(CharacterType r100, String r101, String r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public Character(CharacterType r100, String r101, String r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.type = r100;
            this.f253587id = r101;
            this.content = r102;
            this.avatar_key = r103;
        }
    }

    public static final enum CharacterType extends Enum<CharacterType> implements WireEnum {
        private static final /* synthetic */ CharacterType[] $VALUES = null;
        public static final ProtoAdapter<CharacterType> ADAPTER = null;
        public static final CharacterType CHARACTER_UNKNOWN = null;
        public static final CharacterType CHAT = null;
        public static final CharacterType USER = null;
        private final int value;

        static {
            CharacterType r100 = new CharacterType("CHARACTER_UNKNOWN", 0, 0);
            CHARACTER_UNKNOWN = r100;
            CharacterType r101 = new CharacterType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1);
            USER = r101;
            CharacterType r102 = new CharacterType("CHAT", 2, 2);
            CHAT = r102;
            $VALUES = new CharacterType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(CharacterType.class);
        }

        public static CharacterType[] values() {
            return (CharacterType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static CharacterType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return CHAT;
        L12:
            return USER;
        L14:
            return CHARACTER_UNKNOWN;
        }

        public static CharacterType valueOf(String r100) {
            return (CharacterType) a.a(CharacterType.class, r100);
        }

        private CharacterType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Config extends com.squareup.wire.Message<Config, Builder> {
        public static final ProtoAdapter<Config> ADAPTER = null;
        public static final String DEFAULT_ANALYTICS_DATA = "";
        public static final Boolean DEFAULT_COMPACT_WIDTH = null;
        public static final String DEFAULT_CUSTOM_PARAMETER = "";
        public static final Boolean DEFAULT_ENABLE_FORWARD = null;
        public static final Boolean DEFAULT_ENABLE_TRANSLATE = null;
        public static final Boolean DEFAULT_IS_FORWARD = null;
        public static final Boolean DEFAULT_IS_GADGET_PRELOAD = null;
        public static final Boolean DEFAULT_IS_MEEGO_PRE_LOAD = null;
        public static final Boolean DEFAULT_USE_CUSTOM_TRANSLATION = null;
        public static final Boolean DEFAULT_WIDE_SCREEN_MODE = null;
        public static final String DEFAULT_WIDTH_MODE = "";
        private static final long serialVersionUID = 0;
        public final String analytics_data;
        public final Boolean compact_width;
        public final String custom_parameter;
        public final Boolean enable_forward;
        public final Boolean enable_translate;
        public final List<String> gadget_client_ids;
        public final Boolean is_forward;
        public final Boolean is_gadget_preload;
        public final Boolean is_meego_pre_load;
        public final Map<String, LocaleInfo> locale_info;
        public final Boolean use_custom_translation;
        public final Map<String, String> user_card_language_detect;
        public final Boolean wide_screen_mode;
        public final String width_mode;

        public static final class Builder extends com.squareup.wire.Message.Builder<Config, Builder> {
            public String analytics_data;
            public Boolean compact_width;
            public String custom_parameter;
            public Boolean enable_forward;
            public Boolean enable_translate;
            public List<String> gadget_client_ids;
            public Boolean is_forward;
            public Boolean is_gadget_preload;
            public Boolean is_meego_pre_load;
            public Map<String, LocaleInfo> locale_info;
            public Boolean use_custom_translation;
            public Map<String, String> user_card_language_detect;
            public Boolean wide_screen_mode;
            public String width_mode;

            @Override // com.squareup.wire.Message.Builder
            public Config build() {
                return new Config(this.compact_width, this.width_mode, this.enable_forward, this.wide_screen_mode, this.analytics_data, this.enable_translate, this.use_custom_translation, this.user_card_language_detect, this.locale_info, this.is_gadget_preload, this.gadget_client_ids, this.is_meego_pre_load, this.custom_parameter, this.is_forward, super.buildUnknownFields());
            }

            public Builder() {
                this.user_card_language_detect = Internal.newMutableMap();
                this.locale_info = Internal.newMutableMap();
                this.gadget_client_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder analytics_data(String r100) {
                this.analytics_data = r100;
                return this;
            }

            public Builder compact_width(Boolean r100) {
                this.compact_width = r100;
                return this;
            }

            public Builder custom_parameter(String r100) {
                this.custom_parameter = r100;
                return this;
            }

            public Builder enable_forward(Boolean r100) {
                this.enable_forward = r100;
                return this;
            }

            public Builder enable_translate(Boolean r100) {
                this.enable_translate = r100;
                return this;
            }

            public Builder gadget_client_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.gadget_client_ids = r100;
                return this;
            }

            public Builder is_forward(Boolean r100) {
                this.is_forward = r100;
                return this;
            }

            public Builder is_gadget_preload(Boolean r100) {
                this.is_gadget_preload = r100;
                return this;
            }

            public Builder is_meego_pre_load(Boolean r100) {
                this.is_meego_pre_load = r100;
                return this;
            }

            public Builder locale_info(Map<String, LocaleInfo> r100) {
                Internal.checkElementsNotNull(r100);
                this.locale_info = r100;
                return this;
            }

            public Builder use_custom_translation(Boolean r100) {
                this.use_custom_translation = r100;
                return this;
            }

            public Builder user_card_language_detect(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.user_card_language_detect = r100;
                return this;
            }

            public Builder wide_screen_mode(Boolean r100) {
                this.wide_screen_mode = r100;
                return this;
            }

            public Builder width_mode(String r100) {
                this.width_mode = r100;
                return this;
            }
        }

        public static final class LocaleInfo extends com.squareup.wire.Message<LocaleInfo, Builder> {
            public static final ProtoAdapter<LocaleInfo> ADAPTER = null;
            private static final long serialVersionUID = 0;
            public final List<String> content_languages;

            public static final class Builder extends com.squareup.wire.Message.Builder<LocaleInfo, Builder> {
                public List<String> content_languages;

                @Override // com.squareup.wire.Message.Builder
                public LocaleInfo build() {
                    return new LocaleInfo(this.content_languages, super.buildUnknownFields());
                }

                public Builder() {
                    this.content_languages = Internal.newMutableList();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder content_languages(List<String> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.content_languages = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_LocaleInfo extends ProtoAdapter<LocaleInfo> {
                public ProtoAdapter_LocaleInfo() {
                    super(FieldEncoding.LENGTH_DELIMITED, LocaleInfo.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public LocaleInfo decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L9;
                    if (r103 != 1) goto L7;
                    r101.content_languages.add(ProtoAdapter.STRING.decode(r100));
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
                public int encodedSize2(LocaleInfo r100) {
                    return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.content_languages) + r100.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ LocaleInfo decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(LocaleInfo r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, LocaleInfo r101) throws IOException {
                    ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.content_languages);
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LocaleInfo r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_LocaleInfo();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.content_languages = Internal.copyOf("content_languages", this.content_languages);
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return LocaleInfo.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public LocaleInfo(List<String> r100) {
                this(r100, ByteString.EMPTY);
            }

            public LocaleInfo(List<String> r100, ByteString r101) {
                super(ADAPTER, r101);
                this.content_languages = Internal.immutableCopyOf("content_languages", r100);
            }
        }

        public static final class ProtoAdapter_Config extends ProtoAdapter<Config> {
            private final ProtoAdapter<Map<String, LocaleInfo>> locale_info;
            private final ProtoAdapter<Map<String, String>> user_card_language_detect;

            public ProtoAdapter_Config() {
                super(FieldEncoding.LENGTH_DELIMITED, Config.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.user_card_language_detect = ProtoAdapter.newMapAdapter(r100, r100);
                this.locale_info = ProtoAdapter.newMapAdapter(r100, LocaleInfo.ADAPTER);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Config decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.FALSE;
                r101.compact_width = r102;
                r101.width_mode = "";
                r101.enable_forward = r102;
                r101.wide_screen_mode = r102;
                r101.analytics_data = "";
                r101.enable_translate = r102;
                r101.use_custom_translation = r102;
                r101.is_gadget_preload = r102;
                r101.is_meego_pre_load = r102;
                r101.custom_parameter = "";
                r101.is_forward = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L21;
                switch(r104) {
                    case 1: goto L20;
                    case 2: goto L19;
                    case 3: goto L18;
                    case 4: goto L17;
                    case 5: goto L16;
                    case 6: goto L15;
                    case 7: goto L14;
                    case 8: goto L13;
                    case 9: goto L12;
                    case 10: goto L11;
                    case 11: goto L10;
                    case 12: goto L9;
                    case 13: goto L8;
                    case 14: goto L7;
                    default: goto L6;
                };
            L7:
                r101.is_forward = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                r101.custom_parameter = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                r101.is_meego_pre_load = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                r101.gadget_client_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L11:
                r101.is_gadget_preload = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                r101.locale_info.putAll(this.locale_info.decode(r100));
                goto L3
            L13:
                r101.user_card_language_detect.putAll(this.user_card_language_detect.decode(r100));
                goto L3
            L14:
                r101.use_custom_translation = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L15:
                r101.enable_translate = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L16:
                r101.analytics_data = ProtoAdapter.STRING.decode(r100);
                goto L3
            L17:
                r101.wide_screen_mode = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L18:
                r101.enable_forward = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L19:
                r101.width_mode = ProtoAdapter.STRING.decode(r100);
                goto L3
            L20:
                r101.compact_width = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Config r100) {
                Boolean r101 = r100.compact_width;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.width_mode;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.enable_forward;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Boolean r110 = r100.wide_screen_mode;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                String r113 = r100.analytics_data;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                Boolean r116 = r100.enable_translate;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                Boolean r119 = r100.use_custom_translation;
                if (r119 == null) goto L29;
                int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
            L30:
                int r121 = ((r118 + r120) + this.user_card_language_detect.encodedSizeWithTag(8, r100.user_card_language_detect)) + this.locale_info.encodedSizeWithTag(9, r100.locale_info);
                Boolean r122 = r100.is_gadget_preload;
                if (r122 == null) goto L33;
                int r123 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r122);
            L34:
                int r124 = r121 + r123;
                ProtoAdapter<String> r125 = ProtoAdapter.STRING;
                int r126 = r124 + r125.asRepeated().encodedSizeWithTag(11, r100.gadget_client_ids);
                Boolean r127 = r100.is_meego_pre_load;
                if (r127 == null) goto L37;
                int r128 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r127);
            L38:
                int r129 = r126 + r128;
                String r130 = r100.custom_parameter;
                if (r130 == null) goto L41;
                int r131 = r125.encodedSizeWithTag(13, r130);
            L42:
                int r132 = r129 + r131;
                Boolean r133 = r100.is_forward;
                if (r133 == null) goto L46;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(14, r133);
            L46:
                return (r132 + r102) + r100.unknownFields().size();
            L41:
                r131 = 0;
                goto L42
            L37:
                r128 = 0;
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
            public /* bridge */ /* synthetic */ Config decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Config r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Config r101) throws IOException {
                Boolean r102 = r101.compact_width;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.width_mode;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.enable_forward;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
            L11:
                Boolean r105 = r101.wide_screen_mode;
                if (r105 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
            L14:
                String r106 = r101.analytics_data;
                if (r106 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
            L17:
                Boolean r107 = r101.enable_translate;
                if (r107 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
            L20:
                Boolean r108 = r101.use_custom_translation;
                if (r108 == null) goto L23;
                ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
            L23:
                this.user_card_language_detect.encodeWithTag(r100, 8, r101.user_card_language_detect);
                this.locale_info.encodeWithTag(r100, 9, r101.locale_info);
                Boolean r109 = r101.is_gadget_preload;
                if (r109 == null) goto L26;
                ProtoAdapter.BOOL.encodeWithTag(r100, 10, r109);
            L26:
                ProtoAdapter<String> r110 = ProtoAdapter.STRING;
                r110.asRepeated().encodeWithTag(r100, 11, r101.gadget_client_ids);
                Boolean r111 = r101.is_meego_pre_load;
                if (r111 == null) goto L29;
                ProtoAdapter.BOOL.encodeWithTag(r100, 12, r111);
            L29:
                String r112 = r101.custom_parameter;
                if (r112 == null) goto L32;
                r110.encodeWithTag(r100, 13, r112);
            L32:
                Boolean r113 = r101.is_forward;
                if (r113 == null) goto L35;
                ProtoAdapter.BOOL.encodeWithTag(r100, 14, r113);
            L35:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Config r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Config();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_COMPACT_WIDTH = r100;
            DEFAULT_ENABLE_FORWARD = r100;
            DEFAULT_WIDE_SCREEN_MODE = r100;
            DEFAULT_ENABLE_TRANSLATE = r100;
            DEFAULT_USE_CUSTOM_TRANSLATION = r100;
            DEFAULT_IS_GADGET_PRELOAD = r100;
            DEFAULT_IS_MEEGO_PRE_LOAD = r100;
            DEFAULT_IS_FORWARD = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.compact_width = this.compact_width;
            r100.width_mode = this.width_mode;
            r100.enable_forward = this.enable_forward;
            r100.wide_screen_mode = this.wide_screen_mode;
            r100.analytics_data = this.analytics_data;
            r100.enable_translate = this.enable_translate;
            r100.use_custom_translation = this.use_custom_translation;
            r100.user_card_language_detect = Internal.copyOf("user_card_language_detect", this.user_card_language_detect);
            r100.locale_info = Internal.copyOf("locale_info", this.locale_info);
            r100.is_gadget_preload = this.is_gadget_preload;
            r100.gadget_client_ids = Internal.copyOf("gadget_client_ids", this.gadget_client_ids);
            r100.is_meego_pre_load = this.is_meego_pre_load;
            r100.custom_parameter = this.custom_parameter;
            r100.is_forward = this.is_forward;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Config.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Config(Boolean r110, String r111, Boolean r112, Boolean r210, String r211, Boolean r212, Boolean r213, Map<String, String> r214, Map<String, LocaleInfo> r215, Boolean r216, List<String> r217, Boolean r218, String r219, Boolean r310) {
            this(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, ByteString.EMPTY);
        }

        public Config(Boolean r100, String r101, Boolean r102, Boolean r103, String r104, Boolean r105, Boolean r110, Map<String, String> r111, Map<String, LocaleInfo> r112, Boolean r113, List<String> r114, Boolean r115, String r116, Boolean r117, ByteString r118) {
            super(ADAPTER, r118);
            this.compact_width = r100;
            this.width_mode = r101;
            this.enable_forward = r102;
            this.wide_screen_mode = r103;
            this.analytics_data = r104;
            this.enable_translate = r105;
            this.use_custom_translation = r110;
            this.user_card_language_detect = Internal.immutableCopyOf("user_card_language_detect", r111);
            this.locale_info = Internal.immutableCopyOf("locale_info", r112);
            this.is_gadget_preload = r113;
            this.gadget_client_ids = Internal.immutableCopyOf("gadget_client_ids", r114);
            this.is_meego_pre_load = r115;
            this.custom_parameter = r116;
            this.is_forward = r117;
        }
    }

    public static final class Content extends com.squareup.wire.Message<Content, Builder> {
        public static final ProtoAdapter<Content> ADAPTER = null;
        public static final String DEFAULT_CARD = "";
        private static final long serialVersionUID = 0;
        public final Map<String, Action> actions;
        public final Attachment attachment;
        public final String card;
        public final Config config;
        public final I18nInfo i18n_info;

        public static final class Builder extends com.squareup.wire.Message.Builder<Content, Builder> {
            public Map<String, Action> actions;
            public Attachment attachment;
            public String card;
            public Config config;
            public I18nInfo i18n_info;

            @Override // com.squareup.wire.Message.Builder
            public Content build() {
                String r100 = this.card;
                if (r100 == null) goto L7;
                return new Content(this.card, this.config, this.attachment, this.actions, this.i18n_info, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, BrowserDependency.UrlClickType.CARD});
            }

            public Builder() {
                this.actions = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder actions(Map<String, Action> r100) {
                Internal.checkElementsNotNull(r100);
                this.actions = r100;
                return this;
            }

            public Builder attachment(Attachment r100) {
                this.attachment = r100;
                return this;
            }

            public Builder card(String r100) {
                this.card = r100;
                return this;
            }

            public Builder config(Config r100) {
                this.config = r100;
                return this;
            }

            public Builder i18n_info(I18nInfo r100) {
                this.i18n_info = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Content extends ProtoAdapter<Content> {
            private final ProtoAdapter<Map<String, Action>> actions;

            public ProtoAdapter_Content() {
                super(FieldEncoding.LENGTH_DELIMITED, Content.class);
                this.actions = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, Action.ADAPTER);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Content decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.card = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.card = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.config = Config.ADAPTER.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.attachment = Attachment.ADAPTER.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.actions.putAll(this.actions.decode(r100));
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.i18n_info = I18nInfo.ADAPTER.decode(r100);
                goto L3
            L15:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Content r100) {
                int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.card);
                Config r102 = r100.config;
                int r103 = 0;
                if (r102 == null) goto L5;
                int r104 = Config.ADAPTER.encodedSizeWithTag(2, r102);
            L6:
                int r105 = r101 + r104;
                Attachment r106 = r100.attachment;
                if (r106 == null) goto L9;
                int r107 = Attachment.ADAPTER.encodedSizeWithTag(3, r106);
            L10:
                int r108 = (r105 + r107) + this.actions.encodedSizeWithTag(4, r100.actions);
                I18nInfo r109 = r100.i18n_info;
                if (r109 == null) goto L14;
                r103 = I18nInfo.ADAPTER.encodedSizeWithTag(5, r109);
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
            public /* bridge */ /* synthetic */ Content decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Content r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Content r101) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.card);
                Config r102 = r101.config;
                if (r102 == null) goto L5;
                Config.ADAPTER.encodeWithTag(r100, 2, r102);
            L5:
                Attachment r103 = r101.attachment;
                if (r103 == null) goto L8;
                Attachment.ADAPTER.encodeWithTag(r100, 3, r103);
            L8:
                this.actions.encodeWithTag(r100, 4, r101.actions);
                I18nInfo r104 = r101.i18n_info;
                if (r104 == null) goto L11;
                I18nInfo.ADAPTER.encodeWithTag(r100, 5, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Content r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Content();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.card = this.card;
            r100.config = this.config;
            r100.attachment = this.attachment;
            r100.actions = Internal.copyOf(SlcCommonAction.KEY_ACTIONS, this.actions);
            r100.i18n_info = this.i18n_info;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Content.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Content(String r100, Config r101, Attachment r110, Map<String, Action> r111, I18nInfo r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public Content(String r100, Config r101, Attachment r102, Map<String, Action> r103, I18nInfo r104, ByteString r105) {
            super(ADAPTER, r105);
            this.card = r100;
            this.config = r101;
            this.attachment = r102;
            this.actions = Internal.immutableCopyOf(SlcCommonAction.KEY_ACTIONS, r103);
            this.i18n_info = r104;
        }
    }

    public static final enum DataSource extends Enum<DataSource> implements WireEnum {
        private static final /* synthetic */ DataSource[] $VALUES = null;
        public static final ProtoAdapter<DataSource> ADAPTER = null;
        public static final DataSource CARD = null;
        public static final DataSource IM = null;
        public static final DataSource STREAMING = null;
        private final int value;

        static {
            DataSource r100 = new DataSource("IM", 0, 1);
            IM = r100;
            DataSource r101 = new DataSource("CARD", 1, 2);
            CARD = r101;
            DataSource r102 = new DataSource("STREAMING", 2, 3);
            STREAMING = r102;
            $VALUES = new DataSource[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(DataSource.class);
        }

        public static DataSource[] values() {
            return (DataSource[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static DataSource fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return STREAMING;
        L13:
            return CARD;
        L15:
            return IM;
        }

        public static DataSource valueOf(String r100) {
            return (DataSource) a.a(DataSource.class, r100);
        }

        private DataSource(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum DataType extends Enum<DataType> implements WireEnum {
        private static final /* synthetic */ DataType[] $VALUES = null;
        public static final ProtoAdapter<DataType> ADAPTER = null;
        public static final DataType ActionSyncPatch = null;
        public static final DataType Card = null;
        public static final DataType CardRebind = null;
        private final int value;

        static {
            DataType r100 = new DataType("Card", 0, 0);
            Card = r100;
            DataType r101 = new DataType("ActionSyncPatch", 1, 1);
            ActionSyncPatch = r101;
            DataType r102 = new DataType("CardRebind", 2, 2);
            CardRebind = r102;
            $VALUES = new DataType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(DataType.class);
        }

        public static DataType[] values() {
            return (DataType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static DataType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return CardRebind;
        L12:
            return ActionSyncPatch;
        L14:
            return Card;
        }

        public static DataType valueOf(String r100) {
            return (DataType) a.a(DataType.class, r100);
        }

        private DataType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class I18nInfo extends com.squareup.wire.Message<I18nInfo, Builder> {
        public static final ProtoAdapter<I18nInfo> ADAPTER = null;
        public static final I18nTypeEnum DEFAULT_I18N_TYPE = null;
        public static final Boolean DEFAULT_IS_I18N = null;
        public static final String DEFAULT_LOCALE = "";
        private static final long serialVersionUID = 0;
        public final List<String> all_locales;
        public final Map<String, String> content_language;
        public final I18nTypeEnum i18n_type;
        public final Boolean is_i18n;
        public final String locale;
        public final Map<String, LocaleInfo> locale_info;

        public static final class Builder extends com.squareup.wire.Message.Builder<I18nInfo, Builder> {
            public List<String> all_locales;
            public Map<String, String> content_language;
            public I18nTypeEnum i18n_type;
            public Boolean is_i18n;
            public String locale;
            public Map<String, LocaleInfo> locale_info;

            @Override // com.squareup.wire.Message.Builder
            public I18nInfo build() {
                return new I18nInfo(this.i18n_type, this.is_i18n, this.locale, this.all_locales, this.content_language, this.locale_info, super.buildUnknownFields());
            }

            public Builder() {
                this.all_locales = Internal.newMutableList();
                this.content_language = Internal.newMutableMap();
                this.locale_info = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder all_locales(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.all_locales = r100;
                return this;
            }

            public Builder content_language(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.content_language = r100;
                return this;
            }

            public Builder i18n_type(I18nTypeEnum r100) {
                this.i18n_type = r100;
                return this;
            }

            public Builder is_i18n(Boolean r100) {
                this.is_i18n = r100;
                return this;
            }

            public Builder locale(String r100) {
                this.locale = r100;
                return this;
            }

            public Builder locale_info(Map<String, LocaleInfo> r100) {
                Internal.checkElementsNotNull(r100);
                this.locale_info = r100;
                return this;
            }
        }

        public static final enum I18nTypeEnum extends Enum<I18nTypeEnum> implements WireEnum {
            private static final /* synthetic */ I18nTypeEnum[] $VALUES = null;
            public static final ProtoAdapter<I18nTypeEnum> ADAPTER = null;
            public static final I18nTypeEnum GLOBAL_I18N = null;
            public static final I18nTypeEnum LOCAL_I18N = null;
            private final int value;

            static {
                I18nTypeEnum r100 = new I18nTypeEnum("GLOBAL_I18N", 0, 0);
                GLOBAL_I18N = r100;
                I18nTypeEnum r101 = new I18nTypeEnum("LOCAL_I18N", 1, 1);
                LOCAL_I18N = r101;
                $VALUES = new I18nTypeEnum[]{r100, r101};
                ADAPTER = ProtoAdapter.newEnumAdapter(I18nTypeEnum.class);
            }

            public static I18nTypeEnum[] values() {
                return (I18nTypeEnum[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static I18nTypeEnum fromValue(int r100) {
                if (r100 == 0) goto L10;
                if (r100 == 1) goto L8;
                return null;
            L8:
                return LOCAL_I18N;
            L10:
                return GLOBAL_I18N;
            }

            public static I18nTypeEnum valueOf(String r100) {
                return (I18nTypeEnum) a.a(I18nTypeEnum.class, r100);
            }

            private I18nTypeEnum(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class LocaleInfo extends com.squareup.wire.Message<LocaleInfo, Builder> {
            public static final ProtoAdapter<LocaleInfo> ADAPTER = null;
            private static final long serialVersionUID = 0;
            public final List<String> content_languages;

            public static final class Builder extends com.squareup.wire.Message.Builder<LocaleInfo, Builder> {
                public List<String> content_languages;

                @Override // com.squareup.wire.Message.Builder
                public LocaleInfo build() {
                    return new LocaleInfo(this.content_languages, super.buildUnknownFields());
                }

                public Builder() {
                    this.content_languages = Internal.newMutableList();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder content_languages(List<String> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.content_languages = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_LocaleInfo extends ProtoAdapter<LocaleInfo> {
                public ProtoAdapter_LocaleInfo() {
                    super(FieldEncoding.LENGTH_DELIMITED, LocaleInfo.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public LocaleInfo decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L9;
                    if (r103 != 1) goto L7;
                    r101.content_languages.add(ProtoAdapter.STRING.decode(r100));
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
                public int encodedSize2(LocaleInfo r100) {
                    return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.content_languages) + r100.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ LocaleInfo decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(LocaleInfo r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, LocaleInfo r101) throws IOException {
                    ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.content_languages);
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LocaleInfo r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_LocaleInfo();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.content_languages = Internal.copyOf("content_languages", this.content_languages);
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return LocaleInfo.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public LocaleInfo(List<String> r100) {
                this(r100, ByteString.EMPTY);
            }

            public LocaleInfo(List<String> r100, ByteString r101) {
                super(ADAPTER, r101);
                this.content_languages = Internal.immutableCopyOf("content_languages", r100);
            }
        }

        public static final class ProtoAdapter_I18nInfo extends ProtoAdapter<I18nInfo> {
            private final ProtoAdapter<Map<String, String>> content_language;
            private final ProtoAdapter<Map<String, LocaleInfo>> locale_info;

            public ProtoAdapter_I18nInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, I18nInfo.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.content_language = ProtoAdapter.newMapAdapter(r100, r100);
                this.locale_info = ProtoAdapter.newMapAdapter(r100, LocaleInfo.ADAPTER);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public I18nInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.i18n_type = I18nTypeEnum.GLOBAL_I18N;
                r101.is_i18n = Boolean.FALSE;
                r101.locale = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L16;
                switch(r103) {
                    case 1: goto L18;
                    case 2: goto L11;
                    case 3: goto L10;
                    case 4: goto L9;
                    case 5: goto L8;
                    case 6: goto L7;
                    default: goto L6;
                };
            L18:
                r101.i18n_type = I18nTypeEnum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.locale_info.putAll(this.locale_info.decode(r100));
                goto L3
            L8:
                r101.content_language.putAll(this.content_language.decode(r100));
                goto L3
            L9:
                r101.all_locales.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L10:
                r101.locale = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.is_i18n = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L16:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(I18nInfo r100) {
                I18nTypeEnum r101 = r100.i18n_type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = I18nTypeEnum.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.is_i18n;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.locale;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                return ((((r106 + r102) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(4, r100.all_locales)) + this.content_language.encodedSizeWithTag(5, r100.content_language)) + this.locale_info.encodedSizeWithTag(6, r100.locale_info)) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ I18nInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(I18nInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, I18nInfo r101) throws IOException {
                I18nTypeEnum r102 = r101.i18n_type;
                if (r102 == null) goto L5;
                I18nTypeEnum.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.is_i18n;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.locale;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 4, r101.all_locales);
                this.content_language.encodeWithTag(r100, 5, r101.content_language);
                this.locale_info.encodeWithTag(r100, 6, r101.locale_info);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, I18nInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_I18nInfo();
            DEFAULT_I18N_TYPE = I18nTypeEnum.GLOBAL_I18N;
            DEFAULT_IS_I18N = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.i18n_type = this.i18n_type;
            r100.is_i18n = this.is_i18n;
            r100.locale = this.locale;
            r100.all_locales = Internal.copyOf("all_locales", this.all_locales);
            r100.content_language = Internal.copyOf("content_language", this.content_language);
            r100.locale_info = Internal.copyOf("locale_info", this.locale_info);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return I18nInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public I18nInfo(I18nTypeEnum r100, Boolean r110, String r111, List<String> r112, Map<String, String> r113, Map<String, LocaleInfo> r114) {
            this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
        }

        public I18nInfo(I18nTypeEnum r100, Boolean r101, String r102, List<String> r103, Map<String, String> r104, Map<String, LocaleInfo> r105, ByteString r106) {
            super(ADAPTER, r106);
            this.i18n_type = r100;
            this.is_i18n = r101;
            this.locale = r102;
            this.all_locales = Internal.immutableCopyOf("all_locales", r103);
            this.content_language = Internal.immutableCopyOf("content_language", r104);
            this.locale_info = Internal.immutableCopyOf("locale_info", r105);
        }
    }

    public static final enum LocalExtraKey extends Enum<LocalExtraKey> implements WireEnum {
        private static final /* synthetic */ LocalExtraKey[] $VALUES = null;
        public static final ProtoAdapter<LocalExtraKey> ADAPTER = null;
        public static final LocalExtraKey OPEN_PLATFORM_MESSAGE_CARD = null;
        public static final LocalExtraKey UNKNOWN = null;
        private final int value;

        static {
            LocalExtraKey r100 = new LocalExtraKey("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            LocalExtraKey r101 = new LocalExtraKey("OPEN_PLATFORM_MESSAGE_CARD", 1, 1);
            OPEN_PLATFORM_MESSAGE_CARD = r101;
            $VALUES = new LocalExtraKey[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(LocalExtraKey.class);
        }

        public static LocalExtraKey[] values() {
            return (LocalExtraKey[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static LocalExtraKey fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return OPEN_PLATFORM_MESSAGE_CARD;
        L10:
            return UNKNOWN;
        }

        public static LocalExtraKey valueOf(String r100) {
            return (LocalExtraKey) a.a(LocalExtraKey.class, r100);
        }

        private LocalExtraKey(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class PatchInfo extends com.squareup.wire.Message<PatchInfo, Builder> {
        public static final ProtoAdapter<PatchInfo> ADAPTER = null;
        public static final DataSource DEFAULT_DATA_SOURCE = null;
        public static final Long DEFAULT_PATCH_VERSION = null;
        public static final Long DEFAULT_TARGET_VERSION = null;
        private static final long serialVersionUID = 0;
        public final DataSource data_source;
        public final Long patch_version;
        public final Long target_version;

        public static final class Builder extends com.squareup.wire.Message.Builder<PatchInfo, Builder> {
            public DataSource data_source;
            public Long patch_version;
            public Long target_version;

            @Override // com.squareup.wire.Message.Builder
            public PatchInfo build() {
                return new PatchInfo(this.target_version, this.patch_version, this.data_source, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder data_source(DataSource r100) {
                this.data_source = r100;
                return this;
            }

            public Builder patch_version(Long r100) {
                this.patch_version = r100;
                return this;
            }

            public Builder target_version(Long r100) {
                this.target_version = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_PatchInfo extends ProtoAdapter<PatchInfo> {
            public ProtoAdapter_PatchInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, PatchInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PatchInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.target_version = 0L;
                r101.patch_version = 0L;
                r101.data_source = DataSource.IM;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.target_version = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.patch_version = ProtoAdapter.INT64.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.data_source = DataSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
            public int encodedSize2(PatchInfo r100) {
                Long r101 = r100.target_version;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.patch_version;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                DataSource r107 = r100.data_source;
                if (r107 == null) goto L14;
                r102 = DataSource.ADAPTER.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ PatchInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(PatchInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, PatchInfo r101) throws IOException {
                Long r102 = r101.target_version;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.patch_version;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
            L8:
                DataSource r104 = r101.data_source;
                if (r104 == null) goto L11;
                DataSource.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PatchInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_PatchInfo();
            DEFAULT_TARGET_VERSION = 0L;
            DEFAULT_PATCH_VERSION = 0L;
            DEFAULT_DATA_SOURCE = DataSource.IM;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.target_version = this.target_version;
            r100.patch_version = this.patch_version;
            r100.data_source = this.data_source;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return PatchInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public PatchInfo(Long r100, Long r101, DataSource r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public PatchInfo(Long r100, Long r101, DataSource r102, ByteString r103) {
            super(ADAPTER, r103);
            this.target_version = r100;
            this.patch_version = r101;
            this.data_source = r102;
        }
    }

    public static final enum PrintStrategy extends Enum<PrintStrategy> implements WireEnum {
        private static final /* synthetic */ PrintStrategy[] $VALUES = null;
        public static final ProtoAdapter<PrintStrategy> ADAPTER = null;
        public static final PrintStrategy DEFAULT = null;
        public static final PrintStrategy DELAY = null;
        public static final PrintStrategy FAST = null;
        private final int value;

        static {
            PrintStrategy r100 = new PrintStrategy("DEFAULT", 0, 0);
            DEFAULT = r100;
            PrintStrategy r101 = new PrintStrategy("FAST", 1, 1);
            FAST = r101;
            PrintStrategy r102 = new PrintStrategy("DELAY", 2, 2);
            DELAY = r102;
            $VALUES = new PrintStrategy[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(PrintStrategy.class);
        }

        public static PrintStrategy[] values() {
            return (PrintStrategy[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static PrintStrategy fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return DELAY;
        L12:
            return FAST;
        L14:
            return DEFAULT;
        }

        public static PrintStrategy valueOf(String r100) {
            return (PrintStrategy) a.a(PrintStrategy.class, r100);
        }

        private PrintStrategy(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_UniversalCardEntity extends ProtoAdapter<UniversalCardEntity> {
        private final ProtoAdapter<Map<String, ResourceCleanScene>> clean_resource_key_scene;
        private final ProtoAdapter<Map<Integer, String>> local_extra;

        public ProtoAdapter_UniversalCardEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, UniversalCardEntity.class);
            ProtoAdapter<Integer> r100 = ProtoAdapter.INT32;
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            this.local_extra = ProtoAdapter.newMapAdapter(r100, r101);
            this.clean_resource_key_scene = ProtoAdapter.newMapAdapter(r101, ResourceCleanScene.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UniversalCardEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.card_id = "";
            r101.version = "";
            r101.source_id = "";
            r101.source_type = 0;
            r101.action_url = "";
            r101.streaming_mode = Boolean.FALSE;
            r101.data_source = DataSource.IM;
            r101.data_type = DataType.Card;
            r101.app_id = 0L;
            r101.bot_id = 0L;
            r101.action_data_source = ActionDataSource.IM_CONTENT;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L36;
            switch(r103) {
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
                case 11: goto L38;
                case 12: goto L21;
                case 13: goto L40;
                case 14: goto L16;
                case 15: goto L15;
                case 16: goto L14;
                case 17: goto L13;
                case 18: goto L12;
                case 19: goto L11;
                case 20: goto L42;
                default: goto L6;
            };
        L38:
            r101.data_source = DataSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
        L24:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L40:
            r101.data_type = DataType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L42:
            r101.action_data_source = ActionDataSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.card_header = CardHeader.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.json_card_urls.add(Url.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.bot_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            r101.app_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            r101.clean_resource_key_scene.putAll(this.clean_resource_key_scene.decode(r100));
            goto L3
        L16:
            r101.patch_info = PatchInfo.ADAPTER.decode(r100);
            goto L3
        L21:
            r101.streaming_config = StreamingConfig.ADAPTER.decode(r100);
            goto L3
        L26:
            r101.streaming_mode = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L27:
            r101.app_info = CardAppInfo.ADAPTER.decode(r100);
            goto L3
        L28:
            r101.local_extra.putAll(this.local_extra.decode(r100));
            goto L3
        L29:
            r101.action_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L30:
            r101.action_status = ActionStatus.ADAPTER.decode(r100);
            goto L3
        L31:
            r101.source_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L32:
            r101.source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L33:
            r101.content = Content.ADAPTER.decode(r100);
            goto L3
        L34:
            r101.version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L35:
            r101.card_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L36:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UniversalCardEntity r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.card_id) + r101.encodedSizeWithTag(2, r100.version)) + Content.ADAPTER.encodedSizeWithTag(3, r100.content);
            String r103 = r100.source_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(4, r103);
        L6:
            int r106 = r102 + r105;
            Integer r107 = r100.source_type;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(5, r107);
        L10:
            int r109 = r106 + r108;
            ActionStatus r110 = r100.action_status;
            if (r110 == null) goto L13;
            int r111 = ActionStatus.ADAPTER.encodedSizeWithTag(6, r110);
        L14:
            int r112 = r109 + r111;
            String r113 = r100.action_url;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(7, r113);
        L18:
            int r115 = (r112 + r114) + this.local_extra.encodedSizeWithTag(8, r100.local_extra);
            CardAppInfo r116 = r100.app_info;
            if (r116 == null) goto L21;
            int r117 = CardAppInfo.ADAPTER.encodedSizeWithTag(9, r116);
        L22:
            int r118 = r115 + r117;
            Boolean r119 = r100.streaming_mode;
            if (r119 == null) goto L25;
            int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r119);
        L26:
            int r121 = r118 + r120;
            DataSource r122 = r100.data_source;
            if (r122 == null) goto L29;
            int r123 = DataSource.ADAPTER.encodedSizeWithTag(11, r122);
        L30:
            int r124 = r121 + r123;
            StreamingConfig r125 = r100.streaming_config;
            if (r125 == null) goto L33;
            int r126 = StreamingConfig.ADAPTER.encodedSizeWithTag(12, r125);
        L34:
            int r127 = r124 + r126;
            DataType r128 = r100.data_type;
            if (r128 == null) goto L37;
            int r129 = DataType.ADAPTER.encodedSizeWithTag(13, r128);
        L38:
            int r130 = r127 + r129;
            PatchInfo r131 = r100.patch_info;
            if (r131 == null) goto L41;
            int r132 = PatchInfo.ADAPTER.encodedSizeWithTag(14, r131);
        L42:
            int r133 = (r130 + r132) + this.clean_resource_key_scene.encodedSizeWithTag(15, r100.clean_resource_key_scene);
            Long r134 = r100.app_id;
            if (r134 == null) goto L45;
            int r135 = ProtoAdapter.INT64.encodedSizeWithTag(16, r134);
        L46:
            int r136 = r133 + r135;
            Long r137 = r100.bot_id;
            if (r137 == null) goto L49;
            int r138 = ProtoAdapter.INT64.encodedSizeWithTag(17, r137);
        L50:
            int r139 = (r136 + r138) + Url.ADAPTER.asRepeated().encodedSizeWithTag(18, r100.json_card_urls);
            CardHeader r140 = r100.card_header;
            if (r140 == null) goto L53;
            int r141 = CardHeader.ADAPTER.encodedSizeWithTag(19, r140);
        L54:
            int r142 = r139 + r141;
            ActionDataSource r143 = r100.action_data_source;
            if (r143 == null) goto L58;
            r104 = ActionDataSource.ADAPTER.encodedSizeWithTag(20, r143);
        L58:
            return (r142 + r104) + r100.unknownFields().size();
        L53:
            r141 = 0;
            goto L54
        L49:
            r138 = 0;
            goto L50
        L45:
            r135 = 0;
            goto L46
        L41:
            r132 = 0;
            goto L42
        L37:
            r129 = 0;
            goto L38
        L33:
            r126 = 0;
            goto L34
        L29:
            r123 = 0;
            goto L30
        L25:
            r120 = 0;
            goto L26
        L21:
            r117 = 0;
            goto L22
        L17:
            r114 = 0;
            goto L18
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UniversalCardEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UniversalCardEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UniversalCardEntity r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.card_id);
            r102.encodeWithTag(r100, 2, r101.version);
            Content.ADAPTER.encodeWithTag(r100, 3, r101.content);
            String r103 = r101.source_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 4, r103);
        L5:
            Integer r104 = r101.source_type;
            if (r104 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r104);
        L8:
            ActionStatus r105 = r101.action_status;
            if (r105 == null) goto L11;
            ActionStatus.ADAPTER.encodeWithTag(r100, 6, r105);
        L11:
            String r106 = r101.action_url;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 7, r106);
        L14:
            this.local_extra.encodeWithTag(r100, 8, r101.local_extra);
            CardAppInfo r107 = r101.app_info;
            if (r107 == null) goto L17;
            CardAppInfo.ADAPTER.encodeWithTag(r100, 9, r107);
        L17:
            Boolean r108 = r101.streaming_mode;
            if (r108 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 10, r108);
        L20:
            DataSource r109 = r101.data_source;
            if (r109 == null) goto L23;
            DataSource.ADAPTER.encodeWithTag(r100, 11, r109);
        L23:
            StreamingConfig r110 = r101.streaming_config;
            if (r110 == null) goto L26;
            StreamingConfig.ADAPTER.encodeWithTag(r100, 12, r110);
        L26:
            DataType r111 = r101.data_type;
            if (r111 == null) goto L29;
            DataType.ADAPTER.encodeWithTag(r100, 13, r111);
        L29:
            PatchInfo r112 = r101.patch_info;
            if (r112 == null) goto L32;
            PatchInfo.ADAPTER.encodeWithTag(r100, 14, r112);
        L32:
            this.clean_resource_key_scene.encodeWithTag(r100, 15, r101.clean_resource_key_scene);
            Long r113 = r101.app_id;
            if (r113 == null) goto L35;
            ProtoAdapter.INT64.encodeWithTag(r100, 16, r113);
        L35:
            Long r114 = r101.bot_id;
            if (r114 == null) goto L38;
            ProtoAdapter.INT64.encodeWithTag(r100, 17, r114);
        L38:
            Url.ADAPTER.asRepeated().encodeWithTag(r100, 18, r101.json_card_urls);
            CardHeader r115 = r101.card_header;
            if (r115 == null) goto L41;
            CardHeader.ADAPTER.encodeWithTag(r100, 19, r115);
        L41:
            ActionDataSource r116 = r101.action_data_source;
            if (r116 == null) goto L44;
            ActionDataSource.ADAPTER.encodeWithTag(r100, 20, r116);
        L44:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UniversalCardEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum SourceType extends Enum<SourceType> implements WireEnum {
        private static final /* synthetic */ SourceType[] $VALUES = null;
        public static final ProtoAdapter<SourceType> ADAPTER = null;
        public static final SourceType PROFILE = null;
        public static final SourceType SOURCE_TYPE_UNKNOWN = null;
        public static final SourceType URL_PREVIEW = null;
        private final int value;

        static {
            SourceType r100 = new SourceType("SOURCE_TYPE_UNKNOWN", 0, 0);
            SOURCE_TYPE_UNKNOWN = r100;
            SourceType r101 = new SourceType("URL_PREVIEW", 1, 2);
            URL_PREVIEW = r101;
            SourceType r102 = new SourceType("PROFILE", 2, 4);
            PROFILE = r102;
            $VALUES = new SourceType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(SourceType.class);
        }

        public static SourceType[] values() {
            return (SourceType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SourceType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 2) goto L12;
            if (r100 == 4) goto L10;
            return null;
        L10:
            return PROFILE;
        L12:
            return URL_PREVIEW;
        L14:
            return SOURCE_TYPE_UNKNOWN;
        }

        public static SourceType valueOf(String r100) {
            return (SourceType) a.a(SourceType.class, r100);
        }

        private SourceType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class StreamingConfig extends com.squareup.wire.Message<StreamingConfig, Builder> {
        public static final ProtoAdapter<StreamingConfig> ADAPTER = null;
        public static final PrintStrategy DEFAULT_PRINT_STRATEGY = null;
        private static final long serialVersionUID = 0;
        public final PrintConfig print_frequency_ms;
        public final PrintConfig print_step;
        public final PrintStrategy print_strategy;

        public static final class Builder extends com.squareup.wire.Message.Builder<StreamingConfig, Builder> {
            public PrintConfig print_frequency_ms;
            public PrintConfig print_step;
            public PrintStrategy print_strategy;

            @Override // com.squareup.wire.Message.Builder
            public StreamingConfig build() {
                return new StreamingConfig(this.print_frequency_ms, this.print_step, this.print_strategy, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder print_frequency_ms(PrintConfig r100) {
                this.print_frequency_ms = r100;
                return this;
            }

            public Builder print_step(PrintConfig r100) {
                this.print_step = r100;
                return this;
            }

            public Builder print_strategy(PrintStrategy r100) {
                this.print_strategy = r100;
                return this;
            }
        }

        public static final class PrintConfig extends com.squareup.wire.Message<PrintConfig, Builder> {
            public static final ProtoAdapter<PrintConfig> ADAPTER = null;
            public static final Integer DEFAULT_ANDROID = null;
            public static final Integer DEFAULT_DEFAULT_ = null;
            public static final Integer DEFAULT_IOS = null;
            public static final Integer DEFAULT_PC = null;
            private static final long serialVersionUID = 0;

            /* JADX INFO: renamed from: android, reason: collision with root package name */
            public final Integer f253589android;
            public final Integer default_;
            public final Integer ios;

            /* JADX INFO: renamed from: pc, reason: collision with root package name */
            public final Integer f253590pc;

            public static final class Builder extends com.squareup.wire.Message.Builder<PrintConfig, Builder> {

                /* JADX INFO: renamed from: android, reason: collision with root package name */
                public Integer f253591android;
                public Integer default_;
                public Integer ios;

                /* JADX INFO: renamed from: pc, reason: collision with root package name */
                public Integer f253592pc;

                @Override // com.squareup.wire.Message.Builder
                public PrintConfig build() {
                    return new PrintConfig(this.default_, this.f253591android, this.ios, this.f253592pc, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder android(Integer r100) {
                    this.f253591android = r100;
                    return this;
                }

                public Builder default_(Integer r100) {
                    this.default_ = r100;
                    return this;
                }

                public Builder ios(Integer r100) {
                    this.ios = r100;
                    return this;
                }

                public Builder pc(Integer r100) {
                    this.f253592pc = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_PrintConfig extends ProtoAdapter<PrintConfig> {
                public ProtoAdapter_PrintConfig() {
                    super(FieldEncoding.LENGTH_DELIMITED, PrintConfig.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public PrintConfig decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.default_ = 0;
                    r101.f253591android = 0;
                    r101.ios = 0;
                    r101.f253592pc = 0;
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L18;
                    if (r103 != 1) goto L8;
                    r101.default_ = ProtoAdapter.INT32.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.f253591android = ProtoAdapter.INT32.decode(r100);
                    goto L3
                L10:
                    if (r103 != 3) goto L12;
                    r101.ios = ProtoAdapter.INT32.decode(r100);
                    goto L3
                L12:
                    if (r103 != 4) goto L13;
                    r101.f253592pc = ProtoAdapter.INT32.decode(r100);
                    goto L3
                L13:
                    FieldEncoding r104 = r100.peekFieldEncoding();
                    r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                    goto L3
                L18:
                    r100.endMessage(r102);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(PrintConfig r100) {
                    Integer r101 = r100.default_;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
                L6:
                    Integer r104 = r100.f253589android;
                    if (r104 == null) goto L9;
                    int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
                L10:
                    int r106 = r103 + r105;
                    Integer r107 = r100.ios;
                    if (r107 == null) goto L13;
                    int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
                L14:
                    int r109 = r106 + r108;
                    Integer r110 = r100.f253590pc;
                    if (r110 == null) goto L18;
                    r102 = ProtoAdapter.INT32.encodedSizeWithTag(4, r110);
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
                public /* bridge */ /* synthetic */ PrintConfig decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(PrintConfig r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, PrintConfig r101) throws IOException {
                    Integer r102 = r101.default_;
                    if (r102 == null) goto L5;
                    ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
                L5:
                    Integer r103 = r101.f253589android;
                    if (r103 == null) goto L8;
                    ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
                L8:
                    Integer r104 = r101.ios;
                    if (r104 == null) goto L11;
                    ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
                L11:
                    Integer r105 = r101.f253590pc;
                    if (r105 == null) goto L14;
                    ProtoAdapter.INT32.encodeWithTag(r100, 4, r105);
                L14:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PrintConfig r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_PrintConfig();
                DEFAULT_DEFAULT_ = 0;
                DEFAULT_ANDROID = 0;
                DEFAULT_IOS = 0;
                DEFAULT_PC = 0;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.default_ = this.default_;
                r100.f253591android = this.f253589android;
                r100.ios = this.ios;
                r100.f253592pc = this.f253590pc;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return PrintConfig.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public PrintConfig(Integer r100, Integer r101, Integer r102, Integer r110) {
                this(r100, r101, r102, r110, ByteString.EMPTY);
            }

            public PrintConfig(Integer r100, Integer r101, Integer r102, Integer r103, ByteString r104) {
                super(ADAPTER, r104);
                this.default_ = r100;
                this.f253589android = r101;
                this.ios = r102;
                this.f253590pc = r103;
            }
        }

        public static final class ProtoAdapter_StreamingConfig extends ProtoAdapter<StreamingConfig> {
            public ProtoAdapter_StreamingConfig() {
                super(FieldEncoding.LENGTH_DELIMITED, StreamingConfig.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public StreamingConfig decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.print_strategy = PrintStrategy.DEFAULT;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.print_frequency_ms = PrintConfig.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.print_step = PrintConfig.ADAPTER.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.print_strategy = PrintStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
            public int encodedSize2(StreamingConfig r100) {
                PrintConfig r101 = r100.print_frequency_ms;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = PrintConfig.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                PrintConfig r104 = r100.print_step;
                if (r104 == null) goto L9;
                int r105 = PrintConfig.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                PrintStrategy r107 = r100.print_strategy;
                if (r107 == null) goto L14;
                r102 = PrintStrategy.ADAPTER.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ StreamingConfig decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(StreamingConfig r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, StreamingConfig r101) throws IOException {
                PrintConfig r102 = r101.print_frequency_ms;
                if (r102 == null) goto L5;
                PrintConfig.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                PrintConfig r103 = r101.print_step;
                if (r103 == null) goto L8;
                PrintConfig.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                PrintStrategy r104 = r101.print_strategy;
                if (r104 == null) goto L11;
                PrintStrategy.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, StreamingConfig r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_StreamingConfig();
            DEFAULT_PRINT_STRATEGY = PrintStrategy.DEFAULT;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.print_frequency_ms = this.print_frequency_ms;
            r100.print_step = this.print_step;
            r100.print_strategy = this.print_strategy;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return StreamingConfig.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public StreamingConfig(PrintConfig r100, PrintConfig r101, PrintStrategy r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public StreamingConfig(PrintConfig r100, PrintConfig r101, PrintStrategy r102, ByteString r103) {
            super(ADAPTER, r103);
            this.print_frequency_ms = r100;
            this.print_step = r101;
            this.print_strategy = r102;
        }
    }

    public static final class SummaryContent extends com.squareup.wire.Message<SummaryContent, Builder> {
        public static final ProtoAdapter<SummaryContent> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<Item> items;

        public static final class Builder extends com.squareup.wire.Message.Builder<SummaryContent, Builder> {
            public List<Item> items;

            @Override // com.squareup.wire.Message.Builder
            public SummaryContent build() {
                return new SummaryContent(this.items, super.buildUnknownFields());
            }

            public Builder() {
                this.items = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder items(List<Item> r100) {
                Internal.checkElementsNotNull(r100);
                this.items = r100;
                return this;
            }
        }

        public static final class Item extends com.squareup.wire.Message<Item, Builder> {
            public static final ProtoAdapter<Item> ADAPTER = null;
            public static final String DEFAULT_TEXT = "";
            private static final long serialVersionUID = 0;
            public final RichTextElement.AtProperty at_user;
            public final Emotion emotion;
            public final I18NContent i18n_content;
            public final Image image;
            public final CharacterList person_list;
            public final String text;

            public static final class Builder extends com.squareup.wire.Message.Builder<Item, Builder> {
                public RichTextElement.AtProperty at_user;
                public Emotion emotion;
                public I18NContent i18n_content;
                public Image image;
                public CharacterList person_list;
                public String text;

                @Override // com.squareup.wire.Message.Builder
                public Item build() {
                    return new Item(this.text, this.image, this.at_user, this.emotion, this.person_list, this.i18n_content, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder at_user(RichTextElement.AtProperty r100) {
                    this.at_user = r100;
                    this.text = null;
                    this.image = null;
                    this.emotion = null;
                    this.person_list = null;
                    this.i18n_content = null;
                    return this;
                }

                public Builder emotion(Emotion r100) {
                    this.emotion = r100;
                    this.text = null;
                    this.image = null;
                    this.at_user = null;
                    this.person_list = null;
                    this.i18n_content = null;
                    return this;
                }

                public Builder i18n_content(I18NContent r100) {
                    this.i18n_content = r100;
                    this.text = null;
                    this.image = null;
                    this.at_user = null;
                    this.emotion = null;
                    this.person_list = null;
                    return this;
                }

                public Builder image(Image r100) {
                    this.image = r100;
                    this.text = null;
                    this.at_user = null;
                    this.emotion = null;
                    this.person_list = null;
                    this.i18n_content = null;
                    return this;
                }

                public Builder person_list(CharacterList r100) {
                    this.person_list = r100;
                    this.text = null;
                    this.image = null;
                    this.at_user = null;
                    this.emotion = null;
                    this.i18n_content = null;
                    return this;
                }

                public Builder text(String r100) {
                    this.text = r100;
                    this.image = null;
                    this.at_user = null;
                    this.emotion = null;
                    this.person_list = null;
                    this.i18n_content = null;
                    return this;
                }
            }

            public static final class CharacterList extends com.squareup.wire.Message<CharacterList, Builder> {
                public static final ProtoAdapter<CharacterList> ADAPTER = null;
                private static final long serialVersionUID = 0;
                public final List<Character> characters;

                public static final class Builder extends com.squareup.wire.Message.Builder<CharacterList, Builder> {
                    public List<Character> characters;

                    @Override // com.squareup.wire.Message.Builder
                    public CharacterList build() {
                        return new CharacterList(this.characters, super.buildUnknownFields());
                    }

                    public Builder() {
                        this.characters = Internal.newMutableList();
                    }

                    @Override // com.squareup.wire.Message.Builder
                    public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                        return build();
                    }

                    public Builder characters(List<Character> r100) {
                        Internal.checkElementsNotNull(r100);
                        this.characters = r100;
                        return this;
                    }
                }

                public static final class ProtoAdapter_CharacterList extends ProtoAdapter<CharacterList> {
                    public ProtoAdapter_CharacterList() {
                        super(FieldEncoding.LENGTH_DELIMITED, CharacterList.class);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.squareup.wire.ProtoAdapter
                    public CharacterList decode(ProtoReader r100) throws IOException {
                        Builder r101 = new Builder();
                        long r102 = r100.beginMessage();
                    L3:
                        int r103 = r100.nextTag();
                        if (r103 == (-1)) goto L9;
                        if (r103 != 1) goto L7;
                        r101.characters.add(Character.ADAPTER.decode(r100));
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
                    public int encodedSize2(CharacterList r100) {
                        return Character.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.characters) + r100.unknownFields().size();
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ CharacterList decode(ProtoReader r100) throws IOException {
                        return decode(r100);
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ int encodedSize(CharacterList r100) {
                        return encodedSize2(r100);
                    }

                    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                    public void encode2(ProtoWriter r100, CharacterList r101) throws IOException {
                        Character.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.characters);
                        r100.writeBytes(r101.unknownFields());
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CharacterList r101) throws IOException {
                        encode2(r100, r101);
                    }
                }

                static {
                    ADAPTER = new ProtoAdapter_CharacterList();
                }

                @Override // com.squareup.wire.Message
                public Builder newBuilder() {
                    Builder r100 = new Builder();
                    r100.characters = Internal.copyOf("characters", this.characters);
                    r100.addUnknownFields(unknownFields());
                    return r100;
                }

                @Override // com.squareup.wire.Message
                public String toString() {
                    return CharacterList.class.getName() + "@" + Integer.toHexString(hashCode());
                }

                @Override // com.squareup.wire.Message
                public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                    return newBuilder();
                }

                public CharacterList(List<Character> r100) {
                    this(r100, ByteString.EMPTY);
                }

                public CharacterList(List<Character> r100, ByteString r101) {
                    super(ADAPTER, r101);
                    this.characters = Internal.immutableCopyOf("characters", r100);
                }
            }

            public static final class Emotion extends com.squareup.wire.Message<Emotion, Builder> {
                public static final ProtoAdapter<Emotion> ADAPTER = null;
                public static final String DEFAULT_KEY = "";
                private static final long serialVersionUID = 0;
                public final String key;

                public static final class Builder extends com.squareup.wire.Message.Builder<Emotion, Builder> {
                    public String key;

                    @Override // com.squareup.wire.Message.Builder
                    public Emotion build() {
                        String r100 = this.key;
                        if (r100 == null) goto L7;
                        return new Emotion(this.key, super.buildUnknownFields());
                    L7:
                        throw Internal.missingRequiredFields(new Object[]{r100, "key"});
                    }

                    public Builder() {
                    }

                    @Override // com.squareup.wire.Message.Builder
                    public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                        return build();
                    }

                    public Builder key(String r100) {
                        this.key = r100;
                        return this;
                    }
                }

                public static final class ProtoAdapter_Emotion extends ProtoAdapter<Emotion> {
                    public ProtoAdapter_Emotion() {
                        super(FieldEncoding.LENGTH_DELIMITED, Emotion.class);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.squareup.wire.ProtoAdapter
                    public Emotion decode(ProtoReader r100) throws IOException {
                        Builder r101 = new Builder();
                        r101.key = "";
                        long r102 = r100.beginMessage();
                    L3:
                        int r103 = r100.nextTag();
                        if (r103 == (-1)) goto L9;
                        if (r103 != 1) goto L7;
                        r101.key = ProtoAdapter.STRING.decode(r100);
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
                    public int encodedSize2(Emotion r100) {
                        return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.key) + r100.unknownFields().size();
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ Emotion decode(ProtoReader r100) throws IOException {
                        return decode(r100);
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ int encodedSize(Emotion r100) {
                        return encodedSize2(r100);
                    }

                    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                    public void encode2(ProtoWriter r100, Emotion r101) throws IOException {
                        ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.key);
                        r100.writeBytes(r101.unknownFields());
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Emotion r101) throws IOException {
                        encode2(r100, r101);
                    }
                }

                static {
                    ADAPTER = new ProtoAdapter_Emotion();
                }

                @Override // com.squareup.wire.Message
                public Builder newBuilder() {
                    Builder r100 = new Builder();
                    r100.key = this.key;
                    r100.addUnknownFields(unknownFields());
                    return r100;
                }

                @Override // com.squareup.wire.Message
                public String toString() {
                    return Emotion.class.getName() + "@" + Integer.toHexString(hashCode());
                }

                @Override // com.squareup.wire.Message
                public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                    return newBuilder();
                }

                public Emotion(String r100) {
                    this(r100, ByteString.EMPTY);
                }

                public Emotion(String r100, ByteString r101) {
                    super(ADAPTER, r101);
                    this.key = r100;
                }
            }

            public static final class I18NContent extends com.squareup.wire.Message<I18NContent, Builder> {
                public static final ProtoAdapter<I18NContent> ADAPTER = null;
                public static final String DEFAULT_DEFAULTVALUE = "";
                public static final String DEFAULT_KEY = "";
                private static final long serialVersionUID = 0;
                public final String defaultValue;
                public final String key;

                public static final class Builder extends com.squareup.wire.Message.Builder<I18NContent, Builder> {
                    public String defaultValue;
                    public String key;

                    @Override // com.squareup.wire.Message.Builder
                    public I18NContent build() {
                        String r100 = this.key;
                        if (r100 == null) goto L7;
                        return new I18NContent(this.key, this.defaultValue, super.buildUnknownFields());
                    L7:
                        throw Internal.missingRequiredFields(new Object[]{r100, "key"});
                    }

                    public Builder() {
                    }

                    @Override // com.squareup.wire.Message.Builder
                    public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                        return build();
                    }

                    public Builder defaultValue(String r100) {
                        this.defaultValue = r100;
                        return this;
                    }

                    public Builder key(String r100) {
                        this.key = r100;
                        return this;
                    }
                }

                public static final class ProtoAdapter_I18NContent extends ProtoAdapter<I18NContent> {
                    public ProtoAdapter_I18NContent() {
                        super(FieldEncoding.LENGTH_DELIMITED, I18NContent.class);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.squareup.wire.ProtoAdapter
                    public I18NContent decode(ProtoReader r100) throws IOException {
                        Builder r101 = new Builder();
                        r101.key = "";
                        r101.defaultValue = "";
                        long r102 = r100.beginMessage();
                    L3:
                        int r103 = r100.nextTag();
                        if (r103 == (-1)) goto L12;
                        if (r103 != 1) goto L8;
                        r101.key = ProtoAdapter.STRING.decode(r100);
                        goto L3
                    L8:
                        if (r103 != 2) goto L9;
                        r101.defaultValue = ProtoAdapter.STRING.decode(r100);
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
                    public int encodedSize2(I18NContent r100) {
                        ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                        int r102 = r101.encodedSizeWithTag(1, r100.key);
                        String r103 = r100.defaultValue;
                        if (r103 == null) goto L5;
                        int r104 = r101.encodedSizeWithTag(2, r103);
                    L7:
                        return (r102 + r104) + r100.unknownFields().size();
                    L5:
                        r104 = 0;
                        goto L7
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ I18NContent decode(ProtoReader r100) throws IOException {
                        return decode(r100);
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ int encodedSize(I18NContent r100) {
                        return encodedSize2(r100);
                    }

                    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                    public void encode2(ProtoWriter r100, I18NContent r101) throws IOException {
                        ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                        r102.encodeWithTag(r100, 1, r101.key);
                        String r103 = r101.defaultValue;
                        if (r103 == null) goto L5;
                        r102.encodeWithTag(r100, 2, r103);
                    L5:
                        r100.writeBytes(r101.unknownFields());
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, I18NContent r101) throws IOException {
                        encode2(r100, r101);
                    }
                }

                static {
                    ADAPTER = new ProtoAdapter_I18NContent();
                }

                @Override // com.squareup.wire.Message
                public Builder newBuilder() {
                    Builder r100 = new Builder();
                    r100.key = this.key;
                    r100.defaultValue = this.defaultValue;
                    r100.addUnknownFields(unknownFields());
                    return r100;
                }

                @Override // com.squareup.wire.Message
                public String toString() {
                    return I18NContent.class.getName() + "@" + Integer.toHexString(hashCode());
                }

                @Override // com.squareup.wire.Message
                public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                    return newBuilder();
                }

                public I18NContent(String r100, String r101) {
                    this(r100, r101, ByteString.EMPTY);
                }

                public I18NContent(String r100, String r101, ByteString r102) {
                    super(ADAPTER, r102);
                    this.key = r100;
                    this.defaultValue = r101;
                }
            }

            public static final class Image extends com.squareup.wire.Message<Image, Builder> {
                public static final ProtoAdapter<Image> ADAPTER = null;
                private static final long serialVersionUID = 0;

                public static final class Builder extends com.squareup.wire.Message.Builder<Image, Builder> {
                    @Override // com.squareup.wire.Message.Builder
                    public Image build() {
                        return new Image(super.buildUnknownFields());
                    }

                    public Builder() {
                    }

                    @Override // com.squareup.wire.Message.Builder
                    public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                        return build();
                    }
                }

                public static final class ProtoAdapter_Image extends ProtoAdapter<Image> {
                    public ProtoAdapter_Image() {
                        super(FieldEncoding.LENGTH_DELIMITED, Image.class);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.squareup.wire.ProtoAdapter
                    public Image decode(ProtoReader r100) throws IOException {
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
                    public int encodedSize2(Image r100) {
                        return r100.unknownFields().size();
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ Image decode(ProtoReader r100) throws IOException {
                        return decode(r100);
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ int encodedSize(Image r100) {
                        return encodedSize2(r100);
                    }

                    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                    public void encode2(ProtoWriter r100, Image r101) throws IOException {
                        r100.writeBytes(r101.unknownFields());
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Image r101) throws IOException {
                        encode2(r100, r101);
                    }
                }

                static {
                    ADAPTER = new ProtoAdapter_Image();
                }

                public Image() {
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
                    return Image.class.getName() + "@" + Integer.toHexString(hashCode());
                }

                @Override // com.squareup.wire.Message
                public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                    return newBuilder();
                }

                public Image(ByteString r100) {
                    super(ADAPTER, r100);
                }
            }

            public static final class ProtoAdapter_Item extends ProtoAdapter<Item> {
                public ProtoAdapter_Item() {
                    super(FieldEncoding.LENGTH_DELIMITED, Item.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public Item decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.text("");
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L13;
                    switch(r103) {
                        case 1: goto L12;
                        case 2: goto L11;
                        case 3: goto L10;
                        case 4: goto L9;
                        case 5: goto L8;
                        case 6: goto L7;
                        default: goto L6;
                    };
                L7:
                    r101.i18n_content(I18NContent.ADAPTER.decode(r100));
                    goto L3
                L8:
                    r101.person_list(CharacterList.ADAPTER.decode(r100));
                    goto L3
                L9:
                    r101.emotion(Emotion.ADAPTER.decode(r100));
                    goto L3
                L10:
                    r101.at_user(RichTextElement.AtProperty.ADAPTER.decode(r100));
                    goto L3
                L11:
                    r101.image(Image.ADAPTER.decode(r100));
                    goto L3
                L12:
                    r101.text(ProtoAdapter.STRING.decode(r100));
                    goto L3
                L6:
                    FieldEncoding r104 = r100.peekFieldEncoding();
                    r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                    goto L3
                L13:
                    r100.endMessage(r102);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(Item r100) {
                    String r101 = r100.text;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
                L6:
                    Image r104 = r100.image;
                    if (r104 == null) goto L9;
                    int r105 = Image.ADAPTER.encodedSizeWithTag(2, r104);
                L10:
                    int r106 = r103 + r105;
                    RichTextElement.AtProperty r107 = r100.at_user;
                    if (r107 == null) goto L13;
                    int r108 = RichTextElement.AtProperty.ADAPTER.encodedSizeWithTag(3, r107);
                L14:
                    int r109 = r106 + r108;
                    Emotion r110 = r100.emotion;
                    if (r110 == null) goto L17;
                    int r111 = Emotion.ADAPTER.encodedSizeWithTag(4, r110);
                L18:
                    int r112 = r109 + r111;
                    CharacterList r113 = r100.person_list;
                    if (r113 == null) goto L21;
                    int r114 = CharacterList.ADAPTER.encodedSizeWithTag(5, r113);
                L22:
                    int r115 = r112 + r114;
                    I18NContent r116 = r100.i18n_content;
                    if (r116 == null) goto L26;
                    r102 = I18NContent.ADAPTER.encodedSizeWithTag(6, r116);
                L26:
                    return (r115 + r102) + r100.unknownFields().size();
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
                public /* bridge */ /* synthetic */ Item decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(Item r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, Item r101) throws IOException {
                    String r102 = r101.text;
                    if (r102 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
                L5:
                    Image r103 = r101.image;
                    if (r103 == null) goto L8;
                    Image.ADAPTER.encodeWithTag(r100, 2, r103);
                L8:
                    RichTextElement.AtProperty r104 = r101.at_user;
                    if (r104 == null) goto L11;
                    RichTextElement.AtProperty.ADAPTER.encodeWithTag(r100, 3, r104);
                L11:
                    Emotion r105 = r101.emotion;
                    if (r105 == null) goto L14;
                    Emotion.ADAPTER.encodeWithTag(r100, 4, r105);
                L14:
                    CharacterList r106 = r101.person_list;
                    if (r106 == null) goto L17;
                    CharacterList.ADAPTER.encodeWithTag(r100, 5, r106);
                L17:
                    I18NContent r107 = r101.i18n_content;
                    if (r107 == null) goto L20;
                    I18NContent.ADAPTER.encodeWithTag(r100, 6, r107);
                L20:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Item r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_Item();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.text = this.text;
                r100.image = this.image;
                r100.at_user = this.at_user;
                r100.emotion = this.emotion;
                r100.person_list = this.person_list;
                r100.i18n_content = this.i18n_content;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return Item.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public Item(String r100, Image r110, RichTextElement.AtProperty r111, Emotion r112, CharacterList r113, I18NContent r114) {
                this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
            }

            public Item(String r100, Image r101, RichTextElement.AtProperty r102, Emotion r103, CharacterList r104, I18NContent r105, ByteString r106) {
                super(ADAPTER, r106);
                if (Internal.countNonNull(r100, r101, r102, r103, new Object[]{r104, r105}) > 1) goto L7;
                this.text = r100;
                this.image = r101;
                this.at_user = r102;
                this.emotion = r103;
                this.person_list = r104;
                this.i18n_content = r105;
                return;
            L7:
                throw new IllegalArgumentException("at most one of text, image, at_user, emotion, person_list, i18n_content may be non-null");
            }
        }

        public static final class ProtoAdapter_SummaryContent extends ProtoAdapter<SummaryContent> {
            public ProtoAdapter_SummaryContent() {
                super(FieldEncoding.LENGTH_DELIMITED, SummaryContent.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SummaryContent decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.items.add(Item.ADAPTER.decode(r100));
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
            public int encodedSize2(SummaryContent r100) {
                return Item.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.items) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SummaryContent decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SummaryContent r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SummaryContent r101) throws IOException {
                Item.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.items);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SummaryContent r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SummaryContent();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.items = Internal.copyOf("items", this.items);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SummaryContent.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public SummaryContent(List<Item> r100) {
            this(r100, ByteString.EMPTY);
        }

        public SummaryContent(List<Item> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.items = Internal.immutableCopyOf("items", r100);
        }
    }

    public static final class Url extends com.squareup.wire.Message<Url, Builder> {
        public static final ProtoAdapter<Url> ADAPTER = null;
        public static final String DEFAULT_ANDROID_URL = "";
        public static final String DEFAULT_IOS_URL = "";
        public static final String DEFAULT_PC_URL = "";
        public static final String DEFAULT_URL = "";
        private static final long serialVersionUID = 0;
        public final String android_url;
        public final String ios_url;
        public final String pc_url;
        public final String url;

        public static final class Builder extends com.squareup.wire.Message.Builder<Url, Builder> {
            public String android_url;
            public String ios_url;
            public String pc_url;
            public String url;

            @Override // com.squareup.wire.Message.Builder
            public Url build() {
                return new Url(this.url, this.ios_url, this.android_url, this.pc_url, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder android_url(String r100) {
                this.android_url = r100;
                return this;
            }

            public Builder ios_url(String r100) {
                this.ios_url = r100;
                return this;
            }

            public Builder pc_url(String r100) {
                this.pc_url = r100;
                return this;
            }

            public Builder url(String r100) {
                this.url = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Url extends ProtoAdapter<Url> {
            public ProtoAdapter_Url() {
                super(FieldEncoding.LENGTH_DELIMITED, Url.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Url decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.url = "";
                r101.ios_url = "";
                r101.android_url = "";
                r101.pc_url = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.ios_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.android_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.pc_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Url r100) {
                String r101 = r100.url;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.ios_url;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.android_url;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.pc_url;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
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
            public /* bridge */ /* synthetic */ Url decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Url r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Url r101) throws IOException {
                String r102 = r101.url;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.ios_url;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.android_url;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.pc_url;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Url r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Url();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.url = this.url;
            r100.ios_url = this.ios_url;
            r100.android_url = this.android_url;
            r100.pc_url = this.pc_url;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Url.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Url(String r100, String r101, String r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public Url(String r100, String r101, String r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.url = r100;
            this.ios_url = r101;
            this.android_url = r102;
            this.pc_url = r103;
        }
    }

    public static final class VideoInfo extends com.squareup.wire.Message<VideoInfo, Builder> {
        public static final ProtoAdapter<VideoInfo> ADAPTER = null;
        public static final Integer DEFAULT_DURATION = null;
        public static final String DEFAULT_FS_UNIT = "";
        public static final String DEFAULT_KEY = "";
        public static final String DEFAULT_MIME = "";
        public static final Long DEFAULT_SIZE = null;
        public static final String DEFAULT_URL = "";
        private static final long serialVersionUID = 0;
        public final Integer duration;
        public final String fs_unit;
        public final String key;
        public final String mime;
        public final Long size;
        public final String url;
        public final CardVisitInfo visit_info;

        public static final class Builder extends com.squareup.wire.Message.Builder<VideoInfo, Builder> {
            public Integer duration;
            public String fs_unit;
            public String key;
            public String mime;
            public Long size;
            public String url;
            public CardVisitInfo visit_info;

            @Override // com.squareup.wire.Message.Builder
            public VideoInfo build() {
                return new VideoInfo(this.key, this.duration, this.size, this.url, this.mime, this.fs_unit, this.visit_info, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder duration(Integer r100) {
                this.duration = r100;
                return this;
            }

            public Builder fs_unit(String r100) {
                this.fs_unit = r100;
                return this;
            }

            public Builder key(String r100) {
                this.key = r100;
                return this;
            }

            public Builder mime(String r100) {
                this.mime = r100;
                return this;
            }

            public Builder size(Long r100) {
                this.size = r100;
                return this;
            }

            public Builder url(String r100) {
                this.url = r100;
                return this;
            }

            public Builder visit_info(CardVisitInfo r100) {
                this.visit_info = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_VideoInfo extends ProtoAdapter<VideoInfo> {
            public ProtoAdapter_VideoInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, VideoInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public VideoInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.key = "";
                r101.duration = 0;
                r101.size = 0L;
                r101.url = "";
                r101.mime = "";
                r101.fs_unit = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L14;
                switch(r103) {
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
                r101.visit_info = CardVisitInfo.ADAPTER.decode(r100);
                goto L3
            L8:
                r101.fs_unit = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                r101.mime = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.size = ProtoAdapter.INT64.decode(r100);
                goto L3
            L12:
                r101.duration = ProtoAdapter.INT32.decode(r100);
                goto L3
            L13:
                r101.key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L14:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(VideoInfo r100) {
                String r101 = r100.key;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.duration;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Long r107 = r100.size;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.url;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                String r113 = r100.mime;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                String r116 = r100.fs_unit;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                CardVisitInfo r119 = r100.visit_info;
                if (r119 == null) goto L30;
                r102 = CardVisitInfo.ADAPTER.encodedSizeWithTag(7, r119);
            L30:
                return (r118 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ VideoInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(VideoInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, VideoInfo r101) throws IOException {
                String r102 = r101.key;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.duration;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                Long r104 = r101.size;
                if (r104 == null) goto L11;
                ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.url;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                String r106 = r101.mime;
                if (r106 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
            L17:
                String r107 = r101.fs_unit;
                if (r107 == null) goto L20;
                ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
            L20:
                CardVisitInfo r108 = r101.visit_info;
                if (r108 == null) goto L23;
                CardVisitInfo.ADAPTER.encodeWithTag(r100, 7, r108);
            L23:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, VideoInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_VideoInfo();
            DEFAULT_DURATION = 0;
            DEFAULT_SIZE = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.key = this.key;
            r100.duration = this.duration;
            r100.size = this.size;
            r100.url = this.url;
            r100.mime = this.mime;
            r100.fs_unit = this.fs_unit;
            r100.visit_info = this.visit_info;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return VideoInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public VideoInfo(String r110, Integer r111, Long r112, String r113, String r114, String r115, CardVisitInfo r116) {
            this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
        }

        public VideoInfo(String r100, Integer r101, Long r102, String r103, String r104, String r105, CardVisitInfo r106, ByteString r107) {
            super(ADAPTER, r107);
            this.key = r100;
            this.duration = r101;
            this.size = r102;
            this.url = r103;
            this.mime = r104;
            this.fs_unit = r105;
            this.visit_info = r106;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UniversalCardEntity();
        DEFAULT_SOURCE_TYPE = 0;
        DEFAULT_STREAMING_MODE = Boolean.FALSE;
        DEFAULT_DATA_SOURCE = DataSource.IM;
        DEFAULT_DATA_TYPE = DataType.Card;
        DEFAULT_APP_ID = 0L;
        DEFAULT_BOT_ID = 0L;
        DEFAULT_ACTION_DATA_SOURCE = ActionDataSource.IM_CONTENT;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.card_id = this.card_id;
        r100.version = this.version;
        r100.content = this.content;
        r100.source_id = this.source_id;
        r100.source_type = this.source_type;
        r100.action_status = this.action_status;
        r100.action_url = this.action_url;
        r100.local_extra = Internal.copyOf("local_extra", this.local_extra);
        r100.app_info = this.app_info;
        r100.streaming_mode = this.streaming_mode;
        r100.data_source = this.data_source;
        r100.streaming_config = this.streaming_config;
        r100.data_type = this.data_type;
        r100.patch_info = this.patch_info;
        r100.clean_resource_key_scene = Internal.copyOf("clean_resource_key_scene", this.clean_resource_key_scene);
        r100.app_id = this.app_id;
        r100.bot_id = this.bot_id;
        r100.json_card_urls = Internal.copyOf("json_card_urls", this.json_card_urls);
        r100.card_header = this.card_header;
        r100.action_data_source = this.action_data_source;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UniversalCardEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public UniversalCardEntity(String r210, String r211, Content r212, String r213, Integer r214, ActionStatus r215, String r216, Map<Integer, String> r310, CardAppInfo r311, Boolean r312, DataSource r313, StreamingConfig r314, DataType r315, PatchInfo r316, Map<String, ResourceCleanScene> r317, Long r318, Long r319, List<Url> r410, CardHeader r411, ActionDataSource r412) {
        this(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, ByteString.EMPTY);
    }

    public UniversalCardEntity(String r100, String r101, Content r102, String r103, Integer r104, ActionStatus r105, String r110, Map<Integer, String> r111, CardAppInfo r112, Boolean r113, DataSource r114, StreamingConfig r115, DataType r116, PatchInfo r117, Map<String, ResourceCleanScene> r118, Long r119, Long r210, List<Url> r211, CardHeader r212, ActionDataSource r213, ByteString r214) {
        super(ADAPTER, r214);
        this.card_id = r100;
        this.version = r101;
        this.content = r102;
        this.source_id = r103;
        this.source_type = r104;
        this.action_status = r105;
        this.action_url = r110;
        this.local_extra = Internal.immutableCopyOf("local_extra", r111);
        this.app_info = r112;
        this.streaming_mode = r113;
        this.data_source = r114;
        this.streaming_config = r115;
        this.data_type = r116;
        this.patch_info = r117;
        this.clean_resource_key_scene = Internal.immutableCopyOf("clean_resource_key_scene", r118);
        this.app_id = r119;
        this.bot_id = r210;
        this.json_card_urls = Internal.immutableCopyOf("json_card_urls", r211);
        this.card_header = r212;
        this.action_data_source = r213;
    }
}
