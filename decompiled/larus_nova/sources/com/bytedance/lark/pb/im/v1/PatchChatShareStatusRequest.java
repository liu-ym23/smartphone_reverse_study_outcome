package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.ChatShareInfo;
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
public final class PatchChatShareStatusRequest extends Message<PatchChatShareStatusRequest, Builder> {
    public static final ProtoAdapter<PatchChatShareStatusRequest> ADAPTER = null;
    public static final ChatShareInfo.ShareStatus DEFAULT_STATUS = null;
    public static final ProtoAdapter_PatchChatShareStatusRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ChatShareInfo.ShareStatus status;
    public final List<String> tokens;

    public static final class Builder extends Message.Builder<PatchChatShareStatusRequest, Builder> implements d<PatchChatShareStatusRequest> {
        public ChatShareInfo.ShareStatus status;
        public List<String> tokens;

        @Override // com.squareup.wire.Message.Builder
        public PatchChatShareStatusRequest build() {
            ChatShareInfo.ShareStatus r100 = this.status;
            if (r100 == null) goto L7;
            return new PatchChatShareStatusRequest(this.tokens, this.status, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "status"});
        }

        public Builder() {
            this.tokens = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder status(ChatShareInfo.ShareStatus r100) {
            this.status = r100;
            return this;
        }

        public Builder tokens(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.tokens = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PatchChatShareStatusRequest extends ProtoAdapter<PatchChatShareStatusRequest> implements c<PatchChatShareStatusRequest> {
        public ProtoAdapter_PatchChatShareStatusRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PatchChatShareStatusRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PatchChatShareStatusRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.status = ChatShareInfo.ShareStatus.UNKNOWN_STATE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.tokens.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.status = ChatShareInfo.ShareStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PatchChatShareStatusRequest r100) {
            return (ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.tokens) + ChatShareInfo.ShareStatus.ADAPTER.encodedSizeWithTag(2, r100.status)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PatchChatShareStatusRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PatchChatShareStatusRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PatchChatShareStatusRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.tokens);
            ChatShareInfo.ShareStatus.ADAPTER.encodeWithTag(r100, 2, r101.status);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PatchChatShareStatusRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PatchChatShareStatusRequest r100 = new ProtoAdapter_PatchChatShareStatusRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_STATUS = ChatShareInfo.ShareStatus.UNKNOWN_STATE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.tokens = Internal.copyOf("tokens", this.tokens);
        r100.status = this.status;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PatchChatShareStatusRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PatchChatShareStatusRequest(List<String> r100, ChatShareInfo.ShareStatus r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PatchChatShareStatusRequest(List<String> r100, ChatShareInfo.ShareStatus r101, ByteString r102) {
        super(ADAPTER, r102);
        this.tokens = Internal.immutableCopyOf("tokens", r100);
        this.status = r101;
    }
}
