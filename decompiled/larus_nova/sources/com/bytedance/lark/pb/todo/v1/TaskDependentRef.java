package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskDependentRef extends Message<TaskDependentRef, Builder> {
    public static final ProtoAdapter<TaskDependentRef> ADAPTER = null;
    public static final String DEFAULT_DEPENDENT_TASK_GUID = "";
    public static final TaskDependent.Type DEFAULT_DEPENDENT_TYPE = null;
    public static final String DEFAULT_TASK_GUID = "";
    private static final long serialVersionUID = 0;
    public final String dependent_task_guid;
    public final TaskDependent.Type dependent_type;
    public final String task_guid;

    public static final class Builder extends Message.Builder<TaskDependentRef, Builder> {
        public String dependent_task_guid;
        public TaskDependent.Type dependent_type;
        public String task_guid;

        @Override // com.squareup.wire.Message.Builder
        public TaskDependentRef build() {
            return new TaskDependentRef(this.task_guid, this.dependent_task_guid, this.dependent_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder dependent_task_guid(String r100) {
            this.dependent_task_guid = r100;
            return this;
        }

        public Builder dependent_type(TaskDependent.Type r100) {
            this.dependent_type = r100;
            return this;
        }

        public Builder task_guid(String r100) {
            this.task_guid = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskDependentRef extends ProtoAdapter<TaskDependentRef> {
        public ProtoAdapter_TaskDependentRef() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskDependentRef.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskDependentRef decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.task_guid = "";
            r101.dependent_task_guid = "";
            r101.dependent_type = TaskDependent.Type.UNKNOWN_TYPE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.task_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.dependent_task_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.dependent_type = TaskDependent.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
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
        public int encodedSize2(TaskDependentRef r100) {
            String r101 = r100.task_guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.dependent_task_guid;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            TaskDependent.Type r107 = r100.dependent_type;
            if (r107 == null) goto L14;
            r102 = TaskDependent.Type.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ TaskDependentRef decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskDependentRef r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskDependentRef r101) throws IOException {
            String r102 = r101.task_guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.dependent_task_guid;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            TaskDependent.Type r104 = r101.dependent_type;
            if (r104 == null) goto L11;
            TaskDependent.Type.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskDependentRef r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskDependentRef();
        DEFAULT_DEPENDENT_TYPE = TaskDependent.Type.UNKNOWN_TYPE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.task_guid = this.task_guid;
        r100.dependent_task_guid = this.dependent_task_guid;
        r100.dependent_type = this.dependent_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskDependentRef.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskDependentRef(String r100, String r101, TaskDependent.Type r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public TaskDependentRef(String r100, String r101, TaskDependent.Type r102, ByteString r103) {
        super(ADAPTER, r103);
        this.task_guid = r100;
        this.dependent_task_guid = r101;
        this.dependent_type = r102;
    }
}
