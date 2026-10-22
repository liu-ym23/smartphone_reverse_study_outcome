package com.bytedance.lark.pb.im.v1;

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

/* JADX INFO: loaded from: classes20.dex */
public final class PushUploadResourceStatus extends Message<PushUploadResourceStatus, Builder> {
    public static final ProtoAdapter<PushUploadResourceStatus> ADAPTER = null;
    public static final String DEFAULT_UPLOAD_ID = "";
    public static final ProtoAdapter_PushUploadResourceStatus RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final UploadComplete complete;
    public final UploadFailed failed;
    public final String upload_id;
    public final Uploading uploading;

    public static final class Builder extends Message.Builder<PushUploadResourceStatus, Builder> implements d<PushUploadResourceStatus> {
        public UploadComplete complete;
        public UploadFailed failed;
        public String upload_id;
        public Uploading uploading;

        @Override // com.squareup.wire.Message.Builder
        public PushUploadResourceStatus build() {
            return new PushUploadResourceStatus(this.upload_id, this.complete, this.failed, this.uploading, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder complete(UploadComplete r100) {
            this.complete = r100;
            this.failed = null;
            this.uploading = null;
            return this;
        }

        public Builder failed(UploadFailed r100) {
            this.failed = r100;
            this.complete = null;
            this.uploading = null;
            return this;
        }

        public Builder upload_id(String r100) {
            this.upload_id = r100;
            return this;
        }

        public Builder uploading(Uploading r100) {
            this.uploading = r100;
            this.complete = null;
            this.failed = null;
            return this;
        }
    }

    public static final class ProtoAdapter_PushUploadResourceStatus extends ProtoAdapter<PushUploadResourceStatus> implements c<PushUploadResourceStatus> {
        public ProtoAdapter_PushUploadResourceStatus() {
            super(FieldEncoding.LENGTH_DELIMITED, PushUploadResourceStatus.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushUploadResourceStatus decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.upload_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.upload_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.complete(UploadComplete.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.failed(UploadFailed.ADAPTER.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.uploading(Uploading.ADAPTER.decode(r100));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushUploadResourceStatus r100) {
            String r101 = r100.upload_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            UploadComplete r104 = r100.complete;
            if (r104 == null) goto L9;
            int r105 = UploadComplete.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            UploadFailed r107 = r100.failed;
            if (r107 == null) goto L13;
            int r108 = UploadFailed.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Uploading r110 = r100.uploading;
            if (r110 == null) goto L18;
            r102 = Uploading.ADAPTER.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ PushUploadResourceStatus decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushUploadResourceStatus r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushUploadResourceStatus r101) throws IOException {
            String r102 = r101.upload_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            UploadComplete r103 = r101.complete;
            if (r103 == null) goto L8;
            UploadComplete.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            UploadFailed r104 = r101.failed;
            if (r104 == null) goto L11;
            UploadFailed.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            Uploading r105 = r101.uploading;
            if (r105 == null) goto L14;
            Uploading.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushUploadResourceStatus r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushUploadResourceStatus r100 = new ProtoAdapter_PushUploadResourceStatus();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.upload_id = this.upload_id;
        r100.complete = this.complete;
        r100.failed = this.failed;
        r100.uploading = this.uploading;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushUploadResourceStatus.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushUploadResourceStatus(String r100, UploadComplete r101, UploadFailed r102, Uploading r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public PushUploadResourceStatus(String r100, UploadComplete r101, UploadFailed r102, Uploading r103, ByteString r104) {
        super(ADAPTER, r104);
        if (Internal.countNonNull(r101, r102, r103) > 1) goto L7;
        this.upload_id = r100;
        this.complete = r101;
        this.failed = r102;
        this.uploading = r103;
        return;
    L7:
        throw new IllegalArgumentException("at most one of complete, failed, uploading may be non-null");
    }
}
