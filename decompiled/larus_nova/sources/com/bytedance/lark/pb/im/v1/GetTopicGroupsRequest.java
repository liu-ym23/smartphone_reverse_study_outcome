package com.bytedance.lark.pb.im.v1;

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
public final class GetTopicGroupsRequest extends Message<GetTopicGroupsRequest, Builder> {
    public static final ProtoAdapter<GetTopicGroupsRequest> ADAPTER = null;
    public static final Boolean DEFAULT_NEED_SYNC_UNSUBSCRIBE_GROUPS = null;
    public static final SyncDataStrategy DEFAULT_STRATEGY = null;
    public static final Boolean DEFAULT_SYNC_DATA = null;
    public static final ProtoAdapter_GetTopicGroupsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> group_ids;
    public final Boolean need_sync_unsubscribe_groups;
    public final SyncDataStrategy strategy;
    public final Boolean sync_data;

    public static final class Builder extends Message.Builder<GetTopicGroupsRequest, Builder> implements d<GetTopicGroupsRequest> {
        public List<String> group_ids;
        public Boolean need_sync_unsubscribe_groups;
        public SyncDataStrategy strategy;
        public Boolean sync_data;

        @Override // com.squareup.wire.Message.Builder
        public GetTopicGroupsRequest build() {
            return new GetTopicGroupsRequest(this.group_ids, this.sync_data, this.strategy, this.need_sync_unsubscribe_groups, super.buildUnknownFields());
        }

        public Builder() {
            this.group_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder group_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.group_ids = r100;
            return this;
        }

        public Builder need_sync_unsubscribe_groups(Boolean r100) {
            this.need_sync_unsubscribe_groups = r100;
            return this;
        }

        public Builder strategy(SyncDataStrategy r100) {
            this.strategy = r100;
            return this;
        }

        public Builder sync_data(Boolean r100) {
            this.sync_data = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetTopicGroupsRequest extends ProtoAdapter<GetTopicGroupsRequest> implements c<GetTopicGroupsRequest> {
        public ProtoAdapter_GetTopicGroupsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetTopicGroupsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetTopicGroupsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.sync_data = Boolean.FALSE;
            r101.strategy = SyncDataStrategy.TRY_LOCAL;
            r101.need_sync_unsubscribe_groups = Boolean.TRUE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.group_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.sync_data = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.need_sync_unsubscribe_groups = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetTopicGroupsRequest r100) {
            int r101 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.group_ids);
            Boolean r102 = r100.sync_data;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            SyncDataStrategy r106 = r100.strategy;
            if (r106 == null) goto L9;
            int r107 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            Boolean r109 = r100.need_sync_unsubscribe_groups;
            if (r109 == null) goto L14;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r109);
        L14:
            return (r108 + r103) + r100.unknownFields().size();
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetTopicGroupsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetTopicGroupsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetTopicGroupsRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.group_ids);
            Boolean r102 = r101.sync_data;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            SyncDataStrategy r103 = r101.strategy;
            if (r103 == null) goto L8;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            Boolean r104 = r101.need_sync_unsubscribe_groups;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetTopicGroupsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetTopicGroupsRequest r100 = new ProtoAdapter_GetTopicGroupsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SYNC_DATA = Boolean.FALSE;
        DEFAULT_STRATEGY = SyncDataStrategy.TRY_LOCAL;
        DEFAULT_NEED_SYNC_UNSUBSCRIBE_GROUPS = Boolean.TRUE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.group_ids = Internal.copyOf("group_ids", this.group_ids);
        r100.sync_data = this.sync_data;
        r100.strategy = this.strategy;
        r100.need_sync_unsubscribe_groups = this.need_sync_unsubscribe_groups;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetTopicGroupsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetTopicGroupsRequest(List<String> r100, Boolean r101, SyncDataStrategy r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetTopicGroupsRequest(List<String> r100, Boolean r101, SyncDataStrategy r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.group_ids = Internal.immutableCopyOf("group_ids", r100);
        this.sync_data = r101;
        this.strategy = r102;
        this.need_sync_unsubscribe_groups = r103;
    }
}
