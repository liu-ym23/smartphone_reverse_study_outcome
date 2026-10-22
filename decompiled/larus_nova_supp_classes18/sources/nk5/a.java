package nk5;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.jsapi.SettingsBitableConfig;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.lark.appsetting.api.SettingManager;
import gk5.c;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import na8.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements c {
    public a() {
    }

    @Override // gk5.c
    public final void a(FragmentActivity r3, JSONObject r4, p r5) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, WikiFolderPushPlugin.DATA);
        Intrinsics.checkNotNullParameter(r5, "callback");
        SettingsBitableConfig r6 = (SettingsBitableConfig) SettingManager.getInstance().get(SettingsBitableConfig.class);
        JSONObject r7 = new JSONObject();
        if (r6 == null) goto L10;
        Map r8 = r6.a();
        if (r8 == null) goto L10;
        Iterator r9 = r8.entrySet().iterator();
    L8:
        if (r9.hasNext() == false) goto L10;
        Map.Entry r0 = (Map.Entry) r9.next();
        r7.put((String) r0.getKey(), ((Boolean) r0.getValue()).booleanValue());
    L10:
        r5.onSuccess(r7);
    }
}
