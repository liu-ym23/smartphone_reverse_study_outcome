package com.tencent.qqmusic.third.api.contract;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public class CommonCmd {
    public static final String AIDL_PLATFORM_TYPE_CAR = "car";
    public static final String AIDL_PLATFORM_TYPE_PAD = "pad";
    public static final String AIDL_PLATFORM_TYPE_PHONE = "phone";
    public static final String AIDL_PLATFORM_TYPE_TV = "tv";
    public static final String AIDL_PLATFORM_TYPE_TV_FOR_THIRD = "tvForThird";
    public static final int SDK_VERSION = 10000;
    public static String platform = "phone";

    public final class RPCAction {
        public static final int RPC_ACTION_ONLY_START_PROCESS = 0;
        public static final int RPC_ACTION_START_AND_VERIFY = 1;
        final /* synthetic */ CommonCmd this$0;

        public RPCAction(CommonCmd r100) {
            this.this$0 = r100;
        }
    }

    public final class RPCRequest {
        public static final String RPC_REQUEST_LOGIN = "login";
        public static final String RPC_REQUEST_PARAMS_NEED_VERIFY_AFTER_LOGIN = "needVerifyAfterLogin";
        public static final String RPC_REQUEST_START_QQMUSIC_PROCESS = "start";
        public static final String RPC_REQUEST_VERIFY_CALLER_IDENTITY = "start";
        final /* synthetic */ CommonCmd this$0;

        public RPCRequest(CommonCmd r100) {
            this.this$0 = r100;
        }
    }

    public CommonCmd() {
    }

    private static String getPlatformPackageName() {
        String r100 = platform;
        r100.getClass();
        byte r101 = -1;
        switch(r100.hashCode()) {
            case 3714: goto L22;
            case 98260: goto L18;
            case 110739: goto L14;
            case 106642798: goto L10;
            case 663842496: goto L6;
            default: goto L25;
        };
    L25:
        switch(r101) {
            case 0: goto L31;
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            default: goto L26;
        };
    L26:
        return "";
    L27:
        return "com.tencent.musictvForthird";
    L28:
        return "com.tencent.qqmusic";
    L29:
        return "com.tencent.qqmusicpad";
    L30:
        return "com.tencent.qqmusiccar";
    L31:
        return "com.tencent.qqmusictv";
    L6:
        if (r100.equals(AIDL_PLATFORM_TYPE_TV_FOR_THIRD) == false) goto L25;
        r101 = 4;
        goto L25
    L10:
        if (r100.equals("phone") == false) goto L25;
        r101 = 3;
        goto L25
    L14:
        if (r100.equals(AIDL_PLATFORM_TYPE_PAD) == false) goto L25;
        r101 = 2;
        goto L25
    L18:
        if (r100.equals(AIDL_PLATFORM_TYPE_CAR) == false) goto L25;
        r101 = 1;
        goto L25
    L22:
        if (r100.equals(AIDL_PLATFORM_TYPE_TV) == false) goto L25;
        r101 = 0;
        goto L25
    }

    private static String getPlatformScheme() {
        String r100 = platform;
        r100.getClass();
        byte r101 = -1;
        switch(r100.hashCode()) {
            case 3714: goto L22;
            case 98260: goto L18;
            case 110739: goto L14;
            case 106642798: goto L10;
            case 663842496: goto L6;
            default: goto L25;
        };
    L25:
        switch(r101) {
            case 0: goto L31;
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            default: goto L26;
        };
    L26:
        return "";
    L27:
        return "musictvForthird";
    L28:
        return "qqmusic";
    L29:
        return "qqmusicpad";
    L30:
        return "qqmusiccar";
    L31:
        return "musictv";
    L6:
        if (r100.equals(AIDL_PLATFORM_TYPE_TV_FOR_THIRD) == false) goto L25;
        r101 = 4;
        goto L25
    L10:
        if (r100.equals("phone") == false) goto L25;
        r101 = 3;
        goto L25
    L14:
        if (r100.equals(AIDL_PLATFORM_TYPE_PAD) == false) goto L25;
        r101 = 2;
        goto L25
    L18:
        if (r100.equals(AIDL_PLATFORM_TYPE_CAR) == false) goto L25;
        r101 = 1;
        goto L25
    L22:
        if (r100.equals(AIDL_PLATFORM_TYPE_TV) == false) goto L25;
        r101 = 0;
        goto L25
    }

    public static void init(String r100) {
        platform = r100;
    }

    public static Bundle action(Context r100, Bundle r101) {
        Bundle r102 = new Bundle();
        if (r100 == null) goto L7;
        if (r101 == null) goto L7;
        sendSchema(r100, r101);     // Catch: Exception -> L9
        r102.putInt("code", 0);     // Catch: Exception -> L9
    L11:
        return r102;
    L7:
        r102.putInt("code", 4);     // Catch: Exception -> L9
        r102.putString("error", "context is null");     // Catch: Exception -> L9
        return r102;
    L9:
        e = move-exception;
        r102.putInt("code", 1);
        r102.putString("error", "UnKnow Exception " + e.getMessage());
        goto L11
    }

    public static boolean bindQQMusicApiService(Context r100, ServiceConnection r101) {
        return bindQQMusicApiService(r100, "", r101);
    }

    public static final Bundle openQQMusic(Context r100, String r101) {
        Bundle r102 = new Bundle();
        if (r100 == null) goto L5;
        sendSchema(r100, URLEncoder.encode("{\"cmd\":\"open\",\"callbackurl\": \"" + r101 + "\"}", XML.CHARSET_UTF8));     // Catch: Exception -> L9
        r102.putInt("code", 0);     // Catch: Exception -> L9
    L11:
        return r102;
    L5:
        r102.putInt("code", 4);     // Catch: Exception -> L9
        r102.putString("error", "context is null");     // Catch: Exception -> L9
        return r102;
    L9:
        e = move-exception;
        r102.putInt("code", 1);
        r102.putString("error", "UnKnow Exception " + e.getMessage());
        goto L11
    }

    private static final void sendActiveSchema(Context r100, String r101) {
        String r102 = String.format("qqmusicactive://qq.com/aidl?p=%s", new Object[]{r101});
        if (platform.equals(AIDL_PLATFORM_TYPE_TV_FOR_THIRD) == false) goto L5;
        r102 = String.format("qqmusicactiveForthird://qq.com/aidl?p=%s", new Object[]{r101});
    L5:
        Intent r103 = new Intent();
        r103.addFlags(268435456);
        r103.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        r103.setData(UriProtector.parse(r102));
        String r104 = getPlatformPackageName();
        if (TextUtils.isEmpty(r104) == true) goto L8;
        r103.setPackage(r104);
    L8:
        r100.startActivity(r103);
    }

    private static void sendSchema(Context r100, Bundle r101) throws UnsupportedEncodingException {
        String r102 = getPlatformScheme();
        if (TextUtils.isEmpty(r102) == false) goto L5;
        return;
    L5:
        String r103 = String.format("%s://?", new Object[]{r102});
        StringBuilder r104 = new StringBuilder();
        r104.append(r103);
        if (r101.containsKey("action") == false) goto L9;
        r104.append("action=" + r101.getInt("action"));
    L9:
        if (r101.containsKey(Keys.API_PARAM_KEY_PULL_FROM) == false) goto L12;
        r104.append("&pull_from=" + r101.getLong(Keys.API_PARAM_KEY_PULL_FROM));
    L12:
        if (r101.containsKey(Keys.API_PARAM_KEY_SEARCH_KEY) == false) goto L15;
        r104.append("&search_key=" + URLEncoder.encode(r101.getString(Keys.API_PARAM_KEY_SEARCH_KEY), XML.CHARSET_UTF8));
    L15:
        if (r101.containsKey(Keys.API_PARAM_KEY_M0) == false) goto L18;
        r104.append("&m0=" + r101.getLong(Keys.API_PARAM_KEY_M0));
    L18:
        if (r101.containsKey(Keys.API_PARAM_KEY_M1) == false) goto L21;
        r104.append("&m1=" + r101.getBoolean(Keys.API_PARAM_KEY_M1));
    L21:
        if (r101.containsKey(Keys.API_PARAM_KEY_MB) == false) goto L24;
        r104.append("&mb=" + r101.getBoolean(Keys.API_PARAM_KEY_MB));
    L24:
        if (r101.containsKey(Keys.API_PARAM_KEY_M2) == false) goto L26;
        r104.append("&m2=" + r101.getBoolean(Keys.API_PARAM_KEY_M2));
    L26:
        Intent r105 = new Intent();
        r105.addFlags(268435456);
        r105.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        r105.setData(UriProtector.parse(r104.toString()));
        String r106 = getPlatformPackageName();
        if (TextUtils.isEmpty(r106) == true) goto L29;
        r105.setPackage(r106);
    L29:
        r100.startActivity(r105);
    }

    private static void sendSchema(Context r100, String r101) {
        String r102 = getPlatformScheme();
        if (TextUtils.isEmpty(r102) == false) goto L5;
        return;
    L5:
        String r103 = String.format("%s://qq.com/other/aidl?p=%s", new Object[]{r102, r101});
        Intent r104 = new Intent();
        r104.addFlags(268435456);
        r104.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        String r105 = getPlatformPackageName();
        if (TextUtils.isEmpty(r105) == true) goto L8;
        r104.setPackage(r105);
    L8:
        r104.setData(UriProtector.parse(r103));
        r100.startActivity(r104);
    }

    public static boolean bindQQMusicApiService(Context r100, String r101, ServiceConnection r102) {
        String r103 = platform;
        r103.getClass();
        byte r104 = -1;
        switch(r103.hashCode()) {
            case 3714: goto L18;
            case 98260: goto L14;
            case 106642798: goto L10;
            case 663842496: goto L6;
            default: goto L21;
        };
    L21:
        switch(r104) {
            case 0: goto L26;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            default: goto L22;
        };
    L22:
        return false;
    L23:
        Intent r105 = new Intent("com.tencent.qqmusicthird.third.api.QQMusicApiService");
    L27:
        String r106 = getPlatformPackageName();
        if (TextUtils.isEmpty(r106) == true) goto L31;
        r105.setPackage(r106);
    L31:
        if (TextUtils.isEmpty(r101) == true) goto L34;
        r105.putExtra("packageName", r101);
    L34:
        return r100.bindService(r105, r102, 1);
    L24:
        r105 = new Intent("com.tencent.qqmusic.third.api.QQMusicApiService");
        goto L27
    L25:
        r105 = new Intent("com.tencent.qqmusiccar.third.api.QQMusicApiService");
        goto L27
    L26:
        r105 = new Intent("com.tencent.qqmusictv.third.api.QQMusicApiService");
        goto L27
    L6:
        if (r103.equals(AIDL_PLATFORM_TYPE_TV_FOR_THIRD) == false) goto L21;
        r104 = 3;
        goto L21
    L10:
        if (r103.equals("phone") == false) goto L21;
        r104 = 2;
        goto L21
    L14:
        if (r103.equals(AIDL_PLATFORM_TYPE_CAR) == false) goto L21;
        r104 = 1;
        goto L21
    L18:
        if (r103.equals(AIDL_PLATFORM_TYPE_TV) == false) goto L21;
        r104 = 0;
        goto L21
    }

    public static int startQQMusicProcess(Context r100, String r101, String r102) {
    L8:
        e = move-exception;
        e.printStackTrace();
        return -1;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return -1;
    L6:
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L8
        r103.put("cmd", "start");     // Catch: Exception -> L8
        r103.put("action", 0);     // Catch: Exception -> L8
        r103.put("appId", r102);     // Catch: Exception -> L8
        r103.put("packageName", r101);     // Catch: Exception -> L8
        sendActiveSchema(r100, URLEncoder.encode(r103.toString(), XML.CHARSET_UTF8));     // Catch: Exception -> L8
        return 0;
    }

    public static Bundle loginQQMusic(Context r100, String r101, String r102, String r103) {
        return loginQQMusic(r100, r101, r102, "", false, r103);
    }

    public static final int startProcessAndAuthForPrivacy(Context r100, String r101, String r102, String r103, String r104) {
    L13:
        e = move-exception;
        e.printStackTrace();
        return -1;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L6;
    L12:
        return -1;
    L6:
        if (TextUtils.isEmpty(r102) == true) goto L12;
        if (TextUtils.isEmpty(r103) == true) goto L12;
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L13
        r105.put("cmd", "start");     // Catch: Exception -> L13
        r105.put("action", 0);     // Catch: Exception -> L13
        r105.put("appId", r101);     // Catch: Exception -> L13
        r105.put("packageName", r102);     // Catch: Exception -> L13
        r105.put("callbackurl", r104);     // Catch: Exception -> L13
        r105.put(Keys.API_RETURN_KEY_ENCRYPT_STRING, r103);     // Catch: Exception -> L13
        sendActiveSchema(r100, URLEncoder.encode(r105.toString(), XML.CHARSET_UTF8));     // Catch: Exception -> L13
        return 0;
    }

    public static final int verifyCallerIdentity(Context r100, String r101, String r102, String r103, String r104) {
    L13:
        e = move-exception;
        e.printStackTrace();
        return -1;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L6;
    L12:
        return -1;
    L6:
        if (TextUtils.isEmpty(r102) == true) goto L12;
        if (TextUtils.isEmpty(r103) == true) goto L12;
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L13
        r105.put("cmd", "start");     // Catch: Exception -> L13
        r105.put("action", 1);     // Catch: Exception -> L13
        r105.put("appId", r101);     // Catch: Exception -> L13
        r105.put("packageName", r102);     // Catch: Exception -> L13
        r105.put("callbackurl", r104);     // Catch: Exception -> L13
        r105.put(Keys.API_RETURN_KEY_ENCRYPT_STRING, r103);     // Catch: Exception -> L13
        sendSchema(r100, URLEncoder.encode(r105.toString(), XML.CHARSET_UTF8));     // Catch: Exception -> L13
        return 0;
    }

    public static Bundle loginQQMusic(Context r100, String r101, String r102, String r103, boolean r110, String r111) {
        Bundle r104 = new Bundle();
        if (r100 == null) goto L5;
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L9
        r105.put("cmd", "login");     // Catch: Exception -> L9
        r105.put("packageName", r101);     // Catch: Exception -> L9
        r105.put("appId", r102);     // Catch: Exception -> L9
        r105.put(Keys.API_RETURN_KEY_ENCRYPT_STRING, r103);     // Catch: Exception -> L9
        r105.put(RPCRequest.RPC_REQUEST_PARAMS_NEED_VERIFY_AFTER_LOGIN, r110);     // Catch: Exception -> L9
        r105.put("callbackurl", r111);     // Catch: Exception -> L9
        sendSchema(r100, URLEncoder.encode(r105.toString(), XML.CHARSET_UTF8));     // Catch: Exception -> L9
        r104.putInt("code", 0);     // Catch: Exception -> L9
    L11:
        return r104;
    L5:
        r104.putInt("code", 4);     // Catch: Exception -> L9
        r104.putString("error", "context is null");     // Catch: Exception -> L9
        return r104;
    L9:
        e = move-exception;
        r104.putInt("code", 1);
        r104.putString("error", "UnKnow Exception " + e.getMessage());
        goto L11
    }
}
