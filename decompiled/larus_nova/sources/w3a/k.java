package w3a;

import com.larus.av_call.constant.ThemeType;
import com.larus.av_call.databinding.LarusFragmentInstantCallBaseBinding;
import com.larus.av_call.model.RealtimePageMode;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class k implements t1a.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f558199g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e3a.b f558200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e3a.a f558201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LarusFragmentInstantCallBaseBinding f558202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f558203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList<i> f558204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f558205f;

    public static final class a {
    }

    static {
    }

    public final void a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "newState");
        LarusFragmentInstantCallBaseBinding r101 = this.f558202c;
        if (r101 == null) goto L6;
        this.f558203d.a(r101, this.f558201b);
        this.f558203d = r100;
        r100.b(r101);
        return;
    }

    public final void c(i r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f558204e.add(r100);
    }

    @Deprecated(message = "please add business func， like onRealtimeScaleModeChange(), do not call triggerEvent() directly")
    public final void d(h r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Iterator<i> r101 = this.f558204e.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().a(r100);
        goto L4
    }

    public k(e3a.b r100, e3a.a r101) {
        Intrinsics.checkNotNullParameter(r100, "runtimeData");
        Intrinsics.checkNotNullParameter(r101, "argumentData");
        this.f558200a = r100;
        this.f558201b = r101;
        this.f558203d = b.f558192a;
        this.f558204e = new CopyOnWriteArrayList();
    }

    public final void b(RealtimePageMode r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "realtimePageMode");
        e3a.b r102 = this.f558200a;
        if (r102.f484268i != ThemeType.IMMERS_BOT) goto L7;
        FLogger.f375446a.i("RealtimeCallViewStateManager", "onRealtimeScaleModeChange ThemeType.IMMERS_BOT not support half page");
        return;
    L7:
        if (this.f558201b.f470944x1 == true) goto L17;
        if (r100 != RealtimePageMode.HALF_SCREEN) goto L17;
        if (AppHost.f326268a.isDebug() == true) goto L15;
        FLogger.f375446a.e("RealtimeCallViewStateManager", "onRealtimeScaleModeChange RealtimePageMode:" + r100 + ", but not support half page");
        return;
    L15:
        throw new RuntimeException("current not support half page");
    L17:
        if (r102.f484280u == r100) goto L19;
    L22:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r102.f484280u = r100;
        this.f558205f = r101;
        d(new w3a.a(r100, r101));
        return;
    L19:
        if (r101 != this.f558205f) goto L22;
        FLogger.f375446a.e("RealtimeCallViewStateManager", "onRealtimeScaleModeChange RealtimePageMode:" + r100 + " lastPaddingTop=" + this.f558205f);
    }
}
