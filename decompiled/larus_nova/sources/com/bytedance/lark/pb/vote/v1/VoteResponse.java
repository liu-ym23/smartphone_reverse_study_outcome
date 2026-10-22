package com.bytedance.lark.pb.vote.v1;

import com.bytedance.lark.pb.basic.v1.Entity;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class VoteResponse extends Message<VoteResponse, Builder> {
    public static final ProtoAdapter<VoteResponse> ADAPTER = null;
    public static final Long DEFAULT_VOTE_ID = null;
    public static final ProtoAdapter_VoteResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Entity entity;
    public final Long vote_id;

    public static final class Builder extends Message.Builder<VoteResponse, Builder> implements d<VoteResponse> {
        public Entity entity;
        public Long vote_id;

        @Override // com.squareup.wire.Message.Builder
        public VoteResponse build() {
            return new VoteResponse(this.vote_id, this.entity, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder entity(Entity r100) {
            this.entity = r100;
            return this;
        }

        public Builder vote_id(Long r100) {
            this.vote_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_VoteResponse extends ProtoAdapter<VoteResponse> implements c<VoteResponse> {
        public ProtoAdapter_VoteResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, VoteResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public VoteResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.vote_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.vote_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.entity = Entity.ADAPTER.decode(r100);
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
        public int encodedSize2(VoteResponse r100) {
            Long r101 = r100.vote_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Entity r104 = r100.entity;
            if (r104 == null) goto L10;
            r102 = Entity.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ VoteResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(VoteResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, VoteResponse r101) throws IOException {
            Long r102 = r101.vote_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Entity r103 = r101.entity;
            if (r103 == null) goto L8;
            Entity.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, VoteResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_VoteResponse r100 = new ProtoAdapter_VoteResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_VOTE_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.vote_id = this.vote_id;
        r100.entity = this.entity;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return VoteResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public VoteResponse(Long r100, Entity r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public VoteResponse(Long r100, Entity r101, ByteString r102) {
        super(ADAPTER, r102);
        this.vote_id = r100;
        this.entity = r101;
    }
}
