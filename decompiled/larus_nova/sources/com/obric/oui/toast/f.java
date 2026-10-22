package com.obric.oui.toast;

import android.app.Activity;
import android.content.Context;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.obric.oui.button.OButton;
import com.obric.oui.common.style.l;
import com.obric.oui.common.style.q;
import com.obric.oui.popover.SingleChildFrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import me.ele.lancet.base.annotations.Skip;
import pla.j;

/* JADX INFO: loaded from: classes34.dex */
public final class f {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Handler f403695n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ArrayDeque<f> f403696o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static f f403697p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f403698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f403699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f403700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f403701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f403702e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f403703f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f403704g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Toast f403705h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f403706i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f403707j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f403708k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f403709l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final OButton f403710m;

    public static final class a {
        public static void b() {
            if (f.f403697p == null) goto L5;
            return;
        L5:
            final f r100 = f.f403696o.poll();
            if (r100 != null) goto L8;
            return;
        L8:
            f.f403697p = r100;
        L48:
            e = move-exception;
            pla.f.a(Intrinsics.stringPlus("Try DeadObjectException occur, ", e.getMessage()));
        L52:
            pla.f.a(Intrinsics.stringPlus("OToast", ", showAsDropDown exception occur, try showAtLocation"));
            f.f403695n.post(new d(r100));
            return;
        L50:
            e = move-exception;
            pla.f.a(Intrinsics.stringPlus("Try runtimeException occur, ", e.getMessage()));
            goto L52
        L10:
            if (r100.f403703f == 0) goto L12;
            boolean r101 = true;
        L13:
            if (r101 == false) goto L15;
        L24:
            int r102 = r100.f403700c;     // Catch: DeadObjectException -> L48 RuntimeException -> L50
            if (r102 != 17) goto L27;
        L33:
            int r103 = 0;
        L34:
            ((TextView) r100.f403709l.findViewById(R.id.tv_msg)).setMaxWidth(r100.f403708k);     // Catch: DeadObjectException -> L48 RuntimeException -> L50
            r100.f403709l.measure(0, 0);     // Catch: DeadObjectException -> L48 RuntimeException -> L50
            int r104 = vma.c.f556351a;     // Catch: DeadObjectException -> L48 RuntimeException -> L50
            View r105 = r100.f403709l;     // Catch: DeadObjectException -> L48 RuntimeException -> L50
            if (r105 != null) goto L38;
        L40:
            View r106 = null;
        L41:
            ToastBackgroundView r107 = (ToastBackgroundView) r106;     // Catch: DeadObjectException -> L48 RuntimeException -> L50
            if (r107 == null) goto L45;
            ToastBackgroundView.a(r107, r105.getMeasuredHeight());     // Catch: DeadObjectException -> L48 RuntimeException -> L50
        L45:
            b r108 = r100.f403704g;     // Catch: DeadObjectException -> L48 RuntimeException -> L50
            r108.f403718h = r100.f403709l;     // Catch: DeadObjectException -> L48 RuntimeException -> L50
            r108.f403719i = r100.f403698a;     // Catch: DeadObjectException -> L48 RuntimeException -> L50
            r108.f403714d = r100.f403700c;     // Catch: DeadObjectException -> L48 RuntimeException -> L50
            r108.f403715e = r103;     // Catch: DeadObjectException -> L48 RuntimeException -> L50
            r108.f403712b = r100.f403702e;     // Catch: DeadObjectException -> L48 RuntimeException -> L50
            r108.f403722l = new OToast$showNow$1$3(r100);     // Catch: DeadObjectException -> L48 RuntimeException -> L50
            r108.b();     // Catch: DeadObjectException -> L48 RuntimeException -> L50
        L46:
            Unit r109 = Unit.INSTANCE;     // Catch: DeadObjectException -> L48 RuntimeException -> L50
        L56:
            return;
        L38:
            if ((r105 instanceof ToastBackgroundView) == false) goto L40;
            r106 = r105;
            goto L41
        L27:
            if (r102 != 48) goto L29;
            r103 = pla.d.c(r100.f403698a, 20);     // Catch: DeadObjectException -> L48 RuntimeException -> L50
            goto L34
        L29:
            if (r102 != 80) goto L33;
            r103 = pla.d.c(r100.f403698a, 96);     // Catch: DeadObjectException -> L48 RuntimeException -> L50
            goto L34
        L15:
            if (r100.f403701d == true) goto L24;
            if (j.d(r100.f403710m) == false) goto L19;
        L20:
            Context r110 = r100.f403698a.getApplicationContext();     // Catch: DeadObjectException -> L48 RuntimeException -> L50
            if (r110 != null) goto L23;
            r110 = r100.f403698a;     // Catch: DeadObjectException -> L48 RuntimeException -> L50
        L23:
            Toast r111 = Toast.makeText(r110, r100.f403699b, 0);     // Catch: DeadObjectException -> L48 RuntimeException -> L50
            r100.f403705h = r111;     // Catch: DeadObjectException -> L48 RuntimeException -> L50
            r111.show();     // Catch: DeadObjectException -> L48 RuntimeException -> L50
            b r112 = r100.f403704g;     // Catch: DeadObjectException -> L48 RuntimeException -> L50
            r112.f403713c.postDelayed(new com.obric.oui.toast.b(r100), r112.f403716f);     // Catch: DeadObjectException -> L48 RuntimeException -> L50
            goto L46
        L19:
            if (r100.f403710m.isClickable() == true) goto L24;
        L12:
            r101 = false;
            goto L13
        }

