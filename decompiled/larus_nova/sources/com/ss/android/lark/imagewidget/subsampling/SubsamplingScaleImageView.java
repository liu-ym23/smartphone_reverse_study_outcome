package com.ss.android.lark.imagewidget.subsampling;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
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
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.imagewidget.subsampling.decoder.SkiaImageDecoder;
import com.ss.android.lark.imagewidget.subsampling.decoder.SkiaImageRegionDecoder;
import com.ss.android.lark.log.Log;
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
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
public class SubsamplingScaleImageView extends View {
    public static final List<Integer> E2 = null;
    public static final List<Integer> F2 = null;
    public static final List<Integer> G2 = null;
    public static Bitmap.Config H2;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public static final List<Integer> f426691x2 = null;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public static final List<Integer> f426692y2 = null;
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
    public Paint H1;
    public Rect I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public Rect f426693J;
    public boolean K;
    public boolean L;
    public PointF L0;
    public Paint L1;
    public boolean M;
    public Paint M1;
    public int N;
    public GestureDetector O;
    public GestureDetector P;
    public PointF P0;
    public l P1;
    public rlb.d Q;
    public Matrix Q1;
    public final ReadWriteLock R;
    public rlb.b<? extends rlb.c> S;
    public RectF S1;
    public rlb.b<? extends rlb.d> T;
    public final float[] T1;
    public PointF U;
    public float V;
    public e V0;
    public final float[] V1;
    public final float W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f426694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f426695b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public boolean f426696b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public final float f426697b2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f426698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Uri f426699d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f426700e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<Integer, List<n>> f426701f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f426702g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public boolean f426703g1;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public plb.a f426704g2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f426705h;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public h f426706h1;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public float f426707h2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f426708i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f426709j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f426710k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public float f426711k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public OnScaleEventListener f426712k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f426713l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f426714m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f426715n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f426716o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Executor f426717p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f426718p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public i f426719p1;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public final RectF f426720p2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f426721q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f426722r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f426723s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f426724t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f426725u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f426726v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public View.OnLongClickListener f426727v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public final ScaleGestureDetector f426728v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f426729w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f426730x;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public j f426731x1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f426732y;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public final Handler f426733y1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public PointF f426734z;

    public interface OnScaleEventListener {

        public static final enum ScaleCause extends Enum<ScaleCause> {
            public static final ScaleCause DOUBLE_TAP = null;
            public static final ScaleCause GESTURE = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ ScaleCause[] f426735a = null;

            static {
                ScaleCause r100 = new ScaleCause("DOUBLE_TAP", 0);
                DOUBLE_TAP = r100;
                ScaleCause r101 = new ScaleCause("GESTURE", 1);
                GESTURE = r101;
                f426735a = new ScaleCause[]{r100, r101};
            }

            public static ScaleCause[] values() {
                return (ScaleCause[]) f426735a.clone();
            }

            public static ScaleCause valueOf(String r100) {
                return (ScaleCause) r27.a.a(ScaleCause.class, r100);
            }

            public ScaleCause(String r100, int r101) {
                super(r100, r101);
            }
        }

        void a(float r100, float r101, ScaleCause r102);

        void b(float r100);
    }

    public class a implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SubsamplingScaleImageView f426736a;

