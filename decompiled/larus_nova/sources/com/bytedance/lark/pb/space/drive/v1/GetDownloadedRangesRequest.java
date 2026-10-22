package com.bytedance.lark.pb.space.drive.v1;

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
public final class GetDownloadedRangesRequest extends Message<GetDownloadedRangesRequest, Builder> {
    public static final ProtoAdapter<GetDownloadedRangesRequest> ADAPTER = null;
    public static final String DEFAULT_DATA_VERSION = "";
    public static final String DEFAULT_FILE_TOKEN = "";
    public static final String DEFAULT_LOCAL_PATH = "";
    public static final ProtoAdapter_GetDownloadedRangesRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String data_version;
    public final String file_token;
    public final String local_path;

    public static final class Builder extends Message.Builder<GetDownloadedRangesRequest, Builder> implements d<GetDownloadedRangesRequest> {
        public String data_version;
        public String file_token;
        public String local_path;

        @Override // com.squareup.wire.Message.Builder
        public GetDownloadedRangesRequest build() {
            String r100 = this.file_token;
            if (r100 == null) goto L7;
            return new GetDownloadedRangesRequest(this.file_token, this.local_path, this.data_version, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "file_token"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder data_version(String r100) {
            this.data_version = r100;
            return this;
        }

        public Builder file_token(String r100) {
            this.file_token = r100;
            return this;
        }

        public Builder local_path(String r100) {
            this.local_path = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetDownloadedRangesRequest extends ProtoAdapter<GetDownloadedRangesRequest> implements c<GetDownloadedRangesRequest> {
        public ProtoAdapter_GetDownloadedRangesRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetDownloadedRangesRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetDownloadedRangesRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.file_token = "";
            r101.local_path = "";
            r101.data_version = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.file_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.local_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.data_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetDownloadedRangesRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.file_token);
            String r103 = r100.local_path;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.data_version;
            if (r107 == null) goto L10;
            r104 = r101.encodedSizeWithTag(3, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetDownloadedRangesRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetDownloadedRangesRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetDownloadedRangesRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.file_token);
            String r103 = r101.local_path;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.data_version;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetDownloadedRangesRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetDownloadedRangesRequest r100 = new ProtoAdapter_GetDownloadedRangesRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.file_token = this.file_token;
        r100.local_path = this.local_path;
        r100.data_version = this.data_version;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetDownloadedRangesRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetDownloadedRangesRequest(String r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetDownloadedRangesRequest(String r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.file_token = r100;
        this.local_path = r101;
        this.data_version = r102;
    }
}
