package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskRruleUpdateEntity extends Message<TaskRruleUpdateEntity, Builder> {
    public static final ProtoAdapter<TaskRruleUpdateEntity> ADAPTER = null;
    public static final String DEFAULT_NEW_RRULE = "";
    public static final String DEFAULT_OLD_RRULE = "";
    private static final long serialVersionUID = 0;
    public final String new_rrule;
    public final String old_rrule;

    public static final class Builder extends Message.Builder<TaskRruleUpdateEntity, Builder> {
        public String new_rrule;
        public String old_rrule;

        @Override // com.squareup.wire.Message.Builder
        public TaskRruleUpdateEntity build() {
            return new TaskRruleUpdateEntity(this.old_rrule, this.new_rrule, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder new_rrule(String r100) {
            this.new_rrule = r100;
            return this;
        }

        public Builder old_rrule(String r100) {
            this.old_rrule = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskRruleUpdateEntity extends ProtoAdapter<TaskRruleUpdateEntity> {
        public ProtoAdapter_TaskRruleUpdateEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskRruleUpdateEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskRruleUpdateEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.old_rrule = "";
            r101.new_rrule = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.old_rrule = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.new_rrule = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(TaskRruleUpdateEntity r100) {
            String r101 = r100.old_rrule;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.new_rrule;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskRruleUpdateEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskRruleUpdateEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskRruleUpdateEntity r101) throws IOException {
            String r102 = r101.old_rrule;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.new_rrule;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskRruleUpdateEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskRruleUpdateEntity();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.old_rrule = this.old_rrule;
        r100.new_rrule = this.new_rrule;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskRruleUpdateEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskRruleUpdateEntity(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TaskRruleUpdateEntity(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.old_rrule = r100;
        this.new_rrule = r101;
    }
}
