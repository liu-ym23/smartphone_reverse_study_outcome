package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class I18nText extends com.squareup.wire.Message<I18nText, Builder> {
    public static final ProtoAdapter<I18nText> ADAPTER = null;
    public static final String DEFAULT_FALLBACK_TEXT = "";
    public static final String DEFAULT_LOCALIZED_TEXT = "";
    private static final long serialVersionUID = 0;
    public final String fallback_text;
    public final Map<String, String> i18n_text;
    public final String localized_text;

    public static final class Builder extends com.squareup.wire.Message.Builder<I18nText, Builder> {
        public String fallback_text;
        public Map<String, String> i18n_text;
        public String localized_text;

        @Override // com.squareup.wire.Message.Builder
        public I18nText build() {
            return new I18nText(this.fallback_text, this.i18n_text, this.localized_text, super.buildUnknownFields());
        }

        public Builder() {
            this.i18n_text = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder fallback_text(String r100) {
            this.fallback_text = r100;
            return this;
        }

        public Builder i18n_text(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.i18n_text = r100;
            return this;
        }

        public Builder localized_text(String r100) {
            this.localized_text = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_I18nText extends ProtoAdapter<I18nText> {
        private final ProtoAdapter<Map<String, String>> i18n_text;

        public ProtoAdapter_I18nText() {
            super(FieldEncoding.LENGTH_DELIMITED, I18nText.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.i18n_text = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public I18nText decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.fallback_text = "";
            r101.localized_text = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.fallback_text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.i18n_text.putAll(this.i18n_text.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.localized_text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(I18nText r100) {
            String r101 = r100.fallback_text;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + this.i18n_text.encodedSizeWithTag(2, r100.i18n_text);
            String r105 = r100.localized_text;
            if (r105 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r105);
        L10:
            return (r104 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ I18nText decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(I18nText r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, I18nText r101) throws IOException {
            String r102 = r101.fallback_text;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            this.i18n_text.encodeWithTag(r100, 2, r101.i18n_text);
            String r103 = r101.localized_text;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, I18nText r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_I18nText();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.fallback_text = this.fallback_text;
        r100.i18n_text = Internal.copyOf("i18n_text", this.i18n_text);
        r100.localized_text = this.localized_text;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return I18nText.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public I18nText(String r100, Map<String, String> r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public I18nText(String r100, Map<String, String> r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.fallback_text = r100;
        this.i18n_text = Internal.immutableCopyOf("i18n_text", r101);
        this.localized_text = r102;
    }
}
