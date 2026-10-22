package ooa;

import com.ss.android.cert.manager.permission.PermissionEntity;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f524660a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f524661b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, String> f524662c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, String> f524663d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, String> f524664e = null;

    static {
        f524660a = SetsKt.setOf(new String[]{"android.permission.ACCESS_BACKGROUND_LOCATION", "android.permission.SYSTEM_ALERT_WINDOW", "android.permission.WRITE_SETTINGS", "android.permission.MANAGE_EXTERNAL_STORAGE", "android.permission.REQUEST_INSTALL_PACKAGES", "android.permission.POST_NOTIFICATIONS", "android.permission.BODY_SENSORS_BACKGROUND"});
        Map<String, String> r100 = MapsKt.mapOf(new Pair[]{TuplesKt.to("android.permission.READ_CALENDAR", "android.permission-group.CALENDAR"), TuplesKt.to("android.permission.WRITE_CALENDAR", "android.permission-group.CALENDAR"), TuplesKt.to("android.permission.READ_CALL_LOG", "android.permission-group.CALL_LOG"), TuplesKt.to("android.permission.WRITE_CALL_LOG", "android.permission-group.CALL_LOG"), TuplesKt.to("android.permission.PROCESS_OUTGOING_CALLS", "android.permission-group.CALL_LOG"), TuplesKt.to("android.permission.CAMERA", PermissionEntity.Group.PERMISSION_GROUP_CAMERA), TuplesKt.to("android.permission.READ_CONTACTS", "android.permission-group.CONTACTS"), TuplesKt.to("android.permission.WRITE_CONTACTS", "android.permission-group.CONTACTS"), TuplesKt.to("android.permission.GET_ACCOUNTS", "android.permission-group.CONTACTS"), TuplesKt.to("android.permission.ACCESS_FINE_LOCATION", "android.permission-group.LOCATION"), TuplesKt.to("android.permission.ACCESS_COARSE_LOCATION", "android.permission-group.LOCATION"), TuplesKt.to("android.permission.ACCESS_BACKGROUND_LOCATION", "android.permission-group.LOCATION"), TuplesKt.to("android.permission.RECORD_AUDIO", PermissionEntity.Group.PERMISSION_GROUP_MICROPHONE), TuplesKt.to("android.permission.READ_PHONE_STATE", "android.permission-group.PHONE"), TuplesKt.to("android.permission.READ_PHONE_NUMBERS", "android.permission-group.PHONE"), TuplesKt.to("android.permission.CALL_PHONE", "android.permission-group.PHONE"), TuplesKt.to("android.permission.ANSWER_PHONE_CALLS", "android.permission-group.PHONE"), TuplesKt.to("com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission-group.PHONE"), TuplesKt.to("android.permission.USE_SIP", "android.permission-group.PHONE"), TuplesKt.to("android.permission.ACCEPT_HANDOVER", "android.permission-group.PHONE"), TuplesKt.to("android.permission.BODY_SENSORS", "android.permission-group.SENSORS"), TuplesKt.to("android.permission.ACTIVITY_RECOGNITION", "android.permission-group.ACTIVITY_RECOGNITION"), TuplesKt.to("android.permission.SEND_SMS", "android.permission-group.SMS"), TuplesKt.to("android.permission.RECEIVE_SMS", "android.permission-group.SMS"), TuplesKt.to("android.permission.READ_SMS", "android.permission-group.SMS"), TuplesKt.to("android.permission.RECEIVE_WAP_PUSH", "android.permission-group.SMS"), TuplesKt.to("android.permission.RECEIVE_MMS", "android.permission-group.SMS"), TuplesKt.to("android.permission.READ_EXTERNAL_STORAGE", PermissionEntity.Group.PERMISSION_GROUP_STORAGE), TuplesKt.to("android.permission.WRITE_EXTERNAL_STORAGE", PermissionEntity.Group.PERMISSION_GROUP_STORAGE), TuplesKt.to("android.permission.ACCESS_MEDIA_LOCATION", PermissionEntity.Group.PERMISSION_GROUP_STORAGE)});
        f524661b = r100;
        Map r101 = MapsKt.toMutableMap(MapsKt.mapOf(TuplesKt.to("android.permission.MANAGE_EXTERNAL_STORAGE", PermissionEntity.Group.PERMISSION_GROUP_STORAGE)));
        r101.putAll(r100);
        Map<String, String> r102 = MapsKt.toMap(r101);
        f524662c = r102;
        Map r103 = MapsKt.toMutableMap(MapsKt.mapOf(new Pair[]{TuplesKt.to("android.permission.BLUETOOTH_SCAN", "android.permission-group.NEARBY_DEVICES"), TuplesKt.to("android.permission.BLUETOOTH_ADVERTISE", "android.permission-group.NEARBY_DEVICES"), TuplesKt.to("android.permission.BLUETOOTH_CONNECT", "android.permission-group.NEARBY_DEVICES")}));
        r103.putAll(r102);
        Map<String, String> r104 = MapsKt.toMap(r103);
        f524663d = r104;
        Map r105 = MapsKt.toMutableMap(MapsKt.mapOf(new Pair[]{TuplesKt.to(BaseConstants.PERMISSION_READ_MEDIA_IMAGES, "android.permission-group.READ_MEDIA_VISUAL"), TuplesKt.to(BaseConstants.PERMISSION_READ_MEDIA_VIDEO, "android.permission-group.READ_MEDIA_VISUAL"), TuplesKt.to(BaseConstants.PERMISSION_READ_MEDIA_AUDIO, "android.permission-group.READ_MEDIA_AURAL"), TuplesKt.to("android.permission.POST_NOTIFICATIONS", "android.permission-group.NOTIFICATIONS"), TuplesKt.to("android.permission.NEARBY_WIFI_DEVICES", "android.permission-group.NEARBY_DEVICES"), TuplesKt.to("android.permission.BODY_SENSORS_BACKGROUND", "android.permission-group.SENSORS")}));
        r105.putAll(r104);
        f524664e = MapsKt.toMap(r105);
    }
}
