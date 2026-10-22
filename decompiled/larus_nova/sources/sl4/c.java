package sl4;

import android.view.View;
import com.bytedance.dux.filter.DuxFilter;
import com.bytedance.dux.filterpanel.DuxFilterGroupView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DuxFilterGroupView f542462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DuxFilter f542463b;

    public c(DuxFilterGroupView r100, DuxFilter r101) {
        this.f542462a = r100;
        this.f542463b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100.isSelected() == false) goto L9;
        DuxFilterGroupView r101 = this.f542462a;
        if (r101.f205069e == 1) goto L7;
    L8:
        this.f542463b.setSelected(false);
    L34:
        DuxFilterGroupView r102 = this.f542462a;
        int r103 = DuxFilterGroupView.f205064n;
        r102.getClass();
        return;
    L7:
        if (r101.f205077m == true) goto L8;
    L9:
        DuxFilterGroupView r104 = this.f542462a;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.dux.filter.DuxFilter");
        DuxFilter r105 = (DuxFilter) r100;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "filter");
        if (r105.isSelected() == true) goto L34;
        List<DuxFilter> r106 = r104.f205075k;
        if ((r106 instanceof Collection) == true) goto L15;
    L17:
        Iterator r107 = ((ArrayList) r106).iterator();
        int r108 = 0;
    L19:
        if (r107.hasNext() == false) goto L26;
        if (((DuxFilter) r107.next()).isSelected() == false) goto L19;
        r108 = r108 + 1;
        if (r108 >= 0) goto L19;
        CollectionsKt.throwCountOverflow();
    L26:
        if (r108 < r104.f205069e) goto L33;
        Iterator r109 = ((ArrayList) r104.f205075k).iterator();
    L29:
        if (r109.hasNext() == false) goto L33;
        DuxFilter r110 = (DuxFilter) r109.next();
        if (r110.isSelected() == false) goto L29;
        r110.setSelected(false);
    L33:
        r105.setSelected(true);
        goto L34
    L15:
        if (((ArrayList) r106).isEmpty() == false) goto L17;
        r108 = 0;
        goto L26
    }
}
