package wqa;

import android.content.DialogInterface;
import com.ss.android.ShowDialogActivity;

/* JADX INFO: loaded from: classes34.dex */
public final class e implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShowDialogActivity f560769a;

    public e(ShowDialogActivity r100) {
        this.f560769a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f560769a.finish();
    }
}
