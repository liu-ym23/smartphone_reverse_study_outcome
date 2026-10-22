package pic;

import android.view.KeyEvent;
import android.view.Window;
import com.ss.android.videoshop.context.VideoContext;

/* JADX INFO: loaded from: classes40.dex */
public final class c extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VideoContext f529422b;

    @Override // pic.f, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        if (this.f529422b.s0() == false) goto L15;
        if (r100.getKeyCode() != 4) goto L7;
    L10:
        VideoContext r101 = this.f529422b;
        if (r100.dispatch(r101, r101.f455969w, r101) == false) goto L15;
        return true;
    L7:
        if (this.f529422b.f455966t.isEmpty() == true) goto L15;
        if (this.f529422b.f455966t.contains(Integer.valueOf(r100.getKeyCode())) == true) goto L10;
    L15:
        return super.dispatchKeyEvent(r100);
    }

    public c(VideoContext r100, Window.Callback r101) {
        this.f529422b = r100;
        super(r101);
    }
}
