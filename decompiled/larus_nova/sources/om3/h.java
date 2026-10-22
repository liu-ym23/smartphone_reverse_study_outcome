package om3;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: classes14.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f524290a;

    public h(e r100) {
        this.f524290a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f524290a.getClass();
        e r101 = this.f524290a;
        PopupWindowLancet.handleDismissBeforeOrigin(r101);
        r101.dismiss();
    }
}
