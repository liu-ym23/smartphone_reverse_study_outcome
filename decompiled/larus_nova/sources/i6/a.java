package i6;

import com.bytedance.android.accessibilityLib_Core.config.base.AbstractBaseConfig;
import com.bytedance.android.accessibilityLib_Core.config.bean.ViewVirtualNode;

/* JADX INFO: loaded from: classes43.dex */
public final class a extends AbstractBaseConfig {
    @Override // com.bytedance.android.accessibilityLib_Core.config.base.AbstractBaseConfig, com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig
    public final boolean enableLargeTouchArea() {
        return true;
    }

    @Override // com.bytedance.android.accessibilityLib_Core.config.base.AbstractBaseConfig, com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig
    public final String name() {
        return "largeTouchArea";
    }

    public a() {
    }

    @Override // com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig
    public final void config(ViewVirtualNode r100) {
        r100.f38163m = false;
    }
}
