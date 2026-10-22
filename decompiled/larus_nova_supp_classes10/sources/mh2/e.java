package mh2;

import android.graphics.Bitmap;
import android.widget.TextView;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ List a;
    public final /* synthetic */ String b;
    public final /* synthetic */ float c;
    public final /* synthetic */ float d;
    public final /* synthetic */ TextView e;
    public final /* synthetic */ boolean f;

    public e(List r1, String r2, float r3, float r4, TextView r5, boolean r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void accept(Object r7) {
        Unit r8 = (Unit) r7;
        HashMap<String, WeakReference<Bitmap>> r9 = q.a;
        q.c(this.a, this.b, this.c, this.d, this.e, this.f);
    }
}
