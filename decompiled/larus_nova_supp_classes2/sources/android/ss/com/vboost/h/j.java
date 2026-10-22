package android.ss.com.vboost.h;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.ss.com.vboost.utils.LogUtil;
import androidx.compose.material3.MenuKt;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TimerTask;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f105a = "j";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Vibrator f106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f107c;

    public static class a extends TimerTask {
        public a() {
        }

        public void android_ss_com_vboost_h_j$a__run$___twin___() {
            j.a().cancel();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            android_ss_com_vboost_h_j$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void android_ss_com_vboost_h_j$a_com_larus_apm_impl_protector_RunnableLancet_run(a r1) {
            r1.android_ss_com_vboost_h_j$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class b extends TimerTask {
        public b() {
        }

        public void android_ss_com_vboost_h_j$b__run$___twin___() {
            j.a().cancel();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            android_ss_com_vboost_h_j$b_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void android_ss_com_vboost_h_j$b_com_larus_apm_impl_protector_RunnableLancet_run(b r1) {
            r1.android_ss_com_vboost_h_j$b__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class c extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f109b;

        public c(float r1, float r2) {
            this.f108a = r1;
            this.f109b = r2;
        }

        public void android_ss_com_vboost_h_j$c__run$___twin___() {
            if (j.b() == true) goto L6;
            j.a(this.f108a, this.f109b);
            return;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            android_ss_com_vboost_h_j$c_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void android_ss_com_vboost_h_j$c_com_larus_apm_impl_protector_RunnableLancet_run(c r1) {
            r1.android_ss_com_vboost_h_j$c__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class d extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f111b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f112c;

        public d(float r1, float r2, float r3) {
            this.f110a = r1;
            this.f111b = r2;
            this.f112c = r3;
        }

        public void android_ss_com_vboost_h_j$d__run$___twin___() {
            if (j.b() == true) goto L6;
            j.a(this.f110a, this.f111b, this.f112c);
            return;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            android_ss_com_vboost_h_j$d_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void android_ss_com_vboost_h_j$d_com_larus_apm_impl_protector_RunnableLancet_run(d r1) {
            r1.android_ss_com_vboost_h_j$d__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static /* synthetic */ Vibrator a() {
        return f106b;
    }

    public static void a(float r6, float r7) {
        if (f106b != null) goto L6;
        LogUtil.error(f105a, "Vibrator is null !");
        return;
    L6:
        int r8 = Build.VERSION.SDK_INT;
        if (r8 < 26) goto L16;
        int r9 = (int) (255.0f * r6);
        long r2 = (long) (r6 * 300.0f);
        if (r9 >= 1) goto L12;
        return;
    L12:
        if (r9 <= 255) goto L14;
        r9 = 255;
    L14:
        f106b.vibrate(VibrationEffect.createOneShot(r2, r9));
        return;
    L16:
        if (r8 < 24) goto L20;
        long r4 = (long) (r6 * 90.0f);
        f106b.vibrate(new long[]{5, r4, 5, r4}, 2);
        new PthreadTimer("om/vboost/h/j").schedule(new a(), 300);
        return;
    }

    public static void a(float r6, float r7, float r8) {
        if (f106b != null) goto L6;
        LogUtil.error(f105a, "Vibrator is null  !");
        return;
    L6:
        int r9 = (int) r8;
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 26) goto L16;
        int r11 = (int) (r6 * 255.0f);
        if (r11 >= 1) goto L12;
        return;
    L12:
        if (r11 <= 255) goto L14;
        r11 = 255;
    L14:
        f106b.vibrate(VibrationEffect.createOneShot(r9, r11));
        return;
    L16:
        if (r10 < 24) goto L20;
        long r4 = (long) (r6 * 90.0f);
        f106b.vibrate(new long[]{5, r4, 5, r4}, 2);
        new PthreadTimer("om/vboost/h/j").schedule(new b(), r9);
        return;
    }

    public static void a(String r14) {
        String r1 = f105a;
        LogUtil.debug(r1, "play a Json file Pattern");
        if (f106b != null) goto L58;
        LogUtil.error(r1, "not register yet !");
        return;
    L58:
        String r15 = b(r14);     // Catch: JSONException -> L55
        if (r15 == null) goto L53;
        LogUtil.debug(r1, "start to parse json file");     // Catch: JSONException -> L55
        JSONArray r16 = JSONObjectProtectorUtils.getJSONArray(new JSONObject(r15), "Pattern");     // Catch: JSONException -> L55
        f107c = false;     // Catch: JSONException -> L55
        int r2 = 0;
    L10:
        if (r2 >= r16.length()) goto L69;
        if (JSONArrayProtectorUtils.getJSONObject(r16, r2).optString("Event").equals("") == true) goto L52;
        long r3 = (long) (JSONObjectProtectorUtils.getDouble(JSONObjectProtectorUtils.getJSONObject(JSONArrayProtectorUtils.getJSONObject(r16, r2), "Event"), "Time") * 1000.0d);     // Catch: JSONException -> L55
        JSONArray r5 = JSONObjectProtectorUtils.getJSONArray(JSONObjectProtectorUtils.getJSONObject(JSONArrayProtectorUtils.getJSONObject(r16, r2), "Event"), "EventParameters");     // Catch: JSONException -> L55
        float r6 = MenuKt.ClosedAlphaTarget;
        float r7 = MenuKt.ClosedAlphaTarget;
        int r8 = 0;
    L15:
        byte r10 = -1;
        if (r8 >= r5.length()) goto L35;
        String r9 = JSONObjectProtectorUtils.getString(JSONArrayProtectorUtils.getJSONObject(r5, r8), "ParameterID");     // Catch: JSONException -> L55
        int r12 = r9.hashCode();     // Catch: JSONException -> L55
        if (r12 == (-805677252)) goto L26;
        if (r12 == 1418859594) goto L23;
    L29:
        if (r10 == 0) goto L33;
        if (r10 != 1) goto L34;
        r6 = (float) JSONObjectProtectorUtils.getDouble(JSONArrayProtectorUtils.getJSONObject(r5, r8), "ParameterValue");     // Catch: JSONException -> L55
    L34:
        r8 = r8 + 1;     // Catch: JSONException -> L55
        goto L15
    L33:
        r7 = (float) JSONObjectProtectorUtils.getDouble(JSONArrayProtectorUtils.getJSONObject(r5, r8), "ParameterValue");     // Catch: JSONException -> L55
        goto L34
    L23:
        if (r9.equals("HapticSharpness") == false) goto L29;
        r10 = 0;
        goto L29
    L26:
        if (r9.equals("HapticIntensity") == false) goto L29;
        r10 = 1;
        goto L29
    L35:
        String r11 = JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(JSONArrayProtectorUtils.getJSONObject(r16, r2), "Event"), "EventType");     // Catch: JSONException -> L55
        int r13 = r11.hashCode();     // Catch: JSONException -> L55
        if (r13 == (-1421249242)) goto L44;
        if (r13 == (-252255853)) goto L41;
    L47:
        if (r10 == 0) goto L51;
        if (r10 != 1) goto L52;
        double r17 = JSONObjectProtectorUtils.getDouble(JSONObjectProtectorUtils.getJSONObject(JSONArrayProtectorUtils.getJSONObject(r16, r2), "Event"), "EventDuration");     // Catch: JSONException -> L55
        new PthreadTimer("om/vboost/h/j").schedule(new d(r6, r7, ((float) r17) * 1000.0f), r3);     // Catch: JSONException -> L55
        goto L52
    L51:
        new PthreadTimer("om/vboost/h/j").schedule(new c(r6, r7), r3);     // Catch: JSONException -> L55
        goto L52
    L41:
        if (r11.equals("HapticTransient") == false) goto L47;
        r10 = 0;
        goto L47
    L44:
        if (r11.equals("HapticContinuous") == false) goto L47;
        r10 = 1;
    L52:
        r2 = r2 + 1;     // Catch: JSONException -> L55
        goto L10
    L69:
        return;
    L53:
        LogUtil.error(r1, "read json data null,please check permisson or file path!");     // Catch: JSONException -> L55
        return;
    L55:
        e = move-exception;
        e.printStackTrace();
    }

    public static boolean a(Context r3) {
        if (Build.VERSION.SDK_INT >= 24) goto L7;
        String r4 = f105a;
        String r0 = "device sdk is below BuildVersion, not support vibrator!";
    L5:
        LogUtil.error(r4, r0);
        return false;
    L7:
        Vibrator r5 = (Vibrator) r3.getSystemService("vibrator");
        f106b = r5;
        if (r5 != null) goto L10;
        r4 = f105a;
        r0 = "get VIBRATOR_SERVICE fail!";
        goto L5
    L10:
        boolean r6 = r5.hasVibrator();
        if (r6 == true) goto L13;
        LogUtil.error(f105a, "detect not has vibrator !");
        f106b = null;
    L13:
        return r6;
    }

    private static String b(String r4) {
        File r0 = new File(r4);     // Catch: IOException -> L8
        FileReader r5 = new FileReader(r0);     // Catch: IOException -> L8
        InputStreamReader r1 = new InputStreamReader(new FileInputStream(r0), "utf-8");     // Catch: IOException -> L8
        StringBuffer r2 = new StringBuffer();     // Catch: IOException -> L8
    L3:
        int r3 = r1.read();     // Catch: IOException -> L8
        if (r3 == (-1)) goto L6;
        r2.append((char) r3);     // Catch: IOException -> L8
        goto L3
    L6:
        r5.close();     // Catch: IOException -> L8
        r1.close();     // Catch: IOException -> L8
        return r2.toString();
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static /* synthetic */ boolean b() {
        return f107c;
    }

    public static void c() {
        if (f106b == null) goto L6;
        f106b = null;
        return;
    }

    public static void d() {
        String r0 = f105a;
        LogUtil.debug(r0, "stop Haptic immediately");
        Vibrator r1 = f106b;
        if (r1 != null) goto L6;
        LogUtil.error(r0, "Vibrator is null !");
        return;
    L6:
        f107c = true;
        r1.cancel();
    }
}
