package nm5;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.share.newshare.e0;
import com.bytedance.ee.bear.share.view.ShareAdapter;
import com.bytedance.ee.bear.share.view.ShareNewFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ ShareNewFragment a;

    public b(ShareNewFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        e0 r3 = (e0) r2;
        ShareAdapter r0 = this.a.n;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r3);
        r0.z2(r3);
        return;
    }
}
