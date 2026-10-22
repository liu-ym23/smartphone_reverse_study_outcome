package lfc;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class r implements kfc.a {
    public r() {
    }

    @Override // kfc.a
    public final List<String> b() {
        return Collections.singletonList("com.transsion.XOSLauncher");
    }

    @Override // kfc.a
    public final void a(Context r100, ComponentName r101, int r102) throws RedBadgerException {
        Bundle r103 = new Bundle();
        r103.putString("package", r100.getPackageName());     // Catch: Exception -> L5
        r103.putString("class", r101.getClassName());     // Catch: Exception -> L5
        r103.putInt("badgenumber", r102);     // Catch: Exception -> L5
        r100.getContentResolver().call(UriProtector.parse("content://com.transsion.XOSLauncher.unreadprovider"), "change_badge", null, r103);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        throw new RedBadgerException(e.getMessage(), e);
    }
}
