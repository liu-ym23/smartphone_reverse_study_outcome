package j83;

import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.VideoProgressTextLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b {
    public final /* synthetic */ a a;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b
    public final void onDragEnd() {
        this.a.b.setVisibility(8);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b
    public final void onDragStart() {
        a r0 = this.a;
        if (r0.d() == true) goto L5;
        r0.b.setVisibility(0);
        float r1 = r0.a.getDragProgress();
        VideoProgressTextLayout r2 = r0.b;
        int r3 = r0.i;
        r2.a.setText(VideoProgressTextLayout.a((int) (r1 * r3)));
        r2.b.setText(VideoProgressTextLayout.a(r3));
        return;
    L5:
        r0.b.setVisibility(8);
    }

    public j(a r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b
    public final void a(float r2) {
        this.a.n.seek(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b
    public final void b(float r4) {
        a r0 = this.a;
        VideoProgressTextLayout r1 = r0.b;
        int r2 = r0.i;
        r1.a.setText(VideoProgressTextLayout.a((int) (r4 * r2)));
        r1.b.setText(VideoProgressTextLayout.a(r2));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b
    public final void c(float r2) {
        this.a.b.setAlpha(r2);
    }
}
