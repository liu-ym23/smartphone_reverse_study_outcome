package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class CloudDraftContent extends com.squareup.wire.Message<CloudDraftContent, Builder> {
    public static final ProtoAdapter<CloudDraftContent> ADAPTER = null;
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    public final RichText rich_text;
    public final String title;

    public static final class Builder extends com.squareup.wire.Message.Builder<CloudDraftContent, Builder> {
        public RichText rich_text;
        public String title;

        @Override // com.squareup.wire.Message.Builder
        public CloudDraftContent build() {
            return new CloudDraftContent(this.title, this.rich_text, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder rich_text(RichText r100) {
            this.rich_text = r100;
            return this;
        }

        public Builder title(String r100) {
            this.title = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CloudDraftContent extends ProtoAdapter<CloudDraftContent> {
        public ProtoAdapter_CloudDraftContent() {
            super(FieldEncoding.LENGTH_DELIMITED, CloudDraftContent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CloudDraftContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.title = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.rich_text = RichText.ADAPTER.decode(r100);
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
        public int encodedSize2(CloudDraftContent r100) {
            String r101 = r100.title;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            RichText r104 = r100.rich_text;
            if (r104 == null) goto L10;
            r102 = RichText.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CloudDraftContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CloudDraftContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CloudDraftContent r101) throws IOException {
            String r102 = r101.title;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            RichText r103 = r101.rich_text;
            if (r103 == null) goto L8;
            RichText.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CloudDraftContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CloudDraftContent();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.title = this.title;
        r100.rich_text = this.rich_text;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CloudDraftContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public CloudDraftContent(String r100, RichText r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CloudDraftContent(String r100, RichText r101, ByteString r102) {
        super(ADAPTER, r102);
        this.title = r100;
        this.rich_text = r101;
    }
}
