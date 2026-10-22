package snc;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import unc.d;

/* JADX INFO: loaded from: classes40.dex */
@Deprecated(message = "replace with NavRouter")
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f542686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f542687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, Object> f542688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f542689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f542690e;

    public final Bundle a() {
        Intrinsics.checkNotNullParameter(Bundle.class, "clazz");
        Intrinsics.checkNotNullParameter("intent_extra", "key");
        Object r100 = this.f542688c.get("intent_extra");
        if (r100 != null) goto L13;
    L8:
        Object r101 = null;
    L9:
        Bundle r102 = (Bundle) r101;
        if (r102 != null) goto L15;
        Bundle r103 = new Bundle();
        Intrinsics.checkNotNullParameter("intent_extra", "key");
        this.f542688c.put("intent_extra", r103);
        return r103;
    L15:
        return r102;
    L13:
        r101 = Bundle.class.cast(r100);     // Catch: ClassCastException -> L6
    L6:
        e = move-exception;
        Log.e("Router", "getField failed , exception+" + e.getMessage());
        goto L8
    }

    public final void c() {
        d r100 = a.f542685a;
        Intrinsics.checkNotNullParameter(this, "uriRequest");
        if (a.f542685a != null) goto L5;
        Log.e("Router", "Router has not been initialized!");
    L5:
        d r101 = a.f542685a;
        if (r101 == null) goto L9;
        Intrinsics.checkNotNullParameter(this, "request");
        r101.b(this, new d.a(this, r101.f550894e));
        return;
    }

    public final String toString() {
        return this.f542687b.toString();
    }

    public final Context getContext() {
        return this.f542686a;
    }

    public b(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        Uri r102 = UriProtector.parse(r101);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "uri");
        this.f542686a = r100;
        this.f542687b = r102;
        this.f542688c = new HashMap();
        this.f542689d = "";
        this.f542690e = "";
        String r103 = r102.getScheme();
        if (r103 == null) goto L5;
        this.f542689d = r103;
    L5:
        String r104 = r102.getPath();
        if (r104 == null) goto L9;
        this.f542690e = r104;
        return;
    }

    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        a().putString(r100, r101);
    }
}
