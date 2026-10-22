package tfc;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.photoeditor.mosaic.AbstractMosaicStrategy;
import com.ss.android.photoeditor.mosaic.MosaicPhotoEditorPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MosaicPhotoEditorPlugin f545820a;

    public e(MosaicPhotoEditorPlugin r100) {
        this.f545820a = r100;
    }

    /* JADX WARN: Type inference failed for: r12v0, types: [tfc.c] */
    /* JADX WARN: Type inference failed for: r7v13, types: [tfc.d] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r210) {
        final MosaicPhotoEditorPlugin r100 = this.f545820a;
        if (CollectionUtils.isEmpty(r100.f449277n) == false) goto L6;
    L91:
        boolean r101 = this.f545820a.f449279p;
        return;
    L6:
        if (r100.f449279p == false) goto L30;
        com.ss.android.photoeditor.mosaic.c.a r102 = r100.f449278o;
        if (r102 == null) goto L91;
        r102.f449340c = false;
        pfc.f r103 = pfc.f.i();
        Handler r104 = r103.f529054f;
        if (r104 == null) goto L13;
        r104.removeCallbacksAndMessages(null);
    L13:
        Iterator r105 = ((ArrayList) r103.f529051c).iterator();
    L15:
        if (r105.hasNext() == false) goto L19;
        pfc.f.a r106 = (pfc.f.a) r105.next();
        pfc.f.b r107 = r106.f529057b;
        if (r107 == null) goto L15;
        r107.f529062e = null;
        r107.f529063f = null;
        r106.f529057b = null;
        goto L15
    L19:
        Iterator r108 = ((ArrayList) r103.f529050b).iterator();
    L21:
        if (r108.hasNext() == false) goto L25;
        pfc.f.a r109 = (pfc.f.a) r108.next();
        pfc.f.b r110 = r109.f529057b;
        if (r110 == null) goto L21;
        r110.f529062e = null;
        r110.f529063f = null;
        r109.f529057b = null;
        goto L21
    L25:
        pfc.f.i().a(new MosaicPhotoEditorPlugin.c(r102, new d(r100)));
        r100.f449278o = null;
        r100.f449279p = false;
        TextView r111 = r100.f449273j;
        if (r111 == null) goto L29;
        r111.setSelected(false);
    L29:
        pfc.f.i().f529049a.size();
        r100.f449270g.m();
        goto L91
    L30:
        Iterator r112 = ((HashMap) r100.f449274k).values().iterator();
    L32:
        if (r112.hasNext() == false) goto L83;
        AbstractMosaicStrategy r113 = (AbstractMosaicStrategy) r112.next();
        if ((r113 instanceof com.ss.android.photoeditor.mosaic.c) == false) goto L32;
        com.ss.android.photoeditor.mosaic.c r114 = (com.ss.android.photoeditor.mosaic.c) r113;
        List<RectF> r115 = r100.f449277n;
        ?? r116 = new c(r100);
        if (r114.f449331p == null) goto L80;
        if (r114.f449249e == null) goto L80;
        if (CollectionUtils.isEmpty(r115) == true) goto L80;
        RectF r117 = new RectF(r114.f449249e);
        pfc.f.b r118 = pfc.f.i().d();
        float r119 = 0.0f;
        if (r118 != null) goto L45;
    L47:
        Path r120 = new Path();
        Iterator<RectF> r121 = r115.iterator();
    L49:
        if (r121.hasNext() == false) goto L76;
        RectF r122 = r121.next();
        RectF r123 = new RectF(r118.f529059b);
        RectF r124 = new RectF(r118.f529058a);
        int r125 = r118.f529060c;
        RectF r126 = new RectF(r123);
        if (r125 == 0) goto L53;
        com.ss.android.photoeditor.util.b.d(r126, -r125, r119, r119);
    L53:
        pfc.f.b r211 = r118;
        RectF r127 = new RectF(r126.left + (r122.left * r126.width()), r126.top + (r122.top * r126.height()), r126.left + (r122.right * r126.width()), r126.top + (r122.bottom * r126.height()));
        if (r125 == 0) goto L56;
        com.ss.android.photoeditor.util.b.d(r127, r125, 0.0f, 0.0f);
    L56:
        RectF r128 = new RectF();
        if (r128.setIntersect(r127, r124) == false) goto L70;
        float r129 = r124.width();
        float r130 = r124.height();
        if (r129 <= 0.0f) goto L70;
        if (r130 <= 0.0f) goto L70;
        float r131 = r117.left + (((r128.left - r124.left) / r129) * r117.width());
        float r132 = r117.left + (((r128.right - r124.left) / r129) * r117.width());
        float r133 = r117.top + (((r128.top - r124.top) / r130) * r117.height());
        float r134 = r117.top + (((r128.bottom - r124.top) / r130) * r117.height());
        if ((r132 - r131) <= 0.0f) goto L70;
        if ((r134 - r133) <= 0.0f) goto L70;
        RectF r135 = new RectF(r131, r133, r132, r134);
    L71:
        if (r135 == null) goto L74;
        r120.addRect(r135.left, r135.top, r135.right, r135.bottom, Path.Direction.CW);
    L74:
        r118 = r211;
        r119 = 0.0f;
    L70:
        r135 = null;
        goto L71
    L76:
        if (r120.isEmpty() == true) goto L83;
        Paint r136 = new Paint();
        r136.setStyle(Paint.Style.FILL_AND_STROKE);
        r136.setAntiAlias(true);
        com.ss.android.photoeditor.mosaic.c.a r137 = new com.ss.android.photoeditor.mosaic.c.a(r117, new RectF(0.0f, 0.0f, (int) r114.f449251g.width(), (int) r114.f449251g.height()), r120, r136, r114.f449331p, r116);
        r115.size();
        r117.toString();
        Objects.toString(r114.f449250f);
        pfc.f.i().a(r137);
    L84:
        if (r137 == null) goto L91;
        r100.f449278o = r137;
        r100.f449279p = true;
        TextView r138 = r100.f449273j;
        if (r138 == null) goto L90;
        r138.setSelected(true);
    L90:
        pfc.f.i().f529049a.size();
        r100.f449270g.m();
        goto L91
    L45:
        if (r118.f529058a.width() <= 0.0f) goto L47;
        r117.bottom = r117.top + (r117.width() * (r118.f529058a.height() / r118.f529058a.width()));
    L80:
        if (r115 == null) goto L83;
        r115.size();
    L83:
        r137 = null;
        goto L84
    }
}
