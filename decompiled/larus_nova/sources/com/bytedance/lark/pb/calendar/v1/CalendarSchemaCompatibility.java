package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class CalendarSchemaCompatibility extends Message<CalendarSchemaCompatibility, Builder> {
    public static final ProtoAdapter<CalendarSchemaCompatibility> ADAPTER = null;
    public static final IncompatibleLevel DEFAULT_INCOMPATIBLE_LEVEL = null;
    public static final Integer DEFAULT_MINIMUM_COMPATIBILITY_VER = null;
    private static final long serialVersionUID = 0;
    public final IncompatibleLevel incompatible_level;
    public final Integer minimum_compatibility_ver;

    public static final class Builder extends Message.Builder<CalendarSchemaCompatibility, Builder> {
        public IncompatibleLevel incompatible_level;
        public Integer minimum_compatibility_ver;

        @Override // com.squareup.wire.Message.Builder
        public CalendarSchemaCompatibility build() {
            return new CalendarSchemaCompatibility(this.minimum_compatibility_ver, this.incompatible_level, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder incompatible_level(IncompatibleLevel r100) {
            this.incompatible_level = r100;
            return this;
        }

        public Builder minimum_compatibility_ver(Integer r100) {
            this.minimum_compatibility_ver = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CalendarSchemaCompatibility extends ProtoAdapter<CalendarSchemaCompatibility> {
        public ProtoAdapter_CalendarSchemaCompatibility() {
            super(FieldEncoding.LENGTH_DELIMITED, CalendarSchemaCompatibility.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CalendarSchemaCompatibility decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.minimum_compatibility_ver = 0;
            r101.incompatible_level = IncompatibleLevel.SHOW_HINT;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.minimum_compatibility_ver = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.incompatible_level = IncompatibleLevel.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
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
        public int encodedSize2(CalendarSchemaCompatibility r100) {
            Integer r101 = r100.minimum_compatibility_ver;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            IncompatibleLevel r104 = r100.incompatible_level;
            if (r104 == null) goto L10;
            r102 = IncompatibleLevel.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CalendarSchemaCompatibility decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CalendarSchemaCompatibility r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CalendarSchemaCompatibility r101) throws IOException {
            Integer r102 = r101.minimum_compatibility_ver;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            IncompatibleLevel r103 = r101.incompatible_level;
            if (r103 == null) goto L8;
            IncompatibleLevel.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CalendarSchemaCompatibility r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CalendarSchemaCompatibility();
        DEFAULT_MINIMUM_COMPATIBILITY_VER = 0;
        DEFAULT_INCOMPATIBLE_LEVEL = IncompatibleLevel.SHOW_HINT;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.minimum_compatibility_ver = this.minimum_compatibility_ver;
        r100.incompatible_level = this.incompatible_level;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CalendarSchemaCompatibility.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CalendarSchemaCompatibility(Integer r100, IncompatibleLevel r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CalendarSchemaCompatibility(Integer r100, IncompatibleLevel r101, ByteString r102) {
        super(ADAPTER, r102);
        this.minimum_compatibility_ver = r100;
        this.incompatible_level = r101;
    }
}
