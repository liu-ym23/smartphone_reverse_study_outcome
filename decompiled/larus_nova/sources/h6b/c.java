package h6b;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.ss.android.lark.image.api.SimpleTarget;

/* JADX INFO: loaded from: classes35.dex */
public final class c extends SimpleTarget<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f483946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f483947b;

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadFailed(Drawable r100) {
        super.onLoadFailed(r100);
        this.f483947b.setImageDrawable(this.f483946a.f483934c);
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r100) {
        Drawable r101 = (Drawable) r100;
        super.onResourceReady(r101);
        if (r101 != null) goto L5;
    L7:
        this.f483947b.setImageDrawable(r101);
        return;
    L5:
        if (this.f483946a.f483937f == null) goto L7;
        r101.mutate();
        r101.setTint(com.ss.android.lark.export.entity.preview.a.a(this.f483946a.f483937f, this.f483947b.getContext(), null));
        goto L7
    }

    public c(b r100, ImageView r101) {
        this.f483946a = r100;
        this.f483947b = r101;
    }
}
