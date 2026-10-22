package com.lynx.tasm.behavior;

import android.graphics.RectF;
import androidx.camera.video.AudioStats;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f382317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<d0> f382318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LynxBaseUI f382319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LynxBaseUI f382320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LynxBaseUI f382321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f382322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f382323g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f382324h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f382325i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList<Float> f382326j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f382327k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f382328l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f382329m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList<b> f382330n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f382331o;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RectF f382332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RectF f382333b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public RectF f382334c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f382335d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f382336e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f382337f;

        public final JavaOnlyMap b() {
            JavaOnlyMap r100 = new JavaOnlyMap();
            r100.putMap("relativeRect", a(this.f382332a));
            r100.putMap("boundingClientRect", a(this.f382333b));
            r100.putMap("intersectionRect", a(this.f382334c));
            r100.putDouble("intersectionRatio", this.f382335d);
            r100.putBoolean("isIntersecting", this.f382336e);
            r100.putDouble("time", AudioStats.AUDIO_AMPLITUDE_NONE);
            r100.putString("observerId", this.f382337f);
            return r100;
        }

        public void update() {
            if (this.f382334c != null) goto L6;
            this.f382335d = 0.0f;
            return;
        L6:
            float r100 = this.f382333b.width() * this.f382333b.height();
            float r101 = this.f382334c.width() * this.f382334c.height();
            if (r100 <= 0.0f) goto L9;
            this.f382335d = r101 / r100;
            return;
        L9:
            this.f382335d = 0.0f;
        }

        public a() {
        }

        public static JavaOnlyMap a(RectF r100) {
            JavaOnlyMap r101 = new JavaOnlyMap();
            if (r100 == null) goto L5;
            r101.putDouble("left", r100.left);
            r101.putDouble("right", r100.right);
            r101.putDouble("top", r100.top);
            r101.putDouble("bottom", r100.bottom);
        L6:
            return r101;
        L5:
            r101.putDouble("left", AudioStats.AUDIO_AMPLITUDE_NONE);
            r101.putDouble("right", AudioStats.AUDIO_AMPLITUDE_NONE);
            r101.putDouble("top", AudioStats.AUDIO_AMPLITUDE_NONE);
            r101.putDouble("bottom", AudioStats.AUDIO_AMPLITUDE_NONE);
            goto L6
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LynxBaseUI f382338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f382339b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a f382340c;

        public b() {
        }
    }

    public final RectF b() {
        RectF r100 = new RectF();
        d0 r101 = this.f382318b.get();
        if (r101 != null) goto L5;
        return r100;
    L5:
        LynxBaseUI r102 = this.f382321e;
        if (r102 == null) goto L9;
        RectF r103 = r101.d(r102);
    L12:
        r103.left -= this.f382322f;
        r103.right += this.f382323g;
        r103.top -= this.f382324h;
        r103.bottom += this.f382325i;
        return r103;
    L9:
        if (this.f382328l == false) goto L11;
        r103 = r101.g(getContext());
        goto L12
    L11:
        r103 = r101.d(r101.getContext().getUIBody());
        goto L12
    }

    public LynxContext getContext() {
        d0 r100 = this.f382318b.get();
        if (r100 != null) goto L7;
        LLog.e("LynxIntersectionObserver", "getContext failed because mManager is null");
        return null;
    L7:
        return r100.getContext();
    }

    public final LynxUIOwner c() {
        LynxContext r100 = getContext();
        if (r100 != null) goto L7;
        LLog.e("LynxIntersectionObserver", "getRootUIOwner failed because context is null");
        return null;
    L7:
        return r100.getLynxUIOwner();
    }

    public final void d(ReadableMap r100) {
        this.f382322f = com.lynx.tasm.utils.n.a(r100.getString("left", "0"), 0.0f);
        this.f382323g = com.lynx.tasm.utils.n.a(r100.getString("right", "0"), 0.0f);
        this.f382324h = com.lynx.tasm.utils.n.a(r100.getString("top", "0"), 0.0f);
        this.f382325i = com.lynx.tasm.utils.n.a(r100.getString("bottom", "0"), 0.0f);
    }

    public u(d0 r100, ReadableMap r101, LynxBaseUI r102) {
        this(r100, -1, "-1", r101);
        this.f382319c = r102;
        String r103 = r101.getString("relativeToIdSelector", null);
        this.f382328l = r101.getBoolean("relativeToScreen", false);
        this.f382322f = com.lynx.tasm.utils.n.a(r101.getString("marginLeft", "0"), 0.0f);
        this.f382323g = com.lynx.tasm.utils.n.a(r101.getString("marginRight", "0"), 0.0f);
        this.f382324h = com.lynx.tasm.utils.n.a(r101.getString("marginTop", "0"), 0.0f);
        this.f382325i = com.lynx.tasm.utils.n.a(r101.getString("marginBottom", "0"), 0.0f);
        if (r103 != null) goto L5;
    L7:
        this.f382331o = true;
        b r104 = new b();
        r104.f382338a = r102;
        this.f382330n.add(r104);
        a(r104, b(), true);
        return;
    L5:
        if (r103.startsWith("#") == false) goto L7;
        this.f382321e = this.f382318b.get().getContext().getLynxUIOwner().findLynxUIByIdSelectorSearchUp(r103.substring(1), r102);
        goto L7
    }

    public final void a(b r110, RectF r111, boolean r210) {
        WeakReference<d0> r100 = this.f382318b;
        if (r100 != null) goto L5;
        return;
    L5:
        d0 r101 = r100.get();
        if (r101 != null) goto L8;
        return;
    L8:
        RectF r102 = r101.d(r110.f382338a);
        LynxBaseUI r103 = r110.f382338a;
        if (r103.isVisible() == false) goto L53;
        d0 r104 = this.f382318b.get();
        if (r104 == null) goto L53;
        LynxBaseUI r105 = (LynxBaseUI) r103.getParent();
        LynxBaseUI r112 = this.f382321e;
        if (r112 == null) goto L17;
    L23:
        RectF r113 = r102;
        boolean r114 = false;
    L24:
        if (r114 == true) goto L48;
        if (r105 == null) goto L48;
        if (r105.isVisible() == false) goto L53;
        if (r105 != r112) goto L36;
        if (this.f382328l == false) goto L33;
        RectF r115 = r104.d(r105);
    L34:
        boolean r116 = true;
    L39:
        if (r115 != null) goto L41;
    L44:
        if (r113 == null) goto L48;
        r105 = (LynxBaseUI) r105.getParent();
        r114 = r116;
        goto L24
    L41:
        if (r115.intersects(r113.left, r113.top, r113.right, r113.bottom) == false) goto L43;
        r113 = new RectF(Math.max(r115.left, r113.left), Math.max(r115.top, r113.top), Math.min(r115.right, r113.right), Math.min(r115.bottom, r113.bottom));
        goto L44
    L43:
        r113 = null;
        goto L44
    L33:
        r115 = r111;
        goto L34
    L36:
        if (r105.getOverflow() != 0) goto L38;
        r116 = r114;
        r115 = r104.d(r105);
        goto L39
    L38:
        r116 = r114;
        r115 = null;
    L48:
        if (this.f382328l == false) goto L54;
        RectF r106 = r104.d(r104.getContext().getLynxUIOwner().getRootUI());
        r102.offset(r106.left, r106.top);
        if (r113 == null) goto L54;
        r113.offset(r106.left, r106.top);
        if (r113.intersect(r111) == false) goto L53;
    L54:
        RectF r107 = r113;
    L55:
        a r108 = new a();
        if (r107 == null) goto L61;
        if (r107.isEmpty() == true) goto L61;
        r108.f382336e = true;
    L61:
        r108.f382333b = r102;
        r108.f382332a = r111;
        r108.f382334c = r107;
        LynxBaseUI r109 = r110.f382338a;
        if (r109 != null) goto L64;
    L66:
        String r117 = "";
    L67:
        r108.f382337f = r117;
        r108.update();
        a r118 = r110.f382340c;
        r110.f382340c = r108;
        int r119 = r110.f382339b;
        if (r210 == true) goto L70;
        float r120 = -1.0f;
        if (r118 != null) goto L75;
    L77:
        float r121 = -1.0f;
    L79:
        if (r108.f382334c == null) goto L82;
        r120 = r108.f382335d;
    L82:
        if (r121 == r120) goto L101;
        Iterator<Float> r122 = this.f382326j.iterator();
    L86:
        if (r122.hasNext() == false) goto L101;
        float r123 = r122.next().floatValue();
        if (r123 == r121) goto L100;
        if (r123 == r120) goto L100;
        if (r123 >= r121) goto L94;
        boolean r124 = true;
    L96:
        if (r123 >= r120) goto L98;
        boolean r125 = true;
    L99:
        if (r124 == r125) goto L86;
    L98:
        r125 = false;
        goto L99
    L94:
        r124 = false;
    L100:
        boolean r126 = true;
    L102:
        if (r126 == true) goto L104;
        return;
    L104:
        if (this.f382331o == false) goto L107;
        UIThreadUtils.runOnUiThreadImmediately(new v(r101, this.f382319c.getSign(), r108.b()));
        return;
    L107:
        if (this.f382329m == false) goto L109;
        UIThreadUtils.runOnUiThreadImmediately(new w(r101, this.f382317a, r119, r108.b()));
        return;
    L109:
        UIThreadUtils.runOnUiThreadImmediately(new x(r101, this.f382317a, r119, r108.b()));
        return;
    L101:
        r126 = false;
        goto L102
    L75:
        if (r118.f382334c == null) goto L77;
        r121 = r118.f382335d;
        goto L79
    L70:
        if (this.f382327k >= r108.f382335d) goto L101;
    L64:
        if (r109.getIdSelector() == null) goto L66;
        r117 = r110.f382338a.getIdSelector();
        goto L67
    L17:
        if (r104.getContext() != null) goto L19;
    L22:
        LLog.e("LynxIntersectionObserver", "Get UI error");
        goto L23
    L19:
        if (r104.getContext().getLynxUIOwner() == null) goto L22;
        r112 = r104.getContext().getLynxUIOwner().getRootUI();
    L53:
        r107 = null;
        goto L55
    }

    public u(d0 r100, int r101, String r102, ReadableMap r103) {
        WeakReference<d0> r104 = new WeakReference(r100);
        this.f382318b = r104;
        this.f382317a = r101;
        if ("-1".equals(r102) == false) goto L5;
        this.f382320d = r104.get().getContext().getUIBody();
    L6:
        ArrayList<Float> r105 = new ArrayList();
        this.f382326j = r105;
        ReadableArray r106 = r103.getArray("thresholds");
        if (r106 == null) goto L12;
        int r107 = 0;
    L10:
        if (r107 >= r106.size()) goto L13;
        this.f382326j.add(Float.valueOf((float) r106.getDouble(r107)));
        r107 = r107 + 1;
    L13:
        this.f382327k = (float) r103.getDouble("initialRatio", AudioStats.AUDIO_AMPLITUDE_NONE);
        r103.getBoolean("observeAll", false);
        this.f382329m = r103.getBoolean("__enableGlobalEvent", false);
        this.f382330n = new ArrayList();
        this.f382331o = false;
        return;
    L12:
        r105.add(Float.valueOf(0.0f));
        goto L13
    L5:
        this.f382320d = r104.get().getContext().findLynxUIByComponentId(r102);
        goto L6
    }
}
