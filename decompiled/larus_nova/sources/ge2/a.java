package ge2;

import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f481015a = 0;

    static {
    }

    public static boolean a(DataCenter r100) {
        if (j.i() == true) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == false) goto L15;
        return false;
    L15:
        return true;
    L7:
        if (((LiveMode) r100.get("data_live_mode", LiveMode.VIDEO)) != LiveMode.AUDIO) goto L9;
        r101 = true;
        goto L10
    }
}
