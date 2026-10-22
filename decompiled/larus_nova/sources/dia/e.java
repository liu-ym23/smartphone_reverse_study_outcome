package dia;

import android.content.Context;
import android.view.ViewGroup;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.b1;
import laa.j;

/* JADX INFO: loaded from: classes33.dex */
public final class e extends eia.e {

    public static final class a {
    }

    static {
    }

    @Override // eia.v
    public final void a() {
        FLogger r100 = FLogger.f375446a;
        r100.i("PortraitActionBarStrategy", "applyOrientationChange " + hashCode());
        va8.c r101 = e();
        if (r101 == null) goto L5;
        ViewGroup r102 = ((com.larus.bmhome.chat.component.bottom.core.a) r101).p();
    L6:
        boolean r103 = false;
        if (r102 != null) goto L9;
    L19:
        boolean r104 = false;
    L20:
        if (r104 == false) goto L22;
        r100.i("PortraitActionBarStrategy", "showActionBar skipped, inputAboveLayout is visible");
        boolean r105 = true;
    L23:
        j r106 = (j) this.f472793e.getValue();
        if (r106 == null) goto L30;
        b1 r107 = r106.O4();
        if (r107 == null) goto L30;
        if (((Boolean) r107.getValue()).booleanValue() != true) goto L30;
        boolean r108 = true;
    L31:
        r100.i("PortraitActionBarStrategy", "isInputAboveLayoutVisible: " + r105 + ", isSpecialInputOpen: " + r108);
        if (r105 == true) goto L34;
        if (r108 == true) goto L34;
    L35:
        if (r103 == false) goto L38;
        c();
        return;
    L38:
        d();
        return;
    L34:
        r103 = true;
    L30:
        r108 = false;
        goto L31
    L22:
        r105 = false;
        goto L23
    L9:
        if (r102.getVisibility() != 0) goto L11;
        boolean r109 = true;
    L12:
        if (r109 == true) goto L14;
    L16:
        boolean r110 = false;
    L17:
        if (r110 != true) goto L19;
        r104 = true;
        goto L20
    L14:
        if (r102.getMeasuredHeight() <= 0) goto L16;
        r110 = true;
        goto L17
    L11:
        r109 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    @Override // eia.e
    public final void g() {
        FLogger.f375446a.i("PortraitActionBarStrategy", "onSpecialOpen " + hashCode());
        c();
    }

    @Override // eia.e
    public final void f(boolean r100) {
        FLogger.f375446a.i("PortraitActionBarStrategy", "onInputAboveLayoutVisibleChange " + hashCode() + ", visible " + r100);
        if (r100 == false) goto L5;
        c();
        return;
    L5:
        d();
    }

    public e(Context r100, t1a.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "vContext");
        super(r100, r101);
    }
}
