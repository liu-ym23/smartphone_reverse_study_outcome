package m92;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.interactivity.common.utils.h;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.larus.nova.R;
import g42.i;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f512587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HighlightItem.e f512588b;

    public e(boolean r100, HighlightItem.e r101) {
        this.f512587a = r100;
        this.f512588b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (h.b(this.f512587a) == false) goto L5;
        i42.d r101 = new i42.d(this.f512588b);
        r101.f479967d = true;
        i.a(r101);
        return;
    L5:
        f2.b(R.string.ttlive_pin_not_have_pin_privilege, 0);
    }
}
