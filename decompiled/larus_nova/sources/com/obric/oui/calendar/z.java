package com.obric.oui.calendar;

import android.R;
import android.animation.Animator;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes33.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f399369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public mla.g f399370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f399371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f399372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f399373e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Interpolator f399374f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f399375g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f399376h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CalendarDay f399377i;

    public class a extends com.obric.oui.calendar.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f399378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f399379b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ z f399380c;

        @Override // com.obric.oui.calendar.a, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            z r101 = this.f399380c;
            r101.b(r101.f399369a, 0);
            this.f399380c.f399369a.setAlpha(1.0f);
        }

        @Override // com.obric.oui.calendar.a, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f399380c.f399369a.setText(this.f399378a);
            z r101 = this.f399380c;
            r101.b(r101.f399369a, this.f399379b);
            ViewPropertyAnimator r102 = this.f399380c.f399369a.animate();
            if (this.f399380c.f399375g != 1) goto L5;
            r102.translationX(0.0f);
        L6:
            r102.alpha(1.0f).setDuration(this.f399380c.f399372d).setInterpolator(this.f399380c.f399374f).setListener(new com.obric.oui.calendar.a()).start();
            return;
        L5:
            r102.translationY(0.0f);
            goto L6
        }

        public a(z r100, CharSequence r101, int r102) {
            this.f399380c = r100;
            this.f399378a = r101;
            this.f399379b = r102;
        }
    }

    public z(TextView r100) {
        this.f399370b = mla.g.f514383a;
        this.f399374f = new DecelerateInterpolator(2.0f);
        this.f399375g = 0;
        this.f399376h = 0;
        this.f399377i = null;
        this.f399369a = r100;
        Resources r101 = r100.getResources();
        this.f399371c = 400;
        this.f399372d = r101.getInteger(R.integer.config_shortAnimTime) / 2;
        this.f399373e = (int) TypedValue.applyDimension(1, 20.0f, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
    }

    public final void b(TextView r100, int r101) {
        if (this.f399375g != 1) goto L5;
        r100.setTranslationX(r101);
        return;
    L5:
        r100.setTranslationY(r101);
    }

    public final void a(long r100, CalendarDay r101, boolean r102) {
        this.f399369a.animate().cancel();
        b(this.f399369a, 0);
        this.f399369a.setAlpha(1.0f);
        this.f399376h = r100;
        CharSequence r103 = this.f399370b.a(r101);
        if (r102 == true) goto L5;
        this.f399369a.setText(r103);
    L14:
        this.f399377i = r101;
        return;
    L5:
        int r104 = this.f399373e;
        if (this.f399377i.f399162a.isBefore(r101.f399162a) == false) goto L8;
        int r105 = 1;
    L9:
        int r106 = r104 * r105;
        ViewPropertyAnimator r107 = this.f399369a.animate();
        if (this.f399375g != 1) goto L12;
        r107.translationX(r106 * (-1));
    L13:
        r107.alpha(0.0f).setDuration(this.f399372d).setInterpolator(this.f399374f).setListener(new a(this, r103, r106)).start();
        goto L14
    L12:
        r107.translationY(r106 * (-1));
        goto L13
    L8:
        r105 = -1;
        goto L9
    }
}
