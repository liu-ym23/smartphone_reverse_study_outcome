package ls2;

import com.bytedance.android.livesdk.ability.AbilityCenter;
import com.bytedance.android.livesdk.ability.IAbility;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, ? super c> f510512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbilityCenter f510513b;

    public c() {
        this.f510512a = new LinkedHashMap();
        this.f510513b = new AbilityCenter();
    }

    public final <T extends IAbility> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "classT");
        T r101 = (T) this.f510513b.getAbility(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new RuntimeException(r100 + " is null, 没有注入，考虑是不是注入时序有问题");
    }

    public final <T extends c> T b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "businessTagId");
        Object r101 = ((LinkedHashMap) this.f510512a).get(r100);
        if ((r101 instanceof c) == true) goto L5;
        r101 = null;
    L5:
        T r102 = (T) r101;
        if (r102 == null) goto L9;
        return r102;
    L9:
        throw new RuntimeException(r100.concat(" is null, 没有注入，考虑是不是注入时序有问题"));
    }

    public final <T extends IAbility> void c(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "abilityClass");
        Intrinsics.checkNotNullParameter(r101, "ability");
        if (this.f510513b.getAbility(r100) != null) goto L7;
        this.f510513b.registerAbility(r100, r101);
        return;
    L7:
        throw new RuntimeException(r100 + " 已经注册过");
    }
}
