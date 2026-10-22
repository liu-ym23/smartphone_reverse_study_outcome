package h17;

import android.content.SharedPreferences;
import com.bytedance.lynx.webview.internal.TTWebContext;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f483535a;

    public final void a() {
        SharedPreferences.Editor r100 = this.f483535a.edit();
        int r101 = this.f483535a.getInt("segNum", -1);
        if (r101 <= 0) goto L7;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L7;
        r100.remove("segNum_" + r102);
        r102 = r102 + 1;
    L7:
        r100.remove("url");
        r100.remove("md5");
        r100.remove("path");
        r100.remove("decompress_path");
        r100.remove("version");
        r100.remove("abi");
        r100.remove("segNum");
        r100.remove("size");
        r100.remove(VideoEventOneOutSync.END_TYPE_FINISH);
        r100.remove("decompress_fail_count");
        r100.remove("download_handler_type");
        r100.apply();
    }

    public final String b() {
        return this.f483535a.getString("path", "");
    }

    public b() {
        this.f483535a = TTWebContext.h().getContext().getSharedPreferences("AdblockEngine", 0);
    }

    public final void d(int r100, boolean r101) {
        this.f483535a.edit().putBoolean("segNum_" + r100, r101).apply();
    }

    public final void c(String r100, String r101, String r102, String r103, String r104, String r105, long r106, String r110) {
        SharedPreferences.Editor r107 = this.f483535a.edit();
        r107.putString("use_url", r100);
        r107.putString("use_md5", r101);
        r107.putString("use_path", r102);
        r107.putString("use_decompress_path", r103);
        r107.putString("use_version", r104);
        r107.putString("use_abi", r105);
        r107.putLong("use_size", r106);
        r107.putString("use_file_md5", r110);
        r107.apply();
    }
}
