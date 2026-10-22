package ut1;

import android.view.View;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.android.livesdk.drawer.LiveDrawerLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f551609a;

    public l(k r100) {
        this.f551609a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f551609a.getClass();
        k r101 = this.f551609a;
        LiveDrawerLayout r102 = r101.f551589a;
        if (r102 == null) goto L10;
        Intrinsics.checkNotNull(r102);
        if (ViewCompat.isAttachedToWindow(r102) == false) goto L11;
        LiveDrawerLayout r103 = r101.f551589a;
        if (r103 == null) goto L12;
        r103.closeDrawer(GravityCompat.END);
        return;
    L12:
        return;
    L11:
        return;
    }
}
