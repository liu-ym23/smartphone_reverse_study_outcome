package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class DraftAttachment extends com.squareup.wire.Message<DraftAttachment, Builder> {
    public static final ProtoAdapter<DraftAttachment> ADAPTER = null;
    public static final String DEFAULT_ERROR_REASON = "";
    public static final Integer DEFAULT_PROGRESS = null;
    public static final UploadStatus DEFAULT_STATUS = null;
    private static final long serialVersionUID = 0;
    public final String error_reason;
    public final File file;
    public final Integer progress;
    public final UploadStatus status;

    public static final class Builder extends com.squareup.wire.Message.Builder<DraftAttachment, Builder> {
        public String error_reason;
        public File file;
        public Integer progress;
        public UploadStatus status;

        @Override // com.squareup.wire.Message.Builder
        public DraftAttachment build() {
            return new DraftAttachment(this.file, this.status, this.progress, this.error_reason, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder error_reason(String r100) {
            this.error_reason = r100;
            return this;
        }

        public Builder file(File r100) {
            this.file = r100;
            return this;
        }

        public Builder progress(Integer r100) {
            this.progress = r100;
            return this;
        }

        public Builder status(UploadStatus r100) {
            this.status = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DraftAttachment extends ProtoAdapter<DraftAttachment> {
        public ProtoAdapter_DraftAttachment() {
            super(FieldEncoding.LENGTH_DELIMITED, DraftAttachment.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DraftAttachment decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.status = UploadStatus.UNKNOWN;
            r101.progress = 0;
            r101.error_reason = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.file = File.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.status = UploadStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.progress = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.error_reason = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(DraftAttachment r100) {
            File r101 = r100.file;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = File.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            UploadStatus r104 = r100.status;
            if (r104 == null) goto L9;
            int r105 = UploadStatus.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.progress;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.error_reason;
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
        public /* bridge */ /* synthetic */ DraftAttachment decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DraftAttachment r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DraftAttachment r101) throws IOException {
            File r102 = r101.file;
            if (r102 == null) goto L5;
            File.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            UploadStatus r103 = r101.status;
            if (r103 == null) goto L8;
            UploadStatus.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.progress;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.error_reason;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DraftAttachment r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum UploadStatus extends Enum<UploadStatus> implements WireEnum {
        private static final /* synthetic */ UploadStatus[] $VALUES = null;
        public static final ProtoAdapter<UploadStatus> ADAPTER = null;
        public static final UploadStatus COMPLETE = null;
        public static final UploadStatus FAILED = null;
        public static final UploadStatus UNKNOWN = null;
        public static final UploadStatus UPLOADING = null;
        private final int value;

        static {
            UploadStatus r100 = new UploadStatus("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            UploadStatus r101 = new UploadStatus("UPLOADING", 1, 1);
            UPLOADING = r101;
            UploadStatus r102 = new UploadStatus("COMPLETE", 2, 2);
            COMPLETE = r102;
            UploadStatus r103 = new UploadStatus("FAILED", 3, 3);
            FAILED = r103;
            $VALUES = new UploadStatus[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(UploadStatus.class);
        }

        public static UploadStatus[] values() {
            return (UploadStatus[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static UploadStatus fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return FAILED;
        L14:
            return COMPLETE;
        L16:
            return UPLOADING;
        L18:
            return UNKNOWN;
        }

        public static UploadStatus valueOf(String r100) {
            return (UploadStatus) a.a(UploadStatus.class, r100);
        }

        private UploadStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DraftAttachment();
        DEFAULT_STATUS = UploadStatus.UNKNOWN;
        DEFAULT_PROGRESS = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.file = this.file;
        r100.status = this.status;
        r100.progress = this.progress;
        r100.error_reason = this.error_reason;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DraftAttachment.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public DraftAttachment(File r100, UploadStatus r101, Integer r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public DraftAttachment(File r100, UploadStatus r101, Integer r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.file = r100;
        this.status = r101;
        this.progress = r102;
        this.error_reason = r103;
    }
}
