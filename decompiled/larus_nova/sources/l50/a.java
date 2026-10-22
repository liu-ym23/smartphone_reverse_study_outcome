package l50;

import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.ArrayList;
import java.util.Iterator;
import k50.f;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import m50.d;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<b> f507432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f507433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f507434c;

    public a() {
        this.f507432a = new ArrayList();
    }

    @Override // l50.b
    public final boolean isFinished() {
        return this.f507433b;
    }

    public final void b(b r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f507432a.add(r100);
        this.f507433b = false;
    }

    @Override // l50.b
    public final boolean a(f r100, d r101, n50.b r102) {
        Intrinsics.checkNotNullParameter(r100, "rendererParams");
        Intrinsics.checkNotNullParameter(r101, "modelParams");
        Intrinsics.checkNotNullParameter(r102, "sceneParams");
        Iterator<b> r103 = this.f507432a.iterator();
        boolean r104 = true;
    L4:
        if (r103.hasNext() == false) goto L9;
        b r105 = r103.next();
        r105.a(r100, r101, r102);
        if (r105.isFinished() == true) goto L4;
        r104 = false;
        goto L4
    L9:
        this.f507433b = r104;
        if (r104 == false) goto L15;
        Function0<Unit> r106 = this.f507434c;
        if (r106 == null) goto L15;
        Unit r107 = r106.invoke();
    L15:
        return this.f507433b;
    }
}
