package gi4;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.creativex.mediaimport.preview.internal.main.b1;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class t extends fi4.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s<Object, View> f481411a;

    @Override // fi4.g
    public final void onError() {
        this.f481411a.D = true;
    }

    @Override // fi4.g
    public final void onRenderStart() {
        s<Object, View> r100 = this.f481411a;
        r100.H = true;
        IMAGE_VIEW r101 = r100.A;
        if (r101 == 0) goto L5;
        ci4.a.a(r101, false);
    L5:
        View r102 = this.f481411a.B;
        if (r102 == null) goto L9;
        ci4.a.a(r102, false);
        return;
    }

    public t(s<Object, View> r100) {
        this.f481411a = r100;
    }

    @Override // fi4.g
    public final void a(b1 r100) {
        Intrinsics.checkNotNullParameter(r100, "player");
        s<Object, View> r101 = this.f481411a;
        r101.E = true;
        if (r101.k() == true) goto L5;
        r100.pause();
    L5:
        s<Object, View> r102 = this.f481411a;
        int r103 = r100.g();
        int r104 = r100.b();
        r102.getClass();
        if (r103 <= 0) goto L27;
        if (r104 <= 0) goto L27;
        Context r105 = r102.getContext();
        int r106 = com.ss.android.ugc.tools.utils.i.f454862a;
        if (r105 == null) goto L15;
        Resources r107 = r105.getResources();
        DisplayMetrics r108 = WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics());
        if (r108 == null) goto L15;
        int r109 = r108.heightPixels;
    L16:
        int r110 = com.ss.android.ugc.tools.utils.i.b(r102.getContext());
        float r111 = r104;
        float r112 = r103;
        float r113 = (com.ss.android.ugc.tools.utils.i.b(r102.getContext()) * r111) / r112;
        float r114 = r109;
        if (r113 < r114) goto L19;
        r110 = (int) ((r114 * r112) / r111);
    L20:
        ViewGroup.LayoutParams r115 = r102.v().getLayoutParams();
        if (r115 == null) goto L27;
        if (r115.width == r110) goto L25;
    L26:
        r115.width = r110;
        r115.height = r109;
        r102.v().setLayoutParams(r115);
        goto L27
    L25:
        if (r115.height == r109) goto L27;
    L19:
        r109 = (int) r113;
    L15:
        r109 = 0;
    L27:
        s<Object, View> r116 = this.f481411a;
        if (r116.F == false) goto L31;
        r116.x();
        this.f481411a.F = false;
        return;
    }
}
