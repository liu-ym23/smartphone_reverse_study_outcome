package cwb;

import android.view.View;
import android.widget.FrameLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f465668a;

    public a(FrameLayout r100) {
        this.f465668a = r100;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "insets");
        Insets r102 = r101.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        r100.setPadding(r102.left, r102.top, r102.right, r101.getInsets(WindowInsetsCompat.Type.ime()).bottom);
        FrameLayout r103 = this.f465668a;
        r103.setPadding(r103.getPaddingLeft(), this.f465668a.getPaddingTop(), this.f465668a.getPaddingRight(), xvb.a.a(r101));
        return r101;
    }
}
