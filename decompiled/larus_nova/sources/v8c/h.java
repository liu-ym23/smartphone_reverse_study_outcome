package v8c;

import android.content.DialogInterface;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.todo.impl.flutterweb.bridge.dialog.ShowDialogResult;

/* JADX INFO: loaded from: classes38.dex */
public final class h implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Callback f553767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f553768b;

    public h(Callback r100, int r101) {
        this.f553767a = r100;
        this.f553768b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f553767a.success(new ShowDialogResult(Integer.valueOf(this.f553768b), null, null));
    }
}
