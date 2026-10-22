package y8b;

import android.view.View;
import com.ss.android.lark.contact.base.common_ui.SearchEditText;
import com.ss.android.lark.contact.base.contact_mobile_invite.InviteExternalContactV2Fragment;
import com.ss.android.lark.contact.base.databinding.InvInviteExternalContactV2ViewBinding;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InviteExternalContactV2Fragment f566936a;

    public e(InviteExternalContactV2Fragment r100) {
        this.f566936a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        InvInviteExternalContactV2ViewBinding r101 = this.f566936a.f418647i;
        if (r101 == null) goto L8;
        SearchEditText r102 = r101.f418851e;
        if (r102 == null) goto L9;
        r102.setText("");
        return;
    L9:
        return;
    }
}
