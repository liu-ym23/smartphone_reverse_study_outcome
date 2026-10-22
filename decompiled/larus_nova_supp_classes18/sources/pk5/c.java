package pk5;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.jsapi.common.LocationHelper;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import na8.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements gk5.c {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // gk5.c
    public final void a(FragmentActivity r3, JSONObject r4, p r5) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, WikiFolderPushPlugin.DATA);
        Intrinsics.checkNotNullParameter(r5, "callback");
        if (r4.has("accuracy") == true) goto L5;
    L9:
        String r6 = null;
    L16:
        LocationHelper.a(r3, new LocationHelper.GetLocationRequest(r6), new d(r5));     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        nk5.b.c(r5, th);
        return;
    L5:
        if (r4.isNull("accuracy") == true) goto L9;
        r6 = r4.optString("accuracy");
        if ((!StringsKt.isBlank(r6)) == false) goto L9;
        goto L9
    }
}
