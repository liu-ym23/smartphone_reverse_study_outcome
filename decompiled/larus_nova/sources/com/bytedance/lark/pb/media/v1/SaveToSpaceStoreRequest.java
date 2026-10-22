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
public final class SaveToSpaceStoreRequest extends Message<SaveToSpaceStoreRequest, Builder> {
    public static final ProtoAdapter<SaveToSpaceStoreRequest> ADAPTER = null;
    public static final String DEFAULT_APP_FILE_ID = "";
    public static final String DEFAULT_APP_ID = "";
    public static final String DEFAULT_AUTH_EXTRA = "";
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final String DEFAULT_SOURCE_ID = "";
    public static final com.bytedance.lark.pb.basic.v1.Message.SourceType DEFAULT_SOURCE_TYPE = null;
    public static final ProtoAdapter_SaveToSpaceStoreRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String app_file_id;
    public final String app_id;
    public final String auth_extra;
    public final String message_id;
    public final String source_id;
    public final com.bytedance.lark.pb.basic.v1.Message.SourceType source_type;

    public static final class Builder extends Message.Builder<SaveToSpaceStoreRequest, Builder> implements d<SaveToSpaceStoreRequest> {
        public String app_file_id;
        public String app_id;
        public String auth_extra;
        public String message_id;
        public String source_id;
        public com.bytedance.lark.pb.basic.v1.Message.SourceType source_type;

        @Override // com.squareup.wire.Message.Builder
        public SaveToSpaceStoreRequest build() {
            String r100 = this.message_id;
            if (r100 == null) goto L7;
            return new SaveToSpaceStoreRequest(this.message_id, this.source_id, this.source_type, this.app_id, this.app_file_id, this.auth_extra, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, MusicAppletPage.KEY_MESSAGE_ID});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_file_id(String r100) {
            this.app_file_id = r100;
            return this;
        }

        public Builder app_id(String r100) {
            this.app_id = r100;
            return this;
        }

        public Builder auth_extra(String r100) {
            this.auth_extra = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
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

    public static final class ProtoAdapter_SaveToSpaceStoreRequest extends ProtoAdapter<SaveToSpaceStoreRequest> implements c<SaveToSpaceStoreRequest> {
        public ProtoAdapter_SaveToSpaceStoreRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SaveToSpaceStoreRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SaveToSpaceStoreRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_id = "";
            r101.source_id = "";
            r101.source_type = com.bytedance.lark.pb.basic.v1.Message.SourceType.TYPE_FROM_UNKONWN;
            r101.app_id = "";
            r101.app_file_id = "";
            r101.auth_extra = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L16;
            switch(r103) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L18;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L18:
            r101.source_type = com.bytedance.lark.pb.basic.v1.Message.SourceType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.auth_extra = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.app_file_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.app_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.message_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SaveToSpaceStoreRequest r100) {
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
            String r110 = r100.app_id;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            String r113 = r100.app_file_id;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            String r116 = r100.auth_extra;
            if (r116 == null) goto L22;
            r104 = r101.encodedSizeWithTag(6, r116);
        L22:
            return (r115 + r104) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ SaveToSpaceStoreRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SaveToSpaceStoreRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SaveToSpaceStoreRequest r101) throws IOException {
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
            String r105 = r101.app_id;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 4, r105);
        L11:
            String r106 = r101.app_file_id;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 5, r106);
        L14:
            String r107 = r101.auth_extra;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 6, r107);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SaveToSpaceStoreRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SaveToSpaceStoreRequest r100 = new ProtoAdapter_SaveToSpaceStoreRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SOURCE_TYPE = com.bytedance.lark.pb.basic.v1.Message.SourceType.TYPE_FROM_UNKONWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_id = this.message_id;
        r100.source_id = this.source_id;
        r100.source_type = this.source_type;
        r100.app_id = this.app_id;
        r100.app_file_id = this.app_file_id;
        r100.auth_extra = this.auth_extra;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SaveToSpaceStoreRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SaveToSpaceStoreRequest(String r100, String r110, com.bytedance.lark.pb.basic.v1.Message.SourceType r111, String r112, String r113, String r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public SaveToSpaceStoreRequest(String r100, String r101, com.bytedance.lark.pb.basic.v1.Message.SourceType r102, String r103, String r104, String r105, ByteString r106) {
        super(ADAPTER, r106);
        this.message_id = r100;
        this.source_id = r101;
        this.source_type = r102;
        this.app_id = r103;
        this.app_file_id = r104;
        this.auth_extra = r105;
    }
}
