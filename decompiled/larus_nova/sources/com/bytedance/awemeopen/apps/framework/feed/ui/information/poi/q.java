package com.bytedance.awemeopen.apps.framework.feed.ui.information.poi;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.awemeopen.bizmodels.feed.poi.MinorTag;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class q extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tz3.b<b> f196301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final tz3.b<a> f196302b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f196303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f196304b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<MinorTag> f196305c;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f196303a, r101.f196303a) == true) goto L12;
            return false;
        L12:
            if (this.f196304b == r101.f196304b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f196305c, r101.f196305c) == true) goto L17;
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
            int r100 = this.f196303a.hashCode() * 31;
            boolean r101 = this.f196304b;
            ?? r102 = r101;
            if (r101 == false) goto L6;
            r102 = 1;
        L6:
            return ((r100 + r102) * 31) + this.f196305c.hashCode();
        }

        public final String toString() {
            return "ExpandViewState(uniqueId=" + this.f196303a + ", enableExpendAnchor=" + this.f196304b + ", tags=" + this.f196305c + ')';
        }

        public /* synthetic */ a(int r100) {
            this("", false, CollectionsKt.emptyList());
        }

        public a(String r100, boolean r101, List<MinorTag> r102) {
            Intrinsics.checkNotNullParameter(r100, "uniqueId");
            Intrinsics.checkNotNullParameter(r102, PromotionProductPrivilegesStruct.TAGS);
            this.f196303a = r100;
            this.f196304b = r101;
            this.f196305c = r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f196306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f196307b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f196308c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f196309d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final t14.a f196310e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f196311f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f196306a, r101.f196306a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f196307b, r101.f196307b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f196308c, r101.f196308c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f196309d, r101.f196309d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f196310e, r101.f196310e) == true) goto L24;
            return false;
        L24:
            if (this.f196311f == r101.f196311f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f196306a.hashCode() * 31) + this.f196307b.hashCode()) * 31;
            String r101 = this.f196308c;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (((r100 + r103) * 31) + this.f196309d.hashCode()) * 31;
            t14.a r105 = this.f196310e;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return ((r104 + r102) * 31) + this.f196311f;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "PoiViewState(aid=" + this.f196306a + ", poiName=" + this.f196307b + ", poiType=" + this.f196308c + ", suffix=" + this.f196309d + ", icon=" + this.f196310e + ", anchorType=" + this.f196311f + ')';
        }

        public b(String r100, String r101, String r102, String r103, t14.a r104, int r105) {
            Intrinsics.checkNotNullParameter(r100, "aid");
            Intrinsics.checkNotNullParameter(r101, "poiName");
            Intrinsics.checkNotNullParameter(r103, "suffix");
            this.f196306a = r100;
            this.f196307b = r101;
            this.f196308c = r102;
            this.f196309d = r103;
            this.f196310e = r104;
            this.f196311f = r105;
        }
    }

    public q() {
        this.f196301a = new tz3.b();
        this.f196302b = new tz3.b();
    }
}
