package ht2;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f487107a;

    public c(View r100) {
        this.f487107a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f487107a.setBackground(new BitmapDrawable(null, (Bitmap) r100));
    }
}
