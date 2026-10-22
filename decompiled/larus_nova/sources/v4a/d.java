package v4a;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.lynx.animax.service.IAnimaXMonitorService;
import com.lynx.animax.util.AnimaXMetricsCallback;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import t4a.e;

/* JADX INFO: loaded from: classes32.dex */
public final class d extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w4a.d f553154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<x4a.d> f553155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f553156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f553157d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f553158e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f553159f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f553160g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f553161h;

    public d(w4a.d r100) {
        this.f553156c = false;
        this.f553157d = new ConcurrentHashMap();
        this.f553154a = r100;
        long r101 = System.currentTimeMillis();
        this.f553161h = r101;
        this.f553158e = r101;
    }

    @Override // t4a.f
    public final void d(t4a.c r100) {
        f(false);
    }

    public final void f(boolean r100) {
        this.f553159f++;
        if (r100 == false) goto L5;
        this.f553160g++;
    L5:
        long r101 = System.currentTimeMillis();
        if (this.f553156c == true) goto L8;
    L11:
        h(LynxVideoManagerLite.EVENT_ON_PLAY);
        this.f553156c = true;
        this.f553158e = r101;
        return;
    L8:
        if (this.f553160g >= 5) goto L11;
        if ((r101 - this.f553158e) >= 300000) goto L11;
    }

    public final void h(String r100) {
        IAnimaXMonitorService r101 = (IAnimaXMonitorService) this.f553154a.a(IAnimaXMonitorService.class);
        WeakReference<x4a.d> r102 = this.f553155b;
        if (r102 == null) goto L5;
        x4a.d r103 = r102.get();
    L6:
        if (r103 == null) goto L14;
        if (r101 == null) goto L15;
        HashMap r104 = new HashMap(this.f553157d);
        int r105 = this.f553159f;
        if (r105 <= 0) goto L12;
        r104.put("play_count", Integer.valueOf(r105));
        this.f553159f = 0;
        this.f553160g = 0;
    L12:
        r103.f(new AnimaXMetricsCallback(r101, r100, r104));
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // t4a.e, t4a.f
    public final void i(t4a.a r100) {
        IAnimaXMonitorService r101 = (IAnimaXMonitorService) this.f553154a.a(IAnimaXMonitorService.class);
        if (r101 == null) goto L6;
        r101.reportError(r100);
        return;
    }
}
