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
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.supervisor.token.Token;
import com.davemorrissey.labs.subscaleview.decoder.CompatDecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.DecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.ImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageRegionDecoder;
import com.larus.nova.R;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
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

/* JADX INFO: loaded from: classes18.dex */
public class SubsamplingScaleImageView extends View {

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public static final List<Integer> f236667g2 = null;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public static final List<Integer> f236668h2 = null;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public static final List<Integer> f236669p2 = null;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final List<Integer> f236670v2 = null;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public static final List<Integer> f236671x2 = null;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public static Bitmap.Config f236672y2;
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

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f236673J;
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f236674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f236675b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public h f236676b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public k f236677b2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f236678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Uri f236679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f236680e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<Integer, List<l>> f236681f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f236682g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public bm5.b f236683g1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f236684h;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public bm5.a f236685h1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f236686i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f236687j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f236688k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public PointF f236689k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public View.OnLongClickListener f236690k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f236691l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f236692m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f236693n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f236694o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Executor f236695p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public PointF f236696p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public final Handler f236697p1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f236698q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f236699r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f236700s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f236701t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f236702u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f236703v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public Paint f236704v1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f236705w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f236706x;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public Paint f236707x1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f236708y;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public Paint f236709y1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public PointF f236710z;

    public class a implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SubsamplingScaleImageView f236711a;

