package lfc;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class t implements kfc.a {
    public t() {
    }

    @Override // kfc.a
    public final List<String> b() {
        return new ArrayList(0);
    }

    @Override // kfc.a
    public final void a(Context r100, ComponentName r101, int r102) throws RedBadgerException {
        if (r100 == null) goto L13;
        if (r101 == null) goto L16;
        if (r102 >= 0) goto L7;
        r102 = 0;
    L7:
        Bundle r103 = new Bundle();
        r103.putInt("app_badge_count", r102);
        r103.putString("app_badge_component_name", r101.flattenToString());
        r100.getContentResolver().call(UriProtector.parse("content://com.android.launcher3.cornermark.unreadbadge"), "setAppUnreadCount", null, r103);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
        throw new RedBadgerException(th.getMessage());
    L16:
        return;
    }
}
