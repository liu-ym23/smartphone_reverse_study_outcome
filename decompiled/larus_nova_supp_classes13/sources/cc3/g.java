package cc3;

import android.widget.SeekBar;
import android.widget.TextView;
import com.bytedance.android.shopping.commentgallery.view.CommentGalleryVideoVHNew;
import com.bytedance.services.apm.api.EnsureManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ CommentGalleryVideoVHNew a;

    public g(CommentGalleryVideoVHNew r1) {
        this.a = r1;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r3) {
        CommentGalleryVideoVHNew r4 = this.a;
        int r0 = CommentGalleryVideoVHNew.p;
        r4.getClass();
        if (this.a.c.d() == false) goto L5;
        this.a.play();
    L5:
        this.a.d.setVisibility(0);
        this.a.e.setVisibility(0);
        CommentGalleryVideoVHNew r5 = this.a;
        if (r5.o == false) goto L10;
        TextView r6 = r5.f;
        if (r6 == null) goto L10;
        r6.setVisibility(0);
    L10:
        n r7 = this.a.m;
        if (r7 == null) goto L14;
        r7.a();
        return;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r3) {
        if (r3 != null) goto L20;
    L7:
        TextView r0 = this.a.d;
        if (r3 == null) goto L10;
        String r4 = com.bytedance.android.shopping.utils.g.b(r3.getProgress() / 1000);
    L11:
        r0.setText(r4);
        this.a.getClass();
        this.a.d.setVisibility(4);
        this.a.e.setVisibility(4);
        CommentGalleryVideoVHNew r5 = this.a;
        if (r5.o == false) goto L16;
        TextView r6 = r5.f;
        if (r6 == null) goto L16;
        r6.setVisibility(4);
    L16:
        n r7 = this.a.m;
        if (r7 == null) goto L22;
        r7.b();
        return;
    L22:
        return;
    L10:
        r4 = null;
        goto L11
    L20:
        this.a.c.v((r3.getProgress() * 100) / r3.getMax());     // Catch: Exception -> L5
    L5:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        goto L7
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r1, int r2, boolean r3) {
        if (r3 == false) goto L5;
        this.a.g.setProgress(r2);
        TextView r4 = this.a.d;
        int r5 = com.bytedance.android.shopping.utils.g.a;
        r4.setText(com.bytedance.android.shopping.utils.g.b(r2 / 1000));
        return;
    }
}
