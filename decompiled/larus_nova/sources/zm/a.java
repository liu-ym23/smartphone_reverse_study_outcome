package zm;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.keyframes.model.KFAnimation;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends ObservableProperty<List<Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f572837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f572838b;

    public a(Object r100, Object r101, b r102) {
        this.f572837a = r100;
        this.f572838b = r102;
        super(r101);
    }

    @Override // kotlin.properties.ObservableProperty
    public final void afterChange(KProperty<?> r100, List<Object> r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        List<Object> r103 = r102;
        Iterator r104 = this.f572838b.f572841a.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((List) r104.next()).clear();
        goto L4
    L6:
        Iterator<T> r105 = r103.iterator();
        int r106 = 0;
        int r107 = 0;
    L8:
        if (r105.hasNext() == false) goto L13;
        Object r108 = r105.next();
        int r109 = r107 + 1;
        if (r107 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        b r110 = this.f572838b;
        ((List) ListProtector.get(r110.f572841a, r107 % r110.f572844d)).add(r108);
        r107 = r109;
        goto L8
    L13:
        Iterator r111 = this.f572838b.f572841a.iterator();
    L15:
        if (r111.hasNext() == false) goto L20;
        Object r112 = r111.next();
        int r113 = r106 + 1;
        if (r106 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();
    L19:
        b.C8476b r114 = (b.C8476b) ListProtector.get(this.f572838b.f572842b, r106);
        r114.setData((List) r112);
        r106 = r113;
        goto L15
    }
}
