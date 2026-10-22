package xoc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.larksuite.framework.utils.ApkUtil;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.PackageChannelManager;
import com.suite.lark.component.protocol.Biz;
import java.util.Locale;
import yob.e;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f564692a;

    /* JADX INFO: renamed from: xoc.a$a, reason: collision with other inner class name */
    public static class C8263a {
        public static String a(boolean r100) {
            if (r100 == false) goto L10;
            Log.i("UserAgentModule", "firstlyGetUserAgent return the mock ua.");
        L10:
            String r101 = Build.MODEL;     // Catch: Exception -> L7
            return String.format("Mozilla/5.0 (Linux; Android %s; %s Build/%s %s; wv) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.91 Mobile Safari/537.36", new Object[]{Build.VERSION.RELEASE, r101, Build.MANUFACTURER, r101});
        L7:
            e = move-exception;
            Log.e("UserAgentModule", e);
            return "Mozilla/5.0 (Linux; Android 7.0; FRD-AL00 Build/HUAWEIFRD-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.91 Mobile Safari/537.36";
        }
    }

    public static String a(Context r100) {
        Log.i("UserAgentModule", "will use normal ua");
        Log.i("UserAgentModule", "use new Strategy UA :" + f564692a);
        String r101 = "Feishu";
        if (TextUtils.isEmpty(f564692a) == true) goto L5;
        Log.i("UserAgentModule", "use new Strategy UA cache");
        String r102 = b(f564692a);
        f564692a = r102;
    L27:
        if (LarkAppContext.inst().buildConfig().isUsPackage() == false) goto L30;
        r101 = "Lark";
    L30:
        if (LarkAppContext.inst().buildConfig().isMempopeApp() == false) goto L36;
        if (r102.contains("mempope") == true) goto L34;
        r102 = r102.concat(" mempope");
        Log.d("UserAgentModule", "add mempope to ua, ua is: " + r102);
    L34:
        r101 = "Mempope";
    L36:
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == true) goto L38;
    L41:
        String r103 = r102 + " appid/482431; appname/" + r101 + i.f25853b;
        Log.d("UserAgentModule", "add appid and appname to ua, ua is: " + r103);
        if (TextUtils.isEmpty(null) == false) goto L44;
        return r103;
    L44:
        if (r103.contains(null) == true) goto L48;
        Log.i("UserAgentModule", "start appendUA to finalUserAgent");
        String r104 = r103.concat(" null");
        Log.i("UserAgentModule", "finalUA :" + r104);
        return r104;
    L48:
        return r103;
    L38:
        if (r102.contains("doubao") == true) goto L40;
        r102 = r102.concat(" doubao");
        Log.d("UserAgentModule", "add doubao to ua, ua is: " + r102);
    L40:
        r101 = "Doubao";
        goto L41
    L5:
        String r105 = LarkKVStorage.j(Biz.Core, true).getString("key_user_agent", "");
        if (TextUtils.isEmpty(r105) == false) goto L8;
        r105 = C8263a.a(true);
        Log.i("UserAgentModule", "mock ua:" + r105);
    L8:
        Log.i("UserAgentModule", "getUserAgent:" + r105);
        if (TextUtils.isEmpty(r105) == false) goto L11;
        Log.i("UserAgentModule", "inter ua is empty,use mocked_user_agent{NewStrategy}");
        r105 = "Mozilla/5.0 (Linux; Android 7.0; FRD-AL00 Build/HUAWEIFRD-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.91 Mobile Safari/537.36";
    L11:
        String r106 = ApkUtil.getAppVersionName(r100);
        StringBuilder r107 = new StringBuilder();
        r107.append(r105);
        r107.append(" ");
        if (TextUtils.isEmpty(null) == false) goto L14;
        String r108 = "Lark";
    L15:
        r107.append(r108);
        r107.append(HTTP.URL_DEFAULT);
        r107.append(r106);
        String r109 = b(r107.toString());
        if (r109.contains("ChannelName/") == false) goto L19;
        Log.e("UserAgentModule", "channel name is append,return");
        r102 = r109;
    L25:
        f564692a = r102;
        goto L27
    L19:
        if (PackageChannelManager.getDeployMode(r100) == 1) goto L21;
    L23:
        String r110 = "Feishu";
    L24:
        r102 = r109 + " ChannelName/" + r110;
        goto L25
    L21:
        if (LarkAppContext.inst().buildConfig().isUsPackage() == false) goto L23;
        r110 = "Lark";
        goto L24
    L14:
        r108 = null;
        goto L15
    }

    public static String b(String r100) {
        e.a().getClass();
        int r101 = com.ss.android.lark.language.service.impl.a.f431092f;
        Locale r102 = com.ss.android.lark.language.service.impl.a.b.f431098a.getLanguageSetting();
        if (TextUtils.isEmpty(r100) == true) goto L19;
        if (r102 == null) goto L19;
        String r103 = r102.getLanguage().toLowerCase() + "_" + r102.getCountry().toUpperCase();
        if ("in_ID".equals(r103) == false) goto L9;
        r103 = "id_ID";
    L9:
        Log.i("UserAgentModule", "UA locale param is: " + r103);
        if (r100.contains("LarkLocale/" + r103) == false) goto L12;
        return r100;
    L12:
        if (r100.contains("LarkLocale/") == false) goto L18;
        int r104 = r100.indexOf("LarkLocale/");
        int r105 = r100.indexOf(" ", r104);
        int r106 = r104 + 11;
        if (r105 != (-1)) goto L16;
        String r107 = r100.substring(r106);
    L17:
        String r108 = r100.replace(r107, r103);
        Log.i("UserAgentModule", "UA has replaced the locale, the old locale is: " + r107);
        return r108;
    L16:
        r107 = r100.substring(r106, r105);
        goto L17
    L18:
        String r109 = r100 + " LarkLocale/" + r103;
        Log.i("UserAgentModule", "UA has been added locale param directly");
        return r109;
    L19:
        Log.i("UserAgentModule", "TextUtils.isEmpty(larkUserAgent) || locale == null");
        return r100;
    }
}
