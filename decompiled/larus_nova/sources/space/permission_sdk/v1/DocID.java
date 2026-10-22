package space.permission_sdk.v1;

import annotation.Debug;
import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final class DocID extends Message<DocID, Builder> {
    public static final ProtoAdapter<DocID> ADAPTER = null;
    public static final String DEFAULT_TOKEN = "";
    public static final DocumentType DEFAULT_TYPE = null;
    public static final FieldOptions FIELD_OPTIONS_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String token;
    public final DocumentType type;

    public static final class Builder extends Message.Builder<DocID, Builder> {
        public String token;
        public DocumentType type;

        @Override // com.squareup.wire.Message.Builder
        public DocID build() {
            String r100 = this.token;
            if (r100 == null) goto L9;
            if (this.type == null) goto L9;
            return new DocID(this.token, this.type, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "token", this.type, "type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }

        public Builder type(DocumentType r100) {
            this.type = r100;
            return this;
        }
    }

    public static final enum DocumentType extends Enum<DocumentType> implements WireEnum {
        private static final /* synthetic */ DocumentType[] $VALUES = null;
        public static final ProtoAdapter<DocumentType> ADAPTER = null;
        public static final DocumentType BASE_ADD = null;
        public static final DocumentType BITABLE = null;
        public static final DocumentType BITABLE_FORM = null;
        public static final DocumentType DOC = null;
        public static final DocumentType DOCX = null;
        public static final DocumentType DOCX_SYNC_BLOCK = null;
        public static final DocumentType DOCX_WHITE_BOARD = null;
        public static final DocumentType FILE = null;
        public static final DocumentType FOLDER = null;
        public static final DocumentType IM_FILE = null;
        public static final DocumentType MINDNOTE = null;
        public static final DocumentType MINUTES = null;
        public static final DocumentType OPEN_PLATFORM = null;
        public static final DocumentType SHEET = null;
        public static final DocumentType SLIDES = null;
        public static final DocumentType UNKNOWN = null;
        public static final DocumentType WIKI = null;
        public static final DocumentType WIKI_FOLDER = null;
        private final int value;

        static {
            DocumentType r100 = new DocumentType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            DocumentType r101 = new DocumentType("FOLDER", 1, 1);
            FOLDER = r101;
            DocumentType r102 = new DocumentType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 2, 2);
            DOC = r102;
            DocumentType r103 = new DocumentType("SHEET", 3, 3);
            SHEET = r103;
            DocumentType r104 = new DocumentType("BITABLE", 4, 4);
            BITABLE = r104;
            DocumentType r105 = new DocumentType("BASE_ADD", 5, 5);
            BASE_ADD = r105;
            DocumentType r110 = new DocumentType(PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE, 6, 6);
            MINDNOTE = r110;
            DocumentType r111 = new DocumentType("FILE", 7, 7);
            FILE = r111;
            DocumentType r112 = new DocumentType("SLIDES", 8, 8);
            SLIDES = r112;
            DocumentType r113 = new DocumentType("WIKI", 9, 9);
            WIKI = r113;
            DocumentType r114 = new DocumentType(PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, 10, 10);
            DOCX = r114;
            DocumentType r115 = new DocumentType("DOCX_WHITE_BOARD", 11, 11);
            DOCX_WHITE_BOARD = r115;
            DocumentType r106 = new DocumentType("MINUTES", 12, 12);
            MINUTES = r106;
            DocumentType r107 = new DocumentType("BITABLE_FORM", 13, 13);
            BITABLE_FORM = r107;
            DocumentType r108 = new DocumentType("WIKI_FOLDER", 14, 14);
            WIKI_FOLDER = r108;
            DocumentType r109 = new DocumentType("OPEN_PLATFORM", 15, 15);
            OPEN_PLATFORM = r109;
            DocumentType r116 = new DocumentType("IM_FILE", 16, 16);
            IM_FILE = r116;
            DocumentType r117 = new DocumentType("DOCX_SYNC_BLOCK", 17, 17);
            DOCX_SYNC_BLOCK = r117;
            $VALUES = new DocumentType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117};
            ADAPTER = ProtoAdapter.newEnumAdapter(DocumentType.class);
        }

        public static DocumentType[] values() {
            return (DocumentType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static DocumentType fromValue(int r100) {
            switch(r100) {
                case 0: goto L40;
                case 1: goto L38;
                case 2: goto L36;
                case 3: goto L34;
                case 4: goto L32;
                case 5: goto L30;
                case 6: goto L28;
                case 7: goto L26;
                case 8: goto L24;
                case 9: goto L22;
                case 10: goto L20;
                case 11: goto L18;
                case 12: goto L16;
                case 13: goto L14;
                case 14: goto L12;
                case 15: goto L10;
                case 16: goto L8;
                case 17: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return DOCX_SYNC_BLOCK;
        L8:
            return IM_FILE;
        L10:
            return OPEN_PLATFORM;
        L12:
            return WIKI_FOLDER;
        L14:
            return BITABLE_FORM;
        L16:
            return MINUTES;
        L18:
            return DOCX_WHITE_BOARD;
        L20:
            return DOCX;
        L22:
            return WIKI;
        L24:
            return SLIDES;
        L26:
            return FILE;
        L28:
            return MINDNOTE;
        L30:
            return BASE_ADD;
        L32:
            return BITABLE;
        L34:
            return SHEET;
        L36:
            return DOC;
        L38:
            return FOLDER;
        L40:
            return UNKNOWN;
        }

        public static DocumentType valueOf(String r100) {
            return (DocumentType) a.a(DocumentType.class, r100);
        }

        private DocumentType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_DocID extends ProtoAdapter<DocID> {
        public ProtoAdapter_DocID() {
            super(FieldEncoding.LENGTH_DELIMITED, DocID.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public DocID decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.token = "";
            r101.type = DocumentType.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.type = DocumentType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DocID r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.token) + DocumentType.ADAPTER.encodedSizeWithTag(2, r100.type)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DocID decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DocID r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DocID r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.token);
            DocumentType.ADAPTER.encodeWithTag(r100, 2, r101.type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DocID r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DocID();
        FIELD_OPTIONS_TYPE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_TYPE = DocumentType.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.token = this.token;
        r100.type = this.type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DocID.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DocID(String r100, DocumentType r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public DocID(String r100, DocumentType r101, ByteString r102) {
        super(ADAPTER, r102);
        this.token = r100;
        this.type = r101;
    }
}
