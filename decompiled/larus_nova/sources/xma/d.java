package xma;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import com.larus.nova.R;
import com.obric.oui.dialog.base.j;
import com.obric.oui.dialog.base.r;
import com.obric.oui.view.ViewCompat;

/* JADX INFO: loaded from: classes34.dex */
public final class d implements View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f564558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f564559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f564560c;

    public d(r r100, j r101) {
        this.f564559b = r100;
        this.f564560c = r101;
        this.f564558a = null;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View r100, WindowInsets r101) {
        e r102 = e.a(r101, r100);
        int r103 = Build.VERSION.SDK_INT;
        if (r103 >= 30) goto L13;
        View r104 = this.f564559b;
        View.OnApplyWindowInsetsListener r105 = (View.OnApplyWindowInsetsListener) r104.getTag(R.id.tag_window_insets_animation_callback);
        if (r105 == null) goto L8;
        r105.onApplyWindowInsets(r104, r101);
    L8:
        if (r102.equals(this.f564558a) == false) goto L13;
        ((j) this.f564560c).a(r102);
        e.k r106 = r102.f564561a;
        if ((r106 instanceof e.f) == true) goto L12;
        return null;
    L12:
        return ((e.f) r106).f564579c;
    L13:
        this.f564558a = r102;
        ((j) this.f564560c).a(r102);
        if (r103 < 30) goto L19;
        e.k r107 = r102.f564561a;
        if ((r107 instanceof e.f) == true) goto L18;
        return null;
    L18:
        return ((e.f) r107).f564579c;
    L19:
        int r108 = ViewCompat.f403725a;
        r100.requestApplyInsets();
        e.k r109 = r102.f564561a;
        if ((r109 instanceof e.f) == true) goto L22;
        return null;
    L22:
        return ((e.f) r109).f564579c;
    }
}
