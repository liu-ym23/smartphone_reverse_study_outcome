package ds8;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.larus.bmhome.top.ChatTopFloatingButtonComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatTopFloatingButtonComponent f469874a;

    public j(ChatTopFloatingButtonComponent r100) {
        this.f469874a = r100;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "outline");
        r101.setRect(0, r100.getHeight() - this.f469874a.f314722r, r100.getWidth(), r100.getHeight());
    }
}
