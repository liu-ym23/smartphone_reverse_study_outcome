package g7a;

import android.graphics.Bitmap;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.utils.BitmapUtils;

/* JADX INFO: loaded from: classes32.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bitmap f480348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap.CompressFormat f480349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f480350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Callback f480351d;

    public final void a() {
        String r100 = BitmapUtils.bitmapToBase64(this.f480348a, this.f480349b, 100, 2);     // Catch: Throwable -> L5
        JavaOnlyMap r101 = new JavaOnlyMap();     // Catch: Throwable -> L5
        r101.putInt("width", this.f480348a.getWidth());     // Catch: Throwable -> L5
        r101.putInt("height", this.f480348a.getHeight());     // Catch: Throwable -> L5
        r101.putString("data", this.f480350c + r100);     // Catch: Throwable -> L5
        this.f480351d.invoke(new Object[]{0, r101});     // Catch: Throwable -> L5
    L6:
        this.f480348a.recycle();
        return;
    L5:
        this.f480351d.invoke(new Object[]{1, new JavaOnlyMap()});     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        this.f480348a.recycle();
        throw th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public h(Bitmap r100, Bitmap.CompressFormat r101, String r102, Callback r103) {
        this.f480348a = r100;
        this.f480349b = r101;
        this.f480350c = r102;
        this.f480351d = r103;
    }
}
