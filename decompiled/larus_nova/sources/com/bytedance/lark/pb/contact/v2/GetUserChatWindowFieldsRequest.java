package com.bytedance.lark.pb.contact.v2;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
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
public final class GetUserChatWindowFieldsRequest extends Message<GetUserChatWindowFieldsRequest, Builder> {
    public static final ProtoAdapter<GetUserChatWindowFieldsRequest> ADAPTER = null;
    public static final Boolean DEFAULT_IS_SUPPORT_MEMO_RICHTEXT = null;
    public static final SyncDataStrategy DEFAULT_SYNC_DATA_STRATEGY = null;
    public static final ProtoAdapter_GetUserChatWindowFieldsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_support_memo_richtext;
    public final SyncDataStrategy sync_data_strategy;
    public final List<String> user_id;

    public static final class Builder extends Message.Builder<GetUserChatWindowFieldsRequest, Builder> implements d<GetUserChatWindowFieldsRequest> {
        public Boolean is_support_memo_richtext;
        public SyncDataStrategy sync_data_strategy;
        public List<String> user_id;

        @Override // com.squareup.wire.Message.Builder
        public GetUserChatWindowFieldsRequest build() {
            return new GetUserChatWindowFieldsRequest(this.user_id, this.sync_data_strategy, this.is_support_memo_richtext, super.buildUnknownFields());
        }

        public Builder() {
            this.user_id = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_support_memo_richtext(Boolean r100) {
            this.is_support_memo_richtext = r100;
            return this;
        }

        public Builder sync_data_strategy(SyncDataStrategy r100) {
            this.sync_data_strategy = r100;
            return this;
        }

        public Builder user_id(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUserChatWindowFieldsRequest extends ProtoAdapter<GetUserChatWindowFieldsRequest> implements c<GetUserChatWindowFieldsRequest> {
        public ProtoAdapter_GetUserChatWindowFieldsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUserChatWindowFieldsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUserChatWindowFieldsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.sync_data_strategy = SyncDataStrategy.FORCE_SERVER;
            r101.is_support_memo_richtext = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.user_id.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.sync_data_strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.is_support_memo_richtext = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetUserChatWindowFieldsRequest r100) {
            int r101 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.user_id);
            SyncDataStrategy r102 = r100.sync_data_strategy;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.is_support_memo_richtext;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUserChatWindowFieldsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUserChatWindowFieldsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUserChatWindowFieldsRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.user_id);
            SyncDataStrategy r102 = r101.sync_data_strategy;
            if (r102 == null) goto L5;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            Boolean r103 = r101.is_support_memo_richtext;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUserChatWindowFieldsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetUserChatWindowFieldsRequest r100 = new ProtoAdapter_GetUserChatWindowFieldsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SYNC_DATA_STRATEGY = SyncDataStrategy.FORCE_SERVER;
        DEFAULT_IS_SUPPORT_MEMO_RICHTEXT = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_id = Internal.copyOf("user_id", this.user_id);
        r100.sync_data_strategy = this.sync_data_strategy;
        r100.is_support_memo_richtext = this.is_support_memo_richtext;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUserChatWindowFieldsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUserChatWindowFieldsRequest(List<String> r100, SyncDataStrategy r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetUserChatWindowFieldsRequest(List<String> r100, SyncDataStrategy r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.user_id = Internal.immutableCopyOf("user_id", r100);
        this.sync_data_strategy = r101;
        this.is_support_memo_richtext = r102;
    }
}
