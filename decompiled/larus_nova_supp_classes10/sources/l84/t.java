package l84;

import com.bytedance.bdlocation.store.LocationCache;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class t implements Runnable {
    public /* synthetic */ t() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        LocationCache.getInstance().clearLocalLocationCache();
    }
}
