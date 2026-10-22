package com.bytedance.ee.bear.document.toolbar;

import com.bytedance.ee.bear.doc.toolbar.DocItemId;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarPrimaryItemId;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class o {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f222349a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f222350b = null;

        static {
            int[] r100 = new int[ToolbarPrimaryItemId.values().length];
            f222350b = r100;
            r100[ToolbarPrimaryItemId.addNewBlock.ordinal()] = 1;     // Catch: NoSuchFieldError -> L39
        L81:
            f222350b[ToolbarPrimaryItemId.blockTransform.ordinal()] = 2;     // Catch: NoSuchFieldError -> L40
        L97:
            f222350b[ToolbarPrimaryItemId.textTransform.ordinal()] = 3;     // Catch: NoSuchFieldError -> L41
        L103:
            f222350b[ToolbarPrimaryItemId.alignTransform.ordinal()] = 4;     // Catch: NoSuchFieldError -> L42
        L105:
            f222350b[ToolbarPrimaryItemId.checkbox.ordinal()] = 5;     // Catch: NoSuchFieldError -> L43
        L69:
            f222350b[ToolbarPrimaryItemId.checkList.ordinal()] = 6;     // Catch: NoSuchFieldError -> L44
        L71:
            f222350b[ToolbarPrimaryItemId.reminder.ordinal()] = 7;     // Catch: NoSuchFieldError -> L45
        L87:
            f222350b[ToolbarPrimaryItemId.insertImage.ordinal()] = 8;     // Catch: NoSuchFieldError -> L46
        L91:
            f222350b[ToolbarPrimaryItemId.mention.ordinal()] = 9;     // Catch: NoSuchFieldError -> L47
        L107:
            f222350b[ToolbarPrimaryItemId.insertTable.ordinal()] = 10;     // Catch: NoSuchFieldError -> L48
        L111:
            f222350b[ToolbarPrimaryItemId.undo.ordinal()] = 11;     // Catch: NoSuchFieldError -> L49
        L73:
            f222350b[ToolbarPrimaryItemId.redo.ordinal()] = 12;     // Catch: NoSuchFieldError -> L50
        L77:
            f222350b[ToolbarPrimaryItemId.indentLeft.ordinal()] = 13;     // Catch: NoSuchFieldError -> L51
        L95:
            f222350b[ToolbarPrimaryItemId.indentRight.ordinal()] = 14;     // Catch: NoSuchFieldError -> L52
        L99:
            f222350b[ToolbarPrimaryItemId.transTask.ordinal()] = 15;     // Catch: NoSuchFieldError -> L53
        L115:
            f222350b[ToolbarPrimaryItemId.inlineAI.ordinal()] = 16;     // Catch: NoSuchFieldError -> L54
        L65:
            f222350b[ToolbarPrimaryItemId.aiRewrite.ordinal()] = 17;     // Catch: NoSuchFieldError -> L55
        L28:
            int[] r101 = new int[DocItemId.values().length];
            f222349a = r101;
            r101[DocItemId.reminder.ordinal()] = 1;     // Catch: NoSuchFieldError -> L56
        L85:
            f222349a[DocItemId.attribution.ordinal()] = 2;     // Catch: NoSuchFieldError -> L57
        L101:
            f222349a[DocItemId.insertImage.ordinal()] = 3;     // Catch: NoSuchFieldError -> L58
        L109:
            f222349a[DocItemId.mention.ordinal()] = 4;     // Catch: NoSuchFieldError -> L59
        L113:
            f222349a[DocItemId.comment.ordinal()] = 5;     // Catch: NoSuchFieldError -> L60
        L67:
            f222349a[DocItemId.indentLeft.ordinal()] = 6;     // Catch: NoSuchFieldError -> L61
        L83:
            f222349a[DocItemId.indentRight.ordinal()] = 7;     // Catch: NoSuchFieldError -> L62
        L89:
            f222349a[DocItemId.undo.ordinal()] = 8;     // Catch: NoSuchFieldError -> L63
        L93:
            f222349a[DocItemId.redo.ordinal()] = 9;     // Catch: NoSuchFieldError -> L64
            return;
        }
    }

    public static int a(DocItemId r100) {
        switch(a.f222349a[r100.ordinal()]) {
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L8;
            case 9: goto L6;
            default: goto L4;
        };
    L4:
        return 0;
    L6:
        return R.drawable.ud_icon_redo_outlined;
    L8:
        return R.drawable.ud_icon_undo_outlined;
    L10:
        return R.drawable.ud_icon_increase_indentation_outlined;
    L12:
        return R.drawable.ud_icon_reduce_indentation_outlined;
    L14:
        return R.drawable.ud_icon_add_comment_outlined;
    L16:
        return R.drawable.ud_icon_at_outlined;
    L18:
        return R.drawable.ud_icon_image_outlined;
    L20:
        return R.drawable.ud_icon_style_outlined;
    L22:
        return R.drawable.ud_icon_calendar_outlined;
    }
}
