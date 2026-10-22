package com.bytedance.lark.pb.calendar.v1;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class CalendarEventDescriptionElements extends Message<CalendarEventDescriptionElements, Builder> {
    public static final ProtoAdapter<CalendarEventDescriptionElements> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<DescriptionElement> elements;

    public static final class Builder extends Message.Builder<CalendarEventDescriptionElements, Builder> {
        public List<DescriptionElement> elements;

        @Override // com.squareup.wire.Message.Builder
        public CalendarEventDescriptionElements build() {
            return new CalendarEventDescriptionElements(this.elements, super.buildUnknownFields());
        }

        public Builder() {
            this.elements = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder elements(List<DescriptionElement> r100) {
            Internal.checkElementsNotNull(r100);
            this.elements = r100;
            return this;
        }
    }

    public static final class DescriptionElement extends Message<DescriptionElement, Builder> {
        public static final ProtoAdapter<DescriptionElement> ADAPTER = null;
        public static final Integer DEFAULT_DOC_TYPE = null;
        public static final Boolean DEFAULT_IS_DOC_INVALID = null;
        public static final String DEFAULT_TEXT = "";
        public static final ElementType DEFAULT_TYPE = null;
        public static final String DEFAULT_URL = "";
        private static final long serialVersionUID = 0;
        public final Integer doc_type;
        public final Boolean is_doc_invalid;
        public final String text;
        public final ElementType type;
        public final String url;

        public static final class Builder extends Message.Builder<DescriptionElement, Builder> {
            public Integer doc_type;
            public Boolean is_doc_invalid;
            public String text;
            public ElementType type;
            public String url;

            @Override // com.squareup.wire.Message.Builder
            public DescriptionElement build() {
                return new DescriptionElement(this.type, this.text, this.url, this.doc_type, this.is_doc_invalid, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder doc_type(Integer r100) {
                this.doc_type = r100;
                return this;
            }

            public Builder is_doc_invalid(Boolean r100) {
                this.is_doc_invalid = r100;
                return this;
            }

            public Builder text(String r100) {
                this.text = r100;
                return this;
            }

            public Builder type(ElementType r100) {
                this.type = r100;
                return this;
            }

            public Builder url(String r100) {
                this.url = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DescriptionElement extends ProtoAdapter<DescriptionElement> {
            public ProtoAdapter_DescriptionElement() {
                super(FieldEncoding.LENGTH_DELIMITED, DescriptionElement.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DescriptionElement decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = ElementType.UNKNOWN;
                r101.text = "";
                r101.url = "";
                r101.doc_type = 0;
                r101.is_doc_invalid = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L24;
                if (r103 != 1) goto L8;
                r101.type = ElementType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.text = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 11) goto L14;
                r101.doc_type = ProtoAdapter.INT32.decode(r100);
                goto L3
            L14:
                if (r103 != 12) goto L15;
                r101.is_doc_invalid = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(DescriptionElement r100) {
                ElementType r101 = r100.type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ElementType.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.text;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.url;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Integer r110 = r100.doc_type;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.INT32.encodedSizeWithTag(11, r110);
            L18:
                int r112 = r109 + r111;
                Boolean r113 = r100.is_doc_invalid;
                if (r113 == null) goto L22;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r113);
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
            public /* bridge */ /* synthetic */ DescriptionElement decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DescriptionElement r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DescriptionElement r101) throws IOException {
                ElementType r102 = r101.type;
                if (r102 == null) goto L5;
                ElementType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.text;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.url;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                Integer r105 = r101.doc_type;
                if (r105 == null) goto L14;
                ProtoAdapter.INT32.encodeWithTag(r100, 11, r105);
            L14:
                Boolean r106 = r101.is_doc_invalid;
                if (r106 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r100, 12, r106);
            L17:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DescriptionElement r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DescriptionElement();
            DEFAULT_TYPE = ElementType.UNKNOWN;
            DEFAULT_DOC_TYPE = 0;
            DEFAULT_IS_DOC_INVALID = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.text = this.text;
            r100.url = this.url;
            r100.doc_type = this.doc_type;
            r100.is_doc_invalid = this.is_doc_invalid;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DescriptionElement.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DescriptionElement(ElementType r100, String r101, String r110, Integer r111, Boolean r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public DescriptionElement(ElementType r100, String r101, String r102, Integer r103, Boolean r104, ByteString r105) {
            super(ADAPTER, r105);
            this.type = r100;
            this.text = r101;
            this.url = r102;
            this.doc_type = r103;
            this.is_doc_invalid = r104;
        }
    }

    public static final enum ElementType extends Enum<ElementType> implements WireEnum {
        private static final /* synthetic */ ElementType[] $VALUES = null;
        public static final ProtoAdapter<ElementType> ADAPTER = null;
        public static final ElementType DOC = null;
        public static final ElementType TEXT = null;
        public static final ElementType UNKNOWN = null;
        public static final ElementType URL = null;
        private final int value;

        static {
            ElementType r100 = new ElementType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ElementType r101 = new ElementType(CardAdapter.TEXT, 1, 1);
            TEXT = r101;
            ElementType r102 = new ElementType("URL", 2, 2);
            URL = r102;
            ElementType r103 = new ElementType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 3, 3);
            DOC = r103;
            $VALUES = new ElementType[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(ElementType.class);
        }

        public static ElementType[] values() {
            return (ElementType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ElementType fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return DOC;
        L14:
            return URL;
        L16:
            return TEXT;
        L18:
            return UNKNOWN;
        }

        public static ElementType valueOf(String r100) {
            return (ElementType) a.a(ElementType.class, r100);
        }

        private ElementType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_CalendarEventDescriptionElements extends ProtoAdapter<CalendarEventDescriptionElements> {
        public ProtoAdapter_CalendarEventDescriptionElements() {
            super(FieldEncoding.LENGTH_DELIMITED, CalendarEventDescriptionElements.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CalendarEventDescriptionElements decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.elements.add(DescriptionElement.ADAPTER.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CalendarEventDescriptionElements r100) {
            return DescriptionElement.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.elements) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CalendarEventDescriptionElements decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CalendarEventDescriptionElements r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CalendarEventDescriptionElements r101) throws IOException {
            DescriptionElement.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.elements);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CalendarEventDescriptionElements r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CalendarEventDescriptionElements();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.elements = Internal.copyOf(SlcElement.KEY_ELEMENTS, this.elements);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CalendarEventDescriptionElements.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CalendarEventDescriptionElements(List<DescriptionElement> r100) {
        this(r100, ByteString.EMPTY);
    }

    public CalendarEventDescriptionElements(List<DescriptionElement> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.elements = Internal.immutableCopyOf(SlcElement.KEY_ELEMENTS, r100);
    }
}
