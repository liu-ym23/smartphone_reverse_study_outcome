package e16;

import android.net.Uri;
import com.bytedance.android.anniex.utils.k;
import com.bytedance.ies.bullet.service.sdk.d;
import com.bytedance.ies.bullet.service.sdk.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import w26.g;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends e {

    /* JADX INFO: renamed from: e16.a$a, reason: collision with other inner class name */
    public static final class C5728a {
    }

    static {
    }

    @Override // t36.e
    public final String getName() {
        return "TestFlowInterceptor";
    }

    public a() {
    }

    @Override // t36.e
    public final boolean b(d r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaData");
        Boolean r101 = Boolean.TRUE;
        r100.a("enable_model_pre_create", new y36.a(r100, "enable_model_pre_create", r101), true);
        r100.a("enable_engine_preload", new y36.a(r100, "enable_engine_preload", r101), true);
        Uri r102 = r100.getUrl();
        String r103 = k.c(r102);
        if (r103 != null) goto L5;
        r103 = r102.toString();
    L5:
        Map<String, Map<Class<?>, Object>> r104 = x26.a.f562251a;
        g r105 = (g) x26.a.a(g.class);
        if (r105 == null) goto L12;
        w26.e r106 = (w26.e) r105.n0(w26.e.class);
        if (r106 == null) goto L12;
        List<String> r107 = r106.e();
        if (r107 == null) goto L12;
    L13:
        Iterator r108 = r107.iterator();
    L14:
        boolean r109 = false;
        if (r108.hasNext() == false) goto L19;
        if (StringsKt.contains$default(r103, (String) r108.next(), false, 2, null) == false) goto L14;
        r109 = true;
    L19:
        if (r109 == false) goto L21;
        r100.a("enable_engine_preload", new y36.a(Boolean.FALSE), true);
    L21:
        return true;
    L12:
        r107 = new ArrayList();
        goto L13
    }
}
