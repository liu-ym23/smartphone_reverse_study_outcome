package ma7;

import android.util.Property;
import android.view.View;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.Pair;
import java.util.HashMap;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SparseArrayCompat<Property<View, Float>> f512714c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f512715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Property<View, Float>, Pair<Float, Float>> f512716b;

    static {
        SparseArrayCompat<Property<View, Float>> r100 = new SparseArrayCompat();
        f512714c = r100;
        r100.put(1, View.TRANSLATION_X);
        r100.put(2, View.TRANSLATION_Y);
        r100.put(4, View.TRANSLATION_Z);
        r100.put(8, View.SCALE_X);
        r100.put(16, View.SCALE_Y);
        r100.put(32, View.ROTATION);
        r100.put(64, View.ROTATION_X);
        r100.put(128, View.ROTATION_Y);
        r100.put(256, View.X);
        r100.put(512, View.Y);
        r100.put(1024, View.Z);
        r100.put(2048, View.ALPHA);
    }

    public c(View r100) {
        this.f512716b = new HashMap();
        this.f512715a = r100;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void a(int r100, float r101, float r102) {
        this.f512716b.put(f512714c.get(r100), new Pair(Float.valueOf(r101), Float.valueOf(r102)));
    }
}
