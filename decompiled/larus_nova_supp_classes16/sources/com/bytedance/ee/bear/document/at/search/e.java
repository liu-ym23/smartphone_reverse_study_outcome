package com.bytedance.ee.bear.document.at.search;

import com.bytedance.lark.pb.basic.v1.Doc;
import com.ss.android.lark.picker.config.condition.DocType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Doc.Type.values().length];
            r0[Doc.Type.DOC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[Doc.Type.SHEET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[Doc.Type.BITABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[Doc.Type.MINDNOTE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[Doc.Type.FILE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[Doc.Type.SLIDES.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[Doc.Type.DOCX.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[Doc.Type.WIKI.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    static {
    }

    public static DocType a(int r1) {
        if (r1 == 1) goto L27;
        if (r1 == 3) goto L35;
        if (r1 == 8) goto L34;
        if (r1 == 16) goto L33;
        if (r1 == 22) goto L32;
        if (r1 == 30) goto L31;
        if (r1 == 11) goto L30;
        if (r1 == 12) goto L29;
        return DocType.NONE;
    L29:
        return DocType.FILE;
    L30:
        return DocType.MINDNOTE;
    L31:
        return DocType.SLIDES;
    L32:
        return DocType.DOCX;
    L33:
        return DocType.WIKI;
    L34:
        return DocType.BITABLE;
    L35:
        return DocType.SHEET;
    L27:
        return DocType.DOC;
    }

    public static int b(Doc.Type r1) {
        Intrinsics.checkNotNullParameter(r1, "docType");
        switch(a.a[r1.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        return -1;
    L5:
        return 16;
    L6:
        return 22;
    L7:
        return 30;
    L8:
        return 12;
    L9:
        return 11;
    L10:
        return 8;
    L11:
        return 3;
    L12:
        return 1;
    }
}
