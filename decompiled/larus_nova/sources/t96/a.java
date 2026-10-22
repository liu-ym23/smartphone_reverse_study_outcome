package t96;

import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f545098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f545099b;

    public abstract void b(EventContext r100, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r101);

    public void onDestroy() {
    }

    public b a() {
        return this.f545099b;
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f545098a = r100;
        this.f545099b = new b(true, CollectionsKt.emptyList(), true);
    }
}
