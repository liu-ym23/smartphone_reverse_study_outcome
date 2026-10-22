package gb5;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ee.bear.imageviewer.view.DiagramWebView;

/* JADX INFO: loaded from: classes16.dex */
public final class c extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DiagramWebView f480726a;

    public c(DiagramWebView r100) {
        this.f480726a = r100;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r100) {
        DiagramWebView r101 = this.f480726a;
        View.OnClickListener r102 = r101.f227034a;
        if (r102 == null) goto L7;
        r102.onClick(r101);
        return false;
    L7:
        return false;
    }
}
