package pk5;

import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.jsapi.common.LocationHelper;
import com.bytedance.ee.bear.office.h5jsb.handler.location.ChooseLocationHandler$respondAfterActivityResumed$1;
import kotlin.jvm.internal.Intrinsics;
import na8.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements LocationHelper.a {
    public final /* synthetic */ a a;
    public final /* synthetic */ FragmentActivity b;
    public final /* synthetic */ gk5.a c;

    public final void a(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "response");
        nk5.b.b(this.c, r2);
    }

    public final void b(final JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "response");
        a r0 = this.a;
        final FragmentActivity r1 = this.b;
        final gk5.a r2 = this.c;
        r0.getClass();
        r1.runOnUiThread(new ChooseLocationHandler$respondAfterActivityResumed$1(r1, r2, r4));
    }

    public b(a r1, FragmentActivity r2, p r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
