package com.bytedance.bdlocation.exception;

import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class BDLocationException extends Exception {
    public static final String ERROR_ABNORMAL_NETWORK = "34";
    public static final String ERROR_AMAP_CLIENT = "76";
    public static final String ERROR_AMAP_FAIL = "22";
    public static final String ERROR_ANDROID_VERSION_TOO_LOW = "104";
    public static final String ERROR_BACKGROUND_LOCATE = "36";
    public static final String ERROR_BEACON_ADVERTISING = "100";
    public static final String ERROR_BEACON_INFO_NULL = "98";
    public static final String ERROR_BEACON_NOT_ALLOW_USE = "96";
    public static final String ERROR_BEACON_START_ADVERTISING = "108";
    public static final String ERROR_BELOW_MIN_UPDATE_INTERVAL = "124";
    public static final String ERROR_BLUETOOTh_NOT_AVAILABLE = "106";
    public static final String ERROR_BOOT_NO_CERT_LOCATE = "54";
    public static final String ERROR_BPEA_CERT_CAST = "82";
    public static final String ERROR_BPEA_CERT_NULL = "88";
    public static final String ERROR_BPEA_WITHOUT_CERT = "90";
    public static final String ERROR_BYTE_CONTINUOUS_CLIENT = "148";
    public static final String ERROR_BYTE_DISABLE_USE_WIFI = "44";
    public static final String ERROR_BYTE_FAIL = "42";
    public static final String ERROR_BYTE_NO_CHANGE_WIFI_STATE_PERMISSION = "48";
    public static final String ERROR_BYTE_NO_FINE_LOCATION_PERMISSION = "46";
    public static final String ERROR_BYTE_OPTION_NULL = "68";
    public static final String ERROR_BYTE_SCAN_RESULT_IS_EMPTY = "50";
    public static final String ERROR_CODE_EXCEPTION = "132";
    public static final String ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED = "134";
    public static final String ERROR_CODE_LBS_LIGHT_SUBMITV2_FAILED = "136";
    public static final String ERROR_CONNECT_GOOGLE_FAIL = "32";
    public static final String ERROR_CONTEXT_NULL = "126";
    public static final String ERROR_DEVICE_LOCATION_DISABLE = "86";
    public static final String ERROR_DISPUTED_AREA = "38";
    public static final String ERROR_DOWNGRADE_LOCATION = "138";
    public static final String ERROR_EXTRA_DATA_SCAN_FAILED = "140";
    public static final String ERROR_GET_GEOCODE = "78";
    public static final String ERROR_GOOGLE_FAIL = "84";
    public static final String ERROR_INIT_LOCATION = "80";
    public static final String ERROR_JSON_CONVERT = "66";
    public static final String ERROR_LIGHT_LOCATION_GET_CURRENT_STATION = "118";
    public static final String ERROR_LIGHT_LOCATION_IN_CACHE = "144";
    public static final String ERROR_LIGHT_LOCATION_UPLOAD_EXCEPTION = "122";
    public static final String ERROR_LIGHT_LOCATION_UPLOAD_LOCATION_INFO = "120";
    public static final String ERROR_LIGHT_LOCATION_WHEN_MOCK_ENABLED = "152";
    public static final String ERROR_LIGHT_LOCATION_WIFI_LIST_ALREADY_UPLOAD = "128";
    public static final String ERROR_LOCATION_IS_NULL = "26";
    public static final String ERROR_LOCATION_NO_PROVIDER = "150";
    public static final String ERROR_LOCATION_OPTION = "92";
    public static final String ERROR_LOCATION_UPLOAD = "74";
    public static final String ERROR_LOG_ID_CACHE_ENTITY = "142";
    public static final String ERROR_MULTI_THREAD_LOCATE = "40";
    public static final String ERROR_NETWORK_REQUEST = "70";
    public static final String ERROR_NO_BYTE_IMPL = "52";
    public static final String ERROR_NO_DATA = "130";
    public static final String ERROR_NO_LOCATE = "60";
    public static final String ERROR_NO_LOCATION = "146";
    public static final String ERROR_PROVIDER_DISABLED = "62";
    public static final String ERROR_RESTRICTED_MODE_ON = "64";
    public static final String ERROR_SDK_NO_PERMISSION = "30";
    public static final String ERROR_SDK_START_FAIL = "28";
    public static final String ERROR_SHAKE_BPEA_CERT_CHECK = "58";
    public static final String ERROR_SHAKE_UPLOAD = "56";
    public static final String ERROR_START_ADVERTISING_FAILED = "94";
    public static final String ERROR_TIMEOUT = "0";
    public static final String ERROR_TMAP_BAD_JSON = "112";
    public static final String ERROR_TMAP_CLIENT = "110";
    public static final String ERROR_TMAP_FAIL = "116";
    public static final String ERROR_TMAP_WGS84 = "114";
    public static final String ERROR_UID_IS_EMPTY = "102";
    public static final String ERROR_UNKNOWN = "24";
    public static final String ERROR_WIFI_UPLOAD = "72";
    public static final String SUCCESS = "200";
    private final List<Throwable> causes;
    private final String code;
    private final String detailMessage;
    private final Map<String, String> extra;
    private final int isAssembleError;
    private LocationOption option;
    private final String sdkName;

    public String getCode() {
        if (this.isAssembleError == 0) goto L5;
        Iterator<Throwable> r0 = getRootCauses().iterator();
    L8:
        if (r0.hasNext() == false) goto L12;
        Throwable r1 = r0.next();
        if ((r1 instanceof BDLocationException) == false) goto L8;
        return ((BDLocationException) r1).getCode();
    L12:
        return "";
    L5:
        return this.code;
    }

    public Map<String, String> getExtra() {
        if (this.isAssembleError == 0) goto L5;
        HashMap r0 = new HashMap(0);
        Iterator<Throwable> r1 = getRootCauses().iterator();
    L8:
        if (r1.hasNext() == false) goto L16;
        Throwable r2 = r1.next();
        if ((r2 instanceof BDLocationException) == false) goto L8;
        return ((BDLocationException) r2).getExtra();
    L16:
        return r0;
    L5:
        return this.extra;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuffer r0 = new StringBuffer(71);
        String r2 = "";
        if (TextUtils.isEmpty(this.detailMessage) == false) goto L5;
        String r1 = "";
    L6:
        r0.append(r1);
        if (TextUtils.isEmpty(this.code) == false) goto L9;
        String r3 = "";
    L10:
        r0.append(r3);
        if (TextUtils.isEmpty(this.sdkName) == false) goto L13;
        String r4 = "";
    L14:
        r0.append(r4);
        if (getExtra().size() == 0) goto L18;
        r2 = "错误描述: " + getExtra() + '\n';
    L18:
        r0.append(r2);
        List<Throwable> r5 = getRootCauses();
        if (r5.isEmpty() == false) goto L23;
        return r0.toString();
    L23:
        if (r5.size() != 1) goto L25;
        r0.append("There was 1 cause:\n");
    L26:
        Iterator<Throwable> r6 = r5.iterator();
    L28:
        if (r6.hasNext() == false) goto L31;
        Throwable r7 = r6.next();
        r0.append(r7.getClass().getName());
        r0.append("\n(");
        r0.append(r7.getMessage());
        r0.append(")\n");
        goto L28
    L31:
        return r0.toString();
    L25:
        r0.append("There were ");
        r0.append(r5.size());
        r0.append(" causes:\n");
        goto L26
    L13:
        r4 = "SdkName: " + this.sdkName + '\n';
        goto L14
    L9:
        r3 = "错误码: " + this.code + '\n';
        goto L10
    L5:
        r1 = "错误信息: " + this.detailMessage + '\n';
        goto L6
    }

    public List<Throwable> getRootCauses() {
        ArrayList r0 = new ArrayList();
        addRootCauses(this, r0);
        return r0;
    }

    public String getSdkName() {
        if (this.isAssembleError == 0) goto L5;
        Iterator<Throwable> r0 = getRootCauses().iterator();
    L8:
        if (r0.hasNext() == false) goto L12;
        Throwable r1 = r0.next();
        if ((r1 instanceof BDLocationException) == false) goto L8;
        return ((BDLocationException) r1).getSdkName();
    L12:
        return "";
    L5:
        return this.sdkName;
    }

    public List<Throwable> getCauses() {
        return this.causes;
    }

    public String getDetailMessage() {
        return this.detailMessage;
    }

    public LocationOption getOption() {
        return this.option;
    }

    public BDLocationException(List<Throwable> r8) {
        this("定位失败", "", "", new HashMap(), r8, 1);
    }

    public String getExtra(String r2) {
        return this.extra.get(r2);
    }

    public void setOption(LocationOption r1) {
        this.option = r1;
    }

    private void addRootCauses(Throwable r3, List<Throwable> r4) {
        if ((r3 instanceof BDLocationException) == false) goto L12;
        Iterator<Throwable> r5 = ((BDLocationException) r3).getCauses().iterator();
    L6:
        if (r5.hasNext() == false) goto L21;
        Throwable r0 = r5.next();
        addRootCauses(r0, r4);
        if ((r0 instanceof BDLocationException) == false) goto L6;
        if (((BDLocationException) r0).isAssembleError != 0) goto L6;
        r4.add(r0);
        goto L6
    L21:
        return;
    L12:
        r4.add(r3);
    }

    public BDLocationException addExtra(String r2, String r3) {
        this.extra.put(r2, r3);
        return this;
    }

    public BDLocationException(Throwable r8, String r9, String r10) {
        this("", r9, r10, new HashMap(), Collections.singletonList(r8), 0);
    }

    public BDLocationException(String r8, String r9, String r10) {
        this(r8, r9, r10, new HashMap(), Collections.emptyList(), 0);
    }

    public BDLocationException(String r1, String r2, String r3, Map<String, String> r4, List<Throwable> r5, int r6) {
        this.detailMessage = r1;
        this.sdkName = r2;
        this.code = r3;
        this.extra = r4;
        this.causes = r5;
        this.isAssembleError = r6;
    }
}
