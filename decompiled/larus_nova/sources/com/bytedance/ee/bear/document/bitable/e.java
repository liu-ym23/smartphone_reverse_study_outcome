package com.bytedance.ee.bear.document.bitable;

import com.bytedance.ee.bear.browser.plugin.i;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public interface e extends i, ye5.a {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f219158a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f219159b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f219160c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f219161d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f219162e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f219163f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f219164g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f219158a, r101.f219158a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f219159b, r101.f219159b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f219160c, r101.f219160c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f219161d, r101.f219161d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f219162e, r101.f219162e) == true) goto L24;
            return false;
        L24:
            if (this.f219163f == r101.f219163f) goto L27;
            return false;
        L27:
            if (this.f219164g == r101.f219164g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f219158a.hashCode() * 31;
            String r101 = this.f219159b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (((r100 + r103) * 31) + this.f219160c.hashCode()) * 31;
            String r105 = this.f219161d;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f219162e;
            if (r108 == null) goto L15;
            r102 = r108.hashCode();
        L15:
            return ((((r107 + r102) * 31) + this.f219163f) * 31) + this.f219164g;
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "DiscussAction(tableId=" + this.f219158a + ", viewId=" + this.f219159b + ", recordId=" + this.f219160c + ", commentId=" + this.f219161d + ", replyId=" + this.f219162e + ", openDiscussPanelType=" + this.f219163f + ", commentType=" + this.f219164g + ')';
        }

        public a(String r100, String r101, String r102, String r103, String r104, int r105, int r106) {
            Intrinsics.checkNotNullParameter(r100, "tableId");
            Intrinsics.checkNotNullParameter(r102, "recordId");
            this.f219158a = r100;
            this.f219159b = r101;
            this.f219160c = r102;
            this.f219161d = r103;
            this.f219162e = r104;
            this.f219163f = r105;
            this.f219164g = r106;
        }
    }

    void onDiscussSend(com.bytedance.ee.bear.middleground.comment.export.h r100, String r101, boolean r102);

    @Deprecated(message = "deprecated")
    void openDisucussAction(a r100, boolean r101);

    void openItemViewDiscussAction(a r100, boolean r101);

    @Deprecated(message = "deprecated")
    void openLinkDiscussAction(a r100, boolean r101);

    @Deprecated(message = "deprecated")
    void updateDiscussPermission(String r100);

    void updateDiscussPermission(boolean r100);
}
