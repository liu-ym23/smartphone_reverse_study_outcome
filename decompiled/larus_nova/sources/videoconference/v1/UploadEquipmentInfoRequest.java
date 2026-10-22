package videoconference.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.ss.android.lark.pb.videoconference.v1.ByteviewUser;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes41.dex */
public final class UploadEquipmentInfoRequest extends Message<UploadEquipmentInfoRequest, Builder> {
    public static final ProtoAdapter<UploadEquipmentInfoRequest> ADAPTER = null;
    public static final String DEFAULT_CAMERA_NAME = "";
    public static final String DEFAULT_MEETING_ID = "";
    public static final String DEFAULT_MICROPHONE_NAME = "";
    public static final String DEFAULT_SPEAKER_NAME = "";
    public static final ProtoAdapter_UploadEquipmentInfoRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String camera_name;
    public final String meeting_id;
    public final String microphone_name;
    public final String speaker_name;
    public final ByteviewUser user;

    public static final class Builder extends Message.Builder<UploadEquipmentInfoRequest, Builder> implements d<UploadEquipmentInfoRequest> {
        public String camera_name;
        public String meeting_id;
        public String microphone_name;
        public String speaker_name;
        public ByteviewUser user;

        @Override // com.squareup.wire.Message.Builder
        public UploadEquipmentInfoRequest build() {
            return new UploadEquipmentInfoRequest(this.user, this.meeting_id, this.microphone_name, this.speaker_name, this.camera_name, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder camera_name(String r100) {
            this.camera_name = r100;
            return this;
        }

        public Builder meeting_id(String r100) {
            this.meeting_id = r100;
            return this;
        }

        public Builder microphone_name(String r100) {
            this.microphone_name = r100;
            return this;
        }

        public Builder speaker_name(String r100) {
            this.speaker_name = r100;
            return this;
        }

        public Builder user(ByteviewUser r100) {
            this.user = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UploadEquipmentInfoRequest extends ProtoAdapter<UploadEquipmentInfoRequest> implements c<UploadEquipmentInfoRequest> {
        public ProtoAdapter_UploadEquipmentInfoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UploadEquipmentInfoRequest.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public UploadEquipmentInfoRequest decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.meeting_id = "";
            r101.microphone_name = "";
            r101.speaker_name = "";
            r101.camera_name = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.user = ByteviewUser.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.meeting_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.microphone_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.speaker_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.camera_name = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(UploadEquipmentInfoRequest r100) {
            ByteviewUser r101 = r100.user;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ByteviewUser.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.meeting_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.microphone_name;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.speaker_name;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.camera_name;
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
        public /* bridge */ /* synthetic */ UploadEquipmentInfoRequest decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UploadEquipmentInfoRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UploadEquipmentInfoRequest r101) throws IOException {
            ByteviewUser r102 = r101.user;
            if (r102 == null) goto L5;
            ByteviewUser.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.meeting_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.microphone_name;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.speaker_name;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.camera_name;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UploadEquipmentInfoRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UploadEquipmentInfoRequest r100 = new ProtoAdapter_UploadEquipmentInfoRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user = this.user;
        r100.meeting_id = this.meeting_id;
        r100.microphone_name = this.microphone_name;
        r100.speaker_name = this.speaker_name;
        r100.camera_name = this.camera_name;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UploadEquipmentInfoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UploadEquipmentInfoRequest(ByteviewUser r100, String r101, String r110, String r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public UploadEquipmentInfoRequest(ByteviewUser r100, String r101, String r102, String r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.user = r100;
        this.meeting_id = r101;
        this.microphone_name = r102;
        this.speaker_name = r103;
        this.camera_name = r104;
    }
}
