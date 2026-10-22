package com.ss.android.lark.download.service.impl;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.pb.compliance.IMFileRiskTag;
import com.ss.android.lark.pb.compliance.MGetIMFileRiskTagResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public final class i implements SdkSender.IParser<List<wbb.d.c>> {
    public i() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final List<wbb.d.c> parse(byte[] r100) throws IOException {
        List<IMFileRiskTag> r101 = MGetIMFileRiskTagResponse.ADAPTER.decode(r100).mresult;
        ArrayList r102 = new ArrayList();
        int r103 = 0;
    L4:
        if (r103 >= r101.size()) goto L6;
        IMFileRiskTag r104 = (IMFileRiskTag) ListProtector.get(r101, r103);
        String r105 = r104.mobject_id;
        r104.mis_risk_tag_exist.booleanValue();
        r104.mis_risk_file.booleanValue();
        r102.add(new wbb.d.c(r104.mrestrict_operation.booleanValue()));
        r103 = r103 + 1;
        goto L4
    L6:
        return r102;
    }
}
