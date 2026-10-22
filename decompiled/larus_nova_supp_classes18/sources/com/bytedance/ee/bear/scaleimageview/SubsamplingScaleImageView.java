package com.bytedance.ee.bear.scaleimageview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.supervisor.token.Token;
import com.davemorrissey.labs.subscaleview.decoder.CompatDecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.DecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.ImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageRegionDecoder;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SubsamplingScaleImageView extends View {
    public static final List<Integer> g2 = null;
    public static final List<Integer> h2 = null;
    public static final List<Integer> p2 = null;
    public static final List<Integer> v2 = null;
    public static final List<Integer> x2 = null;
    public static Bitmap.Config y2;
    public PointF A;
    public PointF B;
    public Float C;
    public PointF D;
    public PointF E;
    public int F;
    public int G;
    public Paint G1;
    public int H;
    public PointF H0;
    public j H1;
    public boolean I;
    public boolean J;
    public boolean K;
    public int L;
    public d L0;
    public Matrix L1;
    public GestureDetector M;
    public RectF M1;
    public GestureDetector N;
    public ImageRegionDecoder O;
    public final ReadWriteLock P;
    public boolean P0;
    public final float[] P1;
    public DecoderFactory<? extends ImageDecoder> Q;
    public final float[] Q1;
    public DecoderFactory<? extends ImageRegionDecoder> R;
    public PointF S;
    public final float S1;
    public float T;
    public float T1;
    public final float U;
    public float V;
    public boolean V0;
    public final RectF V1;
    public boolean W;
    public Bitmap a;
    public boolean b;
    public h b1;
    public k b2;
    public boolean c;
    public Uri d;
    public int e;
    public Map<Integer, List<l>> f;
    public boolean g;
    public bm5.b g1;
    public int h;
    public bm5.a h1;
    public float i;
    public float j;
    public int k;
    public PointF k0;
    public View.OnLongClickListener k1;
    public int l;
    public int m;
    public int n;
    public int o;
    public Executor p;
    public PointF p0;
    public final Handler p1;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public float u;
    public int v;
    public Paint v1;
    public int w;
    public float x;
    public Paint x1;
    public float y;
    public Paint y1;
    public PointF z;

    public class a implements Handler.Callback {
        public final /* synthetic */ SubsamplingScaleImageView a;

        public a(SubsamplingScaleImageView r1) {
            this.a = r1;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r4) {
            if (r4.what != 1) goto L7;
            SubsamplingScaleImageView r5 = this.a;
            View.OnLongClickListener r1 = r5.k1;
            if (r1 == null) goto L7;
            r5.L = 0;
            SubsamplingScaleImageView.f(r5, r1);
            this.a.performLongClick();
            SubsamplingScaleImageView.h(this.a);
        L7:
            return true;
        }
    }

    public class b extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ Context a;
        public final /* synthetic */ SubsamplingScaleImageView b;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r8) {
            SubsamplingScaleImageView r0 = this.b;
            if (r0.s == false) goto L23;
            if (r0.P0 == false) goto L23;
            if (r0.z == null) goto L23;
            SubsamplingScaleImageView.e(r0, this.a);
            SubsamplingScaleImageView r1 = this.b;
            PointF r2 = null;
            if (r1.t == false) goto L16;
            r1.S = new PointF(r8.getX(), r8.getY());
            SubsamplingScaleImageView r3 = this.b;
            PointF r4 = this.b.z;
            r3.A = new PointF(r4.x, r4.y);
            SubsamplingScaleImageView r5 = this.b;
            r5.y = r5.x;
            r5.K = true;
            r5.I = true;
            r5.V = -1.0f;
            PointF r6 = r5.S;
            float r7 = r6.x;
            float r9 = r6.y;
            PointF r10 = new PointF();
            PointF r11 = r5.z;
            if (r11 == null) goto L14;
            float r12 = r7 - r11.x;
            float r13 = r5.x;
            r10.set(r12 / r13, (r9 - r11.y) / r13);
            r2 = r10;
        L14:
            r5.p0 = r2;
            SubsamplingScaleImageView r14 = this.b;
            r14.H0 = new PointF(r8.getX(), r8.getY());
            SubsamplingScaleImageView r15 = this.b;
            PointF r16 = this.b.p0;
            r15.k0 = new PointF(r16.x, r16.y);
            this.b.W = false;
            return false;
        L16:
            PointF r17 = new PointF(r8.getX(), r8.getY());
            float r18 = r17.x;
            float r19 = r17.y;
            PointF r20 = new PointF();
            PointF r21 = r1.z;
            if (r21 == null) goto L20;
            float r22 = r18 - r21.x;
            float r23 = r1.x;
            r20.set(r22 / r23, (r19 - r21.y) / r23);
            r2 = r20;
        L20:
            SubsamplingScaleImageView.g(r1, r2, new PointF(r8.getX(), r8.getY()));
            return true;
        L23:
            return onDoubleTapEvent(r8);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r1) {
            this.b.performClick();
            return true;
        }

        public b(SubsamplingScaleImageView r1, Context r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r4, MotionEvent r5, float r6, float r7) {
            SubsamplingScaleImageView r0 = this.b;
            if (r0.r == false) goto L27;
            if (r0.P0 == false) goto L27;
            if (r0.z == null) goto L27;
            if (r4 == null) goto L27;
            if (r5 == null) goto L27;
            if (Math.abs(r4.getX() - r5.getX()) > 50.0f) goto L15;
            if (Math.abs(r4.getY() - r5.getY()) <= 50.0f) goto L27;
        L15:
            if (Math.abs(r6) > 500.0f) goto L19;
            if (Math.abs(r7) <= 500.0f) goto L27;
        L19:
            if (this.b.I == true) goto L27;
            PointF r8 = this.b.z;
            PointF r9 = new PointF(r8.x + (r6 * 0.25f), r8.y + (r7 * 0.25f));
            float r10 = (this.b.getWidth() / 2) - r9.x;
            SubsamplingScaleImageView r11 = this.b;
            float r12 = r10 / r11.x;
            float r13 = (r11.getHeight() / 2) - r9.y;
            SubsamplingScaleImageView r14 = this.b;
            e r15 = new e(r14, new PointF(r12, r13 / r14.x));
            if (SubsamplingScaleImageView.p2.contains(1) == false) goto L25;
            r15.e = 1;
            r15.h = false;
            r15.f = 3;
            r15.a();
            return true;
        L25:
            throw new IllegalArgumentException("Unknown easing type: 1");
        L27:
            return super.onFling(r4, r5, r6, r7);
        }
    }

    public class c extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ SubsamplingScaleImageView a;

        public c(SubsamplingScaleImageView r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r1) {
            this.a.performClick();
            return true;
        }
    }

    public static class d {
        public float a;
        public float b;
        public PointF c;
        public PointF d;
        public PointF e;
        public PointF f;
        public PointF g;
        public long h;
        public boolean i;
        public int j;
        public int k;
        public long l;

        public d() {
            this.h = 500;
            this.i = true;
            this.j = 2;
            this.k = 1;
            this.l = System.currentTimeMillis();
        }

        public static /* synthetic */ void a(d r0) {
            r0.getClass();
        }

        public static /* synthetic */ PointF b(d r0) {
            return r0.f;
        }

        public static /* synthetic */ long c(d r2) {
            return r2.l;
        }

        public static /* synthetic */ long d(d r2) {
            return r2.h;
        }

        public static /* synthetic */ int e(d r0) {
            return r0.j;
        }

        public static /* synthetic */ float f(d r0) {
            return r0.a;
        }

        public static /* synthetic */ float g(d r0) {
            return r0.b;
        }

        public static /* synthetic */ PointF h(d r0) {
            return r0.g;
        }

        public static /* synthetic */ PointF i(d r0) {
            return r0.d;
        }

        public static /* synthetic */ int j(d r0) {
            return r0.k;
        }

        public static /* synthetic */ PointF k(d r0) {
            return r0.c;
        }

        public static /* synthetic */ PointF l(d r0) {
            return r0.e;
        }
    }

    public final class e {
        public final float a;
        public final PointF b;
        public final PointF c;
        public long d;
        public int e;
        public int f;
        public boolean g;
        public boolean h;
        public final /* synthetic */ SubsamplingScaleImageView i;

        public final void a() {
            SubsamplingScaleImageView r0 = this.i;
            d r1 = r0.L0;
            int r2 = r0.getPaddingLeft() + (((this.i.getWidth() - this.i.getPaddingRight()) - this.i.getPaddingLeft()) / 2);
            int r3 = this.i.getPaddingTop() + (((this.i.getHeight() - this.i.getPaddingBottom()) - this.i.getPaddingTop()) / 2);
            float r4 = SubsamplingScaleImageView.o(this.i, this.a);
            if (this.h == false) goto L5;
            SubsamplingScaleImageView r5 = this.i;
            PointF r6 = this.b;
            float r7 = r6.x;
            float r8 = r6.y;
            PointF r9 = new PointF();
            PointF r10 = r5.U(r7, r8, r4);
            r9.set(((r5.getPaddingLeft() + (((r5.getWidth() - r5.getPaddingRight()) - r5.getPaddingLeft()) / 2)) - r10.x) / r4, ((r5.getPaddingTop() + (((r5.getHeight() - r5.getPaddingBottom()) - r5.getPaddingTop()) / 2)) - r10.y) / r4);
        L6:
            this.i.L0 = new d();
            SubsamplingScaleImageView r11 = this.i;
            d r12 = r11.L0;
            r12.a = r11.x;
            r12.b = r4;
            r12.l = System.currentTimeMillis();
            SubsamplingScaleImageView r13 = this.i;
            d r14 = r13.L0;
            r14.e = r9;
            r14.c = r13.getCenter();
            SubsamplingScaleImageView r15 = this.i;
            d r16 = r15.L0;
            r16.d = r9;
            r16.f = r15.Q(r9);
            this.i.L0.g = new PointF(r2, r3);
            d r17 = this.i.L0;
            r17.h = this.d;
            r17.i = this.g;
            r17.j = this.e;
            r17.k = this.f;
            r17.l = System.currentTimeMillis();
            this.i.L0.getClass();
            PointF r18 = this.c;
            if (r18 == null) goto L9;
            float r19 = r18.x;
            PointF r20 = this.i.L0.c;
            float r21 = r19 - (r20.x * r4);
            float r22 = r18.y - (r20.y * r4);
            PointF r23 = new PointF(r21, r22);
            this.i.z(true, new j(r4, r23));
            d r24 = this.i.L0;
            PointF r25 = this.c;
            r24.g = new PointF(r25.x + (r23.x - r21), r25.y + (r23.y - r22));
        L9:
            this.i.invalidate();
            return;
        L5:
            r9 = this.b;
            goto L6
        }

        public e(SubsamplingScaleImageView r3, PointF r4) {
            this.i = r3;
            this.d = 500;
            this.e = 2;
            this.f = 1;
            this.g = true;
            this.h = true;
            this.a = r3.x;
            this.b = r4;
            this.c = null;
        }

        public e(SubsamplingScaleImageView r3, float r4, PointF r5) {
            this.i = r3;
            this.d = 500;
            this.e = 2;
            this.f = 1;
            this.g = true;
            this.h = true;
            this.a = r4;
            this.b = r5;
            this.c = null;
        }

        public e(SubsamplingScaleImageView r3, float r4, PointF r5, PointF r6) {
            this.i = r3;
            this.d = 500;
            this.e = 2;
            this.f = 1;
            this.g = true;
            this.h = true;
            this.a = r4;
            this.b = r5;
            this.c = r6;
        }
    }

    public static class f extends PthreadAsyncTask<Void, Void, Integer> {
        public final WeakReference<SubsamplingScaleImageView> h;
        public final WeakReference<Context> i;
        public final WeakReference<DecoderFactory<? extends ImageDecoder>> j;
        public final Uri k;
        public final boolean l;
        public Bitmap m;
        public Exception n;

        public final Object doInBackground(Object[] r8) {
            Void[] r9 = (Void[]) r8;
            String r1 = this.k.toString();     // Catch: OutOfMemoryError -> L9 Exception -> L11
            Context r2 = this.i.get();     // Catch: OutOfMemoryError -> L9 Exception -> L11
            DecoderFactory<? extends ImageDecoder> r3 = this.j.get();     // Catch: OutOfMemoryError -> L9 Exception -> L11
            SubsamplingScaleImageView r4 = this.h.get();     // Catch: OutOfMemoryError -> L9 Exception -> L11
            if (r2 == null) goto L13;
            if (r3 == null) goto L13;
            if (r4 == null) goto L13;
            SubsamplingScaleImageView.j(r4, "BitmapLoadTask.doInBackground", new Object[0]);     // Catch: OutOfMemoryError -> L9 Exception -> L11
            this.m = ((ImageDecoder) r3.make()).decode(r2, this.k);     // Catch: OutOfMemoryError -> L9 Exception -> L11
        L17:
            return Integer.valueOf(SubsamplingScaleImageView.k(r4, r2, r1));
        L13:
            return null;
        L11:
            e = move-exception;
            List<Integer> r5 = SubsamplingScaleImageView.g2;
            tt5.a.e("SubsamplingScaleImageView", "Failed to load bitmap", e, false);
            this.n = e;
        L9:
            e = move-exception;
            List<Integer> r6 = SubsamplingScaleImageView.g2;
            tt5.a.e("SubsamplingScaleImageView", "Failed to load bitmap - OutOfMemoryError", e, false);
            this.n = new RuntimeException(e);
            goto L13
        }

        public final void onPostExecute(Object r5) {
            Integer r6 = (Integer) r5;
            SubsamplingScaleImageView r0 = this.h.get();
            if (r0 == null) goto L22;
            Bitmap r1 = this.m;
            if (r1 == null) goto L11;
            if (r6 == null) goto L11;
            if (this.l == false) goto L10;
            List<Integer> r7 = SubsamplingScaleImageView.g2;
            r0.G(r1);
            return;
        L10:
            int r8 = r6.intValue();
            List<Integer> r2 = SubsamplingScaleImageView.g2;
            r0.F(r1, r8);
            return;
        L11:
            Exception r9 = this.n;
            if (r9 == null) goto L25;
            r95.h.a r3 = r0.b1;
            if (r3 != null) goto L16;
            return;
        L16:
            if (this.l == true) goto L28;
            tt5.a.i("preview_image", "DriveSubsamplingScaleImageView onImageLoadError() error=", r9);
            com.bytedance.ee.bear.drive.view.preview.imageviewer.b r4 = r3.a.E2;
            if (r4 == null) goto L27;
            r4.b("subsampling_image", r9, false, true);
            return;
        L27:
            return;
        L28:
            return;
        L25:
            return;
        }

        public f(SubsamplingScaleImageView r2, Context r3, DecoderFactory r4, Uri r5) {
            this.h = new WeakReference(r2);
            this.i = new WeakReference(r3);
            this.j = new WeakReference(r4);
            this.k = r5;
            this.l = false;
        }
    }

    public static class g implements h {
        public g() {
        }
    }

    public interface h {
    }

    public interface i {
    }

    public static class j {
        public float a;
        public final PointF b;

        public j(float r1, PointF r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static class k {
        public final boolean a;
        public final boolean b;

        public k(boolean r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static class l {
        public Rect a;
        public int b;
        public Bitmap c;
        public boolean d;
        public boolean e;
        public Rect f;
        public Rect g;

        public l() {
        }

        public static /* synthetic */ boolean a(l r0) {
            return r0.e;
        }

        public static /* synthetic */ boolean b(l r0) {
            return r0.d;
        }

        public static /* synthetic */ Rect c(l r0) {
            return r0.a;
        }

        public static /* synthetic */ Rect d(l r0) {
            return r0.f;
        }

        public static /* synthetic */ int e(l r0) {
            return r0.b;
        }

        public static /* synthetic */ Bitmap f(l r0) {
            return r0.c;
        }
    }

    public static class m extends PthreadAsyncTask<Void, Void, Bitmap> {
        public final WeakReference<SubsamplingScaleImageView> h;
        public final WeakReference<ImageRegionDecoder> i;
        public final WeakReference<l> j;

        public final Object doInBackground(Object[] r9) {
            Void[] r10 = (Void[]) r9;
            SubsamplingScaleImageView r1 = this.h.get();     // Catch: OutOfMemoryError -> L25 Exception -> L27
            ImageRegionDecoder r2 = this.i.get();     // Catch: OutOfMemoryError -> L25 Exception -> L27
            l r3 = this.j.get();     // Catch: OutOfMemoryError -> L25 Exception -> L27
            if (r2 == null) goto L22;
            if (r3 == null) goto L22;
            if (r1 == null) goto L22;
            if (r2.isReady() == false) goto L22;
            if (r3.e == false) goto L22;
            SubsamplingScaleImageView.j(r1, "TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", new Object[]{r3.a, Integer.valueOf(r3.b)});     // Catch: OutOfMemoryError -> L25 Exception -> L27
            ((ReentrantReadWriteLock) r1.P).readLock().lock();     // Catch: OutOfMemoryError -> L25 Exception -> L27
        L19:
            th = move-exception;
            ((ReentrantReadWriteLock) r1.P).readLock().unlock();     // Catch: OutOfMemoryError -> L25 Exception -> L27
            throw th;     // Catch: OutOfMemoryError -> L25 Exception -> L27
        L13:
            if (r2.isReady() == false) goto L17;
            SubsamplingScaleImageView.m(r1, r3.a, r3.g);     // Catch: Throwable -> L19
            Bitmap r4 = r2.decodeRegion(r3.g, r3.b);     // Catch: Throwable -> L19
            ((ReentrantReadWriteLock) r1.P).readLock().unlock();     // Catch: OutOfMemoryError -> L25 Exception -> L27
            return r4;
        L17:
            r3.d = false;     // Catch: Throwable -> L19
            ((ReentrantReadWriteLock) r1.P).readLock().unlock();     // Catch: OutOfMemoryError -> L25 Exception -> L27
        L29:
            return null;
        L22:
            if (r3 == null) goto L29;
            r3.d = false;     // Catch: OutOfMemoryError -> L25 Exception -> L27
        L27:
            e = move-exception;
            List<Integer> r5 = SubsamplingScaleImageView.g2;
            tt5.a.e("SubsamplingScaleImageView", "Failed to decode tile", e, false);
        L25:
            e = move-exception;
            List<Integer> r6 = SubsamplingScaleImageView.g2;
            tt5.a.e("SubsamplingScaleImageView", "Failed to decode tile - OutOfMemoryError", e, false);
            new RuntimeException(e);
            goto L29
        }

        public final void onPostExecute(Object r3) {
            Bitmap r4 = (Bitmap) r3;
            SubsamplingScaleImageView r0 = this.h.get();
            l r1 = this.j.get();
            if (r0 == null) goto L8;
            if (r1 == null) goto L9;
            if (r4 == null) goto L10;
            r1.c = r4;
            r1.d = false;
            SubsamplingScaleImageView.n(r0);
            return;
        L10:
            return;
        L9:
            return;
        }

        public m(SubsamplingScaleImageView r2, ImageRegionDecoder r3, l r4) {
            this.h = new WeakReference(r2);
            this.i = new WeakReference(r3);
            this.j = new WeakReference(r4);
            r4.d = true;
        }
    }

    public static class n extends PthreadAsyncTask<Void, Void, int[]> {
        public final WeakReference<SubsamplingScaleImageView> h;
        public final WeakReference<Context> i;
        public final WeakReference<DecoderFactory<? extends ImageRegionDecoder>> j;
        public final Uri k;
        public ImageRegionDecoder l;
        public Exception m;

        public final Object doInBackground(Object[] r7) {
            Void[] r8 = (Void[]) r7;
            String r0 = this.k.toString();     // Catch: Exception -> L9
            Context r1 = this.i.get();     // Catch: Exception -> L9
            DecoderFactory<? extends ImageRegionDecoder> r2 = this.j.get();     // Catch: Exception -> L9
            SubsamplingScaleImageView r3 = this.h.get();     // Catch: Exception -> L9
            if (r1 == null) goto L11;
            if (r2 == null) goto L11;
            if (r3 == null) goto L11;
            SubsamplingScaleImageView.j(r3, "TilesInitTask.doInBackground", new Object[0]);     // Catch: Exception -> L9
            ImageRegionDecoder r4 = (ImageRegionDecoder) r2.make();     // Catch: Exception -> L9
            this.l = r4;     // Catch: Exception -> L9
            Point r5 = r4.init(r1, this.k);     // Catch: Exception -> L9
            return new int[]{r5.x, r5.y, SubsamplingScaleImageView.k(r3, r1, r0)};
        L11:
            return null;
        L9:
            e = move-exception;
            List<Integer> r6 = SubsamplingScaleImageView.g2;
            tt5.a.e("SubsamplingScaleImageView", "Failed to initialise bitmap decoder", e, false);
            this.m = e;
            goto L11
        }

        public final void onPostExecute(Object r6) {
            int[] r7 = (int[]) r6;
            SubsamplingScaleImageView r0 = this.h.get();
            if (r0 != null) goto L5;
            return;
        L5:
            if (this.l == null) goto L10;
            if (r7 == null) goto L10;
            if (r7.length != 3) goto L10;
            SubsamplingScaleImageView.l(r0, this.l, r7[0], r7[1], r7[2]);
            return;
        L10:
            Exception r8 = this.m;
            if (r8 == null) goto L20;
            r95.h.a r1 = r0.b1;
            if (r1 == null) goto L21;
            tt5.a.i("preview_image", "DriveSubsamplingScaleImageView onImageLoadError() error=", r8);
            com.bytedance.ee.bear.drive.view.preview.imageviewer.b r2 = r1.a.E2;
            if (r2 == null) goto L22;
            r2.b("subsampling_image", r8, false, true);
            return;
        L22:
            return;
        L21:
            return;
        }

        public n(SubsamplingScaleImageView r2, Context r3, DecoderFactory<? extends ImageRegionDecoder> r4, Uri r5) {
            this.h = new WeakReference(r2);
            this.i = new WeakReference(r3);
            this.j = new WeakReference(r4);
            this.k = r5;
        }
    }

    public void setOnStateChangedListener(i r1) {
    }

    static {
        g2 = Arrays.asList(new Integer[]{0, 90, 180, 270, -1});
        h2 = Arrays.asList(new Integer[]{1, 2, 3});
        p2 = Arrays.asList(new Integer[]{2, 1});
        v2 = Arrays.asList(new Integer[]{1, 2, 3});
        x2 = Arrays.asList(new Integer[]{2, 1, 3, 4});
    }

    private int getRequiredRotation() {
        int r0 = this.h;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        return this.H;
    }

    public final boolean D() {
        boolean r1 = true;
        if (this.a != null) goto L5;
    L7:
        Map<Integer, List<l>> r0 = this.f;
        if (r0 == null) goto L23;
        Iterator<Map.Entry<Integer, List<l>>> r2 = r0.entrySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L22;
        Map.Entry<Integer, List<l>> r3 = r2.next();
        if (r3.getKey().intValue() != this.e) goto L11;
        Iterator<l> r4 = r3.getValue().iterator();
    L16:
        if (r4.hasNext() == false) goto L11;
        l r5 = r4.next();
        if (r5.d == true) goto L21;
        if (r5.c != null) goto L16;
    L21:
        r1 = false;
        goto L16
    L22:
        return r1;
    L23:
        return false;
    L5:
        if (this.b == true) goto L7;
        return true;
    }

    public RectF getContentRect() {
        if (this.z != null) goto L5;
        return null;
    L5:
        if (getSWidth() > 0) goto L7;
        return null;
    L7:
        if (getSHeight() <= 0) goto L14;
        float r0 = getScale();
        float r1 = getSWidth() * r0;
        float r2 = getSHeight() * r0;
        PointF r3 = this.z;
        float r4 = r3.x;
        float r5 = r3.y;
        return new RectF(r4, r5, r1 + r4, r2 + r5);
    L14:
        return null;
    }

    public float getScaleFactor() {
        return 1.0f / getMinScale();
    }

    public final ImageViewState getState() {
        if (this.z != null) goto L5;
        return null;
    L5:
        if (this.F > 0) goto L7;
        return null;
    L7:
        if (this.G > 0) goto L9;
        return null;
    L9:
        return new ImageViewState(getScale(), getCenter(), getOrientation());
    }

    public final void u() {
        if (this.v1 != null) goto L6;
        Paint r0 = new Paint();
        this.v1 = r0;
        r0.setAntiAlias(true);
        this.v1.setFilterBitmap(true);
        this.v1.setDither(true);
    L6:
        if (this.x1 == null) goto L10;
        if (this.y1 == null) goto L10;
        return;
    L10:
        if (this.g == false) goto L14;
        Paint r1 = new Paint();
        this.x1 = r1;
        r1.setTextSize(I(12));
        this.x1.setColor(-65281);
        this.x1.setStyle(Paint.Style.FILL);
        Paint r2 = new Paint();
        this.y1 = r2;
        r2.setColor(-65281);
        this.y1.setStyle(Paint.Style.STROKE);
        this.y1.setStrokeWidth(I(1));
        return;
    }

    private float E() {
        int r0 = getPaddingBottom() + getPaddingTop();
        int r1 = getPaddingLeft() + getPaddingRight();
        int r2 = this.m;
        if (r2 == 2) goto L15;
        if (r2 == 4) goto L15;
        if (r2 != 3) goto L13;
        float r3 = this.j;
        if (r3 <= 0.0f) goto L13;
        return r3;
    L13:
        return Math.min((getWidth() - r1) / M(), (getHeight() - r0) / L());
    L15:
        return Math.max((getWidth() - r1) / M(), (getHeight() - r0) / L());
    }

    private void H() {
        if (getWidth() != 0) goto L5;
        return;
    L5:
        if (getHeight() != 0) goto L7;
        return;
    L7:
        if (this.F > 0) goto L9;
        return;
    L9:
        if (this.G <= 0) goto L23;
        PointF r0 = this.D;
        Float r1 = this.C;
        if (r0 == null) goto L18;
        if (r1 == null) goto L18;
        this.x = r1.floatValue();
        if (this.z != null) goto L17;
        this.z = new PointF();
    L17:
        this.z.x = (getWidth() / 2) - (this.x * r0.x);
        this.z.y = (getHeight() / 2) - (this.x * r0.y);
        this.D = null;
        this.C = null;
        y(true);
        J(true);
    L18:
        y(false);
        return;
    }

    private int L() {
        int r0 = getRequiredRotation();
        if (r0 == 90) goto L10;
        if (r0 == 270) goto L10;
        return this.G;
    L10:
        return this.F;
    }

    private int M() {
        int r0 = getRequiredRotation();
        if (r0 == 90) goto L10;
        if (r0 == 270) goto L10;
        return this.F;
    L10:
        return this.G;
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final PointF getCenter() {
        float r0 = getWidth() / 2;
        float r1 = getHeight() / 2;
        PointF r2 = new PointF();
        PointF r3 = this.z;
        if (r3 != null) goto L5;
        return null;
    L5:
        float r4 = r0 - r3.x;
        float r5 = this.x;
        r2.set(r4 / r5, (r1 - r3.y) / r5);
        return r2;
    }

    public float getMaximumScale() {
        return getMaxScale();
    }

    public final float getMinScale() {
        return E();
    }

    public float getMinimumScale() {
        return getMinScale();
    }

    public final boolean r() {
        boolean r0 = D();
        if (this.V0 == true) goto L14;
        if (r0 == false) goto L14;
        H();
        this.V0 = true;
        r95.h.a r1 = this.b1;
        if (r1 == null) goto L12;
        r95.h.a r2 = r1;
        r2.getClass();
        tt5.a.h("preview_image", "DriveSubsamplingScaleImageView onImageLoaded()");
        com.bytedance.ee.bear.drive.view.preview.imageviewer.b r3 = r2.a.E2;
        if (r3 == null) goto L10;
        r3.a("subsampling_image");
        r2.a.E2.onCompleted();
    L10:
        r2.a.post(new r95.g(r2));
    L12:
        if (this.h1 == null) goto L14;
        q(this.z);
        r95.l r4 = this.h1;
        r95.l r5 = r4;
        r5.a(this.V1);
    L14:
        return r0;
    }

    public final boolean s() {
        if (getWidth() > 0) goto L5;
    L15:
        boolean r0 = false;
    L17:
        if (this.P0 == true) goto L22;
        if (r0 == false) goto L22;
        H();
        this.P0 = true;
        h r1 = this.b1;
        if (r1 == null) goto L22;
        r1.getClass();
    L22:
        return r0;
    L5:
        if (getHeight() <= 0) goto L15;
        if (this.F <= 0) goto L15;
        if (this.G <= 0) goto L15;
        if (this.a == null) goto L13;
    L14:
        r0 = true;
        goto L17
    L13:
        if (D() == false) goto L15;
        goto L14
    }

    public static Bitmap.Config getPreferredBitmapConfig() {
        return y2;
    }

    public float getMaxScale() {
        return this.i;
    }

    public final int getOrientation() {
        return this.h;
    }

    public final int getSHeight() {
        return this.G;
    }

    public final int getSWidth() {
        return this.F;
    }

    public final float getScale() {
        return this.x;
    }

    public SubsamplingScaleImageView(Context r2) {
        this(r2, null);
    }

    private void J(boolean r14) {
        if (this.O != null) goto L5;
        return;
    L5:
        if (this.f == null) goto L86;
        int r0 = Math.min(this.e, p(this.x));
        Iterator r1 = ((LinkedHashMap) this.f).entrySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L87;
        Iterator r2 = ((List) ((Map.Entry) r1.next()).getValue()).iterator();
    L12:
        if (r2.hasNext() == false) goto L9;
        l r3 = (l) r2.next();
        int r4 = r3.b;
        if (r4 < r0) goto L18;
        if (r4 > r0) goto L17;
    L21:
        int r5 = r3.b;
        if (r5 == r0) goto L23;
        if (r5 != this.e) goto L12;
        r3.e = true;
        goto L12
    L23:
        PointF r6 = this.z;
        float r8 = Float.NaN;
        if (r6 != null) goto L26;
        float r7 = Float.NaN;
    L27:
        float r10 = getWidth();
        PointF r11 = this.z;
        if (r11 != null) goto L30;
        float r12 = Float.NaN;
    L31:
        if (r11 != null) goto L33;
        float r9 = Float.NaN;
    L34:
        float r13 = getHeight();
        PointF r15 = this.z;
        if (r15 == null) goto L38;
        r8 = (r13 - r15.y) / this.x;
    L38:
        Rect r16 = r3.a;
        if (r7 <= r16.right) goto L41;
    L47:
        boolean r17 = false;
    L48:
        if (r17 == true) goto L49;
        if (r3.b == this.e) goto L12;
        r3.e = false;
        Bitmap r18 = r3.c;
        if (r18 == null) goto L12;
        r18.recycle();
        r3.c = null;
        goto L12
    L49:
        r3.e = true;
        if (r3.d == true) goto L12;
        if (r3.c != null) goto L12;
        if (r14 == false) goto L12;
        new m(this, this.O, r3).executeOnExecutor(this.p, new Void[0]);
        goto L12
    L41:
        if (r16.left > r12) goto L47;
        if (r9 > r16.bottom) goto L47;
        if (r16.top > r8) goto L47;
        r17 = true;
        goto L48
    L33:
        r9 = (0.0f - r11.y) / this.x;
        goto L34
    L30:
        r12 = (r10 - r11.x) / this.x;
        goto L31
    L26:
        r7 = (0.0f - r6.x) / this.x;
        goto L27
    L17:
        if (r4 == this.e) goto L21;
    L18:
        r3.e = false;
        Bitmap r19 = r3.c;
        if (r19 == null) goto L21;
        r19.recycle();
        r3.c = null;
        goto L21
    L87:
        return;
    }

    private void K(boolean r8) {
        v("reset newImage=" + r8, new Object[0]);
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = Float.valueOf(0.0f);
        this.D = null;
        this.E = null;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = 0;
        this.e = 0;
        this.S = null;
        this.T = 0.0f;
        this.V = 0.0f;
        this.W = false;
        this.p0 = null;
        this.k0 = null;
        this.H0 = null;
        this.L0 = null;
        this.H1 = null;
        this.L1 = null;
        this.M1 = null;
        if (r8 == false) goto L23;
        this.d = null;
        tt5.a.k("SubsamplingScaleImageView", ThreadMethodProxy.currentThread().getName() + ", try getLock:start");
        boolean r9 = ((ReentrantReadWriteLock) this.P).writeLock().tryLock();
        tt5.a.k("SubsamplingScaleImageView", ThreadMethodProxy.currentThread().getName() + ", getLock: success");
        if (r9 == true) goto L37;
        tt5.a.k("SubsamplingScaleImageView", ThreadMethodProxy.currentThread().getName() + ", getLock: Failed!");
    L14:
        Bitmap r10 = this.a;
        if (r10 == null) goto L20;
        if (this.c == true) goto L20;
        r10.recycle();
    L20:
        if (this.a == null) goto L22;
        boolean r11 = this.c;
    L22:
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.P0 = false;
        this.V0 = false;
        this.a = null;
        this.b = false;
        this.c = false;
        goto L23
    L37:
        ImageRegionDecoder r12 = this.O;     // Catch: Throwable -> L10
        if (r12 == null) goto L9;
        r12.recycle();     // Catch: Throwable -> L10
        this.O = null;     // Catch: Throwable -> L10
    L9:
        tt5.a.k("SubsamplingScaleImageView", ThreadMethodProxy.currentThread().getName() + ", try freed writeLock:start");
        ((ReentrantReadWriteLock) this.P).writeLock().unlock();
        tt5.a.k("SubsamplingScaleImageView", ThreadMethodProxy.currentThread().getName() + ", freed writeLock success");
    L10:
        th = move-exception;
        tt5.a.k("SubsamplingScaleImageView", ThreadMethodProxy.currentThread().getName() + ", try freed writeLock:start");
        ((ReentrantReadWriteLock) this.P).writeLock().unlock();
        tt5.a.k("SubsamplingScaleImageView", ThreadMethodProxy.currentThread().getName() + ", freed writeLock success");
        throw th;
    L23:
        Map<Integer, List<l>> r13 = this.f;
        if (r13 == null) goto L35;
        Iterator r14 = ((LinkedHashMap) r13).entrySet().iterator();
    L27:
        if (r14.hasNext() == false) goto L34;
        Iterator r0 = ((List) ((Map.Entry) r14.next()).getValue()).iterator();
    L30:
        if (r0.hasNext() == false) goto L27;
        l r1 = (l) r0.next();
        r1.e = false;
        Bitmap r2 = r1.c;
        if (r2 == null) goto L30;
        r2.recycle();
        r1.c = null;
        goto L30
    L34:
        this.f = null;
    L35:
        setGestureDetector(getContext());
    }

    public static DisplayMetrics b(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static /* synthetic */ void h(SubsamplingScaleImageView r1) {
        super.setOnLongClickListener(null);
    }

    public static void n(SubsamplingScaleImageView r3) {
        monitor-enter(r3);
        r3.v("onTileLoaded", new Object[0]);     // Catch: Throwable -> L14
        r3.s();     // Catch: Throwable -> L14
        r3.r();     // Catch: Throwable -> L14
        if (r3.D() == false) goto L11;
        Bitmap r0 = r3.a;     // Catch: Throwable -> L14
        if (r0 == null) goto L11;
        if (r3.c == true) goto L10;
        r0.recycle();     // Catch: Throwable -> L14
    L10:
        r3.a = null;     // Catch: Throwable -> L14
        h r1 = r3.b1;     // Catch: Throwable -> L14
        r3.b = false;     // Catch: Throwable -> L14
        r3.c = false;     // Catch: Throwable -> L14
    L11:
        r3.invalidate();     // Catch: Throwable -> L14
        monitor-exit(r3);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void setGestureDetector(Context r3) {
        this.M = new GestureDetector(r3, new b(this, r3));
        this.N = new GestureDetector(r3, new c(this));
    }

    public static void setPreferredBitmapConfig(Bitmap.Config r0) {
        y2 = r0;
    }

    public static int t(ExifInterface r20) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {"Orientation", 1};
        f06.b r13 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(100022);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r9 = r3;
        int r8 = r9.length;
        int r7 = 0;
    L8:
        if (r7 >= r8) goto L15;
        f06.a r6 = r9[r7];
        int r17 = r7;
        int r18 = r8;
        f06.a[] r19 = r9;
        f06.d r4 = r6.preInvoke(100022, "android/media/ExifInterface", "getAttributeInt", r20, r1, "int", r13);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r6);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Integer) r4.b).intValue();
    L21:
        return r20.getAttributeInt("Orientation", 1);
    L14:
        r7 = r17 + 1;
        r8 = r18;
        r9 = r19;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    private void y(boolean r5) {
        if (this.z != null) goto L5;
        this.z = new PointF(0.0f, 0.0f);
        boolean r0 = true;
    L7:
        if (this.H1 != null) goto L9;
        this.H1 = new j(0.0f, new PointF(0.0f, 0.0f));
    L9:
        j r1 = this.H1;
        r1.a = this.x;
        r1.b.set(this.z);
        z(r5, this.H1);
        j r6 = this.H1;
        this.x = r6.a;
        this.z.set(r6.b);
        if (r0 == true) goto L12;
        return;
    L12:
        if (this.m == 4) goto L16;
        this.z.set(U(M() / 2, L() / 2, this.x));
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L7
    }

    public final Point A(Canvas r4) {
        return new Point(Math.min(r4.getMaximumBitmapWidth(), this.n), Math.min(r4.getMaximumBitmapHeight(), this.o));
    }

    public final synchronized void B(Point r7) {
        monitor-enter(this);
        v("initialiseBaseLayer maxTileDimensions=%dx%d", new Object[]{Integer.valueOf(r7.x), Integer.valueOf(r7.y)});     // Catch: Throwable -> L34
        k r0 = this.b2;     // Catch: Throwable -> L34
        if (r0 != null) goto L6;
    L8:
        this.e = p(this.j);     // Catch: Throwable -> L34
    L9:
        k r1 = this.b2;     // Catch: Throwable -> L34
        if (r1 != null) goto L12;
    L16:
        int r2 = this.e;     // Catch: Throwable -> L34
        if (r2 <= 8) goto L19;
        this.e = r2 / 8;     // Catch: Throwable -> L34
    L21:
        if (this.e == 1) goto L23;
    L27:
        C(r7);     // Catch: Throwable -> L34
        Iterator r8 = ((List) ((LinkedHashMap) this.f).get(Integer.valueOf(this.e))).iterator();     // Catch: Throwable -> L34
    L29:
        if (r8.hasNext() == false) goto L31;
        new m(this, this.O, (l) r8.next()).executeOnExecutor(this.p, new Void[0]);     // Catch: Throwable -> L34
        goto L29
    L31:
        J(true);     // Catch: Throwable -> L34
    L32:
        monitor-exit(this);
        return;
    L23:
        if (M() >= r7.x) goto L27;
        if (L() >= r7.y) goto L27;
        this.O.recycle();     // Catch: Throwable -> L34
        this.O = null;     // Catch: Throwable -> L34
        new f(this, getContext(), this.Q, this.d).executeOnExecutor(this.p, new Void[0]);     // Catch: Throwable -> L34
        goto L32
    L19:
        this.e = 1;     // Catch: Throwable -> L34
        goto L21
    L12:
        if (r1.a == false) goto L16;
        int r3 = this.e;     // Catch: Throwable -> L34
        if (r3 <= 1) goto L21;
        this.e = r3 / 2;     // Catch: Throwable -> L34
        goto L21
    L6:
        if (r0.b == false) goto L8;
        j r4 = new j(0.0f, new PointF(0.0f, 0.0f));     // Catch: Throwable -> L34
        this.H1 = r4;     // Catch: Throwable -> L34
        z(true, r4);     // Catch: Throwable -> L34
        this.e = p(this.H1.a);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }

    public final void C(Point r18) {
        int r5 = 1;
        v("initialiseTileMap maxTileDimensions=%dx%d", new Object[]{Integer.valueOf(r18.x), Integer.valueOf(r18.y)});
        this.f = new LinkedHashMap();
        int r2 = this.e;
        int r3 = 1;
        int r6 = 1;
    L3:
        int r7 = M() / r3;
        int r8 = L() / r6;
        int r9 = r7 / r2;
        int r10 = r8 / r2;
    L5:
        if (((r9 + r3) + r5) > r18.x) goto L41;
        if (r9 <= (((double) getWidth()) * 1.25d)) goto L12;
        if (r2 < this.e) goto L41;
    L12:
        if (((r10 + r6) + r5) > r18.y) goto L40;
        if (r10 <= (((double) getHeight()) * 1.25d)) goto L18;
        if (r2 < this.e) goto L40;
    L18:
        ArrayList r11 = new ArrayList(r3 * r6);
        int r12 = 0;
    L19:
        if (r12 >= r3) goto L36;
        int r13 = 0;
    L21:
        if (r13 >= r6) goto L35;
        l r14 = new l();
        r14.b = r2;
        if (r2 != this.e) goto L25;
        boolean r15 = true;
    L26:
        r14.e = r15;
        int r16 = r12 * r7;
        int r17 = r13 * r8;
        if (r12 != (r3 - 1)) goto L29;
        int r19 = M();
    L31:
        if (r13 != (r6 - 1)) goto L33;
        int r4 = L();
    L34:
        r14.a = new Rect(r16, r17, r19, r4);
        r14.f = new Rect(0, 0, 0, 0);
        r14.g = new Rect(r14.a);
        r11.add(r14);
        r13 = r13 + 1;
        goto L21
    L33:
        r4 = (r13 + 1) * r8;
        goto L34
    L29:
        r19 = (r12 + 1) * r7;
        goto L31
    L25:
        r15 = false;
        goto L26
    L35:
        r12 = r12 + 1;
        goto L19
    L36:
        this.f.put(Integer.valueOf(r2), r11);
        if (r2 == 1) goto L38;
        r2 = r2 / 2;
        r5 = 1;
        goto L3
    L38:
        return;
    L40:
        r6 = r6 + 1;
        r8 = L() / r6;
        r10 = r8 / r2;
        r5 = 1;
    L41:
        r3 = r3 + 1;
        r7 = M() / r3;
        r9 = r7 / r2;
        r5 = 1;
        goto L5
    }

    public final synchronized void G(Bitmap r3) {
        monitor-enter(this);
        v("onPreviewLoaded", new Object[0]);     // Catch: Throwable -> L16
        if (this.a == null) goto L6;
    L13:
        r3.recycle();     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L6:
        if (this.V0 == true) goto L13;
        this.a = r3;     // Catch: Throwable -> L16
        this.b = true;     // Catch: Throwable -> L16
        if (s() == false) goto L11;
        invalidate();     // Catch: Throwable -> L16
        requestLayout();     // Catch: Throwable -> L16
    L11:
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public final int I(int r2) {
        return (int) (this.S1 * r2);
    }

    public final PointF Q(PointF r4) {
        float r0 = r4.x;
        float r5 = r4.y;
        PointF r1 = new PointF();
        if (this.z != null) goto L5;
        return null;
    L5:
        r1.set(S(r0), T(r5));
        return r1;
    }

    public final float S(float r3) {
        PointF r0 = this.z;
        if (r0 != null) goto L7;
        return Float.NaN;
    L7:
        return (r3 * this.x) + r0.x;
    }

    public final float T(float r3) {
        PointF r0 = this.z;
        if (r0 != null) goto L7;
        return Float.NaN;
    L7:
        return (r3 * this.x) + r0.y;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r36) {
        super.onDraw(r36);     // Catch: Exception -> L161
        u();     // Catch: Exception -> L161
        if (this.F != 0) goto L6;
        return;
    L6:
        if (this.G != 0) goto L8;
        return;
    L8:
        if (getWidth() != 0) goto L10;
        return;
    L10:
        if (getHeight() != 0) goto L13;
        return;
    L13:
        if (this.f != null) goto L18;
        if (this.O == null) goto L18;
        B(A(r36));     // Catch: Exception -> L161
    L18:
        if (s() == true) goto L20;
        return;
    L20:
        H();     // Catch: Exception -> L161
        d r6 = this.L0;     // Catch: Exception -> L161
        if (r6 == null) goto L43;
        if (d.b(r6) == null) goto L43;
        float r7 = this.x;     // Catch: Exception -> L161
        if (this.B != null) goto L27;
        this.B = new PointF(0.0f, 0.0f);     // Catch: Exception -> L161
    L27:
        this.B.set(this.z);     // Catch: Exception -> L161
        long r10 = System.currentTimeMillis() - d.c(this.L0);     // Catch: Exception -> L161
        if (r10 <= d.d(this.L0)) goto L30;
        boolean r12 = true;
    L31:
        long r11 = Math.min(r10, d.d(this.L0));     // Catch: Exception -> L161
        this.x = x(d.e(this.L0), r11, d.f(this.L0), d.g(this.L0) - d.f(this.L0), d.d(this.L0));     // Catch: Exception -> L161
        float r8 = x(d.e(this.L0), r11, d.b(this.L0).x, d.h(this.L0).x - d.b(this.L0).x, d.d(this.L0));     // Catch: Exception -> L161
        float r9 = x(d.e(this.L0), r11, d.b(this.L0).y, d.h(this.L0).y - d.b(this.L0).y, d.d(this.L0));     // Catch: Exception -> L161
        this.z.x -= S(d.i(this.L0).x) - r8;     // Catch: Exception -> L161
        this.z.y -= T(d.i(this.L0).y) - r9;     // Catch: Exception -> L161
        if (r12 == false) goto L34;
    L37:
        boolean r13 = true;
    L38:
        y(r13);     // Catch: Exception -> L161
        PointF r14 = this.B;     // Catch: Exception -> L161
        d.j(this.L0);     // Catch: Exception -> L161
        N(r7, r14);     // Catch: Exception -> L161
        J(r12);     // Catch: Exception -> L161
        if (r12 == false) goto L41;
        d.a(this.L0);     // Catch: Exception -> L161
        this.L0 = null;     // Catch: Exception -> L161
    L41:
        invalidate();     // Catch: Exception -> L161
        goto L43
    L34:
        if (d.f(this.L0) == d.g(this.L0)) goto L37;
        r13 = false;
        goto L38
    L30:
        r12 = false;
    L43:
        if (this.f != null) goto L45;
    L109:
        Bitmap r4 = this.a;     // Catch: Exception -> L161
        if (r4 == null) goto L143;
        float r15 = this.x;     // Catch: Exception -> L161
        if (this.b == false) goto L114;
        float r16 = r15 * (this.F / r4.getWidth());     // Catch: Exception -> L161
        r15 = this.x * (this.G / this.a.getHeight());     // Catch: Exception -> L161
        float r5 = r16;
    L116:
        if (this.L1 != null) goto L118;
        this.L1 = new Matrix();     // Catch: Exception -> L161
    L118:
        this.L1.reset();     // Catch: Exception -> L161
        this.L1.postScale(r5, r15);     // Catch: Exception -> L161
        this.L1.postRotate(getRequiredRotation());     // Catch: Exception -> L161
        Matrix r17 = this.L1;     // Catch: Exception -> L161
        PointF r18 = this.z;     // Catch: Exception -> L161
        r17.postTranslate(r18.x, r18.y);     // Catch: Exception -> L161
        if (getRequiredRotation() != 180) goto L122;
        Matrix r19 = this.L1;     // Catch: Exception -> L161
        float r20 = this.x;     // Catch: Exception -> L161
        r19.postTranslate(this.F * r20, r20 * this.G);     // Catch: Exception -> L161
    L128:
        if (this.G1 != null) goto L130;
    L141:
        r36.drawBitmap(this.a, this.L1, this.v1);     // Catch: Exception -> L161
        goto L143
    L130:
        if (this.M1 != null) goto L132;
        this.M1 = new RectF();     // Catch: Exception -> L161
    L132:
        RectF r21 = this.M1;     // Catch: Exception -> L161
        if (this.b == false) goto L135;
        int r22 = this.a.getWidth();     // Catch: Exception -> L161
    L136:
        float r23 = r22;
        if (this.b == false) goto L139;
        int r24 = this.a.getHeight();     // Catch: Exception -> L161
    L140:
        r21.set(0.0f, 0.0f, r23, r24);     // Catch: Exception -> L161
        this.L1.mapRect(this.M1);     // Catch: Exception -> L161
        r36.drawRect(this.M1, this.G1);     // Catch: Exception -> L161
        goto L141
    L139:
        r24 = this.G;     // Catch: Exception -> L161
        goto L140
    L135:
        r22 = this.F;     // Catch: Exception -> L161
        goto L136
    L122:
        if (getRequiredRotation() != 90) goto L125;
        this.L1.postTranslate(this.x * this.G, 0.0f);     // Catch: Exception -> L161
        goto L128
    L125:
        if (getRequiredRotation() != 270) goto L128;
        this.L1.postTranslate(0.0f, this.x * this.F);     // Catch: Exception -> L161
        goto L128
    L114:
        r5 = r15;
    L143:
        if (this.g == false) goto L186;
        StringBuilder r25 = new StringBuilder();     // Catch: Exception -> L161
        r25.append("Scale: ");     // Catch: Exception -> L161
        Locale r26 = Locale.ENGLISH;     // Catch: Exception -> L161
        r25.append(String.format(r26, "%.2f", new Object[]{Float.valueOf(this.x)}));     // Catch: Exception -> L161
        r25.append(" (");     // Catch: Exception -> L161
        r25.append(String.format(r26, "%.2f", new Object[]{Float.valueOf(E())}));     // Catch: Exception -> L161
        r25.append(" - ");     // Catch: Exception -> L161
        r25.append(String.format(r26, "%.2f", new Object[]{Float.valueOf(this.i)}));     // Catch: Exception -> L161
        r25.append(")");     // Catch: Exception -> L161
        r36.drawText(r25.toString(), I(5), I(15), this.x1);     // Catch: Exception -> L161
        r36.drawText("Translate: " + String.format(r26, "%.2f", new Object[]{Float.valueOf(this.z.x)}) + ":" + String.format(r26, "%.2f", new Object[]{Float.valueOf(this.z.y)}), I(5), I(30), this.x1);     // Catch: Exception -> L161
        PointF r27 = getCenter();     // Catch: Exception -> L161
        r36.drawText("Source center: " + String.format(r26, "%.2f", new Object[]{Float.valueOf(r27.x)}) + ":" + String.format(r26, "%.2f", new Object[]{Float.valueOf(r27.y)}), I(5), I(45), this.x1);     // Catch: Exception -> L161
        d r3 = this.L0;     // Catch: Exception -> L161
        if (r3 == null) goto L148;
        PointF r28 = Q(d.k(r3));     // Catch: Exception -> L161
        PointF r29 = Q(d.l(this.L0));     // Catch: Exception -> L161
        PointF r110 = Q(d.i(this.L0));     // Catch: Exception -> L161
        r36.drawCircle(r28.x, r28.y, I(10), this.y1);     // Catch: Exception -> L161
        this.y1.setColor(-65536);     // Catch: Exception -> L161
        r36.drawCircle(r29.x, r29.y, I(20), this.y1);     // Catch: Exception -> L161
        this.y1.setColor(-16776961);     // Catch: Exception -> L161
        r36.drawCircle(r110.x, r110.y, I(25), this.y1);     // Catch: Exception -> L161
        this.y1.setColor(-16711681);     // Catch: Exception -> L161
        r36.drawCircle(getWidth() / 2, getHeight() / 2, I(30), this.y1);     // Catch: Exception -> L161
    L148:
        if (this.S == null) goto L151;
        this.y1.setColor(-65536);     // Catch: Exception -> L161
        PointF r30 = this.S;     // Catch: Exception -> L161
        r36.drawCircle(r30.x, r30.y, I(20), this.y1);     // Catch: Exception -> L161
    L151:
        if (this.p0 == null) goto L154;
        this.y1.setColor(-16776961);     // Catch: Exception -> L161
        r36.drawCircle(S(this.p0.x), T(this.p0.y), I(35), this.y1);     // Catch: Exception -> L161
    L154:
        if (this.H0 != null) goto L156;
    L158:
        this.y1.setColor(-65281);     // Catch: Exception -> L161
        return;
    L156:
        if (this.K == false) goto L158;
        this.y1.setColor(-16711681);     // Catch: Exception -> L161
        PointF r31 = this.H0;     // Catch: Exception -> L161
        r36.drawCircle(r31.x, r31.y, I(30), this.y1);     // Catch: Exception -> L161
        goto L158
    L186:
        return;
    L45:
        if (D() == false) goto L109;
        int r32 = Math.min(this.e, p(this.x));     // Catch: Exception -> L161
        Iterator r33 = ((LinkedHashMap) this.f).entrySet().iterator();     // Catch: Exception -> L161
        boolean r111 = false;
    L48:
        if (r33.hasNext() == false) goto L61;
        Map.Entry r112 = (Map.Entry) r33.next();     // Catch: Exception -> L161
        if (((Integer) r112.getKey()).intValue() != r32) goto L48;
        Iterator r113 = ((List) r112.getValue()).iterator();     // Catch: Exception -> L161
    L53:
        if (r113.hasNext() == false) goto L48;
        l r114 = (l) r113.next();     // Catch: Exception -> L161
        if (l.a(r114) == false) goto L53;
        if (l.b(r114) == true) goto L60;
        if (l.f(r114) != null) goto L53;
    L60:
        r111 = true;
        goto L53
    L61:
        Iterator r34 = ((LinkedHashMap) this.f).entrySet().iterator();     // Catch: Exception -> L161
    L63:
        if (r34.hasNext() == false) goto L143;
        Map.Entry r115 = (Map.Entry) r34.next();     // Catch: Exception -> L161
        if (((Integer) r115.getKey()).intValue() == r32) goto L69;
        if (r111 == true) goto L69;
    L108:
        r32 = r32;
        r34 = r34;
        r111 = r111;
    L69:
        Iterator r116 = ((List) r115.getValue()).iterator();     // Catch: Exception -> L161
    L71:
        if (r116.hasNext() == false) goto L108;
        l r117 = (l) r116.next();     // Catch: Exception -> L161
        R(l.c(r117), l.d(r117));     // Catch: Exception -> L161
        if (l.b(r117) == false) goto L75;
    L97:
        int r118 = r32;
        Iterator r35 = r34;
        Iterator r37 = r116;
        boolean r38 = r111;
        if (l.b(r117) == true) goto L100;
    L103:
        if (l.a(r117) == false) goto L107;
        if (this.g == false) goto L107;
        r36.drawText("ISS " + l.e(r117) + " RECT " + l.c(r117).top + "," + l.c(r117).left + "," + l.c(r117).bottom + "," + l.c(r117).right, l.d(r117).left + I(5), l.d(r117).top + I(15), this.x1);     // Catch: Exception -> L161
    L107:
        r32 = r118;
        r34 = r35;
        r116 = r37;
        r111 = r38;
        goto L71
    L100:
        if (this.g == false) goto L103;
        r36.drawText("LOADING", l.d(r117).left + I(5), l.d(r117).top + I(35), this.x1);     // Catch: Exception -> L161
        goto L103
    L75:
        if (l.f(r117) == null) goto L97;
        if (this.G1 == null) goto L80;
        r36.drawRect(l.d(r117), this.G1);     // Catch: Exception -> L161
    L80:
        if (this.L1 != null) goto L82;
        this.L1 = new Matrix();     // Catch: Exception -> L161
    L82:
        this.L1.reset();     // Catch: Exception -> L161
        P(this.P1, 0.0f, 0.0f, l.f(r117).getWidth(), 0.0f, l.f(r117).getWidth(), l.f(r117).getHeight(), 0.0f, l.f(r117).getHeight());     // Catch: Exception -> L161
        if (getRequiredRotation() != 0) goto L85;
        r118 = r32;
        r35 = r34;
        r37 = r116;
        r38 = r111;
        P(this.Q1, l.d(r117).left, l.d(r117).top, l.d(r117).right, l.d(r117).top, l.d(r117).right, l.d(r117).bottom, l.d(r117).left, l.d(r117).bottom);     // Catch: Exception -> L161
    L94:
        this.L1.setPolyToPoly(this.P1, 0, this.Q1, 0, 4);     // Catch: Exception -> L161
        r36.drawBitmap(l.f(r117), this.L1, this.v1);     // Catch: Exception -> L161
        if (this.g == false) goto L103;
        r36.drawRect(l.d(r117), this.y1);     // Catch: Exception -> L161
        goto L103
    L85:
        r118 = r32;
        r35 = r34;
        r37 = r116;
        r38 = r111;
        if (getRequiredRotation() != 90) goto L89;
        P(this.Q1, l.d(r117).right, l.d(r117).top, l.d(r117).right, l.d(r117).bottom, l.d(r117).left, l.d(r117).bottom, l.d(r117).left, l.d(r117).top);     // Catch: Exception -> L161
        goto L94
    L89:
        if (getRequiredRotation() != 180) goto L92;
        P(this.Q1, l.d(r117).right, l.d(r117).bottom, l.d(r117).left, l.d(r117).bottom, l.d(r117).left, l.d(r117).top, l.d(r117).right, l.d(r117).top);     // Catch: Exception -> L161
        goto L94
    L92:
        if (getRequiredRotation() != 270) goto L94;
        P(this.Q1, l.d(r117).left, l.d(r117).bottom, l.d(r117).left, l.d(r117).top, l.d(r117).right, l.d(r117).top, l.d(r117).right, l.d(r117).bottom);     // Catch: Exception -> L161
    L161:
        e = move-exception;
        tt5.a.d("SubsamplingScaleImageView", e.getMessage());
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r15) {
        d r0 = this.L0;
        if (r0 != null) goto L5;
    L10:
        this.L0 = null;
        if (this.z != null) goto L17;
        GestureDetector r1 = this.N;
        if (r1 == null) goto L15;
        r1.onTouchEvent(r15);
    L15:
        return true;
    L17:
        if (this.K == true) goto L24;
        GestureDetector r2 = this.M;
        if (r2 != null) goto L21;
    L22:
        this.I = false;
        this.J = false;
        this.L = 0;
        return true;
    L21:
        if (r2.onTouchEvent(r15) == true) goto L22;
    L24:
        float r4 = 0.0f;
        if (this.A != null) goto L28;
        this.A = new PointF(0.0f, 0.0f);
    L28:
        if (this.B != null) goto L31;
        this.B = new PointF(0.0f, 0.0f);
    L31:
        if (this.S != null) goto L33;
        this.S = new PointF(0.0f, 0.0f);
    L33:
        float r3 = this.x;
        PointF r5 = this.z;
        if (r5 == null) goto L229;
        this.B.set(r5);
        int r6 = r15.getPointerCount();
        int r7 = r15.getAction();
        if (r7 == 0) goto L207;
        if (r7 == 1) goto L174;
        if (r7 == 2) goto L49;
        if (r7 != 5) goto L42;
    L208:
        this.L0 = null;
        ViewParent r8 = getParent();
        if (r8 == null) goto L211;
        r8.requestDisallowInterceptTouchEvent(true);
    L211:
        this.L = Math.max(this.L, r6);
        if (r6 < 2) goto L219;
        if (this.s == false) goto L216;
        float r9 = r15.getX(0) - r15.getX(1);
        float r10 = r15.getY(0) - r15.getY(1);
        float r11 = (float) Math.sqrt((r9 * r9) + (r10 * r10));
        this.y = this.x;
        this.T = r11;
        PointF r12 = this.A;
        PointF r13 = this.z;
        r12.set(r13.x, r13.y);
        this.S.set((r15.getX(0) + r15.getX(1)) / 2.0f, (r15.getY(0) + r15.getY(1)) / 2.0f);
    L217:
        this.p1.removeMessages(1);
    L221:
        boolean r14 = true;
    L222:
        N(r3, this.B);
        if (r14 == false) goto L225;
        return true;
    L225:
        if (super.onTouchEvent(r15) == true) goto L231;
        return false;
    L231:
        return true;
    L216:
        this.L = 0;
        goto L217
    L219:
        if (this.K == true) goto L221;
        PointF r16 = this.A;
        PointF r17 = this.z;
        r16.set(r17.x, r17.y);
        this.S.set(r15.getX(), r15.getY());
        this.p1.sendEmptyMessageDelayed(1, 600);
        goto L221
    L42:
        if (r7 != 6) goto L44;
    L182:
        this.p1.removeMessages(1);
        if (this.K == false) goto L188;
        this.K = false;
        if (this.W == true) goto L188;
        w(this.p0, this.S);
    L188:
        if (this.L <= 0) goto L205;
        boolean r18 = this.I;
        if (r18 == false) goto L192;
    L193:
        if (r18 == false) goto L200;
        if (r6 != 2) goto L200;
        this.J = true;
        PointF r19 = this.A;
        PointF r20 = this.z;
        r19.set(r20.x, r20.y);
        if (r15.getActionIndex() != 1) goto L198;
        this.S.set(r15.getX(0), r15.getY(0));
        goto L200
    L198:
        this.S.set(r15.getX(1), r15.getY(1));
    L200:
        if (r6 >= 3) goto L202;
        this.I = false;
    L202:
        if (r6 >= 2) goto L204;
        this.J = false;
        this.L = 0;
    L204:
        J(true);
        goto L221
    L192:
        if (this.J == true) goto L193;
    L205:
        if (r6 != 1) goto L221;
        this.I = false;
        this.J = false;
        this.L = 0;
        goto L221
    L44:
        if (r7 == 261) goto L208;
        if (r7 == 262) goto L182;
    L173:
        r14 = false;
        goto L222
    L49:
        if (this.L > 0) goto L51;
    L170:
        boolean r21 = false;
    L171:
        if (r21 == false) goto L173;
        this.p1.removeMessages(1);
        invalidate();
        goto L221
    L51:
        if (r6 < 2) goto L80;
        float r22 = r15.getX(0) - r15.getX(1);
        float r23 = r15.getY(0) - r15.getY(1);
        float r24 = (float) Math.sqrt((r22 * r22) + (r23 * r23));
        float r25 = (r15.getX(0) + r15.getX(1)) / 2.0f;
        float r26 = (r15.getY(0) + r15.getY(1)) / 2.0f;
        if (this.s == false) goto L170;
        PointF r27 = this.S;
        float r28 = r27.x - r25;
        float r29 = r27.y - r26;
        if (((float) Math.sqrt((r28 * r28) + (r29 * r29))) <= 5.0f) goto L57;
    L60:
        this.I = true;
        this.J = true;
        double r30 = this.x;
        float r31 = Math.min(this.i, (r24 / this.T) * this.y);
        this.x = r31;
        if (r31 > E()) goto L64;
        this.T = r24;
        this.y = E();
        this.S.set(r25, r26);
        this.A.set(this.z);
    L78:
        y(true);
        J(this.q);
    L169:
        r21 = true;
        goto L171
    L64:
        if (this.r == false) goto L75;
        PointF r32 = this.S;
        float r33 = r32.x;
        PointF r110 = this.A;
        float r34 = r33 - r110.x;
        float r35 = r32.y - r110.y;
        float r111 = this.x / this.y;
        float r36 = r34 * r111;
        float r37 = r35 * r111;
        PointF r112 = this.z;
        r112.x = r25 - r36;
        r112.y = r26 - r37;
        if ((((double) L()) * r30) >= getHeight()) goto L70;
        if ((this.x * L()) < getHeight()) goto L70;
    L73:
        y(true);
        this.S.set(r25, r26);
        this.A.set(this.z);
        this.y = this.x;
        this.T = r24;
    L70:
        if ((r30 * ((double) M())) >= getWidth()) goto L78;
        if ((this.x * M()) < getWidth()) goto L78;
    L75:
        if (this.E == null) goto L77;
        this.z.x = (getWidth() / 2) - (this.x * this.E.x);
        this.z.y = (getHeight() / 2) - (this.x * this.E.y);
        goto L78
    L77:
        this.z.x = (getWidth() / 2) - (this.x * (M() / 2));
        this.z.y = (getHeight() / 2) - (this.x * (L() / 2));
        goto L78
    L57:
        if (Math.abs(r24 - this.T) > 5.0f) goto L60;
        if (this.J == false) goto L170;
    L80:
        if (this.K == false) goto L115;
        float r38 = (Math.abs(this.H0.y - r15.getY()) * 2.0f) + this.U;
        if (this.V != (-1.0f)) goto L84;
        this.V = r38;
    L84:
        float r39 = r15.getY();
        PointF r40 = this.k0;
        if (r39 <= r40.y) goto L87;
        boolean r41 = true;
    L88:
        r40.set(0.0f, r15.getY());
        float r42 = 1.0f;
        float r43 = Math.abs(1.0f - (r38 / this.V)) * 0.5f;
        if (r43 <= 0.03f) goto L91;
    L92:
        this.W = true;
        if (this.V <= 0.0f) goto L97;
        if (r41 == false) goto L96;
        r42 = 1.0f + r43;
        goto L97
    L96:
        r42 = 1.0f - r43;
    L97:
        double r44 = this.x;
        float r45 = Math.max(E(), Math.min(this.i, this.x * r42));
        this.x = r45;
        if (this.r == false) goto L109;
        PointF r46 = this.S;
        float r47 = r46.x;
        PointF r113 = this.A;
        float r114 = r47 - r113.x;
        float r48 = r46.y;
        float r115 = r48 - r113.y;
        float r49 = r45 / this.y;
        float r116 = r114 * r49;
        float r117 = r115 * r49;
        PointF r50 = this.z;
        r50.x = r47 - r116;
        r50.y = r48 - r117;
        if ((((double) L()) * r44) >= getHeight()) goto L104;
        if ((this.x * L()) < getHeight()) goto L104;
    L107:
        y(true);
        this.S.set(Q(this.p0));
        this.A.set(this.z);
        this.y = this.x;
    L113:
        this.V = r4;
        y(true);
        J(this.q);
    L104:
        if ((r44 * ((double) M())) < getWidth()) goto L106;
    L112:
        r4 = r38;
        goto L113
    L106:
        if ((this.x * M()) < getWidth()) goto L112;
    L109:
        if (this.E == null) goto L111;
        this.z.x = (getWidth() / 2) - (this.x * this.E.x);
        this.z.y = (getHeight() / 2) - (this.x * this.E.y);
        goto L112
    L111:
        this.z.x = (getWidth() / 2) - (this.x * (M() / 2));
        this.z.y = (getHeight() / 2) - (this.x * (L() / 2));
        goto L112
    L91:
        if (this.W == false) goto L112;
    L87:
        r41 = false;
        goto L88
    L115:
        if (this.I == true) goto L170;
        float r51 = Math.abs(r15.getX() - this.S.x);
        float r52 = Math.abs(r15.getY() - this.S.y);
        float r53 = this.S1 * 5.0f;
        if (r51 <= r53) goto L119;
    L122:
        this.z.x = this.A.x + (r15.getX() - this.S.x);
        this.z.y = this.A.y + (r15.getY() - this.S.y);
        PointF r54 = this.z;
        float r55 = r54.x;
        float r56 = r54.y;
        y(true);
        PointF r57 = this.z;
        if (r55 == r57.x) goto L125;
        boolean r58 = true;
    L126:
        float r59 = r57.y;
        if (r56 == r59) goto L129;
        boolean r60 = true;
    L130:
        if (r58 == true) goto L132;
    L136:
        boolean r118 = false;
    L137:
        if (r60 == true) goto L139;
    L143:
        boolean r61 = false;
    L144:
        if (r56 == r59) goto L146;
    L148:
        boolean r62 = false;
    L149:
        if (r118 == true) goto L157;
        if (r61 == true) goto L157;
        if (r58 == false) goto L156;
        if (r60 == false) goto L156;
        if (r62 == true) goto L156;
        if (this.J == false) goto L157;
    L156:
        this.J = true;
    L164:
        if (this.r == true) goto L168;
        PointF r63 = this.z;
        PointF r64 = this.A;
        r63.x = r64.x;
        r63.y = r64.y;
        ViewParent r65 = getParent();
        if (r65 == null) goto L168;
        r65.requestDisallowInterceptTouchEvent(false);
    L168:
        J(this.q);
    L157:
        if (r51 <= r53) goto L159;
    L160:
        this.L = 0;
        this.p1.removeMessages(1);
        ViewParent r66 = getParent();
        if (r66 == null) goto L164;
        r66.requestDisallowInterceptTouchEvent(false);
        goto L164
    L159:
        if (r52 <= r53) goto L164;
    L146:
        if (r52 <= (3.0f * r53)) goto L148;
        r62 = true;
        goto L149
    L139:
        if (r52 <= r51) goto L143;
        if (this.J == true) goto L143;
        r61 = true;
        goto L144
    L132:
        if (r51 <= r52) goto L136;
        if (this.J == true) goto L136;
        r118 = true;
        goto L137
    L129:
        r60 = false;
        goto L130
    L125:
        r58 = false;
        goto L126
    L119:
        if (r52 > r53) goto L122;
        if (this.J == false) goto L170;
    L174:
        float r67 = getScale();
        if (this.g1 == null) goto L182;
        float r68 = this.T1;
        int r69 = iu5.c.a;
        if (Math.abs(r67 - r68) >= 1.0E-8f) goto L179;
        boolean r70 = true;
    L180:
        if (r70 == true) goto L182;
        this.g1.a(this.T1, r67);
        goto L182
    L179:
        r70 = false;
        goto L180
    L207:
        this.T1 = getScale();
        goto L208
    L229:
        return true;
    L5:
        if (r0.i == true) goto L10;
        ViewParent r119 = getParent();
        if (r119 == null) goto L9;
        r119.requestDisallowInterceptTouchEvent(true);
    L9:
        return true;
    }

    public final int p(float r4) {
        if (this.k <= 0) goto L5;
        DisplayMetrics r0 = b(getResources());
        r4 = r4 * (this.k / ((r0.xdpi + r0.ydpi) / 2.0f));
    L5:
        int r1 = (int) (M() * r4);
        int r5 = (int) (L() * r4);
        if (r1 == 0) goto L23;
        if (r5 == 0) goto L27;
        int r2 = 1;
        if (L() <= r5) goto L12;
    L15:
        int r6 = Math.round(L() / r5);
        int r3 = Math.round(M() / r1);
        if (r6 < r3) goto L19;
        r6 = r3;
    L19:
        int r7 = r2 * 2;
        if (r7 >= r6) goto L22;
        r2 = r7;
        goto L19
    L22:
        return r2;
    L12:
        if (M() > r1) goto L15;
        r6 = 1;
        goto L19
    L27:
        return 32;
    L23:
        return 32;
    }

    public final void q(PointF r5) {
        RectF r0 = this.V1;
        r0.left = r5.x;
        r0.top = r5.y;
        if (getRequiredRotation() != 90) goto L5;
    L8:
        RectF r1 = this.V1;
        float r2 = r5.x;
        float r3 = this.G;
        float r4 = this.x;
        r1.right = r2 + (r3 * r4);
        r1.bottom = r5.y + (this.F * r4);
        return;
    L5:
        if (getRequiredRotation() == 270) goto L8;
        RectF r6 = this.V1;
        float r7 = r5.x;
        float r8 = this.F;
        float r9 = this.x;
        r6.right = r7 + (r8 * r9);
        r6.bottom = r5.y + (this.G * r9);
    }

    public final void setBitmapDecoderClass(Class<? extends ImageDecoder> r2) {
        if (r2 == null) goto L6;
        this.Q = new CompatDecoderFactory(r2);
        return;
    L6:
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setBitmapDecoderFactory(DecoderFactory<? extends ImageDecoder> r2) {
        if (r2 == null) goto L6;
        this.Q = r2;
        return;
    L6:
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setDebug(boolean r1) {
        this.g = r1;
    }

    public final void setDoubleTapZoomDpi(int r3) {
        DisplayMetrics r0 = b(getResources());
        setDoubleTapZoomScale(((r0.xdpi + r0.ydpi) / 2.0f) / r3);
    }

    public final void setDoubleTapZoomDuration(int r2) {
        this.w = Math.max(0, r2);
    }

    public final void setDoubleTapZoomScale(float r1) {
        this.u = r1;
    }

    public final void setDoubleTapZoomStyle(int r4) {
        if (h2.contains(Integer.valueOf(r4)) == false) goto L7;
        this.v = r4;
        return;
    L7:
        throw new IllegalArgumentException("Invalid zoom style: " + r4);
    }

    public final void setDrivePhotoViewDoubleTapZoomScale(float r2) {
        this.u = r2 / getScaleFactor();
    }

    public void setEagerLoadingEnabled(boolean r1) {
        this.q = r1;
    }

    public void setExecutor(Executor r2) {
        if (r2 == null) goto L6;
        this.p = r2;
        return;
    L6:
        throw new NullPointerException("Executor must not be null");
    }

    public final void setImage(zl5.a r2) {
        O(r2, null);
    }

    public final void setMaxScale(float r1) {
        this.i = r1;
    }

    public void setMaxTileSize(int r1) {
        this.n = r1;
        this.o = r1;
    }

    public final void setMaximumDpi(int r3) {
        DisplayMetrics r0 = b(getResources());
        setMinScale(((r0.xdpi + r0.ydpi) / 2.0f) / r3);
    }

    public final void setMinScale(float r1) {
        this.j = r1;
    }

    public final void setMinimumDpi(int r3) {
        DisplayMetrics r0 = b(getResources());
        setMaxScale(((r0.xdpi + r0.ydpi) / 2.0f) / r3);
    }

    public final void setMinimumScaleType(int r4) {
        if (x2.contains(Integer.valueOf(r4)) == false) goto L9;
        this.m = r4;
        if (this.P0 == false) goto L10;
        y(true);
        invalidate();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Invalid scale type: " + r4);
    }

    public void setMinimumTileDpi(int r3) {
        DisplayMetrics r0 = b(getResources());
        this.k = (int) Math.min((r0.xdpi + r0.ydpi) / 2.0f, r3);
        if (this.P0 == false) goto L6;
        K(false);
        invalidate();
        return;
    }

    public void setOnImageEventListener(h r1) {
        this.b1 = r1;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r1) {
        this.k1 = r1;
    }

    public void setOnMatrixChangeListener(bm5.a r1) {
        this.h1 = r1;
    }

    public void setOnMatrixChangedListener(bm5.a r1) {
        this.h1 = r1;
    }

    public void setOnScaleEventListener(bm5.b r1) {
        this.g1 = r1;
    }

    public final void setOrientation(int r4) {
        if (g2.contains(Integer.valueOf(r4)) == false) goto L7;
        this.h = r4;
        K(false);
        invalidate();
        requestLayout();
        return;
    L7:
        throw new IllegalArgumentException("Invalid orientation: " + r4);
    }

    public final void setPanEnabled(boolean r4) {
        this.r = r4;
        if (r4 == true) goto L10;
        PointF r5 = this.z;
        if (r5 == null) goto L11;
        r5.x = (getWidth() / 2) - (this.x * (M() / 2));
        this.z.y = (getHeight() / 2) - (this.x * (L() / 2));
        if (this.P0 == false) goto L12;
        J(true);
        invalidate();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setPanLimit(int r4) {
        if (v2.contains(Integer.valueOf(r4)) == false) goto L9;
        this.l = r4;
        if (this.P0 == false) goto L10;
        y(true);
        invalidate();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Invalid pan limit: " + r4);
    }

    public final void setQuickScaleEnabled(boolean r1) {
        this.t = r1;
    }

    public final void setRegionDecoderClass(Class<? extends ImageRegionDecoder> r2) {
        if (r2 == null) goto L6;
        this.R = new CompatDecoderFactory(r2);
        return;
    L6:
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setRegionDecoderFactory(DecoderFactory<? extends ImageRegionDecoder> r2) {
        if (r2 == null) goto L6;
        this.R = r2;
        return;
    L6:
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public void setScale(float r1) {
        this.x = r1;
    }

    public void setScaleImageConfig(k r1) {
        this.b2 = r1;
    }

    public final void setTileBackgroundColor(int r3) {
        if (Color.alpha(r3) != 0) goto L5;
        this.G1 = null;
    L6:
        invalidate();
        return;
    L5:
        Paint r0 = new Paint();
        this.G1 = r0;
        r0.setStyle(Paint.Style.FILL);
        this.G1.setColor(r3);
        goto L6
    }

    public final void setZoomEnabled(boolean r1) {
        this.s = r1;
    }

    public SubsamplingScaleImageView(Context r5, AttributeSet r6) {
        super(r5, r6);
        this.h = 0;
        this.i = 2.0f;
        this.j = E();
        this.k = -1;
        this.l = 1;
        this.m = 1;
        this.n = Integer.MAX_VALUE;
        this.o = Integer.MAX_VALUE;
        this.p = AsyncTask.THREAD_POOL_EXECUTOR;
        this.q = true;
        this.r = true;
        this.s = true;
        this.t = true;
        this.u = 1.0f;
        this.v = 1;
        this.w = 500;
        this.P = new ReentrantReadWriteLock(true);
        this.Q = new CompatDecoderFactory(SkiaImageDecoder.class);
        this.R = new CompatDecoderFactory(SkiaImageRegionDecoder.class);
        this.P1 = new float[8];
        this.Q1 = new float[8];
        this.V1 = new RectF();
        this.S1 = b(getResources()).density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMinimumTileDpi(320);
        setGestureDetector(r5);
        this.p1 = new Handler(new a(this));
        if (r6 == null) goto L29;
        TypedArray r7 = getContext().obtainStyledAttributes(r6, new int[]{2130968854, 2130973433, 2130973708, 2130974137, 2130974566, 2130975242});
        if (r7.hasValue(0) == false) goto L12;
        String r2 = r7.getString(0);
        if (r2 == null) goto L12;
        if (r2.length() <= 0) goto L12;
        zl5.a r3 = zl5.a.a("file:///android_asset/".concat(r2));
        r3.c = true;
        setImage(r3);
    L12:
        if (r7.hasValue(3) == false) goto L17;
        int r4 = r7.getResourceId(3, 0);
        if (r4 <= 0) goto L17;
        zl5.a r8 = new zl5.a(r4);
        r8.c = true;
        setImage(r8);
    L17:
        if (r7.hasValue(1) == false) goto L20;
        setPanEnabled(r7.getBoolean(1, true));
    L20:
        if (r7.hasValue(5) == false) goto L23;
        setZoomEnabled(r7.getBoolean(5, true));
    L23:
        if (r7.hasValue(2) == false) goto L26;
        setQuickScaleEnabled(r7.getBoolean(2, true));
    L26:
        if (r7.hasValue(4) == false) goto L28;
        setTileBackgroundColor(r7.getColor(4, Color.argb(0, 0, 0, 0)));
    L28:
        r7.recycle();
    L29:
        this.U = TypedValue.applyDimension(1, 20.0f, b(r5.getResources()));
    }

    public static /* synthetic */ void e(SubsamplingScaleImageView r0, Context r1) {
        r0.setGestureDetector(r1);
    }

    public static /* synthetic */ void f(SubsamplingScaleImageView r0, View.OnLongClickListener r1) {
        super.setOnLongClickListener(r1);
    }

    public static float o(SubsamplingScaleImageView r1, float r2) {
        float r3 = Math.max(r1.E(), r2);
        return Math.min(r1.i, r3);
    }

    private void v(String r2, Object... r3) {
        if (this.g == false) goto L6;
        tt5.a.b("SubsamplingScaleImageView", String.format(r2, r3));
        return;
    }

    private void w(PointF r11, PointF r12) {
        if (this.r == true) goto L8;
        PointF r0 = this.E;
        if (r0 == null) goto L7;
        r11.x = r0.x;
        r11.y = r0.y;
        goto L8
    L7:
        r11.x = M() / 2;
        r11.y = L() / 2;
    L8:
        float r1 = Math.min(this.i, this.u);
        float r2 = this.x;
        if (r2 > (((double) r1) * 0.9d)) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == true) goto L18;
        r1 = E();
    L18:
        int r4 = this.v;
        if (r4 != 3) goto L22;
        this.L0 = null;
        this.C = Float.valueOf(r1);
        this.D = r11;
        this.E = r11;
        invalidate();
    L30:
        invalidate();
        r95.m r13 = this.g1;
        if (r13 == null) goto L34;
        r13.a(getScale(), r1);
        return;
    L34:
        return;
    L22:
        if (r4 == 2) goto L29;
        if (r3 == false) goto L29;
        if (this.r == false) goto L29;
        if (r4 != 1) goto L30;
        e r5 = new e(this, r1, r11, r12);
        r5.g = false;
        r5.d = this.w;
        r5.f = 4;
        r5.a();
    L29:
        e r14 = new e(this, r1, r11);
        r14.g = false;
        r14.d = this.w;
        r14.f = 4;
        r14.a();
        goto L30
    L11:
        if (r2 == this.j) goto L14;
        r3 = false;
        goto L15
    }

    public final synchronized void F(Bitmap r4, int r5) {
        monitor-enter(this);
        v("onImageLoaded", new Object[0]);     // Catch: Throwable -> L28
        int r0 = this.F;     // Catch: Throwable -> L28
        if (r0 > 0) goto L6;
    L12:
        Bitmap r1 = this.a;     // Catch: Throwable -> L28
        if (r1 == null) goto L18;
        if (this.c == true) goto L18;
        r1.recycle();     // Catch: Throwable -> L28
    L18:
        if (this.a != null) goto L20;
    L22:
        this.b = false;     // Catch: Throwable -> L28
        this.c = false;     // Catch: Throwable -> L28
        this.a = r4;     // Catch: Throwable -> L28
        this.F = r4.getWidth();     // Catch: Throwable -> L28
        this.G = r4.getHeight();     // Catch: Throwable -> L28
        this.H = r5;     // Catch: Throwable -> L28
        boolean r6 = s();     // Catch: Throwable -> L28
        boolean r7 = r();     // Catch: Throwable -> L28
        if (r6 == true) goto L25;
        if (r7 == true) goto L25;
    L26:
        monitor-exit(this);
        return;
    L25:
        invalidate();     // Catch: Throwable -> L28
        requestLayout();     // Catch: Throwable -> L28
        goto L26
    L20:
        if (this.c == false) goto L22;
        h r2 = this.b1;     // Catch: Throwable -> L28
        goto L22
    L6:
        if (this.G <= 0) goto L12;
        if (r0 == r4.getWidth()) goto L10;
    L11:
        K(false);     // Catch: Throwable -> L28
        goto L12
    L10:
        if (this.G == r4.getHeight()) goto L12;
    L28:
        th = move-exception;
        throw th;
    }

    public final void N(float r2, PointF r3) {
        if (this.h1 != null) goto L5;
        return;
    L5:
        if (this.x == r2) goto L7;
    L8:
        q(this.z);
        r95.l r4 = this.h1;
        r95.l r5 = r4;
        r5.a(this.V1);
        return;
    L7:
        if (this.z.equals(r3) == false) goto L8;
    }

    public final void O(zl5.a r4, ImageViewState r5) {
        if (r4 == null) goto L19;
        K(true);
        if (r5 != null) goto L6;
    L8:
        Uri r6 = r4.a;
        this.d = r6;
        if (r6 != null) goto L14;
        if (r4.b == null) goto L14;
        this.d = UriProtector.parse("android.resource://" + getContext().getPackageName() + "/" + r4.b);
    L14:
        if (r4.c == true) goto L16;
        new f(this, getContext(), this.Q, this.d).executeOnExecutor(this.p, new Void[0]);
        return;
    L16:
        new n(this, getContext(), this.R, this.d).executeOnExecutor(this.p, new Void[0]);
        return;
    L6:
        if (g2.contains(Integer.valueOf(r5.getOrientation())) == false) goto L8;
        this.h = r5.getOrientation();
        this.C = Float.valueOf(r5.getScale());
        this.D = r5.getCenter();
        invalidate();
        goto L8
    L19:
        throw new NullPointerException("imageSource must not be null");
    }

    public final void R(Rect r4, Rect r5) {
        r5.set((int) S(r4.left), (int) T(r4.top), (int) S(r4.right), (int) T(r4.bottom));
    }

    @Override // android.view.View
    public final void onMeasure(int r6, int r7) {
        int r0 = View.MeasureSpec.getMode(r6);
        int r1 = View.MeasureSpec.getMode(r7);
        int r8 = View.MeasureSpec.getSize(r6);
        int r9 = View.MeasureSpec.getSize(r7);
        boolean r2 = true;
        if (r0 == 1073741824) goto L5;
        boolean r3 = true;
    L6:
        if (r1 != 1073741824) goto L10;
        r2 = false;
    L10:
        if (this.F > 0) goto L12;
    L20:
        setMeasuredDimension(Math.max(r8, getSuggestedMinimumWidth()), Math.max(r9, getSuggestedMinimumHeight()));
        return;
    L12:
        if (this.G <= 0) goto L20;
        if (r3 == false) goto L16;
        if (r2 == false) goto L16;
        r8 = M();
        r9 = L();
    L16:
        if (r2 == false) goto L18;
        r9 = (int) ((((double) L()) / ((double) M())) * ((double) r8));
        goto L20
    L18:
        if (r3 == false) goto L20;
        r8 = (int) ((((double) M()) / ((double) L())) * ((double) r9));
        goto L20
    L5:
        r3 = false;
        goto L6
    }

    public final void z(boolean r12, j r13) {
        if (this.l == 2) goto L5;
    L7:
        PointF r0 = r13.b;
        float r3 = Math.min(this.i, Math.max(E(), r13.a));
        float r4 = M() * r3;
        float r5 = L() * r3;
        if (this.l == 3) goto L10;
    L12:
        if (r12 == false) goto L14;
        r0.x = Math.max(r0.x, getWidth() - r4);
        r0.y = Math.max(r0.y, getHeight() - r5);
    L15:
        float r8 = 0.5f;
        if (getPaddingLeft() <= 0) goto L18;
    L21:
        float r6 = getPaddingLeft() / (getPaddingLeft() + getPaddingRight());
    L23:
        if (getPaddingTop() <= 0) goto L25;
    L26:
        r8 = getPaddingTop() / (getPaddingTop() + getPaddingBottom());
    L28:
        if (this.l == 3) goto L30;
    L32:
        if (r12 == false) goto L34;
        float r14 = Math.max(0.0f, (getWidth() - r4) * r6);
        float r1 = Math.max(0.0f, (getHeight() - r5) * r8);
    L36:
        r0.x = Math.min(r0.x, r14);
        r0.y = Math.min(r0.y, r1);
        r13.a = r3;
        return;
    L34:
        r14 = Math.max(0, getWidth());
        int r2 = Math.max(0, getHeight());
    L35:
        r1 = r2;
        goto L36
    L30:
        if (this.P0 == false) goto L32;
        r14 = Math.max(0, getWidth() / 2);
        r2 = Math.max(0, getHeight() / 2);
        goto L35
    L25:
        if (getPaddingBottom() <= 0) goto L28;
    L18:
        if (getPaddingRight() > 0) goto L21;
        r6 = 0.5f;
        goto L23
    L14:
        r0.x = Math.max(r0.x, -r4);
        r0.y = Math.max(r0.y, -r5);
        goto L15
    L10:
        if (this.P0 == false) goto L12;
        r0.x = Math.max(r0.x, (getWidth() / 2) - r4);
        r0.y = Math.max(r0.y, (getHeight() / 2) - r5);
        goto L15
    L5:
        if (this.P0 == false) goto L7;
        r12 = false;
        goto L7
    }

    public static /* synthetic */ void g(SubsamplingScaleImageView r0, PointF r1, PointF r2) {
        r0.w(r1, r2);
    }

    public static /* synthetic */ void j(SubsamplingScaleImageView r0, String r1, Object[] r2) {
        r0.v(r1, r2);
    }

    public static int k(SubsamplingScaleImageView r12, Context r13, String r14) {
        int r3 = 0;
        if (r14.startsWith("content") == false) goto L26;
        Cursor r0 = null;
        r0 = sf7.a.a.query(r13.getContentResolver(), Uri.parse(r14), new String[]{"orientation"}, null, null, null, new Token("LARK-PSDA-ccm_android_subsampling_scale_imageView_query_media"));     // Catch: Throwable -> L17 Exception -> L19
        if (r0 != null) goto L8;
    L15:
        if (r0 == null) goto L51;
    L21:
        r0.close();
        return r3;
    L51:
        return r3;
    L8:
        if (r0.moveToFirst() == false) goto L15;
        int r15 = r0.getInt(0);     // Catch: Throwable -> L17 Exception -> L19
        if (g2.contains(Integer.valueOf(r15)) == true) goto L12;
    L14:
        tt5.a.k("SubsamplingScaleImageView", "Unsupported orientation: " + r15);     // Catch: Throwable -> L17 Exception -> L19
    L12:
        if (r15 == (-1)) goto L14;
        r3 = r15;
    L19:
        tt5.a.k("SubsamplingScaleImageView", "Could not get orientation of image from media store");     // Catch: Throwable -> L17
        if (r0 != null) goto L21;
        return 0;
    L17:
        th = move-exception;
        if (r0 == null) goto L24;
        r0.close();
    L24:
        throw th;
    L26:
        if (r14.startsWith("file:///") == true) goto L28;
        return 0;
    L28:
        if (r14.startsWith("file:///android_asset/") == true) goto L55;
        int r16 = t(new ExifInterface(r14.substring(7)));     // Catch: Exception -> L44
        if (r16 == 1) goto L56;
        if (r16 != 0) goto L34;
        return 0;
    L34:
        if (r16 != 6) goto L37;
        return 90;
    L37:
        if (r16 != 3) goto L40;
        return 180;
    L40:
        if (r16 == 8) goto L60;
        tt5.a.k("SubsamplingScaleImageView", "Unsupported EXIF orientation: " + r16);     // Catch: Exception -> L44
        return 0;
    L60:
        return 270;
    L56:
        return 0;
    L44:
        tt5.a.k("SubsamplingScaleImageView", "Could not get EXIF orientation of image");
        return 0;
    L55:
        return 0;
    }

    public static void m(SubsamplingScaleImageView r4, Rect r5, Rect r6) {
        if (r4.getRequiredRotation() != 0) goto L6;
        r6.set(r5);
        return;
    L6:
        if (r4.getRequiredRotation() != 90) goto L9;
        int r0 = r5.top;
        int r7 = r4.G;
        r6.set(r0, r7 - r5.right, r5.bottom, r7 - r5.left);
        return;
    L9:
        if (r4.getRequiredRotation() != 180) goto L11;
        int r1 = r4.F;
        int r2 = r1 - r5.right;
        int r8 = r4.G;
        r6.set(r2, r8 - r5.bottom, r1 - r5.left, r8 - r5.top);
        return;
    L11:
        int r9 = r4.F;
        r6.set(r9 - r5.bottom, r5.left, r9 - r5.top, r5.right);
    }

    public final PointF U(float r6, float r7, float r8) {
        int r0 = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int r1 = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.H1 != null) goto L5;
        this.H1 = new j(0.0f, new PointF(0.0f, 0.0f));
    L5:
        j r2 = this.H1;
        r2.a = r8;
        r2.b.set(r0 - (r6 * r8), r1 - (r7 * r8));
        z(true, this.H1);
        return this.H1.b;
    }

    public final void i(float r5, float r6, float r7) {
        if (this.V0 == true) goto L5;
        return;
    L5:
        if (this.P0 == false) goto L15;
        PointF r0 = new PointF(r6, r7);
        float r8 = r0.x;
        float r9 = r0.y;
        PointF r1 = new PointF();
        PointF r2 = this.z;
        if (r2 != null) goto L9;
        r1 = null;
    L10:
        if (r1 != null) goto L12;
        return;
    L12:
        e r10 = new e(this, r5 / getScaleFactor(), r1, r0);
        r10.g = false;
        r10.d = this.w;
        r10.f = 4;
        r10.a();
        return;
    L9:
        float r11 = r8 - r2.x;
        float r3 = this.x;
        r1.set(r11 / r3, (r9 - r2.y) / r3);
        goto L10
    }

    @Override // android.view.View
    public final void onSizeChanged(int r4, int r5, int r6, int r7) {
        v("onSizeChanged %dx%d -> %dx%d", new Object[]{Integer.valueOf(r6), Integer.valueOf(r7), Integer.valueOf(r4), Integer.valueOf(r5)});
        PointF r8 = getCenter();
        if (this.P0 == false) goto L6;
        if (r8 == null) goto L6;
        this.L0 = null;
        this.C = Float.valueOf(this.x);
        this.D = r8;
    L6:
        if (r7 == 0) goto L12;
        if (r6 != 0) goto L9;
        return;
    L9:
        if (this.h1 == null) goto L14;
        y(true);
        q(this.z);
        this.h1.a(this.V1);
        return;
    L14:
        return;
    }

    public static void l(SubsamplingScaleImageView r5, ImageRegionDecoder r6, int r7, int r8, int r9) {
        monitor-enter(r5);
        r5.v("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", new Object[]{Integer.valueOf(r7), Integer.valueOf(r8), Integer.valueOf(r5.h)});     // Catch: Throwable -> L32
        int r0 = r5.F;     // Catch: Throwable -> L32
        if (r0 <= 0) goto L15;
        int r1 = r5.G;     // Catch: Throwable -> L32
        if (r1 <= 0) goto L15;
        if (r0 != r7) goto L9;
        if (r1 == r8) goto L15;
    L9:
        r5.K(false);     // Catch: Throwable -> L32
        Bitmap r2 = r5.a;     // Catch: Throwable -> L32
        if (r2 == null) goto L15;
        if (r5.c == true) goto L14;
        r2.recycle();     // Catch: Throwable -> L32
    L14:
        r5.a = null;     // Catch: Throwable -> L32
        h r3 = r5.b1;     // Catch: Throwable -> L32
        r5.b = false;     // Catch: Throwable -> L32
        r5.c = false;     // Catch: Throwable -> L32
    L15:
        r5.O = r6;     // Catch: Throwable -> L32
        r5.F = r7;     // Catch: Throwable -> L32
        r5.G = r8;     // Catch: Throwable -> L32
        r5.H = r9;     // Catch: Throwable -> L32
        r5.s();     // Catch: Throwable -> L32
        if (r5.r() == true) goto L29;
        int r10 = r5.n;     // Catch: Throwable -> L32
        if (r10 <= 0) goto L29;
        if (r10 == Integer.MAX_VALUE) goto L29;
        int r11 = r5.o;     // Catch: Throwable -> L32
        if (r11 <= 0) goto L29;
        if (r11 == Integer.MAX_VALUE) goto L29;
        if (r5.getWidth() <= 0) goto L29;
        if (r5.getHeight() <= 0) goto L29;
        r5.B(new Point(r5.n, r5.o));     // Catch: Throwable -> L32
    L29:
        r5.invalidate();     // Catch: Throwable -> L32
        r5.requestLayout();     // Catch: Throwable -> L32
        monitor-exit(r5);
        return;
    L32:
        th = move-exception;
        throw th;
    }

    public static float x(int r2, long r3, float r5, float r6, long r7) {
        if (r2 != 1) goto L5;
        float r4 = r3 / r7;
        return (((-r6) * r4) * (r4 - 2.0f)) + r5;
    L5:
        if (r2 != 2) goto L13;
        float r8 = r3 / (r7 / 2.0f);
        if (r8 >= 1.0f) goto L9;
        float r9 = (r6 / 2.0f) * r8;
    L11:
        return (r9 * r8) + r5;
    L9:
        float r10 = r8 - 1.0f;
        r9 = (-r6) / 2.0f;
        r8 = (r10 * (r10 - 2.0f)) - 1.0f;
        goto L11
    L13:
        throw new IllegalStateException("Unexpected easing type: " + r2);
    }

    public static void P(float[] r1, float r2, float r3, float r4, float r5, float r6, float r7, float r8, float r9) {
        r1[0] = r2;
        r1[1] = r3;
        r1[2] = r4;
        r1[3] = r5;
        r1[4] = r6;
        r1[5] = r7;
        r1[6] = r8;
        r1[7] = r9;
    }
}
