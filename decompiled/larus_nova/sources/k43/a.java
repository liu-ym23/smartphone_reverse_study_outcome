package k43;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.abscontainer.arch.platform.widget.PlatformBodyContainerWidget$childViewNotClickChildren$1;
import com.bytedance.android.shopping.abscontainer.common_biz.platform.BottomPaddingDecoration;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements n43.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayoutManager f501752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BottomPaddingDecoration f501753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f501754c;

    @Override // n43.c
    public final View getView() {
        return this.f501754c;
    }

    public a(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "bodyContainer");
        this.f501754c = r100;
        LinearLayoutManager r101 = new LinearLayoutManager(r100.getContext());
        this.f501752a = r101;
        BottomPaddingDecoration r102 = new BottomPaddingDecoration();
        this.f501753b = r102;
        r100.setLayoutManager(r101);
        r100.addItemDecoration(r102);
        r100.addOnChildAttachStateChangeListener(new PlatformBodyContainerWidget$childViewNotClickChildren$1());
    }

    public final void e(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "childView");
        int[] r102 = new int[2];
        r100.getLocationInWindow(r102);
        Unit r103 = Unit.INSTANCE;
        Integer r104 = ArraysKt.getOrNull(r102, 1);
        if (r104 == null) goto L5;
        int r105 = r104.intValue();
    L6:
        this.f501754c.getLocationInWindow(r102);
        Integer r106 = ArraysKt.getOrNull(r102, 1);
        if (r106 == null) goto L9;
        int r107 = r106.intValue();
    L10:
        if (r101 == false) goto L12;
        this.f501754c.smoothScrollBy(0, r105 - r107);
        return;
    L12:
        this.f501754c.scrollBy(0, r105 - r107);
        return;
    L9:
        r107 = 0;
        goto L10
    L5:
        r105 = 0;
        goto L6
    }

    public final void f(int r100, boolean r101) {
        if (r101 == false) goto L4;
        this.f501754c.smoothScrollToPosition(r100);
        return;
    L4:
        this.f501754c.scrollToPosition(r100);
    }
}
