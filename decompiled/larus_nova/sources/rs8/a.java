package rs8;

import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.platform.service.i3;

/* JADX INFO: loaded from: classes26.dex */
public final class a {
    static {
    }

    public static boolean a() {
        e0 r100 = AuthModelDelegate.f297134b.e().getValue();
        if (r100 == null) goto L5;
        LaunchInfo r101 = r100.f297186a;
    L7:
        if (r101 != null) goto L10;
        return true;
    L10:
        if (FeatureKitDelegate.f295792b.j0().b() == false) goto L12;
        return true;
    L12:
        if (i3.f365750a.f() == true) goto L17;
        return false;
    L17:
        return true;
    L5:
        r101 = null;
        goto L7
    }
}
