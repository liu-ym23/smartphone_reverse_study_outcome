package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class EmptyStateMaterial extends Message<EmptyStateMaterial, Builder> {
    public static final ProtoAdapter<EmptyStateMaterial> ADAPTER = null;
    public static final String DEFAULT_CREATE_TIME = "";
    public static final String DEFAULT_DURATION = "";
    public static final String DEFAULT_IMAGE_URL = "";
    public static final String DEFAULT_MATERIAL_ID = "";
    public static final String DEFAULT_NOTE_TOKEN = "";
    public static final String DEFAULT_NOTE_URL = "";
    public static final String DEFAULT_SUBTITLE = "";
    public static final String DEFAULT_SUMMARY = "";
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    public final String mcreate_time;
    public final String mduration;
    public final List<CustomSummaryGoldenSentences> mgolden_sentences;
    public final String mimage_url;
    public final String mmaterial_id;
    public final String mnote_token;
    public final String mnote_url;
    public final String msubtitle;
    public final String msummary;
    public final String mtitle;

    public static final class Builder extends Message.Builder<EmptyStateMaterial, Builder> {
        public String mcreate_time;
        public String mduration;
        public List<CustomSummaryGoldenSentences> mgolden_sentences;
        public String mimage_url;
        public String mmaterial_id;
        public String mnote_token;
        public String mnote_url;
        public String msubtitle;
        public String msummary;
        public String mtitle;

        @Override // com.squareup.wire.Message.Builder
        public EmptyStateMaterial build() {
            return new EmptyStateMaterial(this.mmaterial_id, this.mimage_url, this.mtitle, this.msubtitle, this.msummary, this.mgolden_sentences, this.mnote_url, this.mnote_token, this.mcreate_time, this.mduration, super.buildUnknownFields());
        }

        public Builder() {
            this.mgolden_sentences = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder create_time(String r100) {
            this.mcreate_time = r100;
            return this;
        }

        public Builder duration(String r100) {
            this.mduration = r100;
            return this;
        }

        public Builder golden_sentences(List<CustomSummaryGoldenSentences> r100) {
            Internal.checkElementsNotNull(r100);
            this.mgolden_sentences = r100;
            return this;
        }

        public Builder image_url(String r100) {
            this.mimage_url = r100;
            return this;
        }

        public Builder material_id(String r100) {
            this.mmaterial_id = r100;
            return this;
        }

        public Builder note_token(String r100) {
            this.mnote_token = r100;
            return this;
        }

        public Builder note_url(String r100) {
            this.mnote_url = r100;
            return this;
        }

        public Builder subtitle(String r100) {
            this.msubtitle = r100;
            return this;
        }

        public Builder summary(String r100) {
            this.msummary = r100;
            return this;
        }

        public Builder title(String r100) {
            this.mtitle = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_EmptyStateMaterial extends ProtoAdapter<EmptyStateMaterial> {
        public ProtoAdapter_EmptyStateMaterial() {
            super(FieldEncoding.LENGTH_DELIMITED, EmptyStateMaterial.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EmptyStateMaterial decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mmaterial_id = "";
            r101.mimage_url = "";
            r101.mtitle = "";
            r101.msubtitle = "";
            r101.msummary = "";
            r101.mnote_url = "";
            r101.mnote_token = "";
            r101.mcreate_time = "";
            r101.mduration = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L17;
            switch(r103) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            r101.mduration = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.mcreate_time = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.mnote_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.mnote_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.mgolden_sentences.add(CustomSummaryGoldenSentences.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.msummary = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.msubtitle = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.mtitle = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.mimage_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.mmaterial_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(EmptyStateMaterial r100) {
            String r101 = r100.mmaterial_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mimage_url;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mtitle;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.msubtitle;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.msummary;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = (r112 + r114) + CustomSummaryGoldenSentences.ADAPTER.asRepeated().encodedSizeWithTag(6, r100.mgolden_sentences);
            String r116 = r100.mnote_url;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(7, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.mnote_token;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(8, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.mcreate_time;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(9, r122);
        L34:
            int r124 = r121 + r123;
            String r125 = r100.mduration;
            if (r125 == null) goto L38;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(10, r125);
        L38:
            return (r124 + r102) + r100.unknownFields().size();
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
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
        public /* bridge */ /* synthetic */ EmptyStateMaterial decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EmptyStateMaterial r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EmptyStateMaterial r101) throws IOException {
            String r102 = r101.mmaterial_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mimage_url;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mtitle;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.msubtitle;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.msummary;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            CustomSummaryGoldenSentences.ADAPTER.asRepeated().encodeWithTag(r100, 6, r101.mgolden_sentences);
            String r107 = r101.mnote_url;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r107);
        L20:
            String r108 = r101.mnote_token;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r108);
        L23:
            String r109 = r101.mcreate_time;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r109);
        L26:
            String r110 = r101.mduration;
            if (r110 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r100, 10, r110);
        L29:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EmptyStateMaterial r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EmptyStateMaterial();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mmaterial_id = this.mmaterial_id;
        r100.mimage_url = this.mimage_url;
        r100.mtitle = this.mtitle;
        r100.msubtitle = this.msubtitle;
        r100.msummary = this.msummary;
        r100.mgolden_sentences = Internal.copyOf("mgolden_sentences", this.mgolden_sentences);
        r100.mnote_url = this.mnote_url;
        r100.mnote_token = this.mnote_token;
        r100.mcreate_time = this.mcreate_time;
        r100.mduration = this.mduration;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EmptyStateMaterial.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public EmptyStateMaterial(String r110, String r111, String r112, String r113, String r114, List<CustomSummaryGoldenSentences> r115, String r116, String r210, String r211, String r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public EmptyStateMaterial(String r100, String r101, String r102, String r103, String r104, List<CustomSummaryGoldenSentences> r105, String r106, String r107, String r110, String r111, ByteString r112) {
        super(ADAPTER, r112);
        this.mmaterial_id = r100;
        this.mimage_url = r101;
        this.mtitle = r102;
        this.msubtitle = r103;
        this.msummary = r104;
        this.mgolden_sentences = Internal.immutableCopyOf("mgolden_sentences", r105);
        this.mnote_url = r106;
        this.mnote_token = r107;
        this.mcreate_time = r110;
        this.mduration = r111;
    }
}
