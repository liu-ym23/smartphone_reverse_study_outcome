package in4;

import com.bytedance.ee.bear.lark.dependency.m;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements m {
    public e() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.m
    public final String getString() {
        Intrinsics.checkNotNullParameter("suite_hybrid_config", "key");
        return "";
    }

    @Override // com.bytedance.ee.bear.lark.dependency.m
    public final boolean getBoolean(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return FeatureGatingModule.getFeatureGatingService().isEnable(r100);
    }
}
