package com.ss.android.ugc.aweme.search.common.saas.autoplay;

import android.graphics.Rect;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes40.dex */
public abstract class ScrollStateObserver implements IScrollStateObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f452016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f452017b;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollStatus {
    }

    public int a() {
        return 0;
    }

    public abstract Rect b();

    public void c() {
    }

    public void d() {
    }

    public /* synthetic */ void e(int r100) {
        IScrollStateObserver.CC.$default$onSurfaceAvailable(this, r100);
    }

    public ScrollStateObserver() {
        this.f452016a = 0;
        this.f452017b = 0;
    }
}
