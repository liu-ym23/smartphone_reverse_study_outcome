package ne0;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.j1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tf0.p;

/* JADX INFO: loaded from: classes46.dex */
public abstract class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f518849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f518850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f518851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f518852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f518853e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f518854f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, c> f518855g;

    public static final class a {
    }

    static {
    }

    public abstract void f();

    @Override // ne0.c
    public final void onDestory() {
        this.f518853e = true;
        Map<String, c> r100 = this.f518855g;
        if (r100 == null) goto L5;
        ((HashMap) r100).clear();
    L5:
        b r101 = this.f518851c;
        if (r101 == null) goto L11;
        if ((true ^ r101.f518848a.isEmpty()) == false) goto L11;
        r101.f518848a.clear();
    L11:
        if (j1.f142014a.getValue().getFixInteractStore() == false) goto L14;
        this.f518849a.lifecycleOwner = null;
        return;
    }

    @Override // ne0.c
    public final g a() {
        return this.f518850b;
    }

    public e(LifecycleOwner r100) {
        this.f518851c = new b();
        this.f518852d = new f(this);
        DataCenter r101 = new DataCenter();
        this.f518849a = r101;
        r101.lifecycleOwner = r100;
        f();
        this.f518850b = new g(this);
    }

    @Override // ne0.c
    public final void c(e r100) {
        this.f518854f = r100;
    }

    @Override // ne0.c
    public final e e(p r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        b r101 = this.f518851c;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNullParameter(r100, "action");
        r101.f518848a.remove(r100);
    L5:
        return this;
    }

    @Override // ne0.c
    public final void b(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f518849a.put(r100, r101);
    }

    @Override // ne0.c
    public final e d(p r100, ne0.a r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "effect");
        b r102 = this.f518851c;
        if (r102 == null) goto L5;
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "effect");
        r102.f518848a.put(r100, r101);
    L5:
        return this;
    }

    @Override // ne0.c
    public final void d0(p r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (this.f518853e == false) goto L5;
        return;
    L5:
        f r102 = this.f518852d;
        if (r102 == null) goto L27;
        Intrinsics.checkNotNullParameter(r100, "action");
        ALogger.d("Live_Redux_Action", "effect action is <" + r100.f545695a);
        e r103 = r102.f518856a;
        b r104 = r103.f518851c;
        if (r104 == null) goto L14;
        Intrinsics.checkNotNullParameter(r103, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        if ((!r104.f518848a.isEmpty()) == false) goto L14;
        ne0.a r105 = r104.f518848a.get(r100);
        if (r105 == null) goto L14;
        ALogger.i("EffectCollect", "do action has effect action:" + r100);
        r105.a(r103, r101);
    L14:
        e r106 = r102.f518856a;
        if (r106.f518853e == true) goto L35;
        Map<String, c> r107 = r106.f518855g;
        if (r107 != null) goto L20;
        return;
    L20:
        if ((!((HashMap) r107).isEmpty()) != true) goto L34;
        Map<String, c> r108 = r106.f518855g;
        Intrinsics.checkNotNull(r108);
        Iterator r109 = ((HashMap) r108).values().iterator();
    L23:
        if (r109.hasNext() == false) goto L36;
        c r110 = (c) r109.next();
        if (r110 == null) goto L23;
        r110.d0(r100, r101);
        goto L23
    L36:
        return;
    L34:
        return;
    L35:
        return;
    }
}
