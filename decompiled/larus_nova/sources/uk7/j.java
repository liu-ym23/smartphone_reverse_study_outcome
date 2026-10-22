package uk7;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f550534c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f550535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f550536b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f550537a = null;

        static {
            f550537a = new j();
        }
    }

    static {
        HashSet r100 = new HashSet();
        f550534c = r100;
        r100.add("/luckycat/activity/settings/get_dynamic_settings/");
        r100.add("/luckycat/activity/settings/get_static_settings/");
        r100.add("/luckycat/activity/settings/get_polling_settings/");
        r100.add("/luckycat/crossover/v:version/ack_install/");
        r100.add("/luckycat/activity/phone_score/");
        r100.add("/luckycat/activity/apply_token/");
    }

    public j() {
        HashSet r100 = new HashSet();
        this.f550536b = r100;
        this.f550535a = il7.m.a().e("auto_trigger_path_list", "");
        r100.addAll(f550534c);
        r100.addAll(a(this.f550535a));
    }

    public static Set a(String r100) {
        JSONArray r101 = new JSONArray(r100);     // Catch: JSONException -> L5
    L7:
        HashSet r102 = new HashSet();
        if (r101 != null) goto L10;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NetWorkColourManager", "addPath() 为空，return");
    L20:
        return r102;
    L10:
        int r103 = 0;
    L12:
        if (r103 >= r101.length()) goto L20;
        String r104 = JSONArrayProtectorUtils.getString(r101, r103);     // Catch: JSONException -> L17
        if (TextUtils.isEmpty(r104) == true) goto L19;
        r102.add(r104);     // Catch: JSONException -> L17
    L19:
        r103 = r103 + 1;
    L17:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NetWorkColourManager", e.getLocalizedMessage());
    L5:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NetWorkColourManager", e.getLocalizedMessage());
        r101 = null;
        goto L7
    }
}
