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
import com.larus.nova.R;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f497672u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VideoProgressBar f497673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VideoProgressTextLayout f497674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PdpGalleryVideoButtonView f497675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PdpGalleryVideoButtonView f497676d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PdpGalleryVideoButtonView f497677e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ECStatusView f497678f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b f497679g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f497680h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f497681i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f497682j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f497683k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f497684l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f497685m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final x73.a f497686n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final View f497687o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final View f497688p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final View f497689q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final l f497690r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final FrameLayout f497691s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final k f497692t;

    /* JADX INFO: renamed from: j83.a$a, reason: collision with other inner class name */
    public static final class C6403a {
    }

    static {
    }

    public final boolean b() {
        l r100 = this.f497690r;
        if (r100 == null) goto L11;
        GalleryViewModel r101 = r100.f169328f;
        if (r101 == null) goto L11;
        LiveData<Boolean> r102 = r101.isMoreVideoExpanded();
        if (r102 == null) goto L11;
        Boolean r103 = r102.getValue();
        if (r103 == null) goto L11;
        return r103.booleanValue();
    L11:
        return false;
    }

    public final void e() {
        if (this.f497686n.isMute() == false) goto L5;
        this.f497677e.setImageResource(R.drawable.ec_pdp_gallery_video_mute);
        return;
    L5:
        this.f497677e.setImageResource(R.drawable.ec_pdp_gallery_video_unmute);
    }

    public final void a() {
        boolean r100 = false;
        if (d() == false) goto L5;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b r101 = this.f497679g;
        if (r101 == null) goto L21;
        r101.k0(false);
        return;
    L21:
        return;
    L5:
        if (this.f497688p.getVisibility() != 8) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
        return;
    L10:
        if (this.f497678f.f46000a == null) goto L12;
        r100 = true;
    L12:
        if (r100 == false) goto L19;
        this.f497688p.setVisibility(8);
        this.f497678f.a();
        return;
    L19:
        return;
    L7:
        r102 = false;
        goto L8
    }

    public final boolean d() {
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.a() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f497680h == false) goto L7;
        return true;
    }

    public final void f() {
        if (d() == true) goto L20;
        l r100 = this.f497690r;
        if (r100 == null) goto L15;
        Integer r101 = this.f497684l;
        if (r101 == null) goto L15;
        int r102 = r101.intValue();
        List<s> r103 = r100.f169328f.getFullThumbList().getValue();
        if (r103 == null) goto L12;
        s r104 = (s) CollectionsKt.getOrNull(r103, r102);
    L13:
        if (r104 == null) goto L15;
        boolean r105 = true;
    L16:
        if (r105 == false) goto L18;
        this.f497675c.setVisibility(0);
        return;
    L18:
        this.f497675c.setVisibility(8);
        return;
    L12:
        r104 = null;
    L15:
        r105 = false;
        goto L16
    }

    public final void g() {
        if (b() == false) goto L5;
        this.f497675c.setImageResource(R.drawable.ec_pdp_gallery_more_video_arrow_up);
        return;
    L5:
        this.f497675c.setImageResource(R.drawable.ec_pdp_gallery_more_video_arrow_down);
    }

    public final void c(float r100) {
        VideoProgressBar r101 = this.f497673a;
        float r102 = r100 / 100;
        r101.getClass();
        r101.f169761c = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r102, 1.0f), 0.0f);
        r101.invalidate();
        a();
        if (this.f497682j == false) goto L5;
        UIUtils.c().removeCallbacks(this.f497683k);
        UIUtils.c().postDelayed(this.f497683k, 1100);
    L5:
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b r103 = this.f497679g;
        if (r103 == null) goto L9;
        r103.m0(r102, this.f497681i * 1000.0f);
        return;
    }

    public final void h(Boolean r100) {
        if (d() == false) goto L5;
        this.f497676d.setVisibility(8);
        this.f497687o.setVisibility(8);
    L11:
        if (r100 == null) goto L13;
        boolean r101 = r100.booleanValue();
    L14:
        this.f497682j = r101;
        if (r101 == false) goto L17;
        UIUtils.c().removeCallbacks(this.f497683k);
        UIUtils.c().postDelayed(this.f497683k, 500);
    L18:
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b r102 = this.f497679g;
        if (r102 == null) goto L24;
        VideoCtrlContainerComponent r103 = r102.f166804c;
        if (r103 == null) goto L25;
        int r104 = VideoCtrlContainerComponent.f166794g;
        r103.c(0);
        return;
    L25:
        return;
    L24:
        return;
    L17:
        Lazy r105 = UIUtils.f45548a;
        UIUtils.c().removeCallbacks(this.f497683k);
        a();
        goto L18
    L13:
        r101 = this.f497686n.isPlaying();
        goto L14
    L5:
        if (r100 == null) goto L7;
        boolean r106 = r100.booleanValue();
    L8:
        if (r106 == false) goto L10;
        this.f497676d.setImageResource(R.drawable.ec_pdp_gallery_video_play);
        this.f497687o.setVisibility(8);
        goto L11
    L10:
        this.f497676d.setImageResource(R.drawable.ec_pdp_gallery_video_pause);
        this.f497687o.setVisibility(0);
        View r107 = this.f497687o;
        r107.setAlpha(0.2f);
        r107.setScaleX(1.4f);
        r107.setScaleY(1.4f);
        r107.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(150).start();
        goto L11
    L7:
        r106 = this.f497686n.isPlaying();
        goto L8
    }

    public a(View r100, x73.a r101, View r102, View r103, View r104, l r105, FrameLayout r106, GalleryVideoVH.b r107) {
        Intrinsics.checkNotNullParameter(r100, "layoutControl");
        Intrinsics.checkNotNullParameter(r101, "videoView");
        Intrinsics.checkNotNullParameter(r102, "btnPlayCenter");
        Intrinsics.checkNotNullParameter(r103, "layoutLoading");
        Intrinsics.checkNotNullParameter(r104, "viewBgGradient");
        Intrinsics.checkNotNullParameter(r106, "lynxLayoutContainer");
        Intrinsics.checkNotNullParameter(r107, "callback");
        this.f497685m = r100;
        this.f497686n = r101;
        this.f497687o = r102;
        this.f497688p = r103;
        this.f497689q = r104;
        this.f497690r = r105;
        this.f497691s = r106;
        this.f497692t = r107;
        this.f497673a = (VideoProgressBar) r100.findViewById(R.id.video_progress);
        this.f497674b = (VideoProgressTextLayout) r100.findViewById(R.id.video_progress_text);
        this.f497675c = (PdpGalleryVideoButtonView) r100.findViewById(R.id.btn_more_video_handle);
        this.f497676d = (PdpGalleryVideoButtonView) r100.findViewById(R.id.btn_video_play);
        this.f497677e = (PdpGalleryVideoButtonView) r100.findViewById(R.id.btn_video_audio);
        this.f497678f = (ECStatusView) r103.findViewById(R.id.view_loading);
        this.f497683k = new b(this);
    }
}
