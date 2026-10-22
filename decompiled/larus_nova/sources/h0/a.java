package h0;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.LocaleList;

/* JADX INFO: loaded from: classes28.dex */
public final class a extends Paint {
    @Override // android.graphics.Paint
    public final void setTextLocales(LocaleList r100) {
    }

    public a(PorterDuff.Mode r100) {
        setXfermode(new PorterDuffXfermode(r100));
    }

    public a(int r100) {
        super(r100);
    }

    public a(PorterDuff.Mode r100, int r101) {
        super(1);
        setXfermode(new PorterDuffXfermode(r100));
    }
}
