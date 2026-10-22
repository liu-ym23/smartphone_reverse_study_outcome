package com.bytedance.lark.pb.todo.v1;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
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

/* JADX INFO: loaded from: classes20.dex */
public final class ContainerMetaData extends Message<ContainerMetaData, Builder> {
    public static final ProtoAdapter<ContainerMetaData> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<TaskField> all_fields;
    public final TaskContainer container;
    public final ContainerTabs container_tabs;
    public final List<TaskField> fields;
    public final Map<Long, TodoUser> related_users;
    public final List<TaskSection> sections;
    public final List<TaskView> views;

    public static final class Builder extends Message.Builder<ContainerMetaData, Builder> {
        public List<TaskField> all_fields;
        public TaskContainer container;
        public ContainerTabs container_tabs;
        public List<TaskField> fields;
        public Map<Long, TodoUser> related_users;
        public List<TaskSection> sections;
        public List<TaskView> views;

        @Override // com.squareup.wire.Message.Builder
        public ContainerMetaData build() {
            return new ContainerMetaData(this.container, this.fields, this.sections, this.views, this.all_fields, this.container_tabs, this.related_users, super.buildUnknownFields());
        }

        public Builder() {
            this.fields = Internal.newMutableList();
            this.sections = Internal.newMutableList();
            this.views = Internal.newMutableList();
            this.all_fields = Internal.newMutableList();
            this.related_users = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder all_fields(List<TaskField> r100) {
            Internal.checkElementsNotNull(r100);
            this.all_fields = r100;
            return this;
        }

        public Builder container(TaskContainer r100) {
            this.container = r100;
            return this;
        }

        public Builder container_tabs(ContainerTabs r100) {
            this.container_tabs = r100;
            return this;
        }

        public Builder fields(List<TaskField> r100) {
            Internal.checkElementsNotNull(r100);
            this.fields = r100;
            return this;
        }

        public Builder related_users(Map<Long, TodoUser> r100) {
            Internal.checkElementsNotNull(r100);
            this.related_users = r100;
            return this;
        }

        public Builder sections(List<TaskSection> r100) {
            Internal.checkElementsNotNull(r100);
            this.sections = r100;
            return this;
        }

        public Builder views(List<TaskView> r100) {
            Internal.checkElementsNotNull(r100);
            this.views = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ContainerMetaData extends ProtoAdapter<ContainerMetaData> {
        private final ProtoAdapter<Map<Long, TodoUser>> related_users;

        public ProtoAdapter_ContainerMetaData() {
            super(FieldEncoding.LENGTH_DELIMITED, ContainerMetaData.class);
            this.related_users = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, TodoUser.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ContainerMetaData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L16;
            if (r103 != 100) goto L7;
            r101.related_users.putAll(this.related_users.decode(r100));
            goto L3
        L7:
            switch(r103) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                default: goto L8;
            };
        L9:
            r101.container_tabs = ContainerTabs.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.all_fields.add(TaskField.ADAPTER.decode(r100));
            goto L3
        L11:
            r101.views.add(TaskView.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.sections.add(TaskSection.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.fields.add(TaskField.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.container = TaskContainer.ADAPTER.decode(r100);
            goto L3
        L8:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ContainerMetaData r100) {
            TaskContainer r101 = r100.container;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = TaskContainer.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            ProtoAdapter<TaskField> r104 = TaskField.ADAPTER;
            int r105 = (((r103 + r104.asRepeated().encodedSizeWithTag(2, r100.fields)) + TaskSection.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.sections)) + TaskView.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.views)) + r104.asRepeated().encodedSizeWithTag(5, r100.all_fields);
            ContainerTabs r106 = r100.container_tabs;
            if (r106 == null) goto L10;
            r102 = ContainerTabs.ADAPTER.encodedSizeWithTag(6, r106);
        L10:
            return ((r105 + r102) + this.related_users.encodedSizeWithTag(100, r100.related_users)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ContainerMetaData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ContainerMetaData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ContainerMetaData r101) throws IOException {
            TaskContainer r102 = r101.container;
            if (r102 == null) goto L5;
            TaskContainer.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter<TaskField> r103 = TaskField.ADAPTER;
            r103.asRepeated().encodeWithTag(r100, 2, r101.fields);
            TaskSection.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.sections);
            TaskView.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.views);
            r103.asRepeated().encodeWithTag(r100, 5, r101.all_fields);
            ContainerTabs r104 = r101.container_tabs;
            if (r104 == null) goto L8;
            ContainerTabs.ADAPTER.encodeWithTag(r100, 6, r104);
        L8:
            this.related_users.encodeWithTag(r100, 100, r101.related_users);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ContainerMetaData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ContainerMetaData();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.container = this.container;
        r100.fields = Internal.copyOf(SlcCommonAction.KEY_PARAMS, this.fields);
        r100.sections = Internal.copyOf("sections", this.sections);
        r100.views = Internal.copyOf("views", this.views);
        r100.all_fields = Internal.copyOf("all_fields", this.all_fields);
        r100.container_tabs = this.container_tabs;
        r100.related_users = Internal.copyOf("related_users", this.related_users);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ContainerMetaData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ContainerMetaData(TaskContainer r110, List<TaskField> r111, List<TaskSection> r112, List<TaskView> r113, List<TaskField> r114, ContainerTabs r115, Map<Long, TodoUser> r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public ContainerMetaData(TaskContainer r100, List<TaskField> r101, List<TaskSection> r102, List<TaskView> r103, List<TaskField> r104, ContainerTabs r105, Map<Long, TodoUser> r106, ByteString r107) {
        super(ADAPTER, r107);
        this.container = r100;
        this.fields = Internal.immutableCopyOf(SlcCommonAction.KEY_PARAMS, r101);
        this.sections = Internal.immutableCopyOf("sections", r102);
        this.views = Internal.immutableCopyOf("views", r103);
        this.all_fields = Internal.immutableCopyOf("all_fields", r104);
        this.container_tabs = r105;
        this.related_users = Internal.immutableCopyOf("related_users", r106);
    }
}
