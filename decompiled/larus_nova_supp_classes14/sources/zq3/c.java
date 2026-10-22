package zq3;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.google.gson.Gson;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static final Gson a = null;
    public static final boolean b = false;

    static {
        a = new Gson();
        b = !ECAppInfoService.e.i();
    }
}
