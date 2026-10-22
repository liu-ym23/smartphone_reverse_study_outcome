package h9c;

import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.ss.android.lark.ug.banner.ui.normal.BannerNormalView;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BannerNormalView f484356a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f484356a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        BannerNormalView r100 = this.f484356a;
        TextView r101 = r100.f444378e;
        if (r101 == null) goto L14;
        TextView r102 = r100.f444379f;
        if (r102 == null) goto L15;
        int r103 = 4 - r101.getLineCount();
        if (r103 > 0) goto L11;
        r102.setVisibility(8);
        return;
    L11:
        r102.setVisibility(0);
        r102.setMaxLines(r103);
        return;
    L15:
        return;
    }

    public b(BannerNormalView r100) {
        this.f484356a = r100;
    }
}
