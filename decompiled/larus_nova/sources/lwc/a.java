package lwc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.core.error.NoParameterFoundException;

/* JADX INFO: loaded from: classes42.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Object> f511103a;

    /* JADX INFO: renamed from: lwc.a$a, reason: collision with other inner class name */
    public static final class C6746a {
    }

    static {
    }

    public a() {
        this(0);
    }

    public final String toString() {
        return Intrinsics.stringPlus("DefinitionParameters", CollectionsKt.toList(this.f511103a));
    }

    public a(List<? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "values");
        this.f511103a = r100;
    }

    public final a a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return insert(this.f511103a.size(), r100);
    }

    public /* synthetic */ a(int r100) {
        this(CollectionsKt.emptyList());
    }

    public final <T> T b(int r100, KClass<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (this.f511103a.size() <= r100) goto L7;
        return (T) ListProtector.get(this.f511103a, r100);
    L7:
        throw new NoParameterFoundException("Can't get injected parameter #" + r100 + " from " + this + " for type '" + pwc.a.a(r101) + '\'');
    }

    public final a insert(int r100, Object r101) {
        Intrinsics.checkNotNullParameter(r101, "value");
        List<Object> r102 = this.f511103a;
        ArrayList r103 = new ArrayList();
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r102.iterator();
    L4:
        if (r105.hasNext() == false) goto L12;
        Object r106 = r105.next();
        if (this.f511103a.indexOf(r106) >= r100) goto L8;
        boolean r107 = true;
    L9:
        if (r107 == true) goto L10;
        r104.add(r106);
        goto L4
    L10:
        r103.add(r106);
        goto L4
    L8:
        r107 = false;
        goto L9
    L12:
        Pair r108 = new Pair(r103, r104);
        List r109 = (List) r108.component1();
        List r110 = (List) r108.component2();
        return new a(CollectionsKt.plus(CollectionsKt.plus(r109, r101), r110));
    }
}
