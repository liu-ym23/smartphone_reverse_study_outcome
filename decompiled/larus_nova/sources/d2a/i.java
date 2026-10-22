package d2a;

import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import com.facebook.keyframes.model.KFAnimation;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public class i extends h implements k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f466574i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Property<View, Float> f466575j;

    public i(View r100, Property<View, Float> r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        super(0);
        this.f466574i = r100;
        this.f466575j = r101;
        this.f466573h.setTarget(r100);
        this.f466573h.setProperty(r101);
    }

    @Override // d2a.k
    public final void a(float r100, float r101) {
        float[] r102 = {r100, r101};
        Intrinsics.checkNotNullParameter(r102, "value");
        this.f466573h.setValues(new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(this.f466575j, Arrays.copyOf(r102, 2))});
    }
}
