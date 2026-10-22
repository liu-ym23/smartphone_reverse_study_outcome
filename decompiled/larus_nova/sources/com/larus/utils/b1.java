package com.larus.utils;

import android.os.SystemClock;
import android.view.View;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f375364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f375365b;

    public /* synthetic */ b1(View r100, Function1 r101) {
        this.f375364a = r100;
        this.f375365b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        View r111 = this.f375364a;
        Function1 r100 = this.f375365b;
        long r101 = SystemClock.elapsedRealtime();
        Object r102 = r111.getTag(123400002);
        Long r103 = null;
        if ((r102 instanceof Long) == false) goto L5;
        Long r104 = (Long) r102;
    L6:
        if (r104 == null) goto L8;
        long r105 = r104.longValue();
    L9:
        long r106 = r101 - r105;
        Object r107 = r111.getTag(123400001);
        if ((r107 instanceof Long) == false) goto L12;
        r103 = (Long) r107;
    L12:
        if (r103 == null) goto L14;
        long r108 = r103.longValue();
    L16:
        if (r106 >= r108) goto L18;
        boolean r109 = true;
    L19:
        if (r109 == true) goto L21;
        r111.setTag(123400002, Long.valueOf(r101));
    L21:
        if (r109 == true) goto L24;
        r100.invoke(r111);
        return;
    L24:
        return;
    L18:
        r109 = false;
        goto L19
    L14:
        r108 = 500;
        goto L16
    L8:
        r105 = 0;
        goto L9
    L5:
        r104 = null;
        goto L6
    }
}
