package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskContainerSection extends Message<TaskContainerSection, Builder> {
    public static final ProtoAdapter<TaskContainerSection> ADAPTER = null;
    public static final Long DEFAULT_DELETE_MILLI_TIME = null;
    public static final String DEFAULT_GUID = "";
    public static final Boolean DEFAULT_IS_DEFAULT = null;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_RANK = "";
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final Long delete_milli_time;
    public final String guid;
    public final Boolean is_default;
    public final String name;
    public final String rank;
    public final Long version;

    public static final class Builder extends Message.Builder<TaskContainerSection, Builder> {
        public Long delete_milli_time;
        public String guid;
        public Boolean is_default;
        public String name;
        public String rank;
        public Long version;

        @Override // com.squareup.wire.Message.Builder
        public TaskContainerSection build() {
            return new TaskContainerSection(this.guid, this.name, this.is_default, this.rank, this.version, this.delete_milli_time, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder delete_milli_time(Long r100) {
            this.delete_milli_time = r100;
            return this;
        }

        public Builder guid(String r100) {
            this.guid = r100;
            return this;
        }

        public Builder is_default(Boolean r100) {
            this.is_default = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder rank(String r100) {
            this.rank = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskContainerSection extends ProtoAdapter<TaskContainerSection> {
        public ProtoAdapter_TaskContainerSection() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskContainerSection.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskContainerSection decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.guid = "";
            r101.name = "";
            r101.is_default = Boolean.FALSE;
            r101.rank = "";
            r101.version = 0L;
            r101.delete_milli_time = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.is_default = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.rank = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 100) goto L16;
            r101.version = ProtoAdapter.INT64.decode(r100);
            goto L3
        L16:
            if (r103 != 101) goto L17;
            r101.delete_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L17:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TaskContainerSection r100) {
            String r101 = r100.guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.name;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.is_default;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.rank;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.version;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT64.encodedSizeWithTag(100, r113);
        L22:
            int r115 = r112 + r114;
            Long r116 = r100.delete_milli_time;
            if (r116 == null) goto L26;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(101, r116);
        L26:
            return (r115 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ TaskContainerSection decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskContainerSection r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskContainerSection r101) throws IOException {
            String r102 = r101.guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.name;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.is_default;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.rank;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Long r106 = r101.version;
            if (r106 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 100, r106);
        L17:
            Long r107 = r101.delete_milli_time;
            if (r107 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 101, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskContainerSection r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskContainerSection();
        DEFAULT_IS_DEFAULT = Boolean.FALSE;
        DEFAULT_VERSION = 0L;
        DEFAULT_DELETE_MILLI_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.guid = this.guid;
        r100.name = this.name;
        r100.is_default = this.is_default;
        r100.rank = this.rank;
        r100.version = this.version;
        r100.delete_milli_time = this.delete_milli_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskContainerSection.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskContainerSection(String r100, String r110, Boolean r111, String r112, Long r113, Long r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public TaskContainerSection(String r100, String r101, Boolean r102, String r103, Long r104, Long r105, ByteString r106) {
        super(ADAPTER, r106);
        this.guid = r100;
        this.name = r101;
        this.is_default = r102;
        this.rank = r103;
        this.version = r104;
        this.delete_milli_time = r105;
    }
}
