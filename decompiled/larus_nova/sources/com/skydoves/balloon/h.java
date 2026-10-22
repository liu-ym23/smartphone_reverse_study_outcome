package com.skydoves.balloon;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class h implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Balloon f406151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f406152b;

    public h(Balloon r100, k r101) {
        this.f406151a = r100;
        this.f406152b = r101;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r101.getAction() != 4) goto L12;
        Balloon r102 = this.f406151a;
        if (r102.f406019b.S == false) goto L7;
        r102.h();
    L7:
        p r103 = this.f406152b;
        if (r103 == null) goto L14;
        r103.a(r100, r101);
        return true;
    L14:
        return true;
    L12:
        return false;
    }
}
