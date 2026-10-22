package ma7;

import android.util.Property;
import android.view.View;
import androidx.core.util.Pair;
import java.util.Iterator;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c f512713d;

    public b(c r100) {
        this.f512713d = r100;
        super(0);
    }

    @Override // ma7.a
    public final void a(float r100) {
        Iterator<Property<View, Float>> r101 = this.f512713d.f512716b.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Property<View, Float> r102 = r101.next();
        Pair<Float, Float> r103 = this.f512713d.f512716b.get(r102);
        r102.set(this.f512713d.f512715a, Float.valueOf(r103.first.floatValue() + (r103.second.floatValue() * r100)));
        goto L4
    }
}
