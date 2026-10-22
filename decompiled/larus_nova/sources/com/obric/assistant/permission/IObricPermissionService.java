package com.obric.assistant.permission;

import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.pia.core.metrics.ErrorType;
import com.larus.platform.api.g1;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cJP\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\bH&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\nH&J(\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\nH&¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/permission/IObricPermissionService;", "Lcom/larus/platform/api/IPermission;", "batchPermissionRequest", "", "activity", "Landroidx/fragment/app/FragmentActivity;", ErrorType.MANIFEST, "", "", "needShowGrantedPermission", "", "showIcon", "fallbackToSingleRequestWhenNoResolveInfo", "forceRuntimeRequestOnFallback", "requestDataCallBack", "Lcom/obric/assistant/permission/IObricPermissionService$IObricRequestPermissionCallback;", "checkPermission", "checkAlbumPermission", "Lcom/obric/assistant/permission/IObricPermissionService$Companion$ObricPermissionStatus;", "isOEMSupportAppListPermission", "goPermissionSettings", WidgetService.PARAM_FRAGMENT, ComplianceResult.JsonKey.PERMISSIONS, "callback", "Lcom/larus/platform/api/IPermission$IRequestPermissionCallback;", "setInterceptGoToSettingsDialog", "intercept", "Companion", "IObricRequestPermissionCallback", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricPermissionService extends g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f391047a = null;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f391048a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final List<String> f391049b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final List<String> f391050c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final List<String> f391051d = null;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/permission/IObricPermissionService$Companion$ObricPermissionStatus;", "", "<init>", "(Ljava/lang/String;I)V", "GRANTED", "DENIED", "LIMITED_GRANTED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum ObricPermissionStatus extends Enum<ObricPermissionStatus> {
            public static final ObricPermissionStatus DENIED = null;
            public static final ObricPermissionStatus GRANTED = null;
            public static final ObricPermissionStatus LIMITED_GRANTED = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ ObricPermissionStatus[] f391052a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f391053b = null;

            public static EnumEntries<ObricPermissionStatus> getEntries() {
                return f391053b;
            }

            static {
                ObricPermissionStatus r100 = new ObricPermissionStatus("GRANTED", 0);
                GRANTED = r100;
                ObricPermissionStatus r101 = new ObricPermissionStatus("DENIED", 1);
                DENIED = r101;
                ObricPermissionStatus r102 = new ObricPermissionStatus("LIMITED_GRANTED", 2);
                LIMITED_GRANTED = r102;
                ObricPermissionStatus[] r103 = {r100, r101, r102};
                f391052a = r103;
                f391053b = EnumEntriesKt.enumEntries(r103);
            }

            public static ObricPermissionStatus[] values() {
                return (ObricPermissionStatus[]) f391052a.clone();
            }

            public static ObricPermissionStatus valueOf(String r100) {
                return (ObricPermissionStatus) r27.a.a(ObricPermissionStatus.class, r100);
            }

            public ObricPermissionStatus(String r100, int r101) {
                super(r100, r101);
            }
        }

        public Companion() {
        }

        static {
            f391048a = new Companion();
            ArrayList r100 = new ArrayList();
            r100.add("android.permission.RECORD_AUDIO");
            r100.add("android.permission.READ_SMS");
            r100.add("android.permission.READ_CONTACTS");
            r100.add("android.permission.READ_CALL_LOG");
            r100.add("android.permission.READ_CALENDAR");
            r100.add("android.permission.WRITE_CALENDAR");
            r100.add("android.permission.ACCESS_COARSE_LOCATION");
            r100.add("android.permission.ACCESS_FINE_LOCATION");
            int r101 = Build.VERSION.SDK_INT;
            if (r101 < 29) goto L6;
            r100.add("android.permission.ACCESS_BACKGROUND_LOCATION");
        L6:
            if (r101 < 31) goto L9;
            r100.add("android.permission.BLUETOOTH_CONNECT");
        L9:
            if (r101 < 31) goto L12;
            r100.add("android.permission.BLUETOOTH_SCAN");
        L12:
            if (r101 < 31) goto L15;
            r100.add("android.permission.BLUETOOTH_ADVERTISE");
        L15:
            if (r101 < 33) goto L18;
            r100.add("android.permission.NEARBY_WIFI_DEVICES");
        L18:
            if (r101 < 33) goto L21;
            r100.add("android.permission.POST_NOTIFICATIONS");
        L21:
            if (r101 < 33) goto L24;
            r100.add(BaseConstants.PERMISSION_READ_MEDIA_IMAGES);
        L24:
            if (r101 < 33) goto L26;
            r100.add(BaseConstants.PERMISSION_READ_MEDIA_VIDEO);
        L26:
            r100.add("com.android.permission.GET_INSTALLED_APPS");
            f391049b = CollectionsKt.toList(r100);
            ArrayList r102 = new ArrayList();
            r102.add("android.permission.RECORD_AUDIO");
            r102.add("android.permission.READ_SMS");
            r102.add("android.permission.READ_CONTACTS");
            r102.add("android.permission.READ_CALL_LOG");
            r102.add("android.permission.READ_CALENDAR");
            r102.add("android.permission.WRITE_CALENDAR");
            r102.add("android.permission.ACCESS_FINE_LOCATION");
            if (r101 < 31) goto L29;
            r102.add("android.permission.BLUETOOTH_CONNECT");
        L29:
            if (r101 < 31) goto L31;
            r102.add("android.permission.BLUETOOTH_SCAN");
        L31:
            if (r101 < 31) goto L34;
            r102.add("android.permission.BLUETOOTH_ADVERTISE");
        L34:
            if (r101 < 33) goto L36;
            r102.add("android.permission.NEARBY_WIFI_DEVICES");
        L36:
            if (r101 < 33) goto L38;
            r102.add("android.permission.POST_NOTIFICATIONS");
        L38:
            if (r101 < 33) goto L40;
            r102.add(BaseConstants.PERMISSION_READ_MEDIA_IMAGES);
        L40:
            if (r101 < 33) goto L42;
            r102.add(BaseConstants.PERMISSION_READ_MEDIA_VIDEO);
        L42:
            r102.add("com.android.permission.GET_INSTALLED_APPS");
            f391050c = CollectionsKt.toList(r102);
            ArrayList r103 = new ArrayList();
            r103.add("android.permission.RECORD_AUDIO");
            f391051d = CollectionsKt.toList(r103);
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public interface a {
        void a(boolean r100, boolean r101, List<String> r102, List<String> r103);
    }

    static {
        f391047a = Companion.f391048a;
    }

    void c();

    boolean checkPermission(String r100);

    void e(FragmentActivity r100, List<String> r101, g1.c r102);

    Companion.ObricPermissionStatus h();

    void n(FragmentActivity r100, List<String> r101, boolean r102, boolean r103, boolean r104, boolean r105, a r106);

    boolean o();
}
