package ss6;

import android.app.Activity;
import com.bytedance.locallife.adapter.impl.host.appInfo.AbsLifeHostAppInfo;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import java.util.List;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import v19.h;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends AbsLifeHostAppInfo {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f543411b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f543412c = null;

    @Override // ss6.c
    public final boolean isPluginReady() {
        Intrinsics.checkNotNullParameter("com.bytedance.lifeservice.im.plugin", "pkg");
        return true;
    }

    static {
        f543411b = new b();
        f543412c = LazyKt.lazy(new a());
    }

    @Override // ss6.c
    public final List<Activity> getActivityStack() {
        return AppHost.f326268a.a().g();
    }

    @Override // ss6.c
    public final int getAppId() {
        return AppHost.f326268a.getAppId();
    }

    @Override // ss6.c
    public final String getAppName() {
        return AppHost.f326268a.getAppName();
    }

    @Override // ss6.c
    public final String getAppVersion() {
        return AppHost.f326268a.getVersionName();
    }

    @Override // ss6.c
    public final String getBussinessVersionName() {
        return AppHost.f326268a.getVersionName();
    }

    @Override // ss6.c
    public final String getChannel() {
        return AppHost.f326268a.getBuildChannel();
    }

    @Override // ss6.c
    public final String getColdLaunchTime() {
        return String.valueOf(AppHost.f326268a.getAppStartTime().getSecond().longValue());
    }

    @Override // ss6.c
    public final Activity getCurrentActivity() {
        List<Activity> r100 = AppHost.f326268a.a().g();
        ListIterator<Activity> r101 = r100.listIterator(r100.size());
    L4:
        if (r101.hasPrevious() == false) goto L13;
        Activity r102 = r101.previous();
        Activity r103 = r102;
        if (r103.isFinishing() == false) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == false) goto L4;
    L15:
        return r102;
    L8:
        if (r103.isDestroyed() == true) goto L10;
        r104 = true;
        goto L11
    L13:
        r102 = null;
        goto L15
    }

    @Override // ss6.c
    public final String getDeviceId() {
        return IApplog.f287053a.getDeviceId();
    }

    @Override // ss6.c
    public final long getServerTime() {
        return AppHost.f326268a.getAppClock().currentTimeMillis();
    }

    @Override // ss6.c
    public final long getUpdateVersionCode() {
        return AppHost.f326268a.getUpdateVersionCode();
    }

    @Override // ss6.c
    public final boolean isDebug() {
        return ((Boolean) f543412c.getValue()).booleanValue();
    }

    public b() {
    }

    @Override // ss6.c
    public final String a(boolean r100) {
        if (r100 == false) goto L5;
        return "light";
    L5:
        boolean r101 = h.f552477a;
        if (h.a(null) == false) goto L9;
        return "dark";
    L9:
        return "light";
    }
}
