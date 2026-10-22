package wa8;

import com.larus.im.FlowRuntime;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, Integer> f558857a = null;

    static {
        Pair[] r100 = new Pair[19];
        int r101 = 0;
        r100[0] = TuplesKt.to(1, 0);
        r100[1] = TuplesKt.to(2, 0);
        r100[2] = TuplesKt.to(3, 0);
        r100[3] = TuplesKt.to(4, 0);
        if (FlowRuntime.b().a().appId() != 482431) goto L6;
        r101 = 101;
    L6:
        r100[4] = TuplesKt.to(5, Integer.valueOf(r101));
        r100[5] = TuplesKt.to(6, 0);
        r100[6] = TuplesKt.to(7, 0);
        r100[7] = TuplesKt.to(29, 0);
        r100[8] = TuplesKt.to(8, 0);
        r100[9] = TuplesKt.to(9, 0);
        r100[10] = TuplesKt.to(11, 0);
        r100[11] = TuplesKt.to(12, 0);
        r100[12] = TuplesKt.to(13, 0);
        r100[13] = TuplesKt.to(15, 0);
        r100[14] = TuplesKt.to(16, 0);
        r100[15] = TuplesKt.to(18, 1);
        r100[16] = TuplesKt.to(22, 0);
        r100[17] = TuplesKt.to(20, 0);
        r100[18] = TuplesKt.to(24, 1);
        f558857a = MapsKt.mapOf(r100);
    }
}
