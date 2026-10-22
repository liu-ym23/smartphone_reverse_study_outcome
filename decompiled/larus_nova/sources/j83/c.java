package j83;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f497694a;

    @Override // com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.c
    public final void onLoadSuccess() {
        dm.a.a("GalleryVideoVH").i("initVideoCtrlContainerComponent onLoadSuccess");
        a r100 = this.f497694a;
        r100.f497680h = true;
        r100.f497674b.setVisibility(8);
        r100.f497673a.setVisibility(8);
        r100.f497676d.setVisibility(8);
        r100.f497677e.setVisibility(8);
        r100.f497675c.setVisibility(8);
        r100.f497689q.setVisibility(8);
    }

    public c(a r100) {
        this.f497694a = r100;
    }

    @Override // com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.c
    public final void a(String r100) {
        dm.a.a("GalleryVideoVH").b("initVideoCtrlContainerComponent onLoadFailed errMsg=" + r100, null);
        a r101 = this.f497694a;
        r101.f497680h = false;
        r101.f497673a.setVisibility(0);
        r101.f497676d.setVisibility(0);
        r101.f497677e.setVisibility(0);
        r101.f497689q.setVisibility(0);
    }
}
