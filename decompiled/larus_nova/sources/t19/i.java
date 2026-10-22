package t19;

import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f544184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f544185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f544186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f544187d;

    public /* synthetic */ i(Context r100, int r101, int r102, boolean r103) {
        this.f544184a = r100;
        this.f544185b = r101;
        this.f544186c = r102;
        this.f544187d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context r100 = this.f544184a;
        int r101 = this.f544185b;
        int r102 = this.f544186c;
        boolean r103 = this.f544187d;
        if (r100 != null) goto L5;
        Context r104 = AppHost.f326268a.getApplication();
    L6:
        String r105 = r104.getResources().getString(r101);
        FLogger.f375446a.d("ToastLogger", "toast utils show, method name: showWithIcon");
        s.f544207a.getClass();
        s.l(r100, r102, r105, null, null, r103);
        return;
    L5:
        r104 = r100;
        goto L6
    }
}
