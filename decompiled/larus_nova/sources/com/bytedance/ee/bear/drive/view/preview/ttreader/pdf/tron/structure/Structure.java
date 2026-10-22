package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.structure;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import com.bytedance.ee.util.ui.n;
import java.util.Arrays;

/* JADX INFO: loaded from: classes16.dex */
public class Structure implements BaseJSModel {
    public Paragraph[] paragraphs;

    public static class Paragraph implements BaseJSModel {
        public boolean collapse;
        private String hash;
        public int level;
        public boolean showCollapse;
        public boolean showParagraph;
        public String title;
        public int top;

        public String getHash() {
            String r100 = this.hash;
            if (r100 != null) goto L6;
            return "-1";
        L6:
            return r100;
        }

        public String getTitle() {
            String r100 = this.title;
            if (r100 != null) goto L6;
            return "";
        L6:
            return r100;
        }

        public int hashCode() {
            String r100 = this.hash;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.title;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return ((((r103 + r101) * 31) + this.level) * 31) + this.top;
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "Paragraph{hash='" + this.hash + "', title='" + this.title + "', level=" + this.level + ", top=" + this.top + ", collapse=" + this.collapse + '}';
        }

        public Paragraph() {
            this.showParagraph = true;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L40:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L40;
            Paragraph r101 = (Paragraph) r100;
            if (this.level == r101.level) goto L14;
            return false;
        L14:
            if (this.top == r101.top) goto L16;
            return false;
        L16:
            String r102 = this.hash;
            if (r102 == null) goto L22;
            if (r102.equals(r101.hash) == true) goto L25;
        L23:
            return false;
        L25:
            if (this.showParagraph == r101.showParagraph) goto L28;
            return false;
        L28:
            if (this.showCollapse == r101.showCollapse) goto L31;
            return false;
        L31:
            if (this.collapse == r101.collapse) goto L33;
            return false;
        L33:
            String r103 = this.title;
            String r104 = r101.title;
            if (r103 != null) goto L41;
            if (r104 == null) goto L42;
            return false;
        L42:
            return true;
        L41:
            return r103.equals(r104);
        L22:
            if (r101.hash == null) goto L25;
            goto L23
        }

        public Paragraph(String r100, String r101, int r102, int r103) {
            this.showParagraph = true;
            this.hash = r100;
            this.title = r101;
            this.level = r102;
            this.top = r103;
        }

        public Paragraph(String r100, String r101, int r102, int r103, boolean r104, boolean r105, boolean r106) {
            this(r100, r101, r102, r103);
            this.showParagraph = r104;
            this.showCollapse = r105;
            this.collapse = r106;
        }
    }

    public Structure() {
    }

    public int getParagraphCount() {
        Paragraph[] r100 = this.paragraphs;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.length;
    }

    public int hashCode() {
        return Arrays.hashCode(this.paragraphs);
    }

    public String toString() {
        return "Structure{paragraphs=" + Arrays.toString(this.paragraphs) + '}';
    }

    public void transformDip2Px() {
        Paragraph[] r100 = this.paragraphs;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r100.length;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L8;
        Paragraph r103 = r100[r102];
        r103.top = n.d(r103.top);
        r102 = r102 + 1;
        goto L6
    }

    public void trimAllTitle() {
        Paragraph[] r100 = this.paragraphs;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r100.length;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L11;
        Paragraph r103 = r100[r102];
        String r104 = r103.title;
        if (r104 == null) goto L10;
        r103.title = r104.trim();
    L10:
        r102 = r102 + 1;
        goto L6
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (getClass() == r100.getClass()) goto L10;
        return false;
    L10:
        return Arrays.equals(this.paragraphs, ((Structure) r100).paragraphs);
    }

    public Paragraph getParagraph(int r100) {
        if (r100 >= 0) goto L4;
        return null;
    L4:
        if (r100 <= (getParagraphCount() - 1)) goto L7;
        return null;
    L7:
        return this.paragraphs[r100];
    }

    public static boolean countEquals(Structure r100, Structure r101) {
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        if (r101 != null) goto L8;
        int r103 = 0;
    L9:
        if (r102 != r103) goto L12;
        return true;
    L12:
        return false;
    L8:
        r103 = r101.getParagraphCount();
        goto L9
    L5:
        r102 = r100.getParagraphCount();
        goto L6
    }

    public static boolean equals(Structure r100, Structure r101) {
        if (r100 != null) goto L8;
        if (r101 != null) goto L5;
        return true;
    L5:
        return false;
    L8:
        return r100.equals(r101);
    }
}
