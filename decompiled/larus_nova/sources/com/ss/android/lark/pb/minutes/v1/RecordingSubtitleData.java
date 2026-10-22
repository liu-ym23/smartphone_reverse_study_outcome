package com.ss.android.lark.pb.minutes.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes37.dex */
public final class RecordingSubtitleData extends Message<RecordingSubtitleData, Builder> {
    public static final ProtoAdapter<RecordingSubtitleData> ADAPTER = null;
    public static final Long DEFAULT_ABSOLUTE_TIMESTAMP = null;
    public static final Boolean DEFAULT_DELETE_SEGMENT = null;
    public static final Long DEFAULT_FIRST_WORD_START_TIME = null;
    public static final Boolean DEFAULT_IS_PARTIAL = null;
    public static final Boolean DEFAULT_IS_SEG_FINAL = null;
    public static final Long DEFAULT_SEG_ID = null;
    public static final String DEFAULT_SESSION_ID = "";
    public static final Boolean DEFAULT_SHOW_EDIT_SPEAKER_BUTTON = null;
    public static final Long DEFAULT_SLICE_ID = null;
    public static final SoundType DEFAULT_SOUND_TYPE = null;
    public static final Long DEFAULT_TIMESTAMP = null;
    public static final Boolean DEFAULT_TRACK_RECEIVED = null;
    public static final ProtoAdapter_RecordingSubtitleData RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long absolute_timestamp;
    public final Boolean delete_segment;
    public final Long first_word_start_time;
    public final Boolean is_partial;
    public final Boolean is_seg_final;
    public final Long seg_id;
    public final String session_id;
    public final Boolean show_edit_speaker_button;
    public final Long slice_id;
    public final SoundType sound_type;
    public final Subtitle source;
    public final SSDSpeaker ssd_speaker;
    public final Subtitle target;
    public final Long timestamp;
    public final Boolean track_received;

    public static final class Builder extends Message.Builder<RecordingSubtitleData, Builder> implements d<RecordingSubtitleData> {
        public Long absolute_timestamp;
        public Boolean delete_segment;
        public Long first_word_start_time;
        public Boolean is_partial;
        public Boolean is_seg_final;
        public Long seg_id;
        public String session_id;
        public Boolean show_edit_speaker_button;
        public Long slice_id;
        public SoundType sound_type;
        public Subtitle source;
        public SSDSpeaker ssd_speaker;
        public Subtitle target;
        public Long timestamp;
        public Boolean track_received;

