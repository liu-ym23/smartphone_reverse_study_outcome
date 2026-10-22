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
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PutDisableAutoTranslateLanguagesResponse extends Message<PutDisableAutoTranslateLanguagesResponse, Builder> {
    public static final ProtoAdapter<PutDisableAutoTranslateLanguagesResponse> ADAPTER = null;
    public static final ProtoAdapter_PutDisableAutoTranslateLanguagesResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> language_keys;

    public static final class Builder extends Message.Builder<PutDisableAutoTranslateLanguagesResponse, Builder> implements d<PutDisableAutoTranslateLanguagesResponse> {
        public List<String> language_keys;

        @Override // com.squareup.wire.Message.Builder
        public PutDisableAutoTranslateLanguagesResponse build() {
            return new PutDisableAutoTranslateLanguagesResponse(this.language_keys, super.buildUnknownFields());
        }

        public Builder() {
            this.language_keys = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder language_keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.language_keys = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PutDisableAutoTranslateLanguagesResponse extends ProtoAdapter<PutDisableAutoTranslateLanguagesResponse> implements c<PutDisableAutoTranslateLanguagesResponse> {
        public ProtoAdapter_PutDisableAutoTranslateLanguagesResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PutDisableAutoTranslateLanguagesResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PutDisableAutoTranslateLanguagesResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.language_keys.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(PutDisableAutoTranslateLanguagesResponse r100) {
            return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.language_keys) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PutDisableAutoTranslateLanguagesResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PutDisableAutoTranslateLanguagesResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PutDisableAutoTranslateLanguagesResponse r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.language_keys);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PutDisableAutoTranslateLanguagesResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PutDisableAutoTranslateLanguagesResponse r100 = new ProtoAdapter_PutDisableAutoTranslateLanguagesResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.language_keys = Internal.copyOf("language_keys", this.language_keys);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PutDisableAutoTranslateLanguagesResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PutDisableAutoTranslateLanguagesResponse(List<String> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PutDisableAutoTranslateLanguagesResponse(List<String> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.language_keys = Internal.immutableCopyOf("language_keys", r100);
    }
}
