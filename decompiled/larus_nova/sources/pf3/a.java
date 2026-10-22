package pf3;

import com.bytedance.android.ec.hybrid.card.event.d;
import com.bytedance.android.ec.hybrid.card.event.e;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class a implements e {

    /* JADX INFO: renamed from: pf3.a$a, reason: collision with other inner class name */
    public static final class C7191a {
    }

    static {
    }

    public a() {
    }

    public abstract void b(Map<String, ? extends Object> r100);

    @Override // com.bytedance.android.ec.hybrid.card.event.e
    public final void a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "jsEvent");
        if ((!Intrinsics.areEqual(r100.f46489a, "ec.mall.marketingResource")) == false) goto L5;
        return;
    L5:
        b(r100.f46490b);
    }
}
