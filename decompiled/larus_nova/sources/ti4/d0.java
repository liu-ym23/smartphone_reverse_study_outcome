package ti4;

import com.bytedance.creativex.mediaimport.view.internal.MultiSelectStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MultiSelectStrategy f546073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f0 f546074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j0 f546075c;

    public d0() {
        MultiSelectStrategy r100 = MultiSelectStrategy.ALL;
        f0 r101 = new f0(false, 3);
        j0.a r102 = j0.a.f546100c;
        Intrinsics.checkNotNullParameter(r100, "multiSelectStrategy");
        Intrinsics.checkNotNullParameter(r101, "selectMultipleBehavior");
        Intrinsics.checkNotNullParameter(r102, "singleSelectBehavior");
        this.f546073a = r100;
        this.f546074b = r101;
        this.f546075c = r102;
    }
}
