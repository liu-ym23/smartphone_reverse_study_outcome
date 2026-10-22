package v19;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes27.dex */
public final class i7 implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f552564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f552565b;

    public i7(View r100, com.larus.bmhome.chat.component.bottom.core.l7 r101) {
        this.f552564a = r100;
        this.f552565b = r101;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        this.f552564a.removeOnLayoutChangeListener(this);
        this.f552565b.invoke();
    }
}
