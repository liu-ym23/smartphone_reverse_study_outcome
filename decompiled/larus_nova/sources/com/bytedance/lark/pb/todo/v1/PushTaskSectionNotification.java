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
public final class PushTaskSectionNotification extends Message<PushTaskSectionNotification, Builder> {
    public static final ProtoAdapter<PushTaskSectionNotification> ADAPTER = null;
    public static final ProtoAdapter_PushTaskSectionNotification RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<TaskSection> task_sections;

    public static final class Builder extends Message.Builder<PushTaskSectionNotification, Builder> implements d<PushTaskSectionNotification> {
        public List<TaskSection> task_sections;

        @Override // com.squareup.wire.Message.Builder
        public PushTaskSectionNotification build() {
            return new PushTaskSectionNotification(this.task_sections, super.buildUnknownFields());
        }

        public Builder() {
            this.task_sections = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder task_sections(List<TaskSection> r100) {
            Internal.checkElementsNotNull(r100);
            this.task_sections = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushTaskSectionNotification extends ProtoAdapter<PushTaskSectionNotification> implements c<PushTaskSectionNotification> {
        public ProtoAdapter_PushTaskSectionNotification() {
            super(FieldEncoding.LENGTH_DELIMITED, PushTaskSectionNotification.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushTaskSectionNotification decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.task_sections.add(TaskSection.ADAPTER.decode(r100));
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
        public int encodedSize2(PushTaskSectionNotification r100) {
            return TaskSection.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.task_sections) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushTaskSectionNotification decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushTaskSectionNotification r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushTaskSectionNotification r101) throws IOException {
            TaskSection.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.task_sections);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushTaskSectionNotification r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushTaskSectionNotification r100 = new ProtoAdapter_PushTaskSectionNotification();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.task_sections = Internal.copyOf("task_sections", this.task_sections);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushTaskSectionNotification.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushTaskSectionNotification(List<TaskSection> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PushTaskSectionNotification(List<TaskSection> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.task_sections = Internal.immutableCopyOf("task_sections", r100);
    }
}
