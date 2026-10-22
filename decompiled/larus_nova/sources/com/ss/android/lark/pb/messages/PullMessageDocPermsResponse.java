package com.ss.android.lark.pb.messages;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.DocPermission;
import com.ss.android.lark.pb.entities.DocType;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PullMessageDocPermsResponse extends Message<PullMessageDocPermsResponse, Builder> {
    public static final ProtoAdapter<PullMessageDocPermsResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<DocPerm> mdoc_perms;

    public static final class Builder extends Message.Builder<PullMessageDocPermsResponse, Builder> {
        public List<DocPerm> mdoc_perms;

        @Override // com.squareup.wire.Message.Builder
        public PullMessageDocPermsResponse build() {
            return new PullMessageDocPermsResponse(this.mdoc_perms, super.buildUnknownFields());
        }

        public Builder() {
            this.mdoc_perms = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder doc_perms(List<DocPerm> r100) {
            Internal.checkElementsNotNull(r100);
            this.mdoc_perms = r100;
            return this;
        }
    }

    public static final class DocPerm extends Message<DocPerm, Builder> {
        public static final ProtoAdapter<DocPerm> ADAPTER = null;
        public static final String DEFAULT_DOC_TITLE = "";
        public static final String DEFAULT_DOC_URL = "";
        public static final String DEFAULT_OWNER_NAME = "";
        private static final long serialVersionUID = 0;
        public final String mdoc_title;
        public final DocType mdoc_type;
        public final String mdoc_url;
        public final List<String> mmessage_ids;
        public final String mowner_name;
        public final List<DocPermission> mpermissions;

        public static final class Builder extends Message.Builder<DocPerm, Builder> {
            public String mdoc_title;
            public DocType mdoc_type;
            public String mdoc_url;
            public List<String> mmessage_ids;
            public String mowner_name;
            public List<DocPermission> mpermissions;

            @Override // com.squareup.wire.Message.Builder
            public DocPerm build() {
                return new DocPerm(this.mdoc_title, this.mdoc_type, this.mowner_name, this.mdoc_url, this.mpermissions, this.mmessage_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.mpermissions = Internal.newMutableList();
                this.mmessage_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder doc_title(String r100) {
                this.mdoc_title = r100;
                return this;
            }

            public Builder doc_type(DocType r100) {
                this.mdoc_type = r100;
                return this;
            }

            public Builder doc_url(String r100) {
                this.mdoc_url = r100;
                return this;
            }

            public Builder message_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.mmessage_ids = r100;
                return this;
            }

            public Builder owner_name(String r100) {
                this.mowner_name = r100;
                return this;
            }

            public Builder permissions(List<DocPermission> r100) {
                Internal.checkElementsNotNull(r100);
                this.mpermissions = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DocPerm extends ProtoAdapter<DocPerm> {
            public ProtoAdapter_DocPerm() {
                super(FieldEncoding.LENGTH_DELIMITED, DocPerm.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DocPerm decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mdoc_title = "";
                r101.mowner_name = "";
                r101.mdoc_url = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L16;
                switch(r103) {
                    case 1: goto L15;
                    case 2: goto L18;
                    case 3: goto L10;
                    case 4: goto L9;
                    case 5: goto L8;
                    case 6: goto L7;
                    default: goto L6;
                };
            L18:
                r101.mdoc_type = DocType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.mmessage_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L8:
                r101.mpermissions.add(DocPermission.ADAPTER.decode(r100));
                goto L3
            L9:
                r101.mdoc_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.mowner_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L15:
                r101.mdoc_title = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(DocPerm r100) {
                String r101 = r100.mdoc_title;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                DocType r104 = r100.mdoc_type;
                if (r104 == null) goto L9;
                int r105 = DocType.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.mowner_name;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.mdoc_url;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                return (((r109 + r102) + DocPermission.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.mpermissions)) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(6, r100.mmessage_ids)) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ DocPerm decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DocPerm r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DocPerm r101) throws IOException {
                String r102 = r101.mdoc_title;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                DocType r103 = r101.mdoc_type;
                if (r103 == null) goto L8;
                DocType.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.mowner_name;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.mdoc_url;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                DocPermission.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.mpermissions);
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 6, r101.mmessage_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DocPerm r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DocPerm();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mdoc_title = this.mdoc_title;
            r100.mdoc_type = this.mdoc_type;
            r100.mowner_name = this.mowner_name;
            r100.mdoc_url = this.mdoc_url;
            r100.mpermissions = Internal.copyOf("mpermissions", this.mpermissions);
            r100.mmessage_ids = Internal.copyOf("mmessage_ids", this.mmessage_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DocPerm.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DocPerm(String r100, DocType r110, String r111, String r112, List<DocPermission> r113, List<String> r114) {
            this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
        }

        public DocPerm(String r100, DocType r101, String r102, String r103, List<DocPermission> r104, List<String> r105, ByteString r106) {
            super(ADAPTER, r106);
            this.mdoc_title = r100;
            this.mdoc_type = r101;
            this.mowner_name = r102;
            this.mdoc_url = r103;
            this.mpermissions = Internal.immutableCopyOf("mpermissions", r104);
            this.mmessage_ids = Internal.immutableCopyOf("mmessage_ids", r105);
        }
    }

    public static final class ProtoAdapter_PullMessageDocPermsResponse extends ProtoAdapter<PullMessageDocPermsResponse> {
        public ProtoAdapter_PullMessageDocPermsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullMessageDocPermsResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullMessageDocPermsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mdoc_perms.add(DocPerm.ADAPTER.decode(r100));
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
        public int encodedSize2(PullMessageDocPermsResponse r100) {
            return DocPerm.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mdoc_perms) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullMessageDocPermsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullMessageDocPermsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullMessageDocPermsResponse r101) throws IOException {
            DocPerm.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mdoc_perms);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullMessageDocPermsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullMessageDocPermsResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mdoc_perms = Internal.copyOf("mdoc_perms", this.mdoc_perms);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullMessageDocPermsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullMessageDocPermsResponse(List<DocPerm> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PullMessageDocPermsResponse(List<DocPerm> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mdoc_perms = Internal.immutableCopyOf("mdoc_perms", r100);
    }
}
