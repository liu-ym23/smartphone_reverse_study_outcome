package com.bytedance.awemeopen.apps.framework.base.view;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/* JADX INFO: loaded from: classes14.dex */
public class PeriscopeLayout extends FrameLayout implements e {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f193191o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f193192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f193193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout.LayoutParams f193194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable[] f193195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Random f193196e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Queue<ImageView> f193197f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f193198g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f193199h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f193200i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f193201j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Handler f193202k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f193203l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f193204m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f193205n;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PeriscopeLayout f193206a;

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void a() {
            PeriscopeLayout r100 = this.f193206a;
            int r101 = PeriscopeLayout.f193191o;
            Context r102 = r100.getContext();
            if ((r102 instanceof Activity) == false) goto L5;
            boolean r103 = !((Activity) r102).isDestroyed();
        L6:
            if (r103 == false) goto L29;
            PeriscopeLayout r104 = this.f193206a;
            if (r104.f193200i != 0) goto L11;
            return;
        L11:
            if (r104.f193197f.isEmpty() == false) goto L13;
            ImageView r105 = new ImageView(r104.getContext());
            r105.setLayoutParams(r104.f193194c);
            r104.addView(r105);
            ImageView r106 = r105;
        L14:
            Drawable[] r107 = r104.f193195d;
            int r108 = r104.f193205n;
            r104.f193205n = r108 + 1;
            r106.setImageDrawable(r107[r108 % 2]);
            float r109 = n0.a(r104.getContext(), 48.0f);
            float r110 = n0.a(r104.getContext(), 20.0f);
            float r111 = n0.a(r104.getContext(), 20.0f);
            if (r104.f193204m == false) goto L17;
            float r112 = r104.f193193b;
            r109 = (r112 - r109) - r111;
            r110 = (r112 - r110) - r111;
        L17:
            com.bytedance.awemeopen.apps.framework.utils.i r113 = new com.bytedance.awemeopen.apps.framework.utils.i(new PointF(r109, (r104.f193192a - r104.f193198g) - n0.a(r104.getContext(), 8.0f)), new PointF(r110, n0.a(r104.getContext(), 51.0f)));
            Object[] r114 = new Object[2];
            if (r104.f193204m == false) goto L20;
            float r115 = r104.f193199h - r111;
        L21:
            r114[0] = new PointF(r115, (r104.f193192a - r104.f193198g) - n0.a(r104.getContext(), 2.0f));
            if (r104.f193204m == false) goto L24;
            float r116 = (r104.f193193b - r111) - n0.a(r104.getContext(), r104.f193196e.nextInt(30) + 12);
        L25:
            r114[1] = new PointF(r116, 0.0f);
            ValueAnimator r117 = ValueAnimator.ofObject(r113, r114);
            ValueAnimator.AnimatorUpdateListener r118 = new b(r104, r106);
            r117.addUpdateListener(r118);
            r117.setTarget(r106);
            r106.setTag(R.id.aos_tag_animation_update_listener, r118);
            r117.setDuration(r104.f193201j);
            r106.setTag(r117);
            r117.start();
            PeriscopeLayout r119 = this.f193206a;
            Handler r120 = r119.f193202k;
            if (r120 == null) goto L30;
            r120.postDelayed(this, r119.f193200i);
            return;
        L30:
            return;
        L24:
            r116 = n0.a(r104.getContext(), r104.f193196e.nextInt(30) + 12);
            goto L25
        L20:
            r115 = r104.f193193b - r104.f193199h;
            goto L21
        L13:
            r106 = (ImageView) ((LinkedList) r104.f193197f).poll();
            goto L14
        L29:
            return;
        L5:
            r103 = false;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(PeriscopeLayout r100) {
            this.f193206a = r100;
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f193207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f193208b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f193209c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.bytedance.awemeopen.apps.framework.utils.b f193210d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ PeriscopeLayout f193211e;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            View r101 = this.f193207a;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.getTag() == null) goto L34;
            com.bytedance.awemeopen.apps.framework.utils.b r102 = this.f193210d;
            if (r102 == null) goto L15;
            r102.getClass();
            long r103 = SystemClock.uptimeMillis();
            if ((r103 - r102.f197677a) > 34) goto L12;
            boolean r104 = true;
        L13:
            if (r104 == false) goto L15;
            return;
        L12:
            r102.f197677a = r103;
            r104 = false;
        L15:
            PointF r105 = (PointF) r100.getAnimatedValue();
            this.f193207a.setX(r105.x);
            this.f193207a.setY(r105.y);
            float r106 = r100.getAnimatedFraction();
            if (r106 > 0.7f) goto L19;
            float r107 = r106 / 0.7f;
            this.f193207a.setAlpha(0.7f * r107);
            float r108 = (r107 * 0.3f) + 0.3f;
            this.f193207a.setScaleX(r108);
            this.f193207a.setScaleY(r108);
        L28:
            if (r106 > 0.5f) goto L30;
            this.f193207a.setRotation(((r106 / 0.5f) * 20.0f) * this.f193208b);
            return;
        L30:
            this.f193207a.setRotation(((((r106 - 0.5f) / 0.5f) * 20.0f) * this.f193209c) + (this.f193208b * 20));
            return;
        L19:
            if (r106 > 0.8f) goto L22;
            this.f193207a.setAlpha(0.7f);
            this.f193207a.setScaleX(0.6f);
            this.f193207a.setScaleY(0.6f);
            goto L28
        L22:
            if (r106 > 1.0f) goto L28;
            float r109 = (r106 - 0.8f) / 0.2f;
            this.f193207a.setAlpha((1.0f - r109) * 0.7f);
            float r110 = (r109 * 0.1f) + 0.6f;
            this.f193207a.setScaleX(r110);
            this.f193207a.setScaleY(r110);
            if ((1.0f - r106) >= 1.0E-10d) goto L28;
            PeriscopeLayout r111 = this.f193211e;
            View r112 = this.f193207a;
            int r113 = PeriscopeLayout.f193191o;
            r111.b(r112);
            return;
        }

