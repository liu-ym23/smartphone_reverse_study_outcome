package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class BlockByStrangerRelationLarkErrorExtra extends com.squareup.wire.Message<BlockByStrangerRelationLarkErrorExtra, Builder> {
    public static final ProtoAdapter<BlockByStrangerRelationLarkErrorExtra> ADAPTER = null;
    public static final Long DEFAULT_STRANGER_USER_ID = null;
    private static final long serialVersionUID = 0;
    public final Long mstranger_user_id;

    public static final class Builder extends com.squareup.wire.Message.Builder<BlockByStrangerRelationLarkErrorExtra, Builder> {
        public Long mstranger_user_id;

        @Override // com.squareup.wire.Message.Builder
        public BlockByStrangerRelationLarkErrorExtra build() {
            return new BlockByStrangerRelationLarkErrorExtra(this.mstranger_user_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder stranger_user_id(Long r100) {
            this.mstranger_user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BlockByStrangerRelationLarkErrorExtra extends ProtoAdapter<BlockByStrangerRelationLarkErrorExtra> {
        public ProtoAdapter_BlockByStrangerRelationLarkErrorExtra() {
            super(FieldEncoding.LENGTH_DELIMITED, BlockByStrangerRelationLarkErrorExtra.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BlockByStrangerRelationLarkErrorExtra decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mstranger_user_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mstranger_user_id = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(BlockByStrangerRelationLarkErrorExtra r100) {
            Long r101 = r100.mstranger_user_id;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BlockByStrangerRelationLarkErrorExtra decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BlockByStrangerRelationLarkErrorExtra r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BlockByStrangerRelationLarkErrorExtra r101) throws IOException {
            Long r102 = r101.mstranger_user_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BlockByStrangerRelationLarkErrorExtra r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BlockByStrangerRelationLarkErrorExtra();
        DEFAULT_STRANGER_USER_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mstranger_user_id = this.mstranger_user_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BlockByStrangerRelationLarkErrorExtra.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public BlockByStrangerRelationLarkErrorExtra(Long r100) {
        this(r100, ByteString.EMPTY);
    }

    public BlockByStrangerRelationLarkErrorExtra(Long r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mstranger_user_id = r100;
    }
}
