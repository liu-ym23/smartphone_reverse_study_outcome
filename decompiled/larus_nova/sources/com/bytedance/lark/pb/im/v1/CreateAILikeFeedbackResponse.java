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
public final class CreateAILikeFeedbackResponse extends Message<CreateAILikeFeedbackResponse, Builder> {
    public static final ProtoAdapter<CreateAILikeFeedbackResponse> ADAPTER = null;
    public static final String DEFAULT_AI_MESSAGE_ID = "";
    public static final String DEFAULT_SCENE = "";
    public static final ProtoAdapter_CreateAILikeFeedbackResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String ai_message_id;
    public final String scene;

    public static final class Builder extends Message.Builder<CreateAILikeFeedbackResponse, Builder> implements d<CreateAILikeFeedbackResponse> {
        public String ai_message_id;
        public String scene;

        @Override // com.squareup.wire.Message.Builder
        public CreateAILikeFeedbackResponse build() {
            return new CreateAILikeFeedbackResponse(this.ai_message_id, this.scene, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ai_message_id(String r100) {
            this.ai_message_id = r100;
            return this;
        }

        public Builder scene(String r100) {
            this.scene = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CreateAILikeFeedbackResponse extends ProtoAdapter<CreateAILikeFeedbackResponse> implements c<CreateAILikeFeedbackResponse> {
        public ProtoAdapter_CreateAILikeFeedbackResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, CreateAILikeFeedbackResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CreateAILikeFeedbackResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.ai_message_id = "";
            r101.scene = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.ai_message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.scene = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(CreateAILikeFeedbackResponse r100) {
            String r101 = r100.ai_message_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.scene;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CreateAILikeFeedbackResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CreateAILikeFeedbackResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CreateAILikeFeedbackResponse r101) throws IOException {
            String r102 = r101.ai_message_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.scene;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CreateAILikeFeedbackResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CreateAILikeFeedbackResponse r100 = new ProtoAdapter_CreateAILikeFeedbackResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.ai_message_id = this.ai_message_id;
        r100.scene = this.scene;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CreateAILikeFeedbackResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CreateAILikeFeedbackResponse(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CreateAILikeFeedbackResponse(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.ai_message_id = r100;
        this.scene = r101;
    }
}