        public a(SubsamplingScaleImageView r100) {
            this.f236711a = r100;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r100) {
            if (r100.what != 1) goto L7;
            SubsamplingScaleImageView r101 = this.f236711a;
            View.OnLongClickListener r102 = r101.f236690k1;
            if (r102 == null) goto L7;
            r101.L = 0;
            SubsamplingScaleImageView.f(r101, r102);
            this.f236711a.performLongClick();
            SubsamplingScaleImageView.h(this.f236711a);
        L7:
            return true;
        }
    }

    public class b extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f236712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SubsamplingScaleImageView f236713b;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r100) {
            SubsamplingScaleImageView r101 = this.f236713b;
            if (r101.f236700s == false) goto L23;
            if (r101.P0 == false) goto L23;
            if (r101.f236710z == null) goto L23;
            SubsamplingScaleImageView.e(r101, this.f236712a);
            SubsamplingScaleImageView r102 = this.f236713b;
            PointF r103 = null;
            if (r102.f236701t == false) goto L16;
            r102.S = new PointF(r100.getX(), r100.getY());
            SubsamplingScaleImageView r104 = this.f236713b;
            PointF r105 = this.f236713b.f236710z;
            r104.A = new PointF(r105.x, r105.y);
            SubsamplingScaleImageView r106 = this.f236713b;
            r106.f236708y = r106.f236706x;
            r106.K = true;
            r106.I = true;
            r106.V = -1.0f;
            PointF r107 = r106.S;
            float r108 = r107.x;
            float r109 = r107.y;
            PointF r110 = new PointF();
            PointF r111 = r106.f236710z;
            if (r111 == null) goto L14;
            float r112 = r108 - r111.x;
            float r113 = r106.f236706x;
            r110.set(r112 / r113, (r109 - r111.y) / r113);
            r103 = r110;
        L14:
            r106.f236696p0 = r103;
            SubsamplingScaleImageView r114 = this.f236713b;
            r114.H0 = new PointF(r100.getX(), r100.getY());
            SubsamplingScaleImageView r115 = this.f236713b;
            PointF r116 = this.f236713b.f236696p0;
            r115.f236689k0 = new PointF(r116.x, r116.y);
            this.f236713b.W = false;
            return false;
        L16:
            PointF r117 = new PointF(r100.getX(), r100.getY());
            float r118 = r117.x;
            float r119 = r117.y;
            PointF r120 = new PointF();
            PointF r121 = r102.f236710z;
            if (r121 == null) goto L20;
            float r122 = r118 - r121.x;
            float r123 = r102.f236706x;
            r120.set(r122 / r123, (r119 - r121.y) / r123);
            r103 = r120;
        L20:
            SubsamplingScaleImageView.g(r102, r103, new PointF(r100.getX(), r100.getY()));
            return true;
        L23:
            return onDoubleTapEvent(r100);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r100) {
            this.f236713b.performClick();
            return true;
        }

        public b(SubsamplingScaleImageView r100, Context r101) {
            this.f236713b = r100;
            this.f236712a = r101;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            SubsamplingScaleImageView r104 = this.f236713b;
            if (r104.f236699r == false) goto L27;
            if (r104.P0 == false) goto L27;
            if (r104.f236710z == null) goto L27;
            if (r100 == null) goto L27;
            if (r101 == null) goto L27;
            if (Math.abs(r100.getX() - r101.getX()) > 50.0f) goto L15;
            if (Math.abs(r100.getY() - r101.getY()) <= 50.0f) goto L27;
        L15:
            if (Math.abs(r102) > 500.0f) goto L19;
            if (Math.abs(r103) <= 500.0f) goto L27;
        L19:
            if (this.f236713b.I == true) goto L27;
            PointF r105 = this.f236713b.f236710z;
            PointF r106 = new PointF(r105.x + (r102 * 0.25f), r105.y + (r103 * 0.25f));
            float r107 = (this.f236713b.getWidth() / 2) - r106.x;
            SubsamplingScaleImageView r108 = this.f236713b;
            float r109 = r107 / r108.f236706x;
            float r110 = (r108.getHeight() / 2) - r106.y;
            SubsamplingScaleImageView r111 = this.f236713b;
            e r112 = new e(r111, new PointF(r109, r110 / r111.f236706x));
            if (SubsamplingScaleImageView.f236669p2.contains(1) == false) goto L25;
            r112.f236731e = 1;
            r112.f236734h = false;
            r112.f236732f = 3;
            r112.a();
            return true;
        L25:
            throw new IllegalArgumentException("Unknown easing type: 1");
        L27:
            return super.onFling(r100, r101, r102, r103);
        }
    }

    public class c extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SubsamplingScaleImageView f236714a;

        public c(SubsamplingScaleImageView r100) {
            this.f236714a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r100) {
            this.f236714a.performClick();
            return true;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f236715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f236716b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public PointF f236717c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public PointF f236718d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public PointF f236719e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public PointF f236720f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public PointF f236721g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f236722h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f236723i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f236724j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f236725k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f236726l;

        public d() {
            this.f236722h = 500;
            this.f236723i = true;
            this.f236724j = 2;
            this.f236725k = 1;
            this.f236726l = System.currentTimeMillis();
        }

        public static /* synthetic */ void a(d r100) {
            r100.getClass();
        }

        public static /* synthetic */ PointF b(d r100) {
            return r100.f236720f;
        }

        public static /* synthetic */ long c(d r100) {
            return r100.f236726l;
        }

        public static /* synthetic */ long d(d r100) {
            return r100.f236722h;
        }

        public static /* synthetic */ int e(d r100) {
            return r100.f236724j;
        }

        public static /* synthetic */ float f(d r100) {
            return r100.f236715a;
        }

        public static /* synthetic */ float g(d r100) {
            return r100.f236716b;
        }

        public static /* synthetic */ PointF h(d r100) {
            return r100.f236721g;
        }

        public static /* synthetic */ PointF i(d r100) {
            return r100.f236718d;
        }

        public static /* synthetic */ int j(d r100) {
            return r100.f236725k;
        }

        public static /* synthetic */ PointF k(d r100) {
            return r100.f236717c;
        }

        public static /* synthetic */ PointF l(d r100) {
            return r100.f236719e;
        }
    }

    public final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f236727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PointF f236728b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PointF f236729c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f236730d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f236731e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f236732f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f236733g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f236734h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ SubsamplingScaleImageView f236735i;

        public final void a() {
            SubsamplingScaleImageView r100 = this.f236735i;
            d r101 = r100.L0;
            int r102 = r100.getPaddingLeft() + (((this.f236735i.getWidth() - this.f236735i.getPaddingRight()) - this.f236735i.getPaddingLeft()) / 2);
            int r103 = this.f236735i.getPaddingTop() + (((this.f236735i.getHeight() - this.f236735i.getPaddingBottom()) - this.f236735i.getPaddingTop()) / 2);
            float r104 = SubsamplingScaleImageView.o(this.f236735i, this.f236727a);
            if (this.f236734h == false) goto L5;
            SubsamplingScaleImageView r105 = this.f236735i;
            PointF r106 = this.f236728b;
            float r107 = r106.x;
            float r108 = r106.y;
            PointF r109 = new PointF();
            PointF r110 = r105.U(r107, r108, r104);
            r109.set(((r105.getPaddingLeft() + (((r105.getWidth() - r105.getPaddingRight()) - r105.getPaddingLeft()) / 2)) - r110.x) / r104, ((r105.getPaddingTop() + (((r105.getHeight() - r105.getPaddingBottom()) - r105.getPaddingTop()) / 2)) - r110.y) / r104);
        L6:
            this.f236735i.L0 = new d();
            SubsamplingScaleImageView r111 = this.f236735i;
            d r112 = r111.L0;
            r112.f236715a = r111.f236706x;
            r112.f236716b = r104;
            r112.f236726l = System.currentTimeMillis();
            SubsamplingScaleImageView r113 = this.f236735i;
            d r114 = r113.L0;
            r114.f236719e = r109;
            r114.f236717c = r113.getCenter();
            SubsamplingScaleImageView r115 = this.f236735i;
            d r116 = r115.L0;
            r116.f236718d = r109;
            r116.f236720f = r115.Q(r109);
            this.f236735i.L0.f236721g = new PointF(r102, r103);
            d r117 = this.f236735i.L0;
            r117.f236722h = this.f236730d;
            r117.f236723i = this.f236733g;
            r117.f236724j = this.f236731e;
            r117.f236725k = this.f236732f;
            r117.f236726l = System.currentTimeMillis();
            this.f236735i.L0.getClass();
            PointF r118 = this.f236729c;
            if (r118 == null) goto L9;
            float r119 = r118.x;
            PointF r120 = this.f236735i.L0.f236717c;
            float r121 = r119 - (r120.x * r104);
            float r122 = r118.y - (r120.y * r104);
            PointF r123 = new PointF(r121, r122);
            this.f236735i.z(true, new j(r104, r123));
            d r124 = this.f236735i.L0;
            PointF r125 = this.f236729c;
            r124.f236721g = new PointF(r125.x + (r123.x - r121), r125.y + (r123.y - r122));
        L9:
            this.f236735i.invalidate();
            return;
        L5:
            r109 = this.f236728b;
            goto L6
        }

        public e(SubsamplingScaleImageView r100, PointF r101) {
            this.f236735i = r100;
            this.f236730d = 500;
            this.f236731e = 2;
            this.f236732f = 1;
            this.f236733g = true;
            this.f236734h = true;
            this.f236727a = r100.f236706x;
            this.f236728b = r101;
            this.f236729c = null;
        }

        public e(SubsamplingScaleImageView r100, float r101, PointF r102) {
            this.f236735i = r100;
            this.f236730d = 500;
            this.f236731e = 2;
            this.f236732f = 1;
            this.f236733g = true;
            this.f236734h = true;
            this.f236727a = r101;
            this.f236728b = r102;
            this.f236729c = null;
        }

        public e(SubsamplingScaleImageView r100, float r101, PointF r102, PointF r103) {
            this.f236735i = r100;
            this.f236730d = 500;
            this.f236731e = 2;
            this.f236732f = 1;
            this.f236733g = true;
            this.f236734h = true;
            this.f236727a = r101;
            this.f236728b = r102;
            this.f236729c = r103;
        }
    }

    public static class f extends PthreadAsyncTask<Void, Void, Integer> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final WeakReference<SubsamplingScaleImageView> f236736h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final WeakReference<Context> f236737i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final WeakReference<DecoderFactory<? extends ImageDecoder>> f236738j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Uri f236739k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final boolean f236740l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Bitmap f236741m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Exception f236742n;

        @Override // android.os.AsyncTask
        public final Object doInBackground(Object[] r100) {
            Void[] r101 = (Void[]) r100;
            String r102 = this.f236739k.toString();     // Catch: OutOfMemoryError -> L9 Exception -> L11
            Context r103 = this.f236737i.get();     // Catch: OutOfMemoryError -> L9 Exception -> L11
            DecoderFactory<? extends ImageDecoder> r104 = this.f236738j.get();     // Catch: OutOfMemoryError -> L9 Exception -> L11
            SubsamplingScaleImageView r105 = this.f236736h.get();     // Catch: OutOfMemoryError -> L9 Exception -> L11
            if (r103 == null) goto L13;
            if (r104 == null) goto L13;
            if (r105 == null) goto L13;
            SubsamplingScaleImageView.j(r105, "BitmapLoadTask.doInBackground", new Object[0]);     // Catch: OutOfMemoryError -> L9 Exception -> L11
            this.f236741m = r104.make().decode(r103, this.f236739k);     // Catch: OutOfMemoryError -> L9 Exception -> L11
        L17:
            return Integer.valueOf(SubsamplingScaleImageView.k(r105, r103, r102));
        L13:
            return null;
        L11:
            e = move-exception;
            List<Integer> r106 = SubsamplingScaleImageView.f236667g2;
            tt5.a.e("SubsamplingScaleImageView", "Failed to load bitmap", e, false);
            this.f236742n = e;
        L9:
            e = move-exception;
            List<Integer> r107 = SubsamplingScaleImageView.f236667g2;
            tt5.a.e("SubsamplingScaleImageView", "Failed to load bitmap - OutOfMemoryError", e, false);
            this.f236742n = new RuntimeException(e);
            goto L13
        }

        @Override // android.os.AsyncTask
        public final void onPostExecute(Object r100) {
            Integer r101 = (Integer) r100;
            SubsamplingScaleImageView r102 = this.f236736h.get();
            if (r102 == null) goto L22;
            Bitmap r103 = this.f236741m;
            if (r103 == null) goto L11;
            if (r101 == null) goto L11;
            if (this.f236740l == false) goto L10;
            List<Integer> r104 = SubsamplingScaleImageView.f236667g2;
            r102.G(r103);
            return;
        L10:
            int r105 = r101.intValue();
            List<Integer> r106 = SubsamplingScaleImageView.f236667g2;
            r102.F(r103, r105);
            return;
        L11:
            Exception r107 = this.f236742n;
            if (r107 == null) goto L25;
            h r108 = r102.f236676b1;
            if (r108 != null) goto L16;
            return;
        L16:
            if (this.f236740l == true) goto L28;
            tt5.a.i("preview_image", "DriveSubsamplingScaleImageView onImageLoadError() error=", r107);
            com.bytedance.ee.bear.drive.view.preview.imageviewer.b r109 = ((r95.h.a) r108).f536720a.E2;
            if (r109 == null) goto L27;
            r109.b("subsampling_image", r107, false, true);
            return;
        L27:
            return;
        L28:
            return;
        L25:
            return;
        }

        public f(SubsamplingScaleImageView r100, Context r101, DecoderFactory r102, Uri r103) {
            this.f236736h = new WeakReference(r100);
            this.f236737i = new WeakReference(r101);
            this.f236738j = new WeakReference(r102);
            this.f236739k = r103;
            this.f236740l = false;
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f236743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PointF f236744b;

        public j(float r100, PointF r101) {
            this.f236743a = r100;
            this.f236744b = r101;
        }
    }

    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f236745a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f236746b;

        public k(boolean r100, boolean r101) {
            this.f236745a = r100;
            this.f236746b = r101;
        }
    }

    public static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Rect f236747a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f236748b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Bitmap f236749c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f236750d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f236751e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Rect f236752f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Rect f236753g;

        public l() {
        }

        public static /* synthetic */ boolean a(l r100) {
            return r100.f236751e;
        }

        public static /* synthetic */ boolean b(l r100) {
            return r100.f236750d;
        }

        public static /* synthetic */ Rect c(l r100) {
            return r100.f236747a;
        }

        public static /* synthetic */ Rect d(l r100) {
            return r100.f236752f;
        }

        public static /* synthetic */ int e(l r100) {
            return r100.f236748b;
        }

        public static /* synthetic */ Bitmap f(l r100) {
            return r100.f236749c;
        }
    }

    public static class m extends PthreadAsyncTask<Void, Void, Bitmap> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final WeakReference<SubsamplingScaleImageView> f236754h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final WeakReference<ImageRegionDecoder> f236755i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final WeakReference<l> f236756j;

        @Override // android.os.AsyncTask
        public final Object doInBackground(Object[] r100) {
            Void[] r101 = (Void[]) r100;
            SubsamplingScaleImageView r102 = this.f236754h.get();     // Catch: OutOfMemoryError -> L25 Exception -> L27
            ImageRegionDecoder r103 = this.f236755i.get();     // Catch: OutOfMemoryError -> L25 Exception -> L27
            l r104 = this.f236756j.get();     // Catch: OutOfMemoryError -> L25 Exception -> L27
            if (r103 == null) goto L22;
            if (r104 == null) goto L22;
            if (r102 == null) goto L22;
            if (r103.isReady() == false) goto L22;
            if (r104.f236751e == false) goto L22;
            SubsamplingScaleImageView.j(r102, "TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", new Object[]{r104.f236747a, Integer.valueOf(r104.f236748b)});     // Catch: OutOfMemoryError -> L25 Exception -> L27
            ((ReentrantReadWriteLock) r102.P).readLock().lock();     // Catch: OutOfMemoryError -> L25 Exception -> L27
        L19:
            th = move-exception;
            ((ReentrantReadWriteLock) r102.P).readLock().unlock();     // Catch: OutOfMemoryError -> L25 Exception -> L27
            throw th;     // Catch: OutOfMemoryError -> L25 Exception -> L27
        L13:
            if (r103.isReady() == false) goto L17;
            SubsamplingScaleImageView.m(r102, r104.f236747a, r104.f236753g);     // Catch: Throwable -> L19
            Bitmap r105 = r103.decodeRegion(r104.f236753g, r104.f236748b);     // Catch: Throwable -> L19
            ((ReentrantReadWriteLock) r102.P).readLock().unlock();     // Catch: OutOfMemoryError -> L25 Exception -> L27
            return r105;
        L17:
            r104.f236750d = false;     // Catch: Throwable -> L19
            ((ReentrantReadWriteLock) r102.P).readLock().unlock();     // Catch: OutOfMemoryError -> L25 Exception -> L27
        L29:
            return null;
        L22:
            if (r104 == null) goto L29;
            r104.f236750d = false;     // Catch: OutOfMemoryError -> L25 Exception -> L27
        L27:
            e = move-exception;
            List<Integer> r106 = SubsamplingScaleImageView.f236667g2;
            tt5.a.e("SubsamplingScaleImageView", "Failed to decode tile", e, false);
        L25:
            e = move-exception;
            List<Integer> r107 = SubsamplingScaleImageView.f236667g2;
            tt5.a.e("SubsamplingScaleImageView", "Failed to decode tile - OutOfMemoryError", e, false);
            new RuntimeException(e);
            goto L29
        }

        @Override // android.os.AsyncTask
        public final void onPostExecute(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            SubsamplingScaleImageView r102 = this.f236754h.get();
            l r103 = this.f236756j.get();
            if (r102 == null) goto L8;
            if (r103 == null) goto L9;
            if (r101 == null) goto L10;
            r103.f236749c = r101;
            r103.f236750d = false;
            SubsamplingScaleImageView.n(r102);
            return;
        L10:
            return;
        L9:
            return;
        }

        public m(SubsamplingScaleImageView r100, ImageRegionDecoder r101, l r102) {
            this.f236754h = new WeakReference(r100);
            this.f236755i = new WeakReference(r101);
            this.f236756j = new WeakReference(r102);
            r102.f236750d = true;
        }
    }

    public static class n extends PthreadAsyncTask<Void, Void, int[]> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final WeakReference<SubsamplingScaleImageView> f236757h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final WeakReference<Context> f236758i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final WeakReference<DecoderFactory<? extends ImageRegionDecoder>> f236759j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Uri f236760k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public ImageRegionDecoder f236761l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Exception f236762m;

        @Override // android.os.AsyncTask
        public final Object doInBackground(Object[] r100) {
            Void[] r101 = (Void[]) r100;
            String r102 = this.f236760k.toString();     // Catch: Exception -> L9
            Context r103 = this.f236758i.get();     // Catch: Exception -> L9
            DecoderFactory<? extends ImageRegionDecoder> r104 = this.f236759j.get();     // Catch: Exception -> L9
            SubsamplingScaleImageView r105 = this.f236757h.get();     // Catch: Exception -> L9
            if (r103 == null) goto L11;
            if (r104 == null) goto L11;
            if (r105 == null) goto L11;
            SubsamplingScaleImageView.j(r105, "TilesInitTask.doInBackground", new Object[0]);     // Catch: Exception -> L9
            ImageRegionDecoder r106 = r104.make();     // Catch: Exception -> L9
            this.f236761l = r106;     // Catch: Exception -> L9
            Point r107 = r106.init(r103, this.f236760k);     // Catch: Exception -> L9
            return new int[]{r107.x, r107.y, SubsamplingScaleImageView.k(r105, r103, r102)};
        L11:
            return null;
        L9:
            e = move-exception;
            List<Integer> r108 = SubsamplingScaleImageView.f236667g2;
            tt5.a.e("SubsamplingScaleImageView", "Failed to initialise bitmap decoder", e, false);
            this.f236762m = e;
            goto L11
        }

        @Override // android.os.AsyncTask
        public final void onPostExecute(Object r100) {
            int[] r101 = (int[]) r100;
            SubsamplingScaleImageView r102 = this.f236757h.get();
            if (r102 != null) goto L5;
            return;
        L5:
            if (this.f236761l == null) goto L10;
            if (r101 == null) goto L10;
            if (r101.length != 3) goto L10;
            SubsamplingScaleImageView.l(r102, this.f236761l, r101[0], r101[1], r101[2]);
            return;
        L10:
            Exception r103 = this.f236762m;
            if (r103 == null) goto L20;
            h r104 = r102.f236676b1;
            if (r104 == null) goto L21;
            tt5.a.i("preview_image", "DriveSubsamplingScaleImageView onImageLoadError() error=", r103);
            com.bytedance.ee.bear.drive.view.preview.imageviewer.b r105 = ((r95.h.a) r104).f536720a.E2;
            if (r105 == null) goto L22;
            r105.b("subsampling_image", r103, false, true);
            return;
        L22:
            return;
        L21:
            return;
        }

        public n(SubsamplingScaleImageView r100, Context r101, DecoderFactory<? extends ImageRegionDecoder> r102, Uri r103) {
            this.f236757h = new WeakReference(r100);
            this.f236758i = new WeakReference(r101);
            this.f236759j = new WeakReference(r102);
            this.f236760k = r103;
        }
    }

    public void setOnStateChangedListener(i r100) {
    }

    static {
        f236667g2 = Arrays.asList(new Integer[]{0, 90, 180, 270, -1});
        f236668h2 = Arrays.asList(new Integer[]{1, 2, 3});
        f236669p2 = Arrays.asList(new Integer[]{2, 1});
        f236670v2 = Arrays.asList(new Integer[]{1, 2, 3});
        f236671x2 = Arrays.asList(new Integer[]{2, 1, 3, 4});
    }

    private int getRequiredRotation() {
        int r100 = this.f236684h;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        return this.H;
    }

    public final boolean D() {
        boolean r100 = true;
        if (this.f236674a != null) goto L5;
    L7:
        Map<Integer, List<l>> r101 = this.f236681f;
        if (r101 == null) goto L23;
        Iterator<Map.Entry<Integer, List<l>>> r102 = r101.entrySet().iterator();
    L11:
        if (r102.hasNext() == false) goto L22;
        Map.Entry<Integer, List<l>> r103 = r102.next();
        if (r103.getKey().intValue() != this.f236680e) goto L11;
        Iterator<l> r104 = r103.getValue().iterator();
    L16:
        if (r104.hasNext() == false) goto L11;
        l r105 = r104.next();
        if (r105.f236750d == true) goto L21;
        if (r105.f236749c != null) goto L16;
    L21:
        r100 = false;
        goto L16
    L22:
        return r100;
    L23:
        return false;
    L5:
        if (this.f236675b == true) goto L7;
        return true;
    }

    public RectF getContentRect() {
        if (this.f236710z != null) goto L5;
        return null;
    L5:
        if (getSWidth() > 0) goto L7;
        return null;
    L7:
        if (getSHeight() <= 0) goto L14;
        float r100 = getScale();
        float r101 = getSWidth() * r100;
        float r102 = getSHeight() * r100;
        PointF r103 = this.f236710z;
        float r104 = r103.x;
        float r105 = r103.y;
        return new RectF(r104, r105, r101 + r104, r102 + r105);
    L14:
        return null;
    }

    public float getScaleFactor() {
        return 1.0f / getMinScale();
    }

    public final ImageViewState getState() {
        if (this.f236710z != null) goto L5;
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
        if (this.f236704v1 != null) goto L6;
        Paint r100 = new Paint();
        this.f236704v1 = r100;
        r100.setAntiAlias(true);
        this.f236704v1.setFilterBitmap(true);
        this.f236704v1.setDither(true);
    L6:
        if (this.f236707x1 == null) goto L10;
        if (this.f236709y1 == null) goto L10;
        return;
    L10:
        if (this.f236682g == false) goto L14;
        Paint r101 = new Paint();
        this.f236707x1 = r101;
        r101.setTextSize(I(12));
        this.f236707x1.setColor(FakePickerAvatarCreator.MAGENTA);
        this.f236707x1.setStyle(Paint.Style.FILL);
        Paint r102 = new Paint();
        this.f236709y1 = r102;
        r102.setColor(FakePickerAvatarCreator.MAGENTA);
        this.f236709y1.setStyle(Paint.Style.STROKE);
        this.f236709y1.setStrokeWidth(I(1));
        return;
    }

    private float E() {
        int r100 = getPaddingBottom() + getPaddingTop();
        int r101 = getPaddingLeft() + getPaddingRight();
        int r102 = this.f236692m;
        if (r102 == 2) goto L15;
        if (r102 == 4) goto L15;
        if (r102 != 3) goto L13;
        float r103 = this.f236687j;
        if (r103 <= 0.0f) goto L13;
        return r103;
    L13:
        return Math.min((getWidth() - r101) / M(), (getHeight() - r100) / L());
    L15:
        return Math.max((getWidth() - r101) / M(), (getHeight() - r100) / L());
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
        PointF r100 = this.D;
        Float r101 = this.C;
        if (r100 == null) goto L18;
        if (r101 == null) goto L18;
        this.f236706x = r101.floatValue();
        if (this.f236710z != null) goto L17;
        this.f236710z = new PointF();
    L17:
        this.f236710z.x = (getWidth() / 2) - (this.f236706x * r100.x);
        this.f236710z.y = (getHeight() / 2) - (this.f236706x * r100.y);
        this.D = null;
        this.C = null;
        y(true);
        J(true);
    L18:
        y(false);
        return;
    }

    private int L() {
        int r100 = getRequiredRotation();
        if (r100 == 90) goto L10;
        if (r100 == 270) goto L10;
        return this.G;
    L10:
        return this.F;
    }

    private int M() {
        int r100 = getRequiredRotation();
        if (r100 == 90) goto L10;
        if (r100 == 270) goto L10;
        return this.F;
    L10:
        return this.G;
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final PointF getCenter() {
        float r100 = getWidth() / 2;
        float r101 = getHeight() / 2;
        PointF r102 = new PointF();
        PointF r103 = this.f236710z;
        if (r103 != null) goto L5;
        return null;
    L5:
        float r104 = r100 - r103.x;
        float r105 = this.f236706x;
        r102.set(r104 / r105, (r101 - r103.y) / r105);
        return r102;
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
        boolean r100 = D();
        if (this.V0 == true) goto L14;
        if (r100 == false) goto L14;
        H();
        this.V0 = true;
        h r101 = this.f236676b1;
        if (r101 == null) goto L12;
        final r95.h.a r102 = (r95.h.a) r101;
        r102.getClass();
        tt5.a.h("preview_image", "DriveSubsamplingScaleImageView onImageLoaded()");
        com.bytedance.ee.bear.drive.view.preview.imageviewer.b r103 = r102.f536720a.E2;
        if (r103 == null) goto L10;
        r103.a("subsampling_image");
        r102.f536720a.E2.onCompleted();
    L10:
        r102.f536720a.post(new r95.g(r102));
    L12:
        if (this.f236685h1 == null) goto L14;
        q(this.f236710z);
        bm5.a r104 = this.f236685h1;
        r95.l r105 = (r95.l) r104;
        r105.a(this.V1);
    L14:
        return r100;
    }

    public final boolean s() {
        if (getWidth() > 0) goto L5;
    L15:
        boolean r100 = false;
    L17:
        if (this.P0 == true) goto L22;
        if (r100 == false) goto L22;
        H();
        this.P0 = true;
        h r101 = this.f236676b1;
        if (r101 == null) goto L22;
        r101.getClass();
    L22:
        return r100;
    L5:
        if (getHeight() <= 0) goto L15;
        if (this.F <= 0) goto L15;
        if (this.G <= 0) goto L15;
        if (this.f236674a == null) goto L13;
    L14:
        r100 = true;
        goto L17
    L13:
        if (D() == false) goto L15;
        goto L14
    }

    public static Bitmap.Config getPreferredBitmapConfig() {
        return f236672y2;
    }

    public float getMaxScale() {
        return this.f236686i;
    }

    public final int getOrientation() {
        return this.f236684h;
    }

    public final int getSHeight() {
        return this.G;
    }

    public final int getSWidth() {
        return this.F;
    }

    public final float getScale() {
        return this.f236706x;
    }

    public SubsamplingScaleImageView(Context r100) {
        this(r100, null);
    }

    private void J(boolean r110) {
        if (this.O != null) goto L5;
        return;
    L5:
        if (this.f236681f == null) goto L86;
        int r100 = Math.min(this.f236680e, p(this.f236706x));
        Iterator r101 = ((LinkedHashMap) this.f236681f).entrySet().iterator();
    L9:
        if (r101.hasNext() == false) goto L87;
        Iterator r102 = ((List) ((Map.Entry) r101.next()).getValue()).iterator();
    L12:
        if (r102.hasNext() == false) goto L9;
        l r103 = (l) r102.next();
        int r104 = r103.f236748b;
        if (r104 < r100) goto L18;
        if (r104 > r100) goto L17;
    L21:
        int r105 = r103.f236748b;
        if (r105 == r100) goto L23;
        if (r105 != this.f236680e) goto L12;
        r103.f236751e = true;
        goto L12
    L23:
        PointF r106 = this.f236710z;
        float r107 = Float.NaN;
        if (r106 != null) goto L26;
        float r108 = Float.NaN;
    L27:
        float r111 = getWidth();
        PointF r112 = this.f236710z;
        if (r112 != null) goto L30;
        float r113 = Float.NaN;
    L31:
        if (r112 != null) goto L33;
        float r109 = Float.NaN;
    L34:
        float r114 = getHeight();
        PointF r115 = this.f236710z;
        if (r115 == null) goto L38;
        r107 = (r114 - r115.y) / this.f236706x;
    L38:
        Rect r116 = r103.f236747a;
        if (r108 <= r116.right) goto L41;
    L47:
        boolean r117 = false;
    L48:
        if (r117 == true) goto L49;
        if (r103.f236748b == this.f236680e) goto L12;
        r103.f236751e = false;
        Bitmap r118 = r103.f236749c;
        if (r118 == null) goto L12;
        r118.recycle();
        r103.f236749c = null;
        goto L12
    L49:
        r103.f236751e = true;
        if (r103.f236750d == true) goto L12;
        if (r103.f236749c != null) goto L12;
        if (r110 == false) goto L12;
        new m(this, this.O, r103).executeOnExecutor(this.f236695p, new Void[0]);
        goto L12
    L41:
        if (r116.left > r113) goto L47;
        if (r109 > r116.bottom) goto L47;
        if (r116.top > r107) goto L47;
        r117 = true;
        goto L48
    L33:
        r109 = (0.0f - r112.y) / this.f236706x;
        goto L34
    L30:
        r113 = (r111 - r112.x) / this.f236706x;
        goto L31
    L26:
        r108 = (0.0f - r106.x) / this.f236706x;
        goto L27
    L17:
        if (r104 == this.f236680e) goto L21;
    L18:
        r103.f236751e = false;
        Bitmap r119 = r103.f236749c;
        if (r119 == null) goto L21;
        r119.recycle();
        r103.f236749c = null;
        goto L21
    L87:
        return;
    }

    private void K(boolean r100) {
        v("reset newImage=" + r100, new Object[0]);
        this.f236706x = 0.0f;
        this.f236708y = 0.0f;
        this.f236710z = null;
        this.A = null;
        this.B = null;
        this.C = Float.valueOf(0.0f);
        this.D = null;
        this.E = null;
        this.I = false;
        this.f236673J = false;
        this.K = false;
        this.L = 0;
        this.f236680e = 0;
        this.S = null;
        this.T = 0.0f;
        this.V = 0.0f;
        this.W = false;
        this.f236696p0 = null;
        this.f236689k0 = null;
        this.H0 = null;
        this.L0 = null;
        this.H1 = null;
        this.L1 = null;
        this.M1 = null;
        if (r100 == false) goto L23;
        this.f236679d = null;
        tt5.a.k("SubsamplingScaleImageView", ThreadMethodProxy.currentThread().getName() + ", try getLock:start");
        boolean r101 = ((ReentrantReadWriteLock) this.P).writeLock().tryLock();
        tt5.a.k("SubsamplingScaleImageView", ThreadMethodProxy.currentThread().getName() + ", getLock: success");
        if (r101 == true) goto L37;
        tt5.a.k("SubsamplingScaleImageView", ThreadMethodProxy.currentThread().getName() + ", getLock: Failed!");
    L14:
        Bitmap r102 = this.f236674a;
        if (r102 == null) goto L20;
        if (this.f236678c == true) goto L20;
        r102.recycle();
    L20:
        if (this.f236674a == null) goto L22;
        boolean r103 = this.f236678c;
    L22:
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.P0 = false;
        this.V0 = false;
        this.f236674a = null;
        this.f236675b = false;
        this.f236678c = false;
        goto L23
    L37:
        ImageRegionDecoder r104 = this.O;     // Catch: Throwable -> L10
        if (r104 == null) goto L9;
        r104.recycle();     // Catch: Throwable -> L10
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
        Map<Integer, List<l>> r105 = this.f236681f;
        if (r105 == null) goto L35;
        Iterator r106 = ((LinkedHashMap) r105).entrySet().iterator();
    L27:
        if (r106.hasNext() == false) goto L34;
        Iterator r107 = ((List) ((Map.Entry) r106.next()).getValue()).iterator();
    L30:
        if (r107.hasNext() == false) goto L27;
        l r108 = (l) r107.next();
        r108.f236751e = false;
        Bitmap r109 = r108.f236749c;
        if (r109 == null) goto L30;
        r109.recycle();
        r108.f236749c = null;
        goto L30
    L34:
        this.f236681f = null;
    L35:
        setGestureDetector(getContext());
    }

    public static DisplayMetrics b(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static /* synthetic */ void h(SubsamplingScaleImageView r100) {
        super.setOnLongClickListener(null);
    }

    public static void n(SubsamplingScaleImageView r100) {
        monitor-enter(r100);
        r100.v("onTileLoaded", new Object[0]);     // Catch: Throwable -> L14
        r100.s();     // Catch: Throwable -> L14
        r100.r();     // Catch: Throwable -> L14
        if (r100.D() == false) goto L11;
        Bitmap r101 = r100.f236674a;     // Catch: Throwable -> L14
        if (r101 == null) goto L11;
        if (r100.f236678c == true) goto L10;
        r101.recycle();     // Catch: Throwable -> L14
    L10:
        r100.f236674a = null;     // Catch: Throwable -> L14
        h r102 = r100.f236676b1;     // Catch: Throwable -> L14
        r100.f236675b = false;     // Catch: Throwable -> L14
        r100.f236678c = false;     // Catch: Throwable -> L14
    L11:
        r100.invalidate();     // Catch: Throwable -> L14
        monitor-exit(r100);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void setGestureDetector(Context r100) {
        this.M = new GestureDetector(r100, new b(this, r100));
        this.N = new GestureDetector(r100, new c(this));
    }

    public static void setPreferredBitmapConfig(Bitmap.Config r100) {
        f236672y2 = r100;
    }

    public static int t(ExifInterface r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH));
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r104 = r103;
        int r105 = r104.length;
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L15;
        f06.a r107 = r104[r106];
        int r111 = r106;
        int r112 = r105;
        f06.a[] r113 = r104;
        f06.d r108 = r107.preInvoke(SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH, "android/media/ExifInterface", "getAttributeInt", r210, r101, "int", r110);     // Catch: Exception -> L22
        if (r108.f474982a == true) goto L17;
        r100.add(r107);     // Catch: Exception -> L22
    L17:
        if (r108.f474982a == false) goto L21;
        return ((Integer) r108.f474983b).intValue();
    L21:
        return r210.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
    L14:
        r106 = r111 + 1;
        r105 = r112;
        r104 = r113;
        goto L8
    L15:
        r108 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    private void y(boolean r100) {
        if (this.f236710z != null) goto L5;
        this.f236710z = new PointF(0.0f, 0.0f);
        boolean r101 = true;
    L7:
        if (this.H1 != null) goto L9;
        this.H1 = new j(0.0f, new PointF(0.0f, 0.0f));
    L9:
        j r102 = this.H1;
        r102.f236743a = this.f236706x;
        r102.f236744b.set(this.f236710z);
        z(r100, this.H1);
        j r103 = this.H1;
        this.f236706x = r103.f236743a;
        this.f236710z.set(r103.f236744b);
        if (r101 == true) goto L12;
        return;
    L12:
        if (this.f236692m == 4) goto L16;
        this.f236710z.set(U(M() / 2, L() / 2, this.f236706x));
        return;
    L16:
        return;
    L5:
        r101 = false;
        goto L7
    }

    public final Point A(Canvas r100) {
        return new Point(Math.min(r100.getMaximumBitmapWidth(), this.f236693n), Math.min(r100.getMaximumBitmapHeight(), this.f236694o));
    }

    public final synchronized void B(Point r100) {
        monitor-enter(this);
        v("initialiseBaseLayer maxTileDimensions=%dx%d", new Object[]{Integer.valueOf(r100.x), Integer.valueOf(r100.y)});     // Catch: Throwable -> L34
        k r101 = this.f236677b2;     // Catch: Throwable -> L34
        if (r101 != null) goto L6;
    L8:
        this.f236680e = p(this.f236687j);     // Catch: Throwable -> L34
    L9:
        k r102 = this.f236677b2;     // Catch: Throwable -> L34
        if (r102 != null) goto L12;
    L16:
        int r103 = this.f236680e;     // Catch: Throwable -> L34
        if (r103 <= 8) goto L19;
        this.f236680e = r103 / 8;     // Catch: Throwable -> L34
    L21:
        if (this.f236680e == 1) goto L23;
    L27:
        C(r100);     // Catch: Throwable -> L34
        Iterator r104 = ((List) ((LinkedHashMap) this.f236681f).get(Integer.valueOf(this.f236680e))).iterator();     // Catch: Throwable -> L34
    L29:
        if (r104.hasNext() == false) goto L31;
        new m(this, this.O, (l) r104.next()).executeOnExecutor(this.f236695p, new Void[0]);     // Catch: Throwable -> L34
        goto L29
    L31:
        J(true);     // Catch: Throwable -> L34
    L32:
        monitor-exit(this);
        return;
    L23:
        if (M() >= r100.x) goto L27;
        if (L() >= r100.y) goto L27;
        this.O.recycle();     // Catch: Throwable -> L34
        this.O = null;     // Catch: Throwable -> L34
        new f(this, getContext(), this.Q, this.f236679d).executeOnExecutor(this.f236695p, new Void[0]);     // Catch: Throwable -> L34
        goto L32
    L19:
        this.f236680e = 1;     // Catch: Throwable -> L34
        goto L21
    L12:
        if (r102.f236745a == false) goto L16;
        int r105 = this.f236680e;     // Catch: Throwable -> L34
        if (r105 <= 1) goto L21;
        this.f236680e = r105 / 2;     // Catch: Throwable -> L34
        goto L21
    L6:
        if (r101.f236746b == false) goto L8;
        j r106 = new j(0.0f, new PointF(0.0f, 0.0f));     // Catch: Throwable -> L34
        this.H1 = r106;     // Catch: Throwable -> L34
        z(true, r106);     // Catch: Throwable -> L34
        this.f236680e = p(this.H1.f236743a);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }

    public final void C(Point r110) {
        int r100 = 1;
        v("initialiseTileMap maxTileDimensions=%dx%d", new Object[]{Integer.valueOf(r110.x), Integer.valueOf(r110.y)});
        this.f236681f = new LinkedHashMap();
        int r101 = this.f236680e;
        int r102 = 1;
        int r103 = 1;
    L3:
        int r104 = M() / r102;
        int r105 = L() / r103;
        int r106 = r104 / r101;
        int r111 = r105 / r101;
    L5:
        if (((r106 + r102) + r100) > r110.x) goto L41;
        if (r106 <= (((double) getWidth()) * 1.25d)) goto L12;
        if (r101 < this.f236680e) goto L41;
    L12:
        if (((r111 + r103) + r100) > r110.y) goto L40;
        if (r111 <= (((double) getHeight()) * 1.25d)) goto L18;
        if (r101 < this.f236680e) goto L40;
    L18:
        ArrayList r107 = new ArrayList(r102 * r103);
        int r112 = 0;
    L19:
        if (r112 >= r102) goto L36;
        int r113 = 0;
    L21:
        if (r113 >= r103) goto L35;
        l r114 = new l();
        r114.f236748b = r101;
        if (r101 != this.f236680e) goto L25;
        boolean r115 = true;
    L26:
        r114.f236751e = r115;
        int r116 = r112 * r104;
        int r117 = r113 * r105;
        if (r112 != (r102 - 1)) goto L29;
        int r108 = M();
    L31:
        if (r113 != (r103 - 1)) goto L33;
        int r109 = L();
    L34:
        r114.f236747a = new Rect(r116, r117, r108, r109);
        r114.f236752f = new Rect(0, 0, 0, 0);
        r114.f236753g = new Rect(r114.f236747a);
        r107.add(r114);
        r113 = r113 + 1;
        goto L21
    L33:
        r109 = (r113 + 1) * r105;
        goto L34
    L29:
        r108 = (r112 + 1) * r104;
        goto L31
    L25:
        r115 = false;
        goto L26
    L35:
        r112 = r112 + 1;
        goto L19
    L36:
        this.f236681f.put(Integer.valueOf(r101), r107);
        if (r101 == 1) goto L38;
        r101 = r101 / 2;
        r100 = 1;
        goto L3
    L38:
        return;
    L40:
        r103 = r103 + 1;
        r105 = L() / r103;
        r111 = r105 / r101;
        r100 = 1;
    L41:
        r102 = r102 + 1;
        r104 = M() / r102;
        r106 = r104 / r101;
        r100 = 1;
        goto L5
    }

    public final synchronized void G(Bitmap r100) {
        monitor-enter(this);
        v("onPreviewLoaded", new Object[0]);     // Catch: Throwable -> L16
        if (this.f236674a == null) goto L6;
    L13:
        r100.recycle();     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L6:
        if (this.V0 == true) goto L13;
        this.f236674a = r100;     // Catch: Throwable -> L16
        this.f236675b = true;     // Catch: Throwable -> L16
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

    public final int I(int r100) {
        return (int) (this.S1 * r100);
    }

    public final PointF Q(PointF r100) {
        float r101 = r100.x;
        float r102 = r100.y;
        PointF r103 = new PointF();
        if (this.f236710z != null) goto L5;
        return null;
    L5:
        r103.set(S(r101), T(r102));
        return r103;
    }

    public final float S(float r100) {
        PointF r101 = this.f236710z;
        if (r101 != null) goto L7;
        return Float.NaN;
    L7:
        return (r100 * this.f236706x) + r101.x;
    }

    public final float T(float r100) {
        PointF r101 = this.f236710z;
        if (r101 != null) goto L7;
        return Float.NaN;
    L7:
        return (r100 * this.f236706x) + r101.y;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r310) {
        super.onDraw(r310);     // Catch: Exception -> L161
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
        if (this.f236681f != null) goto L18;
        if (this.O == null) goto L18;
        B(A(r310));     // Catch: Exception -> L161
    L18:
        if (s() == true) goto L20;
        return;
    L20:
        H();     // Catch: Exception -> L161
        d r100 = this.L0;     // Catch: Exception -> L161
        if (r100 == null) goto L43;
        if (d.b(r100) == null) goto L43;
        float r101 = this.f236706x;     // Catch: Exception -> L161
        if (this.B != null) goto L27;
        this.B = new PointF(0.0f, 0.0f);     // Catch: Exception -> L161
    L27:
        this.B.set(this.f236710z);     // Catch: Exception -> L161
        long r110 = System.currentTimeMillis() - d.c(this.L0);     // Catch: Exception -> L161
        if (r110 <= d.d(this.L0)) goto L30;
        boolean r111 = true;
    L31:
        long r112 = Math.min(r110, d.d(this.L0));     // Catch: Exception -> L161
        this.f236706x = x(d.e(this.L0), r112, d.f(this.L0), d.g(this.L0) - d.f(this.L0), d.d(this.L0));     // Catch: Exception -> L161
        float r102 = x(d.e(this.L0), r112, d.b(this.L0).x, d.h(this.L0).x - d.b(this.L0).x, d.d(this.L0));     // Catch: Exception -> L161
        float r103 = x(d.e(this.L0), r112, d.b(this.L0).y, d.h(this.L0).y - d.b(this.L0).y, d.d(this.L0));     // Catch: Exception -> L161
        this.f236710z.x -= S(d.i(this.L0).x) - r102;     // Catch: Exception -> L161
        this.f236710z.y -= T(d.i(this.L0).y) - r103;     // Catch: Exception -> L161
        if (r111 == false) goto L34;
    L37:
        boolean r104 = true;
    L38:
        y(r104);     // Catch: Exception -> L161
        PointF r105 = this.B;     // Catch: Exception -> L161
        d.j(this.L0);     // Catch: Exception -> L161
        N(r101, r105);     // Catch: Exception -> L161
        J(r111);     // Catch: Exception -> L161
        if (r111 == false) goto L41;
        d.a(this.L0);     // Catch: Exception -> L161
        this.L0 = null;     // Catch: Exception -> L161
    L41:
        invalidate();     // Catch: Exception -> L161
        goto L43
    L34:
        if (d.f(this.L0) == d.g(this.L0)) goto L37;
        r104 = false;
        goto L38
    L30:
        r111 = false;
    L43:
        if (this.f236681f != null) goto L45;
    L109:
        Bitmap r106 = this.f236674a;     // Catch: Exception -> L161
        if (r106 == null) goto L143;
        float r107 = this.f236706x;     // Catch: Exception -> L161
        if (this.f236675b == false) goto L114;
        float r108 = r107 * (this.F / r106.getWidth());     // Catch: Exception -> L161
        r107 = this.f236706x * (this.G / this.f236674a.getHeight());     // Catch: Exception -> L161
        float r109 = r108;
    L116:
        if (this.L1 != null) goto L118;
        this.L1 = new Matrix();     // Catch: Exception -> L161
    L118:
        this.L1.reset();     // Catch: Exception -> L161
        this.L1.postScale(r109, r107);     // Catch: Exception -> L161
        this.L1.postRotate(getRequiredRotation());     // Catch: Exception -> L161
        Matrix r113 = this.L1;     // Catch: Exception -> L161
        PointF r114 = this.f236710z;     // Catch: Exception -> L161
        r113.postTranslate(r114.x, r114.y);     // Catch: Exception -> L161
        if (getRequiredRotation() != 180) goto L122;
        Matrix r115 = this.L1;     // Catch: Exception -> L161
        float r116 = this.f236706x;     // Catch: Exception -> L161
        r115.postTranslate(this.F * r116, r116 * this.G);     // Catch: Exception -> L161
    L128:
        if (this.G1 != null) goto L130;
    L141:
        r310.drawBitmap(this.f236674a, this.L1, this.f236704v1);     // Catch: Exception -> L161
        goto L143
    L130:
        if (this.M1 != null) goto L132;
        this.M1 = new RectF();     // Catch: Exception -> L161
    L132:
        RectF r117 = this.M1;     // Catch: Exception -> L161
        if (this.f236675b == false) goto L135;
        int r118 = this.f236674a.getWidth();     // Catch: Exception -> L161
    L136:
        float r119 = r118;
        if (this.f236675b == false) goto L139;
        int r120 = this.f236674a.getHeight();     // Catch: Exception -> L161
    L140:
        r117.set(0.0f, 0.0f, r119, r120);     // Catch: Exception -> L161
        this.L1.mapRect(this.M1);     // Catch: Exception -> L161
        r310.drawRect(this.M1, this.G1);     // Catch: Exception -> L161
        goto L141
    L139:
        r120 = this.G;     // Catch: Exception -> L161
        goto L140
    L135:
        r118 = this.F;     // Catch: Exception -> L161
        goto L136
    L122:
        if (getRequiredRotation() != 90) goto L125;
        this.L1.postTranslate(this.f236706x * this.G, 0.0f);     // Catch: Exception -> L161
        goto L128
    L125:
        if (getRequiredRotation() != 270) goto L128;
        this.L1.postTranslate(0.0f, this.f236706x * this.F);     // Catch: Exception -> L161
        goto L128
    L114:
        r109 = r107;
    L143:
        if (this.f236682g == false) goto L186;
        StringBuilder r121 = new StringBuilder();     // Catch: Exception -> L161
        r121.append("Scale: ");     // Catch: Exception -> L161
        Locale r122 = Locale.ENGLISH;     // Catch: Exception -> L161
        r121.append(String.format(r122, "%.2f", new Object[]{Float.valueOf(this.f236706x)}));     // Catch: Exception -> L161
        r121.append(" (");     // Catch: Exception -> L161
        r121.append(String.format(r122, "%.2f", new Object[]{Float.valueOf(E())}));     // Catch: Exception -> L161
        r121.append(" - ");     // Catch: Exception -> L161
        r121.append(String.format(r122, "%.2f", new Object[]{Float.valueOf(this.f236686i)}));     // Catch: Exception -> L161
        r121.append(")");     // Catch: Exception -> L161
        r310.drawText(r121.toString(), I(5), I(15), this.f236707x1);     // Catch: Exception -> L161
        r310.drawText("Translate: " + String.format(r122, "%.2f", new Object[]{Float.valueOf(this.f236710z.x)}) + ":" + String.format(r122, "%.2f", new Object[]{Float.valueOf(this.f236710z.y)}), I(5), I(30), this.f236707x1);     // Catch: Exception -> L161
        PointF r123 = getCenter();     // Catch: Exception -> L161
        r310.drawText("Source center: " + String.format(r122, "%.2f", new Object[]{Float.valueOf(r123.x)}) + ":" + String.format(r122, "%.2f", new Object[]{Float.valueOf(r123.y)}), I(5), I(45), this.f236707x1);     // Catch: Exception -> L161
        d r124 = this.L0;     // Catch: Exception -> L161
        if (r124 == null) goto L148;
        PointF r125 = Q(d.k(r124));     // Catch: Exception -> L161
        PointF r126 = Q(d.l(this.L0));     // Catch: Exception -> L161
        PointF r127 = Q(d.i(this.L0));     // Catch: Exception -> L161
        r310.drawCircle(r125.x, r125.y, I(10), this.f236709y1);     // Catch: Exception -> L161
        this.f236709y1.setColor(-65536);     // Catch: Exception -> L161
        r310.drawCircle(r126.x, r126.y, I(20), this.f236709y1);     // Catch: Exception -> L161
        this.f236709y1.setColor(FakePickerAvatarCreator.BLUE);     // Catch: Exception -> L161
        r310.drawCircle(r127.x, r127.y, I(25), this.f236709y1);     // Catch: Exception -> L161
        this.f236709y1.setColor(FakePickerAvatarCreator.CYAN);     // Catch: Exception -> L161
        r310.drawCircle(getWidth() / 2, getHeight() / 2, I(30), this.f236709y1);     // Catch: Exception -> L161
    L148:
        if (this.S == null) goto L151;
        this.f236709y1.setColor(-65536);     // Catch: Exception -> L161
        PointF r128 = this.S;     // Catch: Exception -> L161
        r310.drawCircle(r128.x, r128.y, I(20), this.f236709y1);     // Catch: Exception -> L161
    L151:
        if (this.f236696p0 == null) goto L154;
        this.f236709y1.setColor(FakePickerAvatarCreator.BLUE);     // Catch: Exception -> L161
        r310.drawCircle(S(this.f236696p0.x), T(this.f236696p0.y), I(35), this.f236709y1);     // Catch: Exception -> L161
    L154:
        if (this.H0 != null) goto L156;
    L158:
        this.f236709y1.setColor(FakePickerAvatarCreator.MAGENTA);     // Catch: Exception -> L161
        return;
    L156:
        if (this.K == false) goto L158;
        this.f236709y1.setColor(FakePickerAvatarCreator.CYAN);     // Catch: Exception -> L161
        PointF r129 = this.H0;     // Catch: Exception -> L161
        r310.drawCircle(r129.x, r129.y, I(30), this.f236709y1);     // Catch: Exception -> L161
        goto L158
    L186:
        return;
    L45:
        if (D() == false) goto L109;
        int r130 = Math.min(this.f236680e, p(this.f236706x));     // Catch: Exception -> L161
        Iterator r131 = ((LinkedHashMap) this.f236681f).entrySet().iterator();     // Catch: Exception -> L161
        boolean r132 = false;
    L48:
        if (r131.hasNext() == false) goto L61;
        Map.Entry r133 = (Map.Entry) r131.next();     // Catch: Exception -> L161
        if (((Integer) r133.getKey()).intValue() != r130) goto L48;
        Iterator r134 = ((List) r133.getValue()).iterator();     // Catch: Exception -> L161
    L53:
        if (r134.hasNext() == false) goto L48;
        l r135 = (l) r134.next();     // Catch: Exception -> L161
        if (l.a(r135) == false) goto L53;
        if (l.b(r135) == true) goto L60;
        if (l.f(r135) != null) goto L53;
    L60:
        r132 = true;
        goto L53
    L61:
        Iterator r136 = ((LinkedHashMap) this.f236681f).entrySet().iterator();     // Catch: Exception -> L161
    L63:
        if (r136.hasNext() == false) goto L143;
        Map.Entry r137 = (Map.Entry) r136.next();     // Catch: Exception -> L161
        if (((Integer) r137.getKey()).intValue() == r130) goto L69;
        if (r132 == true) goto L69;
    L108:
        r130 = r130;
        r136 = r136;
        r132 = r132;
    L69:
        Iterator r138 = ((List) r137.getValue()).iterator();     // Catch: Exception -> L161
    L71:
        if (r138.hasNext() == false) goto L108;
        l r139 = (l) r138.next();     // Catch: Exception -> L161
        R(l.c(r139), l.d(r139));     // Catch: Exception -> L161
        if (l.b(r139) == false) goto L75;
    L97:
        int r140 = r130;
        Iterator r311 = r136;
        Iterator r312 = r138;
        boolean r313 = r132;
        if (l.b(r139) == true) goto L100;
    L103:
        if (l.a(r139) == false) goto L107;
        if (this.f236682g == false) goto L107;
        r310.drawText("ISS " + l.e(r139) + " RECT " + l.c(r139).top + "," + l.c(r139).left + "," + l.c(r139).bottom + "," + l.c(r139).right, l.d(r139).left + I(5), l.d(r139).top + I(15), this.f236707x1);     // Catch: Exception -> L161
    L107:
        r130 = r140;
        r136 = r311;
        r138 = r312;
        r132 = r313;
        goto L71
    L100:
        if (this.f236682g == false) goto L103;
        r310.drawText("LOADING", l.d(r139).left + I(5), l.d(r139).top + I(35), this.f236707x1);     // Catch: Exception -> L161
        goto L103
    L75:
        if (l.f(r139) == null) goto L97;
        if (this.G1 == null) goto L80;
        r310.drawRect(l.d(r139), this.G1);     // Catch: Exception -> L161
    L80:
        if (this.L1 != null) goto L82;
        this.L1 = new Matrix();     // Catch: Exception -> L161
    L82:
        this.L1.reset();     // Catch: Exception -> L161
        P(this.P1, 0.0f, 0.0f, l.f(r139).getWidth(), 0.0f, l.f(r139).getWidth(), l.f(r139).getHeight(), 0.0f, l.f(r139).getHeight());     // Catch: Exception -> L161
        if (getRequiredRotation() != 0) goto L85;
        r140 = r130;
        r311 = r136;
        r312 = r138;
        r313 = r132;
        P(this.Q1, l.d(r139).left, l.d(r139).top, l.d(r139).right, l.d(r139).top, l.d(r139).right, l.d(r139).bottom, l.d(r139).left, l.d(r139).bottom);     // Catch: Exception -> L161
    L94:
        this.L1.setPolyToPoly(this.P1, 0, this.Q1, 0, 4);     // Catch: Exception -> L161
        r310.drawBitmap(l.f(r139), this.L1, this.f236704v1);     // Catch: Exception -> L161
        if (this.f236682g == false) goto L103;
        r310.drawRect(l.d(r139), this.f236709y1);     // Catch: Exception -> L161
        goto L103
    L85:
        r140 = r130;
        r311 = r136;
        r312 = r138;
        r313 = r132;
        if (getRequiredRotation() != 90) goto L89;
        P(this.Q1, l.d(r139).right, l.d(r139).top, l.d(r139).right, l.d(r139).bottom, l.d(r139).left, l.d(r139).bottom, l.d(r139).left, l.d(r139).top);     // Catch: Exception -> L161
        goto L94
    L89:
        if (getRequiredRotation() != 180) goto L92;
        P(this.Q1, l.d(r139).right, l.d(r139).bottom, l.d(r139).left, l.d(r139).bottom, l.d(r139).left, l.d(r139).top, l.d(r139).right, l.d(r139).top);     // Catch: Exception -> L161
        goto L94
    L92:
        if (getRequiredRotation() != 270) goto L94;
        P(this.Q1, l.d(r139).left, l.d(r139).bottom, l.d(r139).left, l.d(r139).top, l.d(r139).right, l.d(r139).top, l.d(r139).right, l.d(r139).bottom);     // Catch: Exception -> L161
    L161:
        e = move-exception;
        tt5.a.d("SubsamplingScaleImageView", e.getMessage());
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        d r100 = this.L0;
        if (r100 != null) goto L5;
    L10:
        this.L0 = null;
        if (this.f236710z != null) goto L17;
        GestureDetector r101 = this.N;
        if (r101 == null) goto L15;
        r101.onTouchEvent(r110);
    L15:
        return true;
    L17:
        if (this.K == true) goto L24;
        GestureDetector r102 = this.M;
        if (r102 != null) goto L21;
    L22:
        this.I = false;
        this.f236673J = false;
        this.L = 0;
        return true;
    L21:
        if (r102.onTouchEvent(r110) == true) goto L22;
    L24:
        float r103 = 0.0f;
        if (this.A != null) goto L28;
        this.A = new PointF(0.0f, 0.0f);
    L28:
        if (this.B != null) goto L31;
        this.B = new PointF(0.0f, 0.0f);
    L31:
        if (this.S != null) goto L33;
        this.S = new PointF(0.0f, 0.0f);
    L33:
        float r104 = this.f236706x;
        PointF r105 = this.f236710z;
        if (r105 == null) goto L229;
        this.B.set(r105);
        int r106 = r110.getPointerCount();
        int r107 = r110.getAction();
        if (r107 == 0) goto L207;
        if (r107 == 1) goto L174;
        if (r107 == 2) goto L49;
        if (r107 != 5) goto L42;
    L208:
        this.L0 = null;
        ViewParent r108 = getParent();
        if (r108 == null) goto L211;
        r108.requestDisallowInterceptTouchEvent(true);
    L211:
        this.L = Math.max(this.L, r106);
        if (r106 < 2) goto L219;
        if (this.f236700s == false) goto L216;
        float r109 = r110.getX(0) - r110.getX(1);
        float r111 = r110.getY(0) - r110.getY(1);
        float r112 = (float) Math.sqrt((r109 * r109) + (r111 * r111));
        this.f236708y = this.f236706x;
        this.T = r112;
        PointF r113 = this.A;
        PointF r114 = this.f236710z;
        r113.set(r114.x, r114.y);
        this.S.set((r110.getX(0) + r110.getX(1)) / 2.0f, (r110.getY(0) + r110.getY(1)) / 2.0f);
    L217:
        this.f236697p1.removeMessages(1);
    L221:
        boolean r115 = true;
    L222:
        N(r104, this.B);
        if (r115 == false) goto L225;
        return true;
    L225:
        if (super.onTouchEvent(r110) == true) goto L231;
        return false;
    L231:
        return true;
    L216:
        this.L = 0;
        goto L217
    L219:
        if (this.K == true) goto L221;
        PointF r116 = this.A;
        PointF r117 = this.f236710z;
        r116.set(r117.x, r117.y);
        this.S.set(r110.getX(), r110.getY());
        this.f236697p1.sendEmptyMessageDelayed(1, 600);
        goto L221
    L42:
        if (r107 != 6) goto L44;
    L182:
        this.f236697p1.removeMessages(1);
        if (this.K == false) goto L188;
        this.K = false;
        if (this.W == true) goto L188;
        w(this.f236696p0, this.S);
    L188:
        if (this.L <= 0) goto L205;
        boolean r118 = this.I;
        if (r118 == false) goto L192;
    L193:
        if (r118 == false) goto L200;
        if (r106 != 2) goto L200;
        this.f236673J = true;
        PointF r119 = this.A;
        PointF r120 = this.f236710z;
        r119.set(r120.x, r120.y);
        if (r110.getActionIndex() != 1) goto L198;
        this.S.set(r110.getX(0), r110.getY(0));
        goto L200
    L198:
        this.S.set(r110.getX(1), r110.getY(1));
    L200:
        if (r106 >= 3) goto L202;
        this.I = false;
    L202:
        if (r106 >= 2) goto L204;
        this.f236673J = false;
        this.L = 0;
    L204:
        J(true);
        goto L221
    L192:
        if (this.f236673J == true) goto L193;
    L205:
        if (r106 != 1) goto L221;
        this.I = false;
        this.f236673J = false;
        this.L = 0;
        goto L221
    L44:
        if (r107 == 261) goto L208;
        if (r107 == 262) goto L182;
    L173:
        r115 = false;
        goto L222
    L49:
        if (this.L > 0) goto L51;
    L170:
        boolean r121 = false;
    L171:
        if (r121 == false) goto L173;
        this.f236697p1.removeMessages(1);
        invalidate();
        goto L221
    L51:
        if (r106 < 2) goto L80;
        float r122 = r110.getX(0) - r110.getX(1);
        float r123 = r110.getY(0) - r110.getY(1);
        float r124 = (float) Math.sqrt((r122 * r122) + (r123 * r123));
        float r125 = (r110.getX(0) + r110.getX(1)) / 2.0f;
        float r126 = (r110.getY(0) + r110.getY(1)) / 2.0f;
        if (this.f236700s == false) goto L170;
        PointF r127 = this.S;
        float r128 = r127.x - r125;
        float r129 = r127.y - r126;
        if (((float) Math.sqrt((r128 * r128) + (r129 * r129))) <= 5.0f) goto L57;
    L60:
        this.I = true;
        this.f236673J = true;
        double r130 = this.f236706x;
        float r131 = Math.min(this.f236686i, (r124 / this.T) * this.f236708y);
        this.f236706x = r131;
        if (r131 > E()) goto L64;
        this.T = r124;
        this.f236708y = E();
        this.S.set(r125, r126);
        this.A.set(this.f236710z);
    L78:
        y(true);
        J(this.f236698q);
    L169:
        r121 = true;
        goto L171
    L64:
        if (this.f236699r == false) goto L75;
        PointF r132 = this.S;
        float r133 = r132.x;
        PointF r134 = this.A;
        float r135 = r133 - r134.x;
        float r136 = r132.y - r134.y;
        float r137 = this.f236706x / this.f236708y;
        float r138 = r135 * r137;
        float r139 = r136 * r137;
        PointF r140 = this.f236710z;
        r140.x = r125 - r138;
        r140.y = r126 - r139;
        if ((((double) L()) * r130) >= getHeight()) goto L70;
        if ((this.f236706x * L()) < getHeight()) goto L70;
    L73:
        y(true);
        this.S.set(r125, r126);
        this.A.set(this.f236710z);
        this.f236708y = this.f236706x;
        this.T = r124;
    L70:
        if ((r130 * ((double) M())) >= getWidth()) goto L78;
        if ((this.f236706x * M()) < getWidth()) goto L78;
    L75:
        if (this.E == null) goto L77;
        this.f236710z.x = (getWidth() / 2) - (this.f236706x * this.E.x);
        this.f236710z.y = (getHeight() / 2) - (this.f236706x * this.E.y);
        goto L78
    L77:
        this.f236710z.x = (getWidth() / 2) - (this.f236706x * (M() / 2));
        this.f236710z.y = (getHeight() / 2) - (this.f236706x * (L() / 2));
        goto L78
    L57:
        if (Math.abs(r124 - this.T) > 5.0f) goto L60;
        if (this.f236673J == false) goto L170;
    L80:
        if (this.K == false) goto L115;
        float r141 = (Math.abs(this.H0.y - r110.getY()) * 2.0f) + this.U;
        if (this.V != (-1.0f)) goto L84;
        this.V = r141;
    L84:
        float r142 = r110.getY();
        PointF r143 = this.f236689k0;
        if (r142 <= r143.y) goto L87;
        boolean r144 = true;
    L88:
        r143.set(0.0f, r110.getY());
        float r145 = 1.0f;
        float r146 = Math.abs(1.0f - (r141 / this.V)) * 0.5f;
        if (r146 <= 0.03f) goto L91;
    L92:
        this.W = true;
        if (this.V <= 0.0f) goto L97;
        if (r144 == false) goto L96;
        r145 = 1.0f + r146;
        goto L97
    L96:
        r145 = 1.0f - r146;
    L97:
        double r147 = this.f236706x;
        float r148 = Math.max(E(), Math.min(this.f236686i, this.f236706x * r145));
        this.f236706x = r148;
        if (this.f236699r == false) goto L109;
        PointF r149 = this.S;
        float r150 = r149.x;
        PointF r151 = this.A;
        float r152 = r150 - r151.x;
        float r153 = r149.y;
        float r154 = r153 - r151.y;
        float r155 = r148 / this.f236708y;
        float r156 = r152 * r155;
        float r157 = r154 * r155;
        PointF r158 = this.f236710z;
        r158.x = r150 - r156;
        r158.y = r153 - r157;
        if ((((double) L()) * r147) >= getHeight()) goto L104;
        if ((this.f236706x * L()) < getHeight()) goto L104;
    L107:
        y(true);
        this.S.set(Q(this.f236696p0));
        this.A.set(this.f236710z);
        this.f236708y = this.f236706x;
    L113:
        this.V = r103;
        y(true);
        J(this.f236698q);
    L104:
        if ((r147 * ((double) M())) < getWidth()) goto L106;
    L112:
        r103 = r141;
        goto L113
    L106:
        if ((this.f236706x * M()) < getWidth()) goto L112;
    L109:
        if (this.E == null) goto L111;
        this.f236710z.x = (getWidth() / 2) - (this.f236706x * this.E.x);
        this.f236710z.y = (getHeight() / 2) - (this.f236706x * this.E.y);
        goto L112
    L111:
        this.f236710z.x = (getWidth() / 2) - (this.f236706x * (M() / 2));
        this.f236710z.y = (getHeight() / 2) - (this.f236706x * (L() / 2));
        goto L112
    L91:
        if (this.W == false) goto L112;
    L87:
        r144 = false;
        goto L88
    L115:
        if (this.I == true) goto L170;
        float r159 = Math.abs(r110.getX() - this.S.x);
        float r160 = Math.abs(r110.getY() - this.S.y);
        float r161 = this.S1 * 5.0f;
        if (r159 <= r161) goto L119;
    L122:
        this.f236710z.x = this.A.x + (r110.getX() - this.S.x);
        this.f236710z.y = this.A.y + (r110.getY() - this.S.y);
        PointF r162 = this.f236710z;
        float r163 = r162.x;
        float r164 = r162.y;
        y(true);
        PointF r165 = this.f236710z;
        if (r163 == r165.x) goto L125;
        boolean r166 = true;
    L126:
        float r167 = r165.y;
        if (r164 == r167) goto L129;
        boolean r168 = true;
    L130:
        if (r166 == true) goto L132;
    L136:
        boolean r169 = false;
    L137:
        if (r168 == true) goto L139;
    L143:
        boolean r170 = false;
    L144:
        if (r164 == r167) goto L146;
    L148:
        boolean r171 = false;
    L149:
        if (r169 == true) goto L157;
        if (r170 == true) goto L157;
        if (r166 == false) goto L156;
        if (r168 == false) goto L156;
        if (r171 == true) goto L156;
        if (this.f236673J == false) goto L157;
    L156:
        this.f236673J = true;
    L164:
        if (this.f236699r == true) goto L168;
        PointF r172 = this.f236710z;
        PointF r173 = this.A;
        r172.x = r173.x;
        r172.y = r173.y;
        ViewParent r174 = getParent();
        if (r174 == null) goto L168;
        r174.requestDisallowInterceptTouchEvent(false);
    L168:
        J(this.f236698q);
    L157:
        if (r159 <= r161) goto L159;
    L160:
        this.L = 0;
        this.f236697p1.removeMessages(1);
        ViewParent r175 = getParent();
        if (r175 == null) goto L164;
        r175.requestDisallowInterceptTouchEvent(false);
        goto L164
    L159:
        if (r160 <= r161) goto L164;
    L146:
        if (r160 <= (3.0f * r161)) goto L148;
        r171 = true;
        goto L149
    L139:
        if (r160 <= r159) goto L143;
        if (this.f236673J == true) goto L143;
        r170 = true;
        goto L144
    L132:
        if (r159 <= r160) goto L136;
        if (this.f236673J == true) goto L136;
        r169 = true;
        goto L137
    L129:
        r168 = false;
        goto L130
    L125:
        r166 = false;
        goto L126
    L119:
        if (r160 > r161) goto L122;
        if (this.f236673J == false) goto L170;
    L174:
        float r176 = getScale();
        if (this.f236683g1 == null) goto L182;
        float r177 = this.T1;
        int r178 = iu5.c.f495800a;
        if (Math.abs(r176 - r177) >= 1.0E-8f) goto L179;
        boolean r179 = true;
    L180:
        if (r179 == true) goto L182;
        ((r95.m) this.f236683g1).a(this.T1, r176);
        goto L182
    L179:
        r179 = false;
        goto L180
    L207:
        this.T1 = getScale();
        goto L208
    L229:
        return true;
    L5:
        if (r100.f236723i == true) goto L10;
        ViewParent r180 = getParent();
        if (r180 == null) goto L9;
        r180.requestDisallowInterceptTouchEvent(true);
    L9:
        return true;
    }

    public final int p(float r100) {
        if (this.f236688k <= 0) goto L5;
        DisplayMetrics r101 = b(getResources());
        r100 = r100 * (this.f236688k / ((r101.xdpi + r101.ydpi) / 2.0f));
    L5:
        int r102 = (int) (M() * r100);
        int r103 = (int) (L() * r100);
        if (r102 == 0) goto L23;
        if (r103 == 0) goto L27;
        int r104 = 1;
        if (L() <= r103) goto L12;
    L15:
        int r105 = Math.round(L() / r103);
        int r106 = Math.round(M() / r102);
        if (r105 < r106) goto L19;
        r105 = r106;
    L19:
        int r107 = r104 * 2;
        if (r107 >= r105) goto L22;
        r104 = r107;
        goto L19
    L22:
        return r104;
    L12:
        if (M() > r102) goto L15;
        r105 = 1;
        goto L19
    L27:
        return 32;
    L23:
        return 32;
    }

    public final void q(PointF r100) {
        RectF r101 = this.V1;
        r101.left = r100.x;
        r101.top = r100.y;
        if (getRequiredRotation() != 90) goto L5;
    L8:
        RectF r102 = this.V1;
        float r103 = r100.x;
        float r104 = this.G;
        float r105 = this.f236706x;
        r102.right = r103 + (r104 * r105);
        r102.bottom = r100.y + (this.F * r105);
        return;
    L5:
        if (getRequiredRotation() == 270) goto L8;
        RectF r106 = this.V1;
        float r107 = r100.x;
        float r108 = this.F;
        float r109 = this.f236706x;
        r106.right = r107 + (r108 * r109);
        r106.bottom = r100.y + (this.G * r109);
    }

    public final void setBitmapDecoderClass(Class<? extends ImageDecoder> r100) {
        if (r100 == null) goto L6;
        this.Q = new CompatDecoderFactory(r100);
        return;
    L6:
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setBitmapDecoderFactory(DecoderFactory<? extends ImageDecoder> r100) {
        if (r100 == null) goto L6;
        this.Q = r100;
        return;
    L6:
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setDebug(boolean r100) {
        this.f236682g = r100;
    }

    public final void setDoubleTapZoomDpi(int r100) {
        DisplayMetrics r101 = b(getResources());
        setDoubleTapZoomScale(((r101.xdpi + r101.ydpi) / 2.0f) / r100);
    }

    public final void setDoubleTapZoomDuration(int r100) {
        this.f236705w = Math.max(0, r100);
    }

    public final void setDoubleTapZoomScale(float r100) {
        this.f236702u = r100;
    }

    public final void setDoubleTapZoomStyle(int r100) {
        if (f236668h2.contains(Integer.valueOf(r100)) == false) goto L7;
        this.f236703v = r100;
        return;
    L7:
        throw new IllegalArgumentException("Invalid zoom style: " + r100);
    }

    public final void setDrivePhotoViewDoubleTapZoomScale(float r100) {
        this.f236702u = r100 / getScaleFactor();
    }

    public void setEagerLoadingEnabled(boolean r100) {
        this.f236698q = r100;
    }

    public void setExecutor(Executor r100) {
        if (r100 == null) goto L6;
        this.f236695p = r100;
        return;
    L6:
        throw new NullPointerException("Executor must not be null");
    }

    public final void setImage(zl5.a r100) {
        O(r100, null);
    }

    public final void setMaxScale(float r100) {
        this.f236686i = r100;
    }

    public void setMaxTileSize(int r100) {
        this.f236693n = r100;
        this.f236694o = r100;
    }

    public final void setMaximumDpi(int r100) {
        DisplayMetrics r101 = b(getResources());
        setMinScale(((r101.xdpi + r101.ydpi) / 2.0f) / r100);
    }

    public final void setMinScale(float r100) {
        this.f236687j = r100;
    }

    public final void setMinimumDpi(int r100) {
        DisplayMetrics r101 = b(getResources());
        setMaxScale(((r101.xdpi + r101.ydpi) / 2.0f) / r100);
    }

    public final void setMinimumScaleType(int r100) {
        if (f236671x2.contains(Integer.valueOf(r100)) == false) goto L9;
        this.f236692m = r100;
        if (this.P0 == false) goto L10;
        y(true);
        invalidate();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Invalid scale type: " + r100);
    }

    public void setMinimumTileDpi(int r100) {
        DisplayMetrics r101 = b(getResources());
        this.f236688k = (int) Math.min((r101.xdpi + r101.ydpi) / 2.0f, r100);
        if (this.P0 == false) goto L6;
        K(false);
        invalidate();
        return;
    }

    public void setOnImageEventListener(h r100) {
        this.f236676b1 = r100;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r100) {
        this.f236690k1 = r100;
    }

    public void setOnMatrixChangeListener(bm5.a r100) {
        this.f236685h1 = r100;
    }

    public void setOnMatrixChangedListener(bm5.a r100) {
        this.f236685h1 = r100;
    }

    public void setOnScaleEventListener(bm5.b r100) {
        this.f236683g1 = r100;
    }

    public final void setOrientation(int r100) {
        if (f236667g2.contains(Integer.valueOf(r100)) == false) goto L7;
        this.f236684h = r100;
        K(false);
        invalidate();
        requestLayout();
        return;
    L7:
        throw new IllegalArgumentException("Invalid orientation: " + r100);
    }

    public final void setPanEnabled(boolean r100) {
        this.f236699r = r100;
        if (r100 == true) goto L10;
        PointF r101 = this.f236710z;
        if (r101 == null) goto L11;
        r101.x = (getWidth() / 2) - (this.f236706x * (M() / 2));
        this.f236710z.y = (getHeight() / 2) - (this.f236706x * (L() / 2));
        if (this.P0 == false) goto L12;
        J(true);
        invalidate();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setPanLimit(int r100) {
        if (f236670v2.contains(Integer.valueOf(r100)) == false) goto L9;
        this.f236691l = r100;
        if (this.P0 == false) goto L10;
        y(true);
        invalidate();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Invalid pan limit: " + r100);
    }

    public final void setQuickScaleEnabled(boolean r100) {
        this.f236701t = r100;
    }

    public final void setRegionDecoderClass(Class<? extends ImageRegionDecoder> r100) {
        if (r100 == null) goto L6;
        this.R = new CompatDecoderFactory(r100);
        return;
    L6:
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setRegionDecoderFactory(DecoderFactory<? extends ImageRegionDecoder> r100) {
        if (r100 == null) goto L6;
        this.R = r100;
        return;
    L6:
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public void setScale(float r100) {
        this.f236706x = r100;
    }

    public void setScaleImageConfig(k r100) {
        this.f236677b2 = r100;
    }

    public final void setTileBackgroundColor(int r100) {
        if (Color.alpha(r100) != 0) goto L5;
        this.G1 = null;
    L6:
        invalidate();
        return;
    L5:
        Paint r101 = new Paint();
        this.G1 = r101;
        r101.setStyle(Paint.Style.FILL);
        this.G1.setColor(r100);
        goto L6
    }

    public final void setZoomEnabled(boolean r100) {
        this.f236700s = r100;
    }

    public SubsamplingScaleImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f236684h = 0;
        this.f236686i = 2.0f;
        this.f236687j = E();
        this.f236688k = -1;
        this.f236691l = 1;
        this.f236692m = 1;
        this.f236693n = Integer.MAX_VALUE;
        this.f236694o = Integer.MAX_VALUE;
        this.f236695p = AsyncTask.THREAD_POOL_EXECUTOR;
        this.f236698q = true;
        this.f236699r = true;
        this.f236700s = true;
        this.f236701t = true;
        this.f236702u = 1.0f;
        this.f236703v = 1;
        this.f236705w = 500;
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
        setGestureDetector(r100);
        this.f236697p1 = new Handler(new a(this));
        if (r101 == null) goto L29;
        TypedArray r102 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.assetName, R.attr.panEnabled, R.attr.quickScaleEnabled, R.attr.src, R.attr.tileBackgroundColor, R.attr.zoomEnabled});
        if (r102.hasValue(0) == false) goto L12;
        String r103 = r102.getString(0);
        if (r103 == null) goto L12;
        if (r103.length() <= 0) goto L12;
        zl5.a r104 = zl5.a.a("file:///android_asset/".concat(r103));
        r104.f572788c = true;
        setImage(r104);
    L12:
        if (r102.hasValue(3) == false) goto L17;
        int r105 = r102.getResourceId(3, 0);
        if (r105 <= 0) goto L17;
        zl5.a r106 = new zl5.a(r105);
        r106.f572788c = true;
        setImage(r106);
    L17:
        if (r102.hasValue(1) == false) goto L20;
        setPanEnabled(r102.getBoolean(1, true));
    L20:
        if (r102.hasValue(5) == false) goto L23;
        setZoomEnabled(r102.getBoolean(5, true));
    L23:
        if (r102.hasValue(2) == false) goto L26;
        setQuickScaleEnabled(r102.getBoolean(2, true));
    L26:
        if (r102.hasValue(4) == false) goto L28;
        setTileBackgroundColor(r102.getColor(4, Color.argb(0, 0, 0, 0)));
    L28:
        r102.recycle();
    L29:
        this.U = TypedValue.applyDimension(1, 20.0f, b(r100.getResources()));
    }

    public static /* synthetic */ void e(SubsamplingScaleImageView r100, Context r101) {
        r100.setGestureDetector(r101);
    }

    public static /* synthetic */ void f(SubsamplingScaleImageView r100, View.OnLongClickListener r101) {
        super.setOnLongClickListener(r101);
    }

    public static float o(SubsamplingScaleImageView r100, float r101) {
        float r102 = Math.max(r100.E(), r101);
        return Math.min(r100.f236686i, r102);
    }

    private void v(String r100, Object... r101) {
        if (this.f236682g == false) goto L6;
        tt5.a.b("SubsamplingScaleImageView", String.format(r100, r101));
        return;
    }

    private void w(PointF r110, PointF r111) {
        if (this.f236699r == true) goto L8;
        PointF r100 = this.E;
        if (r100 == null) goto L7;
        r110.x = r100.x;
        r110.y = r100.y;
        goto L8
    L7:
        r110.x = M() / 2;
        r110.y = L() / 2;
    L8:
        float r101 = Math.min(this.f236686i, this.f236702u);
        float r102 = this.f236706x;
        if (r102 > (((double) r101) * 0.9d)) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == true) goto L18;
        r101 = E();
    L18:
        int r104 = this.f236703v;
        if (r104 != 3) goto L22;
        this.L0 = null;
        this.C = Float.valueOf(r101);
        this.D = r110;
        this.E = r110;
        invalidate();
    L30:
        invalidate();
        bm5.b r112 = this.f236683g1;
        if (r112 == null) goto L34;
        ((r95.m) r112).a(getScale(), r101);
        return;
    L34:
        return;
    L22:
        if (r104 == 2) goto L29;
        if (r103 == false) goto L29;
        if (this.f236699r == false) goto L29;
        if (r104 != 1) goto L30;
        e r105 = new e(this, r101, r110, r111);
        r105.f236733g = false;
        r105.f236730d = this.f236705w;
        r105.f236732f = 4;
        r105.a();
    L29:
        e r113 = new e(this, r101, r110);
        r113.f236733g = false;
        r113.f236730d = this.f236705w;
        r113.f236732f = 4;
        r113.a();
        goto L30
    L11:
        if (r102 == this.f236687j) goto L14;
        r103 = false;
        goto L15
    }

    public final synchronized void F(Bitmap r100, int r101) {
        monitor-enter(this);
        v("onImageLoaded", new Object[0]);     // Catch: Throwable -> L28
        int r102 = this.F;     // Catch: Throwable -> L28
        if (r102 > 0) goto L6;
    L12:
        Bitmap r103 = this.f236674a;     // Catch: Throwable -> L28
        if (r103 == null) goto L18;
        if (this.f236678c == true) goto L18;
        r103.recycle();     // Catch: Throwable -> L28
    L18:
        if (this.f236674a != null) goto L20;
    L22:
        this.f236675b = false;     // Catch: Throwable -> L28
        this.f236678c = false;     // Catch: Throwable -> L28
        this.f236674a = r100;     // Catch: Throwable -> L28
        this.F = r100.getWidth();     // Catch: Throwable -> L28
        this.G = r100.getHeight();     // Catch: Throwable -> L28
        this.H = r101;     // Catch: Throwable -> L28
        boolean r104 = s();     // Catch: Throwable -> L28
        boolean r105 = r();     // Catch: Throwable -> L28
        if (r104 == true) goto L25;
        if (r105 == true) goto L25;
    L26:
        monitor-exit(this);
        return;
    L25:
        invalidate();     // Catch: Throwable -> L28
        requestLayout();     // Catch: Throwable -> L28
        goto L26
    L20:
        if (this.f236678c == false) goto L22;
        h r106 = this.f236676b1;     // Catch: Throwable -> L28
        goto L22
    L6:
        if (this.G <= 0) goto L12;
        if (r102 == r100.getWidth()) goto L10;
    L11:
        K(false);     // Catch: Throwable -> L28
        goto L12
    L10:
        if (this.G == r100.getHeight()) goto L12;
    L28:
        th = move-exception;
        throw th;
    }

    public final void N(float r100, PointF r101) {
        if (this.f236685h1 != null) goto L5;
        return;
    L5:
        if (this.f236706x == r100) goto L7;
    L8:
        q(this.f236710z);
        bm5.a r102 = this.f236685h1;
        r95.l r103 = (r95.l) r102;
        r103.a(this.V1);
        return;
    L7:
        if (this.f236710z.equals(r101) == false) goto L8;
    }

    public final void O(zl5.a r100, ImageViewState r101) {
        if (r100 == null) goto L19;
        K(true);
        if (r101 != null) goto L6;
    L8:
        Uri r102 = r100.f572786a;
        this.f236679d = r102;
        if (r102 != null) goto L14;
        if (r100.f572787b == null) goto L14;
        this.f236679d = UriProtector.parse("android.resource://" + getContext().getPackageName() + HTTP.URL_DEFAULT + r100.f572787b);
    L14:
        if (r100.f572788c == true) goto L16;
        new f(this, getContext(), this.Q, this.f236679d).executeOnExecutor(this.f236695p, new Void[0]);
        return;
    L16:
        new n(this, getContext(), this.R, this.f236679d).executeOnExecutor(this.f236695p, new Void[0]);
        return;
    L6:
        if (f236667g2.contains(Integer.valueOf(r101.getOrientation())) == false) goto L8;
        this.f236684h = r101.getOrientation();
        this.C = Float.valueOf(r101.getScale());
        this.D = r101.getCenter();
        invalidate();
        goto L8
    L19:
        throw new NullPointerException("imageSource must not be null");
    }

    public final void R(Rect r100, Rect r101) {
        r101.set((int) S(r100.left), (int) T(r100.top), (int) S(r100.right), (int) T(r100.bottom));
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getMode(r101);
        int r104 = View.MeasureSpec.getSize(r100);
        int r105 = View.MeasureSpec.getSize(r101);
        boolean r106 = true;
        if (r102 == 1073741824) goto L5;
        boolean r107 = true;
    L6:
        if (r103 != 1073741824) goto L10;
        r106 = false;
    L10:
        if (this.F > 0) goto L12;
    L20:
        setMeasuredDimension(Math.max(r104, getSuggestedMinimumWidth()), Math.max(r105, getSuggestedMinimumHeight()));
        return;
    L12:
        if (this.G <= 0) goto L20;
        if (r107 == false) goto L16;
        if (r106 == false) goto L16;
        r104 = M();
        r105 = L();
    L16:
        if (r106 == false) goto L18;
        r105 = (int) ((((double) L()) / ((double) M())) * ((double) r104));
        goto L20
    L18:
        if (r107 == false) goto L20;
        r104 = (int) ((((double) M()) / ((double) L())) * ((double) r105));
        goto L20
    L5:
        r107 = false;
        goto L6
    }

    public final void z(boolean r110, j r111) {
        if (this.f236691l == 2) goto L5;
    L7:
        PointF r100 = r111.f236744b;
        float r101 = Math.min(this.f236686i, Math.max(E(), r111.f236743a));
        float r102 = M() * r101;
        float r103 = L() * r101;
        if (this.f236691l == 3) goto L10;
    L12:
        if (r110 == false) goto L14;
        r100.x = Math.max(r100.x, getWidth() - r102);
        r100.y = Math.max(r100.y, getHeight() - r103);
    L15:
        float r104 = 0.5f;
        if (getPaddingLeft() <= 0) goto L18;
    L21:
        float r105 = getPaddingLeft() / (getPaddingLeft() + getPaddingRight());
    L23:
        if (getPaddingTop() <= 0) goto L25;
    L26:
        r104 = getPaddingTop() / (getPaddingTop() + getPaddingBottom());
    L28:
        if (this.f236691l == 3) goto L30;
    L32:
        if (r110 == false) goto L34;
        float r112 = Math.max(0.0f, (getWidth() - r102) * r105);
        float r106 = Math.max(0.0f, (getHeight() - r103) * r104);
    L36:
        r100.x = Math.min(r100.x, r112);
        r100.y = Math.min(r100.y, r106);
        r111.f236743a = r101;
        return;
    L34:
        r112 = Math.max(0, getWidth());
        int r107 = Math.max(0, getHeight());
    L35:
        r106 = r107;
        goto L36
    L30:
        if (this.P0 == false) goto L32;
        r112 = Math.max(0, getWidth() / 2);
        r107 = Math.max(0, getHeight() / 2);
        goto L35
    L25:
        if (getPaddingBottom() <= 0) goto L28;
    L18:
        if (getPaddingRight() > 0) goto L21;
        r105 = 0.5f;
        goto L23
    L14:
        r100.x = Math.max(r100.x, -r102);
        r100.y = Math.max(r100.y, -r103);
        goto L15
    L10:
        if (this.P0 == false) goto L12;
        r100.x = Math.max(r100.x, (getWidth() / 2) - r102);
        r100.y = Math.max(r100.y, (getHeight() / 2) - r103);
        goto L15
    L5:
        if (this.P0 == false) goto L7;
        r110 = false;
        goto L7
    }

    public static /* synthetic */ void g(SubsamplingScaleImageView r100, PointF r101, PointF r102) {
        r100.w(r101, r102);
    }

    public static /* synthetic */ void j(SubsamplingScaleImageView r100, String r101, Object[] r102) {
        r100.v(r101, r102);
    }

    public static int k(SubsamplingScaleImageView r110, Context r111, String r112) {
        int r100 = 0;
        if (r112.startsWith("content") == false) goto L26;
        Cursor r101 = null;
        r101 = sf7.a.f541727a.query(r111.getContentResolver(), Uri.parse(r112), new String[]{"orientation"}, null, null, null, new Token("LARK-PSDA-ccm_android_subsampling_scale_imageView_query_media"));     // Catch: Throwable -> L17 Exception -> L19
        if (r101 != null) goto L8;
    L15:
        if (r101 == null) goto L51;
    L21:
        r101.close();
        return r100;
    L51:
        return r100;
    L8:
        if (r101.moveToFirst() == false) goto L15;
        int r113 = r101.getInt(0);     // Catch: Throwable -> L17 Exception -> L19
        if (f236667g2.contains(Integer.valueOf(r113)) == true) goto L12;
    L14:
        tt5.a.k("SubsamplingScaleImageView", "Unsupported orientation: " + r113);     // Catch: Throwable -> L17 Exception -> L19
    L12:
        if (r113 == (-1)) goto L14;
        r100 = r113;
    L19:
        tt5.a.k("SubsamplingScaleImageView", "Could not get orientation of image from media store");     // Catch: Throwable -> L17
        if (r101 != null) goto L21;
        return 0;
    L17:
        th = move-exception;
        if (r101 == null) goto L24;
        r101.close();
    L24:
        throw th;
    L26:
        if (r112.startsWith("file:///") == true) goto L28;
        return 0;
    L28:
        if (r112.startsWith("file:///android_asset/") == true) goto L55;
        int r114 = t(new ExifInterface(r112.substring(7)));     // Catch: Exception -> L44
        if (r114 == 1) goto L56;
        if (r114 != 0) goto L34;
        return 0;
    L34:
        if (r114 != 6) goto L37;
        return 90;
    L37:
        if (r114 != 3) goto L40;
        return 180;
    L40:
        if (r114 == 8) goto L60;
        tt5.a.k("SubsamplingScaleImageView", "Unsupported EXIF orientation: " + r114);     // Catch: Exception -> L44
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

    public static void m(SubsamplingScaleImageView r100, Rect r101, Rect r102) {
        if (r100.getRequiredRotation() != 0) goto L6;
        r102.set(r101);
        return;
    L6:
        if (r100.getRequiredRotation() != 90) goto L9;
        int r103 = r101.top;
        int r104 = r100.G;
        r102.set(r103, r104 - r101.right, r101.bottom, r104 - r101.left);
        return;
    L9:
        if (r100.getRequiredRotation() != 180) goto L11;
        int r105 = r100.F;
        int r106 = r105 - r101.right;
        int r107 = r100.G;
        r102.set(r106, r107 - r101.bottom, r105 - r101.left, r107 - r101.top);
        return;
    L11:
        int r108 = r100.F;
        r102.set(r108 - r101.bottom, r101.left, r108 - r101.top, r101.right);
    }

    public final PointF U(float r100, float r101, float r102) {
        int r103 = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int r104 = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.H1 != null) goto L5;
        this.H1 = new j(0.0f, new PointF(0.0f, 0.0f));
    L5:
        j r105 = this.H1;
        r105.f236743a = r102;
        r105.f236744b.set(r103 - (r100 * r102), r104 - (r101 * r102));
        z(true, this.H1);
        return this.H1.f236744b;
    }

    public final void i(float r100, float r101, float r102) {
        if (this.V0 == true) goto L5;
        return;
    L5:
        if (this.P0 == false) goto L15;
        PointF r103 = new PointF(r101, r102);
        float r104 = r103.x;
        float r105 = r103.y;
        PointF r106 = new PointF();
        PointF r107 = this.f236710z;
        if (r107 != null) goto L9;
        r106 = null;
    L10:
        if (r106 != null) goto L12;
        return;
    L12:
        e r108 = new e(this, r100 / getScaleFactor(), r106, r103);
        r108.f236733g = false;
        r108.f236730d = this.f236705w;
        r108.f236732f = 4;
        r108.a();
        return;
    L9:
        float r109 = r104 - r107.x;
        float r110 = this.f236706x;
        r106.set(r109 / r110, (r105 - r107.y) / r110);
        goto L10
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        v("onSizeChanged %dx%d -> %dx%d", new Object[]{Integer.valueOf(r102), Integer.valueOf(r103), Integer.valueOf(r100), Integer.valueOf(r101)});
        PointF r104 = getCenter();
        if (this.P0 == false) goto L6;
        if (r104 == null) goto L6;
        this.L0 = null;
        this.C = Float.valueOf(this.f236706x);
        this.D = r104;
    L6:
        if (r103 == 0) goto L12;
        if (r102 != 0) goto L9;
        return;
    L9:
        if (this.f236685h1 == null) goto L14;
        y(true);
        q(this.f236710z);
        ((r95.l) this.f236685h1).a(this.V1);
        return;
    L14:
        return;
    }

    public static void l(SubsamplingScaleImageView r100, ImageRegionDecoder r101, int r102, int r103, int r104) {
        monitor-enter(r100);
        r100.v("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", new Object[]{Integer.valueOf(r102), Integer.valueOf(r103), Integer.valueOf(r100.f236684h)});     // Catch: Throwable -> L32
        int r105 = r100.F;     // Catch: Throwable -> L32
        if (r105 <= 0) goto L15;
        int r106 = r100.G;     // Catch: Throwable -> L32
        if (r106 <= 0) goto L15;
        if (r105 != r102) goto L9;
        if (r106 == r103) goto L15;
    L9:
        r100.K(false);     // Catch: Throwable -> L32
        Bitmap r107 = r100.f236674a;     // Catch: Throwable -> L32
        if (r107 == null) goto L15;
        if (r100.f236678c == true) goto L14;
        r107.recycle();     // Catch: Throwable -> L32
    L14:
        r100.f236674a = null;     // Catch: Throwable -> L32
        h r108 = r100.f236676b1;     // Catch: Throwable -> L32
        r100.f236675b = false;     // Catch: Throwable -> L32
        r100.f236678c = false;     // Catch: Throwable -> L32
    L15:
        r100.O = r101;     // Catch: Throwable -> L32
        r100.F = r102;     // Catch: Throwable -> L32
        r100.G = r103;     // Catch: Throwable -> L32
        r100.H = r104;     // Catch: Throwable -> L32
        r100.s();     // Catch: Throwable -> L32
        if (r100.r() == true) goto L29;
        int r109 = r100.f236693n;     // Catch: Throwable -> L32
        if (r109 <= 0) goto L29;
        if (r109 == Integer.MAX_VALUE) goto L29;
        int r110 = r100.f236694o;     // Catch: Throwable -> L32
        if (r110 <= 0) goto L29;
        if (r110 == Integer.MAX_VALUE) goto L29;
        if (r100.getWidth() <= 0) goto L29;
        if (r100.getHeight() <= 0) goto L29;
        r100.B(new Point(r100.f236693n, r100.f236694o));     // Catch: Throwable -> L32
    L29:
        r100.invalidate();     // Catch: Throwable -> L32
        r100.requestLayout();     // Catch: Throwable -> L32
        monitor-exit(r100);
        return;
    L32:
        th = move-exception;
        throw th;
    }

    public static float x(int r100, long r101, float r102, float r103, long r104) {
        if (r100 != 1) goto L5;
        float r105 = r101 / r104;
        return (((-r103) * r105) * (r105 - 2.0f)) + r102;
    L5:
        if (r100 != 2) goto L13;
        float r106 = r101 / (r104 / 2.0f);
        if (r106 >= 1.0f) goto L9;
        float r107 = (r103 / 2.0f) * r106;
    L11:
        return (r107 * r106) + r102;
    L9:
        float r108 = r106 - 1.0f;
        r107 = (-r103) / 2.0f;
        r106 = (r108 * (r108 - 2.0f)) - 1.0f;
        goto L11
    L13:
        throw new IllegalStateException("Unexpected easing type: " + r100);
    }

    public static void P(float[] r100, float r101, float r102, float r103, float r104, float r105, float r106, float r107, float r108) {
        r100[0] = r101;
        r100[1] = r102;
        r100[2] = r103;
        r100[3] = r104;
        r100[4] = r105;
        r100[5] = r106;
        r100[6] = r107;
        r100[7] = r108;
    }
}
