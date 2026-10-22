package sq1;

import android.content.SharedPreferences;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import kotlin.jvm.JvmStatic;
import org.json.JSONException;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f542957a = 0;

    static {
    }

    @JvmStatic
    public static final jq1.c a(long r100) {
        jq1.c r101 = (jq1.c) new Gson().fromJson(jc1.a.b().getSharedPreferences("live_vs_sp_play_progress_cache", 0).getString(String.valueOf(r100), ""), jq1.c.class);     // Catch: Exception -> L7
        if (r101 != null) goto L11;
        return new jq1.c(0, 0);
    L11:
        return r101;
    L8:
        return new jq1.c(0, 0);
    }

    @JvmStatic
    public static final void b(long r100, long r101) {
        SharedPreferences.Editor r102 = jc1.a.b().getSharedPreferences("live_vs_sp_play_progress_cache", 0).edit();
        r102.putString(String.valueOf(r100), GsonProtectorUtils.toJson(new Gson(), new jq1.c(r101, System.currentTimeMillis())));     // Catch: JSONException -> L5
    L7:
        r102.apply();
        return;
    L5:
        e = move-exception;
        ALogger.e("VSVideoProgressUtil", "save local progress failed " + e);
        goto L7
    }
}
