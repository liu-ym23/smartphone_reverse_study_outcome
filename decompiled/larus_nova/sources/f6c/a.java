package f6c;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends rkb.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Animatable f475733b;

    public a(AppCompatImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "imageView");
        super(r100);
    }

    @Override // rkb.b, com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadCleared(Drawable r100) {
        Animatable r101 = this.f475733b;
        if (r101 == null) goto L5;
        r101.stop();
    L5:
        this.f475733b = null;
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadFailed(Drawable r100) {
        Animatable r101 = this.f475733b;
        if (r101 == null) goto L5;
        r101.stop();
    L5:
        this.f475733b = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadStarted(Drawable r100) {
        if ((r100 instanceof Animatable) == false) goto L6;
        Animatable r101 = (Animatable) r100;
        r101.start();
        this.f475733b = r101;
        return;
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r100) {
        Intrinsics.checkNotNullParameter((Drawable) r100, "resource");
        Animatable r101 = this.f475733b;
        if (r101 == null) goto L5;
        r101.stop();
    L5:
        this.f475733b = null;
    }
}
