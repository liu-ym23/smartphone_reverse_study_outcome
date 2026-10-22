package j41;

import android.graphics.Bitmap;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f497338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f497339b;

    public d(int r100) {
        this.f497338a = 720;
        this.f497339b = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return Bitmap.createScaledBitmap(r101, this.f497338a, this.f497339b, false);
    }
}
