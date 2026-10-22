package uc5;

import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t1 implements Function<DocumentListInfo, Publisher<DocumentListInfo>> {
    public t1() {
    }

    public final Object apply(Object r8) throws Exception {
        final DocumentListInfo r9 = (DocumentListInfo) r8;
        Document r0 = r9.getParent();
        if (r0 != null) goto L6;
        tt5.a.h("GetAndSetOldShareFolderPermissionFunction", "GetOldShareFolderPermissionFunction...parent is null, return. ");
        return Flowable.just(r9);
    L6:
        if (FolderVersion.isPersonalFolder(r0.L1, r0.P1) == false) goto L8;
        Flowable r1 = Flowable.just(2);
    L10:
        return r1.map(new r1(r9)).onErrorReturn(new s1(r9));
    L8:
        jg5.j r2 = ((cj5.b) org.koin.java.a.a(cj5.b.class)).aa();
        String r3 = r0.m;
        FolderVersion r4 = new FolderVersion(r0.L1, r0.T, r0.P1);
        boolean r5 = r0.n;
        r2.getClass();
        r1 = xh5.d.a.c(r3, r4, r5).map(new jg5.h());
        goto L10
    }
}
