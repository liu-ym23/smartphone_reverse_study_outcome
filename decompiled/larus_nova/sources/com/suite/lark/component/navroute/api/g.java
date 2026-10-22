package com.suite.lark.component.navroute.api;

/* JADX INFO: loaded from: classes40.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f460257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f460258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f460259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f460260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f460261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final NavRouteNavigator.NavRouteExtras f460262f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f460263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f460264b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f460265c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f460266d;

        public a() {
            int r100 = 0;
            this(r100, r100, 15);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f460263a == r101.f460263a) goto L12;
            return false;
        L12:
            if (this.f460264b == r101.f460264b) goto L15;
            return false;
        L15:
            if (this.f460265c == r101.f460265c) goto L18;
            return false;
        L18:
            if (this.f460266d == r101.f460266d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f460263a * 31) + this.f460264b) * 31) + this.f460265c) * 31) + this.f460266d;
        }

        public final String toString() {
            return "Animations(enterAnim=" + this.f460263a + ", exitAnim=" + this.f460264b + ", popEnterAnim=" + this.f460265c + ", popExitAnim=" + this.f460266d + ')';
        }

        public /* synthetic */ a(int r100, int r101, int r102) {
            int r103 = -1;
            if ((r102 & 1) == 0) goto L6;
            r100 = -1;
        L6:
            if ((r102 & 2) == 0) goto L9;
            r101 = -1;
        L9:
            if ((r102 & 4) == 0) goto L11;
            int r104 = -1;
        L13:
            if ((r102 & 8) != 0) goto L16;
            r103 = 0;
        L16:
            this(r100, r101, r104, r103);
            return;
        L11:
            r104 = 0;
            goto L13
        }

        public a(int r100, int r101, int r102, int r103) {
            this.f460263a = r100;
            this.f460264b = r101;
            this.f460265c = r102;
            this.f460266d = r103;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f460267a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f460268b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f460269c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a f460270d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public NavRouteNavigator.NavRouteExtras f460271e;

        public b() {
        }
    }

    public String toString() {
        return "NavRouteOptions(restoreState=" + this.f460257a + ", singleTop=" + this.f460258b + ", clearTop=" + this.f460259c + ", inclusive=" + this.f460260d + ", animations=" + this.f460261e + ", extras=" + a() + ')';
    }

    public NavRouteNavigator.NavRouteExtras a() {
        return this.f460262f;
    }

    public g(boolean r100, boolean r101, String r102, boolean r103, a r104, NavRouteNavigator.NavRouteExtras r105) {
        this.f460257a = r100;
        this.f460258b = r101;
        this.f460259c = r102;
        this.f460260d = r103;
        this.f460261e = r104;
        this.f460262f = r105;
    }
}
