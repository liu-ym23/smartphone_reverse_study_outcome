package com.ss.android.lark.pb.security_event;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class ObjectDetail extends Message<ObjectDetail, Builder> {
    public static final ProtoAdapter<ObjectDetail> ADAPTER = null;
    public static final String DEFAULT_CLONESOURCE = "";
    public static final String DEFAULT_CONTAINERID = "";
    public static final String DEFAULT_CURRENTPAGE = "";
    public static final String DEFAULT_FILENAME = "";
    public static final String DEFAULT_POSTID = "";
    public static final String DEFAULT_TEXTDETAIL = "";
    public static final String DEFAULT_THIRDPARTYAPPID = "";
    private static final long serialVersionUID = 0;
    public final String mCloneSource;
    public final String mContainerID;
    public final ContainerType mContainerType;
    public final String mCurrentPage;
    public final Document mDocument;
    public final String mFileName;
    public final List<String> mForwardIDs;
    public final List<String> mImageKeys;
    public final PermissionSettingType mPermissionSettingType;
    public final String mPostID;
    public final String mTextDetail;
    public final String mThirdPartyAppID;
    public final List<String> mVideoKeys;

    public static final class Builder extends Message.Builder<ObjectDetail, Builder> {
        public String mCloneSource;
        public String mContainerID;
        public ContainerType mContainerType;
        public String mCurrentPage;
        public Document mDocument;
        public String mFileName;
        public List<String> mForwardIDs;
        public List<String> mImageKeys;
        public PermissionSettingType mPermissionSettingType;
        public String mPostID;
        public String mTextDetail;
        public String mThirdPartyAppID;
        public List<String> mVideoKeys;

        @Override // com.squareup.wire.Message.Builder
        public ObjectDetail build() {
            return new ObjectDetail(this.mCloneSource, this.mTextDetail, this.mFileName, this.mThirdPartyAppID, this.mPermissionSettingType, this.mContainerType, this.mContainerID, this.mCurrentPage, this.mPostID, this.mForwardIDs, this.mImageKeys, this.mVideoKeys, this.mDocument, super.buildUnknownFields());
        }

        public Builder() {
            this.mForwardIDs = Internal.newMutableList();
            this.mImageKeys = Internal.newMutableList();
            this.mVideoKeys = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder CloneSource(String r100) {
            this.mCloneSource = r100;
            return this;
        }

        public Builder ContainerID(String r100) {
            this.mContainerID = r100;
            return this;
        }

        public Builder ContainerType(ContainerType r100) {
            this.mContainerType = r100;
            return this;
        }

        public Builder CurrentPage(String r100) {
            this.mCurrentPage = r100;
            return this;
        }

        public Builder Document(Document r100) {
            this.mDocument = r100;
            return this;
        }

        public Builder FileName(String r100) {
            this.mFileName = r100;
            return this;
        }

        public Builder ForwardIDs(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mForwardIDs = r100;
            return this;
        }

        public Builder ImageKeys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mImageKeys = r100;
            return this;
        }

        public Builder PermissionSettingType(PermissionSettingType r100) {
            this.mPermissionSettingType = r100;
            return this;
        }

        public Builder PostID(String r100) {
            this.mPostID = r100;
            return this;
        }

        public Builder TextDetail(String r100) {
            this.mTextDetail = r100;
            return this;
        }

        public Builder ThirdPartyAppID(String r100) {
            this.mThirdPartyAppID = r100;
            return this;
        }

        public Builder VideoKeys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mVideoKeys = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ObjectDetail extends ProtoAdapter<ObjectDetail> {
        public ProtoAdapter_ObjectDetail() {
            super(FieldEncoding.LENGTH_DELIMITED, ObjectDetail.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ObjectDetail decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mCloneSource = "";
            r101.mTextDetail = "";
            r101.mFileName = "";
            r101.mThirdPartyAppID = "";
            r101.mContainerID = "";
            r101.mCurrentPage = "";
            r101.mPostID = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L31;
            if (r103 != 31) goto L8;
            r101.mPostID = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 32) goto L9;
            r101.mForwardIDs.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L9:
            switch(r103) {
                case 1: goto L28;
                case 2: goto L27;
                case 3: goto L26;
                case 4: goto L25;
                case 5: goto L33;
                case 6: goto L35;
                case 7: goto L16;
                case 8: goto L15;
                default: goto L10;
            };
        L33:
            r101.mPermissionSettingType = PermissionSettingType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L35:
            r101.mContainerType = ContainerType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            r101.mCurrentPage = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.mContainerID = ProtoAdapter.STRING.decode(r100);
            goto L3
        L25:
            r101.mThirdPartyAppID = ProtoAdapter.STRING.decode(r100);
            goto L3
        L26:
            r101.mFileName = ProtoAdapter.STRING.decode(r100);
            goto L3
        L27:
            r101.mTextDetail = ProtoAdapter.STRING.decode(r100);
            goto L3
        L28:
            r101.mCloneSource = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            switch(r103) {
                case 9000002: goto L14;
                case 9000003: goto L13;
                case 9000004: goto L12;
                default: goto L11;
            };
        L12:
            r101.mDocument = Document.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.mVideoKeys.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L14:
            r101.mImageKeys.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L31:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ObjectDetail r100) {
            String r101 = r100.mCloneSource;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mTextDetail;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mFileName;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mThirdPartyAppID;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            PermissionSettingType r113 = r100.mPermissionSettingType;
            if (r113 == null) goto L21;
            int r114 = PermissionSettingType.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            ContainerType r116 = r100.mContainerType;
            if (r116 == null) goto L25;
            int r117 = ContainerType.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.mContainerID;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.mCurrentPage;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            String r125 = r100.mPostID;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.STRING.encodedSizeWithTag(31, r125);
        L38:
            int r127 = r124 + r126;
            ProtoAdapter<String> r128 = ProtoAdapter.STRING;
            int r129 = ((r127 + r128.asRepeated().encodedSizeWithTag(32, r100.mForwardIDs)) + r128.asRepeated().encodedSizeWithTag(9000002, r100.mImageKeys)) + r128.asRepeated().encodedSizeWithTag(9000003, r100.mVideoKeys);
            Document r130 = r100.mDocument;
            if (r130 == null) goto L42;
            r102 = Document.ADAPTER.encodedSizeWithTag(9000004, r130);
        L42:
            return (r129 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ ObjectDetail decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ObjectDetail r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ObjectDetail r101) throws IOException {
            String r102 = r101.mCloneSource;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mTextDetail;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mFileName;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mThirdPartyAppID;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            PermissionSettingType r106 = r101.mPermissionSettingType;
            if (r106 == null) goto L17;
            PermissionSettingType.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            ContainerType r107 = r101.mContainerType;
            if (r107 == null) goto L20;
            ContainerType.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.mContainerID;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.mCurrentPage;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            String r110 = r101.mPostID;
            if (r110 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r100, 31, r110);
        L29:
            ProtoAdapter<String> r111 = ProtoAdapter.STRING;
            r111.asRepeated().encodeWithTag(r100, 32, r101.mForwardIDs);
            r111.asRepeated().encodeWithTag(r100, 9000002, r101.mImageKeys);
            r111.asRepeated().encodeWithTag(r100, 9000003, r101.mVideoKeys);
            Document r112 = r101.mDocument;
            if (r112 == null) goto L32;
            Document.ADAPTER.encodeWithTag(r100, 9000004, r112);
        L32:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ObjectDetail r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ObjectDetail();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mCloneSource = this.mCloneSource;
        r100.mTextDetail = this.mTextDetail;
        r100.mFileName = this.mFileName;
        r100.mThirdPartyAppID = this.mThirdPartyAppID;
        r100.mPermissionSettingType = this.mPermissionSettingType;
        r100.mContainerType = this.mContainerType;
        r100.mContainerID = this.mContainerID;
        r100.mCurrentPage = this.mCurrentPage;
        r100.mPostID = this.mPostID;
        r100.mForwardIDs = Internal.copyOf("mForwardIDs", this.mForwardIDs);
        r100.mImageKeys = Internal.copyOf("mImageKeys", this.mImageKeys);
        r100.mVideoKeys = Internal.copyOf("mVideoKeys", this.mVideoKeys);
        r100.mDocument = this.mDocument;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ObjectDetail.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ObjectDetail(String r110, String r111, String r112, String r113, PermissionSettingType r210, ContainerType r211, String r212, String r213, String r214, List<String> r215, List<String> r216, List<String> r217, Document r218) {
        this(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218, ByteString.EMPTY);
    }

    public ObjectDetail(String r100, String r101, String r102, String r103, PermissionSettingType r104, ContainerType r105, String r106, String r107, String r110, List<String> r111, List<String> r112, List<String> r113, Document r114, ByteString r115) {
        super(ADAPTER, r115);
        this.mCloneSource = r100;
        this.mTextDetail = r101;
        this.mFileName = r102;
        this.mThirdPartyAppID = r103;
        this.mPermissionSettingType = r104;
        this.mContainerType = r105;
        this.mContainerID = r106;
        this.mCurrentPage = r107;
        this.mPostID = r110;
        this.mForwardIDs = Internal.immutableCopyOf("mForwardIDs", r111);
        this.mImageKeys = Internal.immutableCopyOf("mImageKeys", r112);
        this.mVideoKeys = Internal.immutableCopyOf("mVideoKeys", r113);
        this.mDocument = r114;
    }
}
