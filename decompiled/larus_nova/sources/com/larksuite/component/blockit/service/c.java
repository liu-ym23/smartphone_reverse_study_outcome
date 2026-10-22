package com.larksuite.component.blockit.service;

import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.larksuite.component.blockit.entity.BlockEntity;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import java.util.Map;

/* JADX INFO: loaded from: classes24.dex */
public final class c implements BlockitService.g<String, ErrorResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BlockEntity f283141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback f283142b;

    @Override // com.larksuite.component.blockit.service.BlockitService.g
    public final void onError(ErrorResult r100) {
        ErrorResult r101 = r100;
        AppBrandLogger.e("BlockitService", new Object[]{"onError:" + r101.toString()});
        this.f283142b.onError(r101);
    }

    public c(BlockEntity r100, IGetDataCallback r101) {
        this.f283141a = r100;
        this.f283142b = r101;
    }

    @Override // com.larksuite.component.blockit.service.BlockitService.g
    public final void a(String r100, Map r101) {
        String r102 = r100;
        JsonObject r103 = GsonProtectorUtils.parse(new JsonParser(), r102).getAsJsonObject();
        int r104 = r103.get("code").getAsInt();
        if (r104 != 0) goto L5;
        String r105 = r103.get("data").getAsJsonObject().get("BlockId").getAsString();
        this.f283141a.setBlockID(r105);
        this.f283142b.onSuccess(this.f283141a);
        return;
    L5:
        this.f283142b.onError(new ErrorResult(r104, r102));
    }
}
