package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class VideoChatI18nDefaultTopic extends com.squareup.wire.Message<VideoChatI18nDefaultTopic, Builder> {
    public static final ProtoAdapter<VideoChatI18nDefaultTopic> ADAPTER = null;
    public static final String DEFAULT_I18N_KEY = "";
    private static final long serialVersionUID = 0;
    public final String i18n_key;
    public final List<Param> params;

    public static final class Builder extends com.squareup.wire.Message.Builder<VideoChatI18nDefaultTopic, Builder> {
        public String i18n_key;
        public List<Param> params;

        @Override // com.squareup.wire.Message.Builder
        public VideoChatI18nDefaultTopic build() {
            String r100 = this.i18n_key;
            if (r100 == null) goto L7;
            return new VideoChatI18nDefaultTopic(this.i18n_key, this.params, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "i18n_key"});
        }

        public Builder() {
            this.params = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder i18n_key(String r100) {
            this.i18n_key = r100;
            return this;
        }

        public Builder params(List<Param> r100) {
            Internal.checkElementsNotNull(r100);
            this.params = r100;
            return this;
        }
    }

    public static final class Param extends com.squareup.wire.Message<Param, Builder> {
        public static final ProtoAdapter<Param> ADAPTER = null;
        public static final String DEFAULT_CHAT_ID = "";
        public static final String DEFAULT_DEFAULT_CONTENT = "";
        public static final String DEFAULT_FIXED_CONTENT = "";
        public static final Type DEFAULT_TYPE = null;
        public static final String DEFAULT_USER_ID = "";
        private static final long serialVersionUID = 0;
        public final String chat_id;
        public final String default_content;
        public final String fixed_content;
        public final Type type;
        public final String user_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<Param, Builder> {
            public String chat_id;
            public String default_content;
            public String fixed_content;
            public Type type;
            public String user_id;

            @Override // com.squareup.wire.Message.Builder
            public Param build() {
                Type r100 = this.type;
                if (r100 == null) goto L7;
                return new Param(this.type, this.default_content, this.fixed_content, this.chat_id, this.user_id, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "type"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder chat_id(String r100) {
                this.chat_id = r100;
                this.fixed_content = null;
                this.user_id = null;
                return this;
            }

            public Builder default_content(String r100) {
                this.default_content = r100;
                return this;
            }

            public Builder fixed_content(String r100) {
                this.fixed_content = r100;
                this.chat_id = null;
                this.user_id = null;
                return this;
            }

            public Builder type(Type r100) {
                this.type = r100;
                return this;
            }

            public Builder user_id(String r100) {
                this.user_id = r100;
                this.fixed_content = null;
                this.chat_id = null;
                return this;
            }
        }

        public static final class ProtoAdapter_Param extends ProtoAdapter<Param> {
            public ProtoAdapter_Param() {
                super(FieldEncoding.LENGTH_DELIMITED, Param.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Param decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = Type.UNKNOWN;
                r101.default_content = "";
                r101.fixed_content("");
                r101.chat_id("");
                r101.user_id("");
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L24;
                if (r103 != 1) goto L8;
                r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.default_content = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.fixed_content(ProtoAdapter.STRING.decode(r100));
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.chat_id(ProtoAdapter.STRING.decode(r100));
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.user_id(ProtoAdapter.STRING.decode(r100));
                goto L3
            L15:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L24:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Param r100) {
                int r101 = Type.ADAPTER.encodedSizeWithTag(1, r100.type);
                String r102 = r100.default_content;
                int r103 = 0;
                if (r102 == null) goto L5;
                int r104 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
            L6:
                int r105 = r101 + r104;
                String r106 = r100.fixed_content;
                if (r106 == null) goto L9;
                int r107 = ProtoAdapter.STRING.encodedSizeWithTag(3, r106);
            L10:
                int r108 = r105 + r107;
                String r109 = r100.chat_id;
                if (r109 == null) goto L13;
                int r110 = ProtoAdapter.STRING.encodedSizeWithTag(4, r109);
            L14:
                int r111 = r108 + r110;
                String r112 = r100.user_id;
                if (r112 == null) goto L18;
                r103 = ProtoAdapter.STRING.encodedSizeWithTag(5, r112);
            L18:
                return (r111 + r103) + r100.unknownFields().size();
            L13:
                r110 = 0;
                goto L14
            L9:
                r107 = 0;
                goto L10
            L5:
                r104 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Param decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Param r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Param r101) throws IOException {
                Type.ADAPTER.encodeWithTag(r100, 1, r101.type);
                String r102 = r101.default_content;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
            L5:
                String r103 = r101.fixed_content;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
            L8:
                String r104 = r101.chat_id;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
            L11:
                String r105 = r101.user_id;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Param r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum Type extends Enum<Type> implements WireEnum {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type FIXED_CONTENT = null;
            public static final Type GROUP = null;
            public static final Type LARK_USER = null;
            public static final Type ROOM = null;
            public static final Type UNKNOWN = null;
            private final int value;

            static {
                Type r100 = new Type("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Type r101 = new Type("FIXED_CONTENT", 1, 1);
                FIXED_CONTENT = r101;
                Type r102 = new Type("GROUP", 2, 2);
                GROUP = r102;
                Type r103 = new Type("LARK_USER", 3, 3);
                LARK_USER = r103;
                Type r104 = new Type("ROOM", 4, 4);
                ROOM = r104;
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
                return ROOM;
            L16:
                return LARK_USER;
            L18:
                return GROUP;
            L20:
                return FIXED_CONTENT;
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
            ADAPTER = new ProtoAdapter_Param();
            DEFAULT_TYPE = Type.UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.default_content = this.default_content;
            r100.fixed_content = this.fixed_content;
            r100.chat_id = this.chat_id;
            r100.user_id = this.user_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Param.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Param(Type r100, String r101, String r110, String r111, String r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public Param(Type r100, String r101, String r102, String r103, String r104, ByteString r105) {
            super(ADAPTER, r105);
            if (Internal.countNonNull(r102, r103, r104) > 1) goto L7;
            this.type = r100;
            this.default_content = r101;
            this.fixed_content = r102;
            this.chat_id = r103;
            this.user_id = r104;
            return;
        L7:
            throw new IllegalArgumentException("at most one of fixed_content, chat_id, user_id may be non-null");
        }
    }

    public static final class ProtoAdapter_VideoChatI18nDefaultTopic extends ProtoAdapter<VideoChatI18nDefaultTopic> {
        public ProtoAdapter_VideoChatI18nDefaultTopic() {
            super(FieldEncoding.LENGTH_DELIMITED, VideoChatI18nDefaultTopic.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public VideoChatI18nDefaultTopic decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.i18n_key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.i18n_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.params.add(Param.ADAPTER.decode(r100));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(VideoChatI18nDefaultTopic r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.i18n_key) + Param.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.params)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ VideoChatI18nDefaultTopic decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(VideoChatI18nDefaultTopic r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, VideoChatI18nDefaultTopic r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.i18n_key);
            Param.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.params);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, VideoChatI18nDefaultTopic r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_VideoChatI18nDefaultTopic();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.i18n_key = this.i18n_key;
        r100.params = Internal.copyOf("params", this.params);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return VideoChatI18nDefaultTopic.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public VideoChatI18nDefaultTopic(String r100, List<Param> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public VideoChatI18nDefaultTopic(String r100, List<Param> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.i18n_key = r100;
        this.params = Internal.immutableCopyOf("params", r101);
    }
}
