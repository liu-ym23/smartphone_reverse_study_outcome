package s7c;

import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.todo.impl.features.center.v3.util.TaskListDialogUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f540941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f540942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<String> f540943c;

    public b(FragmentActivity r100, Function1 r101, Ref.ObjectRef r102) {
        this.f540941a = r100;
        this.f540942b = r101;
        this.f540943c = r102;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        int r102 = TaskListDialogUtils.f441775a;
        TaskListDialogUtils.a(this.f540941a, r100);
        this.f540942b.invoke(this.f540943c.element);
    }
}
