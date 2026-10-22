package f95;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public final List<Integer> a;
    public int b;

    public final boolean a() {
        if (((ArrayList) this.a).size() == 1) goto L5;
        return false;
    L5:
        if (((Integer) ListProtector.get(this.a, 0)).intValue() != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public e() {
        this.a = new ArrayList();
        this.b = 0;
    }
}
