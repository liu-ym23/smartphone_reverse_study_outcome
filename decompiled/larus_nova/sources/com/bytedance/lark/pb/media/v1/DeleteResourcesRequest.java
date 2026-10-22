package com.bytedance.lark.pb.media.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class DeleteResourcesRequest extends Message<DeleteResourcesRequest, Builder> {
    public static final ProtoAdapter<DeleteResourcesRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> keys;

    public static final class Builder extends Message.Builder<DeleteResourcesRequest, Builder> {
        public List<String> keys;

        @Override // com.squareup.wire.Message.Builder
        public DeleteResourcesRequest build() {
            return new DeleteResourcesRequest(this.keys, super.buildUnknownFields());
        }

        public Builder() {
            this.keys = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.keys = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DeleteResourcesRequest extends ProtoAdapter<DeleteResourcesRequest> {
        public ProtoAdapter_DeleteResourcesRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, DeleteResourcesRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DeleteResourcesRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.keys.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(DeleteResourcesRequest r100) {
            return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.keys) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DeleteResourcesRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DeleteResourcesRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DeleteResourcesRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.keys);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DeleteResourcesRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DeleteResourcesRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.keys = Internal.copyOf("keys", this.keys);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DeleteResourcesRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DeleteResourcesRequest(List<String> r100) {
        this(r100, ByteString.EMPTY);
    }

    public DeleteResourcesRequest(List<String> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.keys = Internal.immutableCopyOf("keys", r100);
    }
}
