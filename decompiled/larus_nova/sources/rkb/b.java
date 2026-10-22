package rkb;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.ss.android.lark.image.api.SimpleTarget;

/* JADX INFO: loaded from: classes36.dex */
public class b extends SimpleTarget<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f538438a;

    public b(ImageView r100) {
        this.f538438a = r100;
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public void onLoadCleared(Drawable r100) {
        super.onLoadCleared(r100);
        this.f538438a.setImageDrawable(null);
        this.f538438a.setImageDrawable(r100);
    }
}
