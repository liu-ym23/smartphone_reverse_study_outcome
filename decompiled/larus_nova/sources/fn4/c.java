package fn4;

import android.text.TextUtils;
import com.bytedance.ee.bear.appsetting.RepositoryPriority;
import com.bytedance.ee.bear.appsetting.m;
import com.ss.android.lark.appsetting.api.SettingManager;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SettingManager f477925a;

    @Override // com.bytedance.ee.bear.appsetting.m
    public final boolean b(String r100, boolean r101, boolean r102) {
        return r101;
    }

    @Override // com.bytedance.ee.bear.appsetting.m
    public final void c() {
    }

    @Override // com.bytedance.ee.bear.appsetting.m
    public final void onClear() {
    }

    @Override // com.bytedance.ee.bear.appsetting.m
    public final int getPriority() {
        return RepositoryPriority.SETTING.ordinal();
    }

    public c() {
        this.f477925a = SettingManager.getInstance();
    }

    @Override // com.bytedance.ee.bear.appsetting.m
    public final String getString(String r100) {
        String r101 = this.f477925a.getSettingConfig(r100, true);
        tt5.a.h("SettingRepository", "getString, key = " + r100 + ", value = " + du5.b.k(r101));
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return "";
    L6:
        return r101;
    }

    @Override // com.bytedance.ee.bear.appsetting.m
    public final boolean a(String r100, Class<?> r101) {
        if (Boolean.class.equals(r101) == false) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(this.f477925a.getSettingConfig(r100, true)) == true) goto L7;
        return true;
    }
}
