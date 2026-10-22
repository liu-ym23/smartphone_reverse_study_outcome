package do8;

import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes26.dex */
public final class e implements Function0<de8.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AttachReceiver f469431a;

    public e(AttachReceiver r100) {
        this.f469431a = r100;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [de8.c, t1a.c] */
    @Override // kotlin.jvm.functions.Function0
    public final de8.c invoke() {
        AttachReceiver r100 = this.f469431a;
        if ((r100 instanceof EmptyComponent) == false) goto L6;
        return null;
    L6:
        return s1a.d.a(r100).g(Reflection.getOrCreateKotlinClass(de8.c.class));
    }
}
