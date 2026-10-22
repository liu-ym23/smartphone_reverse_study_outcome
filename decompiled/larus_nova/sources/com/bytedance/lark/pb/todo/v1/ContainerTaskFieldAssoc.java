package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ContainerTaskFieldAssoc extends Message<ContainerTaskFieldAssoc, Builder> {
    public static final ProtoAdapter<ContainerTaskFieldAssoc> ADAPTER = null;
    public static final String DEFAULT_CONTAINER_GUID = "";
    public static final Long DEFAULT_CREATE_MILLI_TIME = null;
    public static final Long DEFAULT_DELETE_MILLI_TIME = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final String container_guid;
    public final Long create_milli_time;
    public final TodoUser creator;
    public final Long delete_milli_time;
    public final TodoUser deleter;
    public final TaskField task_field;
    public final Long version;

    public static final class Builder extends Message.Builder<ContainerTaskFieldAssoc, Builder> {
        public String container_guid;
        public Long create_milli_time;
        public TodoUser creator;
        public Long delete_milli_time;
        public TodoUser deleter;
        public TaskField task_field;
        public Long version;

        @Override // com.squareup.wire.Message.Builder
        public ContainerTaskFieldAssoc build() {
            return new ContainerTaskFieldAssoc(this.task_field, this.container_guid, this.creator, this.deleter, this.create_milli_time, this.delete_milli_time, this.version, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder container_guid(String r100) {
            this.container_guid = r100;
            return this;
        }

        public Builder create_milli_time(Long r100) {
            this.create_milli_time = r100;
            return this;
        }

        public Builder creator(TodoUser r100) {
            this.creator = r100;
            return this;
        }

        public Builder delete_milli_time(Long r100) {
            this.delete_milli_time = r100;
            return this;
        }

        public Builder deleter(TodoUser r100) {
            this.deleter = r100;
            return this;
        }

        public Builder task_field(TaskField r100) {
            this.task_field = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ContainerTaskFieldAssoc extends ProtoAdapter<ContainerTaskFieldAssoc> {
        public ProtoAdapter_ContainerTaskFieldAssoc() {
            super(FieldEncoding.LENGTH_DELIMITED, ContainerTaskFieldAssoc.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ContainerTaskFieldAssoc decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.container_guid = "";
            r101.create_milli_time = 0L;
            r101.delete_milli_time = 0L;
            r101.version = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L22;
            if (r103 != 1) goto L8;
            r101.task_field = TaskField.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.container_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.creator = TodoUser.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.deleter = TodoUser.ADAPTER.decode(r100);
            goto L3
        L13:
            switch(r103) {
                case 100: goto L17;
                case 101: goto L16;
                case 102: goto L15;
                default: goto L14;
            };
        L15:
            r101.version = ProtoAdapter.INT64.decode(r100);
            goto L3
        L16:
            r101.delete_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L17:
            r101.create_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L22:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ContainerTaskFieldAssoc r100) {
            TaskField r101 = r100.task_field;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = TaskField.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.container_guid;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            TodoUser r107 = r100.creator;
            if (r107 == null) goto L13;
            int r108 = TodoUser.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            TodoUser r110 = r100.deleter;
            if (r110 == null) goto L17;
            int r111 = TodoUser.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.create_milli_time;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT64.encodedSizeWithTag(100, r113);
        L22:
            int r115 = r112 + r114;
            Long r116 = r100.delete_milli_time;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.INT64.encodedSizeWithTag(101, r116);
        L26:
            int r118 = r115 + r117;
            Long r119 = r100.version;
            if (r119 == null) goto L30;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(102, r119);
        L30:
            return (r118 + r102) + r100.unknownFields().size();
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ContainerTaskFieldAssoc decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ContainerTaskFieldAssoc r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ContainerTaskFieldAssoc r101) throws IOException {
            TaskField r102 = r101.task_field;
            if (r102 == null) goto L5;
            TaskField.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.container_guid;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            TodoUser r104 = r101.creator;
            if (r104 == null) goto L11;
            TodoUser.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            TodoUser r105 = r101.deleter;
            if (r105 == null) goto L14;
            TodoUser.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            Long r106 = r101.create_milli_time;
            if (r106 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 100, r106);
        L17:
            Long r107 = r101.delete_milli_time;
            if (r107 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 101, r107);
        L20:
            Long r108 = r101.version;
            if (r108 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r100, 102, r108);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ContainerTaskFieldAssoc r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ContainerTaskFieldAssoc();
        DEFAULT_CREATE_MILLI_TIME = 0L;
        DEFAULT_DELETE_MILLI_TIME = 0L;
        DEFAULT_VERSION = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.task_field = this.task_field;
        r100.container_guid = this.container_guid;
        r100.creator = this.creator;
        r100.deleter = this.deleter;
        r100.create_milli_time = this.create_milli_time;
        r100.delete_milli_time = this.delete_milli_time;
        r100.version = this.version;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ContainerTaskFieldAssoc.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ContainerTaskFieldAssoc(TaskField r110, String r111, TodoUser r112, TodoUser r113, Long r114, Long r115, Long r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public ContainerTaskFieldAssoc(TaskField r100, String r101, TodoUser r102, TodoUser r103, Long r104, Long r105, Long r106, ByteString r107) {
        super(ADAPTER, r107);
        this.task_field = r100;
        this.container_guid = r101;
        this.creator = r102;
        this.deleter = r103;
        this.create_milli_time = r104;
        this.delete_milli_time = r105;
        this.version = r106;
    }
}
