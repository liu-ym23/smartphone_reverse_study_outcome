package com.bytedance.ee.bear.lark.selector;

import android.text.TextUtils;
import com.larus.nova.R;
import com.ss.android.lark.doc.entity.DocType;

/* JADX INFO: loaded from: classes16.dex */
public final class DocModuleInner {

    public @interface DocIconColor {
        public static final int BLUE = 0;
        public static final int GRAY = 2;
        public static final int LIGHT_BLUE = 3;
        public static final int WHITE = 1;
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f227455a = null;

        static {
            int[] r100 = new int[DocType.values().length];
            f227455a = r100;
            r100[DocType.DOC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L26:
            f227455a[DocType.SHEET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L32:
            f227455a[DocType.BITABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L42:
            f227455a[DocType.MINDNOTE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L28:
            f227455a[DocType.FILE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L34:
            f227455a[DocType.SLIDES.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L36:
            f227455a[DocType.DOCX_SYNCED_BLOCK.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L38:
            f227455a[DocType.DOCX.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L24:
            f227455a[DocType.WIKI.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L30:
            f227455a[DocType.SLIDE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    public static int b(DocType r100, String r101) {
        if (r100 != null) goto L6;
        return kac.a.b(R.drawable.ud_icon_wiki_unknow_circle_colorful);
    L6:
        switch(a.f227455a[r100.ordinal()]) {
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
        int r102 = -1;
    L17:
        return ua5.a.j(r102, r101);
    L8:
        r102 = 22;
        goto L17
    L9:
        r102 = 44;
        goto L17
    L10:
        r102 = 30;
        goto L17
    L11:
        r102 = 12;
        goto L17
    L12:
        r102 = 11;
        goto L17
    L13:
        r102 = 8;
        goto L17
    L14:
        r102 = 3;
        goto L17
    L15:
        r102 = 2;
        goto L17
    }

    public static int a(DocType r100, DocType r101, String r102) {
        if (r100 != null) goto L7;
        return kac.a.b(R.drawable.ud_icon_file_round_doc_colorful);
    L7:
        switch(a.f227455a[r100.ordinal()]) {
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
        String r103 = com.bytedance.ee.util.io.a.c(r102);
        if (TextUtils.isEmpty(r103) == true) goto L23;
        if (r103.contains(".") == false) goto L23;
        r103 = r103.replace(".", "");
    L23:
        return kac.a.b(ua5.a.h(r103));
    L10:
        return b(r101, r102);
    L12:
        return kac.a.b(R.drawable.ud_icon_file_round_docx_colorful);
    L14:
        return kac.a.b(R.drawable.ud_icon_syncedblock_colorful);
    L16:
        return kac.a.b(R.drawable.ud_icon_wiki_slides_circle_colorful);
    L25:
        return kac.a.b(R.drawable.ud_icon_file_round_mindnote_colorful);
    L27:
        return kac.a.b(R.drawable.ud_icon_file_round_bitable_colorful);
    L29:
        return kac.a.b(R.drawable.ud_icon_file_round_sheet_colorful);
    L31:
        return kac.a.b(R.drawable.ud_icon_file_round_doc_colorful);
    L33:
        return kac.a.b(R.drawable.ud_icon_file_round_unknow_colorful);
    }
}
