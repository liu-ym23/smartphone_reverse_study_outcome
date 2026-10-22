package lb1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.text.TextPaint;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class f extends e<nb1.j> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f508317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextPaint f508318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextPaint f508319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bitmap f508320e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f508321f;

    @Override // lb1.g
    public final void a(com.bytedance.android.live.soloktv.template.timeline.a r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r100 = this.f508321f;
        nb1.j r101 = (nb1.j) this.f508316a;
        if (r101 == null) goto L37;
        nb1.d r102 = r101.c();
        if (r102 == null) goto L38;
        nb1.l r103 = r102.a();
        float r104 = r110.f101465d / 1920.0f;
        int r105 = ob1.c.f522593a;
        ob1.c.c(r102, this.f508318c, this.f508319d, r104);
        if (r103 == null) goto L9;
        float r106 = this.f508319d.getFontMetrics().bottom - this.f508319d.getFontMetrics().top;
        float r107 = this.f508319d.getFontMetrics().leading;
    L10:
        float r108 = r106 + r107;
        Paint.FontMetrics r109 = this.f508318c.getFontMetrics();
        float r111 = r109.bottom;
        float r112 = ((r111 - r109.top) / 2) - r111;
        float r113 = this.f508318c.measureText(r100);
        nb1.k r114 = ((nb1.j) this.f508316a).b();
        if (r114 == null) goto L13;
        float r115 = r114.b();
    L14:
        float r116 = r110.f101464c * r115;
        if (r113 <= r116) goto L21;
    L16:
        int r117 = r100.length() - 2;
        if (r117 <= 0) goto L21;
        r100 = r100.substring(0, r117);
        if (this.f508318c.measureText(r100 + this.f508317b) > r116) goto L16;
        r100 = r100 + this.f508317b;
    L21:
        float r118 = this.f508318c.measureText(r100);
        float r119 = 0;
        if (r118 > r119) goto L24;
        return;
    L24:
        if (r108 <= r119) goto L40;
        int r120 = ob1.c.f522593a;
        LinearGradient r121 = ob1.c.a(r102.b(), r118);
        if (r121 == null) goto L29;
        this.f508318c.setShader(r121);
    L29:
        float r122 = (r108 / 2.0f) + r112;
        this.f508320e = Bitmap.createBitmap((int) r118, (int) r108, Bitmap.Config.ARGB_8888);
        Bitmap r123 = this.f508320e;
        Intrinsics.checkNotNull(r123);
        Canvas r124 = new Canvas(r123);
        float r125 = r118 / 2.0f;
        if (r103 == null) goto L32;
        r124.drawText(r100, r125, r122, this.f508319d);
    L32:
        r124.drawText(r100, r125, r122, this.f508318c);
        return;
    L40:
        return;
    L13:
        r115 = 0.0f;
        goto L14
    L9:
        r106 = this.f508318c.getFontMetrics().bottom - this.f508318c.getFontMetrics().top;
        r107 = this.f508318c.getFontMetrics().leading;
        goto L10
    L38:
        return;
    }

    public f(String r100, nb1.j r101) {
        Intrinsics.checkNotNullParameter(r100, "pendingRendText");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super(r101);
        this.f508321f = r100;
        this.f508317b = "...";
        this.f508318c = new TextPaint();
        this.f508319d = new TextPaint();
    }
}
