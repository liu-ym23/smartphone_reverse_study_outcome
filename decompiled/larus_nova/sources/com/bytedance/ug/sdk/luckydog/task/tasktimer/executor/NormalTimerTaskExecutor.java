package com.bytedance.ug.sdk.luckydog.task.tasktimer.executor;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ug.sdk.luckydog.api.task.taskmanager.ActionTaskManager;
import com.bytedance.ug.sdk.luckydog.api.task.taskmanager.ActionTaskManager$executeCallback$1;
import com.bytedance.ug.sdk.luckydog.task.tasktimer.view.LuckyCommonPendantView;
import com.bytedance.ug.sdk.luckydog.task.tasktimer.view.TimerTaskPendantState;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.inv.export.router.InvRouter;
import gm7.f;
import il7.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import rk7.m;
import tk7.h;

/* JADX INFO: loaded from: classes3.dex */
public final class NormalTimerTaskExecutor extends com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f272224r = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f272225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f272226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<FrameLayout, com.bytedance.ug.sdk.luckydog.task.tasktimer.view.a> f272227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public hm7.a f272228e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f272229f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Runnable f272230g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public uo7.a f272231h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public gk7.e f272232i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Pair<Integer, Long>> f272233j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f272234k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicBoolean f272235l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicInteger f272236m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicBoolean f272237n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicBoolean f272238o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicInteger f272239p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicBoolean f272240q;

    /* JADX INFO: loaded from: classes22.dex */
    public static final class a {
    }

    /* JADX INFO: loaded from: classes22.dex */
    public interface b {
        void a(ConcurrentHashMap<String, String> r100);

        void onFail();
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static final class c implements uo7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NormalTimerTaskExecutor f272243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f272244b;

        @Override // uo7.a
        public final void onActivityDestroyed(Activity r100) {
            com.bytedance.ug.sdk.luckydog.api.log.d.a("NormalTimerTaskExecutor", "showTimerPendantForBridge activity = " + r100 + " onActivityDestroyed");
            if (Intrinsics.areEqual(r100, this.f272244b) == false) goto L5;
            com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "showTimerPendantForBridge bridgeActivity = " + this.f272244b + " Destroyed stop task");
            this.f272243a.n();
            ActionTaskManager.f271681l.K(this.f272243a.c().f546539a);
            gm7.a.f481679f.b(this.f272243a.c().f546539a);
        L5:
            to7.c.e(this.f272243a.f272231h);
            this.f272243a.f272231h = null;
        }

        @Override // uo7.a
        public final void onEnterActivityBackground(Activity r100) {
            com.bytedance.ug.sdk.luckydog.api.log.d.a("NormalTimerTaskExecutor", "showTimerPendantForBridge activity = " + r100 + " onEnterActivityBackground");
        }

        @Override // uo7.a
        public final void onEnterActivityForeground(Activity r100) {
            com.bytedance.ug.sdk.luckydog.api.log.d.a("NormalTimerTaskExecutor", "showTimerPendantForBridge activity = " + r100 + " onEnterActivityForeground");
        }

        @Override // uo7.b
        public final void onEnterBackground(Activity r100) {
            com.bytedance.ug.sdk.luckydog.api.log.d.a("NormalTimerTaskExecutor", "showTimerPendantForBridge activity = " + r100 + " onEnterBackground");
        }

        @Override // uo7.b
        public final void onEnterForeground(Activity r100) {
            com.bytedance.ug.sdk.luckydog.api.log.d.a("NormalTimerTaskExecutor", "showTimerPendantForBridge activity = " + r100 + " onEnterForeground");
        }

        public c(NormalTimerTaskExecutor r100, Activity r101) {
            this.f272243a = r100;
            this.f272244b = r101;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NormalTimerTaskExecutor f272245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f272246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FrameLayout.LayoutParams f272247c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f272248d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f272249e;

        public d(NormalTimerTaskExecutor r100, FrameLayout r101, FrameLayout.LayoutParams r102, int r103, int r104) {
            this.f272245a = r100;
            this.f272246b = r101;
            this.f272247c = r102;
            this.f272248d = r103;
            this.f272249e = r104;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.ug.sdk.luckydog.api.log.d.a("NormalTimerTaskExecutor", "pendant not init pending run");     // Catch: Throwable -> L4
            this.f272245a.w(this.f272246b, this.f272247c, this.f272248d, this.f272249e);     // Catch: Throwable -> L4
            this.f272245a.f272230g = null;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static final class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NormalTimerTaskExecutor f272250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f272251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FrameLayout.LayoutParams f272252c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f272253d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f272254e;

        @Override // com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.NormalTimerTaskExecutor.b
        public final void onFail() {
            com.bytedance.ug.sdk.luckydog.api.log.d.a("NormalTimerTaskExecutor", "showTimerPendant fetchIconImage fail");
            boolean r100 = h.f546571a;
            if (h.f546572b.get() == false) goto L6;
            com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "showTimerPendant is daoliang, so return");
            return;
        L6:
            NormalTimerTaskExecutor.k(this.f272250a, this.f272251b, this.f272252c, this.f272253d, this.f272254e, null);
        }

        @Override // com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.NormalTimerTaskExecutor.b
        public final void a(ConcurrentHashMap<String, String> r100) {
            boolean r101 = h.f546571a;
            if (h.f546572b.get() == false) goto L6;
            com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "showTimerPendant is daoliang, so return");
            return;
        L6:
            NormalTimerTaskExecutor.k(this.f272250a, this.f272251b, this.f272252c, this.f272253d, this.f272254e, r100);
        }

        public e(NormalTimerTaskExecutor r100, FrameLayout r101, FrameLayout.LayoutParams r102, int r103, int r104) {
            this.f272250a = r100;
            this.f272251b = r101;
            this.f272252c = r102;
            this.f272253d = r103;
            this.f272254e = r104;
        }
    }

    static {
    }

    @Override // bl7.a
    public final String d() {
        return "lucky_normal_timing_task";
    }

    @Override // bl7.a
    public final boolean e() {
        return true;
    }

    @Override // bl7.a
    public final void f() {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "pause");
    }

    public final FrameLayout.LayoutParams m() {
        FrameLayout.LayoutParams r100 = new FrameLayout.LayoutParams(-2, -2);
        hm7.a r101 = this.f272228e;
        if (r101 == null) goto L12;
        String r102 = r101.e();
        if (r102 == null) goto L12;
        List r103 = StringsKt.split$default(r102, new String[]{","}, false, 0, 6, null);
        if (r103 == null) goto L12;
        List r104 = r103;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r106 = r104.iterator();
    L10:
        if (r106.hasNext() == false) goto L13;
        r105.add(StringsKt.toIntOrNull((String) r106.next()));
    L13:
        if (r105 != null) goto L15;
    L46:
        return r100;
    L15:
        if (r105.size() != 4) goto L46;
        int r107 = 0;
        Integer r108 = (Integer) ListProtector.get(r105, 0);
        if (r108 == null) goto L19;
        int r109 = r108.intValue();
    L20:
        Integer r110 = (Integer) ListProtector.get(r105, 1);
        if (r110 == null) goto L23;
        int r111 = r110.intValue();
    L24:
        Integer r112 = (Integer) ListProtector.get(r105, 2);
        if (r112 == null) goto L27;
        int r113 = r112.intValue();
    L28:
        Integer r114 = (Integer) ListProtector.get(r105, 3);
        if (r114 == null) goto L31;
        int r115 = r114.intValue();
    L33:
        if (r109 == (-1)) goto L36;
        r100.gravity = 48;
    L35:
        r113 = 0;
    L39:
        if (r115 == (-1)) goto L42;
        r100.gravity |= 3;
        r107 = r115;
    L41:
        r111 = 0;
    L45:
        Activity r116 = to7.c.b();
        r100.setMargins((int) UIUtils.dip2Px(r116, r107), (int) UIUtils.dip2Px(r116, r109), (int) UIUtils.dip2Px(r116, r111), (int) UIUtils.dip2Px(r116, r113));
        goto L46
    L42:
        if (r111 == (-1)) goto L44;
        r100.gravity |= 5;
        goto L45
    L44:
        r100.gravity |= 3;
        goto L41
    L36:
        if (r113 == (-1)) goto L38;
        r100.gravity = 80;
        r109 = 0;
        goto L39
    L38:
        r100.gravity = 48;
        r109 = 0;
        goto L35
    L31:
        r115 = 0;
        goto L33
    L27:
        r113 = 0;
        goto L28
    L23:
        r111 = 0;
        goto L24
    L19:
        r109 = 0;
    L12:
        r105 = null;
        goto L13
    }

    public final void n() {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "finishTask call");
        this.f272230g = null;
        this.f272232i = null;
        gm7.e r100 = gm7.e.B;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (gm7.e.f481709m.contains(this) == false) goto L7;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "unRegisterTimerTask taskType = " + c().f546540b + " taskId = " + c().f546539a);     // Catch: Throwable -> L10
        u();     // Catch: Throwable -> L10
        gm7.e.f481697a = false;     // Catch: Throwable -> L10
        r100.o(this);     // Catch: Throwable -> L10
    L7:
        monitor-exit(r100);
        gm7.d.f481696c.f(2);
    }

    public final void u() {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "hideAllTimerPendant");
        Iterator<Map.Entry<FrameLayout, com.bytedance.ug.sdk.luckydog.task.tasktimer.view.a>> r100 = this.f272227d.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        Map.Entry<FrameLayout, com.bytedance.ug.sdk.luckydog.task.tasktimer.view.a> r101 = r100.next();
        com.bytedance.ug.sdk.luckydog.api.log.d.a("NormalTimerTaskExecutor", "hideAllTimerPendant root = " + r101.getKey() + " view = " + r101.getValue());
        p(r101.getKey());
        goto L4
    L6:
        this.f272227d.clear();
    }

    public NormalTimerTaskExecutor() {
        this.f272225b = new AtomicInteger(0);
        this.f272226c = new AtomicInteger(1);
        this.f272227d = new ConcurrentHashMap();
        this.f272229f = new Handler(Looper.getMainLooper());
        this.f272233j = new ConcurrentHashMap();
        this.f272234k = new ConcurrentHashMap();
        this.f272235l = new AtomicBoolean(false);
        this.f272236m = new AtomicInteger(0);
        this.f272237n = new AtomicBoolean(false);
        this.f272238o = new AtomicBoolean(false);
        this.f272239p = new AtomicInteger(0);
        this.f272240q = new AtomicBoolean(false);
    }

    @Override // bl7.a
    public final void h() {
        n();
    }

    public static void x(String r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "timerFailToast call");
        gm7.e.B.getClass();
        Activity r101 = gm7.e.s();
        if (r101 != null) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "timerFailToast activity = null");
        return;
    L6:
        if (r100 != null) goto L9;
        r100 = "网络异常，请稍后重启任务";
    L9:
        o.a(r101, r100);
    }

    @Override // bl7.a
    public final void a(tk7.a r110) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "beforeOpenTargetPage call");
        gm7.e.B.getClass();
        gm7.e.f481706j.set(true);
        String r100 = r110.f546543e;
        int r101 = r110.f546546h.optInt("effect_interval", -1);
        Uri r102 = UriProtector.parse(r100);
        String r103 = "url";
        String r104 = UriProtector.getQueryParameter(r102, "url");
        boolean r105 = false;
        if (r104 != null) goto L5;
    L8:
        boolean r106 = true;
    L9:
        if (r106 == false) goto L18;
        r103 = "surl";
        r104 = UriProtector.getQueryParameter(r102, "surl");
        if (r104 != null) goto L13;
    L14:
        r105 = true;
    L15:
        if (r105 == false) goto L18;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "beforeOpenTargetPage targetPage not have url and surl");
        return;
    L13:
        if (r104.length() != 0) goto L15;
    L18:
        Uri.Builder r107 = UriProtector.parse(r104).buildUpon();
        r107.appendQueryParameter("task_id", r110.f546539a);
        if (r101 == (-1)) goto L22;
        r107.appendQueryParameter("timer_interval", String.valueOf(r101));
    L22:
        if (r102.isHierarchical() == false) goto L34;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "removeQueryParameterSafely call");
        Uri.Builder r108 = r102.buildUpon().clearQuery();
        Iterator<String> r109 = UriProtector.getQueryParameterNames(r102).iterator();
    L26:
        if (r109.hasNext() == false) goto L33;
        String r111 = r109.next();
        if ((!Intrinsics.areEqual(r111, r103)) == false) goto L26;
        Iterator<String> r112 = UriProtector.getQueryParameters(r102, r111).iterator();
    L31:
        if (r112.hasNext() == false) goto L26;
        r108.appendQueryParameter(r111, r112.next());
        goto L31
    L33:
        r102 = r108.build();
    L34:
        String r113 = r102.buildUpon().appendQueryParameter(r103, r107.toString()).toString();
        r110.f546543e = r113;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "beforeOpenTargetPage finished targetPage = " + r110.f546543e + ", target = " + r113);
        return;
    L5:
        if (r104.length() == 0) goto L8;
        r106 = false;
        goto L9
    }

    public final TimerTaskPendantState o(int r100) {
        if (q(r100) == true) goto L14;
        if (r100 == 0) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == false) goto L13;
        return TimerTaskPendantState.NOT_START;
    L13:
        return TimerTaskPendantState.COUNT_DOWN;
    L7:
        if (this.f272225b.get() != 0) goto L9;
        r101 = true;
        goto L10
    L14:
        return TimerTaskPendantState.FINISHED;
    }

    public final void p(FrameLayout r100) {
        this.f272230g = null;
        if (this.f272227d.get(r100) == null) goto L7;
        com.bytedance.ug.sdk.luckydog.task.tasktimer.view.a r101 = this.f272227d.get(r100);
        if (r101 == null) goto L7;
        r101.setVisibility(8);
    L7:
        gm7.d.f481696c.c(2);
    }

    public final boolean q(int r100) {
        int r101 = c().f546546h.optInt("report_interval");
        int r102 = c().f546546h.optInt("total_report_count");
        if (c().f546546h.optInt("remaining_report_count") != 0) goto L5;
    L10:
        return true;
    L5:
        if (this.f272225b.get() >= r102) goto L7;
    L9:
        return false;
    L7:
        if (r100 < (r102 * r101)) goto L9;
        goto L9
    }

    public final void t(FrameLayout r100) {
        Iterator r101 = StringsKt.split$default(c().f546546h.optString(InvRouter.SCENES), new String[]{","}, false, 0, 6, null).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if (Intrinsics.areEqual((String) r101.next(), c().f546539a) == false) goto L4;
        boolean r102 = true;
    L10:
        if (r102 == true) goto L14;
        com.bytedance.ug.sdk.luckydog.api.log.d.a("NormalTimerTaskExecutor", "showTimerPendantForBridge 只监听前端相关页面销毁，不监听Native场景页面的销毁");
        return;
    L14:
        if (this.f272231h != null) goto L22;
        Context r103 = r100.getContext();
        if ((r103 instanceof Activity) == true) goto L18;
        r103 = null;
    L18:
        Activity r104 = (Activity) r103;
        if (r104 == null) goto L21;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "showTimerPendantForBridge is not native");
        this.f272231h = new c(this, r104);
        goto L22
    L21:
        return;
    L22:
        to7.c.d(this.f272231h);
        return;
    L8:
        r102 = false;
        goto L10
    }

    public static final void l(NormalTimerTaskExecutor r100, String r101) {
        r100.getClass();
        if (r101 == null) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "updateToken token = ".concat(r101));
        r100.c().f546542d = r101;
        r100.c().f546546h.put("luckydog_task_token", r101);
        return;
    }

    @Override // bl7.a
    public final void b(tk7.a r110, ActionTaskManager$executeCallback$1 r210) {
        this.f19498a = r110;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "execute call");
        long r100 = c().f546546h.optLong("expire_time") * 1000;
        boolean r111 = true;
        if (r100 > 0) goto L5;
    L10:
        int r101 = c().f546546h.optInt("remaining_report_count", -1);
        int r112 = c().f546546h.optInt("total_report_count");
        int r102 = c().f546546h.optInt("report_interval");
        if (r101 <= (-1)) goto L17;
        if (r112 <= 0) goto L17;
        if (r112 < r101) goto L17;
        if (r102 <= 0) goto L17;
        Application r103 = m.f538347a;
        m.p();
        m.k();
        boolean r104 = false;
    L21:
        if (r104 == false) goto L23;
        return;
    L23:
        this.f272232i = r210;
        int r105 = c().f546546h.optInt("remaining_report_count");
        this.f272225b.set(c().f546546h.optInt("total_report_count") - r105);
        this.f272226c.set(this.f272225b.get());
        if (c().f546546h.optString(InvRouter.SCENES).length() == 0) goto L27;
        r111 = false;
    L27:
        if (r111 == false) goto L29;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "scenes is null");
        c().f546546h.put(InvRouter.SCENES, c().f546539a);
    L29:
        long r106 = c().f546546h.optLong("expire_time");
        if (r106 > 0) goto L32;
        JSONObject r107 = c().f546546h;
        gm7.e.B.getClass();
        long r108 = System.currentTimeMillis();
        long r109 = ((long) TimeZone.getDefault().getRawOffset()) + r108;
        AtomicLong r113 = gm7.e.f481699c;
        r107.put("expire_time", (r108 - (r109 % r113.get())) + r113.get());
    L33:
        gm7.e r114 = gm7.e.B;
        com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.b r115 = new com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.b(this);
        r114.getClass();
        String r116 = c().f546542d;
        String r117 = c().f546546h.optString("pendant_key");
        if (r117 != null) goto L37;
        r117 = "";
    L37:
        int r118 = c().f546546h.optInt("report_interval");
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "reportTimerTask taskType = " + r116);
        gm7.b.a(r116, r117, r118, new f(this, r115), false);
        return;
    L32:
        c().f546546h.put("expire_time", r106 * 1000);
    L17:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "registerTimerTask remainingReportCount = " + r101 + " totalReportCount = " + r112 + ", reportInterval = " + r102);
        x("任务加载失败，请返回重试");
        if (r210 == null) goto L20;
        r210.b(c(), false, "incorrect_countdown_task_parmas", true);
    L20:
        r104 = true;
        goto L21
    L5:
        if (r100 >= gm7.e.B.q()) goto L10;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "abnormalParameter taskType = " + c().f546540b + " taskId = " + c().f546539a + " 任务过期，销毁任务");
        if (r210 == null) goto L9;
        r210.b(c(), false, "task_expired", true);
    L9:
        n();
        ActionTaskManager.f271681l.K(c().f546539a);
        goto L20
    }

    public final boolean r(FrameLayout r100, int r101) {
        if (this.f272227d.get(r100) != null) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "needReCreateView return true");
        return true;
    L6:
        int r102 = r100.indexOfChild(this.f272227d.get(r100));
        if (r101 != (-1)) goto L9;
        return false;
    L9:
        if (r102 == (r101 - 1)) goto L15;
        if (r102 == r101) goto L16;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "needReCreateView return true, currIndex: " + r102 + " viewIndex: " + r101);
        return true;
    L16:
        return false;
    L15:
        return false;
    }

    public final void s(final TimerTaskPendantState r100, final int r101) {
        Iterator<Map.Entry<FrameLayout, com.bytedance.ug.sdk.luckydog.task.tasktimer.view.a>> r102 = this.f272227d.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().getValue().a(r100, r101, new NormalTimerTaskExecutor$refreshPendantView$$inlined$forEach$lambda$1(this, r100, r101), new NormalTimerTaskExecutor$refreshPendantView$$inlined$forEach$lambda$2(this, r100, r101));
        goto L4
    }

    public final synchronized void v(b r100, ConcurrentHashMap<String, String> r101) {
        monitor-enter(this);
        this.f272236m.getAndAdd(1);     // Catch: Throwable -> L11
        if (this.f272236m.get() != r101.size()) goto L9;
        this.f272236m.set(0);     // Catch: Throwable -> L11
        if (this.f272235l.get() == false) goto L8;
        r100.a(this.f272234k);     // Catch: Throwable -> L11
        goto L9
    L8:
        r100.onFail();     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void w(FrameLayout r110, FrameLayout.LayoutParams r111, int r112, int r113) {
        if (this.f272240q.get() == false) goto L7;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "挂件被用户关闭 下次任务触发之前不再展示");
        return;
    L7:
        if (this.f272228e != null) goto L11;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "pendant not init but show");
        this.f272230g = new d(this, r110, r111, r112, r113);
        return;
    L11:
        if (q(r113) == false) goto L14;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "pendant is finished, releaseAllTimerPendant");
        return;
    L14:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "showTimerPendant onCall");
        ConcurrentHashMap<String, String> r100 = new ConcurrentHashMap();
        hm7.a r101 = this.f272228e;
        String r102 = null;
        if (r101 == null) goto L17;
        String r103 = r101.c();
    L18:
        r100.put("iconUrlComplete", r103);
        hm7.a r104 = this.f272228e;
        if (r104 == null) goto L21;
        r102 = r104.d();
    L21:
        r100.put("iconUrlDoing", r102);
        e r105 = new e(this, r110, r111, r112, r113);
        Iterator<Map.Entry<String, String>> r114 = r100.entrySet().iterator();
    L23:
        if (r114.hasNext() == false) goto L28;
        Map.Entry<String, String> r115 = r114.next();
        if (TextUtils.isEmpty(r115.getValue()) == true) goto L26;
        il7.f r116 = il7.f.a();
        String r117 = r115.getValue();
        com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.c r106 = new com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.c(r115, this, r105, r100);
        r116.getClass();
        Application r118 = m.f538347a;
        m.d(new il7.e(r116, r117, r106));
        goto L23
    L26:
        v(r105, r100);
        goto L23
    L28:
        return;
    L17:
        r103 = null;
        goto L18
    }

    public static final void k(final NormalTimerTaskExecutor r110, final FrameLayout r111, FrameLayout.LayoutParams r210, final int r211, int r212, ConcurrentHashMap r213) {
        monitor-enter(r110);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "addPendantView onCall");     // Catch: Throwable -> L56
        if (r213 == null) goto L15;
        String r100 = (String) r213.get("iconUrlComplete");     // Catch: Throwable -> L56
        if (r100 != null) goto L10;
        r100 = "";
    L10:
        Bitmap r101 = BitmapFactory.decodeFile(r100);     // Catch: Throwable -> L56
        String r102 = (String) r213.get("iconUrlDoing");     // Catch: Throwable -> L56
        if (r102 != null) goto L14;
        r102 = "";
    L14:
        Bitmap r112 = BitmapFactory.decodeFile(r102);     // Catch: Throwable -> L56
        Bitmap r113 = r101;
    L16:
        gm7.d r103 = gm7.d.f481696c;     // Catch: Throwable -> L56
        if (r103.a(2) == false) goto L19;
        r103.d(2);     // Catch: Throwable -> L56
        r110.t(r111);     // Catch: Throwable -> L56
        if (r210 == null) goto L26;
        final FrameLayout.LayoutParams r104 = r210;
    L27:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "addPendantView inner");     // Catch: Throwable -> L56
        if (r110.f272227d.get(r111) == null) goto L33;
        if (r110.r(r111, r211) == true) goto L33;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "addView views[root] != null且不需要重新绘制挂件");     // Catch: Throwable -> L56
        com.bytedance.ug.sdk.luckydog.task.pendant.f.a(new NormalTimerTaskExecutor$addPendantView$1(r110, r111, r104));     // Catch: Throwable -> L56
        JSONObject r114 = null;
    L47:
        r110.s(r110.o(r6), r212);     // Catch: Throwable -> L56
        if (r110.f272237n.get() == true) goto L54;
        r110.f272237n.set(true);     // Catch: Throwable -> L56
        int r105 = gm7.c.f481693a;     // Catch: Throwable -> L56
        gm7.c.c("luckydog_countdown_pendant_show_success", r114, r110.c());     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.c("LuckyTimerTaskEvent", com.bytedance.ug.sdk.luckydog.api.task.taskmanager.d.a("luckyDogCountdownPendantShowSuccessEvent", th.getLocalizedMessage()), th);     // Catch: Throwable -> L56
    L54:
        monitor-exit(r110);
        return;
    L33:
        int r106 = r110.c().f546546h.optInt("total_report_count") * r110.c().f546546h.optInt("report_interval");     // Catch: Throwable -> L56
        hm7.a r115 = r110.f272228e;     // Catch: Throwable -> L56
        if (r115 == null) goto L39;
        Activity r107 = to7.c.b();     // Catch: Throwable -> L56
        if (r107 != null) goto L38;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "getPendantView() activity == null");     // Catch: Throwable -> L56
        goto L39
    L38:
        LuckyCommonPendantView r116 = new LuckyCommonPendantView(r107, new hm7.c(r106, r212, r110.o(r212), r115, r113, r112, r110.c()), r104);     // Catch: Throwable -> L56
    L40:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "addPendantView create new view = " + r116);     // Catch: Throwable -> L56
        if (r116 == null) goto L43;
        r116.f272282a = new NormalTimerTaskExecutor$addPendantView$2(r110, r111);     // Catch: Throwable -> L56
    L43:
        com.bytedance.ug.sdk.luckydog.api.log.d.a("NormalTimerTaskExecutor", "addPendantView add new view");     // Catch: Throwable -> L56
        final LuckyCommonPendantView r108 = r116;
        final FrameLayout.LayoutParams r109 = r104;
        r114 = null;
        com.bytedance.ug.sdk.luckydog.task.pendant.f.a(new NormalTimerTaskExecutor$addPendantView$3(r110, r108, r111, r211, r109));     // Catch: Throwable -> L56
        if (r116 == null) goto L46;
        r110.f272227d.put(r111, r116);     // Catch: Throwable -> L56
    L46:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "addPendantView add success");     // Catch: Throwable -> L56
    L39:
        r116 = null;
        goto L40
    L26:
        r104 = r110.m();     // Catch: Throwable -> L56
        goto L27
    L19:
        if (r110.f272237n.get() == true) goto L21;
        r110.f272237n.set(true);     // Catch: Throwable -> L56
        int r117 = gm7.c.f481693a;     // Catch: Throwable -> L56
        gm7.c.b(r110.c(), "exclude_by_crossover");     // Catch: Throwable -> L56
    L21:
        monitor-exit(r110);
        return;
    L15:
        r113 = null;
        r112 = null;
    L56:
        th = move-exception;
        throw th;
    }
}
