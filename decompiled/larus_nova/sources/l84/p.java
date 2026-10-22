package l84;

import android.text.TextUtils;
import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.log.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;

/* JADX INFO: loaded from: classes10.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f508032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f508033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f508034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ k f508035d;

    public final void a() {
        if (TextUtils.isEmpty(this.f508032a) == false) goto L6;
        Logger.w("BDLocationService.updateNavigationHint ignored, businessId is null or empty");
        return;
    L6:
        Integer r100 = (Integer) ((HashMap) this.f508035d.f507976i).get(this.f508032a);
        if (r100 != null) goto L10;
        Logger.w("BDLocationService.updateNavigationHint ignored, businessId locate type not found: " + this.f508032a);
        return;
    L10:
        k r101 = this.f508035d;
        int r102 = r100.intValue();
        r101.getClass();
        if (k.r(r102) == false) goto L16;
        BaseLocate r103 = this.f508035d.f507975h;
        if (r103 == null) goto L15;
        r103.updateNavigationHint(this.f508032a, this.f508033b, this.f508034c);
        return;
    L15:
        Logger.w("BDLocationService.updateNavigationHint ignored, byte fusion continuous location is null");
        return;
    L16:
        BaseLocate r104 = this.f508035d.f507973f;
        if (r104 == null) goto L22;
        r104.updateNavigationHint(this.f508032a, this.f508033b, this.f508034c);
        return;
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

    public p(k r100, String r101, int r102, float r103) {
        this.f508035d = r100;
        this.f508032a = r101;
        this.f508033b = r102;
        this.f508034c = r103;
    }
}
