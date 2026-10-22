package com.ss.android.lark.todo.impl.features.detail.time;

import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes38.dex */
public final class v implements c18.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoTimePickerFragment f443579a;

    public v(TodoTimePickerFragment r100) {
        this.f443579a = r100;
    }

    @Override // c18.a
    public final void a(int r100, int r101, int r102, int r110, int r111) {
        TodoTimePickerFragment r103 = this.f443579a;
        if (r103.f443534q == false) goto L5;
        r103.f443525h = r110;
        r103.f443526i = r111;
    L6:
        int r104 = k8c.a.f502137a;
        GregorianCalendar r105 = k8c.a.b(r103.f443522e, r103.f443523f, r103.f443524g, r103.f443525h, r103.f443526i, 96);
        TodoTimePickerFragment r106 = this.f443579a;
        if (r105.compareTo(k8c.a.b(r106.f443528k, r106.f443529l, r106.f443530m, r106.f443531n, r106.f443532o, 96)) <= 0) goto L12;
        TodoTimePickerFragment r107 = this.f443579a;
        if (r107.f443534q == false) goto L11;
        r107.f443531n = r107.f443525h;
        r107.f443532o = r107.f443526i;
        goto L12
    L11:
        r107.f443525h = r107.f443531n;
        r107.f443526i = r107.f443532o;
    L12:
        this.f443579a.ca0();
        this.f443579a.ea0(false);
        return;
    L5:
        r103.f443531n = r110;
        r103.f443532o = r111;
        goto L6
    }
}
