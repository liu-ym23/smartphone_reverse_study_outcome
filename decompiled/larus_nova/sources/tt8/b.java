package tt8;

import android.view.View;
import android.widget.TextView;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import ut8.k;

/* JADX INFO: loaded from: classes26.dex */
public final class b extends k implements st8.b.InterfaceC7657b {
    public final TextView D;
    public st8.b.c E;

    public static final class a {
    }

    static {
    }

    @Override // ut8.b
    public final void i() {
        FLogger.f375446a.i("SelectorTextView", "hideSelectView, callback=" + this.E);
        super.i();
        st8.b.c r100 = this.E;
        if (r100 == null) goto L6;
        r100.a(true);
        return;
    }

    @Override // ut8.k, ut8.b
    public final void j() {
        FLogger.f375446a.i("SelectorTextView", "onTouchOutside, callback=" + this.E);
        st8.b.c r100 = this.E;
        if (r100 == null) goto L6;
        r100.a(false);
        return;
    }

    @Override // ut8.b
    public final void o() {
        l();
        if (q(g(), this.f551665l) == false) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L14;
        st8.b.c r101 = this.E;
        if (r101 == null) goto L15;
        r101.onShow();
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (q(g(), this.f551666m) == true) goto L8;
        r100 = false;
        goto L9
    }

    public b(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        super(r100);
        this.D = r100;
    }

    public final void s(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "outArr");
        View r101 = this.D.getRootView();
        int r102 = ((this.f551706y + this.A) / 2) - (r101.getMeasuredWidth() / 2);
        int r103 = this.f551707z;
        if (r103 == this.B) goto L5;
        r102 = 0;
    L5:
        r100[0] = r102;
        r100[1] = r103;
        r100[2] = this.C;
    }
}
