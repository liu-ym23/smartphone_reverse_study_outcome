package lb1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.text.TextPaint;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nb1.m;

/* JADX INFO: loaded from: classes7.dex */
public final class h extends e<nb1.e> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mb1.b f508322b;

    public h(nb1.e r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super(r100);
        this.f508322b = new mb1.b();
    }

    @Override // lb1.g
    public final void a(com.bytedance.android.live.soloktv.template.timeline.a r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        nb1.e r100 = (nb1.e) this.f508316a;
        if (r100 == null) goto L7;
        nb1.k r101 = r100.b();
        if (r101 == null) goto L7;
        float r102 = r101.a();
    L8:
        float r103 = r110.f101465d;
        float r104 = r102 * r103;
        float r105 = r103 / 1920.0f;
        nb1.e r106 = (nb1.e) this.f508316a;
        if (r106 == null) goto L91;
        mb1.b r107 = this.f508322b;
        com.bytedance.android.live.soloktv.model.k r108 = r110.f101463b;
        if (r108 == null) goto L13;
        List<com.bytedance.component.lyric.model.b> r109 = r108.f101398a;
    L14:
        r107.getClass();
        Intrinsics.checkNotNullParameter(r106, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        r107.f512771f = r106.e();
        r107.f512772g = r109;
        nb1.d r111 = r106.c();
        int r112 = 0;
        if (r111 == null) goto L39;
        r107.f512768c.setTextSize(r111.d() * r105);
        r107.f512767b.setTextSize(r111.d() * r105);
        r107.f512768c.setTextAlign(Paint.Align.CENTER);
        r107.f512767b.setTextAlign(Paint.Align.CENTER);
        m r113 = r106.d();
        m r114 = r106.g();
        TextPaint r115 = r107.f512768c;
        if (r114 == null) goto L19;
        String r116 = r114.b();
    L20:
        r115.setColor(ColorProtector.parseColor(r116));
        TextPaint r117 = r107.f512768c;
        if (r114 == null) goto L23;
        float r118 = r114.a();
    L24:
        float r119 = 255;
        r117.setAlpha((int) (r118 * r119));
        TextPaint r120 = r107.f512767b;
        if (r113 == null) goto L27;
        String r121 = r113.b();
    L28:
        r120.setColor(ColorProtector.parseColor(r121));
        TextPaint r122 = r107.f512767b;
        if (r113 == null) goto L31;
        float r123 = r113.a();
    L32:
        r122.setAlpha((int) (r123 * r119));
        if (r113 == null) goto L38;
        if (r114 == null) goto L38;
        Intrinsics.areEqual(r113.b(), r114.b());
    L38:
        int r124 = ob1.c.f522593a;
        ob1.c.b(r111.c(), r111.e(), new Paint[]{r107.f512767b});
        ob1.c.b(r111.c(), r111.e(), new Paint[]{r107.f512768c});
        ob1.c.c(r111, r107.f512769d, r107.f512770e, r105);
        goto L39
    L31:
        r123 = 1.0f;
        goto L32
    L27:
        r121 = null;
        goto L28
    L23:
        r118 = 1.0f;
        goto L24
    L19:
        r116 = null;
    L39:
        nb1.d r125 = r106.c();
        if (r125 == null) goto L42;
        nb1.l r126 = r125.a();
    L43:
        if (r126 == null) goto L45;
        boolean r127 = true;
    L46:
        if (r127 == false) goto L48;
        float r128 = r107.f512770e.getFontMetrics().bottom - r107.f512770e.getFontMetrics().top;
        float r129 = r107.f512770e.getFontMetrics().leading;
    L49:
        float r130 = r128 + r129;
        int r131 = r107.f512771f;
        if (r131 <= 0) goto L52;
        r130 = r104 / r131;
    L52:
        int r132 = (int) r130;
        if (r109 == null) goto L55;
        r109.size();
    L55:
        if (r109 == null) goto L91;
        Iterator<T> r133 = r109.iterator();
        int r134 = 0;
    L58:
        if (r133.hasNext() == false) goto L91;
        Object r135 = r133.next();
        int r136 = r134 + 1;
        if (r134 >= 0) goto L62;
        CollectionsKt.throwIndexOverflow();
    L62:
        String r137 = ((com.bytedance.component.lyric.model.b) r135).f203031d;
        if (r137 != null) goto L65;
    L68:
        boolean r138 = true;
    L69:
        if (r138 == true) goto L90;
        if (r107.f512766a.containsKey(r137) == true) goto L90;
        float r139 = r107.f512769d.measureText(r137);
        float r140 = r112;
        if (r139 <= r140) goto L90;
        if (r130 <= r140) goto L90;
        int r141 = ob1.c.f522593a;
        nb1.d r142 = r106.c();
        if (r142 == null) goto L80;
        ArrayList<m> r143 = r142.b();
    L81:
        LinearGradient r144 = ob1.c.a(r143, r139);
        if (r144 == null) goto L84;
        r107.f512769d.setShader(r144);
    L85:
        Paint.FontMetrics r145 = r107.f512769d.getFontMetrics();
        float r146 = r145.bottom;
        float r147 = (r130 / 2.0f) + (((r146 - r145.top) / 2) - r146);
        int r148 = (int) r139;
        float r149 = r139 / 2.0f;
        new Canvas(Bitmap.createBitmap(r148, r132, Bitmap.Config.ARGB_8888)).drawText(r137, r149, r147, r107.f512768c);
        Bitmap r150 = Bitmap.createBitmap(r148, r132, Bitmap.Config.ARGB_8888);
        new Canvas(Bitmap.createBitmap(r148, r132, Bitmap.Config.ARGB_8888)).drawText(r137, r149, r147, r107.f512767b);
        Canvas r151 = new Canvas(r150);
        if (r127 == false) goto L88;
        r151.drawText(r137, r149, r147, r107.f512770e);
    L88:
        r151.drawText(r137, r149, r147, r107.f512769d);
        r107.f512766a.put(r137, new mb1.c());
        goto L90
    L84:
        r107.f512769d.setShader(null);
        goto L85
    L80:
        r143 = null;
    L90:
        r112 = 0;
        r134 = r136;
        r106 = r106;
        goto L58
    L65:
        if (r137.length() == 0) goto L68;
        r138 = false;
        goto L69
    L48:
        r128 = r107.f512769d.getFontMetrics().bottom - r107.f512769d.getFontMetrics().top;
        r129 = r107.f512769d.getFontMetrics().leading;
        goto L49
    L45:
        r127 = false;
        goto L46
    L42:
        r126 = null;
        goto L43
    L13:
        r109 = null;
    L91:
        nb1.e r152 = (nb1.e) this.f508316a;
        if (r152 == null) goto L94;
        Integer r153 = Integer.valueOf(r152.f());
    L95:
        if (r153 != null) goto L98;
    L100:
        if (r153 != null) goto L103;
    L105:
        mb1.a r154 = new mb1.d(this.f508322b);
    L106:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        r154.f512765b = r110;
        return;
    L103:
        if (r153.intValue() != 2) goto L105;
        r154 = new mb1.e(this.f508322b);
        goto L106
    L98:
        if (r153.intValue() != 1) goto L100;
        r154 = new mb1.d(this.f508322b);
        goto L106
    L94:
        r153 = null;
    L7:
        r102 = 1.0f;
        goto L8
    }
}
