package l84;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.callback.BDLocationCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ BDLocationCallback a;
    public final /* synthetic */ BDLocation b;

    public /* synthetic */ a(BDLocationCallback r1, BDLocation r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onLocationChanged(this.b);
    }
}
