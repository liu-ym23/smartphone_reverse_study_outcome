package com.ss.android.lark.floating.widget.appfloat;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.floating.enums.SideHideDirection;
import com.ss.android.lark.floating.enums.SidePattern;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class AppFloatManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f421875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vfb.a f421876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WindowManager f421877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f421878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.ss.android.lark.floating.widget.appfloat.d f421879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TouchUtils f421880f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f421881g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f421882h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f421883i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f421884j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Rect f421885k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final e f421886l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Animator f421887m;

    public static final class a {
    }

    public interface b {
        void a();
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f421892a = null;

        static {
            int[] r100 = new int[SidePattern.values().length];
            r100[SidePattern.AUTO_HORIZONTAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L35:
            r100[SidePattern.RESULT_HORIZONTAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L51:
            r100[SidePattern.RESULT_LEFT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L39:
            r100[SidePattern.RESULT_RIGHT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L43:
            r100[SidePattern.LEFT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L29:
            r100[SidePattern.RIGHT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L45:
            r100[SidePattern.AUTO_VERTICAL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L47:
            r100[SidePattern.RESULT_VERTICAL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L37:
            r100[SidePattern.RESULT_TOP.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L41:
            r100[SidePattern.RESULT_BOTTOM.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L31:
            r100[SidePattern.TOP.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L33:
            r100[SidePattern.BOTTOM.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L15:
            f421892a = r100;
        }
    }

    public static final class d implements wfb.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppFloatManager f421893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.floating.widget.appfloat.d f421894b;

        public static final class a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AppFloatManager f421895a;

            @Override // com.ss.android.lark.floating.widget.appfloat.AppFloatManager.b
            public final void a() {
                AppFloatManager r100 = this.f421895a;
                r100.b(r100.f421876b.f554631z);
            }

            public a(AppFloatManager r100) {
                this.f421895a = r100;
            }
        }

        @Override // wfb.e
        public final void onTouch(MotionEvent r110) {
            Intrinsics.checkNotNullParameter(r110, "event");
            TouchUtils r100 = this.f421893a.f421880f;
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("touchUtils");
            r100 = null;
        L5:
            com.ss.android.lark.floating.widget.appfloat.d r101 = this.f421894b;
            WindowManager r102 = this.f421893a.f();
            h r103 = this.f421893a.e();
            AppFloatManager r104 = this.f421893a;
            int r105 = r104.f421876b.f554628w;
            a r111 = new a(r104);
            r100.getClass();
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r110, "event");
            Intrinsics.checkNotNullParameter(r102, "windowManager");
            Intrinsics.checkNotNullParameter(r103, "params");
            Intrinsics.checkNotNullParameter(r111, "action");
            r100.f421903b.getClass();
            wfb.a r106 = r100.f421903b.B;
            if (r106 == null) goto L9;
            r106.a();
        L9:
            if (r100.f421906e != 0) goto L12;
            r100.f421906e = xfb.d.b(r100.f421902a);
        L12:
            if (r100.f421905d != 0) goto L14;
            r100.f421905d = r100.f421903b.E.a(r100.f421902a);
        L14:
            r101.getLocationOnScreen(r100.f421915n);
            boolean r107 = true;
            int r112 = 0;
            if (r100.f421915n[1] <= ((WindowManager.LayoutParams) r103.f421955a).y) goto L17;
            boolean r108 = true;
        L18:
            r100.f421917p = r108;
            r100.f421916o = r100.f421905d - r101.getHeight();
            vfb.a r109 = r100.f421903b;
            if (r109.f554613h == true) goto L21;
        L158:
            r109.f554614i = false;
            r100.f421907f = r110.getRawX();
            r100.f421908g = r110.getRawY();
            Log.i("TouchUtils", "config.dragEnable: " + r100.f421903b.f554613h + ", config.isAnim: " + r100.f421903b.f554615j + ", return");
            return;
        L21:
            if (r109.f554615j == true) goto L158;
            int r113 = r110.getAction() & 255;
            if (r113 == 0) goto L157;
            if (r113 != 1) goto L27;
            vfb.a r114 = r100.f421903b;
            if (r114.f554614i == true) goto L140;
            return;
        L140:
            switch(TouchUtils.b.f421923a[r114.f554618m.ordinal()]) {
                case 8: goto L148;
                case 9: goto L148;
                case 10: goto L148;
                case 11: goto L148;
                case 12: goto L148;
                case 13: goto L148;
                case 14: goto L143;
                default: goto L141;
            };
        L141:
            r100.f421921t = SideHideDirection.NONE;
            r100.f421903b.getClass();
            wfb.a r115 = r100.f421903b.B;
            if (r115 == null) goto L156;
            wfb.a.C8107a r116 = r115.a();
            if (r116 == null) goto L156;
            Function1<? super View, Unit> r117 = r116.f559501e;
            if (r117 == null) goto L156;
            r117.invoke(r101);
        L156:
            r100.f421903b.f554614i = false;
            return;
        L148:
            r100.g(r101, r103, r105, r102, r111);
            goto L156
        L143:
            if (Intrinsics.areEqual(r100.f421903b.f554610e, Boolean.TRUE) == true) goto L145;
        L147:
            r100.g(r101, r103, r105, r102, r111);
            goto L156
        L145:
            if (r100.f421919r == false) goto L147;
            r100.h(new TouchUtils$sideHideAnim$1(r100, r103, r101, r102, r111, true));
            goto L156
        L27:
            if (r113 != 2) goto L29;
            float r118 = r110.getRawX() - r100.f421907f;
            float r119 = r110.getRawY() - r100.f421908g;
            vfb.a r120 = r100.f421903b;
            if (r120.f554614i == false) goto L38;
        L40:
            r120.f554614i = true;
            WindowManagerLayoutParamsInternal r121 = r103.f421955a;
            int r122 = ((WindowManager.LayoutParams) r121).x + ((int) r118);
            int r123 = ((WindowManager.LayoutParams) r121).y + ((int) r119);
            Boolean r124 = r120.f554610e;
            Boolean r125 = Boolean.TRUE;
            if (Intrinsics.areEqual(r124, r125) == true) goto L43;
            if (r122 >= 0) goto L51;
            r122 = 0;
        L53:
            if (r123 >= 0) goto L56;
            r123 = 0;
        L63:
            boolean r126 = r100.f421919r;
            if (Intrinsics.areEqual(r100.f421903b.f554610e, r125) == true) goto L66;
        L71:
            boolean r127 = false;
        L72:
            r100.f421919r = r127;
            if (r126 == r127) goto L85;
            r100.f(r103, r101);
            r100.l();
            wfb.a r128 = r100.f421903b.B;
            if (r128 == null) goto L85;
            wfb.a.C8107a r129 = r128.a();
            if (r129 == null) goto L85;
            Function2<? super Boolean, ? super Boolean, Unit> r130 = r129.f559499c;
            if (r130 == null) goto L85;
            Boolean r131 = Boolean.valueOf(r100.f421919r);
            if (r100.f421921t != SideHideDirection.RIGHT) goto L83;
            boolean r132 = true;
        L84:
            r130.invoke(r131, Boolean.valueOf(r132));
            goto L85
        L83:
            r132 = false;
        L85:
            boolean r133 = r100.f421920s;
            if (Intrinsics.areEqual(r100.f421903b.f554610e, r125) == true) goto L88;
        L93:
            boolean r134 = false;
        L94:
            r100.f421920s = r134;
            if (r133 == r134) goto L108;
            r100.f(r103, r101);
            r100.l();
            wfb.a r135 = r100.f421903b.B;
            if (r135 == null) goto L108;
            wfb.a.C8107a r136 = r135.a();
            if (r136 == null) goto L108;
            Function2<? super Boolean, ? super Boolean, Unit> r137 = r136.f559500d;
            if (r137 == null) goto L108;
            Boolean r138 = Boolean.valueOf(r100.f421920s);
            if (r100.f421921t == SideHideDirection.RIGHT) goto L106;
            r107 = false;
        L106:
            r137.invoke(r138, Boolean.valueOf(r107));
        L108:
            switch(TouchUtils.b.f421923a[r100.f421903b.f554618m.ordinal()]) {
                case 1: goto L132;
                case 2: goto L129;
                case 3: goto L128;
                case 4: goto L126;
                case 5: goto L123;
                case 6: goto L120;
                case 7: goto L110;
                default: goto L109;
            };
        L109:
            r112 = r123;
        L131:
            r123 = r112;
            r112 = r122;
            goto L132
        L110:
            r100.f421909h = (int) r110.getRawX();
            r100.f421910i = r100.f421906e - ((int) r110.getRawX());
            int r139 = (int) r110.getRawY();
            int r140 = r100.f421904c.top;
            r100.f421911j = r139 - r140;
            r100.f421912k = (r100.f421905d + r140) - ((int) r110.getRawY());
            r100.f421913l = Math.min(r100.f421909h, r100.f421910i);
            int r141 = Math.min(r100.f421911j, r100.f421912k);
            r100.f421914m = r141;
            int r142 = r100.f421913l;
            if (r142 >= r141) goto L117;
            if (r100.f421909h == r142) goto L132;
            int r143 = r100.f421906e;
            int r144 = r101.getWidth();
        L130:
            r112 = r143 - r144;
            goto L132
        L117:
            if (r100.f421911j == r141) goto L131;
            int r145 = r100.f421905d;
            int r146 = r101.getHeight();
        L127:
            r112 = r145 - r146;
            goto L131
        L120:
            float r147 = (r110.getRawY() - r100.f421904c.top) * 2;
            int r148 = r100.f421905d;
            if (r147 <= r148) goto L131;
            r112 = r148 - r101.getHeight();
            goto L131
        L123:
            float r149 = r110.getRawX() * 2;
            int r150 = r100.f421906e;
            if (r149 <= r150) goto L132;
            r144 = r101.getWidth();
            r143 = r150;
            goto L130
        L126:
            r145 = r100.f421905d;
            r146 = r101.getHeight();
            goto L127
        L128:
            r112 = r122;
            r123 = 0;
            goto L132
        L129:
            r143 = r100.f421906e;
            r144 = r101.getWidth();
        L132:
            WindowManagerLayoutParamsInternal r151 = r103.f421955a;
            ((WindowManager.LayoutParams) r151).x = r112;
            ((WindowManager.LayoutParams) r151).y = r123;
            r102.updateViewLayout(r101, r151);
            r100.f421903b.getClass();
            wfb.a r152 = r100.f421903b.B;
            if (r152 == null) goto L135;
            r152.a();
        L135:
            r100.f421907f = r110.getRawX();
            r100.f421908g = r110.getRawY();
            return;
        L88:
            if (r122 > r100.d(r101)) goto L91;
        L92:
            r134 = true;
            goto L94
        L91:
            if (r122 < r100.e()) goto L93;
        L66:
            if (r122 > ((0 - r100.f421903b.f554612g) - r100.f421922u)) goto L69;
        L70:
            r127 = true;
            goto L72
        L69:
            if (r122 < (((r100.f421906e - r101.getWidth()) + r100.f421903b.f554612g) + r100.f421922u)) goto L71;
        L56:
            if (r123 <= (r100.f421916o - TouchUtils.k(r101))) goto L63;
            if (r100.f421917p == false) goto L60;
            r123 = r100.f421916o - TouchUtils.k(r101);
            goto L63
        L60:
            int r153 = r100.f421916o;
            if (r123 <= r153) goto L63;
            r123 = r153;
            goto L63
        L51:
            if (r122 <= (r100.f421906e - r101.getWidth())) goto L53;
            r122 = r100.f421906e - r101.getWidth();
            goto L53
        L43:
            if (r122 >= r100.d(r101)) goto L46;
            r122 = r100.d(r101);
            goto L53
        L46:
            if (r122 <= r100.e()) goto L53;
            r122 = r100.e();
            goto L53
        L38:
            if (((r118 * r118) + (r119 * r119)) >= 81.0f) goto L40;
            return;
        L29:
            if (r113 != 3) goto L164;
            vfb.a r154 = r100.f421903b;
            if (r154.f554614i == false) goto L165;
            r154.f554614i = false;
            return;
        L165:
            return;
        L164:
            return;
        L157:
            r100.f421903b.f554614i = false;
            r100.f421907f = r110.getRawX();
            r100.f421908g = r110.getRawY();
            return;
        L17:
            r108 = false;
            goto L18
        }

        public d(AppFloatManager r100, com.ss.android.lark.floating.widget.appfloat.d r101) {
            this.f421893a = r100;
            this.f421894b = r101;
        }
    }

    public static final class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f421896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppFloatManager f421897b;

        @Override // com.ss.android.lark.floating.widget.appfloat.AppFloatManager.b
        public final void a() {
            if (this.f421896a == false) goto L12;
            return;
        L12:
            this.f421896a = true;     // Catch: Throwable -> L9
            AppFloatManager r100 = this.f421897b;     // Catch: Throwable -> L9
            r100.b(r100.f421876b.f554631z);     // Catch: Throwable -> L9
            this.f421896a = false;
            return;
        L9:
            th = move-exception;
            this.f421896a = false;
            throw th;
        }

        public e(AppFloatManager r100) {
            this.f421897b = r100;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppFloatManager f421898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f421899b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f421900c;

        public f(AppFloatManager r100, int r101, boolean r102) {
            this.f421898a = r100;
            this.f421899b = r101;
            this.f421900c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f421898a.h(this.f421899b, this.f421900c);     // Catch: Throwable -> L4
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

    public final void a() {
        final com.ss.android.lark.floating.widget.appfloat.d r100 = new com.ss.android.lark.floating.widget.appfloat.d(this.f421875a, this.f421876b);
        r100.setTag(this.f421876b.f554609d);
        LayoutInflater r101 = LayoutInflater.from(this.f421875a);
        Integer r102 = this.f421876b.f554606a;
        Intrinsics.checkNotNull(r102);
        final View r103 = r101.inflate(r102.intValue(), r100, true);
        r103.setVisibility(4);
        WindowManager r104 = f();
        WindowManagerLayoutParamsInternal r105 = e().f421955a;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r100, r105);
        r104.addView(r100, r105);
        Log.i("AppFloatManager", "addParentFrameLayout@" + r100.hashCode());
        vfb.a r106 = this.f421876b;
        r106.f554607b = r103;
        r106.f554608c = r100;
        wfb.f r107 = r106.A;
        if (r107 == null) goto L5;
        r107.a(r103);
    L5:
        r100.setTouchListener(new d(this, r100));
        r100.setLayoutListener(new AppFloatManager$addView$1$3(this, r100, r103));
        this.f421879e = r100;
    }

    public final void d() {
        StringBuilder r100 = new StringBuilder("floatOver, removeParentFrameLayout@");     // Catch: Exception -> L9
        com.ss.android.lark.floating.widget.appfloat.d r101 = this.f421879e;     // Catch: Exception -> L9
        if (r101 == null) goto L6;
        Integer r102 = Integer.valueOf(r101.hashCode());     // Catch: Exception -> L9
    L7:
        r100.append(r102);     // Catch: Exception -> L9
        Log.i("AppFloatManager", r100.toString());     // Catch: Exception -> L9
        this.f421876b.f554615j = false;     // Catch: Exception -> L9
        f().removeView(this.f421879e);     // Catch: Exception -> L9
        return;
    L6:
        r102 = null;
    L9:
        e = move-exception;
        Log.e("AppFloatManager", "float dismiss occurs error：" + e);
    }

    public final h e() {
        h r100 = this.f421878d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("params");
        return null;
    }

    public final WindowManager f() {
        WindowManager r100 = this.f421877c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("windowManager");
        return null;
    }

    public final void g() {
        Object r100 = this.f421875a.getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.view.WindowManager");
        i r101 = new i((WindowManager) r100);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f421877c = r101;
        h r102 = new h();
        if (Build.VERSION.SDK_INT < 26) goto L5;
        int r103 = 2038;
    L6:
        WindowManagerLayoutParamsInternal r104 = r102.f421955a;
        ((WindowManager.LayoutParams) r104).type = r103;
        boolean r105 = true;
        ((WindowManager.LayoutParams) r104).format = 1;
        ((WindowManager.LayoutParams) r104).gravity = 8388659;
        ((WindowManager.LayoutParams) r104).flags = 552;
        vfb.a r106 = this.f421876b;
        if (r106.f554620o == false) goto L10;
        this.f421881g |= 128;
    L10:
        if (r106.f554621p == false) goto L12;
        this.f421881g |= 16777216;
    L12:
        float r107 = r106.f554623r;
        if (r107 == (-1.0f)) goto L16;
        r105 = false;
    L16:
        if (r105 == true) goto L18;
        this.f421881g |= 2;
        ((WindowManager.LayoutParams) r104).dimAmount = r107;
    L18:
        ((WindowManager.LayoutParams) r104).flags = this.f421881g | 552;
        int r108 = -1;
        if (r106.f554624s == false) goto L21;
        int r109 = -1;
    L22:
        ((WindowManager.LayoutParams) r104).width = r109;
        if (r106.f554625t == true) goto L26;
        r108 = -2;
    L26:
        ((WindowManager.LayoutParams) r104).height = r108;
        if (Intrinsics.areEqual(r106.f554630y, new Pair(0, 0)) == true) goto L29;
        ((WindowManager.LayoutParams) r102.f421955a).x = this.f421876b.f554630y.getFirst().intValue();
        ((WindowManager.LayoutParams) r102.f421955a).y = this.f421876b.f554630y.getSecond().intValue();
    L30:
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f421878d = r102;
        return;
    L29:
        ((WindowManager.LayoutParams) r102.f421955a).y = this.f421876b.f554629x;
        goto L30
    L21:
        r109 = -2;
        goto L22
    L5:
        r103 = 2002;
        goto L6
    }

    public final Context getContext() {
        return this.f421875a;
    }

    public final void b(List<Rect> r110) {
        Intrinsics.checkNotNullParameter(r110, "rects");
        if (this.f421876b.f554615j == false) goto L5;
        return;
    L5:
        com.ss.android.lark.floating.widget.appfloat.d r100 = this.f421879e;
        if (r100 == null) goto L92;
        int[] r101 = this.f421884j;
        r100.getLocationOnScreen(r101);
        Rect r102 = this.f421885k;
        boolean r103 = false;
        int r104 = r101[0];
        r102.set(r104, r101[1], r100.getWidth() + r104, r101[1] + r100.getHeight());
        List<Rect> r111 = r110;
        Iterator<T> r105 = r111.iterator();
        boolean r106 = false;
    L9:
        if (r105.hasNext() == false) goto L11;
        r106 = r106 | r102.intersect((Rect) r105.next());
        goto L9
    L11:
        if (r106 == true) goto L13;
        return;
    L13:
        Rect r107 = new Rect();
        Iterator<T> r112 = r111.iterator();
    L15:
        if (r112.hasNext() == false) goto L17;
        r107.union((Rect) r112.next());
        goto L15
    L17:
        int r113 = xfb.d.f563555a;
        Rect r114 = xfb.d.c(this.f421875a);
        if (r102.top <= ((WindowManager.LayoutParams) e().f421955a).y) goto L20;
        boolean r108 = true;
    L21:
        if (r108 == false) goto L25;
        Context r109 = this.f421875a;
        Intrinsics.checkNotNullParameter(r109, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r115 = r109.getResources();
        int r116 = r115.getIdentifier("status_bar_height", "dimen", "android");
        if (r116 <= 0) goto L25;
        int r117 = r115.getDimensionPixelSize(r116);
    L27:
        switch(c.f421892a[this.f421876b.f554618m.ordinal()]) {
            case 1: goto L59;
            case 2: goto L59;
            case 3: goto L59;
            case 4: goto L59;
            case 5: goto L59;
            case 6: goto L59;
            case 7: goto L29;
            case 8: goto L29;
            case 9: goto L29;
            case 10: goto L29;
            case 11: goto L29;
            case 12: goto L29;
            default: goto L28;
        };
    L28:
        return;
    L29:
        int r118 = r107.left - UIHelper.dp2px(20.0f);
        int r119 = (r114.right - r107.right) - UIHelper.dp2px(20.0f);
        int r120 = r119 + 1;
        int r121 = r100.getWidth();
        if (r120 > r121) goto L33;
        if (r121 > r118) goto L33;
        boolean r122 = true;
    L34:
        if (r122 == false) goto L36;
        int r123 = r107.left - UIHelper.dp2px(20.0f);
        int r124 = r100.getWidth();
    L48:
        int r125 = r123 - r124;
    L51:
        int r126 = r125;
    L53:
        if (r126 == (-1)) goto L93;
        TouchUtils r127 = this.f421880f;
        if (r127 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("touchUtils");
        TouchUtils r128 = null;
    L58:
        h r129 = e();
        WindowManager r130 = f();
        int r131 = TouchUtils.f421901v;
        r128.b(true, r129, r126, r130, r100, null, false);
        return;
    L57:
        r128 = r127;
        goto L58
    L93:
        return;
    L36:
        int r132 = r118 + 1;
        int r133 = r100.getWidth();
        if (r132 > r133) goto L40;
        if (r133 > r119) goto L40;
        r103 = true;
    L40:
        if (r103 == false) goto L43;
        int r134 = r107.right;
        int r135 = UIHelper.dp2px(20.0f);
    L50:
        r125 = r134 + r135;
        goto L51
    L43:
        if (r118 >= r100.getWidth()) goto L45;
    L52:
        r126 = -1;
        goto L53
    L45:
        if (r119 < r100.getWidth()) goto L52;
        if (r118 <= r119) goto L49;
        r123 = r107.left - UIHelper.dp2px(20.0f);
        r124 = r100.getWidth();
        goto L48
    L49:
        r134 = r107.right;
        r135 = UIHelper.dp2px(20.0f);
    L33:
        r122 = false;
        goto L34
    L59:
        int r136 = r107.top - UIHelper.dp2px(20.0f);
        int r137 = (r114.bottom - r107.bottom) - UIHelper.dp2px(20.0f);
        int r138 = r137 + 1;
        int r139 = r100.getHeight();
        if (r138 > r139) goto L63;
        if (r139 > r136) goto L63;
        boolean r140 = true;
    L64:
        if (r140 == false) goto L66;
        int r141 = r107.top - UIHelper.dp2px(20.0f);
        int r142 = r100.getHeight();
    L78:
        int r143 = r141 - r142;
    L81:
        int r144 = r143 - r117;
    L83:
        if (r144 == (-1)) goto L95;
        TouchUtils r145 = this.f421880f;
        if (r145 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("touchUtils");
        TouchUtils r146 = null;
    L88:
        h r147 = e();
        WindowManager r148 = f();
        int r149 = TouchUtils.f421901v;
        r146.b(false, r147, r144, r148, r100, null, false);
        return;
    L87:
        r146 = r145;
        goto L88
    L95:
        return;
    L66:
        int r150 = r136 + 1;
        int r151 = r100.getHeight();
        if (r150 > r151) goto L70;
        if (r151 > r137) goto L70;
        r103 = true;
    L70:
        if (r103 == false) goto L73;
        int r152 = r107.bottom;
        int r153 = UIHelper.dp2px(20.0f);
    L80:
        r143 = r152 + r153;
        goto L81
    L73:
        if (r136 >= r100.getHeight()) goto L75;
    L82:
        r144 = -1;
        goto L83
    L75:
        if (r137 < r100.getHeight()) goto L82;
        if (r136 <= r137) goto L79;
        r141 = r107.top - UIHelper.dp2px(20.0f);
        r142 = r100.getHeight();
        goto L78
    L79:
        r152 = r107.bottom;
        r153 = UIHelper.dp2px(20.0f);
    L63:
        r140 = false;
    L25:
        r117 = 0;
        goto L27
    L20:
        r108 = false;
        goto L21
    }

    public final void c(final boolean r100) {
        vfb.a r101 = this.f421876b;
        if (r101.f554614i == false) goto L5;
        return;
    L5:
        if (r101.f554615j == true) goto L21;
        TouchUtils r102 = null;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("core.appfloat.windowsize_refactor") == false) goto L14;
        TouchUtils r103 = this.f421880f;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("touchUtils");
    L13:
        r102.h(new AppFloatManager$expandAppFloatView$1(this, r100));
        return;
    L12:
        r102 = r103;
        goto L13
    L14:
        TouchUtils r104 = this.f421880f;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("touchUtils");
        r104 = null;
    L17:
        r104.h(null);
        i(this, Boolean.valueOf(r100), null, 2);
        return;
    }

    public AppFloatManager(Context r100, vfb.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "config");
        this.f421875a = r100;
        this.f421876b = r101;
        this.f421884j = new int[2];
        this.f421885k = new Rect();
        this.f421886l = new e(this);
    }

    public final void h(int r100, boolean r101) {
        com.ss.android.lark.floating.widget.appfloat.d r102 = this.f421879e;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.getChildCount() >= 1) goto L8;
        return;
    L8:
        if (r102.isLaidOut() == true) goto L12;
        if (r100 != 0) goto L12;
        r102.post(new f(this, r100, r101));
        return;
    L12:
        this.f421876b.H = r101;
        r102.setVisibility(r100);
        r102.getChildAt(0);
        if (r100 != 0) goto L17;
        vfb.a r103 = this.f421876b;
        r103.f554616k = true;
        r103.getClass();
        wfb.a r104 = this.f421876b.B;
        if (r104 == null) goto L22;
        r104.a();
        return;
    L22:
        return;
    L17:
        vfb.a r105 = this.f421876b;
        r105.f554616k = false;
        r105.getClass();
        wfb.a r106 = this.f421876b.B;
        if (r106 == null) goto L24;
        r106.a();
        return;
    }

    public static void i(AppFloatManager r110, Boolean r111, Boolean r112, int r113) {
        if ((r113 & 1) == 0) goto L6;
        r111 = null;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r112 = null;
    L8:
        com.ss.android.lark.floating.widget.appfloat.d r100 = r110.f421879e;
        if (r100 == null) goto L47;
        Animator r114 = r110.f421887m;
        if (r114 == null) goto L13;
        r114.cancel();
    L13:
        r110.f421887m = null;
        if (r100.isLaidOut() == false) goto L53;
        TouchUtils r115 = r110.f421880f;
        if (r115 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("touchUtils");
        r115 = null;
    L19:
        h r101 = r110.e();
        WindowManager r102 = r110.f();
        e r103 = r110.f421886l;
        r115.getClass();
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "windowManager");
        Intrinsics.checkNotNullParameter(r100, "view");
        r115.f(r101, r100);
        vfb.a r116 = r115.f421903b;
        int r104 = r116.f554628w;
        int r105 = r115.f421909h;
        int r106 = r115.f421910i;
        if (r105 >= r106) goto L22;
        int r107 = 0 - r104;
    L23:
        int r108 = r116.f554629x;
        if (Intrinsics.areEqual(r116.f554610e, Boolean.TRUE) == false) goto L45;
        if (r111 != null) goto L27;
        if (r112 == null) goto L42;
        if (r112.booleanValue() == false) goto L42;
        r115.i(r101, r107, r108, r102, r100, r103, true, r115.f421919r);
        return;
    L42:
        if (r115.f421919r == false) goto L44;
        r115.h(new TouchUtils$sideHideAnim$1(r115, r101, r100, r102, r103, false));
        Unit r117 = Unit.INSTANCE;
        return;
    L44:
        TouchUtils.j(r115, r101, r107, r102, r100, r103, false);
        return;
    L27:
        if (r115.f421919r == false) goto L32;
        if (r111.booleanValue() == false) goto L32;
        TouchUtils.j(r115, r101, r107, r102, r100, r103, true);
        return;
    L32:
        if (r115.f421919r == false) goto L34;
    L36:
        Unit r118 = Unit.INSTANCE;
        return;
    L34:
        if (r111.booleanValue() == true) goto L36;
        r115.h(new TouchUtils$sideHideAnim$1(r115, r101, r100, r102, r103, true));
        goto L36
    L45:
        r115.i(r101, r107, r108, r102, r100, r103, false, false);
        return;
    L22:
        r107 = (((WindowManager.LayoutParams) r101.f421955a).x + r106) + r104;
        goto L23
    L53:
        return;
    }
}
