package com.larus.common_ui.floatwindow.view;

import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewKt;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.w0;
import hq9.f1;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import v19.c7;

/* JADX INFO: loaded from: classes27.dex */
public final class SingleFloatBall extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0 f327467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f327468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f327469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u f327470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WindowManager.LayoutParams f327471e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f327472f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f327473g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewGroup f327474h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f327475i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ImageView f327476j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f327477k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f327478l;

    public static final class a {
    }

    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public b(CoroutineExceptionHandler.Key r100) {
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            FLogger.f375446a.e("SingleFloatBall", "autoUpdateBlurMask CoroutineScope fail: " + r101);
        }
    }

    static {
    }

    private final f1 getFloatWindowConfig() {
        return (f1) this.f327477k.getValue();
    }

    public final void a() {
        Bitmap r100 = ViewKt.drawToBitmap$default(this.f327472f, null, 1, null);     // Catch: Exception -> L8
        float r101 = 1024;
        float r102 = r100.getWidth();     // Catch: Exception -> L8
        float r103 = r100.getHeight();     // Catch: Exception -> L8
        float r104 = Math.min(r101 / r102, r101 / r103);     // Catch: Exception -> L8
        if (r104 >= 1.0d) goto L6;
        r100 = Bitmap.createScaledBitmap(r100, (int) (r102 * r104), (int) (r103 * r104), true);     // Catch: Exception -> L8
    L6:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), new b(CoroutineExceptionHandler.Key), null, new SingleFloatBall$autoUpdateBlurMask$2(this, r100, null), 2, null);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        FLogger.f375446a.e("SingleFloatBall", "autoUpdateBlurMask fail: " + e);
    }

    public final boolean b() {
        if ((this.f327471e.gravity & 7) != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public final u getHotInfo() {
        return this.f327470d;
    }

    public final WindowManager.LayoutParams getParams() {
        return this.f327471e;
    }

    public final void c(WindowManager.LayoutParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f327468b.updateViewLayout(this, r100);
        m0 r101 = this.f327467a;
        WindowManager.LayoutParams r102 = r101.f327531g.getParams();
        if (r102.x >= 0) goto L13;
        SingleFloatBall r103 = r101.f327531g;
        if (r103.b() == false) goto L7;
        ImageView r104 = r103.f327475i;
    L8:
        e1.o(r104);
        float r105 = RangesKt.coerceAtMost(Math.abs(r102.x) / (r102.width / 2), 1.0f);
        SingleFloatBall r106 = r101.f327531g;
        if (r106.b() == false) goto L11;
        ViewGroup r107 = r106.f327473g;
    L12:
        r107.setAlpha(r105);
        e1.x(r107);
        return;
    L11:
        r107 = r106.f327474h;
        goto L12
    L7:
        r104 = r103.f327476j;
        goto L8
    L13:
        SingleFloatBall r108 = r101.f327531g;
        if (r108.b() == false) goto L16;
        ViewGroup r109 = r108.f327473g;
    L17:
        e1.o(r109);
        return;
    L16:
        r109 = r108.f327474h;
        goto L17
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (r100.getActionMasked() != 0) goto L8;
        e19.t r101 = e19.t.f470740j;
        e19.t r102 = e19.t.a.a();
        if (r102 == null) goto L7;
        r102.k(null);
    L7:
        a();
    L8:
        z r103 = this.f327469c;
        r103.getClass();
        Intrinsics.checkNotNullParameter(this, "view");
        Intrinsics.checkNotNullParameter(r100, "event");
        int r104 = r100.getActionMasked();
        boolean r105 = false;
        if (r104 != 0) goto L11;
        r103.a(this, r100);
    L22:
        return r105;
    L11:
        if (r104 != 2) goto L22;
        if (r103.f327571i == true) goto L23;
        float r106 = r100.getRawX() - r103.f327567e;
        float r107 = r100.getRawY() - r103.f327568f;
        if (((r106 * r106) + (r107 * r107)) <= r103.f327565c) goto L19;
        r105 = true;
    L19:
        r103.f327571i = r105;
        goto L22
    L23:
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        z r100 = this.f327469c;
        r100.getClass();
        Intrinsics.checkNotNullParameter(this, "view");
        Intrinsics.checkNotNullParameter(r110, "event");
        int r101 = r110.getActionMasked();
        if (r101 == 0) goto L50;
        if (r101 != 1) goto L6;
        View.OnClickListener r102 = r100.f327564b;
        if (r102 != null) goto L46;
    L51:
        int r111 = r110.getActionMasked();
        if (r111 == 0) goto L57;
        if (r111 == 1) goto L56;
        if (r111 == 3) goto L56;
    L58:
        return true;
    L56:
        this.f327467a.n(false, false);
        goto L58
    L57:
        this.f327467a.getClass();
        goto L58
    L46:
        if (r100.f327571i == true) goto L51;
        if ((SystemClock.uptimeMillis() - r100.f327570h) > r100.f327566d) goto L51;
        r102.onClick(this);
        goto L51
    L6:
        if (r101 != 2) goto L51;
        if (r100.f327571i == true) goto L17;
        float r103 = r110.getRawX() - r100.f327567e;
        float r104 = r110.getRawY() - r100.f327568f;
        if (((r103 * r103) + (r104 * r104)) <= r100.f327565c) goto L13;
        boolean r105 = true;
    L14:
        r100.f327571i = r105;
        if (r105 == true) goto L17;
    L13:
        r105 = false;
    L17:
        WindowManager.LayoutParams r106 = r100.f327563a.getParams();
        Integer r107 = Integer.valueOf(r100.f327569g);
        if (r107.intValue() <= 0) goto L20;
        boolean r108 = true;
    L21:
        if (r108 == true) goto L24;
        r107 = null;
    L24:
        if (r107 == null) goto L26;
        int r109 = r107.intValue();
    L27:
        int r112 = (int) (r110.getRawX() - r100.f327567e);
        int r113 = (int) (r110.getRawY() - r100.f327568f);
        r100.f327567e = r110.getRawX();
        r100.f327568f = r110.getRawY();
        int r114 = r106.gravity & 7;
        if (r114 != 3) goto L30;
        int r115 = r106.x + r112;
    L31:
        r106.x = r115;
        r106.y += r113;
        if (r114 != 3) goto L37;
        int r116 = r106.width;
        if (((r116 / 2) + r115) < (r109 / 2)) goto L40;
        r106.x = (r109 - r115) - r116;
    L41:
        int r117 = 5;
    L42:
        r106.gravity = r117 | 48;
        r100.f327563a.c(r106);
    L40:
        r117 = 3;
        goto L42
    L37:
        int r118 = r106.width;
        if (((r118 / 2) + r115) <= (r109 / 2)) goto L41;
        r106.x = (r109 - r115) - r118;
        goto L40
    L30:
        r115 = r106.x - r112;
        goto L31
    L26:
        r109 = com.larus.utils.i.d(getContext());
        goto L27
    L20:
        r108 = false;
        goto L21
    L50:
        r100.a(this, r110);
        goto L51
    }

    @Override // android.view.View
    public void setAlpha(float r100) {
        h r101 = this.f327468b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(this, "view");
        Iterator<T> r102 = r101.f327502a.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((Pair) r103).getFirst(), this) == false) goto L4;
    L9:
        Pair r104 = (Pair) r103;
        if (r104 == null) goto L13;
        ((ImageView) r104.getSecond()).setAlpha(r100);
    L13:
        super.setAlpha(r100);
        return;
    L8:
        r103 = null;
        goto L9
    }

    public final void setClipViewCornerRadius(int r100) {
        this.f327478l = r100;
        h r101 = this.f327468b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(this, "view");
        w0.e(this, r100);
        r101.f327506e = r100;
        Intrinsics.checkNotNullParameter(this, "view");
        Iterator<T> r102 = r101.f327502a.iterator();
    L3:
        ImageView r103 = null;
        if (r102.hasNext() == false) goto L8;
        Object r104 = r102.next();
        if (Intrinsics.areEqual(((Pair) r104).getFirst(), this) == false) goto L3;
    L9:
        Pair r105 = (Pair) r104;
        if (r105 == null) goto L12;
        r103 = (ImageView) r105.getSecond();
    L12:
        if (r103 == null) goto L18;
        r103.setImageBitmap(h.c(r103.getLayoutParams().width, r103.getLayoutParams().height, r100, r101.f327505d, r101.f327507f));
        return;
    L18:
        return;
    L8:
        r104 = null;
        goto L9
    }

    public final void setMaskClickListener(View.OnClickListener r100) {
        if (b() == false) goto L5;
        this.f327473g.setOnClickListener(r100);
    L7:
        if (r100 == null) goto L13;
        h r101 = this.f327468b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(this, "view");
        View r102 = (View) ((LinkedHashMap) r101.f327503b).get(this);
        if (r102 == null) goto L11;
        r102.setVisibility(0);
        r102.setOnClickListener(r100);
    L12:
        if (r102 == null) goto L13;
        return;
    L11:
        r102 = null;
    L13:
        h r103 = this.f327468b;
        r103.getClass();
        Intrinsics.checkNotNullParameter(this, "view");
        View r104 = (View) ((LinkedHashMap) r103.f327503b).get(this);
        if (r104 == null) goto L16;
        r104.setVisibility(8);
    L16:
        Unit r105 = Unit.INSTANCE;
        return;
    L5:
        this.f327474h.setOnClickListener(r100);
        goto L7
    }

    public SingleFloatBall(Application r100, m0 r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, "application");
        Intrinsics.checkNotNullParameter(r101, "handler");
        Intrinsics.checkNotNullParameter(r102, "winManager");
        super(r100);
        this.f327467a = r101;
        this.f327468b = r102;
        this.f327477k = LazyKt.lazy(new x());
        View r103 = LayoutInflater.from(r100).inflate(R.layout.larus_float_ball, this, false);
        addView(r103);
        Activity r104 = AppHost.f326268a.a().getCurrentActivity();
        if ((r104 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r105 = (FragmentActivity) r104;
    L6:
        if (r105 == null) goto L8;
        int r106 = com.larus.utils.u.b(r105);
    L9:
        int r107 = r106 + c7.b(12);
        int r108 = c7.b(6);
        this.f327470d = new u(r108, com.larus.utils.i.e(getContext()) + c7.b(12), r107);
        this.f327472f = (ViewGroup) r103.findViewById(R.id.container);
        this.f327473g = (ViewGroup) r103.findViewById(R.id.leftMaskContainer);
        this.f327474h = (ViewGroup) r103.findViewById(R.id.rightMaskContainer);
        if (getFloatWindowConfig().d() == true) goto L12;
        int r109 = R.id.leftMaskIcon;
    L16:
        this.f327475i = (ImageView) r103.findViewById(r109);
        if (getFloatWindowConfig().d() == true) goto L19;
        int r110 = R.id.rightMaskIcon;
    L23:
        this.f327476j = (ImageView) r103.findViewById(r110);
        WindowManager.LayoutParams r111 = new WindowManager.LayoutParams();
        r111.format = -2;
        r111.flags = 552;
        if (Build.VERSION.SDK_INT >= 26) goto L26;
        r111.type = 2003;
    L27:
        this.f327471e = r111;
        r111.gravity = 53;
        r111.x = r108;
        r111.y = com.larus.utils.i.e(getContext()) + c7.b(80);
        r111.width = 0;
        r111.height = 0;
        z r112 = new z(this);
        this.f327469c = r112;
        r112.f327564b = new y(this);
        this.f327478l = c7.b(8);
        return;
    L26:
        r111.type = 2038;
        goto L27
    L19:
        if (getFloatWindowConfig().e() == false) goto L21;
        r110 = R.id.rightMaskIconMini;
        goto L23
    L21:
        r110 = R.id.rightMaskIconNew;
        goto L23
    L12:
        if (getFloatWindowConfig().e() == false) goto L14;
        r109 = R.id.leftMaskIconMini;
        goto L16
    L14:
        r109 = R.id.leftMaskIconNew;
        goto L16
    L8:
        com.larus.utils.i0.f375410a.getClass();
        r106 = com.larus.utils.i0.e();
        goto L9
    L5:
        r105 = null;
        goto L6
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        w0.e(this, this.f327478l);
    }
}
