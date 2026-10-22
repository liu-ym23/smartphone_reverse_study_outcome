package com.bytedance.lark.pb.settings.v1;

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
public final class TimeFormatSetting extends Message<TimeFormatSetting, Builder> {
    public static final ProtoAdapter<TimeFormatSetting> ADAPTER = null;
    public static final TimeFormat DEFAULT_TIME_FORMAT = null;
    private static final long serialVersionUID = 0;
    public final TimeFormat time_format;

    public static final class Builder extends Message.Builder<TimeFormatSetting, Builder> {
        public TimeFormat time_format;

        @Override // com.squareup.wire.Message.Builder
        public TimeFormatSetting build() {
            return new TimeFormatSetting(this.time_format, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder time_format(TimeFormat r100) {
            this.time_format = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TimeFormatSetting extends ProtoAdapter<TimeFormatSetting> {
        public ProtoAdapter_TimeFormatSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, TimeFormatSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TimeFormatSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.time_format = TimeFormat.TWELVE_HOUR;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.time_format = TimeFormat.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TimeFormatSetting r100) {
            TimeFormat r101 = r100.time_format;
            if (r101 == null) goto L5;
            int r102 = TimeFormat.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TimeFormatSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TimeFormatSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TimeFormatSetting r101) throws IOException {
            TimeFormat r102 = r101.time_format;
            if (r102 == null) goto L5;
            TimeFormat.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TimeFormatSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum TimeFormat extends Enum<TimeFormat> implements WireEnum {
        private static final /* synthetic */ TimeFormat[] $VALUES = null;
        public static final ProtoAdapter<TimeFormat> ADAPTER = null;
        public static final TimeFormat TWELVE_HOUR = null;
        public static final TimeFormat TWENTY_FOUR_HOUR = null;
        public static final TimeFormat UNKNOWN = null;
        private final int value;

        static {
            TimeFormat r100 = new TimeFormat("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            TimeFormat r101 = new TimeFormat("TWELVE_HOUR", 1, 1);
            TWELVE_HOUR = r101;
            TimeFormat r102 = new TimeFormat("TWENTY_FOUR_HOUR", 2, 2);
            TWENTY_FOUR_HOUR = r102;
            $VALUES = new TimeFormat[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(TimeFormat.class);
        }

        public static TimeFormat[] values() {
            return (TimeFormat[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static TimeFormat fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return TWENTY_FOUR_HOUR;
        L12:
            return TWELVE_HOUR;
        L14:
            return UNKNOWN;
        }

        public static TimeFormat valueOf(String r100) {
            return (TimeFormat) a.a(TimeFormat.class, r100);
        }

        private TimeFormat(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TimeFormatSetting();
        DEFAULT_TIME_FORMAT = TimeFormat.TWELVE_HOUR;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.time_format = this.time_format;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TimeFormatSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TimeFormatSetting(TimeFormat r100) {
        this(r100, ByteString.EMPTY);
    }

    public TimeFormatSetting(TimeFormat r100, ByteString r101) {
        super(ADAPTER, r101);
        this.time_format = r100;
    }
}
