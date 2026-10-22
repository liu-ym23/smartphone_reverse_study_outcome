package com.bytedance.lark.pb.basic.v1;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class Channel extends com.squareup.wire.Message<Channel, Builder> {
    public static final ProtoAdapter<Channel> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253443id;
    public final Type type;

    public static final class Builder extends com.squareup.wire.Message.Builder<Channel, Builder> {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253444id;
        public Type type;

        @Override // com.squareup.wire.Message.Builder
        public Channel build() {
            String r100 = this.f253444id;
            if (r100 == null) goto L7;
            return new Channel(this.f253444id, this.type, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder id(String r100) {
            this.f253444id = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Channel extends ProtoAdapter<Channel> {
        public ProtoAdapter_Channel() {
            super(FieldEncoding.LENGTH_DELIMITED, Channel.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Channel decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253444id = "";
            r101.type = Type.CHAT;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.f253444id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Channel r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.f253443id);
            Type r102 = r100.type;
            if (r102 == null) goto L5;
            int r103 = Type.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Channel decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Channel r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Channel r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.f253443id);
            Type r102 = r101.type;
            if (r102 == null) goto L5;
            Type.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Channel r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type APP_FEED = null;
        public static final Type CHAT = null;
        public static final Type DOC = null;
        public static final Type EMAIL = null;
        public static final Type KNOWLEDGE_AI = null;
        public static final Type OPENAPP = null;
        public static final Type SUBSCRIPTION = null;
        public static final Type UNKNOWN = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("CHAT", 1, 1);
            CHAT = r101;
            Type r102 = new Type(CommonConstant.RETKEY.EMAIL, 2, 2);
            EMAIL = r102;
            Type r103 = new Type(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 3, 3);
            DOC = r103;
            Type r104 = new Type("OPENAPP", 4, 4);
            OPENAPP = r104;
            Type r105 = new Type("SUBSCRIPTION", 5, 10);
            SUBSCRIPTION = r105;
            Type r110 = new Type("APP_FEED", 6, 13);
            APP_FEED = r110;
            Type r111 = new Type("KNOWLEDGE_AI", 7, 14);
            KNOWLEDGE_AI = r111;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111};
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
            if (r100 == 0) goto L34;
            if (r100 == 1) goto L32;
            if (r100 == 2) goto L30;
            if (r100 == 3) goto L28;
            if (r100 == 4) goto L26;
            if (r100 == 10) goto L24;
            if (r100 == 13) goto L22;
            if (r100 == 14) goto L20;
            return null;
        L20:
            return KNOWLEDGE_AI;
        L22:
            return APP_FEED;
        L24:
            return SUBSCRIPTION;
        L26:
            return OPENAPP;
        L28:
            return DOC;
        L30:
            return EMAIL;
        L32:
            return CHAT;
        L34:
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
        ADAPTER = new ProtoAdapter_Channel();
        DEFAULT_TYPE = Type.CHAT;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253444id = this.f253443id;
        r100.type = this.type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Channel.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Channel(String r100, Type r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public Channel(String r100, Type r101, ByteString r102) {
        super(ADAPTER, r102);
        this.f253443id = r100;
        this.type = r101;
    }
}
