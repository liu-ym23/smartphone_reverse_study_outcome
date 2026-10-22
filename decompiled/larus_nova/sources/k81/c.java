package k81;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.livesdk.utils.v5;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f502081a = 0;

    @JvmStatic
    public static final j81.a a() {
        String r100 = v5.b().getString("live.pref.SHARE_PANEL_CONFIG", "");
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L13;
        ALogger.i("QrCodeConfig", "cache map is null");
        return null;
    L13:
        return (j81.a) JsonUtil.parse(r100, j81.a.class);
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    static {
    }

    public static boolean b(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.length() <= 0) goto L6;
        return true;
    }
}
