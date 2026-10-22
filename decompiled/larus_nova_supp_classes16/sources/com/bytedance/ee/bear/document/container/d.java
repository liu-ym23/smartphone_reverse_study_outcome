package com.bytedance.ee.bear.document.container;

import com.bytedance.ee.bear.document.device.OfficeDeviceInfoWebService;
import com.bytedance.ee.bear.document.like.OfficeLikeListLaunchWebService;
import com.bytedance.ee.bear.document.render.preload.WebViewLoadStateWebService;
import com.ss.android.lark.chameleon.IWebService;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
import java.util.List;
import kotlin.collections.CollectionsKt;
import n35.k;
import vv4.m;
import y05.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements IWebService {
    public final /* synthetic */ String a;

    /* JADX WARN: Multi-variable type inference failed */
    public final List<m> getWebService() {
        Log.i("OfficeDocumentImpl", "==openDocs==preload== getWebService");
        List<m> r0 = CollectionsKt.mutableListOf(new m[]{new o45.a(), new WebViewLoadStateWebService(), new m35.a(this.a), new k(this.a), new m45.a(), new q15.d(), new g35.a(), new OfficeLikeListLaunchWebService(), new x35.b(), new d05.f(), new j(), new OfficeDeviceInfoWebService(), new p45.a(), new q45.a(), new k35.b()});
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L5;
        r0.add(new tl5.b());
    L5:
        return r0;
    }

    public d(String r1) {
        this.a = r1;
    }
}
