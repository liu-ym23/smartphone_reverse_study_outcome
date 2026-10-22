package cp2;

import com.bytedance.android.livesdk.config.n11;
import com.bytedance.android.livesdk.config.rf;
import dp2.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n11 f464626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f464627b;

    public final b a() {
        ArrayList r100 = new ArrayList();
        Iterator r101 = ((ArrayList) this.f464627b).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        n11.b.a r102 = c("enterBackground", (String) r101.next());
        if (r102 == null) goto L4;
        dp2.b r103 = new dp2.b(r102);
        Intrinsics.checkNotNullParameter(r103, com.heytap.mcssdk.constant.b.f276366p);
        r100.add(r103);
        goto L4
    L8:
        b r104 = fp2.b.a();
        Iterator r105 = r100.iterator();
    L10:
        if (r105.hasNext() == false) goto L17;
        b r106 = ((c) r105.next()).execute();
        if (r106.f464628a == true) goto L15;
        r104.f464628a = false;
    L15:
        if (r106.f464629b == true) goto L10;
        r104.f464629b = false;
        goto L10
    L17:
        return r104;
    }

    public a(String r100) {
        ArrayList r101 = new ArrayList();
        r101.add("global");
        String r102 = fp2.b.f478231b.get(fp2.b.b());
        if (r102 == null) goto L5;
        r101.add(r102);
    L5:
        String r103 = fp2.b.d(r100);
        if (r103 == null) goto L8;
        r101.add(r103);
    L8:
        Unit r104 = Unit.INSTANCE;
        this.f464627b = r101;
        this.f464626a = rf.f121127a.getValue();
    }

    public final <T> b b(T r100) {
        ArrayList r101 = new ArrayList();
        Iterator r102 = ((ArrayList) this.f464627b).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        n11.b.a r103 = c("coverByPage", (String) r102.next());
        if (r103 == null) goto L4;
        dp2.a r104 = new dp2.a(r100, r103);
        Intrinsics.checkNotNullParameter(r104, com.heytap.mcssdk.constant.b.f276366p);
        r101.add(r104);
        goto L4
    L8:
        b r105 = fp2.b.a();
        Iterator r106 = r101.iterator();
    L10:
        if (r106.hasNext() == false) goto L17;
        b r107 = ((c) r106.next()).execute();
        if (r107.f464628a == true) goto L15;
        r105.f464628a = false;
    L15:
        if (r107.f464629b == true) goto L10;
        r105.f464629b = false;
        goto L10
    L17:
        return r105;
    }

    public final n11.b.a c(String r100, String r101) {
        n11 r102 = this.f464626a;
        if (r102 == null) goto L15;
        Map<String, Map<String, n11.b>> r103 = r102.a();
        if (r103 == null) goto L15;
        Map<String, n11.b> r104 = r103.get(r100);
        if (r104 == null) goto L15;
        if (r101 == null) goto L15;
        n11.b r105 = r104.get(r101);
        if (r105 == null) goto L15;
        if (fp2.b.e() == false) goto L18;
        return r105.a();
    L18:
        return r105.b();
    L15:
        return null;
    }
}
