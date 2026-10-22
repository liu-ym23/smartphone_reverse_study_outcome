package bd5;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.list.homepage.title.HomeSubTitleView;
import com.bytedance.ee.bear.widgets.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h extends t {
    public final /* synthetic */ HomeSubTitleView c;

    public h(HomeSubTitleView r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r2) {
        HomeSubTitleView r3 = this.c;
        r3.h = !r3.h;
        AppCompatImageView r4 = r3.f;
        if (r4 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mIvSwitch");
        r4 = null;
    L6:
        if (this.c.h == false) goto L8;
        int r0 = 2131254229;
    L9:
        r4.setImageResource(r0);
        HomeSubTitleView r5 = this.c;
        wc5.f.a r1 = r5.b;
        if (r1 == null) goto L13;
        r1.WU(r5.h);
        return;
    L13:
        return;
    L8:
        r0 = 2131253870;
        goto L9
    }
}
