package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskTimeEntity extends Message<TaskTimeEntity, Builder> {
    public static final ProtoAdapter<TaskTimeEntity> ADAPTER = null;
    public static final Long DEFAULT_DUE_MILLI_TIME = null;
    public static final Boolean DEFAULT_IS_ALL_DAY = null;
    public static final Long DEFAULT_START_MILLI_TIME = null;
    private static final long serialVersionUID = 0;
    public final Long due_milli_time;
    public final Boolean is_all_day;
    public final Long start_milli_time;

    public static final class Builder extends Message.Builder<TaskTimeEntity, Builder> {
        public Long due_milli_time;
        public Boolean is_all_day;
        public Long start_milli_time;

        @Override // com.squareup.wire.Message.Builder
        public TaskTimeEntity build() {
            return new TaskTimeEntity(this.start_milli_time, this.due_milli_time, this.is_all_day, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder due_milli_time(Long r100) {
            this.due_milli_time = r100;
            return this;
        }

        public Builder is_all_day(Boolean r100) {
            this.is_all_day = r100;
            return this;
        }

        public Builder start_milli_time(Long r100) {
            this.start_milli_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskTimeEntity extends ProtoAdapter<TaskTimeEntity> {
        public ProtoAdapter_TaskTimeEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskTimeEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskTimeEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.start_milli_time = 0L;
            r101.due_milli_time = 0L;
            r101.is_all_day = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.start_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.due_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.is_all_day = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(TaskTimeEntity r100) {
            Long r101 = r100.start_milli_time;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.due_milli_time;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.is_all_day;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ TaskTimeEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskTimeEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskTimeEntity r101) throws IOException {
            Long r102 = r101.start_milli_time;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.due_milli_time;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.is_all_day;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskTimeEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskTimeEntity();
        DEFAULT_START_MILLI_TIME = 0L;
        DEFAULT_DUE_MILLI_TIME = 0L;
        DEFAULT_IS_ALL_DAY = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.start_milli_time = this.start_milli_time;
        r100.due_milli_time = this.due_milli_time;
        r100.is_all_day = this.is_all_day;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskTimeEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskTimeEntity(Long r100, Long r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public TaskTimeEntity(Long r100, Long r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.start_milli_time = r100;
        this.due_milli_time = r101;
        this.is_all_day = r102;
    }
}
