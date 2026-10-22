package n92;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.interactivity.common.utils.h;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.larus.nova.R;
import g42.i;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f518389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HighlightItem.f f518390b;

    public c(boolean r100, HighlightItem.f r101) {
        this.f518389a = r100;
        this.f518390b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (h.b(this.f518389a) == false) goto L5;
        k42.c r101 = new k42.c(this.f518390b);
        r101.f479967d = true;
        i.a(r101);
        return;
    L5:
        f2.b(R.string.ttlive_pin_not_have_pin_privilege, 0);
    }
}
