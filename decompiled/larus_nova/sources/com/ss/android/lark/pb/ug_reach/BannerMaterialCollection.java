package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class BannerMaterialCollection extends Message<BannerMaterialCollection, Builder> {
    public static final ProtoAdapter<BannerMaterialCollection> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<BannerMaterial> mbanners;

    public static final class Builder extends Message.Builder<BannerMaterialCollection, Builder> {
        public List<BannerMaterial> mbanners;

        @Override // com.squareup.wire.Message.Builder
        public BannerMaterialCollection build() {
            return new BannerMaterialCollection(this.mbanners, super.buildUnknownFields());
        }

        public Builder() {
            this.mbanners = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder banners(List<BannerMaterial> r100) {
            Internal.checkElementsNotNull(r100);
            this.mbanners = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BannerMaterialCollection extends ProtoAdapter<BannerMaterialCollection> {
        public ProtoAdapter_BannerMaterialCollection() {
            super(FieldEncoding.LENGTH_DELIMITED, BannerMaterialCollection.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BannerMaterialCollection decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mbanners.add(BannerMaterial.ADAPTER.decode(r100));
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
        public int encodedSize2(BannerMaterialCollection r100) {
            return BannerMaterial.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mbanners) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BannerMaterialCollection decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BannerMaterialCollection r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BannerMaterialCollection r101) throws IOException {
            BannerMaterial.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mbanners);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BannerMaterialCollection r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BannerMaterialCollection();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mbanners = Internal.copyOf("mbanners", this.mbanners);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BannerMaterialCollection.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BannerMaterialCollection(List<BannerMaterial> r100) {
        this(r100, ByteString.EMPTY);
    }

    public BannerMaterialCollection(List<BannerMaterial> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mbanners = Internal.immutableCopyOf("mbanners", r100);
    }
}
