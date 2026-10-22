package nu0;

import android.content.DialogInterface;
import io.reactivex.subjects.SingleSubject;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SingleSubject f520578a;

    public d(SingleSubject r100) {
        this.f520578a = r100;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        this.f520578a.onSuccess(Boolean.FALSE);
    }
}
