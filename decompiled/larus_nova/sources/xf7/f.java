package xf7;

import android.content.Context;
import com.bytedance.common.utility.NetworkUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f563453a;

    public f(g r100) {
        this.f563453a = r100;
    }

    @Override // xf7.k
    public final boolean O(Context r100) {
        g r101 = this.f563453a;
        if (r101 == null) goto L6;
        r101.getClass();
    L6:
        return NetworkUtils.isNetworkAvailableFast(r100);
    }
}
