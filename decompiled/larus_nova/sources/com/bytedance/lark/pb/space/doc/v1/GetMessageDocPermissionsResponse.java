package com.bytedance.lark.pb.space.doc.v1;

import com.bytedance.lark.pb.basic.v1.DocPermission;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetMessageDocPermissionsResponse extends Message<GetMessageDocPermissionsResponse, Builder> {
    public static final ProtoAdapter<GetMessageDocPermissionsResponse> ADAPTER = null;
    public static final ProtoAdapter_GetMessageDocPermissionsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, DocPermission.Permission> message_id2permission;
    public final Map<String, PermissionInfo> message_id2permission_info;
    public final Map<String, PermissionListInfo> message_id2permission_list_info;

    public static final class Builder extends Message.Builder<GetMessageDocPermissionsResponse, Builder> implements d<GetMessageDocPermissionsResponse> {
        public Map<String, DocPermission.Permission> message_id2permission;
        public Map<String, PermissionInfo> message_id2permission_info;
        public Map<String, PermissionListInfo> message_id2permission_list_info;

        @Override // com.squareup.wire.Message.Builder
        public GetMessageDocPermissionsResponse build() {
            return new GetMessageDocPermissionsResponse(this.message_id2permission, this.message_id2permission_info, this.message_id2permission_list_info, super.buildUnknownFields());
        }

        public Builder() {
            this.message_id2permission = Internal.newMutableMap();
            this.message_id2permission_info = Internal.newMutableMap();
            this.message_id2permission_list_info = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder message_id2permission(Map<String, DocPermission.Permission> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_id2permission = r100;
            return this;
        }

        public Builder message_id2permission_info(Map<String, PermissionInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_id2permission_info = r100;
            return this;
        }

        public Builder message_id2permission_list_info(Map<String, PermissionListInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_id2permission_list_info = r100;
            return this;
        }
    }

    public static final class PermissionInfo extends Message<PermissionInfo, Builder> {
        public static final ProtoAdapter<PermissionInfo> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Map<String, DocPermission.Permission> doc_url2permission;

        public static final class Builder extends Message.Builder<PermissionInfo, Builder> {
            public Map<String, DocPermission.Permission> doc_url2permission;

            @Override // com.squareup.wire.Message.Builder
            public PermissionInfo build() {
                return new PermissionInfo(this.doc_url2permission, super.buildUnknownFields());
            }

            public Builder() {
                this.doc_url2permission = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder doc_url2permission(Map<String, DocPermission.Permission> r100) {
                Internal.checkElementsNotNull(r100);
                this.doc_url2permission = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_PermissionInfo extends ProtoAdapter<PermissionInfo> {
            private final ProtoAdapter<Map<String, DocPermission.Permission>> doc_url2permission;

            public ProtoAdapter_PermissionInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, PermissionInfo.class);
                this.doc_url2permission = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, DocPermission.Permission.ADAPTER);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PermissionInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.doc_url2permission.putAll(this.doc_url2permission.decode(r100));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(PermissionInfo r100) {
                return this.doc_url2permission.encodedSizeWithTag(1, r100.doc_url2permission) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ PermissionInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(PermissionInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, PermissionInfo r101) throws IOException {
                this.doc_url2permission.encodeWithTag(r100, 1, r101.doc_url2permission);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PermissionInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_PermissionInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.doc_url2permission = Internal.copyOf("doc_url2permission", this.doc_url2permission);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return PermissionInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public PermissionInfo(Map<String, DocPermission.Permission> r100) {
            this(r100, ByteString.EMPTY);
        }

        public PermissionInfo(Map<String, DocPermission.Permission> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.doc_url2permission = Internal.immutableCopyOf("doc_url2permission", r100);
        }
    }

    public static final class PermissionListInfo extends Message<PermissionListInfo, Builder> {
        public static final ProtoAdapter<PermissionListInfo> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Map<String, PermissionList> doc_url2permission_list;

        public static final class Builder extends Message.Builder<PermissionListInfo, Builder> {
            public Map<String, PermissionList> doc_url2permission_list;

            @Override // com.squareup.wire.Message.Builder
            public PermissionListInfo build() {
                return new PermissionListInfo(this.doc_url2permission_list, super.buildUnknownFields());
            }

            public Builder() {
                this.doc_url2permission_list = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder doc_url2permission_list(Map<String, PermissionList> r100) {
                Internal.checkElementsNotNull(r100);
                this.doc_url2permission_list = r100;
                return this;
            }
        }

        public static final class PermissionList extends Message<PermissionList, Builder> {
            public static final ProtoAdapter<PermissionList> ADAPTER = null;
            private static final long serialVersionUID = 0;
            public final List<DocPermission.Permission> permissions;

            public static final class Builder extends Message.Builder<PermissionList, Builder> {
                public List<DocPermission.Permission> permissions;

                @Override // com.squareup.wire.Message.Builder
                public PermissionList build() {
                    return new PermissionList(this.permissions, super.buildUnknownFields());
                }

                public Builder() {
                    this.permissions = Internal.newMutableList();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder permissions(List<DocPermission.Permission> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.permissions = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_PermissionList extends ProtoAdapter<PermissionList> {
                public ProtoAdapter_PermissionList() {
                    super(FieldEncoding.LENGTH_DELIMITED, PermissionList.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public PermissionList decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L9;
                    if (r103 != 1) goto L7;
                    r101.permissions.add(DocPermission.Permission.ADAPTER.decode(r100));
                    goto L3
                L7:
                    FieldEncoding r104 = r100.peekFieldEncoding();
                    r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                    goto L3
                L9:
                    r100.endMessage(r102);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(PermissionList r100) {
                    return DocPermission.Permission.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.permissions) + r100.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ PermissionList decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(PermissionList r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, PermissionList r101) throws IOException {
                    DocPermission.Permission.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.permissions);
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PermissionList r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_PermissionList();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.permissions = Internal.copyOf(ComplianceResult.JsonKey.PERMISSIONS, this.permissions);
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return PermissionList.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public PermissionList(List<DocPermission.Permission> r100) {
                this(r100, ByteString.EMPTY);
            }

            public PermissionList(List<DocPermission.Permission> r100, ByteString r101) {
                super(ADAPTER, r101);
                this.permissions = Internal.immutableCopyOf(ComplianceResult.JsonKey.PERMISSIONS, r100);
            }
        }

        public static final class ProtoAdapter_PermissionListInfo extends ProtoAdapter<PermissionListInfo> {
            private final ProtoAdapter<Map<String, PermissionList>> doc_url2permission_list;

            public ProtoAdapter_PermissionListInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, PermissionListInfo.class);
                this.doc_url2permission_list = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, PermissionList.ADAPTER);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PermissionListInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.doc_url2permission_list.putAll(this.doc_url2permission_list.decode(r100));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(PermissionListInfo r100) {
                return this.doc_url2permission_list.encodedSizeWithTag(1, r100.doc_url2permission_list) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ PermissionListInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(PermissionListInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, PermissionListInfo r101) throws IOException {
                this.doc_url2permission_list.encodeWithTag(r100, 1, r101.doc_url2permission_list);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PermissionListInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_PermissionListInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.doc_url2permission_list = Internal.copyOf("doc_url2permission_list", this.doc_url2permission_list);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return PermissionListInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public PermissionListInfo(Map<String, PermissionList> r100) {
            this(r100, ByteString.EMPTY);
        }

        public PermissionListInfo(Map<String, PermissionList> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.doc_url2permission_list = Internal.immutableCopyOf("doc_url2permission_list", r100);
        }
    }

    public static final class ProtoAdapter_GetMessageDocPermissionsResponse extends ProtoAdapter<GetMessageDocPermissionsResponse> implements c<GetMessageDocPermissionsResponse> {
        private final ProtoAdapter<Map<String, DocPermission.Permission>> message_id2permission;
        private final ProtoAdapter<Map<String, PermissionInfo>> message_id2permission_info;
        private final ProtoAdapter<Map<String, PermissionListInfo>> message_id2permission_list_info;

        public ProtoAdapter_GetMessageDocPermissionsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetMessageDocPermissionsResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.message_id2permission = ProtoAdapter.newMapAdapter(r100, DocPermission.Permission.ADAPTER);
            this.message_id2permission_info = ProtoAdapter.newMapAdapter(r100, PermissionInfo.ADAPTER);
            this.message_id2permission_list_info = ProtoAdapter.newMapAdapter(r100, PermissionListInfo.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetMessageDocPermissionsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.message_id2permission.putAll(this.message_id2permission.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.message_id2permission_info.putAll(this.message_id2permission_info.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.message_id2permission_list_info.putAll(this.message_id2permission_list_info.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetMessageDocPermissionsResponse r100) {
            return ((this.message_id2permission.encodedSizeWithTag(1, r100.message_id2permission) + this.message_id2permission_info.encodedSizeWithTag(2, r100.message_id2permission_info)) + this.message_id2permission_list_info.encodedSizeWithTag(3, r100.message_id2permission_list_info)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetMessageDocPermissionsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetMessageDocPermissionsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetMessageDocPermissionsResponse r101) throws IOException {
            this.message_id2permission.encodeWithTag(r100, 1, r101.message_id2permission);
            this.message_id2permission_info.encodeWithTag(r100, 2, r101.message_id2permission_info);
            this.message_id2permission_list_info.encodeWithTag(r100, 3, r101.message_id2permission_list_info);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetMessageDocPermissionsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetMessageDocPermissionsResponse r100 = new ProtoAdapter_GetMessageDocPermissionsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_id2permission = Internal.copyOf("message_id2permission", this.message_id2permission);
        r100.message_id2permission_info = Internal.copyOf("message_id2permission_info", this.message_id2permission_info);
        r100.message_id2permission_list_info = Internal.copyOf("message_id2permission_list_info", this.message_id2permission_list_info);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetMessageDocPermissionsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetMessageDocPermissionsResponse(Map<String, DocPermission.Permission> r100, Map<String, PermissionInfo> r101, Map<String, PermissionListInfo> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetMessageDocPermissionsResponse(Map<String, DocPermission.Permission> r100, Map<String, PermissionInfo> r101, Map<String, PermissionListInfo> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.message_id2permission = Internal.immutableCopyOf("message_id2permission", r100);
        this.message_id2permission_info = Internal.immutableCopyOf("message_id2permission_info", r101);
        this.message_id2permission_list_info = Internal.immutableCopyOf("message_id2permission_list_info", r102);
    }
}
