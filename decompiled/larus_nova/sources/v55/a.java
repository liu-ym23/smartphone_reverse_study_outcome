package v55;

import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements bu5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f553247a;

    public a(c r100) {
        this.f553247a = r100;
    }

    @Override // bu5.a
    public final void didReceivePush(String r100) {
        tt5.a.h("DriveComponent", "initReliablePermission() received push");
        c r101 = this.f553247a;
        if (r101.f553253e == false) goto L5;
        return;
    L5:
        DriveMGPermissionVM.fetchPermission$default(r101.f553250b, r101.f553249a, null, 2, null);
    }
}
