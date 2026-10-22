package fn4;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.ee.bear.appsetting.RepositoryPriority;
import com.bytedance.ee.bear.appsetting.m;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f477924a;

    @Override // com.bytedance.ee.bear.appsetting.m
    public final void c() {
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
        return RepositoryPriority.MOCK_FG.ordinal();
    }

    public b(Context r100) {
        this.f477924a = r100.getSharedPreferences("mock_fg", 0);
    }

    @Override // com.bytedance.ee.bear.appsetting.m
    public final boolean a(String r100, Class<?> r101) {
        if (Boolean.class.equals(r101) == true) goto L5;
        return false;
    L5:
        return this.f477924a.contains(r100);
    }

    @Override // com.bytedance.ee.bear.appsetting.m
    public final boolean b(String r100, boolean r101, boolean r102) {
        String r103 = this.f477924a.getString(r100, "");
        if (TextUtils.isEmpty(r103) == false) goto L6;
        return r101;
    L6:
        return Boolean.parseBoolean(r103);
    }
}
