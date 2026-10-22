package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskContainerFilter extends Message<TaskContainerFilter, Builder> {
    public static final ProtoAdapter<TaskContainerFilter> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final StatusFilter status_filter;
    public final TabFilter tab_filter;

    public static final class Builder extends Message.Builder<TaskContainerFilter, Builder> {
        public StatusFilter status_filter;
        public TabFilter tab_filter;

        @Override // com.squareup.wire.Message.Builder
        public TaskContainerFilter build() {
            return new TaskContainerFilter(this.tab_filter, this.status_filter, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder status_filter(StatusFilter r100) {
            this.status_filter = r100;
            return this;
        }

        public Builder tab_filter(TabFilter r100) {
            this.tab_filter = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskContainerFilter extends ProtoAdapter<TaskContainerFilter> {
        public ProtoAdapter_TaskContainerFilter() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskContainerFilter.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskContainerFilter decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.tab_filter = TabFilter.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.status_filter = StatusFilter.ADAPTER.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TaskContainerFilter r100) {
            TabFilter r101 = r100.tab_filter;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = TabFilter.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            StatusFilter r104 = r100.status_filter;
            if (r104 == null) goto L10;
            r102 = StatusFilter.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskContainerFilter decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskContainerFilter r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskContainerFilter r101) throws IOException {
            TabFilter r102 = r101.tab_filter;
            if (r102 == null) goto L5;
            TabFilter.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            StatusFilter r103 = r101.status_filter;
            if (r103 == null) goto L8;
            StatusFilter.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskContainerFilter r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class StatusFilter extends Message<StatusFilter, Builder> {
        public static final ProtoAdapter<StatusFilter> ADAPTER = null;
        public static final TaskContainerArchiveCategory DEFAULT_ARCHIVE_CATEGORY = null;
        private static final long serialVersionUID = 0;
        public final TaskContainerArchiveCategory archive_category;

        public static final class Builder extends Message.Builder<StatusFilter, Builder> {
            public TaskContainerArchiveCategory archive_category;

            @Override // com.squareup.wire.Message.Builder
            public StatusFilter build() {
                return new StatusFilter(this.archive_category, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder archive_category(TaskContainerArchiveCategory r100) {
                this.archive_category = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_StatusFilter extends ProtoAdapter<StatusFilter> {
            public ProtoAdapter_StatusFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, StatusFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public StatusFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.archive_category = TaskContainerArchiveCategory.TASK_CONTAINER_ALL;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L7;
                r101.archive_category = TaskContainerArchiveCategory.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(StatusFilter r100) {
                TaskContainerArchiveCategory r101 = r100.archive_category;
                if (r101 == null) goto L5;
                int r102 = TaskContainerArchiveCategory.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ StatusFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(StatusFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, StatusFilter r101) throws IOException {
                TaskContainerArchiveCategory r102 = r101.archive_category;
                if (r102 == null) goto L5;
                TaskContainerArchiveCategory.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, StatusFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum TaskContainerArchiveCategory extends Enum<TaskContainerArchiveCategory> implements WireEnum {
            private static final /* synthetic */ TaskContainerArchiveCategory[] $VALUES = null;
            public static final ProtoAdapter<TaskContainerArchiveCategory> ADAPTER = null;
            public static final TaskContainerArchiveCategory TASK_CONTAINER_ALL = null;
            public static final TaskContainerArchiveCategory TASK_CONTAINER_ARCHIVED = null;
            public static final TaskContainerArchiveCategory TASK_CONTAINER_UNARCHIVED = null;
            private final int value;

            static {
                TaskContainerArchiveCategory r100 = new TaskContainerArchiveCategory("TASK_CONTAINER_ALL", 0, 0);
                TASK_CONTAINER_ALL = r100;
                TaskContainerArchiveCategory r101 = new TaskContainerArchiveCategory("TASK_CONTAINER_ARCHIVED", 1, 1);
                TASK_CONTAINER_ARCHIVED = r101;
                TaskContainerArchiveCategory r102 = new TaskContainerArchiveCategory("TASK_CONTAINER_UNARCHIVED", 2, 2);
                TASK_CONTAINER_UNARCHIVED = r102;
                $VALUES = new TaskContainerArchiveCategory[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(TaskContainerArchiveCategory.class);
            }

            public static TaskContainerArchiveCategory[] values() {
                return (TaskContainerArchiveCategory[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static TaskContainerArchiveCategory fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return TASK_CONTAINER_UNARCHIVED;
            L12:
                return TASK_CONTAINER_ARCHIVED;
            L14:
                return TASK_CONTAINER_ALL;
            }

            public static TaskContainerArchiveCategory valueOf(String r100) {
                return (TaskContainerArchiveCategory) a.a(TaskContainerArchiveCategory.class, r100);
            }

            private TaskContainerArchiveCategory(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_StatusFilter();
            DEFAULT_ARCHIVE_CATEGORY = TaskContainerArchiveCategory.TASK_CONTAINER_ALL;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.archive_category = this.archive_category;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return StatusFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public StatusFilter(TaskContainerArchiveCategory r100) {
            this(r100, ByteString.EMPTY);
        }

        public StatusFilter(TaskContainerArchiveCategory r100, ByteString r101) {
            super(ADAPTER, r101);
            this.archive_category = r100;
        }
    }

    public static final class TabFilter extends Message<TabFilter, Builder> {
        public static final ProtoAdapter<TabFilter> ADAPTER = null;
        public static final TaskContainerTabCategory DEFAULT_TAB_CATEGORY = null;
        private static final long serialVersionUID = 0;
        public final TaskContainerTabCategory tab_category;

        public static final class Builder extends Message.Builder<TabFilter, Builder> {
            public TaskContainerTabCategory tab_category;

            @Override // com.squareup.wire.Message.Builder
            public TabFilter build() {
                return new TabFilter(this.tab_category, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder tab_category(TaskContainerTabCategory r100) {
                this.tab_category = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TabFilter extends ProtoAdapter<TabFilter> {
            public ProtoAdapter_TabFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, TabFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TabFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.tab_category = TaskContainerTabCategory.TASK_CONTAINER_ALL;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L7;
                r101.tab_category = TaskContainerTabCategory.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TabFilter r100) {
                TaskContainerTabCategory r101 = r100.tab_category;
                if (r101 == null) goto L5;
                int r102 = TaskContainerTabCategory.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TabFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TabFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TabFilter r101) throws IOException {
                TaskContainerTabCategory r102 = r101.tab_category;
                if (r102 == null) goto L5;
                TaskContainerTabCategory.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TabFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum TaskContainerTabCategory extends Enum<TaskContainerTabCategory> implements WireEnum {
            private static final /* synthetic */ TaskContainerTabCategory[] $VALUES = null;
            public static final ProtoAdapter<TaskContainerTabCategory> ADAPTER = null;
            public static final TaskContainerTabCategory TASK_CONTAINER_ALL = null;
            public static final TaskContainerTabCategory TASK_CONTAINER_COLLABORATED_WITH_ME = null;
            public static final TaskContainerTabCategory TASK_CONTAINER_CREATED_BY_ME = null;
            public static final TaskContainerTabCategory TASK_CONTAINER_FROM_CHAT = null;
            public static final TaskContainerTabCategory TASK_CONTAINER_FROM_DOC = null;
            public static final TaskContainerTabCategory TASK_CONTAINER_FROM_MEEGO_SUBTASK = null;
            public static final TaskContainerTabCategory TASK_CONTAINER_MANAGED_BY_ME = null;
            private final int value;

            static {
                TaskContainerTabCategory r100 = new TaskContainerTabCategory("TASK_CONTAINER_ALL", 0, 0);
                TASK_CONTAINER_ALL = r100;
                TaskContainerTabCategory r101 = new TaskContainerTabCategory("TASK_CONTAINER_CREATED_BY_ME", 1, 1);
                TASK_CONTAINER_CREATED_BY_ME = r101;
                TaskContainerTabCategory r102 = new TaskContainerTabCategory("TASK_CONTAINER_MANAGED_BY_ME", 2, 2);
                TASK_CONTAINER_MANAGED_BY_ME = r102;
                TaskContainerTabCategory r103 = new TaskContainerTabCategory("TASK_CONTAINER_COLLABORATED_WITH_ME", 3, 3);
                TASK_CONTAINER_COLLABORATED_WITH_ME = r103;
                TaskContainerTabCategory r104 = new TaskContainerTabCategory("TASK_CONTAINER_FROM_CHAT", 4, 4);
                TASK_CONTAINER_FROM_CHAT = r104;
                TaskContainerTabCategory r105 = new TaskContainerTabCategory("TASK_CONTAINER_FROM_DOC", 5, 5);
                TASK_CONTAINER_FROM_DOC = r105;
                TaskContainerTabCategory r110 = new TaskContainerTabCategory("TASK_CONTAINER_FROM_MEEGO_SUBTASK", 6, 6);
                TASK_CONTAINER_FROM_MEEGO_SUBTASK = r110;
                $VALUES = new TaskContainerTabCategory[]{r100, r101, r102, r103, r104, r105, r110};
                ADAPTER = ProtoAdapter.newEnumAdapter(TaskContainerTabCategory.class);
            }

            public static TaskContainerTabCategory[] values() {
                return (TaskContainerTabCategory[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static TaskContainerTabCategory fromValue(int r100) {
                switch(r100) {
                    case 0: goto L18;
                    case 1: goto L16;
                    case 2: goto L14;
                    case 3: goto L12;
                    case 4: goto L10;
                    case 5: goto L8;
                    case 6: goto L6;
                    default: goto L3;
                };
            L3:
                return null;
            L6:
                return TASK_CONTAINER_FROM_MEEGO_SUBTASK;
            L8:
                return TASK_CONTAINER_FROM_DOC;
            L10:
                return TASK_CONTAINER_FROM_CHAT;
            L12:
                return TASK_CONTAINER_COLLABORATED_WITH_ME;
            L14:
                return TASK_CONTAINER_MANAGED_BY_ME;
            L16:
                return TASK_CONTAINER_CREATED_BY_ME;
            L18:
                return TASK_CONTAINER_ALL;
            }

            public static TaskContainerTabCategory valueOf(String r100) {
                return (TaskContainerTabCategory) a.a(TaskContainerTabCategory.class, r100);
            }

            private TaskContainerTabCategory(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TabFilter();
            DEFAULT_TAB_CATEGORY = TaskContainerTabCategory.TASK_CONTAINER_ALL;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.tab_category = this.tab_category;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TabFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public TabFilter(TaskContainerTabCategory r100) {
            this(r100, ByteString.EMPTY);
        }

        public TabFilter(TaskContainerTabCategory r100, ByteString r101) {
            super(ADAPTER, r101);
            this.tab_category = r100;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskContainerFilter();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.tab_filter = this.tab_filter;
        r100.status_filter = this.status_filter;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskContainerFilter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskContainerFilter(TabFilter r100, StatusFilter r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TaskContainerFilter(TabFilter r100, StatusFilter r101, ByteString r102) {
        super(ADAPTER, r102);
        this.tab_filter = r100;
        this.status_filter = r101;
    }
}
