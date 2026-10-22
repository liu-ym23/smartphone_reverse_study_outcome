package fo6;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<d> f478167a = null;

    public e() {
    }

    static {
        f478167a = new CopyOnWriteArrayList();
    }

    public static void a(d r100) {
        Intrinsics.checkNotNullParameter(r100, PrefetchTiming.ROUTER);
        int r101 = f478167a.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        CopyOnWriteArrayList<d> r103 = f478167a;
        if (Intrinsics.areEqual(r103.get(r102).getClass(), r100.getClass()) == true) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        r103.set(r102, r100);
        return;
    L9:
        f478167a.add(r100);
    }

    public static d b(Uri r100) {
        Iterator<d> r101 = f478167a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        d r102 = r101.next();
        if (r102.a(r100) == false) goto L4;
        return r102;
    L8:
        return null;
    }

    public static boolean d(Context r100, Uri r101) {
        Intent r102 = new Intent();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r102, "extra");
        d r103 = b(r101);
        if (r103 != null) goto L5;
        return false;
    L5:
        f.a(r102, r101.toString());
        if ((r100 instanceof Activity) == true) goto L8;
        r102.addFlags(268435456);
    L8:
        r102.setData(r101);
        r103.b(r100, r101, r102);
        return true;
    }

    public static /* synthetic */ boolean e(Context r100, String r101) {
        return c(r100, r101, new Intent());
    }

    public static boolean c(Context r100, String r101, Intent r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "schema");
        Intrinsics.checkNotNullParameter(r102, "extra");
        Uri r103 = UriProtector.parse(r101);     // Catch: Exception -> L12
        d r104 = b(r103);
        if (r104 != null) goto L7;
        return false;
    L7:
        f.a(r102, r101);
        if ((r100 instanceof Activity) == true) goto L10;
        r102.addFlags(268435456);
    L10:
        r102.setData(r103);
        r104.b(r100, r103, r102);
        return true;
    L12:
        return false;
    }
}
