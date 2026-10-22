package k70;

import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.element.ElementBuilderMap;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import j70.f;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ElementBuilderMap f501981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LayerEventDispatcher f501982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p70.b f501983c;

    /* JADX WARN: Multi-variable type inference failed */
    public final Class<j70.e> b(Class<?> r100) {
        if (j70.e.class.isAssignableFrom(r100) == true) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r100, Object.class) == false) goto L8;
        return null;
    L8:
        Class<?>[] r101 = r100.getInterfaces();
        int r102 = r101.length;
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L14;
        Class<j70.e> r104 = r101[r103];
        if (j70.e.class.isAssignableFrom(r104) == true) goto L12;
        r103 = r103 + 1;
        goto L9
    L12:
        return r104;
    L14:
        Class<? super Object> r105 = r100.getSuperclass();
        if (r105 == null) goto L19;
        return b(r105);
    L19:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
    }

    @Override // k70.c
    public final Element<?> a(f r100, j70.e r101) {
        Intrinsics.checkNotNullParameter(r100, "elementType");
        Intrinsics.checkNotNullParameter(r101, "elementAttribute");
        Class<j70.e> r102 = b(r101.getClass());
        Intrinsics.checkNotNull(r102);
        b<? extends j70.e> r103 = this.f501981a.get(r102);
        if (r103 == null) goto L7;
        Element<?> r104 = r103.a(r101);
        LayerEventDispatcher r105 = this.f501982b;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r104.f65666h = r105;
        p70.b r106 = this.f501983c;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r104.f65667i = r106;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r104.f65662d = r100;
        return r104;
    L7:
        throw new IllegalArgumentException("There is no ElementBuilder for " + r102 + " .");
    }

    public e(ElementBuilderMap r100, h70.b r101, LayerEventDispatcher r102, p70.b r103) {
        Intrinsics.checkNotNullParameter(r100, "elementBuilderMap");
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        Intrinsics.checkNotNullParameter(r102, "layerEventDispatcher");
        Intrinsics.checkNotNullParameter(r103, "processChains");
        this.f501981a = r100;
        this.f501982b = r102;
        this.f501983c = r103;
        Iterator<Map.Entry<Class<? extends j70.e>, b<? extends j70.e>>> r104 = r100.entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        b<? extends j70.e> r105 = r104.next().getValue();
        r105.getClass();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r105.f501980a = r101;
        goto L4
    }
}
