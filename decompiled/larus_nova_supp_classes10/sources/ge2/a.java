package ge2;

import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(DataCenter r4) {
        if (j.i() == true) goto L5;
        return true;
    L5:
        if (r4 != null) goto L7;
    L9:
        boolean r5 = false;
    L10:
        if (r5 == false) goto L15;
        return false;
    L15:
        return true;
    L7:
        if (((LiveMode) r4.get("data_live_mode", LiveMode.VIDEO)) != LiveMode.AUDIO) goto L9;
        r5 = true;
        goto L10
    }
}
