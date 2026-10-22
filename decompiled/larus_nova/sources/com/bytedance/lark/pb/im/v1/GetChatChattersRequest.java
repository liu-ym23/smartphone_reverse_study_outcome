package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetChatChattersRequest extends Message<GetChatChattersRequest, Builder> {
    public static final ProtoAdapter<GetChatChattersRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Condition DEFAULT_CONDITION = null;
    public static final String DEFAULT_CURSOR = "";
    public static final String DEFAULT_FILTER = "";
    public static final FromScene DEFAULT_FROM_SCENE = null;
    public static final Boolean DEFAULT_IS_FROM_SERVER = null;
    public static final Boolean DEFAULT_IS_FULL_DATA = null;
    public static final Integer DEFAULT_LIMIT = null;
    public static final Integer DEFAULT_OFFSET = null;
    public static final Scene DEFAULT_SCENE = null;
    public static final ProtoAdapter_GetChatChattersRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final Condition condition;
    public final String cursor;
    public final String filter;
    public final FromScene from_scene;
    public final Boolean is_from_server;
    public final Boolean is_full_data;
    public final Integer limit;
    public final Integer offset;
    public final Scene scene;

    public static final class Builder extends Message.Builder<GetChatChattersRequest, Builder> implements d<GetChatChattersRequest> {
        public String chat_id;
        public Condition condition;
        public String cursor;
        public String filter;
        public FromScene from_scene;
        public Boolean is_from_server;
        public Boolean is_full_data;
        public Integer limit;
        public Integer offset;
        public Scene scene;

        @Override // com.squareup.wire.Message.Builder
        public GetChatChattersRequest build() {
            String r100 = this.chat_id;
            if (r100 == null) goto L7;
            return new GetChatChattersRequest(this.chat_id, this.is_from_server, this.scene, this.filter, this.cursor, this.limit, this.is_full_data, this.condition, this.offset, this.from_scene, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "chat_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder condition(Condition r100) {
            this.condition = r100;
            return this;
        }

        public Builder cursor(String r100) {
            this.cursor = r100;
            return this;
        }

        public Builder filter(String r100) {
            this.filter = r100;
            return this;
        }

        public Builder from_scene(FromScene r100) {
            this.from_scene = r100;
            return this;
        }

        public Builder is_from_server(Boolean r100) {
            this.is_from_server = r100;
            return this;
        }

        public Builder is_full_data(Boolean r100) {
            this.is_full_data = r100;
            return this;
        }

        public Builder limit(Integer r100) {
            this.limit = r100;
            return this;
        }

        public Builder offset(Integer r100) {
            this.offset = r100;
            return this;
        }

        public Builder scene(Scene r100) {
            this.scene = r100;
            return this;
        }
    }

    public static final enum Condition extends Enum<Condition> implements WireEnum {
        private static final /* synthetic */ Condition[] $VALUES = null;
        public static final ProtoAdapter<Condition> ADAPTER = null;
        public static final Condition NoLimit = null;
        public static final Condition NonDepartment = null;
        public static final Condition Unknown = null;
        private final int value;

        static {
            Condition r100 = new Condition("Unknown", 0, 0);
            Unknown = r100;
            Condition r101 = new Condition("NoLimit", 1, 1);
            NoLimit = r101;
            Condition r102 = new Condition("NonDepartment", 2, 2);
            NonDepartment = r102;
            $VALUES = new Condition[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Condition.class);
        }

        public static Condition[] values() {
            return (Condition[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Condition fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return NonDepartment;
        L12:
            return NoLimit;
        L14:
            return Unknown;
        }

        public static Condition valueOf(String r100) {
            return (Condition) a.a(Condition.class, r100);
        }

        private Condition(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum FromScene extends Enum<FromScene> implements WireEnum {
        private static final /* synthetic */ FromScene[] $VALUES = null;
        public static final ProtoAdapter<FromScene> ADAPTER = null;
        public static final FromScene FirstGetChatChatterList = null;
        public static final FromScene GetChatChatterList = null;
        public static final FromScene UnknownScene = null;
        private final int value;

        static {
            FromScene r100 = new FromScene("UnknownScene", 0, 1);
            UnknownScene = r100;
            FromScene r101 = new FromScene("FirstGetChatChatterList", 1, 2);
            FirstGetChatChatterList = r101;
            FromScene r102 = new FromScene("GetChatChatterList", 2, 3);
            GetChatChatterList = r102;
            $VALUES = new FromScene[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(FromScene.class);
        }

        public static FromScene[] values() {
            return (FromScene[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static FromScene fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return GetChatChatterList;
        L13:
            return FirstGetChatChatterList;
        L15:
            return UnknownScene;
        }

        public static FromScene valueOf(String r100) {
            return (FromScene) a.a(FromScene.class, r100);
        }

        private FromScene(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_GetChatChattersRequest extends ProtoAdapter<GetChatChattersRequest> implements c<GetChatChattersRequest> {
        public ProtoAdapter_GetChatChattersRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetChatChattersRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetChatChattersRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            r101.is_from_server = Boolean.TRUE;
            r101.scene = Scene.CHAT_MEMBER;
            r101.filter = "";
            r101.cursor = "";
            r101.limit = 0;
            r101.is_full_data = Boolean.FALSE;
            r101.condition = Condition.NoLimit;
            r101.offset = 0;
            r101.from_scene = FromScene.UnknownScene;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L26;
            switch(r103) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L28;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L32;
                case 9: goto L11;
                case 10: goto L30;
                default: goto L6;
            };
        L28:
            r101.scene = Scene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L30:
            r101.from_scene = FromScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L32:
            r101.condition = Condition.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.offset = ProtoAdapter.INT32.decode(r100);
            goto L3
        L16:
            r101.is_full_data = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L17:
            r101.limit = ProtoAdapter.INT32.decode(r100);
            goto L3
        L18:
            r101.cursor = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.filter = ProtoAdapter.STRING.decode(r100);
            goto L3
        L24:
            r101.is_from_server = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L25:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L26:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetChatChattersRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.chat_id);
            Boolean r103 = r100.is_from_server;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Scene r107 = r100.scene;
            if (r107 == null) goto L9;
            int r108 = Scene.ADAPTER.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.filter;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            String r113 = r100.cursor;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            Integer r116 = r100.limit;
            if (r116 == null) goto L21;
            int r117 = ProtoAdapter.INT32.encodedSizeWithTag(6, r116);
        L22:
            int r118 = r115 + r117;
            Boolean r119 = r100.is_full_data;
            if (r119 == null) goto L25;
            int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
        L26:
            int r121 = r118 + r120;
            Condition r122 = r100.condition;
            if (r122 == null) goto L29;
            int r123 = Condition.ADAPTER.encodedSizeWithTag(8, r122);
        L30:
            int r124 = r121 + r123;
            Integer r125 = r100.offset;
            if (r125 == null) goto L33;
            int r126 = ProtoAdapter.INT32.encodedSizeWithTag(9, r125);
        L34:
            int r127 = r124 + r126;
            FromScene r128 = r100.from_scene;
            if (r128 == null) goto L38;
            r104 = FromScene.ADAPTER.encodedSizeWithTag(10, r128);
        L38:
            return (r127 + r104) + r100.unknownFields().size();
        L33:
            r126 = 0;
            goto L34
        L29:
            r123 = 0;
            goto L30
        L25:
            r120 = 0;
            goto L26
        L21:
            r117 = 0;
            goto L22
        L17:
            r114 = 0;
            goto L18
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetChatChattersRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetChatChattersRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetChatChattersRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.chat_id);
            Boolean r103 = r101.is_from_server;
            if (r103 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L5:
            Scene r104 = r101.scene;
            if (r104 == null) goto L8;
            Scene.ADAPTER.encodeWithTag(r100, 3, r104);
        L8:
            String r105 = r101.filter;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 4, r105);
        L11:
            String r106 = r101.cursor;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 5, r106);
        L14:
            Integer r107 = r101.limit;
            if (r107 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r107);
        L17:
            Boolean r108 = r101.is_full_data;
            if (r108 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
        L20:
            Condition r109 = r101.condition;
            if (r109 == null) goto L23;
            Condition.ADAPTER.encodeWithTag(r100, 8, r109);
        L23:
            Integer r110 = r101.offset;
            if (r110 == null) goto L26;
            ProtoAdapter.INT32.encodeWithTag(r100, 9, r110);
        L26:
            FromScene r111 = r101.from_scene;
            if (r111 == null) goto L29;
            FromScene.ADAPTER.encodeWithTag(r100, 10, r111);
        L29:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetChatChattersRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Scene extends Enum<Scene> implements WireEnum {
        private static final /* synthetic */ Scene[] $VALUES = null;
        public static final ProtoAdapter<Scene> ADAPTER = null;
        public static final Scene AT = null;
        public static final Scene CHAT_MEMBER = null;
        public static final Scene URGENT = null;
        private final int value;

        static {
            Scene r100 = new Scene("CHAT_MEMBER", 0, 1);
            CHAT_MEMBER = r100;
            Scene r101 = new Scene("URGENT", 1, 2);
            URGENT = r101;
            Scene r102 = new Scene("AT", 2, 3);
            AT = r102;
            $VALUES = new Scene[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Scene.class);
        }

        public static Scene[] values() {
            return (Scene[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Scene fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return AT;
        L13:
            return URGENT;
        L15:
            return CHAT_MEMBER;
        }

        public static Scene valueOf(String r100) {
            return (Scene) a.a(Scene.class, r100);
        }

        private Scene(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_GetChatChattersRequest r100 = new ProtoAdapter_GetChatChattersRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_IS_FROM_SERVER = Boolean.TRUE;
        DEFAULT_SCENE = Scene.CHAT_MEMBER;
        DEFAULT_LIMIT = 0;
        DEFAULT_IS_FULL_DATA = Boolean.FALSE;
        DEFAULT_CONDITION = Condition.NoLimit;
        DEFAULT_OFFSET = 0;
        DEFAULT_FROM_SCENE = FromScene.UnknownScene;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.is_from_server = this.is_from_server;
        r100.scene = this.scene;
        r100.filter = this.filter;
        r100.cursor = this.cursor;
        r100.limit = this.limit;
        r100.is_full_data = this.is_full_data;
        r100.condition = this.condition;
        r100.offset = this.offset;
        r100.from_scene = this.from_scene;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetChatChattersRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetChatChattersRequest(String r110, Boolean r111, Scene r112, String r113, String r114, Integer r115, Boolean r116, Condition r210, Integer r211, FromScene r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public GetChatChattersRequest(String r100, Boolean r101, Scene r102, String r103, String r104, Integer r105, Boolean r106, Condition r107, Integer r110, FromScene r111, ByteString r112) {
        super(ADAPTER, r112);
        this.chat_id = r100;
        this.is_from_server = r101;
        this.scene = r102;
        this.filter = r103;
        this.cursor = r104;
        this.limit = r105;
        this.is_full_data = r106;
        this.condition = r107;
        this.offset = r110;
        this.from_scene = r111;
    }
}
