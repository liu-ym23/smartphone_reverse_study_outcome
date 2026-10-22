package t6a;

import android.graphics.Rect;
import android.view.animation.Animation;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: classes32.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s6a.a f544702a;

    public abstract Animation b(LynxUI r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, Rect r118, float r119);

    public final boolean c() {
        s6a.a r100 = this.f544702a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.f540861b <= 0) goto L7;
        return true;
    }

    public a() {
        this.f544702a = new s6a.a();
    }

    public final Animation a(LynxUI r100, int r101, int r102, int r103, int r104, int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r118, int r119, int r210, int r211, Rect r212, float r213) {
        if (c() == true) goto L6;
        return null;
    L6:
        Animation r105 = b(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r213);
        if (r105 == null) goto L9;
        r105.setDuration(this.f544702a.f540861b);
        r105.setStartOffset(this.f544702a.f540862c);
        r105.setInterpolator(s6a.b.a(this.f544702a));
    L9:
        return r105;
    }
}
