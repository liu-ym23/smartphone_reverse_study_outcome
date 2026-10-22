package com.bytedance.ee.bear.doc.structure;

import com.bytedance.ee.bear.document.comment.bean.ShowCardsJsData;
import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import com.bytedance.ee.util.ui.n;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
            String r0 = this.hash;
            if (r0 != null) goto L6;
            return ShowCardsJsData.ID_GLOBAL;
        L6:
            return r0;
        }

        public String getTitle() {
            String r0 = this.title;
            if (r0 != null) goto L6;
            return "";
        L6:
            return r0;
        }

        public int hashCode() {
            String r0 = this.hash;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.title;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return ((((r3 + r1) * 31) + this.level) * 31) + this.top;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "Paragraph{hash='" + this.hash + "', title='" + this.title + "', level=" + this.level + ", top=" + this.top + ", collapse=" + this.collapse + '}';
        }

        public Paragraph() {
            this.showParagraph = true;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L40:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L40;
            Paragraph r6 = (Paragraph) r5;
            if (this.level == r6.level) goto L14;
            return false;
        L14:
            if (this.top == r6.top) goto L16;
            return false;
        L16:
            String r2 = this.hash;
            if (r2 == null) goto L22;
            if (r2.equals(r6.hash) == true) goto L25;
        L23:
            return false;
        L25:
            if (this.showParagraph == r6.showParagraph) goto L28;
            return false;
        L28:
            if (this.showCollapse == r6.showCollapse) goto L31;
            return false;
        L31:
            if (this.collapse == r6.collapse) goto L33;
            return false;
        L33:
            String r3 = this.title;
            String r7 = r6.title;
            if (r3 != null) goto L41;
            if (r7 == null) goto L42;
            return false;
        L42:
            return true;
        L41:
            return r3.equals(r7);
        L22:
            if (r6.hash == null) goto L25;
            goto L23
        }

        public void setHash(String r1) {
            this.hash = r1;
        }

        public Paragraph(String r2, int r3, int r4) {
            this.showParagraph = true;
            this.title = r2;
            this.level = r3;
            this.top = r4;
        }

        public Paragraph(String r1, int r2, int r3, boolean r4, boolean r5, boolean r6) {
            this(r1, r2, r3);
            this.showParagraph = r4;
            this.showCollapse = r5;
            this.collapse = r6;
        }
    }

    public Structure() {
    }

    public int getParagraphCount() {
        Paragraph[] r0 = this.paragraphs;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.length;
    }

    public int hashCode() {
        return Arrays.hashCode(this.paragraphs);
    }

    public String toString() {
        return "Structure{paragraphs=" + Arrays.toString(this.paragraphs) + '}';
    }

    public void transformDip2Px() {
        Paragraph[] r0 = this.paragraphs;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        Paragraph r3 = r0[r2];
        r3.top = n.d(r3.top);
        r2 = r2 + 1;
        goto L6
    }

    public void trimAllTitle() {
        Paragraph[] r0 = this.paragraphs;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L11;
        Paragraph r3 = r0[r2];
        String r4 = r3.title;
        if (r4 == null) goto L10;
        r3.title = r4.trim();
    L10:
        r2 = r2 + 1;
        goto L6
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (getClass() == r3.getClass()) goto L10;
        return false;
    L10:
        return Arrays.equals(this.paragraphs, ((Structure) r3).paragraphs);
    }

    public Paragraph getParagraph(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 <= (getParagraphCount() - 1)) goto L7;
        return null;
    L7:
        return this.paragraphs[r2];
    }

    public static boolean countEquals(Structure r1, Structure r2) {
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        if (r2 != null) goto L8;
        int r4 = 0;
    L9:
        if (r3 != r4) goto L12;
        return true;
    L12:
        return false;
    L8:
        r4 = r2.getParagraphCount();
        goto L9
    L5:
        r3 = r1.getParagraphCount();
        goto L6
    }

    public static boolean equals(Structure r0, Structure r1) {
        if (r0 != null) goto L8;
        if (r1 != null) goto L5;
        return true;
    L5:
        return false;
    L8:
        return r0.equals(r1);
    }
}
