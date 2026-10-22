package com.bytedance.lark.pb.search.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class ChatFilterParam extends Message<ChatFilterParam, Builder> {
    public static final ProtoAdapter<ChatFilterParam> ADAPTER = null;
    public static final String DEFAULT_CHAT_MESSAGE_KEY = "";
    public static final SortType DEFAULT_SORT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final List<String> chat_member_ids;
    public final String chat_message_key;
    public final List<ChatMode> chat_modes;
    public final List<ChatType> chat_types;
    public final List<String> exclude_ids;
    public final SortType sort_type;

    public static final class Builder extends Message.Builder<ChatFilterParam, Builder> {
        public List<String> chat_member_ids;
        public String chat_message_key;
        public List<ChatMode> chat_modes;
        public List<ChatType> chat_types;
        public List<String> exclude_ids;
        public SortType sort_type;

        @Override // com.squareup.wire.Message.Builder
        public ChatFilterParam build() {
            return new ChatFilterParam(this.chat_types, this.chat_member_ids, this.chat_message_key, this.chat_modes, this.sort_type, this.exclude_ids, super.buildUnknownFields());
        }

        public Builder() {
            this.chat_types = Internal.newMutableList();
            this.chat_member_ids = Internal.newMutableList();
            this.chat_modes = Internal.newMutableList();
            this.exclude_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_member_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.chat_member_ids = r100;
            return this;
        }

        public Builder chat_message_key(String r100) {
            this.chat_message_key = r100;
            return this;
        }

        public Builder chat_modes(List<ChatMode> r100) {
            Internal.checkElementsNotNull(r100);
            this.chat_modes = r100;
            return this;
        }

        public Builder chat_types(List<ChatType> r100) {
            Internal.checkElementsNotNull(r100);
            this.chat_types = r100;
            return this;
        }

        public Builder exclude_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.exclude_ids = r100;
            return this;
        }

        public Builder sort_type(SortType r100) {
            this.sort_type = r100;
            return this;
        }
    }

    public static final enum ChatMode extends Enum<ChatMode> implements WireEnum {
        private static final /* synthetic */ ChatMode[] $VALUES = null;
        public static final ProtoAdapter<ChatMode> ADAPTER = null;
        public static final ChatMode NORMAL = null;
        public static final ChatMode THREAD = null;
        public static final ChatMode UNLIMITED = null;
        private final int value;

        static {
            ChatMode r100 = new ChatMode("UNLIMITED", 0, 0);
            UNLIMITED = r100;
            ChatMode r101 = new ChatMode(EffectConstants.NORMAL, 1, 1);
            NORMAL = r101;
            ChatMode r102 = new ChatMode("THREAD", 2, 2);
            THREAD = r102;
            $VALUES = new ChatMode[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(ChatMode.class);
        }

        public static ChatMode[] values() {
            return (ChatMode[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ChatMode fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return THREAD;
        L12:
            return NORMAL;
        L14:
            return UNLIMITED;
        }

        public static ChatMode valueOf(String r100) {
            return (ChatMode) a.a(ChatMode.class, r100);
        }

        private ChatMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ChatType extends Enum<ChatType> implements WireEnum {
        private static final /* synthetic */ ChatType[] $VALUES = null;
        public static final ProtoAdapter<ChatType> ADAPTER = null;
        public static final ChatType OUTER = null;
        public static final ChatType PRIVATE = null;
        public static final ChatType PUBLIC_ABSENT = null;
        public static final ChatType PUBLIC_JOIN = null;
        public static final ChatType UNKNOWNTAB = null;
        private final int value;

        static {
            ChatType r100 = new ChatType("UNKNOWNTAB", 0, 0);
            UNKNOWNTAB = r100;
            ChatType r101 = new ChatType("PRIVATE", 1, 1);
            PRIVATE = r101;
            ChatType r102 = new ChatType("OUTER", 2, 2);
            OUTER = r102;
            ChatType r103 = new ChatType("PUBLIC_JOIN", 3, 3);
            PUBLIC_JOIN = r103;
            ChatType r104 = new ChatType("PUBLIC_ABSENT", 4, 4);
            PUBLIC_ABSENT = r104;
            $VALUES = new ChatType[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(ChatType.class);
        }

        public static ChatType[] values() {
            return (ChatType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ChatType fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return PUBLIC_ABSENT;
        L16:
            return PUBLIC_JOIN;
        L18:
            return OUTER;
        L20:
            return PRIVATE;
        L22:
            return UNKNOWNTAB;
        }

        public static ChatType valueOf(String r100) {
            return (ChatType) a.a(ChatType.class, r100);
        }

        private ChatType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_ChatFilterParam extends ProtoAdapter<ChatFilterParam> {
        public ProtoAdapter_ChatFilterParam() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatFilterParam.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatFilterParam decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_message_key = "";
            r101.sort_type = SortType.DEFAULT;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L22;
            switch(r103) {
                case 1: goto L26;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L24;
                case 5: goto L28;
                case 6: goto L7;
                default: goto L6;
            };
        L24:
            r101.chat_modes.add(ChatMode.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L26:
            r101.chat_types.add(ChatType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L28:
            r101.sort_type = SortType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.exclude_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L16:
            r101.chat_message_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.chat_member_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L22:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ChatFilterParam r100) {
            int r101 = ChatType.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.chat_types);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            int r103 = r101 + r102.asRepeated().encodedSizeWithTag(2, r100.chat_member_ids);
            String r104 = r100.chat_message_key;
            int r105 = 0;
            if (r104 == null) goto L5;
            int r106 = r102.encodedSizeWithTag(3, r104);
        L6:
            int r107 = (r103 + r106) + ChatMode.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.chat_modes);
            SortType r108 = r100.sort_type;
            if (r108 == null) goto L10;
            r105 = SortType.ADAPTER.encodedSizeWithTag(5, r108);
        L10:
            return ((r107 + r105) + r102.asRepeated().encodedSizeWithTag(6, r100.exclude_ids)) + r100.unknownFields().size();
        L5:
            r106 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ChatFilterParam decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatFilterParam r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatFilterParam r101) throws IOException {
            ChatType.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.chat_types);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 2, r101.chat_member_ids);
            String r103 = r101.chat_message_key;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            ChatMode.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.chat_modes);
            SortType r104 = r101.sort_type;
            if (r104 == null) goto L8;
            SortType.ADAPTER.encodeWithTag(r100, 5, r104);
        L8:
            r102.asRepeated().encodeWithTag(r100, 6, r101.exclude_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatFilterParam r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatFilterParam();
        DEFAULT_SORT_TYPE = SortType.DEFAULT;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_types = Internal.copyOf("chat_types", this.chat_types);
        r100.chat_member_ids = Internal.copyOf("chat_member_ids", this.chat_member_ids);
        r100.chat_message_key = this.chat_message_key;
        r100.chat_modes = Internal.copyOf("chat_modes", this.chat_modes);
        r100.sort_type = this.sort_type;
        r100.exclude_ids = Internal.copyOf("exclude_ids", this.exclude_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatFilterParam.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatFilterParam(List<ChatType> r100, List<String> r110, String r111, List<ChatMode> r112, SortType r113, List<String> r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public ChatFilterParam(List<ChatType> r100, List<String> r101, String r102, List<ChatMode> r103, SortType r104, List<String> r105, ByteString r106) {
        super(ADAPTER, r106);
        this.chat_types = Internal.immutableCopyOf("chat_types", r100);
        this.chat_member_ids = Internal.immutableCopyOf("chat_member_ids", r101);
        this.chat_message_key = r102;
        this.chat_modes = Internal.immutableCopyOf("chat_modes", r103);
        this.sort_type = r104;
        this.exclude_ids = Internal.immutableCopyOf("exclude_ids", r105);
    }
}
