package com.bytedance.ee.bear.bitable.statistic.common.layoutdraw;

import com.bytedance.ee.bear.bitable.card.view.page.PageCellContainerLayout;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends com.bytedance.ee.bear.bitable.statistic.common.layoutdraw.a {

    public static final class a {
        public final String a;
        public final int[] b;
        public final int[] c;
        public final int d;

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
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + Arrays.hashCode(this.b)) * 31) + Arrays.hashCode(this.c)) * 31) + this.d;
        }

        public final String toString() {
            return "DrawTimeParam(viewType=" + this.a + ", drawTime=" + Arrays.toString(this.b) + ", drawCount=" + Arrays.toString(this.c) + ", costTime=" + this.d + ')';
        }

        public a(String r2, int[] r3, int[] r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "viewType");
            Intrinsics.checkNotNullParameter(r3, "drawTime");
            Intrinsics.checkNotNullParameter(r4, "drawCount");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public interface b {
        void a(a r1);

        String getViewType();
    }

    public c(final PageCellContainerLayout.drawTimeMonitor.2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "onReportListener");
        super(new BitableListItemDrawTimeView$1(r2));
    }
}
