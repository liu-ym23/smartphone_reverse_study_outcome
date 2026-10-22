package com.bytedance.lark.pb.space.drive.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class MultiDownloadResponse extends Message<MultiDownloadResponse, Builder> {
    public static final ProtoAdapter<MultiDownloadResponse> ADAPTER = null;
    public static final ProtoAdapter_MultiDownloadResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> keys;
    public final Map<String, String> keys_map;

    public static final class Builder extends Message.Builder<MultiDownloadResponse, Builder> implements d<MultiDownloadResponse> {
        public List<String> keys;
        public Map<String, String> keys_map;

        @Override // com.squareup.wire.Message.Builder
        public MultiDownloadResponse build() {
            return new MultiDownloadResponse(this.keys, this.keys_map, super.buildUnknownFields());
        }

        public Builder() {
            this.keys = Internal.newMutableList();
            this.keys_map = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.keys = r100;
            return this;
        }

        public Builder keys_map(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.keys_map = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MultiDownloadResponse extends ProtoAdapter<MultiDownloadResponse> implements c<MultiDownloadResponse> {
        private final ProtoAdapter<Map<String, String>> keys_map;

        public ProtoAdapter_MultiDownloadResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, MultiDownloadResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.keys_map = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MultiDownloadResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.keys.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.keys_map.putAll(this.keys_map.decode(r100));
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
        public int encodedSize2(MultiDownloadResponse r100) {
            return (ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.keys) + this.keys_map.encodedSizeWithTag(2, r100.keys_map)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MultiDownloadResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MultiDownloadResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MultiDownloadResponse r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.keys);
            this.keys_map.encodeWithTag(r100, 2, r101.keys_map);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MultiDownloadResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_MultiDownloadResponse r100 = new ProtoAdapter_MultiDownloadResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.keys = Internal.copyOf("keys", this.keys);
        r100.keys_map = Internal.copyOf("keys_map", this.keys_map);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MultiDownloadResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MultiDownloadResponse(List<String> r100, Map<String, String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public MultiDownloadResponse(List<String> r100, Map<String, String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.keys = Internal.immutableCopyOf("keys", r100);
        this.keys_map = Internal.immutableCopyOf("keys_map", r101);
    }
}
