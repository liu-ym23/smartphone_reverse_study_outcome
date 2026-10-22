package com.bytedance.ies.bullet.service.preload;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.SystemClock;
import android.webkit.WebView;
import b36.p;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e extends s26.a implements b36.f {

    public static final class a {
    }

    public static final class b implements zq7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f248097a;

        public b(p r100) {
            this.f248097a = r100;
        }

        @Override // zq7.a
        public final WebView create(Context r100) {
            p.a r101 = this.f248097a.f17191a;
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.create(r100);
        }
    }

    static {
    }

    public e() {
    }

    @Override // b36.f
    public final void w0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        b36.d r101 = (b36.d) F0(b36.d.class);
        if (r101 == null) goto L5;
        r101.x0(r100, null);
    L5:
        ar7.c r102 = yq7.a.f568858a;
        ar7.c r103 = yq7.a.f568858a;
        if (r103 == null) goto L9;
        r103.b("webx_bullet", 1);
        return;
    }

    @Override // b36.f
    public final void M(Context r100, p r101) {
        Intrinsics.checkNotNullParameter(r100, "application");
        Intrinsics.checkNotNullParameter(r101, "config");
        if (r101.f17191a != null) goto L5;
        return;
    L5:
        ar7.c r102 = yq7.a.f568858a;
        if (yq7.a.f568858a != null) goto L8;
        yq7.a.f568858a = new ar7.c(r100);
    L8:
        String r103 = r101.getType();
        if (r103 != null) goto L11;
        r103 = "webx_bullet";
    L11:
        br7.a.C0347a r104 = new br7.a.C0347a();
        r104.f20140a = new b(r101);
        r104.f20141b = 1;
        r104.f20142c = false;
        br7.a r105 = new br7.a(r104);
        ar7.c r106 = yq7.a.f568858a;
        if (r106 != null) goto L14;
        return;
    L14:
        if (((HashMap) r106.f16032d).containsKey(r103) == true) goto L20;
        ((HashMap) r106.f16032d).put(r103, r105);
        if (r105.f20139d == false) goto L21;
        r106.b(r103, r105.f20138c);
        return;
    L21:
        return;
    }

    @Override // b36.f
    public final WebView d(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        b36.d r102 = (b36.d) F0(b36.d.class);
        if (r102 == null) goto L5;
        r102.x0(r100, null);
    L5:
        ar7.c r103 = yq7.a.f568858a;
        if (r101 != null) goto L8;
        r101 = "webx_bullet";
    L8:
        ar7.c r104 = yq7.a.f568858a;
        if (r104 == null) goto L39;
        SystemClock.uptimeMillis();
        br7.a r105 = (br7.a) ((HashMap) r104.f16032d).get(r101);
        if (r105 != null) goto L13;
        return null;
    L13:
        if (((ArrayList) r105.f20136a).isEmpty() == true) goto L31;
        Object r106 = r104.f16029a;
        monitor-enter(r106);
        WebView r107 = (WebView) ((SoftReference) ((ArrayList) r105.f20136a).remove(0)).get();     // Catch: Throwable -> L28
        if (r107 == null) goto L24;
        if (r100 == null) goto L24;
        Context r108 = r107.getContext();     // Catch: Throwable -> L28
        if ((r108 instanceof MutableContextWrapper) == false) goto L24;
        ((MutableContextWrapper) r108).setBaseContext(r100);     // Catch: Throwable -> L28
    L24:
        if (((ArrayList) r105.f20136a).size() >= r105.f20138c) goto L26;
        r104.c(r105);     // Catch: Throwable -> L28
    L26:
        monitor-exit(r106);     // Catch: Throwable -> L28
        return r107;
    L28:
        th = move-exception;
        throw th;
    L31:
        WebView r109 = r105.f20137b.create(new MutableContextWrapper(r100));
        if (r109 == null) goto L35;
        r109.setTag(R.id.webx_precreate_is_precreate, Boolean.FALSE);
    L35:
        r104.b(r101, r105.f20138c);
        return r109;
    L39:
        return null;
    }
}