        public b(PeriscopeLayout r100, View r101) {
            this.f193211e = r100;
            this.f193207a = r101;
            int r102 = -1;
            if (r100.f193196e.nextBoolean() == false) goto L5;
            int r103 = 1;
        L6:
            this.f193208b = r103;
            if (r100.f193196e.nextBoolean() == false) goto L9;
            r102 = 1;
        L9:
            this.f193209c = r102;
            this.f193210d = new com.bytedance.awemeopen.apps.framework.utils.b();
            return;
        L5:
            r103 = -1;
            goto L6
        }
    }

    public final void a() {
        this.f193197f = new LinkedList();
        this.f193195d = new Drawable[2];
        Drawable r100 = getResources().getDrawable(R.drawable.aos_legacy_ic_home_musicnote1);
        Drawable r101 = getResources().getDrawable(R.drawable.aos_legacy_ic_home_musicnote2);
        Drawable[] r102 = this.f193195d;
        r102[0] = r100;
        r102[1] = r101;
        this.f193198g = r100.getIntrinsicHeight();
        this.f193199h = r100.getIntrinsicWidth();
        this.f193194c = new FrameLayout.LayoutParams(this.f193199h, this.f193198g);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.e
    public final void w() {
        this.f193201j = 3000;
        this.f193200i = 800;
        this.f193202k.removeCallbacksAndMessages(null);
        this.f193202k.postDelayed(this.f193203l, this.f193196e.nextInt(4) * 100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f193202k.removeCallbacksAndMessages(null);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.e
    public final void stop() {
        int r100 = getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        b(getChildAt(r101));
        r101 = r101 + 1;
        goto L3
    L5:
        this.f193200i = 0;
        this.f193202k.removeCallbacksAndMessages(null);
        this.f193202k.removeCallbacks(this.f193203l);
    }

    public PeriscopeLayout(Context r100) {
        super(r100);
        this.f193196e = new Random();
        this.f193202k = new Handler(Looper.getMainLooper());
        this.f193203l = new a(this);
        this.f193205n = 0;
        a();
    }

    public final void b(View r100) {
        if (r100.getTag() != null) goto L5;
        return;
    L5:
        LinkedList r101 = (LinkedList) this.f193197f;
        r101.add((ImageView) r100);
        ValueAnimator r102 = (ValueAnimator) r100.getTag();
        if (r102 == null) goto L9;
        r102.setTarget(null);
        r102.cancel();
        r102.removeAllUpdateListeners();
    L9:
        if ((r100.getTag(R.id.aos_tag_animation_update_listener) instanceof b) == false) goto L13;
        b r103 = (b) r100.getTag(R.id.aos_tag_animation_update_listener);
        if (r103 == null) goto L13;
        r103.f193207a = null;
    L13:
        r100.setAlpha(0.0f);
        r100.setScaleX(0.3f);
        r100.setScaleY(0.3f);
        r100.setRotation(0.0f);
        r100.setTag(null);
    }

    public PeriscopeLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f193196e = new Random();
        this.f193202k = new Handler(Looper.getMainLooper());
        this.f193203l = new a(this);
        this.f193205n = 0;
        a();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f193193b = getMeasuredWidth();
        this.f193192a = getMeasuredHeight();
        boolean r102 = true;
        if (ViewCompat.getLayoutDirection(this) == 1) goto L6;
        r102 = false;
    L6:
        this.f193204m = r102;
    }

    public PeriscopeLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f193196e = new Random();
        this.f193202k = new Handler(Looper.getMainLooper());
        this.f193203l = new a(this);
        this.f193205n = 0;
        a();
    }
}
