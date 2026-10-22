package hp0;

import android.view.View;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.banner.SimpleCarouselIndicator;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SimpleCarouselIndicator f486359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f486360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SimpleCarouselIndicator.a f486361c;

    public a(SimpleCarouselIndicator r100, int r101, SimpleCarouselIndicator.d r102) {
        this.f486359a = r100;
        this.f486360b = r101;
        this.f486361c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f486359a.getDotsClickable() == true) goto L5;
        return;
    L5:
        if (this.f486360b >= this.f486361c.getCount()) goto L9;
        this.f486361c.a(this.f486360b);
        return;
    }
}
