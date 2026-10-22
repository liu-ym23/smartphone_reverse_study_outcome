package v8c;

import android.content.DialogInterface;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.todo.impl.flutterweb.bridge.dialog.ShowDialogResult;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Callback f553760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f553761b;

    public e(Callback r100, int r101) {
        this.f553760a = r100;
        this.f553761b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f553760a.success(new ShowDialogResult(Integer.valueOf(this.f553761b), null, null));
    }
}
