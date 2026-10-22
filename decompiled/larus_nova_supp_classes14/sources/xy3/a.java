package xy3;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.comment.write.arch.ability.AbilityManager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static c a(Class r3, LifecycleOwner r4) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        ConcurrentHashMap<Class<? extends yy3.b>, Map<String, AbilityManager.a<? extends yy3.b>>> r2 = AbilityManager.a;
        Intrinsics.checkNotNullParameter(r3, "clazz");
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        String r5 = String.valueOf(r4.hashCode());
        Intrinsics.checkNotNullParameter(r3, "clazz");
        Intrinsics.checkNotNullParameter(r5, "key");
        Map<String, AbilityManager.a<? extends yy3.b>> r6 = AbilityManager.a.get(r3);
        Object r0 = null;
        if (r6 == null) goto L7;
        AbilityManager.a<? extends yy3.b> r7 = r6.get(r5);
        if (r7 == null) goto L7;
        Object r8 = r7.a;
    L9:
        if ((r8 instanceof yy3.b) == false) goto L12;
        r0 = r8;
    L12:
        return (c) r0;
    L7:
        r8 = null;
        goto L9
    }

    public static void b(Class r3, LifecycleOwner r4, Observer r5) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r5, "observer");
        Intrinsics.checkNotNullParameter(r3, "clazz");
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        d r6 = (d) a(r3, r4);
        if (r6 == null) goto L6;
        r6.p(r4, r5);
        return;
    }

    public static void c(Class r1, c r2, LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r1, "clazz");
        Intrinsics.checkNotNullParameter(r2, "ability");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        AbilityManager.a(r1, r2, r3);
    }

    public static void d(Class r1, b r2, LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r1, "clazz");
        Intrinsics.checkNotNullParameter(r2, "ability");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        AbilityManager.a(r1, r2, r3);
    }
}
