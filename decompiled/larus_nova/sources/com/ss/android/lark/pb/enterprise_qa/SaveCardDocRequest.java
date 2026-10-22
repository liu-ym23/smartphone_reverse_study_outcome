package com.ss.android.lark.pb.enterprise_qa;

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
public final class SaveCardDocRequest extends Message<SaveCardDocRequest, Builder> {
    public static final ProtoAdapter<SaveCardDocRequest> ADAPTER = null;
    public static final Integer DEFAULT_ASK_SCENE = null;
    public static final String DEFAULT_CARD_KEY = "";
    public static final String DEFAULT_DOC_TOKEN = "";
    public static final String DEFAULT_IDENTIFIER_ID = "";
    public static final Integer DEFAULT_SELECTED_ANSWER_INDEX = null;
    public static final String DEFAULT_TOPIC_ID = "";
    public static final String DEFAULT_WIKI_SPACE_ID = "";
    private static final long serialVersionUID = 0;
    public final AnswerType manswer_type;
    public final Integer mask_scene;
    public final String mcard_key;
    public final String mdoc_token;
    public final String midentifier_id;
    public final Integer mselected_answer_index;
    public final String mtopic_id;
    public final String mwiki_space_id;

    public static final enum AnswerType extends Enum<AnswerType> implements WireEnum {
        private static final /* synthetic */ AnswerType[] $VALUES = null;
        public static final ProtoAdapter<AnswerType> ADAPTER = null;
        public static final AnswerType CANVAS = null;
        public static final AnswerType CARD = null;
        public static final AnswerType UNKNOWN = null;
        private final int value;

        static {
            AnswerType r100 = new AnswerType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            AnswerType r101 = new AnswerType("CARD", 1, 1);
            CARD = r101;
            AnswerType r102 = new AnswerType("CANVAS", 2, 2);
            CANVAS = r102;
            $VALUES = new AnswerType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(AnswerType.class);
        }

        public static AnswerType[] values() {
            return (AnswerType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static AnswerType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return CANVAS;
        L12:
            return CARD;
        L14:
            return UNKNOWN;
        }

        public static AnswerType valueOf(String r100) {
            return (AnswerType) a.a(AnswerType.class, r100);
        }

        private AnswerType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends Message.Builder<SaveCardDocRequest, Builder> {
        public AnswerType manswer_type;
        public Integer mask_scene;
        public String mcard_key;
        public String mdoc_token;
        public String midentifier_id;
        public Integer mselected_answer_index;
        public String mtopic_id;
        public String mwiki_space_id;

        @Override // com.squareup.wire.Message.Builder
        public SaveCardDocRequest build() {
            return new SaveCardDocRequest(this.mcard_key, this.mask_scene, this.mwiki_space_id, this.midentifier_id, this.mtopic_id, this.manswer_type, this.mdoc_token, this.mselected_answer_index, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder answer_type(AnswerType r100) {
            this.manswer_type = r100;
            return this;
        }

        public Builder ask_scene(Integer r100) {
            this.mask_scene = r100;
            return this;
        }

        public Builder card_key(String r100) {
            this.mcard_key = r100;
            return this;
        }

        public Builder doc_token(String r100) {
            this.mdoc_token = r100;
            return this;
        }

        public Builder identifier_id(String r100) {
            this.midentifier_id = r100;
            return this;
        }

        public Builder selected_answer_index(Integer r100) {
            this.mselected_answer_index = r100;
            return this;
        }

        public Builder topic_id(String r100) {
            this.mtopic_id = r100;
            return this;
        }

        public Builder wiki_space_id(String r100) {
            this.mwiki_space_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SaveCardDocRequest extends ProtoAdapter<SaveCardDocRequest> {
        public ProtoAdapter_SaveCardDocRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SaveCardDocRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SaveCardDocRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mcard_key = "";
            r101.mask_scene = 0;
            r101.mwiki_space_id = "";
            r101.midentifier_id = "";
            r101.mtopic_id = "";
            r101.mdoc_token = "";
            r101.mselected_answer_index = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            switch(r103) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L20;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L20:
            r101.manswer_type = AnswerType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mselected_answer_index = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            r101.mdoc_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.mtopic_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.midentifier_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.mwiki_space_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.mask_scene = ProtoAdapter.INT32.decode(r100);
            goto L3
        L17:
            r101.mcard_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SaveCardDocRequest r100) {
            String r101 = r100.mcard_key;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.mask_scene;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mwiki_space_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.midentifier_id;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.mtopic_id;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            AnswerType r116 = r100.manswer_type;
            if (r116 == null) goto L25;
            int r117 = AnswerType.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.mdoc_token;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Integer r122 = r100.mselected_answer_index;
            if (r122 == null) goto L34;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(8, r122);
        L34:
            return (r121 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ SaveCardDocRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SaveCardDocRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SaveCardDocRequest r101) throws IOException {
            String r102 = r101.mcard_key;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.mask_scene;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mwiki_space_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.midentifier_id;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.mtopic_id;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            AnswerType r107 = r101.manswer_type;
            if (r107 == null) goto L20;
            AnswerType.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.mdoc_token;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            Integer r109 = r101.mselected_answer_index;
            if (r109 == null) goto L26;
            ProtoAdapter.INT32.encodeWithTag(r100, 8, r109);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SaveCardDocRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SaveCardDocRequest();
        DEFAULT_ASK_SCENE = 0;
        DEFAULT_SELECTED_ANSWER_INDEX = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mcard_key = this.mcard_key;
        r100.mask_scene = this.mask_scene;
        r100.mwiki_space_id = this.mwiki_space_id;
        r100.midentifier_id = this.midentifier_id;
        r100.mtopic_id = this.mtopic_id;
        r100.manswer_type = this.manswer_type;
        r100.mdoc_token = this.mdoc_token;
        r100.mselected_answer_index = this.mselected_answer_index;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SaveCardDocRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SaveCardDocRequest(String r110, Integer r111, String r112, String r113, String r114, AnswerType r115, String r116, Integer r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public SaveCardDocRequest(String r100, Integer r101, String r102, String r103, String r104, AnswerType r105, String r106, Integer r107, ByteString r110) {
        super(ADAPTER, r110);
        this.mcard_key = r100;
        this.mask_scene = r101;
        this.mwiki_space_id = r102;
        this.midentifier_id = r103;
        this.mtopic_id = r104;
        this.manswer_type = r105;
        this.mdoc_token = r106;
        this.mselected_answer_index = r107;
    }
}
