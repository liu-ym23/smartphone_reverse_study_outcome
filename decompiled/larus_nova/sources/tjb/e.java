package tjb;

import android.text.Layout;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppCompatTextView f546463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f546464b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.f546463a.getViewTreeObserver().removeOnPreDrawListener(this);
        Layout r100 = this.f546463a.getLayout();
        if (r100 != null) goto L7;
        return true;
    L7:
        if (r100.getLineCount() <= this.f546464b) goto L9;
        this.f546463a.setTextSize(2, 14.0f);
    L9:
        this.f546463a.setMaxLines(this.f546464b);
        return false;
    }

    public e(AppCompatTextView r100, int r101) {
        this.f546463a = r100;
        this.f546464b = r101;
    }
}
