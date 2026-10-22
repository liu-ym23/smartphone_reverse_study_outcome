package wt4;

import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSONObject;
import eu5.b;
import eu5.c;
import vv4.k;

/* JADX INFO: loaded from: classes15.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f561215a;

    public a(k r100) {
        this.f561215a = r100;
    }

    public final void l(String r100, JSONObject r101) {
        k r102 = this.f561215a;
        if (r102 == null) goto L6;
        r102.j(r100, r101);
        return;
    L6:
        if (c.b(b.f474075a) == true) goto L9;
        return;
    L9:
        throw new IllegalStateException("UN EXPECT STATE");
    }

    public final void m(String r100, JSONObject r101, ValueCallback<String> r102) {
        k r103 = this.f561215a;
        if (r103 == null) goto L6;
        r103.a(r100, r101, r102);
        return;
    L6:
        if (c.b(b.f474075a) == true) goto L9;
        return;
    L9:
        throw new IllegalStateException("UN EXPECT STATE");
    }
}
