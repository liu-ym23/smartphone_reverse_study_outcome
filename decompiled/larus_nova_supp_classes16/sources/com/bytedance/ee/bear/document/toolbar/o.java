package com.bytedance.ee.bear.document.toolbar;

import com.bytedance.ee.bear.doc.toolbar.DocItemId;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarPrimaryItemId;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class o {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ToolbarPrimaryItemId.values().length];
            b = r0;
            r0[ToolbarPrimaryItemId.addNewBlock.ordinal()] = 1;     // Catch: NoSuchFieldError -> L39
        L81:
            b[ToolbarPrimaryItemId.blockTransform.ordinal()] = 2;     // Catch: NoSuchFieldError -> L40
        L97:
            b[ToolbarPrimaryItemId.textTransform.ordinal()] = 3;     // Catch: NoSuchFieldError -> L41
        L103:
            b[ToolbarPrimaryItemId.alignTransform.ordinal()] = 4;     // Catch: NoSuchFieldError -> L42
        L105:
            b[ToolbarPrimaryItemId.checkbox.ordinal()] = 5;     // Catch: NoSuchFieldError -> L43
        L69:
            b[ToolbarPrimaryItemId.checkList.ordinal()] = 6;     // Catch: NoSuchFieldError -> L44
        L71:
            b[ToolbarPrimaryItemId.reminder.ordinal()] = 7;     // Catch: NoSuchFieldError -> L45
        L87:
            b[ToolbarPrimaryItemId.insertImage.ordinal()] = 8;     // Catch: NoSuchFieldError -> L46
        L91:
            b[ToolbarPrimaryItemId.mention.ordinal()] = 9;     // Catch: NoSuchFieldError -> L47
        L107:
            b[ToolbarPrimaryItemId.insertTable.ordinal()] = 10;     // Catch: NoSuchFieldError -> L48
        L111:
            b[ToolbarPrimaryItemId.undo.ordinal()] = 11;     // Catch: NoSuchFieldError -> L49
        L73:
            b[ToolbarPrimaryItemId.redo.ordinal()] = 12;     // Catch: NoSuchFieldError -> L50
        L77:
            b[ToolbarPrimaryItemId.indentLeft.ordinal()] = 13;     // Catch: NoSuchFieldError -> L51
        L95:
            b[ToolbarPrimaryItemId.indentRight.ordinal()] = 14;     // Catch: NoSuchFieldError -> L52
        L99:
            b[ToolbarPrimaryItemId.transTask.ordinal()] = 15;     // Catch: NoSuchFieldError -> L53
        L115:
            b[ToolbarPrimaryItemId.inlineAI.ordinal()] = 16;     // Catch: NoSuchFieldError -> L54
        L65:
            b[ToolbarPrimaryItemId.aiRewrite.ordinal()] = 17;     // Catch: NoSuchFieldError -> L55
        L28:
            int[] r9 = new int[DocItemId.values().length];
            a = r9;
            r9[DocItemId.reminder.ordinal()] = 1;     // Catch: NoSuchFieldError -> L56
        L85:
            a[DocItemId.attribution.ordinal()] = 2;     // Catch: NoSuchFieldError -> L57
        L101:
            a[DocItemId.insertImage.ordinal()] = 3;     // Catch: NoSuchFieldError -> L58
        L109:
            a[DocItemId.mention.ordinal()] = 4;     // Catch: NoSuchFieldError -> L59
        L113:
            a[DocItemId.comment.ordinal()] = 5;     // Catch: NoSuchFieldError -> L60
        L67:
            a[DocItemId.indentLeft.ordinal()] = 6;     // Catch: NoSuchFieldError -> L61
        L83:
            a[DocItemId.indentRight.ordinal()] = 7;     // Catch: NoSuchFieldError -> L62
        L89:
            a[DocItemId.undo.ordinal()] = 8;     // Catch: NoSuchFieldError -> L63
        L93:
            a[DocItemId.redo.ordinal()] = 9;     // Catch: NoSuchFieldError -> L64
            return;
        }
    }

    public static int a(DocItemId r1) {
        switch(a.a[r1.ordinal()]) {
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
        return 2131255522;
    L8:
        return 2131256063;
    L10:
        return 2131254912;
    L12:
        return 2131255523;
    L14:
        return 2131253538;
    L16:
        return 2131253681;
    L18:
        return 2131254899;
    L20:
        return 2131255840;
    L22:
        return 2131253990;
    }
}
