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
public final class UpsertTaskContainerRequest extends Message<UpsertTaskContainerRequest, Builder> {
    public static final ProtoAdapter<UpsertTaskContainerRequest> ADAPTER = null;
    public static final ProtoAdapter_UpsertTaskContainerRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<TaskContainerSectionRef> container_section_refs;
    public final TaskContainer new_container;
    public final TaskContainer old_container;

    public static final class Builder extends Message.Builder<UpsertTaskContainerRequest, Builder> implements d<UpsertTaskContainerRequest> {
        public List<TaskContainerSectionRef> container_section_refs;
        public TaskContainer new_container;
        public TaskContainer old_container;

        @Override // com.squareup.wire.Message.Builder
        public UpsertTaskContainerRequest build() {
            return new UpsertTaskContainerRequest(this.old_container, this.new_container, this.container_section_refs, super.buildUnknownFields());
        }

        public Builder() {
            this.container_section_refs = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder container_section_refs(List<TaskContainerSectionRef> r100) {
            Internal.checkElementsNotNull(r100);
            this.container_section_refs = r100;
            return this;
        }

        public Builder new_container(TaskContainer r100) {
            this.new_container = r100;
            return this;
        }

        public Builder old_container(TaskContainer r100) {
            this.old_container = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpsertTaskContainerRequest extends ProtoAdapter<UpsertTaskContainerRequest> implements c<UpsertTaskContainerRequest> {
        public ProtoAdapter_UpsertTaskContainerRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpsertTaskContainerRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpsertTaskContainerRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.old_container = TaskContainer.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.new_container = TaskContainer.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.container_section_refs.add(TaskContainerSectionRef.ADAPTER.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UpsertTaskContainerRequest r100) {
            TaskContainer r101 = r100.old_container;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = TaskContainer.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            TaskContainer r104 = r100.new_container;
            if (r104 == null) goto L10;
            r102 = TaskContainer.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return ((r103 + r102) + TaskContainerSectionRef.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.container_section_refs)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpsertTaskContainerRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpsertTaskContainerRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpsertTaskContainerRequest r101) throws IOException {
            TaskContainer r102 = r101.old_container;
            if (r102 == null) goto L5;
            TaskContainer.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            TaskContainer r103 = r101.new_container;
            if (r103 == null) goto L8;
            TaskContainer.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            TaskContainerSectionRef.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.container_section_refs);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpsertTaskContainerRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpsertTaskContainerRequest r100 = new ProtoAdapter_UpsertTaskContainerRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.old_container = this.old_container;
        r100.new_container = this.new_container;
        r100.container_section_refs = Internal.copyOf("container_section_refs", this.container_section_refs);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpsertTaskContainerRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpsertTaskContainerRequest(TaskContainer r100, TaskContainer r101, List<TaskContainerSectionRef> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public UpsertTaskContainerRequest(TaskContainer r100, TaskContainer r101, List<TaskContainerSectionRef> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.old_container = r100;
        this.new_container = r101;
        this.container_section_refs = Internal.immutableCopyOf("container_section_refs", r102);
    }
}
