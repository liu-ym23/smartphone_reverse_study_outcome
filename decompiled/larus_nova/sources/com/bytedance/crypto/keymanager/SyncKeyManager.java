package com.bytedance.crypto.keymanager;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import com.bytedance.crypto.cloudsync.network.SyncKeyData;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.UByte;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public class SyncKeyManager {
    private static final String JSON_TAG_APP_ID = "app_id";
    private static final String JSON_TAG_KEY_INFO_LIST = "key_info_list";
    private static final String JSON_TAG_LATEST_VERSION = "latest_version";
    private static final String KEY_INFO_FILE_NAME = "key_info.xml";
    public static final String TAG = "SyncKeyManager";
    private static volatile SyncKeyManager keyManager;
    private volatile HashMap<String, Integer> keyVersionMap;

    public SyncKeyManager() {
        this.keyVersionMap = new HashMap();
    }

    private synchronized int deleteVersionMap(Context r100) {
        monitor-enter(this);
        String r101 = r100.getFilesDir().getAbsolutePath() + "/key_info.xml";     // Catch: Throwable -> L12
        String r102 = TAG;     // Catch: Throwable -> L12
        LogUtils.d(r102, "key_info file path:" + r101);     // Catch: Throwable -> L12
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101);     // Catch: Throwable -> L12
        if (r103.exists() == true) goto L9;
        LogUtils.e(r102, "File not exist:" + r101 + ", need create!!");     // Catch: Throwable -> L12
        monitor-exit(this);
        return 0;
    L9:
        r103.delete();     // Catch: Throwable -> L12
        monitor-exit(this);
        return 0;
    L12:
        th = move-exception;
        throw th;
    }

    public static SyncKeyManager getInstance() {
        if (keyManager != null) goto L15;
        monitor-enter(SyncKeyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (keyManager != null) goto L9;
        keyManager = new SyncKeyManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SyncKeyManager.class);     // Catch: Throwable -> L11
    L15:
        return keyManager;
    }

    private synchronized int importToVersionMap(Context r100, List<SyncKeyData> r101) {
        monitor-enter(this);
        Iterator<SyncKeyData> r102 = r101.iterator();     // Catch: Throwable -> L20
        boolean r103 = false;
    L5:
        if (r102.hasNext() == false) goto L13;
        SyncKeyData r104 = r102.next();     // Catch: Throwable -> L20
        if (this.keyVersionMap.containsKey(r104.getAppId()) == false) goto L11;
        int r105 = this.keyVersionMap.get(r104.getAppId()).intValue();     // Catch: Throwable -> L20
        if (r104.getKeyVersion() <= r105) goto L5;
        this.keyVersionMap.replace(r104.getAppId(), Integer.valueOf(r104.getKeyVersion()));     // Catch: Throwable -> L20
    L12:
        r103 = true;
        goto L5
    L11:
        this.keyVersionMap.put(r104.getAppId(), Integer.valueOf(r104.getKeyVersion()));     // Catch: Throwable -> L20
        goto L12
    L13:
        if (r103 == false) goto L17;
        int r106 = writeVersionMap(r100);     // Catch: Throwable -> L20
        monitor-exit(this);
        return r106;
    L17:
        LogUtils.i(TAG, "Key info exist, no need to update.");     // Catch: Throwable -> L20
        monitor-exit(this);
        return 0;
    L20:
        th = move-exception;
        throw th;
    }

    private int preHandleForXcrypt(Context r100, String r101, byte[] r102, String r103) {
        if (r100 != null) goto L5;
    L24:
        String r104 = TAG;
        String r105 = "Input param is empty!!";
    L22:
        LogUtils.e(r104, r105);
        return -2;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L24;
        if (TextUtils.isEmpty(r103) == true) goto L24;
        if (r102 != null) goto L11;
    L21:
        r104 = TAG;
        r105 = "Input data is empty!!";
        goto L22
    L11:
        if (r102.length == 0) goto L21;
        if (this.keyVersionMap.isEmpty() == false) goto L19;
        int r106 = readVersionMap(r100);
        if (r106 == 0) goto L25;
        LogUtils.e(TAG, "Read version map failed!! errorCode:" + r106);
        return r106;
    L25:
        return 0;
    L19:
        return 0;
    }

    private synchronized int readVersionMap(Context r100) {
        monitor-enter(this);
        String r101 = r100.getFilesDir().getAbsolutePath() + "/key_info.xml";     // Catch: Throwable -> L41
        String r102 = TAG;     // Catch: Throwable -> L41
        LogUtils.d(r102, "key_info file path:" + r101);     // Catch: Throwable -> L41
        if (new PolarisFileWrapper(r101).exists() == true) goto L46;
        LogUtils.e(r102, "file not exist:" + r101);     // Catch: Throwable -> L41
        monitor-exit(this);
        return -5;
    L46:
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r101);     // Catch: Exception -> L36 Throwable -> L41
        byte[] r104 = new byte[4096];     // Catch: Throwable -> L30
        r103.read(r104);     // Catch: Throwable -> L30
        JSONArray r105 = new JSONArray(new JSONObject(new String(r104, StandardCharsets.UTF_8)).getString(JSON_TAG_KEY_INFO_LIST));     // Catch: Throwable -> L30
        int r106 = 0;
    L14:
        if (r106 >= r105.length()) goto L22;
        JSONObject r107 = r105.getJSONObject(r106);     // Catch: Throwable -> L30
        String r108 = r107.getString("app_id");     // Catch: Throwable -> L30
        int r109 = r107.getInt(JSON_TAG_LATEST_VERSION);     // Catch: Throwable -> L30
        if (this.keyVersionMap.containsKey(r108) == true) goto L18;
        this.keyVersionMap.put(r108, Integer.valueOf(r109));     // Catch: Throwable -> L30
    L21:
        r106 = r106 + 1;     // Catch: Throwable -> L30
        goto L14
    L18:
        if (r109 <= this.keyVersionMap.get(r108).intValue()) goto L21;
        this.keyVersionMap.replace(r108, Integer.valueOf(r109));     // Catch: Throwable -> L30
        goto L21
    L22:
        Iterator<String> r110 = this.keyVersionMap.keySet().iterator();     // Catch: Throwable -> L30
    L23:
        if (r110.hasNext() == false) goto L27;
        String r111 = r110.next();     // Catch: Throwable -> L30
        LogUtils.i(TAG, "keyVersionMap key:" + r111 + " version:" + this.keyVersionMap.get(r111));     // Catch: Throwable -> L30
        goto L23
    L27:
        r103.close();     // Catch: Exception -> L36 Throwable -> L41
        monitor-exit(this);
        return 0;
    L30:
        th = move-exception;
        r103.close();     // Catch: Throwable -> L33
    L35:
        throw th;     // Catch: Exception -> L36 Throwable -> L41
    L33:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L36 Throwable -> L41
    L36:
        e = move-exception;
        LogUtils.e(TAG, "Parse key_info file failed, error:" + e.getMessage());     // Catch: Throwable -> L41
        return -100;
    L41:
        th = move-exception;
        throw th;
    }

    private synchronized int removeFromVersionMap(Context r100, String r101) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.keyVersionMap.containsKey(r101) == true) goto L10;
        LogUtils.e(TAG, "AppId not in version map!! appId:" + r101);     // Catch: Throwable -> L18
        monitor-exit(this);
        return -5;
    L10:
        this.keyVersionMap.remove(r101);     // Catch: Throwable -> L18
        if (this.keyVersionMap.isEmpty() == false) goto L15;
        int r102 = deleteVersionMap(r100);     // Catch: Throwable -> L18
        monitor-exit(this);
        return r102;
    L15:
        int r103 = writeVersionMap(r100);     // Catch: Throwable -> L18
        monitor-exit(this);
        return r103;
    }

    private String versionMapToJson() {
        if (this.keyVersionMap.isEmpty() == false) goto L15;
        LogUtils.e(TAG, "Key version map is empty!!!");
        return "";
    L15:
        JSONArray r100 = new JSONArray();     // Catch: Exception -> L12
        Iterator<String> r101 = this.keyVersionMap.keySet().iterator();     // Catch: Exception -> L12
    L8:
        if (r101.hasNext() == false) goto L10;
        String r102 = r101.next();     // Catch: Exception -> L12
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L12
        r103.put("app_id", r102);     // Catch: Exception -> L12
        r103.put(JSON_TAG_LATEST_VERSION, this.keyVersionMap.get(r102));     // Catch: Exception -> L12
        r100.put(r103);     // Catch: Exception -> L12
        goto L8
    L10:
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L12
        r104.put(JSON_TAG_KEY_INFO_LIST, r100);     // Catch: Exception -> L12
        return r104.toString();
    L12:
        e = move-exception;
        LogUtils.e(TAG, "Version map to json failed, error:" + e.getMessage());
        return "";
    }

    private synchronized int writeVersionMap(Context r100) {
        monitor-enter(this);
        String r101 = r100.getFilesDir().getAbsolutePath() + "/key_info.xml";     // Catch: Throwable -> L25
        String r102 = TAG;     // Catch: Throwable -> L25
        LogUtils.d(r102, "key_info file path:" + r101);     // Catch: Throwable -> L25
        if (new PolarisFileWrapper(r101).exists() == true) goto L7;
        LogUtils.e(r102, "File not exist:" + r101 + ", need create!!");     // Catch: Throwable -> L25
    L7:
        String r103 = versionMapToJson();     // Catch: Throwable -> L25
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(r101);     // Catch: Exception -> L20 Throwable -> L25
        r104.write(r103.getBytes(StandardCharsets.UTF_8));     // Catch: Throwable -> L14
        r104.flush();     // Catch: Throwable -> L14
        r104.close();     // Catch: Exception -> L20 Throwable -> L25
        monitor-exit(this);
        return 0;
    L14:
        th = move-exception;
        r104.close();     // Catch: Throwable -> L17
    L19:
        throw th;     // Catch: Exception -> L20 Throwable -> L25
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L20 Throwable -> L25
    L20:
        e = move-exception;
        LogUtils.e(TAG, "Write json data failed, error:" + e.getMessage());     // Catch: Throwable -> L25
        return -100;
    L25:
        th = move-exception;
        throw th;
    }

    public byte[] decryptByKeyManager(Context r100, String r101, byte[] r102, String r110) {
        String r103 = TAG;
        LogUtils.i(r103, "Decrypt enter, appId:" + r101);
        LogUtils.d(r103, "Decrypt enter, aad:" + r110);
        if (preHandleForXcrypt(r100, r101, r102, r110) == 0) goto L6;
        LogUtils.e(r103, "Pre handle for Decrypt failed!!");
        return new byte[0];
    L6:
        byte[] r104 = new byte[4];
        if (r102.length >= 4) goto L10;
        LogUtils.e(r103, "Input data len is too short! len:" + r102.length);
        return new byte[0];
    L10:
        System.arraycopy(r102, 0, r104, 0, 4);
        int r105 = CryptoUtils.byteArrayToInt(r104);
        if (r105 == 317657839) goto L15;
        LogUtils.e(r103, "Cannot parse input cipher data! magic:" + r105);
        return new byte[0];
    L15:
        if (r102.length >= 5) goto L18;
        LogUtils.e(r103, "Input data len is too short!! len:" + r102.length);
        return new byte[0];
    L18:
        int r106 = r102[4] & UByte.MAX_VALUE;
        if (r106 <= this.keyVersionMap.get(r101).intValue()) goto L22;
        LogUtils.e(r103, "Input cipher data version is wrong! version:" + r106);
        return new byte[0];
    L22:
        LogUtils.i(r103, "Decrypt enter, keyVersion:" + r106);
        if (r102.length >= 21) goto L26;
        LogUtils.e(r103, "Input data len is too short for data cipher! len:" + r102.length);
        return new byte[0];
    L26:
        int r107 = r102.length - 5;
        byte[] r108 = new byte[r107];
        System.arraycopy(r102, 5, r108, 0, r107);
        Bundle r109 = new Bundle();
        r109.putString(FrameworkSecurityCompat.KeyManagerConst.ADDITIONAL_DATA(), r110);
        r109.putString(FrameworkSecurityCompat.KeyManagerConst.KEY_ALIAS(), r101 + "_" + r106);
        FrameworkSecurityCompat.KmResult r111 = FrameworkSecurityCompat.xcrypt(r100, 1, r108, r109);
        if (r111.getResultCode() == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L30;
        LogUtils.e(r103, "Decrypt failed, error code:" + r111.getResultCode());
        return new byte[0];
    L30:
        LogUtils.i(r103, "Decrypt succeed, out data len:" + r111.getOutData().length);
        return r111.getOutData();
    }

    public int deleteSyncKey(Context r100, String r110) {
        if (r100 != null) goto L4;
    L27:
        LogUtils.e(TAG, "Input param is empty!!");
        return -2;
    L4:
        if (TextUtils.isEmpty(r110) == true) goto L27;
        if (this.keyVersionMap.isEmpty() == false) goto L12;
        int r101 = readVersionMap(r100);
        if (r101 == 0) goto L12;
        LogUtils.e(TAG, "Read version map failed!! errorCode:" + r101);
        return r101;
    L12:
        boolean r102 = true;
        if (this.keyVersionMap.containsKey(r110) == false) goto L22;
        int r103 = this.keyVersionMap.get(r110).intValue();
    L15:
        if (r103 < 1) goto L20;
        String r104 = r110 + "_" + r103;
        int r105 = FrameworkSecurityCompat.deleteSyncKey(r100, r104);
        LogUtils.i(TAG, "delete sync key, keyAlias:" + r104 + " package:" + r100.getPackageName() + " ret:" + r105);
        if (r105 != FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L18;
        r103 = r103 - 1;
        goto L15
    L18:
        r102 = false;
    L20:
        if (r102 == false) goto L23;
        removeFromVersionMap(r100, r110);
    L23:
        if (r102 == true) goto L31;
        return -100;
    L31:
        return 0;
    L22:
        LogUtils.e(TAG, "Key version map find app failed!! appId:" + r110);
        goto L23
    }

    public byte[] encryptByKeyManager(Context r100, String r101, byte[] r102, String r103) {
        String r104 = TAG;
        LogUtils.i(r104, "Encrypt enter, keyAlias:" + r101);
        LogUtils.d(r104, "Encrypt enter, aad:" + r103);
        if (preHandleForXcrypt(r100, r101, r102, r103) == 0) goto L7;
        String r105 = "Pre handle for Encrypt failed!!";
    L5:
        LogUtils.e(r104, r105);
        return new byte[0];
    L7:
        Bundle r106 = new Bundle();
        r106.putString(FrameworkSecurityCompat.KeyManagerConst.ADDITIONAL_DATA(), r103);
        int r107 = this.keyVersionMap.get(r101).intValue();
        LogUtils.i(r104, "Encrypt enter, keyVersion:" + r107);
        r106.putString(FrameworkSecurityCompat.KeyManagerConst.KEY_ALIAS(), r101 + "_" + r107);
        FrameworkSecurityCompat.KmResult r108 = FrameworkSecurityCompat.xcrypt(r100, 0, r102, r106);
        if (r108.getResultCode() == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L10;
        r105 = "Encrypt failed, error code:" + r108.getResultCode();
        goto L5
    L10:
        LogUtils.i(r104, "Encrypt succeed, out data len:" + r108.getOutData().length);
        byte[] r109 = new byte[r108.getOutData().length + 5];
        System.arraycopy(CryptoUtils.intToBytes(CryptoConst.BYTES_KEY_CIPHER_MAGIC_NUM), 0, r109, 0, 4);
        r109[4] = (byte) r107;
        System.arraycopy(r108.getOutData(), 0, r109, 5, r108.getOutData().length);
        return r109;
    }

    public boolean importSyncKey(Context r100, List<SyncKeyData> r101, String r110, String r111) {
        if (r100 != null) goto L5;
    L36:
        LogUtils.e(TAG, "Input param is empty!!");
        return false;
    L5:
        if (TextUtils.isEmpty(r110) == true) goto L36;
        if (TextUtils.isEmpty(r111) == true) goto L36;
        if (r101 != null) goto L11;
    L34:
        LogUtils.e(TAG, "Key data list is empty!!");
        return false;
    L11:
        if (r101.isEmpty() == true) goto L34;
        if (this.keyVersionMap.isEmpty() == false) goto L21;
        int r102 = readVersionMap(r100);
        if (r102 == 0) goto L21;
        if (r102 == (-5)) goto L21;
        LogUtils.e(TAG, "Read version map failed!! errorCode:" + r102);
        return false;
    L21:
        Iterator<SyncKeyData> r103 = r101.iterator();
    L23:
        if (r103.hasNext() == false) goto L29;
        SyncKeyData r104 = r103.next();
        Bundle r105 = new Bundle();
        String r106 = TAG;
        LogUtils.i(r106, "Import key enter, appid:" + r104.getAppId() + " key version:" + r104.getKeyVersion());
        LogUtils.d(r106, "Import key enter, attKeyAlias:" + r111);
        LogUtils.d(r106, "Import key enter, serverPubKey:" + r110);
        LogUtils.d(r106, "Import key enter, SyncKeyCipher:" + r104.getSyncKeyCipher());
        r105.putString(FrameworkSecurityCompat.KeyManagerConst.KEY_ALIAS(), r104.getAppId() + "_" + r104.getKeyVersion());
        r105.putString("attest_key_alias", r111);
        r105.putString(FrameworkSecurityCompat.KeyManagerConst.ECC_PUBLIC_KEY(), r110);
        r105.putString(FrameworkSecurityCompat.KeyManagerConst.WRAPPED_KEY_DATA(), r104.getSyncKeyCipher());
        String r107 = CloudConfig.getInstance().getPkgName(r104.getAppId());
        r105.putString(FrameworkSecurityCompat.KeyManagerConst.ADDITIONAL_DATA(), r107);
        LogUtils.d(r106, "Import key enter, aad:" + r107);
        int r108 = FrameworkSecurityCompat.importKey(r100, r105);
        if (r108 == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L23;
        LogUtils.e(r106, "Import key failed, error code:" + r108);
        return false;
    L29:
        if (importToVersionMap(r100, r101) == 0) goto L32;
        LogUtils.e(TAG, "Update version map failed!!");
        return false;
    L32:
        return true;
    }

    public boolean importSyncKeyLegacy(Context r100, List<SyncKeyData> r101, String r110, String r111) {
        if (r100 != null) goto L5;
    L36:
        LogUtils.e(TAG, "Input param is empty!! legacy.");
        return false;
    L5:
        if (TextUtils.isEmpty(r110) == true) goto L36;
        if (TextUtils.isEmpty(r111) == true) goto L36;
        if (r101 != null) goto L11;
    L34:
        LogUtils.e(TAG, "Key data list is empty!! legacy.");
        return false;
    L11:
        if (r101.isEmpty() == true) goto L34;
        if (this.keyVersionMap.isEmpty() == false) goto L21;
        int r102 = readVersionMap(r100);
        if (r102 == 0) goto L21;
        if (r102 == (-5)) goto L21;
        LogUtils.e(TAG, "Read version map failed!!  legacy errorCode:" + r102);
        return false;
    L21:
        Iterator<SyncKeyData> r103 = r101.iterator();
    L23:
        if (r103.hasNext() == false) goto L29;
        SyncKeyData r104 = r103.next();
        Bundle r105 = new Bundle();
        String r106 = TAG;
        LogUtils.i(r106, "Import key legacy enter, appid:" + r104.getAppId() + " key version:" + r104.getKeyVersion());
        LogUtils.d(r106, "Import key enter, localPrivKey:" + r111);
        LogUtils.d(r106, "Import key enter, serverPubKey:" + r110);
        LogUtils.d(r106, "Import key enter, SyncKeyCipher:" + r104.getSyncKeyCipher());
        r105.putString(FrameworkSecurityCompat.KeyManagerConst.KEY_ALIAS(), r104.getAppId() + "_" + r104.getKeyVersion());
        r105.putString(FrameworkSecurityCompat.KeyManagerConst.ECC_PRIVATE_KEY(), r111);
        r105.putString(FrameworkSecurityCompat.KeyManagerConst.ECC_PUBLIC_KEY(), r110);
        r105.putString(FrameworkSecurityCompat.KeyManagerConst.WRAPPED_KEY_DATA(), r104.getSyncKeyCipher());
        String r107 = CloudConfig.getInstance().getPkgName(r104.getAppId());
        r105.putString(FrameworkSecurityCompat.KeyManagerConst.ADDITIONAL_DATA(), r107);
        LogUtils.d(r106, "Import key legacy enter, aad:" + r107);
        int r108 = FrameworkSecurityCompat.importKeyLegacy(r100, r105);
        if (r108 == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L23;
        LogUtils.e(r106, "Import key legacy failed, error code:" + r108);
        return false;
    L29:
        if (importToVersionMap(r100, r101) == 0) goto L32;
        LogUtils.e(TAG, "Update version map failed!! legacy.");
        return false;
    L32:
        return true;
    }
}
