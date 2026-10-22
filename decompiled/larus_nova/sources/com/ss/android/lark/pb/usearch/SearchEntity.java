package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.DocType;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class SearchEntity extends Message<SearchEntity, Builder> {
    public static final ProtoAdapter<SearchEntity> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Props> mprops;

    public static final class Builder extends Message.Builder<SearchEntity, Builder> {
        public List<Props> mprops;

        @Override // com.squareup.wire.Message.Builder
        public SearchEntity build() {
            return new SearchEntity(this.mprops, super.buildUnknownFields());
        }

        public Builder() {
            this.mprops = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder props(List<Props> r100) {
            Internal.checkElementsNotNull(r100);
            this.mprops = r100;
            return this;
        }
    }

    public static final class ChatterMeta extends Message<ChatterMeta, Builder> {
        public static final ProtoAdapter<ChatterMeta> ADAPTER = null;
        public static final String DEFAULT_CHATTER_ID = "";
        public static final String DEFAULT_ENTERPRISE_MAIL_ADDRESS = "";
        private static final long serialVersionUID = 0;
        public final String mchatter_id;
        public final String menterprise_mail_address;

        public static final class Builder extends Message.Builder<ChatterMeta, Builder> {
            public String mchatter_id;
            public String menterprise_mail_address;

            @Override // com.squareup.wire.Message.Builder
            public ChatterMeta build() {
                return new ChatterMeta(this.menterprise_mail_address, this.mchatter_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder chatter_id(String r100) {
                this.mchatter_id = r100;
                return this;
            }

            public Builder enterprise_mail_address(String r100) {
                this.menterprise_mail_address = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ChatterMeta extends ProtoAdapter<ChatterMeta> {
            public ProtoAdapter_ChatterMeta() {
                super(FieldEncoding.LENGTH_DELIMITED, ChatterMeta.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ChatterMeta decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.menterprise_mail_address = "";
                r101.mchatter_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.menterprise_mail_address = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mchatter_id = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(ChatterMeta r100) {
                String r101 = r100.menterprise_mail_address;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.mchatter_id;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ChatterMeta decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ChatterMeta r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ChatterMeta r101) throws IOException {
                String r102 = r101.menterprise_mail_address;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.mchatter_id;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatterMeta r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ChatterMeta();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.menterprise_mail_address = this.menterprise_mail_address;
            r100.mchatter_id = this.mchatter_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ChatterMeta.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ChatterMeta(String r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public ChatterMeta(String r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.menterprise_mail_address = r100;
            this.mchatter_id = r101;
        }
    }

    public static final class DocFolderMeta extends Message<DocFolderMeta, Builder> {
        public static final ProtoAdapter<DocFolderMeta> ADAPTER = null;
        public static final Boolean DEFAULT_IS_SHARE_FOLDER = null;
        public static final Long DEFAULT_UPDATE_TIME = null;
        private static final long serialVersionUID = 0;
        public final Boolean mis_share_folder;
        public final DocType mtype;
        public final Long mupdate_time;

        public static final class Builder extends Message.Builder<DocFolderMeta, Builder> {
            public Boolean mis_share_folder;
            public DocType mtype;
            public Long mupdate_time;

            @Override // com.squareup.wire.Message.Builder
            public DocFolderMeta build() {
                return new DocFolderMeta(this.mupdate_time, this.mis_share_folder, this.mtype, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder is_share_folder(Boolean r100) {
                this.mis_share_folder = r100;
                return this;
            }

            public Builder type(DocType r100) {
                this.mtype = r100;
                return this;
            }

            public Builder update_time(Long r100) {
                this.mupdate_time = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DocFolderMeta extends ProtoAdapter<DocFolderMeta> {
            public ProtoAdapter_DocFolderMeta() {
                super(FieldEncoding.LENGTH_DELIMITED, DocFolderMeta.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DocFolderMeta decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mupdate_time = 0L;
                r101.mis_share_folder = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.mupdate_time = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mis_share_folder = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.mtype = DocType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DocFolderMeta r100) {
                Long r101 = r100.mupdate_time;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.mis_share_folder;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                DocType r107 = r100.mtype;
                if (r107 == null) goto L14;
                r102 = DocType.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                return (r106 + r102) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DocFolderMeta decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DocFolderMeta r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DocFolderMeta r101) throws IOException {
                Long r102 = r101.mupdate_time;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.mis_share_folder;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                DocType r104 = r101.mtype;
                if (r104 == null) goto L11;
                DocType.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DocFolderMeta r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DocFolderMeta();
            DEFAULT_UPDATE_TIME = 0L;
            DEFAULT_IS_SHARE_FOLDER = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mupdate_time = this.mupdate_time;
            r100.mis_share_folder = this.mis_share_folder;
            r100.mtype = this.mtype;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DocFolderMeta.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DocFolderMeta(Long r100, Boolean r101, DocType r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public DocFolderMeta(Long r100, Boolean r101, DocType r102, ByteString r103) {
            super(ADAPTER, r103);
            this.mupdate_time = r100;
            this.mis_share_folder = r101;
            this.mtype = r102;
        }
    }

    public static final class HistoryMeta extends Message<HistoryMeta, Builder> {
        public static final ProtoAdapter<HistoryMeta> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final ChatterMeta mchatter_meta;
        public final DocFolderMeta mdoc_folder_meta;

        public static final class Builder extends Message.Builder<HistoryMeta, Builder> {
            public ChatterMeta mchatter_meta;
            public DocFolderMeta mdoc_folder_meta;

            @Override // com.squareup.wire.Message.Builder
            public HistoryMeta build() {
                return new HistoryMeta(this.mdoc_folder_meta, this.mchatter_meta, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder chatter_meta(ChatterMeta r100) {
                this.mchatter_meta = r100;
                this.mdoc_folder_meta = null;
                return this;
            }

            public Builder doc_folder_meta(DocFolderMeta r100) {
                this.mdoc_folder_meta = r100;
                this.mchatter_meta = null;
                return this;
            }
        }

        public static final class ProtoAdapter_HistoryMeta extends ProtoAdapter<HistoryMeta> {
            public ProtoAdapter_HistoryMeta() {
                super(FieldEncoding.LENGTH_DELIMITED, HistoryMeta.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public HistoryMeta decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.doc_folder_meta(DocFolderMeta.ADAPTER.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.chatter_meta(ChatterMeta.ADAPTER.decode(r100));
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
            public int encodedSize2(HistoryMeta r100) {
                DocFolderMeta r101 = r100.mdoc_folder_meta;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = DocFolderMeta.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                ChatterMeta r104 = r100.mchatter_meta;
                if (r104 == null) goto L10;
                r102 = ChatterMeta.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ HistoryMeta decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(HistoryMeta r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, HistoryMeta r101) throws IOException {
                DocFolderMeta r102 = r101.mdoc_folder_meta;
                if (r102 == null) goto L5;
                DocFolderMeta.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                ChatterMeta r103 = r101.mchatter_meta;
                if (r103 == null) goto L8;
                ChatterMeta.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HistoryMeta r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_HistoryMeta();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mdoc_folder_meta = this.mdoc_folder_meta;
            r100.mchatter_meta = this.mchatter_meta;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return HistoryMeta.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public HistoryMeta(DocFolderMeta r100, ChatterMeta r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public HistoryMeta(DocFolderMeta r100, ChatterMeta r101, ByteString r102) {
            super(ADAPTER, r102);
            if (Internal.countNonNull(r100, r101) > 1) goto L7;
            this.mdoc_folder_meta = r100;
            this.mchatter_meta = r101;
            return;
        L7:
            throw new IllegalArgumentException("at most one of mdoc_folder_meta, mchatter_meta may be non-null");
        }
    }

    public static final class Props extends Message<Props, Builder> {
        public static final ProtoAdapter<Props> ADAPTER = null;
        public static final String DEFAULT_DESCRIPTION = "";
        public static final String DEFAULT_NAME = "";
        private static final long serialVersionUID = 0;
        public final String mdescription;
        public final HistoryMeta mmeta;
        public final String mname;

        public static final class Builder extends Message.Builder<Props, Builder> {
            public String mdescription;
            public HistoryMeta mmeta;
            public String mname;

            @Override // com.squareup.wire.Message.Builder
            public Props build() {
                return new Props(this.mname, this.mdescription, this.mmeta, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder description(String r100) {
                this.mdescription = r100;
                return this;
            }

            public Builder meta(HistoryMeta r100) {
                this.mmeta = r100;
                return this;
            }

            public Builder name(String r100) {
                this.mname = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Props extends ProtoAdapter<Props> {
            public ProtoAdapter_Props() {
                super(FieldEncoding.LENGTH_DELIMITED, Props.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Props decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mname = "";
                r101.mdescription = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.mname = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mdescription = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.mmeta = HistoryMeta.ADAPTER.decode(r100);
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
            public int encodedSize2(Props r100) {
                String r101 = r100.mname;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.mdescription;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                HistoryMeta r107 = r100.mmeta;
                if (r107 == null) goto L14;
                r102 = HistoryMeta.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                return (r106 + r102) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Props decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Props r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Props r101) throws IOException {
                String r102 = r101.mname;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.mdescription;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                HistoryMeta r104 = r101.mmeta;
                if (r104 == null) goto L11;
                HistoryMeta.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Props r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Props();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mname = this.mname;
            r100.mdescription = this.mdescription;
            r100.mmeta = this.mmeta;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Props.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Props(String r100, String r101, HistoryMeta r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public Props(String r100, String r101, HistoryMeta r102, ByteString r103) {
            super(ADAPTER, r103);
            this.mname = r100;
            this.mdescription = r101;
            this.mmeta = r102;
        }
    }

    public static final class ProtoAdapter_SearchEntity extends ProtoAdapter<SearchEntity> {
        public ProtoAdapter_SearchEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SearchEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mprops.add(Props.ADAPTER.decode(r100));
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
        public int encodedSize2(SearchEntity r100) {
            return Props.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mprops) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SearchEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SearchEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SearchEntity r101) throws IOException {
            Props.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mprops);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchEntity();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mprops = Internal.copyOf("mprops", this.mprops);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SearchEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SearchEntity(List<Props> r100) {
        this(r100, ByteString.EMPTY);
    }

    public SearchEntity(List<Props> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mprops = Internal.immutableCopyOf("mprops", r100);
    }
}
