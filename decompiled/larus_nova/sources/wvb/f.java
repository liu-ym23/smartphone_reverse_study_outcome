package wvb;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class f implements OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f561606a;

    public f(g r100) {
        this.f561606a = r100;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "insets");
        r101.getInsets(WindowInsetsCompat.Type.statusBars());
        this.f561606a.f561607a.getClass();
        Insets r102 = r101.getInsets(WindowInsetsCompat.Type.navigationBars());
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.bottom;
    L6:
        this.f561606a.f561607a.getClass();
        Insets r105 = r101.getInsets(WindowInsetsCompat.Type.ime());
        if (r105 == null) goto L9;
        r103 = r105.bottom;
    L9:
        int r106 = r103 - r104;
        Function1<? super Integer, Unit> r107 = this.f561606a.f561607a.f561605a;
        if (r107 == null) goto L12;
        r107.invoke(Integer.valueOf(r106));
    L12:
        r101.isVisible(WindowInsetsCompat.Type.ime());
        this.f561606a.f561607a.getClass();
        return WindowInsetsCompat.CONSUMED;
    L5:
        r104 = 0;
        goto L6
    }
}
