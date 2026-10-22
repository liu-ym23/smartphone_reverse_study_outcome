package o2a;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import kotlin.jvm.internal.Intrinsics;
import l2a.u;

/* JADX INFO: loaded from: classes32.dex */
public final class b {
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        String r101 = AppHost.f326268a.getApplication().getFilesDir().getPath() + '/' + r100 + '/';
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
        if (r102.exists() == true) goto L5;
        r102.mkdirs();
        boolean r103 = u.f507187a;
        u.b("BmfVideoSRHelper", "file.mkdirs(): superRsSoPath" + r101);
    L5:
        return r101;
    }
}
