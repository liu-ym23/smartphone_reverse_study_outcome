package ou6;

import android.content.Context;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class j {
    public static boolean a(String r100) {
        Context r101 = HostServiceUtilsKt.E().getApplicationContext();
        if (r101 != null) goto L5;
    L10:
        return false;
    L5:
        if (StringUtils.isEmpty(r100) == true) goto L10;
        if (r101.getPackageManager().getPackageInfo(r100, 16777216) == null) goto L10;
        return true;
    }
}
