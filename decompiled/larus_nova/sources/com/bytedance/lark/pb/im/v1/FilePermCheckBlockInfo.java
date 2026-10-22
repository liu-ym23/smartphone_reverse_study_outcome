package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class FilePermCheckBlockInfo extends Message<FilePermCheckBlockInfo, Builder> {
    public static final ProtoAdapter<FilePermCheckBlockInfo> ADAPTER = null;
    public static final String DEFAULT_BUTTON = "";
    public static final String DEFAULT_POPUP_TEXT = "";
    public static final String DEFAULT_POPUP_TITLE = "";
    public static final String DEFAULT_TOAST = "";
    private static final long serialVersionUID = 0;
    public final String button;
    public final String popup_text;
    public final String popup_title;
    public final String toast;

    public static final class Builder extends Message.Builder<FilePermCheckBlockInfo, Builder> {
        public String button;
        public String popup_text;
        public String popup_title;
        public String toast;

        @Override // com.squareup.wire.Message.Builder
        public FilePermCheckBlockInfo build() {
            return new FilePermCheckBlockInfo(this.toast, this.popup_title, this.popup_text, this.button, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder button(String r100) {
            this.button = r100;
            return this;
        }

        public Builder popup_text(String r100) {
            this.popup_text = r100;
            return this;
        }

        public Builder popup_title(String r100) {
            this.popup_title = r100;
            return this;
        }

        public Builder toast(String r100) {
            this.toast = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FilePermCheckBlockInfo extends ProtoAdapter<FilePermCheckBlockInfo> {
        public ProtoAdapter_FilePermCheckBlockInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, FilePermCheckBlockInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FilePermCheckBlockInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.toast = "";
            r101.popup_title = "";
            r101.popup_text = "";
            r101.button = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.toast = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.popup_title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.popup_text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.button = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FilePermCheckBlockInfo r100) {
            String r101 = r100.toast;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.popup_title;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.popup_text;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.button;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ FilePermCheckBlockInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FilePermCheckBlockInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FilePermCheckBlockInfo r101) throws IOException {
            String r102 = r101.toast;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.popup_title;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.popup_text;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.button;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FilePermCheckBlockInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FilePermCheckBlockInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.toast = this.toast;
        r100.popup_title = this.popup_title;
        r100.popup_text = this.popup_text;
        r100.button = this.button;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FilePermCheckBlockInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FilePermCheckBlockInfo(String r100, String r101, String r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FilePermCheckBlockInfo(String r100, String r101, String r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.toast = r100;
        this.popup_title = r101;
        this.popup_text = r102;
        this.button = r103;
    }
}
