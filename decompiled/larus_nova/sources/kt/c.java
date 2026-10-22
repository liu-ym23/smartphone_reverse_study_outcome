package kt;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.gamecp.base.gamedetail.ShowType;
import com.bytedance.android.gamecp.base.gamedetail.l0;
import com.bytedance.android.gamecp.business.gamedetail.strategy.scene.GameDetailScene;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import lt.f;
import lt.g;

/* JADX INFO: loaded from: classes44.dex */
public abstract class c implements f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f506001c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ lt.a f506002b;

    public static final class a {
    }

    static {
    }

    @Override // lt.f
    public final void a(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        this.f506002b.a(r100);
    }

    @Override // lt.f
    public final lt.b b(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "frameLayout");
        return this.f506002b.b(r100);
    }

    @Override // lt.f
    public final l0 c(Context r100, Window r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f506002b.c(r100, r101, r102, r103);
    }

    @Override // lt.f
    public final void d(DialogFragment r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        Intrinsics.checkNotNullParameter(r101, "statusBarMode");
        this.f506002b.d(r100, r101);
    }

    @Override // lt.f
    public final void e(Dialog r100) {
        this.f506002b.e(r100);
    }

    @Override // lt.f
    public final void onViewCreated(View r100) {
        this.f506002b.onViewCreated(r100);
    }

    public c(GameDetailScene r100, ShowType r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "showType");
        f.f510641a.getClass();
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "showType");
        int r102 = lt.e.f510640a[r100.ordinal()];
        if (r102 != 1) goto L5;
        lt.a r103 = new lt.c(r101);
    L16:
        this.f506002b = r103;
        return;
    L5:
        if (r102 != 2) goto L7;
        r103 = new g(r101);
        goto L16
    L7:
        if (r102 != 3) goto L9;
        r103 = new lt.d(r101);
        goto L16
    L9:
        if (r102 != 4) goto L12;
        r103 = new lt.d(r101);
        goto L16
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
