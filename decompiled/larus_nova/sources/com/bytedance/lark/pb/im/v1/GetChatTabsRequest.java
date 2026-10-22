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
public final class GetChatTabsRequest extends Message<GetChatTabsRequest, Builder> {
    public static final ProtoAdapter<GetChatTabsRequest> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final SyncStrategy DEFAULT_STRATEGY = null;
    public static final ProtoAdapter_GetChatTabsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long chat_id;
    public final SyncStrategy strategy;

    public static final class Builder extends Message.Builder<GetChatTabsRequest, Builder> implements d<GetChatTabsRequest> {
        public Long chat_id;
        public SyncStrategy strategy;

        @Override // com.squareup.wire.Message.Builder
        public GetChatTabsRequest build() {
            return new GetChatTabsRequest(this.strategy, this.chat_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(Long r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder strategy(SyncStrategy r100) {
            this.strategy = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetChatTabsRequest extends ProtoAdapter<GetChatTabsRequest> implements c<GetChatTabsRequest> {
        public ProtoAdapter_GetChatTabsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetChatTabsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetChatTabsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.strategy = SyncStrategy.Sync;
            r101.chat_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.strategy = SyncStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.chat_id = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(GetChatTabsRequest r100) {
            SyncStrategy r101 = r100.strategy;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = SyncStrategy.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.chat_id;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetChatTabsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetChatTabsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetChatTabsRequest r101) throws IOException {
            SyncStrategy r102 = r101.strategy;
            if (r102 == null) goto L5;
            SyncStrategy.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.chat_id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetChatTabsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetChatTabsRequest r100 = new ProtoAdapter_GetChatTabsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_STRATEGY = SyncStrategy.Sync;
        DEFAULT_CHAT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.strategy = this.strategy;
        r100.chat_id = this.chat_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetChatTabsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetChatTabsRequest(SyncStrategy r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetChatTabsRequest(SyncStrategy r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.strategy = r100;
        this.chat_id = r101;
    }
}
