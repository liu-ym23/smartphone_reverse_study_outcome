package com.bytedance.lark.pb.todo.v1;

import com.bytedance.lark.pb.basic.v1.RichText;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class TodoLaunchScreen extends Message<TodoLaunchScreen, Builder> {
    public static final ProtoAdapter<TodoLaunchScreen> ADAPTER = null;
    public static final Boolean DEFAULT_ENABLE_BUTTON = null;
    public static final Boolean DEFAULT_ENABLE_EXIT = null;
    public static final Integer DEFAULT_INT_TYPE = null;
    public static final TodoLaunchStatus DEFAULT_STATUS = null;
    public static final TodoLaunchType DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final CustomComplete button_action;
    public final Map<String, String> button_i18n_texts;
    public final Boolean enable_button;
    public final Boolean enable_exit;
    public final List<TodoListView.Type> enable_tabs;
    public final Map<String, RichText> i18n_rich_texts;
    public final Integer int_type;
    public final TodoLaunchStatus status;
    public final TodoLaunchType type;

    public static final class Builder extends Message.Builder<TodoLaunchScreen, Builder> {
        public CustomComplete button_action;
        public Map<String, String> button_i18n_texts;
        public Boolean enable_button;
        public Boolean enable_exit;
        public List<TodoListView.Type> enable_tabs;
        public Map<String, RichText> i18n_rich_texts;
        public Integer int_type;
        public TodoLaunchStatus status;
        public TodoLaunchType type;

        @Override // com.squareup.wire.Message.Builder
        public TodoLaunchScreen build() {
            return new TodoLaunchScreen(this.type, this.status, this.enable_exit, this.enable_tabs, this.i18n_rich_texts, this.enable_button, this.button_i18n_texts, this.button_action, this.int_type, super.buildUnknownFields());
        }

        public Builder() {
            this.enable_tabs = Internal.newMutableList();
            this.i18n_rich_texts = Internal.newMutableMap();
            this.button_i18n_texts = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder button_action(CustomComplete r100) {
            this.button_action = r100;
            return this;
        }

        public Builder button_i18n_texts(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.button_i18n_texts = r100;
            return this;
        }

        public Builder enable_button(Boolean r100) {
            this.enable_button = r100;
            return this;
        }

        public Builder enable_exit(Boolean r100) {
            this.enable_exit = r100;
            return this;
        }

        public Builder enable_tabs(List<TodoListView.Type> r100) {
            Internal.checkElementsNotNull(r100);
            this.enable_tabs = r100;
            return this;
        }

        public Builder i18n_rich_texts(Map<String, RichText> r100) {
            Internal.checkElementsNotNull(r100);
            this.i18n_rich_texts = r100;
            return this;
        }

        public Builder int_type(Integer r100) {
            this.int_type = r100;
            return this;
        }

        public Builder status(TodoLaunchStatus r100) {
            this.status = r100;
            return this;
        }

        public Builder type(TodoLaunchType r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TodoLaunchScreen extends ProtoAdapter<TodoLaunchScreen> {
        private final ProtoAdapter<Map<String, String>> button_i18n_texts;
        private final ProtoAdapter<Map<String, RichText>> i18n_rich_texts;

        public ProtoAdapter_TodoLaunchScreen() {
            super(FieldEncoding.LENGTH_DELIMITED, TodoLaunchScreen.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.i18n_rich_texts = ProtoAdapter.newMapAdapter(r100, RichText.ADAPTER);
            this.button_i18n_texts = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TodoLaunchScreen decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = TodoLaunchType.UNKNOWN_TYPE;
            r101.status = TodoLaunchStatus.Enable;
            Boolean r102 = Boolean.FALSE;
            r101.enable_exit = r102;
            r101.enable_button = r102;
            r101.int_type = 0;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L25;
            switch(r104) {
                case 1: goto L27;
                case 2: goto L31;
                case 3: goto L16;
                case 4: goto L29;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L27:
            r101.type = TodoLaunchType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L29:
            r101.enable_tabs.add(TodoListView.Type.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L31:
            r101.status = TodoLaunchStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.int_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            r101.button_action = CustomComplete.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.button_i18n_texts.putAll(this.button_i18n_texts.decode(r100));
            goto L3
        L10:
            r101.enable_button = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.i18n_rich_texts.putAll(this.i18n_rich_texts.decode(r100));
            goto L3
        L16:
            r101.enable_exit = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L25:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TodoLaunchScreen r100) {
            TodoLaunchType r101 = r100.type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = TodoLaunchType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            TodoLaunchStatus r104 = r100.status;
            if (r104 == null) goto L9;
            int r105 = TodoLaunchStatus.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.enable_exit;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = ((r106 + r108) + TodoListView.Type.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.enable_tabs)) + this.i18n_rich_texts.encodedSizeWithTag(5, r100.i18n_rich_texts);
            Boolean r110 = r100.enable_button;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r110);
        L18:
            int r112 = (r109 + r111) + this.button_i18n_texts.encodedSizeWithTag(7, r100.button_i18n_texts);
            CustomComplete r113 = r100.button_action;
            if (r113 == null) goto L21;
            int r114 = CustomComplete.ADAPTER.encodedSizeWithTag(8, r113);
        L22:
            int r115 = r112 + r114;
            Integer r116 = r100.int_type;
            if (r116 == null) goto L26;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(9, r116);
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
        public /* bridge */ /* synthetic */ TodoLaunchScreen decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TodoLaunchScreen r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TodoLaunchScreen r101) throws IOException {
            TodoLaunchType r102 = r101.type;
            if (r102 == null) goto L5;
            TodoLaunchType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            TodoLaunchStatus r103 = r101.status;
            if (r103 == null) goto L8;
            TodoLaunchStatus.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.enable_exit;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            TodoListView.Type.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.enable_tabs);
            this.i18n_rich_texts.encodeWithTag(r100, 5, r101.i18n_rich_texts);
            Boolean r105 = r101.enable_button;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r105);
        L14:
            this.button_i18n_texts.encodeWithTag(r100, 7, r101.button_i18n_texts);
            CustomComplete r106 = r101.button_action;
            if (r106 == null) goto L17;
            CustomComplete.ADAPTER.encodeWithTag(r100, 8, r106);
        L17:
            Integer r107 = r101.int_type;
            if (r107 == null) goto L20;
            ProtoAdapter.INT32.encodeWithTag(r100, 9, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TodoLaunchScreen r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum TodoLaunchStatus extends Enum<TodoLaunchStatus> implements WireEnum {
        private static final /* synthetic */ TodoLaunchStatus[] $VALUES = null;
        public static final ProtoAdapter<TodoLaunchStatus> ADAPTER = null;
        public static final TodoLaunchStatus Disable = null;
        public static final TodoLaunchStatus Enable = null;
        public static final TodoLaunchStatus Exit = null;
        private final int value;

        static {
            TodoLaunchStatus r100 = new TodoLaunchStatus("Enable", 0, 0);
            Enable = r100;
            TodoLaunchStatus r101 = new TodoLaunchStatus("Disable", 1, 1);
            Disable = r101;
            TodoLaunchStatus r102 = new TodoLaunchStatus("Exit", 2, 2);
            Exit = r102;
            $VALUES = new TodoLaunchStatus[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(TodoLaunchStatus.class);
        }

        public static TodoLaunchStatus[] values() {
            return (TodoLaunchStatus[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static TodoLaunchStatus fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return Exit;
        L12:
            return Disable;
        L14:
            return Enable;
        }

        public static TodoLaunchStatus valueOf(String r100) {
            return (TodoLaunchStatus) a.a(TodoLaunchStatus.class, r100);
        }

        private TodoLaunchStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum TodoLaunchType extends Enum<TodoLaunchType> implements WireEnum {
        private static final /* synthetic */ TodoLaunchType[] $VALUES = null;
        public static final ProtoAdapter<TodoLaunchType> ADAPTER = null;
        public static final TodoLaunchType ENTER_DOC_TAB = null;
        public static final TodoLaunchType UNKNOWN_TYPE = null;
        private final int value;

        static {
            TodoLaunchType r100 = new TodoLaunchType("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r100;
            TodoLaunchType r101 = new TodoLaunchType("ENTER_DOC_TAB", 1, 1);
            ENTER_DOC_TAB = r101;
            $VALUES = new TodoLaunchType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(TodoLaunchType.class);
        }

        public static TodoLaunchType[] values() {
            return (TodoLaunchType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static TodoLaunchType fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return ENTER_DOC_TAB;
        L10:
            return UNKNOWN_TYPE;
        }

        public static TodoLaunchType valueOf(String r100) {
            return (TodoLaunchType) a.a(TodoLaunchType.class, r100);
        }

        private TodoLaunchType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TodoLaunchScreen();
        DEFAULT_TYPE = TodoLaunchType.UNKNOWN_TYPE;
        DEFAULT_STATUS = TodoLaunchStatus.Enable;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_ENABLE_EXIT = r100;
        DEFAULT_ENABLE_BUTTON = r100;
        DEFAULT_INT_TYPE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.status = this.status;
        r100.enable_exit = this.enable_exit;
        r100.enable_tabs = Internal.copyOf("enable_tabs", this.enable_tabs);
        r100.i18n_rich_texts = Internal.copyOf("i18n_rich_texts", this.i18n_rich_texts);
        r100.enable_button = this.enable_button;
        r100.button_i18n_texts = Internal.copyOf("button_i18n_texts", this.button_i18n_texts);
        r100.button_action = this.button_action;
        r100.int_type = this.int_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TodoLaunchScreen.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TodoLaunchScreen(TodoLaunchType r110, TodoLaunchStatus r111, Boolean r112, List<TodoListView.Type> r113, Map<String, RichText> r114, Boolean r115, Map<String, String> r116, CustomComplete r117, Integer r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public TodoLaunchScreen(TodoLaunchType r100, TodoLaunchStatus r101, Boolean r102, List<TodoListView.Type> r103, Map<String, RichText> r104, Boolean r105, Map<String, String> r106, CustomComplete r107, Integer r110, ByteString r111) {
        super(ADAPTER, r111);
        this.type = r100;
        this.status = r101;
        this.enable_exit = r102;
        this.enable_tabs = Internal.immutableCopyOf("enable_tabs", r103);
        this.i18n_rich_texts = Internal.immutableCopyOf("i18n_rich_texts", r104);
        this.enable_button = r105;
        this.button_i18n_texts = Internal.immutableCopyOf("button_i18n_texts", r106);
        this.button_action = r107;
        this.int_type = r110;
    }
}
