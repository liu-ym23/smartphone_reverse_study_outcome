package com.bytedance.lark.pb.feed.v1;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
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
public final class GetRecentTransmitTargetsRequest extends Message<GetRecentTransmitTargetsRequest, Builder> {
    public static final ProtoAdapter<GetRecentTransmitTargetsRequest> ADAPTER = null;
    public static final Boolean DEFAULT_FILTER_CROSS_TENANT_CHAT = null;
    public static final Boolean DEFAULT_FILTER_CROSS_TENANT_THREAD = null;
    public static final Boolean DEFAULT_FILTER_GROUP_CHAT = null;
    public static final Boolean DEFAULT_FILTER_MYSELF = null;
    public static final Boolean DEFAULT_FILTER_P2P_CHAT = null;
    public static final Boolean DEFAULT_FILTER_THREAD_CHAT = null;
    public static final Boolean DEFAULT_INCLUDE_MY_AI = null;
    public static final Integer DEFAULT_LIMIT = null;
    public static final SyncDataStrategy DEFAULT_SYNC_DATA_STRATEGY = null;
    public static final ProtoAdapter_GetRecentTransmitTargetsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean filter_cross_tenant_chat;
    public final Boolean filter_cross_tenant_thread;
    public final Boolean filter_group_chat;
    public final Boolean filter_myself;
    public final Boolean filter_p2p_chat;
    public final Boolean filter_thread_chat;
    public final Boolean include_my_ai;
    public final Integer limit;
    public final SyncDataStrategy sync_data_strategy;

    public static final class Builder extends Message.Builder<GetRecentTransmitTargetsRequest, Builder> implements d<GetRecentTransmitTargetsRequest> {
        public Boolean filter_cross_tenant_chat;
        public Boolean filter_cross_tenant_thread;
        public Boolean filter_group_chat;
        public Boolean filter_myself;
        public Boolean filter_p2p_chat;
        public Boolean filter_thread_chat;
        public Boolean include_my_ai;
        public Integer limit;
        public SyncDataStrategy sync_data_strategy;

