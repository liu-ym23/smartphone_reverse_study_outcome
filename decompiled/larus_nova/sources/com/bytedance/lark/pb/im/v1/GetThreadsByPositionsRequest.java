package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.Channel;
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
public final class GetThreadsByPositionsRequest extends Message<GetThreadsByPositionsRequest, Builder> {
    public static final ProtoAdapter<GetThreadsByPositionsRequest> ADAPTER = null;
    public static final ProtoAdapter_GetThreadsByPositionsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Channel channel;
    public final List<Integer> positions;

    public static final class Builder extends Message.Builder<GetThreadsByPositionsRequest, Builder> implements d<GetThreadsByPositionsRequest> {
        public Channel channel;
        public List<Integer> positions;

        @Override // com.squareup.wire.Message.Builder
        public GetThreadsByPositionsRequest build() {
            Channel r100 = this.channel;
            if (r100 == null) goto L7;
            return new GetThreadsByPositionsRequest(this.channel, this.positions, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "channel"});
        }

        public Builder() {
            this.positions = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder channel(Channel r100) {
            this.channel = r100;
            return this;
        }

        public Builder positions(List<Integer> r100) {
            Internal.checkElementsNotNull(r100);
            this.positions = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetThreadsByPositionsRequest extends ProtoAdapter<GetThreadsByPositionsRequest> implements c<GetThreadsByPositionsRequest> {
        public ProtoAdapter_GetThreadsByPositionsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetThreadsByPositionsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetThreadsByPositionsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.channel = Channel.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.positions.add(ProtoAdapter.INT32.decode(r100));
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
        public int encodedSize2(GetThreadsByPositionsRequest r100) {
            return (Channel.ADAPTER.encodedSizeWithTag(1, r100.channel) + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(2, r100.positions)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetThreadsByPositionsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetThreadsByPositionsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetThreadsByPositionsRequest r101) throws IOException {
            Channel.ADAPTER.encodeWithTag(r100, 1, r101.channel);
            ProtoAdapter.INT32.asRepeated().encodeWithTag(r100, 2, r101.positions);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetThreadsByPositionsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetThreadsByPositionsRequest r100 = new ProtoAdapter_GetThreadsByPositionsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.channel = this.channel;
        r100.positions = Internal.copyOf("positions", this.positions);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetThreadsByPositionsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetThreadsByPositionsRequest(Channel r100, List<Integer> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetThreadsByPositionsRequest(Channel r100, List<Integer> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.channel = r100;
        this.positions = Internal.immutableCopyOf("positions", r101);
    }
}
