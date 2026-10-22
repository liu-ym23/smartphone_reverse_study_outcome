package com.bytedance.lark.pb.basic.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class NetDecorator extends com.squareup.wire.Message<NetDecorator, Builder> {
    public static final ProtoAdapter<NetDecorator> ADAPTER = null;
    public static final FieldOptions FIELD_OPTIONS_HEADERS = null;
    public static final FieldOptions FIELD_OPTIONS_URLS = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> headers;
    public final List<String> urls;

    public static final class Builder extends com.squareup.wire.Message.Builder<NetDecorator, Builder> {
        public Map<String, String> headers;
        public List<String> urls;

        @Override // com.squareup.wire.Message.Builder
        public NetDecorator build() {
            return new NetDecorator(this.urls, this.headers, super.buildUnknownFields());
        }

        public Builder() {
            this.urls = Internal.newMutableList();
            this.headers = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder headers(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.headers = r100;
            return this;
        }

        public Builder urls(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.urls = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_NetDecorator extends ProtoAdapter<NetDecorator> {
        private final ProtoAdapter<Map<String, String>> headers;

        public ProtoAdapter_NetDecorator() {
            super(FieldEncoding.LENGTH_DELIMITED, NetDecorator.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.headers = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public NetDecorator decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.urls.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.headers.putAll(this.headers.decode(r100));
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
        public int encodedSize2(NetDecorator r100) {
            return (ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.urls) + this.headers.encodedSizeWithTag(2, r100.headers)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ NetDecorator decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(NetDecorator r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, NetDecorator r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.urls);
            this.headers.encodeWithTag(r100, 2, r101.headers);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, NetDecorator r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_NetDecorator();
        FIELD_OPTIONS_URLS = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_HEADERS = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.urls = Internal.copyOf("urls", this.urls);
        r100.headers = Internal.copyOf("headers", this.headers);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return NetDecorator.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public NetDecorator(List<String> r100, Map<String, String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public NetDecorator(List<String> r100, Map<String, String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.urls = Internal.immutableCopyOf("urls", r100);
        this.headers = Internal.immutableCopyOf("headers", r101);
    }
}
