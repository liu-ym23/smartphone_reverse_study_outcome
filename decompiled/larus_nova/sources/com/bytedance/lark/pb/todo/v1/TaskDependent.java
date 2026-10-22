package com.bytedance.lark.pb.todo.v1;

import com.bytedance.lark.pb.basic.v1.RichContent;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskDependent extends Message<TaskDependent, Builder> {
    public static final ProtoAdapter<TaskDependent> ADAPTER = null;
    public static final String DEFAULT_DEPENDENT_BY_GUID = "";
    public static final String DEFAULT_GUID = "";
    public static final Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String dependent_by_guid;
    public final String guid;
    public final RichContent task_summary;
    public final Type type;

    public static final class Builder extends Message.Builder<TaskDependent, Builder> {
        public String dependent_by_guid;
        public String guid;
        public RichContent task_summary;
        public Type type;

        @Override // com.squareup.wire.Message.Builder
        public TaskDependent build() {
            return new TaskDependent(this.guid, this.dependent_by_guid, this.type, this.task_summary, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder dependent_by_guid(String r100) {
            this.dependent_by_guid = r100;
            return this;
        }

        public Builder guid(String r100) {
            this.guid = r100;
            return this;
        }

        public Builder task_summary(RichContent r100) {
            this.task_summary = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskDependent extends ProtoAdapter<TaskDependent> {
        public ProtoAdapter_TaskDependent() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskDependent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskDependent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.guid = "";
            r101.dependent_by_guid = "";
            r101.type = Type.UNKNOWN_TYPE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.dependent_by_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.task_summary = RichContent.ADAPTER.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TaskDependent r100) {
            String r101 = r100.guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.dependent_by_guid;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Type r107 = r100.type;
            if (r107 == null) goto L13;
            int r108 = Type.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            RichContent r110 = r100.task_summary;
            if (r110 == null) goto L18;
            r102 = RichContent.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ TaskDependent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskDependent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskDependent r101) throws IOException {
            String r102 = r101.guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.dependent_by_guid;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Type r104 = r101.type;
            if (r104 == null) goto L11;
            Type.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            RichContent r105 = r101.task_summary;
            if (r105 == null) goto L14;
            RichContent.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskDependent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type NEXT = null;
        public static final Type PREV = null;
        public static final Type UNKNOWN_TYPE = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r100;
            Type r101 = new Type("PREV", 1, 1);
            PREV = r101;
            Type r102 = new Type("NEXT", 2, 2);
            NEXT = r102;
            $VALUES = new Type[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return NEXT;
        L12:
            return PREV;
        L14:
            return UNKNOWN_TYPE;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskDependent();
        DEFAULT_TYPE = Type.UNKNOWN_TYPE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.guid = this.guid;
        r100.dependent_by_guid = this.dependent_by_guid;
        r100.type = this.type;
        r100.task_summary = this.task_summary;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskDependent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskDependent(String r100, String r101, Type r102, RichContent r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public TaskDependent(String r100, String r101, Type r102, RichContent r103, ByteString r104) {
        super(ADAPTER, r104);
        this.guid = r100;
        this.dependent_by_guid = r101;
        this.type = r102;
        this.task_summary = r103;
    }
}
