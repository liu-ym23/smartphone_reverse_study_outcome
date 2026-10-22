package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskSection extends Message<TaskSection, Builder> {
    public static final ProtoAdapter<TaskSection> ADAPTER = null;
    public static final String DEFAULT_CONTAINER_ID = "";
    public static final Long DEFAULT_DELETE_MILLI_TIME = null;
    public static final String DEFAULT_GUID = "";
    public static final Boolean DEFAULT_IS_DEFAULT = null;
    public static final Boolean DEFAULT_IS_FROM_MEEGO = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_RANK = "";
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final String container_id;
    public final Long delete_milli_time;
    public final String guid;
    public final Boolean is_default;
    public final Boolean is_from_meego;
    public final String key;
    public final String name;
    public final String rank;
    public final Long version;

    public static final class Builder extends Message.Builder<TaskSection, Builder> {
        public String container_id;
        public Long delete_milli_time;
        public String guid;
        public Boolean is_default;
        public Boolean is_from_meego;
        public String key;
        public String name;
        public String rank;
        public Long version;

        @Override // com.squareup.wire.Message.Builder
        public TaskSection build() {
            return new TaskSection(this.guid, this.name, this.is_default, this.key, this.rank, this.container_id, this.is_from_meego, this.version, this.delete_milli_time, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder container_id(String r100) {
            this.container_id = r100;
            return this;
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

        public Builder is_from_meego(Boolean r100) {
            this.is_from_meego = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
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

    public static final class ProtoAdapter_TaskSection extends ProtoAdapter<TaskSection> {
        public ProtoAdapter_TaskSection() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskSection.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskSection decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.guid = "";
            r101.name = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_default = r102;
            r101.key = "";
            r101.rank = "";
            r101.container_id = "";
            r101.is_from_meego = r102;
            r101.version = 0L;
            r101.delete_milli_time = 0L;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L20;
            if (r104 != 100) goto L8;
            r101.version = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r104 != 101) goto L9;
            r101.delete_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L9:
            switch(r104) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                default: goto L10;
            };
        L11:
            r101.is_from_meego = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.container_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.rank = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.is_default = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L16:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L20:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TaskSection r100) {
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
            String r110 = r100.key;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.rank;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.container_id;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Boolean r119 = r100.is_from_meego;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Long r122 = r100.version;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.INT64.encodedSizeWithTag(100, r122);
        L34:
            int r124 = r121 + r123;
            Long r125 = r100.delete_milli_time;
            if (r125 == null) goto L38;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(101, r125);
        L38:
            return (r124 + r102) + r100.unknownFields().size();
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
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
        public /* bridge */ /* synthetic */ TaskSection decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskSection r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskSection r101) throws IOException {
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
            String r105 = r101.key;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.rank;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.container_id;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            Boolean r108 = r101.is_from_meego;
            if (r108 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
        L23:
            Long r109 = r101.version;
            if (r109 == null) goto L26;
            ProtoAdapter.INT64.encodeWithTag(r100, 100, r109);
        L26:
            Long r110 = r101.delete_milli_time;
            if (r110 == null) goto L29;
            ProtoAdapter.INT64.encodeWithTag(r100, 101, r110);
        L29:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskSection r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskSection();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_DEFAULT = r100;
        DEFAULT_IS_FROM_MEEGO = r100;
        DEFAULT_VERSION = 0L;
        DEFAULT_DELETE_MILLI_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.guid = this.guid;
        r100.name = this.name;
        r100.is_default = this.is_default;
        r100.key = this.key;
        r100.rank = this.rank;
        r100.container_id = this.container_id;
        r100.is_from_meego = this.is_from_meego;
        r100.version = this.version;
        r100.delete_milli_time = this.delete_milli_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskSection.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskSection(String r110, String r111, Boolean r112, String r113, String r114, String r115, Boolean r116, Long r117, Long r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public TaskSection(String r100, String r101, Boolean r102, String r103, String r104, String r105, Boolean r106, Long r107, Long r110, ByteString r111) {
        super(ADAPTER, r111);
        this.guid = r100;
        this.name = r101;
        this.is_default = r102;
        this.key = r103;
        this.rank = r104;
        this.container_id = r105;
        this.is_from_meego = r106;
        this.version = r107;
        this.delete_milli_time = r110;
    }
}
