package com.ss.android.lark.pb.improto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PipeEntity extends Message<PipeEntity, Builder> {
    public static final ProtoAdapter<PipeEntity> ADAPTER = null;
    public static final Long DEFAULT_ID = null;
    public static final String DEFAULT_TYPE = "";
    private static final long serialVersionUID = 0;
    public final Long mid;
    public final String mtype;

    public static final class Builder extends Message.Builder<PipeEntity, Builder> {
        public Long mid;
        public String mtype;

        @Override // com.squareup.wire.Message.Builder
        public PipeEntity build() {
            String r100 = this.mtype;
            if (r100 == null) goto L7;
            return new PipeEntity(this.mtype, this.mid, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, GearStrategyConsts.EV_MEDIA_TYPE});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder id(Long r100) {
            this.mid = r100;
            return this;
        }

        public Builder type(String r100) {
            this.mtype = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PipeEntity extends ProtoAdapter<PipeEntity> {
        public ProtoAdapter_PipeEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, PipeEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PipeEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mtype = "";
            r101.mid = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mtype = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 3) goto L9;
            r101.mid = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(PipeEntity r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.mtype);
            Long r102 = r100.mid;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(3, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PipeEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PipeEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PipeEntity r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.mtype);
            Long r102 = r101.mid;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PipeEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PipeEntity();
        DEFAULT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtype = this.mtype;
        r100.mid = this.mid;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PipeEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PipeEntity(String r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PipeEntity(String r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mtype = r100;
        this.mid = r101;
    }
}
