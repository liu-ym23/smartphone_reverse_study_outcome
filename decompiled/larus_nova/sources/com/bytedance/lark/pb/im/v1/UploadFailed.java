package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.LarkError;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class UploadFailed extends Message<UploadFailed, Builder> {
    public static final ProtoAdapter<UploadFailed> ADAPTER = null;
    public static final String DEFAULT_REASON = "";
    private static final long serialVersionUID = 0;
    public final LarkError lark_error;
    public final String reason;

    public static final class Builder extends Message.Builder<UploadFailed, Builder> {
        public LarkError lark_error;
        public String reason;

        @Override // com.squareup.wire.Message.Builder
        public UploadFailed build() {
            return new UploadFailed(this.reason, this.lark_error, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder lark_error(LarkError r100) {
            this.lark_error = r100;
            return this;
        }

        public Builder reason(String r100) {
            this.reason = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UploadFailed extends ProtoAdapter<UploadFailed> {
        public ProtoAdapter_UploadFailed() {
            super(FieldEncoding.LENGTH_DELIMITED, UploadFailed.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UploadFailed decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.reason = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.reason = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.lark_error = LarkError.ADAPTER.decode(r100);
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
        public int encodedSize2(UploadFailed r100) {
            String r101 = r100.reason;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            LarkError r104 = r100.lark_error;
            if (r104 == null) goto L10;
            r102 = LarkError.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UploadFailed decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UploadFailed r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UploadFailed r101) throws IOException {
            String r102 = r101.reason;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            LarkError r103 = r101.lark_error;
            if (r103 == null) goto L8;
            LarkError.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UploadFailed r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UploadFailed();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.reason = this.reason;
        r100.lark_error = this.lark_error;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UploadFailed.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UploadFailed(String r100, LarkError r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public UploadFailed(String r100, LarkError r101, ByteString r102) {
        super(ADAPTER, r102);
        this.reason = r100;
        this.lark_error = r101;
    }
}
