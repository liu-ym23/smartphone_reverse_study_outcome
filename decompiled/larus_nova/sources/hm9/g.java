package hm9;

import com.larus.dora.device.api.IDoraDeviceInfo;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements i49.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IDoraDeviceInfo f485958a;

    public g(IDoraDeviceInfo r100) {
        this.f485958a = r100;
    }

    @Override // i49.a
    public final void a(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "productName");
        boolean r102 = this.f485958a.hasDoraDevice();
        FLogger r103 = FLogger.f375446a;
        j r104 = j.f485959a;
        r103.i("BackgroundNetworkInterceptor", "onDoraLinkChanged: state=" + r100 + ", hasDoraDevice=" + r102);
        j r105 = j.f485959a;
        monitor-enter(r105);
        s r106 = j.f485966h;     // Catch: Throwable -> L11
        if (r106.f485975e != r102) goto L8;
        monitor-exit(r105);
        return;
    L8:
        xg9.b.a().storeBoolean("has_dora_device", r102);     // Catch: Throwable -> L11
        r106.f485975e = r102;     // Catch: Throwable -> L11
        r103.i("BackgroundNetworkInterceptor", "updateDoraUser: hasDoraDevice=" + r102);     // Catch: Throwable -> L11
        r105.b();     // Catch: Throwable -> L11
        j.e("updateDoraUser");     // Catch: Throwable -> L11
        monitor-exit(r105);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
