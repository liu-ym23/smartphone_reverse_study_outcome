package j7c;

import com.ss.android.lark.todo.impl.adapterhelper.TaskBaseQuickAdapter;
import com.ss.android.lark.todo.impl.adapterhelper.loadmodule.PageLoadingStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskBaseQuickAdapter f497657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j7c.a f497658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f497659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f497660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PageLoadingStatus f497661e;

    public static final class a {
    }

    static {
    }

    public b(TaskBaseQuickAdapter r100) {
        Intrinsics.checkNotNullParameter(r100, "baseQuickAdapter");
        this.f497657a = r100;
        this.f497659c = true;
        this.f497660d = 30;
        this.f497661e = PageLoadingStatus.END;
    }
}
