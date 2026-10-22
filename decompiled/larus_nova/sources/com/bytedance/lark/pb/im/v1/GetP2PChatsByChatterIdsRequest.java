package com.bytedance.lark.pb.im.v1;

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
public final class GetP2PChatsByChatterIdsRequest extends Message<GetP2PChatsByChatterIdsRequest, Builder> {
    public static final ProtoAdapter<GetP2PChatsByChatterIdsRequest> ADAPTER = null;
    public static final ProtoAdapter_GetP2PChatsByChatterIdsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> chatter_ids;

    public static final class Builder extends Message.Builder<GetP2PChatsByChatterIdsRequest, Builder> implements d<GetP2PChatsByChatterIdsRequest> {
        public List<String> chatter_ids;

        @Override // com.squareup.wire.Message.Builder
        public GetP2PChatsByChatterIdsRequest build() {
            return new GetP2PChatsByChatterIdsRequest(this.chatter_ids, super.buildUnknownFields());
        }

        public Builder() {
            this.chatter_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chatter_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.chatter_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetP2PChatsByChatterIdsRequest extends ProtoAdapter<GetP2PChatsByChatterIdsRequest> implements c<GetP2PChatsByChatterIdsRequest> {
        public ProtoAdapter_GetP2PChatsByChatterIdsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetP2PChatsByChatterIdsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetP2PChatsByChatterIdsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.chatter_ids.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(GetP2PChatsByChatterIdsRequest r100) {
            return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.chatter_ids) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetP2PChatsByChatterIdsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetP2PChatsByChatterIdsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetP2PChatsByChatterIdsRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.chatter_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetP2PChatsByChatterIdsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetP2PChatsByChatterIdsRequest r100 = new ProtoAdapter_GetP2PChatsByChatterIdsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chatter_ids = Internal.copyOf("chatter_ids", this.chatter_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetP2PChatsByChatterIdsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetP2PChatsByChatterIdsRequest(List<String> r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetP2PChatsByChatterIdsRequest(List<String> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.chatter_ids = Internal.immutableCopyOf("chatter_ids", r100);
    }
}
