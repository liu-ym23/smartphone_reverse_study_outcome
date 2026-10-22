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
public final class UpdateLocalSystemMessageVisibilityRequest extends Message<UpdateLocalSystemMessageVisibilityRequest, Builder> {
    public static final ProtoAdapter<UpdateLocalSystemMessageVisibilityRequest> ADAPTER = null;
    public static final String DEFAULT_LOCAL_MESSAGE_ID = "";
    public static final Boolean DEFAULT_VISIBLE = null;
    public static final ProtoAdapter_UpdateLocalSystemMessageVisibilityRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String local_message_id;
    public final Boolean visible;

    public static final class Builder extends Message.Builder<UpdateLocalSystemMessageVisibilityRequest, Builder> implements d<UpdateLocalSystemMessageVisibilityRequest> {
        public String local_message_id;
        public Boolean visible;

        @Override // com.squareup.wire.Message.Builder
        public UpdateLocalSystemMessageVisibilityRequest build() {
            String r100 = this.local_message_id;
            if (r100 == null) goto L9;
            if (this.visible == null) goto L9;
            return new UpdateLocalSystemMessageVisibilityRequest(this.local_message_id, this.visible, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "local_message_id", this.visible, "visible"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder local_message_id(String r100) {
            this.local_message_id = r100;
            return this;
        }

        public Builder visible(Boolean r100) {
            this.visible = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateLocalSystemMessageVisibilityRequest extends ProtoAdapter<UpdateLocalSystemMessageVisibilityRequest> implements c<UpdateLocalSystemMessageVisibilityRequest> {
        public ProtoAdapter_UpdateLocalSystemMessageVisibilityRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateLocalSystemMessageVisibilityRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateLocalSystemMessageVisibilityRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.local_message_id = "";
            r101.visible = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.local_message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.visible = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(UpdateLocalSystemMessageVisibilityRequest r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.local_message_id) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.visible)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateLocalSystemMessageVisibilityRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateLocalSystemMessageVisibilityRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateLocalSystemMessageVisibilityRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.local_message_id);
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.visible);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateLocalSystemMessageVisibilityRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateLocalSystemMessageVisibilityRequest r100 = new ProtoAdapter_UpdateLocalSystemMessageVisibilityRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_VISIBLE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.local_message_id = this.local_message_id;
        r100.visible = this.visible;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateLocalSystemMessageVisibilityRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateLocalSystemMessageVisibilityRequest(String r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public UpdateLocalSystemMessageVisibilityRequest(String r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.local_message_id = r100;
        this.visible = r101;
    }
}
