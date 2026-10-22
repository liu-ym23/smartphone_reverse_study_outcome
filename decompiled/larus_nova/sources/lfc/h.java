package lfc;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class h extends kfc.b {
    @Override // kfc.a
    public final List<String> b() {
        return Arrays.asList(new String[]{"com.hihonor.android.launcher"});
    }

    public h() {
    }

    @Override // kfc.b
    public final int d(Context r100, ComponentName r101) throws RedBadgerException {
        com.bytedance.push.utils.f.b("HonorHomeBadger", "getCurRedBadgeNumber");
        if (r100 == null) goto L14;
        if (r101 == null) goto L14;
        Bundle r102 = new Bundle();
        r102.putString("package", r100.getPackageName());
        r102.putString("class", r101.getClassName());
        Bundle r103 = r100.getContentResolver().call(UriProtector.parse("content://com.hihonor.android.launcher.settings/badge/"), "getbadgeNumber", null, r102);     // Catch: Throwable -> L11
        if (r103 == null) goto L13;
        return r103.getInt("badgenumber");
    L13:
        return -1;
    L11:
        th = move-exception;
        th.printStackTrace();
    L14:
        com.bytedance.push.utils.f.b("HonorHomeBadger", "args is null");
        return -1;
    }

    @Override // kfc.a
    public final void a(Context r100, ComponentName r101, int r102) throws RedBadgerException {
        if (r100 == null) goto L16;
        if (r101 == null) goto L19;
        if (r102 >= 0) goto L7;
        r102 = 0;
    L7:
        Bundle r103 = new Bundle();
        r103.putString("package", r100.getPackageName());
        r103.putString("class", r101.getClassName());
        r103.putInt("badgenumber", r102);
        Uri r104 = UriProtector.parse("content://com.hihonor.android.launcher.settings/badge/");     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r100.getContentResolver().getType(r104)) == false) goto L11;
        r104 = UriProtector.parse("content://com.huawei.android.launcher.settings/badge/");     // Catch: Throwable -> L13
    L11:
        r100.getContentResolver().call(r104, "change_badge", null, r103);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
        throw new RedBadgerException(th.getMessage());
    L19:
        return;
    }
}
