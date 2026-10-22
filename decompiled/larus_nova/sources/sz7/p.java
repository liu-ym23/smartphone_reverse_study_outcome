package sz7;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.larksuite.component.ui.avatar.BorderProperty;
import com.ss.android.lark.image.api.SimpleTarget;

/* JADX INFO: loaded from: classes24.dex */
public final class p extends SimpleTarget<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Integer f544005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f544006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Drawable f544007c;

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadCleared(Drawable r100) {
        q r101 = this.f544006b;
        if (r101.f544019l == false) goto L6;
        r101.e(this.f544007c);
        return;
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadFailed(Drawable r100) {
        q r101 = this.f544006b;
        if (r101.f544019l == false) goto L6;
        r101.e(this.f544007c);
        return;
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r100) {
        Drawable r101 = (Drawable) r100;
        Integer r102 = this.f544005a;
        if (r102 == null) goto L11;
        if (r102.intValue() == 0) goto L11;
        if (r101 == null) goto L8;
        r101.mutate();
    L8:
        if (r101 == null) goto L11;
        r101.setTint(this.f544005a.intValue());
    L11:
        if ((r101 instanceof BitmapDrawable) == false) goto L13;
        this.f544006b.getClass();
        this.f544006b.getClass();
        r101 = new y(this.f544006b.getContext().getResources(), (BitmapDrawable) r101, new BorderProperty(0, 0, this.f544006b.f544020m));
    L13:
        q r103 = this.f544006b;
        r103.e(q.a(r103, r101, this.f544007c));
    }

    public p(Integer r100, q r101, Drawable r102) {
        this.f544005a = r100;
        this.f544006b = r101;
        this.f544007c = r102;
    }
}
