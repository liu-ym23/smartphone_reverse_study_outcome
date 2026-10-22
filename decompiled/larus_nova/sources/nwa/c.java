package nwa;

import android.os.SystemClock;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.authorization.AllPermissionData;
import com.ss.android.lark.pb.authorization.EntityType;
import com.ss.android.lark.pb.authorization.PermissionType;
import com.ss.android.lark.pb.authorization.ResultType;
import com.ss.android.lark.sdk.SdkSender;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f521017a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f521018b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f521019c = null;

        static {
            int[] r100 = new int[EntityType.values().length];
            f521019c = r100;
            r100[EntityType.ANY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L61
        L129:
            f521019c[EntityType.USER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L62
        L153:
            f521019c[EntityType.IM_IMAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L63
        L169:
            f521019c[EntityType.IM_VIDEO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L64
        L171:
            f521019c[EntityType.IM_FILE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L65
        L111:
            f521019c[EntityType.CCM_DOC.ordinal()] = 6;     // Catch: NoSuchFieldError -> L66
        L115:
            f521019c[EntityType.CCM_SHEET.ordinal()] = 7;     // Catch: NoSuchFieldError -> L67
        L141:
            f521019c[EntityType.CCM_BITABLE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L68
        L149:
            f521019c[EntityType.CCM_MINDNOTE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L69
        L177:
            f521019c[EntityType.CCM_FILE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L70
        L183:
            f521019c[EntityType.CCM_SLIDE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L71
        L119:
            f521019c[EntityType.ENTITY_TYPE_UNKNOWN.ordinal()] = 12;     // Catch: NoSuchFieldError -> L72
        L26:
            int[] r110 = new int[PermissionType.values().length];
            f521018b = r110;
            r110[PermissionType.PERMISSION_TYPE_UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L73
        L157:
            f521018b[PermissionType.FILE_UPLOAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L74
        L159:
            f521018b[PermissionType.FILE_IMPORT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L75
        L175:
            f521018b[PermissionType.FILE_DOWNLOAD.ordinal()] = 4;     // Catch: NoSuchFieldError -> L76
        L109:
            f521018b[PermissionType.FILE_EXPORT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L77
        L125:
            f521018b[PermissionType.FILE_PRINT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L78
        L127:
            f521018b[PermissionType.FILE_APP_OPEN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L79
        L139:
            f521018b[PermissionType.FILE_ACCESS_FOLDER.ordinal()] = 8;     // Catch: NoSuchFieldError -> L80
        L165:
            f521018b[PermissionType.FILE_READ.ordinal()] = 9;     // Catch: NoSuchFieldError -> L81
        L181:
            f521018b[PermissionType.FILE_EDIT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L82
        L185:
            f521018b[PermissionType.FILE_COMMENT.ordinal()] = 11;     // Catch: NoSuchFieldError -> L83
        L107:
            f521018b[PermissionType.FILE_COPY.ordinal()] = 12;     // Catch: NoSuchFieldError -> L84
        L135:
            f521018b[PermissionType.FILE_DELETE.ordinal()] = 13;     // Catch: NoSuchFieldError -> L85
        L137:
            f521018b[PermissionType.FILE_SHARE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L86
        L167:
            f521018b[PermissionType.SEARCH.ordinal()] = 15;     // Catch: NoSuchFieldError -> L87
        L173:
            f521018b[PermissionType.LOCAL_FILE_SHARE.ordinal()] = 16;     // Catch: NoSuchFieldError -> L88
        L113:
            f521018b[PermissionType.LOCAL_FILE_PREVIEW.ordinal()] = 17;     // Catch: NoSuchFieldError -> L89
        L117:
            f521018b[PermissionType.DOC_PREVIEW_AND_OPEN.ordinal()] = 18;     // Catch: NoSuchFieldError -> L90
        L145:
            f521018b[PermissionType.PRIVACY_GPS_LOCATION.ordinal()] = 19;     // Catch: NoSuchFieldError -> L91
        L151:
            f521018b[PermissionType.PC_PASTE_PROTECTION.ordinal()] = 20;     // Catch: NoSuchFieldError -> L92
        L179:
            f521018b[PermissionType.WEB_PASTE_PROTECTION.ordinal()] = 21;     // Catch: NoSuchFieldError -> L93
        L187:
            f521018b[PermissionType.MOBILE_PASTE_PROTECTION.ordinal()] = 22;     // Catch: NoSuchFieldError -> L94
        L123:
            f521018b[PermissionType.MOBILE_SCREEN_PROTECT.ordinal()] = 23;     // Catch: NoSuchFieldError -> L95
        L131:
            f521018b[PermissionType.PC_SCREEN_PROTECT.ordinal()] = 24;     // Catch: NoSuchFieldError -> L96
        L155:
            f521018b[PermissionType.DOC_DOWNLOAD.ordinal()] = 25;     // Catch: NoSuchFieldError -> L97
        L163:
            f521018b[PermissionType.DOC_EXPORT.ordinal()] = 26;     // Catch: NoSuchFieldError -> L98
        L191:
            f521018b[PermissionType.DOC_PRINT.ordinal()] = 27;     // Catch: NoSuchFieldError -> L99
        L105:
            f521018b[PermissionType.BAIKE_REPO_VIEW.ordinal()] = 28;     // Catch: NoSuchFieldError -> L100
        L133:
            f521018b[PermissionType.SDK_SWITCH.ordinal()] = 29;     // Catch: NoSuchFieldError -> L101
        L56:
            int[] r101 = new int[ResultType.values().length];
            f521017a = r101;
            r101[ResultType.Deny.ordinal()] = 1;     // Catch: NoSuchFieldError -> L102
        L161:
            f521017a[ResultType.Null.ordinal()] = 2;     // Catch: NoSuchFieldError -> L103
        L189:
            f521017a[ResultType.Allow.ordinal()] = 3;     // Catch: NoSuchFieldError -> L104
            return;
        }
    }

    public static int a(EntityType r100) {
        switch(a.f521019c[r100.ordinal()]) {
            case 1: goto L26;
            case 2: goto L24;
            case 3: goto L22;
            case 4: goto L20;
            case 5: goto L18;
            case 6: goto L16;
            case 7: goto L14;
            case 8: goto L12;
            case 9: goto L10;
            case 10: goto L8;
            case 11: goto L6;
            default: goto L4;
        };
    L4:
        return 0;
    L6:
        return 11;
    L8:
        return 10;
    L10:
        return 9;
    L12:
        return 8;
    L14:
        return 7;
    L16:
        return 6;
    L18:
        return 5;
    L20:
        return 4;
    L22:
        return 3;
    L24:
        return 2;
    L26:
        return 1;
    }

    public static boolean b(AllPermissionData r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
        Log.i("AuditPerm_DataService", "PermissionUtil: allPermissionData == null");
    L17:
        Log.i("AuditPerm_DataService", "PermissionUtil: isExpired == " + r101);
        return r101;
    L5:
        mwa.a r102 = mwa.a.C6865a.f515996a;
        if (r102.f515994a != 0) goto L8;
    L11:
        r102.f515994a = SdkSender.getNtpTime();
        r102.f515995b = SystemClock.elapsedRealtime();
        long r103 = r102.f515994a;
    L13:
        if ((r100.mexpire_time.longValue() * 1000) < r103) goto L16;
        r101 = false;
    L16:
        Log.i("AuditPerm_DataService", "PermissionUtil nowNtpTime = " + r103 + ",systemTime=" + System.currentTimeMillis() + ",allPermissionData.mexpire_time=" + r100.mexpire_time);
        goto L17
    L8:
        if ((SystemClock.elapsedRealtime() - r102.f515995b) > 30000) goto L11;
        r103 = r102.f515994a + (SystemClock.elapsedRealtime() - r102.f515995b);
        goto L13
    }

    public static int c(PermissionType r100) {
        switch(a.f521018b[r100.ordinal()]) {
            case 2: goto L60;
            case 3: goto L58;
            case 4: goto L56;
            case 5: goto L54;
            case 6: goto L52;
            case 7: goto L50;
            case 8: goto L48;
            case 9: goto L46;
            case 10: goto L44;
            case 11: goto L42;
            case 12: goto L40;
            case 13: goto L38;
            case 14: goto L36;
            case 15: goto L34;
            case 16: goto L32;
            case 17: goto L30;
            case 18: goto L28;
            case 19: goto L26;
            case 20: goto L24;
            case 21: goto L22;
            case 22: goto L20;
            case 23: goto L18;
            case 24: goto L16;
            case 25: goto L14;
            case 26: goto L12;
            case 27: goto L10;
            case 28: goto L8;
            case 29: goto L6;
            default: goto L4;
        };
    L4:
        return 0;
    L6:
        return 28;
    L8:
        return 27;
    L10:
        return 26;
    L12:
        return 25;
    L14:
        return 24;
    L16:
        return 23;
    L18:
        return 22;
    L20:
        return 21;
    L22:
        return 20;
    L24:
        return 19;
    L26:
        return 18;
    L28:
        return 17;
    L30:
        return 16;
    L32:
        return 15;
    L34:
        return 14;
    L36:
        return 13;
    L38:
        return 12;
    L40:
        return 11;
    L42:
        return 10;
    L44:
        return 9;
    L46:
        return 8;
    L48:
        return 7;
    L50:
        return 6;
    L52:
        return 5;
    L54:
        return 4;
    L56:
        return 3;
    L58:
        return 2;
    L60:
        return 1;
    }

    public static int d(ResultType r100) {
        int r101 = a.f521017a[r100.ordinal()];
        int r102 = 1;
        if (r101 == 1) goto L10;
        r102 = 3;
        if (r101 == 2) goto L10;
        if (r101 == 3) goto L9;
        return 0;
    L9:
        return 2;
    L10:
        return r102;
    }

    public static void e(int r100, int r101) {
        if (r100 != 1) goto L5;
        String r102 = "deny";
    L15:
        b r103 = b.a.f521016a;
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L18
        r104.put("type", "audit_check_auth");     // Catch: JSONException -> L18
        r104.put("check_auth_result", r102);     // Catch: JSONException -> L18
        r103.c("audit_sdk_overall", r104, null, null);     // Catch: JSONException -> L18
    L20:
        Log.i("AuditPerm_DataService", "doCheck permissionType: " + r101 + ", result: " + r102);
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        Log.e("Audit_Monitor", e.getMessage(), e);
        goto L20
    L5:
        if (r100 != 2) goto L7;
        r102 = "allow";
        goto L15
    L7:
        if (r100 != 3) goto L9;
        r102 = "null";
        goto L15
    L9:
        if (r100 == 4) goto L11;
        r102 = "unknown";
        goto L15
    L11:
        r102 = "error";
        goto L15
    }
}
