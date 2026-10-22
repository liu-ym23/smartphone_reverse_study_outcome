package ow3;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.applog.log.n;
import com.bytedance.keva.KevaPreloadHolder;
import java.util.HashSet;
import jx3.j;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a implements Application.ActivityLifecycleCallbacks {
    public int a;
    public j b;
    public long c;
    public String d;
    public final HashSet<Integer> e;
    public final com.bytedance.applog.b f;
    public boolean g;
    public volatile boolean h;
    public volatile b i;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r1, Bundle r2) {
    }

    public a(com.bytedance.applog.b r4) {
        this.a = 0;
        this.e = new HashSet(8);
        this.g = false;
        this.h = false;
        this.f = r4;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r2) {
        this.e.remove(Integer.valueOf(r2.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r8) {
        d r0 = this.f.w0;
        r0.getClass();
        String r1 = XmlPullParser.NO_NAMESPACE;
        Intrinsics.checkNotNullParameter(XmlPullParser.NO_NAMESPACE, "id");
        r0.d = XmlPullParser.NO_NAMESPACE;
        long r2 = System.currentTimeMillis();
        n r3 = this.f.t0;
        Object[] r5 = new Object[1];
        if (r8 == null) goto L5;
        r1 = r8.getClass().getName();
    L5:
        r5[0] = r1;
        r3.j("onActivityPaused:{}", r5);
        j r4 = this.b;
        if (r4 == null) goto L22;
        this.d = r4.A;
        this.c = r2;
        jx3.a r6 = (j) r4.a();
        r6.m(r2);
        long r7 = r2 - ((jx3.a) r4).b;
        if (r7 > 0) goto L10;
        r7 = 1000;
    L10:
        ((j) r6).y = r7;
        b r9 = this.i;
        if (r9 != null) goto L20;
    L18:
        this.f.V1(r6);
        this.b = null;
        return;
    L20:
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L16
        r9.a(((j) r6).A, r10);     // Catch: Throwable -> L16
        if (r10.length() <= 0) goto L18;
        ((j) r6).D = r10.toString();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.f.t0.s(null, "Navigator callback onPause:{} failed", th, new Object[]{((j) r6).A});
        goto L18
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r2) {
        a(r2.getClass().getName(), r2.hashCode());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r1) {
        this.a++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r3) {
        if (this.d == null) goto L8;
        int r4 = this.a - 1;
        this.a = r4;
        if (r4 > 0) goto L9;
        this.d = null;
        this.c = 0;
        return;
    L9:
        return;
    }

    public final void a(String r11, int r12) {
        d r0 = this.f.w0;
        String r1 = r11 + "___" + r12;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "id");
        r0.d = r1;
        long r2 = System.currentTimeMillis();
        this.f.t0.j("onActivityResumed: {}", new Object[]{r11});
        if (this.b == null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        String r4 = this.d;
        jx3.a r6 = new j();
        if (TextUtils.isEmpty(XmlPullParser.NO_NAMESPACE) == true) goto L11;
        ((j) r6).A = r11 + ":";
    L12:
        r6.m(r2);
        ((j) r6).y = -1;
        if (r4 != null) goto L16;
        r4 = XmlPullParser.NO_NAMESPACE;
    L16:
        ((j) r6).z = r4;
        b r13 = this.i;
        if (r13 != null) goto L42;
    L24:
        this.f.V1(r6);
        this.b = r6;
        ((j) r6).B = !this.e.remove(Integer.valueOf(r12)) ? 1 : 0;
        if (this.h == true) goto L27;
    L40:
        this.g = true;
        return;
    L27:
        if (this.g == true) goto L30;
        this.f.m("applog_activity_resume", "{\"v\":1}");
        goto L40
    L30:
        if (r3 == false) goto L36;
        long r7 = this.c;
        if (r7 >= (r2 - 3000)) goto L36;
        if (r7 <= (r2 - KevaPreloadHolder.FIRST_FRAME_DELAYED_TIME)) goto L36;
        this.f.m("applog_activity_resume", "{\"v\":2}");
    L36:
        if (r3 == false) goto L40;
        if (this.c >= (r2 - KevaPreloadHolder.FIRST_FRAME_DELAYED_TIME)) goto L40;
        this.f.m("applog_activity_resume", "{\"v\":3}");
        goto L40
    L42:
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L22
        r13.b(((j) r6).A, r5);     // Catch: Throwable -> L22
        if (r5.length() <= 0) goto L24;
        ((j) r6).D = r5.toString();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        this.f.t0.s(null, "Navigator callback onResume:{} failed", th, new Object[]{((j) r6).A});
        goto L24
    L11:
        ((j) r6).A = r11;
        goto L12
    L5:
        if (this.c <= 0) goto L7;
        r3 = true;
        goto L8
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r1, Bundle r2) {
        this.e.add(Integer.valueOf(r1.hashCode()));
    }
}
