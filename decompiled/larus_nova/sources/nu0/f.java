package nu0;

import android.content.DialogInterface;
import io.reactivex.subjects.SingleSubject;

/* JADX INFO: loaded from: classes47.dex */
public final class f implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SingleSubject f520580a;

    public f(SingleSubject r100) {
        this.f520580a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        this.f520580a.onSuccess(Boolean.FALSE);
    }
}
