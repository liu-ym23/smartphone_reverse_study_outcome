package com.bytedance.ug.sdk.luckydog.task.newTimer.pendant;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ug.sdk.luckydog.api.task.pendant.PendantState;
import com.bytedance.ug.sdk.luckydog.api.task.pendant.PendantStyle;
import com.bytedance.ug.sdk.luckyhost.api.api.timer.LuckyTimerStatus;
import com.google.gson.Gson;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import zm7.q;

/* JADX INFO: loaded from: classes3.dex */
public final class LuckyDogPendantViewWrapper extends uo7.c implements ym7.h, gk7.f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f272108j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f272109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zm7.m f272110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f272111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f272112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LuckyTimerStatus f272113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<FrameLayout, dl7.b> f272114f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f272115g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f272116h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ym7.i f272117i;

    /* JADX INFO: loaded from: classes22.dex */
    public static final class a {
    }

    static {
    }

    @Override // uo7.c, uo7.b
    public final void onEnterBackground(Activity r100) {
    }

    @Override // ym7.h
    public final void d() {
        if (this.f272115g == true) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantViewWrapper", "releasePendant() 没init初始化，return");
        return;
    L6:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantViewWrapper", "releasePendant() called");
        if ((!this.f272114f.isEmpty()) == false) goto L9;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantViewWrapper", "releasePendant()");
        final ArrayList r100 = new ArrayList(this.f272114f.values());
        com.bytedance.ug.sdk.luckydog.task.pendant.f.a(new LuckyDogPendantViewWrapper$releasePendant$1(this, r100));
        this.f272114f.clear();
    L9:
        to7.c.e(this);
    }

    public final void o() {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantViewWrapper", "refreshPendantView() called;");
        zm7.m r100 = this.f272110b;
        boolean r101 = true;
        if (r100 == null) goto L15;
        zm7.n r102 = r100.c();
        if (r102 == null) goto L15;
        if (r102.f() != true) goto L15;
        Application r103 = rk7.m.f538347a;
        if (rk7.m.o() == true) goto L15;
        Iterator<Map.Entry<FrameLayout, dl7.b>> r104 = this.f272114f.entrySet().iterator();
    L12:
        if (r104.hasNext() == false) goto L14;
        dl7.b r105 = r104.next().getValue();
        PendantState r106 = PendantState.NEED_LOGIN;
        int r107 = dl7.b.f469132b;
        r105.a(r106, -1);
        goto L12
    L14:
        return;
    L15:
        int r108 = 0;
        if (this.f272113e == LuckyTimerStatus.TASK_TIME_END) goto L19;
        r101 = false;
    L19:
        if (r101 == false) goto L24;
        Iterator<Map.Entry<FrameLayout, dl7.b>> r109 = this.f272114f.entrySet().iterator();
    L22:
        if (r109.hasNext() == false) goto L39;
        dl7.b r110 = r109.next().getValue();
        PendantState r111 = PendantState.FINISHED;
        int r112 = dl7.b.f469132b;
        r110.a(r111, -1);
        goto L22
    L39:
        return;
    L24:
        zm7.m r113 = this.f272110b;
        if (r113 == null) goto L29;
        q r114 = r113.d();
        if (r114 == null) goto L29;
        r108 = r114.f();
    L29:
        if (r108 <= 0) goto L34;
        Iterator<Map.Entry<FrameLayout, dl7.b>> r115 = this.f272114f.entrySet().iterator();
    L32:
        if (r115.hasNext() == false) goto L40;
        r115.next().getValue().a(PendantState.COUNT_DOWN, r108 - this.f272109a);
        goto L32
    L40:
        return;
    L34:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantViewWrapper", "refreshPendantView() targetS为0了，不进行更新");
    }

    @Override // gk7.f
    public final void onAccountBindUpdate() {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantViewWrapper", "onAccountBindUpdate() called;");
    }

    public LuckyDogPendantViewWrapper() {
        this.f272113e = LuckyTimerStatus.TASK_TIME_CREATED;
        this.f272114f = new ConcurrentHashMap();
        this.f272116h = true;
    }

    @Override // ym7.h
    public final void c(float r100) {
        if (this.f272115g == true) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantViewWrapper", "updateTime() 没init初始化，return");
        return;
    L6:
        this.f272109a = (int) r100;
        LuckyTimerStatus r101 = this.f272113e;
        LuckyTimerStatus r102 = LuckyTimerStatus.TASK_TIME_END;
        boolean r103 = true;
        if (r101 != r102) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == false) goto L17;
        StringBuilder r105 = new StringBuilder("updatePendantAckedTime !isInit() isPendantFinished = ");
        if (this.f272113e == r102) goto L15;
        r103 = false;
    L15:
        r105.append(r103);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantViewWrapper", r105.toString());
        return;
    L17:
        o();
        return;
    L9:
        r104 = false;
        goto L10
    }

    @Override // ym7.h
    public final void g(final ym7.n r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantViewWrapper", "hidePendant() called;");
        if (this.f272115g == true) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantViewWrapper", "hidePendant() 没init初始化，return");
        return;
    L6:
        com.bytedance.ug.sdk.luckydog.task.pendant.f.a(new LuckyDogPendantViewWrapper$hidePendant$1(this, r100));
    }

    @Override // ym7.h
    public final void h(LuckyTimerStatus r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantViewWrapper", "updateTimerStatus() called; status = " + r100);
        if (this.f272115g == true) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantViewWrapper", "updateTimerStatus() 没init初始化，return");
        return;
    L6:
        this.f272113e = r100;
        int r101 = com.bytedance.ug.sdk.luckydog.task.newTimer.pendant.a.f272118a[r100.ordinal()];
        if (r101 != 1) goto L9;
    L21:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantViewWrapper", "updateTimerStatus() 展示倒计时状态");
        o();
        return;
    L9:
        if (r101 == 2) goto L21;
        if (r101 != 3) goto L13;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantViewWrapper", "updateTimerStatus() 任务完成");
        o();
        return;
    L13:
        if (r101 == 4) goto L15;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantViewWrapper", "updateTimerStatus() 其他状态，不需要处理");
        return;
    L15:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantViewWrapper", "updateTimerStatus() 任务过期");
        Context r102 = rk7.m.f538361o.e();
        if (r102 != null) goto L18;
        return;
    L18:
        if (to7.c.c() == false) goto L25;
        il7.o.a(r102, r102.getString(R.string.luckydog_pendant_timer_expired));
        return;
    }

    public final FrameLayout.LayoutParams n(zm7.o r100) {
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-2, -2);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantViewWrapper", "analyseLayoutParams() called;");
        r101.gravity = 19;
        if (r100 != null) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantViewWrapper", "analyseLayoutParams() position 为空，走默认;");
        return r101;
    L6:
        int r102 = r100.d();
        int r103 = r100.c();
        int r104 = r100.a();
        int r105 = r100.b();
        if (r102 == (-1)) goto L10;
        r101.gravity = 48;
    L9:
        r104 = 0;
    L13:
        if (r105 == (-1)) goto L16;
        r101.gravity |= 3;
    L15:
        r103 = 0;
    L19:
        Activity r106 = to7.c.b();
        r101.setMargins((int) UIUtils.dip2Px(r106, r105), (int) UIUtils.dip2Px(r106, r102), (int) UIUtils.dip2Px(r106, r103), (int) UIUtils.dip2Px(r106, r104));
        return r101;
    L16:
        if (r103 == (-1)) goto L18;
        r101.gravity |= 5;
        r105 = 0;
        goto L19
    L18:
        r101.gravity |= 3;
        r105 = 0;
        goto L15
    L10:
        if (r104 == (-1)) goto L12;
        r101.gravity = 80;
        r102 = 0;
        goto L13
    L12:
        r101.gravity = 17;
        r102 = 0;
        goto L9
    }

    @Override // gk7.f
    public final void onAccountRefresh(boolean r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantViewWrapper", "onAccountRefresh() called isLogin = " + r100);
        o();
    }

    public static final FrameLayout l(LuckyDogPendantViewWrapper r100, Activity r101) {
        r100.getClass();
        Window r102 = r101.getWindow();     // Catch: Throwable -> L13
        if (r102 == null) goto L15;
        View r103 = r102.getDecorView();     // Catch: Throwable -> L13
        if (com.larus.home.impl.utils.c.f346345e == false) goto L10;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L13
        Thread r104 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L13
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L10;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");     // Catch: Throwable -> L13
    L10:
        if (r103 == null) goto L15;
        return (FrameLayout) r103.findViewById(android.R.id.content);
    L15:
        return null;
    L13:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantViewWrapper", th.getLocalizedMessage());
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ym7.h
    public final void a(final String r110, final ym7.n r111) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantViewWrapper", "showPendant() called; scene = " + r110 + ", extra = " + r111);
        zm7.o r100 = null;
        if (this.f272115g == true) goto L6;
        Gson r112 = com.bytedance.ug.sdk.luckydog.api.log.c.f271581a;
        com.bytedance.ug.sdk.luckydog.api.log.c.b("LuckyDogTimerComponent", "showPendant onCall, 没init初始化，return", MapsKt.mapOf(new Pair[]{TuplesKt.to("scene", r110), TuplesKt.to(DbJsonConstants.DBJSON_KEY_TASK_KEY, this.f272111c)}), null);
        return;
    L6:
        if (r111 == null) goto L10;
        JSONObject r101 = r111.f568383b;
        if (r101 == null) goto L10;
        JSONObject r102 = r101.optJSONObject("cross_pendant");
    L11:
        if (r102 == null) goto L13;
        String r103 = r102.optString("position");
    L14:
        if (r103 != null) goto L39;
    L19:
        FrameLayout.LayoutParams r104 = null;
    L20:
        if (r104 == null) goto L22;
    L21:
        final FrameLayout.LayoutParams r105 = r104;
        final Ref.IntRef r106 = new Ref.IntRef();
        int r107 = -1;
        if (r102 == null) goto L31;
        r107 = r102.optInt("view_index", -1);
    L31:
        r106.element = r107;
        final Ref.ObjectRef r113 = new Ref.ObjectRef();
        if (r102 != null) goto L34;
    L36:
        T r108 = PendantStyle.NORMAL;
    L37:
        r113.element = r108;
        com.bytedance.ug.sdk.luckydog.task.pendant.f.a(new LuckyDogPendantViewWrapper$showPendant$1(this, r111, r105, r106, r113, r110));
        return;
    L34:
        if (r102.optInt("style", 0) != 1) goto L36;
        r108 = PendantStyle.ALL_RADIUS;
        goto L37
    L22:
        zm7.m r109 = this.f272110b;
        if (r109 == null) goto L27;
        zm7.n r114 = r109.c();
        if (r114 == null) goto L27;
        r100 = r114.i();
    L27:
        r104 = n(r100);
        goto L21
    L39:
        r104 = n((zm7.o) new Gson().fromJson(r103, zm7.o.class));     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantViewWrapper", th.getLocalizedMessage());
        goto L19
    L13:
        r103 = null;
    L10:
        r102 = null;
        goto L11
    }

    @Override // ym7.h
    public final void k(zm7.m r100, JSONObject r101, ym7.i r102) {
        if (this.f272115g == false) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantViewWrapper", "init() called; 已经初始化，return");
        return;
    L6:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantViewWrapper", "init() called; ");
        this.f272115g = true;
        this.f272110b = r100;
        this.f272111c = r100.e();
        this.f272112d = r101;
        this.f272117i = r102;
        to7.c.d(this);
        d();
        il7.m r103 = il7.m.a();     // Catch: Exception -> L13
        StringBuilder r104 = new StringBuilder("lucky_cache_increment_");     // Catch: Exception -> L13
        zm7.m r105 = this.f272110b;     // Catch: Exception -> L13
        if (r105 == null) goto L10;
        String r106 = r105.e();     // Catch: Exception -> L13
    L11:
        r104.append(r106);     // Catch: Exception -> L13
        float r107 = new JSONObject(r103.e(r104.toString(), "")).optLong("cache_timer_interval", 0);     // Catch: Exception -> L13
    L14:
        int r108 = (int) r107;
        zm7.m r109 = this.f272110b;
        if (r109 == null) goto L19;
        q r110 = r109.d();
        if (r110 == null) goto L19;
        int r111 = r110.a();
    L20:
        this.f272109a = r111 + r108;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantViewWrapper", "init() finish");
        rk7.h.a(this);
        return;
    L19:
        r111 = 0;
        goto L20
    L10:
        r106 = null;
    L13:
        r107 = 0.0f;
        goto L14
    }
}
