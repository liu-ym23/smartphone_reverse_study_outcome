package com.ss.android.lark.pb.recognition;

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

/* JADX INFO: loaded from: classes37.dex */
public final class SpeechRecognitionReportEditRequest extends Message<SpeechRecognitionReportEditRequest, Builder> {
    public static final ProtoAdapter<SpeechRecognitionReportEditRequest> ADAPTER = null;
    public static final String DEFAULT_SOURCE_ID = "";
    public static final String DEFAULT_TEXT_EDIT = "";
    public static final String DEFAULT_TEXT_INIT = "";
    public static final String DEFAULT_TEXT_ORIGIN = "";
    private static final long serialVersionUID = 0;
    public final List<SpeechRecognitionReportEditItem> mitems;
    public final Scene mscene;
    public final String msource_id;
    public final String mtext_edit;
    public final String mtext_init;
    public final String mtext_origin;

    public static final class Builder extends Message.Builder<SpeechRecognitionReportEditRequest, Builder> {
        public List<SpeechRecognitionReportEditItem> mitems;
        public Scene mscene;
        public String msource_id;
        public String mtext_edit;
        public String mtext_init;
        public String mtext_origin;

        @Override // com.squareup.wire.Message.Builder
        public SpeechRecognitionReportEditRequest build() {
            return new SpeechRecognitionReportEditRequest(this.msource_id, this.mtext_origin, this.mtext_edit, this.mitems, this.mscene, this.mtext_init, super.buildUnknownFields());
        }

        public Builder() {
            this.mitems = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder items(List<SpeechRecognitionReportEditItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.mitems = r100;
            return this;
        }

        public Builder scene(Scene r100) {
            this.mscene = r100;
            return this;
        }

        public Builder source_id(String r100) {
            this.msource_id = r100;
            return this;
        }

        public Builder text_edit(String r100) {
            this.mtext_edit = r100;
            return this;
        }

        public Builder text_init(String r100) {
            this.mtext_init = r100;
            return this;
        }

        public Builder text_origin(String r100) {
            this.mtext_origin = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SpeechRecognitionReportEditRequest extends ProtoAdapter<SpeechRecognitionReportEditRequest> {
        public ProtoAdapter_SpeechRecognitionReportEditRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SpeechRecognitionReportEditRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SpeechRecognitionReportEditRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.msource_id = "";
            r101.mtext_origin = "";
            r101.mtext_edit = "";
            r101.mtext_init = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L16;
            switch(r103) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L18;
                case 6: goto L7;
                default: goto L6;
            };
        L18:
            r101.mscene = Scene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mtext_init = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.mitems.add(SpeechRecognitionReportEditItem.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.mtext_edit = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.mtext_origin = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.msource_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SpeechRecognitionReportEditRequest r100) {
            String r101 = r100.msource_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mtext_origin;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mtext_edit;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = (r106 + r108) + SpeechRecognitionReportEditItem.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.mitems);
            Scene r110 = r100.mscene;
            if (r110 == null) goto L17;
            int r111 = Scene.ADAPTER.encodedSizeWithTag(5, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.mtext_init;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(6, r113);
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
        public /* bridge */ /* synthetic */ SpeechRecognitionReportEditRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SpeechRecognitionReportEditRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SpeechRecognitionReportEditRequest r101) throws IOException {
            String r102 = r101.msource_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mtext_origin;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mtext_edit;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            SpeechRecognitionReportEditItem.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.mitems);
            Scene r105 = r101.mscene;
            if (r105 == null) goto L14;
            Scene.ADAPTER.encodeWithTag(r100, 5, r105);
        L14:
            String r106 = r101.mtext_init;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SpeechRecognitionReportEditRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Scene extends Enum<Scene> implements WireEnum {
        private static final /* synthetic */ Scene[] $VALUES = null;
        public static final ProtoAdapter<Scene> ADAPTER = null;
        public static final Scene ADVANCED = null;
        public static final Scene BUBBLE = null;
        public static final Scene PC = null;
        public static final Scene UNKNOWN = null;
        private final int value;

        static {
            Scene r100 = new Scene("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Scene r101 = new Scene("BUBBLE", 1, 1);
            BUBBLE = r101;
            Scene r102 = new Scene("ADVANCED", 2, 2);
            ADVANCED = r102;
            Scene r103 = new Scene("PC", 3, 3);
            PC = r103;
            $VALUES = new Scene[]{r100, r101, r102, r103};
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
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return PC;
        L14:
            return ADVANCED;
        L16:
            return BUBBLE;
        L18:
            return UNKNOWN;
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
        ADAPTER = new ProtoAdapter_SpeechRecognitionReportEditRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.msource_id = this.msource_id;
        r100.mtext_origin = this.mtext_origin;
        r100.mtext_edit = this.mtext_edit;
        r100.mitems = Internal.copyOf("mitems", this.mitems);
        r100.mscene = this.mscene;
        r100.mtext_init = this.mtext_init;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SpeechRecognitionReportEditRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SpeechRecognitionReportEditRequest(String r100, String r110, String r111, List<SpeechRecognitionReportEditItem> r112, Scene r113, String r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public SpeechRecognitionReportEditRequest(String r100, String r101, String r102, List<SpeechRecognitionReportEditItem> r103, Scene r104, String r105, ByteString r106) {
        super(ADAPTER, r106);
        this.msource_id = r100;
        this.mtext_origin = r101;
        this.mtext_edit = r102;
        this.mitems = Internal.immutableCopyOf("mitems", r103);
        this.mscene = r104;
        this.mtext_init = r105;
    }
}
