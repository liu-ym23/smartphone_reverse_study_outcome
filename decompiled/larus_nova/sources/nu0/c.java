package nu0;

import android.content.DialogInterface;
import io.reactivex.subjects.SingleSubject;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SingleSubject f520577a;

    public c(SingleSubject r100) {
        this.f520577a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        com.bytedance.tools.kcp.spongepreference.runtime.a r102 = k.f520584b;
        KProperty<?> r103 = k.f520583a[0];
        Boolean r104 = Boolean.TRUE;
        r102.setValue(null, r103, r104);
        this.f520577a.onSuccess(r104);
    }
}
