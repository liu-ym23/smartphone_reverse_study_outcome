package com.bytedance.awemeopen.apps.framework.feed.ui.information.poi;

import com.bytedance.awemeopen.bizmodels.feed.poi.MinorTag;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b {
    public final tz3.b<b> a;
    public final tz3.b<a> b;

    public static final class a {
        public final String a;
        public final boolean b;
        public final List<MinorTag> c;

        public a() {
            this(0);
        }

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
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            boolean r1 = this.b;
            ?? r2 = r1;
            if (r1 == false) goto L6;
            r2 = 1;
        L6:
            return ((r0 + r2) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "ExpandViewState(uniqueId=" + this.a + ", enableExpendAnchor=" + this.b + ", tags=" + this.c + ')';
        }

        public /* synthetic */ a(int r3) {
            this("", false, CollectionsKt.emptyList());
        }

        public a(String r2, boolean r3, List<MinorTag> r4) {
            Intrinsics.checkNotNullParameter(r2, "uniqueId");
            Intrinsics.checkNotNullParameter(r4, "tags");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final t14.a e;
        public final int f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
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
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            String r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + this.d.hashCode()) * 31;
            t14.a r5 = this.e;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((r4 + r2) * 31) + this.f;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "PoiViewState(aid=" + this.a + ", poiName=" + this.b + ", poiType=" + this.c + ", suffix=" + this.d + ", icon=" + this.e + ", anchorType=" + this.f + ')';
        }

        public b(String r2, String r3, String r4, String r5, t14.a r6, int r7) {
            Intrinsics.checkNotNullParameter(r2, "aid");
            Intrinsics.checkNotNullParameter(r3, "poiName");
            Intrinsics.checkNotNullParameter(r5, "suffix");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public q() {
        this.a = new tz3.b();
        this.b = new tz3.b();
    }
}
