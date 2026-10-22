package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetPagingTaskContainerRelatedDataResponse extends Message<GetPagingTaskContainerRelatedDataResponse, Builder> {
    public static final ProtoAdapter<GetPagingTaskContainerRelatedDataResponse> ADAPTER = null;
    public static final ProtoAdapter_GetPagingTaskContainerRelatedDataResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<TaskContainer> containers;
    public final PageResult page_result;
    public final Map<String, TaskContainerSectionRefs> task_container_section_refs;
    public final Map<String, TaskContainerSection> task_container_sections;
    public final Map<String, TaskItemMembers> task_members;

    public static final class Builder extends Message.Builder<GetPagingTaskContainerRelatedDataResponse, Builder> implements d<GetPagingTaskContainerRelatedDataResponse> {
        public List<TaskContainer> containers;
        public PageResult page_result;
        public Map<String, TaskContainerSectionRefs> task_container_section_refs;
        public Map<String, TaskContainerSection> task_container_sections;
        public Map<String, TaskItemMembers> task_members;

        @Override // com.squareup.wire.Message.Builder
        public GetPagingTaskContainerRelatedDataResponse build() {
            return new GetPagingTaskContainerRelatedDataResponse(this.containers, this.task_container_sections, this.task_container_section_refs, this.task_members, this.page_result, super.buildUnknownFields());
        }

        public Builder() {
            this.containers = Internal.newMutableList();
            this.task_container_sections = Internal.newMutableMap();
            this.task_container_section_refs = Internal.newMutableMap();
            this.task_members = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder containers(List<TaskContainer> r100) {
            Internal.checkElementsNotNull(r100);
            this.containers = r100;
            return this;
        }

        public Builder page_result(PageResult r100) {
            this.page_result = r100;
            return this;
        }

        public Builder task_container_section_refs(Map<String, TaskContainerSectionRefs> r100) {
            Internal.checkElementsNotNull(r100);
            this.task_container_section_refs = r100;
            return this;
        }

        public Builder task_container_sections(Map<String, TaskContainerSection> r100) {
            Internal.checkElementsNotNull(r100);
            this.task_container_sections = r100;
            return this;
        }

        public Builder task_members(Map<String, TaskItemMembers> r100) {
            Internal.checkElementsNotNull(r100);
            this.task_members = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetPagingTaskContainerRelatedDataResponse extends ProtoAdapter<GetPagingTaskContainerRelatedDataResponse> implements c<GetPagingTaskContainerRelatedDataResponse> {
        private final ProtoAdapter<Map<String, TaskContainerSectionRefs>> task_container_section_refs;
        private final ProtoAdapter<Map<String, TaskContainerSection>> task_container_sections;
        private final ProtoAdapter<Map<String, TaskItemMembers>> task_members;

        public ProtoAdapter_GetPagingTaskContainerRelatedDataResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetPagingTaskContainerRelatedDataResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.task_container_sections = ProtoAdapter.newMapAdapter(r100, TaskContainerSection.ADAPTER);
            this.task_container_section_refs = ProtoAdapter.newMapAdapter(r100, TaskContainerSectionRefs.ADAPTER);
            this.task_members = ProtoAdapter.newMapAdapter(r100, TaskItemMembers.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetPagingTaskContainerRelatedDataResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.containers.add(TaskContainer.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.task_container_sections.putAll(this.task_container_sections.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.task_container_section_refs.putAll(this.task_container_section_refs.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.task_members.putAll(this.task_members.decode(r100));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.page_result = PageResult.ADAPTER.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetPagingTaskContainerRelatedDataResponse r100) {
            int r101 = ((TaskContainer.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.containers) + this.task_container_sections.encodedSizeWithTag(2, r100.task_container_sections)) + this.task_container_section_refs.encodedSizeWithTag(3, r100.task_container_section_refs)) + this.task_members.encodedSizeWithTag(4, r100.task_members);
            PageResult r102 = r100.page_result;
            if (r102 == null) goto L5;
            int r103 = PageResult.ADAPTER.encodedSizeWithTag(5, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetPagingTaskContainerRelatedDataResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetPagingTaskContainerRelatedDataResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetPagingTaskContainerRelatedDataResponse r101) throws IOException {
            TaskContainer.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.containers);
            this.task_container_sections.encodeWithTag(r100, 2, r101.task_container_sections);
            this.task_container_section_refs.encodeWithTag(r100, 3, r101.task_container_section_refs);
            this.task_members.encodeWithTag(r100, 4, r101.task_members);
            PageResult r102 = r101.page_result;
            if (r102 == null) goto L5;
            PageResult.ADAPTER.encodeWithTag(r100, 5, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetPagingTaskContainerRelatedDataResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetPagingTaskContainerRelatedDataResponse r100 = new ProtoAdapter_GetPagingTaskContainerRelatedDataResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.containers = Internal.copyOf("containers", this.containers);
        r100.task_container_sections = Internal.copyOf("task_container_sections", this.task_container_sections);
        r100.task_container_section_refs = Internal.copyOf("task_container_section_refs", this.task_container_section_refs);
        r100.task_members = Internal.copyOf("task_members", this.task_members);
        r100.page_result = this.page_result;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetPagingTaskContainerRelatedDataResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetPagingTaskContainerRelatedDataResponse(List<TaskContainer> r100, Map<String, TaskContainerSection> r101, Map<String, TaskContainerSectionRefs> r110, Map<String, TaskItemMembers> r111, PageResult r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public GetPagingTaskContainerRelatedDataResponse(List<TaskContainer> r100, Map<String, TaskContainerSection> r101, Map<String, TaskContainerSectionRefs> r102, Map<String, TaskItemMembers> r103, PageResult r104, ByteString r105) {
        super(ADAPTER, r105);
        this.containers = Internal.immutableCopyOf("containers", r100);
        this.task_container_sections = Internal.immutableCopyOf("task_container_sections", r101);
        this.task_container_section_refs = Internal.immutableCopyOf("task_container_section_refs", r102);
        this.task_members = Internal.immutableCopyOf("task_members", r103);
        this.page_result = r104;
    }
}
