package com.ss.android.lark.pb.recognition;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class SpeechLang extends Message<SpeechLang, Builder> {
    public static final ProtoAdapter<SpeechLang> ADAPTER = null;
    public static final String DEFAULT_LANGCODE = "";
    public static final String DEFAULT_LANGNAME = "";
    private static final long serialVersionUID = 0;
    public final String mlangCode;
    public final String mlangName;

    public static final class Builder extends Message.Builder<SpeechLang, Builder> {
        public String mlangCode;
        public String mlangName;

        @Override // com.squareup.wire.Message.Builder
        public SpeechLang build() {
            return new SpeechLang(this.mlangCode, this.mlangName, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder langCode(String r100) {
            this.mlangCode = r100;
            return this;
        }

        public Builder langName(String r100) {
            this.mlangName = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SpeechLang extends ProtoAdapter<SpeechLang> {
        public ProtoAdapter_SpeechLang() {
            super(FieldEncoding.LENGTH_DELIMITED, SpeechLang.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SpeechLang decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mlangCode = "";
            r101.mlangName = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mlangCode = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mlangName = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SpeechLang r100) {
            String r101 = r100.mlangCode;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mlangName;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SpeechLang decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SpeechLang r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SpeechLang r101) throws IOException {
            String r102 = r101.mlangCode;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mlangName;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SpeechLang r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SpeechLang();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mlangCode = this.mlangCode;
        r100.mlangName = this.mlangName;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SpeechLang.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SpeechLang(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SpeechLang(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mlangCode = r100;
        this.mlangName = r101;
    }
}
