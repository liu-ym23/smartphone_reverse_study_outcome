package o0;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<m0.a> f521590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PointF f521591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f521592c;

    public final String toString() {
        return "ShapeData{numCurves=" + this.f521590a.size() + "closed=" + this.f521592c + '}';
    }

    public g() {
        this.f521590a = new ArrayList();
    }

    public g(PointF r100, boolean r101, List<m0.a> r102) {
        ArrayList r103 = new ArrayList();
        this.f521590a = r103;
        this.f521591b = r100;
        this.f521592c = r101;
        r103.addAll(r102);
    }
}
