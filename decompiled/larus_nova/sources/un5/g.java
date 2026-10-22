package un5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class g extends ReplacementSpan implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f550799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f550800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f550801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f550802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f550803e;

    @Override // un5.i
    public final boolean E() {
        return false;
    }

    @Override // un5.i
    public final /* synthetic */ int F() {
        throw null;
    }

    public g(Context r100) {
        this.f550802d = 11;
        this.f550803e = new RectF();
        this.f550800b = r100.getResources().getColor(R.color.primary_fill_default);
        this.f550801c = r100.getResources().getColor(R.color.static_white);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        int r105 = ((int) r100.measureText(r101, r102, r103)) + n.d(this.f550802d);
        this.f550799a = r105;
        return r105;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r110, CharSequence r111, int r112, int r210, float r211, int r212, int r213, int r214, Paint r215) {
        int r113 = r215.getColor();
        r215.setColor(this.f550800b);
        r215.setAntiAlias(true);
        RectF r100 = this.f550803e;
        r100.left = r211;
        float r114 = r213;
        r100.top = r215.ascent() + r114;
        RectF r101 = this.f550803e;
        r101.right = this.f550799a + r211;
        r101.bottom = r215.descent() + r114;
        r110.drawRoundRect(this.f550803e, n.d(this.f550802d), n.d(this.f550802d), r215);
        r215.setColor(this.f550801c);
        float r115 = r215.measureText("@");
        r110.drawText("@", 0, 1, n.d(this.f550802d / 2) + r211, r213 - n.d(1), r215);
        String r102 = r111.subSequence(r112, r210).toString();     // Catch: Exception -> L10
        if (r102.contains("@") == false) goto L8;
        String[] r103 = r102.split("@");     // Catch: Exception -> L10
        if (r103.length <= 1) goto L8;
        r102 = r103[1];     // Catch: Exception -> L10
    L8:
        r110.drawText(r102, 0, r102.length(), (r211 + r115) + n.d(this.f550802d / 2), r114, r215);     // Catch: Exception -> L10
    L12:
        r215.setColor(r113);
        return;
    L10:
        e = move-exception;
        tt5.a.e("HighLightUserSpan", "draw: ", e, false);
        goto L12
    }
}
