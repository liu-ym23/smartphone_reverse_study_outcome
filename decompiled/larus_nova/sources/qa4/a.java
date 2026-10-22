package qa4;

import android.content.Context;
import com.bytedance.bdp.serviceapi.defaults.log.BdpLogService;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.io.FilesKt;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f532253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ wa4.b f532254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ra4.a.InterfaceC7454a f532255c;

    public a(Context r100, wa4.b r101, ra4.a.InterfaceC7454a r102) {
        this.f532253a = r100;
        this.f532254b = r101;
        this.f532255c = r102;
    }

    public final void a() {
        int r100 = ra4.a.f536843a;
        Context r101 = this.f532253a;
        wa4.b r102 = this.f532254b;
        ra4.a.InterfaceC7454a r103 = this.f532255c;
        BdpLogService r104 = oa4.a.f522541a;
        int r105 = ua4.a.f549245a;
        oa4.a.f522541a.i("LiveMeta", "LiveMeta.useMeta call");
        va4.b r106 = new va4.b(r102.f558819k, r102.f558814f, r102.f558818j);
        new sa4.a(r106, new sa4.b(FilesKt.resolve(r106.a(), "PackageInfo.json"))).a();     // Catch: Exception -> L5
    L7:
        new wa4.a();
        wa4.a.a(r101, r102);     // Catch: Exception -> L10
        throw null;     // Catch: Exception -> L10
    L10:
        e = move-exception;
        BdpLogService r107 = oa4.a.f522541a;
        int r108 = ua4.a.f549245a;
        oa4.a.f522541a.e("LiveMeta", "MetaInfoFetcher.fetchInfo() fail: " + e);
        r103.a("fetch_info", e.getMessage());
        return;
    L5:
        e = move-exception;
        BdpLogService r109 = oa4.a.f522541a;
        int r110 = ua4.a.f549245a;
        oa4.a.f522541a.e("LiveMeta", "metaActiveManager remove old items error: " + e);
        goto L7
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
}
