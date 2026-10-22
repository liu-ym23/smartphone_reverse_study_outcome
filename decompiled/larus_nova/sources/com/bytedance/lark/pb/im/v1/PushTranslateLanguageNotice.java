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
public final class PushTranslateLanguageNotice extends Message<PushTranslateLanguageNotice, Builder> {
    public static final ProtoAdapter<PushTranslateLanguageNotice> ADAPTER = null;
    public static final String DEFAULT_TARGET_LANGUAGE = "";
    public static final ProtoAdapter_PushTranslateLanguageNotice RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> language_keys;
    public final Map<String, String> supported_languages;
    public final String target_language;

    public static final class Builder extends Message.Builder<PushTranslateLanguageNotice, Builder> implements d<PushTranslateLanguageNotice> {
        public List<String> language_keys;
        public Map<String, String> supported_languages;
        public String target_language;

        @Override // com.squareup.wire.Message.Builder
        public PushTranslateLanguageNotice build() {
            String r100 = this.target_language;
            if (r100 == null) goto L7;
            return new PushTranslateLanguageNotice(this.target_language, this.language_keys, this.supported_languages, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "target_language"});
        }

        public Builder() {
            this.language_keys = Internal.newMutableList();
            this.supported_languages = Internal.newMutableMap();
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

        public Builder supported_languages(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.supported_languages = r100;
            return this;
        }

        public Builder target_language(String r100) {
            this.target_language = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushTranslateLanguageNotice extends ProtoAdapter<PushTranslateLanguageNotice> implements c<PushTranslateLanguageNotice> {
        private final ProtoAdapter<Map<String, String>> supported_languages;

        public ProtoAdapter_PushTranslateLanguageNotice() {
            super(FieldEncoding.LENGTH_DELIMITED, PushTranslateLanguageNotice.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.supported_languages = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushTranslateLanguageNotice decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.target_language = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.target_language = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.language_keys.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.supported_languages.putAll(this.supported_languages.decode(r100));
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
        public int encodedSize2(PushTranslateLanguageNotice r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((r101.encodedSizeWithTag(1, r100.target_language) + r101.asRepeated().encodedSizeWithTag(2, r100.language_keys)) + this.supported_languages.encodedSizeWithTag(3, r100.supported_languages)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushTranslateLanguageNotice decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushTranslateLanguageNotice r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushTranslateLanguageNotice r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.target_language);
            r102.asRepeated().encodeWithTag(r100, 2, r101.language_keys);
            this.supported_languages.encodeWithTag(r100, 3, r101.supported_languages);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushTranslateLanguageNotice r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushTranslateLanguageNotice r100 = new ProtoAdapter_PushTranslateLanguageNotice();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.target_language = this.target_language;
        r100.language_keys = Internal.copyOf("language_keys", this.language_keys);
        r100.supported_languages = Internal.copyOf("supported_languages", this.supported_languages);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushTranslateLanguageNotice.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushTranslateLanguageNotice(String r100, List<String> r101, Map<String, String> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PushTranslateLanguageNotice(String r100, List<String> r101, Map<String, String> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.target_language = r100;
        this.language_keys = Internal.immutableCopyOf("language_keys", r101);
        this.supported_languages = Internal.immutableCopyOf("supported_languages", r102);
    }
}
