package r07;

import android.os.SystemClock;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements Callable<o07.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f535492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f535493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f535494c;

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public o07.d call2() {
        c r100 = this.f535494c;
        r100.getClass();
        r100.f535491e = SystemClock.uptimeMillis();
        ((ConcurrentHashMap) r100.f535487a).put("scc_cloudservice_prefetch_check_delta", "-1");
        ((ConcurrentHashMap) r100.f535487a).put("scc_cloudservice_prefetch_ttnet_code", "-1");
        o07.c r101 = new o07.c(this.f535492a);
        r101.f521636c = "GET";
        r101.f521634a = new HashMap();
        r101.f521638e = this.f535493b;
        o07.d r102 = n07.b.a().a(r101, false);
        c r103 = this.f535494c;
        int r104 = r102.f521639a;
        r103.getClass();
        long r105 = SystemClock.uptimeMillis() - r103.f535491e;
        ((ConcurrentHashMap) r103.f535487a).put("scc_cloudservice_prefetch_check_delta", r105 + "");
        ((ConcurrentHashMap) r103.f535487a).put("scc_cloudservice_prefetch_ttnet_code", r104 + "");
        return r102;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ o07.d call() throws Exception {
        return call2();
    }

    public d(String r100, int r101, c r102) {
        this.f535492a = r100;
        this.f535493b = r101;
        this.f535494c = r102;
    }
}
