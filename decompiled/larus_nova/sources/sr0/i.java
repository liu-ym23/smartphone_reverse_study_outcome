package sr0;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.performance.adapter.DebugNormalInfoAdapter;
import com.bytedance.android.live.performance.adapter.DebugPerformanceTextAdapter;
import com.bytedance.android.live.performance.api.IPerfToolsService;
import com.bytedance.android.live.performance.views.PerftoolsLinearLayout;
import com.bytedance.android.live.performance.views.PerftoolsRelativeLayout;
import com.bytedance.android.live.performance.views.charts.LineChartView;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Arrays;
import jc1.k;

/* JADX INFO: loaded from: classes46.dex */
public final class i implements ur0.a, ur0.b {
    public final Handler A;
    public Button B;
    public Button C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WindowManager f543176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WindowManager.LayoutParams f543177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PerftoolsRelativeLayout f543178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PerftoolsLinearLayout f543179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f543180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameLayout f543181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f543182g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f543183h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public GridView f543184i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public tr0.b f543185j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RecyclerView f543186k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DebugNormalInfoAdapter f543187l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LineChartView f543188m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LinearLayout f543189n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public GridView f543190o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public tr0.g f543191p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f543192q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public RecyclerView f543193r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public DebugPerformanceTextAdapter f543194s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final IPerfToolsService f543195t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Dialog f543196u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f543197v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final a f543198w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Activity f543199x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f543200y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f543201z;

    public class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f543202a;

        public a(i r100) {
            this.f543202a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            i r102 = this.f543202a;
            if (r102.f543182g == false) goto L6;
            View r103 = r102.f543178c;
        L10:
            if (r103 == null) goto L15;
            View r104 = wr0.d.a(r103, r101);
            if (r104 == null) goto L15;
            r104.dispatchTouchEvent(r101);
            return true;
        L15:
            Dialog r105 = this.f543202a.f543196u;
            if (r105 != null) goto L18;
        L35:
            Activity r106 = this.f543202a.f543199x;
            if (r106 == null) goto L38;
            r106.dispatchTouchEvent(r101);
        L38:
            return false;
        L18:
            if (r105.isShowing() == false) goto L35;
            if (this.f543202a.f543197v == true) goto L34;
            int[] r107 = new int[2];
            if (r103 == null) goto L24;
            r103.getLocationOnScreen(r107);
        L25:
            int[] r108 = new int[2];
            Window r109 = this.f543202a.f543196u.getWindow();
            if (r109 == null) goto L33;
            View r110 = r109.getDecorView();
            if (com.larus.home.impl.utils.c.f346345e == false) goto L32;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r111 = ThreadMethodProxy.currentThread();
            if (r111 == com.larus.home.impl.utils.c.f346341a) goto L32;
            com.larus.home.impl.utils.c.a(r111, "getDecorView");
        L32:
            r110.getLocationOnScreen(r108);
        L33:
            r101.offsetLocation(r107[0] - r108[0], r107[1] - r108[1]);
            goto L34
        L24:
            Arrays.fill(r107, 0);
        L34:
            this.f543202a.f543196u.dispatchTouchEvent(r101);
            goto L38
        L6:
            if (r102.f543183h == false) goto L8;
            r103 = r102.f543179d;
            goto L10
        L8:
            r103 = null;
            goto L10
        }
    }

    public final void a() {
        if (this.f543176a != null) goto L5;
        return;
    L5:
        if (this.f543178c != null) goto L7;
        return;
    L7:
        if (this.f543182g == true) goto L9;
        return;
    L9:
        if (wr0.c.a() == false) goto L11;
        this.f543176a.removeViewImmediate(this.f543178c);
    L12:
        this.f543182g = false;
        return;
    L11:
        this.f543176a.removeView(this.f543178c);
        goto L12
    }

    public final void b() {
        if (this.f543176a != null) goto L5;
        return;
    L5:
        if (this.f543179d != null) goto L7;
        return;
    L7:
        if (this.f543183h == true) goto L9;
        return;
    L9:
        if (wr0.c.a() == false) goto L11;
        this.f543176a.removeViewImmediate(this.f543179d);
    L12:
        this.f543183h = false;
        return;
    L11:
        this.f543176a.removeView(this.f543179d);
        goto L12
    }

    public final void c() {
        Activity r100 = this.f543199x;
        if (r100 != null) goto L5;
        return;
    L5:
        PerftoolsLinearLayout r101 = (PerftoolsLinearLayout) LayoutInflater.from(r100).inflate(R.layout.ttlive_popup_entrance_debug, null);
        this.f543179d = r101;
        r101.setActivity(this.f543199x);
        this.f543184i = (GridView) this.f543179d.findViewById(R.id.grid_entrance);
        tr0.b r102 = new tr0.b(this.f543199x, this);
        this.f543185j = r102;
        r102.a(0);
        r102.a(1);
        r102.a(4);
        r102.a(2);
        r102.a(3);
        r102.a(5);
        r102.a(6);
        r102.a(7);
        r102.a(8);
        FrameLayout r103 = (FrameLayout) this.f543179d.findViewById(R.id.close_entrance);
        this.f543181f = r103;
        r103.setOnClickListener(new b(this));
        this.f543184i.setAdapter(this.f543185j);
        WindowManager.LayoutParams r104 = this.f543177b;
        r104.width = -1;
        r104.height = -2;
        r104.x = 0;
        r104.y = 0;
        r104.gravity = 80;
        f();
        this.f543179d.setOnTouchListener(this.f543198w);
        WindowManager r105 = this.f543176a;
        PerftoolsLinearLayout r106 = this.f543179d;
        WindowManager.LayoutParams r107 = this.f543177b;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r106, r107);
        r105.addView(r106, r107);
        this.f543183h = true;
    }

    public final boolean d() {
        RecyclerView r100 = this.f543186k;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getVisibility() != 0) goto L7;
        return true;
    }

    public final boolean e() {
        LinearLayout r100 = this.f543189n;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getVisibility() != 0) goto L7;
        return true;
    }

    public final void f() {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        this.f543177b.type = 2038;
    L6:
        WindowManager.LayoutParams r100 = this.f543177b;
        r100.format = -3;
        r100.flags = (r100.flags | 32) | 8;
        r100.softInputMode = 16;
        return;
    L5:
        this.f543177b.type = 2002;
        goto L6
    }

    public i() {
        this.f543177b = new WindowManager.LayoutParams();
        this.f543198w = new a(this);
        this.f543200y = -1;
        this.f543201z = 1000;
        this.A = new Handler(Looper.getMainLooper());
        this.f543195t = (IPerfToolsService) k.f(IPerfToolsService.class);
    }
}
