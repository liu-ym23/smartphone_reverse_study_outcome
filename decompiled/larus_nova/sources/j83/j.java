package j83;

import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.VideoProgressTextLayout;

/* JADX INFO: loaded from: classes13.dex */
public final class j implements com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f497704a;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b
    public final void onDragEnd() {
        this.f497704a.f497674b.setVisibility(8);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b
    public final void onDragStart() {
        a r100 = this.f497704a;
        if (r100.d() == true) goto L5;
        r100.f497674b.setVisibility(0);
        float r101 = r100.f497673a.getDragProgress();
        VideoProgressTextLayout r102 = r100.f497674b;
        int r103 = r100.f497681i;
        r102.f169778a.setText(VideoProgressTextLayout.a((int) (r101 * r103)));
        r102.f169779b.setText(VideoProgressTextLayout.a(r103));
        return;
    L5:
        r100.f497674b.setVisibility(8);
    }

    public j(a r100) {
        this.f497704a = r100;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b
    public final void a(float r100) {
        this.f497704a.f497686n.seek(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b
    public final void b(float r100) {
        a r101 = this.f497704a;
        VideoProgressTextLayout r102 = r101.f497674b;
        int r103 = r101.f497681i;
        r102.f169778a.setText(VideoProgressTextLayout.a((int) (r100 * r103)));
        r102.f169779b.setText(VideoProgressTextLayout.a(r103));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b
    public final void c(float r100) {
        this.f497704a.f497674b.setAlpha(r100);
    }
}
