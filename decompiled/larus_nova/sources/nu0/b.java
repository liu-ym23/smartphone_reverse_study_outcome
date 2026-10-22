package nu0;

import android.content.DialogInterface;
import io.reactivex.subjects.SingleSubject;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SingleSubject f520576a;

    public b(SingleSubject r100) {
        this.f520576a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        this.f520576a.onSuccess(Boolean.FALSE);
    }
}
