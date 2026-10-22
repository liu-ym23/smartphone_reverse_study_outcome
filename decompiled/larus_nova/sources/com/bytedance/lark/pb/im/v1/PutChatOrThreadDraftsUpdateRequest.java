package com.bytedance.lark.pb.im.v1;

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
public final class PutChatOrThreadDraftsUpdateRequest extends Message<PutChatOrThreadDraftsUpdateRequest, Builder> {
    public static final ProtoAdapter<PutChatOrThreadDraftsUpdateRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_CHAT_INPUT_DRAFT_ID = "";
    public static final String DEFAULT_CHAT_TYPE = "";
    public static final String DEFAULT_CHAT_TYPE_DETAIL = "";
    public static final String DEFAULT_THREAD_ID = "";
    public static final ProtoAdapter_PutChatOrThreadDraftsUpdateRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final String chat_input_draft_id;
    public final String chat_type;
    public final String chat_type_detail;
    public final String thread_id;

    public static final class Builder extends Message.Builder<PutChatOrThreadDraftsUpdateRequest, Builder> implements d<PutChatOrThreadDraftsUpdateRequest> {
        public String chat_id;
        public String chat_input_draft_id;
        public String chat_type;
        public String chat_type_detail;
        public String thread_id;

        @Override // com.squareup.wire.Message.Builder
        public PutChatOrThreadDraftsUpdateRequest build() {
            return new PutChatOrThreadDraftsUpdateRequest(this.chat_id, this.thread_id, this.chat_input_draft_id, this.chat_type, this.chat_type_detail, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder chat_input_draft_id(String r100) {
            this.chat_input_draft_id = r100;
            return this;
        }

        public Builder chat_type(String r100) {
            this.chat_type = r100;
            return this;
        }

        public Builder chat_type_detail(String r100) {
            this.chat_type_detail = r100;
            return this;
        }

        public Builder thread_id(String r100) {
            this.thread_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PutChatOrThreadDraftsUpdateRequest extends ProtoAdapter<PutChatOrThreadDraftsUpdateRequest> implements c<PutChatOrThreadDraftsUpdateRequest> {
        public ProtoAdapter_PutChatOrThreadDraftsUpdateRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PutChatOrThreadDraftsUpdateRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PutChatOrThreadDraftsUpdateRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            r101.thread_id = "";
            r101.chat_input_draft_id = "";
            r101.chat_type = "";
            r101.chat_type_detail = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.thread_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.chat_input_draft_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.chat_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.chat_type_detail = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PutChatOrThreadDraftsUpdateRequest r100) {
            String r101 = r100.chat_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.thread_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.chat_input_draft_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.chat_type;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.chat_type_detail;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PutChatOrThreadDraftsUpdateRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PutChatOrThreadDraftsUpdateRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PutChatOrThreadDraftsUpdateRequest r101) throws IOException {
            String r102 = r101.chat_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.thread_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.chat_input_draft_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.chat_type;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.chat_type_detail;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PutChatOrThreadDraftsUpdateRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PutChatOrThreadDraftsUpdateRequest r100 = new ProtoAdapter_PutChatOrThreadDraftsUpdateRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.thread_id = this.thread_id;
        r100.chat_input_draft_id = this.chat_input_draft_id;
        r100.chat_type = this.chat_type;
        r100.chat_type_detail = this.chat_type_detail;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PutChatOrThreadDraftsUpdateRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PutChatOrThreadDraftsUpdateRequest(String r100, String r101, String r110, String r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public PutChatOrThreadDraftsUpdateRequest(String r100, String r101, String r102, String r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.chat_id = r100;
        this.thread_id = r101;
        this.chat_input_draft_id = r102;
        this.chat_type = r103;
        this.chat_type_detail = r104;
    }
}
