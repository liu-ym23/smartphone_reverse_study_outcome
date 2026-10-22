package uhb;

import android.view.View;
import com.ss.android.lark.flow.passport.ui.widget.verifycode.VerifyCodeEditText;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VerifyCodeEditText f550115a;

    public a(VerifyCodeEditText r100) {
        this.f550115a = r100;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        this.f550115a.f423913a.setCursorVisible(true);
        return false;
    }
}
