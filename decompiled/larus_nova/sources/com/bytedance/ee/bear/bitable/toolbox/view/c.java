package com.bytedance.ee.bear.bitable.toolbox.view;

import android.view.GestureDetector;
import android.view.MotionEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements Function1<MotionEvent, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GestureDetector f216037a;

    public c(GestureDetector r100) {
        this.f216037a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(MotionEvent r100) {
        MotionEvent r101 = r100;
        if (r101 == null) goto L6;
        this.f216037a.onTouchEvent(r101);
    L6:
        return Unit.INSTANCE;
    }
}
