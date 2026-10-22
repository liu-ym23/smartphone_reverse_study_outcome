package y08;

import android.view.ViewTreeObserver;
import com.larksuite.component.universe_design.notice.UDNotice;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UDNotice f565591a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        UDNotice r100 = this.f565591a;
        r100.f285167w = false;
        r100.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        if (this.f565591a.f285145a.f285212d.getLineCount() != 1) goto L5;
        UDNotice r101 = this.f565591a;
        UDNotice.R5(r101, r101.f285145a.f285214f, r101.f285162r);
        UDNotice r102 = this.f565591a;
        UDNotice.R5(r102, r102.f285145a.f285213e, false);
        return;
    L5:
        UDNotice r103 = this.f565591a;
        UDNotice.R5(r103, r103.f285145a.f285214f, false);
        UDNotice r104 = this.f565591a;
        UDNotice.R5(r104, r104.f285145a.f285213e, r104.f285162r);
    }

    public a(UDNotice r100) {
        this.f565591a = r100;
    }
}
