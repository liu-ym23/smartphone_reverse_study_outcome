package m92;

import android.view.View;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import g42.i;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HighlightItem.e f512584a;

    public c(HighlightItem.e r100) {
        this.f512584a = r100;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        i.a(new i42.d(this.f512584a));
        return true;
    }
}
