package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskContainerSectionRef extends Message<TaskContainerSectionRef, Builder> {
    public static final ProtoAdapter<TaskContainerSectionRef> ADAPTER = null;
    public static final String DEFAULT_CONTAINER_GUID = "";
    public static final Long DEFAULT_DELETE_MILLI_TIME = null;
    public static final String DEFAULT_RANK = "";
    public static final String DEFAULT_SECTION_GUID = "";
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final String container_guid;
    public final Long delete_milli_time;
    public final String rank;
    public final String section_guid;
    public final Long version;

    public static final class Builder extends Message.Builder<TaskContainerSectionRef, Builder> {
        public String container_guid;
        public Long delete_milli_time;
        public String rank;
        public String section_guid;
        public Long version;

        @Override // com.squareup.wire.Message.Builder
        public TaskContainerSectionRef build() {
            return new TaskContainerSectionRef(this.container_guid, this.section_guid, this.rank, this.version, this.delete_milli_time, super.buildUnknownFields());
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

        public Builder delete_milli_time(Long r100) {
            this.delete_milli_time = r100;
            return this;
        }

        public Builder rank(String r100) {
            this.rank = r100;
            return this;
        }

        public Builder section_guid(String r100) {
            this.section_guid = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskContainerSectionRef extends ProtoAdapter<TaskContainerSectionRef> {
        public ProtoAdapter_TaskContainerSectionRef() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskContainerSectionRef.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskContainerSectionRef decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.container_guid = "";
            r101.section_guid = "";
            r101.rank = "";
            r101.version = 0L;
            r101.delete_milli_time = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.container_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.section_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.rank = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 100) goto L14;
            r101.version = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            if (r103 != 101) goto L15;
            r101.delete_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TaskContainerSectionRef r100) {
            String r101 = r100.container_guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.section_guid;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.rank;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.version;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT64.encodedSizeWithTag(100, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.delete_milli_time;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(101, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ TaskContainerSectionRef decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskContainerSectionRef r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskContainerSectionRef r101) throws IOException {
            String r102 = r101.container_guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.section_guid;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.rank;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.version;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 100, r105);
        L14:
            Long r106 = r101.delete_milli_time;
            if (r106 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 101, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskContainerSectionRef r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskContainerSectionRef();
        DEFAULT_VERSION = 0L;
        DEFAULT_DELETE_MILLI_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.container_guid = this.container_guid;
        r100.section_guid = this.section_guid;
        r100.rank = this.rank;
        r100.version = this.version;
        r100.delete_milli_time = this.delete_milli_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskContainerSectionRef.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskContainerSectionRef(String r100, String r101, String r110, Long r111, Long r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public TaskContainerSectionRef(String r100, String r101, String r102, Long r103, Long r104, ByteString r105) {
        super(ADAPTER, r105);
        this.container_guid = r100;
        this.section_guid = r101;
        this.rank = r102;
        this.version = r103;
        this.delete_milli_time = r104;
    }
}
