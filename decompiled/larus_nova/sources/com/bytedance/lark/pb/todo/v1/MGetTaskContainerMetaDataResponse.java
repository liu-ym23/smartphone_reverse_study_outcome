package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class MGetTaskContainerMetaDataResponse extends Message<MGetTaskContainerMetaDataResponse, Builder> {
    public static final ProtoAdapter<MGetTaskContainerMetaDataResponse> ADAPTER = null;
    public static final ProtoAdapter_MGetTaskContainerMetaDataResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, ContainerMetaData> meta_data;

    public static final class Builder extends Message.Builder<MGetTaskContainerMetaDataResponse, Builder> implements d<MGetTaskContainerMetaDataResponse> {
        public Map<String, ContainerMetaData> meta_data;

        @Override // com.squareup.wire.Message.Builder
        public MGetTaskContainerMetaDataResponse build() {
            return new MGetTaskContainerMetaDataResponse(this.meta_data, super.buildUnknownFields());
        }

        public Builder() {
            this.meta_data = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder meta_data(Map<String, ContainerMetaData> r100) {
            Internal.checkElementsNotNull(r100);
            this.meta_data = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MGetTaskContainerMetaDataResponse extends ProtoAdapter<MGetTaskContainerMetaDataResponse> implements c<MGetTaskContainerMetaDataResponse> {
        private final ProtoAdapter<Map<String, ContainerMetaData>> meta_data;

        public ProtoAdapter_MGetTaskContainerMetaDataResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, MGetTaskContainerMetaDataResponse.class);
            this.meta_data = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ContainerMetaData.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MGetTaskContainerMetaDataResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.meta_data.putAll(this.meta_data.decode(r100));
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
        public int encodedSize2(MGetTaskContainerMetaDataResponse r100) {
            return this.meta_data.encodedSizeWithTag(1, r100.meta_data) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MGetTaskContainerMetaDataResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MGetTaskContainerMetaDataResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MGetTaskContainerMetaDataResponse r101) throws IOException {
            this.meta_data.encodeWithTag(r100, 1, r101.meta_data);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MGetTaskContainerMetaDataResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_MGetTaskContainerMetaDataResponse r100 = new ProtoAdapter_MGetTaskContainerMetaDataResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.meta_data = Internal.copyOf("meta_data", this.meta_data);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MGetTaskContainerMetaDataResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MGetTaskContainerMetaDataResponse(Map<String, ContainerMetaData> r100) {
        this(r100, ByteString.EMPTY);
    }

    public MGetTaskContainerMetaDataResponse(Map<String, ContainerMetaData> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.meta_data = Internal.immutableCopyOf("meta_data", r100);
    }
}
