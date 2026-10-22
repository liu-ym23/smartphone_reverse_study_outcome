package oz6;

import android.graphics.Path;
import com.bytedance.lottie.model.content.Mask;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a<sz6.g, Path>> f527212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a<Integer, Integer>> f527213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Mask> f527214c;

    public g(List<Mask> r100) {
        this.f527214c = r100;
        this.f527212a = new ArrayList(r100.size());
        this.f527213b = new ArrayList(r100.size());
        int r101 = 0;
    L4:
        if (r101 >= r100.size()) goto L6;
        this.f527212a.add(((Mask) ListProtector.get(r100, r101)).f264457b.a());
        rz6.d r102 = ((Mask) ListProtector.get(r100, r101)).f264458c;
        this.f527213b.add(r102.a());
        r101 = r101 + 1;
        goto L4
    }
}
