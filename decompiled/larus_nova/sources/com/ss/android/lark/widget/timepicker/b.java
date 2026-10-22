package com.ss.android.lark.widget.timepicker;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements e18.a<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f448988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f448989b;

    public final class a implements e18.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f448990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f448991b;

        @Override // e18.c
        public final String a() {
            int r100 = this.f448991b.getItemsCount();
            int r101 = this.f448990a;
            boolean r102 = false;
            if (r101 < 0) goto L6;
            if (r101 >= r100) goto L6;
            r102 = true;
        L6:
            if (r102 == false) goto L8;
            int r103 = (this.f448991b.f448988a + r101) - 1;
        L9:
            if (r103 >= 0) goto L11;
            return "";
        L11:
            if (r103 < 12) goto L14;
            return "";
        L14:
            return String.valueOf(r103 + 1);
        L8:
            r103 = -1;
            goto L9
        }

        public a(b r100, int r101) {
            this.f448991b = r100;
            this.f448990a = r101;
        }
    }

    @Override // e18.a
    public final int getItemsCount() {
        return (this.f448989b - this.f448988a) + 1;
    }

    @Override // e18.a
    public final int a(Object r100) {
        return e18.a.C5729a.a(this, r100);
    }

    @Override // e18.a
    public final a getItem(int r100) {
        return new a(this, r100);
    }

    @Override // e18.a
    public final int indexOf(a r100) {
        a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "o");
        return r101.f448990a;
    }

    public b(int r100, int r101) {
        this.f448988a = r100;
        this.f448989b = r101;
    }
}
