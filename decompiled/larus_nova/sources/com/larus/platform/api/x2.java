package com.larus.platform.api;

import android.app.Dialog;
import androidx.fragment.app.FragmentActivity;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocateScene;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public interface x2 {

    public static final class a {
        public static /* synthetic */ void a(LocateScene r100) {
            com.larus.platform.service.l1.f365760a.a(r100, null);
        }
    }

    void a(LocateScene r100, hq9.a3 r101);

    void b(hq9.y2 r100);

    boolean c();

    Dialog d(FragmentActivity r100);

    GeoLocationInfo e(long r100);

    void f(LocateScene r100, com.bytedance.applet.utils.g r101, JSONObject r102);

    void g();
}
