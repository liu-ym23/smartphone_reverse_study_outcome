package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class MappingColor extends Message<MappingColor, Builder> {
    public static final ProtoAdapter<MappingColor> ADAPTER = null;
    public static final Integer DEFAULT_BACKGROUND_COLOR = null;
    public static final Integer DEFAULT_EVENT_CARD_COLOR = null;
    public static final String DEFAULT_EVENT_COLOR_INDEX = "";
    public static final Integer DEFAULT_FOREGROUND_COLOR = null;
    private static final long serialVersionUID = 0;
    public final Integer background_color;
    public final Integer event_card_color;
    public final String event_color_index;
    public final Integer foreground_color;

    public static final class Builder extends Message.Builder<MappingColor, Builder> {
        public Integer background_color;
        public Integer event_card_color;
        public String event_color_index;
        public Integer foreground_color;

        @Override // com.squareup.wire.Message.Builder
        public MappingColor build() {
            return new MappingColor(this.background_color, this.foreground_color, this.event_card_color, this.event_color_index, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder background_color(Integer r100) {
            this.background_color = r100;
            return this;
        }

        public Builder event_card_color(Integer r100) {
            this.event_card_color = r100;
            return this;
        }

        public Builder event_color_index(String r100) {
            this.event_color_index = r100;
            return this;
        }

        public Builder foreground_color(Integer r100) {
            this.foreground_color = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MappingColor extends ProtoAdapter<MappingColor> {
        public ProtoAdapter_MappingColor() {
            super(FieldEncoding.LENGTH_DELIMITED, MappingColor.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MappingColor decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.background_color = 0;
            r101.foreground_color = 0;
            r101.event_card_color = 0;
            r101.event_color_index = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.background_color = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.foreground_color = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.event_card_color = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.event_color_index = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MappingColor r100) {
            Integer r101 = r100.background_color;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.foreground_color;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.event_card_color;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.event_color_index;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ MappingColor decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MappingColor r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MappingColor r101) throws IOException {
            Integer r102 = r101.background_color;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.foreground_color;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.event_card_color;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.event_color_index;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MappingColor r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MappingColor();
        DEFAULT_BACKGROUND_COLOR = 0;
        DEFAULT_FOREGROUND_COLOR = 0;
        DEFAULT_EVENT_CARD_COLOR = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.background_color = this.background_color;
        r100.foreground_color = this.foreground_color;
        r100.event_card_color = this.event_card_color;
        r100.event_color_index = this.event_color_index;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MappingColor.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MappingColor(Integer r100, Integer r101, Integer r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public MappingColor(Integer r100, Integer r101, Integer r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.background_color = r100;
        this.foreground_color = r101;
        this.event_card_color = r102;
        this.event_color_index = r103;
    }
}
