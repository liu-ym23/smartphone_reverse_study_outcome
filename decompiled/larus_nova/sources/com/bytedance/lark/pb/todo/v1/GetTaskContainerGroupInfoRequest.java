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
public final class GetTaskContainerGroupInfoRequest extends Message<GetTaskContainerGroupInfoRequest, Builder> {
    public static final ProtoAdapter<GetTaskContainerGroupInfoRequest> ADAPTER = null;
    public static final String DEFAULT_CONTAINER_GUID = "";
    public static final Boolean DEFAULT_ENABLE_ALL_TASK = null;
    public static final Integer DEFAULT_NEXT_COUNT = null;
    public static final String DEFAULT_POSITIONED_TASK_GUID = "";
    public static final Integer DEFAULT_PRE_COUNT = null;
    public static final String DEFAULT_TIMEZONE = "";
    public static final ProtoAdapter_GetTaskContainerGroupInfoRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String container_guid;
    public final Boolean enable_all_task;
    public final ContainerMetaDataParams meta_data_params;
    public final Integer next_count;
    public final String positioned_task_guid;
    public final Integer pre_count;
    public final String timezone;
    public final TaskViewFilters view_filters;
    public final TaskViewGroups view_groups;
    public final TaskViewSorts view_sorts;

    public static final class Builder extends Message.Builder<GetTaskContainerGroupInfoRequest, Builder> implements d<GetTaskContainerGroupInfoRequest> {
        public String container_guid;
        public Boolean enable_all_task;
        public ContainerMetaDataParams meta_data_params;
        public Integer next_count;
        public String positioned_task_guid;
        public Integer pre_count;
        public String timezone;
        public TaskViewFilters view_filters;
        public TaskViewGroups view_groups;
        public TaskViewSorts view_sorts;

