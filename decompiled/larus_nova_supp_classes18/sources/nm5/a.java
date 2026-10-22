package nm5;

import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.share.newshare.d0;
import com.bytedance.ee.bear.share.view.ShareAdapter;
import com.bytedance.ee.bear.share.view.ShareNewFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ ShareNewFragment a;

    public a(ShareNewFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        d0 r6 = (d0) r5;
        ShareAdapter r0 = this.a.n;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r6);
        r0.y2(r6);
    L5:
        ShareNewFragment r7 = this.a;
        if (r7.o == true) goto L17;
        Window r2 = null;
        zo5.b r1 = (zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6);
        Dialog r3 = r7.getDialog();
        if (r3 == null) goto L11;
        r2 = r3.getWindow();
    L11:
        if (r2 != null) goto L13;
    L15:
        r1.h(r7.fa0().getToken(), r7.fa0().getType());
        r1.j(r7.fa0().getToken(), r7.fa0().getType(), r7.getDialog());
        r7.o = true;
        return;
    L13:
        if ((ShareNewFragment.da0(r2) instanceof FrameLayout) == false) goto L15;
        View r4 = ShareNewFragment.da0(r2);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.widget.FrameLayout");
        r1.detachWatermark((FrameLayout) r4);
        goto L15
    }
}
