package com.bytedance.dora.device;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.text.TextUtils;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.voice.ProtocolAbility;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.miui.easygo.constant.EasyGoConstant;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.UByte;
import pk4.a;
import pk4.j;
import pk4.n;
import sk4.e;

/* JADX INFO: loaded from: classes15.dex */
public class DoraDevice {
    private static final String TAG = "DoraDevice";
    public BluetoothDevice _device;
    public String ability;
    public String androidBuildTime;
    public String androidOSVersion;
    public int androidPkgType;
    public String androidRomVersion;
    public String batchName;
    public int[] battery;
    public volatile int btConnectedPhoneCount;
    public volatile long btConnectedPhoneCountUpdateTimeMs;
    public String buildTime;
    public int busyState;
    public String caseSoftVersion;
    public int[] charge;
    public String chip;
    public int[] diskSpace;
    private volatile String fakeDeviceId;
    public int headphoneModeState;
    public String hwVersion;
    public int[] idleState;
    public String imei;
    public int inconsistentVersions;
    public boolean isResetFlag;

    /* JADX INFO: renamed from: mac, reason: collision with root package name */
    public String f204389mac;
    public int mode;
    public String model;
    public String modelVersion;
    public String name;
    public String phoneNumber;
    public int productId;
    public int promptMax;
    public int protocol;
    public int[] realCharge;
    public String reason;
    public int sku;

    /* JADX INFO: renamed from: sn, reason: collision with root package name */
    public String f204390sn;
    public String softVersion;
    public int[] state;
    public int status;
    public int transferAbility;
    public int type;
    public String typeName;
    public int vendorCapabilities;
    public int vendorId;
    public int version;
    public int[] volume;
    public int[] wearState;

    public void resetBudsInfo() {
        this.battery = null;
        this.charge = null;
        this.state = null;
        this.wearState = null;
        this.volume = null;
        this.diskSpace = null;
    }

    private String getDeviceIdSalt() {
        if (this.productId != ProductNameType.DORA_G2.getId()) goto L7;
        return "DEVICE_ID_SALT_G2";
    L7:
        if (this.productId != ProductNameType.DORA_G_AIR.getId()) goto L11;
        return "DEVICE_ID_SALT_G_AIR";
    L11:
        if (this.productId != ProductNameType.DORA_G_PIN.getId()) goto L14;
        return "DEVICE_ID_SALT_G_PIN";
    L14:
        return "DEVICE_ID_SALT_H";
    }

    private boolean isG2SeriesProduct() {
        if (this.productId != ProductNameType.DORA_G2.getId()) goto L5;
    L10:
        return true;
    L5:
        if (this.productId == ProductNameType.DORA_G_AIR.getId()) goto L10;
        if (this.productId == ProductNameType.DORA_G_PIN.getId()) goto L10;
        return false;
    }

