package s55;

import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.drive.biz.preview.more.l;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements gj5.a {
    public final /* synthetic */ e a;
    public final /* synthetic */ d b;

    public final void a(gj5.c r5) {
        Intrinsics.checkNotNullParameter(r5, TipCallBackData.RESULT);
        Toast.cancelLoading();
        PermissionResponse.Companion.getClass();
        PermissionResponse r0 = PermissionResponse.a.a();
        a r1 = a.a;
        e r2 = this.a;
        a.n(r5, r2.c, a.d(r2.b, r2), this.a);
        r0.setAllow(r5.a);
        this.b.a(r0);
    }

    public c(e r1, l r2) {
        this.a = r1;
        this.b = r2;
    }
}
