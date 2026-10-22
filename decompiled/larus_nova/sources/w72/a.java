package w72;

import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.m;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.n;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f558486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f558487b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f558488c = null;

    static {
        f558487b = new b(true, 62);
        f558488c = new b(false, 62);
    }

    public static void a(List r100, b r101) {
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L35;
        m r103 = (m) r102.next();
        if (r103.b() == null) goto L4;
        if (r103.d() == null) goto L13;
        if (r103.d().longValue() <= 0) goto L13;
        r101.f558490b.put(r103.b(), r103.d());
    L13:
        if (r103.c() == null) goto L18;
        if (r103.c().longValue() <= 0) goto L18;
        r101.f558491c.put(r103.b(), r103.c());
    L18:
        if (r103.a() == null) goto L21;
        r101.f558492d.put(r103.b(), r103.a());
    L21:
        if (r103.e() == null) goto L4;
        Iterator<n> r104 = r103.e().iterator();
    L24:
        if (r104.hasNext() == false) goto L4;
        n r105 = r104.next();
        if (r105.b() == null) goto L24;
        if (r105.c() == null) goto L33;
        if (r105.c().longValue() <= 0) goto L33;
        r101.f558493e.put(r105.b(), r105.c());
    L33:
        if (r105.a() == null) goto L24;
        r101.f558494f.put(r105.b(), r105.a());
        goto L24
    }
}
