package dv7;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
public final class x implements Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Collection f470210a;

    public x(Collection r100) {
        this.f470210a = r100;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Object then(Task r100) throws Exception {
        if (this.f470210a.size() == 0) goto L5;
        ArrayList r101 = new ArrayList();
        Iterator r102 = this.f470210a.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r101.add(((Task) r102.next()).getResult());
        goto L8
    L10:
        return r101;
    L5:
        return Collections.emptyList();
    }
}
