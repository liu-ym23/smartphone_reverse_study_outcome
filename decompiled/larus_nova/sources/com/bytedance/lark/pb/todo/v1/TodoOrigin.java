package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class TodoOrigin extends Message<TodoOrigin, Builder> {
    public static final ProtoAdapter<TodoOrigin> ADAPTER = null;
    public static final String DEFAULT_DISPLAY_I18N_NAME = "";
    public static final Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final TodoSourceBlock block;
    public final TodoSourceChat chat;
    public final String display_i18n_name;
    public final TodoSourceHref href;
    public final TodoSourceMeego meego;
    public final Map<String, String> platform_i18n_name;
    public final Type type;

    public static final class Builder extends Message.Builder<TodoOrigin, Builder> {
        public TodoSourceBlock block;
        public TodoSourceChat chat;
        public String display_i18n_name;
        public TodoSourceHref href;
        public TodoSourceMeego meego;
        public Map<String, String> platform_i18n_name;
        public Type type;

        @Override // com.squareup.wire.Message.Builder
        public TodoOrigin build() {
            return new TodoOrigin(this.type, this.platform_i18n_name, this.display_i18n_name, this.block, this.href, this.chat, this.meego, super.buildUnknownFields());
        }

        public Builder() {
            this.platform_i18n_name = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder block(TodoSourceBlock r100) {
            this.block = r100;
            this.href = null;
            this.chat = null;
            this.meego = null;
            return this;
        }

        public Builder chat(TodoSourceChat r100) {
            this.chat = r100;
            this.block = null;
            this.href = null;
            this.meego = null;
            return this;
        }

        public Builder display_i18n_name(String r100) {
            this.display_i18n_name = r100;
            return this;
        }

        public Builder href(TodoSourceHref r100) {
            this.href = r100;
            this.block = null;
            this.chat = null;
            this.meego = null;
            return this;
        }

        public Builder meego(TodoSourceMeego r100) {
            this.meego = r100;
            this.block = null;
            this.href = null;
            this.chat = null;
            return this;
        }

        public Builder platform_i18n_name(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.platform_i18n_name = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TodoOrigin extends ProtoAdapter<TodoOrigin> {
        private final ProtoAdapter<Map<String, String>> platform_i18n_name;

        public ProtoAdapter_TodoOrigin() {
            super(FieldEncoding.LENGTH_DELIMITED, TodoOrigin.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.platform_i18n_name = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TodoOrigin decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = Type.UNKNOWN;
            r101.display_i18n_name = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L23;
            if (r103 != 1) goto L8;
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 3) goto L10;
            r101.platform_i18n_name.putAll(this.platform_i18n_name.decode(r100));
            goto L3
        L10:
            if (r103 != 150) goto L11;
            r101.display_i18n_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            switch(r103) {
                case 100: goto L16;
                case 101: goto L15;
                case 102: goto L14;
                case 103: goto L13;
                default: goto L12;
            };
        L13:
            r101.meego(TodoSourceMeego.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.chat(TodoSourceChat.ADAPTER.decode(r100));
            goto L3
        L15:
            r101.href(TodoSourceHref.ADAPTER.decode(r100));
            goto L3
        L16:
            r101.block(TodoSourceBlock.ADAPTER.decode(r100));
            goto L3
        L12:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L23:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TodoOrigin r100) {
            Type r101 = r100.type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Type.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + this.platform_i18n_name.encodedSizeWithTag(3, r100.platform_i18n_name);
            String r105 = r100.display_i18n_name;
            if (r105 == null) goto L9;
            int r106 = ProtoAdapter.STRING.encodedSizeWithTag(150, r105);
        L10:
            int r107 = r104 + r106;
            TodoSourceBlock r108 = r100.block;
            if (r108 == null) goto L13;
            int r109 = TodoSourceBlock.ADAPTER.encodedSizeWithTag(100, r108);
        L14:
            int r110 = r107 + r109;
            TodoSourceHref r111 = r100.href;
            if (r111 == null) goto L17;
            int r112 = TodoSourceHref.ADAPTER.encodedSizeWithTag(101, r111);
        L18:
            int r113 = r110 + r112;
            TodoSourceChat r114 = r100.chat;
            if (r114 == null) goto L21;
            int r115 = TodoSourceChat.ADAPTER.encodedSizeWithTag(102, r114);
        L22:
            int r116 = r113 + r115;
            TodoSourceMeego r117 = r100.meego;
            if (r117 == null) goto L26;
            r102 = TodoSourceMeego.ADAPTER.encodedSizeWithTag(103, r117);
        L26:
            return (r116 + r102) + r100.unknownFields().size();
        L21:
            r115 = 0;
            goto L22
        L17:
            r112 = 0;
            goto L18
        L13:
            r109 = 0;
            goto L14
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TodoOrigin decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TodoOrigin r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TodoOrigin r101) throws IOException {
            Type r102 = r101.type;
            if (r102 == null) goto L5;
            Type.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            this.platform_i18n_name.encodeWithTag(r100, 3, r101.platform_i18n_name);
            String r103 = r101.display_i18n_name;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 150, r103);
        L8:
            TodoSourceBlock r104 = r101.block;
            if (r104 == null) goto L11;
            TodoSourceBlock.ADAPTER.encodeWithTag(r100, 100, r104);
        L11:
            TodoSourceHref r105 = r101.href;
            if (r105 == null) goto L14;
            TodoSourceHref.ADAPTER.encodeWithTag(r100, 101, r105);
        L14:
            TodoSourceChat r106 = r101.chat;
            if (r106 == null) goto L17;
            TodoSourceChat.ADAPTER.encodeWithTag(r100, 102, r106);
        L17:
            TodoSourceMeego r107 = r101.meego;
            if (r107 == null) goto L20;
            TodoSourceMeego.ADAPTER.encodeWithTag(r100, 103, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TodoOrigin r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type BLOCK = null;
        public static final Type CHAT = null;
        public static final Type HREF = null;
        public static final Type MEEGO = null;
        public static final Type UNKNOWN = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("BLOCK", 1, 1);
            BLOCK = r101;
            Type r102 = new Type("HREF", 2, 2);
            HREF = r102;
            Type r103 = new Type("CHAT", 3, 3);
            CHAT = r103;
            Type r104 = new Type("MEEGO", 4, 4);
            MEEGO = r104;
            $VALUES = new Type[]{r100, r101, r102, r103, r104};
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
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return MEEGO;
        L16:
            return CHAT;
        L18:
            return HREF;
        L20:
            return BLOCK;
        L22:
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
        ADAPTER = new ProtoAdapter_TodoOrigin();
        DEFAULT_TYPE = Type.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.platform_i18n_name = Internal.copyOf("platform_i18n_name", this.platform_i18n_name);
        r100.display_i18n_name = this.display_i18n_name;
        r100.block = this.block;
        r100.href = this.href;
        r100.chat = this.chat;
        r100.meego = this.meego;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TodoOrigin.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TodoOrigin(Type r110, Map<String, String> r111, String r112, TodoSourceBlock r113, TodoSourceHref r114, TodoSourceChat r115, TodoSourceMeego r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public TodoOrigin(Type r100, Map<String, String> r101, String r102, TodoSourceBlock r103, TodoSourceHref r104, TodoSourceChat r105, TodoSourceMeego r106, ByteString r107) {
        super(ADAPTER, r107);
        if (Internal.countNonNull(r103, r104, r105, r106, new Object[0]) > 1) goto L7;
        this.type = r100;
        this.platform_i18n_name = Internal.immutableCopyOf("platform_i18n_name", r101);
        this.display_i18n_name = r102;
        this.block = r103;
        this.href = r104;
        this.chat = r105;
        this.meego = r106;
        return;
    L7:
        throw new IllegalArgumentException("at most one of block, href, chat, meego may be non-null");
    }
}
