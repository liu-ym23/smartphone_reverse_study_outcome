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
public final class PushTaskListsChangedNotification extends Message<PushTaskListsChangedNotification, Builder> {
    public static final ProtoAdapter<PushTaskListsChangedNotification> ADAPTER = null;
    public static final Boolean DEFAULT_REFRESH_ALL = null;
    public static final ProtoAdapter_PushTaskListsChangedNotification RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean refresh_all;
    public final List<TaskContainer> task_lists;

    public static final class Builder extends Message.Builder<PushTaskListsChangedNotification, Builder> implements d<PushTaskListsChangedNotification> {
        public Boolean refresh_all;
        public List<TaskContainer> task_lists;

        @Override // com.squareup.wire.Message.Builder
        public PushTaskListsChangedNotification build() {
            return new PushTaskListsChangedNotification(this.task_lists, this.refresh_all, super.buildUnknownFields());
        }

        public Builder() {
            this.task_lists = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder refresh_all(Boolean r100) {
            this.refresh_all = r100;
            return this;
        }

        public Builder task_lists(List<TaskContainer> r100) {
            Internal.checkElementsNotNull(r100);
            this.task_lists = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushTaskListsChangedNotification extends ProtoAdapter<PushTaskListsChangedNotification> implements c<PushTaskListsChangedNotification> {
        public ProtoAdapter_PushTaskListsChangedNotification() {
            super(FieldEncoding.LENGTH_DELIMITED, PushTaskListsChangedNotification.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushTaskListsChangedNotification decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.refresh_all = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.task_lists.add(TaskContainer.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.refresh_all = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(PushTaskListsChangedNotification r100) {
            int r101 = TaskContainer.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.task_lists);
            Boolean r102 = r100.refresh_all;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushTaskListsChangedNotification decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushTaskListsChangedNotification r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushTaskListsChangedNotification r101) throws IOException {
            TaskContainer.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.task_lists);
            Boolean r102 = r101.refresh_all;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushTaskListsChangedNotification r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushTaskListsChangedNotification r100 = new ProtoAdapter_PushTaskListsChangedNotification();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_REFRESH_ALL = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.task_lists = Internal.copyOf("task_lists", this.task_lists);
        r100.refresh_all = this.refresh_all;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushTaskListsChangedNotification.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushTaskListsChangedNotification(List<TaskContainer> r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PushTaskListsChangedNotification(List<TaskContainer> r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.task_lists = Internal.immutableCopyOf("task_lists", r100);
        this.refresh_all = r101;
    }
}
