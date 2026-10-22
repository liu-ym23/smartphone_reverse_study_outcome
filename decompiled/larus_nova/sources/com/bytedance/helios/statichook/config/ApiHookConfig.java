package com.bytedance.helios.statichook.config;

import com.bytedance.android.livesdkapi.model.LinkMediaModel;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.supervisor.token.AtomicInfoDef;
import com.bytedance.timon_monitor_impl.TimonActionInvoker;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import com.ss.android.lark.search.dto.constant.SearchCommonConstants;
import f06.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import sx9.d;

/* JADX INFO: loaded from: classes3.dex */
public class ApiHookConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, a> f245610a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<Integer, g06.a> f245611b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f245612c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a[] f245613d = null;
    private static String desc = "This class is used as a dictionary maintains.\nDictionary layout:\n    |---- key: API ID, an integer value\n    |---- value: {API ID, API name hash code,                   API related resource id(may be empty),                  API related resource name(maybe empty),                  permissions(maybe empty),                  permission type(anyOf/allOf, maybe empty),                  data types,                  monitor class hash code,                  invoke type (before or/and around)}\nIn runtime, TikTok will monitor these sensitive API usage according to this dictionary to make sure there is no misuse. For example *getDeviceId/getSSID...etc* is not allowed in TikTok. And the ActionInvokers are used to intercept the usage of these API";

    public static void b() {
        HashMap r100 = new HashMap(4);
        f245610a = r100;
        r100.put("-6215962069689047539", new d());
        f245610a.put("3971680796841625202", new sx9.a());
        f245610a.put("-6589579158015428227", new TimonActionInvoker());
        f245610a.put("-5107019182865140624", new com.bytedance.upc.cache.a());
    }

    static {
        Map r100 = Collections.EMPTY_MAP;
        f245610a = r100;
        f245611b = r100;
        f245612c = "";
        f245613d = new a[0];
        b();     // Catch: Throwable -> L5
        a();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public static void a() {
        f245612c = "";
        HashMap r100 = new HashMap(124);
        f245611b = r100;
        r100.put(101200, new g06.a(101200, "android.os.Build.getSerial", new String[0], 0, new String[]{"device_info"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102002, new g06.a(102002, AtomicInfoDef.BUILD_SERIAL, new String[0], 0, new String[]{"device_info"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102003, new g06.a(102003, "android.provider.Settings$System.getString", new String[0], 0, new String[]{"device_info"}, new String[]{"-6215962069689047539", "-6589579158015428227", "-5107019182865140624"}, "around"));
        f245611b.put(102004, new g06.a(102004, "android.provider.Settings$Secure.getString", new String[0], 0, new String[]{"device_info"}, new String[]{"-6215962069689047539", "-6589579158015428227", "-5107019182865140624"}, "around"));
        f245611b.put(100000, new g06.a(100000, "android.location.LocationManager.getLastKnownLocation", new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 1, new String[]{"location"}, new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "around"));
        f245611b.put(100001, new g06.a(100001, "android.location.LocationManager.requestLocationUpdates", new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 1, new String[]{"location"}, new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(100002, new g06.a(100002, "android.location.LocationManager.requestSingleUpdate", new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 1, new String[]{"location"}, new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(100003, new g06.a(100003, "android.webkit.WebChromeClient.onGeolocationPermissionsShowPrompt", new String[0], 0, new String[]{"location"}, new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(100004, new g06.a(100004, "android.location.LocationManager.getCurrentLocation", new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 1, new String[]{"location"}, new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(100005, new g06.a(100005, "android.location.LocationManager.addGpsStatusListener", new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1, new String[]{"location"}, new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(100006, new g06.a(100006, "android.location.LocationManager.addNmeaListener", new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1, new String[]{"location"}, new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(100007, new g06.a(100007, "android.location.LocationManager.addProximityAlert", new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 1, new String[]{"location"}, new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(100008, new g06.a(100008, "android.location.LocationManager.registerAntennaInfoListener", new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1, new String[]{"location"}, new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(100009, new g06.a(100009, "android.location.LocationManager.registerGnssMeasurementsCallback", new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1, new String[]{"location"}, new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(100010, new g06.a(100010, "android.location.LocationManager.registerGnssNavigationMessageCallback", new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1, new String[]{"location"}, new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(100011, new g06.a(100011, "android.location.LocationManager.registerGnssStatusCallback", new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1, new String[]{"location"}, new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(100038, new g06.a(100038, "android.location.LocationListener.onLocationChanged", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(100039, new g06.a(100039, "android.location.LocationManager.getLastLocation", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "around"));
        f245611b.put(100041, new g06.a(100041, "android.location.Address.mLatitude", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(100042, new g06.a(100042, "android.location.Address.mLongitude", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(100045, new g06.a(100045, "android.location.Address.getLatitude", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(100046, new g06.a(100046, "android.location.Address.getLongitude", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(101003, new g06.a(101003, "android.net.wifi.WifiInfo.mWifiSsid", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(101004, new g06.a(101004, "android.net.wifi.WifiConfiguration.SSID", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(101007, new g06.a(101007, "android.net.NetworkInfo.mExtraInfo", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(101010, new g06.a(101010, "java.net.NetworkInterface.hardwareAddr", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(101000, new g06.a(101000, "android.net.wifi.WifiInfo.getSSID", new String[0], 0, new String[]{"location", "wifi", "device_info"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(101001, new g06.a(101001, "android.net.wifi.WifiManager.getConfiguredNetworks", new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1, new String[]{"location", "wifi"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(101009, new g06.a(101009, "android.net.wifi.WifiInfo.mMacAddress", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(101100, new g06.a(101100, "android.net.wifi.WifiInfo.getBSSID", new String[0], 0, new String[]{"location", "wifi", "device_info"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(101101, new g06.a(101101, "android.net.wifi.WifiInfo.mBSSID", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(101102, new g06.a(101102, "android.net.wifi.WifiConfiguration.BSSID", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(101400, new g06.a(101400, "android.telephony.TelephonyManager.getSimSerialNumber", new String[]{"android.permission.READ_PHONE_STATE"}, 1, new String[]{"network", "device_info"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "around"));
        f245611b.put(101304, new g06.a(101304, "android.content.pm.PackageManager.getInstalledApplications", new String[0], 0, new String[]{"application"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "around"));
        f245611b.put(101305, new g06.a(101305, "android.content.pm.PackageManager.getInstalledApplicationsAsUser", new String[0], 0, new String[]{"application"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "around"));
        f245611b.put(101308, new g06.a(101308, "android.content.pm.PackageManager.getInstalledPackagesAsUser", new String[0], 0, new String[]{"application"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "around"));
        f245611b.put(101309, new g06.a(101309, "android.content.pm.PackageManager.getInstalledPackages", new String[0], 0, new String[]{"application"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "around"));
        f245611b.put(101500, new g06.a(101500, "android.telephony.SubscriptionInfo.getIccId", new String[0], 0, new String[]{"network", "device_info"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "around"));
        f245611b.put(101600, new g06.a(101600, "android.telephony.TelephonyManager.getDeviceId", new String[]{"android.permission.READ_PHONE_STATE"}, 0, new String[]{"network", "device_info"}, new String[]{"-6215962069689047539", "-6589579158015428227", "-5107019182865140624"}, "around"));
        f245611b.put(101601, new g06.a(101601, "android.telephony.TelephonyManager.getImei", new String[]{"android.permission.READ_PHONE_STATE"}, 0, new String[]{"network", "device_info"}, new String[]{"-6215962069689047539", "-6589579158015428227", "-5107019182865140624"}, "around"));
        f245611b.put(101602, new g06.a(101602, "android.telephony.TelephonyManager.getMeid", new String[]{"android.permission.READ_PHONE_STATE"}, 0, new String[]{"network", "device_info"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "around"));
        f245611b.put(101700, new g06.a(101700, "android.net.wifi.WifiInfo.getMacAddress", new String[0], 0, new String[]{"location", "wifi", "device_info"}, new String[]{"-6215962069689047539", "-6589579158015428227", "-5107019182865140624"}, "around"));
        f245611b.put(101701, new g06.a(101701, "java.net.NetworkInterface.getHardwareAddress", new String[0], 0, new String[]{"device_info"}, new String[]{"-6215962069689047539", "-6589579158015428227", "-5107019182865140624"}, "around"));
        f245611b.put(102007, new g06.a(102007, "android.telephony.SubscriptionManager.getActiveSubscriptionInfoForSimSlotIndex", new String[]{"android.permission.READ_PHONE_STATE"}, 1, new String[]{"network"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102008, new g06.a(102008, "android.telephony.SubscriptionManager.getActiveSubscriptionInfoList", new String[]{"android.permission.READ_PHONE_STATE"}, 1, new String[]{"network", "device_info"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102009, new g06.a(102009, "android.telephony.SubscriptionManager.getOpportunisticSubscriptions", new String[]{"android.permission.READ_PHONE_STATE"}, 1, new String[]{"network", "device_info"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102010, new g06.a(102010, "android.telephony.SubscriptionManager.getSubscriptionsInGroup", new String[]{"android.permission.READ_PHONE_STATE"}, 1, new String[]{"network", "device_info"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102014, new g06.a(102014, "android.telephony.TelephonyManager.getSubscriptionId", new String[]{"android.permission.READ_PHONE_STATE"}, 1, new String[]{"network", "device_info"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102015, new g06.a(102015, "android.telephony.TelephonyManager.getDeviceSoftwareVersion", new String[]{"android.permission.READ_PHONE_STATE"}, 1, new String[]{"network", "device_info"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102017, new g06.a(102017, "android.telephony.TelephonyManager.getEsn", new String[0], 0, new String[]{"network"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102026, new g06.a(102026, "android.net.NetworkInfo.getExtraInfo", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102046, new g06.a(102046, "android.telephony.SubscriptionManager.getActiveSubscriptionInfo", new String[]{"android.permission.READ_PHONE_STATE"}, 1, new String[]{"network", "device_info"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102300, new g06.a(102300, "android.net.wifi.WifiManager.getScanResults", new String[0], 0, new String[]{"wifi", "location"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "around"));
        f245611b.put(102301, new g06.a(102301, "android.net.wifi.WifiManager.getConnectionInfo", new String[0], 0, new String[]{"wifi", "location"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102302, new g06.a(102302, "android.net.wifi.WifiManager.startScan", new String[0], 0, new String[]{"wifi"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102303, new g06.a(102303, "android.net.wifi.WifiManager.addSuggestionConnectionStatusListener", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102311, new g06.a(102311, "android.net.wifi.WifiManager.startLocalOnlyHotspot", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(101900, new g06.a(101900, "android.telephony.TelephonyManager.getSubscriberId", new String[]{"android.permission.READ_PHONE_STATE"}, 1, new String[]{"network", "device_info"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102130, new g06.a(102130, "android.telecom.TelecomManager.getCallCapablePhoneAccounts", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102131, new g06.a(102131, "android.telecom.TelecomManager.getDefaultOutgoingPhoneAccount", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102132, new g06.a(102132, "android.telecom.TelecomManager.getPhoneAccountsSupportingScheme", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102133, new g06.a(102133, "android.telecom.TelecomManager.getSelfManagedPhoneAccounts", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102134, new g06.a(102134, "android.telephony.SubscriptionInfo.getSubscriptionId", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102135, new g06.a(102135, "android.telephony.SubscriptionInfo.mIccid", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102136, new g06.a(102136, "android.telephony.SubscriptionInfo.mId", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102137, new g06.a(102137, "android.telephony.SubscriptionManager.getAccessibleSubscriptionInfoList", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102138, new g06.a(102138, "android.telephony.SubscriptionManager.getCompleteActiveSubscriptionInfoList", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(101328, new g06.a(101328, "com.amap.api.location.AMapLocationClient.getLastKnownLocation", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "around"));
        f245611b.put(101329, new g06.a(101329, "com.amap.api.location.AMapLocationListener.onLocationChanged", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(101327, new g06.a(101327, "com.bytedance.bdlocation.init.BDLocationAgent.getLastKnownLocation", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "around"));
        f245611b.put(101330, new g06.a(101330, "com.bytedance.bdlocation.callback.BDLocationCallback.onLocationChanged", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(101603, new g06.a(101603, "com.android.id.impl.IdProviderImpl.getOAID", new String[0], 0, new String[]{"device_info"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(100502, new g06.a(100502, "android.media.MediaRecorder.start", new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"}, 1, new String[]{"audio", "video"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "around"));
        f245611b.put(100503, new g06.a(100503, "android.media.MediaRecorder.stop", new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"}, 1, new String[]{"audio", "video"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "around"));
        f245611b.put(100100, new g06.a(100100, "android.hardware.Camera.open", new String[]{"android.permission.CAMERA"}, 1, new String[]{"video"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "around"));
        f245611b.put(100101, new g06.a(100101, "android.hardware.Camera.release", new String[]{"android.permission.CAMERA"}, 1, new String[]{"video"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "around"));
        f245611b.put(100107, new g06.a(100107, "android.hardware.Camera.takePicture", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(Integer.valueOf(LinkMediaModel.LIVE_LINK_OPEN_ALBUM_REQUEST_CODE), new g06.a(LinkMediaModel.LIVE_LINK_OPEN_ALBUM_REQUEST_CODE, "android.hardware.camera2.CameraDevice$StateCallback.onOpened", new String[]{"android.permission.CAMERA"}, 1, new String[]{"video"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(100201, new g06.a(100201, "android.hardware.camera2.CameraDevice.close", new String[]{"android.permission.CAMERA"}, 1, new String[]{"video"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "around"));
        f245611b.put(100206, new g06.a(100206, "android.hardware.camera2.CameraManager.openCamera", new String[]{"android.permission.CAMERA"}, 1, new String[]{"video"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "around"));
        f245611b.put(100019, new g06.a(100019, "android.media.ExifInterface.getLatLong", new String[0], 0, new String[]{"exif", "location"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "around"));
        f245611b.put(100020, new g06.a(100020, "android.media.ExifInterface.getAttribute", new String[0], 0, new String[]{"exif", "location"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(Integer.valueOf(SpeechCode.SPEECH_TOKEN_NOT_GET_DID), new g06.a(SpeechCode.SPEECH_TOKEN_NOT_GET_DID, "android.media.ExifInterface.getAttributeDouble", new String[0], 0, new String[]{"exif", "location"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(Integer.valueOf(SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH), new g06.a(SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH, "android.media.ExifInterface.getAttributeInt", new String[0], 0, new String[]{"exif", "location"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(Integer.valueOf(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE), new g06.a(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE, "android.media.MediaMetadataRetriever.extractMetadata", new String[0], 0, new String[]{"exif", "location"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102100, new g06.a(102100, "android.media.projection.MediaProjectionManager.createScreenCaptureIntent", new String[0], 0, new String[]{"screen_record"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102101, new g06.a(102101, "android.media.projection.MediaProjectionManager.getMediaProjection", new String[0], 0, new String[]{"screen_record"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102900, new g06.a(102900, "java.lang.Runtime.exec", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "around"));
        f245611b.put(100400, new g06.a(100400, "android.media.AudioRecord.startRecording", new String[]{"android.permission.RECORD_AUDIO"}, 1, new String[]{"audio"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "around"));
        f245611b.put(100401, new g06.a(100401, "android.media.AudioRecord.stop", new String[]{"android.permission.RECORD_AUDIO"}, 1, new String[]{"audio"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "around"));
        f245611b.put(100403, new g06.a(100403, "android.media.AudioRecord.release", new String[]{"android.permission.RECORD_AUDIO"}, 1, new String[]{"audio"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "around"));
        f245611b.put(100500, new g06.a(100500, "android.media.MediaRecorder.prepare", new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"}, 1, new String[]{"audio", "video"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "around"));
        f245611b.put(100501, new g06.a(100501, "android.media.MediaRecorder.release", new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"}, 1, new String[]{"audio", "video"}, new String[]{"-6215962069689047539", "-6589579158015428227"}, "around"));
        f245611b.put(101800, new g06.a(101800, "android.content.ClipboardManager.clearPrimaryClip", new String[0], 0, new String[]{DataType.CLIPBOARD}, new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(101801, new g06.a(101801, "android.content.ClipboardManager.addPrimaryClipChangedListener", new String[0], 0, new String[]{DataType.CLIPBOARD}, new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(101802, new g06.a(101802, "android.content.ClipboardManager.removePrimaryClipChangedListener", new String[0], 0, new String[]{DataType.CLIPBOARD}, new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(101803, new g06.a(101803, "android.content.ClipboardManager.getPrimaryClip", new String[0], 0, new String[]{DataType.CLIPBOARD}, new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "around"));
        f245611b.put(101804, new g06.a(101804, "android.content.ClipboardManager.getText", new String[0], 0, new String[]{DataType.CLIPBOARD}, new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "around"));
        f245611b.put(101805, new g06.a(101805, "android.content.ClipboardManager.hasPrimaryClip", new String[0], 0, new String[]{DataType.CLIPBOARD}, new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(101806, new g06.a(101806, "android.content.ClipboardManager.hasText", new String[0], 0, new String[]{DataType.CLIPBOARD}, new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(101807, new g06.a(101807, "android.content.ClipboardManager.setPrimaryClip", new String[0], 0, new String[]{DataType.CLIPBOARD}, new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(101808, new g06.a(101808, "android.content.ClipboardManager.setText", new String[0], 0, new String[]{DataType.CLIPBOARD}, new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(101809, new g06.a(101809, "android.content.ClipboardManager.getPrimaryClipDescription", new String[0], 0, new String[]{DataType.CLIPBOARD}, new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(101810, new g06.a(101810, "android.text.ClipboardManager.getText", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "around"));
        f245611b.put(101811, new g06.a(101811, "android.text.ClipboardManager.hasText", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(101812, new g06.a(101812, "android.text.ClipboardManager.setText", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(240018, new g06.a(240018, "android.content.ContentResolver.update", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(240017, new g06.a(240017, "android.content.ContentResolver.insert", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(240020, new g06.a(240020, "android.content.ContentResolver.openFileDescriptor", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(240019, new g06.a(240019, "android.content.ContentResolver.delete", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(240008, new g06.a(240008, "android.content.ContentResolver.acquireUnstableContentProviderClient", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "before"));
        f245611b.put(240004, new g06.a(240004, "android.content.ContentResolver.query", new String[0], 0, new String[]{"album", "calendar", "contact"}, new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "around"));
        f245611b.put(240016, new g06.a(240016, "android.content.ContentResolver.acquireContentProviderClient", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "3971680796841625202", "-6589579158015428227"}, "around"));
        f245611b.put(102605, new g06.a(102605, "android.webkit.PermissionRequest.grant", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102606, new g06.a(102606, "android.webkit.PermissionRequest.deny", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102607, new g06.a(102607, "android.content.Context.checkPermission", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102608, new g06.a(102608, "android.content.Context.checkSelfPermission", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102609, new g06.a(102609, "android.app.Activity.shouldShowRequestPermissionRationale", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102610, new g06.a(102610, "android.app.Fragment.shouldShowRequestPermissionRationale", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102611, new g06.a(102611, "android.app.Activity.onRequestPermissionsResult", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102612, new g06.a(102612, "android.app.Fragment.onRequestPermissionsResult", new String[0], 0, new String[0], new String[]{"-6215962069689047539", "-6589579158015428227"}, "before"));
        f245611b.put(102021, new g06.a(102021, "android.telephony.TelephonyManager.getSimOperator", new String[0], 0, new String[0], new String[]{"-5107019182865140624"}, "around"));
        f245611b.put(Integer.valueOf(SearchCommonConstants.SearchResultType.QUICK_SEARCH_URGENT_RECOMMEND), new g06.a(SearchCommonConstants.SearchResultType.QUICK_SEARCH_URGENT_RECOMMEND, "com.bytedance.bdinstall.oaid.getOaidId", new String[0], 0, new String[0], new String[]{"-5107019182865140624"}, "around"));
        f245611b.put(Integer.valueOf(SearchCommonConstants.SearchResultType.THREAD_GROUP), new g06.a(SearchCommonConstants.SearchResultType.THREAD_GROUP, "com.ss.android.deviceregister.base.Oaid.getOaidId", new String[0], 0, new String[0], new String[]{"-5107019182865140624"}, "around"));
        Iterator<g06.a> r101 = f245611b.values().iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        g06.a r102 = r101.next();
        String[] r103 = r102.a();
        a[] r104 = new a[r103.length];
        int r105 = 0;
    L7:
        if (r105 >= r103.length) goto L9;
        r104[r105] = f245610a.get(r103[r105]);
        r105 = r105 + 1;
        goto L7
    L9:
        r102.c(r104);
        r102.b();
        goto L4
    }

    public ApiHookConfig() {
    }
}
