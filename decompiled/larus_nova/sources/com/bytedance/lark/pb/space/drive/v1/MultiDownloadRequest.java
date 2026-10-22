package com.bytedance.lark.pb.space.drive.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class MultiDownloadRequest extends Message<MultiDownloadRequest, Builder> {
    public static final ProtoAdapter<MultiDownloadRequest> ADAPTER = null;
    public static final ProtoAdapter_MultiDownloadRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<DownloadRequest> download_requests;

    public static final class Builder extends Message.Builder<MultiDownloadRequest, Builder> implements d<MultiDownloadRequest> {
        public List<DownloadRequest> download_requests;

        @Override // com.squareup.wire.Message.Builder
        public MultiDownloadRequest build() {
            return new MultiDownloadRequest(this.download_requests, super.buildUnknownFields());
        }

        public Builder() {
            this.download_requests = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder download_requests(List<DownloadRequest> r100) {
            Internal.checkElementsNotNull(r100);
            this.download_requests = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MultiDownloadRequest extends ProtoAdapter<MultiDownloadRequest> implements c<MultiDownloadRequest> {
        public ProtoAdapter_MultiDownloadRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, MultiDownloadRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MultiDownloadRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.download_requests.add(DownloadRequest.ADAPTER.decode(r100));
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
        public int encodedSize2(MultiDownloadRequest r100) {
            return DownloadRequest.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.download_requests) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MultiDownloadRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MultiDownloadRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MultiDownloadRequest r101) throws IOException {
            DownloadRequest.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.download_requests);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MultiDownloadRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_MultiDownloadRequest r100 = new ProtoAdapter_MultiDownloadRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.download_requests = Internal.copyOf("download_requests", this.download_requests);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MultiDownloadRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MultiDownloadRequest(List<DownloadRequest> r100) {
        this(r100, ByteString.EMPTY);
    }

    public MultiDownloadRequest(List<DownloadRequest> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.download_requests = Internal.immutableCopyOf("download_requests", r100);
    }
}
