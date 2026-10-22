package kn9;

import com.larus.nova.R;
import com.larus.office.base.plugins.toolbar.model.ItemId;
import com.larus.office.base.plugins.toolbar.model.ToolbarPrimaryItemId;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes29.dex */
public final class p {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f504318a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f504319b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f504320c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f504321d = null;

        static {
            int[] r100 = new int[ToolbarPrimaryItemId.ListTransformSecondaryItemId.values().length];
            r100[ToolbarPrimaryItemId.ListTransformSecondaryItemId.noneList.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L74:
            r100[ToolbarPrimaryItemId.ListTransformSecondaryItemId.unorderedList.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L86:
            r100[ToolbarPrimaryItemId.ListTransformSecondaryItemId.orderedList.ordinal()] = 3;     // Catch: NoSuchFieldError -> L34
        L8:
            f504318a = r100;
            int[] r101 = new int[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.values().length];
            r101[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.plainText.ordinal()] = 1;     // Catch: NoSuchFieldError -> L35
        L80:
            r101[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.f360918h1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L36
        L90:
            r101[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.f360919h2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L37
        L52:
            r101[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.f360920h3.ordinal()] = 4;     // Catch: NoSuchFieldError -> L38
        L60:
            r101[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.checkbox.ordinal()] = 5;     // Catch: NoSuchFieldError -> L39
        L72:
            r101[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.unorderedList.ordinal()] = 6;     // Catch: NoSuchFieldError -> L40
        L82:
            r101[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.orderedList.ordinal()] = 7;     // Catch: NoSuchFieldError -> L41
        L64:
            r101[ToolbarPrimaryItemId.BlockTransformSecondaryItemId.blockQuote.ordinal()] = 8;     // Catch: NoSuchFieldError -> L42
        L19:
            f504319b = r101;
            int[] r102 = new int[ToolbarPrimaryItemId.TextTransformSecondaryItemId.values().length];
            r102[ToolbarPrimaryItemId.TextTransformSecondaryItemId.bold.ordinal()] = 1;     // Catch: NoSuchFieldError -> L43
        L54:
            r102[ToolbarPrimaryItemId.TextTransformSecondaryItemId.italic.ordinal()] = 2;     // Catch: NoSuchFieldError -> L44
        L66:
            r102[ToolbarPrimaryItemId.TextTransformSecondaryItemId.underline.ordinal()] = 3;     // Catch: NoSuchFieldError -> L45
        L76:
            r102[ToolbarPrimaryItemId.TextTransformSecondaryItemId.strikethrough.ordinal()] = 4;     // Catch: NoSuchFieldError -> L46
        L24:
            f504320c = r102;
            int[] r103 = new int[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.values().length];
            r103[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.indentLeft.ordinal()] = 1;     // Catch: NoSuchFieldError -> L47
        L68:
            r103[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.indentRight.ordinal()] = 2;     // Catch: NoSuchFieldError -> L48
        L78:
            r103[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.alignLeft.ordinal()] = 3;     // Catch: NoSuchFieldError -> L49
        L88:
            r103[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.alignCenter.ordinal()] = 4;     // Catch: NoSuchFieldError -> L50
        L56:
            r103[ToolbarPrimaryItemId.AlignTransformSecondaryItemId.alignRight.ordinal()] = 5;     // Catch: NoSuchFieldError -> L51
        L30:
            f504321d = r103;
        }
    }

    static {
    }

    @JvmStatic
    public static final int a(ItemId r100) {
        if ((r100 instanceof ToolbarPrimaryItemId.BlockTransformSecondaryItemId) == false) goto L16;
        switch(a.f504319b[((ToolbarPrimaryItemId.BlockTransformSecondaryItemId) r100).ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L55;
            case 8: goto L7;
            default: goto L6;
        };
    L6:
        return 0;
    L7:
        return R.drawable.larus_doc_icon_text_blockquote;
    L8:
        return R.drawable.larus_doc_icon_unordered_list;
    L9:
        return R.drawable.larus_doc_icon_checkbox_mark;
    L10:
        return R.drawable.larus_doc_icon_h3;
    L11:
        return R.drawable.larus_doc_icon_h2;
    L12:
        return R.drawable.larus_doc_icon_h1;
    L13:
        return R.drawable.larus_doc_icon_plaintext;
    L55:
        return R.drawable.larus_doc_icon_ordered_list;
    L16:
        if ((r100 instanceof ToolbarPrimaryItemId.TextTransformSecondaryItemId) == false) goto L29;
        int r101 = a.f504320c[((ToolbarPrimaryItemId.TextTransformSecondaryItemId) r100).ordinal()];
        if (r101 == 1) goto L26;
        if (r101 == 2) goto L25;
        if (r101 == 3) goto L24;
        if (r101 != 4) goto L66;
        return R.drawable.larus_doc_icon_text_strikethrough;
    L66:
        return 0;
    L24:
        return R.drawable.larus_doc_icon_text_underline;
    L25:
        return R.drawable.larus_doc_icon_text_italic;
    L26:
        return R.drawable.larus_doc_icon_text_bold;
    L29:
        if ((r100 instanceof ToolbarPrimaryItemId.AlignTransformSecondaryItemId) == false) goto L45;
        int r102 = a.f504321d[((ToolbarPrimaryItemId.AlignTransformSecondaryItemId) r100).ordinal()];
        if (r102 == 1) goto L42;
        if (r102 == 2) goto L41;
        if (r102 == 3) goto L40;
        if (r102 != 4) goto L36;
        return R.drawable.larus_doc_icon_text_aligncenter;
    L36:
        if (r102 != 5) goto L71;
        return R.drawable.larus_doc_icon_text_alignright;
    L71:
        return 0;
    L40:
        return R.drawable.larus_doc_icon_text_alignleft;
    L41:
        return R.drawable.larus_doc_icon_indentright;
    L42:
        return R.drawable.larus_doc_icon_indentleft;
    L45:
        if ((r100 instanceof ToolbarPrimaryItemId.ListTransformSecondaryItemId) == false) goto L54;
        int r103 = a.f504318a[((ToolbarPrimaryItemId.ListTransformSecondaryItemId) r100).ordinal()];
        if (r103 == 1) goto L52;
        if (r103 == 2) goto L51;
        if (r103 == 3) goto L72;
        return 0;
    L72:
        return R.drawable.larus_doc_icon_ordered_list;
    L51:
        return R.drawable.larus_doc_icon_unordered_list;
    L52:
        return R.drawable.larus_doc_ic_plaintext;
    L54:
        return 0;
    }
}
