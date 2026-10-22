package ja7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes19.dex */
public abstract class j extends i {

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ja7.a f497931a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f497932b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f497933c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ja7.a f497934d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ qa7.a.C7302a f497935e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ View f497936f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ qa7.a.C7302a f497937g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Runnable f497938h;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            super.onAnimationEnd(r100);
            if (this.f497931a.f497890c == true) goto L5;
            this.f497932b.setVisibility(8);
        L5:
            float r101 = this.f497933c;
            if (r101 <= 0.0f) goto L9;
            ViewCompat.setElevation(this.f497932b, r101);
        L9:
            if (this.f497934d.f497890c == false) goto L11;
            qa7.a.c(this.f497932b, this.f497935e);
        L13:
            if (this.f497931a.f497890c == false) goto L15;
            qa7.a.c(this.f497936f, this.f497937g);
        L16:
            this.f497938h.run();
            return;
        L15:
            qa7.a.b(this.f497936f);
            goto L16
        L11:
            qa7.a.b(this.f497932b);
            goto L13
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            super.onAnimationStart(r100);
        }

        public a(ja7.a r100, View r101, float r102, ja7.a r103, qa7.a.C7302a r104, View r105, qa7.a.C7302a r106, Runnable r107) {
            this.f497931a = r100;
            this.f497932b = r101;
            this.f497933c = r102;
            this.f497934d = r103;
            this.f497935e = r104;
            this.f497936f = r105;
            this.f497937g = r106;
            this.f497938h = r107;
        }
    }

    public class b implements qa7.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Animator f497939a;

        @Override // qa7.b.a
        public final void onCancel() {
            this.f497939a.end();
        }

        public b(Animator r100) {
            this.f497939a = r100;
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ja7.a f497940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f497941b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ qa7.a.C7302a f497942c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ja7.a f497943d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ View f497944e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ qa7.a.C7302a f497945f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Runnable f497946g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ j f497947h;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            super.onAnimationEnd(r100);
            if (this.f497940a.f497890c == false) goto L5;
            qa7.a.c(this.f497941b, this.f497942c);
        L7:
            if (this.f497943d.f497890c == false) goto L9;
            qa7.a.c(this.f497944e, this.f497945f);
        L10:
            this.f497947h.f497918a.getOverlay().remove(this.f497941b);
            this.f497946g.run();
            return;
        L9:
            qa7.a.b(this.f497944e);
            goto L10
        L5:
            qa7.a.b(this.f497941b);
            goto L7
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            super.onAnimationStart(r100);
        }

        public c(j r100, ja7.a r101, View r102, qa7.a.C7302a r103, ja7.a r104, View r105, qa7.a.C7302a r106, Runnable r107) {
            this.f497947h = r100;
            this.f497940a = r101;
            this.f497941b = r102;
            this.f497942c = r103;
            this.f497943d = r104;
            this.f497944e = r105;
            this.f497945f = r106;
            this.f497946g = r107;
        }
    }

    public class d implements qa7.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Animator f497948a;

        @Override // qa7.b.a
        public final void onCancel() {
            this.f497948a.end();
        }

        public d(Animator r100) {
            this.f497948a = r100;
        }
    }

    public abstract void e();

    public abstract Animator f(ja7.a r100, ja7.a r101);

    public abstract Animator g(ja7.a r100, ja7.a r101);

    public j() {
    }

    @Override // ja7.i
    public final void a(ja7.a r110, ja7.a r111, Runnable r112, qa7.b r113) {
        View r100 = r110.f497888a;
        View r101 = r111.f497888a;
        if (r110.f497890c == false) goto L5;
        qa7.a.C7302a r102 = qa7.a.a(r100);
    L7:
        if (r111.f497890c == false) goto L9;
        qa7.a.C7302a r103 = qa7.a.a(r101);
    L10:
        r100.setVisibility(0);
        this.f497918a.getOverlay().add(r100);
        Animator r104 = f(r110, r111);
        e();
        r104.addListener(new c(this, r110, r100, r102, r111, r101, r103, r112));
        r104.start();
        r113.b(new d(r104));
        return;
    L9:
        qa7.a.b(r101);
        r103 = null;
        goto L10
    L5:
        qa7.a.b(r100);
        r102 = null;
        goto L7
    }

    @Override // ja7.i
    public final void b(ja7.a r110, ja7.a r111, Runnable r112, qa7.b r113) {
        View r100 = r110.f497888a;
        View r101 = r111.f497888a;
        if (r110.f497890c == false) goto L5;
        qa7.a.C7302a r102 = qa7.a.a(r100);
    L7:
        if (r111.f497890c == false) goto L9;
        qa7.a.C7302a r103 = qa7.a.a(r101);
    L10:
        r100.setVisibility(0);
        float r104 = ViewCompat.getElevation(r100);
        if (r104 <= 0.0f) goto L13;
        ViewCompat.setElevation(r100, 0.0f);
    L13:
        Animator r105 = g(r110, r111);
        e();
        r105.addListener(new a(r111, r100, r104, r110, r102, r101, r103, r112));
        r105.start();
        r113.b(new b(r105));
        return;
    L9:
        qa7.a.b(r101);
        r103 = null;
        goto L10
    L5:
        qa7.a.b(r100);
        r102 = null;
        goto L7
    }
}
