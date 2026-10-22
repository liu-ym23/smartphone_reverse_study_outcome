package loc;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.image.api.SimpleTarget;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends SimpleTarget<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SimpleTarget<Drawable> f510166a;

    public c(com.suite.lark.platform.component.cta.newstyle.a r100) {
        this.f510166a = r100;
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadFailed(Drawable r100) {
        super.onLoadFailed(r100);
        this.f510166a.onLoadFailed(r100);
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r100) {
        SimpleTarget<Drawable> r101 = this.f510166a;
        r101.onResourceReady((Drawable) r100);
    }
}
