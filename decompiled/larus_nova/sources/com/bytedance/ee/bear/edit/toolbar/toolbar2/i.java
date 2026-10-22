package com.bytedance.ee.bear.edit.toolbar.toolbar2;

import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarPrimaryItemId;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class i {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f226283a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f226284b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f226285c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f226286d = null;

        static {
            int[] r100 = new int[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.values().length];
            f226286d = r100;
            r100[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.indentLeft.ordinal()] = 1;     // Catch: NoSuchFieldError -> L46
        L99:
            f226286d[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.indentRight.ordinal()] = 2;     // Catch: NoSuchFieldError -> L47
        L117:
            f226286d[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.alignLeft.ordinal()] = 3;     // Catch: NoSuchFieldError -> L48
        L125:
            f226286d[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.alignCenter.ordinal()] = 4;     // Catch: NoSuchFieldError -> L49
        L131:
            f226286d[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.alignRight.ordinal()] = 5;     // Catch: NoSuchFieldError -> L50
        L83:
            f226286d[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.moveUp.ordinal()] = 6;     // Catch: NoSuchFieldError -> L51
        L87:
            f226286d[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.moveDown.ordinal()] = 7;     // Catch: NoSuchFieldError -> L52
        L16:
            int[] r101 = new int[ToolbarPrimaryItemId.TextTransformSecondaryItemId.values().length];
            f226285c = r101;
            r101[ToolbarPrimaryItemId.TextTransformSecondaryItemId.bold.ordinal()] = 1;     // Catch: NoSuchFieldError -> L53
        L113:
            f226285c[ToolbarPrimaryItemId.TextTransformSecondaryItemId.italic.ordinal()] = 2;     // Catch: NoSuchFieldError -> L54
        L135:
            f226285c[ToolbarPrimaryItemId.TextTransformSecondaryItemId.underline.ordinal()] = 3;     // Catch: NoSuchFieldError -> L55
        L143:
            f226285c[ToolbarPrimaryItemId.TextTransformSecondaryItemId.strikethrough.ordinal()] = 4;     // Catch: NoSuchFieldError -> L56
        L79:
            f226285c[ToolbarPrimaryItemId.TextTransformSecondaryItemId.highlight.ordinal()] = 5;     // Catch: NoSuchFieldError -> L57
        L89:
            f226285c[ToolbarPrimaryItemId.TextTransformSecondaryItemId.inlineCode.ordinal()] = 6;     // Catch: NoSuchFieldError -> L58
        L23:
            int[] r102 = new int[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.values().length];
            f226284b = r102;
            r102[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.plainText.ordinal()] = 1;     // Catch: NoSuchFieldError -> L59
        L123:
            f226284b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.f220264h1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L60
        L129:
            f226284b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.f220265h2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L61
        L139:
            f226284b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.f220266h3.ordinal()] = 4;     // Catch: NoSuchFieldError -> L62
        L93:
            f226284b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.f220267h4.ordinal()] = 5;     // Catch: NoSuchFieldError -> L63
        L101:
            f226284b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.f220268h5.ordinal()] = 6;     // Catch: NoSuchFieldError -> L64
        L103:
            f226284b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.f220269h6.ordinal()] = 7;     // Catch: NoSuchFieldError -> L65
        L121:
            f226284b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.f220270h7.ordinal()] = 8;     // Catch: NoSuchFieldError -> L66
        L127:
            f226284b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.f220271h8.ordinal()] = 9;     // Catch: NoSuchFieldError -> L67
        L81:
            f226284b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.f220272h9.ordinal()] = 10;     // Catch: NoSuchFieldError -> L68
        L85:
            f226284b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.checkbox.ordinal()] = 11;     // Catch: NoSuchFieldError -> L69
        L107:
            f226284b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.checkList.ordinal()] = 12;     // Catch: NoSuchFieldError -> L70
        L109:
            f226284b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.unorderedList.ordinal()] = 13;     // Catch: NoSuchFieldError -> L71
        L133:
            f226284b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.orderedList.ordinal()] = 14;     // Catch: NoSuchFieldError -> L72
        L137:
            f226284b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.codeList.ordinal()] = 15;     // Catch: NoSuchFieldError -> L73
        L91:
            f226284b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.blockQuote.ordinal()] = 16;     // Catch: NoSuchFieldError -> L74
        L97:
            f226284b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.insertSeparator.ordinal()] = 17;     // Catch: NoSuchFieldError -> L75
        L41:
            int[] r103 = new int[ToolbarPrimaryItemId.ListTransformSecondaryItemId.values().length];
            f226283a = r103;
            r103[ToolbarPrimaryItemId.ListTransformSecondaryItemId.noneList.ordinal()] = 1;     // Catch: NoSuchFieldError -> L76
        L119:
            f226283a[ToolbarPrimaryItemId.ListTransformSecondaryItemId.unorderedList.ordinal()] = 2;     // Catch: NoSuchFieldError -> L77
        L141:
            f226283a[ToolbarPrimaryItemId.ListTransformSecondaryItemId.orderedList.ordinal()] = 3;     // Catch: NoSuchFieldError -> L78
            return;
        }
    }

    public static int a(ItemIdV2 r100) {
        if ((r100 instanceof ToolbarPrimaryItemId.BlockTransformSecondaryItemId) == false) goto L24;
        switch(a.f226284b[((ToolbarPrimaryItemId.BlockTransformSecondaryItemId) r100).ordinal()]) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L12;
            case 11: goto L11;
            case 12: goto L11;
            case 13: goto L10;
            case 14: goto L61;
            case 15: goto L9;
            case 16: goto L8;
            case 17: goto L7;
            default: goto L6;
        };
    L6:
        return 0;
    L7:
        return R.drawable.ud_icon_divider_outlined;
    L8:
        return R.drawable.ud_icon_reference_outlined;
    L9:
        return R.drawable.ud_icon_codeblock_outlined;
    L10:
        return R.drawable.ud_icon_disorder_list_outlined;
    L11:
        return R.drawable.ud_icon_todo_outlined;
    L12:
        return R.drawable.ud_icon_h9_outlined;
    L13:
        return R.drawable.ud_icon_h8_outlined;
    L14:
        return R.drawable.ud_icon_h7_outlined;
    L15:
        return R.drawable.ud_icon_h6_outlined;
    L16:
        return R.drawable.ud_icon_h5_outlined;
    L17:
        return R.drawable.ud_icon_h4_outlined;
    L18:
        return R.drawable.ud_icon_h3_outlined;
    L19:
        return R.drawable.ud_icon_h2_outlined;
    L20:
        return R.drawable.ud_icon_h1_outlined;
    L21:
        return R.drawable.core_ic_svg_doc_plain_text_icon;
    L61:
        return R.drawable.ud_icon_order_list_outlined;
    L24:
        if ((r100 instanceof ToolbarPrimaryItemId.TextTransformSecondaryItemId) == false) goto L36;
        switch(a.f226285c[((ToolbarPrimaryItemId.TextTransformSecondaryItemId) r100).ordinal()]) {
            case 1: goto L33;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L30;
            case 5: goto L29;
            case 6: goto L28;
            default: goto L82;
        };
    L28:
        return R.drawable.ud_icon_code_outlined;
    L29:
        return R.drawable.ud_icon_fontcolor_outlined;
    L30:
        return R.drawable.ud_icon_horizontal_line_outlined;
    L31:
        return R.drawable.ud_icon_underline_outlined;
    L32:
        return R.drawable.ud_icon_italic_outlined;
    L33:
        return R.drawable.ud_icon_bold_outlined;
    L82:
        return 0;
    L36:
        if ((r100 instanceof ToolbarPrimaryItemId.AlignTransformSecondaryItemId) == false) goto L49;
        switch(a.f226286d[((ToolbarPrimaryItemId.AlignTransformSecondaryItemId) r100).ordinal()]) {
            case 1: goto L46;
            case 2: goto L45;
            case 3: goto L44;
            case 4: goto L43;
            case 5: goto L42;
            case 6: goto L41;
            case 7: goto L40;
            default: goto L89;
        };
    L40:
        return R.drawable.ud_icon_move_down_outlined;
    L41:
        return R.drawable.ud_icon_move_up_outlined;
    L42:
        return R.drawable.ud_icon_right_alignment_outlined;
    L43:
        return R.drawable.ud_icon_center_alignment_outlined;
    L44:
        return R.drawable.ud_icon_left_alignment_outlined;
    L45:
        return R.drawable.ud_icon_increase_indentation_outlined;
    L46:
        return R.drawable.ud_icon_reduce_indentation_outlined;
    L89:
        return 0;
    L49:
        if ((r100 instanceof ToolbarPrimaryItemId.ListTransformSecondaryItemId) == false) goto L60;
        int r101 = a.f226283a[((ToolbarPrimaryItemId.ListTransformSecondaryItemId) r100).ordinal()];
        if (r101 != 1) goto L53;
        return R.drawable.core_ic_svg_doc_plain_text_icon;
    L53:
        if (r101 != 2) goto L55;
        return R.drawable.ud_icon_disorder_list_outlined;
    L55:
        if (r101 == 3) goto L90;
        return 0;
    L90:
        return R.drawable.ud_icon_order_list_outlined;
    L60:
        return 0;
    }
}
