package v55;

/* JADX INFO: loaded from: classes16.dex */
public final class g implements bu5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f553257a;

    public g(h r100) {
        this.f553257a = r100;
    }

    @Override // bu5.a
    public final void didReceivePush(String r100) {
        tt5.a.h("DriveComponent", "DriveThirdPartyAttachmentPermissionPush parent permission push");
        h r101 = this.f553257a;
        if (r101.f553268k == true) goto L7;
        r101.f553263f.fetchParentCopyPermission(r101.f553261d, r101.f553262e);
        r101.b();
        return;
    }
}
