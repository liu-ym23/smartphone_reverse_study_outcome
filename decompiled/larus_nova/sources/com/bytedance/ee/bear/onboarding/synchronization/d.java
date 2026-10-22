package com.bytedance.ee.bear.onboarding.synchronization;

import com.ss.android.lark.pb.guide.PullProductGuideResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public final class d<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OnBoardingRustSynchronizer f236183a;

    public d(OnBoardingRustSynchronizer r100) {
        this.f236183a = r100;
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        PullProductGuideResponse r101 = PullProductGuideResponse.ADAPTER.decode(r100);
        this.f236183a.getClass();
        HashMap r102 = new HashMap();
        if (r101 == null) goto L11;
        Map<String, Boolean> r103 = r101.mguides;
        if (r103 == null) goto L11;
        Iterator<Map.Entry<String, Boolean>> r104 = r103.entrySet().iterator();
    L9:
        if (r104.hasNext() == false) goto L11;
        Map.Entry<String, Boolean> r105 = r104.next();
        r102.put(r105.getKey(), Boolean.valueOf(!r105.getValue().booleanValue()));
    L11:
        return r102;
    }
}
