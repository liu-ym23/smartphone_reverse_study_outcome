package yh2;

import com.bytedance.android.ec.model.live.ECPromotionInterationData;
import com.bytedance.android.ec.model.live.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f567548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ECPromotionInterationData> f567549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<ECPromotionInterationData> f567550c;

    public final synchronized List<ECPromotionInterationData> b() {
        monitor-enter(this);
        ArrayList r100 = new ArrayList();     // Catch: Throwable -> L6
        r100.addAll(this.f567549b);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public a() {
        this.f567548a = true;
        this.f567549b = new ArrayList();
    }

    public static boolean a(List r100, m r101) {
        if (r101 != null) goto L5;
        return true;
    L5:
        Iterator r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L19;
        ql.a r103 = (ql.a) r102.next();
        if (Intrinsics.areEqual(r103.getProductId(), String.valueOf(r101.b())) == false) goto L7;
        if (r101.a() == r103.getIronIndex()) goto L18;
        return false;
    L18:
        return true;
    L19:
        return true;
    }
}