        public a(SubsamplingScaleImageView r100) {
            this.f426736a = r100;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r100) {
            if (r100.what != 1) goto L7;
            SubsamplingScaleImageView r101 = this.f426736a;
            View.OnLongClickListener r102 = r101.f426727v1;
            if (r102 == null) goto L7;
            r101.N = 0;
            SubsamplingScaleImageView.b(r101, r102);
            this.f426736a.performLongClick();
            SubsamplingScaleImageView.c(this.f426736a);
        L7:
            return true;
        }
    }

    public class b extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f426737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SubsamplingScaleImageView f426738b;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r100) {
            SubsamplingScaleImageView r101 = this.f426738b;
            if (r101.f426723s == false) goto L15;
            if (r101.f426696b1 == false) goto L15;
            if (r101.f426734z == null) goto L15;
            r101.setGestureDetector(this.f426737a);
            SubsamplingScaleImageView r102 = this.f426738b;
            if (r102.f426724t == false) goto L12;
            r102.U = new PointF(r100.getX(), r100.getY());
            SubsamplingScaleImageView r103 = this.f426738b;
            PointF r104 = this.f426738b.f426734z;
            r103.A = new PointF(r104.x, r104.y);
            SubsamplingScaleImageView r105 = this.f426738b;
            r105.f426732y = r105.f426730x;
            r105.M = true;
            r105.K = true;
            r105.f426711k0 = -1.0f;
            r105.L0 = r105.R(r105.U);
            SubsamplingScaleImageView r106 = this.f426738b;
            r106.P0 = new PointF(r100.getX(), r100.getY());
            SubsamplingScaleImageView r107 = this.f426738b;
            PointF r108 = this.f426738b.L0;
            r107.H0 = new PointF(r108.x, r108.y);
            this.f426738b.f426718p0 = false;
            return false;
        L12:
            r102.o(r102.R(new PointF(r100.getX(), r100.getY())), new PointF(r100.getX(), r100.getY()));
            return true;
        L15:
            return onDoubleTapEvent(r100);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r100) {
            this.f426738b.performClick();
            return true;
        }

        public b(SubsamplingScaleImageView r100, Context r101) {
            this.f426738b = r100;
            this.f426737a = r101;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            SubsamplingScaleImageView r104 = this.f426738b;
            if (r104.f426722r == false) goto L23;
            if (r104.f426696b1 == false) goto L23;
            if (r104.f426734z == null) goto L23;
            if (r100 == null) goto L23;
            if (r101 == null) goto L23;
            if (Math.abs(r100.getX() - r101.getX()) > 50.0f) goto L15;
            if (Math.abs(r100.getY() - r101.getY()) <= 50.0f) goto L23;
        L15:
            if (Math.abs(r102) > 500.0f) goto L19;
            if (Math.abs(r103) <= 500.0f) goto L23;
        L19:
            if (this.f426738b.K == true) goto L23;
            PointF r105 = this.f426738b.f426734z;
            PointF r106 = new PointF(r105.x + (r102 * 0.25f), r105.y + (r103 * 0.25f));
            float r107 = (this.f426738b.getWidth() / 2) - r106.x;
            SubsamplingScaleImageView r108 = this.f426738b;
            float r109 = r107 / r108.f426730x;
            float r110 = (r108.getHeight() / 2) - r106.y;
            SubsamplingScaleImageView r111 = this.f426738b;
            f r112 = new f(r111, new PointF(r109, r110 / r111.f426730x));
            r112.b();
            r112.f426761h = false;
            r112.f426759f = 3;
            r112.a();
            return true;
        L23:
            return super.onFling(r100, r101, r102, r103);
        }
    }

    public class c extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SubsamplingScaleImageView f426739a;

        public c(SubsamplingScaleImageView r100) {
            this.f426739a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r100) {
            this.f426739a.performClick();
            return true;
        }
    }

    public class d implements ScaleGestureDetector.OnScaleGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SubsamplingScaleImageView f426740a;

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector r100) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector r100) {
        }

        public d(SubsamplingScaleImageView r100) {
            this.f426740a = r100;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector r100) {
            OnScaleEventListener r101 = this.f426740a.f426712k1;
            if (r101 == null) goto L7;
            r101.b(r100.getScaleFactor());
            return true;
        L7:
            return true;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f426741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f426742b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public PointF f426743c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public PointF f426744d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public PointF f426745e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public PointF f426746f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public PointF f426747g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f426748h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f426749i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f426750j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f426751k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f426752l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f426753m;

        public e() {
            this.f426748h = 500;
            this.f426749i = true;
            this.f426750j = 2;
            this.f426751k = 1;
            this.f426752l = System.currentTimeMillis();
            this.f426753m = false;
        }
    }

    public final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f426754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PointF f426755b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PointF f426756c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f426757d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f426758e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f426759f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f426760g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f426761h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f426762i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ SubsamplingScaleImageView f426763j;

        public final void a() {
            SubsamplingScaleImageView r100 = this.f426763j;
            e r101 = r100.V0;
            int r102 = r100.getPaddingLeft() + (((this.f426763j.getWidth() - this.f426763j.getPaddingRight()) - this.f426763j.getPaddingLeft()) / 2);
            int r103 = this.f426763j.getPaddingTop() + (((this.f426763j.getHeight() - this.f426763j.getPaddingBottom()) - this.f426763j.getPaddingTop()) / 2);
            SubsamplingScaleImageView r104 = this.f426763j;
            float r105 = Math.min(r104.f426708i, Math.max(r104.x(), this.f426754a));
            if (this.f426761h == false) goto L5;
            SubsamplingScaleImageView r106 = this.f426763j;
            PointF r107 = this.f426755b;
            float r108 = r107.x;
            float r109 = r107.y;
            PointF r110 = new PointF();
            PointF r111 = r106.Q(r108, r109, r105);
            r110.set(((r106.getPaddingLeft() + (((r106.getWidth() - r106.getPaddingRight()) - r106.getPaddingLeft()) / 2)) - r111.x) / r105, ((r106.getPaddingTop() + (((r106.getHeight() - r106.getPaddingBottom()) - r106.getPaddingTop()) / 2)) - r111.y) / r105);
        L6:
            this.f426763j.V0 = new e();
            SubsamplingScaleImageView r112 = this.f426763j;
            e r113 = r112.V0;
            r113.f426741a = r112.f426730x;
            r113.f426742b = r105;
            r113.f426752l = System.currentTimeMillis();
            SubsamplingScaleImageView r114 = this.f426763j;
            e r115 = r114.V0;
            r115.f426745e = r110;
            r115.f426743c = r114.getCenter();
            SubsamplingScaleImageView r116 = this.f426763j;
            e r117 = r116.V0;
            r117.f426744d = r110;
            r117.f426746f = r116.N(r110);
            this.f426763j.V0.f426747g = new PointF(r102, r103);
            e r118 = this.f426763j.V0;
            r118.f426748h = this.f426757d;
            r118.f426749i = this.f426760g;
            r118.f426750j = this.f426758e;
            r118.f426751k = this.f426759f;
            r118.f426753m = this.f426762i;
            r118.f426752l = System.currentTimeMillis();
            this.f426763j.V0.getClass();
            PointF r119 = this.f426756c;
            if (r119 == null) goto L9;
            float r120 = r119.x;
            PointF r121 = this.f426763j.V0.f426743c;
            float r122 = r120 - (r121.x * r105);
            float r123 = r119.y - (r121.y * r105);
            PointF r124 = new PointF(r122, r123);
            this.f426763j.s(true, new l(r105, r124));
            e r125 = this.f426763j.V0;
            PointF r126 = this.f426756c;
            r125.f426747g = new PointF(r126.x + (r124.x - r122), r126.y + (r124.y - r123));
        L9:
            this.f426763j.invalidate();
            return;
        L5:
            r110 = this.f426755b;
            goto L6
        }

        public final void b() {
            if (SubsamplingScaleImageView.E2.contains(1) == false) goto L7;
            this.f426758e = 1;
            return;
        L7:
            throw new IllegalArgumentException("Unknown easing type: 1");
        }

        public f(SubsamplingScaleImageView r100, float r101) {
            this.f426763j = r100;
            this.f426757d = 500;
            this.f426758e = 2;
            this.f426759f = 1;
            this.f426760g = true;
            this.f426761h = true;
            this.f426762i = false;
            this.f426754a = r101;
            this.f426755b = r100.getCenter();
            this.f426756c = null;
        }

        public f(SubsamplingScaleImageView r100, PointF r101) {
            this.f426763j = r100;
            this.f426757d = 500;
            this.f426758e = 2;
            this.f426759f = 1;
            this.f426760g = true;
            this.f426761h = true;
            this.f426762i = false;
            this.f426754a = r100.f426730x;
            this.f426755b = r101;
            this.f426756c = null;
        }

        public f(SubsamplingScaleImageView r100, float r101, PointF r102) {
            this.f426763j = r100;
            this.f426757d = 500;
            this.f426758e = 2;
            this.f426759f = 1;
            this.f426760g = true;
            this.f426761h = true;
            this.f426762i = false;
            this.f426754a = r101;
            this.f426755b = r102;
            this.f426756c = null;
        }

        public f(SubsamplingScaleImageView r100, float r101, PointF r102, PointF r103) {
            this.f426763j = r100;
            this.f426757d = 500;
            this.f426758e = 2;
            this.f426759f = 1;
            this.f426760g = true;
            this.f426761h = true;
            this.f426762i = false;
            this.f426754a = r101;
            this.f426755b = r102;
            this.f426756c = r103;
        }
    }

    public static class g extends PthreadAsyncTask<Void, Void, Integer> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final WeakReference<SubsamplingScaleImageView> f426764h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final WeakReference<Context> f426765i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final WeakReference<rlb.b<? extends rlb.c>> f426766j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Uri f426767k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final boolean f426768l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Bitmap f426769m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Exception f426770n;

        @Override // android.os.AsyncTask
        public final Object doInBackground(Object[] r100) {
            Void[] r101 = (Void[]) r100;
            String r102 = this.f426767k.toString();     // Catch: OutOfMemoryError -> L9 Exception -> L11
            Context r103 = this.f426765i.get();     // Catch: OutOfMemoryError -> L9 Exception -> L11
            rlb.b<? extends rlb.c> r104 = this.f426766j.get();     // Catch: OutOfMemoryError -> L9 Exception -> L11
            SubsamplingScaleImageView r105 = this.f426764h.get();     // Catch: OutOfMemoryError -> L9 Exception -> L11
            if (r103 == null) goto L13;
            if (r104 == null) goto L13;
            if (r105 == null) goto L13;
            List<Integer> r106 = SubsamplingScaleImageView.f426691x2;     // Catch: OutOfMemoryError -> L9 Exception -> L11
            r105.m("BitmapLoadTask.doInBackground", new Object[0]);     // Catch: OutOfMemoryError -> L9 Exception -> L11
            this.f426769m = r104.make().decode(r103, this.f426767k);     // Catch: OutOfMemoryError -> L9 Exception -> L11
        L17:
            return Integer.valueOf(SubsamplingScaleImageView.d(r105, r103, r102));
        L13:
            return null;
        L11:
            e = move-exception;
            Log.e("SubsamplingScaleImageView", "Failed to load bitmap", e);
            this.f426770n = e;
        L9:
            e = move-exception;
            Log.e("SubsamplingScaleImageView", "Failed to load bitmap - OutOfMemoryError", e);
            this.f426770n = new RuntimeException(e);
            goto L13
        }

        @Override // android.os.AsyncTask
        public final void onPostExecute(Object r100) {
            Integer r101 = (Integer) r100;
            SubsamplingScaleImageView r102 = this.f426764h.get();
            if (r102 == null) goto L20;
            Bitmap r103 = this.f426769m;
            if (r103 == null) goto L12;
            if (r101 == null) goto L12;
            if (this.f426768l == false) goto L10;
            List<Integer> r104 = SubsamplingScaleImageView.f426691x2;
            r102.z(r103);
            return;
        L10:
            int r105 = r101.intValue();
            List<Integer> r106 = SubsamplingScaleImageView.f426691x2;
            r102.y(r103, r105, false);
            return;
        L12:
            if (this.f426770n == null) goto L23;
            h r107 = r102.f426706h1;
            if (r107 != null) goto L16;
            return;
        L16:
            if (this.f426768l == false) goto L18;
            r107.a();
            return;
        L18:
            r107.b();
            return;
        L23:
            return;
        }

        public g(SubsamplingScaleImageView r100, Context r101, rlb.b<? extends rlb.c> r102, Uri r103, boolean r104) {
            this.f426764h = new WeakReference(r100);
            this.f426765i = new WeakReference(r101);
            this.f426766j = new WeakReference(r102);
            this.f426767k = r103;
            this.f426768l = r104;
        }
    }

    public interface h {
        void a();

        void b();

        void c();

        void onImageLoaded();

        void onPreviewReleased();

        void onReady();
    }

    public interface i {
        void a(RectF r100);
    }

    public interface j {
        PointF a(PointF r100);

        float b(int r100, int r101, int r102, int r103);
    }

    public interface k {
    }

    public static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f426771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PointF f426772b;

        public l(float r100, PointF r101) {
            this.f426771a = r100;
            this.f426772b = r101;
        }
    }

    public static class m {
    }

    public static class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Rect f426773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f426774b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Bitmap f426775c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f426776d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f426777e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Rect f426778f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Rect f426779g;

        public n() {
        }
    }

    public static class o extends PthreadAsyncTask<Void, Void, Bitmap> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final WeakReference<SubsamplingScaleImageView> f426780h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final WeakReference<rlb.d> f426781i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final WeakReference<n> f426782j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Exception f426783k;

        @Override // android.os.AsyncTask
        public final Object doInBackground(Object[] r100) {
            Void[] r101 = (Void[]) r100;
            SubsamplingScaleImageView r102 = this.f426780h.get();     // Catch: OutOfMemoryError -> L28 Exception -> L30
            rlb.d r103 = this.f426781i.get();     // Catch: OutOfMemoryError -> L28 Exception -> L30
            n r104 = this.f426782j.get();     // Catch: OutOfMemoryError -> L28 Exception -> L30
            if (r103 == null) goto L25;
            if (r104 == null) goto L25;
            if (r102 == null) goto L25;
            if (r103.isReady() == false) goto L25;
            if (r104.f426777e == false) goto L25;
            Object[] r105 = {r104.f426773a, Integer.valueOf(r104.f426774b)};     // Catch: OutOfMemoryError -> L28 Exception -> L30
            List<Integer> r106 = SubsamplingScaleImageView.f426691x2;     // Catch: OutOfMemoryError -> L28 Exception -> L30
            r102.m("TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", r105);     // Catch: OutOfMemoryError -> L28 Exception -> L30
            ((ReentrantReadWriteLock) r102.R).readLock().lock();     // Catch: OutOfMemoryError -> L28 Exception -> L30
        L22:
            th = move-exception;
            ((ReentrantReadWriteLock) r102.R).readLock().unlock();     // Catch: OutOfMemoryError -> L28 Exception -> L30
            throw th;     // Catch: OutOfMemoryError -> L28 Exception -> L30
        L13:
            if (r103.isReady() == false) goto L20;
            SubsamplingScaleImageView.e(r102, r104.f426773a, r104.f426779g);     // Catch: Throwable -> L22
            Rect r107 = r102.I;     // Catch: Throwable -> L22
            if (r107 == null) goto L17;
            r104.f426779g.offset(r107.left, r107.top);     // Catch: Throwable -> L22
        L17:
            Bitmap r108 = r103.decodeRegion(r104.f426779g, r104.f426774b);     // Catch: Throwable -> L22
            ((ReentrantReadWriteLock) r102.R).readLock().unlock();     // Catch: OutOfMemoryError -> L28 Exception -> L30
            return r108;
        L20:
            r104.f426776d = false;     // Catch: Throwable -> L22
            ((ReentrantReadWriteLock) r102.R).readLock().unlock();     // Catch: OutOfMemoryError -> L28 Exception -> L30
        L32:
            return null;
        L25:
            if (r104 == null) goto L32;
            r104.f426776d = false;     // Catch: OutOfMemoryError -> L28 Exception -> L30
        L30:
            e = move-exception;
            Log.e("SubsamplingScaleImageView", "Failed to decode tile", e);
            this.f426783k = e;
        L28:
            e = move-exception;
            Log.e("SubsamplingScaleImageView", "Failed to decode tile - OutOfMemoryError", e);
            this.f426783k = new RuntimeException(e);
            goto L32
        }

        @Override // android.os.AsyncTask
        public final void onPostExecute(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            SubsamplingScaleImageView r102 = this.f426780h.get();
            n r103 = this.f426782j.get();
            if (r102 == null) goto L35;
            if (r103 == null) goto L36;
            if (r101 == null) goto L28;
            r103.f426775c = r101;
            r103.f426776d = false;
            List<Integer> r104 = SubsamplingScaleImageView.f426691x2;
            monitor-enter(r102);
            r102.m("onTileLoaded", new Object[0]);     // Catch: Throwable -> L24
            r102.k();     // Catch: Throwable -> L24
            r102.j();     // Catch: Throwable -> L24
            if (r102.w() == false) goto L21;
            Bitmap r105 = r102.f426694a;     // Catch: Throwable -> L24
            if (r105 == null) goto L21;
            if (r102.f426698c == true) goto L15;
            r105.recycle();     // Catch: Throwable -> L24
        L15:
            r102.f426694a = null;     // Catch: Throwable -> L24
            h r106 = r102.f426706h1;     // Catch: Throwable -> L24
            if (r106 != null) goto L18;
        L20:
            r102.f426695b = false;     // Catch: Throwable -> L24
            r102.f426698c = false;     // Catch: Throwable -> L24
            goto L21
        L18:
            if (r102.f426698c == false) goto L20;
            r106.onPreviewReleased();     // Catch: Throwable -> L24
        L21:
            r102.invalidate();     // Catch: Throwable -> L24
            monitor-exit(r102);
            return;
        L24:
            th = move-exception;
            throw th;
        L28:
            if (this.f426783k == null) goto L37;
            h r107 = r102.f426706h1;
            if (r107 == null) goto L38;
            r107.c();
            return;
        L38:
            return;
        L37:
            return;
        L36:
            return;
        }

        public o(SubsamplingScaleImageView r100, rlb.d r101, n r102) {
            this.f426780h = new WeakReference(r100);
            this.f426781i = new WeakReference(r101);
            this.f426782j = new WeakReference(r102);
            r102.f426776d = true;
        }
    }

    public static class p extends PthreadAsyncTask<Void, Void, int[]> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final WeakReference<SubsamplingScaleImageView> f426784h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final WeakReference<Context> f426785i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final WeakReference<rlb.b<? extends rlb.d>> f426786j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Uri f426787k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public rlb.d f426788l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Exception f426789m;

        @Override // android.os.AsyncTask
        public final Object doInBackground(Object[] r100) {
            Void[] r101 = (Void[]) r100;
            String r102 = this.f426787k.toString();     // Catch: Exception -> L12
            Context r103 = this.f426785i.get();     // Catch: Exception -> L12
            rlb.b<? extends rlb.d> r104 = this.f426786j.get();     // Catch: Exception -> L12
            SubsamplingScaleImageView r105 = this.f426784h.get();     // Catch: Exception -> L12
            if (r103 == null) goto L14;
            if (r104 == null) goto L14;
            if (r105 == null) goto L14;
            List<Integer> r106 = SubsamplingScaleImageView.f426691x2;     // Catch: Exception -> L12
            r105.m("TilesInitTask.doInBackground", new Object[0]);     // Catch: Exception -> L12
            rlb.d r107 = r104.make();     // Catch: Exception -> L12
            this.f426788l = r107;     // Catch: Exception -> L12
            Point r108 = r107.init(r103, this.f426787k);     // Catch: Exception -> L12
            int r109 = r108.x;     // Catch: Exception -> L12
            int r110 = r108.y;     // Catch: Exception -> L12
            int r111 = SubsamplingScaleImageView.d(r105, r103, r102);     // Catch: Exception -> L12
            Rect r112 = r105.I;     // Catch: Exception -> L12
            if (r112 == null) goto L10;
            r112.left = Math.max(0, r112.left);     // Catch: Exception -> L12
            Rect r113 = r105.I;     // Catch: Exception -> L12
            r113.top = Math.max(0, r113.top);     // Catch: Exception -> L12
            Rect r114 = r105.I;     // Catch: Exception -> L12
            r114.right = Math.min(r109, r114.right);     // Catch: Exception -> L12
            Rect r115 = r105.I;     // Catch: Exception -> L12
            r115.bottom = Math.min(r110, r115.bottom);     // Catch: Exception -> L12
            r109 = r105.I.width();     // Catch: Exception -> L12
            r110 = r105.I.height();     // Catch: Exception -> L12
        L10:
            return new int[]{r109, r110, r111};
        L14:
            return null;
        L12:
            e = move-exception;
            Log.e("SubsamplingScaleImageView", "Failed to initialise bitmap decoder", e);
            this.f426789m = e;
            goto L14
        }

        @Override // android.os.AsyncTask
        public final void onPostExecute(Object r110) {
            int[] r111 = (int[]) r110;
            SubsamplingScaleImageView r100 = this.f426784h.get();
            if (r100 == null) goto L56;
            rlb.d r101 = this.f426788l;
            if (r101 == null) goto L49;
            if (r111 == null) goto L49;
            if (r111.length != 3) goto L49;
            int r102 = r111[0];
            int r103 = r111[1];
            int r112 = r111[2];
            List<Integer> r104 = SubsamplingScaleImageView.f426691x2;
            monitor-enter(r100);
            r100.m("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", new Object[]{Integer.valueOf(r102), Integer.valueOf(r103), Integer.valueOf(r100.f426705h)});     // Catch: Throwable -> L45
            int r105 = r100.F;     // Catch: Throwable -> L45
            if (r105 <= 0) goto L28;
            int r106 = r100.G;     // Catch: Throwable -> L45
            if (r106 <= 0) goto L28;
            if (r105 != r102) goto L17;
            if (r106 == r103) goto L28;
        L17:
            r100.G(false);     // Catch: Throwable -> L45
            Bitmap r107 = r100.f426694a;     // Catch: Throwable -> L45
            if (r107 == null) goto L28;
            if (r100.f426698c == true) goto L22;
            r107.recycle();     // Catch: Throwable -> L45
        L22:
            r100.f426694a = null;     // Catch: Throwable -> L45
            h r108 = r100.f426706h1;     // Catch: Throwable -> L45
            if (r108 != null) goto L25;
        L27:
            r100.f426695b = false;     // Catch: Throwable -> L45
            r100.f426698c = false;     // Catch: Throwable -> L45
            goto L28
        L25:
            if (r100.f426698c == false) goto L27;
            r108.onPreviewReleased();     // Catch: Throwable -> L45
        L28:
            r100.Q = r101;     // Catch: Throwable -> L45
            r100.F = r102;     // Catch: Throwable -> L45
            r100.G = r103;     // Catch: Throwable -> L45
            r100.H = r112;     // Catch: Throwable -> L45
            r100.k();     // Catch: Throwable -> L45
            if (r100.j() == true) goto L42;
            int r113 = r100.f426715n;     // Catch: Throwable -> L45
            if (r113 <= 0) goto L42;
            if (r113 == Integer.MAX_VALUE) goto L42;
            int r114 = r100.f426716o;     // Catch: Throwable -> L45
            if (r114 <= 0) goto L42;
            if (r114 == Integer.MAX_VALUE) goto L42;
            if (r100.getWidth() <= 0) goto L42;
            if (r100.getHeight() <= 0) goto L42;
            r100.v(new Point(r100.f426715n, r100.f426716o));     // Catch: Throwable -> L45
        L42:
            r100.invalidate();     // Catch: Throwable -> L45
            r100.requestLayout();     // Catch: Throwable -> L45
            monitor-exit(r100);
            return;
        L45:
            th = move-exception;
            throw th;
        L49:
            if (this.f426789m == null) goto L57;
            h r115 = r100.f426706h1;
            if (r115 == null) goto L58;
            r115.b();
            return;
        L58:
            return;
        L57:
            return;
        }

        public p(SubsamplingScaleImageView r100, Context r101, rlb.b<? extends rlb.d> r102, Uri r103) {
            this.f426784h = new WeakReference(r100);
            this.f426785i = new WeakReference(r101);
            this.f426786j = new WeakReference(r102);
            this.f426787k = r103;
        }
    }

    static {
        f426691x2 = Arrays.asList(new Integer[]{0, 90, 180, 270, 2, 4, -1});
        f426692y2 = Arrays.asList(new Integer[]{1, 2, 3});
        E2 = Arrays.asList(new Integer[]{2, 1});
        F2 = Arrays.asList(new Integer[]{1, 2, 3});
        G2 = Arrays.asList(new Integer[]{2, 1, 3, 4});
    }

    public void B() {
        C(false);
    }

    public void f(Canvas r100) {
    }

    public void g(Canvas r100) {
    }

    public void setOnStateChangedListener(k r100) {
    }

    public void setScaleImageConfig(m r100) {
    }

    public Matrix getBitmapMatrix() {
        Matrix r100 = this.Q1;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new Matrix();
    }

    public RectF getContentRect() {
        if (this.f426734z != null) goto L5;
        return null;
    L5:
        if (getSWidth() > 0) goto L7;
        return null;
    L7:
        if (getSHeight() <= 0) goto L14;
        float r100 = getScale();
        float r101 = getSWidth() * r100;
        float r102 = getSHeight() * r100;
        PointF r103 = this.f426734z;
        float r104 = r103.x;
        float r105 = r103.y;
        return new RectF(r104, r105, r101 + r104, r102 + r105);
    L14:
        return null;
    }

    public Bitmap getImageBitmap() {
        Bitmap r100 = this.f426694a;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (CollectionUtils.isEmpty(this.f426701f) == true) goto L36;
        Iterator<List<n>> r101 = this.f426701f.values().iterator();     // Catch: Exception -> L21
    L9:
        if (r101.hasNext() == false) goto L37;
        Iterator<n> r102 = r101.next().iterator();     // Catch: Exception -> L21
    L12:
        if (r102.hasNext() == false) goto L9;
        n r103 = r102.next();     // Catch: Exception -> L21
        if (r103.f426777e == false) goto L12;
        Bitmap r104 = r103.f426775c;     // Catch: Exception -> L21
        if (r104 == null) goto L12;
        if (r104.isRecycled() == true) goto L12;
        return r103.f426775c;
    L37:
        return null;
    L21:
        e = move-exception;
        Log.e("SubsamplingScaleImageView", "Error getting bitmap from tiles", e);
        return null;
    L36:
        return null;
    }

    public Drawable getImageDrawable() {
        return new ukb.a(getContext().getResources(), this.f426694a);
    }

    public int getRequiredRotation() {
        int r100 = this.f426705h;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        return this.H;
    }

    public float getScaleFactor() {
        return 1.0f / getMinScale();
    }

    public final ImageViewState getState() {
        if (this.f426734z != null) goto L5;
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

    public RectF getVisibleTileRectOnView() {
        return new RectF(0.0f, 0.0f, getWidth(), getHeight());
    }

    public final boolean u() {
        if (this.f426699d == null) goto L5;
    L8:
        return true;
    L5:
        if (this.f426694a != null) goto L8;
        return false;
    }

    public final boolean w() {
        boolean r100 = true;
        if (this.f426694a != null) goto L5;
    L7:
        Map<Integer, List<n>> r101 = this.f426701f;
        if (r101 == null) goto L23;
        Iterator<Map.Entry<Integer, List<n>>> r102 = r101.entrySet().iterator();
    L11:
        if (r102.hasNext() == false) goto L22;
        Map.Entry<Integer, List<n>> r103 = r102.next();
        if (r103.getKey().intValue() != this.f426700e) goto L11;
        Iterator<n> r104 = r103.getValue().iterator();
    L16:
        if (r104.hasNext() == false) goto L11;
        n r105 = r104.next();
        if (r105.f426776d == true) goto L21;
        if (r105.f426775c != null) goto L16;
    L21:
        r100 = false;
        goto L16
    L22:
        return r100;
    L23:
        return false;
    L5:
        if (this.f426695b == true) goto L7;
        return true;
    }

    public final int H() {
        int r100 = getRequiredRotation();
        if (r100 == 90) goto L10;
        if (r100 == 270) goto L10;
        return this.G;
    L10:
        return this.F;
    }

    public final int I() {
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
        PointF r103 = this.f426734z;
        if (r103 != null) goto L5;
        return null;
    L5:
        float r104 = r100 - r103.x;
        float r105 = this.f426730x;
        r102.set(r104 / r105, (r101 - r103.y) / r105);
        return r102;
    }

    public float getMaximumScale() {
        return getMaxScale();
    }

    public final float getMinScale() {
        return x();
    }

    public float getMinimumScale() {
        return getMinScale();
    }

    public final boolean j() {
        boolean r100 = w();
        if (this.f426703g1 == true) goto L11;
        if (r100 == false) goto L11;
        B();
        this.f426703g1 = true;
        h r101 = this.f426706h1;
        if (r101 == null) goto L9;
        r101.onImageLoaded();
    L9:
        if (this.f426719p1 == null) goto L11;
        i(this.f426734z);
        this.f426719p1.a(this.f426720p2);
    L11:
        return r100;
    }

    public final boolean k() {
        if (getWidth() > 0) goto L5;
    L15:
        boolean r100 = false;
    L17:
        if (this.f426696b1 == true) goto L22;
        if (r100 == false) goto L22;
        B();
        this.f426696b1 = true;
        h r101 = this.f426706h1;
        if (r101 == null) goto L22;
        r101.onReady();
    L22:
        return r100;
    L5:
        if (getHeight() <= 0) goto L15;
        if (this.F <= 0) goto L15;
        if (this.G <= 0) goto L15;
        if (this.f426694a == null) goto L13;
    L14:
        r100 = true;
        goto L17
    L13:
        if (w() == false) goto L15;
        goto L14
    }

    public final float x() {
        int r100 = getPaddingBottom() + getPaddingTop();
        int r101 = getPaddingLeft() + getPaddingRight();
        int r102 = this.f426714m;
        if (r102 == 2) goto L15;
        if (r102 == 4) goto L15;
        if (r102 != 3) goto L13;
        float r103 = this.f426709j;
        if (r103 <= 0.0f) goto L13;
        return r103;
    L13:
        return Math.min((getWidth() - r101) / I(), (getHeight() - r100) / H());
    L15:
        return Math.max((getWidth() - r101) / I(), (getHeight() - r100) / H());
    }

    public static Bitmap.Config getPreferredBitmapConfig() {
        return H2;
    }

    public float getMaxScale() {
        return this.f426708i;
    }

    public j getOnSizeChangedStrategy() {
        return this.f426731x1;
    }

    public final int getOrientation() {
        return this.f426705h;
    }

    public final int getSHeight() {
        return this.G;
    }

    public final int getSWidth() {
        return this.F;
    }

    public final float getScale() {
        return this.f426730x;
    }

    public SubsamplingScaleImageView(Context r100) {
        this(r100, null);
    }

    public static DisplayMetrics a(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static /* synthetic */ void c(SubsamplingScaleImageView r100) {
        super.setOnLongClickListener(null);
    }

    public static void setPreferredBitmapConfig(Bitmap.Config r100) {
        H2 = r100;
    }

    public boolean A(MotionEvent r110) {
        int r100 = r110.getPointerCount();
        int r101 = r110.getAction();
        if (r101 == 0) goto L172;
        if (r101 == 1) goto L137;
        if (r101 == 2) goto L16;
        if (r101 != 5) goto L9;
    L173:
        this.V0 = null;
        F(true);
        this.N = Math.max(this.N, r100);
        if (r100 < 2) goto L181;
        if (this.f426723s == false) goto L178;
        float r102 = n(r110.getX(0), r110.getX(1), r110.getY(0), r110.getY(1));
        this.f426732y = this.f426730x;
        this.V = r102;
        PointF r103 = this.A;
        PointF r104 = this.f426734z;
        r103.set(r104.x, r104.y);
        this.U.set((r110.getX(0) + r110.getX(1)) / 2.0f, (r110.getY(0) + r110.getY(1)) / 2.0f);
    L179:
        this.f426733y1.removeMessages(1);
    L183:
        return true;
    L178:
        this.N = 0;
        goto L179
    L181:
        if (this.M == true) goto L183;
        PointF r105 = this.A;
        PointF r106 = this.f426734z;
        r105.set(r106.x, r106.y);
        this.U.set(r110.getX(), r110.getY());
        this.f426733y1.sendEmptyMessageDelayed(1, 600);
        goto L183
    L9:
        if (r101 != 6) goto L11;
    L145:
        this.f426733y1.removeMessages(1);
        if (this.M == false) goto L151;
        this.M = false;
        if (this.f426718p0 == true) goto L151;
        o(this.L0, this.U);
    L151:
        if (this.N <= 0) goto L169;
        boolean r107 = this.K;
        if (r107 == false) goto L155;
    L156:
        if (r107 == false) goto L163;
        if (r100 != 2) goto L163;
        this.L = true;
        PointF r108 = this.A;
        PointF r109 = this.f426734z;
        r108.set(r109.x, r109.y);
        if (r110.getActionIndex() != 1) goto L161;
        this.U.set(r110.getX(0), r110.getY(0));
        goto L163
    L161:
        this.U.set(r110.getX(1), r110.getY(1));
    L163:
        if (r100 >= 3) goto L165;
        this.K = false;
    L165:
        if (r100 >= 2) goto L167;
        this.L = false;
        this.N = 0;
    L167:
        E(true);
        return true;
    L155:
        if (this.L == true) goto L156;
    L169:
        if (r100 != 1) goto L171;
        this.K = false;
        this.L = false;
        this.N = 0;
    L171:
        return true;
    L11:
        if (r101 == 261) goto L173;
        if (r101 == 262) goto L145;
    L136:
        return false;
    L16:
        if (this.N > 0) goto L18;
    L132:
        boolean r111 = false;
    L133:
        if (r111 == false) goto L136;
        this.f426733y1.removeMessages(1);
        invalidate();
        return true;
    L18:
        if (r100 < 2) goto L47;
        float r112 = n(r110.getX(0), r110.getX(1), r110.getY(0), r110.getY(1));
        float r113 = (r110.getX(0) + r110.getX(1)) / 2.0f;
        float r114 = (r110.getY(0) + r110.getY(1)) / 2.0f;
        if (this.f426723s == false) goto L132;
        PointF r115 = this.U;
        if (n(r115.x, r113, r115.y, r114) <= 5.0f) goto L24;
    L27:
        this.K = true;
        this.L = true;
        double r116 = this.f426730x;
        float r117 = Math.min(this.f426708i, (r112 / this.V) * this.f426732y);
        this.f426730x = r117;
        if (r117 > x()) goto L31;
        this.V = r112;
        this.f426732y = x();
        this.U.set(r113, r114);
        this.A.set(this.f426734z);
    L45:
        r(true);
        E(this.f426721q);
    L131:
        r111 = true;
        goto L133
    L31:
        if (this.f426722r == false) goto L42;
        PointF r118 = this.U;
        float r119 = r118.x;
        PointF r120 = this.A;
        float r121 = r119 - r120.x;
        float r122 = r118.y - r120.y;
        float r123 = this.f426730x / this.f426732y;
        float r124 = r121 * r123;
        float r125 = r122 * r123;
        PointF r126 = this.f426734z;
        r126.x = r113 - r124;
        r126.y = r114 - r125;
        if ((((double) H()) * r116) >= getHeight()) goto L37;
        if ((this.f426730x * H()) < getHeight()) goto L37;
    L40:
        r(true);
        this.U.set(r113, r114);
        this.A.set(this.f426734z);
        this.f426732y = this.f426730x;
        this.V = r112;
    L37:
        if ((r116 * ((double) I())) >= getWidth()) goto L45;
        if ((this.f426730x * I()) < getWidth()) goto L45;
    L42:
        if (this.E == null) goto L44;
        this.f426734z.x = (getWidth() / 2) - (this.f426730x * this.E.x);
        this.f426734z.y = (getHeight() / 2) - (this.f426730x * this.E.y);
        goto L45
    L44:
        this.f426734z.x = (getWidth() / 2) - (this.f426730x * (I() / 2));
        this.f426734z.y = (getHeight() / 2) - (this.f426730x * (H() / 2));
        goto L45
    L24:
        if (Math.abs(r112 - this.V) > 5.0f) goto L27;
        if (this.L == false) goto L132;
    L47:
        if (this.M == false) goto L81;
        float r127 = (Math.abs(this.P0.y - r110.getY()) * 2.0f) + this.W;
        if (this.f426711k0 != (-1.0f)) goto L51;
        this.f426711k0 = r127;
    L51:
        float r128 = r110.getY();
        PointF r129 = this.H0;
        if (r128 <= r129.y) goto L54;
        boolean r130 = true;
    L55:
        r129.set(0.0f, r110.getY());
        float r131 = 1.0f;
        float r132 = Math.abs(1.0f - (r127 / this.f426711k0)) * 0.5f;
        if (r132 <= 0.03f) goto L58;
    L59:
        this.f426718p0 = true;
        if (this.f426711k0 <= 0.0f) goto L64;
        if (r130 == false) goto L63;
        r131 = 1.0f + r132;
        goto L64
    L63:
        r131 = 1.0f - r132;
    L64:
        double r133 = this.f426730x;
        float r134 = Math.max(x(), Math.min(this.f426708i, this.f426730x * r131));
        this.f426730x = r134;
        if (this.f426722r == false) goto L76;
        PointF r135 = this.U;
        float r136 = r135.x;
        PointF r137 = this.A;
        float r138 = r136 - r137.x;
        float r139 = r135.y;
        float r140 = r139 - r137.y;
        float r141 = r134 / this.f426732y;
        float r142 = r138 * r141;
        float r143 = r140 * r141;
        PointF r144 = this.f426734z;
        r144.x = r136 - r142;
        r144.y = r139 - r143;
        if ((((double) H()) * r133) >= getHeight()) goto L71;
        if ((this.f426730x * H()) < getHeight()) goto L71;
    L74:
        r(true);
        this.U.set(N(this.L0));
        this.A.set(this.f426734z);
        this.f426732y = this.f426730x;
        r127 = 0.0f;
    L79:
        this.f426711k0 = r127;
        r(true);
        E(this.f426721q);
    L71:
        if ((r133 * ((double) I())) >= getWidth()) goto L79;
        if ((this.f426730x * I()) < getWidth()) goto L79;
    L76:
        if (this.E == null) goto L78;
        this.f426734z.x = (getWidth() / 2) - (this.f426730x * this.E.x);
        this.f426734z.y = (getHeight() / 2) - (this.f426730x * this.E.y);
        goto L79
    L78:
        this.f426734z.x = (getWidth() / 2) - (this.f426730x * (I() / 2));
        this.f426734z.y = (getHeight() / 2) - (this.f426730x * (H() / 2));
        goto L79
    L58:
        if (this.f426718p0 == false) goto L79;
    L54:
        r130 = false;
        goto L55
    L81:
        if (this.K == true) goto L132;
        float r145 = Math.abs(r110.getX() - this.U.x);
        float r146 = Math.abs(r110.getY() - this.U.y);
        float r147 = this.f426697b2 * 5.0f;
        if (r145 <= r147) goto L85;
    L88:
        this.f426734z.x = this.A.x + (r110.getX() - this.U.x);
        this.f426734z.y = this.A.y + (r110.getY() - this.U.y);
        PointF r148 = this.f426734z;
        float r149 = r148.x;
        float r150 = r148.y;
        r(true);
        PointF r151 = this.f426734z;
        if (r149 == r151.x) goto L91;
        boolean r152 = true;
    L92:
        float r153 = r151.y;
        if (r150 == r153) goto L95;
        boolean r154 = true;
    L96:
        if (r152 == true) goto L98;
    L102:
        boolean r155 = false;
    L103:
        if (r154 == true) goto L105;
    L109:
        boolean r156 = false;
    L110:
        if (r150 == r153) goto L112;
    L114:
        boolean r157 = false;
    L115:
        if (r155 == true) goto L123;
        if (r156 == true) goto L123;
        if (r152 == false) goto L122;
        if (r154 == false) goto L122;
        if (r157 == true) goto L122;
        if (this.L == false) goto L123;
    L122:
        this.L = true;
    L128:
        if (this.f426722r == true) goto L130;
        PointF r158 = this.f426734z;
        PointF r159 = this.A;
        r158.x = r159.x;
        r158.y = r159.y;
        F(false);
    L130:
        E(this.f426721q);
    L123:
        if (r145 <= r147) goto L125;
    L126:
        this.N = 0;
        this.f426733y1.removeMessages(1);
        F(false);
        goto L128
    L125:
        if (r146 <= r147) goto L128;
    L112:
        if (r146 <= (3.0f * r147)) goto L114;
        r157 = true;
        goto L115
    L105:
        if (r146 <= r145) goto L109;
        if (this.L == true) goto L109;
        r156 = true;
        goto L110
    L98:
        if (r145 <= r146) goto L102;
        if (this.L == true) goto L102;
        r155 = true;
        goto L103
    L95:
        r154 = false;
        goto L96
    L91:
        r152 = false;
        goto L92
    L85:
        if (r146 > r147) goto L88;
        if (this.L == false) goto L132;
    L137:
        float r160 = getScale();
        if (this.f426712k1 == null) goto L145;
        if (Math.abs(r160 - this.f426707h2) >= 1.0E-8f) goto L142;
        boolean r161 = true;
    L143:
        if (r161 == true) goto L145;
        this.f426712k1.a(this.f426707h2, r160, OnScaleEventListener.ScaleCause.GESTURE);
        goto L145
    L142:
        r161 = false;
        goto L143
    L172:
        this.f426707h2 = getScale();
        goto L173
    }

    public final void C(boolean r100) {
        if (getWidth() != 0) goto L5;
        return;
    L5:
        if (getHeight() != 0) goto L7;
        return;
    L7:
        if (this.F > 0) goto L9;
        return;
    L9:
        if (this.G <= 0) goto L25;
        PointF r101 = this.D;
        Float r102 = this.C;
        if (r101 == null) goto L18;
        if (r102 == null) goto L18;
        this.f426730x = r102.floatValue();
        if (this.f426734z != null) goto L17;
        this.f426734z = new PointF();
    L17:
        this.f426734z.x = (getWidth() / 2.0f) - (this.f426730x * r101.x);
        this.f426734z.y = (getHeight() / 2.0f) - (this.f426730x * r101.y);
        this.D = null;
        this.C = null;
        r(true);
        E(true);
    L18:
        if (r100 == true) goto L26;
        r(false);
        return;
    L26:
        return;
    }

    public final int D(int r100) {
        return (int) (this.f426697b2 * r100);
    }

    public final void E(boolean r110) {
        if (this.Q != null) goto L5;
        return;
    L5:
        if (this.f426701f == null) goto L87;
        int r100 = Math.min(this.f426700e, h(this.f426730x));
        Iterator r101 = ((LinkedHashMap) this.f426701f).entrySet().iterator();
    L9:
        if (r101.hasNext() == false) goto L88;
        Iterator r102 = ((List) ((Map.Entry) r101.next()).getValue()).iterator();
    L12:
        if (r102.hasNext() == false) goto L9;
        n r103 = (n) r102.next();
        int r104 = r103.f426774b;
        if (r104 < r100) goto L18;
        if (r104 > r100) goto L17;
    L21:
        int r105 = r103.f426774b;
        if (r105 == r100) goto L23;
        if (r105 != this.f426700e) goto L12;
        r103.f426777e = true;
        goto L12
    L23:
        RectF r106 = getVisibleTileRectOnView();
        float r107 = r106.left;
        PointF r108 = this.f426734z;
        float r111 = Float.NaN;
        if (r108 != null) goto L26;
        float r109 = Float.NaN;
    L27:
        float r112 = r106.right;
        if (r108 != null) goto L30;
        float r113 = Float.NaN;
    L31:
        float r114 = r106.top;
        if (r108 != null) goto L34;
        float r115 = Float.NaN;
    L35:
        float r116 = r106.bottom;
        if (r108 == null) goto L39;
        r111 = (r116 - r108.y) / this.f426730x;
    L39:
        Rect r117 = r103.f426773a;
        if (r109 <= r117.right) goto L42;
    L48:
        boolean r118 = false;
    L49:
        if (r118 == true) goto L50;
        if (r103.f426774b == this.f426700e) goto L12;
        r103.f426777e = false;
        Bitmap r119 = r103.f426775c;
        if (r119 == null) goto L12;
        r119.recycle();
        r103.f426775c = null;
        goto L12
    L50:
        r103.f426777e = true;
        if (r103.f426776d == true) goto L12;
        if (r103.f426775c != null) goto L12;
        if (r110 == false) goto L12;
        new o(this, this.Q, r103).executeOnExecutor(this.f426717p, new Void[0]);
        goto L12
    L42:
        if (r117.left > r113) goto L48;
        if (r115 > r117.bottom) goto L48;
        if (r117.top > r111) goto L48;
        r118 = true;
        goto L49
    L34:
        r115 = (r114 - r108.y) / this.f426730x;
        goto L35
    L30:
        r113 = (r112 - r108.x) / this.f426730x;
        goto L31
    L26:
        r109 = (r107 - r108.x) / this.f426730x;
        goto L27
    L17:
        if (r104 == this.f426700e) goto L21;
    L18:
        r103.f426777e = false;
        Bitmap r120 = r103.f426775c;
        if (r120 == null) goto L21;
        r120.recycle();
        r103.f426775c = null;
        goto L21
    L88:
        return;
    }

    public final void F(boolean r100) {
        ViewParent r101 = getParent();
        if (r101 == null) goto L6;
        r101.requestDisallowInterceptTouchEvent(r100);
        return;
    }

    public final void G(boolean r100) {
        m("reset newImage=" + r100, new Object[0]);
        this.f426730x = 0.0f;
        this.f426732y = 0.0f;
        this.f426734z = null;
        this.A = null;
        this.B = null;
        this.C = Float.valueOf(0.0f);
        this.D = null;
        this.E = null;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = 0;
        this.f426700e = 0;
        this.U = null;
        this.V = 0.0f;
        this.f426711k0 = 0.0f;
        this.f426718p0 = false;
        this.L0 = null;
        this.H0 = null;
        this.P0 = null;
        this.V0 = null;
        this.P1 = null;
        this.Q1 = null;
        this.S1 = null;
        if (r100 == false) goto L27;
        this.f426699d = null;
        Log.w("SubsamplingScaleImageView", ThreadMethodProxy.currentThread().getName() + ", try getLock:start");
        boolean r101 = ((ReentrantReadWriteLock) this.R).writeLock().tryLock();
        Log.w("SubsamplingScaleImageView", ThreadMethodProxy.currentThread().getName() + ", getLock: success");
        if (r101 == true) goto L41;
        Log.w("SubsamplingScaleImageView", ThreadMethodProxy.currentThread().getName() + ", getLock: Failed!");
    L14:
        Bitmap r102 = this.f426694a;
        if (r102 == null) goto L20;
        if (this.f426698c == true) goto L20;
        r102.recycle();
    L20:
        if (this.f426694a != null) goto L22;
    L26:
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = null;
        this.f426693J = null;
        this.f426696b1 = false;
        this.f426703g1 = false;
        this.f426694a = null;
        this.f426695b = false;
        this.f426698c = false;
        goto L27
    L22:
        if (this.f426698c == false) goto L26;
        h r103 = this.f426706h1;
        if (r103 == null) goto L26;
        r103.onPreviewReleased();
        goto L26
    L41:
        rlb.d r104 = this.Q;     // Catch: Throwable -> L10
        if (r104 == null) goto L9;
        r104.recycle();     // Catch: Throwable -> L10
        this.Q = null;     // Catch: Throwable -> L10
    L9:
        Log.w("SubsamplingScaleImageView", ThreadMethodProxy.currentThread().getName() + ", try freed writeLock:start");
        ((ReentrantReadWriteLock) this.R).writeLock().unlock();
        Log.w("SubsamplingScaleImageView", ThreadMethodProxy.currentThread().getName() + ", freed writeLock success");
    L10:
        th = move-exception;
        Log.w("SubsamplingScaleImageView", ThreadMethodProxy.currentThread().getName() + ", try freed writeLock:start");
        ((ReentrantReadWriteLock) this.R).writeLock().unlock();
        Log.w("SubsamplingScaleImageView", ThreadMethodProxy.currentThread().getName() + ", freed writeLock success");
        throw th;
    L27:
        Map<Integer, List<n>> r105 = this.f426701f;
        if (r105 == null) goto L39;
        Iterator<Map.Entry<Integer, List<n>>> r106 = r105.entrySet().iterator();
    L31:
        if (r106.hasNext() == false) goto L38;
        Iterator<n> r107 = r106.next().getValue().iterator();
    L34:
        if (r107.hasNext() == false) goto L31;
        n r108 = r107.next();
        r108.f426777e = false;
        Bitmap r109 = r108.f426775c;
        if (r109 == null) goto L34;
        r109.recycle();
        r108.f426775c = null;
        goto L34
    L38:
        this.f426701f = null;
    L39:
        setGestureDetector(getContext());
    }

    public final PointF N(PointF r100) {
        float r101 = r100.x;
        float r102 = r100.y;
        PointF r103 = new PointF();
        if (this.f426734z != null) goto L5;
        return null;
    L5:
        r103.set(O(r101), P(r102));
        return r103;
    }

    public final float O(float r100) {
        PointF r101 = this.f426734z;
        if (r101 != null) goto L7;
        return Float.NaN;
    L7:
        return (r100 * this.f426730x) + r101.x;
    }

    public final float P(float r100) {
        if (this.f426734z != null) goto L6;
        return Float.NaN;
    L6:
        Log.i("SubsamplingScaleImageView", "source to view scale y: " + this.f426730x);
        return (r100 * this.f426730x) + this.f426734z.y;
    }

    public final PointF R(PointF r100) {
        float r101 = r100.x;
        float r102 = r100.y;
        PointF r103 = new PointF();
        PointF r104 = this.f426734z;
        if (r104 != null) goto L5;
        return null;
    L5:
        float r105 = r101 - r104.x;
        float r106 = this.f426730x;
        r103.set(r105 / r106, (r102 - r104.y) / r106);
        return r103;
    }

    public final int h(float r100) {
        if (this.f426710k <= 0) goto L5;
        DisplayMetrics r101 = a(getResources());
        r100 = r100 * (this.f426710k / ((r101.xdpi + r101.ydpi) / 2.0f));
    L5:
        int r102 = (int) (I() * r100);
        int r103 = (int) (H() * r100);
        if (r102 == 0) goto L23;
        if (r103 == 0) goto L27;
        int r104 = 1;
        if (H() <= r103) goto L12;
    L15:
        int r105 = Math.round(H() / r103);
        int r106 = Math.round(I() / r102);
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
        if (I() > r102) goto L15;
        r105 = 1;
        goto L19
    L27:
        return 32;
    L23:
        return 32;
    }

    public final void i(PointF r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        RectF r101 = this.f426720p2;
        r101.left = r100.x;
        r101.top = r100.y;
        if (getRequiredRotation() != 90) goto L7;
    L10:
        RectF r102 = this.f426720p2;
        float r103 = r100.x;
        float r104 = this.G;
        float r105 = this.f426730x;
        r102.right = r103 + (r104 * r105);
        r102.bottom = r100.y + (this.F * r105);
        return;
    L7:
        if (getRequiredRotation() == 270) goto L10;
        RectF r106 = this.f426720p2;
        float r107 = r100.x;
        float r108 = this.F;
        float r109 = this.f426730x;
        r106.right = r107 + (r108 * r109);
        r106.bottom = r100.y + (this.G * r109);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        this.f426734z = new PointF(0.0f, 0.0f);
        post(new qlb.b(this));
    }

    @Override // android.view.View
    public final void onDraw(Canvas r310) {
        long r100 = System.currentTimeMillis();
        super.onDraw(r310);
        if (this.G1 != null) goto L6;
        Paint r101 = new Paint();
        this.G1 = r101;
        r101.setAntiAlias(true);
        this.G1.setFilterBitmap(true);
        this.G1.setDither(true);
    L6:
        if (this.H1 == null) goto L10;
        if (this.L1 == null) goto L10;
    L13:
        if (this.F != 0) goto L15;
        return;
    L15:
        if (this.G != 0) goto L17;
        return;
    L17:
        if (getWidth() != 0) goto L19;
        return;
    L19:
        if (getHeight() != 0) goto L22;
        return;
    L22:
        if (this.f426701f != null) goto L27;
        if (this.Q == null) goto L27;
        v(new Point(Math.min(r310.getMaximumBitmapWidth(), this.f426715n), Math.min(r310.getMaximumBitmapHeight(), this.f426716o)));
    L27:
        if (k() == true) goto L29;
        return;
    L29:
        B();
        e r102 = this.V0;
        if (r102 == null) goto L55;
        if (r102.f426746f == null) goto L55;
        Log.i("SubsamplingScaleImageView", "anim and vFocusStart is not null");
        float r103 = this.f426730x;
        if (this.B != null) goto L36;
        this.B = new PointF(0.0f, 0.0f);
    L36:
        this.B.set(this.f426734z);
        long r110 = System.currentTimeMillis();
        e r111 = this.V0;
        long r112 = r110 - r111.f426752l;
        long r113 = r111.f426748h;
        if (r112 <= r113) goto L39;
        boolean r114 = true;
    L40:
        long r115 = Math.min(r112, r113);
        e r116 = this.V0;
        int r117 = r116.f426750j;
        float r118 = r116.f426741a;
        this.f426730x = p(r117, r115, r118, r116.f426742b - r118, r116.f426748h);
        e r104 = this.V0;
        int r119 = r104.f426750j;
        float r105 = r104.f426746f.x;
        float r106 = p(r119, r115, r105, r104.f426747g.x - r105, r104.f426748h);
        e r107 = this.V0;
        int r120 = r107.f426750j;
        float r121 = r107.f426746f.y;
        float r108 = p(r120, r115, r121, r107.f426747g.y - r121, r107.f426748h);
        this.f426734z.x -= O(this.V0.f426744d.x) - r106;
        this.f426734z.y -= P(this.V0.f426744d.y) - r108;
        e r109 = this.V0;
        if (r109.f426753m == true) goto L50;
        if (r114 == false) goto L45;
    L48:
        boolean r122 = true;
    L49:
        r(r122);
        goto L50
    L45:
        if (r109.f426741a == r109.f426742b) goto L48;
        r122 = false;
    L50:
        PointF r123 = this.B;
        int r124 = this.V0.f426751k;
        J(r103, r123);
        E(r114);
        if (r114 == false) goto L53;
        this.V0.getClass();
        this.V0 = null;
    L53:
        invalidate();
        goto L55
    L39:
        r114 = false;
    L55:
        g(r310);
        if (this.f426701f != null) goto L58;
    L161:
        Bitmap r125 = this.f426694a;
        if (r125 != null) goto L164;
    L216:
        f(r310);
        if (this.f426702g == false) goto L233;
        StringBuilder r126 = new StringBuilder("Scale: ");
        Locale r127 = Locale.ENGLISH;
        r126.append(String.format(r127, "%.2f", new Object[]{Float.valueOf(this.f426730x)}));
        r126.append(" (");
        r126.append(String.format(r127, "%.2f", new Object[]{Float.valueOf(x())}));
        r126.append(" - ");
        r126.append(String.format(r127, "%.2f", new Object[]{Float.valueOf(this.f426708i)}));
        r126.append(")");
        r310.drawText(r126.toString(), D(5), D(15), this.H1);
        r310.drawText("Translate: " + String.format(r127, "%.2f", new Object[]{Float.valueOf(this.f426734z.x)}) + ":" + String.format(r127, "%.2f", new Object[]{Float.valueOf(this.f426734z.y)}), D(5), D(30), this.H1);
        PointF r128 = getCenter();
        r310.drawText("Source center: " + String.format(r127, "%.2f", new Object[]{Float.valueOf(r128.x)}) + ":" + String.format(r127, "%.2f", new Object[]{Float.valueOf(r128.y)}), D(5), D(45), this.H1);
        e r129 = this.V0;
        if (r129 == null) goto L222;
        PointF r130 = N(r129.f426743c);
        PointF r131 = N(this.V0.f426745e);
        PointF r132 = N(this.V0.f426744d);
        r310.drawCircle(r130.x, r130.y, D(10), this.L1);
        this.L1.setColor(-65536);
        r310.drawCircle(r131.x, r131.y, D(20), this.L1);
        this.L1.setColor(FakePickerAvatarCreator.BLUE);
        r310.drawCircle(r132.x, r132.y, D(25), this.L1);
        this.L1.setColor(FakePickerAvatarCreator.CYAN);
        r310.drawCircle(getWidth() / 2, getHeight() / 2, D(30), this.L1);
    L222:
        if (this.U == null) goto L225;
        this.L1.setColor(-65536);
        PointF r133 = this.U;
        r310.drawCircle(r133.x, r133.y, D(20), this.L1);
    L225:
        if (this.L0 == null) goto L228;
        this.L1.setColor(FakePickerAvatarCreator.BLUE);
        r310.drawCircle(O(this.L0.x), P(this.L0.y), D(35), this.L1);
    L228:
        if (this.P0 != null) goto L230;
    L232:
        this.L1.setColor(FakePickerAvatarCreator.MAGENTA);
        goto L233
    L230:
        if (this.M == false) goto L232;
        this.L1.setColor(FakePickerAvatarCreator.CYAN);
        PointF r134 = this.P0;
        r310.drawCircle(r134.x, r134.y, D(30), this.L1);
    L233:
        plb.a r135 = this.f426704g2;
        if (r135 == null) goto L236;
        r135.b(r310);
    L236:
        Log.i("SubsamplingScaleImageView", "onDraw finish, costTime:" + (System.currentTimeMillis() - r100));
        return;
    L164:
        if (r125.isRecycled() == true) goto L216;
        float r136 = this.f426730x;
        if (this.f426695b == false) goto L168;
        r136 = r136 * (this.F / this.f426694a.getWidth());
        float r137 = this.f426730x * (this.G / this.f426694a.getHeight());
    L170:
        if (this.Q1 != null) goto L172;
        this.Q1 = new Matrix();
    L172:
        this.Q1.reset();
        if (this.f426695b == false) goto L175;
    L180:
        this.Q1.postScale(r136, r137);
        if (getRequiredRotation() != 90) goto L183;
    L186:
        this.Q1.postRotate(getRequiredRotation());
    L187:
        Matrix r138 = this.Q1;
        PointF r139 = this.f426734z;
        r138.postTranslate(r139.x, r139.y);
        if (getRequiredRotation() != 180) goto L191;
        Matrix r140 = this.Q1;
        float r141 = this.f426730x;
        r140.postTranslate(this.F * r141, r141 * this.G);
    L197:
        if (this.M1 != null) goto L199;
    L215:
        r310.drawBitmap(this.f426694a, this.Q1, this.G1);
        goto L216
    L199:
        if (this.S1 != null) goto L201;
        this.S1 = new RectF();
    L201:
        RectF r142 = this.S1;
        if (this.f426695b == false) goto L204;
        int r143 = this.f426694a.getWidth();
    L205:
        float r144 = r143;
        if (this.f426695b == false) goto L208;
        int r145 = this.f426694a.getHeight();
    L209:
        r142.set(0.0f, 0.0f, r144, r145);
        this.Q1.mapRect(this.S1);
        r310.drawRect(this.S1, this.M1);
        plb.a r146 = this.f426704g2;
        if (r146 == null) goto L215;
        RectF r147 = this.S1;
        int r148 = plb.a.f529807e;
        Log.i("ILargeImageViewPlusProvider", "updateContentRect, bitmapRectF:" + r147);
        if (r147 == null) goto L214;
        r146.f529810c.set(r147);
    L214:
        Region r149 = r146.f529811d;
        RectF r150 = r146.f529810c;
        r149.set((int) r150.left, (int) r150.top, (int) r150.right, (int) r150.bottom);
        Log.i("ILargeImageViewPlusProvider", "updateContentRect, bitmap result:" + r146.f529810c);
        r146.e();
        goto L215
    L208:
        r145 = this.G;
        goto L209
    L204:
        r143 = this.F;
        goto L205
    L191:
        if (getRequiredRotation() != 90) goto L194;
        this.Q1.postTranslate(this.f426730x * this.G, 0.0f);
        goto L197
    L194:
        if (getRequiredRotation() != 270) goto L197;
        this.Q1.postTranslate(0.0f, this.f426730x * this.F);
        goto L197
    L183:
        if (getRequiredRotation() == 180) goto L186;
        if (getRequiredRotation() != 270) goto L187;
    L175:
        if (getRequiredRotation() != 4) goto L178;
        this.Q1.postScale(1.0f, -1.0f, this.f426694a.getWidth() / 2.0f, this.f426694a.getHeight() / 2.0f);
        goto L180
    L178:
        if (getRequiredRotation() != 2) goto L180;
        this.Q1.postScale(-1.0f, 1.0f, this.f426694a.getWidth() / 2.0f, this.f426694a.getHeight() / 2.0f);
        goto L180
    L168:
        r137 = r136;
        goto L170
    L58:
        if (w() == false) goto L161;
        int r151 = Math.min(this.f426700e, h(this.f426730x));
        Iterator r152 = ((LinkedHashMap) this.f426701f).entrySet().iterator();
        boolean r153 = false;
    L61:
        if (r152.hasNext() == false) goto L74;
        Map.Entry r154 = (Map.Entry) r152.next();
        if (((Integer) r154.getKey()).intValue() != r151) goto L61;
        Iterator r155 = ((List) r154.getValue()).iterator();
    L66:
        if (r155.hasNext() == false) goto L61;
        n r156 = (n) r155.next();
        if (r156.f426777e == false) goto L66;
        if (r156.f426776d == true) goto L73;
        if (r156.f426775c != null) goto L66;
    L73:
        r153 = true;
        goto L66
    L74:
        Iterator r157 = ((LinkedHashMap) this.f426701f).entrySet().iterator();
        int r158 = -1;
    L76:
        if (r157.hasNext() == false) goto L216;
        Map.Entry r159 = (Map.Entry) r157.next();
        if (((Integer) r159.getKey()).intValue() == r151) goto L82;
        if (r153 == true) goto L82;
    L160:
        r151 = r151;
    L82:
        Iterator r160 = ((List) r159.getValue()).iterator();
    L84:
        if (r160.hasNext() == false) goto L160;
        n r161 = (n) r160.next();
        Rect r162 = r161.f426773a;
        r161.f426778f.set((int) O(r162.left), (int) P(r162.top), (int) O(r162.right), (int) P(r162.bottom));
        r158 = r158 + 1;
        plb.a r163 = this.f426704g2;
        if (r163 == null) goto L125;
        if (r158 != 0) goto L89;
        boolean r164 = true;
    L90:
        Rect r165 = t(r161);
        int r166 = plb.a.f529807e;
        Log.i("ILargeImageViewPlusProvider", "updateContentRect, first:" + r164 + ",tileRect:" + r165);
        if (r164 == false) goto L93;
        r163.f529810c.set(r163.f529809b);
    L93:
        if (r165 == null) goto L123;
        RectF r167 = r163.f529810c;
        float r168 = r167.left;
        if (r168 != 2.1474836E9f) goto L97;
        boolean r210 = true;
    L98:
        if (r210 == true) goto L100;
        float r169 = RangesKt.coerceAtMost(r168, r165.left);
    L101:
        r167.left = r169;
        RectF r170 = r163.f529810c;
        float r171 = r170.top;
        if (r171 != 2.1474836E9f) goto L104;
        boolean r172 = true;
    L105:
        if (r172 == true) goto L107;
        float r173 = RangesKt.coerceAtMost(r171, r165.top);
    L108:
        r170.top = r173;
        RectF r174 = r163.f529810c;
        float r175 = r174.right;
        if (r175 != 2.1474836E9f) goto L111;
        boolean r176 = true;
    L112:
        if (r176 == true) goto L114;
        float r177 = RangesKt.coerceAtLeast(r175, r165.right);
    L115:
        r174.right = r177;
        RectF r178 = r163.f529810c;
        float r179 = r178.bottom;
        if (r179 != 2.1474836E9f) goto L118;
        boolean r180 = true;
    L119:
        float r181 = r165.bottom;
        if (r180 == true) goto L122;
        r181 = RangesKt.coerceAtLeast(r179, r181);
    L122:
        r178.bottom = r181;
        goto L123
    L118:
        r180 = false;
        goto L119
    L114:
        r177 = r165.right;
        goto L115
    L111:
        r176 = false;
        goto L112
    L107:
        r173 = r165.top;
        goto L108
    L104:
        r172 = false;
        goto L105
    L100:
        r169 = r165.left;
        goto L101
    L97:
        r210 = false;
    L123:
        Region r182 = r163.f529811d;
        RectF r183 = r163.f529810c;
        r182.set((int) r183.left, (int) r183.top, (int) r183.right, (int) r183.bottom);
        Log.i("ILargeImageViewPlusProvider", "updateContentRect, tile result:" + r163.f529810c);
        r163.e();
        goto L125
    L89:
        r164 = false;
    L125:
        boolean r184 = r161.f426776d;
        if (r184 == false) goto L128;
    L150:
        if (r184 == true) goto L152;
    L155:
        if (r161.f426777e == false) goto L159;
        if (this.f426702g == false) goto L159;
        r310.drawText("ISS " + r161.f426774b + " RECT " + r161.f426773a.top + "," + r161.f426773a.left + "," + r161.f426773a.bottom + "," + r161.f426773a.right, r161.f426778f.left + D(5), r161.f426778f.top + D(15), this.H1);
    L159:
        r151 = r151;
        goto L84
    L152:
        if (this.f426702g == false) goto L155;
        r310.drawText("LOADING", r161.f426778f.left + D(5), r161.f426778f.top + D(35), this.H1);
        goto L155
    L128:
        if (r161.f426775c == null) goto L150;
        Paint r185 = this.M1;
        if (r185 == null) goto L133;
        r310.drawRect(r161.f426778f, r185);
    L133:
        if (this.Q1 != null) goto L135;
        this.Q1 = new Matrix();
    L135:
        this.Q1.reset();
        L(this.T1, 0.0f, 0.0f, r161.f426775c.getWidth(), 0.0f, r161.f426775c.getWidth(), r161.f426775c.getHeight(), 0.0f, r161.f426775c.getHeight());
        if (getRequiredRotation() != 0) goto L139;
        float[] r186 = this.V1;
        Rect r187 = r161.f426778f;
        float r188 = r187.left;
        float r189 = r187.top;
        float r190 = r187.right;
        float r191 = r187.bottom;
        L(r186, r188, r189, r190, r189, r190, r191, r188, r191);
    L147:
        this.Q1.setPolyToPoly(this.T1, 0, this.V1, 0, 4);
        r310.drawBitmap(r161.f426775c, this.Q1, this.G1);
        if (this.f426702g == false) goto L155;
        r310.drawRect(r161.f426778f, this.L1);
        goto L155
    L139:
        if (getRequiredRotation() != 90) goto L142;
        float[] r192 = this.V1;
        Rect r193 = r161.f426778f;
        float r194 = r193.right;
        float r195 = r193.top;
        float r196 = r193.bottom;
        float r197 = r193.left;
        L(r192, r194, r195, r194, r196, r197, r196, r197, r195);
        goto L147
    L142:
        if (getRequiredRotation() != 180) goto L145;
        float[] r198 = this.V1;
        Rect r199 = r161.f426778f;
        float r200 = r199.right;
        float r1100 = r199.bottom;
        float r1101 = r199.left;
        float r201 = r199.top;
        L(r198, r200, r1100, r1101, r1100, r1101, r201, r200, r201);
        goto L147
    L145:
        if (getRequiredRotation() != 270) goto L147;
        float[] r202 = this.V1;
        Rect r203 = r161.f426778f;
        float r204 = r203.left;
        float r1102 = r203.bottom;
        float r1103 = r203.top;
        float r205 = r203.right;
        L(r202, r204, r1102, r204, r1103, r205, r1103, r205, r1102);
    L10:
        if (this.f426702g == false) goto L13;
        Paint r206 = new Paint();
        this.H1 = r206;
        r206.setTextSize(D(12));
        this.H1.setColor(FakePickerAvatarCreator.MAGENTA);
        this.H1.setStyle(Paint.Style.FILL);
        Paint r207 = new Paint();
        this.L1 = r207;
        r207.setColor(FakePickerAvatarCreator.MAGENTA);
        this.L1.setStyle(Paint.Style.STROKE);
        this.L1.setStrokeWidth(D(1));
        goto L13
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        this.f426728v2.onTouchEvent(r100);
        plb.a r101 = this.f426704g2;
        if (r101 == null) goto L49;
        if (r101.c(r100) == false) goto L49;
        return true;
    L49:
        e r102 = this.V0;     // Catch: Exception -> L46
        if (r102 != null) goto L11;
    L14:
        this.V0 = null;     // Catch: Exception -> L46
        if (this.f426734z != null) goto L21;
        GestureDetector r103 = this.P;     // Catch: Exception -> L46
        if (r103 == null) goto L19;
        r103.onTouchEvent(r100);     // Catch: Exception -> L46
    L19:
        return true;
    L21:
        if (this.M == true) goto L29;
        GestureDetector r104 = this.O;     // Catch: Exception -> L46
        if (r104 != null) goto L25;
    L26:
        this.K = false;     // Catch: Exception -> L46
        this.L = false;     // Catch: Exception -> L46
        this.N = 0;     // Catch: Exception -> L46
        return true;
    L25:
        if (r104.onTouchEvent(r100) == true) goto L26;
    L29:
        if (this.A != null) goto L32;
        this.A = new PointF(0.0f, 0.0f);     // Catch: Exception -> L46
    L32:
        if (this.B != null) goto L35;
        this.B = new PointF(0.0f, 0.0f);     // Catch: Exception -> L46
    L35:
        if (this.U != null) goto L37;
        this.U = new PointF(0.0f, 0.0f);     // Catch: Exception -> L46
    L37:
        float r105 = this.f426730x;     // Catch: Exception -> L46
        PointF r106 = this.f426734z;     // Catch: Exception -> L46
        if (r106 == null) goto L50;
        this.B.set(r106);     // Catch: Exception -> L46
        boolean r107 = A(r100);     // Catch: Exception -> L46
        J(r105, this.B);     // Catch: Exception -> L46
        if (r107 == false) goto L42;
        return true;
    L42:
        if (super.onTouchEvent(r100) == true) goto L52;
        return false;
    L52:
        return true;
    L50:
        return true;
    L11:
        if (r102.f426749i == true) goto L14;
        F(true);     // Catch: Exception -> L46
        return true;
    L46:
        e = move-exception;
        Log.e("SubsamplingScaleImageView", "onTouchEvent", e);
        return false;
    }

    public final void q(Point r110) {
        int r100 = 1;
        if (this.f426700e == 1) goto L5;
    L14:
        m("initialiseTileMap maxTileDimensions=%dx%d", new Object[]{Integer.valueOf(r110.x), Integer.valueOf(r110.y)});
        this.f426701f = new LinkedHashMap();
        int r101 = this.f426700e;
        int r102 = 1;
        int r103 = 1;
    L15:
        int r104 = I() / r102;
        int r105 = H() / r103;
        int r106 = r104 / r101;
        int r111 = r105 / r101;
    L17:
        if (((r106 + r102) + r100) > r110.x) goto L58;
        if (r106 <= (((double) getWidth()) * 1.25d)) goto L24;
        if (r101 < this.f426700e) goto L58;
    L24:
        if (((r111 + r103) + r100) > r110.y) goto L57;
        if (r111 <= (((double) getHeight()) * 1.25d)) goto L30;
        if (r101 < this.f426700e) goto L57;
    L30:
        ArrayList r107 = new ArrayList(r102 * r103);
        int r112 = 0;
    L31:
        if (r112 >= r102) goto L48;
        int r113 = 0;
    L33:
        if (r113 >= r103) goto L47;
        n r114 = new n();
        r114.f426774b = r101;
        if (r101 != this.f426700e) goto L37;
        boolean r115 = true;
    L38:
        r114.f426777e = r115;
        int r116 = r112 * r104;
        int r117 = r113 * r105;
        if (r112 != (r102 - 1)) goto L41;
        int r108 = I();
    L43:
        if (r113 != (r103 - 1)) goto L45;
        int r109 = H();
    L46:
        r114.f426773a = new Rect(r116, r117, r108, r109);
        r114.f426778f = new Rect(0, 0, 0, 0);
        r114.f426779g = new Rect(r114.f426773a);
        r107.add(r114);
        r113 = r113 + 1;
        goto L33
    L45:
        r109 = (r113 + 1) * r105;
        goto L46
    L41:
        r108 = (r112 + 1) * r104;
        goto L43
    L37:
        r115 = false;
        goto L38
    L47:
        r112 = r112 + 1;
        goto L31
    L48:
        this.f426701f.put(Integer.valueOf(r101), r107);
        r100 = 1;
        if (r101 == 1) goto L50;
        r101 = r101 / 2;
        goto L15
    L50:
        Iterator r118 = ((List) ((LinkedHashMap) this.f426701f).get(Integer.valueOf(this.f426700e))).iterator();
    L52:
        if (r118.hasNext() == false) goto L54;
        new o(this, this.Q, (n) r118.next()).executeOnExecutor(this.f426717p, new Void[0]);
        goto L52
    L54:
        E(true);
        return;
    L57:
        r103 = r103 + 1;
        r105 = H() / r103;
        r111 = r105 / r101;
    L58:
        r102 = r102 + 1;
        r104 = I() / r102;
        r106 = r104 / r101;
        goto L17
    L5:
        if (this.I != null) goto L14;
        if (I() >= r110.x) goto L14;
        if (H() >= r110.y) goto L14;
        rlb.d r119 = this.Q;
        if (r119 == null) goto L13;
        r119.recycle();
    L13:
        this.Q = null;
        new g(this, getContext(), this.S, this.f426699d, false).executeOnExecutor(this.f426717p, new Void[0]);
    }

    public final void r(boolean r100) {
        if (this.f426734z != null) goto L5;
        this.f426734z = new PointF(0.0f, 0.0f);
        boolean r101 = true;
    L7:
        if (this.P1 != null) goto L9;
        this.P1 = new l(0.0f, new PointF(0.0f, 0.0f));
    L9:
        l r102 = this.P1;
        r102.f426771a = this.f426730x;
        r102.f426772b.set(this.f426734z);
        s(r100, this.P1);
        l r103 = this.P1;
        this.f426730x = r103.f426771a;
        this.f426734z.set(r103.f426772b);
        if (r101 == true) goto L12;
        return;
    L12:
        if (this.f426714m == 4) goto L16;
        this.f426734z.set(Q(I() / 2, H() / 2, this.f426730x));
        return;
    L16:
        return;
    L5:
        r101 = false;
        goto L7
    }

    public final void setBitmapDecoderClass(Class<? extends rlb.c> r100) {
        if (r100 == null) goto L6;
        this.S = new rlb.a(r100);
        return;
    L6:
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setBitmapDecoderFactory(rlb.b<? extends rlb.c> r100) {
        if (r100 == null) goto L6;
        this.S = r100;
        return;
    L6:
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setDebug(boolean r100) {
        this.f426702g = r100;
    }

    public final void setDoubleTapZoomDpi(int r100) {
        DisplayMetrics r101 = a(getResources());
        setDoubleTapZoomScale(((r101.xdpi + r101.ydpi) / 2.0f) / r100);
    }

    public final void setDoubleTapZoomDuration(int r100) {
        this.f426729w = Math.max(0, r100);
    }

    public final void setDoubleTapZoomScale(float r100) {
        this.f426725u = r100;
    }

    public final void setDoubleTapZoomStyle(int r100) {
        if (f426692y2.contains(Integer.valueOf(r100)) == false) goto L7;
        this.f426726v = r100;
        return;
    L7:
        throw new IllegalArgumentException("Invalid zoom style: " + r100);
    }

    public void setEagerLoadingEnabled(boolean r100) {
        this.f426721q = r100;
    }

    public void setExecutor(Executor r100) {
        if (r100 == null) goto L6;
        this.f426717p = r100;
        return;
    L6:
        throw new NullPointerException("Executor must not be null");
    }

    public void setGestureDetector(Context r100) {
        this.O = new GestureDetector(r100, new b(this, r100));
        this.P = new GestureDetector(r100, new c(this));
    }

    public final void setImage(qlb.a r100) {
        K(r100, null);
    }

    public final void setMaxScale(float r100) {
        this.f426708i = r100;
    }

    public void setMaxTileSize(int r100) {
        this.f426715n = r100;
        this.f426716o = r100;
    }

    public final void setMaximumDpi(int r100) {
        DisplayMetrics r101 = a(getResources());
        setMinScale(((r101.xdpi + r101.ydpi) / 2.0f) / r100);
    }

    public final void setMinScale(float r100) {
        this.f426709j = r100;
    }

    public final void setMinimumDpi(int r100) {
        DisplayMetrics r101 = a(getResources());
        setMaxScale(((r101.xdpi + r101.ydpi) / 2.0f) / r100);
    }

    public final void setMinimumScaleType(int r100) {
        if (G2.contains(Integer.valueOf(r100)) == false) goto L9;
        this.f426714m = r100;
        if (this.f426696b1 == false) goto L10;
        r(true);
        invalidate();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Invalid scale type: " + r100);
    }

    public void setMinimumTileDpi(int r100) {
        DisplayMetrics r101 = a(getResources());
        this.f426710k = (int) Math.min((r101.xdpi + r101.ydpi) / 2.0f, r100);
        if (this.f426696b1 == false) goto L6;
        G(false);
        invalidate();
        return;
    }

    public void setOnImageEventListener(h r100) {
        this.f426706h1 = r100;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r100) {
        this.f426727v1 = r100;
    }

    public void setOnMatrixChangeListener(i r100) {
        this.f426719p1 = r100;
    }

    public void setOnMatrixChangedListener(i r100) {
        this.f426719p1 = r100;
    }

    public void setOnScaleEventListener(OnScaleEventListener r100) {
        this.f426712k1 = r100;
    }

    public void setOnSizeChangedStrategy(j r100) {
        this.f426731x1 = r100;
    }

    public final void setOrientation(int r100) {
        if (f426691x2.contains(Integer.valueOf(r100)) == false) goto L7;
        this.f426705h = r100;
        G(false);
        invalidate();
        requestLayout();
        return;
    L7:
        throw new IllegalArgumentException("Invalid orientation: " + r100);
    }

    public final void setPanEnabled(boolean r100) {
        this.f426722r = r100;
        if (r100 == true) goto L10;
        PointF r101 = this.f426734z;
        if (r101 == null) goto L11;
        r101.x = (getWidth() / 2) - (this.f426730x * (I() / 2));
        this.f426734z.y = (getHeight() / 2) - (this.f426730x * (H() / 2));
        if (this.f426696b1 == false) goto L12;
        E(true);
        invalidate();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setPanLimit(int r100) {
        if (F2.contains(Integer.valueOf(r100)) == false) goto L9;
        this.f426713l = r100;
        if (this.f426696b1 == false) goto L10;
        r(true);
        invalidate();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Invalid pan limit: " + r100);
    }

    public final void setPhotoViewDoubleTapZoomScale(float r100) {
        this.f426725u = r100 / getScaleFactor();
    }

    public void setPlusProvider(plb.a r100) {
        this.f426704g2 = r100;
    }

    public final void setQuickScaleEnabled(boolean r100) {
        this.f426724t = r100;
    }

    public final void setRegionDecoderClass(Class<? extends rlb.d> r100) {
        if (r100 == null) goto L6;
        this.T = new rlb.a(r100);
        return;
    L6:
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setRegionDecoderFactory(rlb.b<? extends rlb.d> r100) {
        if (r100 == null) goto L6;
        this.T = r100;
        return;
    L6:
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public void setScale(float r100) {
        this.f426730x = r100;
    }

    public final void setTileBackgroundColor(int r100) {
        if (Color.alpha(r100) != 0) goto L5;
        this.M1 = null;
    L6:
        invalidate();
        return;
    L5:
        Paint r101 = new Paint();
        this.M1 = r101;
        r101.setStyle(Paint.Style.FILL);
        this.M1.setColor(r100);
        goto L6
    }

    public final void setZoomEnabled(boolean r100) {
        this.f426723s = r100;
    }

    public Rect t(n r100) {
        return r100.f426778f;
    }

    public final synchronized void v(Point r100) {
        monitor-enter(this);
        m("initialiseBaseLayer maxTileDimensions=%dx%d", new Object[]{Integer.valueOf(r100.x), Integer.valueOf(r100.y)});     // Catch: Throwable -> L9
        l r101 = new l(0.0f, new PointF(0.0f, 0.0f));     // Catch: Throwable -> L9
        this.P1 = r101;     // Catch: Throwable -> L9
        s(true, r101);     // Catch: Throwable -> L9
        int r102 = h(this.P1.f426771a);     // Catch: Throwable -> L9
        this.f426700e = r102;     // Catch: Throwable -> L9
        if (r102 <= 1) goto L6;
        this.f426700e = r102 / 2;     // Catch: Throwable -> L9
    L6:
        q(r100);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void z(Bitmap r100) {
        monitor-enter(this);
        m("onPreviewLoaded", new Object[0]);     // Catch: Throwable -> L20
        if (this.f426694a == null) goto L6;
    L17:
        r100.recycle();     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L6:
        if (this.f426703g1 == true) goto L17;
        Rect r101 = this.f426693J;     // Catch: Throwable -> L20
        if (r101 == null) goto L11;
        this.f426694a = Bitmap.createBitmap(r100, r101.left, r101.top, r101.width(), this.f426693J.height());     // Catch: Throwable -> L20
    L12:
        this.f426695b = true;     // Catch: Throwable -> L20
        if (k() == false) goto L15;
        invalidate();     // Catch: Throwable -> L20
        requestLayout();     // Catch: Throwable -> L20
    L15:
        monitor-exit(this);
        return;
    L11:
        this.f426694a = r100;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public SubsamplingScaleImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f426705h = 0;
        this.f426708i = 2.0f;
        this.f426709j = x();
        this.f426710k = -1;
        this.f426713l = 1;
        this.f426714m = 1;
        this.f426715n = Integer.MAX_VALUE;
        this.f426716o = Integer.MAX_VALUE;
        this.f426717p = AsyncTask.THREAD_POOL_EXECUTOR;
        this.f426721q = true;
        this.f426722r = true;
        this.f426723s = true;
        this.f426724t = true;
        this.f426725u = 1.0f;
        this.f426726v = 1;
        this.f426729w = 500;
        this.R = new ReentrantReadWriteLock(true);
        this.S = new rlb.a(SkiaImageDecoder.class);
        this.T = new rlb.a(SkiaImageRegionDecoder.class);
        this.T1 = new float[8];
        this.V1 = new float[8];
        this.f426720p2 = new RectF();
        this.f426728v2 = new ScaleGestureDetector(getContext(), new d(this));
        this.f426697b2 = a(getResources()).density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMinimumTileDpi(320);
        setGestureDetector(r100);
        this.f426733y1 = new Handler(new a(this));
        if (r101 == null) goto L39;
        TypedArray r102 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.assetName, R.attr.panEnabled, R.attr.quickScaleEnabled, R.attr.src, R.attr.tileBackgroundColor, R.attr.zoomEnabled});
        if (r102.hasValue(0) == false) goto L22;
        String r103 = r102.getString(0);
        if (r103 == null) goto L22;
        if (r103.length() <= 0) goto L22;
        String r104 = "file:///android_asset/".concat(r103);
        if (r104 == null) goto L20;
        if (r104.contains("://") == false) goto L15;
    L18:
        qlb.a r105 = new qlb.a(UriProtector.parse(r104));
        r105.f533829d = true;
        setImage(r105);
        goto L22
    L15:
        if (r104.startsWith(HTTP.URL_DEFAULT) == false) goto L17;
        r104 = r104.substring(1);
    L17:
        r104 = "file:///" + r104;
        goto L18
    L20:
        throw new NullPointerException("Uri must not be null");
    L22:
        if (r102.hasValue(3) == false) goto L27;
        int r106 = r102.getResourceId(3, 0);
        if (r106 <= 0) goto L27;
        qlb.a r107 = new qlb.a(r106);
        r107.f533829d = true;
        setImage(r107);
    L27:
        if (r102.hasValue(1) == false) goto L30;
        setPanEnabled(r102.getBoolean(1, true));
    L30:
        if (r102.hasValue(5) == false) goto L33;
        setZoomEnabled(r102.getBoolean(5, true));
    L33:
        if (r102.hasValue(2) == false) goto L36;
        setQuickScaleEnabled(r102.getBoolean(2, true));
    L36:
        if (r102.hasValue(4) == false) goto L38;
        setTileBackgroundColor(r102.getColor(4, Color.argb(0, 0, 0, 0)));
    L38:
        r102.recycle();
    L39:
        this.W = TypedValue.applyDimension(1, 20.0f, a(r100.getResources()));
    }

    public static /* synthetic */ void b(SubsamplingScaleImageView r100, View.OnLongClickListener r101) {
        super.setOnLongClickListener(r101);
    }

    public final void J(float r100, PointF r101) {
        if (this.f426719p1 != null) goto L5;
        return;
    L5:
        if (this.f426730x == r100) goto L7;
    L8:
        i(this.f426734z);
        this.f426719p1.a(this.f426720p2);
        return;
    L7:
        if (this.f426734z.equals(r101) == false) goto L8;
    }

    public final void K(qlb.a r110, qlb.a r111) {
        if (r110 == null) goto L45;
        G(true);
        if (r111 != null) goto L6;
    L24:
        Bitmap r112 = r110.f533827b;
        if (r112 == null) goto L29;
        Rect r100 = r110.f533832g;
        if (r100 == null) goto L29;
        y(Bitmap.createBitmap(r112, r100.left, r100.top, r100.width(), r110.f533832g.height()), 0, false);
        return;
    L29:
        if (r112 == null) goto L31;
        y(r112, 0, r110.f533833h);
        return;
    L31:
        this.I = r110.f533832g;
        Uri r113 = r110.f533826a;
        this.f426699d = r113;
        if (r113 != null) goto L37;
        if (r110.f533828c == null) goto L37;
        this.f426699d = UriProtector.parse("android.resource://" + getContext().getPackageName() + HTTP.URL_DEFAULT + r110.f533828c);
    L37:
        if (r110.f533829d == false) goto L39;
    L42:
        new p(this, getContext(), this.T, this.f426699d).executeOnExecutor(this.f426717p, new Void[0]);
        return;
    L39:
        if (this.I != null) goto L42;
        new g(this, getContext(), this.S, this.f426699d, false).executeOnExecutor(this.f426717p, new Void[0]);
        return;
    L6:
        if (r110.f533827b != null) goto L23;
        int r101 = r110.f533830e;
        if (r101 <= 0) goto L21;
        int r102 = r110.f533831f;
        if (r102 <= 0) goto L21;
        this.F = r101;
        this.G = r102;
        this.f426693J = r111.f533832g;
        Bitmap r103 = r111.f533827b;
        if (r103 == null) goto L14;
        this.f426698c = r111.f533833h;
        z(r103);
        goto L24
    L14:
        Uri r104 = r111.f533826a;
        if (r104 == null) goto L17;
    L19:
        new g(this, getContext(), this.S, r104, true).executeOnExecutor(this.f426717p, new Void[0]);
        goto L24
    L17:
        if (r111.f533828c == null) goto L19;
        r104 = UriProtector.parse("android.resource://" + getContext().getPackageName() + HTTP.URL_DEFAULT + r111.f533828c);
    L21:
        throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
    L23:
        throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
    L45:
        throw new NullPointerException("imageSource must not be null");
    }

    public final void M(float r100, PointF r101) {
        this.V0 = null;
        this.C = Float.valueOf(r100);
        this.D = r101;
        this.E = r101;
        invalidate();
    }

    public final void m(String r100, Object... r101) {
        if (this.f426702g == false) goto L6;
        Log.d("SubsamplingScaleImageView", String.format(r100, r101));
        return;
    }

    public void o(PointF r110, PointF r111) {
        if (this.f426722r == true) goto L8;
        PointF r100 = this.E;
        if (r100 == null) goto L7;
        r110.x = r100.x;
        r110.y = r100.y;
        goto L8
    L7:
        r110.x = I() / 2;
        r110.y = H() / 2;
    L8:
        float r101 = Math.min(this.f426708i, this.f426725u);
        float r102 = this.f426730x;
        if (r102 > (((double) r101) * 0.9d)) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == true) goto L18;
        r101 = x();
    L18:
        int r104 = this.f426726v;
        if (r104 != 3) goto L22;
        M(r101, r110);
    L30:
        invalidate();
        OnScaleEventListener r112 = this.f426712k1;
        if (r112 == null) goto L34;
        r112.a(getScale(), r101, OnScaleEventListener.ScaleCause.DOUBLE_TAP);
        return;
    L34:
        return;
    L22:
        if (r104 == 2) goto L29;
        if (r103 == false) goto L29;
        if (this.f426722r == false) goto L29;
        if (r104 != 1) goto L30;
        f r105 = new f(this, r101, r110, r111);
        r105.f426760g = false;
        r105.f426757d = this.f426729w;
        r105.f426759f = 4;
        r105.a();
    L29:
        f r113 = new f(this, r101, r110);
        r113.f426760g = false;
        r113.f426757d = this.f426729w;
        r113.f426759f = 4;
        r113.a();
        goto L30
    L11:
        if (r102 == this.f426709j) goto L14;
        r103 = false;
        goto L15
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
        r104 = I();
        r105 = H();
    L16:
        if (r106 == false) goto L18;
        r105 = (int) ((((double) H()) / ((double) I())) * ((double) r104));
        goto L20
    L18:
        if (r107 == false) goto L20;
        r104 = (int) ((((double) I()) / ((double) H())) * ((double) r105));
        goto L20
    L5:
        r107 = false;
        goto L6
    }

    public final void s(boolean r110, l r111) {
        if (this.f426713l == 2) goto L5;
    L7:
        PointF r100 = r111.f426772b;
        float r101 = Math.min(this.f426708i, Math.max(x(), r111.f426771a));
        float r102 = I() * r101;
        float r103 = H() * r101;
        if (this.f426713l == 3) goto L10;
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
        if (this.f426713l == 3) goto L30;
    L32:
        if (r110 == false) goto L34;
        float r112 = Math.max(0.0f, (getWidth() - r102) * r105);
        float r106 = Math.max(0.0f, (getHeight() - r103) * r104);
    L36:
        r100.x = Math.min(r100.x, r112);
        r100.y = Math.min(r100.y, r106);
        r111.f426771a = r101;
        return;
    L34:
        r112 = Math.max(0, getWidth());
        int r107 = Math.max(0, getHeight());
    L35:
        r106 = r107;
        goto L36
    L30:
        if (this.f426696b1 == false) goto L32;
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
        if (this.f426696b1 == false) goto L12;
        r100.x = Math.max(r100.x, (getWidth() / 2) - r102);
        r100.y = Math.max(r100.y, (getHeight() / 2) - r103);
        goto L15
    L5:
        if (this.f426696b1 == false) goto L7;
        r110 = false;
        goto L7
    }

    public static int d(SubsamplingScaleImageView r100, Context r101, String r102) {
        int r103 = 0;
        if (r102.startsWith("content") == false) goto L26;
        Cursor r104 = null;
        r104 = l(r101.getContentResolver(), Uri.parse(r102), new String[]{"orientation"});     // Catch: Throwable -> L17 Exception -> L19
        if (r104 != null) goto L8;
    L15:
        if (r104 == null) goto L56;
    L21:
        r104.close();
        return r103;
    L56:
        return r103;
    L8:
        if (r104.moveToFirst() == false) goto L15;
        int r105 = r104.getInt(0);     // Catch: Throwable -> L17 Exception -> L19
        if (f426691x2.contains(Integer.valueOf(r105)) == true) goto L12;
    L14:
        Log.w("SubsamplingScaleImageView", "Unsupported orientation: " + r105);     // Catch: Throwable -> L17 Exception -> L19
    L12:
        if (r105 == (-1)) goto L14;
        r103 = r105;
    L17:
        th = move-exception;
        if (r104 == null) goto L24;
        r104.close();
    L24:
        throw th;
    L19:
        Log.w("SubsamplingScaleImageView", "Could not get orientation of image from media store");     // Catch: Throwable -> L17
        if (r104 != null) goto L21;
        return 0;
    L26:
        if (r102.startsWith("file:///") == true) goto L28;
        return 0;
    L28:
        if (r102.startsWith("file:///android_asset/") == true) goto L60;
        int r106 = new ExifInterface(r102.substring(7)).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);     // Catch: Exception -> L50
        if (r106 == 1) goto L61;
        if (r106 != 0) goto L34;
        return 0;
    L34:
        if (r106 != 6) goto L37;
        return 90;
    L37:
        if (r106 != 3) goto L40;
        return 180;
    L40:
        if (r106 != 8) goto L43;
        return 270;
    L43:
        if (r106 != 2) goto L46;
        return 2;
    L46:
        if (r106 == 4) goto L67;
        Log.w("SubsamplingScaleImageView", "Unsupported EXIF orientation: " + r106);     // Catch: Exception -> L50
        return 0;
    L67:
        return 4;
    L61:
        return 0;
    L50:
        Log.w("SubsamplingScaleImageView", "Could not get EXIF orientation of image");
        return 0;
    L60:
        return 0;
    }

    public static void e(SubsamplingScaleImageView r100, Rect r101, Rect r102) {
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

    public static Cursor l(ContentResolver r110, Uri r111, String[] r112) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, null, null, null};
        f06.b r113 = new f06.b();
        f06.d r114 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r113);
        if (r114.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r113, false);
        return (Cursor) r114.f474983b;
    L6:
        Cursor r115 = r110.query(r111, r112, null, null, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r115, r113, true);
        return r115;
    }

    public final PointF Q(float r100, float r101, float r102) {
        int r103 = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int r104 = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.P1 != null) goto L5;
        this.P1 = new l(0.0f, new PointF(0.0f, 0.0f));
    L5:
        l r105 = this.P1;
        r105.f426771a = r102;
        r105.f426772b.set(r103 - (r100 * r102), r104 - (r101 * r102));
        s(true, this.P1);
        return this.P1.f426772b;
    }

    public final synchronized void y(Bitmap r100, int r101, boolean r102) {
        monitor-enter(this);
        m("onImageLoaded", new Object[0]);     // Catch: Throwable -> L30
        int r103 = this.F;     // Catch: Throwable -> L30
        if (r103 > 0) goto L6;
    L12:
        Bitmap r104 = this.f426694a;     // Catch: Throwable -> L30
        if (r104 == null) goto L18;
        if (this.f426698c == true) goto L18;
        r104.recycle();     // Catch: Throwable -> L30
    L18:
        if (this.f426694a != null) goto L20;
    L24:
        this.f426695b = false;     // Catch: Throwable -> L30
        this.f426698c = r102;     // Catch: Throwable -> L30
        this.f426694a = r100;     // Catch: Throwable -> L30
        this.F = r100.getWidth();     // Catch: Throwable -> L30
        this.G = r100.getHeight();     // Catch: Throwable -> L30
        this.H = r101;     // Catch: Throwable -> L30
        boolean r105 = k();     // Catch: Throwable -> L30
        boolean r106 = j();     // Catch: Throwable -> L30
        if (r105 == true) goto L27;
        if (r106 == true) goto L27;
    L28:
        monitor-exit(this);
        return;
    L27:
        invalidate();     // Catch: Throwable -> L30
        requestLayout();     // Catch: Throwable -> L30
        goto L28
    L20:
        if (this.f426698c == false) goto L24;
        h r107 = this.f426706h1;     // Catch: Throwable -> L30
        if (r107 == null) goto L24;
        r107.onPreviewReleased();     // Catch: Throwable -> L30
        goto L24
    L6:
        if (this.G <= 0) goto L12;
        if (r103 == r100.getWidth()) goto L10;
    L11:
        G(false);     // Catch: Throwable -> L30
        goto L12
    L10:
        if (this.G == r100.getHeight()) goto L12;
    L30:
        th = move-exception;
        throw th;
    }

    public static float n(float r100, float r101, float r102, float r103) {
        float r104 = r100 - r101;
        float r105 = r102 - r103;
        return (float) Math.sqrt((r104 * r104) + (r105 * r105));
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        Log.i("SubsamplingScaleImageView", "onSizeChanged from:" + r102 + "*" + r103 + ", to:" + r100 + "*" + r101);
        PointF r104 = getCenter();
        if (this.f426696b1 == false) goto L11;
        if (r104 == null) goto L11;
        this.V0 = null;
        j r105 = this.f426731x1;
        if (r105 == null) goto L8;
        this.C = Float.valueOf(r105.b(r100, r101, this.F, this.G));
        this.D = this.f426731x1.a(r104);
    L9:
        Log.i("SubsamplingScaleImageView", "onSizeChanged refresh, pendingScale=" + this.C + ",sPendingCenter=" + this.D);
        goto L11
    L8:
        this.C = Float.valueOf(this.f426730x);
        this.D = r104;
    L11:
        if (this.f426719p1 == null) goto L14;
        r(true);
        i(this.f426734z);
        this.f426719p1.a(this.f426720p2);
        return;
    }

    public static float p(int r100, long r101, float r102, float r103, long r104) {
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

    public static void L(float[] r100, float r101, float r102, float r103, float r104, float r105, float r106, float r107, float r108) {
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
