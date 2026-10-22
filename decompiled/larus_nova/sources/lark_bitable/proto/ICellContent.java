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
public final class ICellContent extends Message<ICellContent, Builder> {
    public static final ProtoAdapter<ICellContent> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final AttachmentCellContent attachment_cell;
    public final ButtonCellContent button_cell;
    public final CheckBoxCellContent check_box_cell;
    public final FormulaCellContent formula_cell;
    public final LinkCellContent link_cell;
    public final TextCellContent multi_text;
    public final OptionCellContent option_cell;
    public final ProgressCellContent progress_cell;
    public final RatingCellContent rating_cell;
    public final StageCellContent stage_cell;
    public final UnSupportCellContent un_support_cell;
    public final UserCellContent user_cell;

    public static final class Builder extends Message.Builder<ICellContent, Builder> {
        public AttachmentCellContent attachment_cell;
        public ButtonCellContent button_cell;
        public CheckBoxCellContent check_box_cell;
        public FormulaCellContent formula_cell;
        public LinkCellContent link_cell;
        public TextCellContent multi_text;
        public OptionCellContent option_cell;
        public ProgressCellContent progress_cell;
        public RatingCellContent rating_cell;
        public StageCellContent stage_cell;
        public UnSupportCellContent un_support_cell;
        public UserCellContent user_cell;

