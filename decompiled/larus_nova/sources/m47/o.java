package m47;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.bridge.protocol.ProtocolMessage;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes21.dex */
public final class o implements d47.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PiaMethod.Scope f511885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b47.b f511886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f511887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f511888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.pia.core.utils.a<JsonObject> f511889e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n47.a f511890f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f511891g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SparseArray<l47.a<ProtocolMessage.a>> f511892h;

    @Override // d47.a
    public e47.b getContext() {
        return this.f511886b;
    }

    public static <T> void c(l47.a<T> r100, T r101) {
        if (r100 == null) goto L10;
        r100.accept(r101);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.bytedance.pia.core.utils.d.d("[Bridge] invoke callback error:", th);
        return;
    }

    @Override // d47.a
    public final void a(final String r100, final Object r101) {
        ThreadUtil.c(new e(this, r101, r100));
    }

    public o(PiaMethod.Scope r100, b47.b r101, b r102) {
        this.f511888d = false;
        this.f511889e = new com.bytedance.pia.core.utils.a();
        this.f511890f = null;
        this.f511891g = 0;
        this.f511892h = new SparseArray();
        this.f511885a = r100;
        this.f511886b = r101;
        this.f511887c = r102;
    }

    public final void b(int r100, String r101, String r102, Throwable r103) {
        StringBuilder r104 = new StringBuilder("name=");
        r104.append(r101);
        if (TextUtils.isEmpty(r102) == true) goto L5;
        r104.append(", message=");
        r104.append(r102);
    L5:
        if (r103 == null) goto L7;
        r104.append(", error=");
        r104.append(Log.getStackTraceString(r103));
    L7:
        b47.b r105 = this.f511886b;
        if (r105 == null) goto L11;
        r105.f17562k.b("bridge", r100, r104.toString());
        return;
    }

    public <T> void call(final String r100, final Object r101, final l47.a<T> r110, final l47.a<PiaMethod.Error> r111) {
        ThreadUtil.c(new c(this, r100, r111, r101, r110));
    }
}
