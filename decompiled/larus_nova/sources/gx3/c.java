package gx3;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f483095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f483096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONArray f483097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONArray f483098d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<a> f483099e;

    public c() {
        this.f483099e = new ArrayList();
    }

    public final boolean a(j r100, String r101, JSONObject r102) {
        Iterator r103 = ((ArrayList) this.f483099e).iterator();
    L3:
        boolean r104 = false;
        if (r103.hasNext() == false) goto L19;
        a r105 = (a) r103.next();
        r105.getClass();
        if (TextUtils.isEmpty(r101) == true) goto L16;
        Set<String> r106 = r105.f483092b;
        if (r106 != null) goto L11;
    L13:
        if (r102 == null) goto L16;
        r104 = r105.b(r101, r102);
        goto L16
    L11:
        if (r106.contains(r101) == false) goto L13;
        r104 = true;
    L16:
        if (r104 == false) goto L3;
        return r105.c(r100);
    L19:
        return false;
    }
}
