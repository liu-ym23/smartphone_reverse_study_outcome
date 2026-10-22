package es1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.VSSettingKeys;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.concert_stage.models.JoinChorusConcertStatus;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Map<Long, a> f473679h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Set<Long> f473680i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C5810a f473681j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f473682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f473683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f473684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f473685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f473686e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Pair<Integer, Integer> f473687f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f473688g;

    /* JADX INFO: renamed from: es1.a$a, reason: collision with other inner class name */
    public static final class C5810a {
        public C5810a() {
        }

        public final synchronized void a(long r100) {
            monitor-enter(this);
            ALogger.d("VSChorusConcertHelper", "clearInstance roomId:" + r100);     // Catch: Throwable -> L29
            a.f473680i.add(Long.valueOf(r100));     // Catch: Throwable -> L29
            Map<Long, a> r101 = a.f473679h;     // Catch: Throwable -> L29
            a r102 = (a) ((LinkedHashMap) r101).get(Long.valueOf(r100));     // Catch: Throwable -> L29
            if (r102 == null) goto L26;
            a.c(MapMonitorConst.EVENT_DESTROY);     // Catch: Throwable -> L29
            View r103 = r102.f473685d;     // Catch: Throwable -> L29
            if (r103 == null) goto L14;
            ViewParent r104 = r103.getParent();     // Catch: Throwable -> L29
            if ((r104 instanceof ViewGroup) == true) goto L11;
            r104 = null;
        L11:
            ViewGroup r105 = (ViewGroup) r104;     // Catch: Throwable -> L29
            if (r105 == null) goto L14;
            r105.removeView(r103);     // Catch: Throwable -> L29
        L14:
            r102.f473685d = null;     // Catch: Throwable -> L29
            IKtvService r106 = (IKtvService) k.f(IKtvService.class);     // Catch: Throwable -> L29
            if (r106 == null) goto L17;
            r106.destroyChorusService();     // Catch: Throwable -> L29
        L17:
            View r107 = r102.f473686e;     // Catch: Throwable -> L29
            if (r107 == null) goto L25;
            ViewParent r108 = r107.getParent();     // Catch: Throwable -> L29
            if ((r108 instanceof ViewGroup) == true) goto L22;
            r108 = null;
        L22:
            ViewGroup r109 = (ViewGroup) r108;     // Catch: Throwable -> L29
            if (r109 == null) goto L25;
            r109.removeView(r107);     // Catch: Throwable -> L29
        L25:
            r102.f473686e = null;     // Catch: Throwable -> L29
        L26:
            r101.remove(Long.valueOf(r100));     // Catch: Throwable -> L29
            monitor-exit(this);
            return;
        L29:
            th = move-exception;
            throw th;
        }

        public final synchronized void b(long r100) {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (((LinkedHashMap) a.f473679h).get(Long.valueOf(r100)) == null) goto L7;
            a(r100);     // Catch: Throwable -> L9
            ALogger.d("VSChorusConcertHelper", "cache already exit, force clear roomId:" + r100);     // Catch: Throwable -> L9
        L7:
            monitor-exit(this);
        }

        public final synchronized a c(long r100, Context r101, boolean r102) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L16
            ALogger.w("VSChorusConcertHelper", "getInstance needCreate:" + r102 + " roomId:" + r100 + ". ");     // Catch: Throwable -> L16
            if (r102 == false) goto L7;
        L10:
            Map<Long, a> r103 = a.f473679h;     // Catch: Throwable -> L16
            Long r104 = Long.valueOf(r100);     // Catch: Throwable -> L16
            LinkedHashMap r105 = (LinkedHashMap) r103;     // Catch: Throwable -> L16
            Object r106 = r105.get(r104);     // Catch: Throwable -> L16
            if (r106 != null) goto L13;
            r106 = new a();     // Catch: Throwable -> L16
            r105.put(r104, r106);     // Catch: Throwable -> L16
        L13:
            a r107 = (a) r106;     // Catch: Throwable -> L16
        L14:
            monitor-exit(this);
            return r107;
        L7:
            if (VSSettingKeys.LIVE_VS_CHORUS_UNNECESSARY_CREATE_HELPER.getValue().booleanValue() == true) goto L10;
            r107 = (a) ((LinkedHashMap) a.f473679h).get(Long.valueOf(r100));     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f473689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f473690b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f473691c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ View f473692d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f473693e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f473694f;

        public b(a r100, View r101, View r102, View r103, ViewGroup r104, ViewGroup r105) {
            this.f473689a = r100;
            this.f473690b = r101;
            this.f473691c = r102;
            this.f473692d = r103;
            this.f473693e = r104;
            this.f473694f = r105;
        }

        public final void a() {
            View r100 = this.f473690b;
            ViewParent r101 = r100.getParent();
            Integer r102 = null;
            if ((r101 instanceof ViewGroup) == true) goto L5;
            r101 = null;
        L5:
            ViewGroup r103 = (ViewGroup) r101;
            if (r103 == null) goto L8;
            r103.removeView(r100);
        L8:
            Pair<Integer, Integer> r104 = this.f473689a.f473687f;
            if (r104 != null) goto L11;
        L16:
            this.f473689a.b(this.f473691c);
        L17:
            this.f473689a.b(this.f473691c);
            FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(this.f473692d.getWidth(), this.f473692d.getHeight());
            Pair<Integer, Integer> r106 = this.f473689a.f473687f;
            int r107 = 0;
            if (r106 == null) goto L22;
            Integer r108 = r106.getFirst();
            if (r108 == null) goto L22;
            int r109 = r108.intValue();
        L23:
            r105.leftMargin = r109;
            Pair<Integer, Integer> r110 = this.f473689a.f473687f;
            if (r110 == null) goto L28;
            Integer r111 = r110.getSecond();
            if (r111 == null) goto L28;
            int r112 = r111.intValue();
        L29:
            r105.topMargin = r112;
            a r113 = this.f473689a;
            StringBuilder r114 = new StringBuilder("attachOverlayOnRender width:");
            r114.append(this.f473692d.getWidth());
            r114.append(" height:");
            r114.append(this.f473692d.getHeight());
            r114.append(" leftMargin:");
            r114.append(r105.leftMargin);
            r114.append(" topMargin:");
            r114.append(r105.topMargin);
            r114.append(" pair.left:");
            Pair<Integer, Integer> r115 = this.f473689a.f473687f;
            if (r115 == null) goto L32;
            Integer r116 = r115.getFirst();
        L33:
            r114.append(r116);
            r114.append(" pair.right:");
            Pair<Integer, Integer> r117 = this.f473689a.f473687f;
            if (r117 == null) goto L36;
            r102 = r117.getSecond();
        L36:
            r114.append(r102);
            String r118 = r114.toString();
            r113.getClass();
            a.c(r118);
            this.f473690b.setLayoutParams(r105);
            this.f473689a.getClass();     // Catch: Exception -> L43
            a.c("attachOverlayOnRender and addview now");     // Catch: Exception -> L43
            int r119 = this.f473693e.indexOfChild(this.f473694f);     // Catch: Exception -> L43
            if (r119 == (-1)) goto L41;
            r107 = r119;
        L41:
            this.f473693e.addView(this.f473690b, r107 + 1);     // Catch: Exception -> L43
            this.f473690b.requestLayout();     // Catch: Exception -> L43
        L45:
            this.f473689a.f473686e = this.f473690b;
            return;
        L43:
            e = move-exception;
            this.f473689a.getClass();
            a.c("attachOverlayOnRender exception: " + e);
            goto L45
        L32:
            r116 = null;
        L28:
            r112 = 0;
        L22:
            r109 = 0;
            goto L23
        L11:
            if (r104.getFirst().intValue() != 0) goto L17;
            Pair<Integer, Integer> r120 = this.f473689a.f473687f;
            if (r120 == null) goto L17;
            if (r120.getSecond().intValue() != 0) goto L17;
            goto L16
        }

        @Override // java.lang.Runnable
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
    }

    static {
        f473681j = new C5810a();
        f473679h = new LinkedHashMap();
        f473680i = new LinkedHashSet();
    }

    public a() {
        this.f473683b = JoinChorusConcertStatus.NOT_JOINED.getValue();
    }

    public static void c(String r100) {
        ALogger.i("VSChorusConcertHelper", r100);
    }

    public final void b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "originPlayerView");
        if (this.f473688g == 0) goto L6;
        c("initLandPlayerSize return cause landScapeAnimState != MatchRoomLandScapeAnimUtil.ANIM_STATE_HIDE");
        return;
    L6:
        this.f473687f = new Pair(Integer.valueOf((int) r100.getX()), Integer.valueOf((int) r100.getY()));
        c("initLandPlayerSize " + this.f473687f);
    }

    public final void a(View r100, ViewGroup r110, View r111) {
        Intrinsics.checkNotNullParameter(r100, "surface");
        Intrinsics.checkNotNullParameter(r110, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r111, "originPlayerView");
        c("attachSurfaceView " + r100);
        ViewParent r101 = r111.getParent();
        if ((r101 instanceof ViewGroup) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup r102 = (ViewGroup) r101;
        if (r102 != null) goto L8;
        return;
    L8:
        r111.post(new b(this, r100, r111, r111, r110, r102));
    }
}
