package i87;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.push.settings.ISettingsUpdateListener;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.push.settings.PushOnlineSettings;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f488677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f488678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f488679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f488680d;

    public final void a() {
        if (this.f488677a != null) goto L5;
        return;
    L5:
        String r100 = this.f488680d;
        com.bytedance.push.utils.f.b("UpdateSettingsTask", "[updatePushSettings]updateSource:" + r100);
        JSONObject r101 = this.f488677a;
        if (r101.has("sdk_key_PushSDK") == false) goto L8;
        r101 = this.f488677a.optJSONObject("sdk_key_PushSDK");
    L8:
        if (r101 != null) goto L15;
        com.bytedance.push.utils.f.e("UpdateSettingsTask", "can't find settings");
        if (com.bytedance.push.utils.f.f267065a == true) goto L13;
    L34:
        JSONObject r102 = this.f488677a;
        if (r102.has("sdk_key_alliance_sdk") == false) goto L37;
        r102 = this.f488677a.optJSONObject("sdk_key_alliance_sdk");
    L37:
        int r103 = 0;
        if (r102 != null) goto L45;
        com.bytedance.push.utils.f.e("UpdateSettingsTask", "can't find settings");
        if (com.bytedance.push.utils.f.f267065a == true) goto L43;
    L53:
        com.ss.android.pushmanager.setting.b r104 = com.ss.android.pushmanager.setting.b.b();
        Set<ISettingsUpdateListener> r105 = r104.f449566a;
        monitor-enter(r105);
        Object[] r106 = ((HashSet) r104.f449566a).toArray();     // Catch: Throwable -> L61
        monitor-exit(r105);     // Catch: Throwable -> L61
        int r107 = r106.length;
    L58:
        if (r103 >= r107) goto L60;
        ((ISettingsUpdateListener) r106[r103]).onSettingsUpdate();
        r103 = r103 + 1;
        goto L58
    L60:
        return;
    L61:
        th = move-exception;
        throw th;
    L43:
        throw new IllegalArgumentException("settings missing sdk_key_alliance_sdk");
    L45:
        if (this.f488679c == false) goto L52;
        Context r108 = this.f488678b;
        r102.put("alliance_sdk_enable_wakeup", false);     // Catch: JSONException -> L49
    L51:
        PushServiceManager.get().getIAllianceService().updateSettings(r108, r102);
    L49:
        e = move-exception;
        e.printStackTrace();
        goto L51
    L52:
        PushServiceManager.get().getIAllianceService().updateSettings(this.f488678b, r102);
        goto L53
    L13:
        throw new IllegalArgumentException("settings missing sdk_key_PushSDK");
    L15:
        if (TextUtils.equals(r100, "settings_source_sdk") == true) goto L21;
        Iterator<String> r109 = PushOnlineSettings.f267015a.iterator();
    L18:
        if (r109.hasNext() == false) goto L21;
        String r110 = r109.next();
        com.bytedance.push.utils.f.b("UpdateSettingsTask", "cur settings source is not UPDATE_SOURCE_SDK,remove " + r110);
        r101.remove(r110);
    L21:
        if (this.f488679c == false) goto L30;
        Context r111 = this.f488678b;
        JSONObject r112 = new JSONObject(r101.toString());     // Catch: JSONException -> L28
        r112.remove("ttpush_is_notify_service_stick");     // Catch: JSONException -> L28
        r112.remove("ttpush_allow_push_daemon_monitor");     // Catch: JSONException -> L28
        r112.remove("ttpush_is_close_alarm_wakeup");     // Catch: JSONException -> L28
        r112.remove("ttpush_allow_push_job_service");     // Catch: JSONException -> L28
        f r113 = new f(this, r111, r112);     // Catch: JSONException -> L28
        if (Looper.myLooper() != Looper.getMainLooper()) goto L26;
        ThreadPlus.submitRunnable(r113);     // Catch: JSONException -> L28
    L68:
        goto L34
    L26:
        r113.run();     // Catch: JSONException -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
        goto L34
    L30:
        f r114 = new f(this, this.f488678b, r101);
        if (Looper.myLooper() != Looper.getMainLooper()) goto L33;
        ThreadPlus.submitRunnable(r114);
        goto L34
    L33:
        r114.run();
        goto L34
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

    public g(Context r100, JSONObject r101, boolean r102, String r103) {
        this.f488678b = r100;
        this.f488677a = r101;
        this.f488679c = r102;
        this.f488680d = r103;
    }
}
