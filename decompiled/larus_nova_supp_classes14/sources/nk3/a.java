package nk3;

import com.bytedance.geckox.b;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.settings.GlobalSettingsManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
        b r0 = b.a.a;
        GlobalConfigSettings r1 = GlobalSettingsManager.a;
        ReqType r2 = ReqType.NORMAL;
        GlobalSettingsManager.h = null;
        GlobalSettingsManager.c(r2, false);
    }
}
