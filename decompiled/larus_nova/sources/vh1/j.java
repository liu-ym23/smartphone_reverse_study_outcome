package vh1;

import android.view.View;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class j implements Observer<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f554817a;

    public j(View r100) {
        this.f554817a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.f554817a != null) goto L8;
        return;
    L8:
        if (r101.booleanValue() == false) goto L10;
        this.f554817a.animate().alpha(0.5f).setDuration(300).start();
        return;
    L10:
        this.f554817a.animate().alpha(1.0f).setDuration(300).start();
    }
}
