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
public final class DeleteResourcesResponse extends Message<DeleteResourcesResponse, Builder> {
    public static final ProtoAdapter<DeleteResourcesResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> success_keys;

    public static final class Builder extends Message.Builder<DeleteResourcesResponse, Builder> {
        public List<String> success_keys;

        @Override // com.squareup.wire.Message.Builder
        public DeleteResourcesResponse build() {
            return new DeleteResourcesResponse(this.success_keys, super.buildUnknownFields());
        }

        public Builder() {
            this.success_keys = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder success_keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.success_keys = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DeleteResourcesResponse extends ProtoAdapter<DeleteResourcesResponse> {
        public ProtoAdapter_DeleteResourcesResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, DeleteResourcesResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DeleteResourcesResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.success_keys.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(DeleteResourcesResponse r100) {
            return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.success_keys) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DeleteResourcesResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DeleteResourcesResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DeleteResourcesResponse r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.success_keys);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DeleteResourcesResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DeleteResourcesResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.success_keys = Internal.copyOf("success_keys", this.success_keys);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DeleteResourcesResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DeleteResourcesResponse(List<String> r100) {
        this(r100, ByteString.EMPTY);
    }

    public DeleteResourcesResponse(List<String> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.success_keys = Internal.immutableCopyOf("success_keys", r100);
    }
}
