package kwc;

import java.util.ArrayList;
import java.util.HashSet;
import mwc.c;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.d;

/* JADX INFO: loaded from: classes42.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f506518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f506519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f506520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f506521d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<mwc.a> f506522e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashSet<BeanDefinition<?>> f506523f;

    public final d a(boolean r100) {
        boolean r101 = false;
        if (this.f506518a == true) goto L7;
        if (r100 == true) goto L7;
        boolean r102 = false;
    L9:
        if (this.f506519b == false) goto L13;
        r101 = true;
    L13:
        return new d(r102, r101, 4);
    L7:
        r102 = true;
        goto L9
    }

    public a(boolean r100, boolean r101) {
        this.f506518a = r100;
        this.f506519b = r101;
        this.f506520c = org.koin.core.scope.c.f526154d;
        this.f506522e = new ArrayList();
        this.f506523f = new HashSet();
    }
}
