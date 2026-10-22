package nd5;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;

/* JADX INFO: loaded from: classes18.dex */
public final class j implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IDocPublicPermission f518788a;

    @Override // nd5.c
    public final Integer getVisibilityStatus() {
        return this.f518788a.getVisibilityStatus();
    }

    @Override // nd5.c
    public final Boolean hasModifiedLinkShare() {
        return this.f518788a.hasModifiedLinkShare();
    }

    @Override // nd5.c
    public final boolean isLinkShareAnyoneRead() {
        return this.f518788a.isLinkShareAnyoneRead();
    }

    @Override // nd5.c
    public final boolean isLinkShareClose() {
        return this.f518788a.isLinkShareClose();
    }

    public j(IDocPublicPermission r100) {
        this.f518788a = r100;
    }
}
