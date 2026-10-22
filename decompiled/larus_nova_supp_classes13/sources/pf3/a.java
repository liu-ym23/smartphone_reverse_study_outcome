package pf3;

import com.bytedance.android.ec.hybrid.card.event.d;
import com.bytedance.android.ec.hybrid.card.event.e;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class a implements e {

    /* JADX INFO: renamed from: pf3.a$a, reason: collision with other inner class name */
    public static final class C0226a {
    }

    static {
    }

    public a() {
    }

    public abstract void b(Map<String, ? extends Object> r1);

    public final void a(d r3) {
        Intrinsics.checkNotNullParameter(r3, "jsEvent");
        if ((!Intrinsics.areEqual(r3.a, "ec.mall.marketingResource")) == false) goto L5;
        return;
    L5:
        b(r3.b);
    }
}
