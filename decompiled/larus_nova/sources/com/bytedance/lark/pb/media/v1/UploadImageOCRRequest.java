package com.bytedance.lark.pb.media.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class UploadImageOCRRequest extends Message<UploadImageOCRRequest, Builder> {
    public static final ProtoAdapter<UploadImageOCRRequest> ADAPTER = null;
    public static final String DEFAULT_FILE_KEY = "";
    public static final Boolean DEFAULT_IS_PRELOAD = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final OCRScene DEFAULT_OCR_SCENE = null;
    public static final String DEFAULT_PATH = "";
    public static final DownloadFileScene DEFAULT_SCENE = null;
    public static final ProtoAdapter_UploadImageOCRRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String file_key;
    public final Boolean is_preload;
    public final String message_id;
    public final OCRScene ocr_scene;
    public final String path;
    public final DownloadFileScene scene;

    public static final class Builder extends Message.Builder<UploadImageOCRRequest, Builder> implements d<UploadImageOCRRequest> {
        public String file_key;
        public Boolean is_preload;
        public String message_id;
        public OCRScene ocr_scene;
        public String path;
        public DownloadFileScene scene;

        @Override // com.squareup.wire.Message.Builder
        public UploadImageOCRRequest build() {
            return new UploadImageOCRRequest(this.file_key, this.path, this.message_id, this.scene, this.ocr_scene, this.is_preload, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder file_key(String r100) {
            this.file_key = r100;
            return this;
        }

        public Builder is_preload(Boolean r100) {
            this.is_preload = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder ocr_scene(OCRScene r100) {
            this.ocr_scene = r100;
            return this;
        }

        public Builder path(String r100) {
            this.path = r100;
            return this;
        }

        public Builder scene(DownloadFileScene r100) {
            this.scene = r100;
            return this;
        }
    }

    public static final enum OCRScene extends Enum<OCRScene> implements WireEnum {
        private static final /* synthetic */ OCRScene[] $VALUES = null;
        public static final ProtoAdapter<OCRScene> ADAPTER = null;
        public static final OCRScene OCR = null;
        public static final OCRScene SCRATCH = null;
        private final int value;

        static {
            OCRScene r100 = new OCRScene("OCR", 0, 0);
            OCR = r100;
            OCRScene r101 = new OCRScene("SCRATCH", 1, 1);
            SCRATCH = r101;
            $VALUES = new OCRScene[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(OCRScene.class);
        }

        public static OCRScene[] values() {
            return (OCRScene[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static OCRScene fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return SCRATCH;
        L10:
            return OCR;
        }

        public static OCRScene valueOf(String r100) {
            return (OCRScene) a.a(OCRScene.class, r100);
        }

        private OCRScene(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_UploadImageOCRRequest extends ProtoAdapter<UploadImageOCRRequest> implements c<UploadImageOCRRequest> {
        public ProtoAdapter_UploadImageOCRRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UploadImageOCRRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UploadImageOCRRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.file_key = "";
            r101.path = "";
            r101.message_id = "";
            r101.scene = DownloadFileScene.UNKNOWN;
            r101.ocr_scene = OCRScene.OCR;
            r101.is_preload = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L23;
                case 5: goto L21;
                case 6: goto L7;
                default: goto L6;
            };
        L21:
            r101.ocr_scene = OCRScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L23:
            r101.scene = DownloadFileScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.is_preload = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L16:
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.file_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UploadImageOCRRequest r100) {
            String r101 = r100.file_key;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.path;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.message_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            DownloadFileScene r110 = r100.scene;
            if (r110 == null) goto L17;
            int r111 = DownloadFileScene.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            OCRScene r113 = r100.ocr_scene;
            if (r113 == null) goto L21;
            int r114 = OCRScene.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.is_preload;
            if (r116 == null) goto L26;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
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
        public /* bridge */ /* synthetic */ UploadImageOCRRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UploadImageOCRRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UploadImageOCRRequest r101) throws IOException {
            String r102 = r101.file_key;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.path;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.message_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            DownloadFileScene r105 = r101.scene;
            if (r105 == null) goto L14;
            DownloadFileScene.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            OCRScene r106 = r101.ocr_scene;
            if (r106 == null) goto L17;
            OCRScene.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            Boolean r107 = r101.is_preload;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UploadImageOCRRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UploadImageOCRRequest r100 = new ProtoAdapter_UploadImageOCRRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SCENE = DownloadFileScene.UNKNOWN;
        DEFAULT_OCR_SCENE = OCRScene.OCR;
        DEFAULT_IS_PRELOAD = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.file_key = this.file_key;
        r100.path = this.path;
        r100.message_id = this.message_id;
        r100.scene = this.scene;
        r100.ocr_scene = this.ocr_scene;
        r100.is_preload = this.is_preload;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UploadImageOCRRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UploadImageOCRRequest(String r100, String r110, String r111, DownloadFileScene r112, OCRScene r113, Boolean r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public UploadImageOCRRequest(String r100, String r101, String r102, DownloadFileScene r103, OCRScene r104, Boolean r105, ByteString r106) {
        super(ADAPTER, r106);
        this.file_key = r100;
        this.path = r101;
        this.message_id = r102;
        this.scene = r103;
        this.ocr_scene = r104;
        this.is_preload = r105;
    }
}
