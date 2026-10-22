package kjc;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.aweme.paas.IAwemePaasTarget;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class a {
    public static final int a() {
        return ((IAwemePaasTarget) ServiceManager.get().getService(IAwemePaasTarget.class)).a();
    }

    public static final <T> T call(Function1<? super c<T>, ? extends b<T>> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        return r100.invoke(new c()).f503729a;
    }
}
