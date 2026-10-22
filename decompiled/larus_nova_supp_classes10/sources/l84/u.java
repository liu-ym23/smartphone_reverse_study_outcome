package l84;

import com.bytedance.bdlocation.client.BDLocationConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class u implements Runnable {
    public /* synthetic */ u() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        BDLocationConfig.setRequestLocation(true);
    }
}
