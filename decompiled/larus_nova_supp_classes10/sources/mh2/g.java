package mh2;

import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g<V> implements Callable {
    public final /* synthetic */ List a;
    public final /* synthetic */ String b;
    public final /* synthetic */ float c;
    public final /* synthetic */ float d;
    public final /* synthetic */ TextView e;
    public final /* synthetic */ boolean f;

    public g(List r1, String r2, float r3, float r4, TextView r5, boolean r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // java.util.concurrent.Callable
    public final SpannableStringBuilder call() {
        HashMap<String, WeakReference<Bitmap>> r0 = q.a;
        return q.c(this.a, this.b, this.c, this.d, this.e, this.f);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
