package com.bytedance.lark.pb.security.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class OpenRequest extends Message<OpenRequest, Builder> {
    public static final ProtoAdapter<OpenRequest> ADAPTER = null;
    public static final String DEFAULT_PATH = "";
    public static final ProtoAdapter_OpenRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final OpenOptions options;
    public final String path;

    public static final class Builder extends Message.Builder<OpenRequest, Builder> implements d<OpenRequest> {
        public OpenOptions options;
        public String path;

        @Override // com.squareup.wire.Message.Builder
        public OpenRequest build() {
            return new OpenRequest(this.path, this.options, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder options(OpenOptions r100) {
            this.options = r100;
            return this;
        }

        public Builder path(String r100) {
            this.path = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_OpenRequest extends ProtoAdapter<OpenRequest> implements c<OpenRequest> {
        public ProtoAdapter_OpenRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, OpenRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OpenRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.path = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.options = OpenOptions.ADAPTER.decode(r100);
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
        public int encodedSize2(OpenRequest r100) {
            String r101 = r100.path;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            OpenOptions r104 = r100.options;
            if (r104 == null) goto L10;
            r102 = OpenOptions.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OpenRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OpenRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OpenRequest r101) throws IOException {
            String r102 = r101.path;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            OpenOptions r103 = r101.options;
            if (r103 == null) goto L8;
            OpenOptions.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OpenRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_OpenRequest r100 = new ProtoAdapter_OpenRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.path = this.path;
        r100.options = this.options;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return OpenRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OpenRequest(String r100, OpenOptions r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public OpenRequest(String r100, OpenOptions r101, ByteString r102) {
        super(ADAPTER, r102);
        this.path = r100;
        this.options = r101;
    }
}
