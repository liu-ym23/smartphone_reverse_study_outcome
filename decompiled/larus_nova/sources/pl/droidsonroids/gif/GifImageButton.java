package pl.droidsonroids.gif;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageButton;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class GifImageButton extends ImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f529686a;

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Drawable r100 = null;
        if (this.f529686a == false) goto L5;
        Drawable r101 = getDrawable();
    L7:
        if (this.f529686a == false) goto L10;
        r100 = getBackground();
    L10:
        return new GifViewSavedState(super.onSaveInstanceState(), new Drawable[]{r101, r100});
    L5:
        r101 = null;
        goto L7
    }

    public GifImageButton(Context r100) {
        super(r100);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof GifViewSavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        GifViewSavedState r101 = (GifViewSavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        r101.a(getDrawable(), 0);
        r101.a(getBackground(), 1);
    }

    @Override // android.view.View
    public void setBackgroundResource(int r100) {
        if (i.c(this, false, r100) == true) goto L6;
        super.setBackgroundResource(r100);
        return;
    }

    public void setFreezesAnimation(boolean r100) {
        this.f529686a = r100;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int r100) {
        if (i.c(this, true, r100) == true) goto L6;
        super.setImageResource(r100);
        return;
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri r100) {
        List<String> r101 = i.f529733a;
        if (r100 != null) goto L11;
    L6:
        boolean r102 = false;
    L7:
        if (r102 == true) goto L13;
        super.setImageURI(r100);
        return;
    L13:
        return;
    L11:
        setImageDrawable(new d(GifInfoHandle.q(getContext().getContentResolver(), r100)));     // Catch: IOException -> L10
        r102 = true;
        goto L7
    }

    public GifImageButton(Context r100, AttributeSet r101) {
        super(r100, r101);
        i.a r102 = i.b(this, r101, 0);
        this.f529686a = r102.f529736a;
        int r103 = r102.f529734c;
        if (r103 <= 0) goto L5;
        super.setImageResource(r103);
    L5:
        int r104 = r102.f529735d;
        if (r104 <= 0) goto L9;
        super.setBackgroundResource(r104);
        return;
    }

    public GifImageButton(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        i.a r103 = i.b(this, r101, r102);
        this.f529686a = r103.f529736a;
        int r104 = r103.f529734c;
        if (r104 <= 0) goto L5;
        super.setImageResource(r104);
    L5:
        int r105 = r103.f529735d;
        if (r105 <= 0) goto L9;
        super.setBackgroundResource(r105);
        return;
    }
}