    public String getDeviceId() {
        String r100 = this.fakeDeviceId;
        if (TextUtils.isEmpty(r100) == true) goto L5;
        return r100;
    L5:
        int r101 = 0;
        if (isG2SeriesProduct() == false) goto L30;
        String r102 = this.f204389mac;
        if (TextUtils.isEmpty(r102) == false) goto L57;
    L54:
        String r103 = "";
    L55:
        this.fakeDeviceId = r103;
        return r103;
    L57:
        String[] r104 = r102.split(":");     // Catch: Exception -> L28
        if (r104.length == 6) goto L13;
        j.d("BTUtils", "generateWDid invalid mac parts : " + r104.length);     // Catch: Exception -> L28
        goto L54
    L13:
        byte[] r105 = new byte[6];     // Catch: Exception -> L28
        int r106 = 0;
    L14:
        if (r106 >= 6) goto L16;
        r105[r106] = (byte) (CastIntegerProtector.parseInt(r104[r106], 16) & 255);     // Catch: Exception -> L28
        r106 = r106 + 1;     // Catch: Exception -> L28
        goto L14
    L16:
        int[] r107 = a.f529595a;     // Catch: Exception -> L28
        int r108 = -1519704291;
        int r109 = 0;
    L18:
        if (r109 >= 8) goto L20;
        int r110 = r108 ^ (r107[r109] & 255);     // Catch: Exception -> L28
        int r111 = r110 ^ (r110 << 13);     // Catch: Exception -> L28
        int r112 = r111 ^ (r111 >>> 17);     // Catch: Exception -> L28
        r108 = r112 ^ (r112 << 5);     // Catch: Exception -> L28
        r109 = r109 + 1;     // Catch: Exception -> L28
        goto L18
    L20:
        byte[] r113 = new byte[6];     // Catch: Exception -> L28
        int r114 = 0;
    L21:
        if (r114 >= 6) goto L23;
        int r115 = r108 ^ (r108 << 13);     // Catch: Exception -> L28
        int r116 = r115 ^ (r115 >>> 17);     // Catch: Exception -> L28
        r108 = r116 ^ (r116 << 5);     // Catch: Exception -> L28
        r113[r114] = (byte) (r108 & 255);     // Catch: Exception -> L28
        r114 = r114 + 1;     // Catch: Exception -> L28
        goto L21
    L23:
        char[] r117 = new char[12];     // Catch: Exception -> L28
        char[] r118 = "0123456789ABCDEF".toCharArray();     // Catch: Exception -> L28
    L24:
        if (r101 >= 6) goto L26;
        int r119 = (r105[r101] ^ r113[r101]) & 255;     // Catch: Exception -> L28
        int r120 = r101 * 2;     // Catch: Exception -> L28
        r117[r120] = r118[(r119 >> 4) & 15];     // Catch: Exception -> L28
        r117[r120 + 1] = r118[r119 & 15];     // Catch: Exception -> L28
        r101 = r101 + 1;     // Catch: Exception -> L28
        goto L24
    L26:
        r103 = new String(r117);     // Catch: Exception -> L28
    L28:
        e = move-exception;
        j.d("BTUtils", "generateWDid error : " + e.getMessage());
        goto L54
    L30:
        String r121 = this.f204389mac;
        String r122 = getDeviceIdSalt();
        if (TextUtils.isEmpty(r121) == true) goto L54;
        if (TextUtils.isEmpty(r122) == true) goto L54;
        String[] r123 = r121.split(":");     // Catch: Exception -> L52
        byte[] r124 = new byte[r123.length];     // Catch: Exception -> L52
        int r125 = 0;
    L37:
        if (r125 >= r123.length) goto L44;
        r124[r125] = (byte) CastIntegerProtector.parseInt(r123[r125], 16);     // Catch: Exception -> L41
    L43:
        r125 = r125 + 1;     // Catch: Exception -> L52
    L41:
        e = move-exception;
        j.d("BTUtils", "generateDeviceId error : " + e.getMessage());     // Catch: Exception -> L52
        goto L43
    L44:
        MessageDigest r126 = MessageDigest.getInstance("SHA-256");     // Catch: Exception -> L52
        byte[] r127 = r126.digest(r122.getBytes(StandardCharsets.UTF_8));     // Catch: Exception -> L52
        byte[] r128 = new byte[r123.length + r127.length];     // Catch: Exception -> L52
        System.arraycopy(r124, 0, r128, 0, r123.length);     // Catch: Exception -> L52
        System.arraycopy(r127, 0, r128, r123.length, r127.length);     // Catch: Exception -> L52
        byte[] r129 = r126.digest(r128);     // Catch: Exception -> L52
        StringBuilder r130 = new StringBuilder();     // Catch: Exception -> L52
    L45:
        if (r101 >= 16) goto L50;
        String r131 = Integer.toHexString(r129[r101] & UByte.MAX_VALUE);     // Catch: Exception -> L52
        if (r131.length() != 1) goto L49;
        r130.append('0');     // Catch: Exception -> L52
    L49:
        r130.append(r131);     // Catch: Exception -> L52
        r101 = r101 + 1;     // Catch: Exception -> L52
        goto L45
    L50:
        r103 = r130.toString();     // Catch: Exception -> L52
    L52:
        e = move-exception;
        j.d("BTUtils", "generateDeviceId error : " + e.getMessage());
        goto L54
    }

