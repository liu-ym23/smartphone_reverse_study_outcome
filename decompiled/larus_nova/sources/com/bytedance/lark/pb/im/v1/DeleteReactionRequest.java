package com.bytedance.lark.pb.im.v1;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class DeleteReactionRequest extends Message<DeleteReactionRequest, Builder> {
    public static final ProtoAdapter<DeleteReactionRequest> ADAPTER = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final String DEFAULT_TYPE = "";
    public static final ProtoAdapter_DeleteReactionRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String message_id;
    public final String type;

    public static final class Builder extends Message.Builder<DeleteReactionRequest, Builder> implements d<DeleteReactionRequest> {
        public String message_id;
        public String type;

        @Override // com.squareup.wire.Message.Builder
        public DeleteReactionRequest build() {
            String r100 = this.message_id;
            if (r100 == null) goto L9;
            if (this.type == null) goto L9;
            return new DeleteReactionRequest(this.message_id, this.type, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, MusicAppletPage.KEY_MESSAGE_ID, this.type, "type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder type(String r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DeleteReactionRequest extends ProtoAdapter<DeleteReactionRequest> implements c<DeleteReactionRequest> {
        public ProtoAdapter_DeleteReactionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, DeleteReactionRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DeleteReactionRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_id = "";
            r101.type = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.type = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(DeleteReactionRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (r101.encodedSizeWithTag(1, r100.message_id) + r101.encodedSizeWithTag(2, r100.type)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DeleteReactionRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DeleteReactionRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DeleteReactionRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.message_id);
            r102.encodeWithTag(r100, 2, r101.type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DeleteReactionRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_DeleteReactionRequest r100 = new ProtoAdapter_DeleteReactionRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_id = this.message_id;
        r100.type = this.type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DeleteReactionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DeleteReactionRequest(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public DeleteReactionRequest(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.message_id = r100;
        this.type = r101;
    }
}
