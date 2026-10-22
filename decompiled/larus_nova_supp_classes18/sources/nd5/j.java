package nd5;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements c {
    public final /* synthetic */ IDocPublicPermission a;

    @Override // nd5.c
    public final Integer getVisibilityStatus() {
        return this.a.getVisibilityStatus();
    }

    @Override // nd5.c
    public final Boolean hasModifiedLinkShare() {
        return this.a.hasModifiedLinkShare();
    }

    @Override // nd5.c
    public final boolean isLinkShareAnyoneRead() {
        return this.a.isLinkShareAnyoneRead();
    }

    @Override // nd5.c
    public final boolean isLinkShareClose() {
        return this.a.isLinkShareClose();
    }

    public j(IDocPublicPermission r1) {
        this.a = r1;
    }
}
