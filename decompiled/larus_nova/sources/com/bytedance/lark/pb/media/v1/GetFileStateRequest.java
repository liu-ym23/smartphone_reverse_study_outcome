package com.bytedance.lark.pb.media.v1;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetFileStateRequest extends Message<GetFileStateRequest, Builder> {
    public static final ProtoAdapter<GetFileStateRequest> ADAPTER = null;
    public static final String DEFAULT_CHANNEL_ID = "";
    public static final String DEFAULT_FILE_KEY = "";
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final DownloadFileScene DEFAULT_SCENE = null;
    public static final String DEFAULT_SOURCE_ID = "";
    public static final com.bytedance.lark.pb.basic.v1.Message.SourceType DEFAULT_SOURCE_TYPE = null;
    public static final ProtoAdapter_GetFileStateRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String channel_id;
    public final String file_key;
    public final String message_id;
    public final DownloadFileOptions options;
    public final DownloadFileScene scene;
    public final String source_id;
    public final com.bytedance.lark.pb.basic.v1.Message.SourceType source_type;

    public static final class Builder extends Message.Builder<GetFileStateRequest, Builder> implements d<GetFileStateRequest> {
        public String channel_id;
        public String file_key;
        public String message_id;
        public DownloadFileOptions options;
        public DownloadFileScene scene;
        public String source_id;
        public com.bytedance.lark.pb.basic.v1.Message.SourceType source_type;

        @Override // com.squareup.wire.Message.Builder
        public GetFileStateRequest build() {
            String r100 = this.message_id;
            if (r100 == null) goto L7;
            return new GetFileStateRequest(this.message_id, this.source_id, this.source_type, this.scene, this.options, this.file_key, this.channel_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, MusicAppletPage.KEY_MESSAGE_ID});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder channel_id(String r100) {
            this.channel_id = r100;
            return this;
        }

        public Builder file_key(String r100) {
            this.file_key = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder options(DownloadFileOptions r100) {
            this.options = r100;
            return this;
        }

        public Builder scene(DownloadFileScene r100) {
            this.scene = r100;
            return this;
        }

        public Builder source_id(String r100) {
            this.source_id = r100;
            return this;
        }

        public Builder source_type(com.bytedance.lark.pb.basic.v1.Message.SourceType r100) {
            this.source_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetFileStateRequest extends ProtoAdapter<GetFileStateRequest> implements c<GetFileStateRequest> {
        public ProtoAdapter_GetFileStateRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetFileStateRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetFileStateRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_id = "";
            r101.source_id = "";
            r101.source_type = com.bytedance.lark.pb.basic.v1.Message.SourceType.TYPE_FROM_UNKONWN;
            r101.scene = DownloadFileScene.CHAT;
            r101.file_key = "";
            r101.channel_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L20;
            switch(r103) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L24;
                case 4: goto L22;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L22:
            r101.scene = DownloadFileScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L24:
            r101.source_type = com.bytedance.lark.pb.basic.v1.Message.SourceType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.channel_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.file_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.options = DownloadFileOptions.ADAPTER.decode(r100);
            goto L3
        L18:
            r101.source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L20:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetFileStateRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.message_id);
            String r103 = r100.source_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            com.bytedance.lark.pb.basic.v1.Message.SourceType r107 = r100.source_type;
            if (r107 == null) goto L9;
            int r108 = com.bytedance.lark.pb.basic.v1.Message.SourceType.ADAPTER.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            DownloadFileScene r110 = r100.scene;
            if (r110 == null) goto L13;
            int r111 = DownloadFileScene.ADAPTER.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            DownloadFileOptions r113 = r100.options;
            if (r113 == null) goto L17;
            int r114 = DownloadFileOptions.ADAPTER.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            String r116 = r100.file_key;
            if (r116 == null) goto L21;
            int r117 = r101.encodedSizeWithTag(6, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.channel_id;
            if (r119 == null) goto L26;
            r104 = r101.encodedSizeWithTag(7, r119);
        L26:
            return (r118 + r104) + r100.unknownFields().size();
        L21:
            r117 = 0;
            goto L22
        L17:
            r114 = 0;
            goto L18
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetFileStateRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetFileStateRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetFileStateRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.message_id);
            String r103 = r101.source_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            com.bytedance.lark.pb.basic.v1.Message.SourceType r104 = r101.source_type;
            if (r104 == null) goto L8;
            com.bytedance.lark.pb.basic.v1.Message.SourceType.ADAPTER.encodeWithTag(r100, 3, r104);
        L8:
            DownloadFileScene r105 = r101.scene;
            if (r105 == null) goto L11;
            DownloadFileScene.ADAPTER.encodeWithTag(r100, 4, r105);
        L11:
            DownloadFileOptions r106 = r101.options;
            if (r106 == null) goto L14;
            DownloadFileOptions.ADAPTER.encodeWithTag(r100, 5, r106);
        L14:
            String r107 = r101.file_key;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 6, r107);
        L17:
            String r108 = r101.channel_id;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 7, r108);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetFileStateRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetFileStateRequest r100 = new ProtoAdapter_GetFileStateRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SOURCE_TYPE = com.bytedance.lark.pb.basic.v1.Message.SourceType.TYPE_FROM_UNKONWN;
        DEFAULT_SCENE = DownloadFileScene.CHAT;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_id = this.message_id;
        r100.source_id = this.source_id;
        r100.source_type = this.source_type;
        r100.scene = this.scene;
        r100.options = this.options;
        r100.file_key = this.file_key;
        r100.channel_id = this.channel_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetFileStateRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetFileStateRequest(String r110, String r111, com.bytedance.lark.pb.basic.v1.Message.SourceType r112, DownloadFileScene r113, DownloadFileOptions r114, String r115, String r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public GetFileStateRequest(String r100, String r101, com.bytedance.lark.pb.basic.v1.Message.SourceType r102, DownloadFileScene r103, DownloadFileOptions r104, String r105, String r106, ByteString r107) {
        super(ADAPTER, r107);
        this.message_id = r100;
        this.source_id = r101;
        this.source_type = r102;
        this.scene = r103;
        this.options = r104;
        this.file_key = r105;
        this.channel_id = r106;
    }
}
