package com.larus.camera.impl.ui.component.video;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.keva.Keva;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import kotlinx.coroutines.flow.e;
import v19.c7;

/* JADX INFO: loaded from: classes26.dex */
public final class CaptureRecorderComponent extends com.larus.camera.impl.ui.arch.b {
    public final String A;
    public Job B;
    public Job C;
    public final b D;
    public final c E;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView f322534m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ImageView f322535n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f322536o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f322537p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public FrameLayout f322538q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f322539r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ImageView f322540s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public GradientDrawable f322541t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f322542u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f322543v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Handler f322544w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f322545x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f322546y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f322547z;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaptureRecorderComponent f322548a;

        public final void a() {
            CaptureRecorderComponent r100 = this.f322548a;
            int r101 = r100.f322542u;
            r100.getClass();
            StringCompanionObject r102 = StringCompanionObject.INSTANCE;
            String r103 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r101 / 60), Integer.valueOf(r101 % 60)}, 2));
            TextView r104 = r100.f322536o;
            if (r104 == null) goto L5;
            r104.setText(r103);
        L5:
            CaptureRecorderComponent r105 = this.f322548a;
            int r106 = r105.f322542u;
            if (r106 < r105.f322543v) goto L10;
            FLogger.f375446a.i(r105.A, "[updateRunnable] max duration:" + this.f322548a.f322543v);
            CameraCaptureViewModel r107 = (CameraCaptureViewModel) com.larus.camera.impl.ui.arch.b.e(this.f322548a).a();
            if (r107 == null) goto L12;
            r107.updateRecordingState(px8.d.f.f530952a);
            return;
        L12:
            return;
        L10:
            r105.f322542u = r106 + 1;
            r105.f322544w.postDelayed(this, 1000);
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

        public b(CaptureRecorderComponent r100) {
            this.f322548a = r100;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaptureRecorderComponent f322549a;

        @Override // java.lang.Runnable
        public final void run() {
            CameraCaptureViewModel r100 = (CameraCaptureViewModel) com.larus.camera.impl.ui.arch.b.e(this.f322549a).a();     // Catch: Throwable -> L7
            if (r100 == null) goto L5;
            int r101 = r100.getRenderFps();     // Catch: Throwable -> L7
            qx8.a.f535156b.h(r101, "record");     // Catch: Throwable -> L7
        L5:
            this.f322549a.f322544w.postDelayed(this, 5000);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public c(CaptureRecorderComponent r100) {
            this.f322549a = r100;
        }
    }

    static {
    }

    public CaptureRecorderComponent() {
        com.larus.camera.impl.ui.arch.c r100 = com.larus.camera.impl.ui.arch.c.f321810a;
        super(17, com.larus.camera.impl.ui.arch.c.f321812c);
        Keva r101 = zx8.b.f573892a;
        this.f322543v = zx8.b.f573897f;
        this.f322544w = new Handler(Looper.getMainLooper());
        this.f322546y = true;
        this.f322547z = -1.0f;
        this.A = "CaptureRecorderComponent" + hashCode();
        this.D = new b(this);
        this.E = new c(this);
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [T, java.lang.Object] */
    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        FLogger r100 = FLogger.f375446a;
        r100.i(this.A, " [onViewCreated]");
        CameraCaptureViewModel r101 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r101 != null) goto L5;
        return;
    L5:
        BaseCameraViewModel.tryAdaptBottomLine$default(r101, (ConstraintLayout) h(R.id.container), 0, null, 6, null);
        GradientDrawable r102 = new GradientDrawable();
        r102.setShape(0);
        r102.setColor(ContextCompat.getColor(getContext(), R.color.danger_50));
        r102.setCornerRadius(c7.c(28));
        this.f322541t = r102;
        ImageView r103 = this.f322534m;
        if (r103 == null) goto L8;
        r103.setBackground(r102);
    L8:
        this.f322542u = 0;
        this.f322544w.post(this.D);
        this.f322544w.post(this.E);
        MotionEvent r104 = r101.getDownEvent();
        if (r104 == null) goto L13;
        r100.i(this.A, "downEvent " + r104);
        View r105 = this.f322545x;
        if (r105 == null) goto L13;
        r105.dispatchTouchEvent(r104);
    L13:
        this.B = e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r101.getCaptureButtonTouchEvent(), new CaptureRecorderComponent$onViewCreated$3(this, null)), k());
        Ref.ObjectRef r106 = new Ref.ObjectRef();
        r106.element = r101.getRecordingState().getValue();
        this.C = e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r101.getRecordingState(), new CaptureRecorderComponent$onViewCreated$4(this, r101, r106, null)), k());
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void n() {
        FLogger.f375446a.i(this.A, "onViewDestroyed");
        Job r100 = this.B;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        Job r101 = this.C;
        if (r101 == null) goto L8;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L8:
        this.f322544w.removeCallbacksAndMessages(null);
        this.B = null;
        this.C = null;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final CameraContainer.b f(int r100) {
        CameraContainer.b r101 = super.f(r100);
        ((FrameLayout.LayoutParams) r101).width = -1;
        ((FrameLayout.LayoutParams) r101).height = -1;
        return r101;
    }

    public final void r(float r100) {
        if (this.f322547z != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        this.f322547z = r100;
        FLogger.f375446a.i(this.A, "Zoom factor: " + r100);
        CameraCaptureViewModel r102 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r102 == null) goto L12;
        r102.zoom(r100);
        return;
    L12:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final View g(LayoutInflater r110, ViewGroup r111) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        Intrinsics.checkNotNullParameter(r111, "parent");
        View r112 = r110.inflate(R.layout.larus_layout_capture_recorder, r111, false);
        this.f322534m = (ImageView) r112.findViewById(R.id.recorder_icon);
        this.f322535n = (ImageView) r112.findViewById(R.id.hands_free_icon);
        this.f322536o = (TextView) r112.findViewById(R.id.recorder_duration);
        this.f322537p = (TextView) r112.findViewById(R.id.hands_free_tips);
        this.f322538q = (FrameLayout) r112.findViewById(R.id.focus_container_placeholder);
        this.f322539r = r112.findViewById(R.id.connect_line);
        this.f322540s = (ImageView) r112.findViewById(R.id.recorder_icon_bg);
        Intrinsics.checkNotNull(r112);
        final CameraCaptureViewModel r100 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r100 == null) goto L10;
        ImageView r113 = this.f322534m;
        if (r113 == null) goto L8;
        Context r114 = r113.getContext();
    L9:
        final GestureDetector r101 = new GestureDetector(r114, new d(r100, this));
        final Ref.FloatRef r102 = new Ref.FloatRef();
        final Rect r115 = new Rect();
        final Rect r103 = new Rect();
        final Rect r104 = new Rect();
        final Rect r116 = new Rect();
        final Ref.BooleanRef r105 = new Ref.BooleanRef();
        final Ref.BooleanRef r106 = new Ref.BooleanRef();
        r106.element = true;
        final Ref.IntRef r107 = new Ref.IntRef();
        r107.element = -1;
        r112.setOnTouchListener(new com.larus.camera.impl.ui.component.video.c(r105, r107, this, r100, r104, r101, r106, r103, r102, r115, r116));
        goto L10
    L8:
        r114 = null;
    L10:
        this.f322545x = r112;
        return r112;
    }

    public static final void p(CaptureRecorderComponent r100, int r101, float r102) {
        ImageView r103 = r100.f322534m;
        if (r103 == null) goto L5;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
    L6:
        if (r104 == null) goto L8;
        r104.width = r101;
    L8:
        if (r104 == null) goto L10;
        r104.height = r101;
    L10:
        ImageView r105 = r100.f322534m;
        if (r105 == null) goto L13;
        r105.setLayoutParams(r104);
    L13:
        GradientDrawable r106 = r100.f322541t;
        if (r106 == null) goto L17;
        r106.setCornerRadius(r102);
        return;
    L17:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public static final boolean q(CameraCaptureViewModel r100, Ref.BooleanRef r101, Ref.IntRef r102, CaptureRecorderComponent r103) {
        px8.d r104 = r100.getRecordingState().getValue();
        r101.element = false;
        r102.element = -1;
        r103.r(0.0f);
        if ((r104 instanceof px8.d.b) == false) goto L6;
        r100.updateRecordingState(px8.d.c.f530949a);
        r100.clickRecordOnCapturePage("record_hands_free");
        FLogger.f375446a.i(r103.A, "-> HandsFreeRecording");
        return true;
    L6:
        if ((r104 instanceof px8.d.C7253d) == false) goto L8;
    L12:
        r100.updateRecordingState(px8.d.f.f530952a);
        r100.clickRecordOnCapturePage("record_end");
        FLogger.f375446a.i(r103.A, "-> RecordingEnd");
        return true;
    L8:
        if ((r104 instanceof px8.d.e) == true) goto L12;
        FLogger.f375446a.i(r103.A, "finalize with state=" + r104 + " (no-op)");
        return false;
    }
}
