package com.bytedance.lark.pb.settings.v1;

import com.bytedance.lark.pb.basic.v1.ExternalDisplayTimezoneSettingType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ExternalDisplayTimezoneSetting extends Message<ExternalDisplayTimezoneSetting, Builder> {
    public static final ProtoAdapter<ExternalDisplayTimezoneSetting> ADAPTER = null;
    public static final Boolean DEFAULT_FOLLOW_SYSTEM = null;
    public static final String DEFAULT_TIMEZONE = "";
    public static final Integer DEFAULT_TIMEZONE_OFFSET = null;
    public static final ExternalDisplayTimezoneSettingType DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final Boolean follow_system;
    public final String timezone;
    public final Integer timezone_offset;
    public final ExternalDisplayTimezoneSettingType type;

    public static final class Builder extends Message.Builder<ExternalDisplayTimezoneSetting, Builder> {
        public Boolean follow_system;
        public String timezone;
        public Integer timezone_offset;
        public ExternalDisplayTimezoneSettingType type;

        @Override // com.squareup.wire.Message.Builder
        public ExternalDisplayTimezoneSetting build() {
            return new ExternalDisplayTimezoneSetting(this.follow_system, this.timezone, this.timezone_offset, this.type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder follow_system(Boolean r100) {
            this.follow_system = r100;
            return this;
        }

        public Builder timezone(String r100) {
            this.timezone = r100;
            return this;
        }

        public Builder timezone_offset(Integer r100) {
            this.timezone_offset = r100;
            return this;
        }

        public Builder type(ExternalDisplayTimezoneSettingType r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ExternalDisplayTimezoneSetting extends ProtoAdapter<ExternalDisplayTimezoneSetting> {
        public ProtoAdapter_ExternalDisplayTimezoneSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, ExternalDisplayTimezoneSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ExternalDisplayTimezoneSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.follow_system = Boolean.FALSE;
            r101.timezone = "";
            r101.timezone_offset = 0;
            r101.type = ExternalDisplayTimezoneSettingType.FOLLOW_SYSTEM;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.follow_system = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.timezone = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.timezone_offset = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.type = ExternalDisplayTimezoneSettingType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ExternalDisplayTimezoneSetting r100) {
            Boolean r101 = r100.follow_system;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.timezone;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.timezone_offset;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            ExternalDisplayTimezoneSettingType r110 = r100.type;
            if (r110 == null) goto L18;
            r102 = ExternalDisplayTimezoneSettingType.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ ExternalDisplayTimezoneSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ExternalDisplayTimezoneSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ExternalDisplayTimezoneSetting r101) throws IOException {
            Boolean r102 = r101.follow_system;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.timezone;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.timezone_offset;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            ExternalDisplayTimezoneSettingType r105 = r101.type;
            if (r105 == null) goto L14;
            ExternalDisplayTimezoneSettingType.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ExternalDisplayTimezoneSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ExternalDisplayTimezoneSetting();
        DEFAULT_FOLLOW_SYSTEM = Boolean.FALSE;
        DEFAULT_TIMEZONE_OFFSET = 0;
        DEFAULT_TYPE = ExternalDisplayTimezoneSettingType.FOLLOW_SYSTEM;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.follow_system = this.follow_system;
        r100.timezone = this.timezone;
        r100.timezone_offset = this.timezone_offset;
        r100.type = this.type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ExternalDisplayTimezoneSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ExternalDisplayTimezoneSetting(Boolean r100, String r101, Integer r102, ExternalDisplayTimezoneSettingType r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public ExternalDisplayTimezoneSetting(Boolean r100, String r101, Integer r102, ExternalDisplayTimezoneSettingType r103, ByteString r104) {
        super(ADAPTER, r104);
        this.follow_system = r100;
        this.timezone = r101;
        this.timezone_offset = r102;
        this.type = r103;
    }
}
