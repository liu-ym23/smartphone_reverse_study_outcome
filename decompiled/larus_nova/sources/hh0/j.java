package hh0;

import android.content.DialogInterface;
import com.bytedance.android.live.liveinteract.plantform.dialog.AudienceTypeFragment;

/* JADX INFO: loaded from: classes46.dex */
public final class j implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceTypeFragment f485097a;

    public j(AudienceTypeFragment r100) {
        this.f485097a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        AudienceTypeFragment r102 = this.f485097a;
        int r103 = AudienceTypeFragment.f76775m;
        r102.ba0();
    }
}
