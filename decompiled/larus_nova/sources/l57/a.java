package l57;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.platform.godzilla.GodzillaCore;
import com.bytedance.platform.godzilla.plugin.StartType;
import java.util.HashMap;
import java.util.Iterator;
import p57.f;
import t57.b;
import t57.d;
import u57.c;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f507531c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f507532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, t57.a> f507533b;

    /* JADX INFO: renamed from: l57.a$a, reason: collision with other inner class name */
    public static class C6650a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Application f507534a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap<String, t57.a> f507535b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public com.bytedance.platform.godzilla.common.a f507536c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public f f507537d;

        public C6650a(Application r100) {
            this.f507535b = new HashMap();
            if (r100 == null) goto L7;
            this.f507534a = r100;
            return;
        L7:
            throw new RuntimeException("Godzilla init, application is null");
        }

        public final void a(t57.a r100) {
            String r101 = r100.b();
            if (TextUtils.isEmpty(r101) == true) goto L11;
            if (this.f507535b.get(r101) != null) goto L9;
            this.f507535b.put(r101, r100);
            return;
        L9:
            throw new RuntimeException(String.format("%s plugin is already exist", new Object[]{r101}));
        L11:
            throw new RuntimeException(String.format("%s plugin name is null", new Object[]{r100.getClass().getName()}));
        }
    }

    public a() {
        throw null;
    }

    public final void a(StartType r100) {
        Iterator<t57.a> r101 = this.f507533b.values().iterator();
        d r102 = null;
    L4:
        if (r101.hasNext() == false) goto L23;
        t57.a r103 = r101.next();
        if ((r103 instanceof b) == true) goto L7;
        if (r103.e() != r100) goto L4;
        r103.d();
        if ((r103 instanceof d) == false) goto L4;
        r102 = (d) r103;
        goto L4
    L7:
        b r104 = (b) r103;
        Iterator<t57.a> r105 = r104.f544640a.iterator();
    L9:
        if (r105.hasNext() == false) goto L15;
        t57.a r106 = r105.next();
        if (r106.e() != r100) goto L9;
        r106.d();
        if ((r106 instanceof d) == false) goto L9;
        r104.f544641b = (d) r106;
        goto L9
    L15:
        d r107 = r104.f544641b;
        if (r107 == null) goto L4;
        r104.f544641b = null;
        r102 = r107;
        goto L4
    L23:
        if (r102 == null) goto L45;
        r102.f();
        return;
    }

    public a(Application r100, HashMap r101, com.bytedance.platform.godzilla.common.a r102, f r103) {
        this.f507532a = r100;
        this.f507533b = r101;
        GodzillaCore.INSTANCE.init(r100, r102, null);
        Iterator r104 = r101.values().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((t57.a) r104.next()).c(this.f507532a);
        goto L4
    L6:
        c.f548875a = r103;
    }
}
