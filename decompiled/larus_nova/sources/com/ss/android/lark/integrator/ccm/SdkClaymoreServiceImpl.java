package com.ss.android.lark.integrator.ccm;

import cmb.f;
import com.bytedance.ee.bear.basesdk.apisupport.ISdkClaymoreService;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.integrator.ccm.spacekit.SpacekitSdkWrapper;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@ClaymoreImpl(ISdkClaymoreService.class)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/integrator/ccm/SdkClaymoreServiceImpl;", "Lcom/bytedance/ee/bear/basesdk/apisupport/ISdkClaymoreService;", "<init>", "()V", "checkAndInit", "", "ccm-assembly_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SdkClaymoreServiceImpl implements ISdkClaymoreService {
    public SdkClaymoreServiceImpl() {
    }

    @Override // com.bytedance.ee.bear.basesdk.apisupport.ISdkClaymoreService
    public void checkAndInit() {
        f.a().getClass();
        SpacekitSdkWrapper.b.f427892a.c();
    }
}
