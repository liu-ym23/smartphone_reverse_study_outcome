package n92;

import android.view.View;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import g42.i;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HighlightItem.f f518393a;

    public f(HighlightItem.f r100) {
        this.f518393a = r100;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        i.a(new k42.c(this.f518393a));
        return true;
    }
}
