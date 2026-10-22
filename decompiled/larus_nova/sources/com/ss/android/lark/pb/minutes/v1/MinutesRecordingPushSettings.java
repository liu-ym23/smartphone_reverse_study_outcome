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
public final class MinutesRecordingPushSettings extends Message<MinutesRecordingPushSettings, Builder> {
    public static final ProtoAdapter<MinutesRecordingPushSettings> ADAPTER = null;
    public static final FeatureStatus DEFAULT_AI_VIEW = null;
    public static final String DEFAULT_SESSION_ID = "";
    public static final ProtoAdapter_MinutesRecordingPushSettings RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final FeatureStatus ai_view;
    public final String session_id;

    public static final class Builder extends Message.Builder<MinutesRecordingPushSettings, Builder> implements d<MinutesRecordingPushSettings> {
        public FeatureStatus ai_view;
        public String session_id;

        @Override // com.squareup.wire.Message.Builder
        public MinutesRecordingPushSettings build() {
            String r100 = this.session_id;
            if (r100 == null) goto L7;
            return new MinutesRecordingPushSettings(this.session_id, this.ai_view, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "session_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ai_view(FeatureStatus r100) {
            this.ai_view = r100;
            return this;
        }

        public Builder session_id(String r100) {
            this.session_id = r100;
            return this;
        }
    }

    public static final enum FeatureStatus extends Enum<FeatureStatus> implements WireEnum {
        private static final /* synthetic */ FeatureStatus[] $VALUES = null;
        public static final ProtoAdapter<FeatureStatus> ADAPTER = null;
        public static final FeatureStatus FEATURE_STATUS_DISABLED = null;
        public static final FeatureStatus FEATURE_STATUS_OFF = null;
        public static final FeatureStatus FEATURE_STATUS_ON = null;
        public static final FeatureStatus FEATURE_STATUS_UNKNOWN = null;
        private final int value;

        static {
            FeatureStatus r100 = new FeatureStatus("FEATURE_STATUS_UNKNOWN", 0, 0);
            FEATURE_STATUS_UNKNOWN = r100;
            FeatureStatus r101 = new FeatureStatus("FEATURE_STATUS_DISABLED", 1, 1);
            FEATURE_STATUS_DISABLED = r101;
            FeatureStatus r102 = new FeatureStatus("FEATURE_STATUS_ON", 2, 2);
            FEATURE_STATUS_ON = r102;
            FeatureStatus r103 = new FeatureStatus("FEATURE_STATUS_OFF", 3, 3);
            FEATURE_STATUS_OFF = r103;
            $VALUES = new FeatureStatus[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(FeatureStatus.class);
        }

        public static FeatureStatus[] values() {
            return (FeatureStatus[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static FeatureStatus fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return FEATURE_STATUS_OFF;
        L14:
            return FEATURE_STATUS_ON;
        L16:
            return FEATURE_STATUS_DISABLED;
        L18:
            return FEATURE_STATUS_UNKNOWN;
        }

        public static FeatureStatus valueOf(String r100) {
            return (FeatureStatus) a.a(FeatureStatus.class, r100);
        }

        private FeatureStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_MinutesRecordingPushSettings extends ProtoAdapter<MinutesRecordingPushSettings> implements c<MinutesRecordingPushSettings> {
        public ProtoAdapter_MinutesRecordingPushSettings() {
            super(FieldEncoding.LENGTH_DELIMITED, MinutesRecordingPushSettings.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MinutesRecordingPushSettings decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.session_id = "";
            r101.ai_view = FeatureStatus.FEATURE_STATUS_UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.session_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.ai_view = FeatureStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
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
        public int encodedSize2(MinutesRecordingPushSettings r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.session_id);
            FeatureStatus r102 = r100.ai_view;
            if (r102 == null) goto L5;
            int r103 = FeatureStatus.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MinutesRecordingPushSettings decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MinutesRecordingPushSettings r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MinutesRecordingPushSettings r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.session_id);
            FeatureStatus r102 = r101.ai_view;
            if (r102 == null) goto L5;
            FeatureStatus.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MinutesRecordingPushSettings r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_MinutesRecordingPushSettings r100 = new ProtoAdapter_MinutesRecordingPushSettings();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_AI_VIEW = FeatureStatus.FEATURE_STATUS_UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.session_id = this.session_id;
        r100.ai_view = this.ai_view;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MinutesRecordingPushSettings.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MinutesRecordingPushSettings(String r100, FeatureStatus r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public MinutesRecordingPushSettings(String r100, FeatureStatus r101, ByteString r102) {
        super(ADAPTER, r102);
        this.session_id = r100;
        this.ai_view = r101;
    }
}
