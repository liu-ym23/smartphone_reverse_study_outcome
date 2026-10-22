package com.bytedance.lark.pb.todo.v1;

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
public final class GetPagingTaskContainerRelatedDataRequest extends Message<GetPagingTaskContainerRelatedDataRequest, Builder> {
    public static final ProtoAdapter<GetPagingTaskContainerRelatedDataRequest> ADAPTER = null;
    public static final ProtoAdapter_GetPagingTaskContainerRelatedDataRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<ContainerDataCategory> data_categories;
    public final TaskContainerFilter filter;
    public final PageParam page_param;

    public static final class Builder extends Message.Builder<GetPagingTaskContainerRelatedDataRequest, Builder> implements d<GetPagingTaskContainerRelatedDataRequest> {
        public List<ContainerDataCategory> data_categories;
        public TaskContainerFilter filter;
        public PageParam page_param;

        @Override // com.squareup.wire.Message.Builder
        public GetPagingTaskContainerRelatedDataRequest build() {
            return new GetPagingTaskContainerRelatedDataRequest(this.filter, this.data_categories, this.page_param, super.buildUnknownFields());
        }

        public Builder() {
            this.data_categories = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder data_categories(List<ContainerDataCategory> r100) {
            Internal.checkElementsNotNull(r100);
            this.data_categories = r100;
            return this;
        }

        public Builder filter(TaskContainerFilter r100) {
            this.filter = r100;
            return this;
        }

        public Builder page_param(PageParam r100) {
            this.page_param = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetPagingTaskContainerRelatedDataRequest extends ProtoAdapter<GetPagingTaskContainerRelatedDataRequest> implements c<GetPagingTaskContainerRelatedDataRequest> {
        public ProtoAdapter_GetPagingTaskContainerRelatedDataRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetPagingTaskContainerRelatedDataRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetPagingTaskContainerRelatedDataRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.filter = TaskContainerFilter.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.data_categories.add(ContainerDataCategory.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.page_param = PageParam.ADAPTER.decode(r100);
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
        public int encodedSize2(GetPagingTaskContainerRelatedDataRequest r100) {
            TaskContainerFilter r101 = r100.filter;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = TaskContainerFilter.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + ContainerDataCategory.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.data_categories);
            PageParam r105 = r100.page_param;
            if (r105 == null) goto L10;
            r102 = PageParam.ADAPTER.encodedSizeWithTag(3, r105);
        L10:
            return (r104 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetPagingTaskContainerRelatedDataRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetPagingTaskContainerRelatedDataRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetPagingTaskContainerRelatedDataRequest r101) throws IOException {
            TaskContainerFilter r102 = r101.filter;
            if (r102 == null) goto L5;
            TaskContainerFilter.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            ContainerDataCategory.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.data_categories);
            PageParam r103 = r101.page_param;
            if (r103 == null) goto L8;
            PageParam.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetPagingTaskContainerRelatedDataRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetPagingTaskContainerRelatedDataRequest r100 = new ProtoAdapter_GetPagingTaskContainerRelatedDataRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.filter = this.filter;
        r100.data_categories = Internal.copyOf("data_categories", this.data_categories);
        r100.page_param = this.page_param;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetPagingTaskContainerRelatedDataRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetPagingTaskContainerRelatedDataRequest(TaskContainerFilter r100, List<ContainerDataCategory> r101, PageParam r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetPagingTaskContainerRelatedDataRequest(TaskContainerFilter r100, List<ContainerDataCategory> r101, PageParam r102, ByteString r103) {
        super(ADAPTER, r103);
        this.filter = r100;
        this.data_categories = Internal.immutableCopyOf("data_categories", r101);
        this.page_param = r102;
    }
}
