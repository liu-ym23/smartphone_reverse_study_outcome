package com.ss.android.lark.pb.recognition;

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
public final class SpeechRecognitionFeedbackRequest extends Message<SpeechRecognitionFeedbackRequest, Builder> {
    public static final ProtoAdapter<SpeechRecognitionFeedbackRequest> ADAPTER = null;
    public static final String DEFAULT_CLIENT_RESULT = "";
    public static final String DEFAULT_DESC = "";
    public static final ByteString DEFAULT_ORIGIN_AUDIO_DATA = null;
    public static final String DEFAULT_ORIGIN_AUDIO_TYPE = "";
    public static final String DEFAULT_SOURCE_ID = "";
    private static final long serialVersionUID = 0;
    public final List<String> mbutton_desc;
    public final String mclient_result;
    public final String mdesc;
    public final List<SpeechRecognitionFeedbackItem> mitems;
    public final ByteString morigin_audio_data;
    public final String morigin_audio_type;
    public final String msource_id;

    public static final class Builder extends Message.Builder<SpeechRecognitionFeedbackRequest, Builder> {
        public List<String> mbutton_desc;
        public String mclient_result;
        public String mdesc;
        public List<SpeechRecognitionFeedbackItem> mitems;
        public ByteString morigin_audio_data;
        public String morigin_audio_type;
        public String msource_id;

        @Override // com.squareup.wire.Message.Builder
        public SpeechRecognitionFeedbackRequest build() {
            return new SpeechRecognitionFeedbackRequest(this.msource_id, this.mdesc, this.mbutton_desc, this.mclient_result, this.morigin_audio_type, this.morigin_audio_data, this.mitems, super.buildUnknownFields());
        }

        public Builder() {
            this.mbutton_desc = Internal.newMutableList();
            this.mitems = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder button_desc(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mbutton_desc = r100;
            return this;
        }

        public Builder client_result(String r100) {
            this.mclient_result = r100;
            return this;
        }

        public Builder desc(String r100) {
            this.mdesc = r100;
            return this;
        }

        public Builder items(List<SpeechRecognitionFeedbackItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.mitems = r100;
            return this;
        }

        public Builder origin_audio_data(ByteString r100) {
            this.morigin_audio_data = r100;
            return this;
        }

        public Builder origin_audio_type(String r100) {
            this.morigin_audio_type = r100;
            return this;
        }

        public Builder source_id(String r100) {
            this.msource_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SpeechRecognitionFeedbackRequest extends ProtoAdapter<SpeechRecognitionFeedbackRequest> {
        public ProtoAdapter_SpeechRecognitionFeedbackRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SpeechRecognitionFeedbackRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SpeechRecognitionFeedbackRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.msource_id = "";
            r101.mdesc = "";
            r101.mclient_result = "";
            r101.morigin_audio_type = "";
            r101.morigin_audio_data = ByteString.EMPTY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L14;
            switch(r103) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.mitems.add(SpeechRecognitionFeedbackItem.ADAPTER.decode(r100));
            goto L3
        L8:
            r101.morigin_audio_data = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L9:
            r101.morigin_audio_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.mclient_result = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.mbutton_desc.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            r101.mdesc = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.msource_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SpeechRecognitionFeedbackRequest r100) {
            String r101 = r100.msource_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mdesc;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ProtoAdapter<String> r107 = ProtoAdapter.STRING;
            int r108 = r106 + r107.asRepeated().encodedSizeWithTag(3, r100.mbutton_desc);
            String r109 = r100.mclient_result;
            if (r109 == null) goto L13;
            int r110 = r107.encodedSizeWithTag(4, r109);
        L14:
            int r111 = r108 + r110;
            String r112 = r100.morigin_audio_type;
            if (r112 == null) goto L17;
            int r113 = r107.encodedSizeWithTag(5, r112);
        L18:
            int r114 = r111 + r113;
            ByteString r115 = r100.morigin_audio_data;
            if (r115 == null) goto L22;
            r102 = ProtoAdapter.BYTES.encodedSizeWithTag(6, r115);
        L22:
            return ((r114 + r102) + SpeechRecognitionFeedbackItem.ADAPTER.asRepeated().encodedSizeWithTag(7, r100.mitems)) + r100.unknownFields().size();
        L17:
            r113 = 0;
            goto L18
        L13:
            r110 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SpeechRecognitionFeedbackRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SpeechRecognitionFeedbackRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SpeechRecognitionFeedbackRequest r101) throws IOException {
            String r102 = r101.msource_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mdesc;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            ProtoAdapter<String> r104 = ProtoAdapter.STRING;
            r104.asRepeated().encodeWithTag(r100, 3, r101.mbutton_desc);
            String r105 = r101.mclient_result;
            if (r105 == null) goto L11;
            r104.encodeWithTag(r100, 4, r105);
        L11:
            String r106 = r101.morigin_audio_type;
            if (r106 == null) goto L14;
            r104.encodeWithTag(r100, 5, r106);
        L14:
            ByteString r107 = r101.morigin_audio_data;
            if (r107 == null) goto L17;
            ProtoAdapter.BYTES.encodeWithTag(r100, 6, r107);
        L17:
            SpeechRecognitionFeedbackItem.ADAPTER.asRepeated().encodeWithTag(r100, 7, r101.mitems);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SpeechRecognitionFeedbackRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SpeechRecognitionFeedbackRequest();
        DEFAULT_ORIGIN_AUDIO_DATA = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.msource_id = this.msource_id;
        r100.mdesc = this.mdesc;
        r100.mbutton_desc = Internal.copyOf("mbutton_desc", this.mbutton_desc);
        r100.mclient_result = this.mclient_result;
        r100.morigin_audio_type = this.morigin_audio_type;
        r100.morigin_audio_data = this.morigin_audio_data;
        r100.mitems = Internal.copyOf("mitems", this.mitems);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SpeechRecognitionFeedbackRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SpeechRecognitionFeedbackRequest(String r110, String r111, List<String> r112, String r113, String r114, ByteString r115, List<SpeechRecognitionFeedbackItem> r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public SpeechRecognitionFeedbackRequest(String r100, String r101, List<String> r102, String r103, String r104, ByteString r105, List<SpeechRecognitionFeedbackItem> r106, ByteString r107) {
        super(ADAPTER, r107);
        this.msource_id = r100;
        this.mdesc = r101;
        this.mbutton_desc = Internal.immutableCopyOf("mbutton_desc", r102);
        this.mclient_result = r103;
        this.morigin_audio_type = r104;
        this.morigin_audio_data = r105;
        this.mitems = Internal.immutableCopyOf("mitems", r106);
    }
}
