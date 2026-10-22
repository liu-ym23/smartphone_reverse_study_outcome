package com.bytedance.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.view.Choreographer;
import android.view.View;
import com.bytedance.lottie.model.layer.Layer;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes21.dex */
public final class LottieDrawable extends Drawable implements Drawable.Callback, Animatable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f264393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.lottie.d f264394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wz6.d f264395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f264396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<i> f264397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public pz6.b f264398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f264399g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public pz6.a f264400h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f264401i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.lottie.model.layer.b f264402j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f264403k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f264404l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f264405m;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    public class a implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f264406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LottieDrawable f264407b;

        @Override // com.bytedance.lottie.LottieDrawable.i
        public final void run() {
            this.f264407b.g(this.f264406a);
        }

        public a(LottieDrawable r100, int r101) {
            this.f264407b = r100;
            this.f264406a = r101;
        }
    }

    public class b implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f264408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LottieDrawable f264409b;

        @Override // com.bytedance.lottie.LottieDrawable.i
        public final void run() {
            this.f264409b.j(this.f264408a);
        }

        public b(LottieDrawable r100, float r101) {
            this.f264409b = r100;
            this.f264408a = r101;
        }
    }

    public class c implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ qz6.e f264410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f264411b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ xz6.c f264412c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ LottieDrawable f264413d;

        @Override // com.bytedance.lottie.LottieDrawable.i
        public final void run() {
            this.f264413d.a(this.f264410a, this.f264411b, this.f264412c);
        }

        public c(LottieDrawable r100, qz6.e r101, Object r102, xz6.c r103) {
            this.f264413d = r100;
            this.f264410a = r101;
            this.f264411b = r102;
            this.f264412c = r103;
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LottieDrawable f264414a;

        public d(LottieDrawable r100) {
            this.f264414a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            LottieDrawable r101 = this.f264414a;
            com.bytedance.lottie.model.layer.b r102 = r101.f264402j;
            if (r102 == null) goto L10;
            wz6.d r103 = r101.f264395c;
            com.bytedance.lottie.d r104 = r103.f561951j;
            if (r104 != null) goto L7;
            float r105 = 0.0f;
        L8:
            r102.n(r105);
            return;
        L7:
            float r106 = r103.f561947f;
            float r107 = r104.f264433j;
            r105 = (r106 - r107) / (r104.f264434k - r107);
            goto L8
        }
    }

    public class e implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LottieDrawable f264415a;

        @Override // com.bytedance.lottie.LottieDrawable.i
        public final void run() {
            this.f264415a.e();
        }

        public e(LottieDrawable r100) {
            this.f264415a = r100;
        }
    }

    public class f implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LottieDrawable f264416a;

        @Override // com.bytedance.lottie.LottieDrawable.i
        public final void run() {
            this.f264416a.f();
        }

        public f(LottieDrawable r100) {
            this.f264416a = r100;
        }
    }

    public class g implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f264417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LottieDrawable f264418b;

        @Override // com.bytedance.lottie.LottieDrawable.i
        public final void run() {
            this.f264418b.i(this.f264417a);
        }

        public g(LottieDrawable r100, int r101) {
            this.f264418b = r100;
            this.f264417a = r101;
        }
    }

    public class h implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f264419a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LottieDrawable f264420b;

        @Override // com.bytedance.lottie.LottieDrawable.i
        public final void run() {
            this.f264420b.h(this.f264419a);
        }

        public h(LottieDrawable r100, int r101) {
            this.f264420b = r100;
            this.f264419a = r101;
        }
    }

    public interface i {
        void run();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    public final void b() {
        com.bytedance.lottie.d r100 = this.f264394b;
        Rect r110 = r100.f264432i;
        Layer r111 = new Layer(Collections.emptyList(), r100, "__container", -1, Layer.LayerType.PreComp, -1, null, Collections.emptyList(), new rz6.l(), 0, 0, 0, 0.0f, 0.0f, r110.width(), r110.height(), null, null, Collections.emptyList(), Layer.MatteType.None, null);
        com.bytedance.lottie.d r101 = this.f264394b;
        this.f264402j = new com.bytedance.lottie.model.layer.b(this, r111, r101.f264431h, r101);
    }

    public final void c() {
        if (this.f264405m == false) goto L7;
        pz6.b r100 = this.f264398f;
        if (r100 == null) goto L7;
        r100.b();
    L7:
        wz6.d r101 = this.f264395c;
        if (r101.f561952k == false) goto L10;
        r101.cancel();
    L10:
        this.f264394b = null;
        this.f264402j = null;
        this.f264398f = null;
        wz6.d r102 = this.f264395c;
        r102.f561951j = null;
        r102.f561949h = -2.1474836E9f;
        r102.f561950i = 2.1474836E9f;
        invalidateSelf();
    }

    public final void e() {
        if (this.f264402j != null) goto L6;
        this.f264397e.add(new e(this));
        return;
    L6:
        wz6.d r100 = this.f264395c;
        r100.f561952k = true;
        boolean r101 = r100.e();
        Iterator r102 = ((CopyOnWriteArraySet) r100.f561943b).iterator();
    L8:
        if (r102.hasNext() == false) goto L14;
        Animator.AnimatorListener r103 = (Animator.AnimatorListener) r102.next();
        if (Build.VERSION.SDK_INT >= 26) goto L11;
        r103.onAnimationStart(r100);
        goto L8
    L11:
        r103.onAnimationStart(r100, r101);
        goto L8
    L14:
        if (r100.e() == false) goto L16;
        float r104 = r100.c();
    L17:
        r100.g((int) r104);
        r100.f561946e = System.nanoTime();
        r100.f561948g = 0;
        if (r100.f561952k == false) goto L27;
        r100.f(false);
        Choreographer.getInstance().postFrameCallback(r100);
        return;
    L27:
        return;
    L16:
        r104 = r100.d();
        goto L17
    }

    public final void f() {
        if (this.f264402j != null) goto L6;
        this.f264397e.add(new f(this));
        return;
    L6:
        wz6.d r100 = this.f264395c;
        r100.f561952k = true;
        r100.f(false);
        Choreographer.getInstance().postFrameCallback(r100);
        r100.f561946e = System.nanoTime();
        if (r100.e() == false) goto L12;
        if (r100.f561947f != r100.d()) goto L12;
        r100.f561947f = r100.c();
        return;
    L12:
        if (r100.e() == false) goto L14;
        return;
    L14:
        if (r100.f561947f != r100.c()) goto L19;
        r100.f561947f = r100.d();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        com.bytedance.lottie.d r100 = this.f264394b;
        if (r100 != null) goto L6;
        return -1;
    L6:
        return (int) (r100.f264432i.height() * this.f264396d);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        com.bytedance.lottie.d r100 = this.f264394b;
        if (r100 != null) goto L6;
        return -1;
    L6:
        return (int) (r100.f264432i.width() * this.f264396d);
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f264395c.f561952k;
    }

    public final void k() {
        com.bytedance.lottie.d r100 = this.f264394b;
        if (r100 != null) goto L5;
        return;
    L5:
        float r101 = this.f264396d;
        setBounds(0, 0, (int) (r100.f264432i.width() * r101), (int) (this.f264394b.f264432i.height() * r101));
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f264397e.clear();
        this.f264395c.b();
    }

    public LottieDrawable() {
        this.f264393a = new Matrix();
        wz6.d r100 = new wz6.d();
        this.f264395c = r100;
        this.f264396d = 1.0f;
        new HashSet();
        this.f264397e = new ArrayList();
        this.f264403k = 255;
        this.f264405m = true;
        r100.addUpdateListener(new d(this));
    }

    private Context getContext() {
        Drawable.Callback r100 = getCallback();
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof View) == true) goto L8;
        return null;
    L8:
        return ((View) r100).getContext();
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable.Callback r100 = getCallback();
        if (r100 == null) goto L6;
        r100.invalidateDrawable(this);
        return;
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f264403k;
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        e();
    }

    public final Bitmap d(String r100) {
        if (getCallback() != null) goto L5;
        pz6.b r101 = null;
    L25:
        if (r101 == null) goto L58;
        k r102 = r101.f531124c.get(r100);
        if (r102 == null) goto L62;
        Bitmap r103 = r102.f264454b;
        if (r103 != null) goto L59;
        String r104 = r102.f264453a;
        BitmapFactory.Options r105 = new BitmapFactory.Options();
        r105.inScaled = true;
        r105.inDensity = 160;
        if (r104.startsWith(fyb.a.KEY_DATA) == false) goto L49;
        if (r104.indexOf("base64,") <= 0) goto L49;
        byte[] r106 = Base64.decode(r104.substring(r104.indexOf(44) + 1), 0);     // Catch: Throwable -> L53
        Bitmap r107 = BitmapFactory.decodeByteArray(r106, 0, r106.length, r105);
        Object r108 = pz6.b.f531121f;
        monitor-enter(r108);
    L45:
        th = move-exception;
        throw th;
    L41:
        if (((HashSet) r101.f531125d).contains(r100) == true) goto L43;
        r101.f531124c.get(r100).f264454b = r107;     // Catch: Throwable -> L45
    L43:
        monitor-exit(r108);     // Catch: Throwable -> L45
        return r107;
    L63:
        return null;
    L49:
        if (TextUtils.isEmpty(r101.f531123b) == true) goto L61;
        Bitmap r109 = BitmapFactory.decodeStream(r101.f531122a.getAssets().open(r101.f531123b + r104), null, r105);
        r101.a(r100, r109);
        return r109;
    L61:
        return null;
    L59:
        return r103;
    L62:
        return null;
    L58:
        return null;
    L5:
        pz6.b r110 = this.f264398f;
        if (r110 == null) goto L18;
        Context r111 = getContext();
        if (r111 != null) goto L12;
        if (r110.f531122a != null) goto L12;
    L13:
        boolean r112 = true;
    L15:
        if (r112 == true) goto L18;
        this.f264398f.b();
        this.f264398f = null;
    L12:
        if (r110.f531122a.equals(r111) == true) goto L13;
        r112 = false;
    L18:
        if (this.f264398f != null) goto L24;
        pz6.b r113 = new pz6.b(getCallback(), this.f264399g, this.f264394b.f264427d);
        this.f264398f = r113;
        com.bytedance.lottie.d r114 = this.f264394b;
        if (r114 == null) goto L24;
        Set<String> r115 = r114.f264436m;
        ((HashSet) r113.f531125d).clear();
        if (r115 == null) goto L24;
        r113.f531125d.addAll(r115);
    L24:
        r101 = this.f264398f;
        goto L25
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Set<String> r101 = com.bytedance.lottie.c.f264422a;
        if (this.f264402j != null) goto L5;
        return;
    L5:
        float r102 = this.f264396d;
        float r103 = Math.min(r100.getWidth() / this.f264394b.f264432i.width(), r100.getHeight() / this.f264394b.f264432i.height());
        if (r102 <= r103) goto L8;
        float r104 = this.f264396d / r103;
    L10:
        if (r104 <= 1.0f) goto L12;
        r100.save();
        float r105 = this.f264394b.f264432i.width() / 2.0f;
        float r106 = this.f264394b.f264432i.height() / 2.0f;
        float r107 = r105 * r103;
        float r108 = r106 * r103;
        float r109 = this.f264396d;
        r100.translate((r105 * r109) - r107, (r109 * r106) - r108);
        r100.scale(r104, r104, r107, r108);
    L12:
        this.f264393a.reset();
        this.f264393a.preScale(r103, r103);
        this.f264402j.d(r100, this.f264393a, this.f264403k);
        com.bytedance.lottie.c.a();
        if (r104 <= 1.0f) goto L16;
        r100.restore();
        return;
    L16:
        return;
    L8:
        r103 = r102;
        r104 = 1.0f;
        goto L10
    }

    public final void g(int r100) {
        if (this.f264394b != null) goto L6;
        this.f264397e.add(new a(this, r100));
        return;
    L6:
        this.f264395c.g(r100);
    }

    public final void h(int r100) {
        if (this.f264394b != null) goto L6;
        this.f264397e.add(new h(this, r100));
        return;
    L6:
        wz6.d r101 = this.f264395c;
        r101.h((int) r101.f561949h, r100);
    }

    public final void i(int r100) {
        if (this.f264394b != null) goto L6;
        this.f264397e.add(new g(this, r100));
        return;
    L6:
        wz6.d r101 = this.f264395c;
        r101.h(r100, (int) r101.f561950i);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        Drawable.Callback r101 = getCallback();
        if (r101 != null) goto L5;
        return;
    L5:
        r101.invalidateDrawable(this);
    }

    public final void j(float r100) {
        com.bytedance.lottie.d r101 = this.f264394b;
        if (r101 != null) goto L6;
        this.f264397e.add(new b(this, r100));
        return;
    L6:
        float r102 = r101.f264433j;
        g((int) (r102 + (r100 * (r101.f264434k - r102))));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f264403k = r100;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r100, Runnable r101) {
        Drawable.Callback r102 = getCallback();
        if (r102 != null) goto L5;
        return;
    L5:
        r102.unscheduleDrawable(this, r101);
    }

    public final <T> void a(qz6.e r100, T r101, xz6.c<T> r102) {
        if (this.f264402j != null) goto L6;
        this.f264397e.add(new c(this, r100, r101, r102));
        return;
    L6:
        qz6.f r103 = r100.f535376b;
        boolean r104 = true;
        if (r103 == null) goto L9;
        r103.f(r101, r102);
    L14:
        if (r104 == false) goto L24;
        invalidateSelf();
        if (r101 != n.f264575w) goto L25;
        wz6.d r105 = this.f264395c;
        com.bytedance.lottie.d r106 = r105.f561951j;
        if (r106 != null) goto L20;
        float r107 = 0.0f;
    L21:
        j(r107);
        return;
    L20:
        float r108 = r105.f561947f;
        float r109 = r106.f264433j;
        r107 = (r108 - r109) / (r106.f264434k - r109);
        goto L21
    L25:
        return;
    L24:
        return;
    L9:
        ArrayList r110 = new ArrayList();
        int r111 = 0;
        this.f264402j.g(r100, 0, r110, new qz6.e(new String[0]));
    L11:
        if (r111 >= r110.size()) goto L13;
        ((qz6.e) ListProtector.get(r110, r111)).f535376b.f(r101, r102);
        r111 = r111 + 1;
        goto L11
    L13:
        r104 = true ^ r110.isEmpty();
        goto L14
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
        Drawable.Callback r103 = getCallback();
        if (r103 != null) goto L5;
        return;
    L5:
        r103.scheduleDrawable(this, r101, r102);
    }
}
