package im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes41.dex */
public final class QuestionItem extends Message<QuestionItem, Builder> {
    public static final ProtoAdapter<QuestionItem> ADAPTER = null;
    public static final String DEFAULT_ANSWER = "";
    public static final String DEFAULT_ICON = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_KNOWLEDGE_SCOPE = "";
    public static final String DEFAULT_NAME = "";
    public static final RecommendType DEFAULT_REC_TYPE = null;
    public static final String DEFAULT_STRATEGY_ID = "";
    private static final long serialVersionUID = 0;
    public final String answer;
    public final List<AnswerReference> answer_ref;
    public final String icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f490427id;
    public final String knowledge_scope;
    public final String name;
    public final RecommendSource rec_source;
    public final RecommendType rec_type;
    public final String strategy_id;

    public static final class Builder extends Message.Builder<QuestionItem, Builder> {
        public String answer;
        public List<AnswerReference> answer_ref;
        public String icon;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f490428id;
        public String knowledge_scope;
        public String name;
        public RecommendSource rec_source;
        public RecommendType rec_type;
        public String strategy_id;

        @Override // com.squareup.wire.Message.Builder
        public QuestionItem build() {
            return new QuestionItem(this.f490428id, this.name, this.icon, this.answer, this.rec_type, this.answer_ref, this.rec_source, this.strategy_id, this.knowledge_scope, super.buildUnknownFields());
        }

        public Builder() {
            this.answer_ref = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder answer(String r100) {
            this.answer = r100;
            return this;
        }

        public Builder answer_ref(List<AnswerReference> r100) {
            Internal.checkElementsNotNull(r100);
            this.answer_ref = r100;
            return this;
        }

        public Builder icon(String r100) {
            this.icon = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f490428id = r100;
            return this;
        }

        public Builder knowledge_scope(String r100) {
            this.knowledge_scope = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder rec_source(RecommendSource r100) {
            this.rec_source = r100;
            return this;
        }

        public Builder rec_type(RecommendType r100) {
            this.rec_type = r100;
            return this;
        }

        public Builder strategy_id(String r100) {
            this.strategy_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_QuestionItem extends ProtoAdapter<QuestionItem> {
        public ProtoAdapter_QuestionItem() {
            super(FieldEncoding.LENGTH_DELIMITED, QuestionItem.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public QuestionItem decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f490428id = "";
            r101.name = "";
            r101.icon = "";
            r101.answer = "";
            r101.rec_type = RecommendType.PROJECT;
            r101.strategy_id = "";
            r101.knowledge_scope = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L21;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L21:
            r101.rec_type = RecommendType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.knowledge_scope = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.strategy_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.rec_source = RecommendSource.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.answer_ref.add(AnswerReference.ADAPTER.decode(r100));
            goto L3
        L15:
            r101.answer = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.icon = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.f490428id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(QuestionItem r100) {
            String r101 = r100.f490427id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.name;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.icon;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.answer;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            RecommendType r113 = r100.rec_type;
            if (r113 == null) goto L21;
            int r114 = RecommendType.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = (r112 + r114) + AnswerReference.ADAPTER.asRepeated().encodedSizeWithTag(6, r100.answer_ref);
            RecommendSource r116 = r100.rec_source;
            if (r116 == null) goto L25;
            int r117 = RecommendSource.ADAPTER.encodedSizeWithTag(7, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.strategy_id;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(8, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.knowledge_scope;
            if (r122 == null) goto L34;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(9, r122);
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
        public /* bridge */ /* synthetic */ QuestionItem decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(QuestionItem r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, QuestionItem r101) throws IOException {
            String r102 = r101.f490427id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.name;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.icon;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.answer;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            RecommendType r106 = r101.rec_type;
            if (r106 == null) goto L17;
            RecommendType.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            AnswerReference.ADAPTER.asRepeated().encodeWithTag(r100, 6, r101.answer_ref);
            RecommendSource r107 = r101.rec_source;
            if (r107 == null) goto L20;
            RecommendSource.ADAPTER.encodeWithTag(r100, 7, r107);
        L20:
            String r108 = r101.strategy_id;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r108);
        L23:
            String r109 = r101.knowledge_scope;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r109);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, QuestionItem r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_QuestionItem();
        DEFAULT_REC_TYPE = RecommendType.PROJECT;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f490428id = this.f490427id;
        r100.name = this.name;
        r100.icon = this.icon;
        r100.answer = this.answer;
        r100.rec_type = this.rec_type;
        r100.answer_ref = Internal.copyOf("answer_ref", this.answer_ref);
        r100.rec_source = this.rec_source;
        r100.strategy_id = this.strategy_id;
        r100.knowledge_scope = this.knowledge_scope;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return QuestionItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public QuestionItem(String r110, String r111, String r112, String r113, RecommendType r114, List<AnswerReference> r115, RecommendSource r116, String r117, String r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public QuestionItem(String r100, String r101, String r102, String r103, RecommendType r104, List<AnswerReference> r105, RecommendSource r106, String r107, String r110, ByteString r111) {
        super(ADAPTER, r111);
        this.f490427id = r100;
        this.name = r101;
        this.icon = r102;
        this.answer = r103;
        this.rec_type = r104;
        this.answer_ref = Internal.immutableCopyOf("answer_ref", r105);
        this.rec_source = r106;
        this.strategy_id = r107;
        this.knowledge_scope = r110;
    }
}
