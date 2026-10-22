package ef6;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes20.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f472521a;

    public final boolean a() {
        List<String> r100 = this.f472521a;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (((ArrayList) r100).isEmpty() == true) goto L8;
        return false;
    }

    public a(List<String> r100) {
        this.f472521a = new ArrayList();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L19;
        Iterator<String> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L20;
        String r102 = r101.next();
        if (TextUtils.isEmpty(r102) == true) goto L9;
        this.f472521a.add(r102);
        goto L9
    L20:
        return;
    }
}
