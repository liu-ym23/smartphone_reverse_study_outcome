package sz7;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.image.api.SimpleTarget;

/* JADX INFO: loaded from: classes24.dex */
public final class m extends SimpleTarget<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Integer f543996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f543997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Drawable f543998c;

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadCleared(Drawable r100) {
        q r101 = this.f543997b;
        if (r101.f544019l == false) goto L6;
        r101.e(this.f543998c);
        return;
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadFailed(Drawable r100) {
        q r101 = this.f543997b;
        if (r101.f544019l == false) goto L6;
        r101.e(this.f543998c);
        return;
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r100) {
        Drawable r101 = (Drawable) r100;
        Integer r102 = this.f543996a;
        if (r102 != null) goto L5;
    L10:
        q r103 = this.f543997b;
        r103.e(q.a(r103, r101, this.f543998c));
        return;
    L5:
        if (r102.intValue() == 0) goto L10;
        if (r101 == null) goto L8;
        r101.mutate();
    L8:
        if (r101 == null) goto L10;
        r101.setTint(this.f543996a.intValue());
        goto L10
    }

    public m(Integer r100, q r101, Drawable r102) {
        this.f543996a = r100;
        this.f543997b = r101;
        this.f543998c = r102;
    }
}
