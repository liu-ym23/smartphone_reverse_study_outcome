package ko1;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.chatroom.ui.x6;
import com.bytedance.android.livesdk.config.LiveInitSettingKeys;
import com.bytedance.android.livesdk.widgetdescriptor.data.LandscapeInteractionModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f504371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f504372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f504373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f504374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f504375e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f504376f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f504377g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f504378h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f504379i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f504380j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ViewGroup f504381k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LandscapeInteractionModel f504382l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.android.live.platformplayer.layout.c f504383m;

    @Override // ko1.c
    public final void a() {
        this.f504371a.f504394c = true;
        this.f504373c.f504418q = true;
        if (LiveInitSettingKeys.get_LIVE_PLAYER_LAYOUT_V1_ENABLE() == true) goto L6;
        this.f504380j.getViewTreeObserver().addOnPreDrawListener(new a(this));
        return;
    }

    public final void e() {
        e r100 = this.f504371a;
        r100.f504392a = 1.0f;
        r100.f504393b = 1.0f;
        r100.f504397f = false;
        r100.f504398g = true;
        g r101 = this.f504373c;
        r101.f504402a = 1.0f;
        r101.f504419r = 1.0f;
        r101.f504420s = 1.0f;
        r101.f504403b = 0.0f;
        r101.f504404c = 0.0f;
        r101.f504405d = 0.0f;
        r101.f504406e = 0.0f;
        r101.f504407f = 0.0f;
        r101.f504408g = 0.0f;
        r101.f504409h = false;
        r101.f504410i = 0;
        r101.f504411j = 0;
        r101.f504412k = 0;
        r101.f504413l = 0;
        r101.f504414m = 0.0f;
        r101.f504415n = 0.0f;
        r101.f504416o = 0.0f;
        r101.f504417p = 0.0f;
    }

    @Override // ko1.c
    public boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "resetType");
        if (this.f504380j.getScaleX() == 1.0f) goto L5;
    L7:
        this.f504380j.setScaleX(1.0f);
        this.f504380j.setScaleY(1.0f);
        this.f504380j.setX(this.f504378h);
        this.f504380j.setY(this.f504379i);
        this.f504380j.setPivotX(this.f504376f);
        this.f504380j.setPivotY(this.f504377g);
        e();
        d(false);
        int r101 = x6.f114300a;
        x6.f114304e = false;
        com.bytedance.android.live.platformplayer.layout.c r102 = this.f504383m;
        if (r102 == null) goto L12;
        r102.setScaleX(1.0f);
        r102.setScaleY(1.0f);
        r102.setTranslationX(0.0f);
        r102.setTranslationY(0.0f);
        return true;
    L12:
        return true;
    L5:
        if (this.f504380j.getScaleY() != 1.0f) goto L7;
        return false;
    }

    @Override // ko1.c
    public boolean c(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if (x6.c() == true) goto L8;
        if (x6.e() == true) goto L8;
        return false;
    L8:
        if (r110.getPointerCount() != 1) goto L14;
        if (this.f504375e == false) goto L14;
        return this.f504374d.onTouchEvent(r110);
    L14:
        if (r110.getPointerCount() == 2) goto L20;
        if (this.f504375e == false) goto L20;
        return false;
    L20:
        if (r110.getAction() != 1) goto L22;
        boolean r100 = true;
    L23:
        this.f504375e = r100;
        if (r100 == false) goto L30;
        e r101 = this.f504371a;
        if (r101.f504394c == false) goto L30;
        if (r101.f504393b >= r101.f504396e) goto L30;
        r101.f504392a = 1.0f;
        r101.a(Float.valueOf(1.0f), Float.valueOf(r101.f504392a));
        r101.f504393b = r101.f504392a;
    L30:
        e r102 = this.f504371a;
        r102.getClass();
        float r103 = x6.a();
        float r104 = r102.f504392a;
        float r105 = r102.f504395d;
        if (r104 > (r105 * r103)) goto L35;
        r105 = r102.f504396e;
        if (r104 < (r105 * r103)) goto L35;
    L36:
        g r106 = this.f504373c;
        r106.getClass();
        if (x6.f114300a != 1) goto L42;
        float r107 = r104 / x6.a();
        if (x6.f114301b == false) goto L41;
        float r108 = r107;
        r107 = r104;
    L43:
        float r109 = r106.f504410i;
        float r111 = r109 * r107;
        r106.f504405d = r111;
        r106.f504406e = r106.f504411j * r108;
        if (r111 < r106.f504412k) goto L46;
        float r112 = r111 - r109;
        float r113 = 2;
        r106.f504414m = (r112 / r113) - (r106.f504422u.getWidth() - r106.f504421t.getRight());
        float r114 = ((r106.f504405d - r106.f504410i) / r113) - r106.f504421t.getLeft();
        r106.f504416o = r114;
        float r115 = r106.f504419r;
        if (r107 >= r115) goto L68;
        float r116 = r106.f504403b;
        if (r116 >= 0) goto L68;
        if ((-r116) <= r106.f504414m) goto L68;
        float r117 = (r106.f504407f - r106.f504405d) / r113;
        r106.a(r106.f504421t.getTranslationX() + r117);
        r106.f504403b += r117;
    L74:
        float r118 = r106.f504406e;
        if (r118 >= r106.f504413l) goto L92;
        float r119 = 2;
        r106.f504415n = r106.f504421t.getTop() - ((r106.f504406e - r106.f504411j) / r119);
        r106.f504417p = (r106.f504422u.getHeight() - r106.f504421t.getBottom()) - ((r106.f504406e - r106.f504411j) / r119);
        if (r106.f504418q == false) goto L79;
        r106.f504404c = 0.0f;
        r106.b(0.0f);
    L79:
        float r120 = r106.f504420s;
        if (r108 <= r120) goto L86;
        float r121 = r106.f504404c;
        if (r121 >= 0) goto L86;
        if ((-r121) <= r106.f504415n) goto L86;
        float r122 = (r106.f504406e - r106.f504408g) / r119;
        r106.b(r106.f504421t.getTranslationY() + r122);
        r106.f504404c += r122;
    L105:
        r106.f504407f = r106.f504405d;
        r106.f504408g = r106.f504406e;
        r106.f504402a = r104;
        r106.f504419r = r107;
        r106.f504420s = r108;
        if (r104 <= x6.a()) goto L108;
        d(true);
        x6.f114304e = true;
    L110:
        return this.f504372b.onTouchEvent(r110);
    L108:
        d(false);
        x6.f114304e = false;
    L86:
        if (r108 <= r120) goto L105;
        float r123 = r106.f504404c;
        if (r123 <= 0) goto L105;
        if (r123 <= r106.f504417p) goto L105;
        float r124 = (r106.f504406e - r106.f504408g) / r119;
        r106.b(r106.f504421t.getTranslationY() - r124);
        r106.f504404c -= r124;
        goto L105
    L92:
        float r125 = 2;
        r106.f504415n = ((r118 - r106.f504411j) / r125) - (r106.f504422u.getHeight() - r106.f504421t.getBottom());
        float r126 = ((r106.f504406e - r106.f504411j) / r125) - r106.f504421t.getTop();
        r106.f504417p = r126;
        float r127 = r106.f504420s;
        if (r108 >= r127) goto L99;
        float r128 = r106.f504404c;
        if (r128 >= 0) goto L99;
        if ((-r128) <= r106.f504415n) goto L99;
        float r129 = (r106.f504408g - r106.f504406e) / r125;
        r106.b(r106.f504421t.getTranslationY() + r129);
        r106.f504404c += r129;
    L99:
        if (r108 >= r127) goto L105;
        float r130 = r106.f504404c;
        if (r130 <= 0) goto L105;
        if (r130 <= r126) goto L105;
        float r131 = (r106.f504408g - r106.f504406e) / r125;
        r106.b(r106.f504421t.getTranslationY() - r131);
        r106.f504404c -= r131;
    L68:
        if (r107 >= r115) goto L74;
        float r132 = r106.f504403b;
        if (r132 <= 0) goto L74;
        if (r132 <= r114) goto L74;
        float r133 = (r106.f504407f - r106.f504405d) / r113;
        r106.a(r106.f504421t.getTranslationX() - r133);
        r106.f504403b -= r133;
        goto L74
    L46:
        if (r106.f504418q == false) goto L48;
        r106.f504403b = 0.0f;
        r106.a(0.0f);
    L48:
        float r134 = 2;
        r106.f504414m = r106.f504421t.getLeft() - ((r106.f504405d - r106.f504410i) / r134);
        float r135 = r106.f504422u.getWidth() - r106.f504421t.getRight();
        float r136 = r106.f504405d;
        float r137 = r135 - ((r136 - r106.f504410i) / r134);
        r106.f504416o = r137;
        float r138 = r106.f504419r;
        if (r107 <= r138) goto L55;
        float r139 = r106.f504403b;
        if (r139 >= 0) goto L55;
        if ((-r139) <= r106.f504414m) goto L55;
        float r140 = (r136 - r106.f504407f) / r134;
        r106.a(r106.f504421t.getTranslationX() + r140);
        r106.f504403b += r140;
    L55:
        if (r107 <= r138) goto L74;
        float r141 = r106.f504403b;
        if (r141 <= 0) goto L74;
        if (r141 <= r137) goto L74;
        float r142 = (r136 - r106.f504407f) / r134;
        r106.a(r106.f504421t.getTranslationX() - r142);
        r106.f504403b -= r142;
        goto L74
    L41:
        r108 = r104;
        goto L43
    L42:
        r107 = r104;
        r108 = r107;
    L35:
        r104 = r105 * r103;
        goto L36
    L22:
        r100 = false;
        goto L23
    }

    public void d(boolean r100) {
        LandscapeInteractionModel r101 = this.f504382l;
        if (r101 == null) goto L8;
        MutableLiveData<Boolean> r102 = r101.isInZoomState();
        if (r102 == null) goto L9;
        r102.setValue(Boolean.valueOf(r100));
        return;
    L9:
        return;
    }

    public b(Context r100, View r101, ViewGroup r102, LandscapeInteractionModel r103, com.bytedance.android.live.platformplayer.layout.c r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "targetView");
        Intrinsics.checkNotNullParameter(r102, "viewGroup");
        this.f504380j = r101;
        this.f504381k = r102;
        this.f504382l = r103;
        this.f504383m = r104;
        e r105 = new e(r101, r102, r104);
        this.f504371a = r105;
        this.f504372b = new f(r100, r105);
        g r106 = new g(r101, r102, r104);
        this.f504373c = r106;
        this.f504374d = new h(r100, r106);
        this.f504375e = true;
        r101.setClickable(false);
        this.f504378h = r101.getX();
        this.f504379i = r101.getY();
        this.f504376f = r101.getPivotX();
        this.f504377g = r101.getPivotY();
    }
}
