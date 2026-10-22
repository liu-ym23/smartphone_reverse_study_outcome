package s1;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public final class b implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f540074a;

    public b(c r100) {
        this.f540074a = r100;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        String r101 = r100.getClass().getName();
        int r102 = ((ArrayList) this.f540074a.f540082a).indexOf(r101);
        if (r102 > (-1)) goto L5;
    L7:
        ((ArrayList) this.f540074a.f540084c).add(r101);
        long r103 = System.currentTimeMillis();
        List<Long> r104 = this.f540074a.f540085d;
        ArrayList r105 = (ArrayList) r104;
        r105.add(Long.valueOf(r103));
        c.b(this.f540074a, r101, r103, LiveCommonConstants.REASON_ON_DEDTROY);
        return;
    L5:
        if (r102 >= ((ArrayList) this.f540074a.f540082a).size()) goto L7;
        ListProtector.remove(this.f540074a.f540082a, r102);
        ListProtector.remove(this.f540074a.f540083b, r102);
        goto L7
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        this.f540074a.f540093l = r100.getClass().getName();
        this.f540074a.f540094m = System.currentTimeMillis();
        c r101 = this.f540074a;
        int r102 = r101.f540100s - 1;
        r101.f540100s = r102;
        if (r102 != 0) goto L6;
        r101.f540097p = false;
        c.f540077v = false;
    L5:
        r101.f540098q = SystemClock.uptimeMillis();
    L8:
        c r103 = this.f540074a;
        c.b(r103, r103.f540093l, r103.f540094m, "onPause");
        return;
    L6:
        if (r102 >= 0) goto L8;
        r101.f540100s = 0;
        r101.f540097p = false;
        c.f540077v = false;
        goto L5
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        this.f540074a.f540091j = r100.getClass().getName();
        this.f540074a.f540092k = System.currentTimeMillis();
        c r101 = this.f540074a;
        r101.f540100s++;
        if (r101.f540097p == true) goto L18;
        r101.f540097p = true;
        if (c.f540075t == false) goto L8;
        c.f540075t = false;
        c.f540078w = 1;
        c.f540080y = r101.f540092k;
    L8:
        if (r101.f540091j.equals(r101.f540093l) == false) goto L18;
        boolean r102 = c.f540077v;
        if (r102 == true) goto L13;
    L16:
        if (r102 == true) goto L18;
        c.f540078w = 3;
        c r103 = this.f540074a;
    L15:
        c.f540080y = r103.f540092k;
        goto L18
    L13:
        if (c.f540076u == true) goto L16;
        c.f540078w = 4;
        r103 = this.f540074a;
    L18:
        c r104 = this.f540074a;
        c.b(r104, r104.f540091j, r104.f540092k, "onResume");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        c r101 = this.f540074a;
        r101.f540089h = r100.getClass().getName();
        c r102 = this.f540074a;
        r102.f540090i = System.currentTimeMillis();
        c r103 = this.f540074a;
        c.b(r103, r103.f540089h, r103.f540090i, WidgetCostModule.TYPE_ON_START);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        c r101 = this.f540074a;
        r101.f540095n = r100.getClass().getName();
        c r102 = this.f540074a;
        r102.f540096o = System.currentTimeMillis();
        c r103 = this.f540074a;
        c.b(r103, r103.f540095n, r103.f540096o, "onStop");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        c r102 = this.f540074a;
        r102.f540087f = r100.getClass().getName();
        c r103 = this.f540074a;
        r103.f540088g = System.currentTimeMillis();
        if (r101 == null) goto L5;
        boolean r104 = true;
    L6:
        c.f540076u = r104;
        c.f540077v = true;
        c r105 = this.f540074a;
        List<String> r106 = r105.f540082a;
        ArrayList r107 = (ArrayList) r106;
        r107.add(r105.f540087f);
        c r108 = this.f540074a;
        List<Long> r109 = r108.f540083b;
        ArrayList r110 = (ArrayList) r109;
        r110.add(Long.valueOf(r108.f540088g));
        c r111 = this.f540074a;
        c.b(r111, r111.f540087f, r111.f540088g, WidgetCostModule.TYPE_ON_CREATE);
        return;
    L5:
        r104 = false;
        goto L6
    }
}
