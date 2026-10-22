package com.bytedance.android.window.shop.holder.presenter;

import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.widget.WindowEveryoneTalkCard;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowHeaderEveryoneTalkItemPresenter extends ECWindowHolderBaseFragmentPresenter {
    public WindowEveryoneTalkCard i;
    public oq3.c j;
    public final WindowHeaderEveryoneTalkItemPresenter$observer$1 k;

    public final void c0() {
        d0().getSubCollapseProgress().removeObserver(this.k);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.android.window.shop.holder.presenter.WindowHeaderEveryoneTalkItemPresenter$observer$1] */
    public WindowHeaderEveryoneTalkItemPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.k = new WindowHeaderEveryoneTalkItemPresenter$observer$1(this);
    }

    public final void b0(QModel r3) {
        if ((r3 instanceof oq3.c) == true) goto L5;
        r3 = null;
    L5:
        oq3.c r4 = (oq3.c) r3;
        if (r4 == null) goto L15;
        this.j = r4;
        Object r0 = a0();
        if (r0 == null) goto L14;
        WindowEveryoneTalkCard r1 = (WindowEveryoneTalkCard) r0;
        this.i = r1;
        List<uq3.p> r5 = r4.j;
        if (r5 == null) goto L12;
        r1.R5(r5, new WindowHeaderEveryoneTalkItemPresenter$onBind$$inlined$also$lambda$1(this));
    L12:
        d0().getSubCollapseProgress().observe(e0(), this.k);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.widget.WindowEveryoneTalkCard");
    }
}
