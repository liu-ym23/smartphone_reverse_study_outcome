package com.bytedance.lark.pb.im.v1;

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
public final class CreateChatLastReadPositionRequest extends Message<CreateChatLastReadPositionRequest, Builder> {
    public static final ProtoAdapter<CreateChatLastReadPositionRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Float DEFAULT_OFFSET = null;
    public static final Integer DEFAULT_POSITION = null;
    public static final ProtoAdapter_CreateChatLastReadPositionRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final Float offset;
    public final Integer position;

    public static final class Builder extends Message.Builder<CreateChatLastReadPositionRequest, Builder> implements d<CreateChatLastReadPositionRequest> {
        public String chat_id;
        public Float offset;
        public Integer position;

        @Override // com.squareup.wire.Message.Builder
        public CreateChatLastReadPositionRequest build() {
            String r100 = this.chat_id;
            if (r100 == null) goto L9;
            if (this.position == null) goto L9;
            return new CreateChatLastReadPositionRequest(this.chat_id, this.position, this.offset, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "chat_id", this.position, "position"});
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

        public Builder offset(Float r100) {
            this.offset = r100;
            return this;
        }

        public Builder position(Integer r100) {
            this.position = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CreateChatLastReadPositionRequest extends ProtoAdapter<CreateChatLastReadPositionRequest> implements c<CreateChatLastReadPositionRequest> {
        public ProtoAdapter_CreateChatLastReadPositionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CreateChatLastReadPositionRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CreateChatLastReadPositionRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            r101.position = 0;
            r101.offset = Float.valueOf(0.0f);
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.offset = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CreateChatLastReadPositionRequest r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.chat_id) + ProtoAdapter.INT32.encodedSizeWithTag(2, r100.position);
            Float r102 = r100.offset;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.FLOAT.encodedSizeWithTag(3, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CreateChatLastReadPositionRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CreateChatLastReadPositionRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CreateChatLastReadPositionRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.chat_id);
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r101.position);
            Float r102 = r101.offset;
            if (r102 == null) goto L5;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 3, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CreateChatLastReadPositionRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CreateChatLastReadPositionRequest r100 = new ProtoAdapter_CreateChatLastReadPositionRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_POSITION = 0;
        DEFAULT_OFFSET = Float.valueOf(0.0f);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.position = this.position;
        r100.offset = this.offset;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CreateChatLastReadPositionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CreateChatLastReadPositionRequest(String r100, Integer r101, Float r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public CreateChatLastReadPositionRequest(String r100, Integer r101, Float r102, ByteString r103) {
        super(ADAPTER, r103);
        this.chat_id = r100;
        this.position = r101;
        this.offset = r102;
    }
}
