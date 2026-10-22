package com.bytedance.bdp.bdpplatform.service.ui.picker.wheel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.bdp.bdpbase.util.o;
import com.bytedance.bdp.serviceapi.defaults.ui.model.WheelItem;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import ib4.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimerTask;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes11.dex */
public class WheelView extends View implements ib4.d {
    public static final /* synthetic */ int T = 0;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public float f201444J;
    public long K;
    public int L;
    public int M;
    public int N;
    public int O;
    public final float P;
    public boolean Q;
    public boolean R;
    public final ArrayList<String> S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f201445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GestureDetector f201446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f201447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f201448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ScheduledFuture<?> f201449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f201450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Paint f201451g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Paint f201452h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f201453i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<WheelItem> f201454j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f201455k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f201456l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f201457m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f201458n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f201459o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f201460p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Typeface f201461q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f201462r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f201463s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public a f201464t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f201465u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f201466v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f201467w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f201468x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f201469y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f201470z;

    public static class StringItem implements WheelItem {
        private final String name;

        @Override // com.bytedance.bdp.serviceapi.defaults.ui.model.WheelItem
        public String getName() {
            return this.name;
        }

        public StringItem(String r100, e r101) {
            this.name = r100;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f201471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f201472b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f201473c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f201474d;

        public final String toString() {
            return "visible=" + this.f201471a + ",color=" + this.f201473c + ",alpha=" + this.f201474d + ",thick=2.0";
        }

        public a() {
            this.f201471a = true;
            this.f201472b = false;
            this.f201473c = -1513240;
            this.f201474d = 220;
        }
    }

    public static class b extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f201475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f201476b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WheelView f201477c;

        public final void a() {
            if (this.f201475a != 2.1474836E9f) goto L12;
            if (Math.abs(this.f201476b) > 2000.0f) goto L7;
            this.f201475a = this.f201476b;
            goto L12
        L7:
            if (this.f201476b <= 0.0f) goto L9;
            this.f201475a = 2000.0f;
            goto L12
        L9:
            this.f201475a = -2000.0f;
        L12:
            if (Math.abs(this.f201475a) >= 0.0f) goto L14;
        L17:
            int r100 = (int) ((this.f201475a * 10.0f) / 1000.0f);
            WheelView r101 = this.f201477c;
            float r102 = r100;
            r101.f201470z -= r102;
            if (r101.f201467w == true) goto L31;
            float r103 = r101.f201460p;
            float r104 = (-r101.A) * r103;
            int r105 = r101.getItemCount() - 1;
            WheelView r106 = this.f201477c;
            float r107 = (r105 - r106.A) * r103;
            float r108 = r106.f201470z;
            double r110 = ((double) r103) * 0.25d;
            if ((((double) r108) - r110) >= r104) goto L23;
            r104 = r108 + r102;
        L26:
            if (r108 > r104) goto L29;
            this.f201475a = 40.0f;
            r106.f201470z = (int) r104;
            goto L31
        L29:
            if (r108 < r107) goto L31;
            r106.f201470z = (int) r107;
            this.f201475a = -40.0f;
            goto L31
        L23:
            if ((((double) r108) + r110) <= r107) goto L26;
            r107 = r108 + r102;
        L31:
            float r109 = this.f201475a;
            if (r109 >= 0.0f) goto L34;
            this.f201475a = r109 + 20.0f;
        L35:
            this.f201477c.f201445a.sendEmptyMessage(1000);
            return;
        L34:
            this.f201475a = r109 - 20.0f;
            goto L35
        L14:
            if (Math.abs(this.f201475a) > 20.0f) goto L17;
            WheelView r111 = this.f201477c;
            int r112 = WheelView.T;
            r111.a();
            this.f201477c.f201445a.sendEmptyMessage(2000);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
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

        public b(WheelView r100, float r101) {
            this.f201475a = 2.1474836E9f;
            this.f201477c = r100;
            this.f201476b = r101;
        }
    }

    public static class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WheelView f201478a;

        public c(WheelView r100) {
            this.f201478a = r100;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            int r101 = r100.what;
            if (r101 != 1000) goto L5;
            this.f201478a.invalidate();
            return;
        L5:
            if (r101 != 2000) goto L7;
            WheelView r102 = this.f201478a;
            int r103 = WheelView.T;
            r102.f(2);
            return;
        L7:
            if (r101 != 3000) goto L18;
            WheelView r104 = this.f201478a;
            if (r104.f201447c == null) goto L19;
            r104.B = r104.C;
            r104.post(new f(r104));
            return;
        L19:
            return;
        }
    }

