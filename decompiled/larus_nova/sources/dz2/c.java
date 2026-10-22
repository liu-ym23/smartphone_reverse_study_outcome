package dz2;

import android.webkit.WebView;
import bz2.e;
import com.bytedance.android.monitor.webview.h;
import java.lang.ref.SoftReference;
import ny2.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class c extends ny2.c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ez2.c f470572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public py2.a f470573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f470574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f470575d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f470576e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f470577f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONObject f470578g;

    @Override // dz2.b
    public void h(JSONObject r100) {
    }

    public abstract a i();

    @Override // dz2.b
    public boolean e() {
        if (i() != null) goto L5;
        return true;
    L5:
        return i().f470571b;
    }

    @Override // ny2.g
    public /* bridge */ /* synthetic */ ny2.b f() {
        return i();
    }

    @Override // dz2.b
    public void reset() {
        if (i() == null) goto L6;
        i().c();
        return;
    }

    @Override // ny2.g
    public final f a() {
        return this.f470572a;
    }

    @Override // ny2.g
    public final JSONObject b() {
        return this.f470578g;
    }

    @Override // ny2.g
    public final py2.a c() {
        return this.f470573b;
    }

    @Override // ny2.g
    public final JSONObject g() {
        return this.f470577f;
    }

    @Override // ny2.g
    public final String getBiz() {
        return this.f470574c;
    }

    @Override // ny2.g
    public final String getContainerType() {
        return this.f470576e;
    }

    @Override // ny2.g
    public final String getEventType() {
        return this.f470575d;
    }

    public final void j(JSONObject r100) {
        if (r100 == null) goto L5;
        this.f470577f = new JSONObject();
        this.f470578g = new JSONObject();
        e.a(this.f470577f, r100.optJSONObject("jsBase"));
        e.a(this.f470578g, r100.optJSONObject("jsInfo"));
        return;
    }

    public c(ez2.c r100, String r101, String r102) {
        this.f470572a = r100;
        h r103 = h.f162934h;
        SoftReference<WebView> r104 = r100.f474844j;
        if (r104 != null) goto L6;
        r104 = new SoftReference(null);
    L6:
        com.bytedance.android.monitor.webview.b r105 = r103.k(r104.get());
        if (r105 == null) goto L9;
        String r106 = r105.f162911s;
    L10:
        this.f470574c = r106;
        this.f470575d = r101;
        this.f470576e = r102;
        return;
    L9:
        r106 = "";
        goto L10
    }
}
