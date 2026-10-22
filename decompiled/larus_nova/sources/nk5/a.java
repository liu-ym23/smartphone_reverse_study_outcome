package nk5;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.jsapi.SettingsBitableConfig;
import com.ss.android.lark.appsetting.api.SettingManager;
import gk5.c;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import na8.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements c {
    public a() {
    }

    @Override // gk5.c
    public final void a(FragmentActivity r100, JSONObject r101, p r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "callback");
        SettingsBitableConfig r103 = (SettingsBitableConfig) SettingManager.getInstance().get(SettingsBitableConfig.class);
        JSONObject r104 = new JSONObject();
        if (r103 == null) goto L10;
        Map<String, Boolean> r105 = r103.a();
        if (r105 == null) goto L10;
        Iterator<Map.Entry<String, Boolean>> r106 = r105.entrySet().iterator();
    L8:
        if (r106.hasNext() == false) goto L10;
        Map.Entry<String, Boolean> r107 = r106.next();
        r104.put(r107.getKey(), r107.getValue().booleanValue());
    L10:
        r102.onSuccess(r104);
    }
}
