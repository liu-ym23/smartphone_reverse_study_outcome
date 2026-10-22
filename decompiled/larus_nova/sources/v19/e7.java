package v19;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class e7 implements OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f552470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f552471b;

    public /* synthetic */ e7(View r100, Function1 r101) {
        this.f552470a = r100;
        this.f552471b = r101;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
        View r102 = this.f552470a;
        Function1 r103 = this.f552471b;
        Intrinsics.checkNotNullParameter(r100, "<unused var>");
        Intrinsics.checkNotNullParameter(r101, "insets");
        WindowInsetsCompat r104 = ViewCompat.getRootWindowInsets(r102);
        if (r104 == null) goto L7;
        Insets r105 = r104.getInsets(WindowInsetsCompat.Type.statusBars());
        if (r105 == null) goto L7;
        r103.invoke(r105);
    L7:
        return r101;
    }
}
