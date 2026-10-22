package kfc;

import android.content.ComponentName;
import android.content.Context;
import com.ss.android.newmedia.redbadge.RedBadgerException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class b implements a {
    public abstract int d(Context r100, ComponentName r101) throws RedBadgerException;

    public boolean e(int r100) {
        return true;
    }

    public b() {
    }

    public boolean c(Context r100, ComponentName r101, int r102) {
        if (r100 == null) goto L17;
        if (r101 == null) goto L17;
        if (r102 > 0) goto L19;
        com.bytedance.push.utils.f.b("CnHomeBadger", "count must bigger than 0");
        return false;
    L19:
        int r103 = d(r100, r101);     // Catch: RedBadgerException -> L14
        if (r103 < 0) goto L16;
        a(r100, r101, r103 + r102);     // Catch: RedBadgerException -> L14
        return true;
    L16:
        return false;
    L14:
        e = move-exception;
        e.printStackTrace();
    L17:
        com.bytedance.push.utils.f.b("CnHomeBadger", "args is null");
        return false;
    }

    public boolean f(Context r100, ComponentName r101, int r102) {
        if (r100 == null) goto L19;
        if (r101 == null) goto L19;
        if (r102 > 0) goto L21;
        com.bytedance.push.utils.f.b("CnHomeBadger", "count must bigger than 0");
        return false;
    L21:
        int r103 = d(r100, r101);     // Catch: RedBadgerException -> L16
        int r104 = r103 - r102;     // Catch: RedBadgerException -> L16
        if (r104 >= 0) goto L13;
        com.bytedance.push.utils.f.b("CnHomeBadger", "cur badge number is " + r103 + " but try to reduce " + r102 + ", can't do it");     // Catch: RedBadgerException -> L16
        return false;
    L13:
        a(r100, r101, r104);     // Catch: RedBadgerException -> L16
        return true;
    L16:
        e = move-exception;
        e.printStackTrace();
        return false;
    L19:
        com.bytedance.push.utils.f.b("CnHomeBadger", "args is null");
        return false;
    }
}
