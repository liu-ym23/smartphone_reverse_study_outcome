package zm;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.keyframes.model.KFAnimation;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends ObservableProperty<List<Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f572850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b.C8476b f572851b;

    public c(Object r100, Object r101, b.C8476b r102) {
        this.f572850a = r100;
        this.f572851b = r102;
        super(r101);
    }

    @Override // kotlin.properties.ObservableProperty
    public final void afterChange(KProperty<?> r100, List<Object> r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        this.f572851b.removeAllViews();
        Iterator<T> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        Object r104 = r103.next();
        View r105 = (View) this.f572851b.f572849b.getItemCreator().invoke(r104);
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 != null) goto L8;
        r106 = new LinearLayout.LayoutParams(-1, b.f572840h);
    L8:
        this.f572851b.addView(r105, r106);
        goto L4
    }
}
