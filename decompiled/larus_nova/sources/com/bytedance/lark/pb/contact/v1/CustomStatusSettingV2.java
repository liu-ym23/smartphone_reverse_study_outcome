package com.bytedance.lark.pb.contact.v1;

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
public final class CustomStatusSettingV2 extends Message<CustomStatusSettingV2, Builder> {
    public static final ProtoAdapter<CustomStatusSettingV2> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_EXPLAIN = "";
    public static final Long DEFAULT_ID = null;
    public static final Boolean DEFAULT_IS_OPEN = null;
    public static final SettingType DEFAULT_SETTING_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String content;
    public final String explain;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final Long f253607id;
    public final Boolean is_open;
    public final SettingType setting_type;

    public static final class Builder extends Message.Builder<CustomStatusSettingV2, Builder> {
        public String content;
        public String explain;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public Long f253608id;
        public Boolean is_open;
        public SettingType setting_type;

        @Override // com.squareup.wire.Message.Builder
        public CustomStatusSettingV2 build() {
            return new CustomStatusSettingV2(this.f253608id, this.setting_type, this.content, this.explain, this.is_open, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder content(String r100) {
            this.content = r100;
            return this;
        }

        public Builder explain(String r100) {
            this.explain = r100;
            return this;
        }

        public Builder id(Long r100) {
            this.f253608id = r100;
            return this;
        }

        public Builder is_open(Boolean r100) {
            this.is_open = r100;
            return this;
        }

        public Builder setting_type(SettingType r100) {
            this.setting_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomStatusSettingV2 extends ProtoAdapter<CustomStatusSettingV2> {
        public ProtoAdapter_CustomStatusSettingV2() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomStatusSettingV2.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CustomStatusSettingV2 decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253608id = 0L;
            r101.setting_type = SettingType.UNKNOWN;
            r101.content = "";
            r101.explain = "";
            r101.is_open = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.f253608id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.setting_type = SettingType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.content = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.explain = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.is_open = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(CustomStatusSettingV2 r100) {
            Long r101 = r100.f253607id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            SettingType r104 = r100.setting_type;
            if (r104 == null) goto L9;
            int r105 = SettingType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.content;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.explain;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.is_open;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
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
        public /* bridge */ /* synthetic */ CustomStatusSettingV2 decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CustomStatusSettingV2 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CustomStatusSettingV2 r101) throws IOException {
            Long r102 = r101.f253607id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            SettingType r103 = r101.setting_type;
            if (r103 == null) goto L8;
            SettingType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.content;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.explain;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.is_open;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomStatusSettingV2 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum SettingType extends Enum<SettingType> implements WireEnum {
        private static final /* synthetic */ SettingType[] $VALUES = null;
        public static final ProtoAdapter<SettingType> ADAPTER = null;
        public static final SettingType CALENDAR_MEETING = null;
        public static final SettingType COMMON = null;
        public static final SettingType UNKNOWN = null;
        private final int value;

        static {
            SettingType r100 = new SettingType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            SettingType r101 = new SettingType("COMMON", 1, 1);
            COMMON = r101;
            SettingType r102 = new SettingType("CALENDAR_MEETING", 2, 2);
            CALENDAR_MEETING = r102;
            $VALUES = new SettingType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(SettingType.class);
        }

        public static SettingType[] values() {
            return (SettingType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SettingType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return CALENDAR_MEETING;
        L12:
            return COMMON;
        L14:
            return UNKNOWN;
        }

        public static SettingType valueOf(String r100) {
            return (SettingType) a.a(SettingType.class, r100);
        }

        private SettingType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomStatusSettingV2();
        DEFAULT_ID = 0L;
        DEFAULT_SETTING_TYPE = SettingType.UNKNOWN;
        DEFAULT_IS_OPEN = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253608id = this.f253607id;
        r100.setting_type = this.setting_type;
        r100.content = this.content;
        r100.explain = this.explain;
        r100.is_open = this.is_open;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CustomStatusSettingV2.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CustomStatusSettingV2(Long r100, SettingType r101, String r110, String r111, Boolean r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public CustomStatusSettingV2(Long r100, SettingType r101, String r102, String r103, Boolean r104, ByteString r105) {
        super(ADAPTER, r105);
        this.f253607id = r100;
        this.setting_type = r101;
        this.content = r102;
        this.explain = r103;
        this.is_open = r104;
    }
}
