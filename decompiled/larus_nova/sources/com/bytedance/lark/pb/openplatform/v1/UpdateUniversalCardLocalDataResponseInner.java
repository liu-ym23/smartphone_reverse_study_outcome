package com.bytedance.lark.pb.openplatform.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class UpdateUniversalCardLocalDataResponseInner extends Message<UpdateUniversalCardLocalDataResponseInner, Builder> {
    public static final ProtoAdapter<UpdateUniversalCardLocalDataResponseInner> ADAPTER = null;
    public static final String DEFAULT_JSON_DATA = "";
    public static final String DEFAULT_VERSION = "";
    private static final long serialVersionUID = 0;
    public final String json_data;
    public final String version;

    public static final class Builder extends Message.Builder<UpdateUniversalCardLocalDataResponseInner, Builder> {
        public String json_data;
        public String version;

        @Override // com.squareup.wire.Message.Builder
        public UpdateUniversalCardLocalDataResponseInner build() {
            String r100 = this.version;
            if (r100 == null) goto L9;
            if (this.json_data == null) goto L9;
            return new UpdateUniversalCardLocalDataResponseInner(this.version, this.json_data, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "version", this.json_data, "json_data"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder json_data(String r100) {
            this.json_data = r100;
            return this;
        }

        public Builder version(String r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateUniversalCardLocalDataResponseInner extends ProtoAdapter<UpdateUniversalCardLocalDataResponseInner> {
        public ProtoAdapter_UpdateUniversalCardLocalDataResponseInner() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateUniversalCardLocalDataResponseInner.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateUniversalCardLocalDataResponseInner decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.version = "";
            r101.json_data = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.json_data = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(UpdateUniversalCardLocalDataResponseInner r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (r101.encodedSizeWithTag(1, r100.version) + r101.encodedSizeWithTag(2, r100.json_data)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateUniversalCardLocalDataResponseInner decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateUniversalCardLocalDataResponseInner r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateUniversalCardLocalDataResponseInner r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.version);
            r102.encodeWithTag(r100, 2, r101.json_data);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateUniversalCardLocalDataResponseInner r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UpdateUniversalCardLocalDataResponseInner();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.version = this.version;
        r100.json_data = this.json_data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateUniversalCardLocalDataResponseInner.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateUniversalCardLocalDataResponseInner(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public UpdateUniversalCardLocalDataResponseInner(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.version = r100;
        this.json_data = r101;
    }
}
