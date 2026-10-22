package com.bytedance.lark.pb.ugreach.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ReachPointMaterial extends Message<ReachPointMaterial, Builder> {
    public static final ProtoAdapter<ReachPointMaterial> ADAPTER = null;
    public static final ByteString DEFAULT_MATERIAL = null;
    public static final Long DEFAULT_MATERIAL_ID = null;
    public static final String DEFAULT_MATERIAL_KEY = "";
    private static final long serialVersionUID = 0;
    public final ByteString material;
    public final Long material_id;
    public final String material_key;

    public static final class Builder extends Message.Builder<ReachPointMaterial, Builder> {
        public ByteString material;
        public Long material_id;
        public String material_key;

        @Override // com.squareup.wire.Message.Builder
        public ReachPointMaterial build() {
            return new ReachPointMaterial(this.material_id, this.material_key, this.material, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder material(ByteString r100) {
            this.material = r100;
            return this;
        }

        public Builder material_id(Long r100) {
            this.material_id = r100;
            return this;
        }

        public Builder material_key(String r100) {
            this.material_key = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ReachPointMaterial extends ProtoAdapter<ReachPointMaterial> {
        public ProtoAdapter_ReachPointMaterial() {
            super(FieldEncoding.LENGTH_DELIMITED, ReachPointMaterial.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ReachPointMaterial decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.material_id = 0L;
            r101.material_key = "";
            r101.material = ByteString.EMPTY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.material_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.material_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.material = ProtoAdapter.BYTES.decode(r100);
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
        public int encodedSize2(ReachPointMaterial r100) {
            Long r101 = r100.material_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.material_key;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ByteString r107 = r100.material;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.BYTES.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ReachPointMaterial decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ReachPointMaterial r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ReachPointMaterial r101) throws IOException {
            Long r102 = r101.material_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.material_key;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            ByteString r104 = r101.material;
            if (r104 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ReachPointMaterial r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ReachPointMaterial();
        DEFAULT_MATERIAL_ID = 0L;
        DEFAULT_MATERIAL = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.material_id = this.material_id;
        r100.material_key = this.material_key;
        r100.material = this.material;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ReachPointMaterial.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ReachPointMaterial(Long r100, String r101, ByteString r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ReachPointMaterial(Long r100, String r101, ByteString r102, ByteString r103) {
        super(ADAPTER, r103);
        this.material_id = r100;
        this.material_key = r101;
        this.material = r102;
    }
}
