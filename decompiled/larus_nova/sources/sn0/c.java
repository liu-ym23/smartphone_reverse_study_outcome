package sn0;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements nn0.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f542622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ pn0.d f542623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b.a f542624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f542625d;

    @Override // nn0.b.a
    public final void onError(Throwable r100) {
        this.f542622a.d(this.f542623b.e(), "loadGeckoLayoutConfig failed, fileName: " + this.f542625d + ", throwable: " + r100);
        this.f542624c.onFailed(r100);
    }

    @Override // nn0.b.a
    public final void onSuccess(String r100) {
        this.f542622a.d(this.f542623b.e(), "loadGeckoLayoutConfig success, filePath: " + r100);
        if (r100 == null) goto L9;
        b r101 = this.f542622a;
        pn0.d r102 = this.f542623b;
        b.a r103 = this.f542624c;
        r101.getClass();
        LayoutConfigModel r104 = (LayoutConfigModel) GsonHelper.get().fromJson(GsonHelper.get().newJsonReader(new PolarisFileReaderWrapper(r100)), new g().getType());     // Catch: Throwable -> L7
        r101.d(r102.e(), "parseGeckoLayoutConfig success");     // Catch: Throwable -> L7
        r103.a(r104);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        r101.d(r102.e(), "parseGeckoLayoutConfig failed");
        r103.onFailed(th);
        return;
    L9:
        this.f542624c.onFailed(new Throwable("loadGeckoLayoutConfig, filePath is null"));
    }

    public c(b r100, pn0.d r101, f r102, String r103) {
        this.f542622a = r100;
        this.f542623b = r101;
        this.f542624c = r102;
        this.f542625d = r103;
    }
}
