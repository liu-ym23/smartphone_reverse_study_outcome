package j83;

import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LiveData;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.core.widget.ECStatusView;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.VideoCtrlContainerComponent;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.GalleryViewModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.s;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.GalleryVideoVH;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.PdpGalleryVideoButtonView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.VideoProgressBar;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.VideoProgressTextLayout;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int u = 0;
    public final VideoProgressBar a;
    public final VideoProgressTextLayout b;
    public final PdpGalleryVideoButtonView c;
    public final PdpGalleryVideoButtonView d;
    public final PdpGalleryVideoButtonView e;
    public final ECStatusView f;
    public com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b g;
    public boolean h;
    public int i;
    public boolean j;
    public final b k;
    public Integer l;
    public final View m;
    public final x73.a n;
    public final View o;
    public final View p;
    public final View q;
    public final l r;
    public final FrameLayout s;
    public final k t;

    /* JADX INFO: renamed from: j83.a$a, reason: collision with other inner class name */
    public static final class C0207a {
    }

    static {
    }

    public final boolean b() {
        l r0 = this.r;
        if (r0 == null) goto L11;
        GalleryViewModel r1 = r0.f;
        if (r1 == null) goto L11;
        LiveData<Boolean> r2 = r1.isMoreVideoExpanded();
        if (r2 == null) goto L11;
        Boolean r3 = (Boolean) r2.getValue();
        if (r3 == null) goto L11;
        return r3.booleanValue();
    L11:
        return false;
    }

    public final void e() {
        if (this.n.isMute() == false) goto L5;
        this.e.setImageResource(2131234641);
        return;
    L5:
        this.e.setImageResource(2131234645);
    }

    public final void a() {
        boolean r1 = false;
        if (d() == false) goto L5;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b r0 = this.g;
        if (r0 == null) goto L21;
        r0.k0(false);
        return;
    L21:
        return;
    L5:
        if (this.p.getVisibility() != 8) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L10;
        return;
    L10:
        if (this.f.a == null) goto L12;
        r1 = true;
    L12:
        if (r1 == false) goto L19;
        this.p.setVisibility(8);
        this.f.a();
        return;
    L19:
        return;
    L7:
        r2 = false;
        goto L8
    }

    public final boolean d() {
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.a() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.h == false) goto L7;
        return true;
    }

    public final void f() {
        if (d() == true) goto L20;
        l r0 = this.r;
        if (r0 == null) goto L15;
        Integer r2 = this.l;
        if (r2 == null) goto L15;
        int r3 = r2.intValue();
        List r1 = (List) r0.f.getFullThumbList().getValue();
        if (r1 == null) goto L12;
        s r4 = (s) CollectionsKt.getOrNull(r1, r3);
    L13:
        if (r4 == null) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == false) goto L18;
        this.c.setVisibility(0);
        return;
    L18:
        this.c.setVisibility(8);
        return;
    L12:
        r4 = null;
    L15:
        r5 = false;
        goto L16
    }

    public final void g() {
        if (b() == false) goto L5;
        this.c.setImageResource(2131234639);
        return;
    L5:
        this.c.setImageResource(2131234638);
    }

    public final void c(float r5) {
        VideoProgressBar r0 = this.a;
        float r6 = r5 / 100;
        r0.getClass();
        r0.c = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r6, 1.0f), 0.0f);
        r0.invalidate();
        a();
        if (this.j == false) goto L5;
        UIUtils.c().removeCallbacks(this.k);
        UIUtils.c().postDelayed(this.k, 1100);
    L5:
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b r1 = this.g;
        if (r1 == null) goto L9;
        r1.m0(r6, this.i * 1000.0f);
        return;
    }

    public final void h(Boolean r5) {
        if (d() == false) goto L5;
        this.d.setVisibility(8);
        this.o.setVisibility(8);
    L11:
        if (r5 == null) goto L13;
        boolean r6 = r5.booleanValue();
    L14:
        this.j = r6;
        if (r6 == false) goto L17;
        UIUtils.c().removeCallbacks(this.k);
        UIUtils.c().postDelayed(this.k, 500);
    L18:
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b r7 = this.g;
        if (r7 == null) goto L24;
        VideoCtrlContainerComponent r8 = r7.c;
        if (r8 == null) goto L25;
        int r0 = VideoCtrlContainerComponent.g;
        r8.c(0);
        return;
    L25:
        return;
    L24:
        return;
    L17:
        Lazy r9 = UIUtils.a;
        UIUtils.c().removeCallbacks(this.k);
        a();
        goto L18
    L13:
        r6 = this.n.isPlaying();
        goto L14
    L5:
        if (r5 == null) goto L7;
        boolean r1 = r5.booleanValue();
    L8:
        if (r1 == false) goto L10;
        this.d.setImageResource(2131234644);
        this.o.setVisibility(8);
        goto L11
    L10:
        this.d.setImageResource(2131234642);
        this.o.setVisibility(0);
        View r2 = this.o;
        r2.setAlpha(0.2f);
        r2.setScaleX(1.4f);
        r2.setScaleY(1.4f);
        r2.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(150).start();
        goto L11
    L7:
        r1 = this.n.isPlaying();
        goto L8
    }

    public a(View r2, x73.a r3, View r4, View r5, View r6, l r7, FrameLayout r8, GalleryVideoVH.b r9) {
        Intrinsics.checkNotNullParameter(r2, "layoutControl");
        Intrinsics.checkNotNullParameter(r3, "videoView");
        Intrinsics.checkNotNullParameter(r4, "btnPlayCenter");
        Intrinsics.checkNotNullParameter(r5, "layoutLoading");
        Intrinsics.checkNotNullParameter(r6, "viewBgGradient");
        Intrinsics.checkNotNullParameter(r8, "lynxLayoutContainer");
        Intrinsics.checkNotNullParameter(r9, "callback");
        this.m = r2;
        this.n = r3;
        this.o = r4;
        this.p = r5;
        this.q = r6;
        this.r = r7;
        this.s = r8;
        this.t = r9;
        this.a = (VideoProgressBar) r2.findViewById(2131392352);
        this.b = (VideoProgressTextLayout) r2.findViewById(2131392354);
        this.c = (PdpGalleryVideoButtonView) r2.findViewById(2131364768);
        this.d = (PdpGalleryVideoButtonView) r2.findViewById(2131364878);
        this.e = (PdpGalleryVideoButtonView) r2.findViewById(2131364877);
        this.f = r5.findViewById(2131392546);
        this.k = new b(this);
    }
}
