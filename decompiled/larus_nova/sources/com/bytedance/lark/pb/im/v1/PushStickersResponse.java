package com.bytedance.lark.pb.im.v1;

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
public final class PushStickersResponse extends Message<PushStickersResponse, Builder> {
    public static final ProtoAdapter<PushStickersResponse> ADAPTER = null;
    public static final ProtoAdapter_PushStickersResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> key2url;
    public final List<String> keys;

    public static final class Builder extends Message.Builder<PushStickersResponse, Builder> implements d<PushStickersResponse> {
        public Map<String, String> key2url;
        public List<String> keys;

        @Override // com.squareup.wire.Message.Builder
        public PushStickersResponse build() {
            return new PushStickersResponse(this.keys, this.key2url, super.buildUnknownFields());
        }

        public Builder() {
            this.keys = Internal.newMutableList();
            this.key2url = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder key2url(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.key2url = r100;
            return this;
        }

        public Builder keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.keys = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushStickersResponse extends ProtoAdapter<PushStickersResponse> implements c<PushStickersResponse> {
        private final ProtoAdapter<Map<String, String>> key2url;

        public ProtoAdapter_PushStickersResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PushStickersResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.key2url = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushStickersResponse decode(ProtoReader r100) throws IOException {
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
            r101.key2url.putAll(this.key2url.decode(r100));
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
        public int encodedSize2(PushStickersResponse r100) {
            return (ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.keys) + this.key2url.encodedSizeWithTag(2, r100.key2url)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushStickersResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushStickersResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushStickersResponse r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.keys);
            this.key2url.encodeWithTag(r100, 2, r101.key2url);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushStickersResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushStickersResponse r100 = new ProtoAdapter_PushStickersResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.keys = Internal.copyOf("keys", this.keys);
        r100.key2url = Internal.copyOf("key2url", this.key2url);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushStickersResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushStickersResponse(List<String> r100, Map<String, String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PushStickersResponse(List<String> r100, Map<String, String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.keys = Internal.immutableCopyOf("keys", r100);
        this.key2url = Internal.immutableCopyOf("key2url", r101);
    }
}
