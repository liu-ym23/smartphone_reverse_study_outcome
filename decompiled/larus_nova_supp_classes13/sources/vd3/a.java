package vd3;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.z1;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    public a() {
    }

    static {
    }

    public static void a(BcmParams r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "bcm");
        if (r4 == null) goto L5;
        JSONObject r5 = z1.g(r4);
    L6:
        if (r5 == null) goto L11;
        Iterator<String> r0 = r5.keys();
    L9:
        if (r0.hasNext() == false) goto L13;
        String r1 = r0.next();
        r3.put(r1, r5.optString(r1));
        goto L9
    L13:
        return;
    L11:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public static String b(Object r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "page");
        Intrinsics.checkNotNullParameter(r4, "btm");
        return BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder(r4, false).withPageFinder(PageFinder.via(r3)).build());
    }
}
