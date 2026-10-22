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
import okio.ByteString;

/* JADX INFO: loaded from: classes33.dex */
public final class Pair extends Message<Pair, Builder> {
    public static final ProtoAdapter<Pair> ADAPTER = null;
    public static final String DEFAULT__KEY = "";
    public static final String DEFAULT__VAL = "";
    private static final long serialVersionUID = 0;

    @SerializedName("_key")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String _key;

    @SerializedName("_val")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String _val;

    public static final class Builder extends Message.Builder<Pair, Builder> {
        public String _key;
        public String _val;

        @Override // com.squareup.wire.Message.Builder
        public Pair build() {
            return new Pair(this._key, this._val, super.buildUnknownFields());
        }

        public Builder() {
            this._key = "";
            this._val = "";
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder _key(String r100) {
            this._key = r100;
            return this;
        }

        public Builder _val(String r100) {
            this._val = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Pair extends ProtoAdapter<Pair> {
        public ProtoAdapter_Pair() {
            super(FieldEncoding.LENGTH_DELIMITED, Pair.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Pair decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101._key(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101._val(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(Pair r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (r101.encodedSizeWithTag(1, r100._key) + r101.encodedSizeWithTag(2, r100._val)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public Pair redact2(Pair r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Pair decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Pair r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Pair redact(Pair r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Pair r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101._key);
            r102.encodeWithTag(r100, 2, r101._val);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Pair r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Pair();
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L13;
        int r101 = unknownFields().hashCode() * 37;
        String r102 = this._key;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        String r106 = this._val;
        if (r106 == null) goto L11;
        r103 = r106.hashCode();
    L11:
        int r107 = r105 + r103;
        this.hashCode = r107;
        return r107;
    L7:
        r104 = 0;
        goto L8
    L13:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100._key = this._key;
        r100._val = this._val;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this._key == null) goto L6;
        r100.append(", _key=");
        r100.append(this._key);
    L6:
        if (this._val == null) goto L8;
        r100.append(", _val=");
        r100.append(this._val);
    L8:
        StringBuilder r101 = r100.replace(0, 2, "Pair{");
        r101.append('}');
        return r101.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof Pair) == true) goto L8;
        return false;
    L8:
        Pair r101 = (Pair) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (Internal.equals(this._key, r101._key) == false) goto L15;
        if (Internal.equals(this._val, r101._val) == false) goto L15;
        return true;
    }

    public Pair(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public Pair(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this._key = r100;
        this._val = r101;
    }
}
