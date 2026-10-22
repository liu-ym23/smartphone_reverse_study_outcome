package s55;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.drive.biz.preview.more.l;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements ph5.d {
    public final /* synthetic */ Context a;
    public final /* synthetic */ d b;

    public final void a(PermissionResponse r3) {
        Intrinsics.checkNotNullParameter(r3, "permissionResponse");
        Toast.cancelLoading();
        ph5.e r0 = r3.getCallback();
        Context r1 = this.a;
        if (r1 != null) goto L5;
        r1 = eu5.b.a;
    L5:
        Intrinsics.checkNotNull(r1);
        r0.a(r1, r3);
        this.b.a(r3);
    }

    public b(FragmentActivity r1, l r2) {
        this.a = r1;
        this.b = r2;
    }
}
