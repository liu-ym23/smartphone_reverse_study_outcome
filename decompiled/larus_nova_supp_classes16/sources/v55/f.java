package v55;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements bu5.a {
    public final /* synthetic */ h a;

    public f(h r1) {
        this.a = r1;
    }

    public final void didReceivePush(String r4) {
        tt5.a.h("DriveComponent", "DriveThirdPartyAttachmentPermissionPush parent group push");
        h r5 = this.a;
        if (r5.k == true) goto L7;
        r5.f.fetchParentCopyPermission(r5.d, r5.e);
        r5.b();
        return;
    }
}
