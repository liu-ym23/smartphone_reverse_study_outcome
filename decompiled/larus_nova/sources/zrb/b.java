package zrb;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements hua.a {
    public b() {
    }

    @Override // hua.a
    public final String getBizName() {
        return "Performance";
    }

    @Override // hua.a
    public final List<iua.a> a() {
        return Collections.unmodifiableList(com.ss.android.lark.monitor.abtest.a.f432336a);
    }
}
