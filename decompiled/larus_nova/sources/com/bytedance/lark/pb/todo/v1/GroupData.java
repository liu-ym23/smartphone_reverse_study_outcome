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
public final class GroupData extends Message<GroupData, Builder> {
    public static final ProtoAdapter<GroupData> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<GroupInfo> group_infos;
    public final List<TaskSortedInfo> task_sorted_infos;

    public static final class Builder extends Message.Builder<GroupData, Builder> {
        public List<GroupInfo> group_infos;
        public List<TaskSortedInfo> task_sorted_infos;

        @Override // com.squareup.wire.Message.Builder
        public GroupData build() {
            return new GroupData(this.group_infos, this.task_sorted_infos, super.buildUnknownFields());
        }

        public Builder() {
            this.group_infos = Internal.newMutableList();
            this.task_sorted_infos = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder group_infos(List<GroupInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.group_infos = r100;
            return this;
        }

        public Builder task_sorted_infos(List<TaskSortedInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.task_sorted_infos = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GroupData extends ProtoAdapter<GroupData> {
        public ProtoAdapter_GroupData() {
            super(FieldEncoding.LENGTH_DELIMITED, GroupData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GroupData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.group_infos.add(GroupInfo.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.task_sorted_infos.add(TaskSortedInfo.ADAPTER.decode(r100));
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
        public int encodedSize2(GroupData r100) {
            return (GroupInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.group_infos) + TaskSortedInfo.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.task_sorted_infos)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GroupData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GroupData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GroupData r101) throws IOException {
            GroupInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.group_infos);
            TaskSortedInfo.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.task_sorted_infos);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GroupData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GroupData();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.group_infos = Internal.copyOf("group_infos", this.group_infos);
        r100.task_sorted_infos = Internal.copyOf("task_sorted_infos", this.task_sorted_infos);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GroupData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GroupData(List<GroupInfo> r100, List<TaskSortedInfo> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GroupData(List<GroupInfo> r100, List<TaskSortedInfo> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.group_infos = Internal.immutableCopyOf("group_infos", r100);
        this.task_sorted_infos = Internal.immutableCopyOf("task_sorted_infos", r101);
    }
}
