package com.bytedance.ee.bear.document.at.search;

import com.bytedance.lark.pb.basic.v1.Doc;
import com.ss.android.lark.picker.config.condition.DocType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f219126a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f219127a = null;

        static {
            int[] r100 = new int[Doc.Type.values().length];
            r100[Doc.Type.DOC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[Doc.Type.SHEET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[Doc.Type.BITABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[Doc.Type.MINDNOTE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[Doc.Type.FILE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[Doc.Type.SLIDES.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[Doc.Type.DOCX.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[Doc.Type.WIKI.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f219127a = r100;
        }
    }

    static {
    }

    public static DocType a(int r100) {
        if (r100 == 1) goto L27;
        if (r100 == 3) goto L35;
        if (r100 == 8) goto L34;
        if (r100 == 16) goto L33;
        if (r100 == 22) goto L32;
        if (r100 == 30) goto L31;
        if (r100 == 11) goto L30;
        if (r100 == 12) goto L29;
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

    public static int b(Doc.Type r100) {
        Intrinsics.checkNotNullParameter(r100, "docType");
        switch(a.f219127a[r100.ordinal()]) {
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
