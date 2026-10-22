package om3;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ e a;

    public h(e r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.getClass();
        e r2 = this.a;
        PopupWindowLancet.handleDismissBeforeOrigin(r2);
        r2.dismiss();
    }
}
