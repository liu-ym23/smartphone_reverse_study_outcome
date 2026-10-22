package lark_bitable.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class RecordItem extends Message<RecordItem, Builder> {
    public static final ProtoAdapter<RecordItem> ADAPTER = null;
    public static final ModelAction DEFAULT_ACTION = null;
    public static final Boolean DEFAULT_EDITABLE = null;
    public static final String DEFAULT_ITEM_ICON = "";
    public static final String DEFAULT_ITEM_NAME = "";
    public static final String DEFAULT_ITEM_UI_TYPE = "";
    private static final long serialVersionUID = 0;
    public final ModelAction action;
    public final Boolean editable;
    public final ICellContent item_content;
    public final String item_icon;
    public final String item_name;
    public final String item_ui_type;

    public static final class Builder extends Message.Builder<RecordItem, Builder> {
        public ModelAction action;
        public Boolean editable;
        public ICellContent item_content;
        public String item_icon;
        public String item_name;
        public String item_ui_type;

        @Override // com.squareup.wire.Message.Builder
        public RecordItem build() {
            String r100 = this.item_icon;
            if (r100 == null) goto L15;
            if (this.item_name == null) goto L15;
            if (this.item_ui_type == null) goto L15;
            if (this.editable == null) goto L15;
            if (this.item_content == null) goto L15;
            return new RecordItem(this.item_icon, this.item_name, this.item_ui_type, this.editable, this.action, this.item_content, super.buildUnknownFields());
        L15:
            throw Internal.missingRequiredFields(new Object[]{r100, "item_icon", this.item_name, "item_name", this.item_ui_type, "item_ui_type", this.editable, "editable", this.item_content, "item_content"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action(ModelAction r100) {
            this.action = r100;
            return this;
        }

        public Builder editable(Boolean r100) {
            this.editable = r100;
            return this;
        }

        public Builder item_content(ICellContent r100) {
            this.item_content = r100;
            return this;
        }

        public Builder item_icon(String r100) {
            this.item_icon = r100;
            return this;
        }

        public Builder item_name(String r100) {
            this.item_name = r100;
            return this;
        }

        public Builder item_ui_type(String r100) {
            this.item_ui_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RecordItem extends ProtoAdapter<RecordItem> {
        public ProtoAdapter_RecordItem() {
            super(FieldEncoding.LENGTH_DELIMITED, RecordItem.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public RecordItem decode2(ProtoReader r100) throws IOException {
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
                case 5: goto L18;
                case 6: goto L7;
                default: goto L6;
            };
        L18:
            r101.action = ModelAction.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.item_content = ICellContent.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.editable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.item_ui_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.item_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.item_icon = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(RecordItem r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = ((r101.encodedSizeWithTag(1, r100.item_icon) + r101.encodedSizeWithTag(2, r100.item_name)) + r101.encodedSizeWithTag(3, r100.item_ui_type)) + ProtoAdapter.BOOL.encodedSizeWithTag(4, r100.editable);
            ModelAction r103 = r100.action;
            if (r103 == null) goto L5;
            int r104 = ModelAction.ADAPTER.encodedSizeWithTag(5, r103);
        L7:
            return ((r102 + r104) + ICellContent.ADAPTER.encodedSizeWithTag(6, r100.item_content)) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RecordItem decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RecordItem r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RecordItem r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.item_icon);
            r102.encodeWithTag(r100, 2, r101.item_name);
            r102.encodeWithTag(r100, 3, r101.item_ui_type);
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r101.editable);
            ModelAction r103 = r101.action;
            if (r103 == null) goto L5;
            ModelAction.ADAPTER.encodeWithTag(r100, 5, r103);
        L5:
            ICellContent.ADAPTER.encodeWithTag(r100, 6, r101.item_content);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RecordItem r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RecordItem();
        DEFAULT_EDITABLE = Boolean.FALSE;
        DEFAULT_ACTION = ModelAction.VAR_MODEL_ACTION_JUMP_PAGE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.item_icon = this.item_icon;
        r100.item_name = this.item_name;
        r100.item_ui_type = this.item_ui_type;
        r100.editable = this.editable;
        r100.action = this.action;
        r100.item_content = this.item_content;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RecordItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public RecordItem(String r100, String r110, String r111, Boolean r112, ModelAction r113, ICellContent r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public RecordItem(String r100, String r101, String r102, Boolean r103, ModelAction r104, ICellContent r105, ByteString r106) {
        super(ADAPTER, r106);
        this.item_icon = r100;
        this.item_name = r101;
        this.item_ui_type = r102;
        this.editable = r103;
        this.action = r104;
        this.item_content = r105;
    }
}
