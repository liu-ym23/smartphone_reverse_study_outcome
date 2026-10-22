package com.ss.android.lark.keyboard.statistics;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.statistics.a$a, reason: collision with other inner class name */
    public static final class C5117a {
    }

    static {
    }

    public a() {
    }

    public abstract String a();

    public abstract String b();

    public final void c() {
        Statistics.sendEvent(a(), new JSONObject().put(DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON, b()));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("KBPluginHitPoint", "send hit point failed " + e.getMessage());
    }
}
