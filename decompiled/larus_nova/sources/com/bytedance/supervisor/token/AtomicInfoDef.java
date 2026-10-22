package com.bytedance.supervisor.token;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes22.dex */
@Target({ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/supervisor/token/AtomicInfoDef;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "token_release"}, k = 1, mv = {1, 5, 1})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface AtomicInfoDef {
    public static final String AUDIO_RECORD_START_RECORDING = "android.media.AudioRecord#startRecording()";
    public static final String BIOMETRIC_PROMPT_AUTHENTICATE = "android.hardware.biometrics.BiometricPrompt#authenticate()";
    public static final String BLUETOOTH_ADAPTER_GET_ADDRESS = "android.bluetooth.BluetoothAdapter#getAddress()";
    public static final String BLUETOOTH_DEVICE_GET_ADDRESS = "android.bluetooth.BluetoothDevice#getAddress()";
    public static final String BLUETOOTH_LE_SCANNER_START_SCAN = "android.bluetooth.le.BluetoothLeScanner#startScan()";
    public static final String BLUETOOTH_LE_START_ADVERTISING = "android.bluetooth.le.BluetoothLeAdvertiser#startAdvertising()";
    public static final String BROWSER_GET_ALL_BOOKMARKS = "android.provider.Browser#getAllBookmarks()";
    public static final String BROWSER_GET_ALL_VISITED_URLS = "android.provider.Browser#getAllVisitedUrls()";
    public static final String BUILD_GET_SERIAL = "android.os.Build#getSerial()";
    public static final String BUILD_SERIAL = "android.os.Build.SERIAL";
    public static final String CAMERA_MANAGER_OPEN_CAMERA = "android.hardware.camera2.CameraManager#openCamera()";
    public static final String CAMERA_OPEN = "android.hardware.Camera#open()";
    public static final String CELL_IDENTITY_LTE_GET_TAC = "android.telephony.CellIdentityLte#getTac()";
    public static final String CLIPBOARD_MANAGER_ADD_PRIMARY_CLIP_CHANGED_LISTENER = "android.content.ClipboardManager#addPrimaryClipChangedListener";
    public static final String CLIPBOARD_MANAGER_CLEAR_PRIMARY_CLIP = "android.content.ClipboardManager#clearPrimaryClip()";
    public static final String CLIPBOARD_MANAGER_GET_PRIMARY_CLIP = "android.content.ClipboardManager#getPrimaryClip()";
    public static final String CLIPBOARD_MANAGER_GET_TEXT = "android.content.ClipboardManager#getText()";
    public static final String CLIPBOARD_MANAGER_SET_PRIMARY_CLIP = "android.content.ClipboardManager#setPrimaryClip()";
    public static final String CLIPBOARD_MANAGER_SET_TEXT = "android.content.ClipboardManager#setText()";
    public static final String CONTENT_RESOLVER_APPLY_BATCH_CALENDAR = "android.content.ContentResolver#applyBatch(uri=content://com.android.calendar/)";
    public static final String CONTENT_RESOLVER_APPLY_BATCH_MEDIA = "android.content.ContentResolver#applyBatch(uri=content://media/)";
    public static final String CONTENT_RESOLVER_BULK_INSERT_CALENDAR = "android.content.ContentResolver#bulkInsert(uri=content://com.android.calendar/)";
    public static final String CONTENT_RESOLVER_BULK_INSERT_MEDIA = "android.content.ContentResolver#bulkInsert(uri=content://media/)";
    public static final String CONTENT_RESOLVER_DELETE_CALENDAR = "android.content.ContentResolver#delete(uri=content://com.android.calendar/)";
    public static final String CONTENT_RESOLVER_DELETE_MEDIA = "android.content.ContentResolver#delete(uri=content://media/)";
    public static final String CONTENT_RESOLVER_INSERT_CALENDAR = "android.content.ContentResolver#insert(uri=content://com.android.calendar/)";
    public static final String CONTENT_RESOLVER_INSERT_CONTACTS = "android.content.ContentResolver#insert(uri=content://com.android.contacts)";
    public static final String CONTENT_RESOLVER_INSERT_MEDIA = "android.content.ContentResolver#insert(uri=content://media/)";
    public static final String CONTENT_RESOLVER_QUERY_BROWSER_BOOKMARKS = "android.content.ContentResolver#query(uri=content://browser/bookmarks)";
    public static final String CONTENT_RESOLVER_QUERY_CALENDAR = "android.content.ContentResolver#query(uri=content://com.android.calendar/)";
    public static final String CONTENT_RESOLVER_QUERY_CALL_LOG = "android.content.ContentResolver#query(uri=content://call_log)";
    public static final String CONTENT_RESOLVER_QUERY_CHROME_BROWSER_BOOKMARKS = "android.content.ContentResolver#query(uri=content://com.android.chrome.browser/bookmarks)";
    public static final String CONTENT_RESOLVER_QUERY_CONTACTS = "android.content.ContentResolver#query(uri=content://com.android.contacts)";
    public static final String CONTENT_RESOLVER_QUERY_MEDIA = "android.content.ContentResolver#query(uri=content://media/)";
    public static final String CONTENT_RESOLVER_QUERY_MMS = "android.content.ContentResolver#query(uri=content://mms)";
    public static final String CONTENT_RESOLVER_QUERY_MMS_SMS = "android.content.ContentResolver#query(uri=content://mms-sms)";
    public static final String CONTENT_RESOLVER_QUERY_SMS = "android.content.ContentResolver#query(uri=content://sms)";
    public static final String CONTENT_RESOLVER_UPDATE_CALENDAR = "android.content.ContentResolver#update(uri=content://com.android.calendar/)";
    public static final String CONTENT_RESOLVER_UPDATE_MEDIA = "android.content.ContentResolver#update(uri=content://media/)";
    public static final a Companion = null;
    public static final String FINGERPRINT_MANAGER_AUTHENTICATE = "android.hardware.fingerprint.FingerprintManager#authenticate()";
    public static final String FINGERPRINT_MANAGER_COMPAT_AUTHENTICATE = "FingerprintManagerCompat#authenticate()";
    public static final String ILOCATION_GET_LOCATION = "com.ss.android.lark.location.listener.ILocation#getLocation()";
    public static final String ILOCATION_GET_LOCATION_WITH_OPTION = "com.ss.android.lark.location.listener.ILocation#getLocationWithOption()";
    public static final String ILOCATION_REQUEST_LOCATION = "com.ss.android.lark.location.listener.ILocation#requestLocation()";
    public static final String ILOCATION_REQUEST_LOCATION_WITH_OPTION = "com.ss.android.lark.location.listener.ILocation#requestLocationWithOption()";
    public static final String INET4_ADDRESS_GET_HOST_ADDRESS = "java.net.Inet4Address#getHostAddress()";
    public static final String INET6_ADDRESS_GET_HOST_ADDRESS = "java.net.Inet6Address#getHostAddress()";
    public static final String INET_ADDRESS_GET_HOST_ADDRESS = "java.net.InetAddress#getHostAddress()";
    public static final String LOCATION_MANAGER_GET_CURRENT_LOCATION = "android.location.LocationManager#getCurrentLocation()";
    public static final String LOCATION_MANAGER_GET_LAST_KNOWN_LOCATION = "android.location.LocationManager#getLastKnownLocation()";
    public static final String LOCATION_MANAGER_REQUEST_LOCATION_UPDATES = "android.location.LocationManager#requestLocationUpdates()";
    public static final String LOCATION_MANAGER_REQUEST_SINGLE_UPDATE = "android.location.LocationManager#requestSingleUpdate()";
    public static final String MEDIA_PROJECTION_MANAGER_GET_MEDIA_PROJECTION = "android.media.projection.MediaProjectionManager#getMediaProjection()";
    public static final String MEDIA_RECORDER_START = "android.media.MediaRecorder#start()";
    public static final String MEDIA_SCANNER_SCAN_FILE = "android.content.Intent.ACTION_MEDIA_SCANNER_SCAN_FILE";
    public static final String NETWORK_INTERFACE_GET_HARDWARE_ADDRESS = "java.net.NetworkInterface#getHardwareAddress()";
    public static final String PACKAGE_MANAGER_GET_INSTALLED_APPLICATIONS = "android.content.pm.PackageManager#getInstalledApplications()";
    public static final String PACKAGE_MANAGER_GET_INSTALLED_PACKAGES = "android.content.pm.PackageManager#getInstalledPackages()";
    public static final String PIXEL_COPY_REQUEST = "android.view.PixelCopy#request()";
    public static final String REQUEST_PERMISSIONS_ACCEPT_HANDOVER = "requestPermissions(permission=android.permission.ACCEPT_HANDOVER)";
    public static final String REQUEST_PERMISSIONS_ACCESS_COARSE_LOCATION = "requestPermissions(permission=android.permission.ACCESS_COARSE_LOCATION)";
    public static final String REQUEST_PERMISSIONS_ACCESS_FINE_LOCATION = "requestPermissions(permission=android.permission.ACCESS_FINE_LOCATION)";
    public static final String REQUEST_PERMISSIONS_ACCESS_MEDIA_LOCATION = "requestPermissions(permission=android.permission.ACCESS_MEDIA_LOCATION)";
    public static final String REQUEST_PERMISSIONS_ACTIVITY_RECOGNITION = "requestPermissions(permission=android.permission.ACTIVITY_RECOGNITION)";
    public static final String REQUEST_PERMISSIONS_ADD_VOICEMAIL = "requestPermissions(permission=com.android.voicemail.permission.ADD_VOICEMAIL)";
    public static final String REQUEST_PERMISSIONS_ANSWER_PHONE_CALLS = "requestPermissions(permission=android.permission.ANSWER_PHONE_CALLS)";
    public static final String REQUEST_PERMISSIONS_BLUETOOTH_ADVERTISE = "requestPermissions(permission=android.permission.BLUETOOTH_ADVERTISE)";
    public static final String REQUEST_PERMISSIONS_BLUETOOTH_CONNECT = "requestPermissions(permission=android.permission.BLUETOOTH_CONNECT)";
    public static final String REQUEST_PERMISSIONS_BLUETOOTH_SCAN = "requestPermissions(permission=android.permission.BLUETOOTH_SCAN)";
    public static final String REQUEST_PERMISSIONS_BODY_SENSORS_BACKGROUND = "requestPermissions(permission=android.permission.BODY_SENSORS_BACKGROUND)";
    public static final String REQUEST_PERMISSIONS_CALL_PHONE = "requestPermissions(permission=android.permission.CALL_PHONE)";
    public static final String REQUEST_PERMISSIONS_CAMERA = "requestPermissions(permission=android.permission.CAMERA)";
    public static final String REQUEST_PERMISSIONS_GET_ACCOUNTS_PRIVILEGED = "requestPermissions(permission=android.permission.GET_ACCOUNTS_PRIVILEGED)";
    public static final String REQUEST_PERMISSIONS_PROCESS_OUTGOING_CALLS = "requestPermissions(permission=android.permission.PROCESS_OUTGOING_CALLS)";
    public static final String REQUEST_PERMISSIONS_READ_CALENDAR = "requestPermissions(permission=android.permission.READ_CALENDAR)";
    public static final String REQUEST_PERMISSIONS_READ_CALL_LOG = "requestPermissions(permission=android.permission.READ_CALL_LOG)";
    public static final String REQUEST_PERMISSIONS_READ_CONTACTS = "requestPermissions(permission=android.permission.READ_CONTACTS)";
    public static final String REQUEST_PERMISSIONS_READ_EXTERNAL_STORAGE = "requestPermissions(permission=android.permission.READ_EXTERNAL_STORAGE)";
    public static final String REQUEST_PERMISSIONS_READ_MEDIA_AUDIO = "requestPermissions(permission=android.permission.READ_MEDIA_AUDIO)";
    public static final String REQUEST_PERMISSIONS_READ_MEDIA_IMAGES = "requestPermissions(permission=android.permission.READ_MEDIA_IMAGES)";
    public static final String REQUEST_PERMISSIONS_READ_MEDIA_VIDEO = "requestPermissions(permission=android.permission.READ_MEDIA_VIDEO)";
    public static final String REQUEST_PERMISSIONS_READ_MEDIA_VISUAL = "requestPermissions(permission=android.permission.READ_MEDIA_VISUAL_USER_SELECTED)";
    public static final String REQUEST_PERMISSIONS_READ_PHONE_NUMBERS = "requestPermissions(permission=android.permission.READ_PHONE_NUMBERS)";
    public static final String REQUEST_PERMISSIONS_READ_PHONE_STATE = "requestPermissions(permission=android.permission.READ_PHONE_STATE)";
    public static final String REQUEST_PERMISSIONS_READ_SMS = "requestPermissions(permission=android.permission.READ_SMS)";
    public static final String REQUEST_PERMISSIONS_RECEIVE_MMS = "requestPermissions(permission=android.permission.RECEIVE_MMS)";
    public static final String REQUEST_PERMISSIONS_RECEIVE_SMS = "requestPermissions(permission=android.permission.RECEIVE_SMS)";
    public static final String REQUEST_PERMISSIONS_RECEIVE_WAP_PUSH = "requestPermissions(permission=android.permission.RECEIVE_WAP_PUSH)";
    public static final String REQUEST_PERMISSIONS_RECORD_AUDIO = "requestPermissions(permission=android.permission.RECORD_AUDIO)";
    public static final String REQUEST_PERMISSIONS_SEND_SMS = "requestPermissions(permission=android.permission.SEND_SMS)";
    public static final String REQUEST_PERMISSIONS_USE_SIP = "requestPermissions(permission=android.permission.USE_SIP)";
    public static final String REQUEST_PERMISSIONS_UWB_RANGING = "requestPermissions(permission=android.permission.UWB_RANGING)";
    public static final String REQUEST_PERMISSIONS_WRITE_CALENDAR = "requestPermissions(permission=android.permission.WRITE_CALENDAR)";
    public static final String REQUEST_PERMISSIONS_WRITE_CALL_LOG = "requestPermissions(permission=android.permission.WRITE_CALL_LOG)";
    public static final String REQUEST_PERMISSIONS_WRITE_CONTACTS = "requestPermissions(permission=android.permission.WRITE_CONTACTS)";
    public static final String REQUEST_PERMISSIONS_WRITE_EXTERNAL_STORAGE = "requestPermissions(permission=android.permission.WRITE_EXTERNAL_STORAGE)";
    public static final String RTC_ENABLE_LOCAL_VIDEO = "ByteRtcService#enableLocalVideo()";
    public static final String RTC_MUTE_LOCAL_VIDEO_STREAM = "ByteRtcService#muteLocalVideoStream()";
    public static final String RTC_START_AUDIO_CAPTURE = "ByteRtcService#startAudioCapture()";
    public static final String RTC_START_LOCAL_AUDIO_CAPTURE = "ByteRtcService#startLocalAudioCapture()";
    public static final String RTC_START_PREVIEW = "ByteRtcService#startPreview()";
    public static final String RTC_START_SCREEN_AUDIO_CAPTURE = "ByteRtcService#startScreenAudioCapture()";
    public static final String RTC_START_SCREEN_CAPTURER = "ByteRtcService#startScreenCapturer()";
    public static final String SECURE_GET_STRING_ANDROID_ID = "android.provider.Settings$Secure#getString(name=ANDROID_ID)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_ACCELEROMETER = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_ACCELEROMETER)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_ACCELEROMETER_LIMITED_AXES = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_ACCELEROMETER_LIMITED_AXES)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_ACCELEROMETER_LIMITED_AXES_UNCALIBRATED = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_ACCELEROMETER_LIMITED_AXES_UNCALIBRATED)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_ACCELEROMETER_UNCALIBRATED = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_ACCELEROMETER_UNCALIBRATED)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_AMBIENT_TEMPERATURE = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_AMBIENT_TEMPERATURE)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_DEVICE_PRIVATE_BASE = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_DEVICE_PRIVATE_BASE)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_GAME_ROTATION_VECTOR = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_GAME_ROTATION_VECTOR)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_GEOMAGNETIC_ROTATION_VECTOR = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_GEOMAGNETIC_ROTATION_VECTOR)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_GRAVITY = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_GRAVITY)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_GYROSCOPE = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_GYROSCOPE)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_GYROSCOPE_LIMITED_AXES = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_GYROSCOPE_LIMITED_AXES)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_GYROSCOPE_LIMITED_AXES_UNCALIBRATED = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_GYROSCOPE_LIMITED_AXES_UNCALIBRATED)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_GYROSCOPE_UNCALIBRATED = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_GYROSCOPE_UNCALIBRATED)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_HEADING = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_HEADING)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_HEAD_TRACKER = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_HEAD_TRACKER)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_HEART_BEAT = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_HEART_BEAT)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_HEART_RATE = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_HEART_RATE)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_HINGE_ANGLE = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_HINGE_ANGLE)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_LIGHT = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_LIGHT)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_LINEAR_ACCELERATION = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_LINEAR_ACCELERATION)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_LOW_LATENCY_OFFBODY_DETECT = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_LOW_LATENCY_OFFBODY_DETECT)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_MAGNETIC_FIELD = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_MAGNETIC_FIELD)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_MAGNETIC_FIELD_UNCALIBRATED = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_MAGNETIC_FIELD_UNCALIBRATED)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_MOTION_DETECT = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_MOTION_DETECT)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_ORIENTATION = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_ORIENTATION)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_POSE_6DOF = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_POSE_6DOF)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_PRESSURE = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_PRESSURE)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_PROXIMITY = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_PROXIMITY)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_RELATIVE_HUMIDITY = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_RELATIVE_HUMIDITY)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_ROTATION_VECTOR = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_ROTATION_VECTOR)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_SIGNIFICANT_MOTION = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_SIGNIFICANT_MOTION)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_STATIONARY_DETECT = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_STATIONARY_DETECT)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_STEP_COUNTER = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_STEP_COUNTER)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_STEP_DETECTOR = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_STEP_DETECTOR)";
    public static final String SENSOR_MANAGER_GET_DEFAULT_SENSOR_TYPE_TEMPERATURE = "android.hardware.SensorManager#getDefaultSensor(type=TYPE_TEMPERATURE)";
    public static final String SENSOR_MANAGER_GET_DYNAMIC_SENSOR_LIST = "android.hardware.SensorManager#getDynamicSensorList()";
    public static final String SENSOR_MANAGER_GET_SENSOR_LIST_TYPE_ALL = "android.hardware.SensorManager#getSensorList(type=TYPE_ALL)";
    public static final String SUBSCRIPTION_INFO_GET_ICC_ID = "android.telephony.SubscriptionInfo#getIccId()";
    public static final String SYSTEM_GET_STRING_ANDROID_ID = "android.provider.Settings$System#getString(name=ANDROID_ID)";
    public static final String TELECOM_MANAGER_GET_LINE1_NUMBER = "android.telecom.TelecomManager#getLine1Number()";
    public static final String TELEPHONY_MANAGER_GET_ALL_CELL_INFO = "android.telephony.TelephonyManager#getAllCellInfo()";
    public static final String TELEPHONY_MANAGER_GET_CELL_LOCATION = "android.telephony.TelephonyManager#getCellLocation()";
    public static final String TELEPHONY_MANAGER_GET_DEVICE_ID = "android.telephony.TelephonyManager#getDeviceId()";
    public static final String TELEPHONY_MANAGER_GET_DEVICE_SOFTWARE_VERSION = "android.telephony.TelephonyManager#getDeviceSoftwareVersion()";
    public static final String TELEPHONY_MANAGER_GET_IMEI = "android.telephony.TelephonyManager#getImei()";
    public static final String TELEPHONY_MANAGER_GET_LINE1_NUMBER = "android.telephony.TelephonyManager#getLine1Number()";
    public static final String TELEPHONY_MANAGER_GET_MEID = "android.telephony.TelephonyManager#getMeid()";
    public static final String TELEPHONY_MANAGER_GET_SIM_SERIAL_NUMBER = "android.telephony.TelephonyManager#getSimSerialNumber()";
    public static final String TELEPHONY_MANAGER_GET_SUBSCRIBER_ID = "android.telephony.TelephonyManager#getSubscriberId()";
    public static final String TELEPHONY_MANAGER_LISTEN_LISTEN_CELL_LOCATION = "android.telephony.TelephonyManager#listen(events=LISTEN_CELL_LOCATION)";
    public static final String TELEPHONY_MANAGER_REQUEST_CELL_INFO_UPDATE = "android.telephony.TelephonyManager#requestCellInfoUpdate()";
    public static final String VE_AUDIO_START = "VEAudioRecord#startRecording()";
    public static final String VE_CAMERA_OPEN = "VECamera#open()";
    public static final String WIFI_INFO_GET_BSSID = "android.net.wifi.WifiInfo#getBSSID()";
    public static final String WIFI_INFO_GET_IP_ADDRESS = "android.net.wifi.WifiInfo#getIpAddress()";
    public static final String WIFI_INFO_GET_MAC_ADDRESS = "android.net.wifi.WifiInfo#getMacAddress()";
    public static final String WIFI_INFO_GET_SSID = "android.net.wifi.WifiInfo#getSSID()";
    public static final String WIFI_MANAGER_GET_CONFIGURED_NETWORKS = "android.net.wifi.WifiManager#getConfiguredNetworks()";
    public static final String WIFI_MANAGER_GET_SCAN_RESULTS = "android.net.wifi.WifiManager#getScanResults()";
    public static final String WIFI_MANAGER_START_SCAN = "android.net.wifi.WifiManager#startScan()";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f270345a = null;

        static {
            f270345a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f270345a;
    }
}
