package fic;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f477429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StringBuilder f477430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f477431c;

    public a() {
        this.f477429a = new HashMap();
        this.f477430b = new StringBuilder();
        this.f477431c = true;
    }

    public final void a(String r100, float r101) {
        ((HashMap) this.f477429a).put(r100, r101 + "");
        d(r100, r101 + "");
    }

    public final void b(String r100, int r101) {
        ((HashMap) this.f477429a).put(r100, r101 + "");
        d(r100, r101 + "");
    }

    public final void c(String r100, String r101) {
        ((HashMap) this.f477429a).put(r100, r101);
        d(r100, r101);
    }

    public final void d(String r100, String r101) {
        if (this.f477431c == true) goto L5;
        this.f477430b.append(",");
    L5:
        this.f477430b.append("\"");
        this.f477430b.append(r100);
        this.f477430b.append("\"");
        this.f477430b.append(":");
        this.f477430b.append("\"");
        this.f477430b.append(r101);
        this.f477430b.append("\"");
        if (this.f477431c == false) goto L9;
        this.f477431c = false;
        return;
    }
}
