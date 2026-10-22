package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements NetService.c<Result<SidebarListInfo>> {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.a$a, reason: collision with other inner class name */
    public class C0216a extends TypeToken<Result<SidebarListInfo>> {
        public C0216a() {
        }
    }

    public a() {
    }

    public final Result<SidebarListInfo> parse(String r3) throws NetService.ParseException {
        return (Result) new Gson().fromJson(r3, new C0216a().getType());
    L4:
        e = move-exception;
        tt5.a.d("SidebarListInfoParser", "TopCloudDocumentResultParser fail: " + e);
        throw new NetService.ParseException();
    }
}
