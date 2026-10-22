package x37;

import com.bytedance.mt.protector.impl.color.ColorProtector;
import u77.i;

/* JADX INFO: loaded from: classes21.dex */
public final class d {
    public static int a() {
        com.ss.android.pushmanager.setting.b.b().getClass();
        i r100 = com.ss.android.pushmanager.setting.b.d().B();
        if (r100 == null) goto L7;
        int r101 = ColorProtector.parseColor(r100.notificationRedBadgeColor);
        if (r101 == 0) goto L9;
        return r101;
    L9:
        return -65536;
    L7:
        return -65536;
    }
}
