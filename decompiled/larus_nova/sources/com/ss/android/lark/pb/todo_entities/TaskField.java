package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class TaskField extends Message<TaskField, Builder> {
    public static final ProtoAdapter<TaskField> ADAPTER = null;
    public static final Long DEFAULT_CREATE_MILLI_TIME = null;
    public static final Long DEFAULT_CREATOR_ID = null;
    public static final Long DEFAULT_DELETED_MILLI_TIME = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_NAME = "";
    public static final Long DEFAULT_UPDATE_MILLI_TIME = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final TaskFieldCategory mcategory;
    public final Long mcreate_milli_time;
    public final Long mcreator_id;
    public final Long mdeleted_milli_time;
    public final String mkey;
    public final String mname;
    public final TaskFieldSettings msettings;
    public final FieldType mtype;
    public final Long mupdate_milli_time;
    public final Long mversion;

    public static final class Builder extends Message.Builder<TaskField, Builder> {
        public TaskFieldCategory mcategory;
        public Long mcreate_milli_time;
        public Long mcreator_id;
        public Long mdeleted_milli_time;
        public String mkey;
        public String mname;
        public TaskFieldSettings msettings;
        public FieldType mtype;
        public Long mupdate_milli_time;
        public Long mversion;

        @Override // com.squareup.wire.Message.Builder
        public TaskField build() {
            return new TaskField(this.mkey, this.mname, this.mtype, this.msettings, this.mcategory, this.mcreator_id, this.mcreate_milli_time, this.mupdate_milli_time, this.mdeleted_milli_time, this.mversion, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder category(TaskFieldCategory r100) {
            this.mcategory = r100;
            return this;
        }

        public Builder create_milli_time(Long r100) {
            this.mcreate_milli_time = r100;
            return this;
        }

        public Builder creator_id(Long r100) {
            this.mcreator_id = r100;
            return this;
        }

        public Builder deleted_milli_time(Long r100) {
            this.mdeleted_milli_time = r100;
            return this;
        }

        public Builder key(String r100) {
            this.mkey = r100;
            return this;
        }

        public Builder name(String r100) {
            this.mname = r100;
            return this;
        }

        public Builder settings(TaskFieldSettings r100) {
            this.msettings = r100;
            return this;
        }

        public Builder type(FieldType r100) {
            this.mtype = r100;
            return this;
        }

        public Builder update_milli_time(Long r100) {
            this.mupdate_milli_time = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.mversion = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskField extends ProtoAdapter<TaskField> {
        public ProtoAdapter_TaskField() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskField.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskField decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mkey = "";
            r101.mname = "";
            r101.mcreator_id = 0L;
            r101.mcreate_milli_time = 0L;
            r101.mupdate_milli_time = 0L;
            r101.mdeleted_milli_time = 0L;
            r101.mversion = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            switch(r103) {
                case 1: goto L23;
                case 2: goto L22;
                case 3: goto L28;
                case 4: goto L17;
                case 5: goto L26;
                case 6: goto L12;
                default: goto L6;
            };
        L26:
            r101.mcategory = TaskFieldCategory.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L28:
            r101.mtype = FieldType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            r101.mcreator_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L17:
            r101.msettings = TaskFieldSettings.ADAPTER.decode(r100);
            goto L3
        L22:
            r101.mname = ProtoAdapter.STRING.decode(r100);
            goto L3
        L23:
            r101.mkey = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            switch(r103) {
                case 100: goto L11;
                case 101: goto L10;
                case 102: goto L9;
                case 103: goto L8;
                default: goto L7;
            };
        L8:
            r101.mversion = ProtoAdapter.INT64.decode(r100);
            goto L3
        L9:
            r101.mdeleted_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            r101.mupdate_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L11:
            r101.mcreate_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TaskField r100) {
            String r101 = r100.mkey;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mname;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            FieldType r107 = r100.mtype;
            if (r107 == null) goto L13;
            int r108 = FieldType.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            TaskFieldSettings r110 = r100.msettings;
            if (r110 == null) goto L17;
            int r111 = TaskFieldSettings.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            TaskFieldCategory r113 = r100.mcategory;
            if (r113 == null) goto L21;
            int r114 = TaskFieldCategory.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Long r116 = r100.mcreator_id;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.INT64.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Long r119 = r100.mcreate_milli_time;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.INT64.encodedSizeWithTag(100, r119);
        L30:
            int r121 = r118 + r120;
            Long r122 = r100.mupdate_milli_time;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.INT64.encodedSizeWithTag(101, r122);
        L34:
            int r124 = r121 + r123;
            Long r125 = r100.mdeleted_milli_time;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.INT64.encodedSizeWithTag(102, r125);
        L38:
            int r127 = r124 + r126;
            Long r128 = r100.mversion;
            if (r128 == null) goto L42;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(103, r128);
        L42:
            return (r127 + r102) + r100.unknownFields().size();
        L37:
            r126 = 0;
            goto L38
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
        public /* bridge */ /* synthetic */ TaskField decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskField r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskField r101) throws IOException {
            String r102 = r101.mkey;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mname;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            FieldType r104 = r101.mtype;
            if (r104 == null) goto L11;
            FieldType.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            TaskFieldSettings r105 = r101.msettings;
            if (r105 == null) goto L14;
            TaskFieldSettings.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            TaskFieldCategory r106 = r101.mcategory;
            if (r106 == null) goto L17;
            TaskFieldCategory.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            Long r107 = r101.mcreator_id;
            if (r107 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 6, r107);
        L20:
            Long r108 = r101.mcreate_milli_time;
            if (r108 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r100, 100, r108);
        L23:
            Long r109 = r101.mupdate_milli_time;
            if (r109 == null) goto L26;
            ProtoAdapter.INT64.encodeWithTag(r100, 101, r109);
        L26:
            Long r110 = r101.mdeleted_milli_time;
            if (r110 == null) goto L29;
            ProtoAdapter.INT64.encodeWithTag(r100, 102, r110);
        L29:
            Long r111 = r101.mversion;
            if (r111 == null) goto L32;
            ProtoAdapter.INT64.encodeWithTag(r100, 103, r111);
        L32:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskField r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskField();
        DEFAULT_CREATOR_ID = 0L;
        DEFAULT_CREATE_MILLI_TIME = 0L;
        DEFAULT_UPDATE_MILLI_TIME = 0L;
        DEFAULT_DELETED_MILLI_TIME = 0L;
        DEFAULT_VERSION = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mkey = this.mkey;
        r100.mname = this.mname;
        r100.mtype = this.mtype;
        r100.msettings = this.msettings;
        r100.mcategory = this.mcategory;
        r100.mcreator_id = this.mcreator_id;
        r100.mcreate_milli_time = this.mcreate_milli_time;
        r100.mupdate_milli_time = this.mupdate_milli_time;
        r100.mdeleted_milli_time = this.mdeleted_milli_time;
        r100.mversion = this.mversion;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskField.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskField(String r110, String r111, FieldType r112, TaskFieldSettings r113, TaskFieldCategory r114, Long r115, Long r116, Long r210, Long r211, Long r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public TaskField(String r100, String r101, FieldType r102, TaskFieldSettings r103, TaskFieldCategory r104, Long r105, Long r106, Long r107, Long r110, Long r111, ByteString r112) {
        super(ADAPTER, r112);
        this.mkey = r100;
        this.mname = r101;
        this.mtype = r102;
        this.msettings = r103;
        this.mcategory = r104;
        this.mcreator_id = r105;
        this.mcreate_milli_time = r106;
        this.mupdate_milli_time = r107;
        this.mdeleted_milli_time = r110;
        this.mversion = r111;
    }
}