    public static class d extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f201479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f201480b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f201481c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final WheelView f201482d;

        public final void a() {
            if (this.f201479a != Integer.MAX_VALUE) goto L5;
            this.f201479a = this.f201481c;
        L5:
            int r100 = this.f201479a;
            int r101 = (int) (r100 * 0.1f);
            this.f201480b = r101;
            if (r101 != 0) goto L11;
            if (r100 >= 0) goto L9;
            this.f201480b = -1;
            goto L11
        L9:
            this.f201480b = 1;
        L11:
            if (Math.abs(r100) > 1) goto L13;
            WheelView r102 = this.f201482d;
            int r103 = WheelView.T;
            r102.a();
            this.f201482d.f201445a.sendEmptyMessage(3000);
            return;
        L13:
            WheelView r104 = this.f201482d;
            r104.f201470z += this.f201480b;
            if (r104.f201467w == true) goto L21;
            float r105 = r104.f201460p;
            float r106 = (-r104.A) * r105;
            int r107 = r104.getItemCount() - 1;
            WheelView r108 = this.f201482d;
            float r109 = (r107 - r108.A) * r105;
            float r110 = r108.f201470z;
            if (r110 > r106) goto L18;
        L19:
            r108.f201470z = r110 - this.f201480b;
            r108.a();
            this.f201482d.f201445a.sendEmptyMessage(3000);
            return;
        L18:
            if (r110 >= r109) goto L19;
        L21:
            this.f201482d.f201445a.sendEmptyMessage(1000);
            this.f201479a -= this.f201480b;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
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

        public d(WheelView r100, int r101) {
            this.f201479a = Integer.MAX_VALUE;
            this.f201480b = 0;
            this.f201482d = r100;
            this.f201481c = r101;
        }
    }

    @Override // ib4.d
    public View getWheelView() {
        return this;
    }

