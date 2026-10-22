package n9b;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.contact.customized.OfficeContactPageUtils;
import com.ss.android.lark.contact.customized.privatecontact.view.OfficePrivateContactFragment;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficePrivateContactFragment f518431a;

    public c(OfficePrivateContactFragment r100) {
        this.f518431a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Context r101 = this.f518431a.getContext();
        if (r101 == null) goto L6;
        OfficeContactPageUtils.a(r101);
        return;
    }
}
