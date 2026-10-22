package com.bytedance.lark.pb.search.v2;

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
public final class ColdAndHotStorageInfo extends Message<ColdAndHotStorageInfo, Builder> {
    public static final ProtoAdapter<ColdAndHotStorageInfo> ADAPTER = null;
    public static final HasMoreInfo DEFAULT_HAS_MORE_INFO = null;
    public static final Boolean DEFAULT_IS_NEED_COLD_DATA = null;
    public static final Integer DEFAULT_TIME_SIZE = null;
    public static final String DEFAULT_TIME_TEXT = "";
    public static final TimeUnit DEFAULT_TIME_UNIT = null;
    private static final long serialVersionUID = 0;
    public final HasMoreInfo has_more_info;
    public final Boolean is_need_cold_data;
    public final Integer time_size;
    public final String time_text;
    public final TimeUnit time_unit;

    public static final class Builder extends Message.Builder<ColdAndHotStorageInfo, Builder> {
        public HasMoreInfo has_more_info;
        public Boolean is_need_cold_data;
        public Integer time_size;
        public String time_text;
        public TimeUnit time_unit;

        @Override // com.squareup.wire.Message.Builder
        public ColdAndHotStorageInfo build() {
            return new ColdAndHotStorageInfo(this.is_need_cold_data, this.time_size, this.time_unit, this.time_text, this.has_more_info, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder has_more_info(HasMoreInfo r100) {
            this.has_more_info = r100;
            return this;
        }

        public Builder is_need_cold_data(Boolean r100) {
            this.is_need_cold_data = r100;
            return this;
        }

        public Builder time_size(Integer r100) {
            this.time_size = r100;
            return this;
        }

        public Builder time_text(String r100) {
            this.time_text = r100;
            return this;
        }

        public Builder time_unit(TimeUnit r100) {
            this.time_unit = r100;
            return this;
        }
    }

    public static final enum HasMoreInfo extends Enum<HasMoreInfo> implements WireEnum {
        private static final /* synthetic */ HasMoreInfo[] $VALUES = null;
        public static final ProtoAdapter<HasMoreInfo> ADAPTER = null;
        public static final HasMoreInfo COLD_HAS_MORE = null;
        public static final HasMoreInfo COLD_HAS_NO_MORE = null;
        public static final HasMoreInfo HOT_HAS_MORE = null;
        public static final HasMoreInfo HOT_HAS_NO_MORE = null;
        public static final HasMoreInfo UNKNOWN = null;
        private final int value;

        static {
            HasMoreInfo r100 = new HasMoreInfo("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            HasMoreInfo r101 = new HasMoreInfo("HOT_HAS_MORE", 1, 1);
            HOT_HAS_MORE = r101;
            HasMoreInfo r102 = new HasMoreInfo("HOT_HAS_NO_MORE", 2, 2);
            HOT_HAS_NO_MORE = r102;
            HasMoreInfo r103 = new HasMoreInfo("COLD_HAS_MORE", 3, 3);
            COLD_HAS_MORE = r103;
            HasMoreInfo r104 = new HasMoreInfo("COLD_HAS_NO_MORE", 4, 4);
            COLD_HAS_NO_MORE = r104;
            $VALUES = new HasMoreInfo[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(HasMoreInfo.class);
        }

        public static HasMoreInfo[] values() {
            return (HasMoreInfo[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static HasMoreInfo fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return COLD_HAS_NO_MORE;
        L16:
            return COLD_HAS_MORE;
        L18:
            return HOT_HAS_NO_MORE;
        L20:
            return HOT_HAS_MORE;
        L22:
            return UNKNOWN;
        }

        public static HasMoreInfo valueOf(String r100) {
            return (HasMoreInfo) a.a(HasMoreInfo.class, r100);
        }

        private HasMoreInfo(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_ColdAndHotStorageInfo extends ProtoAdapter<ColdAndHotStorageInfo> {
        public ProtoAdapter_ColdAndHotStorageInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ColdAndHotStorageInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ColdAndHotStorageInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.is_need_cold_data = Boolean.FALSE;
            r101.time_size = 0;
            r101.time_unit = TimeUnit.YEAR;
            r101.time_text = "";
            r101.has_more_info = HasMoreInfo.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L27;
            if (r103 != 1) goto L8;
            r101.is_need_cold_data = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.time_size = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.time_unit = TimeUnit.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.time_text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.has_more_info = HasMoreInfo.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L27:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ColdAndHotStorageInfo r100) {
            Boolean r101 = r100.is_need_cold_data;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.time_size;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            TimeUnit r107 = r100.time_unit;
            if (r107 == null) goto L13;
            int r108 = TimeUnit.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.time_text;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            HasMoreInfo r113 = r100.has_more_info;
            if (r113 == null) goto L22;
            r102 = HasMoreInfo.ADAPTER.encodedSizeWithTag(5, r113);
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
        public /* bridge */ /* synthetic */ ColdAndHotStorageInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ColdAndHotStorageInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ColdAndHotStorageInfo r101) throws IOException {
            Boolean r102 = r101.is_need_cold_data;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.time_size;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            TimeUnit r104 = r101.time_unit;
            if (r104 == null) goto L11;
            TimeUnit.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.time_text;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            HasMoreInfo r106 = r101.has_more_info;
            if (r106 == null) goto L17;
            HasMoreInfo.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ColdAndHotStorageInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum TimeUnit extends Enum<TimeUnit> implements WireEnum {
        private static final /* synthetic */ TimeUnit[] $VALUES = null;
        public static final ProtoAdapter<TimeUnit> ADAPTER = null;
        public static final TimeUnit DAY = null;
        public static final TimeUnit MONTH = null;
        public static final TimeUnit WEEK = null;
        public static final TimeUnit YEAR = null;
        private final int value;

        static {
            TimeUnit r100 = new TimeUnit("DAY", 0, 1);
            DAY = r100;
            TimeUnit r101 = new TimeUnit("WEEK", 1, 2);
            WEEK = r101;
            TimeUnit r102 = new TimeUnit("MONTH", 2, 3);
            MONTH = r102;
            TimeUnit r103 = new TimeUnit("YEAR", 3, 4);
            YEAR = r103;
            $VALUES = new TimeUnit[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(TimeUnit.class);
        }

        public static TimeUnit[] values() {
            return (TimeUnit[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static TimeUnit fromValue(int r100) {
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L15;
            if (r100 == 4) goto L13;
            return null;
        L13:
            return YEAR;
        L15:
            return MONTH;
        L17:
            return WEEK;
        L19:
            return DAY;
        }

        public static TimeUnit valueOf(String r100) {
            return (TimeUnit) a.a(TimeUnit.class, r100);
        }

        private TimeUnit(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ColdAndHotStorageInfo();
        DEFAULT_IS_NEED_COLD_DATA = Boolean.FALSE;
        DEFAULT_TIME_SIZE = 0;
        DEFAULT_TIME_UNIT = TimeUnit.YEAR;
        DEFAULT_HAS_MORE_INFO = HasMoreInfo.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.is_need_cold_data = this.is_need_cold_data;
        r100.time_size = this.time_size;
        r100.time_unit = this.time_unit;
        r100.time_text = this.time_text;
        r100.has_more_info = this.has_more_info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ColdAndHotStorageInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ColdAndHotStorageInfo(Boolean r100, Integer r101, TimeUnit r110, String r111, HasMoreInfo r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public ColdAndHotStorageInfo(Boolean r100, Integer r101, TimeUnit r102, String r103, HasMoreInfo r104, ByteString r105) {
        super(ADAPTER, r105);
        this.is_need_cold_data = r100;
        this.time_size = r101;
        this.time_unit = r102;
        this.time_text = r103;
        this.has_more_info = r104;
    }
}
