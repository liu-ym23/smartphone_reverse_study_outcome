package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class MarkTodoCompletedRequest extends Message<MarkTodoCompletedRequest, Builder> {
    public static final ProtoAdapter<MarkTodoCompletedRequest> ADAPTER = null;
    public static final String DEFAULT_CONTAINER_ID = "";
    public static final String DEFAULT_GUID = "";
    public static final Boolean DEFAULT_IS_COMPLETED = null;
    public static final TodoSource DEFAULT_SOURCE = null;
    public static final Type DEFAULT_TYPE = null;
    public static final ProtoAdapter_MarkTodoCompletedRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String container_id;
    public final String guid;
    public final Boolean is_completed;
    public final TodoSource source;
    public final List<String> target_user_ids;
    public final Type type;

    public static final class Builder extends Message.Builder<MarkTodoCompletedRequest, Builder> implements d<MarkTodoCompletedRequest> {
        public String container_id;
        public String guid;
        public Boolean is_completed;
        public TodoSource source;
        public List<String> target_user_ids;
        public Type type;

        @Override // com.squareup.wire.Message.Builder
        public MarkTodoCompletedRequest build() {
            return new MarkTodoCompletedRequest(this.guid, this.is_completed, this.source, this.type, this.target_user_ids, this.container_id, super.buildUnknownFields());
        }

        public Builder() {
            this.target_user_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder container_id(String r100) {
            this.container_id = r100;
            return this;
        }

        public Builder guid(String r100) {
            this.guid = r100;
            return this;
        }

        public Builder is_completed(Boolean r100) {
            this.is_completed = r100;
            return this;
        }

        public Builder source(TodoSource r100) {
            this.source = r100;
            return this;
        }

        public Builder target_user_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.target_user_ids = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MarkTodoCompletedRequest extends ProtoAdapter<MarkTodoCompletedRequest> implements c<MarkTodoCompletedRequest> {
        public ProtoAdapter_MarkTodoCompletedRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, MarkTodoCompletedRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MarkTodoCompletedRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.guid = "";
            r101.is_completed = Boolean.FALSE;
            r101.source = TodoSource.UNKNOWN_SOURCE;
            r101.type = Type.USER;
            r101.container_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L21;
                case 4: goto L23;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L21:
            r101.source = TodoSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L23:
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.container_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.target_user_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L17:
            r101.is_completed = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L18:
            r101.guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MarkTodoCompletedRequest r100) {
            String r101 = r100.guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.is_completed;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            TodoSource r107 = r100.source;
            if (r107 == null) goto L13;
            int r108 = TodoSource.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Type r110 = r100.type;
            if (r110 == null) goto L17;
            int r111 = Type.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            ProtoAdapter<String> r113 = ProtoAdapter.STRING;
            int r114 = r112 + r113.asRepeated().encodedSizeWithTag(5, r100.target_user_ids);
            String r115 = r100.container_id;
            if (r115 == null) goto L22;
            r102 = r113.encodedSizeWithTag(6, r115);
        L22:
            return (r114 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ MarkTodoCompletedRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MarkTodoCompletedRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MarkTodoCompletedRequest r101) throws IOException {
            String r102 = r101.guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.is_completed;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            TodoSource r104 = r101.source;
            if (r104 == null) goto L11;
            TodoSource.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            Type r105 = r101.type;
            if (r105 == null) goto L14;
            Type.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            ProtoAdapter<String> r106 = ProtoAdapter.STRING;
            r106.asRepeated().encodeWithTag(r100, 5, r101.target_user_ids);
            String r107 = r101.container_id;
            if (r107 == null) goto L17;
            r106.encodeWithTag(r100, 6, r107);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MarkTodoCompletedRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type Todo = null;
        public static final Type USER = null;
        private final int value;

        static {
            Type r100 = new Type("Todo", 0, 1);
            Todo = r100;
            Type r101 = new Type(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 2);
            USER = r101;
            $VALUES = new Type[]{r100, r101};
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
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return USER;
        L11:
            return Todo;
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
        ProtoAdapter_MarkTodoCompletedRequest r100 = new ProtoAdapter_MarkTodoCompletedRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_IS_COMPLETED = Boolean.FALSE;
        DEFAULT_SOURCE = TodoSource.UNKNOWN_SOURCE;
        DEFAULT_TYPE = Type.USER;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.guid = this.guid;
        r100.is_completed = this.is_completed;
        r100.source = this.source;
        r100.type = this.type;
        r100.target_user_ids = Internal.copyOf("target_user_ids", this.target_user_ids);
        r100.container_id = this.container_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MarkTodoCompletedRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MarkTodoCompletedRequest(String r100, Boolean r110, TodoSource r111, Type r112, List<String> r113, String r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public MarkTodoCompletedRequest(String r100, Boolean r101, TodoSource r102, Type r103, List<String> r104, String r105, ByteString r106) {
        super(ADAPTER, r106);
        this.guid = r100;
        this.is_completed = r101;
        this.source = r102;
        this.type = r103;
        this.target_user_ids = Internal.immutableCopyOf("target_user_ids", r104);
        this.container_id = r105;
    }
}
