package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.Entity;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetThreadsByPositionsResponse extends Message<GetThreadsByPositionsResponse, Builder> {
    public static final ProtoAdapter<GetThreadsByPositionsResponse> ADAPTER = null;
    public static final ProtoAdapter_GetThreadsByPositionsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Entity entity;
    public final List<Integer> invalid_positions;

    public static final class Builder extends Message.Builder<GetThreadsByPositionsResponse, Builder> implements d<GetThreadsByPositionsResponse> {
        public Entity entity;
        public List<Integer> invalid_positions;

        @Override // com.squareup.wire.Message.Builder
        public GetThreadsByPositionsResponse build() {
            Entity r100 = this.entity;
            if (r100 == null) goto L7;
            return new GetThreadsByPositionsResponse(this.entity, this.invalid_positions, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "entity"});
        }

        public Builder() {
            this.invalid_positions = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder entity(Entity r100) {
            this.entity = r100;
            return this;
        }

        public Builder invalid_positions(List<Integer> r100) {
            Internal.checkElementsNotNull(r100);
            this.invalid_positions = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetThreadsByPositionsResponse extends ProtoAdapter<GetThreadsByPositionsResponse> implements c<GetThreadsByPositionsResponse> {
        public ProtoAdapter_GetThreadsByPositionsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetThreadsByPositionsResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetThreadsByPositionsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.entity = Entity.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.invalid_positions.add(ProtoAdapter.INT32.decode(r100));
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
        public int encodedSize2(GetThreadsByPositionsResponse r100) {
            return (Entity.ADAPTER.encodedSizeWithTag(1, r100.entity) + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(2, r100.invalid_positions)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetThreadsByPositionsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetThreadsByPositionsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetThreadsByPositionsResponse r101) throws IOException {
            Entity.ADAPTER.encodeWithTag(r100, 1, r101.entity);
            ProtoAdapter.INT32.asRepeated().encodeWithTag(r100, 2, r101.invalid_positions);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetThreadsByPositionsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetThreadsByPositionsResponse r100 = new ProtoAdapter_GetThreadsByPositionsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.entity = this.entity;
        r100.invalid_positions = Internal.copyOf("invalid_positions", this.invalid_positions);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetThreadsByPositionsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetThreadsByPositionsResponse(Entity r100, List<Integer> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetThreadsByPositionsResponse(Entity r100, List<Integer> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.entity = r100;
        this.invalid_positions = Internal.immutableCopyOf("invalid_positions", r101);
    }
}
