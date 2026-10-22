package pi5;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.middleground.permission.permission.folder.FolderPublicPermissionV3;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareFolderInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.FolderPermSetInfo;
import com.bytedance.ee.bear.share.export.ShareParams;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import oi5.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ e a;
    public final /* synthetic */ ShareFolderInfo b;
    public final /* synthetic */ ShareParams c;
    public final /* synthetic */ Context d;

    public d(e r1, ShareFolderInfo r2, ShareParams r3, Context r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        e r8 = this.a;
        ShareFolderInfo r0 = this.b;
        ShareParams r1 = this.c;
        r8.getClass();
        FolderPermSetInfo r9 = h.b(r0, r1);
        HashMap r2 = new HashMap();
        String r3 = r9.i;
        String r4 = "";
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        int r5 = mi5.h.a;
        mi5.h.a(this.a.b, r3, this.d, null, null);
        String r6 = r9.j.a.getReportJson();
        IFolderPublicPermission r10 = r9.j.b;
        if ((r10 instanceof FolderPublicPermissionV3) == false) goto L8;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.permission.folder.FolderPublicPermissionV3");
        r4 = ((FolderPublicPermissionV3) r10).reportJson();
    L8:
        h.a(r2, r6, r4, this.a.b);
    }
}
