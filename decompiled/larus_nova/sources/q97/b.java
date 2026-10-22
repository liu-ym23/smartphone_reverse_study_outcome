package q97;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.c;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, String> f532134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f532135b;

    public b() {
        this.f532134a = null;
        this.f532135b = new Object();
    }

    @Override // q97.a
    public final boolean b(c r100) {
        String r101 = r100.f267527a;
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return false;
    L5:
        String r102 = u97.b.b(r101);
        if (TextUtils.isEmpty(r102) == false) goto L8;
        return false;
    L8:
        Map<String, String> r103 = this.f532134a;
        if (r103 != null) goto L11;
    L17:
        return false;
    L11:
        if (r103.size() == 0) goto L17;
        String r104 = this.f532134a.get(r102);
        if (TextUtils.isEmpty(r104) == true) goto L17;
        r100.b(r104);
        return true;
    }

    @Override // q97.a
    public final boolean a(Context r100, c r101) {
        String r102 = r101.f267527a;
        String r103 = r101.f267529c;
        Intent r104 = new Intent();
        c r105 = new c();
        SmartRouter.getRouterIntentAdapter();
        c.c(r104, r103, false);
        r105.f267527a = r103;
        if (r105.f267529c.equals(r103) == true) goto L5;
        r105.f267529c = r105.f267527a;
    L5:
        r105.f267528b = r104;
        r105.f267534h = -1;
        r105.f267535i = -1;
        r105.f267537k = null;
        r105.a();
        return false;
    }
}
