package rj5;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.TransferApplyInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i0 implements com.bytedance.ee.bear.search.e {
    public final /* synthetic */ TransferApplyInfo a;
    public final /* synthetic */ FragmentActivity b;
    public final /* synthetic */ Fragment c;
    public final /* synthetic */ h0 d;

    @Override // com.bytedance.ee.bear.search.e
    public final void a(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "ownerId");
        Intrinsics.checkNotNullParameter(r5, "ownerName");
        this.a.setOwnerId(r4);
        this.a.setOwnerName(r5);
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).wb(this.b, this.a, this.c, true);
        if (ForsetiHelper.s(this.c) == true) goto L6;
        this.d.getHost().a();
        return;
    }

    public i0(TransferApplyInfo r1, FragmentActivity r2, Fragment r3, h0 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
