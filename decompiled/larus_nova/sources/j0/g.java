package j0;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a<o0.g, Path>> f496762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a<Integer, Integer>> f496763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Mask> f496764c;

    public g(List<Mask> r100) {
        this.f496764c = r100;
        this.f496762a = new ArrayList(r100.size());
        this.f496763b = new ArrayList(r100.size());
        int r101 = 0;
    L4:
        if (r101 >= r100.size()) goto L6;
        this.f496762a.add(((Mask) ListProtector.get(r100, r101)).f24819b.a());
        n0.d r102 = ((Mask) ListProtector.get(r100, r101)).f24820c;
        this.f496763b.add(r102.a());
        r101 = r101 + 1;
        goto L4
    }
}
