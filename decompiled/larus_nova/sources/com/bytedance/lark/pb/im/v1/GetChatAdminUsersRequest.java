package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
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
public final class GetChatAdminUsersRequest extends Message<GetChatAdminUsersRequest, Builder> {
    public static final ProtoAdapter<GetChatAdminUsersRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final SyncDataStrategy DEFAULT_SYNC_DATA_STRATEGY = null;
    public static final ProtoAdapter_GetChatAdminUsersRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final SyncDataStrategy sync_data_strategy;

    public static final class Builder extends Message.Builder<GetChatAdminUsersRequest, Builder> implements d<GetChatAdminUsersRequest> {
        public String chat_id;
        public SyncDataStrategy sync_data_strategy;

        @Override // com.squareup.wire.Message.Builder
        public GetChatAdminUsersRequest build() {
            String r100 = this.chat_id;
            if (r100 == null) goto L9;
            if (this.sync_data_strategy == null) goto L9;
            return new GetChatAdminUsersRequest(this.chat_id, this.sync_data_strategy, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "chat_id", this.sync_data_strategy, "sync_data_strategy"});
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

        public Builder sync_data_strategy(SyncDataStrategy r100) {
            this.sync_data_strategy = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetChatAdminUsersRequest extends ProtoAdapter<GetChatAdminUsersRequest> implements c<GetChatAdminUsersRequest> {
        public ProtoAdapter_GetChatAdminUsersRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetChatAdminUsersRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetChatAdminUsersRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            r101.sync_data_strategy = SyncDataStrategy.LOCAL;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.sync_data_strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
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
        public int encodedSize2(GetChatAdminUsersRequest r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.chat_id) + SyncDataStrategy.ADAPTER.encodedSizeWithTag(2, r100.sync_data_strategy)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetChatAdminUsersRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetChatAdminUsersRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetChatAdminUsersRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.chat_id);
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 2, r101.sync_data_strategy);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetChatAdminUsersRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetChatAdminUsersRequest r100 = new ProtoAdapter_GetChatAdminUsersRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SYNC_DATA_STRATEGY = SyncDataStrategy.LOCAL;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.sync_data_strategy = this.sync_data_strategy;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetChatAdminUsersRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetChatAdminUsersRequest(String r100, SyncDataStrategy r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetChatAdminUsersRequest(String r100, SyncDataStrategy r101, ByteString r102) {
        super(ADAPTER, r102);
        this.chat_id = r100;
        this.sync_data_strategy = r101;
    }
}
