package v19;

import android.os.Build;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.download.api.constant.BaseConstants;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes27.dex */
public final class e6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e6 f552469a = null;

    static {
        f552469a = new e6();
    }

    public e6() {
    }

    public static String a() {
        Object r100 = "disable";
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L22
        com.larus.platform.service.k2 r102 = com.larus.platform.service.k2.f365755a;     // Catch: Throwable -> L22
        if (com.larus.platform.api.g3.a.d() == false) goto L7;
        FLogger.f375446a.i("PermissionStatusHelper", "getAlbumStatus() = open");     // Catch: Throwable -> L22
        Object r103 = Result.m9449constructorimpl("open");     // Catch: Throwable -> L22
    L24:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 != null) goto L27;
        r100 = r103;
    L29:
        return (String) r100;
    L27:
        FLogger.f375446a.e("PermissionStatusHelper", "getAlbumStatus error", r104);
        goto L29
    L7:
        if (Build.VERSION.SDK_INT < 33) goto L9;
        String r105 = BaseConstants.PERMISSION_READ_MEDIA_IMAGES;
    L30:
        Object r106 = Result.m9449constructorimpl(Boolean.valueOf(com.larus.platform.service.i2.f365748b.d(r105)));     // Catch: Throwable -> L12
    L14:
        Boolean r107 = Boolean.FALSE;     // Catch: Throwable -> L22
        if (Result.m9455isFailureimpl(r106) == false) goto L18;
        r106 = r107;
    L18:
        if (((Boolean) r106).booleanValue() == true) goto L33;
        return "request_authorization";
    L33:
        return "disable";
    L12:
        th = move-exception;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L22
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L22
        goto L14
    L9:
        r105 = "android.permission.READ_EXTERNAL_STORAGE";
    L22:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    }

    public final String b() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        String r101 = d(this, "android.permission.CAMERA", "camera_disable", "camera_open", 2);     // Catch: Throwable -> L5
        FLogger.f375446a.i("PermissionStatusHelper", "getCameraStatus() = " + r101);     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(r101);     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L12;
        FLogger.f375446a.e("PermissionStatusHelper", "getCameraStatus error", r103);
        r102 = "request_authorization";
    L12:
        return (String) r102;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final String c() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        String r101 = d(this, "android.permission.RECORD_AUDIO", null, null, 14);     // Catch: Throwable -> L5
        FLogger.f375446a.i("PermissionStatusHelper", "getMicStatus() = " + r101);     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(r101);     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L12;
        FLogger.f375446a.e("PermissionStatusHelper", "getMicStatus error", r103);
        r102 = "disable";
    L12:
        return (String) r102;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static String d(e6 r100, String r101, String r102, String r103, int r104) {
        if ((r104 & 2) == 0) goto L5;
        String r105 = "request_authorization";
    L7:
        if ((r104 & 4) == 0) goto L10;
        r102 = "disable";
    L10:
        if ((r104 & 8) == 0) goto L12;
        r103 = "open";
    L12:
        r100.getClass();
        if (ContextCompat.checkSelfPermission(AppHost.f326268a.getApplication(), r101) != 0) goto L15;
        boolean r106 = true;
    L16:
        if (r106 == true) goto L32;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L20
        Object r108 = Result.m9449constructorimpl(Boolean.valueOf(com.larus.platform.service.i2.f365748b.d(r101)));     // Catch: Throwable -> L20
    L22:
        Boolean r109 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r108) == false) goto L26;
        r108 = r109;
    L26:
        if (((Boolean) r108).booleanValue() == false) goto L29;
        r105 = r102;
    L29:
        return r105;
    L20:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    L32:
        return r103;
    L15:
        r106 = false;
        goto L16
    L5:
        r105 = null;
        goto L7
    }
}
