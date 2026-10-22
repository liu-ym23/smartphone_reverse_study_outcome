package com.bytedance.ee.bear.edit.toolbar.toolbar2;

import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarPrimaryItemId;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;
        public static final /* synthetic */ int[] d = null;

        static {
            int[] r0 = new int[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.values().length];
            d = r0;
            r0[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.indentLeft.ordinal()] = 1;     // Catch: NoSuchFieldError -> L46
        L99:
            d[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.indentRight.ordinal()] = 2;     // Catch: NoSuchFieldError -> L47
        L117:
            d[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.alignLeft.ordinal()] = 3;     // Catch: NoSuchFieldError -> L48
        L125:
            d[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.alignCenter.ordinal()] = 4;     // Catch: NoSuchFieldError -> L49
        L131:
            d[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.alignRight.ordinal()] = 5;     // Catch: NoSuchFieldError -> L50
        L83:
            d[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.moveUp.ordinal()] = 6;     // Catch: NoSuchFieldError -> L51
        L87:
            d[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.moveDown.ordinal()] = 7;     // Catch: NoSuchFieldError -> L52
        L16:
            int[] r7 = new int[ToolbarPrimaryItemId.TextTransformSecondaryItemId.values().length];
            c = r7;
            r7[ToolbarPrimaryItemId.TextTransformSecondaryItemId.bold.ordinal()] = 1;     // Catch: NoSuchFieldError -> L53
        L113:
            c[ToolbarPrimaryItemId.TextTransformSecondaryItemId.italic.ordinal()] = 2;     // Catch: NoSuchFieldError -> L54
        L135:
            c[ToolbarPrimaryItemId.TextTransformSecondaryItemId.underline.ordinal()] = 3;     // Catch: NoSuchFieldError -> L55
        L143:
            c[ToolbarPrimaryItemId.TextTransformSecondaryItemId.strikethrough.ordinal()] = 4;     // Catch: NoSuchFieldError -> L56
        L79:
            c[ToolbarPrimaryItemId.TextTransformSecondaryItemId.highlight.ordinal()] = 5;     // Catch: NoSuchFieldError -> L57
        L89:
            c[ToolbarPrimaryItemId.TextTransformSecondaryItemId.inlineCode.ordinal()] = 6;     // Catch: NoSuchFieldError -> L58
        L23:
            int[] r8 = new int[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.values().length];
            b = r8;
            r8[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.plainText.ordinal()] = 1;     // Catch: NoSuchFieldError -> L59
        L123:
            b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.h1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L60
        L129:
            b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.h2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L61
        L139:
            b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.h3.ordinal()] = 4;     // Catch: NoSuchFieldError -> L62
        L93:
            b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.h4.ordinal()] = 5;     // Catch: NoSuchFieldError -> L63
        L101:
            b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.h5.ordinal()] = 6;     // Catch: NoSuchFieldError -> L64
        L103:
            b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.h6.ordinal()] = 7;     // Catch: NoSuchFieldError -> L65
        L121:
            b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.h7.ordinal()] = 8;     // Catch: NoSuchFieldError -> L66
        L127:
            b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.h8.ordinal()] = 9;     // Catch: NoSuchFieldError -> L67
        L81:
            b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.h9.ordinal()] = 10;     // Catch: NoSuchFieldError -> L68
        L85:
            b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.checkbox.ordinal()] = 11;     // Catch: NoSuchFieldError -> L69
        L107:
            b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.checkList.ordinal()] = 12;     // Catch: NoSuchFieldError -> L70
        L109:
            b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.unorderedList.ordinal()] = 13;     // Catch: NoSuchFieldError -> L71
        L133:
            b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.orderedList.ordinal()] = 14;     // Catch: NoSuchFieldError -> L72
        L137:
            b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.codeList.ordinal()] = 15;     // Catch: NoSuchFieldError -> L73
        L91:
            b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.blockQuote.ordinal()] = 16;     // Catch: NoSuchFieldError -> L74
        L97:
            b[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.insertSeparator.ordinal()] = 17;     // Catch: NoSuchFieldError -> L75
        L41:
            int[] r3 = new int[ToolbarPrimaryItemId.ListTransformSecondaryItemId.values().length];
            a = r3;
            r3[ToolbarPrimaryItemId.ListTransformSecondaryItemId.noneList.ordinal()] = 1;     // Catch: NoSuchFieldError -> L76
        L119:
            a[ToolbarPrimaryItemId.ListTransformSecondaryItemId.unorderedList.ordinal()] = 2;     // Catch: NoSuchFieldError -> L77
        L141:
            a[ToolbarPrimaryItemId.ListTransformSecondaryItemId.orderedList.ordinal()] = 3;     // Catch: NoSuchFieldError -> L78
            return;
        }
    }

    public static int a(ItemIdV2 r5) {
        if ((r5 instanceof ToolbarPrimaryItemId.BlockTransformSecondaryItemId) == false) goto L24;
        switch(a.b[((ToolbarPrimaryItemId.BlockTransformSecondaryItemId) r5).ordinal()]) {
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
        return 2131254237;
    L8:
        return 2131255526;
    L9:
        return 2131254133;
    L10:
        return 2131254229;
    L11:
        return 2131256017;
    L12:
        return 2131254851;
    L13:
        return 2131254850;
    L14:
        return 2131254849;
    L15:
        return 2131254848;
    L16:
        return 2131254847;
    L17:
        return 2131254846;
    L18:
        return 2131254845;
    L19:
        return 2131254844;
    L20:
        return 2131254843;
    L21:
        return 2131233701;
    L61:
        return 2131255256;
    L24:
        if ((r5 instanceof ToolbarPrimaryItemId.TextTransformSecondaryItemId) == false) goto L36;
        switch(a.c[((ToolbarPrimaryItemId.TextTransformSecondaryItemId) r5).ordinal()]) {
            case 1: goto L33;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L30;
            case 5: goto L29;
            case 6: goto L28;
            default: goto L82;
        };
    L28:
        return 2131254132;
    L29:
        return 2131254786;
    L30:
        return 2131254887;
    L31:
        return 2131256061;
    L32:
        return 2131254942;
    L33:
        return 2131253866;
    L82:
        return 0;
    L36:
        if ((r5 instanceof ToolbarPrimaryItemId.AlignTransformSecondaryItemId) == false) goto L49;
        switch(a.d[((ToolbarPrimaryItemId.AlignTransformSecondaryItemId) r5).ordinal()]) {
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
        return 2131255160;
    L41:
        return 2131255165;
    L42:
        return 2131255561;
    L43:
        return 2131254074;
    L44:
        return 2131254994;
    L45:
        return 2131254912;
    L46:
        return 2131255523;
    L89:
        return 0;
    L49:
        if ((r5 instanceof ToolbarPrimaryItemId.ListTransformSecondaryItemId) == false) goto L60;
        int r6 = a.a[((ToolbarPrimaryItemId.ListTransformSecondaryItemId) r5).ordinal()];
        if (r6 != 1) goto L53;
        return 2131233701;
    L53:
        if (r6 != 2) goto L55;
        return 2131254229;
    L55:
        if (r6 == 3) goto L90;
        return 0;
    L90:
        return 2131255256;
    L60:
        return 0;
    }
}
