package com.bytedance.crypto.cloudtrans;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.crypto.engine.HKDFHelper;
import com.bytedance.crypto.obfuscated.h;
import com.bytedance.crypto.obfuscated.i;
import com.bytedance.crypto.obfuscated.j;
import com.bytedance.crypto.obfuscated.k;
import com.bytedance.crypto.obfuscated.l;
import com.bytedance.crypto.utils.CommonUtils;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
class SensitiveData {
    public static final String DEVICE_SHARE_KEY_ALIAS = "device_share_key";
    private static final String OLD_DEVICE_SHARE_KEY_ALIAS_PREFIX = "old_";
    private static final String TAG = "SensitiveData";
    private static final long TWO_DAY_MILLISECONDS = 172800000;
    private boolean isDataExist;
    private boolean isOldDataExist;
    private byte[] mDeviceShareKey;
    private byte[] mExtraInfo;
    private byte[] mHKDFInfo;
    private byte[] mHKDFSalt;
    private boolean mIsBdDevice;
    private long mKeyValidityPeriod;
    private long mKeyVersion;
    private byte[] mOldDeviceShareKey;
    private long mOldKeyVersion;
    private byte[] mSessionEncryptKey;

    public SensitiveData() {
        this.mIsBdDevice = true;
        this.mKeyValidityPeriod = 0;
        this.mKeyVersion = -1;
        this.isDataExist = false;
        this.isOldDataExist = false;
        this.mOldKeyVersion = -1;
    }

    private void bdDeleteSessionEncryptKey(Context r100, String r101) {
        int r102 = FrameworkSecurityCompat.deleteData(r100, r101, new Bundle());
        if (r102 == FrameworkSecurityCompat.SecretErrorCode.SUCCESS()) goto L6;
        LogUtils.e(TAG, "delete sessionEncryptKey failed, code: " + r102);
        return;
    }

