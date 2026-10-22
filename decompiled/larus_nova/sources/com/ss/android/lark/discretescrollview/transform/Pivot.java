package com.ss.android.lark.discretescrollview.transform;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes35.dex */
public final class Pivot {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f420445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f420446b;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Axis {
    }

    public static abstract enum X extends Enum<X> {
        public static final X CENTER = null;
        public static final X LEFT = null;
        public static final X RIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ X[] f420447a = null;

        public X() {
            throw null;
        }

        public abstract Pivot create();

        static {
            final String r100 = "LEFT";
            final int r101 = 0;
            X r102 = new AnonymousClass1(r100, r101);
            LEFT = r102;
            final String r103 = "CENTER";
            final int r104 = 1;
            X r105 = new AnonymousClass2(r103, r104);
            CENTER = r105;
            final String r106 = "RIGHT";
            final int r107 = 2;
            X r108 = new AnonymousClass3(r106, r107);
            RIGHT = r108;
            f420447a = new X[]{r102, r105, r108};
        }

        public static X[] values() {
            return (X[]) f420447a.clone();
        }

        public static X valueOf(String r100) {
            return (X) r27.a.a(X.class, r100);
        }

        public X(String r100, int r101, a r102) {
            super(r100, r101);
        }
    }

    public static abstract enum Y extends Enum<Y> {
        public static final Y BOTTOM = null;
        public static final Y CENTER = null;
        public static final Y TOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Y[] f420448a = null;

        public Y() {
            throw null;
        }

        public abstract Pivot create();

        static {
            final String r100 = "TOP";
            final int r101 = 0;
            Y r102 = new AnonymousClass1(r100, r101);
            TOP = r102;
            final String r103 = "CENTER";
            final int r104 = 1;
            Y r105 = new AnonymousClass2(r103, r104);
            CENTER = r105;
            final String r106 = "BOTTOM";
            final int r107 = 2;
            Y r108 = new AnonymousClass3(r106, r107);
            BOTTOM = r108;
            f420448a = new Y[]{r102, r105, r108};
        }

        public static Y[] values() {
            return (Y[]) f420448a.clone();
        }

        public static Y valueOf(String r100) {
            return (Y) r27.a.a(Y.class, r100);
        }

        public Y(String r100, int r101, a r102) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {
    }

    public final void a(View r100) {
        int r101 = this.f420445a;
        if (r101 != 0) goto L12;
        int r102 = this.f420446b;
        if (r102 == (-2)) goto L9;
        if (r102 == (-1)) goto L8;
        r100.setPivotX(r102);
        return;
    L8:
        r100.setPivotX(r100.getWidth() * 0.5f);
        return;
    L9:
        r100.setPivotX(r100.getWidth());
        return;
    L12:
        if (r101 != 1) goto L22;
        int r103 = this.f420446b;
        if (r103 == (-2)) goto L18;
        if (r103 == (-1)) goto L17;
        r100.setPivotY(r103);
        return;
    L17:
        r100.setPivotY(r100.getHeight() * 0.5f);
        return;
    L18:
        r100.setPivotY(r100.getHeight());
        return;
    }

    public Pivot(int r100, int r101) {
        this.f420445a = r100;
        this.f420446b = r101;
    }
}
