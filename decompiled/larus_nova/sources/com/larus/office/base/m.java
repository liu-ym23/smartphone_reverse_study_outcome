package com.larus.office.base;

import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.service.AccountService;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKBizConfigProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class m implements IOfficeSDKBizConfigProvider {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f360582a = null;

        static {
            int[] r100 = new int[IOfficeSDKBizConfigProvider.Biz.values().length];
            r100[IOfficeSDKBizConfigProvider.Biz.IM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f360582a = r100;
        }
    }

    public m() {
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKBizConfigProvider
    public final boolean isEnabled(IOfficeSDKBizConfigProvider.Biz r100) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        if (a.f360582a[r100.ordinal()] != 1) goto L5;
        LarkSocialExp r101 = LarkSocialExp.f365340a;
        String r102 = AccountService.f365697a.getUserId();
        r101.getClass();
        return LarkSocialExp.g(r102);
    L5:
        return false;
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKBizConfigProvider
    public final boolean isLaunchEnabled(IOfficeSDKBizConfigProvider.Biz r100) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        if (a.f360582a[r100.ordinal()] == 1) goto L7;
        return false;
    L7:
        return com.larus.platform.exp.q.f365393a.b();
    }
}
