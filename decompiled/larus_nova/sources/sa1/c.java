package sa1;

import android.view.View;
import com.bytedance.android.live.search.impl.search.viewholder.LiveSearchSugViewHolder;
import ra1.g;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveSearchSugViewHolder f541148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f541149b;

    public c(LiveSearchSugViewHolder r100, g r101) {
        this.f541148a = r100;
        this.f541149b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        qa1.c r101 = this.f541148a.f100821f;
        if (r101 == null) goto L6;
        r101.Dw(this.f541149b);
        return;
    }
}
