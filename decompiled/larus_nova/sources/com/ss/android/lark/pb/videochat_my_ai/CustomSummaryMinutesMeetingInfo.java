package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class CustomSummaryMinutesMeetingInfo extends Message<CustomSummaryMinutesMeetingInfo, Builder> {
    public static final ProtoAdapter<CustomSummaryMinutesMeetingInfo> ADAPTER = null;
    public static final String DEFAULT_HARDWARE_TITLE = "";
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    public final String mhardware_title;
    public final String mtitle;

    public static final class Builder extends Message.Builder<CustomSummaryMinutesMeetingInfo, Builder> {
        public String mhardware_title;
        public String mtitle;

        @Override // com.squareup.wire.Message.Builder
        public CustomSummaryMinutesMeetingInfo build() {
            return new CustomSummaryMinutesMeetingInfo(this.mhardware_title, this.mtitle, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder hardware_title(String r100) {
            this.mhardware_title = r100;
            return this;
        }

        public Builder title(String r100) {
            this.mtitle = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomSummaryMinutesMeetingInfo extends ProtoAdapter<CustomSummaryMinutesMeetingInfo> {
        public ProtoAdapter_CustomSummaryMinutesMeetingInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomSummaryMinutesMeetingInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CustomSummaryMinutesMeetingInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mhardware_title = "";
            r101.mtitle = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mhardware_title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mtitle = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(CustomSummaryMinutesMeetingInfo r100) {
            String r101 = r100.mhardware_title;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mtitle;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CustomSummaryMinutesMeetingInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CustomSummaryMinutesMeetingInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CustomSummaryMinutesMeetingInfo r101) throws IOException {
            String r102 = r101.mhardware_title;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mtitle;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomSummaryMinutesMeetingInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomSummaryMinutesMeetingInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mhardware_title = this.mhardware_title;
        r100.mtitle = this.mtitle;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CustomSummaryMinutesMeetingInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CustomSummaryMinutesMeetingInfo(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CustomSummaryMinutesMeetingInfo(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mhardware_title = r100;
        this.mtitle = r101;
    }
}
