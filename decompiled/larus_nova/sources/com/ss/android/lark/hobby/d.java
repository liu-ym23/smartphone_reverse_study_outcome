package com.ss.android.lark.hobby;

import android.content.Context;
import android.os.Looper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.log.Log;
import java.io.File;
import java.util.Arrays;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f425860a = null;

        static {
            f425860a = new d();
        }
    }

    public d() {
    }

    public static String c(Context r100) {
        return r100.getFilesDir().getAbsolutePath() + File.separator + "hobby_offline_res";
    }

    public static String d(String r100) {
        return "ka_" + r100;
    }

    public static String b(Context r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        StringBuilder r103 = new StringBuilder();
        r103.append(r100.getFilesDir().getAbsolutePath());
        String r104 = File.separator;
        r103.append(r104);
        r103.append("hobby_ka_res");
        r102.append(r103.toString());
        r102.append(r104);
        r102.append(r101);
        return r102.toString();
    }

    public final void a(Context r100, final String r101) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        final Context r102 = r100.getApplicationContext();
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new c(this, r102, r101));
        return;
    L6:
        File[] r103 = new PolarisFileWrapper(b(r100, d(r101))).listFiles();
        if (r103 != null) goto L9;
        return;
    L9:
        if (r103.length <= 1) goto L17;
        Arrays.sort(r103);
        int r104 = 0;
    L13:
        if (r104 > (r103.length - 2)) goto L18;
        Log.i("HobbyResManager", "clearExpiredKaTaskRes, path: " + r103[r104].getAbsolutePath());
        FileUtils.f(r103[r104]);
        r104 = r104 + 1;
        goto L13
    L18:
        return;
    }
}
