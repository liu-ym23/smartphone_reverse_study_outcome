package com.bytedance.locallife.dito.baseview;

import com.bytedance.locallife.dito.utils.e;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public interface c {

    public static final class a {
        public static void a(c r100, List<Float> r101) {
            if (r101 != null) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == true) goto L10;
            return;
        L10:
            r100.b(e.b((Number) ListProtector.get(r101, 0)), e.b((Number) ListProtector.get(r101, 1)), e.b((Number) ListProtector.get(r101, 2)), e.b((Number) ListProtector.get(r101, 3)));
            return;
        L5:
            if (r101.size() != 4) goto L7;
            r102 = true;
            goto L8
        }
    }

    void b(int r100, int r101, int r102, int r103);

    void e();

    void setRadius(List<Float> r100);

    void w(Integer r100, Float r101);
}
