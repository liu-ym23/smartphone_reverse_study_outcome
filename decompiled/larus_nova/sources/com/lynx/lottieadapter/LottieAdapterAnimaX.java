package com.lynx.lottieadapter;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.camera.video.AudioStats;
import androidx.core.math.MathUtils;
import androidx.core.util.Consumer;
import com.huawei.hms.android.SystemUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.animax.base.bridge.JavaOnlyArray;
import com.lynx.animax.composition.AnimaXComposition;
import com.lynx.animax.property.AnimaXKeyPath;
import com.lynx.animax.property.AnimaXKeyPathListCallback;
import com.lynx.animax.property.AnimaXPropertyCallback;
import com.lynx.animax.property.AnimaXValueCallback;
import com.lynx.animax.property.AnimaXValueParam;
import com.lynx.animax.property.LayerPropertyType;
import com.lynx.animax.ui.AnimaXContext;
import com.lynx.animax.ui.AnimaXImageView;
import com.lynx.animax.ui.AnimaXView;
import com.lynx.animax.ui.ObjectFit;
import com.lynx.animax.util.AnimaXLog;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class LottieAdapterAnimaX implements b6a.b {
    private static final double EPSILON = 1.0E-6d;
    private static final String TAG = "LottieAdapterAnimaX";
    private volatile x4a.e mAnimaXView;
    private boolean mAutoPlay;
    private ColorFilter mColorFilter;
    private c6a.c mComposition;
    private final Context mContext;
    private String mCurrentUrl;
    private int mEndFrame;
    public final Set mExternalListeners;
    private String mImageAssetsFolder;
    private volatile AppCompatImageView mImageDrawableView;
    private boolean mIsAnimationReady;
    private final Handler mMainThreadHandler;
    private float mMaxFrameRate;
    private float mModelEndFrame;
    private float mModelStartFrame;
    private boolean mMultiThreadAccelerate;
    private final List<Runnable> mOperationQueue;
    private WeakReference<ViewGroup> mParentViewRef;
    private int mRepeatCount;
    private int mRepeatMode;
    private ImageView.ScaleType mScaleType;
    private float mSpeed;
    private int mStartFrame;
    private boolean mUseImageMode;

    /* JADX INFO: loaded from: classes32.dex */
    public class a implements AnimaXKeyPathListCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f381381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f381382b;

        @Override // com.lynx.animax.property.AnimaXKeyPathListCallback
        public final /* synthetic */ void onKeyPathListCallback(JavaOnlyArray r100) {
            AnimaXKeyPathListCallback.CC.$default$onKeyPathListCallback(this, r100);
        }

        @Override // com.lynx.animax.property.AnimaXKeyPathListCallback
        public final void onCallback(List<AnimaXKeyPath> r100) {
            Iterator r101 = ((ArrayList) r100).iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            AnimaXKeyPath r102 = (AnimaXKeyPath) r101.next();
            List r103 = this.f381381a;
            ArrayList r104 = (ArrayList) r102.a();
            r103.add(new d6a.a((String[]) r104.toArray(new String[0])));
            goto L4
        L6:
            this.f381382b.countDown();
        }

        public a(List r100, CountDownLatch r101) {
            this.f381381a = r100;
            this.f381382b = r101;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d6a.a f381383a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f381384b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e6a.b f381385c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ LottieAdapterAnimaX f381386d;

        public class a implements AnimaXValueCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f381387a;

            @Override // com.lynx.animax.property.AnimaXValueCallback
            public final /* synthetic */ Object getValueInternal(float r100, float r101, AnimaXValueParam r102, AnimaXValueParam r103, float r104, float r105, float r106) {
                return AnimaXValueCallback.CC.$default$getValueInternal(this, r100, r101, r102, r103, r104, r105, r106);
            }

            public a(b r100) {
                this.f381387a = r100;
            }

            @Override // com.lynx.animax.property.AnimaXValueCallback
            public final AnimaXValueParam a(com.lynx.animax.property.a r100) {
                b r101 = this.f381387a;
                Object r102 = r101.f381385c.a(LottieAdapterAnimaX.access$700(r101.f381386d, r100));
                return LottieAdapterAnimaX.access$800(this.f381387a.f381386d, r102);
            }
        }

        /* JADX INFO: renamed from: com.lynx.lottieadapter.LottieAdapterAnimaX$b$b, reason: collision with other inner class name */
        public class C4559b implements AnimaXPropertyCallback {
            @Override // com.lynx.animax.property.AnimaXPropertyCallback
            public final /* synthetic */ void onPropertyCallback(JavaOnlyArray r100) {
                AnimaXPropertyCallback.CC.$default$onPropertyCallback(this, r100);
            }

            @Override // com.lynx.animax.property.AnimaXPropertyCallback
            public final void onSuccess() {
                AnimaXLog.b(LottieAdapterAnimaX.TAG, "addValueCallback onSuccess");
            }

            public C4559b() {
            }

            @Override // com.lynx.animax.property.AnimaXPropertyCallback
            public final void a(List<String> r100) {
                AnimaXLog.a(LottieAdapterAnimaX.TAG, "addValueCallback onError: " + r100);
            }
        }

        public final void a() {
            if (LottieAdapterAnimaX.access$300(this.f381386d) != null) goto L5;
            return;
        L5:
            if (this.f381383a == null) goto L17;
            Object r100 = this.f381384b;
            if (r100 != null) goto L9;
            return;
        L9:
            if (this.f381385c == null) goto L19;
            LayerPropertyType r101 = LottieAdapterAnimaX.access$600(this.f381386d, r100);
            if (r101 != null) goto L14;
            return;
        L14:
            AnimaXKeyPath r102 = new AnimaXKeyPath((String[]) this.f381383a.f467213a.toArray(new String[0]));
            LottieAdapterAnimaX.access$300(this.f381386d).getPlayer().i(r101, r102, new a(this), new C4559b());
            return;
        L19:
            return;
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

        public b(LottieAdapterAnimaX r100, d6a.a r101, Object r102, e6a.b r103) {
            this.f381386d = r100;
            this.f381383a = r101;
            this.f381384b = r102;
            this.f381385c = r103;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: loaded from: classes32.dex */
    public class c<T> extends e6a.b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e6a.d f381388a;

        public c(e6a.d r100) {
            this.f381388a = r100;
        }

        @Override // e6a.b
        public final T a(e6a.a<T> r100) {
            return (T) this.f381388a.getValue();
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f381389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LottieAdapterAnimaX f381390b;

        @Override // java.lang.Runnable
        public final void run() {
            LottieAdapterAnimaX r100 = this.f381390b;     // Catch: Throwable -> L4
            LottieAdapterAnimaX.access$902(r100, LottieAdapterAnimaX.access$1000(r100, this.f381389a));     // Catch: Throwable -> L4
            LottieAdapterAnimaX.access$300(this.f381390b).setStartFrame(LottieAdapterAnimaX.access$900(this.f381390b));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(LottieAdapterAnimaX r100, int r101) {
            this.f381390b = r100;
            this.f381389a = r101;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LottieAdapterAnimaX f381391a;

        @Override // java.lang.Runnable
        public final void run() {
            LottieAdapterAnimaX r100 = this.f381391a;     // Catch: Throwable -> L4
            LottieAdapterAnimaX.access$1102(r100, LottieAdapterAnimaX.access$1200(r100, LottieAdapterAnimaX.access$1100(r100)));     // Catch: Throwable -> L4
            LottieAdapterAnimaX.access$300(this.f381391a).setEndFrame(LottieAdapterAnimaX.access$1100(this.f381391a));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(LottieAdapterAnimaX r100) {
            this.f381391a = r100;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f381392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f381393b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LottieAdapterAnimaX f381394c;

        public final void a() {
            LottieAdapterAnimaX r100 = this.f381394c;
            LottieAdapterAnimaX.access$902(r100, LottieAdapterAnimaX.access$1000(r100, this.f381392a));
            LottieAdapterAnimaX.access$300(this.f381394c).setStartFrame(LottieAdapterAnimaX.access$900(this.f381394c));
            LottieAdapterAnimaX r101 = this.f381394c;
            LottieAdapterAnimaX.access$1102(r101, LottieAdapterAnimaX.access$1200(r101, this.f381393b));
            LottieAdapterAnimaX.access$300(this.f381394c).setEndFrame(LottieAdapterAnimaX.access$1100(this.f381394c));
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

        public f(LottieAdapterAnimaX r100, int r101, int r102) {
            this.f381394c = r100;
            this.f381392a = r101;
            this.f381393b = r102;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f381395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LottieAdapterAnimaX f381396b;

        @Override // java.lang.Runnable
        public final void run() {
            x4a.e r100 = LottieAdapterAnimaX.access$300(this.f381396b);     // Catch: Throwable -> L4
            Objects.requireNonNull(r100);     // Catch: Throwable -> L4
            r100.setStartFrame((int) LottieAdapterAnimaX.access$1300(this.f381396b, this.f381395a));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public g(LottieAdapterAnimaX r100, float r101) {
            this.f381396b = r100;
            this.f381395a = r101;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f381397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LottieAdapterAnimaX f381398b;

        @Override // java.lang.Runnable
        public final void run() {
            x4a.e r100 = LottieAdapterAnimaX.access$300(this.f381398b);     // Catch: Throwable -> L4
            Objects.requireNonNull(r100);     // Catch: Throwable -> L4
            r100.setEndFrame((int) LottieAdapterAnimaX.access$1300(this.f381398b, this.f381397a));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public h(LottieAdapterAnimaX r100, float r101) {
            this.f381398b = r100;
            this.f381397a = r101;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f381399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f381400b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LottieAdapterAnimaX f381401c;

        public final void a() {
            int r100 = (int) LottieAdapterAnimaX.access$1300(this.f381401c, this.f381399a);
            int r101 = (int) LottieAdapterAnimaX.access$1300(this.f381401c, this.f381400b);
            if (r100 != r101) goto L5;
            r100 = r100 - 1;
        L5:
            LottieAdapterAnimaX.access$300(this.f381401c).setStartFrame(LottieAdapterAnimaX.access$1000(this.f381401c, r100));
            LottieAdapterAnimaX.access$300(this.f381401c).setEndFrame(LottieAdapterAnimaX.access$1200(this.f381401c, r101));
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

        public i(LottieAdapterAnimaX r100, float r101, float r102) {
            this.f381401c = r100;
            this.f381399a = r101;
            this.f381400b = r102;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f381402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LottieAdapterAnimaX f381403b;

        @Override // java.lang.Runnable
        public final void run() {
            x4a.e r100 = LottieAdapterAnimaX.access$300(this.f381403b);     // Catch: Throwable -> L4
            Objects.requireNonNull(r100);     // Catch: Throwable -> L4
            r100.a(this.f381402a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public j(LottieAdapterAnimaX r100, int r101) {
            this.f381403b = r100;
            this.f381402a = r101;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LottieAdapterAnimaX f381404a;

        @Override // java.lang.Runnable
        public final void run() {
            LottieAdapterAnimaX.access$000(this.f381404a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public k(LottieAdapterAnimaX r100) {
            this.f381404a = r100;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f381405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LottieAdapterAnimaX f381406b;

        public final void a() {
            Drawable r100 = AppCompatResources.getDrawable(LottieAdapterAnimaX.access$1400(this.f381406b), this.f381405a);     // Catch: Resources.NotFoundException -> L6
            if (r100 == null) goto L10;
            LottieAdapterAnimaX.access$1500(this.f381406b, r100);     // Catch: Resources.NotFoundException -> L6
            return;
        L10:
            return;
        L6:
            AnimaXLog.d(LottieAdapterAnimaX.TAG, "Image resource not found: " + this.f381405a);
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

        public l(LottieAdapterAnimaX r100, int r101) {
            this.f381406b = r100;
            this.f381405a = r101;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Drawable f381407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LottieAdapterAnimaX f381408b;

        @Override // java.lang.Runnable
        public final void run() {
            LottieAdapterAnimaX.access$1500(this.f381408b, this.f381407a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public m(LottieAdapterAnimaX r100, Drawable r101) {
            this.f381408b = r100;
            this.f381407a = r101;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public static /* synthetic */ class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f381409a = null;

        static {
            int[] r100 = new int[ImageView.ScaleType.values().length];
            f381409a = r100;
            r100[ImageView.ScaleType.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f381409a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f381409a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f381409a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f381409a[ImageView.ScaleType.FIT_START.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f381409a[ImageView.ScaleType.FIT_END.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f381409a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f381409a[ImageView.ScaleType.MATRIX.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f381410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LottieAdapterAnimaX f381411b;

        @Override // java.lang.Runnable
        public final void run() {
            LottieAdapterAnimaX.access$100(this.f381411b, this.f381410a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public o(LottieAdapterAnimaX r100, String r101) {
            this.f381411b = r100;
            this.f381410a = r101;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public class p implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f381412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LottieAdapterAnimaX f381413b;

        @Override // java.lang.Runnable
        public final void run() {
            LottieAdapterAnimaX.access$200(this.f381413b, this.f381412a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public p(LottieAdapterAnimaX r100, String r101) {
            this.f381413b = r100;
            this.f381412a = r101;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public class q implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LottieAdapterAnimaX f381414a;

        @Override // java.lang.Runnable
        public final void run() {
            x4a.e r100 = LottieAdapterAnimaX.access$300(this.f381414a);     // Catch: Throwable -> L4
            Objects.requireNonNull(r100);     // Catch: Throwable -> L4
            r100.play();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public q(LottieAdapterAnimaX r100) {
            this.f381414a = r100;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public class r implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LottieAdapterAnimaX f381415a;

        @Override // java.lang.Runnable
        public final void run() {
            x4a.e r100 = LottieAdapterAnimaX.access$300(this.f381415a);     // Catch: Throwable -> L4
            Objects.requireNonNull(r100);     // Catch: Throwable -> L4
            r100.resume();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public r(LottieAdapterAnimaX r100) {
            this.f381415a = r100;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public class s implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LottieAdapterAnimaX f381416a;

        @Override // java.lang.Runnable
        public final void run() {
            x4a.e r100 = LottieAdapterAnimaX.access$300(this.f381416a);     // Catch: Throwable -> L4
            Objects.requireNonNull(r100);     // Catch: Throwable -> L4
            r100.cancel();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public s(LottieAdapterAnimaX r100) {
            this.f381416a = r100;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public class t implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LottieAdapterAnimaX f381417a;

        @Override // java.lang.Runnable
        public final void run() {
            x4a.e r100 = LottieAdapterAnimaX.access$300(this.f381417a);     // Catch: Throwable -> L4
            Objects.requireNonNull(r100);     // Catch: Throwable -> L4
            r100.pause();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public t(LottieAdapterAnimaX r100) {
            this.f381417a = r100;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public class u implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f381418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LottieAdapterAnimaX f381419b;

        @Override // java.lang.Runnable
        public final void run() {
            x4a.e r100 = LottieAdapterAnimaX.access$300(this.f381419b);     // Catch: Throwable -> L4
            Objects.requireNonNull(r100);     // Catch: Throwable -> L4
            r100.setProgress(this.f381418a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public u(LottieAdapterAnimaX r100, float r101) {
            this.f381419b = r100;
            this.f381418a = r101;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public class v implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f381420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LottieAdapterAnimaX f381421b;

        @Override // java.lang.Runnable
        public final void run() {
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L3:
            if (LottieAdapterAnimaX.access$400(this.f381421b) <= LottieAdapterAnimaX.access$500(this.f381421b)) goto L12;
            int r100 = (int) LottieAdapterAnimaX.access$500(this.f381421b);     // Catch: Throwable -> L9
            int r101 = (((int) LottieAdapterAnimaX.access$400(this.f381421b)) - r100) + 1;     // Catch: Throwable -> L9
            int[] r102 = new int[r101];     // Catch: Throwable -> L9
            int r103 = 0;
        L5:
            if (r103 >= r101) goto L7;
            r102[r103] = r100;     // Catch: Throwable -> L9
            r103 = r103 + 1;     // Catch: Throwable -> L9
            goto L5
        L7:
            LottieAdapterAnimaX.access$300(this.f381421b).b(r102, this.f381420a);     // Catch: Throwable -> L9
            return;
        }

        public v(LottieAdapterAnimaX r100, boolean r101) {
            this.f381421b = r100;
            this.f381420a = r101;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public static class w extends t4a.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<LottieAdapterAnimaX> f381422a;

        public w(LottieAdapterAnimaX r100) {
            this.f381422a = new WeakReference(r100);
        }

        @Override // t4a.e, t4a.f
        public final void a(t4a.c r100) {
            f(ValueAnimator.AnimatorUpdateListener.class, new b6a.f());
        }

        @Override // t4a.e, t4a.f
        public final void b(t4a.c r100) {
            f(Animator.AnimatorListener.class, new b6a.g());
        }

        @Override // t4a.e, t4a.f
        public final void c(t4a.c r100) {
            LottieAdapterAnimaX r101 = this.f381422a.get();
            if (r101 == null) goto L6;
            LottieAdapterAnimaX.access$1600(r101, r100.a("current"), r100.a("current") + r100.a("total"));
            return;
        }

        @Override // t4a.f
        public final void d(t4a.c r100) {
            f(Animator.AnimatorListener.class, new b6a.h());
        }

        @Override // t4a.e, t4a.f
        public final void j(t4a.c r100) {
            f(Animator.AnimatorListener.class, new b6a.d());
        }

        @Override // t4a.e, t4a.f
        public final void l(t4a.c r100) {
            f(Animator.AnimatorListener.class, new b6a.e());
        }

        public final <T> void f(Class<T> r100, Consumer<T> r101) {
            LottieAdapterAnimaX r102 = this.f381422a.get();
            if (r102 == null) goto L6;
            LottieAdapterAnimaX.access$1700(r102, r100, r101);
            return;
        }
    }

    private void onSetAnimationWithNewData() {
        this.mIsAnimationReady = false;
        this.mModelEndFrame = 0.0f;
        this.mModelStartFrame = 0.0f;
        View r100 = (View) this.mAnimaXView;
        Objects.requireNonNull(r100);
        r100.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.view.View, x4a.e] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    private boolean ensureAnimaXView() {
        if (this.mAnimaXView == null) goto L5;
        return true;
    L5:
        ViewGroup r100 = this.mParentViewRef.get();
        boolean r101 = false;
        if (r100 != null) goto L9;
        AnimaXLog.d(TAG, "no parent view, call setParentView first");
        return false;
    L9:
        AnimaXContext.a r102 = new AnimaXContext.a(new o4a.c(), this.mContext);
        if (this.mMultiThreadAccelerate == false) goto L14;
        String r103 = y4a.a.f566160a;
        if (SystemUtils.PRODUCT_HUAWEI.equals(Build.MANUFACTURER) == true) goto L14;
        r101 = true;
    L14:
        r102.f380438c = r101;
        AnimaXContext r104 = new AnimaXContext(r102);
        if (this.mUseImageMode == false) goto L17;
        ?? r105 = new AnimaXImageView(r104);
    L18:
        r105.setAutoPlay(this.mAutoPlay);
        r105.c(new w(this));
        String r106 = this.mImageAssetsFolder;
        if (r106 != null) goto L21;
    L23:
        r105.setSpeed(this.mSpeed);
        r105.setMaxFrameRate(this.mMaxFrameRate);
        setCompositionToAnimaXView(r105, this.mComposition);
        setRepeatCountToAnimaXView(r105, this.mRepeatCount);
        setRepeatModeToAnimaXView(r105, this.mRepeatMode);
        setScaleTypeToAnimaXView(r105, this.mScaleType);
        addViewToParent(r105, r100, this.mImageDrawableView);
        this.mAnimaXView = r105;
        return true;
    L21:
        if (r106.isEmpty() == true) goto L23;
        r105.setImageFolder(this.mImageAssetsFolder);
        goto L23
    L17:
        r105 = new AnimaXView(r104);
        goto L18
    }

    private boolean ensureImageDrawableView() {
        if (this.mImageDrawableView == null) goto L5;
        return true;
    L5:
        ViewGroup r100 = this.mParentViewRef.get();
        if (r100 != null) goto L9;
        return false;
    L9:
        AppCompatImageView r101 = new AppCompatImageView(this.mContext);
        ColorFilter r102 = this.mColorFilter;
        if (r102 == null) goto L12;
        r101.setColorFilter(r102);
    L12:
        addViewToParent(r101, r100, null);
        this.mImageDrawableView = r101;
        return true;
    }

    private void flushOperationQueue() {
        ArrayList r100 = new ArrayList(this.mOperationQueue);
        this.mOperationQueue.clear();
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Runnable r102 = (Runnable) r101.next();
        if (r102 == null) goto L4;
        r102.run();
        goto L4
    }

    private void hideImageDrawableView() {
        if (this.mImageDrawableView == null) goto L6;
        this.mImageDrawableView.setVisibility(8);
        return;
    }

    private boolean isUpdateListenersEmpty() {
        Iterator r100 = this.mExternalListeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        if ((r100.next() instanceof ValueAnimator.AnimatorUpdateListener) == false) goto L4;
        return false;
    L9:
        return true;
    }

    private void onSetParentView() {
        ViewGroup r100 = this.mParentViewRef.get();
        if (r100 != null) goto L7;
        AnimaXLog.d(TAG, "no parent view");
        return;
    L7:
        if (this.mAnimaXView == null) goto L10;
        addViewToParent((View) this.mAnimaXView, r100, this.mImageDrawableView);
    L10:
        if (this.mImageDrawableView == null) goto L13;
        addViewToParent(this.mImageDrawableView, r100, null);
        return;
    }

    @Override // b6a.b
    public void cancelAnimation() {
        enqueueOperation(new s(this));
    }

    @Override // b6a.b
    public long getDuration() {
        if (this.mAnimaXView != null) goto L7;
        return 0;
    L7:
        return (long) this.mAnimaXView.getDurationMs();
    }

    @Override // b6a.b
    public int getFrame() {
        if (this.mAnimaXView != null) goto L7;
        return 0;
    L7:
        return (int) this.mAnimaXView.getCurrentFrame();
    }

    @Override // b6a.b
    public float getMaxFrame() {
        int r100 = this.mEndFrame;
        if (r100 != (-1)) goto L6;
        return this.mModelEndFrame;
    L6:
        return r100;
    }

    @Override // b6a.b
    public float getMinFrame() {
        int r100 = this.mStartFrame;
        if (r100 != 0) goto L6;
        return this.mModelStartFrame;
    L6:
        return r100;
    }

    @Override // b6a.b
    public float getProgress() {
        if (this.mIsAnimationReady == true) goto L6;
        return 0.0f;
    L6:
        x4a.e r100 = this.mAnimaXView;
        Objects.requireNonNull(r100);
        return (float) progressForFrame(r100.getCurrentFrame());
    }

    @Override // b6a.b
    public float getScale() {
        return INVOKEVIRTUAL_com_lynx_lottieadapter_LottieAdapterAnimaX_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mContext.getResources()).density;
    }

    @Override // b6a.b
    public boolean isAnimating() {
        if (this.mAnimaXView != null) goto L7;
        return false;
    L7:
        return this.mAnimaXView.isAnimating();
    }

    @Override // b6a.b
    public void pauseAnimation() {
        enqueueOperation(new t(this));
    }

    @Override // b6a.b
    public void playAnimation() {
        enqueueOperation(new q(this));
    }

    public void removeAllAnimatorListeners() {
        removeExternalListeners(Animator.AnimatorListener.class);
    }

    public void removeAllUpdateListeners() {
        removeExternalListeners(ValueAnimator.AnimatorUpdateListener.class);
    }

    @Override // b6a.b
    public void resumeAnimation() {
        enqueueOperation(new r(this));
    }

    private boolean showImageDrawableView() {
        if (ensureImageDrawableView() == true) goto L5;
        return false;
    L5:
        this.mImageDrawableView.setVisibility(0);
        return true;
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        noticeNotImplemented("removeAllLottieOnCompositionLoadedListener");
    }

    @Override // b6a.b
    public ColorFilter getColorFilter() {
        return this.mColorFilter;
    }

    @Override // b6a.b
    public c6a.c getComposition() {
        return this.mComposition;
    }

    @Override // b6a.b
    public AnimationType getContentType() {
        return AnimationType.ANIMAX;
    }

    @Override // b6a.b
    public String getImageAssetsFolder() {
        return this.mImageAssetsFolder;
    }

    @Override // b6a.b
    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    @Override // b6a.b
    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    @Override // b6a.b
    public float getSpeed() {
        return this.mSpeed;
    }

    public LottieAdapterAnimaX(Context r100) {
        this.mStartFrame = 0;
        this.mEndFrame = -1;
        this.mSpeed = 1.0f;
        this.mMaxFrameRate = 60.0f;
        this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        this.mExternalListeners = Collections.synchronizedSet(new HashSet());
        this.mOperationQueue = new CopyOnWriteArrayList();
        this.mAutoPlay = false;
        this.mIsAnimationReady = false;
        this.mUseImageMode = false;
        this.mMultiThreadAccelerate = false;
        this.mContext = r100.getApplicationContext();
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_lynx_lottieadapter_LottieAdapterAnimaX_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static /* synthetic */ void access$000(LottieAdapterAnimaX r100) {
        r100.onSetParentView();
    }

    public static /* synthetic */ int access$1100(LottieAdapterAnimaX r100) {
        return r100.mEndFrame;
    }

    public static /* synthetic */ Context access$1400(LottieAdapterAnimaX r100) {
        return r100.mContext;
    }

    public static /* synthetic */ x4a.e access$300(LottieAdapterAnimaX r100) {
        return r100.mAnimaXView;
    }

    public static /* synthetic */ float access$400(LottieAdapterAnimaX r100) {
        return r100.mModelEndFrame;
    }

    public static /* synthetic */ float access$500(LottieAdapterAnimaX r100) {
        return r100.mModelStartFrame;
    }

    public static /* synthetic */ int access$900(LottieAdapterAnimaX r100) {
        return r100.mStartFrame;
    }

    private int adjustEndFrame(int r100) {
        if (r100 >= 0) goto L6;
        float r101 = this.mModelEndFrame;
    L5:
        return (int) r101;
    L6:
        r101 = MathUtils.clamp(r100, this.mModelStartFrame, this.mModelEndFrame);
        goto L5
    }

    private int adjustStartFrame(int r100) {
        return (int) MathUtils.clamp(r100, this.mModelStartFrame, this.mModelEndFrame);
    }

    private void enqueueOperation(Runnable r100) {
        if (this.mIsAnimationReady == false) goto L5;
        r100.run();
        return;
    L5:
        this.mOperationQueue.add(r100);
    }

    private double frameForProgress(double r100) {
        float r101 = this.mModelStartFrame;
        return MathUtils.clamp(Math.round(((double) r101) + (((double) (this.mModelEndFrame - r101)) * r100)), this.mModelStartFrame, this.mModelEndFrame);
    }

    private AnimaXValueParam getColorFilterParam(PorterDuffColorFilter r100) {
        Method r101 = PorterDuffColorFilter.class.getDeclaredMethod("getColor", new Class[0]);     // Catch: Exception -> L4
        r101.setAccessible(true);     // Catch: Exception -> L4
        int r102 = ((Integer) r101.invoke(r100, new Object[0])).intValue();     // Catch: Exception -> L4
        Method r103 = PorterDuffColorFilter.class.getDeclaredMethod("getMode", new Class[0]);     // Catch: Exception -> L4
        r103.setAccessible(true);     // Catch: Exception -> L4
        return AnimaXValueParam.fromColorFilter(r102, ((PorterDuff.Mode) r103.invoke(r100, new Object[0])).ordinal());
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private void internalSetImageDrawable(Drawable r100) {
        if (r100 != null) goto L7;
        hideImageDrawableView();
        if (this.mAnimaXView == null) goto L12;
        ((View) this.mAnimaXView).setVisibility(0);
        return;
    L12:
        return;
    L7:
        if (showImageDrawableView() == false) goto L14;
        this.mImageDrawableView.setImageDrawable(r100);
        if (this.mAnimaXView == null) goto L15;
        ((View) this.mAnimaXView).setVisibility(8);
        return;
    L15:
        return;
    }

    private void noticeNotImplemented(String r100) {
        AnimaXLog.d(TAG, "!!!! " + r100 + " not implemented !!!!");
    }

    private void onSetAnimationFromJson(String r100) {
        if (ensureAnimaXView() == true) goto L5;
        return;
    L5:
        onSetAnimationWithNewData();
        this.mCurrentUrl = null;
        x4a.e r101 = this.mAnimaXView;
        Objects.requireNonNull(r101);
        r101.setJson(r100);
    }

    private void onSetAnimationFromUrl(String r100) {
        if (ensureAnimaXView() == true) goto L6;
        return;
    L6:
        if (r100.equals(this.mCurrentUrl) == false) goto L11;
        AnimaXLog.d(TAG, "setAnimationFromUrl url not changed, do nothing");
        View r101 = (View) this.mAnimaXView;
        Objects.requireNonNull(r101);
        r101.setVisibility(0);
        if (this.mIsAnimationReady == false) goto L13;
        hideImageDrawableView();
        return;
    L13:
        return;
    L11:
        onSetAnimationWithNewData();
        this.mCurrentUrl = r100;
        x4a.e r102 = this.mAnimaXView;
        Objects.requireNonNull(r102);
        r102.setSrc(r100);
    }

    private double progressForFrame(double r100) {
        float r101 = this.mModelEndFrame;
        float r102 = this.mModelStartFrame;
        if ((r101 - r102) >= 1.0E-6d) goto L10;
        if (r100 > r102) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        return 1.0d;
    L10:
        return MathUtils.clamp((r100 - ((double) r102)) / ((double) (r101 - r102)), AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d);
    }

    private void removeExternalListeners(Class<?> r100) {
        Iterator r101 = this.mExternalListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if (r100.isInstance(r101.next()) == false) goto L4;
        r101.remove();
        goto L4
    }

    private void runOnUIThread(Runnable r100) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        r100.run();
        return;
    L5:
        this.mMainThreadHandler.post(r100);
    }

    private void subscribeAllUpdateEvents(boolean r100) {
        enqueueOperation(new v(this, r100));
    }

    private AnimaXValueParam toAnimaXValueParam(Object r100) {
        if ((r100 instanceof Integer) == false) goto L7;
        return AnimaXValueParam.fromNumber(((Integer) r100).doubleValue());
    L7:
        if ((r100 instanceof PointF) == false) goto L11;
        PointF r101 = (PointF) r100;
        return AnimaXValueParam.a(r101.x, r101.y);
    L11:
        if ((r100 instanceof Float) == false) goto L15;
        return AnimaXValueParam.fromNumber(((Float) r100).doubleValue());
    L15:
        if ((r100 instanceof String) == false) goto L19;
        return AnimaXValueParam.fromString((String) r100);
    L19:
        if ((r100 instanceof e6a.c) == false) goto L23;
        e6a.c r102 = (e6a.c) r100;
        return AnimaXValueParam.a(r102.f471153a, r102.f471154b);
    L23:
        if ((r100 instanceof PorterDuffColorFilter) == true) goto L25;
        return null;
    L25:
        return getColorFilterParam((PorterDuffColorFilter) r100);
    }

    private <T> LayerPropertyType toLayerPropertyType(T r100) {
        if (r100 != c6a.d.f22604a) goto L7;
        return LayerPropertyType.COLOR;
    L7:
        if (r100 != c6a.d.f22605b) goto L11;
        return LayerPropertyType.STROKE_COLOR;
    L11:
        if (r100 != c6a.d.f22606c) goto L15;
        return LayerPropertyType.TRANSFORM_OPACITY;
    L15:
        if (r100 != c6a.d.f22607d) goto L19;
        return LayerPropertyType.OPACITY;
    L19:
        if (r100 != c6a.d.f22608e) goto L23;
        return LayerPropertyType.TRANSFORM_ANCHOR;
    L23:
        if (r100 != c6a.d.f22609f) goto L27;
        return LayerPropertyType.TRANSFORM_POSITION;
    L27:
        if (r100 != c6a.d.f22610g) goto L31;
        return LayerPropertyType.ELLIPSE_SIZE;
    L31:
        if (r100 != c6a.d.f22611h) goto L35;
        return LayerPropertyType.RECTANGLE_SIZE;
    L35:
        if (r100 != c6a.d.f22612i) goto L39;
        return LayerPropertyType.CORNER_RADIUS;
    L39:
        if (r100 != c6a.d.f22613j) goto L43;
        return LayerPropertyType.POSITION;
    L43:
        if (r100 != c6a.d.f22614k) goto L47;
        return LayerPropertyType.TRANSFORM_SCALE;
    L47:
        if (r100 != c6a.d.f22615l) goto L51;
        return LayerPropertyType.TRANSFORM_ROTATION;
    L51:
        if (r100 != c6a.d.f22616m) goto L55;
        return LayerPropertyType.TRANSFORM_SKEW;
    L55:
        if (r100 != c6a.d.f22617n) goto L59;
        return LayerPropertyType.TRANSFORM_SKEW_ANGLE;
    L59:
        if (r100 != c6a.d.f22618o) goto L63;
        return LayerPropertyType.STROKE_WIDTH;
    L63:
        if (r100 != c6a.d.f22619p) goto L67;
        return LayerPropertyType.TEXT_TRACKING;
    L67:
        if (r100 != c6a.d.f22620q) goto L71;
        return LayerPropertyType.REPEATER_COPIES;
    L71:
        if (r100 != c6a.d.f22622s) goto L75;
        return LayerPropertyType.POLYSTAR_POINTS;
    L75:
        if (r100 != c6a.d.f22623t) goto L79;
        return LayerPropertyType.POLYSTAR_ROTATION;
    L79:
        if (r100 != c6a.d.f22624u) goto L83;
        return LayerPropertyType.POLYSTAR_INNER_RADIUS;
    L83:
        if (r100 != c6a.d.f22625v) goto L87;
        return LayerPropertyType.POLYSTAR_OUTER_RADIUS;
    L87:
        if (r100 != c6a.d.f22626w) goto L91;
        return LayerPropertyType.POLYSTAR_INNER_ROUNDED;
    L91:
        if (r100 != c6a.d.f22627x) goto L95;
        return LayerPropertyType.POLYSTAR_OUTER_ROUNDED;
    L95:
        if (r100 != c6a.d.f22628y) goto L99;
        return LayerPropertyType.TRANSFORM_START_OPACITY;
    L99:
        if (r100 != c6a.d.f22629z) goto L103;
        return LayerPropertyType.TRANSFORM_END_OPACITY;
    L103:
        if (r100 != c6a.d.B) goto L107;
        return LayerPropertyType.TEXT_SIZE;
    L107:
        if (r100 == c6a.d.C) goto L109;
        return null;
    L109:
        return LayerPropertyType.COLOR_FILTER;
    }

    private e6a.a toLottieFrameInfo(com.lynx.animax.property.a r100) {
        e6a.a r101 = new e6a.a();
        float r102 = r100.f380408a;
        return r101;
    }

    public void addAnimatorListener(Animator.AnimatorListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mExternalListeners.add(r100);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (isUpdateListenersEmpty() == false) goto L7;
        subscribeAllUpdateEvents(true);
    L7:
        this.mExternalListeners.add(r100);
    }

    public void removeAnimatorListener(Animator.AnimatorListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mExternalListeners.remove(r100);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mExternalListeners.remove(r100);
        if (isUpdateListenersEmpty() == false) goto L8;
        subscribeAllUpdateEvents(false);
        return;
    }

    public List<d6a.a> resolveKeyPath(d6a.a r100) {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L5;
        return r101;
    L5:
        AnimaXKeyPath r102 = new AnimaXKeyPath((String[]) r100.f467213a.toArray(new String[0]));
        CountDownLatch r103 = new CountDownLatch(1);
        this.mAnimaXView.getPlayer().g(r102, new a(r101, r103));
        r103.await(1000, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L8
    L9:
        return r101;
    L8:
        ThreadMethodProxy.currentThread().interrupt();
        goto L9
    }

    @Override // b6a.b
    public void setAnimation(int r100) {
        InputStream r101 = this.mContext.getResources().openRawResource(r100);     // Catch: Exception -> L16
        byte[] r102 = new byte[r101.available()];     // Catch: Throwable -> L7
        r101.read(r102);     // Catch: Throwable -> L7
        setAnimationFromJson(new String(r102, "UTF-8"));     // Catch: Throwable -> L7
        r101.close();     // Catch: Exception -> L16
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r101 != null) goto L24;
    L15:
        throw th;     // Catch: Exception -> L16
    L24:
        r101.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        AnimaXLog.a(TAG, "Failed to load animation from raw resource: " + e.getMessage());
    }

    @Override // b6a.b
    public void setAnimationFromJson(String r100) {
        if (r100 != null) goto L4;
    L8:
        AnimaXLog.d(TAG, "setAnimationFromJson with empty jsonString, do nothing");
        return;
    L4:
        if (r100.isEmpty() == true) goto L8;
        runOnUIThread(new o(this, r100));
    }

    @Override // b6a.b
    public void setAnimationFromUrl(String r100) {
        if (r100 != null) goto L4;
    L8:
        AnimaXLog.d(TAG, "setAnimationFromUrl with empty url, do nothing");
        return;
    L4:
        if (r100.isEmpty() == true) goto L8;
        runOnUIThread(new p(this, r100));
    }

    @Override // b6a.b
    public void setAutoPlay(boolean r100) {
        this.mAutoPlay = r100;
        if (this.mAnimaXView == null) goto L6;
        this.mAnimaXView.setAutoPlay(r100);
        return;
    }

    @Override // b6a.b
    public void setColorFilter(ColorFilter r100) {
        this.mColorFilter = r100;
        if (this.mImageDrawableView == null) goto L6;
        this.mImageDrawableView.setColorFilter(r100);
        return;
    }

    @Override // b6a.b
    public void setComposition(c6a.c r100) {
        this.mComposition = r100;
        if (this.mAnimaXView == null) goto L6;
        setCompositionToAnimaXView(this.mAnimaXView, r100);
        return;
    }

    @Override // b6a.b
    public void setFontAssetDelegate(c6a.a r100) {
        noticeNotImplemented("setFontAssetDelegate");
    }

    @Override // b6a.b
    public void setFrame(int r100) {
        enqueueOperation(new j(this, r100));
    }

    @Override // b6a.b
    public void setImageAssetDelegate(c6a.b r100) {
        noticeNotImplemented("setImageAssetDelegate");
    }

    @Override // b6a.b
    public void setImageAssetsFolder(String r100) {
        this.mImageAssetsFolder = r100;
        if (this.mAnimaXView == null) goto L10;
        if (r100 != null) goto L6;
    L8:
        this.mAnimaXView.setImageFolder(null);
        return;
    L6:
        if (r100.isEmpty() == true) goto L8;
        this.mAnimaXView.setImageFolder(r100);
        return;
    }

    @Override // b6a.b
    public void setImageDrawable(Drawable r100) {
        runOnUIThread(new m(this, r100));
    }

    @Override // b6a.b
    public void setImageResource(int r100) {
        if (r100 != 0) goto L5;
        AnimaXLog.d(TAG, "Image resource id is 0");
        return;
    L5:
        runOnUIThread(new l(this, r100));
    }

    @Override // b6a.b
    public void setMaxFrame(int r100) {
        this.mEndFrame = r100;
        enqueueOperation(new e(this));
    }

    @Override // b6a.b
    public void setMaxFrameRate(float r100) {
        if (r100 >= 1.0f) goto L5;
        return;
    L5:
        this.mMaxFrameRate = r100;
        if (this.mAnimaXView == null) goto L9;
        this.mAnimaXView.setMaxFrameRate(this.mMaxFrameRate);
        return;
    }

    @Override // b6a.b
    public void setMaxProgress(float r100) {
        enqueueOperation(new h(this, r100));
    }

    @Override // b6a.b
    public void setMinFrame(int r100) {
        this.mStartFrame = r100;
        enqueueOperation(new d(this, r100));
    }

    @Override // b6a.b
    public void setMinProgress(float r100) {
        enqueueOperation(new g(this, r100));
    }

    @Override // b6a.b
    public void setOption(b6a.k r100) {
        this.mUseImageMode = r100.f17893b;
        this.mMultiThreadAccelerate = r100.f17894c;
    }

    @Override // b6a.b
    public void setParentView(ViewGroup r100) {
        this.mParentViewRef = new WeakReference(r100);
        runOnUIThread(new k(this));
    }

    @Override // b6a.b
    public void setProgress(float r100) {
        enqueueOperation(new u(this, r100));
    }

    @Override // b6a.b
    public void setRepeatCount(int r100) {
        this.mRepeatCount = r100;
        if (this.mAnimaXView == null) goto L6;
        setRepeatCountToAnimaXView(this.mAnimaXView, r100);
        return;
    }

    @Override // b6a.b
    public void setRepeatMode(int r100) {
        this.mRepeatMode = r100;
        if (this.mAnimaXView == null) goto L6;
        setRepeatModeToAnimaXView(this.mAnimaXView, r100);
        return;
    }

    @Override // b6a.b
    public void setScale(float r100) {
        noticeNotImplemented("setScale");
    }

    @Override // b6a.b
    public void setScaleType(ImageView.ScaleType r100) {
        this.mScaleType = r100;
        if (this.mImageDrawableView == null) goto L5;
        this.mImageDrawableView.setScaleType(r100);
    L5:
        setScaleTypeToAnimaXView(this.mAnimaXView, r100);
    }

    @Override // b6a.b
    public void setSpeed(float r100) {
        this.mSpeed = r100;
        if (this.mAnimaXView == null) goto L6;
        this.mAnimaXView.setSpeed(r100);
        return;
    }

    @Override // b6a.b
    public void setAnimation(JSONObject r100) {
        if (r100 == null) goto L4;
        String r101 = r100.toString();
    L5:
        setAnimationFromJson(r101);
        return;
    L4:
        r101 = null;
        goto L5
    }

    @Override // b6a.b
    public void setAnimation(String r100) {
        setAnimationFromUrl(y4a.e.a(r100));
    }

    public static /* synthetic */ void access$100(LottieAdapterAnimaX r100, String r101) {
        r100.onSetAnimationFromJson(r101);
    }

    public static /* synthetic */ int access$1000(LottieAdapterAnimaX r100, int r101) {
        return r100.adjustStartFrame(r101);
    }

    public static /* synthetic */ int access$1102(LottieAdapterAnimaX r100, int r101) {
        r100.mEndFrame = r101;
        return r101;
    }

    public static /* synthetic */ int access$1200(LottieAdapterAnimaX r100, int r101) {
        return r100.adjustEndFrame(r101);
    }

    public static /* synthetic */ double access$1300(LottieAdapterAnimaX r100, double r101) {
        return r100.frameForProgress(r101);
    }

    public static /* synthetic */ void access$1500(LottieAdapterAnimaX r100, Drawable r101) {
        r100.internalSetImageDrawable(r101);
    }

    public static /* synthetic */ void access$200(LottieAdapterAnimaX r100, String r101) {
        r100.onSetAnimationFromUrl(r101);
    }

    public static /* synthetic */ LayerPropertyType access$600(LottieAdapterAnimaX r100, Object r101) {
        return r100.toLayerPropertyType(r101);
    }

    public static /* synthetic */ e6a.a access$700(LottieAdapterAnimaX r100, com.lynx.animax.property.a r101) {
        return r100.toLottieFrameInfo(r101);
    }

    public static /* synthetic */ AnimaXValueParam access$800(LottieAdapterAnimaX r100, Object r101) {
        return r100.toAnimaXValueParam(r101);
    }

    public static /* synthetic */ int access$902(LottieAdapterAnimaX r100, int r101) {
        r100.mStartFrame = r101;
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> void executeExternalListeners(Class<T> r100, Consumer<T> r101) {
        Iterator r102 = new ArrayList(this.mExternalListeners).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (r100.isInstance(r103) == false) goto L4;
        r101.accept(r103);
        goto L4
    }

    private void onAnimationReady(float r100, float r101) {
        this.mIsAnimationReady = true;
        this.mModelStartFrame = r100;
        this.mModelEndFrame = r101;
        flushOperationQueue();
        hideImageDrawableView();
    }

    private static void setCompositionToAnimaXView(x4a.e r100, c6a.c r101) {
        if (r101 == null) goto L7;
        Object r102 = r101.f22603a;
        if ((r102 instanceof AnimaXComposition) == false) goto L8;
        r100.setComposition((AnimaXComposition) r102);
        return;
    L8:
        return;
    }

    private static void setRepeatCountToAnimaXView(x4a.e r100, int r101) {
        if (r101 == (-1)) goto L11;
        if (r101 < 0) goto L11;
        r100.setLoop(false);
        if (r101 > 0) goto L10;
        r101 = 1;
    L10:
        r100.setLoopCount(r101);
        return;
    L11:
        r100.setLoop(true);
    }

    private static void setRepeatModeToAnimaXView(x4a.e r100, int r101) {
        if (r101 != 1) goto L5;
        r100.setAutoReverse(false);
        return;
    L5:
        if (r101 != 2) goto L11;
        r100.setAutoReverse(true);
        return;
    }

    private static void setScaleTypeToAnimaXView(x4a.e r100, ImageView.ScaleType r101) {
        if (r100 == null) goto L15;
        if (r101 != null) goto L6;
        return;
    L6:
        switch(n.f381409a[r101.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L7:
        ObjectFit r102 = ObjectFit.CONTAIN;
    L13:
        r100.setObjectFit(r102);
        return;
    L8:
        r102 = ObjectFit.FILL;
        goto L13
    L9:
        r102 = ObjectFit.CONTAIN;
        goto L13
    L10:
        r102 = ObjectFit.SCALE_DOWN;
        goto L13
    L11:
        r102 = ObjectFit.COVER;
        goto L13
    L12:
        r102 = ObjectFit.CENTER;
        goto L13
    }

    public void setMinAndMaxFrame(int r100, int r101) {
        this.mStartFrame = r100;
        this.mEndFrame = r101;
        enqueueOperation(new f(this, r100, r101));
    }

    @Override // b6a.b
    public void setMinAndMaxProgress(float r100, float r101) {
        enqueueOperation(new i(this, r100, r101));
    }

    public Bitmap updateBitmap(String r100, Bitmap r101) {
        noticeNotImplemented("updateBitmap");
        return null;
    }

    public static /* synthetic */ void access$1600(LottieAdapterAnimaX r100, float r101, float r102) {
        r100.onAnimationReady(r101, r102);
    }

    public static /* synthetic */ void access$1700(LottieAdapterAnimaX r100, Class r101, Consumer r102) {
        r100.executeExternalListeners(r101, r102);
    }

    private static void addViewToParent(View r100, ViewGroup r101, View r102) {
        ViewGroup r103 = (ViewGroup) r100.getParent();
        if (r103 != r101) goto L5;
        return;
    L5:
        if (r103 == null) goto L7;
        r103.removeView(r100);
    L7:
        int r104 = -1;
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-1, -1);
        if (r102 == null) goto L10;
        r104 = r101.indexOfChild(r102);
    L10:
        if (r104 < 0) goto L12;
        r101.addView(r100, r104, r105);
        return;
    L12:
        r101.addView(r100, r105);
    }

    public <T> void addValueCallback(d6a.a r100, T r101, e6a.b<T> r102) {
        enqueueOperation(new b(this, r100, r101, r102));
    }

    @Override // b6a.b
    public <T> void addValueCallback(d6a.a r100, T r101, e6a.d<T> r102) {
        addValueCallback(r100, r101, new c(r102));
    }
}
