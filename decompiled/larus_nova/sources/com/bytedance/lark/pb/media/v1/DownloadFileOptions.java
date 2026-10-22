package com.bytedance.lark.pb.media.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class DownloadFileOptions extends Message<DownloadFileOptions, Builder> {
    public static final ProtoAdapter<DownloadFileOptions> ADAPTER = null;
    public static final Boolean DEFAULT_AUTH_BACK = null;
    public static final String DEFAULT_AUTH_FILE_KEY = "";
    public static final String DEFAULT_MSG_LINK_TOKEN = "";
    public static final String DEFAULT_PREVIEW_TOKEN = "";
    public static final String DEFAULT_WATERMARK_SCENE = "";
    private static final long serialVersionUID = 0;
    public final Boolean auth_back;
    public final String auth_file_key;
    public final String msg_link_token;
    public final String preview_token;
    public final VisitInfo visit_info;
    public final String watermark_scene;

    public static final class Builder extends Message.Builder<DownloadFileOptions, Builder> {
        public Boolean auth_back;
        public String auth_file_key;
        public String msg_link_token;
        public String preview_token;
        public VisitInfo visit_info;
        public String watermark_scene;

        @Override // com.squareup.wire.Message.Builder
        public DownloadFileOptions build() {
            return new DownloadFileOptions(this.preview_token, this.auth_file_key, this.auth_back, this.visit_info, this.watermark_scene, this.msg_link_token, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder auth_back(Boolean r100) {
            this.auth_back = r100;
            return this;
        }

        public Builder auth_file_key(String r100) {
            this.auth_file_key = r100;
            return this;
        }

        public Builder msg_link_token(String r100) {
            this.msg_link_token = r100;
            return this;
        }

        public Builder preview_token(String r100) {
            this.preview_token = r100;
            return this;
        }

        public Builder visit_info(VisitInfo r100) {
            this.visit_info = r100;
            return this;
        }

        public Builder watermark_scene(String r100) {
            this.watermark_scene = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DownloadFileOptions extends ProtoAdapter<DownloadFileOptions> {
        public ProtoAdapter_DownloadFileOptions() {
            super(FieldEncoding.LENGTH_DELIMITED, DownloadFileOptions.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DownloadFileOptions decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.preview_token = "";
            r101.auth_file_key = "";
            r101.auth_back = Boolean.FALSE;
            r101.watermark_scene = "";
            r101.msg_link_token = "";
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
            r101.msg_link_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.watermark_scene = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.visit_info = VisitInfo.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.auth_back = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.auth_file_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.preview_token = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(DownloadFileOptions r100) {
            String r101 = r100.preview_token;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.auth_file_key;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.auth_back;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            VisitInfo r110 = r100.visit_info;
            if (r110 == null) goto L17;
            int r111 = VisitInfo.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.watermark_scene;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.msg_link_token;
            if (r116 == null) goto L26;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            return (r115 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ DownloadFileOptions decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DownloadFileOptions r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DownloadFileOptions r101) throws IOException {
            String r102 = r101.preview_token;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.auth_file_key;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.auth_back;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            VisitInfo r105 = r101.visit_info;
            if (r105 == null) goto L14;
            VisitInfo.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.watermark_scene;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.msg_link_token;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DownloadFileOptions r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DownloadFileOptions();
        DEFAULT_AUTH_BACK = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.preview_token = this.preview_token;
        r100.auth_file_key = this.auth_file_key;
        r100.auth_back = this.auth_back;
        r100.visit_info = this.visit_info;
        r100.watermark_scene = this.watermark_scene;
        r100.msg_link_token = this.msg_link_token;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DownloadFileOptions.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DownloadFileOptions(String r100, String r110, Boolean r111, VisitInfo r112, String r113, String r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public DownloadFileOptions(String r100, String r101, Boolean r102, VisitInfo r103, String r104, String r105, ByteString r106) {
        super(ADAPTER, r106);
        this.preview_token = r100;
        this.auth_file_key = r101;
        this.auth_back = r102;
        this.visit_info = r103;
        this.watermark_scene = r104;
        this.msg_link_token = r105;
    }
}
