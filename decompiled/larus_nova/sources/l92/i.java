package l92;

import android.view.View;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;

/* JADX INFO: loaded from: classes9.dex */
public final class i implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HighlightItem.d f508105a;

    public i(HighlightItem.d r100) {
        this.f508105a = r100;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        g42.i.a(new h42.c(this.f508105a));
        return true;
    }
}
