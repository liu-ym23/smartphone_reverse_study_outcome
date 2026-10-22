package p6a;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes32.dex */
public abstract class c extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f527947a;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public c() {
        Paint r100 = new Paint();
        this.f527947a = r100;
        r100.setStyle(Paint.Style.FILL);
        r100.setAntiAlias(true);
        r100.setColor(-5592406);
    }

    public final void a(int r100) {
        this.f527947a.setColor(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f527947a.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f527947a.setColorFilter(r100);
    }
}