    public String getProductName() {
        ProductNameType r100 = ProductNameType.getProduct(this.vendorId, this.productId);
        if (r100 != null) goto L6;
        r100 = ProductNameType.DORA_LITE;
    L6:
        return r100.name;
    }

    public String getSerialNumber() {
        if (4096 == this.vendorId) goto L10;
        if (isG2SeriesProduct() == true) goto L10;
        return this.f204390sn;
    L10:
        return getDeviceId();
    }

    public int getVersion() {
        if (TextUtils.isEmpty(this.softVersion) == true) goto L11;
        String[] r100 = this.softVersion.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r100.length != 4) goto L11;
        int r101 = CastIntegerProtector.parseInt(r100[0]);     // Catch: Throwable -> L12
        int r102 = CastIntegerProtector.parseInt(r100[1]);     // Catch: Throwable -> L12
        if (r101 >= 1) goto L10;
        return r101;
    L10:
        return r102;
    L11:
        return -1;
    }

    public int hashCode() {
        return this.f204389mac.hashCode();
    }

    public boolean isDoraDevice() {
        int r100 = this.vendorId;
        if (r100 == 1) goto L8;
        if (r100 == 0) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    public boolean isSupportGlassesModeControl() {
        return e.a(this.ability, ProtocolAbility.FEATURE_HEADPHONE_MODE_CONTROL);
    }

    public void resetProperties() {
        j.d(TAG, "resetProperties");
        this.androidBuildTime = "";
        this.androidOSVersion = "";
        this.androidRomVersion = "";
    }

    public boolean supportSppInsecure() {
        return a.e(this.transferAbility, 16);
    }

    public String toString() {
        return "DoraDevice{name='" + this.name + "', type=" + this.type + ", typeName='" + this.typeName + "', version=" + this.version + ", hwVersion='" + this.hwVersion + "', softVersion='" + this.softVersion + "', caseSoftVersion='" + this.caseSoftVersion + "', phoneNumber='" + this.phoneNumber + "', imei='" + this.imei + "', sn='" + this.f204390sn + "', sku=" + this.sku + ", buildTime='" + this.buildTime + "', model='" + this.model + "', chip='" + this.chip + "', modelVersion='" + this.modelVersion + "', status=" + this.status + ", protocol=" + this.protocol + ", transferAbility=" + this.transferAbility + ", battery=" + Arrays.toString(this.battery) + ", charge=" + Arrays.toString(this.charge) + ", realCharge=" + Arrays.toString(this.realCharge) + ", state=" + Arrays.toString(this.state) + ", volume=" + Arrays.toString(this.volume) + ", diskSpace=" + Arrays.toString(this.diskSpace) + ", wearState=" + Arrays.toString(this.wearState) + ", mode=" + this.mode + ", isResetFlag=" + this.isResetFlag + ", idleState=" + this.idleState + ", busyState=" + this.busyState + ", headphoneModeState=" + this.headphoneModeState + ", wearState=" + Arrays.toString(this.wearState) + ", reason='" + this.reason + "', vendorId='" + this.vendorId + "', productId='" + this.productId + "', productName='" + getProductName() + "', batchName='" + this.batchName + "', _device=" + this._device + ", promptMax= " + this.promptMax + ", vendorCapabilities= " + this.vendorCapabilities + ", fakeDeviceId= " + this.fakeDeviceId + '}';
    }

    public DoraDevice() {
        this.type = -1;
        this.mode = -1;
        this.isResetFlag = false;
        this.headphoneModeState = -1;
        this.btConnectedPhoneCount = -1;
        this.btConnectedPhoneCountUpdateTimeMs = 0;
        this.promptMax = 0;
        this.vendorId = 1;
        this.productId = ProductNameType.DORA_LITE.f204375id;
        this.fakeDeviceId = null;
        this.vendorCapabilities = 0;
    }

    private boolean useResetFlagAsFactorySource() {
        return isG2SeriesProduct();
    }

    public boolean isFactory() {
        if (useResetFlagAsFactorySource() == false) goto L7;
        return this.isResetFlag;
    L7:
        if (((this.mode >> 1) & 1) == 1) goto L11;
        return false;
    L11:
        return true;
    }

    public static DoraDevice from(String r100) {
        BluetoothDevice r101 = ((BluetoothManager) n.f529659c.getSystemService("bluetooth")).getAdapter().getRemoteDevice(r100);     // Catch: Throwable -> L8
        if (r101 == null) goto L7;
        return from(r101, r100);
    L7:
        return null;
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public boolean equals(Object r100) {
        if (super.equals(r100) == true) goto L9;
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.hashCode() != hashCode()) goto L8;
    L9:
        return true;
    }

    public boolean hasInfoChanged(DoraDevice r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.headphoneModeState == r100.headphoneModeState) goto L8;
    L39:
        return true;
    L8:
        if (TextUtils.equals(this.typeName, r100.typeName) == false) goto L39;
        if (TextUtils.equals(this.modelVersion, r100.modelVersion) == false) goto L39;
        if (TextUtils.equals(this.hwVersion, r100.hwVersion) == false) goto L39;
        if (TextUtils.equals(this.softVersion, r100.softVersion) == false) goto L39;
        if (TextUtils.equals(this.buildTime, r100.buildTime) == false) goto L39;
        if (TextUtils.equals(this.caseSoftVersion, r100.caseSoftVersion) == false) goto L39;
        if (TextUtils.equals(this.f204390sn, r100.f204390sn) == false) goto L39;
        if (TextUtils.equals(this.fakeDeviceId, r100.fakeDeviceId) == false) goto L39;
        if (this.sku != r100.sku) goto L39;
        if (this.type != r100.type) goto L39;
        if (TextUtils.equals(this.model, r100.model) == false) goto L39;
        if (TextUtils.equals(this.name, r100.name) == false) goto L39;
        if (this.vendorId != r100.vendorId) goto L39;
        if (this.productId != r100.productId) goto L39;
        if (this.transferAbility != r100.transferAbility) goto L39;
        if (TextUtils.equals(this.ability, r100.ability) == false) goto L39;
        return false;
    }

    public boolean isFeatureAbility(String r100) {
        return n.i(this.ability, r100);
    }

    public void setDeviceId(String r100) {
        this.fakeDeviceId = r100;
    }

    public void updateBudsStateFrom(DoraDevice r100) {
        this.battery = r100.battery;
        this.charge = r100.charge;
        this.realCharge = r100.realCharge;
        this.state = r100.state;
        this.volume = r100.volume;
        this.diskSpace = r100.diskSpace;
        this.wearState = r100.wearState;
    }

    public static DoraDevice from(BluetoothDevice r100) {
        return from(r100, null);
    }

    public static DoraDevice from(BluetoothDevice r100, String r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        DoraDevice r102 = new DoraDevice();
        r102._device = r100;
        r102.name = r100.getName();     // Catch: Exception -> L9
        j.d(TAG, "Get BluetoothDevice name : " + r102.name);     // Catch: Exception -> L9
    L12:
        if (TextUtils.isEmpty(r101) == true) goto L27;
        r102.f204389mac = r101;
        j.d(TAG, "DoraDevice.from: Use the MAC address provided via method parameters.");
    L31:
        r102.type = r100.getType();     // Catch: Exception -> L20
    L33:
        r102.status = r100.getBondState();     // Catch: Exception -> L24
    L26:
        return r102;
    L24:
        e = move-exception;
        j.d(TAG, "Get BluetoothDevice BondState error : " + e.getMessage());
    L20:
        e = move-exception;
        j.d(TAG, "Get BluetoothDevice type error : " + e.getMessage());
        goto L33
    L27:
        r102.f204389mac = r100.getAddress();     // Catch: Exception -> L16
        j.d(TAG, "DoraDevice.from: Use the MAC address from bluetoothDevice.getAddress.");     // Catch: Exception -> L16
    L16:
        e = move-exception;
        j.d(TAG, "Get BluetoothDevice address (mac) error : " + e.getMessage());
    L9:
        e = move-exception;
        j.d(TAG, "Get BluetoothDevice name error : " + e.getMessage());
        goto L12
    }
}
