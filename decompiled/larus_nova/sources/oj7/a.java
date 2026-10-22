package oj7;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.crash.Npth;
import com.bytedance.ies.bullet.ui.common.AbsBulletContainerActivity;
import com.bytedance.ug.sdk.luckycat.impl.utils.v;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f523582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<Integer> f523583b;

    public a() {
        this.f523583b = new ArrayList();
    }

    public final void a() {
        StringBuilder r100 = new StringBuilder("polaris_has_screen: ");     // Catch: Throwable -> L13
        if (this.f523582a <= 0) goto L6;
        boolean r101 = true;
    L7:
        r100.append(r101);     // Catch: Throwable -> L13
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyMonitor", r100.toString());     // Catch: Throwable -> L13
        if (this.f523582a <= 0) goto L10;
        String r102 = "true";
    L11:
        Npth.addTag("polaris_has_screen", r102);     // Catch: Throwable -> L13
        return;
    L10:
        r102 = "false";
        goto L11
    L6:
        r101 = false;
    L13:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        if ((r100 instanceof dj7.b) == false) goto L5;
    L11:
        this.f523582a--;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyMonitor", " ILuckyCatPage onActivityDestroyed, currentCnt = " + this.f523582a);
        a();
    L13:
        if (this.f523583b.contains(Integer.valueOf(r100.hashCode())) == false) goto L16;
        this.f523583b.remove(Integer.valueOf(r100.hashCode()));
        return;
    L16:
        return;
    L5:
        if ((r100 instanceof AbsBulletContainerActivity) == true) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == false) goto L13;
    L7:
        if (Intrinsics.areEqual(((AbsBulletContainerActivity) r100).getBid(), nj7.a.f519460b.getBid()) == false) goto L9;
        r101 = true;
        goto L10
    }

    @Override // com.bytedance.ug.sdk.luckycat.impl.utils.v, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        if ((r100 instanceof AbsBulletContainerActivity) == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L10;
        return;
    L10:
        if (this.f523583b.contains(Integer.valueOf(r100.hashCode())) == true) goto L14;
        this.f523583b.add(Integer.valueOf(r100.hashCode()));
        this.f523582a++;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyMonitor", " ILuckyCatPage onActivityCreated, currentCnt = " + this.f523582a);
        a();
        return;
    L14:
        return;
    L5:
        if (Intrinsics.areEqual(((AbsBulletContainerActivity) r100).getBid(), nj7.a.f519460b.getBid()) == false) goto L7;
        r101 = true;
        goto L8
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        if ((r100 instanceof dj7.b) == false) goto L6;
        this.f523582a++;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyMonitor", " ILuckyCatPage onActivityCreated, currentCnt = " + this.f523582a);
        a();
        return;
    }
}
