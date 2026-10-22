package sl4;

import com.bytedance.dux.filter.DuxFilter;
import com.bytedance.dux.filterpanel.DuxFilterGroupView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements DuxFilter.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DuxFilterGroupView f542461a;

    public b(DuxFilterGroupView r100) {
        this.f542461a = r100;
    }

    @Override // com.bytedance.dux.filter.DuxFilter.b
    public final void a(DuxFilter r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "filter");
        if (r101 == false) goto L5;
        DuxFilterGroupView r102 = this.f542461a;
        int r103 = DuxFilterGroupView.f205064n;
        r102.getClass();
        return;
    L5:
        DuxFilterGroupView r104 = this.f542461a;
        int r105 = DuxFilterGroupView.f205064n;
        r104.getClass();
    }
}
