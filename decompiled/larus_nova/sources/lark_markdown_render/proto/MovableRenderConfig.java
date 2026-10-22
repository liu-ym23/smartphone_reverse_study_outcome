package lark_markdown_render.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class MovableRenderConfig extends Message<MovableRenderConfig, Builder> {
    public static final ProtoAdapter<MovableRenderConfig> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, MovableRenderAtProperty> at_users;
    public final CodeBlockConfig code_block_config;
    public final DocumentConfig document_config;
    public final HeadingConfig heading_config;
    public final InlineCodeConfig inline_code_config;
    public final LinkConfig link_config;
    public final ListConfig list_config;
    public final TableConfig table_config;
    public final ThematicBreakConfig thematic_break_config;

    public static final class Builder extends Message.Builder<MovableRenderConfig, Builder> {
        public Map<String, MovableRenderAtProperty> at_users;
        public CodeBlockConfig code_block_config;
        public DocumentConfig document_config;
        public HeadingConfig heading_config;
        public InlineCodeConfig inline_code_config;
        public LinkConfig link_config;
        public ListConfig list_config;
        public TableConfig table_config;
        public ThematicBreakConfig thematic_break_config;

        @Override // com.squareup.wire.Message.Builder
        public MovableRenderConfig build() {
            return new MovableRenderConfig(this.document_config, this.heading_config, this.code_block_config, this.inline_code_config, this.thematic_break_config, this.list_config, this.table_config, this.link_config, this.at_users, super.buildUnknownFields());
        }

        public Builder() {
            this.at_users = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder at_users(Map<String, MovableRenderAtProperty> r100) {
            Internal.checkElementsNotNull(r100);
            this.at_users = r100;
            return this;
        }

        public Builder code_block_config(CodeBlockConfig r100) {
            this.code_block_config = r100;
            return this;
        }

        public Builder document_config(DocumentConfig r100) {
            this.document_config = r100;
            return this;
        }

        public Builder heading_config(HeadingConfig r100) {
            this.heading_config = r100;
            return this;
        }

        public Builder inline_code_config(InlineCodeConfig r100) {
            this.inline_code_config = r100;
            return this;
        }

        public Builder link_config(LinkConfig r100) {
            this.link_config = r100;
            return this;
        }

        public Builder list_config(ListConfig r100) {
            this.list_config = r100;
            return this;
        }

        public Builder table_config(TableConfig r100) {
            this.table_config = r100;
            return this;
        }

        public Builder thematic_break_config(ThematicBreakConfig r100) {
            this.thematic_break_config = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MovableRenderConfig extends ProtoAdapter<MovableRenderConfig> {
        private final ProtoAdapter<Map<String, MovableRenderAtProperty>> at_users;

        public ProtoAdapter_MovableRenderConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, MovableRenderConfig.class);
            this.at_users = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, MovableRenderAtProperty.ADAPTER);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public MovableRenderConfig decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L16;
            switch(r103) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r101.at_users.putAll(this.at_users.decode(r100));
            goto L3
        L8:
            r101.link_config = LinkConfig.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.table_config = TableConfig.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.list_config = ListConfig.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.thematic_break_config = ThematicBreakConfig.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.inline_code_config = InlineCodeConfig.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.code_block_config = CodeBlockConfig.ADAPTER.decode(r100);
            goto L3
        L14:
            r101.heading_config = HeadingConfig.ADAPTER.decode(r100);
            goto L3
        L15:
            r101.document_config = DocumentConfig.ADAPTER.decode(r100);
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
        public int encodedSize2(MovableRenderConfig r100) {
            DocumentConfig r101 = r100.document_config;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = DocumentConfig.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            HeadingConfig r104 = r100.heading_config;
            if (r104 == null) goto L9;
            int r105 = HeadingConfig.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            CodeBlockConfig r107 = r100.code_block_config;
            if (r107 == null) goto L13;
            int r108 = CodeBlockConfig.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            InlineCodeConfig r110 = r100.inline_code_config;
            if (r110 == null) goto L17;
            int r111 = InlineCodeConfig.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            ThematicBreakConfig r113 = r100.thematic_break_config;
            if (r113 == null) goto L21;
            int r114 = ThematicBreakConfig.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            ListConfig r116 = r100.list_config;
            if (r116 == null) goto L25;
            int r117 = ListConfig.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            TableConfig r119 = r100.table_config;
            if (r119 == null) goto L29;
            int r120 = TableConfig.ADAPTER.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            LinkConfig r122 = r100.link_config;
            if (r122 == null) goto L34;
            r102 = LinkConfig.ADAPTER.encodedSizeWithTag(8, r122);
        L34:
            return ((r121 + r102) + this.at_users.encodedSizeWithTag(9, r100.at_users)) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ MovableRenderConfig decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MovableRenderConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MovableRenderConfig r101) throws IOException {
            DocumentConfig r102 = r101.document_config;
            if (r102 == null) goto L5;
            DocumentConfig.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            HeadingConfig r103 = r101.heading_config;
            if (r103 == null) goto L8;
            HeadingConfig.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            CodeBlockConfig r104 = r101.code_block_config;
            if (r104 == null) goto L11;
            CodeBlockConfig.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            InlineCodeConfig r105 = r101.inline_code_config;
            if (r105 == null) goto L14;
            InlineCodeConfig.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            ThematicBreakConfig r106 = r101.thematic_break_config;
            if (r106 == null) goto L17;
            ThematicBreakConfig.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            ListConfig r107 = r101.list_config;
            if (r107 == null) goto L20;
            ListConfig.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            TableConfig r108 = r101.table_config;
            if (r108 == null) goto L23;
            TableConfig.ADAPTER.encodeWithTag(r100, 7, r108);
        L23:
            LinkConfig r109 = r101.link_config;
            if (r109 == null) goto L26;
            LinkConfig.ADAPTER.encodeWithTag(r100, 8, r109);
        L26:
            this.at_users.encodeWithTag(r100, 9, r101.at_users);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MovableRenderConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MovableRenderConfig();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.document_config = this.document_config;
        r100.heading_config = this.heading_config;
        r100.code_block_config = this.code_block_config;
        r100.inline_code_config = this.inline_code_config;
        r100.thematic_break_config = this.thematic_break_config;
        r100.list_config = this.list_config;
        r100.table_config = this.table_config;
        r100.link_config = this.link_config;
        r100.at_users = Internal.copyOf("at_users", this.at_users);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MovableRenderConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MovableRenderConfig(DocumentConfig r110, HeadingConfig r111, CodeBlockConfig r112, InlineCodeConfig r113, ThematicBreakConfig r114, ListConfig r115, TableConfig r116, LinkConfig r117, Map<String, MovableRenderAtProperty> r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public MovableRenderConfig(DocumentConfig r100, HeadingConfig r101, CodeBlockConfig r102, InlineCodeConfig r103, ThematicBreakConfig r104, ListConfig r105, TableConfig r106, LinkConfig r107, Map<String, MovableRenderAtProperty> r110, ByteString r111) {
        super(ADAPTER, r111);
        this.document_config = r100;
        this.heading_config = r101;
        this.code_block_config = r102;
        this.inline_code_config = r103;
        this.thematic_break_config = r104;
        this.list_config = r105;
        this.table_config = r106;
        this.link_config = r107;
        this.at_users = Internal.immutableCopyOf("at_users", r110);
    }
}
