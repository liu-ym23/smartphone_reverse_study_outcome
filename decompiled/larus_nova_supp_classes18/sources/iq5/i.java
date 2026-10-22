package iq5;

import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.wikiv2.selector.d a;

    public i(com.bytedance.ee.bear.wikiv2.selector.d r1) {
        this.a = r1;
    }

    public final void accept(Object r12) {
        DocumentListInfo r13 = (DocumentListInfo) r12;
        Intrinsics.checkNotNullParameter(r13, "documentListInfo");
        com.bytedance.ee.bear.wikiv2.selector.d.H8(this.a, r13.getDocumentList());
        com.bytedance.ee.bear.wikiv2.selector.d r0 = this.a;
        if (r0.h != 4) goto L5;
        ShareFolderUserPermission r1 = new ShareFolderUserPermission(2, null, null, false, null, 30, null);
    L6:
        r0.s = r1;
        this.a.c.u(r13.getParent());
        return;
    L5:
        r1 = r13.getParentPermission();
        goto L6
    }
}
