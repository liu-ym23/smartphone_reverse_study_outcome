package com.bytedance.lark.pb.todo.v1;

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
public final class GetPagingTaskListsRequest extends Message<GetPagingTaskListsRequest, Builder> {
    public static final ProtoAdapter<GetPagingTaskListsRequest> ADAPTER = null;
    public static final ArchivedType DEFAULT_ARCHIVED_TYPE = null;
    public static final Integer DEFAULT_COUNT = null;
    public static final Long DEFAULT_LAST_TOKEN = null;
    public static final ProtoAdapter_GetPagingTaskListsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ArchivedType archived_type;
    public final Integer count;
    public final Long last_token;

    public static final class Builder extends Message.Builder<GetPagingTaskListsRequest, Builder> implements d<GetPagingTaskListsRequest> {
        public ArchivedType archived_type;
        public Integer count;
        public Long last_token;

        @Override // com.squareup.wire.Message.Builder
        public GetPagingTaskListsRequest build() {
            return new GetPagingTaskListsRequest(this.count, this.last_token, this.archived_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder archived_type(ArchivedType r100) {
            this.archived_type = r100;
            return this;
        }

        public Builder count(Integer r100) {
            this.count = r100;
            return this;
        }

        public Builder last_token(Long r100) {
            this.last_token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetPagingTaskListsRequest extends ProtoAdapter<GetPagingTaskListsRequest> implements c<GetPagingTaskListsRequest> {
        public ProtoAdapter_GetPagingTaskListsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetPagingTaskListsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetPagingTaskListsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.count = 30;
            r101.last_token = 0L;
            r101.archived_type = ArchivedType.ALL;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.last_token = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.archived_type = ArchivedType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
        public int encodedSize2(GetPagingTaskListsRequest r100) {
            Integer r101 = r100.count;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.last_token;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ArchivedType r107 = r100.archived_type;
            if (r107 == null) goto L14;
            r102 = ArchivedType.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ GetPagingTaskListsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetPagingTaskListsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetPagingTaskListsRequest r101) throws IOException {
            Integer r102 = r101.count;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.last_token;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            ArchivedType r104 = r101.archived_type;
            if (r104 == null) goto L11;
            ArchivedType.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetPagingTaskListsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetPagingTaskListsRequest r100 = new ProtoAdapter_GetPagingTaskListsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_COUNT = 30;
        DEFAULT_LAST_TOKEN = 0L;
        DEFAULT_ARCHIVED_TYPE = ArchivedType.ALL;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.count = this.count;
        r100.last_token = this.last_token;
        r100.archived_type = this.archived_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetPagingTaskListsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetPagingTaskListsRequest(Integer r100, Long r101, ArchivedType r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetPagingTaskListsRequest(Integer r100, Long r101, ArchivedType r102, ByteString r103) {
        super(ADAPTER, r103);
        this.count = r100;
        this.last_token = r101;
        this.archived_type = r102;
    }
}
