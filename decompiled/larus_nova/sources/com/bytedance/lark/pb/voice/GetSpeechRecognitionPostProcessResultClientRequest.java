package com.bytedance.lark.pb.voice;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetSpeechRecognitionPostProcessResultClientRequest extends Message<GetSpeechRecognitionPostProcessResultClientRequest, Builder> {
    public static final ProtoAdapter<GetSpeechRecognitionPostProcessResultClientRequest> ADAPTER = null;
    public static final String DEFAULT_CONTEXT_ID = "";
    public static final Boolean DEFAULT_MARKDOWN_ENABLE = null;
    public static final String DEFAULT_RECOGNITION_TEXT = "";
    public static final Scene DEFAULT_SCENE = null;
    public static final ProtoAdapter_GetSpeechRecognitionPostProcessResultClientRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String context_id;
    public final Boolean markdown_enable;
    public final String recognition_text;
    public final Scene scene;

    public static final class Builder extends Message.Builder<GetSpeechRecognitionPostProcessResultClientRequest, Builder> implements d<GetSpeechRecognitionPostProcessResultClientRequest> {
        public String context_id;
        public Boolean markdown_enable;
        public String recognition_text;
        public Scene scene;

        @Override // com.squareup.wire.Message.Builder
        public GetSpeechRecognitionPostProcessResultClientRequest build() {
            return new GetSpeechRecognitionPostProcessResultClientRequest(this.recognition_text, this.scene, this.context_id, this.markdown_enable, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder context_id(String r100) {
            this.context_id = r100;
            return this;
        }

        public Builder markdown_enable(Boolean r100) {
            this.markdown_enable = r100;
            return this;
        }

        public Builder recognition_text(String r100) {
            this.recognition_text = r100;
            return this;
        }

        public Builder scene(Scene r100) {
            this.scene = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetSpeechRecognitionPostProcessResultClientRequest extends ProtoAdapter<GetSpeechRecognitionPostProcessResultClientRequest> implements c<GetSpeechRecognitionPostProcessResultClientRequest> {
        public ProtoAdapter_GetSpeechRecognitionPostProcessResultClientRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSpeechRecognitionPostProcessResultClientRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetSpeechRecognitionPostProcessResultClientRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.recognition_text = "";
            r101.scene = Scene.UNKNOWN_SCENE;
            r101.context_id = "";
            r101.markdown_enable = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.recognition_text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.scene = Scene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.context_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.markdown_enable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetSpeechRecognitionPostProcessResultClientRequest r100) {
            String r101 = r100.recognition_text;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Scene r104 = r100.scene;
            if (r104 == null) goto L9;
            int r105 = Scene.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.context_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.markdown_enable;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ GetSpeechRecognitionPostProcessResultClientRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetSpeechRecognitionPostProcessResultClientRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetSpeechRecognitionPostProcessResultClientRequest r101) throws IOException {
            String r102 = r101.recognition_text;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Scene r103 = r101.scene;
            if (r103 == null) goto L8;
            Scene.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.context_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.markdown_enable;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetSpeechRecognitionPostProcessResultClientRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Scene extends Enum<Scene> implements WireEnum {
        private static final /* synthetic */ Scene[] $VALUES = null;
        public static final ProtoAdapter<Scene> ADAPTER = null;
        public static final Scene DOUBAO_DOC = null;
        public static final Scene DOUBAO_IM = null;
        public static final Scene UNKNOWN_SCENE = null;
        private final int value;

        static {
            Scene r100 = new Scene("UNKNOWN_SCENE", 0, 0);
            UNKNOWN_SCENE = r100;
            Scene r101 = new Scene("DOUBAO_IM", 1, 1);
            DOUBAO_IM = r101;
            Scene r102 = new Scene("DOUBAO_DOC", 2, 2);
            DOUBAO_DOC = r102;
            $VALUES = new Scene[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Scene.class);
        }

        public static Scene[] values() {
            return (Scene[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Scene fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return DOUBAO_DOC;
        L12:
            return DOUBAO_IM;
        L14:
            return UNKNOWN_SCENE;
        }

        public static Scene valueOf(String r100) {
            return (Scene) a.a(Scene.class, r100);
        }

        private Scene(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_GetSpeechRecognitionPostProcessResultClientRequest r100 = new ProtoAdapter_GetSpeechRecognitionPostProcessResultClientRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SCENE = Scene.UNKNOWN_SCENE;
        DEFAULT_MARKDOWN_ENABLE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.recognition_text = this.recognition_text;
        r100.scene = this.scene;
        r100.context_id = this.context_id;
        r100.markdown_enable = this.markdown_enable;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetSpeechRecognitionPostProcessResultClientRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetSpeechRecognitionPostProcessResultClientRequest(String r100, Scene r101, String r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetSpeechRecognitionPostProcessResultClientRequest(String r100, Scene r101, String r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.recognition_text = r100;
        this.scene = r101;
        this.context_id = r102;
        this.markdown_enable = r103;
    }
}
