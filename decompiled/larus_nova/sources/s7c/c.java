package s7c;

import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.todo.impl.features.center.v3.util.TaskListDialogUtils;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f540944a;

    public c(FragmentActivity r100) {
        this.f540944a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        int r102 = TaskListDialogUtils.f441775a;
        TaskListDialogUtils.a(this.f540944a, r100);
    }
}
