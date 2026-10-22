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
public final class I18nVal extends com.squareup.wire.Message<I18nVal, Builder> {
    public static final ProtoAdapter<I18nVal> ADAPTER = null;
    public static final String DEFAULT_DEFAULT_VAL = "";
    private static final long serialVersionUID = 0;
    public final String default_val;
    public final Map<String, String> i18n_vals;

    public static final class Builder extends com.squareup.wire.Message.Builder<I18nVal, Builder> {
        public String default_val;
        public Map<String, String> i18n_vals;

        @Override // com.squareup.wire.Message.Builder
        public I18nVal build() {
            return new I18nVal(this.default_val, this.i18n_vals, super.buildUnknownFields());
        }

        public Builder() {
            this.i18n_vals = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder default_val(String r100) {
            this.default_val = r100;
            return this;
        }

        public Builder i18n_vals(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.i18n_vals = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_I18nVal extends ProtoAdapter<I18nVal> {
        private final ProtoAdapter<Map<String, String>> i18n_vals;

        public ProtoAdapter_I18nVal() {
            super(FieldEncoding.LENGTH_DELIMITED, I18nVal.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.i18n_vals = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public I18nVal decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.default_val = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.default_val = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.i18n_vals.putAll(this.i18n_vals.decode(r100));
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
        public int encodedSize2(I18nVal r100) {
            String r101 = r100.default_val;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + this.i18n_vals.encodedSizeWithTag(2, r100.i18n_vals)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ I18nVal decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(I18nVal r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, I18nVal r101) throws IOException {
            String r102 = r101.default_val;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            this.i18n_vals.encodeWithTag(r100, 2, r101.i18n_vals);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, I18nVal r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_I18nVal();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.default_val = this.default_val;
        r100.i18n_vals = Internal.copyOf("i18n_vals", this.i18n_vals);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return I18nVal.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public I18nVal(String r100, Map<String, String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public I18nVal(String r100, Map<String, String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.default_val = r100;
        this.i18n_vals = Internal.immutableCopyOf("i18n_vals", r101);
    }
}
