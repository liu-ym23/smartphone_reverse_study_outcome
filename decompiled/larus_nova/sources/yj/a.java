package yj;

import com.bytedance.android.ec.hybrid.api.card.IECHybridCardService;
import com.bytedance.android.shopping.verse.api.IVerseService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f568005a = null;

    public a() {
    }

    static {
        f568005a = new a();
    }

    @Override // yj.q
    public final <T> T getService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        if (Intrinsics.areEqual(r100, IVerseService.class) == false) goto L8;
        T r101 = (T) ServiceManager.get().getService(IVerseService.class);
        if ((r101 instanceof Object) == true) goto L13;
    L11:
        return null;
    L13:
        return r101;
    L8:
        if (Intrinsics.areEqual(r100, IECHybridCardService.class) == false) goto L11;
        T r102 = (T) ServiceManager.get().getService(IECHybridCardService.class);
        if ((r102 instanceof Object) == false) goto L11;
        return r102;
    }
}
