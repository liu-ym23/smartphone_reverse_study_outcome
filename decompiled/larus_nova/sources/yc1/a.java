package yc1;

import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f567128a = 0;

    static {
    }

    public static void a(boolean r100) {
        Map<String, String> r101 = MapsKt.mapOf(new Pair[]{TuplesKt.to("active", "true"), TuplesKt.to(EventConstant.MSSecEvent.CAMERA_PREVIEW, String.valueOf(r100))});
        IPerformanceManager r102 = (IPerformanceManager) k.f(IPerformanceManager.class);
        if (r102 == null) goto L6;
        r102.onModuleStart("virtual_live", r101);
        return;
    }
}
