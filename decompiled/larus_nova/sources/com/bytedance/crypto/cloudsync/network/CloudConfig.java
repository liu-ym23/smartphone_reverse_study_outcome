package com.bytedance.crypto.cloudsync.network;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.crypto.network.NetworkConfig;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public class CloudConfig {
    private static final String GET_SYNC_KEY_URL = "https://ocean-secret.oceancloudapi.com/api/user/getSyncKeyV2";
    private static final String GET_SYNC_KEY_URL_BOE = "http://ocean-secret-boe.bytedance.net/api/user/getSyncKeyV2";
    private static final String GET_SYNC_KEY_URL_BOE_LEGACY = "http://ocean-secret-boe.bytedance.net/api/user/getSyncKey";
    private static final String GET_SYNC_KEY_URL_LEGACY = "https://ocean-secret.oceancloudapi.com/api/user/getSyncKey";
    private static final String JSON_TAG_APPS = "apps";
    private static final String JSON_TAG_APP_ID = "appid";
    private static final String JSON_TAG_CONTENT = "content";
    private static final String JSON_TAG_PACKAGE = "package";
    private static final String JSON_TAG_SIGNATURE = "signature";
    private static final String JSON_TAG_VERSION = "version";
    private static final int MAX_SIGNATURE_SIZE = 2048;
    private static final int MAX_VERIFY_SRC_DATA_SIZE = 1048576;
    public static final String REQUEST_TYPE_POST = "POST";
    public static final String ROOT_NAME_CLOUD_SYNC = "OCEAN_CLOUD_SYNC";
    private static final String SIGN_PUBLIC_KEY = "3059301306072a8648ce3d020106082a8648ce3d030107034200042a37535f0898cd6bc1d58eeeb0d76f980ce18b144b171f8ed83bf05b0f9df32abe408f1c4d783933d18c18ff65234817bff4cae61374468923424e3face1938b";
    private static final String TAG = "CloudConfig";
    public static final String WHITE_LIST_FILE_NAME = "cloud_sync_white_list.xml";
    private static volatile CloudConfig cloudConfig;
    private static final HashMap<String, String> localAppMap = null;
    private Vector<WhiteListApp> cloudAppList;
    private Context mContext;

    public static class WhiteListApp {
        private String appId;
        private String pkgName;

        public WhiteListApp(String r100, String r101) {
            this.pkgName = r100;
            this.appId = r101;
        }

        public String getAppId() {
            return this.appId;
        }

        public String getPackageName() {
            return this.pkgName;
        }
    }

    static {
        localAppMap = new AnonymousClass1();
    }

    public CloudConfig() {
        this.cloudAppList = new Vector();
    }

    private boolean checkVersionUpdate(String r100, String r101) {
        if (new PolarisFileWrapper(r100).exists() == true) goto L7;
        LogUtils.d(TAG, "cloud_sync_white_list file not exist!! need update file.");
        return true;
    L7:
        if (getWhiteListFileVersion(r100) < getWhiteListDataVersion(r101)) goto L11;
        return false;
    L11:
        return true;
    }

    public static String getGetSyncKeyUrl() {
        if (NetworkConfig.getInstance().isBoeEnv() == false) goto L6;
        return GET_SYNC_KEY_URL_BOE;
    L6:
        return GET_SYNC_KEY_URL;
    }

    public static String getGetSyncKeyUrlLegacy() {
        if (NetworkConfig.getInstance().isBoeEnv() == false) goto L6;
        return GET_SYNC_KEY_URL_BOE_LEGACY;
    L6:
        return GET_SYNC_KEY_URL_LEGACY;
    }

    public static CloudConfig getInstance() {
        if (cloudConfig != null) goto L15;
        monitor-enter(CloudConfig.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (cloudConfig != null) goto L9;
        cloudConfig = new CloudConfig();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CloudConfig.class);     // Catch: Throwable -> L11
    L15:
        return cloudConfig;
    }

    private int getWhiteListDataVersion(String r100) {
        int r101 = JSONObjectProtectorUtils.getInt(new JSONObject(JSONObjectProtectorUtils.getString(new JSONObject(r100), "content")), "version");     // Catch: Exception -> L5 JSONException -> L7
        LogUtils.i(TAG, "WhiteList apps data version:" + r101);     // Catch: Exception -> L5 JSONException -> L7
        return r101;
    L7:
        e = move-exception;
        String r102 = TAG;
        StringBuilder r103 = new StringBuilder("JSONException error:");
        String r104 = e.getMessage();
    L9:
        r103.append(r104);
        LogUtils.e(r102, r103.toString());
        return 0;
    L5:
        e = move-exception;
        r102 = TAG;
        r103 = new StringBuilder("Exception error:");
        r104 = e.getMessage();
        goto L9
    }

    private int getWhiteListFileVersion(String r100) {
        PolarisFileReaderWrapper r101 = new PolarisFileReaderWrapper(r100);     // Catch: Exception -> L18 JSONException -> L20 IOException -> L22
        char[] r102 = new char[1024];     // Catch: Throwable -> L12
        StringBuilder r103 = new StringBuilder();     // Catch: Throwable -> L12
    L6:
        int r104 = r101.read(r102);     // Catch: Throwable -> L12
        if (r104 <= 0) goto L9;
        r103.append(r102, 0, r104);     // Catch: Throwable -> L12
        goto L6
    L9:
        int r105 = new JSONObject(new JSONObject(r103.toString()).getString("content")).getInt("version");     // Catch: Throwable -> L12
        LogUtils.i(TAG, "WhiteList apps file version:" + r105);     // Catch: Throwable -> L12
        r101.close();     // Catch: Exception -> L18 JSONException -> L20 IOException -> L22
        return r105;
    L12:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L15
    L17:
        throw th;     // Catch: Exception -> L18 JSONException -> L20 IOException -> L22
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L18 JSONException -> L20 IOException -> L22
    L22:
        e = move-exception;
        String r106 = TAG;
        StringBuilder r107 = new StringBuilder("Get white list file version failed, IOException error:");
        String r108 = e.getMessage();
    L24:
        r107.append(r108);
        LogUtils.e(r106, r107.toString());
        return 0;
    L20:
        e = move-exception;
        r106 = TAG;
        r107 = new StringBuilder("Get white list file version failed, JSONException error:");
        r108 = e.getMessage();
    L18:
        e = move-exception;
        r106 = TAG;
        r107 = new StringBuilder("Get white list file version failed, Exception error:");
        r108 = e.getMessage();
        goto L24
    }

    private synchronized int parseWhiteListApps(String r110) {
        monitor-enter(this);
        JSONObject r100 = new JSONObject(JSONObjectProtectorUtils.getString(new JSONObject(r110), "content"));     // Catch: Throwable -> L20 Exception -> L22 JSONException -> L25
        int r111 = JSONObjectProtectorUtils.getInt(r100, "version");     // Catch: Throwable -> L20 Exception -> L22 JSONException -> L25
        LogUtils.i(TAG, "WhiteList apps file version:" + r111);     // Catch: Throwable -> L20 Exception -> L22 JSONException -> L25
        Vector r112 = new Vector();     // Catch: Throwable -> L20 Exception -> L22 JSONException -> L25
        JSONArray r101 = new JSONArray(JSONObjectProtectorUtils.getString(r100, JSON_TAG_APPS));     // Catch: Throwable -> L20 Exception -> L22 JSONException -> L25
        int r102 = 0;
    L7:
        if (r102 >= r101.length()) goto L17;
        JSONObject r103 = JSONArrayProtectorUtils.getJSONObject(r101, r102);     // Catch: Throwable -> L20 Exception -> L22 JSONException -> L25
        String r104 = JSONObjectProtectorUtils.getString(r103, "package");     // Catch: Throwable -> L20 Exception -> L22 JSONException -> L25
        String r105 = JSONObjectProtectorUtils.getString(r103, "appid");     // Catch: Throwable -> L20 Exception -> L22 JSONException -> L25
        if (TextUtils.isEmpty(r104) == true) goto L14;
        if (TextUtils.isEmpty(r105) == true) goto L14;
        r112.add(new WhiteListApp(r104, r105));     // Catch: Throwable -> L20 Exception -> L22 JSONException -> L25
        LogUtils.d(TAG, "Cloud WhiteList apps pkgName:" + r104 + " appId:" + r105);     // Catch: Throwable -> L20 Exception -> L22 JSONException -> L25
        r102 = r102 + 1;     // Catch: Throwable -> L20 Exception -> L22 JSONException -> L25
    L14:
        LogUtils.e(TAG, "Parse white list apps failed, pkgName or appId is empty!!");     // Catch: Throwable -> L20 Exception -> L22 JSONException -> L25
        monitor-exit(this);
        return -8;
    L17:
        this.cloudAppList.clear();     // Catch: Throwable -> L20 Exception -> L22 JSONException -> L25
        this.cloudAppList.addAll(r112);     // Catch: Throwable -> L20 Exception -> L22 JSONException -> L25
        LogUtils.d(TAG, "WhiteList apps size:" + this.cloudAppList.size());     // Catch: Throwable -> L20 Exception -> L22 JSONException -> L25
        monitor-exit(this);
        return 0;
    L20:
        th = move-exception;
        throw th;
    L25:
        e = move-exception;
        String r106 = TAG;     // Catch: Throwable -> L20
        String r113 = "Parse white list apps failed, JSONException error:" + e.getMessage();     // Catch: Throwable -> L20
    L24:
        LogUtils.e(r106, r113);     // Catch: Throwable -> L20
        monitor-exit(this);
        return -8;
    L22:
        e = move-exception;
        r106 = TAG;     // Catch: Throwable -> L20
        r113 = "Parse white list apps failed, Exception error:" + e.getMessage();     // Catch: Throwable -> L20
        goto L24
    }

    private void readWhiteListFile() {
        String r100 = this.mContext.getFilesDir().getAbsolutePath() + "/cloud_sync_white_list.xml";
        String r101 = TAG;
        LogUtils.d(r101, "cloud_sync_white_list file path:" + r100);
        if (new PolarisFileWrapper(r100).exists() == true) goto L46;
        LogUtils.d(r101, "cloud_sync_white_list file not exist!!");
        return;
    L46:
        PolarisFileReaderWrapper r102 = new PolarisFileReaderWrapper(r100);     // Catch: Exception -> L37 IOException -> L40
        char[] r103 = new char[1024];     // Catch: Throwable -> L31
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L31
        int r105 = 0;
    L9:
        int r106 = r102.read(r103);     // Catch: Throwable -> L31
        if (r106 <= 0) goto L17;
        r105 = r105 + r106;     // Catch: Throwable -> L31
        if (r105 > 1048576) goto L13;
        r104.append(r103, 0, r106);     // Catch: Throwable -> L31
        goto L9
    L13:
        LogUtils.e(TAG, "WhiteList file is too large, size:" + r105);     // Catch: Throwable -> L31
        r102.close();     // Catch: Exception -> L37 IOException -> L40
        return;
    L17:
        String r107 = r104.toString();     // Catch: Throwable -> L31
        r102.close();     // Catch: Exception -> L37 IOException -> L40
        if (TextUtils.isEmpty(r107) == false) goto L24;
        LogUtils.e(TAG, "Read whiteList file failed!");
        return;
    L24:
        if (verifyWhiteListData(r107) == 0) goto L28;
        LogUtils.e(TAG, "WhiteList file verify failed!");
        return;
    L28:
        if (parseWhiteListApps(r107) == 0) goto L49;
        LogUtils.e(TAG, "Parse white list apps failed!");
        return;
    L49:
        return;
    L31:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L34
    L36:
        throw th;     // Catch: Exception -> L37 IOException -> L40
    L34:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L37 IOException -> L40
    L40:
        e = move-exception;
        LogUtils.e(TAG, "Read white list file failed, IOException error:" + e.getMessage());
        return;
    L37:
        e = move-exception;
        LogUtils.e(TAG, "Read white list file failed, Exception error:" + e.getMessage());
    }

    private int verifyWhiteListData(String r110) {
    L25:
        e = move-exception;
        String r100 = TAG;
        StringBuilder r101 = new StringBuilder("Verify white list data failed, InvalidKeyException error:");
        String r111 = e.getMessage();
    L33:
        r101.append(r111);
        LogUtils.e(r100, r101.toString());
        return -9;
    L29:
        e = move-exception;
        r100 = TAG;
        r101 = new StringBuilder("Verify white list data failed, NoSuchAlgorithmException error:");
        r111 = e.getMessage();
    L27:
        e = move-exception;
        r100 = TAG;
        r101 = new StringBuilder("Verify white list data failed, SignatureException error:");
        r111 = e.getMessage();
    L31:
        e = move-exception;
        r100 = TAG;
        r101 = new StringBuilder("Verify white list data failed, JSONException error:");
        r111 = e.getMessage();
    L23:
        e = move-exception;
        r100 = TAG;
        r101 = new StringBuilder("Verify white list data failed, Exception error:");
        r111 = e.getMessage();
        goto L33
    L4:
        if (r110.length() <= 1048576) goto L7;
        LogUtils.e(TAG, "WhiteList file is too large, size:" + r110.length());     // Catch: Exception -> L23 InvalidKeyException -> L25 SignatureException -> L27 NoSuchAlgorithmException -> L29 JSONException -> L31
        return -9;
    L7:
        JSONObject r102 = new JSONObject(r110);     // Catch: Exception -> L23 InvalidKeyException -> L25 SignatureException -> L27 NoSuchAlgorithmException -> L29 JSONException -> L31
        String r112 = JSONObjectProtectorUtils.getString(r102, "content");     // Catch: Exception -> L23 InvalidKeyException -> L25 SignatureException -> L27 NoSuchAlgorithmException -> L29 JSONException -> L31
        String r103 = JSONObjectProtectorUtils.getString(r102, "signature");     // Catch: Exception -> L23 InvalidKeyException -> L25 SignatureException -> L27 NoSuchAlgorithmException -> L29 JSONException -> L31
        String r104 = TAG;     // Catch: Exception -> L23 InvalidKeyException -> L25 SignatureException -> L27 NoSuchAlgorithmException -> L29 JSONException -> L31
        LogUtils.d(r104, "verifyWhiteListData contentStr:" + r112);     // Catch: Exception -> L23 InvalidKeyException -> L25 SignatureException -> L27 NoSuchAlgorithmException -> L29 JSONException -> L31
        LogUtils.d(r104, "verifyWhiteListData signHash:" + r103);     // Catch: Exception -> L23 InvalidKeyException -> L25 SignatureException -> L27 NoSuchAlgorithmException -> L29 JSONException -> L31
        byte[] r105 = CryptoUtils.hexStringToByteArray(r103);     // Catch: Exception -> L23 InvalidKeyException -> L25 SignatureException -> L27 NoSuchAlgorithmException -> L29 JSONException -> L31
        if (r105 != null) goto L10;
    L21:
        LogUtils.e(r104, "Signature parse error! signHash:" + r103);     // Catch: Exception -> L23 InvalidKeyException -> L25 SignatureException -> L27 NoSuchAlgorithmException -> L29 JSONException -> L31
        return -9;
    L10:
        if (r105.length == 0) goto L21;
        if (r105.length <= 2048) goto L16;
        LogUtils.e(r104, "Signature is too large, size:" + r105.length);     // Catch: Exception -> L23 InvalidKeyException -> L25 SignatureException -> L27 NoSuchAlgorithmException -> L29 JSONException -> L31
        return -9;
    L16:
        Signature r106 = Signature.getInstance("SHA256withECDSA");     // Catch: Exception -> L23 InvalidKeyException -> L25 SignatureException -> L27 NoSuchAlgorithmException -> L29 JSONException -> L31
        r106.initVerify(CryptoUtils.byteArrayToECPublicKey(CryptoUtils.hexStringToByteArray(SIGN_PUBLIC_KEY)));     // Catch: Exception -> L23 InvalidKeyException -> L25 SignatureException -> L27 NoSuchAlgorithmException -> L29 JSONException -> L31
        r106.update(r112.getBytes(StandardCharsets.UTF_8));     // Catch: Exception -> L23 InvalidKeyException -> L25 SignatureException -> L27 NoSuchAlgorithmException -> L29 JSONException -> L31
        boolean r113 = r106.verify(r105);     // Catch: Exception -> L23 InvalidKeyException -> L25 SignatureException -> L27 NoSuchAlgorithmException -> L29 JSONException -> L31
        LogUtils.i(r104, "WhiteList file signature verify result:" + r113);     // Catch: Exception -> L23 InvalidKeyException -> L25 SignatureException -> L27 NoSuchAlgorithmException -> L29 JSONException -> L31
        if (r113 == false) goto L20;
        return 0;
    L20:
        return -9;
    }

    private synchronized int writeWhiteListFile(String r100, String r101) {
        monitor-enter(this);
        String r102 = TAG;     // Catch: Throwable -> L24
        LogUtils.i(r102, "cloud_sync_white_list file path:" + r100);     // Catch: Throwable -> L24
        PolarisFileWrapper r103 = new PolarisFileWrapper(r100);     // Catch: Throwable -> L24
        if (r103.exists() == false) goto L29;
        LogUtils.i(r102, "File exist:" + r100 + ", need delete first!!");     // Catch: Throwable -> L24
        r103.delete();     // Catch: Throwable -> L24
    L29:
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(r100);     // Catch: Exception -> L19 Throwable -> L24
        r104.write(r101.getBytes(StandardCharsets.UTF_8));     // Catch: Throwable -> L13
        r104.flush();     // Catch: Throwable -> L13
        r104.close();     // Catch: Exception -> L19 Throwable -> L24
        monitor-exit(this);
        return 0;
    L13:
        th = move-exception;
        r104.close();     // Catch: Throwable -> L16
    L18:
        throw th;     // Catch: Exception -> L19 Throwable -> L24
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L19 Throwable -> L24
    L19:
        e = move-exception;
        LogUtils.e(TAG, "Write json data failed, error:" + e.getMessage());     // Catch: Throwable -> L24
        return -100;
    L24:
        th = move-exception;
        throw th;
    }

    public String getAppId(String r100) {
        String r101 = localAppMap.get(r100);
        if (TextUtils.isEmpty(r101) == false) goto L14;
        Iterator<WhiteListApp> r102 = this.cloudAppList.iterator();
    L6:
        if (r102.hasNext() == false) goto L15;
        WhiteListApp r103 = r102.next();
        if (TextUtils.equals(r100, r103.getPackageName()) == false) goto L6;
        return r103.getAppId();
    L15:
        return r101;
    L14:
        return r101;
    }

    public String getPkgName(String r100) {
        Iterator<String> r101 = localAppMap.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        String r102 = r101.next();
        if (TextUtils.equals(r100, localAppMap.get(r102)) == false) goto L4;
        return r102;
    L8:
        Iterator<WhiteListApp> r103 = this.cloudAppList.iterator();
    L10:
        if (r103.hasNext() == false) goto L15;
        WhiteListApp r104 = r103.next();
        if (TextUtils.equals(r104.getAppId(), r100) == false) goto L10;
        return r104.getPackageName();
    L15:
        return "";
    }

    public void init(Context r100) {
        this.mContext = r100;
        readWhiteListFile();
    }

    public boolean isWhiteListApp(String r100) {
        boolean r101 = localAppMap.containsValue(r100);
        if (r101 == true) goto L10;
        Iterator<WhiteListApp> r102 = this.cloudAppList.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        if (TextUtils.equals(r102.next().getAppId(), r100) == false) goto L6;
        r101 = true;
    L10:
        return r101;
    }

    public void updateWhiteListApps(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L21:
        LogUtils.e(TAG, "White list file name or data is null!!");
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L21;
        if (verifyWhiteListData(r101) == 0) goto L12;
        LogUtils.e(TAG, "Verify white list file failed!!");
        return;
    L12:
        if (checkVersionUpdate(r100, r101) == true) goto L16;
        LogUtils.i(TAG, "No need to update white list file!!");
        return;
    L16:
        if (writeWhiteListFile(r100, r101) == 0) goto L19;
        LogUtils.e(TAG, "Write white list file failed!!");
        return;
    L19:
        int r102 = parseWhiteListApps(r101);
        LogUtils.i(TAG, "White list update result:" + r102);
    }
}
