package ut8;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes26.dex */
public final class i extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PopupWindow f551691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f551692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f551693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f551694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f551695e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f551696f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f551697g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f551698h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f551699i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f551700j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f551701k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f551702l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f551703m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f551704n;

    public interface a {
        void a(boolean r100, boolean r101, int r102, int r103);

        void b(i r100, MotionEvent r101);
    }

    public interface b {
    }

    public i(Context r100) {
        super(r100);
        this.f551694d = false;
        Resources r101 = getContext().getResources();
        this.f551697g = (int) ((8.0f * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
        this.f551703m = false;
        Resources r102 = getContext().getResources();
        this.f551704n = (int) ((12.0f * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
        int r103 = ContextCompat.getColor(r100, R.color.larus_text_cursor);
        Paint r104 = new Paint(1);
        this.f551692b = r104;
        r104.setColor(r103);
        Paint r105 = new Paint(1);
        this.f551693c = r105;
        r105.setColor(r103);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        if (this.f551703m == false) goto L5;
        return;
    L5:
        int r100 = this.f551704n;
        int r101 = this.f551697g;
        r110.drawCircle(r100 + r101, r100 + r101, r101, this.f551692b);
        if (this.f551695e == false) goto L8;
        int r102 = this.f551704n;
        int r103 = this.f551697g;
        r110.drawRect(r102 + r103, r102, (r103 * 2) + r102, r102 + r103, this.f551693c);
        return;
    L8:
        int r104 = this.f551704n;
        int r105 = this.f551697g;
        r110.drawRect(r104, r104, r104 + r105, r104 + r105, this.f551693c);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f551698h != null) goto L5;
        return true;
    L5:
        int r101 = ((int) r100.getRawX()) + this.f551701k;
        int r102 = ((int) r100.getRawY()) - this.f551702l;
        int r103 = r100.getAction();
        if (r103 == 0) goto L14;
        if (r103 == 1) goto L13;
        if (r103 != 2) goto L10;
        this.f551698h.a(this.f551696f, true, r101, r102);
    L19:
        return true;
    L10:
        if (r103 != 3) goto L19;
    L13:
        this.f551694d = false;
        boolean r104 = this.f551696f;
        this.f551695e = r104;
        this.f551698h.a(r104, false, r101, r102);
        goto L19
    L14:
        this.f551694d = true;
        if (this.f551695e == false) goto L17;
        this.f551701k = (getWidth() - ((int) r100.getX())) - this.f551704n;
    L18:
        this.f551702l = (((int) r100.getY()) - this.f551704n) + (this.f551700j / 2);
        goto L19
    L17:
        this.f551701k = this.f551704n - ((int) r100.getX());
        goto L18
    }

    public void setChangeListener(b r100) {
        this.f551699i = r100;
    }

    public void setIsStartCursor(boolean r100) {
        this.f551695e = r100;
        this.f551696f = r100;
    }

    public void setOutArea(boolean r100) {
        this.f551703m = r100;
    }

    public void setTouchMoveListener(a r100) {
        this.f551698h = r100;
    }
}
