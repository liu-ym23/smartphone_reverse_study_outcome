package com.ss.android.lark.pb.security_event;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class I18nText extends Message<I18nText, Builder> {
    public static final ProtoAdapter<I18nText> ADAPTER = null;
    public static final String DEFAULT_DEFAULTTEXT = "";
    private static final long serialVersionUID = 0;
    public final String mDefaultText;
    public final Map<String, String> mI18nTexts;

    public static final class Builder extends Message.Builder<I18nText, Builder> {
        public String mDefaultText;
        public Map<String, String> mI18nTexts;

        @Override // com.squareup.wire.Message.Builder
        public I18nText build() {
            String r100 = this.mDefaultText;
            if (r100 == null) goto L7;
            return new I18nText(this.mDefaultText, this.mI18nTexts, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mDefaultText"});
        }

        public Builder() {
            this.mI18nTexts = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder DefaultText(String r100) {
            this.mDefaultText = r100;
            return this;
        }

        public Builder I18nTexts(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mI18nTexts = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_I18nText extends ProtoAdapter<I18nText> {
        private final ProtoAdapter<Map<String, String>> mI18nTexts;

        public ProtoAdapter_I18nText() {
            super(FieldEncoding.LENGTH_DELIMITED, I18nText.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mI18nTexts = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public I18nText decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mDefaultText = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mDefaultText = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mI18nTexts.putAll(this.mI18nTexts.decode(r100));
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
        public int encodedSize2(I18nText r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.mDefaultText) + this.mI18nTexts.encodedSizeWithTag(2, r100.mI18nTexts)) + r100.unknownFields().size();
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
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.mDefaultText);
            this.mI18nTexts.encodeWithTag(r100, 2, r101.mI18nTexts);
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
        r100.mDefaultText = this.mDefaultText;
        r100.mI18nTexts = Internal.copyOf("mI18nTexts", this.mI18nTexts);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return I18nText.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public I18nText(String r100, Map<String, String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public I18nText(String r100, Map<String, String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mDefaultText = r100;
        this.mI18nTexts = Internal.immutableCopyOf("mI18nTexts", r101);
    }
}
