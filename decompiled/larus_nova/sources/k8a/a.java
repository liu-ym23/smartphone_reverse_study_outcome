package k8a;

import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<String, String> f502128a;

    public a() {
        this.f502128a = new HashMap();
    }

    public boolean update(String r100, String r101) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.isEmpty() == false) goto L6;
        return false;
    L6:
        if (r100.startsWith("__") == true) goto L17;
        if (r101 != null) goto L10;
        this.f502128a.remove(r100);
        return true;
    L10:
        this.f502128a.put(r100, r101);
        return true;
    L17:
        return false;
    }
}
