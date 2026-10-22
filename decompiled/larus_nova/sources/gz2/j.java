package gz2;

import com.bytedance.android.monitorV2.util.k;
import com.bytedance.android.monitorV2.util.l;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class j extends a {
    @Override // gz2.a
    public final boolean a(k r100) {
        Intrinsics.checkNotNullParameter(r100, "accessor");
        return true;
    }

    public j() {
    }

    @Override // gz2.a
    public final void d(k r100) {
        Intrinsics.checkNotNullParameter(r100, "accessor");
        Long r101 = r100.a(0L);
        if (r101 == null) goto L5;
        long r102 = r101.longValue();
    L7:
        if (r102 <= 0) goto L10;
        c(new a.C6084a(r102, r100));
        return;
    L10:
        return;
    L5:
        r102 = 0;
        goto L7
    }

    @Override // gz2.a
    public final void e(long r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "result");
        a.C6084a r102 = this.f483367e;
        if (r102 == null) goto L7;
        k r103 = r102.f483371b;
        if (r103 == null) goto L7;
        JSONObject r104 = r103.f163240a;
    L8:
        l.p(r101, "res_template_dur", a.b(r104, "res_template_dur"));
        return;
    L7:
        r104 = null;
        goto L8
    }
}
