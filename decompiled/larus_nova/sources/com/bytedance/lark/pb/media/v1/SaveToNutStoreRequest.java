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
public final class SaveToNutStoreRequest extends Message<SaveToNutStoreRequest, Builder> {
    public static final ProtoAdapter<SaveToNutStoreRequest> ADAPTER = null;
    public static final String DEFAULT_FILE_KEY = "";
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final String DEFAULT_SOURCE_ID = "";
    public static final com.bytedance.lark.pb.basic.v1.Message.SourceType DEFAULT_SOURCE_TYPE = null;
    public static final ProtoAdapter_SaveToNutStoreRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String file_key;
    public final String message_id;
    public final String source_id;
    public final com.bytedance.lark.pb.basic.v1.Message.SourceType source_type;

    public static final class Builder extends Message.Builder<SaveToNutStoreRequest, Builder> implements d<SaveToNutStoreRequest> {
        public String file_key;
        public String message_id;
        public String source_id;
        public com.bytedance.lark.pb.basic.v1.Message.SourceType source_type;

        @Override // com.squareup.wire.Message.Builder
        public SaveToNutStoreRequest build() {
            String r100 = this.message_id;
            if (r100 == null) goto L7;
            return new SaveToNutStoreRequest(this.message_id, this.source_id, this.source_type, this.file_key, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, MusicAppletPage.KEY_MESSAGE_ID});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder file_key(String r100) {
            this.file_key = r100;
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

    public static final class ProtoAdapter_SaveToNutStoreRequest extends ProtoAdapter<SaveToNutStoreRequest> implements c<SaveToNutStoreRequest> {
        public ProtoAdapter_SaveToNutStoreRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SaveToNutStoreRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SaveToNutStoreRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_id = "";
            r101.source_id = "";
            r101.source_type = com.bytedance.lark.pb.basic.v1.Message.SourceType.TYPE_FROM_UNKONWN;
            r101.file_key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.source_type = com.bytedance.lark.pb.basic.v1.Message.SourceType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.file_key = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SaveToNutStoreRequest r100) {
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
            String r110 = r100.file_key;
            if (r110 == null) goto L14;
            r104 = r101.encodedSizeWithTag(4, r110);
        L14:
            return (r109 + r104) + r100.unknownFields().size();
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SaveToNutStoreRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SaveToNutStoreRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SaveToNutStoreRequest r101) throws IOException {
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
            String r105 = r101.file_key;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 4, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SaveToNutStoreRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SaveToNutStoreRequest r100 = new ProtoAdapter_SaveToNutStoreRequest();
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
        r100.file_key = this.file_key;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SaveToNutStoreRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SaveToNutStoreRequest(String r100, String r101, com.bytedance.lark.pb.basic.v1.Message.SourceType r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public SaveToNutStoreRequest(String r100, String r101, com.bytedance.lark.pb.basic.v1.Message.SourceType r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.message_id = r100;
        this.source_id = r101;
        this.source_type = r102;
        this.file_key = r103;
    }
}
