package m74;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.dtrait.constant.DTraitEnum;
import com.bytedance.bdinstall.dtrait.constant.DTraitRiskType;
import com.bytedance.bdinstall.dtrait.model.DTraitLogLevel;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import r74.g;
import r74.h;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Future<String> f512333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r74.c f512334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f512335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, C6778b> f512336d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f512337e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f512338f;

    public class a implements Callable<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f512339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DTraitRiskType f512340b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f512341c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f512342d;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public String call2() throws Exception {
            g r100 = this.f512342d.f512335c;
            if (r100 != null) goto L6;
            return "";
        L6:
            r100.g(this.f512339a);
            return this.f512342d.f512335c.h(this.f512339a, this.f512340b, this.f512341c);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ String call() throws Exception {
            return call2();
        }

        public a(b r100, String r101, DTraitRiskType r102, int r103) {
            this.f512342d = r100;
            this.f512339a = r101;
            this.f512340b = r102;
            this.f512341c = r103;
        }
    }

    /* JADX INFO: renamed from: m74.b$b, reason: collision with other inner class name */
    public static class C6778b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, String> f512343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f512344b;

        public final boolean a() {
            if ((System.currentTimeMillis() - this.f512344b) >= 1800000) goto L5;
            return true;
        L5:
            return false;
        }

        public C6778b(Map<String, String> r100) {
            this.f512343a = r100;
            this.f512344b = System.currentTimeMillis();
        }
    }

    public final Map<String, String> a(String r100, DTraitRiskType r101, int r102) {
        HashMap r103 = new HashMap();
        this.f512333a = o74.a.f522261d.b(new Object[0]).submit(new a(this, r100, r101, r102));
        ((ConcurrentHashMap) d.f512347a).put("get_dtrait", Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L10
        String r104 = this.f512333a.get(r102, TimeUnit.MILLISECONDS);     // Catch: Exception -> L10
        if (TextUtils.isEmpty(r104) == true) goto L6;
        r103.put("x-tt-device-dtrait", r104);     // Catch: Exception -> L10
    L6:
        g r105 = this.f512335c;     // Catch: Exception -> L10
        String r106 = "";
        if (r105.f536441f == null) goto L12;
        String r107 = r105.f536441f.f558508c;     // Catch: Exception -> L10
    L14:
        if (TextUtils.isEmpty(r107) == true) goto L19;
        g r108 = this.f512335c;     // Catch: Exception -> L10
        if (r108.f536441f == null) goto L18;
        r106 = r108.f536441f.f558508c;     // Catch: Exception -> L10
    L18:
        r103.put("x-tt-device-dtrait-token", r106);     // Catch: Exception -> L10
    L19:
        ((ConcurrentHashMap) d.f512348b).put("get_dtrait", Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L10
    L25:
        return r103;
    L12:
        r107 = "";
    L10:
        e = move-exception;
        ((ConcurrentHashMap) d.f512348b).put("get_dtrait", Long.valueOf(System.currentTimeMillis()));
        DTraitLogLevel r109 = DTraitLogLevel.ERROR;
        String r110 = "getDTrait# error: " + e.getMessage();
        StringWriter r111 = new StringWriter();
        e.printStackTrace(new PrintWriter(r111));
        w74.c r112 = new w74.c(r109, r100, r110, r111.toString());
        ConcurrentHashMap r113 = (ConcurrentHashMap) d.f512349c;
        List r114 = (List) r113.get("get_dtrait");
        if (r114 != null) goto L24;
        r114 = new ArrayList();
        r113.put("get_dtrait", r114);
    L24:
        r114.add(r112);
        goto L25
    }

    public b(Context r100, v74.a r101, v74.d r110, boolean r111) {
        this.f512337e = new AtomicBoolean(false);
        this.f512338f = new Object();
        p74.b r102 = new p74.b(r100, r101);
        this.f512334b = (r74.c) h.a(DTraitEnum.COLLECT, r100, r102, r101, r110, r111);
        this.f512335c = (g) h.a(DTraitEnum.FACTOR, r100, r102, r101, r110, r111);
        this.f512336d = new ConcurrentHashMap();
    }
}
