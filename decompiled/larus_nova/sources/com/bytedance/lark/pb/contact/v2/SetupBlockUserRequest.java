package com.bytedance.lark.pb.contact.v2;

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
public final class SetupBlockUserRequest extends Message<SetupBlockUserRequest, Builder> {
    public static final ProtoAdapter<SetupBlockUserRequest> ADAPTER = null;
    public static final Boolean DEFAULT_BLOCK_STATUS = null;
    public static final String DEFAULT_BLOCK_USER_ID = "";
    public static final ProtoAdapter_SetupBlockUserRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean block_status;
    public final String block_user_id;

    public static final class Builder extends Message.Builder<SetupBlockUserRequest, Builder> implements d<SetupBlockUserRequest> {
        public Boolean block_status;
        public String block_user_id;

        @Override // com.squareup.wire.Message.Builder
        public SetupBlockUserRequest build() {
            String r100 = this.block_user_id;
            if (r100 == null) goto L9;
            if (this.block_status == null) goto L9;
            return new SetupBlockUserRequest(this.block_user_id, this.block_status, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "block_user_id", this.block_status, "block_status"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder block_status(Boolean r100) {
            this.block_status = r100;
            return this;
        }

        public Builder block_user_id(String r100) {
            this.block_user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SetupBlockUserRequest extends ProtoAdapter<SetupBlockUserRequest> implements c<SetupBlockUserRequest> {
        public ProtoAdapter_SetupBlockUserRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SetupBlockUserRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SetupBlockUserRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.block_user_id = "";
            r101.block_status = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.block_user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.block_status = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(SetupBlockUserRequest r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.block_user_id) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.block_status)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SetupBlockUserRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SetupBlockUserRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SetupBlockUserRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.block_user_id);
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.block_status);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SetupBlockUserRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SetupBlockUserRequest r100 = new ProtoAdapter_SetupBlockUserRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_BLOCK_STATUS = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.block_user_id = this.block_user_id;
        r100.block_status = this.block_status;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SetupBlockUserRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SetupBlockUserRequest(String r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SetupBlockUserRequest(String r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.block_user_id = r100;
        this.block_status = r101;
    }
}
