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
public final class CreateAILikeFeedbackRequest extends Message<CreateAILikeFeedbackRequest, Builder> {
    public static final ProtoAdapter<CreateAILikeFeedbackRequest> ADAPTER = null;
    public static final Boolean DEFAULT_IS_DELETE = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final Boolean DEFAULT_PRAISE = null;
    public static final ProtoAdapter_CreateAILikeFeedbackRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_delete;
    public final String message_id;
    public final Boolean praise;

    public static final class Builder extends Message.Builder<CreateAILikeFeedbackRequest, Builder> implements d<CreateAILikeFeedbackRequest> {
        public Boolean is_delete;
        public String message_id;
        public Boolean praise;

        @Override // com.squareup.wire.Message.Builder
        public CreateAILikeFeedbackRequest build() {
            return new CreateAILikeFeedbackRequest(this.message_id, this.praise, this.is_delete, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_delete(Boolean r100) {
            this.is_delete = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder praise(Boolean r100) {
            this.praise = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CreateAILikeFeedbackRequest extends ProtoAdapter<CreateAILikeFeedbackRequest> implements c<CreateAILikeFeedbackRequest> {
        public ProtoAdapter_CreateAILikeFeedbackRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CreateAILikeFeedbackRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CreateAILikeFeedbackRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_id = "";
            Boolean r102 = Boolean.FALSE;
            r101.praise = r102;
            r101.is_delete = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L15;
            if (r104 != 1) goto L8;
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.praise = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L11;
            r101.is_delete = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CreateAILikeFeedbackRequest r100) {
            String r101 = r100.message_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.praise;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.is_delete;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CreateAILikeFeedbackRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CreateAILikeFeedbackRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CreateAILikeFeedbackRequest r101) throws IOException {
            String r102 = r101.message_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.praise;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.is_delete;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CreateAILikeFeedbackRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CreateAILikeFeedbackRequest r100 = new ProtoAdapter_CreateAILikeFeedbackRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_PRAISE = r101;
        DEFAULT_IS_DELETE = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_id = this.message_id;
        r100.praise = this.praise;
        r100.is_delete = this.is_delete;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CreateAILikeFeedbackRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CreateAILikeFeedbackRequest(String r100, Boolean r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public CreateAILikeFeedbackRequest(String r100, Boolean r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.message_id = r100;
        this.praise = r101;
        this.is_delete = r102;
    }
}
