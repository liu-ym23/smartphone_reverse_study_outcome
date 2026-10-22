package sz6;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<qz6.a> f543969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PointF f543970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f543971c;

    public final String toString() {
        return "ShapeData{numCurves=" + this.f543969a.size() + "closed=" + this.f543971c + '}';
    }

    public g() {
        this.f543969a = new ArrayList();
    }

    public g(PointF r100, boolean r101, List<qz6.a> r102) {
        ArrayList r103 = new ArrayList();
        this.f543969a = r103;
        this.f543970b = r100;
        this.f543971c = r101;
        r103.addAll(r102);
    }
}
