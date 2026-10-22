package com.bytedance.android.livesdk.livecommerce.iron.ui.atmosphere;

import android.animation.Animator;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.widget.ECHotAtmosphereView;
import com.bytedance.android.ec.model.response.ECAtmosphere;
import com.bytedance.android.ec.model.response.ECAtmosphereItem;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/atmosphere/ECAtmosphereView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/livecommerce/iron/ui/atmosphere/ECAtmosphereView$b;", "atmosphereListener", "", "setListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECAtmosphereView extends FrameLayout {
    public static final /* synthetic */ int k = 0;
    public final List<Object> a;
    public final List<Runnable> b;
    public Runnable c;
    public boolean d;
    public b e;
    public CountDownTimer f;
    public boolean g;
    public ViewPropertyAnimator h;
    public final ECHotAtmosphereView i;
    public final ECOtherAtmosphereView j;

    public static final class a {
    }

    public interface b extends ECOtherAtmosphereView.b {
        void c();

        void d(ECAtmosphereItem r1);

        void e(ECHotAtmosphereView r1);
    }

    public static final class c implements Animator.AnimatorListener {
        public final /* synthetic */ ECAtmosphereView a;
        public final /* synthetic */ View b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Long d;

        public static final class a extends CountDownTimer {
            public final /* synthetic */ c a;

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.iron.ui.atmosphere.ECAtmosphereView$c$a$a, reason: collision with other inner class name */
            public static final class RunnableC0072a implements Runnable {
                public final /* synthetic */ a a;

                public RunnableC0072a(a r1) {
                    this.a = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    c r0 = this.a.a;     // Catch: Throwable -> L4
                    ECAtmosphereView r1 = r0.a;     // Catch: Throwable -> L4
                    View r2 = r0.b;     // Catch: Throwable -> L4
                    int r3 = ECAtmosphereView.k;     // Catch: Throwable -> L4
                    r1.c(r2, false, null);     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }
            }

            @Override // android.os.CountDownTimer
            public final void onTick(long r1) {
            }

            @Override // android.os.CountDownTimer
            public final void onFinish() {
                dm.a.a("ECAtmosphereView").a("CountDownTimer onFinish");
                if (((ArrayList) this.a.a.b).isEmpty() == false) goto L5;
                ECAtmosphereView r0 = this.a.a;
                r0.c = new RunnableC0072a(this);
                return;
            L5:
                c r1 = this.a;
                r1.a.c(r1.b, false, null);
            }

            public a(c r1, long r2, long r4) {
                this.a = r1;
                super(r2, r4);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r8) {
            Intrinsics.checkNotNullParameter(r8, "animation");
            if (this.c == false) goto L12;
            Long r9 = this.d;
            if (r9 != null) goto L7;
        L11:
            this.a.g = true;
            return;
        L7:
            if (r9.longValue() <= 0) goto L11;
            ECAtmosphereView r10 = this.a;
            r10.g = false;
            r10.f = new a(this, this.d.longValue(), this.d.longValue());
            CountDownTimer r11 = this.a.f;
            if (r11 == null) goto L14;
            r11.start();
            return;
        L14:
            return;
        L12:
            ECAtmosphereView r12 = this.a;
            r12.d = false;
            r12.d();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.b.setVisibility(0);
        }

        public c(ECAtmosphereView r1, View r2, boolean r3, Long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public ECAtmosphereView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECAtmosphereView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void d() {
        if (this.d == true) goto L5;
    L12:
        this.d = true;
        Runnable r0 = (Runnable) CollectionsKt.removeFirstOrNull(this.b);
        if (r0 == null) goto L17;
        r0.run();
        return;
    L17:
        return;
    L5:
        if (this.g == true) goto L12;
        Runnable r1 = this.c;
        if (r1 == null) goto L16;
        if (r1 == null) goto L10;
        r1.run();
    L10:
        this.c = null;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ((ArrayList) this.a).clear();
        ((ArrayList) this.b).clear();
        this.c = null;
        this.d = false;
        CountDownTimer r2 = this.f;
        if (r2 == null) goto L5;
        r2.cancel();
    L5:
        this.f = null;
        this.g = false;
        ViewPropertyAnimator r1 = this.h;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        this.h = null;
        ECHotAtmosphereView r0 = this.i;
        r0.i();
        r0.setVisibility(8);
        r0.setAlpha(0.0f);
        ECOtherAtmosphereView r3 = this.j;
        r3.setVisibility(8);
        r3.setAlpha(0.0f);
        super.onDetachedFromWindow();
    }

    public final void a(ECAtmosphere r5) {
        Intrinsics.checkNotNullParameter(r5, "atmospheres");
        if ((CollectionsKt.firstOrNull(this.a) instanceof ECHotAtmosphere) == false) goto L5;
        return;
    L5:
        List r6 = r5.getAtmosphereItems();
        List r0 = r6;
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        return;
    L14:
        Iterator r7 = r6.iterator();
    L16:
        if (r7.hasNext() == false) goto L18;
        ECAtmosphereItem r2 = (ECAtmosphereItem) r7.next();
        List<Runnable> r3 = this.b;
        ArrayList r4 = (ArrayList) r3;
        r4.add(new com.bytedance.android.livesdk.livecommerce.iron.ui.atmosphere.a(this, r2));
        goto L16
    L18:
        ((ArrayList) this.a).addAll(r0);
        d();
        return;
    L8:
        if (r0.isEmpty() == true) goto L11;
        r1 = false;
        goto L12
    }

    public final void b(ECHotAtmosphere r3) {
        Intrinsics.checkNotNullParameter(r3, "hotAtmosphere");
        ((ArrayList) this.a).clear();
        ((ArrayList) this.a).add(r3);
        ((ArrayList) this.b).clear();
        List<Runnable> r0 = this.b;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new com.bytedance.android.livesdk.livecommerce.iron.ui.atmosphere.b(this, r3));
        d();
    }

    public final void setListener(b r1) {
        this.e = r1;
    }

    public ECAtmosphereView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new ArrayList();
        this.b = new ArrayList();
        th.a.c(r2, 2131564715, this, true);
        this.i = findViewById(2131374531);
        this.j = (ECOtherAtmosphereView) findViewById(2131381724);
    }

    public final void c(View r3, boolean r4, Long r5) {
        ViewPropertyAnimator r0 = r3.animate();
        if (r4 == false) goto L5;
        float r1 = 1.0f;
    L6:
        ViewPropertyAnimator r2 = r0.alpha(r1);
        r2.setListener(new c(this, r3, r4, r5));
        if (r4 == false) goto L9;
        long r6 = 240;
    L10:
        r2.setDuration(r6);
        r2.start();
        Unit r7 = Unit.INSTANCE;
        this.h = r2;
        return;
    L9:
        r6 = 160;
        goto L10
    L5:
        r1 = 0.0f;
        goto L6
    }

    public /* synthetic */ ECAtmosphereView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
