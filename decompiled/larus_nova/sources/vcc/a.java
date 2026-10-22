package vcc;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.player.player.o;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.photo.preview.video.online.h0;
import com.ss.android.lark.widget.photo.preview.video.online.k0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public abstract class a extends v0c.a implements y0c.b, o {
    public void A(String r100) {
        Intrinsics.checkNotNullParameter(r100, "speedTxt");
    }

    public void B(boolean r100, boolean r101) {
    }

    public abstract void C(boolean r100);

    public abstract void D(boolean r100);

    public void E(boolean r100) {
    }

    public /* synthetic */ void f() {
    }

    public /* synthetic */ void onDoubleTap(MotionEvent r100) {
    }

    public /* synthetic */ void onDown(MotionEvent r100) {
    }

    public /* synthetic */ void onLongPress(MotionEvent r100) {
    }

    public /* synthetic */ void onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
    }

    public /* synthetic */ void onSingleTapUp(MotionEvent r100) {
    }

    public Drawable r() {
        return null;
    }

    public abstract void s();

    public void t() {
    }

    public void u(boolean r100) {
    }

    public abstract void v(boolean r100);

    public void w(boolean r100) {
    }

    public abstract void x(int r100);

    public void y(h0 r100) {
        Intrinsics.checkNotNullParameter(r100, "onLongPressListener");
    }

    public abstract void z(k0 r100);

    public a(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}
