package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.Content;
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
public final class GetMessageActionPayloadRequest extends Message<GetMessageActionPayloadRequest, Builder> {
    public static final ProtoAdapter<GetMessageActionPayloadRequest> ADAPTER = null;
    public static final Content.SystemMessageAction.ActType DEFAULT_ACTION_TYPE = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final ProtoAdapter_GetMessageActionPayloadRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Content.SystemMessageAction.ActType action_type;
    public final String message_id;

    public static final class Builder extends Message.Builder<GetMessageActionPayloadRequest, Builder> implements d<GetMessageActionPayloadRequest> {
        public Content.SystemMessageAction.ActType action_type;
        public String message_id;

        @Override // com.squareup.wire.Message.Builder
        public GetMessageActionPayloadRequest build() {
            String r100 = this.message_id;
            if (r100 == null) goto L9;
            if (this.action_type == null) goto L9;
            return new GetMessageActionPayloadRequest(this.message_id, this.action_type, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, MusicAppletPage.KEY_MESSAGE_ID, this.action_type, "action_type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action_type(Content.SystemMessageAction.ActType r100) {
            this.action_type = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetMessageActionPayloadRequest extends ProtoAdapter<GetMessageActionPayloadRequest> implements c<GetMessageActionPayloadRequest> {
        public ProtoAdapter_GetMessageActionPayloadRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetMessageActionPayloadRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetMessageActionPayloadRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_id = "";
            r101.action_type = Content.SystemMessageAction.ActType.UNKNOWN_ACT_TYPE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.action_type = Content.SystemMessageAction.ActType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
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
        public int encodedSize2(GetMessageActionPayloadRequest r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.message_id) + Content.SystemMessageAction.ActType.ADAPTER.encodedSizeWithTag(2, r100.action_type)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetMessageActionPayloadRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetMessageActionPayloadRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetMessageActionPayloadRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.message_id);
            Content.SystemMessageAction.ActType.ADAPTER.encodeWithTag(r100, 2, r101.action_type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetMessageActionPayloadRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetMessageActionPayloadRequest r100 = new ProtoAdapter_GetMessageActionPayloadRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_ACTION_TYPE = Content.SystemMessageAction.ActType.UNKNOWN_ACT_TYPE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_id = this.message_id;
        r100.action_type = this.action_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetMessageActionPayloadRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetMessageActionPayloadRequest(String r100, Content.SystemMessageAction.ActType r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetMessageActionPayloadRequest(String r100, Content.SystemMessageAction.ActType r101, ByteString r102) {
        super(ADAPTER, r102);
        this.message_id = r100;
        this.action_type = r101;
    }
}
