package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class CustomBannerMaterial extends Message<CustomBannerMaterial, Builder> {
    public static final ProtoAdapter<CustomBannerMaterial> ADAPTER = null;
    public static final String DEFAULT_DATA = "";
    public static final String DEFAULT_LAYOUT_NAME = "";
    private static final long serialVersionUID = 0;
    public final String mdata;
    public final String mlayout_name;

    public static final class Builder extends Message.Builder<CustomBannerMaterial, Builder> {
        public String mdata;
        public String mlayout_name;

        @Override // com.squareup.wire.Message.Builder
        public CustomBannerMaterial build() {
            return new CustomBannerMaterial(this.mlayout_name, this.mdata, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder data(String r100) {
            this.mdata = r100;
            return this;
        }

        public Builder layout_name(String r100) {
            this.mlayout_name = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomBannerMaterial extends ProtoAdapter<CustomBannerMaterial> {
        public ProtoAdapter_CustomBannerMaterial() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomBannerMaterial.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CustomBannerMaterial decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mlayout_name = "";
            r101.mdata = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mlayout_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mdata = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(CustomBannerMaterial r100) {
            String r101 = r100.mlayout_name;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mdata;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CustomBannerMaterial decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CustomBannerMaterial r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CustomBannerMaterial r101) throws IOException {
            String r102 = r101.mlayout_name;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mdata;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomBannerMaterial r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomBannerMaterial();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mlayout_name = this.mlayout_name;
        r100.mdata = this.mdata;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CustomBannerMaterial.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CustomBannerMaterial(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CustomBannerMaterial(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mlayout_name = r100;
        this.mdata = r101;
    }
}
