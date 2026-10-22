package j36;

import com.bytedance.ies.bullet.core.k;
import com.bytedance.ies.bullet.service.base.c1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f497118a = 0;

    static {
    }

    public static void a(c1 r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r101, "monitorContext");
        if (r100.f247794d != null) goto L5;
        r100.f247794d = new JSONObject();
    L5:
        JSONObject r102 = r100.f247794d;
        if (r102 == null) goto L9;
        k36.a.b(r102, r101.f246518d);
    L9:
        if (r100.f247795e != null) goto L11;
        r100.f247795e = new JSONObject();
    L11:
        JSONObject r103 = r100.f247795e;
        if (r103 == null) goto L15;
        k36.a.b(r103, r101.f246519e);
        return;
    }
}
