package x72;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f562798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u72.a f562799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f562800c;

    public final boolean a(k32.a r100) {
        if (this.f562800c >= this.f562798a.size()) goto L6;
        int r101 = this.f562800c;
        List<b> r102 = this.f562798a;
        a r103 = new a(r101 + 1, r102, this.f562799b);
        return ((b) ListProtector.get(r102, r101)).a(r103, r100);
    L6:
        return false;
    }

    public a(int r100, List<b> r101, u72.a r102) {
        this.f562800c = r100;
        this.f562798a = r101;
        this.f562799b = r102;
    }
}
