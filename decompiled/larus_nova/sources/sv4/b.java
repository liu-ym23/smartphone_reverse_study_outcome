package sv4;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ee.bear.bizwidget.diagram.OfficeDiagramWebView;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeDiagramWebView f543665a;

    public b(OfficeDiagramWebView r100) {
        this.f543665a = r100;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r100) {
        OfficeDiagramWebView r101 = this.f543665a;
        View.OnClickListener r102 = r101.f216375a;
        if (r102 == null) goto L7;
        r102.onClick(r101);
        return false;
    L7:
        return false;
    }
}
