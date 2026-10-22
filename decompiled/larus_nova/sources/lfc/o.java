package lfc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class o implements kfc.a {
    public o() {
    }

    @Override // kfc.a
    public final List<String> b() {
        return Arrays.asList(new String[]{"com.smartisanos.launcher", "com.smartisanos.home"});
    }

    @Override // kfc.a
    public final void a(Context r100, ComponentName r101, int r102) throws RedBadgerException {
        if (r100 == null) goto L19;
        if (r101 == null) goto L25;
        if (r102 >= 0) goto L7;
        r102 = 0;
    L7:
        Intent r103 = new Intent("com.smartisanos.launcher.new_message");
        r103.putExtra("extra_packagename", r101.getPackageName());
        r103.putExtra("extra_componentname", r101.getClassName());
        r103.putExtra("extra_message_count", r102);
        if (nfc.a.a(r100, r103) == true) goto L20;
        Bundle r104 = new Bundle();
        r104.putInt("badge_num", r102);
        r100.getContentResolver().call(UriProtector.parse("content://com.smartisanos.launcher.badge"), "updateMessageBadge", null, r104);     // Catch: Throwable -> L17
        return;
    L18:
        throw new RedBadgerException("unable to resolve intent: " + r103.toString());
    L20:
        r100.sendBroadcast(r103);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        throw new RedBadgerException(th.getMessage());
    L25:
        return;
    }
}
