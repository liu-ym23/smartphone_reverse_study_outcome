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
public final class PushListTasksChangedNotification extends Message<PushListTasksChangedNotification, Builder> {
    public static final ProtoAdapter<PushListTasksChangedNotification> ADAPTER = null;
    public static final ProtoAdapter_PushListTasksChangedNotification RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<TaskContainerInfo> task_infos;

    public static final class Builder extends Message.Builder<PushListTasksChangedNotification, Builder> implements d<PushListTasksChangedNotification> {
        public List<TaskContainerInfo> task_infos;

        @Override // com.squareup.wire.Message.Builder
        public PushListTasksChangedNotification build() {
            return new PushListTasksChangedNotification(this.task_infos, super.buildUnknownFields());
        }

        public Builder() {
            this.task_infos = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder task_infos(List<TaskContainerInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.task_infos = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushListTasksChangedNotification extends ProtoAdapter<PushListTasksChangedNotification> implements c<PushListTasksChangedNotification> {
        public ProtoAdapter_PushListTasksChangedNotification() {
            super(FieldEncoding.LENGTH_DELIMITED, PushListTasksChangedNotification.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushListTasksChangedNotification decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.task_infos.add(TaskContainerInfo.ADAPTER.decode(r100));
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
        public int encodedSize2(PushListTasksChangedNotification r100) {
            return TaskContainerInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.task_infos) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushListTasksChangedNotification decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushListTasksChangedNotification r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushListTasksChangedNotification r101) throws IOException {
            TaskContainerInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.task_infos);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushListTasksChangedNotification r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushListTasksChangedNotification r100 = new ProtoAdapter_PushListTasksChangedNotification();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.task_infos = Internal.copyOf("task_infos", this.task_infos);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushListTasksChangedNotification.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushListTasksChangedNotification(List<TaskContainerInfo> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PushListTasksChangedNotification(List<TaskContainerInfo> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.task_infos = Internal.immutableCopyOf("task_infos", r100);
    }
}
