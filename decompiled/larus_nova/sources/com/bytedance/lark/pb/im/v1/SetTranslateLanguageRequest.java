package com.bytedance.lark.pb.im.v1;

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
public final class SetTranslateLanguageRequest extends Message<SetTranslateLanguageRequest, Builder> {
    public static final ProtoAdapter<SetTranslateLanguageRequest> ADAPTER = null;
    public static final String DEFAULT_LANGUAGE = "";
    public static final ProtoAdapter_SetTranslateLanguageRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String language;

    public static final class Builder extends Message.Builder<SetTranslateLanguageRequest, Builder> implements d<SetTranslateLanguageRequest> {
        public String language;

        @Override // com.squareup.wire.Message.Builder
        public SetTranslateLanguageRequest build() {
            String r100 = this.language;
            if (r100 == null) goto L7;
            return new SetTranslateLanguageRequest(this.language, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "language"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder language(String r100) {
            this.language = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SetTranslateLanguageRequest extends ProtoAdapter<SetTranslateLanguageRequest> implements c<SetTranslateLanguageRequest> {
        public ProtoAdapter_SetTranslateLanguageRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SetTranslateLanguageRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SetTranslateLanguageRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.language = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.language = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SetTranslateLanguageRequest r100) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.language) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SetTranslateLanguageRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SetTranslateLanguageRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SetTranslateLanguageRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.language);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SetTranslateLanguageRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SetTranslateLanguageRequest r100 = new ProtoAdapter_SetTranslateLanguageRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.language = this.language;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SetTranslateLanguageRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SetTranslateLanguageRequest(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public SetTranslateLanguageRequest(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.language = r100;
    }
}
