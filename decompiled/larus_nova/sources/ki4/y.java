package ki4;

import com.bytedance.creativex.mediaimport.repository.api.BuiltInMaterialType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class y extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f503637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BuiltInMaterialType f503638b;

    @Override // ki4.z
    public final BuiltInMaterialType a() {
        return this.f503638b;
    }

    @Override // ki4.z
    public final String b() {
        return this.f503637a;
    }

    public y(String r100, BuiltInMaterialType r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "categoryType");
        this.f503637a = r100;
        this.f503638b = r101;
    }
}
