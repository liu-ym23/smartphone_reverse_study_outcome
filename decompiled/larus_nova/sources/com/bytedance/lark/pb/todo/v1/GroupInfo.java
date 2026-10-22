package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class GroupInfo extends Message<GroupInfo, Builder> {
    public static final ProtoAdapter<GroupInfo> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final TaskViewGroup group;
    public final GroupResource resource;

    public static final class Builder extends Message.Builder<GroupInfo, Builder> {
        public TaskViewGroup group;
        public GroupResource resource;

        @Override // com.squareup.wire.Message.Builder
        public GroupInfo build() {
            return new GroupInfo(this.group, this.resource, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder group(TaskViewGroup r100) {
            this.group = r100;
            return this;
        }

        public Builder resource(GroupResource r100) {
            this.resource = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GroupInfo extends ProtoAdapter<GroupInfo> {
        public ProtoAdapter_GroupInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, GroupInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GroupInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.group = TaskViewGroup.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.resource = GroupResource.ADAPTER.decode(r100);
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
        public int encodedSize2(GroupInfo r100) {
            TaskViewGroup r101 = r100.group;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = TaskViewGroup.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            GroupResource r104 = r100.resource;
            if (r104 == null) goto L10;
            r102 = GroupResource.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GroupInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GroupInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GroupInfo r101) throws IOException {
            TaskViewGroup r102 = r101.group;
            if (r102 == null) goto L5;
            TaskViewGroup.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            GroupResource r103 = r101.resource;
            if (r103 == null) goto L8;
            GroupResource.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GroupInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GroupInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.group = this.group;
        r100.resource = this.resource;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GroupInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GroupInfo(TaskViewGroup r100, GroupResource r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GroupInfo(TaskViewGroup r100, GroupResource r101, ByteString r102) {
        super(ADAPTER, r102);
        this.group = r100;
        this.resource = r101;
    }
}
