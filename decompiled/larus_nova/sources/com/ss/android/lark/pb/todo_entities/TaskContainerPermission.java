package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class TaskContainerPermission extends Message<TaskContainerPermission, Builder> {
    public static final ProtoAdapter<TaskContainerPermission> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Integer, Boolean> mpermissions;

    public static final class Builder extends Message.Builder<TaskContainerPermission, Builder> {
        public Map<Integer, Boolean> mpermissions;

        @Override // com.squareup.wire.Message.Builder
        public TaskContainerPermission build() {
            return new TaskContainerPermission(this.mpermissions, super.buildUnknownFields());
        }

        public Builder() {
            this.mpermissions = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder permissions(Map<Integer, Boolean> r100) {
            Internal.checkElementsNotNull(r100);
            this.mpermissions = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskContainerPermission extends ProtoAdapter<TaskContainerPermission> {
        private final ProtoAdapter<Map<Integer, Boolean>> mpermissions;

        public ProtoAdapter_TaskContainerPermission() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskContainerPermission.class);
            this.mpermissions = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, ProtoAdapter.BOOL);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskContainerPermission decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mpermissions.putAll(this.mpermissions.decode(r100));
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
        public int encodedSize2(TaskContainerPermission r100) {
            return this.mpermissions.encodedSizeWithTag(1, r100.mpermissions) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskContainerPermission decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskContainerPermission r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskContainerPermission r101) throws IOException {
            this.mpermissions.encodeWithTag(r100, 1, r101.mpermissions);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskContainerPermission r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskContainerPermission();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mpermissions = Internal.copyOf("mpermissions", this.mpermissions);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskContainerPermission.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskContainerPermission(Map<Integer, Boolean> r100) {
        this(r100, ByteString.EMPTY);
    }

    public TaskContainerPermission(Map<Integer, Boolean> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mpermissions = Internal.immutableCopyOf("mpermissions", r100);
    }
}
