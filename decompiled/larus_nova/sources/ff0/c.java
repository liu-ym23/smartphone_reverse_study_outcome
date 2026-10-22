package ff0;

import com.bytedance.android.live.api.exceptions.local.ResponseNoDataException;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.config.sz;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f476645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f476646b = false;

    static {
        f476646b = sz.f121263a.getValue().booleanValue();
    }

    public static boolean b() {
        if (vm2.d.I().getMouthEnable() == true) goto L5;
    L9:
        return false;
    L5:
        if (vm2.d.I().getVadEnable() == false) goto L9;
        if (f476645a == true) goto L9;
        return true;
    }

    public static String a(Throwable r100) {
        if ((r100 instanceof CustomApiServerException) == false) goto L6;
        return ((CustomApiServerException) r100).getXTtLogId();
    L6:
        if ((r100 instanceof ResponseNoDataException) == false) goto L11;
        BaseResponse r101 = ((ResponseNoDataException) r100).getResponse();
        if (r101 == null) goto L11;
        String r102 = r101.logId;
        if (r102 == null) goto L11;
        return r102;
    L11:
        return "";
    }
}
