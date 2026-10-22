package com.larus.music;

import com.larus.applog.api.IApplog;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class w implements n38.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<CommonOperateResult, Unit> f359606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f359607b;

    /* JADX WARN: Multi-variable type inference failed */
    public w(Function1<? super CommonOperateResult, Unit> r100, l r101) {
        this.f359606a = r100;
        this.f359607b = r101;
    }

    @Override // n38.q
    public final void a(boolean r100, Integer r101, String r102, String r103, String r104, String r105) {
        if (r100 == false) goto L4;
        CommonOperateResult r106 = CommonOperateResult.SUCCESS;
    L10:
        this.f359606a.invoke(r106);
        JSONObject r107 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r108 = this.f359607b.f359481d.entrySet().iterator();
    L12:
        if (r108.hasNext() == false) goto L15;
        Map.Entry<String, Object> r109 = r108.next();
        r107.put(r109.getKey(), r109.getValue());
        goto L12
    L15:
        if (r100 == false) goto L17;
        r107.put("success", "1");
    L18:
        IApplog.f287053a.reportEvent("bind_with_account", r107);
        return;
    L17:
        r107.put("success", "0");
        r107.put("bind_fail_step", "douyin_verify");
        goto L18
    L4:
        if (r101 != null) goto L7;
    L9:
        r106 = CommonOperateResult.REJECT;
        goto L10
    L7:
        if (r101.intValue() != (-2)) goto L9;
        r106 = CommonOperateResult.CANCEL;
        goto L10
    }
}
