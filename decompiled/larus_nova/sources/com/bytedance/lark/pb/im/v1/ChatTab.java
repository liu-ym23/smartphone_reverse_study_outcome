package com.bytedance.lark.pb.im.v1;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larus.network.http.ServiceType;
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
public final class ChatTab extends Message<ChatTab, Builder> {
    public static final ProtoAdapter<ChatTab> ADAPTER = null;
    public static final Long DEFAULT_ID = null;
    public static final String DEFAULT_NAME = "";
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final String DEFAULT_PAYLOAD_JSON = "";
    public static final Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final Long f253635id;
    public final String name;
    public final ByteString payload;
    public final String payload_json;
    public final Type type;

    public static final class Builder extends Message.Builder<ChatTab, Builder> {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public Long f253636id;
        public String name;
        public ByteString payload;
        public String payload_json;
        public Type type;

        @Override // com.squareup.wire.Message.Builder
        public ChatTab build() {
            return new ChatTab(this.f253636id, this.name, this.type, this.payload, this.payload_json, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder id(Long r100) {
            this.f253636id = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder payload(ByteString r100) {
            this.payload = r100;
            return this;
        }

        public Builder payload_json(String r100) {
            this.payload_json = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatTab extends ProtoAdapter<ChatTab> {
        public ProtoAdapter_ChatTab() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatTab.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatTab decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253636id = 0L;
            r101.name = "";
            r101.type = Type.Unknown;
            r101.payload = ByteString.EMPTY;
            r101.payload_json = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.f253636id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.payload = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.payload_json = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(ChatTab r100) {
            Long r101 = r100.f253635id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.name;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Type r107 = r100.type;
            if (r107 == null) goto L13;
            int r108 = Type.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            ByteString r110 = r100.payload;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BYTES.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.payload_json;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ ChatTab decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatTab r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatTab r101) throws IOException {
            Long r102 = r101.f253635id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.name;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Type r104 = r101.type;
            if (r104 == null) goto L11;
            Type.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            ByteString r105 = r101.payload;
            if (r105 == null) goto L14;
            ProtoAdapter.BYTES.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.payload_json;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatTab r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type ChatAnnouncement = null;
        public static final Type DOC_FILE_URL_MERGE = null;
        public static final Type Doc = null;
        public static final Type DocSpace = null;
        public static final Type FILE = null;
        public static final Type IMAGE_VIDEO_MERGE = null;
        public static final Type MeetingMinute = null;
        public static final Type Message = null;
        public static final Type Pin = null;
        public static final Type TASK = null;
        public static final Type Unknown = null;
        public static final Type Url = null;
        private final int value;

        static {
            Type r100 = new Type("Unknown", 0, 0);
            Unknown = r100;
            Type r101 = new Type(ServiceType.IM, 1, 1);
            Message = r101;
            Type r102 = new Type("DocSpace", 2, 2);
            DocSpace = r102;
            Type r103 = new Type(ServiceType.DOC, 3, 3);
            Doc = r103;
            Type r104 = new Type(WikiFolderPushPlugin.PIN, 4, 4);
            Pin = r104;
            Type r105 = new Type("MeetingMinute", 5, 5);
            MeetingMinute = r105;
            Type r110 = new Type("ChatAnnouncement", 6, 6);
            ChatAnnouncement = r110;
            Type r111 = new Type("Url", 7, 7);
            Url = r111;
            Type r112 = new Type("FILE", 8, 8);
            FILE = r112;
            Type r113 = new Type("TASK", 9, 9);
            TASK = r113;
            Type r114 = new Type("DOC_FILE_URL_MERGE", 10, 10);
            DOC_FILE_URL_MERGE = r114;
            Type r115 = new Type("IMAGE_VIDEO_MERGE", 11, 11);
            IMAGE_VIDEO_MERGE = r115;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
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
            switch(r100) {
                case 0: goto L28;
                case 1: goto L26;
                case 2: goto L24;
                case 3: goto L22;
                case 4: goto L20;
                case 5: goto L18;
                case 6: goto L16;
                case 7: goto L14;
                case 8: goto L12;
                case 9: goto L10;
                case 10: goto L8;
                case 11: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return IMAGE_VIDEO_MERGE;
        L8:
            return DOC_FILE_URL_MERGE;
        L10:
            return TASK;
        L12:
            return FILE;
        L14:
            return Url;
        L16:
            return ChatAnnouncement;
        L18:
            return MeetingMinute;
        L20:
            return Pin;
        L22:
            return Doc;
        L24:
            return DocSpace;
        L26:
            return Message;
        L28:
            return Unknown;
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
        ADAPTER = new ProtoAdapter_ChatTab();
        DEFAULT_ID = 0L;
        DEFAULT_TYPE = Type.Unknown;
        DEFAULT_PAYLOAD = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253636id = this.f253635id;
        r100.name = this.name;
        r100.type = this.type;
        r100.payload = this.payload;
        r100.payload_json = this.payload_json;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatTab.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatTab(Long r100, String r101, Type r110, ByteString r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public ChatTab(Long r100, String r101, Type r102, ByteString r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.f253635id = r100;
        this.name = r101;
        this.type = r102;
        this.payload = r103;
        this.payload_json = r104;
    }
}
