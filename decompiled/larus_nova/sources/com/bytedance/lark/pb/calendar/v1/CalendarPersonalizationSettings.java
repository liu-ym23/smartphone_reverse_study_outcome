package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class CalendarPersonalizationSettings extends Message<CalendarPersonalizationSettings, Builder> {
    public static final ProtoAdapter<CalendarPersonalizationSettings> ADAPTER = null;
    public static final ColorIndex DEFAULT_COLOR_INDEX = null;
    private static final long serialVersionUID = 0;
    public final ColorIndex color_index;

    public static final class Builder extends Message.Builder<CalendarPersonalizationSettings, Builder> {
        public ColorIndex color_index;

        @Override // com.squareup.wire.Message.Builder
        public CalendarPersonalizationSettings build() {
            return new CalendarPersonalizationSettings(this.color_index, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder color_index(ColorIndex r100) {
            this.color_index = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CalendarPersonalizationSettings extends ProtoAdapter<CalendarPersonalizationSettings> {
        public ProtoAdapter_CalendarPersonalizationSettings() {
            super(FieldEncoding.LENGTH_DELIMITED, CalendarPersonalizationSettings.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CalendarPersonalizationSettings decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.color_index = ColorIndex.NONE_COLOR;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.color_index = ColorIndex.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
        public int encodedSize2(CalendarPersonalizationSettings r100) {
            ColorIndex r101 = r100.color_index;
            if (r101 == null) goto L5;
            int r102 = ColorIndex.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CalendarPersonalizationSettings decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CalendarPersonalizationSettings r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CalendarPersonalizationSettings r101) throws IOException {
            ColorIndex r102 = r101.color_index;
            if (r102 == null) goto L5;
            ColorIndex.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CalendarPersonalizationSettings r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CalendarPersonalizationSettings();
        DEFAULT_COLOR_INDEX = ColorIndex.NONE_COLOR;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.color_index = this.color_index;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CalendarPersonalizationSettings.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CalendarPersonalizationSettings(ColorIndex r100) {
        this(r100, ByteString.EMPTY);
    }

    public CalendarPersonalizationSettings(ColorIndex r100, ByteString r101) {
        super(ADAPTER, r101);
        this.color_index = r100;
    }
}
