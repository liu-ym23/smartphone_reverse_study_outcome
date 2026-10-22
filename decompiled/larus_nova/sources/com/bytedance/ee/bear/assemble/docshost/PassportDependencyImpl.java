package com.bytedance.ee.bear.assemble.docshost;

import com.bytedance.ee.bear.account.a;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@ClaymoreImpl(a.class)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/assemble/docshost/PassportDependencyImpl;", "Lcom/bytedance/ee/bear/account/IAccountModuleDependency;", "<init>", "()V", "oldEnv", "", "loginEnv", "getDeviceId", "", "isUsPackage", "", "isShowGlobalWatermark", "office-ccm-assemble_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PassportDependencyImpl implements a {
    public PassportDependencyImpl() {
    }

    @Override // com.bytedance.ee.bear.account.a
    public boolean isShowGlobalWatermark() {
        return false;
    }

    @Override // com.bytedance.ee.bear.account.a
    public String getDeviceId() {
        int r100 = jl5.a.f499529a;
        return ((epb.a) LarkContext.spiByDwarf(epb.a.class)).getDeviceId();
    }

    @Override // com.bytedance.ee.bear.account.a
    public boolean isUsPackage() {
        LarkAppContext.Companion.getClass();
        return LarkAppContext.access$getInstance$cp().buildConfig().isUsPackage();
    }

    @Override // com.bytedance.ee.bear.account.a
    public int loginEnv() {
        int r100 = jl5.a.f499529a;
        return ((gpb.a) ApiUtils.getApi(gpb.a.class)).envType();
    }

    @Override // com.bytedance.ee.bear.account.a
    public int oldEnv() {
        return jl5.a.d();
    }
}
