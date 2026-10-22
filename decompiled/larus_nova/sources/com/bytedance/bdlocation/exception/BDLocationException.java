package com.bytedance.bdlocation.exception;

import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
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
        Iterator<Throwable> r100 = getRootCauses().iterator();
    L8:
        if (r100.hasNext() == false) goto L12;
        Throwable r101 = r100.next();
        if ((r101 instanceof BDLocationException) == false) goto L8;
        return ((BDLocationException) r101).getCode();
    L12:
        return "";
    L5:
        return this.code;
    }

    public Map<String, String> getExtra() {
        if (this.isAssembleError == 0) goto L5;
        HashMap r100 = new HashMap(0);
        Iterator<Throwable> r101 = getRootCauses().iterator();
    L8:
        if (r101.hasNext() == false) goto L16;
        Throwable r102 = r101.next();
        if ((r102 instanceof BDLocationException) == false) goto L8;
        return ((BDLocationException) r102).getExtra();
    L16:
        return r100;
    L5:
        return this.extra;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuffer r100 = new StringBuffer(71);
        String r101 = "";
        if (TextUtils.isEmpty(this.detailMessage) == false) goto L5;
        String r102 = "";
    L6:
        r100.append(r102);
        if (TextUtils.isEmpty(this.code) == false) goto L9;
        String r103 = "";
    L10:
        r100.append(r103);
        if (TextUtils.isEmpty(this.sdkName) == false) goto L13;
        String r104 = "";
    L14:
        r100.append(r104);
        if (getExtra().size() == 0) goto L18;
        r101 = "错误描述: " + getExtra() + '\n';
    L18:
        r100.append(r101);
        List<Throwable> r105 = getRootCauses();
        if (r105.isEmpty() == false) goto L23;
        return r100.toString();
    L23:
        if (r105.size() != 1) goto L25;
        r100.append("There was 1 cause:\n");
    L26:
        Iterator<Throwable> r106 = r105.iterator();
    L28:
        if (r106.hasNext() == false) goto L31;
        Throwable r107 = r106.next();
        r100.append(r107.getClass().getName());
        r100.append("\n(");
        r100.append(r107.getMessage());
        r100.append(")\n");
        goto L28
    L31:
        return r100.toString();
    L25:
        r100.append("There were ");
        r100.append(r105.size());
        r100.append(" causes:\n");
        goto L26
    L13:
        r104 = "SdkName: " + this.sdkName + '\n';
        goto L14
    L9:
        r103 = "错误码: " + this.code + '\n';
        goto L10
    L5:
        r102 = "错误信息: " + this.detailMessage + '\n';
        goto L6
    }

    public List<Throwable> getRootCauses() {
        ArrayList r100 = new ArrayList();
        addRootCauses(this, r100);
        return r100;
    }

    public String getSdkName() {
        if (this.isAssembleError == 0) goto L5;
        Iterator<Throwable> r100 = getRootCauses().iterator();
    L8:
        if (r100.hasNext() == false) goto L12;
        Throwable r101 = r100.next();
        if ((r101 instanceof BDLocationException) == false) goto L8;
        return ((BDLocationException) r101).getSdkName();
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

    public BDLocationException(List<Throwable> r100) {
        this("定位失败", "", "", new HashMap(), r100, 1);
    }

    public String getExtra(String r100) {
        return this.extra.get(r100);
    }

    public void setOption(LocationOption r100) {
        this.option = r100;
    }

    private void addRootCauses(Throwable r100, List<Throwable> r101) {
        if ((r100 instanceof BDLocationException) == false) goto L12;
        Iterator<Throwable> r102 = ((BDLocationException) r100).getCauses().iterator();
    L6:
        if (r102.hasNext() == false) goto L21;
        Throwable r103 = r102.next();
        addRootCauses(r103, r101);
        if ((r103 instanceof BDLocationException) == false) goto L6;
        if (((BDLocationException) r103).isAssembleError != 0) goto L6;
        r101.add(r103);
        goto L6
    L21:
        return;
    L12:
        r101.add(r100);
    }

    public BDLocationException addExtra(String r100, String r101) {
        this.extra.put(r100, r101);
        return this;
    }

    public BDLocationException(Throwable r100, String r101, String r110) {
        this("", r101, r110, new HashMap(), Collections.singletonList(r100), 0);
    }

    public BDLocationException(String r100, String r101, String r110) {
        this(r100, r101, r110, new HashMap(), Collections.emptyList(), 0);
    }

    public BDLocationException(String r100, String r101, String r102, Map<String, String> r103, List<Throwable> r104, int r105) {
        this.detailMessage = r100;
        this.sdkName = r101;
        this.code = r102;
        this.extra = r103;
        this.causes = r104;
        this.isAssembleError = r105;
    }
}
