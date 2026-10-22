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
public final class DeleteMessagesRequest extends Message<DeleteMessagesRequest, Builder> {
    public static final ProtoAdapter<DeleteMessagesRequest> ADAPTER = null;
    public static final String DEFAULT_CID = "";
    public static final ProtoAdapter_DeleteMessagesRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String cid;
    public final List<String> ids;

    public static final class Builder extends Message.Builder<DeleteMessagesRequest, Builder> implements d<DeleteMessagesRequest> {
        public String cid;
        public List<String> ids;

        @Override // com.squareup.wire.Message.Builder
        public DeleteMessagesRequest build() {
            return new DeleteMessagesRequest(this.ids, this.cid, super.buildUnknownFields());
        }

        public Builder() {
            this.ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cid(String r100) {
            this.cid = r100;
            return this;
        }

        public Builder ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DeleteMessagesRequest extends ProtoAdapter<DeleteMessagesRequest> implements c<DeleteMessagesRequest> {
        public ProtoAdapter_DeleteMessagesRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, DeleteMessagesRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DeleteMessagesRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.cid = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.cid = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(DeleteMessagesRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.asRepeated().encodedSizeWithTag(1, r100.ids);
            String r103 = r100.cid;
            if (r103 == null) goto L5;
            int r104 = r101.encodedSizeWithTag(2, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DeleteMessagesRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DeleteMessagesRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DeleteMessagesRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 1, r101.ids);
            String r103 = r101.cid;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DeleteMessagesRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_DeleteMessagesRequest r100 = new ProtoAdapter_DeleteMessagesRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.ids = Internal.copyOf("ids", this.ids);
        r100.cid = this.cid;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DeleteMessagesRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DeleteMessagesRequest(List<String> r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public DeleteMessagesRequest(List<String> r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.ids = Internal.immutableCopyOf("ids", r100);
        this.cid = r101;
    }
}
