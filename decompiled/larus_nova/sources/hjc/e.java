package hjc;

import android.content.Context;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes40.dex */
public class e implements b.InterfaceC6157b {
    public e() {
    }

    @Override // hjc.b.InterfaceC6157b
    public int a(Context r100, float r101, float r102) {
        if (Math.hypot(r101, r102) > ViewConfiguration.get(r100).getScaledTouchSlop()) goto L5;
        return -1;
    L5:
        if (Math.abs(r102) <= Math.abs(r101)) goto L11;
        if (r102 <= 0.0f) goto L9;
        return 4;
    L9:
        return 8;
    L11:
        if (r101 <= 0.0f) goto L13;
        return 1;
    L13:
        return 2;
    }
}
