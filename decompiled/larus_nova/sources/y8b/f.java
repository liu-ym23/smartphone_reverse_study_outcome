package y8b;

import android.content.DialogInterface;
import com.ss.android.lark.contact.base.contact_mobile_invite.InviteExternalContactV2Fragment;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InviteExternalContactV2Fragment f566937a;

    public f(InviteExternalContactV2Fragment r100) {
        this.f566937a = r100;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        this.f566937a.finish();
    }
}
