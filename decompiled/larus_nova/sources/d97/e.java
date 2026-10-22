package d97;

import c97.k;
import com.bytedance.reparo.core.WandTrick;
import com.bytedance.reparo.core.i;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class e extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f467638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PolarisFileWrapper f467639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f467640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<k.a> f467641e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i f467642f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c97.a f467643g;

    public final File a() {
        if (this.f467639c != null) goto L6;
        i r100 = this.f467642f;
        File r101 = this.f467640d;
        String r102 = ((c97.b) this.f467643g).b();
        r100.getClass();
        this.f467639c = new PolarisFileWrapper(new PolarisFileWrapper(r101, "c"), "lib/" + r102);
    L6:
        return this.f467639c;
    }

    public final List<k.a> b() {
        if (this.f467641e != null) goto L6;
        this.f467641e = k.a(this.f467638b);
    L6:
        if (this.f467641e != null) goto L9;
        this.f467641e = new ArrayList();
    L9:
        return this.f467641e;
    }

    public final boolean c() {
        Iterator<k.a> r100 = b().iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        if (WandTrick.i(r100.next().f22904a) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public e(File r100, File r101, i r102, c97.a r103) {
        this.f467640d = r100;
        this.f467638b = r101;
        this.f467642f = r102;
        this.f467643g = r103;
    }
}
