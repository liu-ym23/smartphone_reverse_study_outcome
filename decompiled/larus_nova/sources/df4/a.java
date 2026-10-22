package df4;

import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.ContainerContext;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.IBizExtension;
import ia.c;
import kotlin.jvm.internal.Intrinsics;
import t36.d;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a, ICJTag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBizExtension f468209a;

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final String CJTag() {
        return "BizExtension_" + this.f468209a.getBizName();
    }

    public a(IBizExtension r100) {
        Intrinsics.checkNotNullParameter(r100, "bizExtension");
        this.f468209a = r100;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a
    public final String Sn(d r100) {
        return com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a.C2930a.c(r100, "cj_biz");
    }

    public final com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.biz.base.a a(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        ContainerContext r101 = com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a.C2930a.a(this, r100, null);
        if (this.f468209a.getWebGlobalConfigService(r101) != null) goto L5;
        return null;
    L5:
        return new com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.biz.base.a(this.f468209a);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void d(String r100) {
        ICJTag.DefaultImpls.d(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void i(String r100) {
        ICJTag.DefaultImpls.i(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void w(String r100) {
        ICJTag.DefaultImpls.w(this, r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a
    public final d U6(m16.b r100, c r101) {
        return com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a.C2930a.e(r100, r101);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void e(String r100, Throwable r101) {
        ICJTag.DefaultImpls.e(this, r100, r101);
    }
}
