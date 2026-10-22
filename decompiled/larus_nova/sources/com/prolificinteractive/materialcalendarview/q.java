package com.prolificinteractive.materialcalendarview;

import android.R;
import android.animation.Animator;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes34.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f404520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gpa.g f404521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f404522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f404523d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f404524e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Interpolator f404525f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f404526g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f404527h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CalendarDay f404528i;

    public class a extends com.prolificinteractive.materialcalendarview.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f404529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f404530b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ q f404531c;

        @Override // com.prolificinteractive.materialcalendarview.a, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            q r101 = this.f404531c;
            r101.b(r101.f404520a, 0);
            this.f404531c.f404520a.setAlpha(1.0f);
        }

        @Override // com.prolificinteractive.materialcalendarview.a, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f404531c.f404520a.setText(this.f404529a);
            q r101 = this.f404531c;
            r101.b(r101.f404520a, this.f404530b);
            ViewPropertyAnimator r102 = this.f404531c.f404520a.animate();
            if (this.f404531c.f404526g != 1) goto L5;
            r102.translationX(0.0f);
        L6:
            r102.alpha(1.0f).setDuration(this.f404531c.f404523d).setInterpolator(this.f404531c.f404525f).setListener(new com.prolificinteractive.materialcalendarview.a()).start();
            return;
        L5:
            r102.translationY(0.0f);
            goto L6
        }

        public a(q r100, CharSequence r101, int r102) {
            this.f404531c = r100;
            this.f404529a = r101;
            this.f404530b = r102;
        }
    }

    public q(AppCompatTextView r100) {
        this.f404521b = gpa.g.f482139a;
        this.f404525f = new DecelerateInterpolator(2.0f);
        this.f404526g = 0;
        this.f404527h = 0;
        this.f404528i = null;
        this.f404520a = r100;
        Resources r101 = r100.getResources();
        this.f404522c = 400;
        this.f404523d = r101.getInteger(R.integer.config_shortAnimTime) / 2;
        this.f404524e = (int) TypedValue.applyDimension(1, 20.0f, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
    }

    public final void b(TextView r100, int r101) {
        if (this.f404526g != 1) goto L5;
        r100.setTranslationX(r101);
        return;
    L5:
        r100.setTranslationY(r101);
    }

    public final void a(long r100, CalendarDay r101, boolean r102) {
        this.f404520a.animate().cancel();
        b(this.f404520a, 0);
        this.f404520a.setAlpha(1.0f);
        this.f404527h = r100;
        CharSequence r103 = this.f404521b.a(r101);
        if (r102 == true) goto L5;
        this.f404520a.setText(r103);
    L14:
        this.f404528i = r101;
        return;
    L5:
        int r104 = this.f404524e;
        if (this.f404528i.f404402a.isBefore(r101.f404402a) == false) goto L8;
        int r105 = 1;
    L9:
        int r106 = r104 * r105;
        ViewPropertyAnimator r107 = this.f404520a.animate();
        if (this.f404526g != 1) goto L12;
        r107.translationX(r106 * (-1));
    L13:
        r107.alpha(0.0f).setDuration(this.f404523d).setInterpolator(this.f404525f).setListener(new a(this, r103, r106)).start();
        goto L14
    L12:
        r107.translationY(r106 * (-1));
        goto L13
    L8:
        r105 = -1;
        goto L9
    }
}
