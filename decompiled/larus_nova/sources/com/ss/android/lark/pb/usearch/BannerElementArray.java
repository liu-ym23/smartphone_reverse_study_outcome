package com.ss.android.lark.pb.usearch;

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
public final class BannerElementArray extends Message<BannerElementArray, Builder> {
    public static final ProtoAdapter<BannerElementArray> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Alignment malignment;
    public final List<BannerElement> melements;

    public static final class Builder extends Message.Builder<BannerElementArray, Builder> {
        public Alignment malignment;
        public List<BannerElement> melements;

        @Override // com.squareup.wire.Message.Builder
        public BannerElementArray build() {
            return new BannerElementArray(this.melements, this.malignment, super.buildUnknownFields());
        }

        public Builder() {
            this.melements = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder alignment(Alignment r100) {
            this.malignment = r100;
            return this;
        }

        public Builder elements(List<BannerElement> r100) {
            Internal.checkElementsNotNull(r100);
            this.melements = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BannerElementArray extends ProtoAdapter<BannerElementArray> {
        public ProtoAdapter_BannerElementArray() {
            super(FieldEncoding.LENGTH_DELIMITED, BannerElementArray.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BannerElementArray decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.melements.add(BannerElement.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.malignment = Alignment.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BannerElementArray r100) {
            int r101 = BannerElement.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.melements);
            Alignment r102 = r100.malignment;
            if (r102 == null) goto L5;
            int r103 = Alignment.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BannerElementArray decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BannerElementArray r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BannerElementArray r101) throws IOException {
            BannerElement.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.melements);
            Alignment r102 = r101.malignment;
            if (r102 == null) goto L5;
            Alignment.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BannerElementArray r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BannerElementArray();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.melements = Internal.copyOf("melements", this.melements);
        r100.malignment = this.malignment;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BannerElementArray.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BannerElementArray(List<BannerElement> r100, Alignment r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public BannerElementArray(List<BannerElement> r100, Alignment r101, ByteString r102) {
        super(ADAPTER, r102);
        this.melements = Internal.immutableCopyOf("melements", r100);
        this.malignment = r101;
    }
}
