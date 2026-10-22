package com.bytedance.lark.pb.settings.v1;

import com.huawei.hms.support.api.entity.common.CommonConstant;
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
public final class WayToAddMeSettingItem extends Message<WayToAddMeSettingItem, Builder> {
    public static final ProtoAdapter<WayToAddMeSettingItem> ADAPTER = null;
    public static final Boolean DEFAULT_ENABLE = null;
    public static final Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final Boolean enable;
    public final Type type;

    public static final class Builder extends Message.Builder<WayToAddMeSettingItem, Builder> {
        public Boolean enable;
        public Type type;

        @Override // com.squareup.wire.Message.Builder
        public WayToAddMeSettingItem build() {
            return new WayToAddMeSettingItem(this.type, this.enable, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder enable(Boolean r100) {
            this.enable = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_WayToAddMeSettingItem extends ProtoAdapter<WayToAddMeSettingItem> {
        public ProtoAdapter_WayToAddMeSettingItem() {
            super(FieldEncoding.LENGTH_DELIMITED, WayToAddMeSettingItem.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public WayToAddMeSettingItem decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = Type.UNKNOWN;
            r101.enable = Boolean.TRUE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.enable = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(WayToAddMeSettingItem r100) {
            Type r101 = r100.type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Type.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.enable;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ WayToAddMeSettingItem decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(WayToAddMeSettingItem r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, WayToAddMeSettingItem r101) throws IOException {
            Type r102 = r101.type;
            if (r102 == null) goto L5;
            Type.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.enable;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WayToAddMeSettingItem r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type CALENDAR = null;
        public static final Type CHAT = null;
        public static final Type CONTACT_TOKEN = null;
        public static final Type DOCS = null;
        public static final Type EMAIL = null;
        public static final Type MINUTES = null;
        public static final Type NAME_CARD = null;
        public static final Type PROFILE = null;
        public static final Type UNKNOWN = null;
        public static final Type VIDEO_CONFERENCE = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("CHAT", 1, 1);
            CHAT = r101;
            Type r102 = new Type("CONTACT_TOKEN", 2, 2);
            CONTACT_TOKEN = r102;
            Type r103 = new Type("PROFILE", 3, 3);
            PROFILE = r103;
            Type r104 = new Type("DOCS", 4, 4);
            DOCS = r104;
            Type r105 = new Type("CALENDAR", 5, 5);
            CALENDAR = r105;
            Type r110 = new Type("VIDEO_CONFERENCE", 6, 6);
            VIDEO_CONFERENCE = r110;
            Type r111 = new Type(CommonConstant.RETKEY.EMAIL, 7, 7);
            EMAIL = r111;
            Type r112 = new Type("NAME_CARD", 8, 8);
            NAME_CARD = r112;
            Type r113 = new Type("MINUTES", 9, 9);
            MINUTES = r113;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
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
                case 0: goto L24;
                case 1: goto L22;
                case 2: goto L20;
                case 3: goto L18;
                case 4: goto L16;
                case 5: goto L14;
                case 6: goto L12;
                case 7: goto L10;
                case 8: goto L8;
                case 9: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return MINUTES;
        L8:
            return NAME_CARD;
        L10:
            return EMAIL;
        L12:
            return VIDEO_CONFERENCE;
        L14:
            return CALENDAR;
        L16:
            return DOCS;
        L18:
            return PROFILE;
        L20:
            return CONTACT_TOKEN;
        L22:
            return CHAT;
        L24:
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
        ADAPTER = new ProtoAdapter_WayToAddMeSettingItem();
        DEFAULT_TYPE = Type.UNKNOWN;
        DEFAULT_ENABLE = Boolean.TRUE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.enable = this.enable;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return WayToAddMeSettingItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public WayToAddMeSettingItem(Type r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public WayToAddMeSettingItem(Type r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.type = r100;
        this.enable = r101;
    }
}
