package i3;

import com.bytedance.ai.bridge.core.AIBridgeMethod;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f488079a;

    public c() {
        this.f488079a = new CopyOnWriteArrayList();
    }

    public final AIBridgeMethod.Error a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "invocation");
        Iterator<b> r101 = this.f488079a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        AIBridgeMethod.Error r102 = r101.next().a(r100);
        if (r102 == null) goto L4;
        return r102;
    L8:
        return null;
    }
}
