package bd5;

import android.view.View;
import com.bytedance.ee.bear.list.homepage.title.SubMenuViewPad;
import com.bytedance.ee.bear.widgets.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p extends t {
    public final /* synthetic */ SubMenuViewPad c;

    public p(SubMenuViewPad r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        wc5.f.a r3 = this.c.a;
        if (r3 == null) goto L5;
        r3.Qi();
    L5:
        tt5.a.h("SubMenuViewPad", "onClicked: this:" + this.c.hashCode() + " onClickSortMenu");
    }
}
