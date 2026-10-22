package com.bytedance.ee.bear.onboarding.synchronization;

import com.ss.android.lark.pb.guide.PullProductGuideResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d<T> implements SdkSender.IParser {
    public final /* synthetic */ OnBoardingRustSynchronizer a;

    public d(OnBoardingRustSynchronizer r1) {
        this.a = r1;
    }

    public final Object parse(byte[] r4) {
        PullProductGuideResponse r5 = (PullProductGuideResponse) PullProductGuideResponse.ADAPTER.decode(r4);
        this.a.getClass();
        HashMap r0 = new HashMap();
        if (r5 == null) goto L11;
        Map r6 = r5.mguides;
        if (r6 == null) goto L11;
        Iterator r7 = r6.entrySet().iterator();
    L9:
        if (r7.hasNext() == false) goto L11;
        Map.Entry r1 = (Map.Entry) r7.next();
        r0.put(r1.getKey(), Boolean.valueOf(!((Boolean) r1.getValue()).booleanValue()));
    L11:
        return r0;
    }
}
