package com.bytedance.ee.bear.bitable.statistic.common.layoutdraw;

import com.bytedance.ee.bear.bitable.card.view.page.PageCellContainerLayout$drawTimeMonitor$2;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c extends com.bytedance.ee.bear.bitable.statistic.common.layoutdraw.a {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f215639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f215640b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f215641c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f215642d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f215639a, r101.f215639a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f215640b, r101.f215640b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f215641c, r101.f215641c) == true) goto L18;
            return false;
        L18:
            if (this.f215642d == r101.f215642d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f215639a.hashCode() * 31) + Arrays.hashCode(this.f215640b)) * 31) + Arrays.hashCode(this.f215641c)) * 31) + this.f215642d;
        }

        public final String toString() {
            return "DrawTimeParam(viewType=" + this.f215639a + ", drawTime=" + Arrays.toString(this.f215640b) + ", drawCount=" + Arrays.toString(this.f215641c) + ", costTime=" + this.f215642d + ')';
        }

        public a(String r100, int[] r101, int[] r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "viewType");
            Intrinsics.checkNotNullParameter(r101, "drawTime");
            Intrinsics.checkNotNullParameter(r102, "drawCount");
            this.f215639a = r100;
            this.f215640b = r101;
            this.f215641c = r102;
            this.f215642d = r103;
        }
    }

    public interface b {
        void a(a r100);

        String getViewType();
    }

    public c(final PageCellContainerLayout$drawTimeMonitor$2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "onReportListener");
        super(new BitableListItemDrawTimeView$1(r100));
    }
}
