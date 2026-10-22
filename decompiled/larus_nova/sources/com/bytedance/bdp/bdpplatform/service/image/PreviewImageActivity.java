package com.bytedance.bdp.bdpplatform.service.image;

import android.R;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.defaults.thread.BdpThreadService;
import com.bytedance.bdp.serviceapi.defaults.ui.model.d;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import v19.f;

/* JADX INFO: loaded from: classes11.dex */
public class PreviewImageActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewPager f201351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f201352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<String> f201353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BdpImageServiceImpl f201354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f201355e;

    public static class PinchImageView extends AppCompatImageView {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final /* synthetic */ int f201356m = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View.OnClickListener f201357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View.OnLongClickListener f201358b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Matrix f201359c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f201360d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f201361e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f201362f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final PointF f201363g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final PointF f201364h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f201365i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public h f201366j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public b f201367k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final GestureDetector f201368l;

        public class a extends GestureDetector.SimpleOnGestureListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PinchImageView f201369a;

            public a(PinchImageView r100) {
                this.f201369a = r100;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public final boolean onDoubleTap(MotionEvent r110) {
                PinchImageView r100 = this.f201369a;
                if (r100.f201360d != 1) goto L58;
                h r101 = r100.f201366j;
                if (r101 != null) goto L7;
            L8:
                PinchImageView r102 = this.f201369a;
                float r103 = r110.getX();
                float r104 = r110.getY();
                if (r102.o() == false) goto L58;
                Matrix r105 = c.c();
                r102.n(r105);
                float r106 = c.a(r105)[0];
                float r107 = c.a(r102.f201359c)[0] * r106;
                float r108 = r102.getWidth();
                float r111 = r102.getHeight();
                float r112 = r102.getMaxScale();
                float r113 = 4.0f;
                if (r107 != 2.0f) goto L17;
                if (r102.f201362f == false) goto L28;
            L26:
                r113 = r106;
            L28:
                if (r113 > r112) goto L32;
                r112 = r113;
            L32:
                if (r112 < r106) goto L35;
                r106 = r112;
            L35:
                Matrix r109 = c.d(r102.f201359c);
                float r114 = r106 / r107;
                r109.postScale(r114, r114, r103, r104);
                float r115 = r108 / 2.0f;
                float r116 = r111 / 2.0f;
                r109.postTranslate(r115 - r103, r116 - r104);
                Matrix r117 = c.d(r105);
                r117.postConcat(r109);
                float r118 = r102.getDrawable().getIntrinsicWidth();
                float r119 = r102.getDrawable().getIntrinsicHeight();
                g r120 = c.f201373b;
                RectF r121 = r120.c();
                float r122 = 0.0f;
                r121.set(0.0f, 0.0f, r118, r119);
                r117.mapRect(r121);
                float r123 = r121.right;
                float r124 = r121.left;
                if ((r123 - r124) >= r108) goto L39;
                float r125 = r115 - ((r123 + r124) / 2.0f);
            L45:
                float r126 = r121.bottom;
                float r127 = r121.top;
                if ((r126 - r127) >= r111) goto L49;
                r122 = r116 - ((r126 + r127) / 2.0f);
            L54:
                r109.postTranslate(r125, r122);
                r102.j();
                h r128 = new h(r102, r102.f201359c, r109);
                r102.f201366j = r128;
                r128.start();
                if (((LinkedList) r120.f201375b).size() >= r120.f201374a) goto L57;
                ((LinkedList) r120.f201375b).offer(r121);
            L57:
                c.b(r117);
                c.b(r109);
                c.b(r105);
                goto L58
            L49:
                if (r127 <= 0.0f) goto L52;
                r122 = -r127;
                goto L54
            L52:
                if (r126 >= r111) goto L54;
                r122 = r111 - r126;
                goto L54
            L39:
                if (r124 <= 0.0f) goto L42;
                r125 = -r124;
                goto L45
            L42:
                if (r123 >= r108) goto L44;
                r125 = r108 - r123;
                goto L45
            L44:
                r125 = 0.0f;
                goto L45
            L17:
                if (r107 >= 2.0f) goto L20;
                r102.f201362f = false;
            L25:
                r113 = 2.0f;
                goto L28
            L20:
                if (r107 < 4.0f) goto L28;
                if (r107 < 4.0f) goto L26;
                r102.f201362f = true;
                goto L25
            L7:
                if (r101.isRunning() == false) goto L8;
            L58:
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final void onLongPress(MotionEvent r100) {
                PinchImageView r101 = this.f201369a;
                View.OnLongClickListener r102 = r101.f201358b;
                if (r102 == null) goto L6;
                r102.onLongClick(r101);
                return;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public final boolean onSingleTapConfirmed(MotionEvent r100) {
                PinchImageView r101 = this.f201369a;
                View.OnClickListener r102 = r101.f201357a;
                if (r102 == null) goto L7;
                r102.onClick(r101);
                return true;
            L7:
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
                PinchImageView r104 = this.f201369a;
                if (r104.f201360d != 0) goto L14;
                h r105 = r104.f201366j;
                if (r105 != null) goto L7;
            L8:
                PinchImageView r106 = this.f201369a;
                if (r106.o() == false) goto L16;
                r106.j();
                b r107 = new b(r106, r102 / 60.0f, r103 / 60.0f);
                r106.f201367k = r107;
                r107.start();
                return true;
            L16:
                return true;
            L7:
                if (r105.isRunning() == false) goto L8;
                return true;
            L14:
                return true;
            }
        }

        public class b extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final float[] f201370a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PinchImageView f201371b;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r100) {
                PinchImageView r101 = this.f201371b;
                float[] r102 = this.f201370a;
                float r103 = r102[0];
                float r104 = r102[1];
                int r105 = PinchImageView.f201356m;
                boolean r106 = r101.q(r103, r104);
                float[] r107 = this.f201370a;
                float r108 = r107[0] * 0.9f;
                r107[0] = r108;
                float r109 = r107[1] * 0.9f;
                r107[1] = r109;
                if (r106 == false) goto L6;
                d r110 = c.f201372a;
                float r111 = 0.0f - r108;
                float r112 = 0.0f - r109;
                if (((float) Math.sqrt((r111 * r111) + (r112 * r112))) < 1.0f) goto L6;
                return;
            L6:
                r100.cancel();
            }

            public b(PinchImageView r100, float r101, float r102) {
                this.f201371b = r100;
                setFloatValues(new float[]{0.0f, 1.0f});
                setDuration(1000000);
                addUpdateListener(this);
                this.f201370a = new float[]{r101, r102};
            }
        }

        public static class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f201372a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g f201373b = null;

            static {
                f201372a = new d();
                f201373b = new g();
            }

            public static Matrix c() {
                return f201372a.c();
            }

            public static float[] a(Matrix r100) {
                if (r100 == null) goto L7;
                float[] r101 = new float[9];
                r100.getValues(r101);
                return new float[]{r101[0], r101[4]};
            L7:
                return new float[2];
            }

            public static void b(Matrix r100) {
                d r101 = f201372a;
                if (r100 != null) goto L5;
                r101.getClass();
                return;
            L5:
                if (((LinkedList) r101.f201375b).size() >= r101.f201374a) goto L9;
                ((LinkedList) r101.f201375b).offer(r100);
                return;
            }

            public static Matrix d(Matrix r100) {
                Matrix r101 = f201372a.c();
                if (r100 == null) goto L5;
                r101.set(r100);
            L5:
                return r101;
            }
        }

        public static class d extends e<Matrix> {
            @Override // com.bytedance.bdp.bdpplatform.service.image.PreviewImageActivity.PinchImageView.e
            public final Matrix a() {
                return new Matrix();
            }

            public d() {
            }

            @Override // com.bytedance.bdp.bdpplatform.service.image.PreviewImageActivity.PinchImageView.e
            public final Matrix b(Matrix r100) {
                Matrix r101 = r100;
                r101.reset();
                return r101;
            }
        }

        public static abstract class e<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f201374a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Queue<T> f201375b;

            public abstract T a();

            public abstract T b(T r100);

            /* JADX WARN: Multi-variable type inference failed */
            public final T c() {
                if (((LinkedList) this.f201375b).size() != 0) goto L7;
                return (T) a();
            L7:
                return (T) b(((LinkedList) this.f201375b).poll());
            }

            public e() {
                this.f201374a = 16;
                this.f201375b = new LinkedList();
            }
        }

        public interface f {
            void a();
        }

        public static class g extends e<RectF> {
            @Override // com.bytedance.bdp.bdpplatform.service.image.PreviewImageActivity.PinchImageView.e
            public final RectF a() {
                return new RectF();
            }

            public g() {
            }

            @Override // com.bytedance.bdp.bdpplatform.service.image.PreviewImageActivity.PinchImageView.e
            public final RectF b(RectF r100) {
                RectF r101 = r100;
                r101.setEmpty();
                return r101;
            }
        }

        public class h extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final float[] f201376a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final float[] f201377b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final float[] f201378c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ PinchImageView f201379d;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r100) {
                float r101 = ((Float) r100.getAnimatedValue()).floatValue();
                int r102 = 0;
            L4:
                if (r102 >= 9) goto L6;
                float[] r103 = this.f201378c;
                float r104 = this.f201376a[r102];
                r103[r102] = r104 + ((this.f201377b[r102] - r104) * r101);
                r102 = r102 + 1;
                goto L4
            L6:
                this.f201379d.f201359c.setValues(this.f201378c);
                this.f201379d.l();
                this.f201379d.invalidate();
            }

            public h(PinchImageView r100, Matrix r101, Matrix r102) {
                this.f201379d = r100;
                float[] r103 = new float[9];
                this.f201376a = r103;
                float[] r104 = new float[9];
                this.f201377b = r104;
                this.f201378c = new float[9];
                setFloatValues(new float[]{0.0f, 1.0f});
                setDuration(200);
                addUpdateListener(this);
                r101.getValues(r103);
                r102.getValues(r104);
            }
        }

        public RectF getMask() {
            return null;
        }

        public float getMaxScale() {
            return 4.0f;
        }

        public final void l() {
        }

        @Override // android.widget.ImageView
        public void setScaleType(ImageView.ScaleType r100) {
        }

        public final void j() {
            h r100 = this.f201366j;
            if (r100 == null) goto L5;
            r100.cancel();
            this.f201366j = null;
        L5:
            b r101 = this.f201367k;
            if (r101 == null) goto L9;
            r101.cancel();
            this.f201367k = null;
            return;
        }

        public final boolean o() {
            if (getDrawable() != null) goto L5;
        L13:
            return false;
        L5:
            if (getDrawable().getIntrinsicWidth() <= 0) goto L13;
            if (getDrawable().getIntrinsicHeight() <= 0) goto L13;
            if (getWidth() <= 0) goto L13;
            if (getHeight() <= 0) goto L13;
            return true;
        }

        public int getPinchMode() {
            return this.f201360d;
        }

        public PinchImageView(Context r100) {
            super(r100);
            this.f201359c = new Matrix();
            this.f201360d = 0;
            this.f201362f = false;
            this.f201363g = new PointF();
            this.f201364h = new PointF();
            this.f201365i = 0.0f;
            this.f201368l = new GestureDetector(getContext(), new a(this));
            super.setScaleType(ImageView.ScaleType.MATRIX);
        }

        @Override // android.view.View
        public final boolean canScrollHorizontally(int r100) {
            if (this.f201360d != 2) goto L5;
            return true;
        L5:
            RectF r101 = m(null);
            if (r101.isEmpty() == false) goto L8;
            return false;
        L8:
            if (r100 <= 0) goto L15;
            if (r101.right > getWidth()) goto L19;
            return false;
        L19:
            return true;
        L15:
            if (r101.left < 0.0f) goto L20;
            return false;
        L20:
            return true;
        }

        @Override // android.view.View
        public final boolean canScrollVertically(int r100) {
            if (this.f201360d != 2) goto L5;
            return true;
        L5:
            RectF r101 = m(null);
            if (r101.isEmpty() == false) goto L8;
            return false;
        L8:
            if (r100 <= 0) goto L15;
            if (r101.bottom > getHeight()) goto L19;
            return false;
        L19:
            return true;
        L15:
            if (r101.top < 0.0f) goto L20;
            return false;
        L20:
            return true;
        }

        public final RectF m(RectF r100) {
            if (r100 != null) goto L4;
            r100 = new RectF();
        L6:
            if (o() == true) goto L8;
            return r100;
        L8:
            Matrix r101 = c.c();
            n(r101).postConcat(this.f201359c);
            r100.set(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
            r101.mapRect(r100);
            c.b(r101);
            return r100;
        L4:
            r100.setEmpty();
            goto L6
        }

        public final Matrix n(Matrix r110) {
            if (r110 != null) goto L4;
            r110 = new Matrix();
        L6:
            if (o() == false) goto L26;
            float r100 = getDrawable().getIntrinsicWidth();
            float r101 = getDrawable().getIntrinsicHeight();
            g r102 = c.f201373b;
            RectF r103 = r102.c();
            float r104 = 0.0f;
            r103.set(0.0f, 0.0f, r100, r101);
            float r105 = getWidth();
            float r106 = getHeight();
            RectF r107 = r102.c();
            r107.set(0.0f, 0.0f, r105, r106);
            if (r103.height() <= r107.width()) goto L10;
        L19:
            r110.setRectToRect(r103, r107, Matrix.ScaleToFit.CENTER);
        L21:
            if (((LinkedList) r102.f201375b).size() >= r102.f201374a) goto L24;
            ((LinkedList) r102.f201375b).offer(r107);
        L24:
            if (((LinkedList) r102.f201375b).size() >= r102.f201374a) goto L26;
            ((LinkedList) r102.f201375b).offer(r103);
            goto L26
        L10:
            if (r103.width() > r107.width()) goto L19;
            int r108 = getDrawable().getIntrinsicWidth();
            int r109 = getDrawable().getIntrinsicHeight();
            int r111 = getWidth();
            int r112 = getHeight();
            if (r108 >= r111) goto L15;
            float r113 = (r111 / 2.0f) - (r108 / 2.0f);
        L16:
            if (r109 >= r112) goto L18;
            r104 = (r112 / 2.0f) - (r109 / 2.0f);
        L18:
            r110.setRectToRect(r103, r103, Matrix.ScaleToFit.CENTER);
            r110.postTranslate(r113, r104);
            goto L21
        L15:
            r113 = 0.0f;
        L26:
            return r110;
        L4:
            r110.reset();
            goto L6
        }

        @Override // android.widget.ImageView, android.view.View
        public final void onDraw(Canvas r100) {
            if (o() == false) goto L5;
            Matrix r101 = c.c();
            Matrix r102 = n(r101);
            r102.postConcat(this.f201359c);
            setImageMatrix(r102);
            c.b(r101);
        L5:
            super.onDraw(r100);
        }

        @Override // android.view.View
        public final boolean onTouchEvent(MotionEvent r110) {
            super.onTouchEvent(r110);
            int r100 = r110.getAction() & 255;
            if (r100 == 1) goto L44;
            if (r100 == 3) goto L44;
            if (r100 == 6) goto L10;
            if (r100 != 0) goto L26;
            h r101 = this.f201366j;
            if (r101 != null) goto L23;
        L24:
            j();
            this.f201360d = 1;
            this.f201363g.set(r110.getX(), r110.getY());
        L91:
            this.f201368l.onTouchEvent(r110);
            return true;
        L23:
            if (r101.isRunning() == true) goto L91;
        L26:
            if (r100 != 5) goto L28;
            j();
            this.f201360d = 2;
            p(r110.getX(0), r110.getY(0), r110.getX(1), r110.getY(1));
            goto L91
        L28:
            if (r100 != 2) goto L91;
            h r102 = this.f201366j;
            if (r102 != null) goto L32;
        L33:
            int r103 = this.f201360d;
            if (r103 != 1) goto L36;
            q(r110.getX() - this.f201363g.x, r110.getY() - this.f201363g.y);
            this.f201363g.set(r110.getX(), r110.getY());
            goto L91
        L36:
            if (r103 != 2) goto L91;
            if (r110.getPointerCount() <= 1) goto L91;
            float r104 = r110.getX(0);
            float r105 = r110.getY(0);
            float r106 = r110.getX(1);
            float r107 = r110.getY(1);
            d r108 = c.f201372a;
            float r109 = r104 - r106;
            float r111 = r105 - r107;
            float r112 = (float) Math.sqrt((r109 * r109) + (r111 * r111));
            float r113 = r110.getX(0);
            float r114 = r110.getY(0);
            float r115 = r110.getX(1);
            float r116 = (r114 + r110.getY(1)) / 2.0f;
            this.f201363g.set((r113 + r115) / 2.0f, r116);
            PointF r117 = this.f201364h;
            float r118 = this.f201365i;
            PointF r119 = this.f201363g;
            if (o() == false) goto L91;
            float r120 = r118 * r112;
            Matrix r121 = c.c();
            r121.postScale(r120, r120, r117.x, r117.y);
            r121.postTranslate(r119.x - r117.x, r119.y - r117.y);
            this.f201359c.set(r121);
            c.b(r121);
            l();
            invalidate();
            goto L91
        L32:
            if (r102.isRunning() == true) goto L91;
        L10:
            if (this.f201360d != 2) goto L91;
            if (r110.getPointerCount() <= 2) goto L91;
            if ((r110.getAction() >> 8) != 0) goto L17;
            p(r110.getX(1), r110.getY(1), r110.getX(2), r110.getY(2));
            goto L91
        L17:
            if ((r110.getAction() >> 8) != 1) goto L91;
            p(r110.getX(0), r110.getY(0), r110.getX(2), r110.getY(2));
        L44:
            if (this.f201360d == 2) goto L46;
        L90:
            this.f201360d = 0;
            goto L91
        L46:
            if (o() == false) goto L90;
            Matrix r122 = c.c();
            n(r122).postConcat(this.f201359c);
            float r123 = c.a(r122)[0];
            float r124 = c.a(this.f201359c)[0];
            float r125 = getWidth();
            float r126 = getHeight();
            float r127 = getMaxScale();
            if (r123 <= r127) goto L51;
            float r128 = r127 / r123;
        L53:
            if ((r124 * r128) >= 1.0f) goto L56;
            r128 = 1.0f / r124;
        L56:
            if (r128 == 1.0f) goto L58;
            boolean r129 = true;
        L59:
            Matrix r130 = c.d(r122);
            PointF r131 = this.f201363g;
            r130.postScale(r128, r128, r131.x, r131.y);
            float r132 = getDrawable().getIntrinsicWidth();
            float r133 = getDrawable().getIntrinsicHeight();
            g r134 = c.f201373b;
            RectF r135 = r134.c();
            r135.set(0.0f, 0.0f, r132, r133);
            r130.mapRect(r135);
            float r136 = r135.right;
            float r137 = r135.left;
            if ((r136 - r137) >= r125) goto L63;
            r125 = r125 / 2.0f;
            r136 = (r136 + r137) / 2.0f;
        L67:
            float r138 = r125 - r136;
        L69:
            float r139 = r135.bottom;
            float r140 = r135.top;
            if ((r139 - r140) >= r126) goto L73;
            r126 = r126 / 2.0f;
            r139 = (r139 + r140) / 2.0f;
        L77:
            float r141 = r126 - r139;
        L80:
            if (r138 == 0.0f) goto L82;
        L83:
            r129 = true;
        L84:
            if (r129 == false) goto L87;
            Matrix r142 = c.d(this.f201359c);
            PointF r143 = this.f201363g;
            r142.postScale(r128, r128, r143.x, r143.y);
            r142.postTranslate(r138, r141);
            j();
            h r144 = new h(this, this.f201359c, r142);
            this.f201366j = r144;
            r144.start();
            c.b(r142);
        L87:
            if (((LinkedList) r134.f201375b).size() >= r134.f201374a) goto L89;
            ((LinkedList) r134.f201375b).offer(r135);
        L89:
            c.b(r130);
            c.b(r122);
            goto L90
        L82:
            if (r141 == 0.0f) goto L84;
        L73:
            if (r140 <= 0.0f) goto L76;
            r141 = -r140;
            goto L80
        L76:
            if (r139 < r126) goto L77;
            r141 = 0.0f;
            goto L80
        L63:
            if (r137 <= 0.0f) goto L66;
            r138 = -r137;
            goto L69
        L66:
            if (r136 < r125) goto L67;
            r138 = 0.0f;
            goto L69
        L58:
            r129 = false;
            goto L59
        L51:
            r128 = 1.0f;
            goto L53
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener r100) {
            this.f201357a = r100;
        }

        @Override // android.view.View
        public void setOnLongClickListener(View.OnLongClickListener r100) {
            this.f201358b = r100;
        }

        public PinchImageView(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.f201359c = new Matrix();
            this.f201360d = 0;
            this.f201362f = false;
            this.f201363g = new PointF();
            this.f201364h = new PointF();
            this.f201365i = 0.0f;
            this.f201368l = new GestureDetector(getContext(), new a(this));
            super.setScaleType(ImageView.ScaleType.MATRIX);
        }

        public final boolean q(float r110, float r111) {
            if (o() == true) goto L5;
            return false;
        L5:
            g r100 = c.f201373b;
            RectF r101 = r100.c();
            m(r101);
            float r102 = getWidth();
            float r103 = getHeight();
            float r104 = r101.right;
            float r105 = r101.left;
            if ((r104 - r105) >= r102) goto L9;
        L18:
            r110 = 0.0f;
        L19:
            float r106 = r101.bottom;
            float r107 = r101.top;
            if ((r106 - r107) >= r103) goto L23;
        L32:
            r111 = 0.0f;
        L34:
            if (((LinkedList) r100.f201375b).size() >= r100.f201374a) goto L36;
            ((LinkedList) r100.f201375b).offer(r101);
        L36:
            this.f201359c.postTranslate(r110, r111);
            l();
            invalidate();
            if (r110 == 0.0f) goto L39;
            return true;
        L39:
            if (r111 != 0.0f) goto L44;
            return false;
        L44:
            return true;
        L23:
            if ((r107 + r111) <= 0.0f) goto L28;
            if (r107 >= 0.0f) goto L32;
            r111 = -r107;
            goto L34
        L28:
            if ((r106 + r111) >= r103) goto L34;
            if (r106 <= r103) goto L32;
            r111 = r103 - r106;
            goto L34
        L9:
            if ((r105 + r110) <= 0.0f) goto L14;
            if (r105 >= 0.0f) goto L18;
            r110 = -r105;
            goto L19
        L14:
            if ((r104 + r110) >= r102) goto L19;
            if (r104 <= r102) goto L18;
            r110 = r102 - r104;
            goto L19
        }

        public PinchImageView(Context r100, AttributeSet r101, int r102) {
            super(r100, r101, r102);
            this.f201359c = new Matrix();
            this.f201360d = 0;
            this.f201362f = false;
            this.f201363g = new PointF();
            this.f201364h = new PointF();
            this.f201365i = 0.0f;
            this.f201368l = new GestureDetector(getContext(), new a(this));
            super.setScaleType(ImageView.ScaleType.MATRIX);
        }

        public final void p(float r100, float r101, float r102, float r103) {
            float r104 = r100 - r102;
            float r105 = r101 - r103;
            this.f201365i = c.a(this.f201359c)[0] / ((float) Math.sqrt((r104 * r104) + (r105 * r105)));
            float[] r106 = {(r100 + r102) / 2.0f, (r101 + r103) / 2.0f};
            Matrix r107 = this.f201359c;
            if (r107 == null) goto L5;
            float[] r108 = new float[2];
            Matrix r109 = c.c();
            r107.invert(r109);
            r109.mapPoints(r108, r106);
            c.b(r109);
        L6:
            this.f201364h.set(r108[0], r108[1]);
            return;
        L5:
            r108 = new float[2];
            goto L6
        }
    }

    public class a extends PagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PreviewImageActivity f201380a;

        @Override // androidx.viewpager.widget.PagerAdapter
        public final boolean isViewFromObject(View r100, Object r101) {
            if (r100 != r101) goto L4;
            return true;
        L4:
            return false;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getCount() {
            ArrayList<String> r100 = this.f201380a.f201353c;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.size();
        }

        public a(PreviewImageActivity r100) {
            this.f201380a = r100;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final Object instantiateItem(ViewGroup r100, int r110) {
            PinchImageView r101 = new PinchImageView(r100.getContext());
            ArrayList<String> r102 = this.f201380a.f201353c;
            if (r102 != null) goto L5;
        L23:
            return r101;
        L5:
            if (r102.size() <= r110) goto L23;
            String r111 = (String) ListProtector.get(this.f201380a.f201353c, r110);
            if (r111 == null) goto L22;
            Uri r103 = UriProtector.parse(r111);
            if ("file".equalsIgnoreCase(r103.getScheme()) == false) goto L12;
            d r112 = new d(r103);
            r112.f201591c = r101;
            d r104 = r112;
        L13:
            PreviewImageActivity r105 = this.f201380a;
            BdpImageServiceImpl r106 = r105.f201354d;
            r106.getClass();
            View r113 = r104.f201591c;
            if ((r113 instanceof ImageView) == false) goto L22;
            ImageView r107 = (ImageView) r113;
            BdpThreadService r114 = (BdpThreadService) BdpManager.getInst().getService(BdpThreadService.class);
            if (r104.f201589a == null) goto L20;
            r114.executeIO(new da4.a(r106, r104, r114, r107));
            goto L22
        L20:
            if (r104.f201590b == null) goto L22;
            r114.executeIO(new da4.b(r106, r104, r105, r114, r107));
            goto L22
        L12:
            r104 = new d(r111, r101);
        L22:
            r100.addView(r101);
            goto L23
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void destroyItem(ViewGroup r100, int r101, Object r102) {
            r100.removeView((View) r102);
        }
    }

    public class b implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PreviewImageActivity f201381a;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
        }

        public b(PreviewImageActivity r100) {
            this.f201381a = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            PreviewImageActivity r101 = this.f201381a;
            int r102 = r101.f201355e;
            if (r102 == r100) goto L9;
            PinchImageView r103 = (PinchImageView) r101.f201351a.getChildAt(r102);
            if (r103 == null) goto L7;
            r103.f201359c.reset();
            r103.l();
            r103.f201360d = 0;
            r103.f201363g.set(0.0f, 0.0f);
            r103.f201364h.set(0.0f, 0.0f);
            r103.f201365i = 0.0f;
            r103.j();
            r103.invalidate();
        L7:
            this.f201381a.f201355e = r100;
            return;
        }
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L45
        if (r103 != null) goto L10;
    L13:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L50;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    public PreviewImageActivity() {
        this.f201354d = new BdpImageServiceImpl();
        this.f201355e = 0;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == c.f346341a) goto L9;
        c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(this) == false) goto L8;
        f.c(getTheme());     // Catch: Throwable -> L10
    L8:
        super.onCreate(r100);
        setContentView(com.larus.nova.R.layout.bdp_activity_preview_image);
        Intent r101 = getIntent();
        r101.getStringExtra("params");
        this.f201352b = r101.getIntExtra("selectedIndex", 0);
        this.f201353c = r101.getStringArrayListExtra("images");
        ViewPager r102 = (ViewPager) findViewById(com.larus.nova.R.id.bdp_imagePager);
        this.f201351a = r102;
        r102.setAdapter(new a(this));
        this.f201351a.addOnPageChangeListener(new b(this));
        this.f201351a.setCurrentItem(Math.max(this.f201352b, 0));
        this.f201355e = Math.max(this.f201352b, 0);
    }
}
