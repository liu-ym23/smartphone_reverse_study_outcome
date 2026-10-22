package n9b;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.contact.customized.privatecontact.view.OfficePrivateContactFragment;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficePrivateContactFragment f518429a;

    public a(OfficePrivateContactFragment r100) {
        this.f518429a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        FragmentActivity r101 = this.f518429a.getActivity();
        if (r101 == null) goto L6;
        r101.finish();
        return;
    }
}
