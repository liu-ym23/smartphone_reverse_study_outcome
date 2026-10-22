package g6;

import com.bytedance.android.accessibilityLib_Core.base.AccessiblityScope;
import com.bytedance.android.accessibilityLib_Core.config.base.AbstractBaseConfig;
import com.bytedance.android.accessibilityLib_Core.config.bean.ViewVirtualNode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
public final class a extends AbstractBaseConfig {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f480111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f480112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<AbstractBaseConfig, Unit> f480113e;

    @Override // com.bytedance.android.accessibilityLib_Core.config.base.AbstractBaseConfig, com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig
    public final AccessiblityScope getScope() {
        return AccessiblityScope.ViewGroup;
    }

    @Override // com.bytedance.android.accessibilityLib_Core.config.base.AbstractBaseConfig, com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig
    public final int layoutRoot() {
        return this.f480112d;
    }

    @Override // com.bytedance.android.accessibilityLib_Core.config.base.AbstractBaseConfig, com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig
    public final String name() {
        return this.f480111c;
    }

    @Override // com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig
    public final void config(ViewVirtualNode r100) {
        Function1<AbstractBaseConfig, Unit> r101 = this.f480113e;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke(this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r100, int r101, Function1<? super AbstractBaseConfig, Unit> r102) {
        this.f480111c = r100;
        this.f480112d = r101;
        this.f480113e = r102;
    }
}
