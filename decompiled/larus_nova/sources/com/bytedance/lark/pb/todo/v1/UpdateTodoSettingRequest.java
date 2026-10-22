package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class UpdateTodoSettingRequest extends Message<UpdateTodoSettingRequest, Builder> {
    public static final ProtoAdapter<UpdateTodoSettingRequest> ADAPTER = null;
    public static final Type DEFAULT_TYPE = null;
    public static final ProtoAdapter_UpdateTodoSettingRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final TodoLaunchScreen launch_screen;
    public final TodoSetting setting;
    public final Type type;
    public final TodoListViewSetting view_setting;

    public static final class Builder extends Message.Builder<UpdateTodoSettingRequest, Builder> implements d<UpdateTodoSettingRequest> {
        public TodoLaunchScreen launch_screen;
        public TodoSetting setting;
        public Type type;
        public TodoListViewSetting view_setting;

        @Override // com.squareup.wire.Message.Builder
        public UpdateTodoSettingRequest build() {
            return new UpdateTodoSettingRequest(this.type, this.setting, this.view_setting, this.launch_screen, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder launch_screen(TodoLaunchScreen r100) {
            this.launch_screen = r100;
            return this;
        }

        public Builder setting(TodoSetting r100) {
            this.setting = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }

        public Builder view_setting(TodoListViewSetting r100) {
            this.view_setting = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateTodoSettingRequest extends ProtoAdapter<UpdateTodoSettingRequest> implements c<UpdateTodoSettingRequest> {
        public ProtoAdapter_UpdateTodoSettingRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateTodoSettingRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateTodoSettingRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = Type.TODO_SETTING;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.setting = TodoSetting.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.view_setting = TodoListViewSetting.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.launch_screen = TodoLaunchScreen.ADAPTER.decode(r100);
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
        public int encodedSize2(UpdateTodoSettingRequest r100) {
            Type r101 = r100.type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Type.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            TodoSetting r104 = r100.setting;
            if (r104 == null) goto L9;
            int r105 = TodoSetting.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            TodoListViewSetting r107 = r100.view_setting;
            if (r107 == null) goto L13;
            int r108 = TodoListViewSetting.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            TodoLaunchScreen r110 = r100.launch_screen;
            if (r110 == null) goto L18;
            r102 = TodoLaunchScreen.ADAPTER.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ UpdateTodoSettingRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateTodoSettingRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateTodoSettingRequest r101) throws IOException {
            Type r102 = r101.type;
            if (r102 == null) goto L5;
            Type.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            TodoSetting r103 = r101.setting;
            if (r103 == null) goto L8;
            TodoSetting.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            TodoListViewSetting r104 = r101.view_setting;
            if (r104 == null) goto L11;
            TodoListViewSetting.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            TodoLaunchScreen r105 = r101.launch_screen;
            if (r105 == null) goto L14;
            TodoLaunchScreen.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateTodoSettingRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type LAUNCH_SCREEN = null;
        public static final Type TODO_SETTING = null;
        public static final Type UNKNOWN = null;
        public static final Type VIEW_SETTING = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("TODO_SETTING", 1, 1);
            TODO_SETTING = r101;
            Type r102 = new Type("VIEW_SETTING", 2, 2);
            VIEW_SETTING = r102;
            Type r103 = new Type("LAUNCH_SCREEN", 3, 3);
            LAUNCH_SCREEN = r103;
            $VALUES = new Type[]{r100, r101, r102, r103};
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
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return LAUNCH_SCREEN;
        L14:
            return VIEW_SETTING;
        L16:
            return TODO_SETTING;
        L18:
            return UNKNOWN;
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
        ProtoAdapter_UpdateTodoSettingRequest r100 = new ProtoAdapter_UpdateTodoSettingRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_TYPE = Type.TODO_SETTING;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.setting = this.setting;
        r100.view_setting = this.view_setting;
        r100.launch_screen = this.launch_screen;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateTodoSettingRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateTodoSettingRequest(Type r100, TodoSetting r101, TodoListViewSetting r102, TodoLaunchScreen r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public UpdateTodoSettingRequest(Type r100, TodoSetting r101, TodoListViewSetting r102, TodoLaunchScreen r103, ByteString r104) {
        super(ADAPTER, r104);
        this.type = r100;
        this.setting = r101;
        this.view_setting = r102;
        this.launch_screen = r103;
    }
}
