package sw2;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.android.logsdk.collect.observer.LifecycleLogObserver;
import com.bytedance.android.logsdk.format.Spm;
import com.ss.android.download.api.constant.BaseConstants;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class d extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f543710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<Context> f543711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f543712c;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f543713a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f543714b;

        public b() {
        }

        public final boolean a(String r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "filePath");
            if (TextUtils.equals(this.f543713a, r100) == true) goto L5;
        L8:
            this.f543713a = r100;
            this.f543714b = r101;
            return false;
        L5:
            if (this.f543714b != r101) goto L8;
            return true;
        }
    }

    static {
    }

    public d() {
        super(null);
        this.f543710a = "dump";
        this.f543712c = new b();
    }

    public static int a(Context r100) {
        int r101 = Build.VERSION.SDK_INT;
        int r102 = 32;
        if (r101 < 34) goto L13;
        Context r103 = r100.getApplicationContext();
        if (r103 == null) goto L9;
        ApplicationInfo r104 = r103.getApplicationInfo();
        if (r104 == null) goto L9;
        int r105 = r104.targetSdkVersion;
    L10:
        if (r105 < 34) goto L13;
        return ContextCompat.checkSelfPermission(r100, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED");
    L9:
        r105 = 32;
    L13:
        if (r101 < 33) goto L22;
        Context r106 = r100.getApplicationContext();
        if (r106 == null) goto L19;
        ApplicationInfo r107 = r106.getApplicationInfo();
        if (r107 == null) goto L19;
        r102 = r107.targetSdkVersion;
    L19:
        if (r102 < 33) goto L22;
        int r108 = ContextCompat.checkSelfPermission(r100, BaseConstants.PERMISSION_READ_MEDIA_AUDIO) & ContextCompat.checkSelfPermission(r100, BaseConstants.PERMISSION_READ_MEDIA_VIDEO);
        return ContextCompat.checkSelfPermission(r100, BaseConstants.PERMISSION_READ_MEDIA_IMAGES) & r108;
    L22:
        return ContextCompat.checkSelfPermission(r100, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public static boolean c(String r100) {
        Locale r101 = Locale.ROOT;
        if (r100 == null) goto L13;
        String r102 = r100.toLowerCase(r101);
        String[] r103 = c.f543708c;
        int r104 = r103.length;
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L11;
        if (StringsKt.contains$default(r102, r103[r105], false, 2, null) == true) goto L8;
        r105 = r105 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r110) {
        String r100 = "";
        super.onChange(r110);
        WeakHashMap<tw2.b, Byte> r101 = LifecycleLogObserver.f162663a;     // Catch: Exception -> L11
        Iterator r102 = new HashSet(LifecycleLogObserver.f162663a.keySet()).iterator();     // Catch: Exception -> L11
    L5:
        if (r102.hasNext() == false) goto L9;
        tw2.b r103 = (tw2.b) r102.next();     // Catch: Exception -> L11
        if (r103 == null) goto L5;
        r103.getEnvData();     // Catch: Exception -> L11
        goto L5
    L9:
        Spm.Companion.getClass();     // Catch: Exception -> L11
        vw2.a.a(Spm.a.a("a100.b6000").addArg("selfChange", Boolean.valueOf(r110)), this.f543710a);     // Catch: Exception -> L11
    L16:
        this.f543712c.getClass();
        WeakReference<Context> r111 = this.f543711b;
        if (r111 == null) goto L94;
        Context r112 = r111.get();
        if (r112 == null) goto L118;
        String[] r104 = {"date_added", "_data"};
        Cursor r105 = null;
    L70:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L68
        Spm.Companion.getClass();     // Catch: Throwable -> L68
        Spm r106 = Spm.a.a("a100.b1000").result(101);     // Catch: Throwable -> L68
        String r113 = e.getMessage();     // Catch: Throwable -> L68
        if (r113 != null) goto L74;
        r113 = "";
    L74:
        vw2.a.a(r106.reason(r113).addArg("tag", "ScreenCaptureObserver_onChange"), "crash");     // Catch: Throwable -> L68
        if (0 != 0) goto L97;
    L82:
        this.f543712c.getClass();
        return;
    L97:
        r105.close();     // Catch: SQLException -> L78
    L78:
        e = move-exception;
        Spm.Companion.getClass();
        Spm r107 = Spm.a.a("a100.b1000").result(101);
        String r114 = e.getMessage();
        if (r114 == null) goto L81;
    L36:
        r100 = r114;
    L81:
        vw2.a.a(r107.reason(r100).addArg("tag", "ScreenCaptureObserver_onChange"), "crash");
        goto L82
    L22:
        if (a(r112) == 0) goto L24;
        this.f543712c.getClass();     // Catch: Throwable -> L68 Exception -> L70
        goto L82
    L24:
        Cursor r108 = b(r112.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r104);     // Catch: Throwable -> L68 Exception -> L70
        if (r108 != null) goto L28;
        this.f543712c.getClass();     // Catch: Throwable -> L68 Exception -> L70
        goto L82
    L28:
        if (r108.moveToFirst() == true) goto L37;
        this.f543712c.getClass();     // Catch: Throwable -> L68 Exception -> L70
        r108.close();     // Catch: SQLException -> L32
    L32:
        e = move-exception;
        Spm.Companion.getClass();
        r107 = Spm.a.a("a100.b1000").result(101);
        r114 = e.getMessage();
        if (r114 != null) goto L36;
    L37:
        int r115 = r108.getColumnIndex("_data");     // Catch: Throwable -> L68 Exception -> L70
        int r109 = r108.getColumnIndex("date_added");     // Catch: Throwable -> L68 Exception -> L70
        String r116 = r108.getString(r115);     // Catch: Throwable -> L68 Exception -> L70
        long r117 = r108.getLong(r109);     // Catch: Throwable -> L68 Exception -> L70
        System.currentTimeMillis();     // Catch: Throwable -> L68 Exception -> L70
        if (this.f543712c.a(r116, r117) == true) goto L100;
        long r118 = System.currentTimeMillis() - (r117 * ((long) 1000));     // Catch: Throwable -> L68 Exception -> L70
        long r119 = 2499;
        if (1 <= r118) goto L49;
    L51:
        boolean r120 = false;
    L52:
        if (r120 == true) goto L54;
    L95:
        r108.close();     // Catch: SQLException -> L64
    L64:
        e = move-exception;
        Spm.Companion.getClass();
        r107 = Spm.a.a("a100.b1000").result(101);
        r114 = e.getMessage();
        if (r114 != null) goto L36;
    L54:
        if (c(r116) == false) goto L95;
        Iterator<T> r121 = c.f543707b.values().iterator();     // Catch: Throwable -> L68 Exception -> L70
    L57:
        if (r121.hasNext() == false) goto L95;
        sw2.b r122 = (sw2.b) r121.next();     // Catch: Throwable -> L68 Exception -> L70
        if (r122 == null) goto L57;
        r122.a(r116);     // Catch: Throwable -> L68 Exception -> L70
        goto L57
    L49:
        if (r119 < r118) goto L51;
        r120 = true;
        goto L52
    L100:
        r108.close();     // Catch: SQLException -> L41
    L41:
        e = move-exception;
        Spm.Companion.getClass();
        r107 = Spm.a.a("a100.b1000").result(101);
        r114 = e.getMessage();
        if (r114 != null) goto L36;
    L68:
        th = move-exception;
        if (0 != 0) goto L105;
    L92:
        this.f543712c.getClass();
        throw th;
    L105:
        r105.close();     // Catch: SQLException -> L86
    L86:
        e = move-exception;
        Spm.Companion.getClass();
        Spm r123 = Spm.a.a("a100.b1000").result(101);
        String r124 = e.getMessage();
        if (r124 == null) goto L91;
        r100 = r124;
    L91:
        vw2.a.a(r123.reason(r100).addArg("tag", "ScreenCaptureObserver_onChange"), "crash");
        goto L92
    L118:
        return;
    L94:
        return;
    L11:
        e = move-exception;
        Spm.Companion.getClass();
        Spm r125 = Spm.a.a("a100.b1000").result(101);
        String r126 = e.getMessage();
        if (r126 != null) goto L15;
        r126 = "";
    L15:
        vw2.a.a(r125.reason(r126).addArg("tag", "ScreenCaptureObserver_onChange"), "crash");
        goto L16
    }

    public static Cursor b(ContentResolver r110, Uri r111, String[] r112) {
        f06.c r113 = new f06.c();
        Object[] r114 = {r111, r112, null, null, "date_modified desc"};
        f06.b r115 = new f06.b();
        f06.d r100 = r113.b(240004, "android/content/ContentResolver", "query", r110, r114, "android.database.Cursor", r115);
        if (r100.f474982a == false) goto L6;
        r113.a(240004, "android/content/ContentResolver", "query", r110, r114, null, r115, false);
        return (Cursor) r100.f474983b;
    L6:
        Cursor r101 = r110.query(r111, r112, null, null, "date_modified desc");
        r113.a(240004, "android/content/ContentResolver", "query", r110, r114, r101, r115, true);
        return r101;
    }
}
