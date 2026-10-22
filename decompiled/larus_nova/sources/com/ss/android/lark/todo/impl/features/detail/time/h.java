package com.ss.android.lark.todo.impl.features.detail.time;

/* JADX INFO: loaded from: classes38.dex */
public final class h implements l08.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoTimePickerFragment f443560a;

    public h(TodoTimePickerFragment r100) {
        this.f443560a = r100;
    }

    @Override // l08.a
    public final void a(int r100, int r110, int r111) {
        TodoTimePickerFragment r101 = this.f443560a;
        r101.f443527j = true;
        r101.f443522e = r100;
        r101.f443523f = r110;
        r101.f443524g = r111;
        int r102 = k8c.a.f502137a;
        long r103 = k8c.a.b(r100, r110, r111, r101.f443525h, r101.f443526i, 96).getTimeInMillis();
        TodoTimePickerFragment r112 = this.f443560a;
        if (r103 <= k8c.a.b(r112.f443528k, r112.f443529l, r112.f443530m, r112.f443531n, r112.f443532o, 96).getTimeInMillis()) goto L8;
        TodoTimePickerFragment r104 = this.f443560a;
        r104.f443528k = r104.f443522e;
        r104.f443529l = r104.f443523f;
        r104.f443530m = r104.f443524g;
        if (r104.f443535r == true) goto L7;
        r104.f443531n = r104.f443525h;
        r104.f443532o = r104.f443526i;
    L7:
        r104.Z90();
    L8:
        this.f443560a.ca0();
        this.f443560a.ea0(false);
    }
}