        public a() {
        }

        public static void a(Context r100, String r110) {
            Handler r101 = f.f403695n;
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r110, "msg");
            f r102 = new f(r100, r110, 80, false, null, 0, 8);
            new WeakReference(r102);
            r102.c();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WindowManager.LayoutParams f403711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Boolean f403712b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a.HandlerC4682a f403713c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f403714d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f403715e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f403716f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public View f403717g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public View f403718h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Context f403719i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public WindowManager f403720j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f403721k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Function0<Unit> f403722l;

        public static final class a {

            /* JADX INFO: renamed from: com.obric.oui.toast.f$b$a$a, reason: collision with other inner class name */
            public static final class HandlerC4682a extends Handler {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final b f403723a;

                public HandlerC4682a(b r100) {
                    Intrinsics.checkNotNullParameter(r100, "tn");
                    super(Looper.getMainLooper());
                    this.f403723a = r100;
                }

                @Override // android.os.Handler
                public final void handleMessage(Message r110) {
                    Intrinsics.checkNotNullParameter(r110, "msg");
                    Handler r100 = f.f403695n;
                    int r101 = r110.what;
                    Objects.toString(this.f403723a);
                    b r102 = this.f403723a;
                    r102.getClass();
                    int r103 = r110.what;
                    if (r103 != 1) goto L74;
                    Objects.toString(r102.f403717g);
                    Objects.toString(r102.f403718h);
                    r102.a();
                    Context r104 = r102.f403719i;
                    if (r104 != null) goto L7;
                    Activity r105 = null;
                L8:
                    Context r106 = r102.f403719i;
                    View r107 = r102.f403718h;
                    Intrinsics.checkNotNull(r107);
                    int r108 = r102.f403715e;
                    View r109 = r107;
                    if (r106 == null) goto L44;
                    int r111 = vma.c.f556351a;
                    if (r107 != null) goto L15;
                L17:
                    View r112 = null;
                L18:
                    ToastBackgroundView r113 = (ToastBackgroundView) r112;
                    if (r113 != null) goto L21;
                    int r114 = 24;
                L22:
                    View r115 = LayoutInflater.from(r106).inflate(R.layout.o_layout_popover_shadow_frame, null);
                    if (r115 == null) goto L72;
                    SingleChildFrameLayout r116 = (SingleChildFrameLayout) r115;
                    r116.addView(r107, new FrameLayout.LayoutParams(-2, -2));
                    r116.setShadowCornerRadius(r114);
                    List<q> r117 = l.h(r106, "oui_shadow_thick");
                    if (r117 != null) goto L27;
                    int r118 = 0;
                L43:
                    SingleChildFrameLayout r119 = new SingleChildFrameLayout(r106, null);
                    r119.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
                    FrameLayout.LayoutParams r120 = new FrameLayout.LayoutParams(-2, -2);
                    r120.gravity = 1;
                    Unit r121 = Unit.INSTANCE;
                    r119.addView(r116, r120);
                    r119.setClipChildren(false);
                    r119.setClipToPadding(false);
                    r119.setPadding(0, r118, 0, r108);
                    r109 = r119;
                    goto L44
                L27:
                    Iterator r122 = ((ArrayList) r117).iterator();
                    r118 = 0;
                    int r123 = 0;
                    int r124 = 0;
                    int r125 = 0;
                L29:
                    if (r122.hasNext() == false) goto L43;
                    q r126 = (q) r122.next();
                    float r127 = r126.f399593b - r126.f399594c;
                    if (r127 <= r123) goto L33;
                    r123 = MathKt.roundToInt(r127);
                L33:
                    float r128 = r126.f399593b + r126.f399594c;
                    if (r128 <= r124) goto L36;
                    r124 = MathKt.roundToInt(r128);
                L36:
                    float r129 = r126.f399593b - r126.f399595d;
                    if (r129 <= r118) goto L39;
                    r118 = MathKt.roundToInt(r129);
                L39:
                    float r130 = r126.f399593b + r126.f399595d;
                    if (r130 <= r125) goto L29;
                    r125 = MathKt.roundToInt(r130);
                    goto L29
                L72:
                    throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.popover.SingleChildFrameLayout");
                L21:
                    r114 = r113.getCornerRadius();
                    goto L22
                L15:
                    if ((r107 instanceof ToastBackgroundView) == false) goto L17;
                    r112 = r107;
                L44:
                    r102.f403717g = r109;
                    Intrinsics.checkNotNull(r109);
                    Context r131 = r109.getContext().getApplicationContext();
                    View r132 = r102.f403717g;
                    Intrinsics.checkNotNull(r132);
                    String r133 = r132.getContext().getPackageName();
                    if (r131 != null) goto L47;
                    View r134 = r102.f403717g;
                    Intrinsics.checkNotNull(r134);
                    r131 = r134.getContext();
                L47:
                    Intrinsics.checkNotNull(r131);
                    Object r135 = r131.getSystemService(LiveEndPageData.TAG_WINDOW);
                    if (r135 == null) goto L70;
                    r102.f403720j = (WindowManager) r135;
                    View r136 = r102.f403717g;
                    Intrinsics.checkNotNull(r136);
                    int r137 = Gravity.getAbsoluteGravity(r102.f403714d, r136.getContext().getResources().getConfiguration().getLayoutDirection());
                    WindowManager.LayoutParams r138 = r102.f403711a;
                    r138.gravity = r137;
                    if ((r137 & 7) != 7) goto L53;
                    r138.horizontalWeight = 1.0f;
                L53:
                    if ((r137 & 112) != 112) goto L55;
                    r138.verticalWeight = 1.0f;
                L55:
                    r138.x = 0;
                    r138.y = r102.f403715e;
                    r138.verticalMargin = 0.0f;
                    r138.horizontalMargin = 0.0f;
                    if (r102.f403721k == true) goto L58;
                    r138.flags |= 16;
                L58:
                    zma.a.b(r131, r138, r102.f403712b);
                    WindowManager.LayoutParams r139 = r102.f403711a;
                    r139.y = 0;
                    r139.width = -1;
                    if (r105 == null) goto L61;
                    r139.token = r105.getWindow().getAttributes().token;
                L61:
                    r102.f403711a.packageName = r133;
                    View r140 = r102.f403717g;
                    Intrinsics.checkNotNull(r140);
                    if (r140.getParent() == null) goto L64;
                    Handler r141 = f.f403695n;
                    Objects.toString(r102.f403717g);
                    WindowManager r142 = r102.f403720j;
                    Intrinsics.checkNotNull(r142);
                    r142.removeView(r102.f403717g);
                L64:
                    Handler r143 = f.f403695n;
                    Objects.toString(r102.f403717g);
                    WindowManager r144 = r102.f403720j;     // Catch: Exception -> L67
                    Intrinsics.checkNotNull(r144);     // Catch: Exception -> L67
                    View r145 = r102.f403717g;     // Catch: Exception -> L67
                    WindowManager.LayoutParams r146 = r102.f403711a;     // Catch: Exception -> L67
                    WindowManagerLancet.bindToAssistantWindowIfNeeded(r145, r146);     // Catch: Exception -> L67
                    r144.addView(r145, r146);     // Catch: Exception -> L67
                    return;
                L67:
                    e = move-exception;
                    e.printStackTrace();
                    return;
                L70:
                    throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
                L7:
                    r105 = zma.a.f572881a.getActivity(r104);
                    goto L8
                L74:
                    if (r103 != 2) goto L86;
                    r102.a();
                    r102.f403718h = null;
                    r102.f403719i = null;
                    r102.f403720j = null;
                    Function0<Unit> r147 = r102.f403722l;
                    r102.f403722l = null;
                    if (r147 == null) goto L88;
                    r147.invoke();
                    return;
                L88:
                    return;
                }
            }

