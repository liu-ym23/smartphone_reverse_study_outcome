package l92;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f508102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HighlightItem.d f508103b;

    public g(boolean r100, HighlightItem.d r101) {
        this.f508102a = r100;
        this.f508103b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (com.bytedance.android.livesdk.interactivity.common.utils.h.b(this.f508102a) == false) goto L5;
        h42.c r101 = new h42.c(this.f508103b);
        r101.f479967d = true;
        g42.i.a(r101);
        return;
    L5:
        f2.b(R.string.ttlive_pin_not_have_pin_privilege, 0);
    }
}
