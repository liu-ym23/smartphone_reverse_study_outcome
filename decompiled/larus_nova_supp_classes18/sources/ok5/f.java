package ok5;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.jsapi.BitableJSApiErrorCode;
import com.bytedance.ee.bear.fileselector.api.FileType;
import com.larksuite.component.universe_design.toast.UDToast;
import kotlin.jvm.internal.Intrinsics;
import na8.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements bb5.c {
    public final /* synthetic */ FragmentActivity a;
    public final /* synthetic */ gk5.a b;

    public final void a(FileType r3) {
        Intrinsics.checkNotNullParameter(r3, "fileType");
        UDToast.show(this.a, 2131886664);
        gk5.a r4 = this.b;
        BitableJSApiErrorCode r0 = BitableJSApiErrorCode.FILE_OVER_LIMIT;
        r4.onFailure(r0.getCode(), r0.getErrMsg());
    }

    public f(FragmentActivity r1, p r2) {
        this.a = r1;
        this.b = r2;
    }
}
