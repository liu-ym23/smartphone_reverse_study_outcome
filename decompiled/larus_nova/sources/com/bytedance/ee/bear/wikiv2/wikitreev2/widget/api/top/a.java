package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements NetService.c<Result<SidebarListInfo>> {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.a$a, reason: collision with other inner class name */
    public class C3463a extends TypeToken<Result<SidebarListInfo>> {
        public C3463a() {
        }
    }

    public a() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result<SidebarListInfo> parse(String r100) throws NetService.ParseException {
        return (Result) new Gson().fromJson(r100, new C3463a().getType());
    L4:
        e = move-exception;
        tt5.a.d("SidebarListInfoParser", "TopCloudDocumentResultParser fail: " + e);
        throw new NetService.ParseException();
    }
}
