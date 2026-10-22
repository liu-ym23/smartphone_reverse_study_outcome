package l84;

import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.log.Logger;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f508025a;

    public final void a() {
        BaseLocate r100 = this.f508025a.f507973f;
        if (r100 != null) goto L5;
    L10:
        StringBuilder r101 = new StringBuilder("stopLocationBecauseEnterBackground skip, option: ");
        BaseLocate r102 = this.f508025a.f507973f;
        if (r102 != null) goto L13;
        Object r103 = "cl null";
    L14:
        r101.append(r103);
        Logger.i(r101.toString());
        return;
    L13:
        r103 = r102.getLocationOption();
        goto L14
    L5:
        if (r100.getLocationOption() != null) goto L7;
    L8:
        Logger.i("stopLocationBecauseEnterBackground, option: " + this.f508025a.f507973f.getLocationOption());
        this.f508025a.f507973f.stopLocation();
        this.f508025a.x(null);
        return;
    L7:
        if ("bpea-light_navigation".equals(this.f508025a.f507973f.getLocationOption().getUploadSource()) == true) goto L10;
        goto L8
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

    public m(k r100) {
        this.f508025a = r100;
    }
}
