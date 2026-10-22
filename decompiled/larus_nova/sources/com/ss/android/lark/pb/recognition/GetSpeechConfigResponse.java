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
public final class GetSpeechConfigResponse extends Message<GetSpeechConfigResponse, Builder> {
    public static final ProtoAdapter<GetSpeechConfigResponse> ADAPTER = null;
    public static final Integer DEFAULT_CODE = null;
    public static final Boolean DEFAULT_ENABLE_FORMAT = null;
    public static final String DEFAULT_MANUAL_CONF_LANG = "";
    public static final Integer DEFAULT_SPEECH_VERSION = null;
    private static final long serialVersionUID = 0;
    public final Integer mcode;
    public final Boolean menable_format;
    public final String mmanual_conf_lang;
    public final Integer mspeech_version;
    public final List<SpeechLang> msupport_lang_list;
    public final List<String> msupport_langs;

    public static final class Builder extends Message.Builder<GetSpeechConfigResponse, Builder> {
        public Integer mcode;
        public Boolean menable_format;
        public String mmanual_conf_lang;
        public Integer mspeech_version;
        public List<SpeechLang> msupport_lang_list;
        public List<String> msupport_langs;

        @Override // com.squareup.wire.Message.Builder
        public GetSpeechConfigResponse build() {
            return new GetSpeechConfigResponse(this.mcode, this.mmanual_conf_lang, this.msupport_langs, this.msupport_lang_list, this.mspeech_version, this.menable_format, super.buildUnknownFields());
        }

        public Builder() {
            this.msupport_langs = Internal.newMutableList();
            this.msupport_lang_list = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder code(Integer r100) {
            this.mcode = r100;
            return this;
        }

        public Builder enable_format(Boolean r100) {
            this.menable_format = r100;
            return this;
        }

        public Builder manual_conf_lang(String r100) {
            this.mmanual_conf_lang = r100;
            return this;
        }

        public Builder speech_version(Integer r100) {
            this.mspeech_version = r100;
            return this;
        }

        public Builder support_lang_list(List<SpeechLang> r100) {
            Internal.checkElementsNotNull(r100);
            this.msupport_lang_list = r100;
            return this;
        }

        public Builder support_langs(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.msupport_langs = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetSpeechConfigResponse extends ProtoAdapter<GetSpeechConfigResponse> {
        public ProtoAdapter_GetSpeechConfigResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSpeechConfigResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetSpeechConfigResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mcode = 0;
            r101.mmanual_conf_lang = "";
            r101.mspeech_version = 0;
            r101.menable_format = Boolean.TRUE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L13;
            switch(r103) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.menable_format = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.mspeech_version = ProtoAdapter.INT32.decode(r100);
            goto L3
        L9:
            r101.msupport_lang_list.add(SpeechLang.ADAPTER.decode(r100));
            goto L3
        L10:
            r101.msupport_langs.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L11:
            r101.mmanual_conf_lang = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.mcode = ProtoAdapter.INT32.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetSpeechConfigResponse r100) {
            Integer r101 = r100.mcode;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mmanual_conf_lang;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = ((r103 + r105) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(3, r100.msupport_langs)) + SpeechLang.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.msupport_lang_list);
            Integer r107 = r100.mspeech_version;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(5, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.menable_format;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r110);
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
        public /* bridge */ /* synthetic */ GetSpeechConfigResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetSpeechConfigResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetSpeechConfigResponse r101) throws IOException {
            Integer r102 = r101.mcode;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mmanual_conf_lang;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 3, r101.msupport_langs);
            SpeechLang.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.msupport_lang_list);
            Integer r104 = r101.mspeech_version;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r104);
        L11:
            Boolean r105 = r101.menable_format;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetSpeechConfigResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetSpeechConfigResponse();
        DEFAULT_CODE = 0;
        DEFAULT_SPEECH_VERSION = 0;
        DEFAULT_ENABLE_FORMAT = Boolean.TRUE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mcode = this.mcode;
        r100.mmanual_conf_lang = this.mmanual_conf_lang;
        r100.msupport_langs = Internal.copyOf("msupport_langs", this.msupport_langs);
        r100.msupport_lang_list = Internal.copyOf("msupport_lang_list", this.msupport_lang_list);
        r100.mspeech_version = this.mspeech_version;
        r100.menable_format = this.menable_format;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetSpeechConfigResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetSpeechConfigResponse(Integer r100, String r110, List<String> r111, List<SpeechLang> r112, Integer r113, Boolean r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public GetSpeechConfigResponse(Integer r100, String r101, List<String> r102, List<SpeechLang> r103, Integer r104, Boolean r105, ByteString r106) {
        super(ADAPTER, r106);
        this.mcode = r100;
        this.mmanual_conf_lang = r101;
        this.msupport_langs = Internal.immutableCopyOf("msupport_langs", r102);
        this.msupport_lang_list = Internal.immutableCopyOf("msupport_lang_list", r103);
        this.mspeech_version = r104;
        this.menable_format = r105;
    }
}
