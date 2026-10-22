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
public final class TaskContainerSectionItem extends Message<TaskContainerSectionItem, Builder> {
    public static final ProtoAdapter<TaskContainerSectionItem> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final TaskContainer container;
    public final List<TaskContainerSectionRef> refs;

    public static final class Builder extends Message.Builder<TaskContainerSectionItem, Builder> {
        public TaskContainer container;
        public List<TaskContainerSectionRef> refs;

        @Override // com.squareup.wire.Message.Builder
        public TaskContainerSectionItem build() {
            return new TaskContainerSectionItem(this.container, this.refs, super.buildUnknownFields());
        }

        public Builder() {
            this.refs = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder container(TaskContainer r100) {
            this.container = r100;
            return this;
        }

        public Builder refs(List<TaskContainerSectionRef> r100) {
            Internal.checkElementsNotNull(r100);
            this.refs = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskContainerSectionItem extends ProtoAdapter<TaskContainerSectionItem> {
        public ProtoAdapter_TaskContainerSectionItem() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskContainerSectionItem.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskContainerSectionItem decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.container = TaskContainer.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.refs.add(TaskContainerSectionRef.ADAPTER.decode(r100));
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
        public int encodedSize2(TaskContainerSectionItem r100) {
            TaskContainer r101 = r100.container;
            if (r101 == null) goto L5;
            int r102 = TaskContainer.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + TaskContainerSectionRef.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.refs)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskContainerSectionItem decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskContainerSectionItem r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskContainerSectionItem r101) throws IOException {
            TaskContainer r102 = r101.container;
            if (r102 == null) goto L5;
            TaskContainer.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            TaskContainerSectionRef.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.refs);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskContainerSectionItem r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskContainerSectionItem();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.container = this.container;
        r100.refs = Internal.copyOf("refs", this.refs);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskContainerSectionItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskContainerSectionItem(TaskContainer r100, List<TaskContainerSectionRef> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TaskContainerSectionItem(TaskContainer r100, List<TaskContainerSectionRef> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.container = r100;
        this.refs = Internal.immutableCopyOf("refs", r101);
    }
}
