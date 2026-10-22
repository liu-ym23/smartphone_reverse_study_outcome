package ph;

import android.content.Context;
import com.bytedance.android.ec.core.opt.ab.j;
import com.bytedance.android.ec.sdk.ECSdk;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f529226a = 0;

    static {
        j.a().b();
        j.a().a();
    }

    public static void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = ECSdk.f48106a;
        cj.b r102 = (cj.b) ECSdk.a(cj.b.class);
        if (r102 == null) goto L6;
        r102.e(r100);
        return;
    }
}
