package lfc;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class u implements kfc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f509112a;

    @Override // kfc.a
    public final List<String> b() {
        return Collections.singletonList("com.zui.launcher");
    }

    public u() {
        this.f509112a = UriProtector.parse("content://com.android.badge/badge");
    }

    @Override // kfc.a
    public final void a(Context r100, ComponentName r101, int r102) throws RedBadgerException {
        if (r100 == null) goto L12;
        if (r101 == null) goto L15;
        if (r102 >= 0) goto L13;
        r102 = 0;
    L13:
        Bundle r103 = new Bundle();     // Catch: Throwable -> L9
        r103.putInt("app_badge_count", r102);     // Catch: Throwable -> L9
        r100.getContentResolver().call(this.f509112a, "setAppBadgeCount", null, r103);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
        throw new RedBadgerException(th.getMessage());
    L15:
        return;
    }
}
