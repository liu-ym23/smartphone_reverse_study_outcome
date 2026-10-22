package com.ss.android.lark.pb.recognition;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class SpeechRecognitionReportEditItem extends Message<SpeechRecognitionReportEditItem, Builder> {
    public static final ProtoAdapter<SpeechRecognitionReportEditItem> ADAPTER = null;
    public static final String DEFAULT_RECORDING_DEVICE = "";
    public static final String DEFAULT_SOURCE_ID = "";
    public static final String DEFAULT_TEXT_ORIGIN = "";
    public static final String DEFAULT_TEXT_SNAPSHOT_AFTER = "";
    public static final String DEFAULT_TEXT_SNAPSHOT_BEFORE = "";
    private static final long serialVersionUID = 0;
    public final String mrecording_device;
    public final String msource_id;
    public final String mtext_origin;
    public final String mtext_snapshot_after;
    public final String mtext_snapshot_before;

    public static final class Builder extends Message.Builder<SpeechRecognitionReportEditItem, Builder> {
        public String mrecording_device;
        public String msource_id;
        public String mtext_origin;
        public String mtext_snapshot_after;
        public String mtext_snapshot_before;

        @Override // com.squareup.wire.Message.Builder
        public SpeechRecognitionReportEditItem build() {
            return new SpeechRecognitionReportEditItem(this.msource_id, this.mtext_origin, this.mtext_snapshot_before, this.mtext_snapshot_after, this.mrecording_device, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder recording_device(String r100) {
            this.mrecording_device = r100;
            return this;
        }

        public Builder source_id(String r100) {
            this.msource_id = r100;
            return this;
        }

        public Builder text_origin(String r100) {
            this.mtext_origin = r100;
            return this;
        }

        public Builder text_snapshot_after(String r100) {
            this.mtext_snapshot_after = r100;
            return this;
        }

        public Builder text_snapshot_before(String r100) {
            this.mtext_snapshot_before = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SpeechRecognitionReportEditItem extends ProtoAdapter<SpeechRecognitionReportEditItem> {
        public ProtoAdapter_SpeechRecognitionReportEditItem() {
            super(FieldEncoding.LENGTH_DELIMITED, SpeechRecognitionReportEditItem.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SpeechRecognitionReportEditItem decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.msource_id = "";
            r101.mtext_origin = "";
            r101.mtext_snapshot_before = "";
            r101.mtext_snapshot_after = "";
            r101.mrecording_device = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.msource_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mtext_origin = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mtext_snapshot_before = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.mtext_snapshot_after = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.mrecording_device = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SpeechRecognitionReportEditItem r100) {
            String r101 = r100.msource_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mtext_origin;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mtext_snapshot_before;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mtext_snapshot_after;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.mrecording_device;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
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
        public /* bridge */ /* synthetic */ SpeechRecognitionReportEditItem decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SpeechRecognitionReportEditItem r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SpeechRecognitionReportEditItem r101) throws IOException {
            String r102 = r101.msource_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mtext_origin;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mtext_snapshot_before;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mtext_snapshot_after;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.mrecording_device;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SpeechRecognitionReportEditItem r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SpeechRecognitionReportEditItem();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.msource_id = this.msource_id;
        r100.mtext_origin = this.mtext_origin;
        r100.mtext_snapshot_before = this.mtext_snapshot_before;
        r100.mtext_snapshot_after = this.mtext_snapshot_after;
        r100.mrecording_device = this.mrecording_device;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SpeechRecognitionReportEditItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SpeechRecognitionReportEditItem(String r100, String r101, String r110, String r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public SpeechRecognitionReportEditItem(String r100, String r101, String r102, String r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.msource_id = r100;
        this.mtext_origin = r101;
        this.mtext_snapshot_before = r102;
        this.mtext_snapshot_after = r103;
        this.mrecording_device = r104;
    }
}
