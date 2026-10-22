package com.bytedance.lark.pb.space.doc.v1;

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
public final class MGetDocFeedsResponse extends Message<MGetDocFeedsResponse, Builder> {
    public static final ProtoAdapter<MGetDocFeedsResponse> ADAPTER = null;
    public static final ProtoAdapter_MGetDocFeedsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Entity entity;

    public static final class Builder extends Message.Builder<MGetDocFeedsResponse, Builder> implements d<MGetDocFeedsResponse> {
        public Entity entity;

        @Override // com.squareup.wire.Message.Builder
        public MGetDocFeedsResponse build() {
            return new MGetDocFeedsResponse(this.entity, super.buildUnknownFields());
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
    }

    public static final class ProtoAdapter_MGetDocFeedsResponse extends ProtoAdapter<MGetDocFeedsResponse> implements c<MGetDocFeedsResponse> {
        public ProtoAdapter_MGetDocFeedsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, MGetDocFeedsResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MGetDocFeedsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 2) goto L7;
            r101.entity = Entity.ADAPTER.decode(r100);
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
        public int encodedSize2(MGetDocFeedsResponse r100) {
            Entity r101 = r100.entity;
            if (r101 == null) goto L5;
            int r102 = Entity.ADAPTER.encodedSizeWithTag(2, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MGetDocFeedsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MGetDocFeedsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MGetDocFeedsResponse r101) throws IOException {
            Entity r102 = r101.entity;
            if (r102 == null) goto L5;
            Entity.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MGetDocFeedsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_MGetDocFeedsResponse r100 = new ProtoAdapter_MGetDocFeedsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.entity = this.entity;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MGetDocFeedsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MGetDocFeedsResponse(Entity r100) {
        this(r100, ByteString.EMPTY);
    }

    public MGetDocFeedsResponse(Entity r100, ByteString r101) {
        super(ADAPTER, r101);
        this.entity = r100;
    }
}
