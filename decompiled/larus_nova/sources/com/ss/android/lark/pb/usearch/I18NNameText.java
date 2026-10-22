package com.ss.android.lark.pb.usearch;

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
public final class I18NNameText extends Message<I18NNameText, Builder> {
    public static final ProtoAdapter<I18NNameText> ADAPTER = null;
    public static final String DEFAULT_VALUE = "";
    private static final long serialVersionUID = 0;
    public final Map<String, String> mi18n_value;
    public final String mvalue;

    public static final class Builder extends Message.Builder<I18NNameText, Builder> {
        public Map<String, String> mi18n_value;
        public String mvalue;

        @Override // com.squareup.wire.Message.Builder
        public I18NNameText build() {
            return new I18NNameText(this.mvalue, this.mi18n_value, super.buildUnknownFields());
        }

        public Builder() {
            this.mi18n_value = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder i18n_value(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mi18n_value = r100;
            return this;
        }

        public Builder value(String r100) {
            this.mvalue = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_I18NNameText extends ProtoAdapter<I18NNameText> {
        private final ProtoAdapter<Map<String, String>> mi18n_value;

        public ProtoAdapter_I18NNameText() {
            super(FieldEncoding.LENGTH_DELIMITED, I18NNameText.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mi18n_value = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public I18NNameText decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mvalue = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mvalue = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mi18n_value.putAll(this.mi18n_value.decode(r100));
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
        public int encodedSize2(I18NNameText r100) {
            String r101 = r100.mvalue;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + this.mi18n_value.encodedSizeWithTag(2, r100.mi18n_value)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ I18NNameText decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(I18NNameText r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, I18NNameText r101) throws IOException {
            String r102 = r101.mvalue;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            this.mi18n_value.encodeWithTag(r100, 2, r101.mi18n_value);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, I18NNameText r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_I18NNameText();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mvalue = this.mvalue;
        r100.mi18n_value = Internal.copyOf("mi18n_value", this.mi18n_value);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return I18NNameText.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public I18NNameText(String r100, Map<String, String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public I18NNameText(String r100, Map<String, String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mvalue = r100;
        this.mi18n_value = Internal.immutableCopyOf("mi18n_value", r101);
    }
}
