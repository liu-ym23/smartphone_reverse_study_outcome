package sm;

import android.view.KeyCharacterMap;
import com.vivo.push.PushClientConstants;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes44.dex */
public final class j implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<KClass<?>, i> f542548a;

    public j() {
        this.f542548a = new ConcurrentHashMap();
    }

    public final <T extends i> void b(KClass<?> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
        Intrinsics.checkNotNullParameter(r101, "instance");
        if (this.f542548a.containsKey(Reflection.getOrCreateKotlinClass(r100.getClass())) == true) goto L7;
        this.f542548a.put(r100, r101);
        return;
    L7:
        throw new KeyCharacterMap.UnavailableException("商品卡重复设置function");
    }
}
