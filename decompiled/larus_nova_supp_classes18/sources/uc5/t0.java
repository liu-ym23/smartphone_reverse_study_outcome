package uc5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t0 {
    public static Flowable<DocumentListInfo> a(String r2, int r3) {
        boolean r4 = FolderVersion.isShareFolderV2(Integer.valueOf(r3));
        if (r4 == false) goto L5;
        String r0 = "/space/api/explorer/v3/children/list/";
    L6:
        if (r4 == false) goto L8;
        NetService.c r5 = new f1(r2);
    L9:
        NetService.f r1 = new NetService.f(r0);
        r1.b(ResourceData.KEY_TOKEN, r2);
        r1.b("need_path", "1");
        return ((NetService) org.koin.java.a.a(NetService.class)).Vc(r5).a(r1);
    L8:
        r5 = new e1(r2);
        goto L9
    L5:
        r0 = "/api/explorer/folder/children/";
        goto L6
    }
}
