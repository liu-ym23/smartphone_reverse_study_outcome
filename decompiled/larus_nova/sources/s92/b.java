package s92;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.t;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f541063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f541064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f541065c;

    public final boolean a() {
        if (this.f541065c == true) goto L5;
        return true;
    L5:
        t r100 = this.f541063a;
        if (r100 == null) goto L10;
        m0 r101 = r100.getBaseMessage();
        if (r101 == null) goto L10;
        long r102 = r101.getAnchorFoldDuration();
    L12:
        if (r102 > 0) goto L14;
        return true;
    L14:
        if (this.f541064b > 0) goto L16;
        return true;
    L16:
        if ((System.currentTimeMillis() - this.f541064b) >= (r102 * 1000)) goto L22;
        return false;
    L22:
        return true;
    L10:
        r102 = 0;
        goto L12
    }

    public b(boolean r100) {
        this.f541065c = r100;
    }
}