            @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
            public static Class a(String r100) throws ClassNotFoundException {
                ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
                FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
                if (el9.a.a() == true) goto L34;
                Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
                if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
                FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
            L7:
                return r103;
            L8:
                th = move-exception;
                if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
                FastClassNotFoundHandler.b(r100);
            L12:
                throw th;
            L34:
                Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
                if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
                FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
            L16:
                return r104;
            L17:
                th = move-exception;
                if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
                FastClassNotFoundHandler.b(r100);
            L22:
                if ((th instanceof PluginClassNotFoundException) == false) goto L24;
                throw th;
            L24:
                if ((th instanceof ClassNotFoundException) == true) goto L30;
                if ((th instanceof NoClassDefFoundError) == true) goto L30;
                throw th;
            L30:
                return MiraPluginFix.forName(r100);
            }
        }

        static {
        }

        public final void a() {
            Handler r100 = f.f403695n;
            Objects.toString(this.f403717g);
            View r101 = this.f403717g;
            if (r101 == null) goto L15;
            Intrinsics.checkNotNull(r101);
            Intrinsics.stringPlus("handleHide parent ", r101.getParent());
            View r102 = this.f403717g;
            Intrinsics.checkNotNull(r102);
            if (r102.getParent() == null) goto L11;
            Objects.toString(this.f403717g);
            WindowManager r103 = this.f403720j;     // Catch: Exception -> L9
            Intrinsics.checkNotNull(r103);     // Catch: Exception -> L9
            r103.removeView(this.f403717g);     // Catch: Exception -> L9
        L9:
            e = move-exception;
            e.printStackTrace();
        L11:
            this.f403717g = null;
            return;
        }

