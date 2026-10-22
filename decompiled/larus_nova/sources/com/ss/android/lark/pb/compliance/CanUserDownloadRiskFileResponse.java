package com.ss.android.lark.pb.compliance;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class CanUserDownloadRiskFileResponse extends Message<CanUserDownloadRiskFileResponse, Builder> {
    public static final ProtoAdapter<CanUserDownloadRiskFileResponse> ADAPTER = null;
    public static final Boolean DEFAULT_CAN_DOWNLOAD = null;
    private static final long serialVersionUID = 0;
    public final Boolean mcan_download;

    public static final class Builder extends Message.Builder<CanUserDownloadRiskFileResponse, Builder> {
        public Boolean mcan_download;

        @Override // com.squareup.wire.Message.Builder
        public CanUserDownloadRiskFileResponse build() {
            Boolean r100 = this.mcan_download;
            if (r100 == null) goto L7;
            return new CanUserDownloadRiskFileResponse(this.mcan_download, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mcan_download"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder can_download(Boolean r100) {
            this.mcan_download = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CanUserDownloadRiskFileResponse extends ProtoAdapter<CanUserDownloadRiskFileResponse> {
        public ProtoAdapter_CanUserDownloadRiskFileResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, CanUserDownloadRiskFileResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CanUserDownloadRiskFileResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mcan_download = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mcan_download = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(CanUserDownloadRiskFileResponse r100) {
            return ProtoAdapter.BOOL.encodedSizeWithTag(1, r100.mcan_download) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CanUserDownloadRiskFileResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CanUserDownloadRiskFileResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CanUserDownloadRiskFileResponse r101) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r101.mcan_download);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CanUserDownloadRiskFileResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CanUserDownloadRiskFileResponse();
        DEFAULT_CAN_DOWNLOAD = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mcan_download = this.mcan_download;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CanUserDownloadRiskFileResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CanUserDownloadRiskFileResponse(Boolean r100) {
        this(r100, ByteString.EMPTY);
    }

    public CanUserDownloadRiskFileResponse(Boolean r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mcan_download = r100;
    }
}
