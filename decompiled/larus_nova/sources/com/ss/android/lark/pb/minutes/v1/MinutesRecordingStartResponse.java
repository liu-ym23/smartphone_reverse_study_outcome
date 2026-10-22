package com.ss.android.lark.pb.minutes.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes37.dex */
public final class MinutesRecordingStartResponse extends Message<MinutesRecordingStartResponse, Builder> {
    public static final ProtoAdapter<MinutesRecordingStartResponse> ADAPTER = null;
    public static final String DEFAULT_BUSINESS_ID = "";
    public static final String DEFAULT_RECORDING_ID = "";
    public static final String DEFAULT_RTC_APP_ID = "";
    public static final String DEFAULT_RTC_INFO = "";
    public static final String DEFAULT_SESSION_ID = "";
    public static final Long DEFAULT_VENDOR_TYPE = null;
    public static final ProtoAdapter_MinutesRecordingStartResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String business_id;
    public final String recording_id;
    public final String rtc_app_id;
    public final String rtc_info;
    public final String session_id;
    public final Long vendor_type;

    public static final class Builder extends Message.Builder<MinutesRecordingStartResponse, Builder> implements d<MinutesRecordingStartResponse> {
        public String business_id;
        public String recording_id;
        public String rtc_app_id;
        public String rtc_info;
        public String session_id;
        public Long vendor_type;

        @Override // com.squareup.wire.Message.Builder
        public MinutesRecordingStartResponse build() {
            String r100 = this.session_id;
            if (r100 == null) goto L11;
            if (this.rtc_info == null) goto L11;
            if (this.vendor_type == null) goto L11;
            return new MinutesRecordingStartResponse(this.session_id, this.rtc_info, this.vendor_type, this.rtc_app_id, this.business_id, this.recording_id, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "session_id", this.rtc_info, "rtc_info", this.vendor_type, "vendor_type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder business_id(String r100) {
            this.business_id = r100;
            return this;
        }

        public Builder recording_id(String r100) {
            this.recording_id = r100;
            return this;
        }

        public Builder rtc_app_id(String r100) {
            this.rtc_app_id = r100;
            return this;
        }

        public Builder rtc_info(String r100) {
            this.rtc_info = r100;
            return this;
        }

        public Builder session_id(String r100) {
            this.session_id = r100;
            return this;
        }

        public Builder vendor_type(Long r100) {
            this.vendor_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MinutesRecordingStartResponse extends ProtoAdapter<MinutesRecordingStartResponse> implements c<MinutesRecordingStartResponse> {
        public ProtoAdapter_MinutesRecordingStartResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, MinutesRecordingStartResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MinutesRecordingStartResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.session_id = "";
            r101.rtc_info = "";
            r101.vendor_type = 0L;
            r101.rtc_app_id = "";
            r101.business_id = "";
            r101.recording_id = "";
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
            r101.recording_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.business_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.rtc_app_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.vendor_type = ProtoAdapter.INT64.decode(r100);
            goto L3
        L11:
            r101.rtc_info = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.session_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(MinutesRecordingStartResponse r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.session_id) + r101.encodedSizeWithTag(2, r100.rtc_info)) + ProtoAdapter.INT64.encodedSizeWithTag(3, r100.vendor_type);
            String r103 = r100.rtc_app_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(4, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.business_id;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(5, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.recording_id;
            if (r110 == null) goto L14;
            r104 = r101.encodedSizeWithTag(6, r110);
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
        public /* bridge */ /* synthetic */ MinutesRecordingStartResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MinutesRecordingStartResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MinutesRecordingStartResponse r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.session_id);
            r102.encodeWithTag(r100, 2, r101.rtc_info);
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r101.vendor_type);
            String r103 = r101.rtc_app_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 4, r103);
        L5:
            String r104 = r101.business_id;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 5, r104);
        L8:
            String r105 = r101.recording_id;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 6, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MinutesRecordingStartResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_MinutesRecordingStartResponse r100 = new ProtoAdapter_MinutesRecordingStartResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_VENDOR_TYPE = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.session_id = this.session_id;
        r100.rtc_info = this.rtc_info;
        r100.vendor_type = this.vendor_type;
        r100.rtc_app_id = this.rtc_app_id;
        r100.business_id = this.business_id;
        r100.recording_id = this.recording_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MinutesRecordingStartResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MinutesRecordingStartResponse(String r100, String r110, Long r111, String r112, String r113, String r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public MinutesRecordingStartResponse(String r100, String r101, Long r102, String r103, String r104, String r105, ByteString r106) {
        super(ADAPTER, r106);
        this.session_id = r100;
        this.rtc_info = r101;
        this.vendor_type = r102;
        this.rtc_app_id = r103;
        this.business_id = r104;
        this.recording_id = r105;
    }
}
