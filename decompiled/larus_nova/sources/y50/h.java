package y50;

import com.bytedance.android.live.base.BaseServices;
import com.bytedance.android.livehostapi.platform.IHostMonitor;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes45.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f566213a = null;

    static {
        f566213a = CollectionsKt.mutableListOf(new String[]{"ttlive_network_apm", "tlive_setting_monitor", "widget_unload_data_center_null", "ttlive_audience_enter_room_full_new_all"});
    }

    @JvmStatic
    public static final boolean a(String r100) {
        if (r100 == null) goto L16;
        IHostMonitor r101 = (IHostMonitor) BaseServices.as(IHostMonitor.class);
        if (r101 != null) goto L8;
        return true;
    L8:
        if (r101.isNotHitSampled(r100) == false) goto L10;
    L14:
        return true;
    L10:
        if (f566213a.contains(r100) == false) goto L12;
        boolean r102 = true;
    L13:
        if (r102 == true) goto L14;
        return false;
    L12:
        r102 = false;
        goto L13
    L16:
        return false;
    }
}
