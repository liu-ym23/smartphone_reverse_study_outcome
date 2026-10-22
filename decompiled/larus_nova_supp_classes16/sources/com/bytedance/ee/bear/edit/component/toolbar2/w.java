package com.bytedance.ee.bear.edit.component.toolbar2;

import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarPrimaryItemId;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class w {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.values().length];
            c = r0;
            r0[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.indentLeft.ordinal()] = 1;     // Catch: NoSuchFieldError -> L39
        L83:
            c[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.indentRight.ordinal()] = 2;     // Catch: NoSuchFieldError -> L40
        L99:
            c[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.alignLeft.ordinal()] = 3;     // Catch: NoSuchFieldError -> L41
        L109:
            c[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.alignCenter.ordinal()] = 4;     // Catch: NoSuchFieldError -> L42
        L113:
            c[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.alignRight.ordinal()] = 5;     // Catch: NoSuchFieldError -> L43
        L12:
            int[] r5 = new int[ToolbarPrimaryItemId.TextTransformSecondaryItemId.values().length];
            b = r5;
            r5[ToolbarPrimaryItemId.TextTransformSecondaryItemId.bold.ordinal()] = 1;     // Catch: NoSuchFieldError -> L44
        L87:
            b[ToolbarPrimaryItemId.TextTransformSecondaryItemId.italic.ordinal()] = 2;     // Catch: NoSuchFieldError -> L45
        L93:
            b[ToolbarPrimaryItemId.TextTransformSecondaryItemId.underline.ordinal()] = 3;     // Catch: NoSuchFieldError -> L46
        L95:
            b[ToolbarPrimaryItemId.TextTransformSecondaryItemId.strikethrough.ordinal()] = 4;     // Catch: NoSuchFieldError -> L47
        L103:
            b[ToolbarPrimaryItemId.TextTransformSecondaryItemId.highlight.ordinal()] = 5;     // Catch: NoSuchFieldError -> L48
        L121:
            b[ToolbarPrimaryItemId.TextTransformSecondaryItemId.inlineCode.ordinal()] = 6;     // Catch: NoSuchFieldError -> L49
        L20:
            int[] r6 = new int[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.values().length];
            a = r6;
            r6[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.plainText.ordinal()] = 1;     // Catch: NoSuchFieldError -> L50
        L81:
            a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.h1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L51
        L91:
            a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.h2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L52
        L107:
            a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.h3.ordinal()] = 4;     // Catch: NoSuchFieldError -> L53
        L115:
            a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.h4.ordinal()] = 5;     // Catch: NoSuchFieldError -> L54
        L117:
            a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.h5.ordinal()] = 6;     // Catch: NoSuchFieldError -> L55
        L73:
            a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.h6.ordinal()] = 7;     // Catch: NoSuchFieldError -> L56
        L79:
            a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.h7.ordinal()] = 8;     // Catch: NoSuchFieldError -> L57
        L97:
            a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.h8.ordinal()] = 9;     // Catch: NoSuchFieldError -> L58
        L101:
            a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.h9.ordinal()] = 10;     // Catch: NoSuchFieldError -> L59
        L119:
            a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.checkbox.ordinal()] = 11;     // Catch: NoSuchFieldError -> L60
        L67:
            a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.checkList.ordinal()] = 12;     // Catch: NoSuchFieldError -> L61
        L85:
            a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.unorderedList.ordinal()] = 13;     // Catch: NoSuchFieldError -> L62
        L89:
            a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.orderedList.ordinal()] = 14;     // Catch: NoSuchFieldError -> L63
        L105:
            a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.codeList.ordinal()] = 15;     // Catch: NoSuchFieldError -> L64
        L111:
            a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.blockQuote.ordinal()] = 16;     // Catch: NoSuchFieldError -> L65
        L71:
            a[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.insertSeparator.ordinal()] = 17;     // Catch: NoSuchFieldError -> L66
            return;
        }
    }

    public static int a(ItemIdV2 r2) {
        if ((r2 instanceof ToolbarPrimaryItemId.BlockTransformSecondaryItemId) == false) goto L25;
        switch(a.a[((ToolbarPrimaryItemId.BlockTransformSecondaryItemId) r2).ordinal()]) {
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
        return 2131254237;
    L8:
        return 2131255526;
    L9:
        return 2131254133;
    L10:
        return 2131255256;
    L11:
        return 2131254229;
    L12:
        return 2131256017;
    L13:
        return 2131254851;
    L14:
        return 2131254850;
    L15:
        return 2131254849;
    L16:
        return 2131254848;
    L17:
        return 2131254847;
    L18:
        return 2131254846;
    L19:
        return 2131254845;
    L20:
        return 2131254844;
    L21:
        return 2131254843;
    L22:
        return 2131237549;
    L70:
        return 0;
    L25:
        if ((r2 instanceof ToolbarPrimaryItemId.TextTransformSecondaryItemId) == false) goto L37;
        switch(a.b[((ToolbarPrimaryItemId.TextTransformSecondaryItemId) r2).ordinal()]) {
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L30;
            case 6: goto L29;
            default: goto L76;
        };
    L29:
        return 2131254132;
    L30:
        return 2131254786;
    L31:
        return 2131254887;
    L32:
        return 2131256061;
    L33:
        return 2131254942;
    L34:
        return 2131253866;
    L76:
        return 0;
    L37:
        if ((r2 instanceof ToolbarPrimaryItemId.AlignTransformSecondaryItemId) == false) goto L77;
        int r3 = a.c[((ToolbarPrimaryItemId.AlignTransformSecondaryItemId) r2).ordinal()];
        if (r3 != 1) goto L41;
        return 2131255523;
    L41:
        if (r3 != 2) goto L43;
        return 2131254912;
    L43:
        if (r3 != 3) goto L45;
        return 2131254994;
    L45:
        if (r3 != 4) goto L47;
        return 2131254074;
    L47:
        if (r3 != 5) goto L82;
        return 2131255561;
    L82:
        return 0;
    L77:
        return 0;
    }
}
