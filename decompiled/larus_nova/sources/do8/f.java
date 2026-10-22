package do8;

import com.larus.bmhome.chat.component.cvs.y;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes26.dex */
public final class f implements Function0<y> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AttachReceiver f469432a;

    public f(AttachReceiver r100) {
        this.f469432a = r100;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.cvs.y, t1a.a] */
    @Override // kotlin.jvm.functions.Function0
    public final y invoke() {
        AttachReceiver r100 = this.f469432a;
        if ((r100 instanceof EmptyComponent) == false) goto L6;
        return null;
    L6:
        return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(y.class));
    }
}
