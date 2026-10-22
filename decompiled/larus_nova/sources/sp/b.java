package sp;

import android.view.View;
import com.bytedance.android.ec.window.base.repository.vo.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f542826a;

    public b(k r100) {
        this.f542826a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        k r101 = this.f542826a;
        Function1<? super k, Unit> r102 = r101.f49508f;
        if (r102 == null) goto L6;
        Unit r103 = r102.invoke(r101);
        return;
    }
}
