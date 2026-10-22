package io.noties.markwon.ext.onetex;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.edu.onetex.latex.LaTeXParam;
import com.edu.onetex.latex.icon.LaTeXIcon;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.capabilitykit.common.ErrorCode;
import io.noties.markwon.onetex.LatexMathBlock;
import java.util.List;
import lsc.y;
import uvc.b;

/* JADX INFO: loaded from: classes5.dex */
public final class p<N extends uvc.b> implements lsc.m.c<LatexMathBlock> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f492465a;

    public p(o r100) {
        this.f492465a = r100;
    }

    @Override // lsc.m.c
    public final void a(lsc.m r210, uvc.b r211) {
        LatexMathBlock r100 = (LatexMathBlock) r211;
        r210.C(r100);
        String r110 = r100.f492652h;
        o r101 = this.f492465a;
        if (r101.f492455e.f492408g == true) goto L5;
    L7:
        o r102 = this.f492465a;
        t r103 = r102.f492455e.f492402a;
        float r104 = r103.f492471b;
        int r105 = r103.f492475f;
        Resources r106 = r102.f492454d.getResources();
        DisplayMetrics r107 = WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics());
        zs7.a r111 = new zs7.a(Float.MAX_VALUE, 0);
        zs7.a r112 = new zs7.a(r104, 0);
        if (r105 == 0) goto L10;
        int r212 = r105;
    L11:
        LaTeXParam r108 = new LaTeXParam(r110, r111, r112, r107.density, 0, AudioStats.AUDIO_AMPLITUDE_NONE, null, r212, 0, false, false, null, false, ErrorCode.EventTask.LOCATION_DATA_EMPTY, null);
        List<LaTeXIcon> r113 = this.f492465a.q(r108);
        if (r113 == null) goto L18;
        int r114 = r113.size();
        int r115 = 0;
    L14:
        if (r115 >= r114) goto L16;
        int r116 = r210.length();
        Object r109 = this.f492465a.p(r210.B().f510591a, r110, false, (LaTeXIcon) ListProtector.get(r113, r115), Integer.valueOf(r115), Integer.valueOf(r105), Float.valueOf(r104));
        r210.builder().c(" ");
        r210.o(r116, r109);
        r115 = r115 + 1;
        goto L14
    L16:
        r210.q(r100);
        return;
    L18:
        if (this.f492465a.f492455e.f492408g == false) goto L24;
        int r117 = r210.length();
        y r118 = r210.builder();
        this.f492465a.getClass();
        r118.c(o.r(r110));
        r210.o(r117, this.f492465a.o(r210.B().f510591a, r110));
        r210.q(r100);
        return;
    L24:
        return;
    L10:
        r212 = -16777216;
        goto L11
    L5:
        if (o.n(r101, r110) == true) goto L7;
        int r119 = r210.length();
        y r120 = r210.builder();
        this.f492465a.getClass();
        r120.c(o.r(r110));
        r210.o(r119, this.f492465a.o(r210.B().f510591a, r110));
        r210.q(r100);
    }
}
