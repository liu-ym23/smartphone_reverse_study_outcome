package com.ss.android.ugc.aweme.search.common.view.refreshdepend;

import android.view.animation.Animation;

/* JADX INFO: loaded from: classes40.dex */
public abstract class SwipeRefreshCustomUI {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f452426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f452427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f452428c;

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.search.common.view.refreshdepend.SwipeRefreshCustomUI$1, reason: invalid class name */
    public class AnonymousClass1 implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Animation.AnimationListener f452429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SwipeRefreshCustomUI f452430b;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            Animation.AnimationListener r101 = this.f452429a;
            if (r101 == null) goto L5;
            r101.onAnimationEnd(r100);
        L5:
            this.f452430b.c(true);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
            Animation.AnimationListener r101 = this.f452429a;
            if (r101 == null) goto L6;
            r101.onAnimationRepeat(r100);
            return;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
            Animation.AnimationListener r101 = this.f452429a;
            if (r101 == null) goto L6;
            r101.onAnimationStart(r100);
            return;
        }

        public AnonymousClass1(SwipeRefreshCustomUI r100, Animation.AnimationListener r101) {
            this.f452430b = r100;
            this.f452429a = r101;
        }
    }

    public abstract void b();

    public SwipeRefreshCustomUI() {
        this.f452427b = true;
    }

    static {
    }

    public final Animation.AnimationListener a(Animation.AnimationListener r100) {
        return new AnonymousClass1(this, r100);
    }

    public final void c(boolean r100) {
        if (this.f452427b != r100) goto L5;
        return;
    L5:
        this.f452427b = r100;
        if (r100 == false) goto L18;
        Boolean r101 = this.f452428c;
        if (r101 == null) goto L19;
        boolean r102 = r101.booleanValue();
        if (this.f452426a != r102) goto L13;
    L16:
        this.f452428c = null;
        return;
    L13:
        if (this.f452427b == true) goto L15;
        this.f452428c = Boolean.valueOf(r102);
        goto L16
    L15:
        this.f452426a = r102;
        b();
        goto L16
    L19:
        return;
    }
}
