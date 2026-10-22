package com.ss.android.lark.pb.minutes.v1;

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

/* JADX INFO: loaded from: classes37.dex */
public final class MinutesGetI18nTemplatesResponse extends Message<MinutesGetI18nTemplatesResponse, Builder> {
    public static final ProtoAdapter<MinutesGetI18nTemplatesResponse> ADAPTER = null;
    public static final ProtoAdapter_MinutesGetI18nTemplatesResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> templates;

    public static final class Builder extends Message.Builder<MinutesGetI18nTemplatesResponse, Builder> implements d<MinutesGetI18nTemplatesResponse> {
        public Map<String, String> templates;

        @Override // com.squareup.wire.Message.Builder
        public MinutesGetI18nTemplatesResponse build() {
            return new MinutesGetI18nTemplatesResponse(this.templates, super.buildUnknownFields());
        }

        public Builder() {
            this.templates = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder templates(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.templates = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MinutesGetI18nTemplatesResponse extends ProtoAdapter<MinutesGetI18nTemplatesResponse> implements c<MinutesGetI18nTemplatesResponse> {
        private final ProtoAdapter<Map<String, String>> templates;

        public ProtoAdapter_MinutesGetI18nTemplatesResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, MinutesGetI18nTemplatesResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.templates = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MinutesGetI18nTemplatesResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.templates.putAll(this.templates.decode(r100));
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
        public int encodedSize2(MinutesGetI18nTemplatesResponse r100) {
            return this.templates.encodedSizeWithTag(1, r100.templates) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MinutesGetI18nTemplatesResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MinutesGetI18nTemplatesResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MinutesGetI18nTemplatesResponse r101) throws IOException {
            this.templates.encodeWithTag(r100, 1, r101.templates);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MinutesGetI18nTemplatesResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_MinutesGetI18nTemplatesResponse r100 = new ProtoAdapter_MinutesGetI18nTemplatesResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.templates = Internal.copyOf("templates", this.templates);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MinutesGetI18nTemplatesResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MinutesGetI18nTemplatesResponse(Map<String, String> r100) {
        this(r100, ByteString.EMPTY);
    }

    public MinutesGetI18nTemplatesResponse(Map<String, String> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.templates = Internal.immutableCopyOf("templates", r100);
    }
}
