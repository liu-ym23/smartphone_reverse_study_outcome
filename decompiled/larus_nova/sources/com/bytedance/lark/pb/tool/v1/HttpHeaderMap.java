package com.bytedance.lark.pb.tool.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class HttpHeaderMap extends Message<HttpHeaderMap, Builder> {
    public static final ProtoAdapter<HttpHeaderMap> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<HttpHeader> headers;

    public static final class Builder extends Message.Builder<HttpHeaderMap, Builder> {
        public List<HttpHeader> headers;

        @Override // com.squareup.wire.Message.Builder
        public HttpHeaderMap build() {
            return new HttpHeaderMap(this.headers, super.buildUnknownFields());
        }

        public Builder() {
            this.headers = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder headers(List<HttpHeader> r100) {
            Internal.checkElementsNotNull(r100);
            this.headers = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_HttpHeaderMap extends ProtoAdapter<HttpHeaderMap> {
        public ProtoAdapter_HttpHeaderMap() {
            super(FieldEncoding.LENGTH_DELIMITED, HttpHeaderMap.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public HttpHeaderMap decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.headers.add(HttpHeader.ADAPTER.decode(r100));
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
        public int encodedSize2(HttpHeaderMap r100) {
            return HttpHeader.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.headers) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ HttpHeaderMap decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(HttpHeaderMap r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, HttpHeaderMap r101) throws IOException {
            HttpHeader.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.headers);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HttpHeaderMap r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_HttpHeaderMap();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.headers = Internal.copyOf("headers", this.headers);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return HttpHeaderMap.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public HttpHeaderMap(List<HttpHeader> r100) {
        this(r100, ByteString.EMPTY);
    }

    public HttpHeaderMap(List<HttpHeader> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.headers = Internal.immutableCopyOf("headers", r100);
    }
}
