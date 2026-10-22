package t6a;

import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: classes32.dex */
public abstract class b extends a {
    public abstract boolean d();

    public b() {
    }

    @Override // t6a.a
    public final Animation b(LynxUI r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r118, int r210, int r211, int r212, int r213, int r214, int r215, int r216, int r217, Rect r218, float r219) {
        View r100 = r110.getView();
        int r101 = this.f544702a.f540863d;
        float r102 = 1.0f;
        float r103 = 0.0f;
        if (r101 == 2) goto L37;
        if (r101 == 4) goto L28;
        if (r101 == 8) goto L19;
        if (d() == false) goto L11;
        float r104 = r219;
    L13:
        if (d() == true) goto L17;
        r103 = r219;
    L17:
        return new h(r100, r104, r103);
    L11:
        r104 = 0.0f;
        goto L13
    L19:
        if (d() == false) goto L21;
        float r105 = 1.0f;
    L23:
        if (d() == false) goto L26;
        r102 = 0.0f;
    L26:
        return new ScaleAnimation(r105, r102, r105, r102, 1, 0.5f, 1, 0.5f);
    L21:
        r105 = 0.0f;
        goto L23
    L28:
        if (d() == false) goto L30;
        float r106 = 1.0f;
    L32:
        if (d() == false) goto L35;
        r102 = 0.0f;
    L35:
        return new ScaleAnimation(1.0f, 1.0f, r106, r102, 1, 0.0f, 1, 0.5f);
    L30:
        r106 = 0.0f;
        goto L32
    L37:
        if (d() == false) goto L39;
        float r107 = 1.0f;
    L41:
        if (d() == false) goto L44;
        r102 = 0.0f;
    L44:
        return new ScaleAnimation(r107, r102, 1.0f, 1.0f, 1, 0.5f, 1, 0.0f);
    L39:
        r107 = 0.0f;
        goto L41
    }
}
