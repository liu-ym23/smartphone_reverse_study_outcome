package k7;

import com.bytedance.android.annie.param.AnnieXLiveContext;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {
    public static final String c(AnnieXLiveContext r100) {
        StringBuilder r101 = new StringBuilder("[");
        if (r100 == null) goto L6;
        String r102 = Integer.valueOf(r100.hashCode()).toString();
        if (r102 == null) goto L6;
    L7:
        r101.append(r102);
        r101.append(']');
        return r101.toString();
    L6:
        r102 = "unknown";
        goto L7
    }

    public static final void a(String r100, String r101, AnnieXLiveContext r102) {
        Intrinsics.checkNotNullParameter(HybridLogger.f246343a, "<this>");
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        HybridLogger.i(r100, c(r102) + r101, null, 12);
    }

    public static final void b(String r100, String r101, AnnieXLiveContext r102) {
        Intrinsics.checkNotNullParameter(HybridLogger.f246343a, "<this>");
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        HybridLogger.m(r100, c(r102) + r101, null, null, 12);
    }
}
