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
public final class FetchMessageReplyDraftRequest extends Message<FetchMessageReplyDraftRequest, Builder> {
    public static final ProtoAdapter<FetchMessageReplyDraftRequest> ADAPTER = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final ProtoAdapter_FetchMessageReplyDraftRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String message_id;

    public static final class Builder extends Message.Builder<FetchMessageReplyDraftRequest, Builder> implements d<FetchMessageReplyDraftRequest> {
        public String message_id;

        @Override // com.squareup.wire.Message.Builder
        public FetchMessageReplyDraftRequest build() {
            String r100 = this.message_id;
            if (r100 == null) goto L7;
            return new FetchMessageReplyDraftRequest(this.message_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, MusicAppletPage.KEY_MESSAGE_ID});
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
    }

    public static final class ProtoAdapter_FetchMessageReplyDraftRequest extends ProtoAdapter<FetchMessageReplyDraftRequest> implements c<FetchMessageReplyDraftRequest> {
        public ProtoAdapter_FetchMessageReplyDraftRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, FetchMessageReplyDraftRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FetchMessageReplyDraftRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.message_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(FetchMessageReplyDraftRequest r100) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.message_id) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FetchMessageReplyDraftRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FetchMessageReplyDraftRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FetchMessageReplyDraftRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.message_id);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FetchMessageReplyDraftRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_FetchMessageReplyDraftRequest r100 = new ProtoAdapter_FetchMessageReplyDraftRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_id = this.message_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FetchMessageReplyDraftRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FetchMessageReplyDraftRequest(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public FetchMessageReplyDraftRequest(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.message_id = r100;
    }
}
