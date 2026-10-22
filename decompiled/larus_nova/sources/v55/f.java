package v55;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements bu5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f553256a;

    public f(h r100) {
        this.f553256a = r100;
    }

    @Override // bu5.a
    public final void didReceivePush(String r100) {
        tt5.a.h("DriveComponent", "DriveThirdPartyAttachmentPermissionPush parent group push");
        h r101 = this.f553256a;
        if (r101.f553268k == true) goto L7;
        r101.f553263f.fetchParentCopyPermission(r101.f553261d, r101.f553262e);
        r101.b();
        return;
    }
}
