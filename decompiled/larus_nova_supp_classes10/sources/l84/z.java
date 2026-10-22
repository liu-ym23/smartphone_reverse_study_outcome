package l84;

import com.bytedance.bdlocation.LocationUtil;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class z implements Runnable {
    public final /* synthetic */ a0 a;

    public /* synthetic */ z(a0 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LocationUtil.startGetDimLocation(this.a.a.b);
    }
}
