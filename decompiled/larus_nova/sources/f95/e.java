package f95;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Integer> f475969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f475970b;

    public final boolean a() {
        if (((ArrayList) this.f475969a).size() == 1) goto L5;
        return false;
    L5:
        if (((Integer) ListProtector.get(this.f475969a, 0)).intValue() != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public e() {
        this.f475969a = new ArrayList();
        this.f475970b = 0;
    }
}
