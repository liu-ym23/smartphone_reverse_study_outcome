package m71;

import com.tencent.connect.common.Constants;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f512327a = 0;

    public static boolean a() {
        return b.f512324a.getValue().b();
    }

    public static boolean b() {
        return b.f512324a.getValue().c();
    }

    public static boolean d() {
        return b.f512324a.getValue().f();
    }

    static {
    }

    public static boolean c(int r100) {
        b r101 = b.f512324a;
        Map<String, Boolean> r102 = r101.getValue().i();
        if (r102 != null) goto L5;
    L7:
        Map<String, Boolean> r103 = r101.getValue().i();
        if (r103 == null) goto L13;
        Boolean r104 = r103.get(String.valueOf(r100));
        if (r104 != null) goto L12;
        return true;
    L12:
        return r104.booleanValue();
    L13:
        return true;
    L5:
        if (r102.isEmpty() != true) goto L7;
        r101.getValue().l(MapsKt.hashMapOf(new Pair[]{TuplesKt.to(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Boolean.FALSE)}));
        goto L7
    }
}
