package lark_bitable.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class RecordData extends Message<RecordData, Builder> {
    public static final ProtoAdapter<RecordData> ADAPTER = null;
    public static final String DEFAULT_COVER_FIELD_NAME = "";
    public static final ErrorContent DEFAULT_ERROR_UI = null;
    public static final Boolean DEFAULT_HAS_COVER_CONFIG = null;
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    public final List<AttachmentCellItem> cover;
    public final String cover_field_name;
    public final ErrorContent error_ui;
    public final Boolean has_cover_config;
    public final List<SubTitle> sub_titles;
    public final List<Tab> tabs;
    public final String title;

    public static final class Builder extends Message.Builder<RecordData, Builder> {
        public List<AttachmentCellItem> cover;
        public String cover_field_name;
        public ErrorContent error_ui;
        public Boolean has_cover_config;
        public List<SubTitle> sub_titles;
        public List<Tab> tabs;
        public String title;

        @Override // com.squareup.wire.Message.Builder
        public RecordData build() {
            String r100 = this.title;
            if (r100 == null) goto L13;
            if (this.has_cover_config == null) goto L13;
            if (this.cover_field_name == null) goto L13;
            if (this.error_ui == null) goto L13;
            return new RecordData(this.title, this.sub_titles, this.tabs, this.cover, this.has_cover_config, this.cover_field_name, this.error_ui, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "title", this.has_cover_config, "has_cover_config", this.cover_field_name, "cover_field_name", this.error_ui, "error_ui"});
        }

        public Builder() {
            this.sub_titles = Internal.newMutableList();
            this.tabs = Internal.newMutableList();
            this.cover = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cover(List<AttachmentCellItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.cover = r100;
            return this;
        }

        public Builder cover_field_name(String r100) {
            this.cover_field_name = r100;
            return this;
        }

        public Builder error_ui(ErrorContent r100) {
            this.error_ui = r100;
            return this;
        }

        public Builder has_cover_config(Boolean r100) {
            this.has_cover_config = r100;
            return this;
        }

        public Builder sub_titles(List<SubTitle> r100) {
            Internal.checkElementsNotNull(r100);
            this.sub_titles = r100;
            return this;
        }

        public Builder tabs(List<Tab> r100) {
            Internal.checkElementsNotNull(r100);
            this.tabs = r100;
            return this;
        }

        public Builder title(String r100) {
            this.title = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RecordData extends ProtoAdapter<RecordData> {
        public ProtoAdapter_RecordData() {
            super(FieldEncoding.LENGTH_DELIMITED, RecordData.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public RecordData decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L17;
            switch(r103) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L19;
                default: goto L6;
            };
        L19:
            r101.error_ui = ErrorContent.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.cover_field_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.has_cover_config = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.cover.add(AttachmentCellItem.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.tabs.add(Tab.ADAPTER.decode(r100));
            goto L3
        L15:
            r101.sub_titles.add(SubTitle.ADAPTER.decode(r100));
            goto L3
        L16:
            r101.title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(RecordData r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((((((r101.encodedSizeWithTag(1, r100.title) + SubTitle.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.sub_titles)) + Tab.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.tabs)) + AttachmentCellItem.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.cover)) + ProtoAdapter.BOOL.encodedSizeWithTag(5, r100.has_cover_config)) + r101.encodedSizeWithTag(6, r100.cover_field_name)) + ErrorContent.ADAPTER.encodedSizeWithTag(7, r100.error_ui)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RecordData decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RecordData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RecordData r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.title);
            SubTitle.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.sub_titles);
            Tab.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.tabs);
            AttachmentCellItem.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.cover);
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r101.has_cover_config);
            r102.encodeWithTag(r100, 6, r101.cover_field_name);
            ErrorContent.ADAPTER.encodeWithTag(r100, 7, r101.error_ui);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RecordData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RecordData();
        DEFAULT_HAS_COVER_CONFIG = Boolean.FALSE;
        DEFAULT_ERROR_UI = ErrorContent.VAR_ERROR_CONTENT_NO_PERMISSION;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.title = this.title;
        r100.sub_titles = Internal.copyOf("sub_titles", this.sub_titles);
        r100.tabs = Internal.copyOf("tabs", this.tabs);
        r100.cover = Internal.copyOf("cover", this.cover);
        r100.has_cover_config = this.has_cover_config;
        r100.cover_field_name = this.cover_field_name;
        r100.error_ui = this.error_ui;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RecordData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public RecordData(String r110, List<SubTitle> r111, List<Tab> r112, List<AttachmentCellItem> r113, Boolean r114, String r115, ErrorContent r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public RecordData(String r100, List<SubTitle> r101, List<Tab> r102, List<AttachmentCellItem> r103, Boolean r104, String r105, ErrorContent r106, ByteString r107) {
        super(ADAPTER, r107);
        this.title = r100;
        this.sub_titles = Internal.immutableCopyOf("sub_titles", r101);
        this.tabs = Internal.immutableCopyOf("tabs", r102);
        this.cover = Internal.immutableCopyOf("cover", r103);
        this.has_cover_config = r104;
        this.cover_field_name = r105;
        this.error_ui = r106;
    }
}
