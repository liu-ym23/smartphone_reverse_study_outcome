package bd5;

import android.view.View;
import com.bytedance.ee.bear.list.homepage.title.SubMenuViewPad;
import com.bytedance.ee.bear.widgets.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o extends t {
    public final /* synthetic */ SubMenuViewPad c;

    public o(SubMenuViewPad r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        SubMenuViewPad r3 = this.c;
        boolean r0 = !r3.e;
        r3.e = r0;
        r3.b(r0);
        SubMenuViewPad r4 = this.c;
        wc5.f.a r1 = r4.a;
        if (r1 == null) goto L5;
        r1.WU(r4.e);
    L5:
        tt5.a.h("SubMenuViewPad", "onClicked: this:" + this.c.hashCode() + " onClickSwitchMenu");
    }
}
