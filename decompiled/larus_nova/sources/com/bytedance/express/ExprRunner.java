package com.bytedance.express;

import android.util.LruCache;
import com.bytedance.express.cache.CacheManager;
import com.bytedance.express.parser.ExprParser;
import com.bytedance.express.util.ThreadTimeUtil;
import com.bytedance.ruler.base.models.ExprException;
import ev5.d;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ExprRunner {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static b f243176e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f243177f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f243178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExprParser f243179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dv5.a f243180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f243181d;

    public static final class Companion {
        public Companion() {
        }

        public static void a(final String r100, final c r110, final com.bytedance.ruler.base.models.a r111, final int r112, final int r113, final int r114, final String r115) {
            int r101 = com.bytedance.express.util.a.f243211a;
            Function1<com.bytedance.express.util.a.b, Unit> r102 = new ExprRunner$Companion$trackExecuteEvent$1(r111, r112, r113, r114, r115, r100, r110);
            ExprRunner.f243177f.getClass();
            b r116 = ExprRunner.f243176e;
            if (r116 == null) goto L5;
            r116.c(r102);
        L5:
            com.bytedance.express.util.a.a(4, new ExprRunner$Companion$trackExecuteEvent$2(r100, r111, r110, r112));
        }
    }

    static {
        f243177f = new Companion();
    }

    public final boolean c(final String r100) {
        int r101 = com.bytedance.express.util.a.f243211a;     // Catch: Throwable -> L12
        com.bytedance.express.util.a.a(4, new ExprRunner$preExecute$1(r100));     // Catch: Throwable -> L12
        LruCache<String, List<com.bytedance.express.command.b>> r102 = this.f243178a.f243184c.f243190a;     // Catch: Throwable -> L12
        if (r102 == null) goto L5;
        List<com.bytedance.express.command.b> r103 = r102.get(StringsKt.trim(r100).toString());     // Catch: Throwable -> L12
    L6:
        if (r103 == null) goto L8;
        com.bytedance.express.util.a.a(4, new ExprRunner$preExecute$2(r100));     // Catch: Throwable -> L12
    L9:
        this.f243178a.f243184c.a(r100, r103);     // Catch: Throwable -> L12
        return true;
    L8:
        r103 = this.f243179b.a(r100);     // Catch: Throwable -> L12
        com.bytedance.express.util.a.a(4, new ExprRunner$preExecute$3(r100));     // Catch: Throwable -> L12
        goto L9
    L5:
        r103 = null;
    L12:
        th = move-exception;
        int r104 = com.bytedance.express.util.a.f243211a;
        com.bytedance.express.util.a.a(6, new ExprRunner$preExecute$4(r100, th));
        return false;
    }

    public final List<com.bytedance.express.command.b> d(final String r100) {
        return this.f243179b.a(r100);
    L4:
        th = move-exception;
        int r101 = com.bytedance.express.util.a.f243211a;
        com.bytedance.express.util.a.a(6, new ExprRunner$preParse$1(r100, th));
        return null;
    }

    public ExprRunner(int r100, d r101) {
        a r102 = new a(r101, new CacheManager(r100));
        this.f243178a = r102;
        this.f243179b = new ExprParser(r102);
        this.f243180c = new dv5.a();
    }

    public final com.bytedance.ruler.base.models.a a(final String r100, v97.c r110) {
        c r101 = new c();
        int r102 = 0;
        int r103 = com.bytedance.express.util.a.f243211a;     // Catch: Throwable -> L20
        com.bytedance.express.util.a.a(4, new ExprRunner$execute$1(r100));     // Catch: Throwable -> L20
        LruCache<String, List<com.bytedance.express.command.b>> r104 = this.f243178a.f243184c.f243190a;     // Catch: Throwable -> L20
        if (r104 == null) goto L7;
        List<com.bytedance.express.command.b> r105 = r104.get(StringsKt.trim(r100).toString());     // Catch: Throwable -> L20
    L8:
        if (r105 == null) goto L14;
        int r106 = 1;
        com.bytedance.express.util.a.a(4, new ExprRunner$execute$2(r100));     // Catch: Throwable -> L12
    L26:
        this.f243178a.f243184c.a(r100, r105);     // Catch: Throwable -> L18
        this.f243180c.getClass();     // Catch: Throwable -> L18
        com.bytedance.ruler.base.models.a r111 = b(this, dv5.a.a(r105, r110, r101), 0, null, 14);     // Catch: Throwable -> L18
        int r107 = r106;
    L22:
        r101.f243187c = System.nanoTime() - r101.f243185a;
        r101.f243189e = ThreadTimeUtil.a() - r101.f243186b;
        Companion r108 = f243177f;
        String r109 = this.f243181d;
        r108.getClass();
        Companion.a(r100, r101, r111, r107, 0, 0, r109);
        return r111;
    L18:
        th = th;
        r102 = r106;
    L21:
        r111 = b(this, null, 100, th, 5);
        r107 = r102;
    L12:
        th = th;
        r102 = 1;
        goto L21
    L14:
        r105 = this.f243179b.a(r100);     // Catch: Throwable -> L20
        r106 = 0;
        goto L26
    L7:
        r105 = null;
    L20:
        th = th;
        goto L21
    }

    public static com.bytedance.ruler.base.models.a b(ExprRunner r100, Object r101, int r102, Throwable r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = null;
    L11:
        r100.getClass();
        com.bytedance.ruler.base.models.a r105 = new com.bytedance.ruler.base.models.a(r101, r102, null, r103);
        if ((r103 instanceof ExprException) == false) goto L14;
        r105.f267650b = ((ExprException) r103).getErrorCode();
    L14:
        return r105;
    }
}
