package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.host;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.p013float.MmFloatView;
import com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model.MmRecordingFloatSide;
import kotlin.Pair;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f436850o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f436851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f436852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f436853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f436854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f436855e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameLayout f436856f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FrameLayout f436857g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FrameLayout f436858h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public qub.g f436859i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f436860j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public g f436861k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Context f436862l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f436863m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Runnable f436864n;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f436865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ hwb.c f436866b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Configuration f436867c;

        public b(e r100, hwb.c r101, Configuration r102) {
            this.f436865a = r100;
            this.f436866b = r101;
            this.f436867c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f436865a.e(this.f436866b, this.f436867c);     // Catch: Throwable -> L4
            this.f436865a.f436864n = null;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public e() {
    }

    public final void c() {
        h r100 = this.f436852b;
        if (r100 == null) goto L7;
        View r101 = this.f436851a;
        if (r101 == null) goto L7;
        r101.removeCallbacks(r100);
    L7:
        this.f436851a = null;
        this.f436852b = null;
    }

    public final void d() {
        Runnable r100 = this.f436864n;
        if (r100 == null) goto L7;
        View r101 = this.f436855e;
        if (r101 == null) goto L7;
        r101.removeCallbacks(r100);
    L7:
        this.f436864n = null;
        this.f436853c = null;
        this.f436854d = null;
        this.f436855e = null;
        this.f436856f = null;
        this.f436857g = null;
        this.f436858h = null;
        this.f436859i = null;
        this.f436851a = null;
    }

    public final void i() {
        Runnable r100 = this.f436864n;
        if (r100 == null) goto L7;
        View r101 = this.f436855e;
        if (r101 == null) goto L7;
        r101.removeCallbacks(r100);
    L7:
        this.f436864n = null;
        String r102 = this.f436860j;
        if (r102 == null) goto L12;
        int r103 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FLOAT, "unregisterUiModeChangeListener", "recordingId=".concat(r102), null, 8);
        qub.g r104 = this.f436859i;
        if (r104 == null) goto L12;
        r104.z0();
    L12:
        this.f436860j = null;
        this.f436859i = null;
        g r105 = this.f436861k;
        if (r105 == null) goto L17;
        Context r106 = this.f436862l;
        if (r106 == null) goto L17;
        r106.unregisterComponentCallbacks(r105);
    L17:
        this.f436861k = null;
        this.f436862l = null;
        this.f436863m = 0;
    }

    public final void e(hwb.c r100, Configuration r110) {
        yub.d r101 = yub.d.f569261a;
        Context r102 = com.ss.android.lark.appcontext.applifecycle2.api.a.a();
        if (r102 != null) goto L16;
        View r103 = this.f436853c;
        if (r103 == null) goto L8;
        r102 = r103.getContext();
    L9:
        if (r102 != null) goto L16;
        View r104 = this.f436855e;
        if (r104 == null) goto L13;
        r102 = r104.getContext();
    L14:
        if (r102 != null) goto L16;
        Context r111 = null;
    L22:
        if (r111 != null) goto L24;
        return;
    L24:
        FrameLayout r105 = this.f436854d;
        if (r105 == null) goto L28;
        MmFloatView r106 = r100.f487444b.a(r111, new hwb.b(r100.f487443a, r100.f487448f, r100.f487449g, new f(r100)));
        this.f436853c = r106;
        r105.removeAllViews();
        r105.addView(r106, new FrameLayout.LayoutParams(-1, -1));
    L28:
        FrameLayout r107 = this.f436856f;
        if (r107 == null) goto L31;
        r107.setBackground(UIUtils.getDrawable(r111, R.drawable.office_sdk_mm_bg_float_side_hide));
    L31:
        ColorStateList r108 = ColorStateList.valueOf(UIUtils.getColor(r111, R.color.ud_N900_50));
        FrameLayout r109 = this.f436857g;
        if (r109 == null) goto L36;
        AppCompatImageView r112 = (AppCompatImageView) r109.findViewById(R.id.mm_side_hide_left_icon);
        if (r112 == null) goto L36;
        r112.setImageTintList(r108);
    L36:
        FrameLayout r113 = this.f436858h;
        if (r113 == null) goto L41;
        AppCompatImageView r114 = (AppCompatImageView) r113.findViewById(R.id.mm_side_hide_right_icon);
        if (r114 == null) goto L41;
        r114.setImageTintList(r108);
    L41:
        int r115 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FLOAT, "refreshTheme", "recordingId=" + r100.f487443a + ", context=" + r111.getClass().getName(), null, 8);
        return;
    L13:
        r102 = null;
        goto L14
    L8:
        r102 = null;
    L16:
        if (r110 == null) goto L21;
        Context r116 = r102.createConfigurationContext(r110);
        NewMiraResourcesManager.getInstance().install(r116);
        if (r116 == null) goto L21;
        r102 = r116;
    L21:
        r111 = com.ss.android.lark.officesdk.minutes.ui.style.c.c(r102, r100.f487449g);
        goto L22
    }

    public final void f(Context r100, final hwb.c r101) {
        i();
        qub.g r102 = r101.f487450h;
        if (r102 != null) goto L5;
        int r103 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FLOAT, "registerUiModeChangeListener", "uiModeBridge missing, recordingId=" + r101.f487443a, null, 8);
    L8:
        this.f436863m = r100.getResources().getConfiguration().uiMode & 48;
        Context r104 = r100.getApplicationContext();
        this.f436862l = r104;
        g r105 = new g(this, r101);
        if (r104 == null) goto L11;
        r104.registerComponentCallbacks(r105);
    L11:
        this.f436861k = r105;
        return;
    L5:
        new MmSystemRecordingFloatHost$registerUiModeChangeListener$handled$1(r101, this);
        if (r102.L0() == false) goto L8;
        this.f436859i = r102;
        this.f436860j = r101.f487443a;
        goto L8
    }

    public final void g(hwb.c r100, Configuration r101) {
        View r102 = this.f436855e;
        if (r102 != null) goto L6;
        return;
    L6:
        if (r101 == null) goto L8;
        Configuration r103 = new Configuration(r101);
    L9:
        Runnable r104 = this.f436864n;
        if (r104 == null) goto L14;
        View r105 = this.f436855e;
        if (r105 == null) goto L14;
        r105.removeCallbacks(r104);
    L14:
        this.f436864n = null;
        b r106 = new b(this, r100, r103);
        r102.postDelayed(r106, 100);
        this.f436864n = r106;
        return;
    L8:
        r103 = null;
        goto L9
    }

    public static final void a(e r100, View r101, hwb.c r102) {
        r100.getClass();
        if (r102.f487446d.f487455e == false) goto L9;
        if (r101 == null) goto L10;
        r100.c();
        r100.f436851a = r101;
        h r103 = new h(r102);
        r101.postDelayed(r103, r102.f487445c.a());
        r100.f436852b = r103;
        return;
    L10:
        return;
    }

    public static final hwb.d b(e r100, String r110, boolean r111, boolean r112, boolean r113) {
        r100.getClass();
        tfb.a.b r101 = tfb.a.f545789a;
        Pair r102 = tfb.a.b.a(r110);
        Integer r114 = null;
        if (r111 == true) goto L7;
        if (r102 == null) goto L7;
        Integer r103 = (Integer) r102.getFirst();
    L8:
        if (r111 == true) goto L12;
        if (r102 == null) goto L12;
        Integer r104 = (Integer) r102.getSecond();
    L13:
        if (r102 == null) goto L15;
        Integer r105 = (Integer) r102.getFirst();
    L16:
        if (r102 == null) goto L18;
        r114 = (Integer) r102.getSecond();
    L18:
        Integer r106 = r114;
        boolean r107 = !r111;
        if (r112 == false) goto L21;
        MmRecordingFloatSide r108 = MmRecordingFloatSide.RIGHT;
    L23:
        return new hwb.d(r107, r108, r105, r106, r113, r103, r104);
    L21:
        r108 = MmRecordingFloatSide.LEFT;
        goto L23
    L15:
        r105 = null;
    L12:
        r104 = null;
    L7:
        r103 = null;
        goto L8
    }

    public static final void h(Ref.ObjectRef<View> r100, Ref.ObjectRef<FrameLayout> r101, Ref.ObjectRef<FrameLayout> r102, Ref.ObjectRef<FrameLayout> r103, Ref.ObjectRef<FrameLayout> r104, boolean r105, boolean r106) {
        View r107 = r100.element;
        int r108 = 0;
        if (r107 == null) goto L5;
        r107.setVisibility(0);
    L5:
        View r109 = r100.element;
        if (r109 == null) goto L8;
        r109.setAlpha(1.0f);
    L8:
        FrameLayout r110 = r101.element;
        if (r110 == null) goto L11;
        r110.setAlpha(1.0f);
    L11:
        FrameLayout r111 = r102.element;
        if (r111 == null) goto L14;
        r111.setAlpha(1.0f);
    L14:
        FrameLayout r112 = r103.element;
        if (r112 == null) goto L17;
        r112.setAlpha(1.0f);
    L17:
        FrameLayout r113 = r104.element;
        if (r113 == null) goto L20;
        r113.setAlpha(1.0f);
    L20:
        FrameLayout r114 = r101.element;
        if (r114 == null) goto L26;
        if (r105 == false) goto L24;
        int r115 = 4;
    L25:
        r114.setVisibility(r115);
        goto L26
    L24:
        r115 = 0;
    L26:
        FrameLayout r116 = r102.element;
        if (r116 == null) goto L32;
        if (r105 == false) goto L30;
        int r117 = 0;
    L31:
        r116.setVisibility(r117);
        goto L32
    L30:
        r117 = 4;
    L32:
        FrameLayout r118 = r103.element;
        if (r118 == null) goto L39;
        if (r105 == false) goto L37;
        if (r106 == false) goto L37;
        int r119 = 0;
    L38:
        r118.setVisibility(r119);
    L37:
        r119 = 4;
    L39:
        FrameLayout r120 = r104.element;
        if (r120 == null) goto L47;
        if (r105 == false) goto L44;
        if (r106 == true) goto L44;
    L45:
        r120.setVisibility(r108);
        return;
    L44:
        r108 = 4;
        goto L45
    }
}
