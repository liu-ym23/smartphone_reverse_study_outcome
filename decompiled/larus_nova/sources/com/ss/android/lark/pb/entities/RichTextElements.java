package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class RichTextElements extends com.squareup.wire.Message<RichTextElements, Builder> {
    public static final ProtoAdapter<RichTextElements> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, RichTextElement> mdictionary;
    public final Map<String, RichTextElementStyleRefs> mstyle_refs;
    public final List<RichTextStyle> mstyles;

    public static final class Builder extends com.squareup.wire.Message.Builder<RichTextElements, Builder> {
        public Map<String, RichTextElement> mdictionary;
        public Map<String, RichTextElementStyleRefs> mstyle_refs;
        public List<RichTextStyle> mstyles;

        @Override // com.squareup.wire.Message.Builder
        public RichTextElements build() {
            return new RichTextElements(this.mdictionary, this.mstyle_refs, this.mstyles, super.buildUnknownFields());
        }

        public Builder() {
            this.mdictionary = Internal.newMutableMap();
            this.mstyle_refs = Internal.newMutableMap();
            this.mstyles = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder dictionary(Map<String, RichTextElement> r100) {
            Internal.checkElementsNotNull(r100);
            this.mdictionary = r100;
            return this;
        }

        public Builder style_refs(Map<String, RichTextElementStyleRefs> r100) {
            Internal.checkElementsNotNull(r100);
            this.mstyle_refs = r100;
            return this;
        }

        public Builder styles(List<RichTextStyle> r100) {
            Internal.checkElementsNotNull(r100);
            this.mstyles = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RichTextElements extends ProtoAdapter<RichTextElements> {
        private final ProtoAdapter<Map<String, RichTextElement>> mdictionary;
        private final ProtoAdapter<Map<String, RichTextElementStyleRefs>> mstyle_refs;

        public ProtoAdapter_RichTextElements() {
            super(FieldEncoding.LENGTH_DELIMITED, RichTextElements.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mdictionary = ProtoAdapter.newMapAdapter(r100, RichTextElement.ADAPTER);
            this.mstyle_refs = ProtoAdapter.newMapAdapter(r100, RichTextElementStyleRefs.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RichTextElements decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mdictionary.putAll(this.mdictionary.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mstyle_refs.putAll(this.mstyle_refs.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mstyles.add(RichTextStyle.ADAPTER.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(RichTextElements r100) {
            return ((this.mdictionary.encodedSizeWithTag(1, r100.mdictionary) + this.mstyle_refs.encodedSizeWithTag(2, r100.mstyle_refs)) + RichTextStyle.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.mstyles)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RichTextElements decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RichTextElements r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RichTextElements r101) throws IOException {
            this.mdictionary.encodeWithTag(r100, 1, r101.mdictionary);
            this.mstyle_refs.encodeWithTag(r100, 2, r101.mstyle_refs);
            RichTextStyle.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.mstyles);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RichTextElements r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class RichTextElementStyleRefs extends com.squareup.wire.Message<RichTextElementStyleRefs, Builder> {
        public static final ProtoAdapter<RichTextElementStyleRefs> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<Integer> mstyle_ids;

        public static final class Builder extends com.squareup.wire.Message.Builder<RichTextElementStyleRefs, Builder> {
            public List<Integer> mstyle_ids;

            @Override // com.squareup.wire.Message.Builder
            public RichTextElementStyleRefs build() {
                return new RichTextElementStyleRefs(this.mstyle_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.mstyle_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder style_ids(List<Integer> r100) {
                Internal.checkElementsNotNull(r100);
                this.mstyle_ids = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_RichTextElementStyleRefs extends ProtoAdapter<RichTextElementStyleRefs> {
            public ProtoAdapter_RichTextElementStyleRefs() {
                super(FieldEncoding.LENGTH_DELIMITED, RichTextElementStyleRefs.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public RichTextElementStyleRefs decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.mstyle_ids.add(ProtoAdapter.INT32.decode(r100));
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
            public int encodedSize2(RichTextElementStyleRefs r100) {
                return ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(1, r100.mstyle_ids) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ RichTextElementStyleRefs decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(RichTextElementStyleRefs r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, RichTextElementStyleRefs r101) throws IOException {
                ProtoAdapter.INT32.asRepeated().encodeWithTag(r100, 1, r101.mstyle_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RichTextElementStyleRefs r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_RichTextElementStyleRefs();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mstyle_ids = Internal.copyOf("mstyle_ids", this.mstyle_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return RichTextElementStyleRefs.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public RichTextElementStyleRefs(List<Integer> r100) {
            this(r100, ByteString.EMPTY);
        }

        public RichTextElementStyleRefs(List<Integer> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.mstyle_ids = Internal.immutableCopyOf("mstyle_ids", r100);
        }
    }

    public static final class RichTextStyle extends com.squareup.wire.Message<RichTextStyle, Builder> {
        public static final ProtoAdapter<RichTextStyle> ADAPTER = null;
        public static final String DEFAULT_NAME = "";
        public static final String DEFAULT_VALUE = "";
        private static final long serialVersionUID = 0;
        public final String mname;
        public final String mvalue;

        public static final class Builder extends com.squareup.wire.Message.Builder<RichTextStyle, Builder> {
            public String mname;
            public String mvalue;

            @Override // com.squareup.wire.Message.Builder
            public RichTextStyle build() {
                return new RichTextStyle(this.mname, this.mvalue, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder name(String r100) {
                this.mname = r100;
                return this;
            }

            public Builder value(String r100) {
                this.mvalue = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_RichTextStyle extends ProtoAdapter<RichTextStyle> {
            public ProtoAdapter_RichTextStyle() {
                super(FieldEncoding.LENGTH_DELIMITED, RichTextStyle.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public RichTextStyle decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mname = "";
                r101.mvalue = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mname = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mvalue = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(RichTextStyle r100) {
                String r101 = r100.mname;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.mvalue;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ RichTextStyle decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(RichTextStyle r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, RichTextStyle r101) throws IOException {
                String r102 = r101.mname;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.mvalue;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RichTextStyle r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_RichTextStyle();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mname = this.mname;
            r100.mvalue = this.mvalue;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return RichTextStyle.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public RichTextStyle(String r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public RichTextStyle(String r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mname = r100;
            this.mvalue = r101;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RichTextElements();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mdictionary = Internal.copyOf("mdictionary", this.mdictionary);
        r100.mstyle_refs = Internal.copyOf("mstyle_refs", this.mstyle_refs);
        r100.mstyles = Internal.copyOf("mstyles", this.mstyles);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RichTextElements.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public RichTextElements(Map<String, RichTextElement> r100, Map<String, RichTextElementStyleRefs> r101, List<RichTextStyle> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public RichTextElements(Map<String, RichTextElement> r100, Map<String, RichTextElementStyleRefs> r101, List<RichTextStyle> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mdictionary = Internal.immutableCopyOf("mdictionary", r100);
        this.mstyle_refs = Internal.immutableCopyOf("mstyle_refs", r101);
        this.mstyles = Internal.immutableCopyOf("mstyles", r102);
    }
}
