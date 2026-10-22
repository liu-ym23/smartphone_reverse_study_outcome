package com.bytedance.lark.pb.im.v1;

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
public final class WebTranslationConfig extends Message<WebTranslationConfig, Builder> {
    public static final ProtoAdapter<WebTranslationConfig> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> black_domains;

    public static final class Builder extends Message.Builder<WebTranslationConfig, Builder> {
        public List<String> black_domains;

        @Override // com.squareup.wire.Message.Builder
        public WebTranslationConfig build() {
            return new WebTranslationConfig(this.black_domains, super.buildUnknownFields());
        }

        public Builder() {
            this.black_domains = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder black_domains(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.black_domains = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_WebTranslationConfig extends ProtoAdapter<WebTranslationConfig> {
        public ProtoAdapter_WebTranslationConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, WebTranslationConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public WebTranslationConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.black_domains.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(WebTranslationConfig r100) {
            return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.black_domains) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ WebTranslationConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(WebTranslationConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, WebTranslationConfig r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.black_domains);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WebTranslationConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_WebTranslationConfig();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.black_domains = Internal.copyOf("black_domains", this.black_domains);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return WebTranslationConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public WebTranslationConfig(List<String> r100) {
        this(r100, ByteString.EMPTY);
    }

    public WebTranslationConfig(List<String> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.black_domains = Internal.immutableCopyOf("black_domains", r100);
    }
}
