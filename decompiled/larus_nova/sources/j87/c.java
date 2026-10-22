package j87;

import android.content.Context;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.third.IPushAdapter;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f497726a;

    public c(Context r100) {
        this.f497726a = r100;
    }

    @Override // j87.b
    public final boolean a(IPushAdapter r100, int r101) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (r100.isPushAvailable(this.f497726a, r101) == false) goto L8;
        if (PushSupporter.thirdService().getPushConfig(r101) == null) goto L8;
        return true;
    }
}
