package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SpeechScene extends Message<SpeechScene, Builder> {
    public static final ProtoAdapter<SpeechScene> ADAPTER = null;
    public static final String DEFAULT_DATA_ID = "";
    private static final long serialVersionUID = 0;
    public final AiKnowledge ai_knowledge;
    public final String data_id;

    /* JADX INFO: renamed from: doc, reason: collision with root package name */
    public final Doc f253657doc;
    public final ImReal im_real;
    public final SpeechDefault speech_default;

    public static final class AiKnowledge extends Message<AiKnowledge, Builder> {
        public static final ProtoAdapter<AiKnowledge> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends Message.Builder<AiKnowledge, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public AiKnowledge build() {
                return new AiKnowledge(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_AiKnowledge extends ProtoAdapter<AiKnowledge> {
            public ProtoAdapter_AiKnowledge() {
                super(FieldEncoding.LENGTH_DELIMITED, AiKnowledge.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AiKnowledge decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(AiKnowledge r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AiKnowledge decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AiKnowledge r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AiKnowledge r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AiKnowledge r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AiKnowledge();
        }

        public AiKnowledge() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return AiKnowledge.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public AiKnowledge(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class Builder extends Message.Builder<SpeechScene, Builder> {
        public AiKnowledge ai_knowledge;
        public String data_id;

        /* JADX INFO: renamed from: doc, reason: collision with root package name */
        public Doc f253658doc;
        public ImReal im_real;
        public SpeechDefault speech_default;

        @Override // com.squareup.wire.Message.Builder
        public SpeechScene build() {
            return new SpeechScene(this.data_id, this.speech_default, this.im_real, this.ai_knowledge, this.f253658doc, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ai_knowledge(AiKnowledge r100) {
            this.ai_knowledge = r100;
            this.speech_default = null;
            this.im_real = null;
            this.f253658doc = null;
            return this;
        }

        public Builder data_id(String r100) {
            this.data_id = r100;
            return this;
        }

        public Builder doc(Doc r100) {
            this.f253658doc = r100;
            this.speech_default = null;
            this.im_real = null;
            this.ai_knowledge = null;
            return this;
        }

        public Builder im_real(ImReal r100) {
            this.im_real = r100;
            this.speech_default = null;
            this.ai_knowledge = null;
            this.f253658doc = null;
            return this;
        }

        public Builder speech_default(SpeechDefault r100) {
            this.speech_default = r100;
            this.im_real = null;
            this.ai_knowledge = null;
            this.f253658doc = null;
            return this;
        }
    }

    public static final class Doc extends Message<Doc, Builder> {
        public static final ProtoAdapter<Doc> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends Message.Builder<Doc, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public Doc build() {
                return new Doc(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_Doc extends ProtoAdapter<Doc> {
            public ProtoAdapter_Doc() {
                super(FieldEncoding.LENGTH_DELIMITED, Doc.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Doc decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Doc r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Doc decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Doc r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Doc r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Doc r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Doc();
        }

        public Doc() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Doc.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Doc(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class ImReal extends Message<ImReal, Builder> {
        public static final ProtoAdapter<ImReal> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends Message.Builder<ImReal, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public ImReal build() {
                return new ImReal(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_ImReal extends ProtoAdapter<ImReal> {
            public ProtoAdapter_ImReal() {
                super(FieldEncoding.LENGTH_DELIMITED, ImReal.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ImReal decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ImReal r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ImReal decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ImReal r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ImReal r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ImReal r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ImReal();
        }

        public ImReal() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ImReal.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ImReal(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class ProtoAdapter_SpeechScene extends ProtoAdapter<SpeechScene> {
        public ProtoAdapter_SpeechScene() {
            super(FieldEncoding.LENGTH_DELIMITED, SpeechScene.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SpeechScene decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.data_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.data_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.speech_default(SpeechDefault.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.im_real(ImReal.ADAPTER.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.ai_knowledge(AiKnowledge.ADAPTER.decode(r100));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.doc(Doc.ADAPTER.decode(r100));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SpeechScene r100) {
            String r101 = r100.data_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            SpeechDefault r104 = r100.speech_default;
            if (r104 == null) goto L9;
            int r105 = SpeechDefault.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ImReal r107 = r100.im_real;
            if (r107 == null) goto L13;
            int r108 = ImReal.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            AiKnowledge r110 = r100.ai_knowledge;
            if (r110 == null) goto L17;
            int r111 = AiKnowledge.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Doc r113 = r100.f253657doc;
            if (r113 == null) goto L22;
            r102 = Doc.ADAPTER.encodedSizeWithTag(5, r113);
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
        public /* bridge */ /* synthetic */ SpeechScene decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SpeechScene r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SpeechScene r101) throws IOException {
            String r102 = r101.data_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            SpeechDefault r103 = r101.speech_default;
            if (r103 == null) goto L8;
            SpeechDefault.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            ImReal r104 = r101.im_real;
            if (r104 == null) goto L11;
            ImReal.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            AiKnowledge r105 = r101.ai_knowledge;
            if (r105 == null) goto L14;
            AiKnowledge.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            Doc r106 = r101.f253657doc;
            if (r106 == null) goto L17;
            Doc.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SpeechScene r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class SpeechDefault extends Message<SpeechDefault, Builder> {
        public static final ProtoAdapter<SpeechDefault> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends Message.Builder<SpeechDefault, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public SpeechDefault build() {
                return new SpeechDefault(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_SpeechDefault extends ProtoAdapter<SpeechDefault> {
            public ProtoAdapter_SpeechDefault() {
                super(FieldEncoding.LENGTH_DELIMITED, SpeechDefault.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SpeechDefault decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(SpeechDefault r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SpeechDefault decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SpeechDefault r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SpeechDefault r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SpeechDefault r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SpeechDefault();
        }

        public SpeechDefault() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SpeechDefault.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SpeechDefault(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SpeechScene();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.data_id = this.data_id;
        r100.speech_default = this.speech_default;
        r100.im_real = this.im_real;
        r100.ai_knowledge = this.ai_knowledge;
        r100.f253658doc = this.f253657doc;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SpeechScene.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SpeechScene(String r100, SpeechDefault r101, ImReal r110, AiKnowledge r111, Doc r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public SpeechScene(String r100, SpeechDefault r101, ImReal r102, AiKnowledge r103, Doc r104, ByteString r105) {
        super(ADAPTER, r105);
        if (Internal.countNonNull(r101, r102, r103, r104, new Object[0]) > 1) goto L7;
        this.data_id = r100;
        this.speech_default = r101;
        this.im_real = r102;
        this.ai_knowledge = r103;
        this.f253657doc = r104;
        return;
    L7:
        throw new IllegalArgumentException("at most one of speech_default, im_real, ai_knowledge, doc may be non-null");
    }
}
