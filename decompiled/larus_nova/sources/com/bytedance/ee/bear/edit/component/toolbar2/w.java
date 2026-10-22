package com.bytedance.ee.bear.edit.component.toolbar2;

import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarPrimaryItemId;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class w {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f226199a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f226200b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f226201c = null;

        static {
            int[] r100 = new int[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.values().length];
            f226201c = r100;
            r100[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.indentLeft.ordinal()] = 1;     // Catch: NoSuchFieldError -> L39
        L83:
            f226201c[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.indentRight.ordinal()] = 2;     // Catch: NoSuchFieldError -> L40
        L99:
            f226201c[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.alignLeft.ordinal()] = 3;     // Catch: NoSuchFieldError -> L41
        L109:
            f226201c[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.alignCenter.ordinal()] = 4;     // Catch: NoSuchFieldError -> L42
        L113:
            f226201c[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.alignRight.ordinal()] = 5;     // Catch: NoSuchFieldError -> L43
        L12:
            int[] r101 = new int[ToolbarPrimaryItemId.TextTransformSecondaryItemId.values().length];
            f226200b = r101;
            r101[ToolbarPrimaryItemId.TextTransformSecondaryItemId.bold.ordinal()] = 1;     // Catch: NoSuchFieldError -> L44
        L87:
            f226200b[ToolbarPrimaryItemId.TextTransformSecondaryItemId.italic.ordinal()] = 2;     // Catch: NoSuchFieldError -> L45
        L93:
            f226200b[ToolbarPrimaryItemId.TextTransformSecondaryItemId.underline.ordinal()] = 3;     // Catch: NoSuchFieldError -> L46
        L95:
            f226200b[ToolbarPrimaryItemId.TextTransformSecondaryItemId.strikethrough.ordinal()] = 4;     // Catch: NoSuchFieldError -> L47
        L103:
            f226200b[ToolbarPrimaryItemId.TextTransformSecondaryItemId.highlight.ordinal()] = 5;     // Catch: NoSuchFieldError -> L48
        L121:
            f226200b[ToolbarPrimaryItemId.TextTransformSecondaryItemId.inlineCode.ordinal()] = 6;     // Catch: NoSuchFieldError -> L49
        L20:
            int[] r102 = new int[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.values().length];
            f226199a = r102;
            r102[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.plainText.ordinal()] = 1;     // Catch: NoSuchFieldError -> L50
        L81:
            f226199a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.f220264h1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L51
        L91:
            f226199a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.f220265h2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L52
        L107:
            f226199a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.f220266h3.ordinal()] = 4;     // Catch: NoSuchFieldError -> L53
        L115:
            f226199a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.f220267h4.ordinal()] = 5;     // Catch: NoSuchFieldError -> L54
        L117:
            f226199a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.f220268h5.ordinal()] = 6;     // Catch: NoSuchFieldError -> L55
        L73:
            f226199a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.f220269h6.ordinal()] = 7;     // Catch: NoSuchFieldError -> L56
        L79:
            f226199a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.f220270h7.ordinal()] = 8;     // Catch: NoSuchFieldError -> L57
        L97:
            f226199a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.f220271h8.ordinal()] = 9;     // Catch: NoSuchFieldError -> L58
        L101:
            f226199a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.f220272h9.ordinal()] = 10;     // Catch: NoSuchFieldError -> L59
        L119:
            f226199a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.checkbox.ordinal()] = 11;     // Catch: NoSuchFieldError -> L60
        L67:
            f226199a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.checkList.ordinal()] = 12;     // Catch: NoSuchFieldError -> L61
        L85:
            f226199a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.unorderedList.ordinal()] = 13;     // Catch: NoSuchFieldError -> L62
        L89:
            f226199a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.orderedList.ordinal()] = 14;     // Catch: NoSuchFieldError -> L63
        L105:
            f226199a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.codeList.ordinal()] = 15;     // Catch: NoSuchFieldError -> L64
        L111:
            f226199a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.blockQuote.ordinal()] = 16;     // Catch: NoSuchFieldError -> L65
        L71:
            f226199a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.insertSeparator.ordinal()] = 17;     // Catch: NoSuchFieldError -> L66
            return;
        }
    }

    public static int a(ItemIdV2 r100) {
        if ((r100 instanceof ToolbarPrimaryItemId.BlockTransformSecondaryItemId) == false) goto L25;
        switch(a.f226199a[((ToolbarPrimaryItemId.BlockTransformSecondaryItemId) r100).ordinal()]) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L13;
            case 11: goto L12;
            case 12: goto L12;
            case 13: goto L11;
            case 14: goto L10;
            case 15: goto L9;
            case 16: goto L8;
            case 17: goto L7;
            default: goto L70;
        };
    L7:
        return R.drawable.ud_icon_divider_outlined;
    L8:
        return R.drawable.ud_icon_reference_outlined;
    L9:
        return R.drawable.ud_icon_codeblock_outlined;
    L10:
        return R.drawable.ud_icon_order_list_outlined;
    L11:
        return R.drawable.ud_icon_disorder_list_outlined;
    L12:
        return R.drawable.ud_icon_todo_outlined;
    L13:
        return R.drawable.ud_icon_h9_outlined;
    L14:
        return R.drawable.ud_icon_h8_outlined;
    L15:
        return R.drawable.ud_icon_h7_outlined;
    L16:
        return R.drawable.ud_icon_h6_outlined;
    L17:
        return R.drawable.ud_icon_h5_outlined;
    L18:
        return R.drawable.ud_icon_h4_outlined;
    L19:
        return R.drawable.ud_icon_h3_outlined;
    L20:
        return R.drawable.ud_icon_h2_outlined;
    L21:
        return R.drawable.ud_icon_h1_outlined;
    L22:
        return R.drawable.ic_svg_doc_plain_text_icon;
    L70:
        return 0;
    L25:
        if ((r100 instanceof ToolbarPrimaryItemId.TextTransformSecondaryItemId) == false) goto L37;
        switch(a.f226200b[((ToolbarPrimaryItemId.TextTransformSecondaryItemId) r100).ordinal()]) {
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L30;
            case 6: goto L29;
            default: goto L76;
        };
    L29:
        return R.drawable.ud_icon_code_outlined;
    L30:
        return R.drawable.ud_icon_fontcolor_outlined;
    L31:
        return R.drawable.ud_icon_horizontal_line_outlined;
    L32:
        return R.drawable.ud_icon_underline_outlined;
    L33:
        return R.drawable.ud_icon_italic_outlined;
    L34:
        return R.drawable.ud_icon_bold_outlined;
    L76:
        return 0;
    L37:
        if ((r100 instanceof ToolbarPrimaryItemId.AlignTransformSecondaryItemId) == false) goto L77;
        int r101 = a.f226201c[((ToolbarPrimaryItemId.AlignTransformSecondaryItemId) r100).ordinal()];
        if (r101 != 1) goto L41;
        return R.drawable.ud_icon_reduce_indentation_outlined;
    L41:
        if (r101 != 2) goto L43;
        return R.drawable.ud_icon_increase_indentation_outlined;
    L43:
        if (r101 != 3) goto L45;
        return R.drawable.ud_icon_left_alignment_outlined;
    L45:
        if (r101 != 4) goto L47;
        return R.drawable.ud_icon_center_alignment_outlined;
    L47:
        if (r101 != 5) goto L82;
        return R.drawable.ud_icon_right_alignment_outlined;
    L82:
        return 0;
    L77:
        return 0;
    }
}