        @Override // com.squareup.wire.Message.Builder
        public GetTaskContainerGroupInfoRequest build() {
            return new GetTaskContainerGroupInfoRequest(this.container_guid, this.view_groups, this.view_sorts, this.view_filters, this.timezone, this.positioned_task_guid, this.pre_count, this.next_count, this.meta_data_params, this.enable_all_task, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder container_guid(String r100) {
            this.container_guid = r100;
            return this;
        }

        public Builder enable_all_task(Boolean r100) {
            this.enable_all_task = r100;
            return this;
        }

        public Builder meta_data_params(ContainerMetaDataParams r100) {
            this.meta_data_params = r100;
            return this;
        }

        public Builder next_count(Integer r100) {
            this.next_count = r100;
            return this;
        }

        public Builder positioned_task_guid(String r100) {
            this.positioned_task_guid = r100;
            return this;
        }

        public Builder pre_count(Integer r100) {
            this.pre_count = r100;
            return this;
        }

        public Builder timezone(String r100) {
            this.timezone = r100;
            return this;
        }

        public Builder view_filters(TaskViewFilters r100) {
            this.view_filters = r100;
            return this;
        }

        public Builder view_groups(TaskViewGroups r100) {
            this.view_groups = r100;
            return this;
        }

        public Builder view_sorts(TaskViewSorts r100) {
            this.view_sorts = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetTaskContainerGroupInfoRequest extends ProtoAdapter<GetTaskContainerGroupInfoRequest> implements c<GetTaskContainerGroupInfoRequest> {
        public ProtoAdapter_GetTaskContainerGroupInfoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetTaskContainerGroupInfoRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetTaskContainerGroupInfoRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.container_guid = "";
            r101.timezone = "";
            r101.positioned_task_guid = "";
            r101.pre_count = 0;
            r101.next_count = 0;
            r101.enable_all_task = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L17;
            switch(r103) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            r101.enable_all_task = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.meta_data_params = ContainerMetaDataParams.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.next_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.pre_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L11:
            r101.positioned_task_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.timezone = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.view_filters = TaskViewFilters.ADAPTER.decode(r100);
            goto L3
        L14:
            r101.view_sorts = TaskViewSorts.ADAPTER.decode(r100);
            goto L3
        L15:
            r101.view_groups = TaskViewGroups.ADAPTER.decode(r100);
            goto L3
        L16:
            r101.container_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetTaskContainerGroupInfoRequest r100) {
            String r101 = r100.container_guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            TaskViewGroups r104 = r100.view_groups;
            if (r104 == null) goto L9;
            int r105 = TaskViewGroups.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            TaskViewSorts r107 = r100.view_sorts;
            if (r107 == null) goto L13;
            int r108 = TaskViewSorts.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            TaskViewFilters r110 = r100.view_filters;
            if (r110 == null) goto L17;
            int r111 = TaskViewFilters.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.timezone;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.positioned_task_guid;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Integer r119 = r100.pre_count;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.INT32.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Integer r122 = r100.next_count;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.INT32.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            ContainerMetaDataParams r125 = r100.meta_data_params;
            if (r125 == null) goto L37;
            int r126 = ContainerMetaDataParams.ADAPTER.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            Boolean r128 = r100.enable_all_task;
            if (r128 == null) goto L42;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r128);
        L42:
            return (r127 + r102) + r100.unknownFields().size();
        L37:
            r126 = 0;
            goto L38
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
        public /* bridge */ /* synthetic */ GetTaskContainerGroupInfoRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetTaskContainerGroupInfoRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetTaskContainerGroupInfoRequest r101) throws IOException {
            String r102 = r101.container_guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            TaskViewGroups r103 = r101.view_groups;
            if (r103 == null) goto L8;
            TaskViewGroups.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            TaskViewSorts r104 = r101.view_sorts;
            if (r104 == null) goto L11;
            TaskViewSorts.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            TaskViewFilters r105 = r101.view_filters;
            if (r105 == null) goto L14;
            TaskViewFilters.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.timezone;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.positioned_task_guid;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            Integer r108 = r101.pre_count;
            if (r108 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r100, 7, r108);
        L23:
            Integer r109 = r101.next_count;
            if (r109 == null) goto L26;
            ProtoAdapter.INT32.encodeWithTag(r100, 8, r109);
        L26:
            ContainerMetaDataParams r110 = r101.meta_data_params;
            if (r110 == null) goto L29;
            ContainerMetaDataParams.ADAPTER.encodeWithTag(r100, 9, r110);
        L29:
            Boolean r111 = r101.enable_all_task;
            if (r111 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r100, 10, r111);
        L32:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetTaskContainerGroupInfoRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetTaskContainerGroupInfoRequest r100 = new ProtoAdapter_GetTaskContainerGroupInfoRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_PRE_COUNT = 0;
        DEFAULT_NEXT_COUNT = 0;
        DEFAULT_ENABLE_ALL_TASK = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.container_guid = this.container_guid;
        r100.view_groups = this.view_groups;
        r100.view_sorts = this.view_sorts;
        r100.view_filters = this.view_filters;
        r100.timezone = this.timezone;
        r100.positioned_task_guid = this.positioned_task_guid;
        r100.pre_count = this.pre_count;
        r100.next_count = this.next_count;
        r100.meta_data_params = this.meta_data_params;
        r100.enable_all_task = this.enable_all_task;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetTaskContainerGroupInfoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetTaskContainerGroupInfoRequest(String r110, TaskViewGroups r111, TaskViewSorts r112, TaskViewFilters r113, String r114, String r115, Integer r116, Integer r210, ContainerMetaDataParams r211, Boolean r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public GetTaskContainerGroupInfoRequest(String r100, TaskViewGroups r101, TaskViewSorts r102, TaskViewFilters r103, String r104, String r105, Integer r106, Integer r107, ContainerMetaDataParams r110, Boolean r111, ByteString r112) {
        super(ADAPTER, r112);
        this.container_guid = r100;
        this.view_groups = r101;
        this.view_sorts = r102;
        this.view_filters = r103;
        this.timezone = r104;
        this.positioned_task_guid = r105;
        this.pre_count = r106;
        this.next_count = r107;
        this.meta_data_params = r110;
        this.enable_all_task = r111;
    }
}
