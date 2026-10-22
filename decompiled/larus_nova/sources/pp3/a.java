package pp3;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import uq3.p;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f530198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f530199b;

    public a(Function1 r100, p r101) {
        this.f530198a = r100;
        this.f530199b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function1 r101 = this.f530198a;
        if (r101 == null) goto L6;
        Unit r102 = (Unit) r101.invoke(this.f530199b.f551274a);
        return;
    }
}
