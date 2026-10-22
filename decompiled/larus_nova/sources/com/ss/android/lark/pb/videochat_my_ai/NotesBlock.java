package com.ss.android.lark.pb.videochat_my_ai;

import com.android.ttcjpaysdk.bdpay.counter.outer.preload.DyOuterPayPreloadManager;
import com.larus.bmhome.chat.bean.SuggestActionType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.ImageSetV2;
import com.ss.android.lark.pb.entities.RichText;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class NotesBlock extends Message<NotesBlock, Builder> {
    public static final ProtoAdapter<NotesBlock> ADAPTER = null;
    public static final String DEFAULT_AI_CONTENT_MARKDOWN = "";
    public static final Long DEFAULT_AUDIO_LOCATION_TIME = null;
    public static final Long DEFAULT_CID = null;
    public static final Long DEFAULT_CLIENT_CREATE_TIME = null;
    public static final Long DEFAULT_CREATE_REL_AUDIO_TIME = null;
    public static final Long DEFAULT_CREATE_REL_MEETING_TIME = null;
    public static final Boolean DEFAULT_DELETED = null;
    public static final String DEFAULT_INPUT_CONTENT_MARKDOWN = "";
    public static final String DEFAULT_MARK_ID = "";
    public static final Boolean DEFAULT_POLISH_ENABLED = null;
    public static final Long DEFAULT_SERVICE_TIME = null;
    public static final Long DEFAULT_SID = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final RichText mai_content;
    public final String mai_content_markdown;
    public final Long maudio_location_time;
    public final Long mcid;
    public final Long mclient_create_time;
    public final PolishContentState mcontent_state;
    public final Long mcreate_rel_audio_time;
    public final Long mcreate_rel_meeting_time;
    public final CreateSource mcreate_source;
    public final Boolean mdeleted;
    public final List<ImageSetV2> mfull_images;
    public final List<String> mimages;
    public final ImageInfo mimages_v2;
    public final RichText minput_content;
    public final String minput_content_markdown;
    public final String mmark_id;
    public final NoteType mnote_type;
    public final Boolean mpolish_enabled;
    public final Long mservice_time;
    public final Long msid;
    public final Long mversion;

    public static final class Builder extends Message.Builder<NotesBlock, Builder> {
        public RichText mai_content;
        public String mai_content_markdown;
        public Long maudio_location_time;
        public Long mcid;
        public Long mclient_create_time;
        public PolishContentState mcontent_state;
        public Long mcreate_rel_audio_time;
        public Long mcreate_rel_meeting_time;
        public CreateSource mcreate_source;
        public Boolean mdeleted;
        public List<ImageSetV2> mfull_images;
        public List<String> mimages;
        public ImageInfo mimages_v2;
        public RichText minput_content;
        public String minput_content_markdown;
        public String mmark_id;
        public NoteType mnote_type;
        public Boolean mpolish_enabled;
        public Long mservice_time;
        public Long msid;
        public Long mversion;

        @Override // com.squareup.wire.Message.Builder
        public NotesBlock build() {
            return new NotesBlock(this.minput_content, this.mcid, this.msid, this.mclient_create_time, this.mservice_time, this.mai_content, this.mnote_type, this.mversion, this.mpolish_enabled, this.mdeleted, this.mimages, this.mcontent_state, this.mcreate_rel_meeting_time, this.mcreate_rel_audio_time, this.minput_content_markdown, this.mai_content_markdown, this.maudio_location_time, this.mmark_id, this.mfull_images, this.mcreate_source, this.mimages_v2, super.buildUnknownFields());
        }

        public Builder() {
            this.mimages = Internal.newMutableList();
            this.mfull_images = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ai_content(RichText r100) {
            this.mai_content = r100;
            return this;
        }

        public Builder ai_content_markdown(String r100) {
            this.mai_content_markdown = r100;
            return this;
        }

        public Builder audio_location_time(Long r100) {
            this.maudio_location_time = r100;
            return this;
        }

        public Builder cid(Long r100) {
            this.mcid = r100;
            return this;
        }

        public Builder client_create_time(Long r100) {
            this.mclient_create_time = r100;
            return this;
        }

        public Builder content_state(PolishContentState r100) {
            this.mcontent_state = r100;
            return this;
        }

        public Builder create_rel_audio_time(Long r100) {
            this.mcreate_rel_audio_time = r100;
            return this;
        }

        public Builder create_rel_meeting_time(Long r100) {
            this.mcreate_rel_meeting_time = r100;
            return this;
        }

        public Builder create_source(CreateSource r100) {
            this.mcreate_source = r100;
            return this;
        }

        public Builder deleted(Boolean r100) {
            this.mdeleted = r100;
            return this;
        }

        public Builder full_images(List<ImageSetV2> r100) {
            Internal.checkElementsNotNull(r100);
            this.mfull_images = r100;
            return this;
        }

        public Builder images(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mimages = r100;
            return this;
        }

        public Builder images_v2(ImageInfo r100) {
            this.mimages_v2 = r100;
            return this;
        }

        public Builder input_content(RichText r100) {
            this.minput_content = r100;
            return this;
        }

        public Builder input_content_markdown(String r100) {
            this.minput_content_markdown = r100;
            return this;
        }

        public Builder mark_id(String r100) {
            this.mmark_id = r100;
            return this;
        }

        public Builder note_type(NoteType r100) {
            this.mnote_type = r100;
            return this;
        }

        public Builder polish_enabled(Boolean r100) {
            this.mpolish_enabled = r100;
            return this;
        }

        public Builder service_time(Long r100) {
            this.mservice_time = r100;
            return this;
        }

        public Builder sid(Long r100) {
            this.msid = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.mversion = r100;
            return this;
        }
    }

    public static final enum CreateSource extends Enum<CreateSource> implements WireEnum {
        private static final /* synthetic */ CreateSource[] $VALUES = null;
        public static final ProtoAdapter<CreateSource> ADAPTER = null;
        public static final CreateSource AI_VISION_HIGHLIGHT = null;
        public static final CreateSource EMPTY_STATE = null;
        public static final CreateSource HIGHLIGHT = null;
        public static final CreateSource INPUT = null;
        public static final CreateSource PHOTO = null;
        public static final CreateSource SUBTITLE_HIGHLIGHT = null;
        private final int value;

        static {
            CreateSource r100 = new CreateSource("INPUT", 0, 0);
            INPUT = r100;
            CreateSource r101 = new CreateSource("HIGHLIGHT", 1, 1);
            HIGHLIGHT = r101;
            CreateSource r102 = new CreateSource(SuggestActionType.PHOTO, 2, 2);
            PHOTO = r102;
            CreateSource r103 = new CreateSource("SUBTITLE_HIGHLIGHT", 3, 3);
            SUBTITLE_HIGHLIGHT = r103;
            CreateSource r104 = new CreateSource("AI_VISION_HIGHLIGHT", 4, 4);
            AI_VISION_HIGHLIGHT = r104;
            CreateSource r105 = new CreateSource("EMPTY_STATE", 5, 5);
            EMPTY_STATE = r105;
            $VALUES = new CreateSource[]{r100, r101, r102, r103, r104, r105};
            ADAPTER = ProtoAdapter.newEnumAdapter(CreateSource.class);
        }

        public static CreateSource[] values() {
            return (CreateSource[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static CreateSource fromValue(int r100) {
            if (r100 == 0) goto L26;
            if (r100 == 1) goto L24;
            if (r100 == 2) goto L22;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L18;
            if (r100 == 5) goto L16;
            return null;
        L16:
            return EMPTY_STATE;
        L18:
            return AI_VISION_HIGHLIGHT;
        L20:
            return SUBTITLE_HIGHLIGHT;
        L22:
            return PHOTO;
        L24:
            return HIGHLIGHT;
        L26:
            return INPUT;
        }

        public static CreateSource valueOf(String r100) {
            return (CreateSource) a.a(CreateSource.class, r100);
        }

        private CreateSource(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ImageInfo extends Message<ImageInfo, Builder> {
        public static final ProtoAdapter<ImageInfo> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> mimages;

        public static final class Builder extends Message.Builder<ImageInfo, Builder> {
            public List<String> mimages;

            @Override // com.squareup.wire.Message.Builder
            public ImageInfo build() {
                return new ImageInfo(this.mimages, super.buildUnknownFields());
            }

            public Builder() {
                this.mimages = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder images(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.mimages = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ImageInfo extends ProtoAdapter<ImageInfo> {
            public ProtoAdapter_ImageInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, ImageInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ImageInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.mimages.add(ProtoAdapter.STRING.decode(r100));
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
            public int encodedSize2(ImageInfo r100) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.mimages) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ImageInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ImageInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ImageInfo r101) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.mimages);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ImageInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ImageInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mimages = Internal.copyOf("mimages", this.mimages);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ImageInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ImageInfo(List<String> r100) {
            this(r100, ByteString.EMPTY);
        }

        public ImageInfo(List<String> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.mimages = Internal.immutableCopyOf("mimages", r100);
        }
    }

    public static final enum NoteType extends Enum<NoteType> implements WireEnum {
        private static final /* synthetic */ NoteType[] $VALUES = null;
        public static final ProtoAdapter<NoteType> ADAPTER = null;
        public static final NoteType FISH_BONE_CHART = null;
        public static final NoteType FISH_BONE_TEXT = null;
        public static final NoteType HARDWARE_MARK = null;
        public static final NoteType HARDWARE_MARK_OFFLINE = null;
        public static final NoteType REGULAR = null;
        public static final NoteType SOFTWARE_MARK = null;
        public static final NoteType SUBTITLE = null;
        private final int value;

        static {
            NoteType r100 = new NoteType("REGULAR", 0, 0);
            REGULAR = r100;
            NoteType r101 = new NoteType("SOFTWARE_MARK", 1, 1);
            SOFTWARE_MARK = r101;
            NoteType r102 = new NoteType("HARDWARE_MARK", 2, 2);
            HARDWARE_MARK = r102;
            NoteType r103 = new NoteType("SUBTITLE", 3, 3);
            SUBTITLE = r103;
            NoteType r104 = new NoteType("FISH_BONE_TEXT", 4, 4);
            FISH_BONE_TEXT = r104;
            NoteType r105 = new NoteType("FISH_BONE_CHART", 5, 5);
            FISH_BONE_CHART = r105;
            NoteType r110 = new NoteType("HARDWARE_MARK_OFFLINE", 6, 6);
            HARDWARE_MARK_OFFLINE = r110;
            $VALUES = new NoteType[]{r100, r101, r102, r103, r104, r105, r110};
            ADAPTER = ProtoAdapter.newEnumAdapter(NoteType.class);
        }

        public static NoteType[] values() {
            return (NoteType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static NoteType fromValue(int r100) {
            switch(r100) {
                case 0: goto L18;
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return HARDWARE_MARK_OFFLINE;
        L8:
            return FISH_BONE_CHART;
        L10:
            return FISH_BONE_TEXT;
        L12:
            return SUBTITLE;
        L14:
            return HARDWARE_MARK;
        L16:
            return SOFTWARE_MARK;
        L18:
            return REGULAR;
        }

        public static NoteType valueOf(String r100) {
            return (NoteType) a.a(NoteType.class, r100);
        }

        private NoteType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum PolishContentState extends Enum<PolishContentState> implements WireEnum {
        private static final /* synthetic */ PolishContentState[] $VALUES = null;
        public static final ProtoAdapter<PolishContentState> ADAPTER = null;
        public static final PolishContentState EDITING = null;
        public static final PolishContentState FINISH = null;
        public static final PolishContentState NEED = null;
        public static final PolishContentState NO_NEED = null;
        public static final PolishContentState REVERTED = null;
        public static final PolishContentState USE = null;
        private final int value;

        static {
            PolishContentState r100 = new PolishContentState("NEED", 0, 0);
            NEED = r100;
            PolishContentState r101 = new PolishContentState("NO_NEED", 1, 1);
            NO_NEED = r101;
            PolishContentState r102 = new PolishContentState("FINISH", 2, 2);
            FINISH = r102;
            PolishContentState r103 = new PolishContentState("REVERTED", 3, 3);
            REVERTED = r103;
            PolishContentState r104 = new PolishContentState(DyOuterPayPreloadManager.VIEW_TAG, 4, 4);
            USE = r104;
            PolishContentState r105 = new PolishContentState("EDITING", 5, 5);
            EDITING = r105;
            $VALUES = new PolishContentState[]{r100, r101, r102, r103, r104, r105};
            ADAPTER = ProtoAdapter.newEnumAdapter(PolishContentState.class);
        }

        public static PolishContentState[] values() {
            return (PolishContentState[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static PolishContentState fromValue(int r100) {
            if (r100 == 0) goto L26;
            if (r100 == 1) goto L24;
            if (r100 == 2) goto L22;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L18;
            if (r100 == 5) goto L16;
            return null;
        L16:
            return EDITING;
        L18:
            return USE;
        L20:
            return REVERTED;
        L22:
            return FINISH;
        L24:
            return NO_NEED;
        L26:
            return NEED;
        }

        public static PolishContentState valueOf(String r100) {
            return (PolishContentState) a.a(PolishContentState.class, r100);
        }

        private PolishContentState(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_NotesBlock extends ProtoAdapter<NotesBlock> {
        public ProtoAdapter_NotesBlock() {
            super(FieldEncoding.LENGTH_DELIMITED, NotesBlock.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public NotesBlock decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mcid = 0L;
            r101.msid = 0L;
            r101.mclient_create_time = 0L;
            r101.mservice_time = 0L;
            r101.mversion = 0L;
            Boolean r102 = Boolean.FALSE;
            r101.mpolish_enabled = r102;
            r101.mdeleted = r102;
            r101.mcreate_rel_meeting_time = 0L;
            r101.mcreate_rel_audio_time = 0L;
            r101.minput_content_markdown = "";
            r101.mai_content_markdown = "";
            r101.maudio_location_time = 0L;
            r101.mmark_id = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L37;
            switch(r104) {
                case 1: goto L36;
                case 2: goto L35;
                case 3: goto L34;
                case 4: goto L33;
                case 5: goto L32;
                case 6: goto L31;
                case 7: goto L41;
                case 8: goto L26;
                case 9: goto L25;
                case 10: goto L24;
                case 11: goto L23;
                case 12: goto L43;
                case 13: goto L18;
                case 14: goto L17;
                case 15: goto L16;
                case 16: goto L15;
                case 17: goto L14;
                case 18: goto L13;
                case 19: goto L12;
                case 20: goto L39;
                case 21: goto L7;
                default: goto L6;
            };
        L39:
            r101.mcreate_source = CreateSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L41:
            r101.mnote_type = NoteType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L29
        L29:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L43:
            r101.mcontent_state = PolishContentState.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mimages_v2 = ImageInfo.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.mfull_images.add(ImageSetV2.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.mmark_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.maudio_location_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            r101.mai_content_markdown = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.minput_content_markdown = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.mcreate_rel_audio_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L18:
            r101.mcreate_rel_meeting_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L23:
            r101.mimages.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L24:
            r101.mdeleted = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L25:
            r101.mpolish_enabled = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L26:
            r101.mversion = ProtoAdapter.INT64.decode(r100);
            goto L3
        L31:
            r101.mai_content = RichText.ADAPTER.decode(r100);
            goto L3
        L32:
            r101.mservice_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L33:
            r101.mclient_create_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L34:
            r101.msid = ProtoAdapter.INT64.decode(r100);
            goto L3
        L35:
            r101.mcid = ProtoAdapter.INT64.decode(r100);
            goto L3
        L36:
            r101.minput_content = RichText.ADAPTER.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L37:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(NotesBlock r100) {
            RichText r101 = r100.minput_content;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = RichText.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.mcid;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.msid;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.mclient_create_time;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.mservice_time;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT64.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            RichText r116 = r100.mai_content;
            if (r116 == null) goto L25;
            int r117 = RichText.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            NoteType r119 = r100.mnote_type;
            if (r119 == null) goto L29;
            int r120 = NoteType.ADAPTER.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Long r122 = r100.mversion;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.INT64.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            Boolean r125 = r100.mpolish_enabled;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            Boolean r128 = r100.mdeleted;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            ProtoAdapter<String> r131 = ProtoAdapter.STRING;
            int r132 = r130 + r131.asRepeated().encodedSizeWithTag(11, r100.mimages);
            PolishContentState r133 = r100.mcontent_state;
            if (r133 == null) goto L45;
            int r134 = PolishContentState.ADAPTER.encodedSizeWithTag(12, r133);
        L46:
            int r135 = r132 + r134;
            Long r136 = r100.mcreate_rel_meeting_time;
            if (r136 == null) goto L49;
            int r137 = ProtoAdapter.INT64.encodedSizeWithTag(13, r136);
        L50:
            int r138 = r135 + r137;
            Long r139 = r100.mcreate_rel_audio_time;
            if (r139 == null) goto L53;
            int r140 = ProtoAdapter.INT64.encodedSizeWithTag(14, r139);
        L54:
            int r141 = r138 + r140;
            String r142 = r100.minput_content_markdown;
            if (r142 == null) goto L57;
            int r143 = r131.encodedSizeWithTag(15, r142);
        L58:
            int r144 = r141 + r143;
            String r145 = r100.mai_content_markdown;
            if (r145 == null) goto L61;
            int r146 = r131.encodedSizeWithTag(16, r145);
        L62:
            int r147 = r144 + r146;
            Long r148 = r100.maudio_location_time;
            if (r148 == null) goto L65;
            int r149 = ProtoAdapter.INT64.encodedSizeWithTag(17, r148);
        L66:
            int r150 = r147 + r149;
            String r151 = r100.mmark_id;
            if (r151 == null) goto L69;
            int r152 = r131.encodedSizeWithTag(18, r151);
        L70:
            int r153 = (r150 + r152) + ImageSetV2.ADAPTER.asRepeated().encodedSizeWithTag(19, r100.mfull_images);
            CreateSource r154 = r100.mcreate_source;
            if (r154 == null) goto L73;
            int r155 = CreateSource.ADAPTER.encodedSizeWithTag(20, r154);
        L74:
            int r156 = r153 + r155;
            ImageInfo r157 = r100.mimages_v2;
            if (r157 == null) goto L78;
            r102 = ImageInfo.ADAPTER.encodedSizeWithTag(21, r157);
        L78:
            return (r156 + r102) + r100.unknownFields().size();
        L73:
            r155 = 0;
            goto L74
        L69:
            r152 = 0;
            goto L70
        L65:
            r149 = 0;
            goto L66
        L61:
            r146 = 0;
            goto L62
        L57:
            r143 = 0;
            goto L58
        L53:
            r140 = 0;
            goto L54
        L49:
            r137 = 0;
            goto L50
        L45:
            r134 = 0;
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
        public /* bridge */ /* synthetic */ NotesBlock decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(NotesBlock r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, NotesBlock r101) throws IOException {
            RichText r102 = r101.minput_content;
            if (r102 == null) goto L5;
            RichText.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.mcid;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.msid;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.mclient_create_time;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            Long r106 = r101.mservice_time;
            if (r106 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r106);
        L17:
            RichText r107 = r101.mai_content;
            if (r107 == null) goto L20;
            RichText.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            NoteType r108 = r101.mnote_type;
            if (r108 == null) goto L23;
            NoteType.ADAPTER.encodeWithTag(r100, 7, r108);
        L23:
            Long r109 = r101.mversion;
            if (r109 == null) goto L26;
            ProtoAdapter.INT64.encodeWithTag(r100, 8, r109);
        L26:
            Boolean r110 = r101.mpolish_enabled;
            if (r110 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r110);
        L29:
            Boolean r111 = r101.mdeleted;
            if (r111 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r100, 10, r111);
        L32:
            ProtoAdapter<String> r112 = ProtoAdapter.STRING;
            r112.asRepeated().encodeWithTag(r100, 11, r101.mimages);
            PolishContentState r113 = r101.mcontent_state;
            if (r113 == null) goto L35;
            PolishContentState.ADAPTER.encodeWithTag(r100, 12, r113);
        L35:
            Long r114 = r101.mcreate_rel_meeting_time;
            if (r114 == null) goto L38;
            ProtoAdapter.INT64.encodeWithTag(r100, 13, r114);
        L38:
            Long r115 = r101.mcreate_rel_audio_time;
            if (r115 == null) goto L41;
            ProtoAdapter.INT64.encodeWithTag(r100, 14, r115);
        L41:
            String r116 = r101.minput_content_markdown;
            if (r116 == null) goto L44;
            r112.encodeWithTag(r100, 15, r116);
        L44:
            String r117 = r101.mai_content_markdown;
            if (r117 == null) goto L47;
            r112.encodeWithTag(r100, 16, r117);
        L47:
            Long r118 = r101.maudio_location_time;
            if (r118 == null) goto L50;
            ProtoAdapter.INT64.encodeWithTag(r100, 17, r118);
        L50:
            String r119 = r101.mmark_id;
            if (r119 == null) goto L53;
            r112.encodeWithTag(r100, 18, r119);
        L53:
            ImageSetV2.ADAPTER.asRepeated().encodeWithTag(r100, 19, r101.mfull_images);
            CreateSource r120 = r101.mcreate_source;
            if (r120 == null) goto L56;
            CreateSource.ADAPTER.encodeWithTag(r100, 20, r120);
        L56:
            ImageInfo r121 = r101.mimages_v2;
            if (r121 == null) goto L59;
            ImageInfo.ADAPTER.encodeWithTag(r100, 21, r121);
        L59:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, NotesBlock r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_NotesBlock();
        DEFAULT_CID = 0L;
        DEFAULT_SID = 0L;
        DEFAULT_CLIENT_CREATE_TIME = 0L;
        DEFAULT_SERVICE_TIME = 0L;
        DEFAULT_VERSION = 0L;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_POLISH_ENABLED = r100;
        DEFAULT_DELETED = r100;
        DEFAULT_CREATE_REL_MEETING_TIME = 0L;
        DEFAULT_CREATE_REL_AUDIO_TIME = 0L;
        DEFAULT_AUDIO_LOCATION_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.minput_content = this.minput_content;
        r100.mcid = this.mcid;
        r100.msid = this.msid;
        r100.mclient_create_time = this.mclient_create_time;
        r100.mservice_time = this.mservice_time;
        r100.mai_content = this.mai_content;
        r100.mnote_type = this.mnote_type;
        r100.mversion = this.mversion;
        r100.mpolish_enabled = this.mpolish_enabled;
        r100.mdeleted = this.mdeleted;
        r100.mimages = Internal.copyOf("mimages", this.mimages);
        r100.mcontent_state = this.mcontent_state;
        r100.mcreate_rel_meeting_time = this.mcreate_rel_meeting_time;
        r100.mcreate_rel_audio_time = this.mcreate_rel_audio_time;
        r100.minput_content_markdown = this.minput_content_markdown;
        r100.mai_content_markdown = this.mai_content_markdown;
        r100.maudio_location_time = this.maudio_location_time;
        r100.mmark_id = this.mmark_id;
        r100.mfull_images = Internal.copyOf("mfull_images", this.mfull_images);
        r100.mcreate_source = this.mcreate_source;
        r100.mimages_v2 = this.mimages_v2;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return NotesBlock.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public NotesBlock(RichText r210, Long r211, Long r212, Long r213, Long r214, RichText r215, NoteType r310, Long r311, Boolean r312, Boolean r313, List<String> r314, PolishContentState r315, Long r316, Long r317, String r318, String r319, Long r410, String r411, List<ImageSetV2> r412, CreateSource r413, ImageInfo r414) {
        this(r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, ByteString.EMPTY);
    }

    public NotesBlock(RichText r100, Long r101, Long r102, Long r103, Long r104, RichText r105, NoteType r110, Long r111, Boolean r112, Boolean r113, List<String> r114, PolishContentState r115, Long r116, Long r117, String r118, String r119, Long r210, String r211, List<ImageSetV2> r212, CreateSource r213, ImageInfo r214, ByteString r215) {
        super(ADAPTER, r215);
        this.minput_content = r100;
        this.mcid = r101;
        this.msid = r102;
        this.mclient_create_time = r103;
        this.mservice_time = r104;
        this.mai_content = r105;
        this.mnote_type = r110;
        this.mversion = r111;
        this.mpolish_enabled = r112;
        this.mdeleted = r113;
        this.mimages = Internal.immutableCopyOf("mimages", r114);
        this.mcontent_state = r115;
        this.mcreate_rel_meeting_time = r116;
        this.mcreate_rel_audio_time = r117;
        this.minput_content_markdown = r118;
        this.mai_content_markdown = r119;
        this.maudio_location_time = r210;
        this.mmark_id = r211;
        this.mfull_images = Internal.immutableCopyOf("mfull_images", r212);
        this.mcreate_source = r213;
        this.mimages_v2 = r214;
    }
}
