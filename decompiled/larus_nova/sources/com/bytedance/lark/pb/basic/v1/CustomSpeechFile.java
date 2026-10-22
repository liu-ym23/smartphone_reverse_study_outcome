package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class CustomSpeechFile extends com.squareup.wire.Message<CustomSpeechFile, Builder> {
    public static final ProtoAdapter<CustomSpeechFile> ADAPTER = null;
    public static final String DEFAULT_FILE_KEY = "";
    public static final String DEFAULT_FS_UNIT = "";
    private static final long serialVersionUID = 0;
    public final String file_key;
    public final String fs_unit;

    public static final class Builder extends com.squareup.wire.Message.Builder<CustomSpeechFile, Builder> {
        public String file_key;
        public String fs_unit;

        @Override // com.squareup.wire.Message.Builder
        public CustomSpeechFile build() {
            return new CustomSpeechFile(this.file_key, this.fs_unit, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder file_key(String r100) {
            this.file_key = r100;
            return this;
        }

        public Builder fs_unit(String r100) {
            this.fs_unit = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomSpeechFile extends ProtoAdapter<CustomSpeechFile> {
        public ProtoAdapter_CustomSpeechFile() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomSpeechFile.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CustomSpeechFile decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.file_key = "";
            r101.fs_unit = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.file_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.fs_unit = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(CustomSpeechFile r100) {
            String r101 = r100.file_key;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.fs_unit;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CustomSpeechFile decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CustomSpeechFile r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CustomSpeechFile r101) throws IOException {
            String r102 = r101.file_key;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.fs_unit;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomSpeechFile r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomSpeechFile();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.file_key = this.file_key;
        r100.fs_unit = this.fs_unit;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CustomSpeechFile.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public CustomSpeechFile(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CustomSpeechFile(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.file_key = r100;
        this.fs_unit = r101;
    }
}
