package oj7;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.crash.Npth;
import com.bytedance.ies.bullet.ui.common.AbsBulletContainerActivity;
import com.bytedance.ug.sdk.luckycat.impl.utils.v;
import java.lang.ref.WeakReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<b> f523586a;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes22.dex */
    public interface b {
        void a();
    }

    static {
    }

    public c() {
    }

    public static void b(boolean r100) {
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("PageStatusDetector", "polaris_is_top_screen: top = " + r100);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        if (r100 == false) goto L6;
        String r102 = "true";
    L7:
        Npth.addTag("polaris_is_top_screen", r102);     // Catch: Throwable -> L9
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
        return;
    L6:
        r102 = "false";
    L9:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final boolean a(Activity r100) {
        if ((r100 instanceof AbsBulletContainerActivity) == true) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(((AbsBulletContainerActivity) r100).getBid(), nj7.a.f519460b.getBid()) == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Activity[] r101 = to7.c.a();
        if (r101 != null) goto L5;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == true) goto L20;
        int r103 = r101.length;
    L15:
        r103 = r103 - 1;
        if (r103 < 0) goto L20;
        Activity r104 = r101[r103];
        if ((!Intrinsics.areEqual(r104, r100)) == false) goto L15;
    L21:
        if (r104 != null) goto L24;
        b(false);
        return;
    L24:
        if ((r104 instanceof dj7.b) == false) goto L26;
    L29:
        boolean r105 = true;
    L30:
        if (r105 == false) goto L32;
        b(true);
        return;
    L32:
        WeakReference<b> r106 = this.f523586a;
        if (r106 == null) goto L37;
        b r107 = r106.get();
        if (r107 == null) goto L37;
        r107.a();
    L37:
        b(false);
        return;
    L26:
        if (a(r100) == true) goto L29;
        r105 = false;
    L20:
        r104 = null;
        goto L21
    L5:
        if (r101.length != 0) goto L7;
        boolean r108 = true;
    L8:
        if (r108 == true) goto L11;
        r102 = false;
        goto L12
    L7:
        r108 = false;
        goto L8
    }

    @Override // com.bytedance.ug.sdk.luckycat.impl.utils.v, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        if ((r100 instanceof dj7.b) == false) goto L5;
    L7:
        b(true);
        return;
    L5:
        if (a(r100) == true) goto L7;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        if ((r100 instanceof dj7.b) == false) goto L5;
    L8:
        b(true);
        return;
    L5:
        if (a(r100) == true) goto L8;
        b(false);
    }
}
