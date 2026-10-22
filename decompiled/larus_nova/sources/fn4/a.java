package fn4;

import com.bytedance.ee.bear.appsetting.RepositoryPriority;
import com.bytedance.ee.bear.appsetting.m;

/* JADX INFO: loaded from: classes15.dex */
public abstract class a implements m {
    public a() {
    }

    @Override // com.bytedance.ee.bear.appsetting.m
    public final String getString(String r100) {
        return "";
    }

    @Override // com.bytedance.ee.bear.appsetting.m
    public final void onClear() {
    }

    @Override // com.bytedance.ee.bear.appsetting.m
    public final int getPriority() {
        return RepositoryPriority.FG.ordinal();
    }

    @Override // com.bytedance.ee.bear.appsetting.m
    public final boolean a(String r100, Class<?> r101) {
        return Boolean.class.equals(r101);
    }
}
