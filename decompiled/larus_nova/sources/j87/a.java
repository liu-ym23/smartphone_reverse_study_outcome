package j87;

import android.content.Context;
import com.bytedance.push.third.IPushAdapter;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f497725a;

    public a(Context r100) {
        this.f497725a = r100;
    }

    @Override // j87.b
    public final boolean a(IPushAdapter r100, int r101) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.isPushAvailable(this.f497725a, r101) == false) goto L6;
        return true;
    }
}
