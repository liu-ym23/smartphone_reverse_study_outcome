package mfa;

import android.content.DialogInterface;
import com.larus.permission.api.IPermissionX;
import com.obric.assistant.permission.IObricPermissionServiceImpl;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes33.dex */
public final class g implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f513676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IPermissionX.c f513677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f513678c;

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        if (this.f513676a == false) goto L5;
        return;
    L5:
        this.f513676a = true;
        IPermissionX.c r101 = this.f513677b;
        if (r101 == null) goto L9;
        r101.a(this.f513678c.element, null);
        return;
    }

    public g(IObricPermissionServiceImpl.d r100, Ref.BooleanRef r101) {
        this.f513677b = r100;
        this.f513678c = r101;
    }
}
