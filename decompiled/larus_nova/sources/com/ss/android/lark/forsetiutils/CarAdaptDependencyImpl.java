package com.ss.android.lark.forsetiutils;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.PackageChannelManager;
import kotlin.Lazy;
import kotlin.Metadata;
import otb.n;

/* JADX INFO: loaded from: classes36.dex */
@ClaymoreImpl(v28.b.class)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/forsetiutils/CarAdaptDependencyImpl;", "Lcom/larksuite/framework/utils/caradapt/ICarAdaptDependency;", "<init>", "()V", "getPackageChannel", "", "isTTWebView", "", "isDisableCarAdapt", "forseti-utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CarAdaptDependencyImpl implements v28.b {
    public CarAdaptDependencyImpl() {
    }

    @Override // v28.b
    public boolean isDisableCarAdapt() {
        return com.ss.android.lark.featuregating.b.f420726d.a().a("im.car_adapt.disable");
    }

    public boolean isTTWebView() {
        Lazy<n> r100 = TTWebViewUtil.f437209a;
        TTWebViewUtil.a.d(null);
        return false;
    }

    @Override // v28.b
    public String getPackageChannel() {
        return PackageChannelManager.getBuildPackageChannel(LarkContext.getApplication());
    }
}
