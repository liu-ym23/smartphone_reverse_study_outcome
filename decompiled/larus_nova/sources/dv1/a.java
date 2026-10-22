package dv1;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import f06.d;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f470135g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f470136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PthreadHandlerThreadV2 f470137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f470138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f470139d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f470140e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final WeakReference<Context> f470141f;

    /* JADX INFO: renamed from: dv1.a$a, reason: collision with other inner class name */
    public static final class C5709a {
    }

    static {
        f470135g = new String[]{IHostShare.ShareType.SCREENSHOT, "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap", "screenrecord", "screen_record", "screen-record", "screen record"};
    }

    public final boolean b() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 33) goto L11;
        Context r101 = this.f470141f.get();
        if (r101 != null) goto L7;
    L9:
        return false;
    L7:
        if (ContextCompat.checkSelfPermission(r101, BaseConstants.PERMISSION_READ_MEDIA_VIDEO) != 0) goto L9;
        return true;
    L11:
        if (r100 < 30) goto L17;
        Context r102 = this.f470141f.get();
        if (r102 == null) goto L9;
        if (ContextCompat.checkSelfPermission(r102, "android.permission.READ_EXTERNAL_STORAGE") != 0) goto L9;
        return true;
    L17:
        Context r103 = this.f470141f.get();
        if (r103 == null) goto L9;
        if (ContextCompat.checkSelfPermission(r103, "android.permission.READ_EXTERNAL_STORAGE") != 0) goto L9;
        return true;
    }

    public a(WeakReference<Context> r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f470141f = r100;
        this.f470139d = new HashSet();
        this.f470140e = new HashSet();
    }

    public static Cursor a(ContentResolver r110, Uri r111, String[] r112) {
        f06.c r113 = new f06.c();
        Object[] r114 = {r111, r112, null, null, "date_added DESC"};
        f06.b r115 = new f06.b();
        d r100 = r113.b(240004, "android/content/ContentResolver", "query", r110, r114, "android.database.Cursor", r115);
        if (r100.f474982a == false) goto L6;
        r113.a(240004, "android/content/ContentResolver", "query", r110, r114, null, r115, false);
        return (Cursor) r100.f474983b;
    L6:
        Cursor r101 = r110.query(r111, r112, null, null, "date_added DESC");
        r113.a(240004, "android/content/ContentResolver", "query", r110, r114, r101, r115, true);
        return r101;
    }
}
