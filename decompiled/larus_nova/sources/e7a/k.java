package e7a;

import androidx.recyclerview.widget.GridLayoutManager;
import com.lynx.tasm.behavior.ui.list.UIList;

/* JADX INFO: loaded from: classes32.dex */
public final class k extends GridLayoutManager.SpanSizeLookup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GridLayoutManager f471259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UIList f471260b;

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public final int getSpanSize(int r100) {
        if (this.f471260b.f382632c.F2(r100) == true) goto L5;
    L8:
        return 1;
    L5:
        if (this.f471260b.f382633d <= 1) goto L8;
        return this.f471259a.getSpanCount();
    }

    public k(UIList r100, GridLayoutManager r101) {
        this.f471260b = r100;
        this.f471259a = r101;
    }
}