    public final void a() {
        ScheduledFuture<?> r100 = this.f201449e;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isCancelled() == true) goto L9;
        this.f201449e.cancel(true);
        this.f201449e = null;
        return;
    }

    public final void d() {
        if (this.f201454j != null) goto L5;
        return;
    L5:
        int r100 = (int) (this.f201460p * (this.E - 1));
        this.F = (int) (((double) (r100 * 2)) / 3.141592653589793d);
        this.H = (int) (((double) r100) / 3.141592653589793d);
        ViewGroup.LayoutParams r101 = getLayoutParams();
        if (this.Q == false) goto L8;
        this.G = View.MeasureSpec.getSize(this.L);
    L26:
        float r102 = this.F;
        float r103 = this.f201460p;
        this.f201468x = (r102 - r103) / 2.0f;
        this.f201469y = (r102 + r103) / 2.0f;
        if (this.A == (-1)) goto L29;
    L32:
        this.D = this.A;
        Resources r104 = getContext().getResources();
        TypedValue.applyDimension(2, 8.0f, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()));
        return;
    L29:
        if (this.f201467w == false) goto L31;
        this.A = (((ArrayList) this.f201454j).size() + 1) / 2;
        goto L32
    L31:
        this.A = 0;
        goto L32
    L8:
        if (r101 == null) goto L12;
        int r105 = r101.width;
        if (r105 <= 0) goto L12;
        this.G = r105;
    L12:
        this.G = this.f201456l;
        if (this.f201466v >= 0) goto L15;
        this.f201466v = (int) o.a(getContext(), 13.0f);
    L15:
        this.G += this.f201466v * 2;
        if (TextUtils.isEmpty(this.f201455k) == true) goto L26;
        int r106 = this.G;
        Paint r107 = this.f201451g;
        String r108 = this.f201455k;
        if (r108 != null) goto L20;
    L24:
        int r109 = 0;
    L25:
        this.G = r106 + r109;
        goto L26
    L20:
        if (r108.length() <= 0) goto L24;
        int r110 = r108.length();
        float[] r111 = new float[r110];
        r107.getTextWidths(r108, r111);
        int r112 = 0;
        r109 = 0;
    L22:
        if (r112 >= r110) goto L25;
        r109 = r109 + ((int) Math.ceil(r111[r112]));
        r112 = r112 + 1;
        goto L22
    }

    public int getItemCount() {
        List<WheelItem> r100 = this.f201454j;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return ((ArrayList) r100).size();
    }

    @Override // ib4.d
    public final int getSelectedIndex() {
        return this.B;
    }

    public WheelView(Context r100) {
        this(r100, null);
    }

    public static String c(Object r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if ((r100 instanceof WheelItem) == false) goto L10;
        return ((WheelItem) r100).getName();
    L10:
        if ((r100 instanceof Integer) == false) goto L14;
        return String.format(Locale.getDefault(), "%02d", new Object[]{r100});
    L14:
        return r100.toString();
    }

    public final int b(int r100) {
        if (r100 >= 0) goto L5;
        return b(r100 + ((ArrayList) this.f201454j).size());
    L5:
        if (r100 > (((ArrayList) this.f201454j).size() - 1)) goto L7;
        return r100;
    L7:
        return b(r100 - ((ArrayList) this.f201454j).size());
    }

    public final void f(int r100) {
        a();
        if (r100 != 2) goto L5;
    L6:
        float r101 = this.f201470z;
        float r102 = this.f201460p;
        int r103 = (int) (((r101 % r102) + r102) % r102);
        this.I = r103;
        if (r103 <= (r102 / 2.0f)) goto L9;
        this.I = (int) (r102 - r103);
    L10:
        this.f201449e = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("eel/WheelView")).scheduleWithFixedDelay(new d(this, this.I), 0, 10, TimeUnit.MILLISECONDS);
        return;
    L9:
        this.I = -r103;
        goto L10
    L5:
        if (r100 != 3) goto L10;
        goto L6
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        List<WheelItem> r100 = this.f201454j;
        if (r100 != null) goto L5;
        return;
    L5:
        if (((ArrayList) r100).size() == 0) goto L145;
        this.S.clear();
        int r101 = this.A + (((int) (this.f201470z / this.f201460p)) % ((ArrayList) this.f201454j).size());
        this.D = r101;
        int r102 = 1;
        int r103 = 0;
        if (this.f201467w == true) goto L14;
        if (r101 >= 0) goto L12;
        this.D = 0;
    L12:
        if (this.D <= (((ArrayList) this.f201454j).size() - 1)) goto L19;
        this.D = ((ArrayList) this.f201454j).size() - 1;
    L19:
        float r111 = this.f201470z % this.f201460p;
        int r104 = 0;
    L20:
        int r105 = this.E;
        if (r104 >= r105) goto L34;
        int r106 = this.D - ((r105 / 2) - r104);
        if (this.f201467w == false) goto L26;
        this.S.add(((WheelItem) ListProtector.get(this.f201454j, b(r106))).getName());
    L32:
        r104 = r104 + 1;
        goto L20
    L26:
        if (r106 >= 0) goto L29;
        this.S.add("");
        goto L32
    L29:
        if (r106 <= (((ArrayList) this.f201454j).size() - 1)) goto L31;
        this.S.add("");
        goto L32
    L31:
        this.S.add(((WheelItem) ListProtector.get(this.f201454j, r106)).getName());
        goto L32
    L34:
        if (this.f201464t.f201471a == false) goto L37;
        float r107 = this.G;
        float r108 = this.f201468x;
        r110.drawLine(r107 * 0.0f, r108, r107 * 1.0f, r108, this.f201452h);
        float r109 = this.G;
        float r112 = this.f201469y;
        r110.drawLine(r109 * 0.0f, r112, r109 * 1.0f, r112, this.f201452h);
    L37:
        if (this.f201464t.f201472b == false) goto L39;
        this.f201453i.setColor(-6710887);
        Paint r113 = this.f201453i;
        this.f201464t.getClass();
        r113.setAlpha(100);
        r110.drawRect(0.0f, this.f201468x, this.G, this.f201469y, this.f201453i);
    L39:
        int r114 = 0;
    L41:
        if (r114 >= this.E) goto L146;
        r110.save();
        double r115 = ((this.f201460p * r114) - r111) / this.H;
        float r116 = (float) (90.0d - ((r115 / 3.141592653589793d) * 180.0d));
        if (r116 < 90.0f) goto L45;
    L132:
        r111 = r111;
        r110.restore();
    L133:
        r114 = r114 + 1;
        this.f201450f.setTextSize(this.f201459o);
        r111 = r111;
        r102 = 1;
        r103 = 0;
        goto L41
    L45:
        if (r116 <= (-90.0f)) goto L132;
        String r117 = c(ListProtector.get(this.S, r114));
        if (this.f201448d == false) goto L50;
    L54:
        String r118 = r117;
    L56:
        if (this.R == false) goto L82;
        Rect r119 = new Rect();
        this.f201451g.getTextBounds(r118, r103, r118.length(), r119);
        float r120 = this.f201458n;
        Paint r121 = new Paint();
        r121.setTextSize(r120);
        float r122 = r121.measureText(r118);
        int r123 = this.f201458n;
        if (r122 <= this.G) goto L60;
        this.f201450f.setTextSize(this.f201459o);
        this.f201451g.setTextSize(r123);
        this.f201451g.getTextBounds(r118, r103, r118.length(), r119);
        boolean r124 = false;
    L61:
        if (r124 == true) goto L81;
        WindowManager r125 = (WindowManager) getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r125 == null) goto L65;
        Point r126 = new Point();
        r125.getDefaultDisplay().getSize(r126);
        int r127 = r126.x;
    L66:
        int r128 = r127 / r110.getWidth();
        if (r128 == r102) goto L73;
        if (r128 == 2) goto L76;
        if (r128 != 3) goto L81;
    L79:
        if (r118.length() <= 5) goto L81;
        r118 = r118.substring(r103, 5) + "...";
    L76:
        if (r118.length() <= 7) goto L79;
        r118 = r118.substring(r103, 7) + "...";
        goto L81
    L73:
        if (r118.length() <= 15) goto L76;
        r118 = r118.substring(r103, 15) + "...";
        goto L81
    L65:
        r127 = -1;
    L81:
        this.M = 17;
    L83:
        Rect r129 = new Rect();
        this.f201451g.getTextBounds(r118, r103, r118.length(), r129);
        int r130 = this.M;
        if (r130 == 3) goto L91;
        if (r130 != 5) goto L87;
        this.N = (this.G - r129.width()) - ((int) this.P);
    L92:
        Rect r131 = new Rect();
        this.f201450f.getTextBounds(r118, 0, r118.length(), r131);
        int r132 = this.M;
        if (r132 != 3) goto L95;
        this.O = (int) o.a(getContext(), 8.0f);
    L102:
        float r133 = (float) ((((double) this.H) - (Math.cos(r115) * ((double) this.H))) - ((Math.sin(r115) * ((double) this.f201457m)) / 2.0d));
        r110.translate(0.0f, r133);
        float r134 = this.f201468x;
        if (r133 <= r134) goto L105;
    L107:
        float r135 = this.f201469y;
        if (r133 > r135) goto L114;
        if ((this.f201457m + r133) < r135) goto L114;
        r110.save();
        r110.clipRect(0.0f, 0.0f, this.G, this.f201469y - r133);
        r110.scale(1.0f, ((float) Math.sin(r115)) * 1.0f);
        r110.drawText(r118, this.N, this.f201457m - this.P, this.f201451g);
        r110.restore();
        r110.save();
        r110.clipRect(0.0f, this.f201469y - r133, this.G, (int) this.f201460p);
        r110.scale(1.0f, ((float) Math.sin(r115)) * 1.0f);
        r110.drawText(r118, this.O, this.f201457m, this.f201450f);
        r110.restore();
    L131:
        r110.restore();
        this.f201451g.setTextSize(this.f201458n);
    L114:
        if (r133 < r134) goto L130;
        int r136 = this.f201457m;
        if ((r136 + r133) > r135) goto L130;
        r110.clipRect(0, 0, this.G, r136 + 5);
        float r137 = this.f201457m - this.P;
        Iterator r138 = ((ArrayList) this.f201454j).iterator();
        int r139 = 0;
    L119:
        if (r138.hasNext() == false) goto L125;
        if (((WheelItem) r138.next()).getName().equals(r117) == true) goto L122;
        r139 = r139 + 1;
        goto L119
    L122:
        this.C = r139;
    L125:
        if (this.f201448d == true) goto L127;
    L129:
        r110.drawText(r118, this.N, r137, this.f201451g);
        goto L131
    L127:
        if (TextUtils.isEmpty(this.f201455k) == true) goto L129;
        r118 = r118 + this.f201455k;
    L130:
        r110.save();
        r110.clipRect(0.0f, 0.0f, this.G, this.f201460p);
        r110.drawText(r118, this.O, this.f201457m, this.f201450f);
        r110.restore();
        goto L131
    L105:
        if ((this.f201457m + r133) < r134) goto L107;
        r110.save();
        r110.clipRect(0.0f, 0.0f, this.G, this.f201468x - r133);
        r110.scale(1.0f, ((float) Math.sin(r115)) * 1.0f);
        r110.drawText(r118, this.O, this.f201457m, this.f201450f);
        r110.restore();
        r110.save();
        r110.clipRect(0.0f, this.f201468x - r133, this.G, (int) this.f201460p);
        r110.scale(1.0f, ((float) Math.sin(r115)) * 1.0f);
        r110.drawText(r118, this.N, this.f201457m - this.P, this.f201451g);
        r110.restore();
        goto L131
    L95:
        if (r132 != 5) goto L97;
        this.O = (this.G - r131.width()) - ((int) this.P);
        goto L102
    L97:
        if (r132 != 17) goto L102;
        this.O = (int) (((double) (this.G - r131.width())) * 0.5d);
        goto L102
    L87:
        if (r130 != 17) goto L92;
        this.N = (int) (((double) (this.G - r129.width())) * 0.5d);
        goto L92
    L91:
        this.N = (int) o.a(getContext(), 8.0f);
        goto L92
    L60:
        r124 = true;
        goto L61
    L82:
        this.M = 3;
        goto L83
    L50:
        if (TextUtils.isEmpty(this.f201455k) == true) goto L54;
        if (TextUtils.isEmpty(r117) == true) goto L54;
        r118 = r117 + this.f201455k;
        goto L56
    L146:
        return;
    L14:
        if (r101 >= 0) goto L17;
        this.D = ((ArrayList) this.f201454j).size() + this.D;
    L17:
        if (this.D <= (((ArrayList) this.f201454j).size() - 1)) goto L19;
        this.D -= ((ArrayList) this.f201454j).size();
        goto L19
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        boolean r100 = this.f201446b.onTouchEvent(r110);
        ViewParent r101 = getParent();
        int r102 = r110.getAction();
        if (r102 != 0) goto L5;
        this.K = System.currentTimeMillis();
        a();
        this.f201444J = r110.getRawY();
        if (r101 == null) goto L30;
        r101.requestDisallowInterceptTouchEvent(true);
    L30:
        invalidate();
        return true;
    L5:
        if (r102 == 2) goto L13;
        if (r100 == true) goto L11;
        float r111 = r110.getY();
        int r103 = this.H;
        double r104 = Math.acos((r103 - r111) / r103) * ((double) this.H);
        float r112 = this.f201460p;
        this.I = (int) (((((int) ((r104 + ((double) (r112 / 2.0f))) / ((double) r112))) - (this.E / 2)) * r112) - (((this.f201470z % r112) + r112) % r112));
        if ((System.currentTimeMillis() - this.K) <= 120) goto L10;
        f(3);
        goto L11
    L10:
        f(1);
    L11:
        if (r101 == null) goto L30;
        r101.requestDisallowInterceptTouchEvent(false);
        goto L30
    L13:
        float r105 = this.f201444J - r110.getRawY();
        this.f201444J = r110.getRawY();
        this.f201470z += r105;
        if (this.f201467w == true) goto L30;
        float r113 = (-this.A) * this.f201460p;
        float r106 = (((ArrayList) this.f201454j).size() - 1) - this.A;
        float r107 = this.f201460p;
        float r108 = r106 * r107;
        float r109 = this.f201470z;
        if ((((double) r109) - (((double) r107) * 0.25d)) >= r113) goto L19;
        r113 = r109 - r105;
    L22:
        if (r109 >= r113) goto L25;
        this.f201470z = (int) r113;
        goto L30
    L25:
        if (r109 <= r108) goto L30;
        this.f201470z = (int) r108;
        goto L30
    L19:
        if ((((double) r109) + (((double) r107) * 0.25d)) <= r108) goto L22;
        r108 = r109 - r105;
        goto L22
    }

    public final void setCycleDisable(boolean r100) {
        this.f201467w = !r100;
    }

    public void setDividerColor(int r100) {
        this.f201464t.f201473c = r100;
        this.f201452h.setColor(r100);
    }

    public void setDividerConfig(a r100) {
        if (r100 != null) goto L5;
        a r101 = this.f201464t;
        r101.f201471a = false;
        r101.f201472b = false;
        return;
    L5:
        this.f201464t = r100;
        this.f201452h.setColor(r100.f201473c);
        this.f201452h.setStrokeWidth(2.0f);
        this.f201452h.setAlpha(r100.f201474d);
        this.f201453i.setColor(-6710887);
        this.f201453i.setAlpha(100);
    }

    public final void setGravity(int r100) {
        this.M = r100;
    }

    @Override // ib4.d
    public final void setItems(List<?> r100) {
        ((ArrayList) this.f201454j).clear();
        Rect r101 = new Rect();
        Iterator<?> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L19;
        Object r103 = r102.next();
        if ((r103 instanceof WheelItem) == false) goto L9;
        WheelItem r104 = (WheelItem) r103;
    L16:
        ((ArrayList) this.f201454j).add(r104);
        String r105 = c(r104);
        this.f201451g.getTextBounds(r105, 0, r105.length(), r101);
        int r106 = r101.width();
        if (r106 <= this.f201456l) goto L4;
        this.f201456l = r106;
        goto L4
    L9:
        if ((r103 instanceof CharSequence) == false) goto L11;
    L15:
        r104 = new StringItem(r103.toString(), null);
        goto L16
    L11:
        if ((r103 instanceof Number) == true) goto L15;
        throw new IllegalArgumentException("please implements ".concat(WheelItem.class.getName()));
    L19:
        this.f201451g.getTextBounds(getContext().getString(R.string.bdp_testing), 0, 2, r101);
        this.f201457m = r101.height() + 2;
        this.f201460p = (int) o.a(getContext(), 48.0f);
        d();
        invalidate();
    }

    public final void setLabel(String r100) {
        this.f201455k = r100;
        this.f201448d = true;
    }

    public void setLineConfig(a r100) {
        setDividerConfig(r100);
    }

    public final void setLineSpaceMultiplier(float r100) {
        this.f201465u = r100;
        if (r100 >= 1.5f) goto L6;
        this.f201465u = 1.5f;
        return;
    L6:
        if (r100 <= 4.0f) goto L10;
        this.f201465u = 4.0f;
        return;
    }

    public final void setOffset(int r100) {
        if (r100 < 1) goto L13;
        if (r100 > 5) goto L13;
        int r101 = (r100 * 2) + 1;
        if ((r100 % 2) == 0) goto L10;
        r100 = r100 - 1;
    L10:
        setVisibleItemCount(r101 + r100);
        return;
    L13:
        throw new IllegalArgumentException("must between 1 and 5");
    }

    @Override // ib4.d
    public final void setOnItemSelectListener(g r100) {
        this.f201447c = r100;
    }

    public final void setOutTextSize(float r100) {
        if (r100 <= 0.0f) goto L6;
        Resources r101 = getContext().getResources();
        int r102 = (int) (WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * r100);
        this.f201459o = r102;
        this.f201450f.setTextSize(r102);
        return;
    }

    public void setPadding(int r100) {
        setTextPadding(r100);
    }

    @Override // ib4.d
    public final void setSelectedIndex(int r100) {
        List<WheelItem> r101 = this.f201454j;
        if (r101 != null) goto L5;
        return;
    L5:
        if (((ArrayList) r101).isEmpty() == true) goto L19;
        int r102 = ((ArrayList) this.f201454j).size();
        if (r100 == 0) goto L13;
        if (r100 <= 0) goto L16;
        if (r100 < r102) goto L12;
        return;
    L12:
        if (r100 != this.B) goto L13;
        return;
    L16:
        return;
    L13:
        this.B = r100;
        this.A = r100;
        this.f201470z = 0.0f;
        this.I = 0;
        invalidate();
        return;
    }

    public void setTextColor(int r100) {
        this.f201462r = r100;
        this.f201463s = r100;
        this.f201450f.setColor(r100);
        this.f201451g.setColor(r100);
    }

    public void setTextPadding(int r100) {
        this.f201466v = (int) o.a(getContext(), r100);
    }

    public final void setTextSize(float r100) {
        if (r100 <= 0.0f) goto L6;
        Resources r101 = getContext().getResources();
        int r102 = (int) (WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * r100);
        this.f201458n = r102;
        this.f201451g.setTextSize(r102);
        return;
    }

    public void setTextSizeAutoFit(boolean r100) {
        this.R = r100;
    }

    public void setTextSkewXOffset(int r100) {
        if (r100 == 0) goto L5;
        this.f201451g.setTextScaleX(1.0f);
        return;
    }

    public final void setTypeface(Typeface r100) {
        this.f201461q = r100;
        this.f201450f.setTypeface(r100);
        this.f201451g.setTypeface(this.f201461q);
    }

    public void setUseWeight(boolean r100) {
        this.Q = r100;
    }

    public final void setVisibleItemCount(int r100) {
        if ((r100 % 2) == 0) goto L9;
        if (r100 == this.E) goto L10;
        this.E = r100;
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("must be odd");
    }

    public final void setItems(String[] r100) {
        setItems(Arrays.asList(r100));
    }

    public WheelView(Context r100, AttributeSet r110) {
        super(r100, r110);
        this.f201448d = true;
        this.f201454j = new ArrayList();
        this.f201458n = 17;
        this.f201459o = 15;
        this.f201461q = Typeface.DEFAULT;
        this.f201462r = -6710887;
        this.f201463s = -14540254;
        this.f201464t = new a();
        this.f201465u = 3.0f;
        this.f201466v = -1;
        this.f201467w = true;
        this.f201470z = 0.0f;
        this.A = -1;
        this.E = 11;
        this.I = 0;
        this.f201444J = 0.0f;
        this.K = 0;
        this.M = 17;
        this.N = 0;
        this.O = 0;
        this.Q = false;
        this.R = true;
        this.S = new ArrayList();
        Resources r101 = getResources();
        float r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density;
        if (r102 >= 1.0f) goto L6;
        this.P = 2.4f;
    L22:
        float r103 = this.f201465u;
        if (r103 >= 1.5f) goto L26;
        this.f201465u = 1.5f;
    L28:
        this.f201445a = new c(this);
        GestureDetector r104 = new GestureDetector(r100, new e(this));
        this.f201446b = r104;
        r104.setIsLongpressEnabled(false);
        Paint r105 = new Paint();
        this.f201450f = r105;
        r105.setAntiAlias(true);
        this.f201450f.setColor(this.f201462r);
        this.f201450f.setTypeface(this.f201461q);
        this.f201450f.setTextSize(this.f201459o);
        Paint r106 = new Paint();
        this.f201451g = r106;
        r106.setAntiAlias(true);
        this.f201451g.setColor(this.f201463s);
        this.f201451g.setTextScaleX(1.0f);
        this.f201451g.setTypeface(this.f201461q);
        this.f201451g.setTextSize(this.f201458n);
        Paint r107 = new Paint();
        this.f201452h = r107;
        r107.setAntiAlias(true);
        this.f201452h.setColor(this.f201464t.f201473c);
        Paint r108 = this.f201452h;
        this.f201464t.getClass();
        r108.setStrokeWidth(2.0f);
        this.f201452h.setAlpha(this.f201464t.f201474d);
        Paint r109 = new Paint();
        this.f201453i = r109;
        r109.setAntiAlias(true);
        Paint r111 = this.f201453i;
        this.f201464t.getClass();
        r111.setColor(-6710887);
        Paint r112 = this.f201453i;
        this.f201464t.getClass();
        r112.setAlpha(100);
        setLayerType(1, null);
        return;
    L26:
        if (r103 <= 4.0f) goto L28;
        this.f201465u = 4.0f;
        goto L28
    L6:
        if (1.0f <= r102) goto L8;
    L10:
        if (1.0f > r102) goto L15;
        if (r102 >= 2.0f) goto L15;
        this.P = 4.5f;
    L15:
        if (2.0f > r102) goto L20;
        if (r102 >= 3.0f) goto L20;
        this.P = 6.0f;
    L20:
        if (r102 < 3.0f) goto L22;
        this.P = r102 * 2.5f;
        goto L22
    L8:
        if (r102 >= 2.0f) goto L10;
        this.P = 3.6f;
        goto L22
    }

    public final void e(List<?> r100, int r101) {
        setItems(r100);
        setSelectedIndex(r101);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        this.L = r100;
        d();
        setMeasuredDimension(this.G, this.F);
    }
}