        @Override // com.squareup.wire.Message.Builder
        public GetRecentTransmitTargetsRequest build() {
            return new GetRecentTransmitTargetsRequest(this.limit, this.filter_group_chat, this.filter_p2p_chat, this.filter_thread_chat, this.filter_cross_tenant_chat, this.filter_myself, this.include_my_ai, this.sync_data_strategy, this.filter_cross_tenant_thread, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder filter_cross_tenant_chat(Boolean r100) {
            this.filter_cross_tenant_chat = r100;
            return this;
        }

        public Builder filter_cross_tenant_thread(Boolean r100) {
            this.filter_cross_tenant_thread = r100;
            return this;
        }

        public Builder filter_group_chat(Boolean r100) {
            this.filter_group_chat = r100;
            return this;
        }

        public Builder filter_myself(Boolean r100) {
            this.filter_myself = r100;
            return this;
        }

        public Builder filter_p2p_chat(Boolean r100) {
            this.filter_p2p_chat = r100;
            return this;
        }

        public Builder filter_thread_chat(Boolean r100) {
            this.filter_thread_chat = r100;
            return this;
        }

        public Builder include_my_ai(Boolean r100) {
            this.include_my_ai = r100;
            return this;
        }

        public Builder limit(Integer r100) {
            this.limit = r100;
            return this;
        }

        public Builder sync_data_strategy(SyncDataStrategy r100) {
            this.sync_data_strategy = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetRecentTransmitTargetsRequest extends ProtoAdapter<GetRecentTransmitTargetsRequest> implements c<GetRecentTransmitTargetsRequest> {
        public ProtoAdapter_GetRecentTransmitTargetsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetRecentTransmitTargetsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetRecentTransmitTargetsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.limit = 5;
            Boolean r102 = Boolean.FALSE;
            r101.filter_group_chat = r102;
            r101.filter_p2p_chat = r102;
            r101.filter_thread_chat = r102;
            r101.filter_cross_tenant_chat = r102;
            r101.filter_myself = r102;
            r101.include_my_ai = r102;
            r101.sync_data_strategy = SyncDataStrategy.FORCE_SERVER;
            r101.filter_cross_tenant_thread = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L19;
            switch(r104) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L21;
                case 9: goto L7;
                default: goto L6;
            };
        L21:
            r101.sync_data_strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.filter_cross_tenant_thread = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.include_my_ai = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.filter_myself = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            r101.filter_cross_tenant_chat = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            r101.filter_thread_chat = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L16:
            r101.filter_p2p_chat = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L17:
            r101.filter_group_chat = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L18:
            r101.limit = ProtoAdapter.INT32.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetRecentTransmitTargetsRequest r100) {
            Integer r101 = r100.limit;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.filter_group_chat;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.filter_p2p_chat;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.filter_thread_chat;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.filter_cross_tenant_chat;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.filter_myself;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Boolean r119 = r100.include_my_ai;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            SyncDataStrategy r122 = r100.sync_data_strategy;
            if (r122 == null) goto L33;
            int r123 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            Boolean r125 = r100.filter_cross_tenant_thread;
            if (r125 == null) goto L38;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r125);
        L38:
            return (r124 + r102) + r100.unknownFields().size();
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetRecentTransmitTargetsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetRecentTransmitTargetsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetRecentTransmitTargetsRequest r101) throws IOException {
            Integer r102 = r101.limit;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.filter_group_chat;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.filter_p2p_chat;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.filter_thread_chat;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.filter_cross_tenant_chat;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            Boolean r107 = r101.filter_myself;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L20:
            Boolean r108 = r101.include_my_ai;
            if (r108 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
        L23:
            SyncDataStrategy r109 = r101.sync_data_strategy;
            if (r109 == null) goto L26;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 8, r109);
        L26:
            Boolean r110 = r101.filter_cross_tenant_thread;
            if (r110 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r110);
        L29:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetRecentTransmitTargetsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetRecentTransmitTargetsRequest r100 = new ProtoAdapter_GetRecentTransmitTargetsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_LIMIT = 5;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_FILTER_GROUP_CHAT = r101;
        DEFAULT_FILTER_P2P_CHAT = r101;
        DEFAULT_FILTER_THREAD_CHAT = r101;
        DEFAULT_FILTER_CROSS_TENANT_CHAT = r101;
        DEFAULT_FILTER_MYSELF = r101;
        DEFAULT_INCLUDE_MY_AI = r101;
        DEFAULT_SYNC_DATA_STRATEGY = SyncDataStrategy.FORCE_SERVER;
        DEFAULT_FILTER_CROSS_TENANT_THREAD = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.limit = this.limit;
        r100.filter_group_chat = this.filter_group_chat;
        r100.filter_p2p_chat = this.filter_p2p_chat;
        r100.filter_thread_chat = this.filter_thread_chat;
        r100.filter_cross_tenant_chat = this.filter_cross_tenant_chat;
        r100.filter_myself = this.filter_myself;
        r100.include_my_ai = this.include_my_ai;
        r100.sync_data_strategy = this.sync_data_strategy;
        r100.filter_cross_tenant_thread = this.filter_cross_tenant_thread;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetRecentTransmitTargetsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetRecentTransmitTargetsRequest(Integer r110, Boolean r111, Boolean r112, Boolean r113, Boolean r114, Boolean r115, Boolean r116, SyncDataStrategy r117, Boolean r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public GetRecentTransmitTargetsRequest(Integer r100, Boolean r101, Boolean r102, Boolean r103, Boolean r104, Boolean r105, Boolean r106, SyncDataStrategy r107, Boolean r110, ByteString r111) {
        super(ADAPTER, r111);
        this.limit = r100;
        this.filter_group_chat = r101;
        this.filter_p2p_chat = r102;
        this.filter_thread_chat = r103;
        this.filter_cross_tenant_chat = r104;
        this.filter_myself = r105;
        this.include_my_ai = r106;
        this.sync_data_strategy = r107;
        this.filter_cross_tenant_thread = r110;
    }
}
