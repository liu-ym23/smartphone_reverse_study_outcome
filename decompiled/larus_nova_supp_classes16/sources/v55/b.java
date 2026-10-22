package v55;

import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements bu5.a {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    public final void didReceivePush(String r4) {
        tt5.a.h("DriveComponent", "initRoomPush() received push");
        c r5 = this.a;
        if (r5.e == false) goto L5;
        return;
    L5:
        DriveMGPermissionVM.fetchPermission$default(r5.b, r5.a, null, 2, null);
    }
}
