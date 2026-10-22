package yub;

import android.content.Context;
import com.ss.android.lark.appcontext.applifecycle.y;
import com.ss.android.lark.officesdk.minutes.service.fileupload.k;
import com.ss.android.lark.utils.LarkContext;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f569261a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<a.b, com.ss.android.lark.appcontext.applifecycle.a> f569262b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<a.c, y> f569263c = null;

    public d() {
    }

    static {
        f569261a = new d();
        f569262b = new HashMap();
        f569263c = new HashMap();
    }

    @Override // yub.a
    public Context getContext() {
        return LarkContext.getApplication();
    }

    public static final a.C8392a c(y.a r100) {
        if (r100 == null) goto L14;
        String r101 = r100.f408858a;
        String r102 = "";
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        String r103 = r100.f408859b;
        if (r103 == null) goto L13;
        r102 = r103;
    L13:
        return new a.C8392a(r101, r102, r100.f408860c, false);
    L14:
        return new a.C8392a(0);
    }

    @Override // yub.a
    public final void a(k r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        y r101 = f569263c.remove(r100);
        if (r101 == null) goto L6;
        com.ss.android.lark.appcontext.applifecycle2.api.a.d(r101);
        return;
    }

    @Override // yub.a
    public final void b(k r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        HashMap<a.c, y> r101 = f569263c;
        if (r101.containsKey(r100) == false) goto L5;
        return;
    L5:
        c r102 = new c(r100);
        r101.put(r100, r102);
        com.ss.android.lark.appcontext.applifecycle2.api.a.c(r102);
    }
}