        public final void b() {
            Handler r100 = f.f403695n;
            Intrinsics.stringPlus("SHOW: ", this);
            this.f403713c.removeMessages(1);
            this.f403713c.removeMessages(2);
            this.f403713c.sendEmptyMessage(1);
            this.f403713c.sendEmptyMessageDelayed(2, this.f403716f);
        }

        public b() {
            WindowManager.LayoutParams r100 = new WindowManager.LayoutParams();
            this.f403711a = r100;
            this.f403713c = new a.HandlerC4682a(this);
            this.f403716f = 2000;
            this.f403721k = true;
            r100.height = -2;
            r100.width = -2;
            r100.format = -3;
            Intrinsics.checkNotNullParameter("style", "type");
            int r101 = a.a(Intrinsics.stringPlus("com.android.internal.R$", "style")).getField("Animation_Toast").getInt(null);     // Catch: Exception -> L5
        L7:
            r100.windowAnimations = r101;
            r100.type = 2;
            r100.flags = 168;
            r100.setTitle("ObricCustomToast");
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
            r101 = 0;
            goto L7
        }
    }

    static {
        new a();
        new WeakReference(null);
        f403695n = new Handler(Looper.getMainLooper());
        f403696o = new ArrayDeque();
    }

    public final void a() {
        if (j.d(this.f403709l.findViewById(R.id.iv_icon)) == true) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L11;
        int r101 = this.f403707j - this.f403706i;
    L12:
        this.f403708k = r101;
        ((TextView) this.f403709l.findViewById(R.id.tv_msg)).setMaxWidth(this.f403708k);
        return;
    L11:
        r101 = this.f403707j;
        goto L12
    L5:
        if (j.d(this.f403709l.findViewById(R.id.toast_progress)) == false) goto L8;
        r100 = false;
        goto L9
    }

    public final void c() {
        f403695n.post(new c(this));
    }

    public final void b(Integer r100) {
        ImageView r101 = (ImageView) this.f403709l.findViewById(R.id.iv_icon);
        if (r100 == null) goto L5;
        r101.setImageResource(r100.intValue());
        j.f(r101);
    L6:
        a();
        return;
    L5:
        j.e(r101);
        goto L6
    }

    public f(Context r100, String r101, int r102, boolean r103, Boolean r104, int r110, int r111) {
        if ((r111 & 4) == 0) goto L6;
        r102 = 80;
    L6:
        if ((r111 & 8) == 0) goto L9;
        r103 = false;
    L9:
        if ((r111 & 16) == 0) goto L12;
        r104 = null;
    L12:
        if ((r111 & 32) == 0) goto L14;
        r110 = 0;
    L14:
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.f403698a = r100;
        this.f403699b = r101;
        this.f403700c = r102;
        this.f403701d = r103;
        this.f403702e = r104;
        this.f403703f = r110;
        b r105 = new b();
        this.f403704g = r105;
        int r106 = pla.d.c(r100, 73);
        this.f403706i = pla.d.c(r100, 28);
        if (pla.e.a(r100) == true) goto L17;
        int r112 = pla.d.j(r100) - r106;
    L18:
        this.f403707j = r112;
        this.f403708k = r112;
        LayoutInflater r107 = LayoutInflater.from(r100);
        if (r110 != 0) goto L21;
        int r108 = R.layout.o_toast;
    L25:
        View r109 = r107.inflate(r108, null);
        this.f403709l = r109;
        if (r102 == 80) goto L28;
        this.f403700c = 80;
        wma.b.h("OToast", "custom position is not supported! position 80!");
    L28:
        r105.f403715e = 96;
        r105.f403714d = this.f403700c;
        ((TextView) r109.findViewById(R.id.tv_msg)).setText(r101);
        this.f403710m = (OButton) r109.findViewById(R.id.right_button);
        a();
        return;
    L21:
        if (r110 == 2) goto L23;
        r108 = R.layout.o_toast_light;
        goto L25
    L23:
        r108 = R.layout.o_toast_dark;
        goto L25
    L17:
        r112 = pla.d.c(r100, 288);
        goto L18
    }
}
