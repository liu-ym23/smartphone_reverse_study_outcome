package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class DatetimeFieldSettings extends Message<DatetimeFieldSettings, Builder> {
    public static final ProtoAdapter<DatetimeFieldSettings> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DateFormat mformat;

    public static final class Builder extends Message.Builder<DatetimeFieldSettings, Builder> {
        public DateFormat mformat;

        @Override // com.squareup.wire.Message.Builder
        public DatetimeFieldSettings build() {
            return new DatetimeFieldSettings(this.mformat, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder format(DateFormat r100) {
            this.mformat = r100;
            return this;
        }
    }

    public static final enum DateFormat extends Enum<DateFormat> implements WireEnum {
        private static final /* synthetic */ DateFormat[] $VALUES = null;
        public static final ProtoAdapter<DateFormat> ADAPTER = null;
        public static final DateFormat DD_MM_YYYY_SLASH = null;
        public static final DateFormat DEFAULT = null;
        public static final DateFormat MM_DD_YYYY_SLASH = null;
        public static final DateFormat YYYY_MM_DD_DASH = null;
        public static final DateFormat YYYY_MM_DD_SLASH = null;
        private final int value;

        static {
            DateFormat r100 = new DateFormat("DEFAULT", 0, 0);
            DEFAULT = r100;
            DateFormat r101 = new DateFormat("YYYY_MM_DD_DASH", 1, 1);
            YYYY_MM_DD_DASH = r101;
            DateFormat r102 = new DateFormat("YYYY_MM_DD_SLASH", 2, 2);
            YYYY_MM_DD_SLASH = r102;
            DateFormat r103 = new DateFormat("MM_DD_YYYY_SLASH", 3, 3);
            MM_DD_YYYY_SLASH = r103;
            DateFormat r104 = new DateFormat("DD_MM_YYYY_SLASH", 4, 4);
            DD_MM_YYYY_SLASH = r104;
            $VALUES = new DateFormat[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(DateFormat.class);
        }

        public static DateFormat[] values() {
            return (DateFormat[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static DateFormat fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return DD_MM_YYYY_SLASH;
        L16:
            return MM_DD_YYYY_SLASH;
        L18:
            return YYYY_MM_DD_SLASH;
        L20:
            return YYYY_MM_DD_DASH;
        L22:
            return DEFAULT;
        }

        public static DateFormat valueOf(String r100) {
            return (DateFormat) a.a(DateFormat.class, r100);
        }

        private DateFormat(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_DatetimeFieldSettings extends ProtoAdapter<DatetimeFieldSettings> {
        public ProtoAdapter_DatetimeFieldSettings() {
            super(FieldEncoding.LENGTH_DELIMITED, DatetimeFieldSettings.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DatetimeFieldSettings decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.mformat = DateFormat.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
        public int encodedSize2(DatetimeFieldSettings r100) {
            DateFormat r101 = r100.mformat;
            if (r101 == null) goto L5;
            int r102 = DateFormat.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DatetimeFieldSettings decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DatetimeFieldSettings r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DatetimeFieldSettings r101) throws IOException {
            DateFormat r102 = r101.mformat;
            if (r102 == null) goto L5;
            DateFormat.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DatetimeFieldSettings r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DatetimeFieldSettings();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mformat = this.mformat;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DatetimeFieldSettings.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DatetimeFieldSettings(DateFormat r100) {
        this(r100, ByteString.EMPTY);
    }

    public DatetimeFieldSettings(DateFormat r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mformat = r100;
    }
}
