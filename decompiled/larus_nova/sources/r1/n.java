package r1;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.sva.sdk.controller.Global;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes39.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PolarisFileWrapper f535575a;

    public static class a implements Runnable {
        public a() {
        }

        public static void a() {
            if (com.apm.lite.k.a.h(com.apm.lite.e.f29909a) == false) goto L16;
            PolarisFileWrapper r100 = new PolarisFileWrapper(com.apm.lite.k.n.g(com.apm.lite.e.f29909a), "apmlite/ProcessTrack/");
            String[] r101 = r100.list();
            if (r101 != null) goto L9;
            return;
        L9:
            if (r101.length <= 25) goto L14;
            Arrays.sort(r101);
            int r102 = 0;
        L12:
            if (r102 >= (r101.length - 25)) goto L18;
            com.apm.lite.k.h.k(new PolarisFileWrapper(r100, r101[r102]));
            r102 = r102 + 1;
            goto L12
        L18:
            return;
        L14:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f535576a;

        public b(String r100) {
            String[] r101 = r100.split("\\s+");
            if (r101.length != 3) goto L9;
            String r102 = r101[0];
            this.f535576a = r101[1];
            CastLongProtector.parseLong(r101[2]);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            com.apm.lite.c.a();
            new RuntimeException("err ProcessTrack line:".concat(r100), th);
            return;
        L9:
            com.apm.lite.c.a();
            new RuntimeException("err ProcessTrack line:".concat(r100));
        }
    }

    public static void c(String r100, String r101) {
        File r102 = d();     // Catch: Throwable -> L6
        if (r102 == null) goto L9;
        com.apm.lite.k.h.h(r102, r100 + ' ' + r101 + ' ' + System.currentTimeMillis() + '\n', true);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static File d() {
        if (f535575a != null) goto L10;
        Context r100 = com.apm.lite.e.f29909a;
        String r101 = com.apm.lite.k.a.i();
        if (r101 != null) goto L8;
        return null;
    L8:
        long r102 = System.currentTimeMillis();
        f535575a = new PolarisFileWrapper(com.apm.lite.k.n.g(com.apm.lite.e.f29909a), "apmlite/ProcessTrack/" + ((r102 - (r102 % 86400000)) / 86400000) + '/' + r101.replace(':', '_') + Global.SUFFIX_TXT_FILE);
        m.a().b(new a(), 15000);
    L10:
        return f535575a;
    }

    public static PolarisFileWrapper a(long r100) {
        return new PolarisFileWrapper(com.apm.lite.k.n.g(com.apm.lite.e.f29909a), "apmlite/ProcessTrack/" + ((r100 - (r100 % 86400000)) / 86400000));
    }

    public static HashMap b(long r110) {
        PolarisFileWrapper r100 = new PolarisFileWrapper(com.apm.lite.k.n.g(com.apm.lite.e.f29909a), "apmlite/ProcessTrack/" + ((r110 - (r110 % 86400000)) / 86400000));
        String[] r111 = r100.list();
        HashMap r112 = new HashMap();
        if (r111 == null) goto L20;
        int r101 = r111.length;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L20;
        String r103 = r111[r102];
        PolarisFileWrapper r104 = new PolarisFileWrapper(r100, r103);
        long r105 = r104.length();
        if (r105 <= 1048576) goto L9;
        long r106 = r105 - PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
    L22:
        JSONArray r107 = com.apm.lite.k.h.d(r104, r106);     // Catch: IOException -> L21
        int r108 = r107.length();     // Catch: IOException -> L21
    L11:
        r108 = r108 - 1;     // Catch: IOException -> L21
        if (r108 < 0) goto L19;
        String r109 = r107.optString(r108);     // Catch: IOException -> L21
        if (TextUtils.isEmpty(r109) == true) goto L11;
        if (r109.startsWith("anr_trace") == false) goto L11;
        r112.put(r103.replace('_', ':').replace(Global.SUFFIX_TXT_FILE, ""), new b(r109));     // Catch: IOException -> L21
    L19:
        r102 = r102 + 1;
        goto L5
    L9:
        r106 = 0;
    L20:
        return r112;
    }
}
