package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class ParsingInfo extends Message<ParsingInfo, Builder> {
    public static final ProtoAdapter<ParsingInfo> ADAPTER = null;
    public static final String DEFAULT_TEXT = "";
    private static final long serialVersionUID = 0;
    public final Style minfo_style;
    public final String mtext;

    public static final class Builder extends Message.Builder<ParsingInfo, Builder> {
        public Style minfo_style;
        public String mtext;

        @Override // com.squareup.wire.Message.Builder
        public ParsingInfo build() {
            return new ParsingInfo(this.mtext, this.minfo_style, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder info_style(Style r100) {
            this.minfo_style = r100;
            return this;
        }

        public Builder text(String r100) {
            this.mtext = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ParsingInfo extends ProtoAdapter<ParsingInfo> {
        public ProtoAdapter_ParsingInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ParsingInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ParsingInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mtext = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mtext = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.minfo_style = Style.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
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
        public int encodedSize2(ParsingInfo r100) {
            String r101 = r100.mtext;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Style r104 = r100.minfo_style;
            if (r104 == null) goto L10;
            r102 = Style.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ParsingInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ParsingInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ParsingInfo r101) throws IOException {
            String r102 = r101.mtext;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Style r103 = r101.minfo_style;
            if (r103 == null) goto L8;
            Style.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ParsingInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Style extends Enum<Style> implements WireEnum {
        private static final /* synthetic */ Style[] $VALUES = null;
        public static final ProtoAdapter<Style> ADAPTER = null;
        public static final Style HIGHLIGHT = null;
        public static final Style NORMAL = null;
        public static final Style STRIKETHROUGH = null;
        public static final Style UNKNOWN = null;
        private final int value;

        static {
            Style r100 = new Style("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Style r101 = new Style("HIGHLIGHT", 1, 1);
            HIGHLIGHT = r101;
            Style r102 = new Style("STRIKETHROUGH", 2, 2);
            STRIKETHROUGH = r102;
            Style r103 = new Style(EffectConstants.NORMAL, 3, 3);
            NORMAL = r103;
            $VALUES = new Style[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(Style.class);
        }

        public static Style[] values() {
            return (Style[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Style fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return NORMAL;
        L14:
            return STRIKETHROUGH;
        L16:
            return HIGHLIGHT;
        L18:
            return UNKNOWN;
        }

        public static Style valueOf(String r100) {
            return (Style) a.a(Style.class, r100);
        }

        private Style(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ParsingInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtext = this.mtext;
        r100.minfo_style = this.minfo_style;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ParsingInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ParsingInfo(String r100, Style r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ParsingInfo(String r100, Style r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mtext = r100;
        this.minfo_style = r101;
    }
}
