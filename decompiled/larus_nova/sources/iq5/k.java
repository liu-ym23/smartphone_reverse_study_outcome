package iq5;

import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.wikiv2.selector.d f495368a;

    public k(com.bytedance.ee.bear.wikiv2.selector.d r100) {
        this.f495368a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        DocumentListInfo r111 = (DocumentListInfo) r110;
        Intrinsics.checkNotNullParameter(r111, "documentListInfo");
        com.bytedance.ee.bear.wikiv2.selector.d.H8(this.f495368a, r111.getDocumentList());
        com.bytedance.ee.bear.wikiv2.selector.d r100 = this.f495368a;
        if (r100.f241157h != 4) goto L5;
        ShareFolderUserPermission r101 = new ShareFolderUserPermission(2, null, null, false, null, 30, null);
    L6:
        r100.f241168s = r101;
        this.f495368a.f241152c.u(r111.getParent());
        return;
    L5:
        r101 = r111.getParentPermission();
        goto L6
    }
}
