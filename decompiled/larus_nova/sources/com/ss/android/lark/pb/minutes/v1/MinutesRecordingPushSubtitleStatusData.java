package com.ss.android.lark.pb.minutes.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes37.dex */
public final class MinutesRecordingPushSubtitleStatusData extends Message<MinutesRecordingPushSubtitleStatusData, Builder> {
    public static final ProtoAdapter<MinutesRecordingPushSubtitleStatusData> ADAPTER = null;
    public static final Status DEFAULT_STATUS = null;
    public static final ProtoAdapter_MinutesRecordingPushSubtitleStatusData RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final SimultaneousInterpretationSpokenLanguageChange simultaneous_interpretation_spoken_language_change;
    public final Status status;
    public final SubtitleTranslationChange subtitle_translation_change;

    public static final class Builder extends Message.Builder<MinutesRecordingPushSubtitleStatusData, Builder> implements d<MinutesRecordingPushSubtitleStatusData> {
        public SimultaneousInterpretationSpokenLanguageChange simultaneous_interpretation_spoken_language_change;
        public Status status;
        public SubtitleTranslationChange subtitle_translation_change;

        @Override // com.squareup.wire.Message.Builder
        public MinutesRecordingPushSubtitleStatusData build() {
            Status r100 = this.status;
            if (r100 == null) goto L7;
            return new MinutesRecordingPushSubtitleStatusData(this.status, this.subtitle_translation_change, this.simultaneous_interpretation_spoken_language_change, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "status"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder simultaneous_interpretation_spoken_language_change(SimultaneousInterpretationSpokenLanguageChange r100) {
            this.simultaneous_interpretation_spoken_language_change = r100;
            return this;
        }

        public Builder status(Status r100) {
            this.status = r100;
            return this;
        }

        public Builder subtitle_translation_change(SubtitleTranslationChange r100) {
            this.subtitle_translation_change = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MinutesRecordingPushSubtitleStatusData extends ProtoAdapter<MinutesRecordingPushSubtitleStatusData> implements c<MinutesRecordingPushSubtitleStatusData> {
        public ProtoAdapter_MinutesRecordingPushSubtitleStatusData() {
            super(FieldEncoding.LENGTH_DELIMITED, MinutesRecordingPushSubtitleStatusData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MinutesRecordingPushSubtitleStatusData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.status = Status.STATUS_UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.status = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 11) goto L10;
            r101.subtitle_translation_change = SubtitleTranslationChange.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 12) goto L11;
            r101.simultaneous_interpretation_spoken_language_change = SimultaneousInterpretationSpokenLanguageChange.ADAPTER.decode(r100);
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
        public int encodedSize2(MinutesRecordingPushSubtitleStatusData r100) {
            int r101 = Status.ADAPTER.encodedSizeWithTag(1, r100.status);
            SubtitleTranslationChange r102 = r100.subtitle_translation_change;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = SubtitleTranslationChange.ADAPTER.encodedSizeWithTag(11, r102);
        L6:
            int r105 = r101 + r104;
            SimultaneousInterpretationSpokenLanguageChange r106 = r100.simultaneous_interpretation_spoken_language_change;
            if (r106 == null) goto L10;
            r103 = SimultaneousInterpretationSpokenLanguageChange.ADAPTER.encodedSizeWithTag(12, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MinutesRecordingPushSubtitleStatusData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MinutesRecordingPushSubtitleStatusData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MinutesRecordingPushSubtitleStatusData r101) throws IOException {
            Status.ADAPTER.encodeWithTag(r100, 1, r101.status);
            SubtitleTranslationChange r102 = r101.subtitle_translation_change;
            if (r102 == null) goto L5;
            SubtitleTranslationChange.ADAPTER.encodeWithTag(r100, 11, r102);
        L5:
            SimultaneousInterpretationSpokenLanguageChange r103 = r101.simultaneous_interpretation_spoken_language_change;
            if (r103 == null) goto L8;
            SimultaneousInterpretationSpokenLanguageChange.ADAPTER.encodeWithTag(r100, 12, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MinutesRecordingPushSubtitleStatusData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class SimultaneousInterpretationSpokenLanguageChange extends Message<SimultaneousInterpretationSpokenLanguageChange, Builder> {
        public static final ProtoAdapter<SimultaneousInterpretationSpokenLanguageChange> ADAPTER = null;
        public static final String DEFAULT_SPOKEN_LANGUAGE = "";
        private static final long serialVersionUID = 0;
        public final String spoken_language;

        public static final class Builder extends Message.Builder<SimultaneousInterpretationSpokenLanguageChange, Builder> {
            public String spoken_language;

            @Override // com.squareup.wire.Message.Builder
            public SimultaneousInterpretationSpokenLanguageChange build() {
                String r100 = this.spoken_language;
                if (r100 == null) goto L7;
                return new SimultaneousInterpretationSpokenLanguageChange(this.spoken_language, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "spoken_language"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder spoken_language(String r100) {
                this.spoken_language = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SimultaneousInterpretationSpokenLanguageChange extends ProtoAdapter<SimultaneousInterpretationSpokenLanguageChange> {
            public ProtoAdapter_SimultaneousInterpretationSpokenLanguageChange() {
                super(FieldEncoding.LENGTH_DELIMITED, SimultaneousInterpretationSpokenLanguageChange.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SimultaneousInterpretationSpokenLanguageChange decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.spoken_language = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.spoken_language = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(SimultaneousInterpretationSpokenLanguageChange r100) {
                return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.spoken_language) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SimultaneousInterpretationSpokenLanguageChange decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SimultaneousInterpretationSpokenLanguageChange r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SimultaneousInterpretationSpokenLanguageChange r101) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.spoken_language);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SimultaneousInterpretationSpokenLanguageChange r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SimultaneousInterpretationSpokenLanguageChange();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.spoken_language = this.spoken_language;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SimultaneousInterpretationSpokenLanguageChange.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SimultaneousInterpretationSpokenLanguageChange(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public SimultaneousInterpretationSpokenLanguageChange(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.spoken_language = r100;
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status SIMULTANEOUS_SPOKEN_LANGUAGE_NOT_SUPPORT = null;
        public static final Status STATUS_UNKNOWN = null;
        public static final Status SUBTITLE_TRANSLATION_CHANGE = null;
        private final int value;

        static {
            Status r100 = new Status("STATUS_UNKNOWN", 0, 0);
            STATUS_UNKNOWN = r100;
            Status r101 = new Status("SUBTITLE_TRANSLATION_CHANGE", 1, 15);
            SUBTITLE_TRANSLATION_CHANGE = r101;
            Status r102 = new Status("SIMULTANEOUS_SPOKEN_LANGUAGE_NOT_SUPPORT", 2, 16);
            SIMULTANEOUS_SPOKEN_LANGUAGE_NOT_SUPPORT = r102;
            $VALUES = new Status[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Status fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 15) goto L12;
            if (r100 == 16) goto L10;
            return null;
        L10:
            return SIMULTANEOUS_SPOKEN_LANGUAGE_NOT_SUPPORT;
        L12:
            return SUBTITLE_TRANSLATION_CHANGE;
        L14:
            return STATUS_UNKNOWN;
        }

        public static Status valueOf(String r100) {
            return (Status) a.a(Status.class, r100);
        }

        private Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class SubtitleTranslationChange extends Message<SubtitleTranslationChange, Builder> {
        public static final ProtoAdapter<SubtitleTranslationChange> ADAPTER = null;
        public static final String DEFAULT_LANGUAGE = "";
        private static final long serialVersionUID = 0;
        public final String language;

        public static final class Builder extends Message.Builder<SubtitleTranslationChange, Builder> {
            public String language;

            @Override // com.squareup.wire.Message.Builder
            public SubtitleTranslationChange build() {
                String r100 = this.language;
                if (r100 == null) goto L7;
                return new SubtitleTranslationChange(this.language, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "language"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder language(String r100) {
                this.language = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SubtitleTranslationChange extends ProtoAdapter<SubtitleTranslationChange> {
            public ProtoAdapter_SubtitleTranslationChange() {
                super(FieldEncoding.LENGTH_DELIMITED, SubtitleTranslationChange.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SubtitleTranslationChange decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.language = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.language = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(SubtitleTranslationChange r100) {
                return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.language) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SubtitleTranslationChange decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SubtitleTranslationChange r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SubtitleTranslationChange r101) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.language);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SubtitleTranslationChange r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SubtitleTranslationChange();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.language = this.language;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SubtitleTranslationChange.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SubtitleTranslationChange(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public SubtitleTranslationChange(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.language = r100;
        }
    }

    static {
        ProtoAdapter_MinutesRecordingPushSubtitleStatusData r100 = new ProtoAdapter_MinutesRecordingPushSubtitleStatusData();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_STATUS = Status.STATUS_UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.status = this.status;
        r100.subtitle_translation_change = this.subtitle_translation_change;
        r100.simultaneous_interpretation_spoken_language_change = this.simultaneous_interpretation_spoken_language_change;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MinutesRecordingPushSubtitleStatusData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MinutesRecordingPushSubtitleStatusData(Status r100, SubtitleTranslationChange r101, SimultaneousInterpretationSpokenLanguageChange r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public MinutesRecordingPushSubtitleStatusData(Status r100, SubtitleTranslationChange r101, SimultaneousInterpretationSpokenLanguageChange r102, ByteString r103) {
        super(ADAPTER, r103);
        this.status = r100;
        this.subtitle_translation_change = r101;
        this.simultaneous_interpretation_spoken_language_change = r102;
    }
}
