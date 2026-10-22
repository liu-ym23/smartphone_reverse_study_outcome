package l84;

import com.bytedance.bdlocation.client.BDLocationConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class x implements Runnable {
    public /* synthetic */ x() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        BDLocationConfig.setRequestLocation(true);
    }
}
