package dv7;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public final class y implements Continuation<Void, Task<List<Task<?>>>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Collection f470211a;

    public y(Collection r100) {
        this.f470211a = r100;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<List<Task<?>>> then(Task<Void> r100) throws Exception {
        ArrayList r101 = new ArrayList();
        r101.addAll(this.f470211a);
        return Tasks.forResult(r101);
    }
}
