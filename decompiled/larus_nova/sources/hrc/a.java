package hrc;

import com.bytedance.ee.bear.lark.dependency.m;
import com.ss.android.lark.dynamicconfig.interfaces.IFeatureSwitchService$FeatureKey;
import ya5.b;

/* JADX INFO: loaded from: classes41.dex */
public final class a implements b {
    @Override // ya5.b
    public final boolean a() {
        return ((m) org.koin.java.a.a(m.class)).getBoolean(IFeatureSwitchService$FeatureKey.SUITE_FILE_DOWNLOAD);
    }

    public a() {
    }
}