        @Override // com.squareup.wire.Message.Builder
        public ICellContent build() {
            return new ICellContent(this.multi_text, this.option_cell, this.link_cell, this.button_cell, this.progress_cell, this.rating_cell, this.user_cell, this.check_box_cell, this.un_support_cell, this.attachment_cell, this.stage_cell, this.formula_cell, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder attachment_cell(AttachmentCellContent r100) {
            this.attachment_cell = r100;
            this.multi_text = null;
            this.option_cell = null;
            this.link_cell = null;
            this.button_cell = null;
            this.progress_cell = null;
            this.rating_cell = null;
            this.user_cell = null;
            this.check_box_cell = null;
            this.un_support_cell = null;
            this.stage_cell = null;
            this.formula_cell = null;
            return this;
        }

        public Builder button_cell(ButtonCellContent r100) {
            this.button_cell = r100;
            this.multi_text = null;
            this.option_cell = null;
            this.link_cell = null;
            this.progress_cell = null;
            this.rating_cell = null;
            this.user_cell = null;
            this.check_box_cell = null;
            this.un_support_cell = null;
            this.attachment_cell = null;
            this.stage_cell = null;
            this.formula_cell = null;
            return this;
        }

        public Builder check_box_cell(CheckBoxCellContent r100) {
            this.check_box_cell = r100;
            this.multi_text = null;
            this.option_cell = null;
            this.link_cell = null;
            this.button_cell = null;
            this.progress_cell = null;
            this.rating_cell = null;
            this.user_cell = null;
            this.un_support_cell = null;
            this.attachment_cell = null;
            this.stage_cell = null;
            this.formula_cell = null;
            return this;
        }

        public Builder formula_cell(FormulaCellContent r100) {
            this.formula_cell = r100;
            this.multi_text = null;
            this.option_cell = null;
            this.link_cell = null;
            this.button_cell = null;
            this.progress_cell = null;
            this.rating_cell = null;
            this.user_cell = null;
            this.check_box_cell = null;
            this.un_support_cell = null;
            this.attachment_cell = null;
            this.stage_cell = null;
            return this;
        }

        public Builder link_cell(LinkCellContent r100) {
            this.link_cell = r100;
            this.multi_text = null;
            this.option_cell = null;
            this.button_cell = null;
            this.progress_cell = null;
            this.rating_cell = null;
            this.user_cell = null;
            this.check_box_cell = null;
            this.un_support_cell = null;
            this.attachment_cell = null;
            this.stage_cell = null;
            this.formula_cell = null;
            return this;
        }

        public Builder multi_text(TextCellContent r100) {
            this.multi_text = r100;
            this.option_cell = null;
            this.link_cell = null;
            this.button_cell = null;
            this.progress_cell = null;
            this.rating_cell = null;
            this.user_cell = null;
            this.check_box_cell = null;
            this.un_support_cell = null;
            this.attachment_cell = null;
            this.stage_cell = null;
            this.formula_cell = null;
            return this;
        }

        public Builder option_cell(OptionCellContent r100) {
            this.option_cell = r100;
            this.multi_text = null;
            this.link_cell = null;
            this.button_cell = null;
            this.progress_cell = null;
            this.rating_cell = null;
            this.user_cell = null;
            this.check_box_cell = null;
            this.un_support_cell = null;
            this.attachment_cell = null;
            this.stage_cell = null;
            this.formula_cell = null;
            return this;
        }

        public Builder progress_cell(ProgressCellContent r100) {
            this.progress_cell = r100;
            this.multi_text = null;
            this.option_cell = null;
            this.link_cell = null;
            this.button_cell = null;
            this.rating_cell = null;
            this.user_cell = null;
            this.check_box_cell = null;
            this.un_support_cell = null;
            this.attachment_cell = null;
            this.stage_cell = null;
            this.formula_cell = null;
            return this;
        }

        public Builder rating_cell(RatingCellContent r100) {
            this.rating_cell = r100;
            this.multi_text = null;
            this.option_cell = null;
            this.link_cell = null;
            this.button_cell = null;
            this.progress_cell = null;
            this.user_cell = null;
            this.check_box_cell = null;
            this.un_support_cell = null;
            this.attachment_cell = null;
            this.stage_cell = null;
            this.formula_cell = null;
            return this;
        }

        public Builder stage_cell(StageCellContent r100) {
            this.stage_cell = r100;
            this.multi_text = null;
            this.option_cell = null;
            this.link_cell = null;
            this.button_cell = null;
            this.progress_cell = null;
            this.rating_cell = null;
            this.user_cell = null;
            this.check_box_cell = null;
            this.un_support_cell = null;
            this.attachment_cell = null;
            this.formula_cell = null;
            return this;
        }

        public Builder un_support_cell(UnSupportCellContent r100) {
            this.un_support_cell = r100;
            this.multi_text = null;
            this.option_cell = null;
            this.link_cell = null;
            this.button_cell = null;
            this.progress_cell = null;
            this.rating_cell = null;
            this.user_cell = null;
            this.check_box_cell = null;
            this.attachment_cell = null;
            this.stage_cell = null;
            this.formula_cell = null;
            return this;
        }

        public Builder user_cell(UserCellContent r100) {
            this.user_cell = r100;
            this.multi_text = null;
            this.option_cell = null;
            this.link_cell = null;
            this.button_cell = null;
            this.progress_cell = null;
            this.rating_cell = null;
            this.check_box_cell = null;
            this.un_support_cell = null;
            this.attachment_cell = null;
            this.stage_cell = null;
            this.formula_cell = null;
            return this;
        }
    }

    public static final class ProtoAdapter_ICellContent extends ProtoAdapter<ICellContent> {
        public ProtoAdapter_ICellContent() {
            super(FieldEncoding.LENGTH_DELIMITED, ICellContent.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public ICellContent decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                case 9: goto L10;
                case 10: goto L9;
                case 11: goto L8;
                case 12: goto L7;
                default: goto L6;
            };
        L7:
            r101.formula_cell(FormulaCellContent.ADAPTER.decode(r100));
            goto L3
        L8:
            r101.stage_cell(StageCellContent.ADAPTER.decode(r100));
            goto L3
        L9:
            r101.attachment_cell(AttachmentCellContent.ADAPTER.decode(r100));
            goto L3
        L10:
            r101.un_support_cell(UnSupportCellContent.ADAPTER.decode(r100));
            goto L3
        L11:
            r101.check_box_cell(CheckBoxCellContent.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.user_cell(UserCellContent.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.rating_cell(RatingCellContent.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.progress_cell(ProgressCellContent.ADAPTER.decode(r100));
            goto L3
        L15:
            r101.button_cell(ButtonCellContent.ADAPTER.decode(r100));
            goto L3
        L16:
            r101.link_cell(LinkCellContent.ADAPTER.decode(r100));
            goto L3
        L17:
            r101.option_cell(OptionCellContent.ADAPTER.decode(r100));
            goto L3
        L18:
            r101.multi_text(TextCellContent.ADAPTER.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ICellContent r100) {
            TextCellContent r101 = r100.multi_text;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = TextCellContent.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            OptionCellContent r104 = r100.option_cell;
            if (r104 == null) goto L9;
            int r105 = OptionCellContent.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            LinkCellContent r107 = r100.link_cell;
            if (r107 == null) goto L13;
            int r108 = LinkCellContent.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            ButtonCellContent r110 = r100.button_cell;
            if (r110 == null) goto L17;
            int r111 = ButtonCellContent.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            ProgressCellContent r113 = r100.progress_cell;
            if (r113 == null) goto L21;
            int r114 = ProgressCellContent.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            RatingCellContent r116 = r100.rating_cell;
            if (r116 == null) goto L25;
            int r117 = RatingCellContent.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            UserCellContent r119 = r100.user_cell;
            if (r119 == null) goto L29;
            int r120 = UserCellContent.ADAPTER.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            CheckBoxCellContent r122 = r100.check_box_cell;
            if (r122 == null) goto L33;
            int r123 = CheckBoxCellContent.ADAPTER.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            UnSupportCellContent r125 = r100.un_support_cell;
            if (r125 == null) goto L37;
            int r126 = UnSupportCellContent.ADAPTER.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            AttachmentCellContent r128 = r100.attachment_cell;
            if (r128 == null) goto L41;
            int r129 = AttachmentCellContent.ADAPTER.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            StageCellContent r131 = r100.stage_cell;
            if (r131 == null) goto L45;
            int r132 = StageCellContent.ADAPTER.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            FormulaCellContent r134 = r100.formula_cell;
            if (r134 == null) goto L50;
            r102 = FormulaCellContent.ADAPTER.encodedSizeWithTag(12, r134);
        L50:
            return (r133 + r102) + r100.unknownFields().size();
        L45:
            r132 = 0;
            goto L46
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
        public /* bridge */ /* synthetic */ ICellContent decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ICellContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ICellContent r101) throws IOException {
            TextCellContent r102 = r101.multi_text;
            if (r102 == null) goto L5;
            TextCellContent.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            OptionCellContent r103 = r101.option_cell;
            if (r103 == null) goto L8;
            OptionCellContent.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            LinkCellContent r104 = r101.link_cell;
            if (r104 == null) goto L11;
            LinkCellContent.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            ButtonCellContent r105 = r101.button_cell;
            if (r105 == null) goto L14;
            ButtonCellContent.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            ProgressCellContent r106 = r101.progress_cell;
            if (r106 == null) goto L17;
            ProgressCellContent.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            RatingCellContent r107 = r101.rating_cell;
            if (r107 == null) goto L20;
            RatingCellContent.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            UserCellContent r108 = r101.user_cell;
            if (r108 == null) goto L23;
            UserCellContent.ADAPTER.encodeWithTag(r100, 7, r108);
        L23:
            CheckBoxCellContent r109 = r101.check_box_cell;
            if (r109 == null) goto L26;
            CheckBoxCellContent.ADAPTER.encodeWithTag(r100, 8, r109);
        L26:
            UnSupportCellContent r110 = r101.un_support_cell;
            if (r110 == null) goto L29;
            UnSupportCellContent.ADAPTER.encodeWithTag(r100, 9, r110);
        L29:
            AttachmentCellContent r111 = r101.attachment_cell;
            if (r111 == null) goto L32;
            AttachmentCellContent.ADAPTER.encodeWithTag(r100, 10, r111);
        L32:
            StageCellContent r112 = r101.stage_cell;
            if (r112 == null) goto L35;
            StageCellContent.ADAPTER.encodeWithTag(r100, 11, r112);
        L35:
            FormulaCellContent r113 = r101.formula_cell;
            if (r113 == null) goto L38;
            FormulaCellContent.ADAPTER.encodeWithTag(r100, 12, r113);
        L38:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ICellContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ICellContent();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.multi_text = this.multi_text;
        r100.option_cell = this.option_cell;
        r100.link_cell = this.link_cell;
        r100.button_cell = this.button_cell;
        r100.progress_cell = this.progress_cell;
        r100.rating_cell = this.rating_cell;
        r100.user_cell = this.user_cell;
        r100.check_box_cell = this.check_box_cell;
        r100.un_support_cell = this.un_support_cell;
        r100.attachment_cell = this.attachment_cell;
        r100.stage_cell = this.stage_cell;
        r100.formula_cell = this.formula_cell;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ICellContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ICellContent(TextCellContent r110, OptionCellContent r111, LinkCellContent r112, ButtonCellContent r113, ProgressCellContent r114, RatingCellContent r210, UserCellContent r211, CheckBoxCellContent r212, UnSupportCellContent r213, AttachmentCellContent r214, StageCellContent r215, FormulaCellContent r216) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, ByteString.EMPTY);
    }

    public ICellContent(TextCellContent r100, OptionCellContent r101, LinkCellContent r102, ButtonCellContent r103, ProgressCellContent r104, RatingCellContent r105, UserCellContent r106, CheckBoxCellContent r110, UnSupportCellContent r111, AttachmentCellContent r112, StageCellContent r113, FormulaCellContent r114, ByteString r115) {
        super(ADAPTER, r115);
        if (Internal.countNonNull(r100, r101, r102, r103, new Object[]{r104, r105, r106, r110, r111, r112, r113, r114}) > 1) goto L7;
        this.multi_text = r100;
        this.option_cell = r101;
        this.link_cell = r102;
        this.button_cell = r103;
        this.progress_cell = r104;
        this.rating_cell = r105;
        this.user_cell = r106;
        this.check_box_cell = r110;
        this.un_support_cell = r111;
        this.attachment_cell = r112;
        this.stage_cell = r113;
        this.formula_cell = r114;
        return;
    L7:
        throw new IllegalArgumentException("at most one of multi_text, option_cell, link_cell, button_cell, progress_cell, rating_cell, user_cell, check_box_cell, un_support_cell, attachment_cell, stage_cell, formula_cell may be non-null");
    }
}
