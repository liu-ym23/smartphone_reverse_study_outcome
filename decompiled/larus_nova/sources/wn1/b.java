package wn1;

import com.bytedance.android.livesdk.config.bg1;
import com.bytedance.android.livesdk.config.pt0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f560454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<a> f560455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f560456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f560457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f560458e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f560459f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f560460g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f560461h;

    public final boolean a() {
        if (this.f560460g == false) goto L7;
        return this.f560461h;
    L7:
        return pt0.f121006a.getValue().mEnable;
    }

    public b() {
        this.f560455b = new ArrayList();
        this.f560456c = false;
        this.f560457d = false;
        this.f560458e = false;
        this.f560459f = bg1.b();
        this.f560460g = bg1.f119867a.c();
        this.f560461h = pt0.f121006a.getValue().mEnable;
    }

    public final void b(boolean r100, boolean r101) {
        if (a() == true) goto L6;
        return;
    L6:
        if (r100 == false) goto L8;
        this.f560457d = true;
    L8:
        if (r101 == false) goto L11;
        this.f560458e = true;
    L11:
        if (this.f560457d == true) goto L13;
        return;
    L13:
        if (this.f560458e == true) goto L15;
        return;
    L15:
        if (this.f560456c == true) goto L24;
        this.f560456c = true;
        this.f560457d = false;
        this.f560458e = false;
        this.f560455b.clear();
        a r102 = this.f560454a;
        if (r102 == null) goto L23;
        r102.f560453d = System.currentTimeMillis();
        this.f560455b.add(this.f560454a);
        this.f560454a = null;
        return;
    L23:
        return;
    }
}
