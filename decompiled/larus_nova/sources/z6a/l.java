package z6a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.LineBackgroundSpan;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class l implements LineBackgroundSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f570594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f570595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f570596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HashMap<Integer, int[]> f570597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.lynx.tasm.behavior.ui.utils.e f570598e;

    public l(int r100, int r101, com.lynx.tasm.behavior.ui.utils.e r102) {
        this.f570596c = true;
        this.f570594a = r100;
        this.f570595b = r101;
        this.f570598e = r102;
    }

    @Override // android.text.style.LineBackgroundSpan
    public final void drawBackground(Canvas r100, Paint r101, int r102, int r103, int r104, int r105, int r106, CharSequence r107, int r108, int r110, int r111) {
        if (this.f570598e == null) goto L19;
        HashMap<Integer, int[]> r109 = this.f570597d;
        if (r109 != null) goto L7;
        return;
    L7:
        if (this.f570596c == true) goto L10;
        return;
    L10:
        if (r109.containsKey(Integer.valueOf(r111)) == false) goto L21;
        int[] r112 = this.f570597d.get(Integer.valueOf(r111));
        if (r112 != null) goto L14;
        return;
    L14:
        if (r112.length != 2) goto L23;
        T r113 = this.f570598e.f383142b;
        if (((BackgroundDrawable) r113) == null) goto L24;
        ((BackgroundDrawable) r113).setBounds(Math.min(r112[0], r112[1]), r104, Math.max(r112[0], r112[1]), r106);
        ((BackgroundDrawable) this.f570598e.f383142b).draw(r100);
        return;
    L24:
        return;
    L23:
        return;
    L21:
        return;
    }
}
