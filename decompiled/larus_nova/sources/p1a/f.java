package p1a;

import com.bytedance.sdk.account.platform.api.IVKService;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
public abstract class f<T extends BaseComponentFeatureInternal> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<KClass<? extends m1a.a>> f527338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<m1a.d> f527339b;

    public void b(ComponentFeature r100) {
        Intrinsics.checkNotNullParameter(r100, "feature");
    }

    public f() {
        this.f527338a = new ArrayList();
        this.f527339b = new ArrayList();
    }

    public final KClass<? extends T> getType() {
        Intrinsics.throwUninitializedPropertyAccessException("type");
        return null;
    }

    public final void a(KClass<? extends m1a.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "ab");
        this.f527338a.add(r100);
    }

    public final void c(ComponentFeature r100) {
        Intrinsics.checkNotNullParameter(r100, IVKService.ResponseConstants.CREATED);
        b(r100);
        if ((r100 instanceof ComponentFeature) == false) goto L6;
        r100.f375139f.clear();
        r100.f375140g.clear();
        r100.f375139f.addAll(this.f527338a);
        r100.f375140g.addAll(this.f527339b);
        return;
    }

    public final <D extends m1a.d> void d(D r100) {
        Intrinsics.checkNotNullParameter(r100, "default");
        this.f527339b.add(r100);
    }
}
