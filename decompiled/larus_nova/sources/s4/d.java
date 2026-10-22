package s4;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.AIBridgeMethod;
import com.bytedance.ai.utils.g;
import f3.k;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f540530a = null;

    static {
        f540530a = new d();
    }

    public d() {
    }

    public static boolean a(String r110, ContainerType r111) {
        Intrinsics.checkNotNullParameter(r110, "schema");
        if (StringsKt.isBlank(r110) == false) goto L6;
        g.f37637a.e("CanIUseUtils", "handle empty schema");
        return false;
    L6:
        List r112 = StringsKt.split$default(r110, new char[]{'.'}, false, 0, 6, null);
        String r100 = (String) CollectionsKt.getOrNull(r112, 0);
        if (r100 != null) goto L9;
    L12:
        boolean r101 = true;
    L13:
        if (r101 == false) goto L16;
        g.f37637a.e("CanIUseUtils", "API's scope name is empty");
        return false;
    L16:
        String r102 = (String) CollectionsKt.getOrNull(r112, 1);
        if (r102 != null) goto L19;
    L22:
        boolean r103 = true;
    L23:
        if (r103 == false) goto L26;
        g.f37637a.e("CanIUseUtils", "API's method name is empty");
        return false;
    L26:
        if (r111 != null) goto L29;
        g.f37637a.e("CanIUseUtils", "Container type is null");
        return false;
    L29:
        AIBridgeMethod r104 = k.f475321b.a(r100 + '.' + r102, r111);
        if (r104 != null) goto L34;
        g.f37637a.e("CanIUseUtils", "Not found: " + r100 + '.' + r102 + " with container type: " + r111);
        return false;
    L34:
        if (r112.size() != 2) goto L36;
        return true;
    L36:
        ConcurrentHashMap<Class<? extends AIBridgeMethod>, f3.d> r113 = f3.g.f475311a;
        Class<?> r114 = r104.getClass();
        Intrinsics.checkNotNullParameter(r114, "clazz");
        f3.d r115 = f3.g.f475311a.get(r114);
        g.f37637a.d("CanIUseUtils", "annotationData: " + r115);
        return false;
    L19:
        if (r102.length() == 0) goto L22;
        r103 = false;
        goto L23
    L9:
        if (r100.length() == 0) goto L12;
        r101 = false;
        goto L13
    }
}
