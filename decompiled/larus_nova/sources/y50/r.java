package y50;

import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f566228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f566229b;

    public r(String r100, WidgetCostModule r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, ChameleonOpenTracker.ParamKey.COST);
        this.f566229b = r100;
        long r102 = r101.getTotal();
        long r103 = r101.getInflateDuration();
        if (r101.isAsync == false) goto L5;
        r102 = r102 - r103;
    L5:
        this.f566228a = (int) r102;
    }
}