        @Override // com.squareup.wire.Message.Builder
        public RecordingSubtitleData build() {
            String r100 = this.session_id;
            if (r100 == null) goto L9;
            if (this.seg_id == null) goto L9;
            return new RecordingSubtitleData(this.session_id, this.seg_id, this.source, this.target, this.timestamp, this.slice_id, this.is_seg_final, this.track_received, this.sound_type, this.is_partial, this.absolute_timestamp, this.ssd_speaker, this.first_word_start_time, this.show_edit_speaker_button, this.delete_segment, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "session_id", this.seg_id, "seg_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder absolute_timestamp(Long r100) {
            this.absolute_timestamp = r100;
            return this;
        }

        public Builder delete_segment(Boolean r100) {
            this.delete_segment = r100;
            return this;
        }

        public Builder first_word_start_time(Long r100) {
            this.first_word_start_time = r100;
            return this;
        }

        public Builder is_partial(Boolean r100) {
            this.is_partial = r100;
            return this;
        }

        public Builder is_seg_final(Boolean r100) {
            this.is_seg_final = r100;
            return this;
        }

        public Builder seg_id(Long r100) {
            this.seg_id = r100;
            return this;
        }

        public Builder session_id(String r100) {
            this.session_id = r100;
            return this;
        }

        public Builder show_edit_speaker_button(Boolean r100) {
            this.show_edit_speaker_button = r100;
            return this;
        }

        public Builder slice_id(Long r100) {
            this.slice_id = r100;
            return this;
        }

        public Builder sound_type(SoundType r100) {
            this.sound_type = r100;
            return this;
        }

        public Builder source(Subtitle r100) {
            this.source = r100;
            return this;
        }

        public Builder ssd_speaker(SSDSpeaker r100) {
            this.ssd_speaker = r100;
            return this;
        }

        public Builder target(Subtitle r100) {
            this.target = r100;
            return this;
        }

        public Builder timestamp(Long r100) {
            this.timestamp = r100;
            return this;
        }

        public Builder track_received(Boolean r100) {
            this.track_received = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RecordingSubtitleData extends ProtoAdapter<RecordingSubtitleData> implements c<RecordingSubtitleData> {
        public ProtoAdapter_RecordingSubtitleData() {
            super(FieldEncoding.LENGTH_DELIMITED, RecordingSubtitleData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RecordingSubtitleData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.session_id = "";
            r101.seg_id = 0L;
            r101.timestamp = 0L;
            r101.slice_id = 0L;
            Boolean r102 = Boolean.FALSE;
            r101.is_seg_final = r102;
            r101.track_received = r102;
            r101.sound_type = SoundType.NORMAL;
            r101.is_partial = r102;
            r101.absolute_timestamp = 0L;
            r101.first_word_start_time = 0L;
            r101.show_edit_speaker_button = r102;
            r101.delete_segment = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L43;
            if (r104 != 1) goto L8;
            r101.session_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.seg_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r104 != 12) goto L12;
            r101.sound_type = SoundType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L39
        L39:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r104 != 13) goto L14;
            r101.is_partial = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            if (r104 != 16) goto L16;
            r101.absolute_timestamp = ProtoAdapter.INT64.decode(r100);
            goto L3
        L16:
            if (r104 != 17) goto L18;
            r101.ssd_speaker = SSDSpeaker.ADAPTER.decode(r100);
            goto L3
        L18:
            if (r104 != 23) goto L20;
            r101.first_word_start_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L20:
            if (r104 != 24) goto L22;
            r101.show_edit_speaker_button = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L22:
            if (r104 != 26) goto L23;
            r101.delete_segment = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L23:
            switch(r104) {
                case 4: goto L30;
                case 5: goto L29;
                case 6: goto L28;
                case 7: goto L27;
                case 8: goto L26;
                case 9: goto L25;
                default: goto L24;
            };
        L25:
            r101.track_received = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L26:
            r101.is_seg_final = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L27:
            r101.slice_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L28:
            r101.timestamp = ProtoAdapter.INT64.decode(r100);
            goto L3
        L29:
            r101.target = Subtitle.ADAPTER.decode(r100);
            goto L3
        L30:
            r101.source = Subtitle.ADAPTER.decode(r100);
            goto L3
        L24:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L43:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(RecordingSubtitleData r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.session_id);
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            int r103 = r101 + r102.encodedSizeWithTag(2, r100.seg_id);
            Subtitle r104 = r100.source;
            int r105 = 0;
            if (r104 == null) goto L5;
            int r106 = Subtitle.ADAPTER.encodedSizeWithTag(4, r104);
        L6:
            int r107 = r103 + r106;
            Subtitle r108 = r100.target;
            if (r108 == null) goto L9;
            int r109 = Subtitle.ADAPTER.encodedSizeWithTag(5, r108);
        L10:
            int r110 = r107 + r109;
            Long r111 = r100.timestamp;
            if (r111 == null) goto L13;
            int r112 = r102.encodedSizeWithTag(6, r111);
        L14:
            int r113 = r110 + r112;
            Long r114 = r100.slice_id;
            if (r114 == null) goto L17;
            int r115 = r102.encodedSizeWithTag(7, r114);
        L18:
            int r116 = r113 + r115;
            Boolean r117 = r100.is_seg_final;
            if (r117 == null) goto L21;
            int r118 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r117);
        L22:
            int r119 = r116 + r118;
            Boolean r120 = r100.track_received;
            if (r120 == null) goto L25;
            int r121 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r120);
        L26:
            int r122 = r119 + r121;
            SoundType r123 = r100.sound_type;
            if (r123 == null) goto L29;
            int r124 = SoundType.ADAPTER.encodedSizeWithTag(12, r123);
        L30:
            int r125 = r122 + r124;
            Boolean r126 = r100.is_partial;
            if (r126 == null) goto L33;
            int r127 = ProtoAdapter.BOOL.encodedSizeWithTag(13, r126);
        L34:
            int r128 = r125 + r127;
            Long r129 = r100.absolute_timestamp;
            if (r129 == null) goto L37;
            int r130 = r102.encodedSizeWithTag(16, r129);
        L38:
            int r131 = r128 + r130;
            SSDSpeaker r132 = r100.ssd_speaker;
            if (r132 == null) goto L41;
            int r133 = SSDSpeaker.ADAPTER.encodedSizeWithTag(17, r132);
        L42:
            int r134 = r131 + r133;
            Long r135 = r100.first_word_start_time;
            if (r135 == null) goto L45;
            int r136 = r102.encodedSizeWithTag(23, r135);
        L46:
            int r137 = r134 + r136;
            Boolean r138 = r100.show_edit_speaker_button;
            if (r138 == null) goto L49;
            int r139 = ProtoAdapter.BOOL.encodedSizeWithTag(24, r138);
        L50:
            int r140 = r137 + r139;
            Boolean r141 = r100.delete_segment;
            if (r141 == null) goto L54;
            r105 = ProtoAdapter.BOOL.encodedSizeWithTag(26, r141);
        L54:
            return (r140 + r105) + r100.unknownFields().size();
        L49:
            r139 = 0;
            goto L50
        L45:
            r136 = 0;
            goto L46
        L41:
            r133 = 0;
            goto L42
        L37:
            r130 = 0;
            goto L38
        L33:
            r127 = 0;
            goto L34
        L29:
            r124 = 0;
            goto L30
        L25:
            r121 = 0;
            goto L26
        L21:
            r118 = 0;
            goto L22
        L17:
            r115 = 0;
            goto L18
        L13:
            r112 = 0;
            goto L14
        L9:
            r109 = 0;
            goto L10
        L5:
            r106 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RecordingSubtitleData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RecordingSubtitleData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RecordingSubtitleData r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.session_id);
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 2, r101.seg_id);
            Subtitle r103 = r101.source;
            if (r103 == null) goto L5;
            Subtitle.ADAPTER.encodeWithTag(r100, 4, r103);
        L5:
            Subtitle r104 = r101.target;
            if (r104 == null) goto L8;
            Subtitle.ADAPTER.encodeWithTag(r100, 5, r104);
        L8:
            Long r105 = r101.timestamp;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 6, r105);
        L11:
            Long r106 = r101.slice_id;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 7, r106);
        L14:
            Boolean r107 = r101.is_seg_final;
            if (r107 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r107);
        L17:
            Boolean r108 = r101.track_received;
            if (r108 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r108);
        L20:
            SoundType r109 = r101.sound_type;
            if (r109 == null) goto L23;
            SoundType.ADAPTER.encodeWithTag(r100, 12, r109);
        L23:
            Boolean r110 = r101.is_partial;
            if (r110 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 13, r110);
        L26:
            Long r111 = r101.absolute_timestamp;
            if (r111 == null) goto L29;
            r102.encodeWithTag(r100, 16, r111);
        L29:
            SSDSpeaker r112 = r101.ssd_speaker;
            if (r112 == null) goto L32;
            SSDSpeaker.ADAPTER.encodeWithTag(r100, 17, r112);
        L32:
            Long r113 = r101.first_word_start_time;
            if (r113 == null) goto L35;
            r102.encodeWithTag(r100, 23, r113);
        L35:
            Boolean r114 = r101.show_edit_speaker_button;
            if (r114 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r100, 24, r114);
        L38:
            Boolean r115 = r101.delete_segment;
            if (r115 == null) goto L41;
            ProtoAdapter.BOOL.encodeWithTag(r100, 26, r115);
        L41:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RecordingSubtitleData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class SSDSpeaker extends Message<SSDSpeaker, Builder> {
        public static final ProtoAdapter<SSDSpeaker> ADAPTER = null;
        public static final String DEFAULT_SPEAKER_INFO_SOURCE = "";
        public static final String DEFAULT_SPEAKER_USER_ID = "";
        public static final String DEFAULT_USER_ID = "";
        public static final SSDSpeakerUserType DEFAULT_USER_TYPE = null;
        private static final long serialVersionUID = 0;
        public final String speaker_info_source;
        public final String speaker_user_id;
        public final String user_id;
        public final SSDSpeakerUserType user_type;

        public static final class Builder extends Message.Builder<SSDSpeaker, Builder> {
            public String speaker_info_source;
            public String speaker_user_id;
            public String user_id;
            public SSDSpeakerUserType user_type;

            @Override // com.squareup.wire.Message.Builder
            public SSDSpeaker build() {
                return new SSDSpeaker(this.speaker_user_id, this.user_id, this.user_type, this.speaker_info_source, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder speaker_info_source(String r100) {
                this.speaker_info_source = r100;
                return this;
            }

            public Builder speaker_user_id(String r100) {
                this.speaker_user_id = r100;
                return this;
            }

            public Builder user_id(String r100) {
                this.user_id = r100;
                return this;
            }

            public Builder user_type(SSDSpeakerUserType r100) {
                this.user_type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SSDSpeaker extends ProtoAdapter<SSDSpeaker> {
            public ProtoAdapter_SSDSpeaker() {
                super(FieldEncoding.LENGTH_DELIMITED, SSDSpeaker.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SSDSpeaker decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.speaker_user_id = "";
                r101.user_id = "";
                r101.user_type = SSDSpeakerUserType.UNKNOWN;
                r101.speaker_info_source = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.speaker_user_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 3) goto L10;
                r101.user_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 4) goto L12;
                r101.user_type = SSDSpeakerUserType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            L17:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L12:
                if (r103 != 5) goto L13;
                r101.speaker_info_source = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(SSDSpeaker r100) {
                String r101 = r100.speaker_user_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.user_id;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(3, r104);
            L10:
                int r106 = r103 + r105;
                SSDSpeakerUserType r107 = r100.user_type;
                if (r107 == null) goto L13;
                int r108 = SSDSpeakerUserType.ADAPTER.encodedSizeWithTag(4, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.speaker_info_source;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(5, r110);
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
            public /* bridge */ /* synthetic */ SSDSpeaker decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SSDSpeaker r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SSDSpeaker r101) throws IOException {
                String r102 = r101.speaker_user_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.user_id;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
            L8:
                SSDSpeakerUserType r104 = r101.user_type;
                if (r104 == null) goto L11;
                SSDSpeakerUserType.ADAPTER.encodeWithTag(r100, 4, r104);
            L11:
                String r105 = r101.speaker_info_source;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SSDSpeaker r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum SSDSpeakerUserType extends Enum<SSDSpeakerUserType> implements WireEnum {
            private static final /* synthetic */ SSDSpeakerUserType[] $VALUES = null;
            public static final ProtoAdapter<SSDSpeakerUserType> ADAPTER = null;
            public static final SSDSpeakerUserType LARK_USER = null;
            public static final SSDSpeakerUserType UNKNOWN = null;
            private final int value;

            static {
                SSDSpeakerUserType r100 = new SSDSpeakerUserType("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                SSDSpeakerUserType r101 = new SSDSpeakerUserType("LARK_USER", 1, 1);
                LARK_USER = r101;
                $VALUES = new SSDSpeakerUserType[]{r100, r101};
                ADAPTER = ProtoAdapter.newEnumAdapter(SSDSpeakerUserType.class);
            }

            public static SSDSpeakerUserType[] values() {
                return (SSDSpeakerUserType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static SSDSpeakerUserType fromValue(int r100) {
                if (r100 == 0) goto L10;
                if (r100 == 1) goto L8;
                return null;
            L8:
                return LARK_USER;
            L10:
                return UNKNOWN;
            }

            public static SSDSpeakerUserType valueOf(String r100) {
                return (SSDSpeakerUserType) a.a(SSDSpeakerUserType.class, r100);
            }

            private SSDSpeakerUserType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SSDSpeaker();
            DEFAULT_USER_TYPE = SSDSpeakerUserType.UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.speaker_user_id = this.speaker_user_id;
            r100.user_id = this.user_id;
            r100.user_type = this.user_type;
            r100.speaker_info_source = this.speaker_info_source;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SSDSpeaker.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SSDSpeaker(String r100, String r101, SSDSpeakerUserType r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public SSDSpeaker(String r100, String r101, SSDSpeakerUserType r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.speaker_user_id = r100;
            this.user_id = r101;
            this.user_type = r102;
            this.speaker_info_source = r103;
        }
    }

    public static final enum SoundType extends Enum<SoundType> implements WireEnum {
        private static final /* synthetic */ SoundType[] $VALUES = null;
        public static final ProtoAdapter<SoundType> ADAPTER = null;
        public static final SoundType NOISE = null;
        public static final SoundType NORMAL = null;
        private final int value;

        static {
            SoundType r100 = new SoundType(EffectConstants.NORMAL, 0, 1);
            NORMAL = r100;
            SoundType r101 = new SoundType("NOISE", 1, 2);
            NOISE = r101;
            $VALUES = new SoundType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(SoundType.class);
        }

        public static SoundType[] values() {
            return (SoundType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SoundType fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return NOISE;
        L11:
            return NORMAL;
        }

        public static SoundType valueOf(String r100) {
            return (SoundType) a.a(SoundType.class, r100);
        }

        private SoundType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Subtitle extends Message<Subtitle, Builder> {
        public static final ProtoAdapter<Subtitle> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final String DEFAULT_LANGUAGE = "";
        public static final Boolean DEFAULT_TRACK_ARRIVAL = null;
        private static final long serialVersionUID = 0;
        public final String content;
        public final String language;
        public final Punctuation punctuation;
        public final ByteviewUser speaker;
        public final Boolean track_arrival;

        public static final class Builder extends Message.Builder<Subtitle, Builder> {
            public String content;
            public String language;
            public Punctuation punctuation;
            public ByteviewUser speaker;
            public Boolean track_arrival;

            @Override // com.squareup.wire.Message.Builder
            public Subtitle build() {
                String r100 = this.content;
                if (r100 == null) goto L9;
                if (this.language == null) goto L9;
                return new Subtitle(this.content, this.language, this.speaker, this.punctuation, this.track_arrival, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "content", this.language, "language"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder content(String r100) {
                this.content = r100;
                return this;
            }

            public Builder language(String r100) {
                this.language = r100;
                return this;
            }

            public Builder punctuation(Punctuation r100) {
                this.punctuation = r100;
                return this;
            }

            public Builder speaker(ByteviewUser r100) {
                this.speaker = r100;
                return this;
            }

            public Builder track_arrival(Boolean r100) {
                this.track_arrival = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Subtitle extends ProtoAdapter<Subtitle> {
            public ProtoAdapter_Subtitle() {
                super(FieldEncoding.LENGTH_DELIMITED, Subtitle.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Subtitle decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.content = "";
                r101.language = "";
                r101.track_arrival = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.content = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.language = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 5) goto L12;
                r101.speaker = ByteviewUser.ADAPTER.decode(r100);
                goto L3
            L12:
                if (r103 != 8) goto L14;
                r101.punctuation = Punctuation.ADAPTER.decode(r100);
                goto L3
            L14:
                if (r103 != 11) goto L15;
                r101.track_arrival = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(Subtitle r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = r101.encodedSizeWithTag(1, r100.content) + r101.encodedSizeWithTag(2, r100.language);
                ByteviewUser r103 = r100.speaker;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = ByteviewUser.ADAPTER.encodedSizeWithTag(5, r103);
            L6:
                int r106 = r102 + r105;
                Punctuation r107 = r100.punctuation;
                if (r107 == null) goto L9;
                int r108 = Punctuation.ADAPTER.encodedSizeWithTag(8, r107);
            L10:
                int r109 = r106 + r108;
                Boolean r110 = r100.track_arrival;
                if (r110 == null) goto L14;
                r104 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r110);
            L14:
                return (r109 + r104) + r100.unknownFields().size();
            L9:
                r108 = 0;
                goto L10
            L5:
                r105 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Subtitle decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Subtitle r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Subtitle r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.content);
                r102.encodeWithTag(r100, 2, r101.language);
                ByteviewUser r103 = r101.speaker;
                if (r103 == null) goto L5;
                ByteviewUser.ADAPTER.encodeWithTag(r100, 5, r103);
            L5:
                Punctuation r104 = r101.punctuation;
                if (r104 == null) goto L8;
                Punctuation.ADAPTER.encodeWithTag(r100, 8, r104);
            L8:
                Boolean r105 = r101.track_arrival;
                if (r105 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 11, r105);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Subtitle r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final class Punctuation extends Message<Punctuation, Builder> {
            public static final ProtoAdapter<Punctuation> ADAPTER = null;
            private static final long serialVersionUID = 0;
            public final List<Long> word_ends;

            public static final class Builder extends Message.Builder<Punctuation, Builder> {
                public List<Long> word_ends;

                @Override // com.squareup.wire.Message.Builder
                public Punctuation build() {
                    return new Punctuation(this.word_ends, super.buildUnknownFields());
                }

                public Builder() {
                    this.word_ends = Internal.newMutableList();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder word_ends(List<Long> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.word_ends = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_Punctuation extends ProtoAdapter<Punctuation> {
                public ProtoAdapter_Punctuation() {
                    super(FieldEncoding.LENGTH_DELIMITED, Punctuation.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public Punctuation decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L9;
                    if (r103 != 2) goto L7;
                    r101.word_ends.add(ProtoAdapter.INT64.decode(r100));
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
                public int encodedSize2(Punctuation r100) {
                    return ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(2, r100.word_ends) + r100.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ Punctuation decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(Punctuation r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, Punctuation r101) throws IOException {
                    ProtoAdapter.INT64.asRepeated().encodeWithTag(r100, 2, r101.word_ends);
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Punctuation r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_Punctuation();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.word_ends = Internal.copyOf("word_ends", this.word_ends);
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return Punctuation.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public Punctuation(List<Long> r100) {
                this(r100, ByteString.EMPTY);
            }

            public Punctuation(List<Long> r100, ByteString r101) {
                super(ADAPTER, r101);
                this.word_ends = Internal.immutableCopyOf("word_ends", r100);
            }
        }

        public static final class SubtitleLanguage extends Message<SubtitleLanguage, Builder> {
            public static final ProtoAdapter<SubtitleLanguage> ADAPTER = null;
            public static final String DEFAULT_DESCRIPTION_KEY = "";
            public static final String DEFAULT_LANGUAGE = "";
            private static final long serialVersionUID = 0;
            public final String description_key;
            public final String language;

            public static final class Builder extends Message.Builder<SubtitleLanguage, Builder> {
                public String description_key;
                public String language;

                @Override // com.squareup.wire.Message.Builder
                public SubtitleLanguage build() {
                    String r100 = this.language;
                    if (r100 == null) goto L9;
                    if (this.description_key == null) goto L9;
                    return new SubtitleLanguage(this.language, this.description_key, super.buildUnknownFields());
                L9:
                    throw Internal.missingRequiredFields(new Object[]{r100, "language", this.description_key, "description_key"});
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder description_key(String r100) {
                    this.description_key = r100;
                    return this;
                }

                public Builder language(String r100) {
                    this.language = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_SubtitleLanguage extends ProtoAdapter<SubtitleLanguage> {
                public ProtoAdapter_SubtitleLanguage() {
                    super(FieldEncoding.LENGTH_DELIMITED, SubtitleLanguage.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public SubtitleLanguage decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.language = "";
                    r101.description_key = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L12;
                    if (r103 != 1) goto L8;
                    r101.language = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L9;
                    r101.description_key = ProtoAdapter.STRING.decode(r100);
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
                public int encodedSize2(SubtitleLanguage r100) {
                    ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                    return (r101.encodedSizeWithTag(1, r100.language) + r101.encodedSizeWithTag(2, r100.description_key)) + r100.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ SubtitleLanguage decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(SubtitleLanguage r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, SubtitleLanguage r101) throws IOException {
                    ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                    r102.encodeWithTag(r100, 1, r101.language);
                    r102.encodeWithTag(r100, 2, r101.description_key);
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SubtitleLanguage r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_SubtitleLanguage();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.language = this.language;
                r100.description_key = this.description_key;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return SubtitleLanguage.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public SubtitleLanguage(String r100, String r101) {
                this(r100, r101, ByteString.EMPTY);
            }

            public SubtitleLanguage(String r100, String r101, ByteString r102) {
                super(ADAPTER, r102);
                this.language = r100;
                this.description_key = r101;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Subtitle();
            DEFAULT_TRACK_ARRIVAL = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.content = this.content;
            r100.language = this.language;
            r100.speaker = this.speaker;
            r100.punctuation = this.punctuation;
            r100.track_arrival = this.track_arrival;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Subtitle.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Subtitle(String r100, String r101, ByteviewUser r110, Punctuation r111, Boolean r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public Subtitle(String r100, String r101, ByteviewUser r102, Punctuation r103, Boolean r104, ByteString r105) {
            super(ADAPTER, r105);
            this.content = r100;
            this.language = r101;
            this.speaker = r102;
            this.punctuation = r103;
            this.track_arrival = r104;
        }
    }

    static {
        ProtoAdapter_RecordingSubtitleData r100 = new ProtoAdapter_RecordingSubtitleData();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SEG_ID = 0L;
        DEFAULT_TIMESTAMP = 0L;
        DEFAULT_SLICE_ID = 0L;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_IS_SEG_FINAL = r101;
        DEFAULT_TRACK_RECEIVED = r101;
        DEFAULT_SOUND_TYPE = SoundType.NORMAL;
        DEFAULT_IS_PARTIAL = r101;
        DEFAULT_ABSOLUTE_TIMESTAMP = 0L;
        DEFAULT_FIRST_WORD_START_TIME = 0L;
        DEFAULT_SHOW_EDIT_SPEAKER_BUTTON = r101;
        DEFAULT_DELETE_SEGMENT = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.session_id = this.session_id;
        r100.seg_id = this.seg_id;
        r100.source = this.source;
        r100.target = this.target;
        r100.timestamp = this.timestamp;
        r100.slice_id = this.slice_id;
        r100.is_seg_final = this.is_seg_final;
        r100.track_received = this.track_received;
        r100.sound_type = this.sound_type;
        r100.is_partial = this.is_partial;
        r100.absolute_timestamp = this.absolute_timestamp;
        r100.ssd_speaker = this.ssd_speaker;
        r100.first_word_start_time = this.first_word_start_time;
        r100.show_edit_speaker_button = this.show_edit_speaker_button;
        r100.delete_segment = this.delete_segment;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RecordingSubtitleData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public RecordingSubtitleData(String r110, Long r111, Subtitle r210, Subtitle r211, Long r212, Long r213, Boolean r214, Boolean r215, SoundType r216, Boolean r217, Long r218, SSDSpeaker r219, Long r310, Boolean r311, Boolean r312) {
        this(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, ByteString.EMPTY);
    }

    public RecordingSubtitleData(String r100, Long r101, Subtitle r102, Subtitle r103, Long r104, Long r105, Boolean r110, Boolean r111, SoundType r112, Boolean r113, Long r114, SSDSpeaker r115, Long r116, Boolean r117, Boolean r118, ByteString r119) {
        super(ADAPTER, r119);
        this.session_id = r100;
        this.seg_id = r101;
        this.source = r102;
        this.target = r103;
        this.timestamp = r104;
        this.slice_id = r105;
        this.is_seg_final = r110;
        this.track_received = r111;
        this.sound_type = r112;
        this.is_partial = r113;
        this.absolute_timestamp = r114;
        this.ssd_speaker = r115;
        this.first_word_start_time = r116;
        this.show_edit_speaker_button = r117;
        this.delete_segment = r118;
    }
}
