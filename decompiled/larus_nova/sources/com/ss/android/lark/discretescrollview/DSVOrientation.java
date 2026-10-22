package com.ss.android.lark.discretescrollview;

import android.graphics.Point;
import android.view.View;

/* JADX INFO: loaded from: classes35.dex */
public abstract enum DSVOrientation extends Enum<DSVOrientation> {
    private static final /* synthetic */ DSVOrientation[] $VALUES = null;
    public static final DSVOrientation HORIZONTAL = null;
    public static final DSVOrientation VERTICAL = null;

    public interface a {
        int a(int r100, int r101);

        void b(Direction r100, int r101, Point r102);

        int c(int r100);

        float d(Point r100, float r101, float r102);

        int e(int r100);

        void f(int r100, com.ss.android.lark.discretescrollview.a r101);

        boolean g(Point r100, int r101, int r102, int r103, int r104);

        int h(int r100, int r101);

        boolean i();

        void j(Point r100, int r101, Point r102);

        int k(int r100, int r101);

        boolean l();

        boolean m(DiscreteScrollLayoutManager r100);
    }

    public static class b implements a {
        public b() {
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final int a(int r100, int r101) {
            return r100;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final int c(int r100) {
            return 0;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final int e(int r100) {
            return r100;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final int h(int r100, int r101) {
            return r100;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final boolean i() {
            return true;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final int k(int r100, int r101) {
            return r100;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final boolean l() {
            return false;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final boolean m(DiscreteScrollLayoutManager r100) {
            View r101 = r100.B.f420444a.getChildAt(0);
            com.ss.android.lark.discretescrollview.a r102 = r100.B;
            View r103 = r102.f420444a.getChildAt(r102.a() - 1);
            int r104 = -r100.f420418f;
            int r105 = r100.getWidth() + r100.f420418f;
            if (r100.getDecoratedLeft(r101) > r104) goto L5;
        L7:
            boolean r106 = false;
        L9:
            if (r100.getDecoratedRight(r103) < r105) goto L11;
        L13:
            boolean r107 = false;
        L14:
            if (r106 == true) goto L16;
            if (r107 == true) goto L16;
            return false;
        L16:
            return true;
        L11:
            if (r100.getPosition(r103) >= (r100.getItemCount() - 1)) goto L13;
            r107 = true;
            goto L14
        L5:
            if (r100.getPosition(r101) <= 0) goto L7;
            r106 = true;
            goto L9
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final void f(int r100, com.ss.android.lark.discretescrollview.a r101) {
            r101.f420444a.offsetChildrenHorizontal(r100);
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final void b(Direction r100, int r101, Point r102) {
            r102.set(r102.x + r100.applyTo(r101), r102.y);
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final float d(Point r100, float r101, float r102) {
            return r101 - r100.x;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final void j(Point r100, int r101, Point r102) {
            r102.set(r100.x - r101, r100.y);
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final boolean g(Point r100, int r101, int r102, int r103, int r104) {
            int r105 = r100.x;
            int r106 = r105 - r101;
            int r107 = r105 + r101;
            if (r106 < (r103 + r104)) goto L5;
        L7:
            return false;
        L5:
            if (r107 <= (-r104)) goto L7;
            return true;
        }
    }

    public static class c implements a {
        public c() {
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final int a(int r100, int r101) {
            return r101;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final int c(int r100) {
            return r100;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final int e(int r100) {
            return 0;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final int h(int r100, int r101) {
            return r101;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final boolean i() {
            return false;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final int k(int r100, int r101) {
            return r101;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final boolean l() {
            return true;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final boolean m(DiscreteScrollLayoutManager r100) {
            View r101 = r100.B.f420444a.getChildAt(0);
            com.ss.android.lark.discretescrollview.a r102 = r100.B;
            View r103 = r102.f420444a.getChildAt(r102.a() - 1);
            int r104 = -r100.f420418f;
            int r105 = r100.getHeight() + r100.f420418f;
            if (r100.getDecoratedTop(r101) > r104) goto L5;
        L7:
            boolean r106 = false;
        L9:
            if (r100.getDecoratedBottom(r103) < r105) goto L11;
        L13:
            boolean r107 = false;
        L14:
            if (r106 == true) goto L16;
            if (r107 == true) goto L16;
            return false;
        L16:
            return true;
        L11:
            if (r100.getPosition(r103) >= (r100.getItemCount() - 1)) goto L13;
            r107 = true;
            goto L14
        L5:
            if (r100.getPosition(r101) <= 0) goto L7;
            r106 = true;
            goto L9
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final void f(int r100, com.ss.android.lark.discretescrollview.a r101) {
            r101.f420444a.offsetChildrenVertical(r100);
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final void b(Direction r100, int r101, Point r102) {
            int r103 = r102.y + r100.applyTo(r101);
            r102.set(r102.x, r103);
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final float d(Point r100, float r101, float r102) {
            return r102 - r100.y;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final void j(Point r100, int r101, Point r102) {
            int r103 = r100.y - r101;
            r102.set(r100.x, r103);
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final boolean g(Point r100, int r101, int r102, int r103, int r104) {
            int r105 = r100.y;
            int r106 = r105 - r102;
            int r107 = r105 + r102;
            if (r106 < (r103 + r104)) goto L5;
        L7:
            return false;
        L5:
            if (r107 <= (-r104)) goto L7;
            return true;
        }
    }

    public abstract a createHelper();

    static {
        final String r100 = "HORIZONTAL";
        final int r101 = 0;
        DSVOrientation r102 = new AnonymousClass1(r100, r101);
        HORIZONTAL = r102;
        final String r103 = "VERTICAL";
        final int r104 = 1;
        DSVOrientation r105 = new AnonymousClass2(r103, r104);
        VERTICAL = r105;
        $VALUES = new DSVOrientation[]{r102, r105};
    }

    public static DSVOrientation[] values() {
        return (DSVOrientation[]) $VALUES.clone();
    }

    public static DSVOrientation valueOf(String r100) {
        return (DSVOrientation) r27.a.a(DSVOrientation.class, r100);
    }

    private DSVOrientation(String r100, int r101) {
        super(r100, r101);
    }

    public /* synthetic */ DSVOrientation(String r100, int r101, AnonymousClass1 r102) {
        this(r100, r101);
    }
}
