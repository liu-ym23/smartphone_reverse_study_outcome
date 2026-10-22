package v8c;

import android.content.DialogInterface;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.todo.impl.flutterweb.bridge.dialog.ShowDialogResult;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Callback f553756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f553757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f553758c;

    public c(Callback r100, int r101, Ref.BooleanRef r102) {
        this.f553756a = r100;
        this.f553757b = r101;
        this.f553758c = r102;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f553756a.success(new ShowDialogResult(Integer.valueOf(this.f553757b), null, Boolean.valueOf(this.f553758c.element)));
    }
}
