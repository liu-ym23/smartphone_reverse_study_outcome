package mi7;

import android.content.Context;
import android.text.TextUtils;
import ci7.p;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ug.sdk.deeplink.IZlinkDepend;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f514088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f514089b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Boolean f514090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f514091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f514092e;

    static {
        f514089b = new AtomicBoolean(false);
        f514090c = null;
        f514091d = 0;
        f514092e = false;
    }

    public b() {
    }

    public static boolean a(Context r100) {
        boolean r101 = false;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (f514090c != null) goto L21;
        monitor-enter(b.class);
    L17:
        th = move-exception;
        throw th;
    L10:
        if (f514090c == null) goto L12;
    L15:
        monitor-exit(b.class);     // Catch: Throwable -> L17
        goto L21
    L12:
        if (f514092e == true) goto L14;
        r101 = true;
    L14:
        f514090c = Boolean.valueOf(r101);     // Catch: Throwable -> L17
    L21:
        return f514090c.booleanValue();
    }

    public static boolean b(String r100) {
        IZlinkDepend r101 = p.a();
        if (r101 == null) goto L5;
        List<String> r102 = r101.getDeepLinkActivities();
    L7:
        if (a.a(r102) == false) goto L9;
        return true;
    L9:
        Iterator<String> r103 = r102.iterator();
    L11:
        if (r103.hasNext() == false) goto L15;
        if (r100.equals(r103.next()) == false) goto L11;
        return true;
    L15:
        return false;
    L5:
        r102 = null;
        goto L7
    }

    public static String c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L9;
    L8:
        return r100;
    L9:
        return UriProtector.parse(r100).buildUpon().appendQueryParameter("_zlink_from_applink", "1").build().toString();
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }
}
