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

/* JADX INFO: loaded from: classes20.dex */
public final class TaskViewGroups extends Message<TaskViewGroups, Builder> {
    public static final ProtoAdapter<TaskViewGroups> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<TaskViewGroup> groups;

    public static final class Builder extends Message.Builder<TaskViewGroups, Builder> {
        public List<TaskViewGroup> groups;

        @Override // com.squareup.wire.Message.Builder
        public TaskViewGroups build() {
            return new TaskViewGroups(this.groups, super.buildUnknownFields());
        }

        public Builder() {
            this.groups = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder groups(List<TaskViewGroup> r100) {
            Internal.checkElementsNotNull(r100);
            this.groups = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskViewGroups extends ProtoAdapter<TaskViewGroups> {
        public ProtoAdapter_TaskViewGroups() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskViewGroups.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskViewGroups decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.groups.add(TaskViewGroup.ADAPTER.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TaskViewGroups r100) {
            return TaskViewGroup.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.groups) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskViewGroups decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskViewGroups r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskViewGroups r101) throws IOException {
            TaskViewGroup.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.groups);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskViewGroups r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskViewGroups();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.groups = Internal.copyOf("groups", this.groups);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskViewGroups.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskViewGroups(List<TaskViewGroup> r100) {
        this(r100, ByteString.EMPTY);
    }

    public TaskViewGroups(List<TaskViewGroup> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.groups = Internal.immutableCopyOf("groups", r100);
    }
}
