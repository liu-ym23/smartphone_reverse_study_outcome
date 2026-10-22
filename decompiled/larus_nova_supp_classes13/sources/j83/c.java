package j83;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.c {
    public final /* synthetic */ a a;

    public final void onLoadSuccess() {
        dm.a.a("GalleryVideoVH").i("initVideoCtrlContainerComponent onLoadSuccess");
        a r0 = this.a;
        r0.h = true;
        r0.b.setVisibility(8);
        r0.a.setVisibility(8);
        r0.d.setVisibility(8);
        r0.e.setVisibility(8);
        r0.c.setVisibility(8);
        r0.q.setVisibility(8);
    }

    public c(a r1) {
        this.a = r1;
    }

    public final void a(String r4) {
        dm.a.a("GalleryVideoVH").b("initVideoCtrlContainerComponent onLoadFailed errMsg=" + r4, null);
        a r5 = this.a;
        r5.h = false;
        r5.a.setVisibility(0);
        r5.d.setVisibility(0);
        r5.e.setVisibility(0);
        r5.q.setVisibility(0);
    }
}
