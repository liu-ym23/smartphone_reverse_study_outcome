package com.bytedance.ee.bear.lark.selector;

import android.text.TextUtils;
import com.ss.android.lark.doc.entity.DocType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DocModuleInner {

    public @interface DocIconColor {
        public static final int BLUE = 0;
        public static final int GRAY = 2;
        public static final int LIGHT_BLUE = 3;
        public static final int WHITE = 1;
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DocType.values().length];
            a = r0;
            r0[DocType.DOC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L26:
            a[DocType.SHEET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L32:
            a[DocType.BITABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L42:
            a[DocType.MINDNOTE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L28:
            a[DocType.FILE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L34:
            a[DocType.SLIDES.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L36:
            a[DocType.DOCX_SYNCED_BLOCK.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L38:
            a[DocType.DOCX.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L24:
            a[DocType.WIKI.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L30:
            a[DocType.SLIDE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    public static int b(DocType r1, String r2) {
        if (r1 != null) goto L6;
        return kac.a.b(2131256268);
    L6:
        switch(a.a[r1.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L7;
        };
    L7:
        int r3 = -1;
    L17:
        return ua5.a.j(r3, r2);
    L8:
        r3 = 22;
        goto L17
    L9:
        r3 = 44;
        goto L17
    L10:
        r3 = 30;
        goto L17
    L11:
        r3 = 12;
        goto L17
    L12:
        r3 = 11;
        goto L17
    L13:
        r3 = 8;
        goto L17
    L14:
        r3 = 3;
        goto L17
    L15:
        r3 = 2;
        goto L17
    }

    public static int a(DocType r2, DocType r3, String r4) {
        if (r2 != null) goto L7;
        return kac.a.b(2131254630);
    L7:
        switch(a.a[r2.ordinal()]) {
            case 1: goto L31;
            case 2: goto L29;
            case 3: goto L27;
            case 4: goto L25;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L14;
            case 8: goto L12;
            case 9: goto L10;
            default: goto L33;
        };
    L17:
        String r5 = com.bytedance.ee.util.io.a.c(r4);
        if (TextUtils.isEmpty(r5) == true) goto L23;
        if (r5.contains(".") == false) goto L23;
        r5 = r5.replace(".", "");
    L23:
        return kac.a.b(ua5.a.h(r5));
    L10:
        return b(r3, r4);
    L12:
        return kac.a.b(2131254632);
    L14:
        return kac.a.b(2131255874);
    L16:
        return kac.a.b(2131256260);
    L25:
        return kac.a.b(2131254655);
    L27:
        return kac.a.b(2131254622);
    L29:
        return kac.a.b(2131254674);
    L31:
        return kac.a.b(2131254630);
    L33:
        return kac.a.b(2131254682);
    }
}
