package xy3;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.comment.write.arch.ability.AbilityManager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f565402a = 0;

    static {
    }

    public static c a(Class r100, LifecycleOwner r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        ConcurrentHashMap<Class<? extends yy3.b>, Map<String, AbilityManager.a<? extends yy3.b>>> r102 = AbilityManager.f194383a;
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        String r103 = String.valueOf(r101.hashCode());
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r103, "key");
        Map<String, AbilityManager.a<? extends yy3.b>> r104 = AbilityManager.f194383a.get(r100);
        Object r105 = null;
        if (r104 == null) goto L7;
        AbilityManager.a<? extends yy3.b> r106 = r104.get(r103);
        if (r106 == null) goto L7;
        Object r107 = r106.f194389a;
    L9:
        if ((r107 instanceof yy3.b) == false) goto L12;
        r105 = r107;
    L12:
        return (c) r105;
    L7:
        r107 = null;
        goto L9
    }

    public static void b(Class r100, LifecycleOwner r101, Observer r102) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "observer");
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        d r103 = (d) a(r100, r101);
        if (r103 == null) goto L6;
        r103.p(r101, r102);
        return;
    }

    public static void c(Class r100, c r101, LifecycleOwner r102) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "ability");
        Intrinsics.checkNotNullParameter(r102, "lifecycleOwner");
        AbilityManager.a(r100, r101, r102);
    }

    public static void d(Class r100, b r101, LifecycleOwner r102) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "ability");
        Intrinsics.checkNotNullParameter(r102, "lifecycleOwner");
        AbilityManager.a(r100, r101, r102);
    }
}
