package com.bytedance.lark.pb.search.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class WikiInfo extends Message<WikiInfo, Builder> {
    public static final ProtoAdapter<WikiInfo> ADAPTER = null;
    public static final Long DEFAULT_SPACE_ID = null;
    public static final String DEFAULT_SPACE_NAME = "";
    public static final String DEFAULT_URL = "";
    public static final String DEFAULT_WIKI_TOKEN = "";
    private static final long serialVersionUID = 0;
    public final Long space_id;
    public final String space_name;
    public final String url;
    public final String wiki_token;

    public static final class Builder extends Message.Builder<WikiInfo, Builder> {
        public Long space_id;
        public String space_name;
        public String url;
        public String wiki_token;

        @Override // com.squareup.wire.Message.Builder
        public WikiInfo build() {
            return new WikiInfo(this.wiki_token, this.space_id, this.space_name, this.url, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder space_id(Long r100) {
            this.space_id = r100;
            return this;
        }

        public Builder space_name(String r100) {
            this.space_name = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }

        public Builder wiki_token(String r100) {
            this.wiki_token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_WikiInfo extends ProtoAdapter<WikiInfo> {
        public ProtoAdapter_WikiInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, WikiInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public WikiInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.wiki_token = "";
            r101.space_id = 0L;
            r101.space_name = "";
            r101.url = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.wiki_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.space_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.space_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.url = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(WikiInfo r100) {
            String r101 = r100.wiki_token;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.space_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.space_name;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.url;
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
        public /* bridge */ /* synthetic */ WikiInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(WikiInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, WikiInfo r101) throws IOException {
            String r102 = r101.wiki_token;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.space_id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.space_name;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.url;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WikiInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_WikiInfo();
        DEFAULT_SPACE_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.wiki_token = this.wiki_token;
        r100.space_id = this.space_id;
        r100.space_name = this.space_name;
        r100.url = this.url;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return WikiInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public WikiInfo(String r100, Long r101, String r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public WikiInfo(String r100, Long r101, String r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.wiki_token = r100;
        this.space_id = r101;
        this.space_name = r102;
        this.url = r103;
    }
}
