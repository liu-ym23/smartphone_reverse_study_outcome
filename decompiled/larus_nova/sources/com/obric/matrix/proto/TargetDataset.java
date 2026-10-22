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
public final class TargetDataset extends Message<TargetDataset, Builder> {
    public static final ProtoAdapter<TargetDataset> ADAPTER = null;
    public static final String DEFAULT_APPID = "";
    public static final String DEFAULT_APPKEY = "";
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;

    @SerializedName("appid")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String appid;

    @SerializedName("appkey")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String appkey;

    @SerializedName("name")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String name;

    @SerializedName("properties")
    @WireField(adapter = "com.obric.matrix.proto.NullableMap#ADAPTER", tag = 4)
    public final NullableMap properties;

    public static final class Builder extends Message.Builder<TargetDataset, Builder> {
        public String appid;
        public String appkey;
        public String name;
        public NullableMap properties;

        @Override // com.squareup.wire.Message.Builder
        public TargetDataset build() {
            return new TargetDataset(this.name, this.appid, this.appkey, this.properties, super.buildUnknownFields());
        }

        public Builder() {
            this.name = "";
            this.appid = "";
            this.appkey = "";
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder appid(String r100) {
            this.appid = r100;
            return this;
        }

        public Builder appkey(String r100) {
            this.appkey = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder properties(NullableMap r100) {
            this.properties = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TargetDataset extends ProtoAdapter<TargetDataset> {
        public ProtoAdapter_TargetDataset() {
            super(FieldEncoding.LENGTH_DELIMITED, TargetDataset.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TargetDataset decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.name(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.appid(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.appkey(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.properties(NullableMap.ADAPTER.decode(r100));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TargetDataset r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (((r101.encodedSizeWithTag(1, r100.name) + r101.encodedSizeWithTag(2, r100.appid)) + r101.encodedSizeWithTag(3, r100.appkey)) + NullableMap.ADAPTER.encodedSizeWithTag(4, r100.properties)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public TargetDataset redact2(TargetDataset r100) {
            Builder r101 = r100.newBuilder();
            NullableMap r102 = r101.properties;
            if (r102 == null) goto L5;
            r101.properties = NullableMap.ADAPTER.redact(r102);
        L5:
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TargetDataset decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TargetDataset r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TargetDataset redact(TargetDataset r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TargetDataset r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.name);
            r102.encodeWithTag(r100, 2, r101.appid);
            r102.encodeWithTag(r100, 3, r101.appkey);
            NullableMap.ADAPTER.encodeWithTag(r100, 4, r101.properties);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TargetDataset r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TargetDataset();
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L21;
        int r101 = unknownFields().hashCode() * 37;
        String r102 = this.name;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        String r106 = this.appid;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        String r109 = this.appkey;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 37;
        NullableMap r112 = this.properties;
        if (r112 == null) goto L19;
        r103 = r112.hashCode();
    L19:
        int r113 = r111 + r103;
        this.hashCode = r113;
        return r113;
    L15:
        r110 = 0;
        goto L16
    L11:
        r107 = 0;
        goto L12
    L7:
        r104 = 0;
        goto L8
    L21:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.name = this.name;
        r100.appid = this.appid;
        r100.appkey = this.appkey;
        r100.properties = this.properties;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.name == null) goto L6;
        r100.append(", name=");
        r100.append(this.name);
    L6:
        if (this.appid == null) goto L9;
        r100.append(", appid=");
        r100.append(this.appid);
    L9:
        if (this.appkey == null) goto L12;
        r100.append(", appkey=");
        r100.append(this.appkey);
    L12:
        if (this.properties == null) goto L14;
        r100.append(", properties=");
        r100.append(this.properties);
    L14:
        StringBuilder r101 = r100.replace(0, 2, "TargetDataset{");
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
        if ((r100 instanceof TargetDataset) == true) goto L8;
        return false;
    L8:
        TargetDataset r101 = (TargetDataset) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L19:
        return false;
    L11:
        if (Internal.equals(this.name, r101.name) == false) goto L19;
        if (Internal.equals(this.appid, r101.appid) == false) goto L19;
        if (Internal.equals(this.appkey, r101.appkey) == false) goto L19;
        if (Internal.equals(this.properties, r101.properties) == false) goto L19;
        return true;
    }

    public TargetDataset(String r100, String r101, String r102, NullableMap r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public TargetDataset(String r100, String r101, String r102, NullableMap r103, ByteString r104) {
        super(ADAPTER, r104);
        this.name = r100;
        this.appid = r101;
        this.appkey = r102;
        this.properties = r103;
    }
}
