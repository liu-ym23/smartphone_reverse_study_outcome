package l1c;

import android.content.Context;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.preload.v2.api.IPrimaryTabService;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d extends k1c.a<String> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f507087d;

    public static final class a {
    }

    static {
    }

    @Override // k1c.a
    public final String n() {
        String r100 = this.f507087d;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public d() {
    }

    @Override // k1c.a, k1c.b
    public final void j(Context r100, e1c.d r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "manager");
        super.j(r100, r101);
        this.f507087d = ((IPrimaryTabService) LarkContext.spiByDwarf(IPrimaryTabService.class)).getDefaultTabName();
        Log.i("Detector/PrimaryTabDetector", "init:" + this.f507087d);
    }
}
