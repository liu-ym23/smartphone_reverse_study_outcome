package wo7;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ug.sdk.yz.utils.ApkUtil;
import com.larus.nova.R;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static b f560527d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, String> f560528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f560529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f560530c;

    public b(Context r110) {
        this.f560528a = new HashMap();
        this.f560529b = r110;
        String r100 = r110.getPackageCodePath();
        HashMap r101 = null;
        RandomAccessFile r102 = null;
        if (TextUtils.isEmpty(r100) == true) goto L30;
        HashMap r103 = new HashMap();
        RandomAccessFile r104 = new RandomAccessFile(r100, "r");     // Catch: Throwable -> L24
        Iterator r105 = ((LinkedHashMap) ApkUtil.b(ApkUtil.a(r104.getChannel()).f272366a)).entrySet().iterator();     // Catch: Throwable -> L22
    L9:
        if (r105.hasNext() == false) goto L62;
        Map.Entry r106 = (Map.Entry) r105.next();     // Catch: Throwable -> L22
        if (r106 == null) goto L9;
        if (r106.getKey() == null) goto L9;
        if (((Integer) r106.getKey()).intValue() == 1896449818) goto L9;
        ByteBuffer r107 = (ByteBuffer) r106.getValue();     // Catch: Throwable -> L51
        byte[] r108 = r107.array();     // Catch: Throwable -> L51
        int r109 = r107.arrayOffset();     // Catch: Throwable -> L51
        String r111 = new String(Arrays.copyOfRange(r108, r107.position() + r109, r109 + r107.limit()));     // Catch: Throwable -> L51
        r103.put(r106.getKey(), r111);     // Catch: Throwable -> L51
    L62:
        r104.close();     // Catch: Throwable -> L52
    L29:
        r101 = r103;
    L22:
        th = th;
        r102 = r104;
    L60:
        th.printStackTrace();     // Catch: Throwable -> L47
        if (r102 == null) goto L29;
        r104 = r102;
    L47:
        th = move-exception;
        if (r102 != null) goto L64;
    L50:
        throw th;
    L64:
        r102.close();     // Catch: Throwable -> L53
    L24:
        th = th;
    L30:
        this.f560528a = r101;
        new Properties().load(this.f560529b.getApplicationContext().getAssets().open("ss.properties"));     // Catch: IOException -> L33
    L35:
        a r112 = new a();
        this.f560530c = r112;
        Context r113 = r110.getApplicationContext();
        JSONObject r114 = a(1903654774);
        if (r114 != null) goto L56;
        r114 = new JSONObject();
    L56:
        String r115 = r113.getString(R.string.yz_default_user_agreement_content);     // Catch: Exception -> L41
        String r116 = r113.getString(R.string.yz_default_user_agreement_extra_content);     // Catch: Exception -> L41
        String r117 = r113.getString(R.string.yz_default_user_agreement_title);     // Catch: Exception -> L41
        String r118 = r113.getString(R.string.yz_kindly_remind_content);     // Catch: Exception -> L41
        r114.optBoolean("close_weibo_sso", false);     // Catch: Exception -> L41
        r114.optBoolean("close_short_cut_create", false);     // Catch: Exception -> L41
        r114.optBoolean("show_check_box", false);     // Catch: Exception -> L41
        r114.optBoolean("show_push_confirm_dialog", false);     // Catch: Exception -> L41
        r112.f560525a = a.a(r114.optString("include_pushs", ""));     // Catch: Exception -> L41
        r112.b();     // Catch: Exception -> L41
        a.a(r114.optString("include_login_type", ""));     // Catch: Exception -> L41
        r112.f560526b = r114.optBoolean("exist_app_kill_process", true);     // Catch: Exception -> L41
        r114.optBoolean("disable_show_setting_notify", false);     // Catch: Exception -> L41
        r114.optString("user_agreement_content", r115);     // Catch: Exception -> L41
        r114.optString("user_agreement_extra_content", r116);     // Catch: Exception -> L41
        r114.optString(WsConstants.KEY_CHANNEL_TYPE, "");     // Catch: Exception -> L41
        r114.optString("brand_type", "");     // Catch: Exception -> L41
        r114.optString("user_agreement_title", r117);     // Catch: Exception -> L41
        r114.optBoolean("is_debug", false);     // Catch: Exception -> L41
        r114.optBoolean("is_change_icon", false);     // Catch: Exception -> L41
        r114.optString("user_agreement_type", "3");     // Catch: Exception -> L41
        r114.optString("persuade_stay_dlg_content", r118);     // Catch: Exception -> L41
        r114.optBoolean("is_need_show_persuade_dlg", true);     // Catch: Exception -> L41
    L44:
        if (a(1903654774) != null) goto L79;
        new JSONObject();
        return;
    L79:
        return;
    L41:
        e = move-exception;
        zo7.b.c("AppConfigManager", e.getMessage(), e);
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L35
    }

    public final JSONObject a(Integer r100) {
        Map<Integer, String> r101 = this.f560528a;
        if (r101 != null) goto L5;
    L15:
        return null;
    L5:
        if (r101.size() == 0) goto L15;
        if (this.f560528a.containsKey(r100) == true) goto L10;
        return null;
    L10:
        String r102 = this.f560528a.get(r100);
        if (TextUtils.isEmpty(r102) == false) goto L17;
        return null;
    L17:
        return new JSONObject(r102);
    }
}