    private void bdInitSessionEncryptKey(Context r110, String r111, String r112) {
        Bundle r100 = new Bundle();     // Catch: Exception -> L37
        r100.putInt(FrameworkSecurityCompat.SecretConst.BUNDLE_KEY_QUERY_MODE(), FrameworkSecurityCompat.QueryMode.PRECISE_QUERY_AND_DECRYPT());     // Catch: Exception -> L37
        FrameworkSecurityCompat.SdQueryResult r101 = FrameworkSecurityCompat.queryData(r110, r111, r100);     // Catch: Exception -> L37
        if (r101.getResultCode() != FrameworkSecurityCompat.SecretErrorCode.DATA_NOT_FOUNT()) goto L7;
    L35:
        LogUtils.i(TAG, "bd sessionEncryptKey info not exist");     // Catch: Exception -> L37
        return;
    L7:
        if (r101.getDataList().isEmpty() == true) goto L35;
        this.isDataExist = true;     // Catch: Exception -> L37
        Object r102 = ListProtector.get(r101.getDataList(), 0);     // Catch: Exception -> L37
        if (FrameworkSecurityCompat.SecretData.getSecretData(r102).isEmpty() == false) goto L13;
        LogUtils.i(TAG, "bd sessionEncryptKey exist, but get secretData failed!");     // Catch: Exception -> L37
        return;
    L13:
        byte[] r113 = CryptoUtils.hexStringToByteArray(FrameworkSecurityCompat.SecretData.getSecretData(r102));     // Catch: Exception -> L37
        this.mDeviceShareKey = r113;     // Catch: Exception -> L37
        if (r113 != null) goto L16;
    L33:
        LogUtils.i(TAG, "bd sessionEncryptKey exist, but get key failed!");     // Catch: Exception -> L37
        return;
    L16:
        if (r113.length == 0) goto L33;
        this.mExtraInfo = CryptoUtils.hexStringToByteArray(FrameworkSecurityCompat.SecretData.getExtInfo(r102));     // Catch: Exception -> L37
        this.mKeyVersion = CastLongProtector.parseLong(FrameworkSecurityCompat.SecretData.getSearchInfo(r102));     // Catch: Exception -> L37
        this.mKeyValidityPeriod = CastLongProtector.parseLong(FrameworkSecurityCompat.SecretData.getPublicData(r102));     // Catch: Exception -> L37
        if (CommonUtils.containsAssistantApp(r112) == false) goto L21;
        String r114 = CommonUtils.getAssistantAppPkgName(r112);     // Catch: Exception -> L37
    L22:
        LogUtils.i(TAG, "bd sessionEncryptKey pkgName:" + r114);     // Catch: Exception -> L37
        this.mHKDFInfo = TransUtils.sha256(r114.getBytes());     // Catch: Exception -> L37
        LogUtils.d(TAG, "bd sessionEncryptKey mKeyVersion:" + this.mKeyVersion);     // Catch: Exception -> L37
        LogUtils.d(TAG, "bd sessionEncryptKey mExtraInfo:" + CryptoUtils.byteArrayToHexString(this.mExtraInfo));     // Catch: Exception -> L37
        LogUtils.d(TAG, "bd sessionEncryptKey mHKDFInfo:" + CryptoUtils.byteArrayToHexString(this.mHKDFInfo));     // Catch: Exception -> L37
        deriveSessionKey(this.mDeviceShareKey);     // Catch: Exception -> L37
        String r115 = OLD_DEVICE_SHARE_KEY_ALIAS_PREFIX + r111;     // Catch: Exception -> L37
        Bundle r116 = new Bundle();     // Catch: Exception -> L37
        r116.putInt(FrameworkSecurityCompat.SecretConst.BUNDLE_KEY_QUERY_MODE(), FrameworkSecurityCompat.QueryMode.PRECISE_QUERY_AND_DECRYPT());     // Catch: Exception -> L37
        FrameworkSecurityCompat.SdQueryResult r117 = FrameworkSecurityCompat.queryData(r110, r115, r116);     // Catch: Exception -> L37
        if (r117.getResultCode() != FrameworkSecurityCompat.SecretErrorCode.DATA_NOT_FOUNT()) goto L25;
        return;
    L25:
        if (r117.getDataList().isEmpty() == true) goto L46;
        Object r118 = ListProtector.get(r117.getDataList(), 0);     // Catch: Exception -> L37
        if ((System.currentTimeMillis() - CastLongProtector.parseLong(FrameworkSecurityCompat.SecretData.getPublicData(r118))) <= TWO_DAY_MILLISECONDS) goto L31;
        deleteSensitiveDate(r110, r115);     // Catch: Exception -> L37
        LogUtils.i(TAG, "old bd sessionEncryptKey info is expired");     // Catch: Exception -> L37
        this.isOldDataExist = false;     // Catch: Exception -> L37
        return;
    L31:
        this.isOldDataExist = true;     // Catch: Exception -> L37
        this.mOldDeviceShareKey = CryptoUtils.hexStringToByteArray(FrameworkSecurityCompat.SecretData.getSecretData(r118));     // Catch: Exception -> L37
        this.mOldKeyVersion = CastLongProtector.parseLong(FrameworkSecurityCompat.SecretData.getSearchInfo(r118));     // Catch: Exception -> L37
        LogUtils.w(TAG, "old key load, key version: " + this.mOldKeyVersion);     // Catch: Exception -> L37
        return;
    L46:
        return;
    L21:
        r114 = r110.getPackageName();     // Catch: Exception -> L37
    L37:
        e = move-exception;
        if ((e instanceof CloudTransException) == false) goto L43;
        throw ((CloudTransException) e);
    L43:
        throw new CloudTransException("initSessionEncryptKey failed", e);
    }

