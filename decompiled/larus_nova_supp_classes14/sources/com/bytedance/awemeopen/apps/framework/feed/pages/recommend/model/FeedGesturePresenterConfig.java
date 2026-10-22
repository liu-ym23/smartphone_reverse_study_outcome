package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model;

import android.view.MotionEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class FeedGesturePresenterConfig {
    public Function0<Unit> a;
    public Function0<Boolean> b;
    public Function3<? super MotionEvent, ? super MotionEvent, ? super MotionEvent, Boolean> c;
    public Function0<Boolean> d;
    public Function0<Boolean> e;
    public Function0<Boolean> f;
    public Function0<Unit> g;
    public Function0<Unit> h;
    public Function1<? super Float, Unit> i;
    public boolean j;

    public FeedGesturePresenterConfig() {
        this.f = FeedGesturePresenterConfig$showReportItem$1.INSTANCE;
    }
}
