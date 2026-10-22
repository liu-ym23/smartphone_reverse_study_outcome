package mp6;

import com.bytedance.locallife.dito.Dito;
import com.bytedance.locallife.dito.utils.l;
import kotlin.jvm.internal.Intrinsics;
import mq6.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements dq6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f514720a = null;

    static {
        f514720a = new a();
    }

    public a() {
    }

    @Override // dq6.a
    public final void a(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        rq6.a.f538927a.c("DitoDataTrace", "uploadStatics " + r100 + ",params:" + r101);
        Dito r102 = Dito.f257280a;
        d r103 = l.h();
        if (r103 == null) goto L8;
        if (r101 != null) goto L6;
        r101 = new JSONObject();
    L6:
        ((en6.l) r103).c(r100, r101);
        return;
    }
}
