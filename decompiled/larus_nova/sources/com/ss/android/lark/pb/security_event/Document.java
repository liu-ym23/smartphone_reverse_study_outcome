package com.ss.android.lark.pb.security_event;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class Document extends Message<Document, Builder> {
    public static final ProtoAdapter<Document> ADAPTER = null;
    public static final String DEFAULT_FOLDERID = "";
    public static final String DEFAULT_FOLDERNAME = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_TENANTID = "";
    public static final String DEFAULT_TITLE = "";
    public static final String DEFAULT_WIKIID = "";
    public static final String DEFAULT_WIKINAME = "";
    public static final String DEFAULT_WIKITOKEN = "";
    private static final long serialVersionUID = 0;
    public final DocSecLabel mDocSecLabel;
    public final String mFolderID;
    public final String mFolderName;
    public final String mID;
    public final User mOwner;
    public final String mTenantID;
    public final String mTitle;
    public final EntityType mType;
    public final String mWikiID;
    public final String mWikiName;
    public final String mWikiToken;

    public static final class Builder extends Message.Builder<Document, Builder> {
        public DocSecLabel mDocSecLabel;
        public String mFolderID;
        public String mFolderName;
        public String mID;
        public User mOwner;
        public String mTenantID;
        public String mTitle;
        public EntityType mType;
        public String mWikiID;
        public String mWikiName;
        public String mWikiToken;

        @Override // com.squareup.wire.Message.Builder
        public Document build() {
            return new Document(this.mID, this.mType, this.mTitle, this.mOwner, this.mDocSecLabel, this.mWikiToken, this.mTenantID, this.mFolderID, this.mFolderName, this.mWikiID, this.mWikiName, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder DocSecLabel(DocSecLabel r100) {
            this.mDocSecLabel = r100;
            return this;
        }

        public Builder FolderID(String r100) {
            this.mFolderID = r100;
            return this;
        }

        public Builder FolderName(String r100) {
            this.mFolderName = r100;
            return this;
        }

        public Builder ID(String r100) {
            this.mID = r100;
            return this;
        }

        public Builder Owner(User r100) {
            this.mOwner = r100;
            return this;
        }

        public Builder TenantID(String r100) {
            this.mTenantID = r100;
            return this;
        }

        public Builder Title(String r100) {
            this.mTitle = r100;
            return this;
        }

        public Builder Type(EntityType r100) {
            this.mType = r100;
            return this;
        }

        public Builder WikiID(String r100) {
            this.mWikiID = r100;
            return this;
        }

        public Builder WikiName(String r100) {
            this.mWikiName = r100;
            return this;
        }

        public Builder WikiToken(String r100) {
            this.mWikiToken = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Document extends ProtoAdapter<Document> {
        public ProtoAdapter_Document() {
            super(FieldEncoding.LENGTH_DELIMITED, Document.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Document decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mID = "";
            r101.mTitle = "";
            r101.mWikiToken = "";
            r101.mTenantID = "";
            r101.mFolderID = "";
            r101.mFolderName = "";
            r101.mWikiID = "";
            r101.mWikiName = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            switch(r103) {
                case 1: goto L20;
                case 2: goto L23;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L23:
            r101.mType = EntityType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mWikiName = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.mWikiID = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.mFolderName = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.mFolderID = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.mTenantID = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.mWikiToken = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.mDocSecLabel = DocSecLabel.ADAPTER.decode(r100);
            goto L3
        L14:
            r101.mOwner = User.ADAPTER.decode(r100);
            goto L3
        L15:
            r101.mTitle = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.mID = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Document r100) {
            String r101 = r100.mID;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            EntityType r104 = r100.mType;
            if (r104 == null) goto L9;
            int r105 = EntityType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mTitle;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            User r110 = r100.mOwner;
            if (r110 == null) goto L17;
            int r111 = User.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            DocSecLabel r113 = r100.mDocSecLabel;
            if (r113 == null) goto L21;
            int r114 = DocSecLabel.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.mWikiToken;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.mTenantID;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.mFolderID;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            String r125 = r100.mFolderName;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.STRING.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            String r128 = r100.mWikiID;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.STRING.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            String r131 = r100.mWikiName;
            if (r131 == null) goto L46;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(11, r131);
        L46:
            return (r130 + r102) + r100.unknownFields().size();
        L41:
            r129 = 0;
            goto L42
        L37:
            r126 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
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
        public /* bridge */ /* synthetic */ Document decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Document r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Document r101) throws IOException {
            String r102 = r101.mID;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            EntityType r103 = r101.mType;
            if (r103 == null) goto L8;
            EntityType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mTitle;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            User r105 = r101.mOwner;
            if (r105 == null) goto L14;
            User.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            DocSecLabel r106 = r101.mDocSecLabel;
            if (r106 == null) goto L17;
            DocSecLabel.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.mWikiToken;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.mTenantID;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.mFolderID;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            String r110 = r101.mFolderName;
            if (r110 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r110);
        L29:
            String r111 = r101.mWikiID;
            if (r111 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r100, 10, r111);
        L32:
            String r112 = r101.mWikiName;
            if (r112 == null) goto L35;
            ProtoAdapter.STRING.encodeWithTag(r100, 11, r112);
        L35:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Document r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Document();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mID = this.mID;
        r100.mType = this.mType;
        r100.mTitle = this.mTitle;
        r100.mOwner = this.mOwner;
        r100.mDocSecLabel = this.mDocSecLabel;
        r100.mWikiToken = this.mWikiToken;
        r100.mTenantID = this.mTenantID;
        r100.mFolderID = this.mFolderID;
        r100.mFolderName = this.mFolderName;
        r100.mWikiID = this.mWikiID;
        r100.mWikiName = this.mWikiName;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Document.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Document(String r110, EntityType r111, String r112, User r113, DocSecLabel r114, String r115, String r210, String r211, String r212, String r213, String r214) {
        this(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, ByteString.EMPTY);
    }

    public Document(String r100, EntityType r101, String r102, User r103, DocSecLabel r104, String r105, String r106, String r107, String r110, String r111, String r112, ByteString r113) {
        super(ADAPTER, r113);
        this.mID = r100;
        this.mType = r101;
        this.mTitle = r102;
        this.mOwner = r103;
        this.mDocSecLabel = r104;
        this.mWikiToken = r105;
        this.mTenantID = r106;
        this.mFolderID = r107;
        this.mFolderName = r110;
        this.mWikiID = r111;
        this.mWikiName = r112;
    }
}
