package com.bytedance.android.window.shop.holder.presenter;

import android.widget.ImageView;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ WindowHeaderAuthorInfoItemPresenter a;
    public final /* synthetic */ ImageView b;

    public e(WindowHeaderAuthorInfoItemPresenter r1, ImageView r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r5) {
        Boolean r6 = (Boolean) r5;
        ImageView r0 = this.b;
        if (r6.booleanValue() == false) goto L5;
        int r1 = 2131234890;
    L6:
        r0.setImageResource(r1);
        WindowHeaderAuthorInfoItemPresenter r2 = this.a;
        boolean r7 = r6.booleanValue();
        int r3 = WindowHeaderAuthorInfoItemPresenter.q;
        ECWindowViewModel r4 = r2.d0();
        Pair[] r8 = new Pair[3];
        r8[0] = TuplesKt.to("enter_from_merge", "store_page");
        r8[1] = TuplesKt.to("enter_method", "live_cell");
        if (r7 == false) goto L9;
        String r9 = "off";
    L10:
        r8[2] = TuplesKt.to("status_to", r9);
        r4.doEventAction("livesdk_open_audio", r8);
        return;
    L9:
        r9 = "on";
        goto L10
    L5:
        r1 = 2131234891;
        goto L6
    }
}
