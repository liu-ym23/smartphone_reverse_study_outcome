package y8b;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.ss.android.lark.contact.base.contact_mobile_invite.InviteExternalContactV2Fragment;
import com.ss.android.lark.contact.base.databinding.InvInviteExternalContactV2ViewBinding;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InviteExternalContactV2Fragment f566934a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public c(InviteExternalContactV2Fragment r100) {
        this.f566934a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        InvInviteExternalContactV2ViewBinding r101 = this.f566934a.f418647i;
        if (r101 == null) goto L14;
        ImageView r102 = r101.f418850d;
        if (r102 == null) goto L15;
        int r103 = 0;
        if (String.valueOf(r100).length() != 0) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == false) goto L12;
        r103 = 8;
    L12:
        r102.setVisibility(r103);
        return;
    L9:
        r104 = false;
        goto L10
    L15:
        return;
    }
}
