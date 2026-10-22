package nd5;

import com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission;

/* JADX INFO: loaded from: classes18.dex */
public final class h implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IFolderPublicPermission f518786a;

    @Override // nd5.c
    public final Integer getVisibilityStatus() {
        return this.f518786a.getVisibilityStatus();
    }

    @Override // nd5.c
    public final Boolean hasModifiedLinkShare() {
        return this.f518786a.hasModifiedLinkShare();
    }

    @Override // nd5.c
    public final boolean isLinkShareAnyoneRead() {
        return this.f518786a.isLinkShareAnyoneRead();
    }

    @Override // nd5.c
    public final boolean isLinkShareClose() {
        return this.f518786a.isLinkShareClose();
    }

    public h(IFolderPublicPermission r100) {
        this.f518786a = r100;
    }
}
