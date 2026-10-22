package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes33.dex */
public final class StringArray extends Message<StringArray, Builder> {
    public static final ProtoAdapter<StringArray> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("_value")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 1)
    public final List<String> _value;

    public static final class Builder extends Message.Builder<StringArray, Builder> {
        public List<String> _value;

        @Override // com.squareup.wire.Message.Builder
        public StringArray build() {
            return new StringArray(this._value, super.buildUnknownFields());
        }

        public Builder() {
            this._value = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder _value(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this._value = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_StringArray extends ProtoAdapter<StringArray> {
        public ProtoAdapter_StringArray() {
            super(FieldEncoding.LENGTH_DELIMITED, StringArray.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public StringArray decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101._value.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(StringArray r100) {
            return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100._value) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public StringArray redact2(StringArray r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ StringArray decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(StringArray r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ StringArray redact(StringArray r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, StringArray r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101._value);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, StringArray r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_StringArray();
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L6;
        int r101 = (unknownFields().hashCode() * 37) + this._value.hashCode();
        this.hashCode = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100._value = Internal.copyOf("_value", this._value);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        List<String> r101 = this._value;
        if (r101 != null) goto L5;
    L7:
        StringBuilder r102 = r100.replace(0, 2, "StringArray{");
        r102.append('}');
        return r102.toString();
    L5:
        if (r101.isEmpty() == true) goto L7;
        r100.append(", _value=");
        r100.append(this._value);
        goto L7
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public StringArray(List<String> r100) {
        this(r100, ByteString.EMPTY);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof StringArray) == true) goto L8;
        return false;
    L8:
        StringArray r101 = (StringArray) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L13:
        return false;
    L11:
        if (this._value.equals(r101._value) == false) goto L13;
        return true;
    }

    public StringArray(List<String> r100, ByteString r101) {
        super(ADAPTER, r101);
        this._value = Internal.immutableCopyOf("_value", r100);
    }
}