    private void bdSaveDeviceShareKey(Context r100, String r101, String r102) {
    L23:
        e = move-exception;
        if ((e instanceof CloudTransException) == false) goto L29;
        throw ((CloudTransException) e);
    L29:
        throw new CloudTransException("saveDeviceShareKey failed, ", e);
    L4:
        if (CommonUtils.containsAssistantApp(r102) == false) goto L6;
        String r103 = CommonUtils.getAssistantAppPkgName(r102);     // Catch: Exception -> L23
    L7:
        LogUtils.i(TAG, "bdSaveDeviceShareKey pkgName:" + r103);     // Catch: Exception -> L23
        this.mHKDFInfo = TransUtils.sha256(r103.getBytes());     // Catch: Exception -> L23
        deriveSessionKey(this.mDeviceShareKey);     // Catch: Exception -> L23
        Object r104 = FrameworkSecurityCompat.SecretData.newInstance();     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setAlias(r104, r101);     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setSecretData(r104, CryptoUtils.byteArrayToHexString(this.mDeviceShareKey));     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setPublicData(r104, String.valueOf(this.mKeyValidityPeriod));     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setSearchInfo(r104, String.valueOf(this.mKeyVersion));     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setExtInfo(r104, CryptoUtils.byteArrayToHexString(this.mExtraInfo));     // Catch: Exception -> L23
        if (this.isDataExist == false) goto L10;
        FrameworkSecurityCompat.updateData(r100, r104, new Bundle());     // Catch: Exception -> L23
    L11:
        long r105 = this.mOldKeyVersion;     // Catch: Exception -> L23
        if (r105 < this.mKeyVersion) goto L14;
        return;
    L14:
        if (r105 > (-1)) goto L16;
        return;
    L16:
        if (this.mOldDeviceShareKey == null) goto L34;
        String r106 = OLD_DEVICE_SHARE_KEY_ALIAS_PREFIX + r101;     // Catch: Exception -> L23
        Object r107 = FrameworkSecurityCompat.SecretData.newInstance();     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setAlias(r107, r106);     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setSecretData(r107, CryptoUtils.byteArrayToHexString(this.mOldDeviceShareKey));     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setSearchInfo(r107, String.valueOf(this.mOldKeyVersion));     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setPublicData(r107, String.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L23
        if (this.isOldDataExist == false) goto L20;
        FrameworkSecurityCompat.updateData(r100, r107, new Bundle());     // Catch: Exception -> L23
    L21:
        this.isOldDataExist = true;     // Catch: Exception -> L23
        return;
    L20:
        FrameworkSecurityCompat.addData(r100, r107, new Bundle());     // Catch: Exception -> L23
        goto L21
    L34:
        return;
    L10:
        FrameworkSecurityCompat.addData(r100, r104, new Bundle());     // Catch: Exception -> L23
        goto L11
    L6:
        r103 = r100.getPackageName();     // Catch: Exception -> L23
        goto L7
    }

    private void deriveSessionKey(byte[] r100) {
        if (r100 == null) goto L13;
        if (r100.length == 0) goto L13;
        LogUtils.i(TAG, "Derive session key enter.");
        byte[] r101 = new byte[32];
        new SecureRandom().nextBytes(r101);
        this.mSessionEncryptKey = HKDFHelper.deriveKey(r100, r101, this.mHKDFInfo);
        this.mHKDFSalt = r101;
        return;
    L9:
        e = move-exception;
        throw new CloudTransException("generateSharedSecret failed, derive session key failed", e);
    L13:
        throw new CloudTransException("deriveSessionKey failed, sek is empty!!");
    }

    private void saveDeviceShareKey(Context r100, String r101) {
        this.mHKDFInfo = TransUtils.sha256(r100.getPackageName().getBytes());     // Catch: Exception -> L18
        deriveSessionKey(this.mDeviceShareKey);     // Catch: Exception -> L18
        i r102 = new i();     // Catch: Exception -> L18
        r102.f204250a = r101;     // Catch: Exception -> L18
        r102.f204255f = CryptoUtils.byteArrayToHexString(this.mDeviceShareKey);     // Catch: Exception -> L18
        r102.f204257h = String.valueOf(this.mKeyVersion);     // Catch: Exception -> L18
        r102.f204253d = String.valueOf(this.mKeyValidityPeriod);     // Catch: Exception -> L18
        r102.f204256g = CryptoUtils.byteArrayToHexString(this.mExtraInfo);     // Catch: Exception -> L18
        if (this.isDataExist == false) goto L6;
        j.a().b(r100, r102, new Bundle());     // Catch: Exception -> L18
    L7:
        long r103 = this.mOldKeyVersion;     // Catch: Exception -> L18
        if (r103 < this.mKeyVersion) goto L10;
        return;
    L10:
        if (r103 > (-1)) goto L12;
        return;
    L12:
        if (this.mOldDeviceShareKey == null) goto L28;
        String r104 = OLD_DEVICE_SHARE_KEY_ALIAS_PREFIX + r101;     // Catch: Exception -> L18
        i r105 = new i();     // Catch: Exception -> L18
        r105.f204250a = r104;     // Catch: Exception -> L18
        r105.f204255f = CryptoUtils.byteArrayToHexString(this.mOldDeviceShareKey);     // Catch: Exception -> L18
        r105.f204257h = String.valueOf(this.mOldKeyVersion);     // Catch: Exception -> L18
        r105.f204253d = String.valueOf(System.currentTimeMillis());     // Catch: Exception -> L18
        if (this.isOldDataExist == false) goto L16;
        j.a().b(r100, r105, new Bundle());     // Catch: Exception -> L18
        return;
    L16:
        j.a().a(r100, r105, new Bundle());     // Catch: Exception -> L18
        this.isOldDataExist = true;     // Catch: Exception -> L18
        return;
    L28:
        return;
    L6:
        j.a().a(r100, r102, new Bundle());     // Catch: Exception -> L18
    L18:
        e = move-exception;
        if ((e instanceof CloudTransException) == false) goto L24;
        throw ((CloudTransException) e);
    L24:
        throw new CloudTransException("saveDeviceShareKey failed, ", e);
    }

    public void deleteSensitiveDate(Context r100, String r101) {
        if (this.mIsBdDevice == false) goto L5;
        bdDeleteSessionEncryptKey(r100, r101);
        return;
    L5:
        deleteSessionEncryptKey(r100, r101);
    }

    public byte[] getDeviceShareKey() {
        return this.mDeviceShareKey;
    }

    public byte[] getExtraInfo() {
        return this.mExtraInfo;
    }

    public byte[] getHKDFInfo() {
        return this.mHKDFInfo;
    }

    public byte[] getHKDFSalt() {
        return this.mHKDFSalt;
    }

    public long getKeyValidityPeriod() {
        return this.mKeyValidityPeriod;
    }

    public long getKeyVersion() {
        return this.mKeyVersion;
    }

    public byte[] getOldDeviceShareKey() {
        return this.mOldDeviceShareKey;
    }

    public long getOldKeyVersion() {
        return this.mOldKeyVersion;
    }

    public byte[] getSessionEncryptKey() {
        return this.mSessionEncryptKey;
    }

    public boolean isOlidKeyExist() {
        return this.isOldDataExist;
    }

    public void loadSensitiveDate(Context r100, String r101, String r102, boolean r103) {
        this.mIsBdDevice = r103;
        if (r103 == false) goto L5;
        bdInitSessionEncryptKey(r100, r101, r102);
        return;
    L5:
        initSessionEncryptKey(r100, r101);
    }

    public void setDeviceShareKey(byte[] r100) {
        this.mOldDeviceShareKey = this.mDeviceShareKey;
        this.mDeviceShareKey = r100;
    }

    public void setExtraInfo(byte[] r100) {
        this.mExtraInfo = r100;
    }

    public void setKeyValidityPeriod(long r100) {
        this.mKeyValidityPeriod = r100;
    }

    public void setKeyVersion(long r100) {
        LogUtils.d(TAG, "set Key Version:" + r100 + ", old key version:" + this.mKeyVersion);
        this.mOldKeyVersion = this.mKeyVersion;
        this.mKeyVersion = r100;
    }

    public void updateSensitiveDate(Context r100, String r101, String r102) {
        if (this.mIsBdDevice == false) goto L5;
        bdSaveDeviceShareKey(r100, r101, r102);
        return;
    L5:
        saveDeviceShareKey(r100, r101);
    }

    private void deleteSessionEncryptKey(Context r100, String r101) {
        Bundle r102 = new Bundle();
        j.a().getClass();
        l r103 = l.a(r100);
        r103.getClass();
        int r104 = 0;
        if (r102.getInt("delete_all", 0) != 1) goto L8;
        k r105 = r103.f204266a;
        String r106 = r103.f204267b.getPackageName();
        r105.getClass();
        if (r105.getWritableDatabase().delete("secret_item", "pkg_name =? ", new String[]{r106}) > 0) goto L22;
    L6:
        r104 = -6;
    L22:
        if (r104 == 0) goto L25;
        LogUtils.e(TAG, "delete sessionEncryptKey failed, code: " + r104);
        return;
    L25:
        return;
    L8:
        if (TextUtils.isEmpty(r101) == false) goto L10;
        r104 = -2;
        goto L22
    L10:
        i r107 = r103.f204266a.a(r101, r103.f204267b.getPackageName());
        if (r107 != null) goto L13;
    L16:
        boolean r108 = false;
    L17:
        if (r108 == true) goto L19;
        r104 = -5;
        goto L22
    L19:
        k r109 = r103.f204266a;
        String r110 = r103.f204267b.getPackageName();
        r109.getClass();
        if (r109.getWritableDatabase().delete("secret_item", "alias =? AND pkg_name =? ", new String[]{r101, r110}) == 1) goto L22;
    L13:
        if (TextUtils.isEmpty(r107.f204250a) == true) goto L16;
        r108 = true;
        goto L17
    }

    private void initSessionEncryptKey(Context r110, String r111) {
        Bundle r100 = new Bundle();     // Catch: Exception -> L35
        r100.putInt("query_mode", 2);     // Catch: Exception -> L35
        h r101 = j.a().a(r110, r111, r100);     // Catch: Exception -> L35
        if (r101.f204248a != (-5)) goto L7;
    L33:
        LogUtils.i(TAG, "sessionEncryptKey info not exist");     // Catch: Exception -> L35
        return;
    L7:
        if (r101.f204249b.isEmpty() == true) goto L33;
        this.isDataExist = true;     // Catch: Exception -> L35
        if (((i) ListProtector.get(r101.f204249b, 0)).f204255f.isEmpty() == false) goto L13;
        LogUtils.i(TAG, "sessionEncryptKey exist, but get secretData failed!");     // Catch: Exception -> L35
        return;
    L13:
        i r102 = (i) ListProtector.get(r101.f204249b, 0);     // Catch: Exception -> L35
        byte[] r103 = CryptoUtils.hexStringToByteArray(r102.f204255f);     // Catch: Exception -> L35
        this.mDeviceShareKey = r103;     // Catch: Exception -> L35
        if (r103 != null) goto L16;
    L31:
        LogUtils.i(TAG, "sessionEncryptKey exist, but get key failed!");     // Catch: Exception -> L35
        return;
    L16:
        if (r103.length == 0) goto L31;
        this.mExtraInfo = CryptoUtils.hexStringToByteArray(r102.f204256g);     // Catch: Exception -> L35
        this.mKeyVersion = CastLongProtector.parseLong(r102.f204257h);     // Catch: Exception -> L35
        this.mKeyValidityPeriod = CastLongProtector.parseLong(r102.f204253d);     // Catch: Exception -> L35
        this.mHKDFInfo = TransUtils.sha256(r110.getPackageName().getBytes());     // Catch: Exception -> L35
        deriveSessionKey(this.mDeviceShareKey);     // Catch: Exception -> L35
        String r112 = OLD_DEVICE_SHARE_KEY_ALIAS_PREFIX + r111;     // Catch: Exception -> L35
        Bundle r104 = new Bundle();     // Catch: Exception -> L35
        r104.putInt("query_mode", 2);     // Catch: Exception -> L35
        h r105 = j.a().a(r110, r112, r104);     // Catch: Exception -> L35
        if (r105.f204248a != (-5)) goto L21;
    L29:
        this.isOldDataExist = false;     // Catch: Exception -> L35
        return;
    L21:
        if (r105.f204249b.isEmpty() == true) goto L29;
        i r106 = (i) ListProtector.get(r105.f204249b, 0);     // Catch: Exception -> L35
        if ((System.currentTimeMillis() - CastLongProtector.parseLong(r106.f204253d)) <= TWO_DAY_MILLISECONDS) goto L27;
        deleteSensitiveDate(r110, r112);     // Catch: Exception -> L35
        LogUtils.i(TAG, "old bd sessionEncryptKey info is expired");     // Catch: Exception -> L35
        this.isOldDataExist = false;     // Catch: Exception -> L35
        return;
    L27:
        this.isOldDataExist = true;     // Catch: Exception -> L35
        this.mOldDeviceShareKey = CryptoUtils.hexStringToByteArray(r106.f204255f);     // Catch: Exception -> L35
        this.mOldKeyVersion = CastLongProtector.parseLong(r106.f204257h);     // Catch: Exception -> L35
        LogUtils.w(TAG, "old key load, key version: " + this.mOldKeyVersion);     // Catch: Exception -> L35
        return;
    L35:
        e = move-exception;
        if ((e instanceof CloudTransException) == false) goto L41;
        throw ((CloudTransException) e);
    L41:
        throw new CloudTransException("initSessionEncryptKey failed", e);
    }
}
