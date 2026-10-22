package ix5;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f496362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f496363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f496364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<String> f496365d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f496366e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f496367f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set<String> f496368g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile boolean f496369h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile long f496370i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile long f496371j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile boolean f496372k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile long f496373l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile boolean f496374m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile boolean f496375n;

    static {
        f496365d = new CopyOnWriteArraySet();
        f496366e = false;
        f496367f = false;
        f496368g = new CopyOnWriteArraySet();
        f496369h = false;
        f496370i = 60000;
        f496371j = TimeUtils.SECONDS_PER_HOUR;
        f496372k = false;
        f496373l = 10;
        f496374m = false;
        f496375n = false;
    }

    public static boolean a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        String r101 = r100.trim();
        int r102 = r101.indexOf(59);
        if (r102 == (-1)) goto L9;
        r101 = r101.substring(0, r102);
    L9:
        Iterator r103 = ((CopyOnWriteArraySet) f496365d).iterator();
    L11:
        if (r103.hasNext() == false) goto L16;
        if (r101.startsWith(((String) r103.next()) + ContainerUtils.KEY_VALUE_DELIMITER) == false) goto L11;
        return true;
    L16:
        return false;
    }
}
