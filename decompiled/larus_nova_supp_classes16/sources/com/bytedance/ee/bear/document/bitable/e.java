package com.bytedance.ee.bear.document.bitable;

import com.bytedance.ee.bear.browser.plugin.i;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface e extends i, ye5.a {

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final int f;
        public final int g;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + this.c.hashCode()) * 31;
            String r5 = this.d;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.e;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return ((((r7 + r2) * 31) + this.f) * 31) + this.g;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "DiscussAction(tableId=" + this.a + ", viewId=" + this.b + ", recordId=" + this.c + ", commentId=" + this.d + ", replyId=" + this.e + ", openDiscussPanelType=" + this.f + ", commentType=" + this.g + ')';
        }

        public a(String r2, String r3, String r4, String r5, String r6, int r7, int r8) {
            Intrinsics.checkNotNullParameter(r2, "tableId");
            Intrinsics.checkNotNullParameter(r4, "recordId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }
    }

    void onDiscussSend(com.bytedance.ee.bear.middleground.comment.export.h r1, String r2, boolean r3);

    @Deprecated(message = "deprecated")
    void openDisucussAction(a r1, boolean r2);

    void openItemViewDiscussAction(a r1, boolean r2);

    @Deprecated(message = "deprecated")
    void openLinkDiscussAction(a r1, boolean r2);

    @Deprecated(message = "deprecated")
    void updateDiscussPermission(String r1);

    void updateDiscussPermission(boolean r1);
}
