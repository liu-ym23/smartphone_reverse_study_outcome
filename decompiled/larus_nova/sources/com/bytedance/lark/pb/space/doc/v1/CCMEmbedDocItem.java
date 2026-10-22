package com.bytedance.lark.pb.space.doc.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class CCMEmbedDocItem extends Message<CCMEmbedDocItem, Builder> {
    public static final ProtoAdapter<CCMEmbedDocItem> ADAPTER = null;
    public static final Integer DEFAULT_FILE_TYPE = null;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    public final Integer file_type;
    public final String token;

    public static final class Builder extends Message.Builder<CCMEmbedDocItem, Builder> {
        public Integer file_type;
        public String token;

        @Override // com.squareup.wire.Message.Builder
        public CCMEmbedDocItem build() {
            String r100 = this.token;
            if (r100 == null) goto L9;
            if (this.file_type == null) goto L9;
            return new CCMEmbedDocItem(this.token, this.file_type, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "token", this.file_type, "file_type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder file_type(Integer r100) {
            this.file_type = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CCMEmbedDocItem extends ProtoAdapter<CCMEmbedDocItem> {
        public ProtoAdapter_CCMEmbedDocItem() {
            super(FieldEncoding.LENGTH_DELIMITED, CCMEmbedDocItem.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CCMEmbedDocItem decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.token = "";
            r101.file_type = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.file_type = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(CCMEmbedDocItem r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.token) + ProtoAdapter.INT32.encodedSizeWithTag(2, r100.file_type)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CCMEmbedDocItem decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CCMEmbedDocItem r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CCMEmbedDocItem r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.token);
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r101.file_type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CCMEmbedDocItem r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CCMEmbedDocItem();
        DEFAULT_FILE_TYPE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.token = this.token;
        r100.file_type = this.file_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CCMEmbedDocItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CCMEmbedDocItem(String r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CCMEmbedDocItem(String r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.token = r100;
        this.file_type = r101;
    }
}
